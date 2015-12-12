package cn.com.jinrizhushi.stock.stock.view.activity;

import android.app.Activity;
import android.os.Bundle;

import org.androidannotations.annotations.EActivity;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cn.com.jinrizhushi.stock.R;
import cn.com.jinrizhushi.stock.container.BaseActivity;
import cn.com.jinrizhushi.stock.stock.model.StockMarketIndexItemModel;
import cn.com.jinrizhushi.stock.stock.model.StockMarketIndexModel;
import cn.com.jinrizhushi.stock.stock.model.StockModel;
import cn.com.jinrizhushi.stock.stock.viewmodel.StockKLineViewModel;
import cn.com.jinrizhushi.stock.stock.viewmodel.StockMarketIndexViewModel;
import cn.com.jinrizhushi.stock.stock.viewmodel.StockViewModel;
import cn.com.jinrizhushi.stock.util.customstockview.StockTimeSharingView;
import cn.com.jinrizhushi.stock.util.customstockview.StockView;

/**
 * 描述: 股票的界面
 * 作者: 刘倩
 * 日期: 15/11/30 17:38
 */
@EActivity
public class StockActivity extends BaseActivity {
    private StockViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initMVVMView();
    }

    public void initMVVMView() {
        viewModel = new StockViewModel(this);
        initializeContentView(R.layout.ativity_stock, viewModel);
    }
}
