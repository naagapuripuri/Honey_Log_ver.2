package com.example.nagatomo.test06271;

import android.app.Activity;
import android.content.Intent;
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
import android.webkit.WebView;
import android.webkit.WebViewClient;

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
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String URI = intent.getStringExtra("URI");
        System.out.println(URI);
        WebView webView = (WebView)findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(URI);


    }
}