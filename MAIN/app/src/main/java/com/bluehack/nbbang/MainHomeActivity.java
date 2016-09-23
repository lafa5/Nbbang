package com.bluehack.nbbang;

import android.content.Context;
import android.graphics.pdf.PdfDocument;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.samsung.android.sdk.pass.Spass;
import com.samsung.android.sdk.pass.SpassFingerprint;

public class MainHomeActivity extends AppCompatActivity {

    private static String TAG = "MainHomeActivity";

    private Context mContext;

    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;
    private Spass mSpass;
    private SpassFingerprint mFingerPrint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);

        mContext = getApplicationContext();

        mViewPager = (ViewPager) findViewById(R.id.main_card_viewpager);
        mPagerAdapter = new MainViewPagerAdapter(mContext, 3);
        mViewPager.setAdapter(mPagerAdapter);
    }
}
