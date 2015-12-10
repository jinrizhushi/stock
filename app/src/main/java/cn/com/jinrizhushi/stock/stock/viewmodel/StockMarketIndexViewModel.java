package cn.com.jinrizhushi.stock.stock.viewmodel;

import android.graphics.Color;

import java.util.List;

import cn.com.jinrizhushi.stock.R;
import cn.com.jinrizhushi.stock.container.StockApplication;
import cn.com.jinrizhushi.stock.stock.model.StockMarketIndexItemModel;
import cn.com.jinrizhushi.stock.stock.model.StockMarketIndexModel;

/**
 * 描述: 分时图的视图模型层
 * 作者: 刘倩
 * 日期: 15/12/4 14:48
 */
public class StockMarketIndexViewModel {
    /**
     * 股票零涨幅
     */
    private String quoteChangeZero;
    /**
     * 股票最低涨幅
     */
    private String qoteChangeLow;
    /** 线的颜色 */
    private int color;
    /** 大盘数据 */
    private StockMarketIndexModel marketInfo;
    /**分割线的颜色 */
    private int lineColor;
    /** 红色 */
    public static int STOCK_MARKET_IDNEX_VIEW_RED_COLOR =0xFFCD3557;
    /** 绿色 */
    public static int STOCK_MARKET_IDNEX_VIEW_GREEN_COLOR = 0xFF00B285;

    public StockMarketIndexViewModel(StockMarketIndexModel marketInfo) {
        this.marketInfo = marketInfo;
        initData();
    }

    /**
     * 初始化数据
     */
    private void initData() {
        setMarketInfo(marketInfo);
        setQoteChangeLow("-" + marketInfo.getQuoteChangeHigh());
        setQuoteChangeZero("0");
        List<StockMarketIndexItemModel> listMarketIndex = marketInfo.getListMarketIndex();
        if(listMarketIndex!=null&&listMarketIndex.size()>0){
            if(Float.parseFloat((listMarketIndex.get(listMarketIndex.size()-1).getIndex()))>Float.parseFloat(marketInfo.getMarketIndexCenter())){
                setColor(STOCK_MARKET_IDNEX_VIEW_RED_COLOR);
            }else{
                setColor(STOCK_MARKET_IDNEX_VIEW_GREEN_COLOR);
            }
        }
        setLineColor(StockApplication.globalContext.getResources().getColor(R.color.stock_view_line_color));
    }


    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public StockMarketIndexViewModel() {
    }

    public String getQuoteChangeZero() {
        return quoteChangeZero;
    }

    public void setQuoteChangeZero(String quoteChangeZero) {
        this.quoteChangeZero = quoteChangeZero;
    }

    public String getQoteChangeLow() {
        return qoteChangeLow;
    }

    public void setQoteChangeLow(String qoteChangeLow) {
        this.qoteChangeLow = qoteChangeLow;
    }

    public StockMarketIndexModel getMarketInfo() {
        return marketInfo;
    }

    public void setMarketInfo(StockMarketIndexModel marketInfo) {
        this.marketInfo = marketInfo;
    }

    public int getLineColor() {
        return lineColor;
    }

    public void setLineColor(int lineColor) {
        this.lineColor = lineColor;
    }
}
