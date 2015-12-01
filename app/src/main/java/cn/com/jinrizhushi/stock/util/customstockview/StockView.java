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
     * 绘制文本的List
     */
    private List<StockTextModel> listText = new ArrayList<>();
    /**
     * 纵坐标的刻度值
     */
    private List<String> listOrdinate = new ArrayList<>();
    /**
     * 横坐标的刻度值
     */
    private List<String> listAbscissa = new ArrayList<>();
    /**
     * 成交量的纵坐标
     */
    private String volumeOrdinate;
    /**
     * 将视图分段
     */
    private int STOCK_VIEW_ALL_DEVIDE = 8;
    /**
     * 视图左右的间距
     */
    private int STOCK_VIEW_LEFT_RIGHT_MARGIN = 2;
    /**
     * 视图离左边的距离
     */
    private int STOCK_VIEW_LEFT_MARGIN = 2;

    public StockView(Context context) {
        super(context);
    }

    public StockView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public StockView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public List<String> getListOrdinate() {
        //从小到大排列
        listOrdinate.add("17.56");
        listOrdinate.add("35.12");
        listOrdinate.add("52.68");
        listOrdinate.add("70.24");
        listOrdinate.add("87.80");
        return listOrdinate;
    }

    public List<String> getListAbscissa() {
        //第一个横坐标和最后一个横坐标
        listAbscissa.add("2015023");
        listAbscissa.add("20151201");
        return listAbscissa;
    }

    public String getVolumeOrdinate() {
        volumeOrdinate = "2.8亿";
        return volumeOrdinate;
    }

    /**
     * 初始化图的点坐标
     */
    private void initPoint() {

        Paint paint = new Paint();
        paint.setColor(getResources().getColor(R.color.line_bg));

        for (int i = 0; i <= STOCK_VIEW_ALL_DEVIDE; i++) {
            StockLineModel point;
            if (i == 0) {
                point = new StockLineModel(STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_MARGIN, STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN, realWidth - STOCK_VIEW_MARGIN, STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN, paint);
                listLine.add(point);
            } else if (i < (STOCK_VIEW_ALL_DEVIDE - 2) || i == STOCK_VIEW_ALL_DEVIDE) {
                if (i > 0 && i < (STOCK_VIEW_ALL_DEVIDE - 3)) {
                    drawPoint((realHeight - STOCK_VIEW_LEFT_RIGHT_MARGIN * 2 * STOCK_VIEW_MARGIN) * i / STOCK_VIEW_ALL_DEVIDE + STOCK_VIEW_LEFT_RIGHT_MARGIN * STOCK_VIEW_MARGIN, 2.0f);
                } else {
                    float yPoint = (realHeight - STOCK_VIEW_LEFT_RIGHT_MARGIN * 2 * STOCK_VIEW_MARGIN) * i / STOCK_VIEW_ALL_DEVIDE + STOCK_VIEW_LEFT_RIGHT_MARGIN * STOCK_VIEW_MARGIN;
                    point = new StockLineModel(STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_MARGIN, yPoint, realWidth - STOCK_VIEW_MARGIN, yPoint, paint);
                    listLine.add(point);
                    if (i == (STOCK_VIEW_ALL_DEVIDE - 3)) {
                        StockLineModel lineLeft = new StockLineModel(STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_MARGIN, STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN, STOCK_VIEW_MARGIN*STOCK_VIEW_LEFT_MARGIN®, yPoint, paint);
                        listLine.add(lineLeft);
                        StockLineModel lineRight = new StockLineModel(realWidth - STOCK_VIEW_MARGIN, STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN, realWidth - STOCK_VIEW_MARGIN, yPoint, paint);
                        listLine.add(lineRight);
                    }
                }

            } else if (i == (STOCK_VIEW_ALL_DEVIDE - 2)) {
                float yPoint = (realHeight - STOCK_VIEW_LEFT_RIGHT_MARGIN * STOCK_VIEW_MARGIN) - (realHeight - STOCK_VIEW_LEFT_RIGHT_MARGIN * 2 * STOCK_VIEW_MARGIN) * STOCK_VIEW_LEFT_RIGHT_MARGIN / STOCK_VIEW_ALL_DEVIDE * STOCK_VIEW_BOTTOM_LINE_PERCENT;
                point = new StockLineModel(STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_MARGIN, yPoint, realWidth - STOCK_VIEW_MARGIN, yPoint, paint);
                listLine.add(point);
            } else if (i == (STOCK_VIEW_ALL_DEVIDE - 1)) {
                drawPoint((realHeight - STOCK_VIEW_LEFT_RIGHT_MARGIN * STOCK_VIEW_MARGIN) - (realHeight - STOCK_VIEW_LEFT_RIGHT_MARGIN * 2 * STOCK_VIEW_MARGIN) * 2 / STOCK_VIEW_ALL_DEVIDE * STOCK_VIEW_BOTTOM_LINE_PERCENT / 2, 2.0f);
            }
        }
        StockLineModel point;
        float yPointLeft = (realHeight - STOCK_VIEW_LEFT_RIGHT_MARGIN * STOCK_VIEW_MARGIN) - (realHeight - STOCK_VIEW_LEFT_RIGHT_MARGIN * 2 * STOCK_VIEW_MARGIN) * 2 / STOCK_VIEW_ALL_DEVIDE * STOCK_VIEW_BOTTOM_LINE_PERCENT;
        float yPointRight = realHeight - STOCK_VIEW_LEFT_RIGHT_MARGIN * STOCK_VIEW_MARGIN;
        point = new StockLineModel(STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_MARGIN, yPointRight, STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_MARGIN, yPointLeft, paint);
        listLine.add(point);
        point = new StockLineModel(realWidth - STOCK_VIEW_MARGIN, yPointRight, realWidth - STOCK_VIEW_MARGIN , yPointLeft, paint);
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
        int stop = (int) (realWidth - STOCK_VIEW_LEFT_RIGHT_MARGIN * STOCK_VIEW_MARGIN);
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
        drawText(canvas, false);
    }

    /**
     * 画刻度尺
     *
     * @param canvas 画布
     */
    private void drawText(Canvas canvas, boolean isInside) {
        if (isInside) {
            //将刻度尺画在内侧


        } else {
            //将刻度尺画在外侧

        }

    }
}
