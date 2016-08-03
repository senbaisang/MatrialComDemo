package com.sally.matrialcomdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sally.matrialcomdemo.R;

/**
 * Created by sally on 8/3/16.
 */
public class SampleFragment extends Fragment {

    private static final String SAMPLE_FRAGMENT = "sampleFragment";

    public SampleFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        String string = getArguments().getString(SAMPLE_FRAGMENT);

        TextView tv = new TextView(getActivity());
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        tv.setLayoutParams(lp);
        tv.setGravity(Gravity.CENTER);
        tv.setText(string);
        tv.setTextColor(getResources().getColor(R.color.tab_bar));
        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 66);

        return tv;
    }

    public static SampleFragment newInstance(String text) {
        SampleFragment sampleFragment = new SampleFragment();
        Bundle bundle = new Bundle();
        bundle.putString(SAMPLE_FRAGMENT, text);
        sampleFragment.setArguments(bundle);
        return sampleFragment;
    }
}
