package com.bawei.dongyong20191127;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import java.util.IdentityHashMap;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private Button butt;
    private WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();

    }

    @SuppressLint("JavascriptInterface")
    private void initView() {
        butt = (Button) findViewById(R.id.butt);
        web = (WebView) findViewById(R.id.web);

        butt.setOnClickListener(this);
        WebSettings settings = web.getSettings();
        settings.setJavaScriptEnabled(true);
        web.addJavascriptInterface(new MyDemo(),"buyNow");
        settings.setJavaScriptCanOpenWindowsAutomatically(true);

        web.loadUrl("view-source:file:///C:/Users/ASUS/AppData/Local/Temp/HZ$D.089.2099/HZ$D.089.2101/%E4%B8%93%E9%AB%984%E3%80%8AAndroid%E7%94%B5%E5%95%86%E9%A1%B9%E7%9B%AE%E5%AE%9E%E6%88%98%E3%80%8BB%E5%8D%B7/B%E5%8D%B7/%E7%B4%A0%E6%9D%90/info.html");
     web.setWebViewClient(new WebViewClient());
     web.setWebChromeClient(new WebChromeClient());

    }

    class  MyDemo{
        public  void buyNow(){
            Toast.makeText(Main2Activity.this, "购买成功", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.butt:
               web.loadUrl("javascript:changeNum(val)");
                break;
        }
    }
}
