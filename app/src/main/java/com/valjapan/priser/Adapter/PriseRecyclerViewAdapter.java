package com.valjapan.priser.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.valjapan.priser.Data.UserMessage;
import com.valjapan.priser.Holder.PriseRecyclerViewHolder;
import com.valjapan.priser.R;

import java.util.List;

public class PriseRecyclerViewAdapter extends RecyclerView.Adapter<PriseRecyclerViewHolder> {

    private List<UserMessage> list;

    public PriseRecyclerViewAdapter(List<UserMessage> list) {
        this.list = list;
    }

    @Override
    public PriseRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detail, parent, false);
        PriseRecyclerViewHolder vh = new PriseRecyclerViewHolder(inflate);
        return vh;
    }

    @Override
    public void onBindViewHolder(PriseRecyclerViewHolder holder, int position) {
        holder.userDetailTextView.setText(list.get(position).userDetail);
        holder.userTimeTextView.setText(list.get(position).userTime);
        holder.cpuDetailTextView.setText(list.get(position).cpuDetail);
        holder.cpuTimeTextView.setText(list.get(position).cpuTime);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}