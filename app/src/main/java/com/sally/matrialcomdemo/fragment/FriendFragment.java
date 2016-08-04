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
 * Created by sally on 8/4/16.
 */
public class FriendFragment extends Fragment {

    private static final String FRIEND_FRAGMENT = "friendFragment";

    public FriendFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        String string = getArguments().getString(FRIEND_FRAGMENT);

        TextView tv = new TextView(getActivity());
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        tv.setLayoutParams(lp);
        tv.setGravity(Gravity.CENTER);
        tv.setText(string);
        tv.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 66);

        return tv;
    }

    public static FriendFragment newInstance(String text) {
        FriendFragment friendFragment = new FriendFragment();
        Bundle bundle = new Bundle();
        bundle.putString(FRIEND_FRAGMENT, text);
        friendFragment.setArguments(bundle);
        return friendFragment;
    }
}
