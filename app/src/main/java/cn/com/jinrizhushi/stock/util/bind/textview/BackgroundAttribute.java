package cn.com.jinrizhushi.stock.util.bind.textview;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.TextView;

import org.robobinding.util.PrimitiveTypeUtils;
import org.robobinding.viewattribute.property.OneWayMultiTypePropertyViewAttribute;
import org.robobinding.viewattribute.property.OneWayPropertyViewAttribute;

/**
 * TextView 背景设置
 */
public class BackgroundAttribute implements OneWayMultiTypePropertyViewAttribute<TextView> {
    @Override
    public OneWayPropertyViewAttribute<TextView, ?> create(TextView view, Class<?> propertyType) {
        if (PrimitiveTypeUtils.integerIsAssignableFrom(propertyType)) {
            return new ResourceIdBackgroundAttribute();
        } else if (Bitmap.class.isAssignableFrom(propertyType)) {
            return new BitmapBackgroundAttribute();
        } else if (Drawable.class.isAssignableFrom(propertyType)) {
            return new DrawableBackgroundAttribute();
        }

        throw new RuntimeException("Could not find a suitable background attribute class for property type: " + propertyType);
    }

    static class ResourceIdBackgroundAttribute implements OneWayPropertyViewAttribute<TextView, Integer> {

        @Override
        public void updateView(TextView view, Integer integer) {
            view.setBackgroundResource(integer);
        }
    }

    static class BitmapBackgroundAttribute implements OneWayPropertyViewAttribute<TextView, Bitmap> {

        @Override
        public void updateView(TextView view, Bitmap bitmap) {
            Drawable drawable =new BitmapDrawable(bitmap);
            view.setBackgroundDrawable(drawable);
        }
    }

    static class DrawableBackgroundAttribute implements OneWayPropertyViewAttribute<TextView, Drawable> {
        @Override
        public void updateView(TextView view, Drawable drawable) {
            view.setBackgroundDrawable(drawable);

        }
    }
}
