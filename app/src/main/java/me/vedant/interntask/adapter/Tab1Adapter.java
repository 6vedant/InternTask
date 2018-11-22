package me.vedant.interntask.adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;

import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;
import me.vedant.interntask.R;
import me.vedant.interntask.libs.AnimationUtils;
import me.vedant.interntask.prototype.Tab1Prototype;


/**
 * Created by vedant on 11/21/2018.
 */

public class Tab1Adapter extends RecyclerView.Adapter<Tab1Adapter.MyViewHolder> {

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

    public Tab1Adapter(Context context, ArrayList<Tab1Prototype> tab1Prototypes) {
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
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.tv_team1_name.setText(tab1Prototypes.get(position).getTeam1_name());
        holder.tv_team2_name.setText(tab1Prototypes.get(position).getTeam2_name());
        holder.tv_match_result.setText(tab1Prototypes.get(position).getMatch_result());
        holder.tv_series_tv.setText(tab1Prototypes.get(position).getSeries_name());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMatchDialog(view, tab1Prototypes.get(position));
            }
        });

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

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_series_tv, tv_team1_name, tv_team2_name, tv_match_result;
        ImageView im_team1, im_team2;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_series_tv = (TextView) itemView.findViewById(R.id.tv_series_name);
            tv_team1_name = (TextView) itemView.findViewById(R.id.tv_team1_name);
            tv_team2_name = (TextView) itemView.findViewById(R.id.tv_team2_name);
            tv_match_result = (TextView) itemView.findViewById(R.id.tv_match_result);
            im_team1 = (ImageView) itemView.findViewById(R.id.im_team1);
            im_team1 = (ImageView) itemView.findViewById(R.id.im_team2);
        }

    }

    public void showMatchDialog(View view, Tab1Prototype tab1Prototype) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;

        Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.match_pager_list_item);
        dialog.setCanceledOnTouchOutside(true);
        try {
            dialog.getWindow().setLayout((6 * width) / 7, (3 * height) / 6);
        } catch (Exception e) {
            e.printStackTrace();
        }


        ImageView im_team1 = (ImageView) dialog.findViewById(R.id.im_pager_team1);
        ImageView im_team2 = (ImageView) dialog.findViewById(R.id.im_pager_team2);
        TextView tv_team1_name = (TextView) dialog.findViewById(R.id.tv_pager_team1);
        TextView tv_team2_name = (TextView) dialog.findViewById(R.id.tv_pager_team2_name);
        TextView tv_team1_score = (TextView) dialog.findViewById(R.id.tv_pager_team1score);
        TextView tv_team2_score = (TextView) dialog.findViewById(R.id.tv_pager_team2score);
        TextView tv_series_name = (TextView) dialog.findViewById(R.id.tv_pager_series_name);
        TextView tv_match_result = (TextView) dialog.findViewById(R.id.tv_pager_match_result);

        Picasso.with(context)
                .load(Uri.parse(tab1Prototype.getTeam1_image_url()))
                .placeholder(R.drawable.indian_team_logo)
                .into(im_team1);

        Picasso.with(context)
                .load(Uri.parse(tab1Prototype.getTeam2_image_url()))
                .placeholder(R.drawable.indian_team_logo)
                .into(im_team2);

        tv_team1_name.setText(tab1Prototype.getTeam1_name());
        tv_team2_name.setText(tab1Prototype.getTeam2_name());
        tv_team1_score.setText(tab1Prototype.getInn1_score());
        if (tab1Prototype.getInn2_score() == null) {
            tv_team2_score.setText("__");
        } else {
            tv_team2_score.setText(tab1Prototype.getInn2_score());
        }
        tv_series_name.setText(tab1Prototype.getSeries_name());
        tv_match_result.setText(tab1Prototype.getMatch_result());

        dialog.show();
    }

}
