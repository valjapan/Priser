package com.valjapan.priser.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.valjapan.priser.R;

import java.util.List;

public class PriseRecyclerViewAdapter extends RecyclerView.Adapter<PriseRecyclerViewAdapter.ViewHolder> {

    protected List<String> dataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView textView;

        public ViewHolder(View v) {
            super(v);
            textView = (TextView) v.findViewById(R.id.detail_details);
        }
    }

    public PriseRecyclerViewAdapter(List<String> myDataSet) {
        dataSet = myDataSet;
    }

    @Override
    public PriseRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_prise, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String text = dataSet.get(position);
        holder.textView.setText(text);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

}
