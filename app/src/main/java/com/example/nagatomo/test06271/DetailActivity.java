package com.example.nagatomo.test06271;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.util.Xml;
import android.os.StrictMode;
import org.xmlpull.v1.XmlPullParser;
import android.content.AsyncTaskLoader;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import android.app.LoaderManager;
import android.content.Loader;
/**
 * Created by Nagatomo on 2015/06/28.
 */
public class DetailActivity extends Activity {

    int count =0;
    private String target;
    private String ss;
    private String ss3;
    private String ss4[] = new String[4];
    private String tagurl[] = new String[20];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("標準出力です。");
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
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
            String src = "";                                   // InputStreamから取得したbyteデータを文字列にして保持するための変数。初期値として空文字（長さが0の文字列）
            byte[] line = new byte[1024];                      // InputStreamからbyteデータを取得するための変数
            int size;
            while (true) {                                     // while内で、InputStreamからのデータを文字列として取得する
                size = in.read(line);                          //ネット上のファイルから１バイトのデータが読み取られ、int型の変数にセット
                if (size <= 0)
                    break;
                src += new String(line);
            }

            System.out.println("標準出力です。2");
            System.out.println(src);

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
    }
}