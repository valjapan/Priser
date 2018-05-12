package com.valjapan.priser.Holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.valjapan.priser.R;

public class PriseRecyclerViewHolder extends RecyclerView.ViewHolder {
    public TextView userDetailTextView;
    public TextView userTimeTextView;
    public TextView cpuDetailTextView;
    public TextView cpuTimeTextView;

    public PriseRecyclerViewHolder(View itemView) {
        super(itemView);
        userDetailTextView = (TextView) itemView.findViewById(R.id.detail_self_details_text_view);
        userTimeTextView = (TextView) itemView.findViewById(R.id.detail_self_time);
        cpuDetailTextView = (TextView) itemView.findViewById(R.id.detail_chara_details_text_view);
        cpuTimeTextView = (TextView) itemView.findViewById(R.id.detail_chara_time);


    }
}
