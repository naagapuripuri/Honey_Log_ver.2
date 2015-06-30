package com.example.nagatomo.test06271;

//import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.app.Activity;
import android.view.MenuItem;
import android.app.ActionBar;
import android.app.Fragment;

import java.util.ArrayList;

public class MainActivity extends Activity {
    private static final String RSS_FEED_URL = "http://news.livedoor.com/topics/rss/top.xml ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setTitle("Heell!");
        actionBar.setSubtitle("sub!");

        Fragment fragment1 = new Fragment1();
        ActionBar.Tab tab1 = actionBar.newTab();
        tab1.setText("Top");
        tab1.setTabListener(new MyTabListener(fragment1));
        actionBar.addTab(tab1);

        Fragment fragmet2 = new Fragment2();
        actionBar.addTab(actionBar.newTab().setText("Japan").setTabListener(new MyTabListener(fragmet2)));

        Fragment fragmet3 = new Fragment3();
        actionBar.addTab(actionBar.newTab().setText("overseas").setTabListener(new MyTabListener(fragmet3)));

        Fragment fragmet4 = new Fragment4();
        actionBar.addTab(actionBar.newTab().setText("IT/経済").setTabListener(new MyTabListener(fragmet4)));
        Fragment fragmet5 = new Fragment5();
        actionBar.addTab(actionBar.newTab().setText("entertainment").setTabListener(new MyTabListener(fragmet5)));





    }
}

