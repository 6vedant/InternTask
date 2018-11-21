package me.vedant.interntask.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.vedant.interndemos.R;

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.tab1, container, false);


        return view;
    }
}
