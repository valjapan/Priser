package com.valjapan.priser.Holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.valjapan.priser.R;

public class PriseRecyclerViewHolder extends RecyclerView.ViewHolder {
    public TextView detailTextView;
    public TextView timeTextView;

    public PriseRecyclerViewHolder(View itemView) {
        super(itemView);
        detailTextView = (TextView) itemView.findViewById(R.id.detail_self_details_text_view);
        timeTextView = (TextView) itemView.findViewById(R.id.detail_self_time);

    }
}
