package cn.com.jinrizhushi.stock.stock.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import org.robobinding.annotation.ItemPresentationModel;
import org.robobinding.annotation.PresentationModel;
import org.robobinding.presentationmodel.HasPresentationModelChangeSupport;
import org.robobinding.presentationmodel.PresentationModelChangeSupport;

import java.util.ArrayList;
import java.util.List;
import java.util.SimpleTimeZone;

import cn.com.jinrizhushi.stock.stock.model.StockBaseInfoModel;
import cn.com.jinrizhushi.stock.stock.model.StockFiveDayItemModel;
import cn.com.jinrizhushi.stock.stock.model.StockFiveDayModel;
import cn.com.jinrizhushi.stock.stock.model.StockFiveDayItemModel;
import cn.com.jinrizhushi.stock.stock.model.StockModel;
import cn.com.jinrizhushi.stock.stock.model.StockSellerModel;

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
     * 是否显示新闻
     */
    private boolean newsVisibility = true;
    /**
     * 是否显示公告
     */
    private boolean noticeVisibility = false;
    /**
     * 是否显示研报
     */
    private boolean studyVisibility = false;
    /**
     * 是否显示公司简介
     */
    private boolean companyVisibility = false;


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

    public void onClickNews() {
        setNewsVisibility(true);
        setNoticeVisibility(false);
        setStudyVisibility(false);
        setCompanyVisibility(false);
    }

    public void onClickNotice() {
        setNewsVisibility(false);
        setNoticeVisibility(true);
        setStudyVisibility(false);
        setCompanyVisibility(false);
    }

    public void onClickStudy() {
        setNewsVisibility(false);
        setNoticeVisibility(false);
        setStudyVisibility(true);
        setCompanyVisibility(false);
    }

    public void onClickCompany() {
        setNewsVisibility(false);
        setNoticeVisibility(false);
        setStudyVisibility(false);
        setCompanyVisibility(true);
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
        baseInfoModel.setOpen("47.");
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

    public StockKLineViewModel getStockKLine() {
        List<StockModel> listKline = new ArrayList<>();
        StockModel sm = new StockModel();
        for (int i = 0; i < 5; i++) {
            StockModel sm3 = new StockModel();
            sm3.setDate("2015-11-26");
            sm3.setOpen("53.51");
            sm3.setHigh("53.78");
            sm3.setLow("52.65");
            sm3.setClose("52.82");
            sm3.setVolume("59515");
            sm3.setAdjClose("52.82");
            listKline.add(sm3);

            StockModel sm4 = new StockModel();
            sm4.setDate("2015-11-25");
            sm4.setOpen("52.80");
            sm4.setHigh("53.56");
            sm4.setLow("52.60");
            sm4.setClose("53.42");
            sm4.setVolume("41963");
            sm4.setAdjClose("53.42");
            listKline.add(sm4);

            StockModel sm5 = new StockModel();
            sm5.setDate("2015-11-24");
            sm5.setOpen("53.61");
            sm5.setHigh("52.79");
            sm5.setLow("52.50");
            sm5.setClose("52.98");
            sm5.setVolume("42558");
            sm5.setAdjClose("52.98");
            listKline.add(sm5);
            sm.setDate("2015-12-01");
            sm.setOpen("50.80");
            sm.setHigh("51.48");
            sm.setLow("50.01");
            sm.setClose("53.84");
            sm.setVolume("49106");
            sm.setAdjClose("50.84");
            listKline.add(sm);

            StockModel sm1 = new StockModel();
            sm1.setDate("2015-11-30");
            sm1.setOpen("51.30");
            sm1.setHigh("51.54");
            sm1.setLow("48.80");
            sm1.setClose("49.99");
            sm1.setVolume("89669");
            sm1.setAdjClose("49.99");
            listKline.add(sm1);

            StockModel sm2 = new StockModel();
            sm2.setDate("2015-11-27");
            sm2.setOpen("52.85");
            sm2.setHigh("52.85");
            sm2.setLow("50.38");
            sm2.setClose("51.28");
            sm2.setVolume("89669");
            sm2.setAdjClose("51.28");
            listKline.add(sm2);


            StockModel sm6 = new StockModel();
            sm6.setDate("2015-11-23");
            sm6.setOpen("55.");
            sm6.setHigh("53.80");
            sm6.setLow("53.88");
            sm6.setClose("53.88");
            sm6.setVolume("32523");
            sm6.setAdjClose("53.88");
            listKline.add(sm6);

            StockModel sm7 = new StockModel();
            sm7.setDate("2015-11-20");
            sm7.setOpen("54.65");
            sm7.setHigh("55.26");
            sm7.setLow("54.20");
            sm7.setClose("54.93");
            sm7.setVolume("36738");
            sm7.setAdjClose("54.93");
            listKline.add(sm7);

            StockModel sm8 = new StockModel();
            sm8.setDate("2015-11-19");
            sm8.setOpen("53.84");
            sm8.setHigh("54.70");
            sm8.setLow("53.51");
            sm8.setClose("54.60");
            sm8.setVolume("29893");
            sm8.setAdjClose("54.60");
            listKline.add(sm8);

            StockModel sm9 = new StockModel();
            sm9.setDate("2015-11-18");
            sm9.setOpen("53.39");
            sm9.setHigh("54.34");
            sm9.setLow("54.20");
            sm9.setClose("53.73");
            sm9.setVolume("37370");
            sm9.setAdjClose("53.75");
            listKline.add(sm9);
        }
        StockKLineViewModel model = new StockKLineViewModel(listKline);
        return model;
    }

    public StockKLineViewModel getStockWeekedKLine() {
        List<StockModel> listKline = new ArrayList<>();
        StockModel sm = new StockModel();
        for (int i = 0; i < 4; i++) {
            StockModel sm3 = new StockModel();
            sm3.setDate("2015-11-26");
            sm3.setOpen("53.51");
            sm3.setHigh("53.78");
            sm3.setLow("52.65");
            sm3.setClose("52.82");
            sm3.setVolume("59515");
            sm3.setAdjClose("52.82");
            listKline.add(sm3);

            StockModel sm4 = new StockModel();
            sm4.setDate("2015-11-25");
            sm4.setOpen("52.80");
            sm4.setHigh("53.56");
            sm4.setLow("52.60");
            sm4.setClose("53.42");
            sm4.setVolume("41963");
            sm4.setAdjClose("53.42");
            listKline.add(sm4);

            StockModel sm5 = new StockModel();
            sm5.setDate("2015-11-24");
            sm5.setOpen("53.61");
            sm5.setHigh("52.79");
            sm5.setLow("52.50");
            sm5.setClose("52.98");
            sm5.setVolume("42558");
            sm5.setAdjClose("52.98");
            listKline.add(sm5);

            sm.setDate("2015-12-01");
            sm.setOpen("50.80");
            sm.setHigh("51.48");
            sm.setLow("50.01");
            sm.setClose("53.84");
            sm.setVolume("49106");
            sm.setAdjClose("50.84");
            listKline.add(sm);

            StockModel sm1 = new StockModel();
            sm1.setDate("2015-11-30");
            sm1.setOpen("51.30");
            sm1.setHigh("51.54");
            sm1.setLow("48.80");
            sm1.setClose("49.99");
            sm1.setVolume("89669");
            sm1.setAdjClose("49.99");
            listKline.add(sm1);

            StockModel sm2 = new StockModel();
            sm2.setDate("2015-11-27");
            sm2.setOpen("52.85");
            sm2.setHigh("52.85");
            sm2.setLow("50.38");
            sm2.setClose("51.28");
            sm2.setVolume("89669");
            sm2.setAdjClose("51.28");
            listKline.add(sm2);


            StockModel sm6 = new StockModel();
            sm6.setDate("2015-11-23");
            sm6.setOpen("55.");
            sm6.setHigh("53.80");
            sm6.setLow("53.88");
            sm6.setClose("53.88");
            sm6.setVolume("32523");
            sm6.setAdjClose("53.88");
            listKline.add(sm6);

            StockModel sm7 = new StockModel();
            sm7.setDate("2015-11-20");
            sm7.setOpen("54.65");
            sm7.setHigh("55.26");
            sm7.setLow("54.20");
            sm7.setClose("54.93");
            sm7.setVolume("36738");
            sm7.setAdjClose("54.93");
            listKline.add(sm7);

            StockModel sm8 = new StockModel();
            sm8.setDate("2015-11-19");
            sm8.setOpen("53.84");
            sm8.setHigh("54.70");
            sm8.setLow("53.51");
            sm8.setClose("54.60");
            sm8.setVolume("29893");
            sm8.setAdjClose("54.60");
            listKline.add(sm8);

            StockModel sm9 = new StockModel();
            sm9.setDate("2015-11-18");
            sm9.setOpen("53.39");
            sm9.setHigh("54.34");
            sm9.setLow("54.20");
            sm9.setClose("53.73");
            sm9.setVolume("37370");
            sm9.setAdjClose("53.75");
            listKline.add(sm9);
        }
        StockKLineViewModel model = new StockKLineViewModel(listKline);
        return model;
    }
    public StockFiveDayViewModel  getStockFiveDay(){
        StockFiveDayViewModel model = new StockFiveDayViewModel();
        StockFiveDayModel fiveDayModel = new StockFiveDayModel();
        fiveDayModel.setStockIndexMaxValue("15.00");
        fiveDayModel.setStockIndexMinValue("2.35");
        List<String> list = new ArrayList<>();
        list.add("12-10");
        list.add("12-11");
        list.add("12-14");
        list.add("12-15");
        list.add("12-16");
        fiveDayModel.setListDate(list);
        fiveDayModel.setStockIndexCurrentValue("6.75");
        List<StockFiveDayItemModel> listFiveDayItemModel=new ArrayList<>();
        for(int i= 0;i<list.size();i++){
            String date = list.get(i);
            for (int k = 1;k<=12;k++){
                String high="7.90" ;
                String vlome = "280";
                if(k%2==0){
                    high=String.valueOf(Float.parseFloat(high)-(k/2)/4);
                    vlome=String.valueOf(Float.parseFloat(vlome)-(k/2)/4*30);
                }else if(k%3==0){
                    high=String.valueOf((k/3)*1.5+Float.parseFloat(high));
                    vlome=String.valueOf((k/3)*1.5*30+Float.parseFloat(vlome));
                }

                StockFiveDayItemModel itemModel11 = new StockFiveDayItemModel(high,date+"  "+k,vlome);
                listFiveDayItemModel.add(itemModel11);
            }
        }
        fiveDayModel.setListFiveDayItemModel(listFiveDayItemModel);
        model.setStockFiveDayModel(fiveDayModel);
        return model;
    }
    public StockFiveDayViewModel  getStockMinute(){
        StockFiveDayViewModel model = new StockFiveDayViewModel();
        StockFiveDayModel fiveDayModel = new StockFiveDayModel();
        fiveDayModel.setStockIndexMaxValue("15.00");
        fiveDayModel.setStockIndexMinValue("2.35");
       
        List<StockFiveDayItemModel> listFiveDayItemModel=new ArrayList<>();
        
        StockFiveDayItemModel index0 = new StockFiveDayItemModel("4.00","09:30","298");
        StockFiveDayItemModel index1 = new StockFiveDayItemModel("7.00","10:00","234");
        StockFiveDayItemModel index2 = new StockFiveDayItemModel("6.00","10:30","345");
        StockFiveDayItemModel index3 = new StockFiveDayItemModel("5.00","11:00","332");
        StockFiveDayItemModel index4 = new StockFiveDayItemModel("8.00","13:30","123");
        StockFiveDayItemModel index5 = new StockFiveDayItemModel("7.00","14:00","344");
        StockFiveDayItemModel index6 = new StockFiveDayItemModel("6.00","14:30","323");
        StockFiveDayItemModel index7 = new StockFiveDayItemModel("4.00","15:00","321");
        listFiveDayItemModel.add(index0);
        listFiveDayItemModel.add(index1);
        listFiveDayItemModel.add(index2);
        listFiveDayItemModel.add(index3);
        listFiveDayItemModel.add(index4);
        listFiveDayItemModel.add(index5);
        listFiveDayItemModel.add(index6);
        listFiveDayItemModel.add(index7);
        fiveDayModel.setListFiveDayItemModel(listFiveDayItemModel);
        model.setStockFiveDayModel(fiveDayModel);
        return model;
    }

    public StockKLineViewModel getStockMonthKLine() {
        List<StockModel> listKline = new ArrayList<>();
        StockModel sm = new StockModel();
        for (int i = 0; i < 3; i++) {
            StockModel sm3 = new StockModel();
            sm3.setDate("2015-11-26");
            sm3.setOpen("53.51");
            sm3.setHigh("53.78");
            sm3.setLow("52.65");
            sm3.setClose("52.82");
            sm3.setVolume("59515");
            sm3.setAdjClose("52.82");
            listKline.add(sm3);

            StockModel sm4 = new StockModel();
            sm4.setDate("2015-11-25");
            sm4.setOpen("52.80");
            sm4.setHigh("53.56");
            sm4.setLow("52.60");
            sm4.setClose("53.42");
            sm4.setVolume("41963");
            sm4.setAdjClose("53.42");
            listKline.add(sm4);

            StockModel sm5 = new StockModel();
            sm5.setDate("2015-11-24");
            sm5.setOpen("53.61");
            sm5.setHigh("52.79");
            sm5.setLow("52.50");
            sm5.setClose("52.98");
            sm5.setVolume("42558");
            sm5.setAdjClose("52.98");
            listKline.add(sm5);
            sm.setDate("2015-12-01");
            sm.setOpen("50.80");
            sm.setHigh("51.48");
            sm.setLow("50.01");
            sm.setClose("53.84");
            sm.setVolume("49106");
            sm.setAdjClose("50.84");
            listKline.add(sm);

            StockModel sm1 = new StockModel();
            sm1.setDate("2015-11-30");
            sm1.setOpen("51.30");
            sm1.setHigh("51.54");
            sm1.setLow("48.80");
            sm1.setClose("49.99");
            sm1.setVolume("89669");
            sm1.setAdjClose("49.99");
            listKline.add(sm1);

            StockModel sm2 = new StockModel();
            sm2.setDate("2015-11-27");
            sm2.setOpen("52.85");
            sm2.setHigh("52.85");
            sm2.setLow("50.38");
            sm2.setClose("51.28");
            sm2.setVolume("89669");
            sm2.setAdjClose("51.28");
            listKline.add(sm2);


            StockModel sm6 = new StockModel();
            sm6.setDate("2015-11-23");
            sm6.setOpen("55.");
            sm6.setHigh("53.80");
            sm6.setLow("53.88");
            sm6.setClose("53.88");
            sm6.setVolume("32523");
            sm6.setAdjClose("53.88");
            listKline.add(sm6);

            StockModel sm7 = new StockModel();
            sm7.setDate("2015-11-20");
            sm7.setOpen("54.65");
            sm7.setHigh("55.26");
            sm7.setLow("54.20");
            sm7.setClose("54.93");
            sm7.setVolume("36738");
            sm7.setAdjClose("54.93");
            listKline.add(sm7);

            StockModel sm8 = new StockModel();
            sm8.setDate("2015-11-19");
            sm8.setOpen("53.84");
            sm8.setHigh("54.70");
            sm8.setLow("53.51");
            sm8.setClose("54.60");
            sm8.setVolume("29893");
            sm8.setAdjClose("54.60");
            listKline.add(sm8);

            StockModel sm9 = new StockModel();
            sm9.setDate("2015-11-18");
            sm9.setOpen("53.39");
            sm9.setHigh("54.34");
            sm9.setLow("54.20");
            sm9.setClose("53.73");
            sm9.setVolume("37370");
            sm9.setAdjClose("53.75");
            listKline.add(sm9);
        }
        StockKLineViewModel model = new StockKLineViewModel(listKline);
        return model;
    }
    @ItemPresentationModel(value = StockSellerOutItemViewModel.class)
    public ArrayList<StockSellerModel> getSellOutModels() {
        ArrayList<StockSellerModel> list = new ArrayList<>();
        list.add(new StockSellerModel("卖5","8.65", 0xFFD8000,"1365"));
        list.add(new StockSellerModel("卖4","8.64", 0xFFD8000,"858"));
        list.add(new StockSellerModel("卖3","8.63", 0xFF8F8F8F,"499"));
        list.add(new StockSellerModel("卖2","8.62", 0xFF2BA800,"167"));
        list.add(new StockSellerModel("卖1","8.61", 0xFF2BA800,"34"));
        return list;
    }
    @ItemPresentationModel(value = StockSellerIntItemViewModel.class)
    public ArrayList<StockSellerModel> getSellInModels() {
        ArrayList<StockSellerModel> list = new ArrayList<>();
        list.add(new StockSellerModel("买1","8.60", 0xFF2BA800,"53"));
        list.add(new StockSellerModel("买2","8.54", 0xFF2BA800,"111"));
        list.add(new StockSellerModel("买3","8.53", 0xFF2BA800,"42"));
        list.add(new StockSellerModel("买4","8.52", 0xFF2BA800,"111"));
        list.add(new StockSellerModel("买5","8.51", 0xFF2BA800,"143"));
        return list;
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

    public boolean isNewsVisibility() {
        return newsVisibility;
    }

    public void setNewsVisibility(boolean newsVisibility) {
        this.newsVisibility = newsVisibility;
        changeSupport.firePropertyChange("newsVisibility");

    }

    public boolean isNoticeVisibility() {
        return noticeVisibility;
    }

    public void setNoticeVisibility(boolean noticeVisibility) {
        this.noticeVisibility = noticeVisibility;
        changeSupport.firePropertyChange("noticeVisibility");

    }

    public boolean isStudyVisibility() {
        return studyVisibility;
    }

    public void setStudyVisibility(boolean studyVisibility) {
        this.studyVisibility = studyVisibility;
        changeSupport.firePropertyChange("studyVisibility");

    }

    public boolean isCompanyVisibility() {
        return companyVisibility;
    }

    public void setCompanyVisibility(boolean companyVisibility) {
        this.companyVisibility = companyVisibility;
        changeSupport.firePropertyChange("companyVisibility");
    }
}
