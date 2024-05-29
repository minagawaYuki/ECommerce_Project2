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

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    private Context context;
    private ArrayList<String> itemName;
    private ArrayList<Integer> itemPrice;
    private ArrayList<String> itemDescription;
    private ArrayList<Integer> itemImages;
    public CartAdapter(Context context, ArrayList<String> itemName, ArrayList<Integer> itemPrice, ArrayList<String> itemDescription, ArrayList<Integer> itemImages) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemDescription = itemDescription;
        this.itemImages = itemImages;
        this.context = context;
    }

    @NonNull
    @Override
    public CartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cart_page_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.ViewHolder holder, int position) {
        holder.cartImage.setImageResource(itemImages.get(position));
        holder.cartItemName.setText(String.valueOf(itemName.get(position)));
        holder.cartItemPrice.setText(String.valueOf(itemPrice.get(position)));
    }

    @Override
    public int getItemCount() {
        return itemName.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageButton cartImage;
        TextView cartItemName, cartItemPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cartImage = itemView.findViewById(R.id.cItemImage);
            cartItemName = itemView.findViewById(R.id.cItemName);
            cartItemPrice = itemView.findViewById(R.id.cItemPrice);
        }
    }
}
