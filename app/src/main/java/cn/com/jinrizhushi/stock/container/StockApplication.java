package cn.com.jinrizhushi.stock.container;

import android.app.Application;

import org.robobinding.binder.BinderFactory;
import org.robobinding.binder.BinderFactoryBuilder;
import org.robobinding.customviewbinding.CustomViewBinding;

import cn.com.jinrizhushi.stock.util.bind.stock.StockTimeBinding;
import cn.com.jinrizhushi.stock.util.customstockview.StockTimeSharingView;
import cn.com.jinrizhushi.stock.util.service.volley.RequestManager;

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
                .build();
        RequestManager.init(this);
    }

    public BinderFactory getReusableBinderFactory() {
        return reusableBinderFactory;
    }

}
