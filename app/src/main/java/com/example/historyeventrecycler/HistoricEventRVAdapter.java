package com.example.historyeventrecycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HistoricEventRVAdapter extends RecyclerView.Adapter<HistoricEventRVAdapter.MyviewHolder> {
    Context context;
    ArrayList<HistoricEventModel> historicEventModels;

    public HistoricEventRVAdapter(Context context, ArrayList<HistoricEventModel> historicEventModels) {
        this.context = context;
        this.historicEventModels = historicEventModels;
    }

    @NonNull
    @Override
    public HistoricEventRVAdapter.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cv_row, parent, false);
        return new HistoricEventRVAdapter.MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoricEventRVAdapter.MyviewHolder holder, int position) {
        holder.tvName.setText(historicEventModels.get(position).getEventName());
        holder.tvDate.setText(historicEventModels.get(position).getEventDate());
        holder.tvLocation.setText(historicEventModels.get(position).getEventLocation());
    }

    @Override
    public int getItemCount() {
        return historicEventModels.size();
    }

    public static class MyviewHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvDate, tvLocation;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvEventName);
            tvDate = itemView.findViewById(R.id.tvEventDate);
            tvLocation = itemView.findViewById(R.id.tvEventLocation);
        }
    }
}
