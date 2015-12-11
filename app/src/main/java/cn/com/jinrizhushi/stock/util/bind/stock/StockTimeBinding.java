package cn.com.jinrizhushi.stock.util.bind.stock;

import org.robobinding.viewbinding.BindingAttributeMappings;
import org.robobinding.viewbinding.ViewBinding;

import cn.com.jinrizhushi.stock.util.customstockview.StockTimeSharingView;

/**
 * 描述: 分时图的binding
 * 作者: 刘倩
 * 日期: 15/12/8 17:04
 */
public class StockTimeBinding implements ViewBinding<StockTimeSharingView> {
    @Override
    public void mapBindingAttributes(BindingAttributeMappings<StockTimeSharingView> mappings) {
        mappings.mapOneWayProperty(StockTimeAttribute.class, "stock");
    }


}
