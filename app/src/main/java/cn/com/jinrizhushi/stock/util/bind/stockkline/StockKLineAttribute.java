package cn.com.jinrizhushi.stock.util.bind.stockkline;


import org.robobinding.viewattribute.property.OneWayPropertyViewAttribute;

import cn.com.jinrizhushi.stock.stock.viewmodel.StockKLineViewModel;
import cn.com.jinrizhushi.stock.util.customstockview.StockView;


/**
 * 描述: k线图的属性
 * 作者: 刘倩
 * 日期: 15/12/12 17:04
 */

public class StockKLineAttribute implements OneWayPropertyViewAttribute<StockView,StockKLineViewModel> {
    @Override
    public void updateView(StockView view, StockKLineViewModel model) {
        view.setModel(model);
    }
}