package com.example.administrator.mylogintert;


import android.content.Context;
import android.widget.Toast;

public class ToastUtil {
    private static Toast toast;

    public static void showToast(Context context, String info) {
        if (toast == null) {
            toast = Toast.makeText(context, info, Toast.LENGTH_SHORT);
            toast.show();
        } else {
            toast.setText(info);
            toast.show();
        }

    }
}
