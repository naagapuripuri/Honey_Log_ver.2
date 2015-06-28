package com.example.nagatomo.test06271;

//import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.app.Activity;
import android.view.MenuItem;
import android.app.ActionBar;
import android.app.Fragment;

public class MainActivity extends Activity {
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
        tab1.setText("タブタイトル1");
        tab1.setTabListener(new MyTabListener(fragment1));
        actionBar.addTab(tab1);

        Fragment fragmet2 = new Fragment2();
        actionBar.addTab(actionBar.newTab().setText("タブタイトル2").setTabListener(new MyTabListener(fragmet2)));

        Fragment fragmet3 = new Fragment3();
        actionBar.addTab(actionBar.newTab().setText("タブタイトル3").setTabListener(new MyTabListener(fragmet3)));

        Fragment fragmet4 = new Fragment4();
        actionBar.addTab(actionBar.newTab().setText("タブタイトル4").setTabListener(new MyTabListener(fragmet4)));
    }
}

