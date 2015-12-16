package cn.com.jinrizhushi.stock.stock.model;

/**
 * 描述: 卖买家的模型
 * 作者: 刘倩
 * 日期: 15/12/16 23:06
 */
public class StockSellerModel {
    /** 卖家或买家名称 */
    private String sellerName;
    /** 卖出或买进的价格 */
    private String sellerPrice;
    /** 字体颜色 */
    private int sellColor;
    /** 买卖量 */
    private String sellNumber;

    public StockSellerModel() {
    }

    public StockSellerModel(String sellerName, String sellerPrice, int sellColor, String sellNumber) {
        this.sellerName = sellerName;
        this.sellerPrice = sellerPrice;
        this.sellColor = sellColor;
        this.sellNumber = sellNumber;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerPrice() {
        return sellerPrice;
    }

    public void setSellerPrice(String sellerPrice) {
        this.sellerPrice = sellerPrice;
    }

    public int getSellColor() {
        return sellColor;
    }

    public void setSellColor(int sellColor) {
        this.sellColor = sellColor;
    }

    public String getSellNumber() {
        return sellNumber;
    }

    public void setSellNumber(String sellNumber) {
        this.sellNumber = sellNumber;
    }
}
