package cn.com.jinrizhushi.stock.util.customnormalview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/**
 * 描述: 自定义View
 * 作者: 刘倩
 * 日期: 15/12/15 03:15
 */
public class CustomTextView extends View {

    public CustomTextView(Context context) {
        super(context);
    }


    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
