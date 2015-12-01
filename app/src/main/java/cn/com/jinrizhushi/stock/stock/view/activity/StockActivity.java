package cn.com.jinrizhushi.stock.stock.view.activity;

import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import cn.com.jinrizhushi.stock.R;
import cn.com.jinrizhushi.stock.util.customstockview.StockView;

/**
 * 描述: 股票的界面
 * 作者: 刘倩
 * 日期: 15/11/30 17:38
 */
public class StockActivity extends Activity {
    private StockView stockView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ativity_stock);
        stockView = (StockView)findViewById(R.id.sv_stock);

    }
}
