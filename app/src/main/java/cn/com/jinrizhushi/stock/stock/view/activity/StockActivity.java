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
    private StockTimeSharingView stockTimeView;
    private StockView stockView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        initMVVMView();
        initView();
    }
    public void initMVVMView(){
        viewModel = new StockViewModel(this);
        initializeContentView(R.layout.ativity_stock, viewModel);
    }
    public void initView(){
        setContentView(R.layout.ativity_stock);
        initStockViewData();
        initStockTimeData();
    }
   public void  initStockViewData(){
       stockView = (StockView)findViewById(R.id.sv_stock);
        List<StockModel> listKline = new ArrayList<>();
        StockModel sm = new StockModel();
        for (int i =0;i<1;i++){
            sm.setDate("2015-12-01");
            sm.setOpen("50.80");
            sm.setHigh("51.48");
            sm.setLow("50.01");
            sm.setClose("53.84");
            sm.setVolume("4910600");
            sm.setAdjClose("50.84");
            listKline.add(sm);

            StockModel sm1 = new StockModel();
            sm1.setDate("2015-11-30");
            sm1.setOpen("51.30");
            sm1.setHigh("51.54");
            sm1.setLow("48.80");
            sm1.setClose("49.99");
            sm1.setVolume("8966900");
            sm1.setAdjClose("49.99");
            listKline.add(sm1);

            StockModel sm2 = new StockModel();
            sm2.setDate("2015-11-27");
            sm2.setOpen("52.85");
            sm2.setHigh("52.85");
            sm2.setLow("50.38");
            sm2.setClose("51.28");
            sm2.setVolume("8966900");
            sm2.setAdjClose("51.28");
            listKline.add(sm2);

            StockModel sm3 = new StockModel();
            sm3.setDate("2015-11-26");
            sm3.setOpen("53.51");
            sm3.setHigh("53.78");
            sm3.setLow("52.65");
            sm3.setClose("52.82");
            sm3.setVolume("5951500");
            sm3.setAdjClose("52.82");
            listKline.add(sm3);

            StockModel sm4 = new StockModel();
            sm4.setDate("2015-11-25");
            sm4.setOpen("52.80");
            sm4.setHigh("53.56");
            sm4.setLow("52.60");
            sm4.setClose("53.42");
            sm4.setVolume("4196300");
            sm4.setAdjClose("53.42");
            listKline.add(sm4);

            StockModel sm5 = new StockModel();
            sm5.setDate("2015-11-24");
            sm5.setOpen("53.61");
            sm5.setHigh("52.79");
            sm5.setLow("52.50");
            sm5.setClose("52.98");
            sm5.setVolume("4255800");
            sm5.setAdjClose("52.98");
            listKline.add(sm5);

            StockModel sm6 = new StockModel();
            sm6.setDate("2015-11-23");
            sm6.setOpen("55.00");
            sm6.setHigh("53.80");
            sm6.setLow("53.88");
            sm6.setClose("53.88");
            sm6.setVolume("3252300");
            sm6.setAdjClose("53.88");
            listKline.add(sm6);

            StockModel sm7 = new StockModel();
            sm7.setDate("2015-11-20");
            sm7.setOpen("54.65");
            sm7.setHigh("55.26");
            sm7.setLow("54.20");
            sm7.setClose("54.93");
            sm7.setVolume("3673800");
            sm7.setAdjClose("54.93");
            listKline.add(sm7);

            StockModel sm8 = new StockModel();
            sm8.setDate("2015-11-19");
            sm8.setOpen("53.84");
            sm8.setHigh("54.70");
            sm8.setLow("53.51");
            sm8.setClose("54.60");
            sm8.setVolume("2989300");
            sm8.setAdjClose("54.60");
            listKline.add(sm8);

            StockModel sm9 = new StockModel();
            sm9.setDate("2015-11-18");
            sm9.setOpen("53.39");
            sm9.setHigh("54.34");
            sm9.setLow("54.20");
            sm9.setClose("53.73");
            sm9.setVolume("3737000");
            sm9.setAdjClose("53.75");
            listKline.add(sm9);
        }

        StockKLineViewModel model = new StockKLineViewModel(listKline);
        stockView.setModel(model);
    }

    public void initStockTimeData(){
        stockTimeView = (StockTimeSharingView) findViewById(R.id.sv_stock_time);
        StockMarketIndexModel marketInfo = new StockMarketIndexModel();
        marketInfo.setMarketIndexHigh("3319");
        marketInfo.setMarketIndexCenter("3183");
        marketInfo.setMarketIndexLow("3080");
        marketInfo.setQuoteChangeHigh("3");
        List<StockMarketIndexItemModel> listMarketIndex = new ArrayList<>();
        StockMarketIndexItemModel index0 = new StockMarketIndexItemModel("3145", "09:30");
        StockMarketIndexItemModel index1 = new StockMarketIndexItemModel("3183", "10:30");
        StockMarketIndexItemModel index2 = new StockMarketIndexItemModel("3165", "11:00");
        StockMarketIndexItemModel index3 = new StockMarketIndexItemModel("3173", "11:30");
        StockMarketIndexItemModel index4 = new StockMarketIndexItemModel("3162", "13:31");
        StockMarketIndexItemModel index5 = new StockMarketIndexItemModel("3185", "13:40");
        StockMarketIndexItemModel index6 = new StockMarketIndexItemModel("3178", "13:50");
        StockMarketIndexItemModel index7 = new StockMarketIndexItemModel("3193", "14:00");
        StockMarketIndexItemModel index8 = new StockMarketIndexItemModel("3182", "14:50");
        listMarketIndex.add(index0);
        listMarketIndex.add(index1);
        listMarketIndex.add(index2);
        listMarketIndex.add(index3);
        listMarketIndex.add(index4);
        listMarketIndex.add(index5);
        listMarketIndex.add(index6);
        listMarketIndex.add(index7);
        listMarketIndex.add(index8);
        marketInfo.setListMarketIndex(listMarketIndex);
        StockMarketIndexViewModel indexViewModel = new StockMarketIndexViewModel(marketInfo);
        stockTimeView.setMarketIndexViewModel(indexViewModel);

    }

}
