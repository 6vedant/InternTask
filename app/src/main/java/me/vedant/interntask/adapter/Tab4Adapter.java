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
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;

import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;
import me.vedant.interntask.R;
import me.vedant.interntask.fragment.Tab4;
import me.vedant.interntask.libs.AnimationUtils;
import me.vedant.interntask.prototype.Tab1Prototype;
import me.vedant.interntask.prototype.Tab2Prototype;
import me.vedant.interntask.prototype.Tab4Prototype;

/**
 * Created by vedant on 11/22/2018.
 */

public class Tab4Adapter extends RecyclerView.Adapter<Tab4Adapter.MyViewHolder> {

    int previousPosition = 0;
    public Context context;
    Activity activity;

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public ArrayList<Tab4Prototype> tab4Prototypes;

    public Tab4Adapter(Context context, ArrayList<Tab4Prototype> tab4Prototypes) {
        this.context = context;
        this.tab4Prototypes = tab4Prototypes;
        Activity activity1 = (Activity) context;
        setActivity(activity1);
    }

    @NonNull
    @Override
    public Tab4Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.tab4_recycler_series_item, parent, false);
        return new Tab4Adapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Tab4Adapter.MyViewHolder holder, final int position) {

        holder.tv_num_matches.setText(tab4Prototypes.get(position).getTab1Prototypes().size() + " Matches");
        holder.tv_series_name.setText(tab4Prototypes.get(position).getSeries_name());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showDialog(view, tab4Prototypes.get(position).getTab1Prototypes());
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
        return tab4Prototypes.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_series_name;
        TextView tv_num_matches;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_series_name = (TextView) itemView.findViewById(R.id.tv_tab4_series_name);
            tv_num_matches = (TextView) itemView.findViewById(R.id.tv_tab4_mathces_number);

        }
    }

    public void showDialog(View view, ArrayList<Tab1Prototype> tab1Prototypes) {

        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;

        Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.pager_match);
        dialog.setCanceledOnTouchOutside(true);
        try {
            dialog.getWindow().setLayout((6 * width) / 7, (3 * height) / 6);
        } catch (Exception e) {
            e.printStackTrace();
        }


        MatchPagerAdapter matchPagerAdapter = new MatchPagerAdapter(context, tab1Prototypes);

        AutoScrollViewPager pager = (AutoScrollViewPager) dialog.findViewById(R.id.pager);

        pager.setAdapter(matchPagerAdapter);

        CirclePageIndicator circlePageIndicator = (CirclePageIndicator) dialog.findViewById(R.id.pager_indicator);
        circlePageIndicator.setViewPager(pager);
        circlePageIndicator.setCurrentItem(0);

        dialog.show();
    }


}
