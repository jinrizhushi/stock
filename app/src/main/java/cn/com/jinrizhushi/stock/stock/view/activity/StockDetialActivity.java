package cn.com.jinrizhushi.stock.stock.view.activity;

import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;

import org.androidannotations.annotations.AfterExtras;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import cn.com.jinrizhushi.stock.R;
import cn.com.jinrizhushi.stock.container.BaseActivity;
import cn.com.jinrizhushi.stock.container.Constant;
import cn.com.jinrizhushi.stock.stock.viewmodel.StockDetailViewModel;
import cn.com.jinrizhushi.stock.util.customnormalview.CustomScrollView;

/**
 * 描述: 股票详情页
 * 作者: 刘倩
 * 日期: 15/12/11 14:32
 */
@EActivity
public class StockDetialActivity extends BaseActivity implements CustomScrollView.OnScrollListener {
    StockDetailViewModel model;
    @ViewById(R.id.ll_news_top)
    LinearLayout llTop;
    @ViewById(R.id.ll_news_middle)
    LinearLayout llMiddle;
    @ViewById(R.id.sv_custom)
    CustomScrollView scrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Bundle bundle = this.getIntent().getExtras();
//        String stockId = bundle.getString(Constant.STOCK_ID);
        String stockId = "111";
        model = new StockDetailViewModel(this, stockId);
        initializeContentView(R.layout.activity_stock_detail, model);
    }
    @AfterViews
    void setData() {
        scrollView.setOnScrollListener(this);
        findViewById(R.id.parent_layout).getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

            @Override
            public void onGlobalLayout() {
                onScroll(scrollView.getScrollY());
            }
        });
    }

    /**
     * 回调方法， 返回CustomScrollView滑动的Y方向距离
     *
     * @param scrollY
     */
    @Override
    public void onScroll(int scrollY) {
        int mBuyLayout2ParentTop = Math.max(scrollY, llMiddle.getTop());
        llTop.layout(0, mBuyLayout2ParentTop, llTop.getWidth(), mBuyLayout2ParentTop + llTop.getHeight());
    }
}
