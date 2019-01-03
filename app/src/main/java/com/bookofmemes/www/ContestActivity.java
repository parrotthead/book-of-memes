package com.bookofmemes.www;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class ContestActivity extends Activity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contest);

        mWebView = new WebView(this);

        mWebView.getSettings().setJavaScriptEnabled(true);

        final Activity activity = this;

        mWebView.setWebViewClient(new WebViewClient() {
            @SuppressWarnings("deprecation")
            @Override
            public void  onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();
            }
            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public  void  onReceivedError(WebView view, WebResourceRequest request, WebResourceError resourceError) {
                onReceivedError(view, resourceError.getErrorCode(), resourceError.getDescription().toString(), request.getUrl().toString());
            }
        });

        mWebView.loadUrl("http://www.google.com");
        setContentView(mWebView);

    }

}
