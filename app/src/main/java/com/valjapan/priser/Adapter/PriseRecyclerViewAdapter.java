package com.valjapan.priser.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.valjapan.priser.R;

import java.util.List;

public class PriseRecyclerViewAdapter extends RecyclerView.Adapter<PriseRecyclerViewAdapter.detailViewHolder> {

    protected List<String> dataSet, timeSet;

    public static class detailViewHolder extends RecyclerView.ViewHolder {
        public final TextView detailTextView;
//        public final TextView timeTextView;

        public detailViewHolder(View v) {
            super(v);
            detailTextView = (TextView) v.findViewById(R.id.detail_details);
//            timeTextView = (TextView) v.findViewById(R.id.detail_time);

        }
    }

    public PriseRecyclerViewAdapter(List<String> myDataSet, List<String> myTimeSet) {
        dataSet = myDataSet;
//        timeSet = myTimeSet;
    }

    @Override
    public detailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_prise, parent, false);
        detailViewHolder vh = new detailViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(detailViewHolder holder, int position) {
        String detailText = dataSet.get(position);
//        String timeText = timeSet.get(position);
        holder.detailTextView.setText(detailText);
//        holder.timeTextView.setText(timeText);
    }


    @Override
    public int getItemCount() {
        return dataSet.size();
    }

}
