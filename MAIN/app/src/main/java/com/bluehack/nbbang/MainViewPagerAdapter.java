package com.bluehack.nbbang;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by jayman on 2016-09-24.
 */

public class MainViewPagerAdapter extends PagerAdapter {

    private Integer[] cardImageArr = {R.drawable.master_home_card, R.drawable.master_home_card, R.drawable.master_home_card};

    private Context mContext;
    private LayoutInflater mInflater;
    private int mCardNum = 0;

    public MainViewPagerAdapter(Context mContext, int mCardNum) {
        this.mContext = mContext;
        this.mCardNum = mCardNum;
        mInflater = LayoutInflater.from(mContext);
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
