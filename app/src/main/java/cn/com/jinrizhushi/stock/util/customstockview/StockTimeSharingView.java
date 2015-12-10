package cn.com.jinrizhushi.stock.util.customstockview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import cn.com.jinrizhushi.stock.R;
import cn.com.jinrizhushi.stock.container.StockApplication;
import cn.com.jinrizhushi.stock.stock.model.StockLineModel;
import cn.com.jinrizhushi.stock.stock.model.StockMarketIndexItemModel;
import cn.com.jinrizhushi.stock.stock.model.StockMarketIndexModel;
import cn.com.jinrizhushi.stock.stock.model.StockPointModel;
import cn.com.jinrizhushi.stock.stock.model.StockTextModel;
import cn.com.jinrizhushi.stock.stock.viewmodel.StockMarketIndexViewModel;
import cn.com.jinrizhushi.stock.util.Tools;

/**
 * 描述: 分时图
 * 作者: 刘倩
 * 日期: 15/12/4 12:12
 */
public class StockTimeSharingView extends View {

    /**
     * 自定义控件的实际高度
     */
    private float realHeight;
    /**
     * 自定义控件的实际宽度
     */
    private float realWidth;
    /**
     * 图形的边距
     */
    private float STOCK_VIEW_MARGIN = 40;
    /**
     * 图形的上边距
     */
    private float STOCK_VIEW_MARGIN_TOP = 1;
    /**
     * 距顶部的距离
     */
    private float STOCK_VIEW_FINAL_MARGIN_TOP = STOCK_VIEW_MARGIN + STOCK_VIEW_MARGIN_TOP;


    /**
     * 文字的宽度
     */
    private float STOCK_VIEW_FONT_WIDTH = 40;
    /**
     * 初始的x坐标
     */
    private float STOCK_VIEW_STARTX = STOCK_VIEW_MARGIN + STOCK_VIEW_FONT_WIDTH;
    /**
     * 分时图的视图模型
     */
    private StockMarketIndexViewModel marketIndexViewModel;
    /**
     * 字体大小
     */
    private int STOCK_VIEW_FONT_SIZE = 30;
    /**
     * 三条横线的list
     */
    private List<StockLineModel> listThreeLine = new ArrayList<>();
    /**
     * 坐标的list
     */
    private List<StockTextModel> listText = new ArrayList<>();
    /**
     * 显示的数据
     */
    private StockMarketIndexModel indexModel;
    /**
     * 点的List
     */
    private static List<StockPointModel> listPoint = new ArrayList<>();
    /** 绿色的阴影 */
    private int STOCK_TIME_SHARING_VIEW_SHADOW_GREEN_COLOR = 0x4700B285;
    /**红色的阴影*/
    private int STOCK_TIME_SHARING_VIEW_SHADOW_RED_COLOR = 0x47CD3557;

    public StockTimeSharingView(Context context) {
        super(context);
    }


