package com.example.nagatomo.test06271;

import android.os.Bundle;
import android.app.ListFragment;
import android.view.View;
import android.widget.ListView;
import android.content.Intent;
import java.util.List;
import java.util.ArrayList;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;

public class MyListFragment extends ListFragment implements LoaderCallbacks<String[]>{// LoaderCallbacksのジェネリクスには、Loaderの戻り値の型を指定する(今回はString)。Workerを作成、実行、結果を受け取るクラス。
  //  private ArrayAdapter<String> adapter;①
    private static final String RSS_FEED_URL = "http://news.livedoor.com/topics/rss/top.xml ";
    public FragListAdapter adapter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getLoaderManager().initLoader(0, null, this);//ローダーを実行
/* ここから*/
        List<Item> objects = new ArrayList<Item>();/////

           //   for(int l=0;l<4;l++){
           //     System.out.println(tagurl[l]);
           // }

          Item item1 = new Item();
          item1.setTitle("ひとつめ");

          Item item2 = new Item();
          item2.setTitle("2つめ");

          String s3 = "さん";
          Item item3 = new Item();
          item3.setTitle(s3);

          Item item[] = new Item[10];
          for(int i=0; i<10; i++){
            item[i] = new Item();
          }
          item[0].setTitle("４");
          item[1].setTitle("ご");
          item[2].setTitle("しっくす");
          objects.add(item1);
          objects.add(item2);
          objects.add(item3);
          for(int j = 0 ;j<3 ;j++){
            objects.add(item[j]);
          }
          adapter = new FragListAdapter(getActivity(), objects);
          /* ここまでを消して下の1文と①を入れると、MyListの方とりにいく*////
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










    @Override
    public RSSLoader onCreateLoader(int arg0, Bundle arg1) {//ワーカーの作成など、非同期処理の初期化
        return new RSSLoader(getActivity());  //
    }

    // after bg process invoke onLoadFinished() who work in ui thread
    @Override
    public void onLoadFinished(Loader<String[]> loader, String[] data) {//loadInBackgroundの返り値がString型配列dataに入ってくる
        //setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, data) );
        System.out.println("finish");
        System.out.println(data[0]);
    }

    @Override
    public void onLoaderReset(Loader<String[]> arg0) {
        // TODO Auto-generated method stub

    }
}

