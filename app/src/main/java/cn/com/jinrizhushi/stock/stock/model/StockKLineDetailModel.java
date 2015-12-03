package cn.com.jinrizhushi.stock.stock.model;

/**
 * 描述: 柱状图的模型
 * 作者: 刘倩
 * 日期: 15/12/2 23:53
 */
public class StockKLineDetailModel {

    /** 最高点的起始x */
    private float highestStartX;
    /** 最高点的起始Y */
    private float highestStartY;
    /** 最高点的终止x */
    private float highestStopX;
    /** 最高点的终止Y */
    private float highestStopY;
    /** 矩形距离左边的距离 */
    private float rectLeft;
    /** 矩形距离上边的距离 */
    private float rectTop;
    /** 矩形距离右边的距离 */
    private float rectRight;
    /** 矩形距离底部的距离 */
    private float rectBottom;
    /** 最低点的起始x */
    private float lowestStartX;
    /** 最低点的起始Y */
    private float lowestStartY;
    /** 最低点的终止x */
    private float lowestStopX;
    /** 最低点的终止Y */
    private float lowestStopY;
    /** 柱状距离左边的距离 */
    private float columnarLeft;
    /**柱状距离上边的距离 */
    private float columnarTop;
    /** 柱状距离右边的距离 */
    private float columnarRight;
    /** 柱状距离底部的距离 */
    private float columnarBottom;
    /** 柱状图的颜色 */
    private int color;

    public StockKLineDetailModel(float highestStartX, float highestStartY, float highestStopX, float highestStopY, float rectLeft, float rectTop, float rectRight, float rectBottom, float lowestStartX, float lowestStartY, float lowestStopX, float lowestStopY, float columnarLeft, float columnarTop, float columnarRight, float columnarBottom, int color) {
        this.highestStartX = highestStartX;
        this.highestStartY = highestStartY;
        this.highestStopX = highestStopX;
        this.highestStopY = highestStopY;
        this.rectLeft = rectLeft;
        this.rectTop = rectTop;
        this.rectRight = rectRight;
        this.rectBottom = rectBottom;
        this.lowestStartX = lowestStartX;
        this.lowestStartY = lowestStartY;
        this.lowestStopX = lowestStopX;
        this.lowestStopY = lowestStopY;
        this.columnarLeft = columnarLeft;
        this.columnarTop = columnarTop;
        this.columnarRight = columnarRight;
        this.columnarBottom = columnarBottom;
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public StockKLineDetailModel() {
    }

    public float getHighestStartX() {
        return highestStartX;
    }

    public void setHighestStartX(float highestStartX) {
        this.highestStartX = highestStartX;
    }

    public float getHighestStartY() {
        return highestStartY;
    }

    public void setHighestStartY(float highestStartY) {
        this.highestStartY = highestStartY;
    }

    public float getHighestStopX() {
        return highestStopX;
    }

    public void setHighestStopX(float highestStopX) {
        this.highestStopX = highestStopX;
    }

    public float getHighestStopY() {
        return highestStopY;
    }

    public void setHighestStopY(float highestStopY) {
        this.highestStopY = highestStopY;
    }

    public float getRectLeft() {
        return rectLeft;
    }

    public void setRectLeft(float rectLeft) {
        this.rectLeft = rectLeft;
    }

    public float getRectTop() {
        return rectTop;
    }

    public void setRectTop(float rectTop) {
        this.rectTop = rectTop;
    }

    public float getRectRight() {
        return rectRight;
    }

    public void setRectRight(float rectRight) {
        this.rectRight = rectRight;
    }

    public float getRectBottom() {
        return rectBottom;
    }

    public void setRectBottom(float rectBottom) {
        this.rectBottom = rectBottom;
    }

    public float getLowestStartX() {
        return lowestStartX;
    }

    public void setLowestStartX(float lowestStartX) {
        this.lowestStartX = lowestStartX;
    }

    public float getLowestStartY() {
        return lowestStartY;
    }

    public void setLowestStartY(float lowestStartY) {
        this.lowestStartY = lowestStartY;
    }

    public float getLowestStopX() {
        return lowestStopX;
    }

    public void setLowestStopX(float lowestStopX) {
        this.lowestStopX = lowestStopX;
    }

    public float getLowestStopY() {
        return lowestStopY;
    }

    public void setLowestStopY(float lowestStopY) {
        this.lowestStopY = lowestStopY;
    }

    public float getColumnarLeft() {
        return columnarLeft;
    }

    public void setColumnarLeft(float columnarLeft) {
        this.columnarLeft = columnarLeft;
    }

    public float getColumnarTop() {
        return columnarTop;
    }

    public void setColumnarTop(float columnarTop) {
        this.columnarTop = columnarTop;
    }

    public float getColumnarRight() {
        return columnarRight;
    }

    public void setColumnarRight(float columnarRight) {
        this.columnarRight = columnarRight;
    }

    public float getColumnarBottom() {
        return columnarBottom;
    }

    public void setColumnarBottom(float columnarBottom) {
        this.columnarBottom = columnarBottom;
    }
}
