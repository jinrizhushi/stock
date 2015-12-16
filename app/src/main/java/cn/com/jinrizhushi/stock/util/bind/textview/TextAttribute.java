package cn.com.jinrizhushi.stock.util.bind.textview;

import android.widget.TextView;

import org.robobinding.util.PrimitiveTypeUtils;
import org.robobinding.viewattribute.property.OneWayMultiTypePropertyViewAttribute;
import org.robobinding.viewattribute.property.OneWayPropertyViewAttribute;

/**
 * TextView 背景设置
 */
public class TextAttribute implements OneWayMultiTypePropertyViewAttribute<TextView> {
    @Override
    public OneWayPropertyViewAttribute<TextView, ?> create(TextView view, Class<?> propertyType) {
        if (PrimitiveTypeUtils.integerIsAssignableFrom(propertyType)) {
            return new ResourceIdBackgroundAttribute();
        } else if (String.class.isAssignableFrom(propertyType)) {
            return new StringBackgroundAttribute();
        } else if (String.class.isAssignableFrom(propertyType)) {
            return new StringBackgroundAttribute();
        }

        throw new RuntimeException("Could not find a suitable background attribute class for property type: " + propertyType);
    }

    static class ResourceIdBackgroundAttribute implements OneWayPropertyViewAttribute<TextView, Integer> {

        @Override
        public void updateView(TextView view, Integer integer) {
            view.setText(integer);
        }
    }

    static class StringBackgroundAttribute implements OneWayPropertyViewAttribute<TextView, String> {

        @Override
        public void updateView(TextView view, String str) {
            view.setText(str);
        }
    }

}
