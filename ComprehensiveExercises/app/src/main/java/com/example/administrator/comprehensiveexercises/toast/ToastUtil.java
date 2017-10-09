package com.example.administrator.comprehensiveexercises.toast;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/9/15.
 */

public class ToastUtil {
    public static Toast toast;

    public static void toastShow(Context context, String info) {
        if (toast == null) {
            toast = Toast.makeText(context, info, Toast.LENGTH_SHORT);
            toast.show();
        } else {
            toast.setText(info);
            toast.show();
        }
    }

}
