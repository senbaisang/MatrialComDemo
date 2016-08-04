package com.sally.matrialcomdemo.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by sally on 8/4/16.
 */
public class Utils {

    public static void showMsg(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }

}
