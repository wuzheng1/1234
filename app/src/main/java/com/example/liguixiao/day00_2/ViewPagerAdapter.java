package com.example.liguixiao.day00_2;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by liguixiao on 2019/9/18.
 */

public class ViewPagerAdapter extends PagerAdapter{

    private Context context;
    private List<RootBeans.ResultsBean> o;

    public ViewPagerAdapter(Context context, List<RootBeans.ResultsBean> o) {
        this.context = context;
        this.o = o;
    }

    @Override
    public int getCount() {
        return o.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = View.inflate(context,R.layout.pagerlayout,null);
        ImageView viewById = view.findViewById(R.id.pager_img);
        TextView pager_tva = view.findViewById(R.id.pager_tva);
        TextView pager_tvb = view.findViewById(R.id.pager_tvb);
        pager_tva.setText(position+1+"");
        pager_tvb.setText(o.get(position).getDesc());
        Glide.with(context).load(o.get(position).getUrl()).into(viewById);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
