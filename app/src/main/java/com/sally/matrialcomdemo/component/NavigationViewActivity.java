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

import com.sally.matrialcomdemo.R;


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

        mToolbar.setTitle("HA HA");
        setSupportActionBar(mToolbar);
        setSupportActionBar(mToolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_favorite_white_24dp);

        setupDrawerContent(mNavigationView);
    }

    private void setupDrawerContent(NavigationView mNavigationView) {
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
           private MenuItem preMenuItem;
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                if(preMenuItem != null) {
                    preMenuItem.setChecked(false);
                }
                item.setChecked(true);
                mDrawerLayout.closeDrawers();
                preMenuItem = item;
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
}
