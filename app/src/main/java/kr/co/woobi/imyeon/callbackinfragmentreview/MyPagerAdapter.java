package kr.co.woobi.imyeon.callbackinfragmentreview;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mData = new ArrayList<>();

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);

        mData.add(new FirstSceneFragment());
        mData.add(new SecondFragment());
        mData.add(new ColorFragment());
    }

    @Override
    public Fragment getItem(int i) {
        return mData.get(i);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title=position+"번째";
        switch (position) {
            case 0:
                title = "이벤트 예제";
                break;
            case 1:
                title = "빨간색 배경";
                break;
            case 2:
                title = "랜덤색 배경";
                break;
        }
        return title;
    }
}
