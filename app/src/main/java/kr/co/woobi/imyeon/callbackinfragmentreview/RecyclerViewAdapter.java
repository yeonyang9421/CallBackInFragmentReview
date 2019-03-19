package kr.co.woobi.imyeon.callbackinfragmentreview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    public interface onSendItemPosition {
        void onSendItemClick(int position);
    }

    onSendItemPosition mListener;

    public void setOnSendItemPosition(onSendItemPosition listener) {
        mListener = listener;
    }


    List<String> mItem = new ArrayList<>();

    public RecyclerViewAdapter(List<String> mItem) {
        this.mItem = mItem;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        if (mListener != null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onSendItemClick(viewHolder.getAdapterPosition());
                }
            });
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String str = mItem.get(i);
        viewHolder.mTextItem.setText(str);
    }

    @Override
    public int getItemCount() {
        return mItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTextItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextItem = itemView.findViewById(R.id.text_item);
        }
    }
}
