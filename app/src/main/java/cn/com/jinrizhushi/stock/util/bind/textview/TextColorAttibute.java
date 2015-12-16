package cn.com.jinrizhushi.stock.util.bind.textview;

import android.widget.TextView;

import org.robobinding.viewattribute.property.OneWayPropertyViewAttribute;

/**
 * TextView 背景设置
 */
public class TextColorAttibute implements OneWayPropertyViewAttribute<TextView,Integer> {
    @Override
    public void updateView(TextView view, Integer color) {
        view.setTextColor(color);
    }
}



