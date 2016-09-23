package com.bluehack.nbbang;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.samsung.android.sdk.SsdkUnsupportedException;
import com.samsung.android.sdk.pass.Spass;
import com.samsung.android.sdk.pass.SpassFingerprint;

/**
 * Created by jayman on 2016-09-24.
 */

public class MainViewPagerAdapter extends PagerAdapter {

    private static String TAG = "MainViewPagerAdapter";

    private Integer[] cardImageArr = {R.drawable.master_home_card, R.drawable.master_home_card, R.drawable.master_home_card};

    private Context mContext;
    private LayoutInflater mInflater;
    private int mCardNum = 0;

    private Spass mSpass;
    private SpassFingerprint mFingerPrint;

    private SpassFingerprint.IdentifyListener mFingerPrintListener;

    public MainViewPagerAdapter(Context mContext, int mCardNum) {
        this.mContext = mContext;
        this.mCardNum = mCardNum;
        mInflater = LayoutInflater.from(mContext);

        mSpass = new Spass();

        try{
            mSpass.initialize(mContext);
        } catch (SsdkUnsupportedException e){
            Log.e(TAG, e.toString());
        }catch (UnsupportedOperationException e){
            Log.e(TAG, e.toString());
        }

        if(mSpass.isFeatureEnabled(Spass.DEVICE_FINGERPRINT)){
            mFingerPrint = new SpassFingerprint(mContext);
            mFingerPrintListener = new SpassFingerprint.IdentifyListener() {
                @Override
                public void onFinished(int i) {

                }

                @Override
                public void onReady() {

                }

                @Override
                public void onStarted() {

                }

                @Override
                public void onCompleted() {

                }
            };
        } else {
            Log.d(TAG, "Fingerprint Service is not supported in the device.");
        }
    }

    @Override
    public int getCount() {
        if(mCardNum < 0) return 0;
        return mCardNum;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View view = mInflater.inflate(R.layout.view_pager_child_view, null);

        ImageView imgView = (ImageView)view.findViewById(R.id.viewpager_child_img);

        imgView.setImageResource(cardImageArr[position]);

        container.addView(view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFingerPrint.startIdentifyWithDialog(mContext, mFingerPrintListener, true);
            }
        });

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }

    public void setmCardNum(int mCardNum) {
        this.mCardNum = mCardNum;
    }
}
