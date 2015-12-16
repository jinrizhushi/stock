package cn.com.jinrizhushi.stock.stock.model;

/**
 * 描述: 长方形的模型
 * 作者: 刘倩
 * 日期: 15/12/16 14:32
 */
public class StockRectModel {
    /** 左边的距离 */
    private float left;
    /** 上边的距离 */
    private float top;
    /** 右边的距离 */
    private float right;
    /** 底部的距离 */
    private float bottom;

    public StockRectModel() {
    }

    public StockRectModel(float left, float top, float right, float bottom) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    public float getLeft() {
        return left;
    }

    public void setLeft(float left) {
        this.left = left;
    }

    public float getTop() {
        return top;
    }

    public void setTop(float top) {
        this.top = top;
    }

    public float getRight() {
        return right;
    }

    public void setRight(float right) {
        this.right = right;
    }

    public float getBottom() {
        return bottom;
    }

    public void setBottom(float bottom) {
        this.bottom = bottom;
    }
}
