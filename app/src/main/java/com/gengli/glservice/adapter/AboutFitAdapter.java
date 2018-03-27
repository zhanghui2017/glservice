package com.gengli.glservice.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gengli.glservice.R;
import com.gengli.glservice.bean.Category;
import com.gengli.glservice.bean.Fitting;
import com.gengli.glservice.util.LogUtils;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.List;

public class AboutFitAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<Fitting> fittings;

    public AboutFitAdapter(Context context, List<Fitting> fittings) {
        this.context = context;
        this.fittings = fittings;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return fittings.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_about_fit, parent, false);
            holder.item_about_fit_img = (ImageView) convertView.findViewById(R.id.item_about_fit_img);
            holder.item_about_fit_name = (TextView) convertView.findViewById(R.id.item_about_fit_name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Fitting fitting = fittings.get(position);

        ImageOptions imageOptions = new ImageOptions.Builder()
                .setLoadingDrawableId(R.mipmap.ic_launcher)
                .setFailureDrawableId(R.mipmap.ic_launcher)
                .build();
        x.image().bind(holder.item_about_fit_img, fitting.getImgUrl(), imageOptions);
        holder.item_about_fit_name.setText(fitting.getTitle());
        return convertView;
    }

    private static class ViewHolder {
        private ImageView item_about_fit_img;
        private TextView item_about_fit_name;
    }
}