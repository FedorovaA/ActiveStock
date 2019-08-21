package com.example.actives.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.actives.R;
import com.example.actives.data.ActiveStockData;
import com.example.actives.data.MostActiveStock;

public class ActiveStockAdapter extends RecyclerView.Adapter<ActiveStockAdapter.ViewHolder> {
    private ActiveStockData activeStockData = new ActiveStockData();

    Context context;

    public ActiveStockAdapter() {
    }

    public ActiveStockAdapter(Context context) {

        this.context = context;
    }

    public void setStockDataList (ActiveStockData activeStockData) {
        this.activeStockData = activeStockData;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.stock_list, viewGroup, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final MostActiveStock mostActiveStock = activeStockData.getMostActiveStocks().get(position);
        holder.txtTicker.setText(mostActiveStock.getTicker());
        holder.txtPrice.setText(mostActiveStock.getPrice().toString());
        holder.txtChanges.setText(mostActiveStock.getChanges().toString());
        holder.txtChangesPercentage.setText(mostActiveStock.getChangesPercentage());
        holder.txtCompanyName.setText(mostActiveStock.getCompanyName());
    }

    @Override
    public int getItemCount() {
        return activeStockData.getMostActiveStocks() != null ? activeStockData.getMostActiveStocks().size() : 0;
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
