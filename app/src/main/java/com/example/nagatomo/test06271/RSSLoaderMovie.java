package com.example.nagatomo.test06271;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Nagatomo on 2015/07/01.
 */
public class RSSLoaderMovie extends AsyncTaskLoader<String[][]> {//非同期処理を行うクラス。非同期で動作するクラス。必要なのはsuperにコンテキストを渡すコンストラクタと非同期処理を行うloadInBackground()。
    String[] target;
    String[][] array2dim;
    String src;
    int titlecount =0;
    int urlcount =0;
    int descrcount =0;
    int timecount =0;
    private String[][] data;
    public RSSLoaderMovie(Context context) {
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
      /*
            //URL で指定されたコンテンツを HTTP で取得する大まかな流れは以下
            URL url ;                                          //クラスの参照型変数の宣言
            url = new URL("http://news.livedoor.com/topics/rss/top.xml");                  //クラスのインスタンスを生成し、その参照を参照型変数に入れる。URL オブジェクトを生成する。
            http = (HttpURLConnection) url.openConnection();   //接続用HttpURLConnectionオブジェクト作成。サイトに接続
            http.setRequestMethod("GET");                      // リクエストメソッドの設定 （デフォルトが GET メソッドなので省略可）。プロトコルの設定
            http.connect();                                    //接続する．
            in = http.getInputStream();                        // ネット上のファイルを開く。

            src = "";                                   // InputStreamから取得したbyteデータを文字列にして保持するための変数。初期値として空文字（長さが0の文字列）
            byte[] line = new byte[1024];                      // InputStreamからbyteデータを取得するための変数
            int size;
            while (true) {                                     // while内で、InputStreamからのデータを文字列として取得する
                size = in.read(line);                          //ネット上のファイルから１バイトのデータが読み取られ、int型の変数にセット
                if (size <= 0)
                    break;
                src += new String(line);
            }
*/
            target = new String[20];
            array2dim = new String[4][20];
            XmlPullParser xmlPullParser = Xml.newPullParser();
            Fragment7 s7 = new Fragment7();
            String s = s7.RSS_FEED_URL;
            //String s = "http://news.livedoor.com/topics/rss/top.xml";
            URL Url = new URL(s);
            URLConnection connection = Url.openConnection();
            xmlPullParser.setInput(connection.getInputStream(), "UTF-8");

            int eventType;
            while ((eventType = xmlPullParser.next()) != XmlPullParser.END_DOCUMENT) {
                String htmlsrc = null;
                String titletag = null;
                String urltag = null;
                if (eventType == XmlPullParser.START_TAG) {
                    htmlsrc = xmlPullParser.getName();
                    if("title".equals(htmlsrc)){
                        titletag = xmlPullParser.nextText();
                        Log.d("XmlPullParserSampleUrl", titletag);
                        target[titlecount] = titletag;
                        array2dim[0][titlecount] = titletag;
                        titlecount = titlecount +1;
                    }
                    else if("link".equals(htmlsrc)){
                        urltag  = xmlPullParser.nextText();
                        Log.d("XmlPullParserSampleUrl",  urltag );
                        array2dim[1][urlcount] =  urltag ;
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
            }
        } catch (Exception e) {
            //  web.setText(e.toString());
            Log.d("catch", "エラー");
        } finally {
            try {
                if (http != null)
                    http.disconnect();
                if (in != null)
                    in.close();
            } catch (Exception e) {
            }
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
