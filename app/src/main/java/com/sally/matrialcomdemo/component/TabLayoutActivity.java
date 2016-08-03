package com.sally.matrialcomdemo.component;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.sally.matrialcomdemo.R;
import com.sally.matrialcomdemo.fragment.SampleFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sally on 8/3/16.
 */
public class TabLayoutActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private FragmentAdapter mAdapter;

    private String[] mTitles = { "tab1", "tab2", "tab3", "tab4", "tab5", "tab6"};
    private List<SampleFragment> mSampleFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_layout_activity);

        getSupportActionBar().setTitle(R.string.tab_layout);

        initView();
    }

    private void initView() {
        mTabLayout = (TabLayout) findViewById(R.id.id_tabLayout);
        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);

        // tabLayout设置tabs
//        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE); //当tab数量过多时，tablayout可以滚动

        mSampleFragments = new ArrayList<>();
        for(String title : mTitles) {
            mTabLayout.addTab(mTabLayout.newTab().setText(title));
            mSampleFragments.add(SampleFragment.newInstance(title));
        }

        // viewPager设置adapter
        mAdapter = new FragmentAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);

        // tablayout与viewpager关联
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabsFromPagerAdapter(mAdapter);
    }

    class FragmentAdapter extends FragmentStatePagerAdapter {

        public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mSampleFragments.get(position);
        }

        @Override
        public int getCount() {
            return mSampleFragments.size();
        }

        /**
         * 需要重写该方法，否则tab标题不显示
         * @param position
         * @return
         */
        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }
    }
}
