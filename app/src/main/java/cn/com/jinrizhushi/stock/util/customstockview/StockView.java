package cn.com.jinrizhushi.stock.util.customstockview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import cn.com.jinrizhushi.stock.R;
import cn.com.jinrizhushi.stock.stock.model.StockLineModel;
import cn.com.jinrizhushi.stock.stock.model.StockPointModel;
import cn.com.jinrizhushi.stock.stock.model.StockTextModel;

/**
 * 描述: 股票的视图
 * 作者: 刘倩
 * 日期: 15/12/1 16:40
 */
public class StockView extends View {
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
    private float STOCK_VIEW_MARGIN = 60;
    /**
     * 底部柱状图占的比例
     */
    private float STOCK_VIEW_BOTTOM_LINE_PERCENT = 0.8F;

    /**
     * 绘制线的List
     */
    private List<StockLineModel> listLine = new ArrayList<>();
    /**
     * 绘制点的List
     */
    private List<StockPointModel> listPoint = new ArrayList<>();
    /**
     * 绘制纵坐标文本的List
     */
    private List<StockTextModel> listTextOridinate = new ArrayList<>();
    /**
     * 绘制横坐标文本的List
     */
    private List<StockTextModel> listTextAbscissa = new ArrayList<>();

    /**
     * 将视图分段
     */
    private int STOCK_VIEW_ALL_DEVIDE = 8;
    /**
     * 视图左右的间距
     */
    private int STOCK_VIEW_LEFT_RIGHT_MARGIN = 2;
    /** 离左边的距离 */
    private float STOCK_VIEW_LEFT_DISTANCE=STOCK_VIEW_LEFT_RIGHT_MARGIN * STOCK_VIEW_MARGIN;
    /**
     * 视图离左边的距离
     */
    private int STOCK_VIEW_LEFT_MARGIN = 2;
    /**
     * 纵坐标的数据
     */
    private String[] ordinateData;
    /**
     * 横坐标的数据
     */
    private String[] abscissaData;


    public StockView(Context context) {
        super(context);
    }

