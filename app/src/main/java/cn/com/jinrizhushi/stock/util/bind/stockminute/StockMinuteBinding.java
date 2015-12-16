package cn.com.jinrizhushi.stock.util.bind.stockminute;

import org.robobinding.viewbinding.BindingAttributeMappings;
import org.robobinding.viewbinding.ViewBinding;

import cn.com.jinrizhushi.stock.util.customstockview.StockMinuteView;

/**
 * 描述: 5日图binding
 * 作者: 刘倩
 * 日期: 15/12/12 17:04
 */
public class StockMinuteBinding implements ViewBinding<StockMinuteView> {
    @Override
    public void mapBindingAttributes(BindingAttributeMappings<StockMinuteView> mappings) {
        mappings.mapOneWayProperty(StockMinuteAttribute.class, "stockMinute");
    }


}
