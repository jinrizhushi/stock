package cn.com.jinrizhushi.stock.stock.viewmodel;

import android.content.Context;

import org.robobinding.annotation.PresentationModel;
import org.robobinding.presentationmodel.HasPresentationModelChangeSupport;
import org.robobinding.presentationmodel.PresentationModelChangeSupport;

/**
 * 描述: 股票详情的视图模型类
 * 作者: 刘倩
 * 日期: 15/12/11 14:35
 */
@PresentationModel
public class StockDetailViewModel implements HasPresentationModelChangeSupport {

    private Context context;
    private PresentationModelChangeSupport changeSupport;

    @Override
    public PresentationModelChangeSupport getPresentationModelChangeSupport() {
        return changeSupport;
    }

    public StockDetailViewModel(Context context) {
        this.context = context;
        changeSupport = new PresentationModelChangeSupport(this);
    }
}
