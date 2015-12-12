package cn.com.jinrizhushi.stock.stock.viewmodel;

import android.app.Activity;
import android.content.Context;

import org.robobinding.annotation.PresentationModel;
import org.robobinding.presentationmodel.HasPresentationModelChangeSupport;
import org.robobinding.presentationmodel.PresentationModelChangeSupport;

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
     * 返回按钮的设置
     */
    public void goback() {
        context.finish();
    }

    public String getStockNameAndCode() {
//        return getStockName() + "    (" + getStockCode() + ")"
        return "乐视  (300104)";
    }

    public String getIsOpenAndDate() {
//        if (isClose) {
//            return "已休市  " + getCurrentTime();
//        } else {
//            return "未休市  " + getCurrentTime();
//        }
        return "已休市 08-07 15:00:00 ";


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

    @Override
    public PresentationModelChangeSupport getPresentationModelChangeSupport() {
        return changeSupport;
    }

    public StockDetailViewModel(Activity context) {
        this.context = context;
        changeSupport = new PresentationModelChangeSupport(this);
    }
}
