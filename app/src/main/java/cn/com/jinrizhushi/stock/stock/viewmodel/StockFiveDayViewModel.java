package cn.com.jinrizhushi.stock.stock.viewmodel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.com.jinrizhushi.stock.stock.model.StockFiveDayItemModel;
import cn.com.jinrizhushi.stock.stock.model.StockFiveDayModel;
import cn.com.jinrizhushi.stock.util.Tools;

/**
 * 描述: 五日线/分时线的viewmodel
 * 作者: 刘倩
 * 日期: 15/12/15 14:18
 */
public class StockFiveDayViewModel {
    /**
     * 线的颜色
     */
    private int lineColor;
    private int STOCK_INDEX_LINE_COLOR = 0xFF0E58A7;
    /**
     * 阴影颜色
     */
    private int shadowColor;
    private int STOCK_INDEX_SHADOW_COLOR = 0xFFDCEBF6;
    /**
     * 成交量柱状图的颜色
     */
    private int volumeColor;
    private int STOCK_INDEX_VOLUME_COLOR = 0xFFB3B3B3;
    /**
     * 最大指数和最大幅度的颜色
     */
    private int maxIndexColor;
    private int STOCK_INDEX_MAX_COLOR = 0xFFDB2518;
    /**
     * 最小指数和最小幅度的颜色
     */
    private int minIndexColor;
    private int STOCK_INDEX_MIN_COLOR = 0xFF39A823;

    /**
     * 股票最低涨幅
     */
    private String qoteChangeLow;
    /**
     * 股票最高涨幅
     */
    private String qoteChangeHigh;
    /***
     * 数据
     */
    private StockFiveDayModel stockFiveDayModel;
    /** 最高的成交额度 */
    private String highestVolume;

    public StockFiveDayViewModel() {
    }

    public StockFiveDayViewModel(int lineColor, int shadowColor, int volumeColor, String qoteChangeLow, StockFiveDayModel stockFiveDayModel, String qoteChangeHigh) {
        this.lineColor = lineColor;
        this.shadowColor = shadowColor;
        this.volumeColor = volumeColor;
        this.qoteChangeLow = qoteChangeLow;
        this.stockFiveDayModel = stockFiveDayModel;
        this.qoteChangeHigh = qoteChangeHigh;
    }

    public int getLineColor() {
        return lineColor;
    }

    public void setLineColor(int lineColor) {
        this.lineColor = lineColor;
    }

    public int getShadowColor() {
        return shadowColor;
    }

    public void setShadowColor(int shadowColor) {
        this.shadowColor = shadowColor;
    }

    public int getVolumeColor() {
        return volumeColor;
    }

    public void setVolumeColor(int volumeColor) {
        this.volumeColor = volumeColor;
    }

    public String getQoteChangeLow() {
        return qoteChangeLow;
    }

    public void setQoteChangeLow(String qoteChangeLow) {
        this.qoteChangeLow = qoteChangeLow;
    }

    public StockFiveDayModel getStockFiveDayModel() {
        return stockFiveDayModel;
    }

    public void setStockFiveDayModel(StockFiveDayModel stockFiveDayModel) {
        this.stockFiveDayModel = stockFiveDayModel;
        initData();
    }

    public String getQoteChangeHigh() {
        return qoteChangeHigh;
    }

    public void setQoteChangeHigh(String qoteChangeHigh) {
        this.qoteChangeHigh = qoteChangeHigh;
    }

    public int getMaxIndexColor() {
        return maxIndexColor;
    }

    public void setMaxIndexColor(int maxIndexColor) {
        this.maxIndexColor = maxIndexColor;
    }

    public int getMinIndexColor() {
        return minIndexColor;
    }

    public void setMinIndexColor(int minIndexColor) {
        this.minIndexColor = minIndexColor;
    }

    public String getHighestVolume() {
        return highestVolume;
    }

    public void setHighestVolume(String highestVolume) {
        this.highestVolume = highestVolume;
    }

    /**
     * 初始化数据
     */
    private void initData() {
        float maxValue = Float.parseFloat(stockFiveDayModel.getStockIndexMaxValue());
        float minValue = Float.parseFloat(stockFiveDayModel.getStockIndexMinValue());
        float centerValue = Tools.getDecimalFormatFloat((maxValue + minValue) / 2);
        float range = Tools.getDecimalFormatFloat((maxValue - minValue) / centerValue);
        stockFiveDayModel.setStockIndexMaxValue(range + "%");
        stockFiveDayModel.setStockIndexMinValue("-" + range + "%");
        setLineColor(STOCK_INDEX_LINE_COLOR);
        setShadowColor(STOCK_INDEX_SHADOW_COLOR);
        setVolumeColor(STOCK_INDEX_VOLUME_COLOR);
        setMaxIndexColor(STOCK_INDEX_MAX_COLOR);
        setMinIndexColor(STOCK_INDEX_MIN_COLOR);
        List<StockFiveDayItemModel> listFiveDayItemModel =  stockFiveDayModel.getListFiveDayItemModel();
        Float[] all ;
        if(listFiveDayItemModel!=null&&listFiveDayItemModel.size()>0){
            all = new Float[listFiveDayItemModel.size()];
            for (int i = 0;i<listFiveDayItemModel.size();i++)
            {
                StockFiveDayItemModel model = listFiveDayItemModel.get(i);
                float volume = Float.parseFloat(model.getVolume());
                all[i] = volume;
            }
            Arrays.sort(all);
            setHighestVolume(Tools.getDecimalFormatNone(all[listFiveDayItemModel.size()-1]));
        }else{
            setHighestVolume("0");
        }
    }

}
