package cn.com.jinrizhushi.stock.util.bind.stockkline;

import org.robobinding.viewbinding.BindingAttributeMappings;
import org.robobinding.viewbinding.ViewBinding;

import cn.com.jinrizhushi.stock.util.customstockview.StockView;

/**
 * 描述: K线图binding
 * 作者: 刘倩
 * 日期: 15/12/12 17:04
 */
public class StockKLineBinding implements ViewBinding<StockView> {
    @Override
    public void mapBindingAttributes(BindingAttributeMappings<StockView> mappings) {
        mappings.mapOneWayProperty(StockKLineAttribute.class, "stockkline");
    }


}
