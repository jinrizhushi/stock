package cn.com.jinrizhushi.stock.stock.view.activity;

import android.os.Bundle;

import org.androidannotations.annotations.EActivity;

import cn.com.jinrizhushi.stock.R;
import cn.com.jinrizhushi.stock.container.BaseActivity;
import cn.com.jinrizhushi.stock.container.Constant;
import cn.com.jinrizhushi.stock.stock.viewmodel.StockDetailViewModel;

/**
 * 描述: 股票详情页
 * 作者: 刘倩
 * 日期: 15/12/11 14:32
 */
@EActivity
public class StockDetialActivity extends BaseActivity{
    StockDetailViewModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Bundle bundle = this.getIntent().getExtras();
//        String stockId = bundle.getString(Constant.STOCK_ID);
        String stockId = "111";
        model = new StockDetailViewModel(this,stockId);
        initializeContentView(R.layout.activity_stock_detail,model);
    }
}
