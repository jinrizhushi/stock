package cn.com.jinrizhushi.stock.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 描述: 帮助类
 * 作者: 刘倩
 * 日期: 15/12/3 10:41
 */
public class Tools {
    /**
     * 格式化数据
     *
     * @param data 要格式化的数据
     * @return
     */
    public static String getDecimalFormat(float data) {
        DecimalFormat decimalFormat = new DecimalFormat(".00");
        return decimalFormat.format(data);
    }

    public static String getDecimalFormatNone(float data) {
        DecimalFormat decimalFormat = new DecimalFormat("");
        return decimalFormat.format(data);
    }
    public static float getDecimalFormatFloat(float data) {
        DecimalFormat decimalFormat = new DecimalFormat(".00");
        return Float.parseFloat(decimalFormat.format(data));
    }

    public static float getDecimalFormatNoneFloat(float data) {
        DecimalFormat decimalFormat = new DecimalFormat("");
        return Float.parseFloat(decimalFormat.format(data));

    }
    /**
     * 获取时间
     * @return
     */
    public static String getTime() {
        return new SimpleDateFormat("MM-dd HH:mm", Locale.CHINA).format(new Date());
    }
}
