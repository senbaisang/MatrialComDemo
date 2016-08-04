package com.sally.matrialcomdemo.component;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.sally.matrialcomdemo.R;
import com.sally.matrialcomdemo.fragment.DiscussionFragment;
import com.sally.matrialcomdemo.fragment.FriendFragment;
import com.sally.matrialcomdemo.fragment.HomeFragment;
import com.sally.matrialcomdemo.fragment.MessageFragment;


/**
 * Created by sally on 8/3/16.
 */
public class NavigationViewActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_view_activity);

        initView();

    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.id_toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.id_drawable_layout);
        mNavigationView = (NavigationView) findViewById(R.id.id_navigation_view);

        setSupportActionBar(mToolbar);
        setSupportActionBar(mToolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_favorite_white_24dp);

        setupDrawerContent(mNavigationView);
        getSupportFragmentManager().beginTransaction().replace(R.id.id_container, HomeFragment.newInstance("home fragment")).commit();
        mToolbar.setTitle(R.string.nav_home);
    }

    private void setupDrawerContent(NavigationView mNavigationView) {
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            private MenuItem preMenuItem;

            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                if (preMenuItem != null) {
                    preMenuItem.setChecked(false);
                }
                item.setChecked(true);
                mDrawerLayout.closeDrawers();
                preMenuItem = item;

                switch (item.getItemId()) {
                    case R.id.nav_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.id_container, HomeFragment.newInstance("home fragment")).commit();
                        mToolbar.setTitle(R.string.nav_home);
                        break;
                    case R.id.nav_messages:
                        getSupportFragmentManager().beginTransaction().replace(R.id.id_container, MessageFragment.newInstance("message fragment")).commit();
                        mToolbar.setTitle(R.string.nav_message);
                        break;
                    case R.id.nav_friend:
                        getSupportFragmentManager().beginTransaction().replace(R.id.id_container, FriendFragment.newInstance("friend fragment")).commit();
                        mToolbar.setTitle(R.string.nav_friend);
                        break;
                    case R.id.nav_discussion:
                        getSupportFragmentManager().beginTransaction().replace(R.id.id_container, DiscussionFragment.newInstance("discussion fragment")).commit();
                        mToolbar.setTitle(R.string.nav_discussion);
                        break;
                    case R.id.nav_stub_item1:
                        showMsg("nav_stub_item1");
                        break;
                    case R.id.nav_stub_item2:
                        showMsg("nav_stub_item2");
                        break;
                }

                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            mDrawerLayout.openDrawer(GravityCompat.START);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void showMsg(String text) {
        Toast.makeText(NavigationViewActivity.this, text, Toast.LENGTH_SHORT).show();
    }
}
