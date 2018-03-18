package com.developer.nguyenngocbaothy.ptit_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;



/**
 * Created by HOME on 23-Feb-18.
 */

public class MonAnAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<MonAn> monAnList;

    public MonAnAdapter(Context context, int layout, List<MonAn> monAnList) {
        this.context = context;
        this.layout = layout;
        this.monAnList = monAnList;
    }

    @Override
    public int getCount() {
        return monAnList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder{
        ImageView image;
        TextView txtTen;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            holder = new ViewHolder();
            holder.txtTen = (TextView) convertView.findViewById(R.id.textTen);
            holder.image = (ImageView) convertView.findViewById(R.id.imageIcon);
            convertView.setTag(holder);

        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        MonAn monan  = monAnList.get(position);
        holder.txtTen.setText(monan.getTenMonAn());
        holder.image.setImageResource(monan.getHinh());

        return convertView;
    }
}
