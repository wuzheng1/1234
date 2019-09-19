package com.example.liguixiao.day00_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;

import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Persenter {

    private RecyclerView mRecyclerview;
    private LinearLayout mLinearlayout;
    private NavigationView mNavigationview;
    private DrawerLayout mDrawerlayout;
    private MainPersenter mainPersenter;
    private Toolbar mToolbar;

    //H1902B 物联网 李桂啸
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mainPersenter = new MainPersenter(this);
        mainPersenter.getModel();
    }

    private void initView() {
        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        mLinearlayout = (LinearLayout) findViewById(R.id.linearlayout);
        mNavigationview = (NavigationView) findViewById(R.id.navigationview);
        mDrawerlayout = (DrawerLayout) findViewById(R.id.drawerlayout);

        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("户外花朵识别系统");
        setSupportActionBar(mToolbar);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerlayout, mToolbar, R.string.app_name, R.string.app_name);
        actionBarDrawerToggle.syncState();
        mDrawerlayout.addDrawerListener(actionBarDrawerToggle);
    }

    @Override
    public void sendData(final List<RootBeans.ResultsBean> results) {
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(this, results);
        mRecyclerview.setAdapter(recyclerAdapter);

        recyclerAdapter.setU(new RecyclerAdapter.User() {
            @Override
            public void onClick(int position) {
                Gson gson = new Gson();
                String s = gson.toJson(results);
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("json",s);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPersenter.detach();
    }
}
