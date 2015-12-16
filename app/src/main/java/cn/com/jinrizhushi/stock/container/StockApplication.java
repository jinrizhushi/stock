package cn.com.jinrizhushi.stock.container;

import android.app.Application;
import android.widget.TextView;

import org.robobinding.binder.BinderFactory;
import org.robobinding.binder.BinderFactoryBuilder;
import org.robobinding.customviewbinding.CustomViewBinding;

import cn.com.jinrizhushi.stock.util.bind.stockkline.StockKLineBinding;
import cn.com.jinrizhushi.stock.util.bind.stocktime.StockTimeBinding;
import cn.com.jinrizhushi.stock.util.bind.textview.TextViewBinding;
import cn.com.jinrizhushi.stock.util.customstockview.StockFiveDayView;
import cn.com.jinrizhushi.stock.util.customstockview.StockMinuteView;
import cn.com.jinrizhushi.stock.util.customstockview.StockTimeSharingView;
import cn.com.jinrizhushi.stock.util.customstockview.StockView;
import cn.com.jinrizhushi.stock.util.service.volley.RequestManager;
import cn.com.jinrizhushi.stock.util.bind.stockfiveday.StockFiveDayBinding;
import cn.com.jinrizhushi.stock.util.bind.stockminute.StockMinuteBinding;

/**
 * 描述: 全局变量类
 * 作者: 刘倩
 * 日期: 15/12/3 18:00
 */
public class StockApplication extends Application{
    private BinderFactory reusableBinderFactory;
    public static StockApplication globalContext;

    @Override
    public void onCreate() {
        super.onCreate();
        globalContext = this;
        reusableBinderFactory = new BinderFactoryBuilder()
                .add(CustomViewBinding.forView(StockTimeSharingView.class, new StockTimeBinding()))
//                .add(CustomViewBinding.forView(TextView.class, new TextViewBinding()))
                .add(CustomViewBinding.forView(StockView.class, new StockKLineBinding()))
                .add(CustomViewBinding.forView(StockFiveDayView.class,new StockFiveDayBinding()))
                .add(CustomViewBinding.forView(StockMinuteView.class,new StockMinuteBinding()))
                .build();
        RequestManager.init(this);
    }

    public BinderFactory getReusableBinderFactory() {
        return reusableBinderFactory;
    }

}
