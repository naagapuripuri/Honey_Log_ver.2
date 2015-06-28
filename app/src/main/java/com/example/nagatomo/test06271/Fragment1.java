package com.example.nagatomo.test06271;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Nagatomo on 2015/06/28.
 */
class Fragment1 extends Fragment {
    TextView text;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab1_fragment, container, false);

        text = (TextView) v.findViewById(R.id.tab1text);
        text.setText("TAB1の内容（fragment）");


        return v;
    }
}

