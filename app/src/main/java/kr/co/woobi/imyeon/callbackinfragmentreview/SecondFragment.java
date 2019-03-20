package kr.co.woobi.imyeon.callbackinfragmentreview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SecondFragment extends ColorFragment {
    private int mColor;

    public SecondFragment() {
    }

    //factory method 만들기==================================
    public static SecondFragment newInstance(int color) {
        SecondFragment secondFragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putInt("color", color);
        secondFragment.setArguments(args);
        return secondFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mColor = getArguments().getInt("color");
        }
    }
    //factory method 만들기==================================


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        view.setBackgroundColor(mColor);
        return view;
    }

    public void setColor(int color) {
        getView().setBackgroundColor(color);
    }
}
