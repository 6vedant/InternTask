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
import me.vedant.interntask.adapter.Tab1Adapter;
import me.vedant.interntask.prototype.Tab1Prototype;


/**
 * Created by vedant on 11/21/2018.
 */

public class Tab1 extends Fragment {

    public Tab1() {
        // Required empty public constructor
    }

    public static Tab1 newInstance(String param1, String param2) {
        Tab1 fragment = new Tab1();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    RecyclerView recyclerView;
    ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.tab1, container, false);

        //   ArrayList<CrickPrototype> crickPrototypes = (ArrayList<CrickPrototype>) getArguments().getSerializable("valuesArray");

        ArrayList<Tab1Prototype> tab1Prototypes = (ArrayList<Tab1Prototype>)getArguments().getSerializable("tab1prototypes");

        //   Toast.makeText(getContext(), "The size of the crickProtypes " + crickPrototypes.size(), Toast.LENGTH_SHORT).show();

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        progressBar = (ProgressBar) view.findViewById(R.id.progressbar);


        if (tab1Prototypes.size() > 0) {
            Tab1Adapter tab1Adapter = new Tab1Adapter(getContext(), tab1Prototypes);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(tab1Adapter);
            progressBar.setVisibility(View.INVISIBLE);
        }


        return view;
    }
}
