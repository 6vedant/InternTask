package me.vedant.interntask;

import android.annotation.SuppressLint;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

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

    private static String JSON_URL = "https://pastebin.com/raw/HVJXf628";
    public static ArrayList<CrickPrototype> crickPrototypes = new ArrayList<>();
    private static ArrayList<Tab1Prototype> tab1Prototypes = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("ResourceAsColor")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        JSON_URL = getIntent().getStringExtra("json_url");
        ArrayList<String> country_names = getIntent().getStringArrayListExtra("country_names");
        ArrayList<String> country_image_urls = getIntent().getStringArrayListExtra("country_image_url");

        final HashMap<String, String> country_image_map = new HashMap<>();
        for (int i = 0; i < country_image_urls.size(); i++) {
            country_image_map.put(country_names.get(i), country_image_urls.get(i));
        }

        // loadFragement(new Tab1());
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setBackgroundDrawable(getDrawable(R.drawable.background));
        }
        crickPrototypes.clear();
        tab1Prototypes.clear();
        final BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setBackgroundColor(R.color.navigationBack);
        //   navigation.setBackgroundResource(R.drawable.bottom_back);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        //creating a string request to send request to the url
        StringRequest stringRequest = new StringRequest(Request.Method.GET, JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //hiding the progressbar after completion


                        try {
                            //getting the whole json object from the response
                            JSONObject obj = new JSONObject(response);


                            //now looping through all the elements of the json array
                            for (int i = 0; i < obj.names().length(); i++) {
                                //getting the json object of the particular index inside the array
                                JSONObject heroObject = (JSONObject) obj.get(obj.names().getString(i));

                                try {
                                    CrickPrototype crickPrototype = new CrickPrototype(heroObject.getString("team1"),
                                            heroObject.getString("team2"),
                                            heroObject.getString("series"),
                                            heroObject.getString("inn1"),
                                            heroObject.getString("inn2"),
                                            heroObject.getString("host"));
                                    crickPrototypes.add(crickPrototype);

                                    Tab1Prototype tab1Prototype = new Tab1Prototype(crickPrototype.getTeam1(),
                                            crickPrototype.getTeam2(), crickPrototype.getHost(), crickPrototype.getSeries(),
                                            crickPrototype.getInn1(), crickPrototype.getInn2(), getMatchResult(crickPrototype.getInn1(), crickPrototype.getInn2(), crickPrototype.getTeam1(), crickPrototype.getTeam2()),
                                            "url1", "url2", "");
                                    tab1Prototypes.add(tab1Prototype);

                                } catch (Exception e) {
                                    // inn2 is missing case
                                    CrickPrototype crickPrototype = new CrickPrototype(heroObject.getString("team1"),
                                            heroObject.getString("team2"),
                                            heroObject.getString("series"),
                                            heroObject.getString("inn1"),
                                            null,
                                            heroObject.getString("host"));
                                    crickPrototypes.add(crickPrototype);

                                    Tab1Prototype tab1Prototype = new Tab1Prototype(crickPrototype.getTeam1(),
                                            crickPrototype.getTeam2(), crickPrototype.getHost(), crickPrototype.getSeries(),
                                            crickPrototype.getInn1(), crickPrototype.getInn2(), getMatchResult(crickPrototype.getInn1(), crickPrototype.getInn2(), crickPrototype.getTeam1(), crickPrototype.getTeam2()),
                                            country_image_map.get(crickPrototype.getTeam1()),
                                            country_image_map.get(crickPrototype.getTeam2()), country_image_map.get(crickPrototype.getHost()));
                                    tab1Prototypes.add(tab1Prototype);

                                    e.printStackTrace();
                                }

                            }
                            Toast.makeText(getApplicationContext(), "The size of the matches " + crickPrototypes.size(), Toast.LENGTH_SHORT).show();

                            loadFragement(new Tab1());
                            for (CrickPrototype crickPrototype : crickPrototypes) {
                                // Toast.makeText(getApplicationContext(), "" + crickPrototype.getSeries() + " Team : " + crickPrototype.getTeam1() + " Team2 : " + crickPrototype.getInn2(), Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //displaying the error in toast if occurrs
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        //creating a request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        //adding the string request to request queue
        requestQueue.add(stringRequest);

        //again load the home fragment
        loadFragement(new Tab1());

        ArrayList<String> country = new ArrayList<>();
        country.clear();

        for (CrickPrototype crickPrototype : crickPrototypes) {
            //let's see the data type
            if (!country.contains(crickPrototype.getTeam1())) {
                country.add(crickPrototype.getTeam1());
            }
            if (!country.contains(crickPrototype.getTeam2())) {
                country.add(crickPrototype.getTeam2());
            }

            if (!country.contains(crickPrototype.getHost())) {
                country.add(crickPrototype.getHost());
            }
        }


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

    public String getMatchResult(String inn1, String inn2, String team1_name, String team2_name) {
        if (inn2 == null) {
            return "Match Cancelled.";
        }
        int inn1_score = Integer.parseInt(inn1.split("/")[0]);
        int inn1_wicket = Integer.parseInt(inn1.split("/")[1]);
        int inn2_score = Integer.parseInt(inn2.split("/")[0]);
        int inn2_wicket = Integer.parseInt(inn2.split("/")[1]);

        if (inn1_score > inn2_score) {
            return team1_name + " wins by " + Math.abs(inn1_score - inn2_score) + " runs.";
        } else if (inn1_score < inn2_score) {
            return team2_name + " wins by " + (10 - inn2_wicket) + " wickets.";
        } else {
            return "Match Drawn!";
        }
    }


}
