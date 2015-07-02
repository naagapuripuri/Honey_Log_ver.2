package com.example.nagatomo.test06271;

/**
 * Created by Nagatomo on 2015/06/30.
 */
import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class RSSLoader extends AsyncTaskLoader<String[][]>{//非同期処理を行うクラス。非同期で動作するクラス。必要なのはsuperにコンテキストを渡すコンストラクタと非同期処理を行うloadInBackground()。
    String[] target;
    String[][] array2dim;
    String src;
    int titlecount =0;
    int urlcount =0;
    int descrcount =0;
    int timecount =0;
    private String[][] data;
    public RSSLoader(Context context) {
        super(context);
    }

    @Override
    public void deliverResult(String[][] data) {
        if (isReset()) {
            return;
        }

        this.data = data;
        super.deliverResult(data);
    }





    @Override
    public String[][] loadInBackground() { // 非同期で動くワーカーの作成。Loderが実行するバックグラウンド処理。UIスレッドとは別のスレッドで実行されるメソッド
        HttpURLConnection http = null;
        InputStream in = null;
        try {
           // target = new String[20];
            array2dim = new String[4][20];
            XmlPullParser xmlPullParser = Xml.newPullParser();
            Fragment1 s1 = new Fragment1();
            String s = s1.RSS_FEED_URL;
            URL Url = new URL(s);
            URLConnection connection = Url.openConnection();
            xmlPullParser.setInput(connection.getInputStream(), "UTF-8");

            int eventType = xmlPullParser.getEventType();
            while (eventType  != XmlPullParser.END_DOCUMENT) {
                String htmlsrc = null;
                String titletag = null;
                String urltag = null;
                if (eventType == XmlPullParser.START_TAG) {
                    htmlsrc = xmlPullParser.getName();
                    if("title".equals(htmlsrc)){
                   //     titletag = xmlPullParser.nextText();
                   //     Log.d("XmlPullParserSampleUrl",  xmlPullParser.nextText());
                   //     target[titlecount] =  xmlPullParser.nextText();
                        array2dim[0][titlecount] =  xmlPullParser.nextText();
                        titlecount = titlecount +1;
                    }
                    else if("link".equals(htmlsrc)){
                   //     urltag  = xmlPullParser.nextText();
                   //     Log.d("XmlPullParserSampleUrl",  xmlPullParser.nextText() );
                        array2dim[1][urlcount] =   xmlPullParser.nextText() ;
                        urlcount = urlcount +1;
                    }
                    else if("description".equals(htmlsrc)){
                        array2dim[2][descrcount] =  xmlPullParser.nextText();;
                        descrcount = descrcount +1;
                    }
                    else if("pubDate".equals(htmlsrc)){
                        array2dim[3][timecount] =  xmlPullParser.nextText();;
                        timecount = timecount +1;
                    }
                }
                eventType = xmlPullParser.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //target[0] = src;
        return array2dim;
    }

  //  @Override
  //  protected void onStartLoading() {// Loader開始時に呼ばれる
      //  forceLoad();// Loaderを開始
    //}

    @Override
    protected void onStartLoading() {//// 非同期処理の開始前。ActivityまたはFragment復帰時（バックキーで戻る、ホーム画面から戻る等）に再実行されるためここで非同期処理を行うかチェック
        if (data != null) {
            deliverResult(data);
        }

        if (takeContentChanged() || data == null) {
            forceLoad();
        }
    }

    @Override
    protected void onStopLoading() {
        cancelLoad();
    }

    @Override
    protected void onReset() {
        super.onReset();
        onStopLoading();
        data = null;
    }
}
