package com.geeksarena.afyayangu.views.general;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.geeksarena.afyayangu.R;

public class AboutCorvid19Activity extends AppCompatActivity {

    private WebView mWebView;
    private String URL = "https://www.who.int/westernpacific/emergencies/covid-19";
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_corvid19);

        progressDialog  = new ProgressDialog(AboutCorvid19Activity.this);
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

        if (isInternetPresent()) {

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
            Alert("sorry", "No internet Available");
        }

    }

    private boolean isInternetPresent() {
        ConnectivityManager connectivity = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null)
        {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null)
                for (int i = 0; i < info.length; i++)
                    if (info[i].getState() == NetworkInfo.State.CONNECTED)
                    {
                        return true;
                    }

        }
        return false;
    }

    //--------------Alert Method-----------
    private void Alert(String title, String message) {
        final PkDialog mDialog = new PkDialog(AboutCorvid19Activity.this);
        mDialog.setDialogTitle(title);
        mDialog.setDialogMessage(message);
        mDialog.setPositiveButton("OK", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialog.dismiss();
                finish();
            }
        });
        mDialog.show();
    }
}
