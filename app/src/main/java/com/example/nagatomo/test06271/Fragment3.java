package com.example.nagatomo.test06271;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.util.Log;

/**
 * Created by Nagatomo on 2015/06/28.
 */
public class Fragment3 extends Fragment {
    TextView text;
    static final String TAG = "FragmentTest";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab3_fragment, container, false);

        text = (TextView) v.findViewById(R.id.tab3text);
        text.setText("TAB3の内容（fragment）");

        return v;
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

}