package cn.com.jinrizhushi.stock.util.bind.stockfiveday;

import org.robobinding.viewbinding.BindingAttributeMappings;
import org.robobinding.viewbinding.ViewBinding;

import cn.com.jinrizhushi.stock.util.customstockview.StockFiveDayView;

/**
 * 描述: 5日图binding
 * 作者: 刘倩
 * 日期: 15/12/12 17:04
 */
public class StockFiveDayBinding implements ViewBinding<StockFiveDayView> {
    @Override
    public void mapBindingAttributes(BindingAttributeMappings<StockFiveDayView> mappings) {
        mappings.mapOneWayProperty(StockFiveDayAttribute.class, "stockFiveDay");
    }


}
