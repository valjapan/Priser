package com.valjapan.priser.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.valjapan.priser.Data.DetailData;
import com.valjapan.priser.Holder.PriseRecyclerViewHolder;
import com.valjapan.priser.R;

import java.util.List;

public class PriseRecyclerViewAdapter extends RecyclerView.Adapter<PriseRecyclerViewHolder> {


    private List<DetailData> list;

    public PriseRecyclerViewAdapter(List<DetailData> list) {
        this.list = list;
    }

    @Override
    public PriseRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_prise, parent,false);
        PriseRecyclerViewHolder vh = new PriseRecyclerViewHolder(inflate);
        return vh;
    }

    @Override
    public void onBindViewHolder(PriseRecyclerViewHolder holder, int position) {
        holder.detailTextView.setText(list.get(position).getDetail());
        holder.timeTextView.setText(list.get(position).getTime());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
