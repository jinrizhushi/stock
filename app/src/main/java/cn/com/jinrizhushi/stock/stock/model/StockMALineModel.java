package cn.com.jinrizhushi.stock.stock.model;

/**
 * 描述: 均线的数据
 * 作者: 刘倩
 * 日期: 15/12/4 01:48
 */
public class StockMALineModel {
    /** 均线的数据 */
    private  float[] ma;
    /** 均线的颜色 */
    private int color;
    /** 几日均线 */
    private String days;

    public StockMALineModel(float[] ma, int color, String days) {
        this.ma = ma;
        this.color = color;
        this.days = days;
    }

    public StockMALineModel() {
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public StockMALineModel(float[] ma, int color) {
        this.ma = ma;
        this.color = color;
    }

    public float[] getMa() {
        return ma;
    }

    public void setMa(float[] ma) {
        this.ma = ma;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
