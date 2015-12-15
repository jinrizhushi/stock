package cn.com.jinrizhushi.stock.stock.model;

/**
 * 描述: 五日分时图/股票详情页的分时图的子数据
 * 作者: 刘倩
 * 日期: 15/12/15 14:05
 */
public class StockFiveDayItemModel {
    /** 大盘指数 */
    private String index;
    /** 时间 */
    private String time;
    /** 成交额 */
    private String volume;

    public StockFiveDayItemModel(String index, String time, String volume) {
        this.index = index;
        this.time = time;
        this.volume = volume;
    }

    public StockFiveDayItemModel() {
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

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }
}
