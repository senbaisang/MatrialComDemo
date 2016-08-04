package com.sally.matrialcomdemo.component;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarBadge;
import com.roughike.bottombar.BottomBarFragment;
import com.roughike.bottombar.OnTabSelectedListener;
import com.sally.matrialcomdemo.R;
import com.sally.matrialcomdemo.fragment.SampleFragment;
import com.sally.matrialcomdemo.util.Utils;

/**
 * Created by sally on 8/4/16.
 */
public class BottomButtonFragmentActivity extends AppCompatActivity {

    private BottomBar mBottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_button_fragment_activity);

        mBottomBar = BottomBar.attach(this, savedInstanceState);
        mBottomBar.setFragmentItems(getSupportFragmentManager(), R.id.id_container,
                new BottomBarFragment(SampleFragment.newInstance("home"), R.drawable.ic_local_dining_white_24dp, "home"),
                new BottomBarFragment(SampleFragment.newInstance("message"), R.drawable.ic_location_on_white_24dp, "message"),
                new BottomBarFragment(SampleFragment.newInstance("discussion"), R.drawable.ic_favorite_white_24dp, "discussion"),
                new BottomBarFragment(SampleFragment.newInstance("friend"), R.drawable.ic_update_white_24dp, "friend"));

        mBottomBar.mapColorForTab(0, "#3B494C");
        mBottomBar.mapColorForTab(1, "#00796B");
        mBottomBar.mapColorForTab(2, "#7B1FA2");
        mBottomBar.mapColorForTab(3, "#FF5252");

        mBottomBar.setOnItemSelectedListener(new OnTabSelectedListener() {
            @Override
            public void onItemSelected(int position) {
                switch (position) {
                    case 0:
                        Utils.showMsg(BottomButtonFragmentActivity.this, "hei");
                        break;
                    case 1:
                        Utils.showMsg(BottomButtonFragmentActivity.this, "ha");
                        break;
                    case 2:
                        Utils.showMsg(BottomButtonFragmentActivity.this, "hei");
                        break;
                    case 3:
                        Utils.showMsg(BottomButtonFragmentActivity.this, "ha");
                        break;
                }
            }
        });

        // 添加未读气泡
        BottomBarBadge unreadMessage = mBottomBar.makeBadgeForTabAt(1, "#E91E63", 4);
        unreadMessage.show();

    }

}
