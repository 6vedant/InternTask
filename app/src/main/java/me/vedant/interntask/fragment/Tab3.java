package me.vedant.interntask.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

import me.vedant.interntask.R;
import me.vedant.interntask.adapter.Tab2Adapter;
import me.vedant.interntask.prototype.CrickPrototype;
import me.vedant.interntask.prototype.Tab1Prototype;
import me.vedant.interntask.prototype.Tab2Prototype;


/**
 * Created by vedant on 11/21/2018.
 */

public class Tab3 extends Fragment {
    public Tab3() {
        // Required empty public constructor
    }

    public static Tab3 newInstance(String param1, String param2) {
        Tab3 fragment = new Tab3();
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
            if (!country_name_list.contains(tab1Prototype.getHost_name())) {
                country_name_list.add(tab1Prototype.getHost_name());
                country_image_url.add(tab1Prototype.getHost_image_url());
            }

        }

        for (int i = 0; i < country_name_list.size(); i++) {
            ArrayList<Tab1Prototype> temp_tab1prototypes = new ArrayList<>();
            temp_tab1prototypes.clear();
            for (Tab1Prototype tab1Prototype : tab1Prototypes) {
                if (tab1Prototype.getHost_name().equals(country_name_list.get(i))) {
                    temp_tab1prototypes.add(tab1Prototype);
                }
            }
            tab2Prototypes.add(new Tab2Prototype(country_name_list.get(i), temp_tab1prototypes, country_image_url.get(i)));
        }

        if (tab2Prototypes.size() > 0) {
            // pass the adapter into recyclerview
            Tab2Adapter tab2Adapter = new Tab2Adapter(getContext(), tab2Prototypes);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(tab2Adapter);
            progressBar.setVisibility(View.INVISIBLE);
        }


        return view;
    }
}

