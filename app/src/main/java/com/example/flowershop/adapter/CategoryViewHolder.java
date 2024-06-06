package com.example.flowershop.adapter;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flowershop.R;

public final class CategoryViewHolder extends RecyclerView.ViewHolder{

    TextView categotyTitle;
    public Button button;
    public CategoryViewHolder(@NonNull View itemView) {
        super(itemView);
        this.categotyTitle = itemView.findViewById(R.id.button);
        this.button = itemView.findViewById(R.id.button);

    }

}