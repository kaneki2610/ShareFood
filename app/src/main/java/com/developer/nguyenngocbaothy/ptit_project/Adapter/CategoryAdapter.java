package com.developer.nguyenngocbaothy.ptit_project.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.developer.nguyenngocbaothy.ptit_project.Model.Category;
import com.developer.nguyenngocbaothy.ptit_project.R;

import java.util.List;


/**
 * Created by HOME on 23-Feb-18.
 */

public class CategoryAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Category> categoryList;

    public CategoryAdapter(Context context, int layout, List<Category> categoryList) {
        this.context = context;
        this.layout = layout;
        this.categoryList = categoryList;
    }

    @Override
    public int getCount() {
        return categoryList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder {
        ImageView image;
        TextView txtTen;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            holder = new ViewHolder();
            holder.txtTen = (TextView) convertView.findViewById(R.id.textTenloai);
            holder.image = (ImageView) convertView.findViewById(R.id.imageHinhloai);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Category category = categoryList.get(position);
        holder.txtTen.setText(category.getName());
        holder.image.setImageResource(category.getImage());

        return convertView;
    }
}
