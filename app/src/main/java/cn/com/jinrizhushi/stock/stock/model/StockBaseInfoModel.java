package cn.com.jinrizhushi.stock.stock.model;

/**
 * 描述: 股票详情中的股票基本信息的模型
 * 作者: 刘倩
 * 日期: 15/12/14 14:05
 */
public class StockBaseInfoModel {
    /**
     * 股票名称
     */
    private String stockName;
    /**
     * 股票代码
     */
    private String stockCode;
    /**
     * 是否休市
     */
    private boolean isClose;
    /**
     * 当前时间
     */
    private String currentTime;
    /**
     * 当前市值
     */
    private String stockPrice;
    /**
     * 增长值
     */
    private String stockAddPrice;
    /**
     * 增长的幅度
     */
    private String stockAddRange;
    /**
     * 今开
     */
    private String open;
    /**
     * 昨收
     */
    private String close;
    /**
     * 成交量
     */
    private String volume;
    /**
     * 换手率
     */
    private String swichRate;
    /**
     * 最高
     */
    private String highest;
    /**
     * 最低
     */
    private String lowest;
    /**
     * 成交额
     */
    private String volumePrice;
    /**
     * 总市值
     */
    private String allPrice;
    /**
     * 内盘
     */
    private String inner;
    /**
     * 外盘
     */
    private String outside;
    /**
     * 市盈率
     */
    private String ratio;
    /**
     * 振幅
     */
    private String swing;

    public StockBaseInfoModel(String stockName, String stockCode, boolean isClose, String currentTime, String stockPrice, String stockAddPrice, String stockAddRange, String open, String close, String volume, String swichRate, String highest, String lowest, String volumePrice, String allPrice, String inner, String outside, String ratio, String swing) {
        this.stockName = stockName;
        this.stockCode = stockCode;
        this.isClose = isClose;
        this.currentTime = currentTime;
        this.stockPrice = stockPrice;
        this.stockAddPrice = stockAddPrice;
        this.stockAddRange = stockAddRange;
        this.open = open;
        this.close = close;
        this.volume = volume;
        this.swichRate = swichRate;
        this.highest = highest;
        this.lowest = lowest;
        this.volumePrice = volumePrice;
        this.allPrice = allPrice;
        this.inner = inner;
        this.outside = outside;
        this.ratio = ratio;
        this.swing = swing;
    }

    public StockBaseInfoModel() {
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public boolean isClose() {
        return isClose;
    }

    public void setIsClose(boolean isClose) {
        this.isClose = isClose;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public String getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(String stockPrice) {
        this.stockPrice = stockPrice;
    }

    public String getStockAddPrice() {
        return stockAddPrice;
    }

    public void setStockAddPrice(String stockAddPrice) {
        this.stockAddPrice = stockAddPrice;
    }

    public String getStockAddRange() {
        return stockAddRange;
    }

    public void setStockAddRange(String stockAddRange) {
        this.stockAddRange = stockAddRange;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
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

    public String getSwichRate() {
        return swichRate;
    }

    public void setSwichRate(String swichRate) {
        this.swichRate = swichRate;
    }

    public String getHighest() {
        return highest;
    }

    public void setHighest(String highest) {
        this.highest = highest;
    }

    public String getLowest() {
        return lowest;
    }

    public void setLowest(String lowest) {
        this.lowest = lowest;
    }

    public String getVolumePrice() {
        return volumePrice;
    }

    public void setVolumePrice(String volumePrice) {
        this.volumePrice = volumePrice;
    }

    public String getAllPrice() {
        return allPrice;
    }

    public void setAllPrice(String allPrice) {
        this.allPrice = allPrice;
    }

    public String getInner() {
        return inner;
    }

    public void setInner(String inner) {
        this.inner = inner;
    }

    public String getOutside() {
        return outside;
    }

    public void setOutside(String outside) {
        this.outside = outside;
    }

    public String getRatio() {
        return ratio;
    }

    public void setRatio(String ratio) {
        this.ratio = ratio;
    }

    public String getSwing() {
        return swing;
    }

    public void setSwing(String swing) {
        this.swing = swing;
    }
}
