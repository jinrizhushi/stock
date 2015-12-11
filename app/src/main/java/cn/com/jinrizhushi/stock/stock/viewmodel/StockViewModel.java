package cn.com.jinrizhushi.stock.stock.viewmodel;

import android.content.Context;

import org.robobinding.annotation.PresentationModel;
import org.robobinding.presentationmodel.HasPresentationModelChangeSupport;
import org.robobinding.presentationmodel.PresentationModelChangeSupport;

import java.util.ArrayList;
import java.util.List;

import cn.com.jinrizhushi.stock.stock.model.StockMarketIndexItemModel;
import cn.com.jinrizhushi.stock.stock.model.StockMarketIndexModel;

/**
 * 描述: 分时图的视图模型类
 * 作者: 刘倩
 * 日期: 15/12/9 22:57
 */
@PresentationModel
public class StockViewModel implements HasPresentationModelChangeSupport {
    private Context context;

    private PresentationModelChangeSupport changeSupport;

    public StockMarketIndexViewModel getStockTime(){
        StockMarketIndexModel marketInfo = new StockMarketIndexModel();
        marketInfo.setMarketIndexHigh("3319");
        marketInfo.setMarketIndexCenter("3183");
        marketInfo.setMarketIndexLow("3080");
        marketInfo.setQuoteChangeHigh("3");
        List<StockMarketIndexItemModel> listMarketIndex = new ArrayList<>();
        StockMarketIndexItemModel index0 = new StockMarketIndexItemModel("3145","09:30");
        StockMarketIndexItemModel index1 = new StockMarketIndexItemModel("3183","10:30");
        StockMarketIndexItemModel index2 = new StockMarketIndexItemModel("3165","11:00");
        StockMarketIndexItemModel index3 = new StockMarketIndexItemModel("3173","11:30");
        StockMarketIndexItemModel index4 = new StockMarketIndexItemModel("3162","13:31");
        StockMarketIndexItemModel index5 = new StockMarketIndexItemModel("3185","13:40");
        StockMarketIndexItemModel index6 = new StockMarketIndexItemModel("3178","13:50");
        StockMarketIndexItemModel index7 = new StockMarketIndexItemModel("3193","14:00");
        StockMarketIndexItemModel index8 = new StockMarketIndexItemModel("3182","14:50");
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
        return indexViewModel;
    }


    @Override
    public PresentationModelChangeSupport getPresentationModelChangeSupport() {
        return changeSupport;
    }

    public StockViewModel(Context context) {
        this.context = context;
        changeSupport = new PresentationModelChangeSupport(this);
    }

}