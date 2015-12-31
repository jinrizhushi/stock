package cn.com.jinrizhushi.stock.home.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cn.com.jinrizhushi.stock.R;
import cn.com.jinrizhushi.stock.home.view.activity.MainActivity;

/**
 * 描述: 拖拽ListView的适配器
 * 作者: 刘倩
 * 日期: 15/12/30 17:49
 */
public class AMDragRateAdapter extends BaseAdapter {
    private Context context;
    List<MainActivity.body> items;//适配器的数据源


    public AMDragRateAdapter(Context context,List<MainActivity.body> list){
        this.context = context;
        this.items = list;
    }



    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return items.size();
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return items.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return arg0;
    }

    public void remove(int arg0) {//删除指定位置的item
        items.remove(arg0);
        this.notifyDataSetChanged();//不要忘记更改适配器对象的数据源
    }

    public void insert(MainActivity.body item, int arg0) {//在指定位置插入item
        items.add(arg0, item);
        this.notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MainActivity.body item = (MainActivity.body)getItem(position);
        ViewHolder viewHolder;
        if(convertView==null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.list_sort_view_item, null);
            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
            viewHolder.ivCountryLogo = (ImageView) convertView.findViewById(R.id.ivCountryLogo);
            viewHolder.ivDelete = (ImageView) convertView.findViewById(R.id.click_remove);
            viewHolder.ivDragHandle = (ImageView) convertView.findViewById(R.id.drag_handle);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tvTitle.setText(item.getCoin());
        viewHolder.ivCountryLogo.setImageResource(item.getSrc());



        return convertView;
    }

    class ViewHolder {
        TextView tvTitle;
        ImageView ivCountryLogo;
        ImageView ivDelete;
        ImageView ivDragHandle;
    }
}
