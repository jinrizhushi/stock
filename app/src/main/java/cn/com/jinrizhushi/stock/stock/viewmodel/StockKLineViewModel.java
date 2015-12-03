package cn.com.jinrizhushi.stock.stock.viewmodel;

import android.graphics.Color;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import cn.com.jinrizhushi.stock.stock.model.StockModel;
import cn.com.jinrizhushi.stock.util.Tools;
import cn.com.jinrizhushi.stock.util.customstockview.StockView;

/**
 * 描述: k线的视图控制模型
 * 作者: 刘倩
 * 日期: 15/12/2 13:58
 */
public class StockKLineViewModel {
    /**
     * K线的数据
     */
    private List<StockModel> listKline = new ArrayList<>();
    /**
     * K线的颜色
     */
    private List<Integer> listKColor = new ArrayList<>();
    /**
     * 纵坐标的数据
     */
    private String[] listKOrdinateData;
    /**
     * 橫坐标的数据
     */
    private String[] listKAbscissaData = new String[2];
    /**
     * 分割的数量
     */
    private int STOCK_VIEW_MODEL_ALL_DEVIDE;
    /** 最高价格 */
    public static float STOCK_VIEW_HIGHEST_PRICE;
    /** 最小价格 */
    public static float STOCK_VIEW_LOWEST_PRICE;
    /** 最高成交量 */
    public static float STOCK_VIEW_HIGHEST_VOLUME;
    /** 最小成交量 */
    public static float STOCK_VIEW_LOWEST_VOLUME;
    public StockKLineViewModel(List<StockModel> listKline) {
        this.listKline = listKline;
        STOCK_VIEW_MODEL_ALL_DEVIDE = StockView.STOCK_VIEW_ALL_DEVIDE - 1;
        listKOrdinateData = new String[STOCK_VIEW_MODEL_ALL_DEVIDE];
        if (listKline != null && listKline.size() > 0) {
            initData(listKline);
        }
    }

    public List<Integer> getListKColor() {
        return listKColor;
    }

    public String[] getListKOrdinateData() {
        return listKOrdinateData;
    }

    public String[] getListKAbscissaData() {
        return listKAbscissaData;
    }

    /**
     * 初始化数据
     *
     * @param listKline 数据
     */
    private void initData(List<StockModel> listKline) {
        float[] hightPrice = new float[listKline.size()];
        float[] lowPrice = new float[listKline.size()];
        float[] volumes = new float[listKline.size()];
        String[] dates = new String[listKline.size()];
        for (int i = 0; i < listKline.size(); i++) {
            /**如果收盘价格高于开盘价格，则k线被称为阳线，用空心的实体表示。反之称为阴线用黑色实体或白色实体表示。
             * 很多软件都可以用彩色实体来表示阴线和阳线，在国内股票和期货市场 ，通常用红色表示阳线，绿色表示阴线。*/
            StockModel model = listKline.get(i);
            if (Float.parseFloat(model.getClose()) > Float.parseFloat(model.getOpen())) {
                listKColor.add(Color.RED);
            } else {
                listKColor.add(Color.GREEN);
            }
            hightPrice[i] = Float.parseFloat(model.getHigh());
            lowPrice[i] = Float.parseFloat(model.getLow());
            volumes[i] = Float.parseFloat(model.getVolume());
            dates[i] = model.getDate();
        }
        countListKOrdinateData(hightPrice, lowPrice, volumes);
        countListKAbscissaData(dates);

    }

    /**
     * 计算横坐标的数据
     *
     * @param dates
     */
    private void countListKAbscissaData(String[] dates) {
        listKAbscissaData[0] = (dates[listKline.size() - 1]);
        listKAbscissaData[1] = (dates[0]);
    }

    /**
     * 计算纵坐标的数据
     *
     * @param hightPrice
     * @param lowPrice
     * @param volumes
     */
    private void countListKOrdinateData(float[] hightPrice, float[] lowPrice, float[] volumes) {
        java.util.Arrays.sort(hightPrice);//升序排列
        java.util.Arrays.sort(lowPrice);

        float highest= STOCK_VIEW_HIGHEST_PRICE = hightPrice[listKline.size() - 1];
        float lowest =STOCK_VIEW_LOWEST_PRICE= lowPrice[0];
        float distance = (highest - lowest) / (STOCK_VIEW_MODEL_ALL_DEVIDE - 2);
        for (int i = 0;i<(listKOrdinateData.length-1);i++){
            if(i==0){
                listKOrdinateData[0] = (Tools.getDecimalFormat(highest));
            }else{
                listKOrdinateData[i] = (Tools.getDecimalFormat(lowest+distance*(STOCK_VIEW_MODEL_ALL_DEVIDE-i-2)));
            }

        }
        java.util.Arrays.sort(volumes);
        float highestVolume=STOCK_VIEW_HIGHEST_VOLUME = volumes[listKline.size() - 1];
        float lowestVolume=STOCK_VIEW_LOWEST_VOLUME = volumes[0];
        float all = (highestVolume + lowestVolume) / 2;
        listKOrdinateData[STOCK_VIEW_MODEL_ALL_DEVIDE - 1] = (Tools.getDecimalFormatNone(all));
    }


    public List<StockModel> getListKline() {
        return listKline;
    }

    public void setListKline(List<StockModel> listKline) {
        this.listKline = listKline;
    }

    public void setListKColor(List<Integer> listKColor) {
        this.listKColor = listKColor;
    }

    public void setListKOrdinateData(String[] listKOrdinateData) {
        this.listKOrdinateData = listKOrdinateData;
    }

    public void setListKAbscissaData(String[] listKAbscissaData) {
        this.listKAbscissaData = listKAbscissaData;
    }
}
