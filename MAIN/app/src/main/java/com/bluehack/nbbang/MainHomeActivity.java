package com.bluehack.nbbang;

import android.graphics.pdf.PdfDocument;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainHomeActivity extends AppCompatActivity {

    ViewPager mViewPager;
    PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);

        mViewPager = (ViewPager) findViewById(R.id.main_card_viewpager);
        mPagerAdapter = new MainViewPagerAdapter(getApplicationContext(), 3);
        mViewPager.setAdapter(mPagerAdapter);
    }
}
