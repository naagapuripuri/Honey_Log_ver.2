package com.example.nagatomo.test06271;

//import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.app.Activity;
import android.view.MenuItem;
import android.app.ActionBar;
import android.app.Fragment;
import android.graphics.drawable.ColorDrawable;
import android.graphics.Color;
import android.widget.Toolbar;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ColorDrawable colorDrawable = new ColorDrawable();
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setTitle("Heell!");
        actionBar.setSubtitle("sub!");
        colorDrawable.setColor(0xffFEBB31);
        actionBar.setBackgroundDrawable(colorDrawable);
        actionBar.setStackedBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));



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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

