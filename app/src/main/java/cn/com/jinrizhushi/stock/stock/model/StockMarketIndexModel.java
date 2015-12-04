package cn.com.jinrizhushi.stock.stock.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述: 股票分时图
 * 作者: 刘倩
 * 日期: 15/12/4 14:30
 */
public class StockMarketIndexModel {
    /**
     * 最高大盘指数
     */
    private String marketIndexHigh;
    /**
     * 中间大盘指数
     */
    private String marketIndexCenter;
    /**
     * 最低大盘指数
     */
    private String marketIndexLow;
    /**
     * 股票最高涨幅
     */
    private String quoteChangeHigh;

    /**
     * 某段时间内的大盘指数
     */
    private List<StockMarketIndexItemModel> listMarketIndex = new ArrayList<>();

    public StockMarketIndexModel(String marketIndexHigh, String marketIndexCenter, String marketIndexLow, String quoteChangeHigh, List<StockMarketIndexItemModel> listMarketIndex) {
        this.marketIndexHigh = marketIndexHigh;
        this.marketIndexCenter = marketIndexCenter;
        this.marketIndexLow = marketIndexLow;
        this.quoteChangeHigh = quoteChangeHigh;
        this.listMarketIndex = listMarketIndex;
    }

    public StockMarketIndexModel() {
    }

    public String getMarketIndexHigh() {
        return marketIndexHigh;
    }

    public void setMarketIndexHigh(String marketIndexHigh) {
        this.marketIndexHigh = marketIndexHigh;
    }

    public String getMarketIndexCenter() {
        return marketIndexCenter;
    }

    public void setMarketIndexCenter(String marketIndexCenter) {
        this.marketIndexCenter = marketIndexCenter;
    }

    public String getMarketIndexLow() {
        return marketIndexLow;
    }

    public void setMarketIndexLow(String marketIndexLow) {
        this.marketIndexLow = marketIndexLow;
    }

    public String getQuoteChangeHigh() {
        return quoteChangeHigh;
    }

    public void setQuoteChangeHigh(String quoteChangeHigh) {
        this.quoteChangeHigh = quoteChangeHigh;
    }


    public List<StockMarketIndexItemModel> getListMarketIndex() {
        return listMarketIndex;
    }

    public void setListMarketIndex(List<StockMarketIndexItemModel> listMarketIndex) {
        this.listMarketIndex = listMarketIndex;
    }
}
