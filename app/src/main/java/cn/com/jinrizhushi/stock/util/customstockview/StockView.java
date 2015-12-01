package cn.com.jinrizhushi.stock.util.customstockview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import cn.com.jinrizhushi.stock.R;
import cn.com.jinrizhushi.stock.stock.model.StockPointModel;

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
    private float STOCK_VIEW_BOTTOM_LINE_PERCENT = 0.7F;

    /**
     * 绘制线的List
     */
    private List<StockPointModel> listPoint = new ArrayList<>();

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

        Paint paint = new Paint();
        paint.setColor(getResources().getColor(R.color.line_bg));

        for (int i = 0; i <= 7; i++) {
            StockPointModel point;
            if (i == 0) {
                point = new StockPointModel(STOCK_VIEW_MARGIN, STOCK_VIEW_MARGIN * 2, realWidth - STOCK_VIEW_MARGIN, STOCK_VIEW_MARGIN * 2, paint);
                listPoint.add(point);
            } else if (i < 5 || i == 7) {
                float yPoint = (realHeight - 4 * STOCK_VIEW_MARGIN) * i / 7 + 2 * STOCK_VIEW_MARGIN;
                point = new StockPointModel(STOCK_VIEW_MARGIN, yPoint, realWidth - STOCK_VIEW_MARGIN, yPoint, paint);
                listPoint.add(point);
                if(i == 4){
                    StockPointModel lineLeft = new StockPointModel(STOCK_VIEW_MARGIN, STOCK_VIEW_MARGIN*2, STOCK_VIEW_MARGIN, yPoint, paint);
                    listPoint.add(lineLeft);
                    StockPointModel lineRight = new StockPointModel(realWidth-STOCK_VIEW_MARGIN, STOCK_VIEW_MARGIN*2, realWidth-STOCK_VIEW_MARGIN, yPoint, paint);
                    listPoint.add(lineRight);
                }
            } else if (i == 5) {
                float yPoint = (realHeight - 2 * STOCK_VIEW_MARGIN) - (realHeight - 4 * STOCK_VIEW_MARGIN) * 2 / 7 * STOCK_VIEW_BOTTOM_LINE_PERCENT;
                point = new StockPointModel(STOCK_VIEW_MARGIN, yPoint, realWidth - STOCK_VIEW_MARGIN, yPoint, paint);
                listPoint.add(point);
            } else if (i == 6) {
                float yPoint = (realHeight - 2 * STOCK_VIEW_MARGIN) - (realHeight - 4 * STOCK_VIEW_MARGIN) * 2 / 7 * STOCK_VIEW_BOTTOM_LINE_PERCENT / 2;
                point = new StockPointModel(STOCK_VIEW_MARGIN, yPoint, realWidth - STOCK_VIEW_MARGIN, yPoint, paint);
                listPoint.add(point);
            }
        }
        StockPointModel point;
        float yPointLeft = (realHeight - 2 * STOCK_VIEW_MARGIN) - (realHeight - 4 * STOCK_VIEW_MARGIN) * 2 / 7 * STOCK_VIEW_BOTTOM_LINE_PERCENT;
        float yPointRight = realHeight - 2 * STOCK_VIEW_MARGIN;
        point = new StockPointModel(STOCK_VIEW_MARGIN,yPointRight,STOCK_VIEW_MARGIN,yPointLeft,paint);
        listPoint.add(point);
        point = new StockPointModel(realWidth-STOCK_VIEW_MARGIN,yPointRight,realWidth-STOCK_VIEW_MARGIN,yPointLeft,paint);
        listPoint.add(point);


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
        for (int i = 0; i < listPoint.size(); i++) {
            StockPointModel point = listPoint.get(i);
            canvas.drawLine(point.getStartX(), point.getStartY(), point.getStopX(), point.getStopY(), point.getPaint());
        }


    }
}
