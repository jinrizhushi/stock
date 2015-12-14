package cn.com.jinrizhushi.stock.stock.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import org.robobinding.annotation.PresentationModel;
import org.robobinding.presentationmodel.HasPresentationModelChangeSupport;
import org.robobinding.presentationmodel.PresentationModelChangeSupport;

import java.util.SimpleTimeZone;

import cn.com.jinrizhushi.stock.stock.model.StockBaseInfoModel;

/**
 * 描述: 股票详情的视图模型类
 * 作者: 刘倩
 * 日期: 15/12/11 14:35
 */
@PresentationModel
public class StockDetailViewModel implements HasPresentationModelChangeSupport {

    private PresentationModelChangeSupport changeSupport;
    /**
     * 上下文
     */
    private Activity context;
    /**
     * 基本信息
     */
    private StockBaseInfoModel baseInfoModel;
    /**
     * 是否分时
     */
    private boolean timeVisibility = true;
    /**
     * 是否5日
     */
    private boolean fiveDayVisibility = false;
    /**
     * 是否日K
     */
    private boolean dayKVisibility = false;
    /**
     * 是否周K
     */
    private boolean weekendKVisibility = false;
    /**
     * 是否月K
     */
    private boolean monthKVisibility = false;
    /**
     * 是否显示分时图
     */
    private boolean llTimeVisibility = true;
    /**
     * 是否显示5日图
     */
    private boolean llFiveDayVisibility = false;
    /**
     * 是否显示日K图
     */
    private boolean llDayKVisibility = false;
    /**
     * 是否显示周K图
     */
    private boolean llWeekendKVisibility = false;
    /**
     * 是否显示月K图
     */
    private boolean llMonthKVisibility = false;

    /**
     * 返回按钮的设置
     */
    public void goback() {
        context.finish();
    }

    public String getStockNameAndCode() {
        return baseInfoModel.getStockName() + "   (" + baseInfoModel.getStockCode() + ")";
    }

    public String getIsOpenAndDate() {
        if (baseInfoModel.isClose()) {
            return "休市  " + baseInfoModel.getCurrentTime();
        } else {
            return "未休市  " + baseInfoModel.getCurrentTime();
        }
    }

    public String getStockPrice() {
        return baseInfoModel.getStockPrice();
    }

    public String getAddPrice() {
        return baseInfoModel.getStockAddPrice();
    }

    public String getAddRange() {
        return baseInfoModel.getStockAddRange();
    }

    public String getTodayOpen() {
        return baseInfoModel.getOpen();
    }

    public String getYestodayClose() {
        return baseInfoModel.getClose();
    }

    public String getVolume() {
        return baseInfoModel.getVolume();
    }

    public String getSwich() {
        return baseInfoModel.getSwichRate();
    }

    public String getHighest() {
        return baseInfoModel.getHighest();
    }

    public String getLowest() {
        return baseInfoModel.getLowest();
    }

    public String getVolumePrice() {
        return baseInfoModel.getVolumePrice();
    }

    public String getAllPrice() {
        return baseInfoModel.getAllPrice();
    }

    public String getInside() {
        return baseInfoModel.getInner();
    }

    public String getOutside() {
        return baseInfoModel.getOutside();
    }

    public String getRatio() {
        return baseInfoModel.getRatio();
    }

    public String getRate() {
        return baseInfoModel.getSwing();
    }

    public void onClickTime() {
        setTimeVisibility(true);
        setDayKVisibility(false);
        setFiveDayVisibility(false);
        setWeekendKVisibility(false);
        setMonthKVisibility(false);

        setLlTimeVisibility(true);
        setLlFiveDayVisibility(false);
        setLlDayKVisibility(false);
        setLlWeekendKVisibility(false);
        setLlMonthKVisibility(false);


    }

    public void onClickFiveDay() {
        setTimeVisibility(false);
        setDayKVisibility(false);
        setFiveDayVisibility(true);
        setWeekendKVisibility(false);
        setMonthKVisibility(false);

        setLlTimeVisibility(false);
        setLlFiveDayVisibility(true);
        setLlDayKVisibility(false);
        setLlWeekendKVisibility(false);
        setLlMonthKVisibility(false);
    }

    public void onClickDayK() {
        setTimeVisibility(false);
        setDayKVisibility(true);
        setFiveDayVisibility(false);
        setWeekendKVisibility(false);
        setMonthKVisibility(false);

        setLlTimeVisibility(false);
        setLlFiveDayVisibility(false);
        setLlDayKVisibility(true);
        setLlWeekendKVisibility(false);
        setLlMonthKVisibility(false);
    }

    public void onClickWeekendK() {
        setTimeVisibility(false);
        setDayKVisibility(false);
        setFiveDayVisibility(false);
        setWeekendKVisibility(true);
        setMonthKVisibility(false);

        setLlTimeVisibility(false);
        setLlFiveDayVisibility(false);
        setLlDayKVisibility(false);
        setLlWeekendKVisibility(true);
        setLlMonthKVisibility(false);
    }

