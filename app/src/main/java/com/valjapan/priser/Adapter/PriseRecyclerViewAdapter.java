package com.valjapan.priser.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.valjapan.priser.Data.CpuMessage;
import com.valjapan.priser.Data.UserMessage;
import com.valjapan.priser.R;

import java.util.List;

public class PriseRecyclerViewAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private List<Object> mObjects;


    public static final int CPU = 0;
    public static final int USER = 1;


    public PriseRecyclerViewAdapter(Context context, List<Object> objects) {
        mContext = context;
        mObjects = objects;
    }


    @Override
    public int getItemViewType(int position) {
        if (mObjects.get(position) instanceof CpuMessage)
            return CPU;
        else if (mObjects.get(position) instanceof UserMessage)
            return USER;
        return -1;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(mContext);
        switch (getItemViewType(viewType)) {


            case USER:
                View itemView1 = li.inflate(R.layout.item_detail, parent, false);
                return new UserViewHolder(itemView1);
            default:
                break;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        switch (getItemViewType(position)) {

            case CPU:
                CpuMessage cpuMessage = (CpuMessage) mObjects.get(position);
                CpuViewHolder cpuViewHolder = (CpuViewHolder) holder;
                cpuViewHolder.detailTextView.setText(cpuMessage.getCharaDetail());
                cpuViewHolder.timeTextView.setText(cpuMessage.getCharaTime());
                break;

            case USER:
                UserMessage userMessage = (UserMessage) mObjects.get(position);
                UserViewHolder userViewHolder = (UserViewHolder) holder;
                userViewHolder.detailTextView.setText(userMessage.getSelfDetail());
                userViewHolder.timeTextView.setText(userMessage.getSelfTime());
                break;

        }
    }

    @Override
    public int getItemCount() {
        return mObjects.size();
    }


    public class CpuViewHolder extends RecyclerView.ViewHolder {
        private TextView detailTextView;
        private TextView timeTextView;

        public CpuViewHolder(View itemView) {
            super(itemView);
            detailTextView = (TextView) itemView.findViewById(R.id.detail_chara_details_text_view);
            timeTextView = (TextView) itemView.findViewById(R.id.detail_chara_time);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext, mObjects.get(getAdapterPosition()).toString(), Toast.LENGTH_SHORT).show();

                }

            });

        }

    }


    public class UserViewHolder extends RecyclerView.ViewHolder {
        private TextView detailTextView;
        private TextView timeTextView;

        public UserViewHolder(View itemView) {
            super(itemView);

            detailTextView = (TextView) itemView.findViewById(R.id.detail_self_details_text_view);
            timeTextView = (TextView) itemView.findViewById(R.id.detail_self_time);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext, mObjects.get(getAdapterPosition()).toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}