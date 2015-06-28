package com.example.nagatomo.test06271;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.app.FragmentTransaction;
import android.app.FragmentManager;
/**
 * Created by Nagatomo on 2015/06/28.
 */
public class Fragment4 extends Fragment {
    static final String TAG = "FragmentTest";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab4_fragment, container, false);

      //  MyListFragment fragment = new MyListFragment();
        //MyListFragment details = (MyListFragment)
          //      getFragmentManager().findFragmentById(R.id.booklistFragment4);
      //  FragmentManager manager = getFragmentManager();
      //  FragmentTransaction tx = manager.beginTransaction();
       // tx.add(R.id.booklistFragment4, fragment, "list_fragment");
      //  tx.commit();

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
        Fragment fragment = (fm.findFragmentById(R.id.booklistFragment4));
        FragmentTransaction ft = fm.beginTransaction();
        ft.remove(fragment);
        ft.commit();
    }
}

