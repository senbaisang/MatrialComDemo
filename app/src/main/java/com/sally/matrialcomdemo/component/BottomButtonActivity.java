package com.sally.matrialcomdemo.component;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarFragment;
import com.roughike.bottombar.OnMenuTabSelectedListener;
import com.sally.matrialcomdemo.R;
import com.sally.matrialcomdemo.fragment.SampleFragment;

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
                        showMsg("home");
                        break;
                    case R.id.bottom_messages:
                        showMsg("message");
                        break;
                    case R.id.bottom_discussion:
                        showMsg("discussion");
                        break;
                    case R.id.bottom_friend:
                        showMsg("friend");
                        break;
                }
            }
        });
    }

    private void showMsg(String text) {
        Toast.makeText(BottomButtonActivity.this, text, Toast.LENGTH_SHORT).show();
    }
}
