package cn.com.jinrizhushi.stock.stock.model;

/**
 * 描述: 股票的模型
 * 作者: 刘倩
 * 日期: 15/12/1 11:20
 */
public class StockModel {

    /** 日期 */
    private String date;
    /** 开盘价 */
    private String open;
    /** 最高价 */
    private String high;
    /** 最低价 */
    private String low;
    /** 收盘价 */
    private String close;
    /** 成交量 */
    private String volume;
    /** 调整收市价 */
    private String adjClose;

    public StockModel(String date, String open, String high, String low, String close, String volume, String adjClose) {
        this.date = date;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
        this.adjClose = adjClose;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getAdjClose() {
        return adjClose;
    }

    public void setAdjClose(String adjClose) {
        this.adjClose = adjClose;
    }
}
