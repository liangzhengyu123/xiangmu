package com.example.administrator.chunhui.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.administrator.chunhui.R;
import com.example.administrator.chunhui.view.fragment.HomeFragment;
import com.example.administrator.chunhui.view.fragment.Knowledge_systemFragment;
import com.example.administrator.chunhui.view.fragment.NavigationFragment;
import com.example.administrator.chunhui.view.fragment.ProjectFragment;
import com.example.administrator.chunhui.view.fragment.SearchDialogFragment;
import com.example.administrator.chunhui.view.fragment.UsageDialogFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.home_button1)
    RadioButton homeButton1;
    @BindView(R.id.home_button2)
    RadioButton homeButton2;
    @BindView(R.id.home_button3)
    RadioButton homeButton3;
    @BindView(R.id.home_button4)
    RadioButton homeButton4;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    private UsageDialogFragment usageDialogFragment;
    private SearchDialogFragment searchDialogFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplication(), "点击了信封", Toast.LENGTH_SHORT).show();
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        homeButton1.setChecked(true);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.home_fragment,new HomeFragment());
        fragmentTransaction.commit();
    }

    //按钮的点击事件
    @OnClick({R.id.home_button1, R.id.home_button2, R.id.home_button3, R.id.home_button4})
    public void onViewClicked(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (view.getId()) {
            case R.id.home_button1:
                fragmentTransaction.replace(R.id.home_fragment,new HomeFragment());
                break;
            case R.id.home_button2:
                fragmentTransaction.replace(R.id.home_fragment,new Knowledge_systemFragment());
                break;
            case R.id.home_button3:
                fragmentTransaction.replace(R.id.home_fragment,new NavigationFragment());
                break;
            case R.id.home_button4:
                fragmentTransaction.replace(R.id.home_fragment,new ProjectFragment());
                break;
        }
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.home, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_usage:
//                if (usageDialogFragment == null) {
//                    usageDialogFragment = new UsageDialogFragment();
//                }
//                if (!isDestroyed() && usageDialogFragment.isAdded()) {
//                    usageDialogFragment.dismiss();
//                }
//                usageDialogFragment.show(getSupportFragmentManager(), "UsageDialogFragment");
//                startActivity(new Intent(HomeActivity.this,UsageDialogFragment.class));
                break;
            case R.id.action_search:
//                if (searchDialogFragment == null) {
//                    searchDialogFragment = new SearchDialogFragment();
//                }
//                if (!isDestroyed() && searchDialogFragment.isAdded()) {
//                    searchDialogFragment.dismiss();
//                }
//                searchDialogFragment.show(getSupportFragmentManager(), "SearchDialogFragment");
//                startActivity(new Intent(HomeActivity.this,SearchDialogFragment.class));
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {

        } else if (id == R.id.nav_gallery) {
            startActivity(new Intent(HomeActivity.this,CollectActivity.class));
        } else if (id == R.id.nav_slideshow) {
            startActivity(new Intent(HomeActivity.this,SettingActivity.class));
        } else if (id == R.id.nav_manage) {
            startActivity(new Intent(HomeActivity.this,AboutUsActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
