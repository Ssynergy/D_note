package com.example.a.dailynote;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends BaseAdapter {

    ArrayList<ItemData> items = new ArrayList<ItemData>(android.R.layout.simple_list_item_multiple_choice);
    Context mContext;

    public MyAdapter(Context context) {
        mContext = context;
    }

    public void add(ItemData item) {
        items.add(item);
        notifyDataSetChanged();
    }

    public void addAll(List<ItemData> items) {
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemView v = new ItemView(mContext);
        v.setItemData(items.get(position));
        return v;
    }
}
