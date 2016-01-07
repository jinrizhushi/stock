package cn.com.jinrizhushi.stock.home.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.com.jinrizhushi.stock.R;
import cn.com.jinrizhushi.stock.home.view.adapter.AMDragRateAdapter;
import cn.com.jinrizhushi.stock.util.Tools;
import cn.com.jinrizhushi.stock.util.customlistview.drag.DragSortListView;
import cn.com.jinrizhushi.stock.util.pulltorefresh.XListView;

public class MainActivity extends Activity  implements XListView.IXListViewListener{
    private DragSortListView listView;
    private AMDragRateAdapter adapter;
    private Button btnEdit;
    List<body> l;//listview的数据源

    int Src[]=new int[]{R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher};//图片数据源

    //监听器在手机拖动停下的时候触发
    private DragSortListView.DropListener onDrop =
            new DragSortListView.DropListener() {
                @Override
                public void drop(int from, int to) {//from to 分别表示 被拖动控件原位置 和目标位置
                    if (from != to) {
                        body item = (body)adapter.getItem(from);//得到listview的适配器
                        adapter.remove(from);//在适配器中”原位置“的数据。
                        adapter.insert(item, to);//在目标位置中插入被拖动的控件。
                    }
                }
            };
    //删除监听器，点击左边差号就触发。删除item操作。
    private DragSortListView.RemoveListener onRemove =
            new DragSortListView.RemoveListener() {
                @Override
                public void remove(int which) {
                    adapter.remove(which);
                }
            };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //取数据设置适配器类的数据源。
        initData();
        //得到滑动listview并且设置监听器。

        listView.setDropListener(onDrop);
        listView.setRemoveListener(onRemove);


        adapter = new AMDragRateAdapter(MainActivity.this, l);
        listView.setAdapter(adapter);
        listView.setDragEnabled(true); //设置是否可拖动。
        listView.setPullRefreshEnable(true);
        listView.setPullLoadEnable(true);
        listView.setAutoLoadEnable(true);
        listView.setXListViewListener(this);
        listView.setRefreshTime(Tools.getTime());
    }
    private void initData() {//初始化
        String[] array = getResources().getStringArray(R.array.module_name);//初始化数据源
        ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(array));
        l=new ArrayList<body>();
        for(int i=0;i<4;i++){
            body b=new body();
            b.coin=arrayList.get(i);
            b.src=Src[i];
            l.add(b);
        }
        listView = (DragSortListView) findViewById(R.id.dslvList);
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMore() {
        listView.stopRefresh();
        listView.stopLoadMore();
        listView.setRefreshTime(Tools.getTime());
    }

    public class body{//放置adapter数据的类
        int src;
        String coin;
        public int getSrc() {
            return src;
        }
        public void setSrc(int src) {
            this.src = src;
        }
        public String getCoin() {
            return coin;
        }
        public void setCoin(String coin) {
            this.coin = coin;
        }
    }


}
