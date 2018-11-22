package me.vedant.interntask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Splash extends AppCompatActivity {


    private ProgressBar progressBar;
    public String json_data_url;
    public ArrayList<String> country_names;
    public ArrayList<String> country_images;

    public ArrayList<String> getCountry_names() {
        return country_names;
    }

    public void setCountry_names(ArrayList<String> country_names) {
        this.country_names = country_names;
    }

    public ArrayList<String> getCountry_images() {
        return country_images;
    }

    public void setCountry_images(ArrayList<String> country_images) {
        this.country_images = country_images;
    }

    public String getJson_data_url() {
        return json_data_url;
    }

    public void setJson_data_url(String json_data_url) {
        this.json_data_url = json_data_url;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        final ArrayList<String> list_country_names = new ArrayList<>();
        final ArrayList<String> list_country_images = new ArrayList<>();
        list_country_images.clear();
        list_country_names.clear();

        //here fetch the data from firebase database
        FirebaseDatabase.getInstance().getReference().addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String json_url = (String) dataSnapshot.child("json_data_url").getValue();
                setJson_data_url(json_url);

                DataSnapshot ds = dataSnapshot.child("country_images");
                for (DataSnapshot ds1 : ds.getChildren()) {
                    String country_name = ds1.getKey();
                    String country_image_url = (String) ds1.getValue();
                    list_country_images.add(country_image_url);
                    list_country_names.add(country_name);
                }

                setCountry_names(list_country_names);
                setCountry_images(list_country_images);
                if (getJson_data_url() != null) {
                    progressBar.setVisibility(View.INVISIBLE);
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("json_url", getJson_data_url());
                    intent.putStringArrayListExtra("country_names", getCountry_names());
                    intent.putStringArrayListExtra("country_images_url", getCountry_images());
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                progressBar.setVisibility(View.INVISIBLE);
                Toast.makeText(getApplicationContext(), "Unable to fetch data "+databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}
