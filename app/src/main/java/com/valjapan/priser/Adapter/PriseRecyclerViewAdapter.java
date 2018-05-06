package com.valjapan.priser.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.valjapan.priser.R;

public class PriseRecyclerViewAdapter extends RecyclerView.Adapter<PriseRecyclerViewAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // view type に応じて生成する view を変える。
        // 今回はサンプルコードなので手軽に両方とも TextView にしている。
        // 実際にはここで生成する View を違うものにする。
        View v = null;
        if(viewType == 0){
            v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_self_detail,
                            parent,
                            false);
        }
        else {
            v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_chara_detail,
                            parent,
                            false);
        }
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // view type に応じて処理を分ける。
        // 今回はどちらも TextView なので単にセットする文字列を変えている。
        if (holder.getItemViewType() == 0) {
            ((TextView) holder.itemView).setText("Even: " + position);
        } else {
            ((TextView) holder.itemView).setText("Odd: " + position);
        }
    }

    @Override
    public int getItemViewType(int position) {
        // サンプルコードなので手軽に position が偶数の項目と奇数の項目で view type を分ける。
        return position % 2;
    }

    @Override
    public int getItemCount() {
        return 10;
    }





}