    public StockView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public StockView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 初始化图的点坐标
     */
    private void initPoint() {
        for (int i = 0; i < ordinateData.length; i++) {
            listTextOridinate.add(new StockTextModel(ordinateData[i]));
        }



        Paint paint = new Paint();
        paint.setColor(getResources().getColor(R.color.line_bg));
        float startX;
        float startY;

        for (int i = 0; i <= STOCK_VIEW_ALL_DEVIDE; i++) {
            StockLineModel point;
            if (i == 0) {
                startX = STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_MARGIN;
                startY = STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN;
                point = new StockLineModel(startX, startY, realWidth - STOCK_VIEW_MARGIN, STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN, paint);
                listLine.add(point);
                listTextOridinate.get(0).setTvX(startX);
                listTextOridinate.get(0).setTvY(startY);
            } else if (i < (STOCK_VIEW_ALL_DEVIDE - 2) || i == STOCK_VIEW_ALL_DEVIDE) {
                if (i > 0 && i < (STOCK_VIEW_ALL_DEVIDE - 3)) {
                    startX = STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_MARGIN;
                    startY = (realHeight - STOCK_VIEW_LEFT_RIGHT_MARGIN * 2 * STOCK_VIEW_MARGIN) * i / STOCK_VIEW_ALL_DEVIDE + STOCK_VIEW_LEFT_DISTANCE;
                    drawPoint(startY, 2.0f);
                    listTextOridinate.get(i).setTvX(startX);
                    listTextOridinate.get(i).setTvY(startY);
                } else {
                    startY = (realHeight - STOCK_VIEW_LEFT_RIGHT_MARGIN * 2 * STOCK_VIEW_MARGIN) * i / STOCK_VIEW_ALL_DEVIDE + STOCK_VIEW_LEFT_DISTANCE;
                    startX = STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_MARGIN;
                    point = new StockLineModel(startX, startY, realWidth - STOCK_VIEW_MARGIN, startY, paint);
                    listLine.add(point);
                    if (i != STOCK_VIEW_ALL_DEVIDE) {
                        listTextOridinate.get(i).setTvX(startX);
                        listTextOridinate.get(i).setTvY(startY);
                    }
                    if (i == (STOCK_VIEW_ALL_DEVIDE - 3)) {
                        StockLineModel lineLeft = new StockLineModel(STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_MARGIN, STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN, STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_MARGIN, startY, paint);
                        listLine.add(lineLeft);
                        StockLineModel lineRight = new StockLineModel(realWidth - STOCK_VIEW_MARGIN, STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN, realWidth - STOCK_VIEW_MARGIN, startY, paint);
                        listLine.add(lineRight);
                    }
                }

            } else if (i == (STOCK_VIEW_ALL_DEVIDE - 2)) {
                startX = STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_MARGIN;
                startY = (realHeight - STOCK_VIEW_LEFT_DISTANCE) - (realHeight - STOCK_VIEW_LEFT_RIGHT_MARGIN * 2 * STOCK_VIEW_MARGIN) * STOCK_VIEW_LEFT_RIGHT_MARGIN / STOCK_VIEW_ALL_DEVIDE * STOCK_VIEW_BOTTOM_LINE_PERCENT;
                point = new StockLineModel(startX, startY, realWidth - STOCK_VIEW_MARGIN, startY, paint);
                listLine.add(point);

            } else if (i == (STOCK_VIEW_ALL_DEVIDE - 1)) {
                startY = (realHeight - STOCK_VIEW_LEFT_DISTANCE) - (realHeight - STOCK_VIEW_LEFT_RIGHT_MARGIN * 2 * STOCK_VIEW_MARGIN) * 2 / STOCK_VIEW_ALL_DEVIDE * STOCK_VIEW_BOTTOM_LINE_PERCENT / 2;
                drawPoint(startY, 2.0f);
                startX = STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_MARGIN;
                listTextOridinate.get(STOCK_VIEW_ALL_DEVIDE - 2).setTvX(startX);
                listTextOridinate.get(STOCK_VIEW_ALL_DEVIDE - 2).setTvY(startY);
            }
        }
        StockLineModel point;
        float yPointLeft = (realHeight - STOCK_VIEW_LEFT_DISTANCE) - (realHeight - STOCK_VIEW_LEFT_RIGHT_MARGIN * 2 * STOCK_VIEW_MARGIN) * 2 / STOCK_VIEW_ALL_DEVIDE * STOCK_VIEW_BOTTOM_LINE_PERCENT;
        float yPointRight = realHeight - STOCK_VIEW_LEFT_DISTANCE;
        point = new StockLineModel(STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_MARGIN, yPointRight, STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_MARGIN, yPointLeft, paint);
        listLine.add(point);
        point = new StockLineModel(realWidth - STOCK_VIEW_MARGIN, yPointRight, realWidth - STOCK_VIEW_MARGIN, yPointLeft, paint);
        listLine.add(point);
    }

