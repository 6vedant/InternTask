package me.vedant.interntask;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

import me.vedant.interntask.fragment.Tab1;
import me.vedant.interntask.fragment.Tab2;
import me.vedant.interntask.fragment.Tab3;
import me.vedant.interntask.fragment.Tab4;
import me.vedant.interntask.prototype.CrickPrototype;
import me.vedant.interntask.prototype.Tab1Prototype;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;


            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = new Tab1();

                    break;
                case R.id.navigation__tab2:
                    fragment = new Tab2();
                    break;

                case R.id.navigation_tab3:
                    fragment = new Tab3();
                    break;

                case R.id.navigation_tab4:
                    fragment = new Tab4();
                    break;

                default:
                    fragment = new Tab1();
            }

            return loadFragement(fragment);
        }
    };

    private static final String JSON_URL = "https://pastebin.com/raw/HVJXf628";
    public static ArrayList<CrickPrototype> crickPrototypes = new ArrayList<>();
    private static ArrayList<Tab1Prototype> tab1Prototypes = new ArrayList<>();

    @SuppressLint("ResourceAsColor")


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }

    private boolean loadFragement(Fragment fragment) {
        // switching fragment
        if (fragment != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("valuesArray", crickPrototypes);
            bundle.putSerializable("tab1prototypes", tab1Prototypes);
            fragment.setArguments(bundle);

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }


}
