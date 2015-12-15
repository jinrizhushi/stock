package cn.com.jinrizhushi.stock.stock.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述: 五日分时图/股票详情页的分时图
 * 作者: 刘倩
 * 日期: 15/12/15 13:59
 */
public class StockFiveDayModel {

    /** 最高大盘指数 */
    private String stockIndexMaxValue;
    /** 最低大盘指数 */
    private String stockIndexMinValue;
    /** 当前指数 */
    private String stockIndexCurrentValue;
    /** 数据 */
    private List<StockFiveDayItemModel> listFiveDayItemModel = new ArrayList<>();
    /** 日期 */
    private List<String> listDate = new ArrayList<>();


    public StockFiveDayModel() {
    }

    public StockFiveDayModel(String stockIndexMaxValue, String stockIndexMinValue, String stockIndexCurrentValue, List<StockFiveDayItemModel> listFiveDayItemModel) {
        this.stockIndexMaxValue = stockIndexMaxValue;
        this.stockIndexMinValue = stockIndexMinValue;
        this.stockIndexCurrentValue = stockIndexCurrentValue;
        this.listFiveDayItemModel = listFiveDayItemModel;
    }

    public String getStockIndexMaxValue() {
        return stockIndexMaxValue;
    }

    public void setStockIndexMaxValue(String stockIndexMaxValue) {
        this.stockIndexMaxValue = stockIndexMaxValue;
    }

    public String getStockIndexMinValue() {
        return stockIndexMinValue;
    }

    public void setStockIndexMinValue(String stockIndexMinValue) {
        this.stockIndexMinValue = stockIndexMinValue;
    }

    public String getStockIndexCurrentValue() {
        return stockIndexCurrentValue;
    }

    public void setStockIndexCurrentValue(String stockIndexCurrentValue) {
        this.stockIndexCurrentValue = stockIndexCurrentValue;
    }

    public List<StockFiveDayItemModel> getListFiveDayItemModel() {
        return listFiveDayItemModel;
    }

    public void setListFiveDayItemModel(List<StockFiveDayItemModel> listFiveDayItemModel) {
        this.listFiveDayItemModel = listFiveDayItemModel;
    }

    public List<String> getListDate() {
        return listDate;
    }

    public void setListDate(List<String> listDate) {
        this.listDate = listDate;
    }
}
