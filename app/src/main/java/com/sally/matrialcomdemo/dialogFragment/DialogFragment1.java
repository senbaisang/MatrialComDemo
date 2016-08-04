package com.sally.matrialcomdemo.dialogFragment;


import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sally.matrialcomdemo.R;

/**
 * Created by sally on 8/4/16.
 */
public class DialogFragment1 extends DialogFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_fragment1, container, false);
        return view;
    }
}
