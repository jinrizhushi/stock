package cn.com.jinrizhushi.stock.stock.viewmodel;

import android.content.Context;

import org.robobinding.itempresentationmodel.ItemContext;
import org.robobinding.itempresentationmodel.ItemPresentationModel;
import org.robobinding.presentationmodel.HasPresentationModelChangeSupport;
import org.robobinding.presentationmodel.PresentationModelChangeSupport;

import cn.com.jinrizhushi.stock.stock.model.StockSellerModel;

/**
 * 描述: 卖出
 * 作者: 刘倩
 * 日期: 15/12/17 00:06
 */
public class StockSellerIntItemViewModel implements ItemPresentationModel<StockSellerModel>, HasPresentationModelChangeSupport {
    private StockSellerModel value;
    private Context mContext;


    @Override
    public void updateData(StockSellerModel StockSellerModel, ItemContext itemContext) {
        value = StockSellerModel;
        this.mContext = itemContext.getItemView().getContext();
    }

    public String getSellerName() {
        return value.getSellerName();
    }
    public String getSellerPrice() {
        return value.getSellerPrice();
    }
    public String getSellNumber() {
        return value.getSellNumber();
    }
    public int getSellColor() {
        return value.getSellColor();
    }

    public StockSellerModel getValue() {
        return value;
    }


    private PresentationModelChangeSupport changeSupport;

    @Override
    public PresentationModelChangeSupport getPresentationModelChangeSupport() {
        return changeSupport = new PresentationModelChangeSupport(this);
    }
}
