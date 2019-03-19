package kr.co.woobi.imyeon.callbackinfragmentreview;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    List<String> mItem = new ArrayList<>();

    public RecyclerViewAdapter(List<String> mItem) {
        this.mItem = mItem;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        final ViewHolder viewHolder = new ViewHolder(view);

            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String colorString = mItem.get(viewHolder.getAdapterPosition());
                    int color= Color.GRAY;
                    switch (colorString) {
                        case "Red":
                            color = Color.RED;
                            break;
                        case "Blue":
                            color = Color.BLUE;
                            break;
                        case "Green":
                            color = Color.GREEN;
                            break;
                    }
                    EventBus.getDefault().post(new EventItem(color));
                }
            });

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
