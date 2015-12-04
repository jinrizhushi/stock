package cn.com.jinrizhushi.stock.stock.model;

/**
 * 描述: 大盘指数的信息
 * 作者: 刘倩
 * 日期: 15/12/4 14:45
 */
public class StockMarketIndexItemModel {
    /** 大盘指数 */
    private String index;
    /** 时间 */
    private String time;

    public StockMarketIndexItemModel() {
    }

    public StockMarketIndexItemModel(String index) {
        this.index = index;
    }

    public StockMarketIndexItemModel(String index, String time) {
        this.index = index;
        this.time = time;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
