package cn.com.jinrizhushi.stock.stock.viewmodel;

import android.graphics.Color;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import cn.com.jinrizhushi.stock.stock.model.StockModel;

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
    private String[] listKOrdinateData = new String[7];
    /**
     * 橫坐标的数据
     */
    private String[] listKAbscissaData = new String[2];

    public StockKLineViewModel(List<StockModel> listKline) {
        this.listKline = listKline;
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
        float highest = hightPrice[listKline.size() - 1];
        float lowest = lowPrice[0];
        float distance = (highest - lowest) / 5;
        listKOrdinateData[0] = (getDecimalFormat(highest));
        listKOrdinateData[1] = (getDecimalFormat(lowest + distance * 4));
        listKOrdinateData[2] = (getDecimalFormat(lowest + distance * 3));
        listKOrdinateData[3] = (getDecimalFormat(lowest + distance * 2));
        listKOrdinateData[4] = (getDecimalFormat(lowest + distance));
        listKOrdinateData[5] = (getDecimalFormat(lowest));
        float sum = 0f;
        for (int i = 0; i < volumes.length; i++) {
            sum += volumes[i];
        }
        float all = sum / (volumes.length);
        listKOrdinateData[6] = (getDecimalFormatNone(all));
    }

    /**
     * 格式化数据
     *
     * @param data 要格式化的数据
     * @return
     */
    private String getDecimalFormat(float data) {
        DecimalFormat decimalFormat = new DecimalFormat(".00");
        return decimalFormat.format(data);
    }
    private String getDecimalFormatNone(float data) {
        DecimalFormat decimalFormat = new DecimalFormat("");
        return decimalFormat.format(data);
    }


}
