package com.geeksarena.afyayangu.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;

import com.geeksarena.afyayangu.views.general.AboutCorvid19Activity;
import com.geeksarena.afyayangu.views.general.PkDialog;

public class UtilityFunctions {

    public static boolean isInternetPresent(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
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
    public static void Alert(Context context, String title, String message) {
        final PkDialog mDialog = new PkDialog(context);
        mDialog.setDialogTitle(title);
        mDialog.setDialogMessage(message);
        mDialog.setPositiveButton("OK", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialog.dismiss();
                //finish();
            }
        });
        mDialog.show();
    }
}