    /**
     * 画点
     *
     * @param pointY 该点所在的坐标
     * @param width  该点所在的半径
     */
    private void drawPoint(float pointY, float width) {

        float startY = pointY;
        int stop = (int) (realWidth - STOCK_VIEW_LEFT_DISTANCE);
        float sum = STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_MARGIN;
        for (int k = 0; k < stop; k++) {
            sum = sum + 10;
            Paint paintPoint = new Paint();
            paintPoint.setColor(getResources().getColor(R.color.line_bg));
            if (sum < (realWidth - STOCK_VIEW_MARGIN)) {
                paintPoint.setStrokeWidth(width);
                StockPointModel newPoint = new StockPointModel(sum, startY, paintPoint);
                listPoint.add(newPoint);
            }


        }
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        realWidth = MeasureSpec.getSize(widthMeasureSpec);
        realHeight = MeasureSpec.getSize(heightMeasureSpec);
//        ordinateData = new String[STOCK_VIEW_ALL_DEVIDE - 1];
//        ordinateData[0] = "105.36";
//        ordinateData[1] = "87.80";
//        ordinateData[2] = "70.24";
//        ordinateData[3] = "52.68";
//        ordinateData[4] = "35.12";
//        ordinateData[5] = "17.56";
//        ordinateData[6] = "2.1亿";
//        abscissaData = new String[2];
//        abscissaData[0] = "20157023";
//        abscissaData[1] = "20151201";
        ordinateData = getOrdinateData();
        abscissaData = getAbscissaData();
        initPoint();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < listLine.size(); i++) {
            StockLineModel point = listLine.get(i);
            canvas.drawLine(point.getStartX(), point.getStartY(), point.getStopX(), point.getStopY(), point.getPaint());
        }
        for (int i = 0; i < listPoint.size(); i++) {
            StockPointModel point = listPoint.get(i);
            canvas.drawPoint(point.getStartX(), point.getStartY(), point.getPaint());
        }
        if(listTextOridinate!=null&&listTextOridinate.size()>0){
            //drawText(canvas, false);
            drawOrdinateText(canvas, true);
            drawAbscissaText(canvas);
        }
        drawKline(canvas);
    }

    /**
     * 画K线
     * @param canvas 画布
     */
    private void drawKline(Canvas canvas) {
    }

    /**
     * 画横轴的刻度尺
     *
     * @param canvas 画布
     */
    private void drawAbscissaText(Canvas canvas) {
        float startY = (realHeight - STOCK_VIEW_LEFT_RIGHT_MARGIN * 2 * STOCK_VIEW_MARGIN) * (STOCK_VIEW_ALL_DEVIDE - 3) / STOCK_VIEW_ALL_DEVIDE + STOCK_VIEW_LEFT_DISTANCE;
        float startX = STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_MARGIN;
        listTextAbscissa.add(new StockTextModel(abscissaData[0],startX,startY));
        listTextAbscissa.add(new StockTextModel(abscissaData[1], realWidth - STOCK_VIEW_MARGIN,startY));
        for (int i = 0; i < listTextAbscissa.size(); i++) {
            StockTextModel model = listTextAbscissa.get(i);
            Paint paint = new Paint();
            paint.setColor(getResources().getColor(R.color.line_bg));
            paint.setTextSize(24);
            model.setPaint(paint);
            float tvY = model.getTvY() + (float) (STOCK_VIEW_MARGIN * 0.5);
            float tvX = model.getTvX();
            if (i == 1) {
                tvX -= STOCK_VIEW_MARGIN * 1.7;
            }
            canvas.drawText(model.getContent(), tvX, tvY, model.getPaint());
        }
    }

    /**
     * 画刻度尺
     *
     * @param canvas    画布
     * @param isOutSide 是否画在外部,true则画在外部,否则,在内部
     */
    private void drawOrdinateText(Canvas canvas, boolean isOutSide) {

        for (int i = 0; i < listTextOridinate.size(); i++) {
            StockTextModel model = listTextOridinate.get(i);
            Paint paint = new Paint();
            paint.setColor(getResources().getColor(R.color.line_bg));
            paint.setTextSize(24);
            model.setPaint(paint);
            float tvY = model.getTvY();
            float tvX = model.getTvX();
            if (i == 0) {
                tvY += 20;
            }
            if (isOutSide) {
                //将刻度尺画在外侧
                tvX = model.getTvX() - (float) (STOCK_VIEW_MARGIN * 1.3);
            }
            if(isOutSide&&(model.getContent().length()>6)){
                tvX =STOCK_VIEW_MARGIN*(1-0.7f);
            }
            canvas.drawText(model.getContent(), tvX, tvY, model.getPaint());
        }

    }

    public String[] getOrdinateData() {
        return ordinateData;
    }

    public void setOrdinateData(String[] ordinateData) {
        this.ordinateData = ordinateData;
    }

    public String[] getAbscissaData() {
        return abscissaData;
    }

    public void setAbscissaData(String[] abscissaData) {
        this.abscissaData = abscissaData;
    }
}
