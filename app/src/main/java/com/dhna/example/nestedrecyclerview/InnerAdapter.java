package com.dhna.example.nestedrecyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InnerAdapter extends RecyclerView.Adapter<InnerAdapter.ViewHolder> {

    private List<InnerModel> items;

    public InnerAdapter() {
        items = new ArrayList<>();
    }

    public void setItems(List<InnerModel> items) {
        this.items.clear();
        this.items.addAll(MoreObjects.firstNonNull(items, ImmutableList.<InnerModel>of()));
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_inner, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d("TEST_LOG", "InnerAdapter.onBindViewHolder(), position: " + position);
        InnerModel model = items.get(position);

        setName(holder, model);
    }

    private void setName(@NonNull ViewHolder holder, InnerModel model) {
        holder.nameTextView.setText(model.getName());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.nameTextView)
        TextView nameTextView;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
