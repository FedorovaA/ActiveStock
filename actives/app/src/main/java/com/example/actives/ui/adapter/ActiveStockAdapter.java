package com.example.actives.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.actives.R;
import com.example.actives.data.model.MostActiveStock;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Angelina Fedorova
 */

public class ActiveStockAdapter extends RecyclerView.Adapter<ActiveStockAdapter.ViewHolder> {
    private List<MostActiveStock> mostActiveStocks = null;

    private Context context;

    public ActiveStockAdapter() {
    }

    public ActiveStockAdapter(Context context) {

        this.context = context;

        mostActiveStocks = new ArrayList<>();
    }

    public void setStockDataList (List<MostActiveStock> mostActiveStocks) {
        this.mostActiveStocks = mostActiveStocks;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.stock_list, viewGroup, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final MostActiveStock mostActiveStock = mostActiveStocks.get(position);
        holder.txtTicker.setText(mostActiveStock.getTicker());
        holder.txtPrice.setText(String.format(Locale.getDefault(),"%.2f",mostActiveStock.getPrice()));
        holder.txtChanges.setText(String.format(Locale.getDefault(),"%.2f",mostActiveStock.getChanges()));
        holder.txtChangesPercentage.setText(mostActiveStock.getChangesPercentage());
        holder.txtCompanyName.setText(mostActiveStock.getCompanyName());
    }

    @Override
    public int getItemCount() {
        return mostActiveStocks != null ? mostActiveStocks.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTicker;
        TextView txtChanges;
        TextView txtPrice;
        TextView txtChangesPercentage;
        TextView txtCompanyName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTicker = itemView.findViewById(R.id.txtTicker);
            txtChanges = itemView.findViewById(R.id.txtChanges);
            txtPrice = itemView.findViewById(R.id.txtPrice);
            txtChangesPercentage = itemView.findViewById(R.id.txtChangesPercentage);
            txtCompanyName = itemView.findViewById(R.id.txtCompanyName);
        }
    }
}
