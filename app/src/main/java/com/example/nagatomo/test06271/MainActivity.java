package com.example.nagatomo.test06271;

//import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.app.Activity;
import android.view.MenuItem;
import android.app.ActionBar;
import android.app.Fragment;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;


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
        actionBar.addTab(actionBar.newTab().setText("タブタイトル2")
                .setTabListener(new MyTabListener(fragmet2)));

        Fragment fragmet3 = new Fragment3();
        actionBar.addTab(actionBar.newTab().setText("タブタイトル3")
                .setTabListener(new MyTabListener(fragmet3)));

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

