package cn.com.jinrizhushi.stock.stock.model;

import android.graphics.Paint;

import cn.com.jinrizhushi.stock.util.customstockview.StockView;

/**
 * 描述: 画布上文字的模型
 * 作者: 刘倩
 * 日期: 15/12/1 23:56
 */
public class StockTextModel {

    /**
     * 文字
     */
    private String content;
    /**
     * x轴
     */
    private float tvX;
    /**
     * Y轴
     */
    private float tvY;
    /**
     * 画笔
     */
    private Paint paint;

    public StockTextModel(String content, float tvX, float tvY, Paint paint) {
        this.content = content;
        this.tvX = tvX;
        this.tvY = tvY;
        this.paint = paint;
    }

    public StockTextModel(String content, float tvX, float tvY) {
        this.content = content;
        this.tvX = tvX;
        this.tvY = tvY;
    }

    public StockTextModel() {
    }

    public StockTextModel(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public float getTvX() {
        return tvX;
    }

    public void setTvX(float tvX) {
        this.tvX = tvX;
    }

    public float getTvY() {
        return tvY;
    }

    public void setTvY(float tvY) {
        this.tvY = tvY;
    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }
}