    public void onClickMonthK() {
        setTimeVisibility(false);
        setDayKVisibility(false);
        setFiveDayVisibility(false);
        setWeekendKVisibility(false);
        setMonthKVisibility(true);

        setLlTimeVisibility(false);
        setLlFiveDayVisibility(false);
        setLlDayKVisibility(false);
        setLlWeekendKVisibility(false);
        setLlMonthKVisibility(true);
    }

    @Override
    public PresentationModelChangeSupport getPresentationModelChangeSupport() {
        return changeSupport;
    }

    public StockDetailViewModel(Activity context, String stockId) {
        this.context = context;
        changeSupport = new PresentationModelChangeSupport(this);
        requestStockInfo(stockId);
    }

    /**
     * 通过请求,获取股票的详情信息
     *
     * @param stockId
     */
    private void requestStockInfo(String stockId) {
        /* 模拟数据 */
        baseInfoModel = new StockBaseInfoModel();
        baseInfoModel.setStockName("乐视");
        baseInfoModel.setStockCode("321113");
        baseInfoModel.setIsClose(true);
        baseInfoModel.setCurrentTime("08-07 15:00:00");
        baseInfoModel.setStockPrice("57.5");
        baseInfoModel.setStockAddPrice("+1.59");
        baseInfoModel.setStockAddRange("+3.49%");
        baseInfoModel.setOpen("47.00");
        baseInfoModel.setClose("45.60");
        baseInfoModel.setVolume("40.51万手");
        baseInfoModel.setSwichRate("3.72%");
        baseInfoModel.setHighest("48.95");
        baseInfoModel.setLowest("46.54");
        baseInfoModel.setVolumePrice("19.28亿");
        baseInfoModel.setAllPrice("873亿");
        baseInfoModel.setInner("20.25万");
        baseInfoModel.setOutside("20.26万");
        baseInfoModel.setRatio("233.69");
        baseInfoModel.setSwing("5.29%");
    }

    public boolean isTimeVisibility() {
        return timeVisibility;
    }

    public void setTimeVisibility(boolean timeVisibility) {
        this.timeVisibility = timeVisibility;
        changeSupport.firePropertyChange("timeVisibility");
    }

    public boolean isFiveDayVisibility() {
        return fiveDayVisibility;
    }

    public void setFiveDayVisibility(boolean fiveDayVisibility) {
        this.fiveDayVisibility = fiveDayVisibility;
        changeSupport.firePropertyChange("fiveDayVisibility");

    }

    public boolean isDayKVisibility() {
        return dayKVisibility;
    }

    public void setDayKVisibility(boolean dayKVisibility) {
        this.dayKVisibility = dayKVisibility;
        changeSupport.firePropertyChange("dayKVisibility");
    }

    public boolean isWeekendKVisibility() {
        return weekendKVisibility;
    }

    public void setWeekendKVisibility(boolean weekendKVisibility) {
        this.weekendKVisibility = weekendKVisibility;
        changeSupport.firePropertyChange("weekendKVisibility");
    }

    public boolean isMonthKVisibility() {
        return monthKVisibility;
    }

    public void setMonthKVisibility(boolean monthKVisibility) {
        this.monthKVisibility = monthKVisibility;
        changeSupport.firePropertyChange("monthKVisibility");
    }

    public boolean isLlTimeVisibility() {
        return llTimeVisibility;
    }

    public void setLlTimeVisibility(boolean llTimeVisibility) {
        this.llTimeVisibility = llTimeVisibility;
        changeSupport.firePropertyChange("llTimeVisibility");
    }

    public boolean isLlFiveDayVisibility() {
        return llFiveDayVisibility;
    }

    public void setLlFiveDayVisibility(boolean llFiveDayVisibility) {
        this.llFiveDayVisibility = llFiveDayVisibility;
        changeSupport.firePropertyChange("llFiveDayVisibility");
    }

    public boolean isLlDayKVisibility() {
        return llDayKVisibility;
    }

    public void setLlDayKVisibility(boolean llDayKVisibility) {
        this.llDayKVisibility = llDayKVisibility;
        changeSupport.firePropertyChange("llDayKVisibility");
    }

    public boolean isLlWeekendKVisibility() {
        return llWeekendKVisibility;
    }

    public void setLlWeekendKVisibility(boolean llWeekendKVisibility) {
        this.llWeekendKVisibility = llWeekendKVisibility;
        changeSupport.firePropertyChange("llWeekendKVisibility");
    }

    public boolean isLlMonthKVisibility() {
        return llMonthKVisibility;
    }

    public void setLlMonthKVisibility(boolean llMonthKVisibility) {
        this.llMonthKVisibility = llMonthKVisibility;
        changeSupport.firePropertyChange("llMonthKVisibility");
    }
}
