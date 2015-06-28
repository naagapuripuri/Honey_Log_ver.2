package com.example.nagatomo.test06271;

import android.os.Bundle;
import android.app.ListFragment;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.ListView;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;


public class MyListFragment extends ListFragment {
  //  private List<String> list;
    private ArrayAdapter<String> adapter;
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
         adapter = new ArrayAdapter<String>( getActivity(), android.R.layout.simple_list_item_1, MyList.Data);
        setListAdapter(adapter);
        //getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }
    @Override
    public void onListItemClick(ListView l,View v,int pos,long id) {
        showDetails(pos);
    }
    private void showDetails(int index) {
        //    Context context=getActivity().getApplication();
            getListView().setItemChecked(index,false);
        //    Intent intent=new Intent(context,DetailActivity.class);
            Intent intent=new Intent(getActivity(),DetailActivity.class);
       //     intent.putExtra("index",index);
            getActivity().startActivity(intent);
    }
}

