package me.vedant.interntask.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.ArrayList;

import me.vedant.interndemos.R;
import me.vedant.interndemos.adapter.Tab2Adapter;
import me.vedant.interndemos.prototype.Tab1Prototype;
import me.vedant.interndemos.prototype.Tab2Prototype;

/**
 * Created by vedant on 11/21/2018.
 */

public class Tab2 extends Fragment {
    public Tab2() {
        // Required empty public constructor
    }

    public static Tab2 newInstance(String param1, String param2) {
        Tab2 fragment = new Tab2();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    ProgressBar progressBar;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.tab1, container, false);

        progressBar = (ProgressBar) view.findViewById(R.id.progressbar);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);

        ArrayList<Tab1Prototype> tab1Prototypes = (ArrayList<Tab1Prototype>) getArguments().getSerializable("tab1prototypes");

        ArrayList<Tab2Prototype> tab2Prototypes = new ArrayList<>();
        tab2Prototypes.clear();
        ArrayList<String> country_name_list = new ArrayList<>();
        country_name_list.clear();
        ArrayList<String> country_image_url = new ArrayList<>();
        country_image_url.clear();

        for (Tab1Prototype tab1Prototype : tab1Prototypes) {
           if(!country_name_list.contains(tab1Prototype.getTeam1_name())){
               country_name_list.add(tab1Prototype.getTeam1_name());
               country_image_url.add(tab1Prototype.getTeam1_image_url());
           }

           if(!country_name_list.contains(tab1Prototype.getTeam2_name())){
               country_name_list.add(tab1Prototype.getTeam2_name());
               country_image_url.add(tab1Prototype.getTeam2_image_url());
           }
        }

        for(int i=0;i<country_name_list.size();i++){
            ArrayList<Tab1Prototype> temp_tab1prototypes = new ArrayList<>();
            temp_tab1prototypes.clear();
            for(Tab1Prototype tab1Prototype : tab1Prototypes){
                if(tab1Prototype.getTeam1_name().equals(country_name_list.get(i))){
                    temp_tab1prototypes.add(tab1Prototype);
                }
                if(tab1Prototype.getTeam2_name().equals(country_name_list.get(i))){
                    temp_tab1prototypes.add(tab1Prototype);
                }
            }
            tab2Prototypes.add(new Tab2Prototype(country_name_list.get(i), temp_tab1prototypes, country_image_url.get(i)));
        }

        if (tab2Prototypes.size() > 0) {
            Tab2Adapter tab2Adapter = new Tab2Adapter(getContext(), tab2Prototypes);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(tab2Adapter);
            progressBar.setVisibility(View.INVISIBLE);
        }



        return view;
    }
}
