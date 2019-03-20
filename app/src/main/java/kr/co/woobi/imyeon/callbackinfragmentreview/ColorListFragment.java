package kr.co.woobi.imyeon.callbackinfragmentreview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ColorListFragment extends Fragment {

    private List<String> listColor=new ArrayList<>();
    RecyclerView mRecyclerView;
    RecyclerViewAdapter mRecyclerAdapter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView=view.findViewById(R.id.recycler);
        mRecyclerAdapter=new RecyclerViewAdapter(listColor);
        mRecyclerView.setAdapter(mRecyclerAdapter);
    }

    public ColorListFragment() {
        listColor.add("Red");
        listColor.add("Green");
        listColor.add("Blue");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_list,container,false);
        return view;
    }
}
