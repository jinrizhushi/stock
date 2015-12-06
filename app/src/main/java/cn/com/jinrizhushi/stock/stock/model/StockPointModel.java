package cn.com.jinrizhushi.stock.stock.model;

import android.graphics.Paint;

/**
 * 描述: 点的模型
 * 作者: 刘倩
 * 日期: 15/12/1 17:55
 */
public class StockPointModel {
    /** 初始X */
    float startX;
    /** 初始Y */
    float startY;
    /** 画笔 */
    Paint paint;

    public StockPointModel(float startX, float startY, Paint paint) {
        this.startX = startX;
        this.startY = startY;
        this.paint = paint;
    }

    public StockPointModel() {
    }

    public float getStartX() {
        return startX;
    }

    public void setStartX(float startX) {
        this.startX = startX;
    }

    public float getStartY() {
        return startY;
    }

    public void setStartY(float startY) {
        this.startY = startY;
    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }
}
