package me.vedant.interntask.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import me.vedant.interntask.R;
import me.vedant.interntask.prototype.Tab1Prototype;


/**
 * Created by vedant on 11/21/2018.
 */

public class MatchPagerAdapter extends PagerAdapter {

    Context context;
    public ArrayList<Tab1Prototype> tab1Prototypes;
    LayoutInflater inflater;

    public MatchPagerAdapter(Context context, ArrayList<Tab1Prototype> tab1Prototypes) {
        this.context = context;
        this.tab1Prototypes = tab1Prototypes;

        inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return tab1Prototypes.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        // inflate the view
        View view = inflater.inflate(R.layout.match_pager_list_item, container, false);
        ImageView im_team1 = (ImageView) view.findViewById(R.id.im_pager_team1);
        ImageView im_team2 = (ImageView) view.findViewById(R.id.im_pager_team2);
        TextView tv_team1_name = (TextView) view.findViewById(R.id.tv_pager_team1);
        TextView tv_team2_name = (TextView) view.findViewById(R.id.tv_pager_team2_name);
        TextView tv_team1_score = (TextView) view.findViewById(R.id.tv_pager_team1score);
        TextView tv_team2_score = (TextView) view.findViewById(R.id.tv_pager_team2score);
        TextView tv_series_name = (TextView) view.findViewById(R.id.tv_pager_series_name);
        TextView tv_match_result = (TextView) view.findViewById(R.id.tv_pager_match_result);

        Tab1Prototype tab1Prototype = tab1Prototypes.get(position);

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

        ((ViewPager) container).addView(view);

        return view;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((View) object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);
    }
}
