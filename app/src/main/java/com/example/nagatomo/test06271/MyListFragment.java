package com.example.nagatomo.test06271;

import android.os.Bundle;
import android.app.ListFragment;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.ListView;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import java.util.List;
import java.util.ArrayList;

public class MyListFragment extends ListFragment {
    private ArrayAdapter<String> adapter;
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
/* ここから*/
        List<Item> objects = new ArrayList<Item>();/////
        Item item1 = new Item();
        item1.setTitle("ひとつめ");

        Item item2 = new Item();
        item2.setTitle("2つめ");

        Item item3 = new Item();
        item3.setTitle("さーん");

        objects.add(item1);
        objects.add(item2);
        objects.add(item3);
        FragListAdapter adapter = new FragListAdapter(getActivity(), objects);
        /* ここまでを消して下の1文を入れると、MyListの方とりにいく*////
//         adapter = new ArrayAdapter<String>( getActivity(), android.R.layout.simple_list_item_1,MyList.Data);
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

