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

public class FragmentColorList extends Fragment {

    private List<String> listColor=new ArrayList<>();
    RecyclerView mRecyclerView;
    RecyclerViewAdapter mRecyclerAdapter;


    public interface onSelectListener{
        void onSelectColor(int position);
    }
    onSelectListener mListener;

    public void setOnSelectListener(onSelectListener listener){
        mListener=listener;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listColor.add("Red");
        listColor.add("Green");
        listColor.add("Blue");

        mRecyclerView=view.findViewById(R.id.recycler);
        mRecyclerAdapter=new RecyclerViewAdapter(listColor);
        mRecyclerView.setAdapter(mRecyclerAdapter);


        mRecyclerAdapter.setOnSendItemPosition(new RecyclerViewAdapter.onSendItemPosition() {
            @Override
            public void onSendItemClick(int position) {
                mListener.onSelectColor(position);
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_list,container,false);
        return view;
    }
}
