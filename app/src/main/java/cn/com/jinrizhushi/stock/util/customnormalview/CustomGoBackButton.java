package cn.com.jinrizhushi.stock.util.customnormalview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * 描述: 返回按钮
 * 作者: 刘倩
 * 日期: 15/12/11 16:43
 */
public class CustomGoBackButton extends Button{
    /** 实际的宽度 */
    private float width;
    /** 实际的高度 */
    private float height;
    public CustomGoBackButton(Context context) {
        super(context);
    }

    public CustomGoBackButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomGoBackButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = MeasureSpec.getSize(widthMeasureSpec);
        height = MeasureSpec.getSize(heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(6);
        canvas.drawLine(width,0,0,height/2,paint);
        canvas.drawLine(0,height/2,width,height,paint);
    }
}
