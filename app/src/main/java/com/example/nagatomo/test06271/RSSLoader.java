package com.example.nagatomo.test06271;

/**
 * Created by Nagatomo on 2015/06/30.
 */
import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class RSSLoader extends AsyncTaskLoader<String[]>{//非同期処理を行うクラス。非同期で動作するクラス。必要なのはsuperにコンテキストを渡すコンストラクタと非同期処理を行うloadInBackground()。
    String[] target;
    String src;
    public RSSLoader(Context context) {
        super(context);
    }
    @Override
    public String[] loadInBackground() { // 非同期で動くワーカーの作成。Loderが実行するバックグラウンド処理。UIスレッドとは別のスレッドで実行されるメソッド
        HttpURLConnection http = null;
        InputStream in = null;
        try {
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
        target = new String[10];
        target[0] = src;
        return target;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

}
