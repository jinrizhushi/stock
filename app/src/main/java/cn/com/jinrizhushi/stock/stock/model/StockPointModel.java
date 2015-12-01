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
    /** 终止X */
    float stopX;
    /** 终止Y */
    float stopY;
    /** 画笔 */
    Paint paint;

    public StockPointModel(float startX, float startY, float stopX, float stopY,Paint paint) {
        this.startX = startX;
        this.startY = startY;
        this.stopX = stopX;
        this.stopY = stopY;
        this.paint = paint;
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

    public float getStopX() {
        return stopX;
    }

    public void setStopX(float stopX) {
        this.stopX = stopX;
    }

    public float getStopY() {
        return stopY;
    }

    public void setStopY(float stopY) {
        this.stopY = stopY;
    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }
}
