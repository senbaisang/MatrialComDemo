package com.sally.matrialcomdemo.component;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarFragment;
import com.roughike.bottombar.OnMenuTabSelectedListener;
import com.sally.matrialcomdemo.R;
import com.sally.matrialcomdemo.fragment.SampleFragment;
import com.sally.matrialcomdemo.util.Utils;

/**
 * Created by sally on 8/4/16.
 *
 * 只有底部button
 */
public class BottomButtonActivity extends AppCompatActivity {

    private BottomBar mBottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_button_activity);

        mBottomBar = BottomBar.attach(this, savedInstanceState);
        mBottomBar.setItemsFromMenu(R.menu.bottom_menu, new OnMenuTabSelectedListener() {
            @Override
            public void onMenuItemSelected(int menuItemId) {
                switch (menuItemId) {
                    case R.id.bottom_home:
                        Utils.showMsg(BottomButtonActivity.this, "home");
                        break;
                    case R.id.bottom_messages:
                        Utils.showMsg(BottomButtonActivity.this, "message");
                        break;
                    case R.id.bottom_discussion:
                        Utils.showMsg(BottomButtonActivity.this, "discussion");
                        break;
                    case R.id.bottom_friend:
                        Utils.showMsg(BottomButtonActivity.this, "friend");
                        break;
                }
            }
        });
    }

}
