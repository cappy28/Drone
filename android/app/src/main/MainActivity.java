package com.dronexp.app;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.*;
import android.view.WindowManager;
import android.graphics.Color;

public class MainActivity extends Activity {
    private WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().setStatusBarColor(Color.parseColor("#080a0f"));
        setContentView(R.layout.activity_main);
        wv = findViewById(R.id.webview);
        WebSettings s = wv.getSettings();
        s.setJavaScriptEnabled(true);
        s.setDomStorageEnabled(true);
        s.setAllowFileAccessFromFileURLs(true);
        s.setAllowUniversalAccessFromFileURLs(true);
        s.setCacheMode(WebSettings.LOAD_NO_CACHE);
        s.setDatabaseEnabled(true);
        s.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        wv.setBackgroundColor(Color.parseColor("#080a0f"));
        wv.setWebViewClient(new WebViewClient() {
            @Override public boolean shouldOverrideUrlLoading(WebView v, String url) {
                return false;
            }
        });
        wv.setWebChromeClient(new WebChromeClient());
        wv.loadUrl("file:///android_asset/www/index.html");
    }
    @Override public void onBackPressed() {
        if (wv.canGoBack()) wv.goBack(); else super.onBackPressed();
    }
}
