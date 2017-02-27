package com.example.fkz.phoneandmessagejs;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
    private WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init() {
        mWebView= (WebView) findViewById(R.id.webview);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.addJavascriptInterface(MainActivity.this, "fkz");
        mWebView.loadUrl("file:///android_asset/web.html");
    }
    @JavascriptInterface
    public void call(String text){
        Intent i=new Intent();
        i.setAction(Intent.ACTION_CALL);
        i.setData(Uri.parse("tel:"+text));
        startActivity(i);
    }
    @JavascriptInterface
    public void open(String text){
        startActivity(new Intent(MainActivity.this,Mainb.class));
    }
}
