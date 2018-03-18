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

import com.developer.nguyenngocbaothy.ptit_project.Model.MonAnModel;
import com.developer.nguyenngocbaothy.ptit_project.R;

import java.util.List;

/**
 * Created by Dell on 3/12/2018.
 */

public class CustomLoaiMonAnAdapter extends ArrayAdapter<MonAnModel> {
    Context context;
    int resourc;
    List<MonAnModel> objects;
    public CustomLoaiMonAnAdapter(@NonNull Context context, int resource, @NonNull List<MonAnModel> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resourc=resource;
        this.objects=objects;
    }
    private class ViewHolder{
        ImageView img;
        TextView txt;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView==null)
        {
            LayoutInflater inflater= (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(this.resourc,parent,false);
            ViewHolder viewHolder=new ViewHolder();
            viewHolder.img=convertView.findViewById(R.id.imgHinhLoaiMonAn);
            viewHolder.txt=convertView.findViewById(R.id.txtTenMonAn);
            convertView.setTag(viewHolder);
        }
        ViewHolder viewHolder= (ViewHolder) convertView.getTag();
        MonAnModel m=objects.get(position);
        viewHolder.img.setImageResource(m.getHinhAnh());
        viewHolder.txt.setText(m.getTenMon());
        return convertView;
    }
}
