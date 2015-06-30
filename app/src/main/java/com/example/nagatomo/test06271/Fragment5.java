package com.example.nagatomo.test06271;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Nagatomo on 2015/06/30.
 */
public class Fragment5 extends Fragment {
    static final String TAG = "FragmentTest";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab5_fragment, container, false);
        return v;
    }
    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    public void onDestroyView() {
        super.onDestroyView();
        FragmentManager fm = getActivity().getFragmentManager();
        Fragment fragment = (fm.findFragmentById(R.id.booklistFragment5));
        FragmentTransaction ft = fm.beginTransaction();
        ft.remove(fragment);
        ft.commit();
    }
}