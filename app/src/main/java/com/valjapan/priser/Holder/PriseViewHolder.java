package com.valjapan.priser.Holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.valjapan.priser.R;

public class PriseViewHolder extends RecyclerView.ViewHolder {
    public TextView detailView;
    public PriseViewHolder(View itemView) {
        super(itemView);
        detailView = (TextView) itemView.findViewById(R.id.detail_details);

    }
}