    public StockTimeSharingView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    public StockTimeSharingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        realWidth = MeasureSpec.getSize(widthMeasureSpec);
        realHeight = MeasureSpec.getSize(heightMeasureSpec);
        if(marketIndexViewModel!=null){
            initDefaultPoint();
            initTextPoint();
        }
        if(indexModel!=null){
            initShownPoint();
        }
    }

    float highest;
    float lowest;
    float center;

    /**
     * 初试化指数线
     */
    private void initShownPoint() {
        if (listPoint != null) {
            listPoint.clear();
        }
        highest = Float.parseFloat(indexModel.getMarketIndexHigh());
        lowest = Float.parseFloat(indexModel.getMarketIndexLow());
        center = Float.parseFloat(indexModel.getMarketIndexCenter());
        if (indexModel != null && indexModel.getListMarketIndex() != null && indexModel.getListMarketIndex().size() > 0) {
            List<StockMarketIndexItemModel> list = indexModel.getListMarketIndex();
            if (list != null && list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    StockMarketIndexItemModel model = list.get(i);
                    float index = Float.parseFloat(model.getIndex());
                    String time = model.getTime();
                    StockPointModel pointModel = new StockPointModel();
                    float yDistance = distance * 2 / (highest - lowest);
                    String s1 = time.substring(0, 2);
                    String s2 = time.substring(3, 5);
                    Float all = Float.parseFloat(s1) * 60 + Float.parseFloat(s2);
                    /* 9:30 ,11:30,13:30,14:0015:00*/
                    float startTime = 9 * 60 + 30;
                    float centerLeft = 11 * 60 + 30;
                    float centerRight = 13 * 60 + 30;
                    float stopRight = 14 * 60;
                    float stopTime = 15 * 60;
                    float startX = 0f;
                    float xDistance = (realWidth - STOCK_VIEW_STARTX * 2) / 2 / (2 * 60);
                    if (all <= centerLeft) {
                        startX = STOCK_VIEW_STARTX + (all - startTime) * xDistance;
                    } else if (all >= centerRight && all <= stopRight) {
                        startX = (realWidth - STOCK_VIEW_STARTX * 2) / 4 / 30 * (all - centerRight) + (realWidth - STOCK_VIEW_STARTX * 2) / 2 + STOCK_VIEW_STARTX;
                    } else if (all > stopRight && all <= stopTime) {
                        startX = STOCK_VIEW_STARTX + (realWidth - STOCK_VIEW_STARTX * 2) / 4 * 3 + (realWidth - STOCK_VIEW_STARTX * 2) / 4 / 60 * (all - stopRight);
                    }
                    pointModel.setStartX(Tools.getDecimalFormatFloat(startX));
                    float startY = 0F;
                    startY = realHeight - distance - (index - lowest) * yDistance;
                    pointModel.setStartY(Tools.getDecimalFormatFloat(startY));
                    Paint paint = new Paint();
                    paint.setColor(marketIndexViewModel.getColor());
                    paint.setStrokeWidth(2);
                    pointModel.setPaint(paint);
                    listPoint.add(pointModel);
                }

            }
        }

    }


    float distanceX;
    float timeY;

    /**
     * 初始化坐标
     */
    private void initTextPoint() {
        Paint paint = new Paint();
        paint.setTextSize(STOCK_VIEW_FONT_SIZE);
        paint.setColor(StockApplication.globalContext.getResources().getColor(R.color.stock_view_text_color));
        float tvX = STOCK_VIEW_MARGIN;
        float tvY = STOCK_VIEW_FINAL_MARGIN_TOP;
        if (distance <= 0f) {
            distance = (realHeight - STOCK_VIEW_MARGIN - STOCK_VIEW_MARGIN_TOP) / 3;
        }
        String hight;
        String center;
        String low;
        String rightLow;
        String zero;
        String rightHight;
        if (marketIndexViewModel == null) {
            hight = "0 ";
            center = "0 ";
            low = "0";
            rightLow = " 0%";
            zero = " 0%";
            rightHight = " 0%";
        } else {
            indexModel = marketIndexViewModel.getMarketInfo();
            hight = indexModel.getMarketIndexHigh() + " ";
            center = indexModel.getMarketIndexCenter() + " ";
            low = indexModel.getMarketIndexLow() + " ";
            rightLow = " -" + indexModel.getQuoteChangeHigh() + "%";
            zero = " 0%";
            rightHight = " " + indexModel.getQuoteChangeHigh() + "%";

        }
        StockTextModel modelHight = new StockTextModel(hight, tvX - STOCK_VIEW_FONT_SIZE, tvY + STOCK_VIEW_FONT_SIZE / 3, paint);
        StockTextModel modelCenter = new StockTextModel(center, tvX - STOCK_VIEW_FONT_SIZE, tvY + distance + STOCK_VIEW_FONT_SIZE / 3, paint);
        StockTextModel modelLow = new StockTextModel(low, tvX - STOCK_VIEW_FONT_SIZE, tvY + distance * 2 + STOCK_VIEW_FONT_SIZE / 3, paint);
        timeY = tvY + distance * 2 + distance / 3;
        distanceX = (realWidth - 2 * STOCK_VIEW_STARTX) / 4;
        StockTextModel modelNine = new StockTextModel("09:30", STOCK_VIEW_STARTX, timeY+STOCK_VIEW_MARGIN/2, paint);
        StockTextModel modelTen = new StockTextModel("10:30", STOCK_VIEW_STARTX + distanceX - STOCK_VIEW_FONT_WIDTH, timeY+STOCK_VIEW_MARGIN/2, paint);
        StockTextModel modelEleven = new StockTextModel("11:30/13:30", STOCK_VIEW_STARTX + distanceX * 2 - STOCK_VIEW_FONT_WIDTH, timeY+STOCK_VIEW_MARGIN/2, paint);
        StockTextModel modelForth = new StockTextModel("14:00", STOCK_VIEW_STARTX + distanceX * 3 + STOCK_VIEW_FONT_WIDTH, timeY+STOCK_VIEW_MARGIN/2, paint);
        StockTextModel modelFifth = new StockTextModel("15:00", STOCK_VIEW_STARTX + distanceX * 4, timeY+STOCK_VIEW_MARGIN/2, paint);
        float timeX = realWidth - STOCK_VIEW_STARTX;
        StockTextModel modelQuoteChangeLow = new StockTextModel(rightLow, timeX, tvY + distance * 2 + STOCK_VIEW_FONT_SIZE / 3, paint);
        StockTextModel modelQuoteChangeZero = new StockTextModel(zero, timeX, tvY + STOCK_VIEW_FONT_SIZE / 3 + distance, paint);
        StockTextModel modelQuoteChangeHigh = new StockTextModel(rightHight, timeX, tvY + STOCK_VIEW_FONT_SIZE / 3, paint);

        listText.add(modelHight);
        listText.add(modelCenter);
        listText.add(modelLow);
        listText.add(modelNine);
        listText.add(modelTen);
        listText.add(modelEleven);
        listText.add(modelForth);
        listText.add(modelFifth);
        listText.add(modelQuoteChangeLow);
        listText.add(modelQuoteChangeZero);
        listText.add(modelQuoteChangeHigh);
    }

    float distance;

    /**
     * 初始化分割线点坐标
     */
    private void initDefaultPoint() {
        float stopx = realWidth - STOCK_VIEW_STARTX;
        distance = (realHeight - STOCK_VIEW_MARGIN - STOCK_VIEW_MARGIN_TOP) / 3;
        Paint paint = new Paint();
        if (marketIndexViewModel == null) {
            paint.setColor(StockApplication.globalContext.getResources().getColor(R.color.stock_view_line_color));
        } else {
            paint.setColor(marketIndexViewModel.getLineColor());
        }

        StockLineModel lineOne = new StockLineModel(STOCK_VIEW_STARTX, STOCK_VIEW_FINAL_MARGIN_TOP, stopx, STOCK_VIEW_FINAL_MARGIN_TOP, paint);
        StockLineModel lineSecond = new StockLineModel(STOCK_VIEW_STARTX, STOCK_VIEW_FINAL_MARGIN_TOP + distance, stopx, STOCK_VIEW_FINAL_MARGIN_TOP + distance, paint);
        StockLineModel lineThread = new StockLineModel(STOCK_VIEW_STARTX, STOCK_VIEW_FINAL_MARGIN_TOP + distance * 2, stopx, STOCK_VIEW_FINAL_MARGIN_TOP + distance * 2, paint);
        listThreeLine.add(lineOne);
        listThreeLine.add(lineSecond);
        listThreeLine.add(lineThread);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        initThreeLine(canvas);
        initText(canvas);
        if(listPoint!=null&&listPoint.size()>0){
            initLine(canvas);
        }
    }

    Path path = new Path();

    /**
     * 画曲线
     *
     * @param canvas
     */
    private void initLine(Canvas canvas) {
        for (int i = (listPoint.size() - 1); i > 0; i--) {
            if (i > 0) {
                StockPointModel modelBehind = listPoint.get(i);
                StockPointModel modelAHead = listPoint.get(i - 1);
                Paint paint = modelAHead.getPaint();
                paint.setStrokeWidth(3);
                if (i == (listPoint.size() - 1)) {
                    path.moveTo(modelBehind.getStartX(), modelBehind.getStartY());
                } else {
                    path.lineTo(modelBehind.getStartX(), modelBehind.getStartY());
                    path.lineTo(modelAHead.getStartX(), modelAHead.getStartY());
                }
                canvas.drawLine(modelAHead.getStartX(), modelAHead.getStartY(), modelBehind.getStartX(), modelBehind.getStartY(), paint);
            }
        }
        /* 画渐变的阴影 */
        Paint paint = new Paint();
        path.lineTo(STOCK_VIEW_STARTX, (float) (timeY * 0.8));
        path.lineTo(listPoint.get(listPoint.size() - 1).getStartX(), (float) (timeY * 0.8));
        path.lineTo(listPoint.get(listPoint.size() - 1).getStartX(), listPoint.get(listPoint.size() - 1).getStartY());
        path.close();
        Shader mShasder;
        if (listPoint.get(0).getPaint().getColor() == StockMarketIndexViewModel.STOCK_MARKET_IDNEX_VIEW_RED_COLOR) {
            mShasder = new LinearGradient(listPoint.get(listPoint.size() - 1).getStartX(), listPoint.get(listPoint.size() - 1).getStartY(), listPoint.get(listPoint.size() - 1).getStartX(), (float) (timeY * 0.8), new int[]{0xFF493546, 0xFF343542}, null, Shader.TileMode.CLAMP);
        } else {
            mShasder = new LinearGradient(listPoint.get(listPoint.size() - 1).getStartX(), listPoint.get(listPoint.size() - 1).getStartY(), listPoint.get(listPoint.size() - 1).getStartX(), (float) (timeY * 0.8), new int[]{0xFF275956, 0xFF343542}, null, Shader.TileMode.CLAMP);

        }
        paint.setShader(mShasder);
        canvas.drawPath(path, paint);
        /* 画最近的点 */
        paint = new Paint();
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(3);

        if (listPoint.get(0).getPaint().getColor() == StockMarketIndexViewModel.STOCK_MARKET_IDNEX_VIEW_RED_COLOR) {
            paint.setColor(STOCK_TIME_SHARING_VIEW_SHADOW_RED_COLOR);
        } else {
            paint.setColor(STOCK_TIME_SHARING_VIEW_SHADOW_GREEN_COLOR);
        }
        canvas.drawCircle(listPoint.get(listPoint.size() - 1).getStartX(), listPoint.get(listPoint.size() - 1).getStartY(), 10, paint);
        paint.setColor(listPoint.get(0).getPaint().getColor());
        canvas.drawCircle(listPoint.get(listPoint.size() - 1).getStartX(), listPoint.get(listPoint.size() - 1).getStartY(), 5, paint);

        /* 标记指数和幅度 */
        String range;
        String index = marketIndexViewModel.getMarketInfo().getListMarketIndex().get(listPoint.size() - 1).getIndex();
        float dis = Float.parseFloat(indexModel.getQuoteChangeHigh()) * 2 / (highest - lowest);
        float ra = Float.parseFloat(index) - center;
        range = String.valueOf(Tools.getDecimalFormatFloat(dis * ra)) + "%";
        float indexY=0F;
        float rangeY=0F;
        if(ra>0){
            indexY =  listPoint.get(listPoint.size() - 1).getStartY() + 50;
            rangeY = listPoint.get(listPoint.size() - 1).getStartY() - 20;
        }else{
            rangeY =  listPoint.get(listPoint.size() - 1).getStartY() + 50;
            indexY = listPoint.get(listPoint.size() - 1).getStartY() - 20;
        }

        paint.setColor(Color.WHITE);
        paint.setTextSize(22);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        canvas.drawText(index, listPoint.get(listPoint.size() - 1).getStartX() - 30,indexY, paint);
        paint.setColor(listPoint.get(listPoint.size() - 1).getPaint().getColor());
        canvas.drawText(range, listPoint.get(listPoint.size() - 1).getStartX() - 27,rangeY , paint);


    }

    /**
     * 画坐标
     *
     * @param canvas
     */
    private void initText(Canvas canvas) {
        if (listText != null && listText.size() > 0) {
            for (int i = 0; i < listText.size(); i++) {
                StockTextModel model = listText.get(i);
                canvas.drawText(model.getContent(), model.getTvX(), model.getTvY(), model.getPaint());
            }
        }
    }

    /**
     * 画三条分割线
     *
     * @param canvas
     */
    private void initThreeLine(Canvas canvas) {
        if (listThreeLine != null && listThreeLine.size() > 0) {
            for (int i = 0; i < listThreeLine.size(); i++) {
                StockLineModel model = listThreeLine.get(i);
                canvas.drawLine(model.getStartX(), model.getStartY(), model.getStopX(), model.getStopY(), model.getPaint());
            }
        }
    }

    public StockMarketIndexViewModel getMarketIndexViewModel() {
        return marketIndexViewModel;
    }

    public void setMarketIndexViewModel(StockMarketIndexViewModel marketIndexViewModel) {
        this.marketIndexViewModel = marketIndexViewModel;
    }

    public void setModel(StockMarketIndexViewModel model) {
        this.marketIndexViewModel = model;
    }
}
