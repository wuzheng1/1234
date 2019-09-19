package com.example.liguixiao.day00_2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by liguixiao on 2019/9/18.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<RootBeans.ResultsBean> results;

    public RecyclerAdapter(Context context, List<RootBeans.ResultsBean> results) {
        this.context = context;
        this.results = results;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType==1){
            View view = View.inflate(context,R.layout.firstlayout,null);
            return new FirstViewHolder(view);
        }else if (viewType==2){
            View view = View.inflate(context,R.layout.nextlayout,null);
            return new NextViewHolder(view);
        }else{
            View view = View.inflate(context,R.layout.threelayout,null);
            return new ThreeViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        int type = getItemViewType(position);
        if (type==1){
            FirstViewHolder firstViewHolder = (FirstViewHolder) holder;
            Glide.with(context).load(results.get(position).getUrl()).into(firstViewHolder.img);
        }else if (type==2){
            NextViewHolder nextViewHolder = (NextViewHolder) holder;
            nextViewHolder.tv_a.setText(results.get(position).getCreatedAt());
            nextViewHolder.tv_b.setText(results.get(position).getWho());
            nextViewHolder.tv_c.setText(results.get(position).getDesc());
            nextViewHolder.tv_d.setText(results.get(position).getSource());
        }else{
            ThreeViewHolder threeViewHolder = (ThreeViewHolder) holder;
            Glide.with(context).load(results.get(position).getUrl()).into(threeViewHolder.imga);
            Glide.with(context).load(results.get(position).getUrl()).into(threeViewHolder.imgb);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                u.onClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 3 == 0) {
            return 1;
        } else if (position % 3 == 1) {
            return 2;
        } else {
            return 3;
        }
    }

    class FirstViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        public FirstViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.first_img);
        }
    }

    class NextViewHolder extends RecyclerView.ViewHolder{
        TextView tv_a;
        TextView tv_b;
        TextView tv_c;
        TextView tv_d;
        public NextViewHolder(View itemView) {
            super(itemView);
            tv_a = itemView.findViewById(R.id.next_tva);
            tv_b = itemView.findViewById(R.id.next_tvb);
            tv_c = itemView.findViewById(R.id.next_tvc);
            tv_d = itemView.findViewById(R.id.next_tvd);
        }
    }

    class ThreeViewHolder extends RecyclerView.ViewHolder{

        ImageView imga;
        ImageView imgb;
        public ThreeViewHolder(View itemView) {
            super(itemView);
            imga = itemView.findViewById(R.id.three_imga);
            imgb = itemView.findViewById(R.id.three_imgb);
        }
    }

    private User u;

    public void setU(User u) {
        this.u = u;
    }

    public interface User{
        void onClick(int position);
    }
}
