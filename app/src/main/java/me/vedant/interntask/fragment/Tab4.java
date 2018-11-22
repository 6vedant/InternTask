package me.vedant.interntask.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.ArrayList;

import me.vedant.interntask.R;
import me.vedant.interntask.prototype.Tab1Prototype;


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

        progressBar = (ProgressBar)view.findViewById(R.id.progressbar);
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerview);



        return view;
    }
}
