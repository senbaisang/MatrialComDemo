package com.sally.matrialcomdemo.component;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sally.matrialcomdemo.R;


/**
 * Created by sally on 8/3/16.
 */
public class CardViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_view_activity);

        getSupportActionBar().setTitle(R.string.card_view);
    }
}
