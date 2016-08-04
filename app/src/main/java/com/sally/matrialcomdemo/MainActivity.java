package com.sally.matrialcomdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;

import com.sally.matrialcomdemo.component.BottomButtonActivity;
import com.sally.matrialcomdemo.component.BottomButtonFragmentActivity;
import com.sally.matrialcomdemo.component.CardViewActivity;
import com.sally.matrialcomdemo.component.EditTextAndDialogActivity;
import com.sally.matrialcomdemo.component.NavigationViewActivity;
import com.sally.matrialcomdemo.component.RecyclerViewActivity;
import com.sally.matrialcomdemo.component.TabLayoutActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mCardView;
    private Button mTabLayout;
    private Button mNavigationView;
    private Button mRecyclerView;
    private Button mSeeSee;
    private Button mBottomButton;
    private Button mBottomButtonFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initEvent();
    }

    private void initView() {
        mCardView = (Button) findViewById(R.id.id_cardView);
        mTabLayout = (Button) findViewById(R.id.id_tabLayout);
        mNavigationView = (Button) findViewById(R.id.id_navigation);
        mRecyclerView = (Button) findViewById(R.id.id_recycler_btn);
        mSeeSee = (Button) findViewById(R.id.id_edit_dialog);
        mBottomButton = (Button) findViewById(R.id.id_bottom_button);
        mBottomButtonFragment = (Button) findViewById(R.id.id_bottom_button_fragment);
    }

    private void initEvent() {
        mCardView.setOnClickListener(this);
        mTabLayout.setOnClickListener(this);
        mNavigationView.setOnClickListener(this);
        mRecyclerView.setOnClickListener(this);
        mSeeSee.setOnClickListener(this);
        mBottomButton.setOnClickListener(this);
        mBottomButtonFragment.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_cardView:
                startActivity(new Intent(this, CardViewActivity.class));
                break;
            case R.id.id_tabLayout:
                startActivity(new Intent(this, TabLayoutActivity.class));
                break;
            case R.id.id_navigation:
                startActivity(new Intent(this, NavigationViewActivity.class));
                break;
            case R.id.id_recycler_btn:
                startActivity(new Intent(this, RecyclerViewActivity.class));
                break;
            case R.id.id_edit_dialog:
                startActivity(new Intent(this, EditTextAndDialogActivity.class));
                break;
            case R.id.id_bottom_button:
                startActivity(new Intent(this, BottomButtonActivity.class));
                break;
            case R.id.id_bottom_button_fragment:
                startActivity(new Intent(this, BottomButtonFragmentActivity.class));
                break;
        }
    }
}
