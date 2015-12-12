package cn.com.jinrizhushi.stock.util.bind.stocktime;


import org.robobinding.viewattribute.property.OneWayPropertyViewAttribute;

import cn.com.jinrizhushi.stock.stock.viewmodel.StockMarketIndexViewModel;
import cn.com.jinrizhushi.stock.util.customstockview.StockTimeSharingView;


/**
 * 描述: 分时图的数据
 * 作者: 刘倩
 * 日期: 15/12/8 17:04
 */

public class StockTimeAttribute implements OneWayPropertyViewAttribute<StockTimeSharingView,StockMarketIndexViewModel> {
    @Override
    public void updateView(StockTimeSharingView view, StockMarketIndexViewModel model) {
        view.setModel(model);
    }
}