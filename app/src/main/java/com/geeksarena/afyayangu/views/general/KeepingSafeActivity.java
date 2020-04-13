package com.geeksarena.afyayangu.views.general;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.geeksarena.afyayangu.R;
import com.geeksarena.afyayangu.utils.UtilityFunctions;

public class KeepingSafeActivity extends AppCompatActivity {
    private WebView mWebView;
    private String URL = "https://www.who.int/emergencies/diseases/novel-coronavirus-2019/advice-for-public";
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keeping_safe);

        progressDialog  = new ProgressDialog(KeepingSafeActivity.this);
        progressDialog.setMessage("please wait ...");
        progressDialog.setCanceledOnTouchOutside(false);
        mWebView = findViewById(R.id.mywebview);

        // Enable Javascript to run in WebView
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setDomStorageEnabled(true);
        mWebView.requestFocus(View.FOCUS_DOWN);

        // Allow Zoom in/out controls
        mWebView.getSettings().setBuiltInZoomControls(false);

        // Zoom out the best fit your screen
        mWebView.getSettings().setLoadWithOverviewMode(true);
        mWebView.getSettings().setUseWideViewPort(true);
        mWebView.getSettings().setAllowFileAccess(true);

        mWebView.setWebViewClient(new WebViewClient());

        if (UtilityFunctions.isInternetPresent(KeepingSafeActivity.this)) {

            mWebView.loadUrl(URL);

            mWebView.setWebChromeClient(new WebChromeClient() {
                @Override
                public void onProgressChanged(WebView view, int progress) {



                    if (progress < 100 ) {
                        progressDialog.show();
                    }

                    if (progress == 100) {
                        progressDialog.dismiss();
                    }
                }
            });

        } else {
            UtilityFunctions.Alert(KeepingSafeActivity.this, "sorry", "No internet Available");
        }


    }
}
