package com.example.vv.fragments;

import android.app.Fragment;
import android.app.FragmentManagerNonConfig;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;

public class MainActivity extends AppCompatActivity{

    TitleFragment title = new TitleFragment();
    WebFragment web = new WebFragment();

    FragmentManager fragmentManager = getSupportFragmentManager();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle bundle = new Bundle();
        bundle.putString("abc", "abc");
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            fragmentManager.beginTransaction().add(R.id.title, title).addToBackStack(null).commit();
            fragmentManager.beginTransaction().add(R.id.web, web).addToBackStack(null).commit();
        }
        else {
            fragmentManager.beginTransaction().add(R.id.title, title).addToBackStack(null).commit();
        }
    }

    public void setUrl(String url) {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            web.showUrl(url);
        }
        else {
            fragmentManager.beginTransaction().replace(R.id.web1, web).addToBackStack(null).commit();
            web.showUrl(url);
        }
    }
}
