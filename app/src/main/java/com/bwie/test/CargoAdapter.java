package com.bwie.test;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 李小兵 on 2016/12/2.
 */
public class CargoAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Cargo> cargoArrayList;
    private OnMoneyChangeListener onMoneyChangeListener;

    public CargoAdapter(ArrayList<Cargo> cargoArrayList, Context context, OnMoneyChangeListener onMoneyChangeListener) {
        this.cargoArrayList = cargoArrayList;
        this.context = context;
        this.onMoneyChangeListener = onMoneyChangeListener;
    }

    @Override
    public int getCount() {
        return cargoArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ViewHolder viewHolder;
        if (convertView == null) {

            viewHolder = new ViewHolder();
            convertView = View.inflate(context, R.layout.lv_item, null);
            viewHolder.tv_price = (TextView) convertView.findViewById(R.id.tv_item_price);
            viewHolder.cb_item = (CheckBox) convertView.findViewById(R.id.cb_item);
            viewHolder.tv_item = (TextView) convertView.findViewById(R.id.tv_item_name);

            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();

        }
        viewHolder.tv_item.setText(cargoArrayList.get(position).getName());
        viewHolder.cb_item.setChecked(cargoArrayList.get(position).isFlag());
        viewHolder.tv_price.setText(cargoArrayList.get(position).getPrice() + "");

        viewHolder.cb_item.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            }
        });

        viewHolder.cb_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (viewHolder.cb_item.isChecked()) {
                    cargoArrayList.get(position).setFlag(true);

                } else {
                    cargoArrayList.get(position).setFlag(false);
                }

//                MainActivity mainActivity = (MainActivity) CargoAdapter.this.context;
//                mainActivity.setMony();
                if (onMoneyChangeListener != null) {
                    onMoneyChangeListener.setChange();
                }
            }
        });

        return convertView;
    }

    class ViewHolder {
        TextView tv_price;
        TextView tv_item;
        CheckBox cb_item;
    }

}
