package com.example.liguixiao.day00_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager mViewpager;
    private TextView mPagerTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        mViewpager = (ViewPager) findViewById(R.id.viewpager);
        Intent intent = getIntent();
        String json = intent.getStringExtra("json");
        Gson gson = new Gson();
        List<RootBeans.ResultsBean> o = gson.fromJson(json, new TypeToken<List<RootBeans.ResultsBean>>() {
        }.getType());
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this, o);
        mViewpager.setAdapter(viewPagerAdapter);
        mViewpager.setOnClickListener(this);
        mPagerTv = (TextView) findViewById(R.id.pager_tv);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.viewpager:
                break;
        }
    }
}
