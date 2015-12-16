package cn.com.jinrizhushi.stock.util.bind.textview;

import android.widget.TextView;

import org.robobinding.viewattribute.property.OneWayPropertyViewAttribute;
import org.robobinding.viewbinding.BindingAttributeMappings;
import org.robobinding.viewbinding.ViewBinding;

/**
 * 自定义TextView属性
 */
public class TextViewBinding implements ViewBinding<TextView> {
    @Override
    public void mapBindingAttributes(BindingAttributeMappings<TextView> mappings) {
        mappings.mapOneWayProperty(TextColorAttibute.class, "textColor");
    }
}
