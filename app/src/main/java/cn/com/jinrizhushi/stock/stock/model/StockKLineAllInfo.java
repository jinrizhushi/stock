package cn.com.jinrizhushi.stock.stock.model;

import java.util.List;

/**
 * 描述: 联网获取的所有数据
 * 作者: 刘倩
 * 日期: 15/12/3 18:11
 */
public class StockKLineAllInfo {
    private int code;
    private  String msg;
    private List<StockModel> payload;

    public StockKLineAllInfo(int code, String msg, List<StockModel> payload) {
        this.code = code;
        this.msg = msg;
        this.payload = payload;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<StockModel> getPayload() {
        return payload;
    }

    public void setPayload(List<StockModel> payload) {
        this.payload = payload;
    }
}
