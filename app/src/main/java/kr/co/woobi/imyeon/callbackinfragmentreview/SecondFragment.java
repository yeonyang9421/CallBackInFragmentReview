package kr.co.woobi.imyeon.callbackinfragmentreview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SecondFragment extends ColorFragment {

    public void setColor(int color) {
        getView().setBackgroundColor(color);
    }
}
