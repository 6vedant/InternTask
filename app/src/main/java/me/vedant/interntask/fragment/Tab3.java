package me.vedant.interntask.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import me.vedant.interntask.R;
import me.vedant.interntask.prototype.CrickPrototype;


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


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.tab1, container, false);

        ArrayList<CrickPrototype> crickPrototypes = (ArrayList<CrickPrototype>) getArguments().getSerializable("valuesArray");

        Toast.makeText(getContext(), "The size of the crickProtypes "+crickPrototypes.size(), Toast.LENGTH_SHORT).show();


        return view;
    }
}

