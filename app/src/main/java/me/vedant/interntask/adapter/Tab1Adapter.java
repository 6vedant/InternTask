package me.vedant.interntask.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import me.vedant.interntask.R;
import me.vedant.interntask.libs.AnimationUtils;
import me.vedant.interntask.prototype.Tab1Prototype;


/**
 * Created by vedant on 11/21/2018.
 */

public class Tab1Adapter extends RecyclerView.Adapter<Tab1Adapter.MyViewHolder>{

    int previousPosition = 0;
    public Context context;
    Activity activity;

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
    public ArrayList<Tab1Prototype> tab1Prototypes;

    public Tab1Adapter(Context context, ArrayList<Tab1Prototype> tab1Prototypes){
        this.context = context;
        this.tab1Prototypes = tab1Prototypes;
        Activity activity1 = (Activity) context;
        setActivity(activity1);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.tab1_list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tv_team1_name.setText(tab1Prototypes.get(position).getTeam1_name());
        holder.tv_team2_name.setText(tab1Prototypes.get(position).getTeam2_name());
        holder.tv_match_result.setText(tab1Prototypes.get(position).getMatch_result());
        holder.tv_series_tv.setText(tab1Prototypes.get(position).getSeries_name());

        //add the fluidic effect
        previousPosition = position;
        if (position > previousPosition) {
            AnimationUtils.animate(holder, true);
        } else {
            AnimationUtils.animate(holder, false);
        }
        previousPosition = position;

    }

    @Override
    public int getItemCount() {
        return tab1Prototypes.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_series_tv, tv_team1_name, tv_team2_name, tv_match_result;
        ImageView im_team1, im_team2;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_series_tv = (TextView)itemView.findViewById(R.id.tv_series_name);
            tv_team1_name = (TextView)itemView.findViewById(R.id.tv_team1_name);
            tv_team2_name = (TextView)itemView.findViewById(R.id.tv_team2_name);
            tv_match_result = (TextView)itemView.findViewById(R.id.tv_match_result);
            im_team1 = (ImageView)itemView.findViewById(R.id.im_team1);
            im_team1 = (ImageView)itemView.findViewById(R.id.im_team2);
        }

    }
}
