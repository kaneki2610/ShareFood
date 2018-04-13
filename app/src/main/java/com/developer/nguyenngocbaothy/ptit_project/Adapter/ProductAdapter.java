package com.developer.nguyenngocbaothy.ptit_project.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.developer.nguyenngocbaothy.ptit_project.Model.Product;
import com.developer.nguyenngocbaothy.ptit_project.R;

import java.util.List;

/**
 * Created by Dell on 3/12/2018.
 */

public class ProductAdapter extends ArrayAdapter<Product> {
    Context context;
    int resource;
    List<Product> objects;

    public ProductAdapter(@NonNull Context context, int resource, @NonNull List<Product> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    private class ViewHolder {
        ImageView img;
        TextView txt;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(this.resource, null);
            viewHolder = new ViewHolder();
            viewHolder.img = (ImageView) convertView.findViewById(R.id.imgHinhLoaiMonAn);
            viewHolder.txt = (TextView) convertView.findViewById(R.id.txtTenMonAn);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Product pd = objects.get(position);
        viewHolder.img.setImageResource(pd.getImage());
        viewHolder.txt.setText(pd.getName());

        return convertView;
    }
}
