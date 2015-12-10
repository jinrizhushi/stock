package cn.com.jinrizhushi.stock.container;

import android.app.Activity;
import android.view.View;

import org.robobinding.ViewBinder;
import org.robobinding.binder.BinderFactory;

/**
 * 描述: 基类
 * 作者: 刘倩
 * 日期: 15/12/9 22:49
 */
public class BaseActivity extends Activity{
    public void initializeContentView(int layoutId, Object presentationModel) {
        ViewBinder viewBinder = createViewBinder();
        View rootView = viewBinder.inflateAndBind(layoutId, presentationModel);
        setContentView(rootView);
    }

    public ViewBinder createViewBinder() {
        BinderFactory binderFactory = getReusableBinderFactory();
        return binderFactory.createViewBinder(this);
    }

    private BinderFactory getReusableBinderFactory() {
        BinderFactory binderFactory = getStockApplication().getReusableBinderFactory();
        return binderFactory;
    }

    private StockApplication getStockApplication() {
        return (StockApplication)getApplicationContext();
    }
}
