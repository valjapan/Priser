package com.valjapan.priser.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.valjapan.priser.Data.PriseData;
import com.valjapan.priser.Holder.PriseViewHolder;
import com.valjapan.priser.R;

import java.util.List;

public class PriseAdapter extends RecyclerView.Adapter<PriseViewHolder> {

    private List<PriseData> list;

    public PriseAdapter(List<PriseData> list) {
        this.list = list;
    }

    @Override
    public PriseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_prise, parent,false);
        PriseViewHolder vh = new PriseViewHolder(inflate);
        return vh;
    }

    @Override
    public void onBindViewHolder(PriseViewHolder holder, int position) {
        holder.detailView.setText(list.get(position).getDetail());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}