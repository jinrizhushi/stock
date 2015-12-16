package cn.com.jinrizhushi.stock.util.bind.stockminute;



import org.robobinding.viewattribute.property.OneWayPropertyViewAttribute;

import cn.com.jinrizhushi.stock.stock.viewmodel.StockFiveDayViewModel;
import cn.com.jinrizhushi.stock.util.customstockview.StockFiveDayView;
import cn.com.jinrizhushi.stock.util.customstockview.StockMinuteView;


/**
 * 描述: 5日图的属性
 * 作者: 刘倩
 * 日期: 15/12/12 17:04
 */

public class StockMinuteAttribute implements OneWayPropertyViewAttribute<StockMinuteView,StockFiveDayViewModel> {
    @Override
    public void updateView(StockMinuteView view, StockFiveDayViewModel model) {
        view.setViewModel(model);
    }
}