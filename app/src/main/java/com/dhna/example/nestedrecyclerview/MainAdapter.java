package com.dhna.example.nestedrecyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import lombok.Getter;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private List<MainModel> items;

    public MainAdapter() {
        items = new ArrayList<>();
    }

    public void setItems(List<MainModel> items) {
        this.items.clear();
        this.items.addAll(items);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_main, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d("TEST_LOG", "MainAdapter.onBindViewHolder(), position: " + position);
        MainModel model = items.get(position);

        holder.titleTextView.setText(model.getTitle());

        holder.subAdapter.setItems(model.getSubModels());
        holder.subAdapter.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.titleTextView)
        TextView titleTextView;

        @BindView(R.id.subRecyclerView)
        RecyclerView subRecyclerView;

        @Getter
        private final SubAdapter subAdapter;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            subAdapter = new SubAdapter();
            subRecyclerView.setAdapter(subAdapter);
        }
    }
}
