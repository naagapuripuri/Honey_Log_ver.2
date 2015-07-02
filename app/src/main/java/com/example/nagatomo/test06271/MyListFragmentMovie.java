package com.example.nagatomo.test06271;

import android.app.AlertDialog;
import android.app.ListFragment;
import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.View;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Nagatomo on 2015/07/01.
 */
public class MyListFragmentMovie extends ListFragment implements LoaderManager.LoaderCallbacks<String[][]> {// LoaderCallbacksのジェネリクスには、Loaderの戻り値の型を指定する(今回はString)。Workerを作成、実行、結果を受け取るクラス。
    //  private ArrayAdapter<String> adapter;①
    private ArrayList<Item> objects;
    public FragListAdapter adapter;
    private TextView tv;
    private AlertDialog.Builder builder;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getLoaderManager().initLoader(0, null, this);//ローダーを実行
        //initLoaderメソッドを利用し、このActivityに対応づけるLoaderの初期化を行う。
        //LoaderManagerのインスタンスは、Activityごとに1つ割り当てられ、何度getLoaderManagerを実行しても、同じLoaderManagerインスタンスが戻される。
        //initLoader(int id, Bundle bundle, LoaderCallback)
        //id: Loaderを識別するID値（onCreateLoaderメソッドの第1引数に渡される）
        //bundle:パラメータ格納用（onCreateLoaderメソッドの第2引数に渡される）
        //LoaderCallback:LoaderCallbackインターフェースを実装したクラス




/* ここから*/
   /*///////     List<Item> objects = new ArrayList<Item>();/////

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
          adapter = new FragListAdapter(getActivity(), objects);  ///////*/
          /* ここまでを消して下の1文と①を入れると、MyListの方とりにいく*///
        //         adapter = new ArrayAdapter<String>( getActivity(), android.R.layout.simple_list_item_1,MyList.Data);
        ///////////////     setListAdapter(adapter);
        //getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }


    @Override
    public void onListItemClick(ListView l,View v,int pos,long id) {
        // showDetails(pos);

        builder = new AlertDialog.Builder(getActivity());
        Item items = objects.get(pos);
        CharSequence URL = items.getURL();
        builder.setTitle(items.getTitle());
        CharSequence descr = items.getDescription();
        String string = (String) descr;
        CharSequence cs1 = Html.fromHtml(string);
        tv = new TextView(getActivity());
        // tv.setAutoLinkMask(Linkify.WEB_URLS);
        ScrollView sv = new ScrollView(getActivity());
        sv.addView(tv);
        builder.setView(sv);
        final AlertDialog dialog = builder.create();
        dialog.show();
        tv.setText(cs1);
        //String url = URL.toString();
        //toastMake(url, 180, 30);
        //webViewに飛ばす
        HandleableLinkMovementMethod linkMethod = new HandleableLinkMovementMethod();
        linkMethod.setOnUrlClickListener(new HandleableLinkMovementMethod.OnUrlClickListener() {
            @Override
            public void onUrlClick(Uri uri) {
                // ここでuriを使ってWebView表示用のIntentを飛ばしたりする
                String URI = String.valueOf(uri);
                System.out.println(URI);
                dialog.dismiss();
                toastMake(URI, 180, 30);
                Intent intent=new Intent(getActivity(),DetailActivity.class);
                intent.putExtra("URI",URI);
                getActivity().startActivity(intent);
            }
        });
        tv.setMovementMethod(linkMethod);
    }


    private void toastMake(String message, int x, int y){
        Toast toast = Toast.makeText(getActivity(), message, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER|Gravity.LEFT, x, y);
        toast.show();
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
    public RSSLoaderMovie onCreateLoader(int arg0, Bundle arg1) {//ワーカーの作成など、非同期処理の初期化
        return new RSSLoaderMovie(getActivity());  //
    }

    // after bg process invoke onLoadFinished() who work in ui thread
    @Override
    public void onLoadFinished(Loader<String[][]> loader, String[][] data) {//loadInBackgroundの返り値がString型配列dataに入ってくる
        //setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, data) );
        System.out.println("finish");
        System.out.println(data[1][1]);
        objects = new ArrayList<Item>();/////
        //   for(int l=0;l<4;l++){
        //     System.out.println(tagurl[l]);
        // }

 /*       Item item1 = new Item();
        item1.setTitle("ひとつめ");

        Item item2 = new Item();
        item2.setTitle("2つめ");

        String s3 = "さん";
        Item item3 = new Item();
        item3.setTitle(s3);

*/
        // Item itemtitle[] = new Item[20];
        // Item itemurl[] = new Item[20];
        Item itemcontents = null;
        for(int i=1; i<19; i++){
            itemcontents = new Item();
            itemcontents.setTitle(data[0][i]);
            itemcontents.setURL(data[1][i + 1]);
            itemcontents.setDescription(data[2][i]);
        //    data[3][i-1] = data[3][i-1].replaceAll("\\+0900", "");
            itemcontents.setPubDate(data[3][i-1]);
            objects.add(itemcontents);
            //   itemtitle[i] = new Item();
            //   itemtitle[i].setTitle(data[0][i]);
            //   itemurl[i] = new Item();
            //   itemurl[i].setPubDate(data[1][i]);
        }
        //  item[0].setTitle("４");
        // item[1].setTitle("ご");
        // item[2].setTitle("しっくす");
        //       objects.add(item1);
        //       objects.add(item2);
        //       objects.add(item3);
        //   for(int j = 1 ;j<15 ;j++){
        //       objects.add(itemtitle[j]);
        //   }

        adapter = new FragListAdapter(getActivity(), objects);
        setListAdapter(adapter);
    }

    @Override
    public void onLoaderReset(Loader<String[][]> arg0) {
        // TODO Auto-generated method stub

    }
}

