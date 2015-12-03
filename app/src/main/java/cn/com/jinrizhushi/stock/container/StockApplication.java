package cn.com.jinrizhushi.stock.container;

import android.app.Application;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
/**
 * 描述: 全局变量类
 * 作者: 刘倩
 * 日期: 15/12/3 18:00
 */
public class StockApplication extends Application{
    private static StockApplication sInstance;

    private RequestQueue mRequestQueue;

    @Override
    public void onCreate() {
        super.onCreate();

        mRequestQueue = Volley.newRequestQueue(this);
        sInstance = this;
    }

    public synchronized static StockApplication getInstance() {
        return sInstance;
    }

    public RequestQueue getRequestQueue() {
        return mRequestQueue;
    }
}
