package com.example.ecommerce_project1;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class orderHistoryAdapter extends RecyclerView.Adapter<orderHistoryAdapter.ViewHolder> {
    private Context context;
    private ArrayList<String> itemName;
    private ArrayList<Integer> itemPrice;
    private ArrayList<String> itemDescription;
    private ArrayList<Integer> itemImages;
    public orderHistoryAdapter(Context context, ArrayList<String> itemName, ArrayList<Integer> itemPrice, ArrayList<String> itemDescription, ArrayList<Integer> itemImages) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemDescription = itemDescription;
        this.itemImages = itemImages;
        this.context = context;
    }

    @NonNull
    @Override
    public orderHistoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.itemrow, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemNameText.setText(String.valueOf(itemName.get(position)));
        holder.itemPriceText.setText(String.valueOf(itemPrice.get(position)));
        holder.itemDescriptionText.setText(String.valueOf(itemDescription.get(position)));
        holder.itemImage.setImageResource(itemImages.get(position));
    }

    @Override
    public int getItemCount() {
        return itemName.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemNameText, itemPriceText, itemDescriptionText;
        ImageButton itemImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemNameText = itemView.findViewById(R.id.itemName);
            itemPriceText = itemView.findViewById(R.id.itemPrice);
            itemDescriptionText = itemView.findViewById(R.id.itemDescription);
            itemImage = itemView.findViewById(R.id.itemImage);
        }
    }
}
