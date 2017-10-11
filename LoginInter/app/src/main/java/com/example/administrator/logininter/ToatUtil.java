package com.example.administrator.logininter;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/8/23.
 */

public class ToatUtil {
    private static Toast toat;

    public static void showToast(Context context, String info) {
        if (toat == null) {
            toat = Toast.makeText(context, info, Toast.LENGTH_SHORT);
            toat.show();
        } else {
            toat.setText(info);
            toat.show();
        }
    }
}
