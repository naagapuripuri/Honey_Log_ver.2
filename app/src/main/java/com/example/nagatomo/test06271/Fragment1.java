package com.example.nagatomo.test06271;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Nagatomo on 2015/06/28.
 */
class Fragment1 extends Fragment {
    TextView text;
    private static final String RSS_FEED_URL = "http://news.livedoor.com/topics/rss/top.xml ";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab1_fragment, container, false);

       // text = (TextView) v.findViewById(R.id.tab1text);
       // text.setText("TAB1の内容（fragment）");

        return v;
    }

    public void onDestroyView() {
        super.onDestroyView();
        FragmentManager fm = getActivity().getFragmentManager();
        Fragment fragment = (fm.findFragmentById(R.id.booklistFragment1));
        FragmentTransaction ft = fm.beginTransaction();
        ft.remove(fragment);
        ft.commit();
    }


}

