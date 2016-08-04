package com.sally.matrialcomdemo.component;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sally.matrialcomdemo.R;
import com.sally.matrialcomdemo.adapter.RecyclerViewAdapter;
import com.sally.matrialcomdemo.bean.NewsBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sally on 8/4/16.
 */
public class RecyclerViewActivity extends AppCompatActivity {

    private CoordinatorLayout mCoordinatorLayout;
    private TabLayout mTabLayout;
    private RecyclerView mRecyclerView;

    private RecyclerViewAdapter mAdapter;

    private List<NewsBean> news;
    private NewsBean myNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_activity);

        initView();
        initDats();
        initEvent();
    }

    private void initEvent() {
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        for(NewsBean mNew : news) {
            mTabLayout.addTab(mTabLayout.newTab().setText(mNew.getTitle()));
        }

        mAdapter = new RecyclerViewAdapter(news, this);
        mRecyclerView.setAdapter(mAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void initDats() {
        news = new ArrayList<>();
        myNew = new NewsBean("first book", "first book content", R.drawable.book1);
        news.add(myNew);
        myNew = new NewsBean("second book", "second book content", R.drawable.book2);
        news.add(myNew);
        myNew = new NewsBean("third book", "third book content", R.drawable.book3);
        news.add(myNew);
        myNew = new NewsBean("fourth book", "first book content", R.drawable.book4);
        news.add(myNew);
        myNew = new NewsBean("fifth book", "fifth book content", R.drawable.book5);
        news.add(myNew);
        myNew = new NewsBean("sixth book", "sixth book content", R.drawable.book1);
        news.add(myNew);
        myNew = new NewsBean("seventh book", "seventh book content", R.drawable.book4);
        news.add(myNew);
        myNew = new NewsBean("eighth book", "eighth book content", R.drawable.book3);
        news.add(myNew);
        myNew = new NewsBean("ninth book", "ninth book content", R.drawable.book2);
        news.add(myNew);

    }

    private void initView() {
        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.id_main_content);
        mTabLayout = (TabLayout) findViewById(R.id.id_tabLayout);
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recycler_view);
    }

}
