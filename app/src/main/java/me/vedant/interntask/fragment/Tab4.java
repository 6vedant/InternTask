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

import me.vedant.interntask.R;
import me.vedant.interntask.adapter.Tab2Adapter;
import me.vedant.interntask.adapter.Tab4Adapter;
import me.vedant.interntask.prototype.Tab1Prototype;
import me.vedant.interntask.prototype.Tab4Prototype;


/**
 * Created by vedant on 11/21/2018.
 */

public class Tab4 extends Fragment {
    public Tab4() {
        // Required empty public constructor
    }

    public static Tab4 newInstance(String param1, String param2) {
        Tab4 fragment = new Tab4();
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

        ArrayList<Tab1Prototype> tab1Prototypes = (ArrayList<Tab1Prototype>) getArguments().getSerializable("tab1prototypes");

        progressBar = (ProgressBar) view.findViewById(R.id.progressbar);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);

        ArrayList<String> series_name = new ArrayList<>();
        series_name.clear();

        ArrayList<Tab4Prototype> tab4Prototypes = new ArrayList<>();
        tab4Prototypes.clear();

        for (Tab1Prototype tab1Prototype : tab1Prototypes) {

            if (!series_name.contains(tab1Prototype.getSeries_name())) {
                series_name.add(tab1Prototype.getSeries_name());
            }
        }

        for (int i = 0; i < series_name.size(); i++) {
            ArrayList<Tab1Prototype> tab1Prototypes1 = new ArrayList<>();
            tab1Prototypes1.clear();
            for (Tab1Prototype tab1Prototype : tab1Prototypes) {
                if (tab1Prototype.getSeries_name().equals(series_name.get(i))) {
                    tab1Prototypes1.add(tab1Prototype);
                }
            }
            tab4Prototypes.add(new Tab4Prototype(series_name.get(i), tab1Prototypes1));

        }

        if (tab4Prototypes.size() > 0) {
            Tab4Adapter tab4Adapter = new Tab4Adapter(getContext(), tab4Prototypes);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(tab4Adapter);
            progressBar.setVisibility(View.INVISIBLE);
        }


        return view;
    }
}
