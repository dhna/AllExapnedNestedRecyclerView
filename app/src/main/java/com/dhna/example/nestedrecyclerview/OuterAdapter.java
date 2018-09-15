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

public class OuterAdapter extends RecyclerView.Adapter<OuterAdapter.ViewHolder> {

    private List<OuterModel> items;

    public OuterAdapter() {
        items = new ArrayList<>();
    }

    public void setItems(List<OuterModel> items) {
        this.items.clear();
        this.items.addAll(items);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_outer, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d("TEST_LOG", "OuterAdapter.onBindViewHolder(), position: " + position);
        OuterModel model = items.get(position);

        holder.titleTextView.setText(model.getTitle());

        holder.innerAdapter.setItems(model.getInnerModels());
        holder.innerAdapter.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.titleTextView)
        TextView titleTextView;

        @BindView(R.id.innerRecyclerView)
        RecyclerView innerRecyclerView;

        @Getter
        private final InnerAdapter innerAdapter;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            innerAdapter = new InnerAdapter();
            innerRecyclerView.setAdapter(innerAdapter);
        }
    }
}
