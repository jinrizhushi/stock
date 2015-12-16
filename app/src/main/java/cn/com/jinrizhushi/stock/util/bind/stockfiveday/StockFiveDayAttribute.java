package cn.com.jinrizhushi.stock.util.bind.stockfiveday;



import org.robobinding.viewattribute.property.OneWayPropertyViewAttribute;

import cn.com.jinrizhushi.stock.stock.viewmodel.StockFiveDayViewModel;
import cn.com.jinrizhushi.stock.stock.viewmodel.StockKLineViewModel;
import cn.com.jinrizhushi.stock.util.customstockview.StockFiveDayView;


/**
 * 描述: 5日图的属性
 * 作者: 刘倩
 * 日期: 15/12/12 17:04
 */

public class StockFiveDayAttribute implements OneWayPropertyViewAttribute<StockFiveDayView,StockFiveDayViewModel> {
    @Override
    public void updateView(StockFiveDayView view, StockFiveDayViewModel model) {
        view.setViewModel(model);
    }
}