package com.example.ecommerce_project1;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
    private ArrayList<Integer> itemIDs;
    private DBHandler dbHandler;
    public CartAdapter(Context context, ArrayList<String> itemName, ArrayList<Integer> itemPrice, ArrayList<String> itemDescription, ArrayList<Integer> itemImages,ArrayList<Integer>itemIDs, DBHandler dbHandler) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemDescription = itemDescription;
        this.itemImages = itemImages;
        this.context = context;
        this.itemIDs = itemIDs;
        this.dbHandler = dbHandler;
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
        int pos = position;
        holder.cartImage.setImageResource(itemImages.get(position));
        holder.cartItemName.setText(String.valueOf(itemName.get(position)));
        holder.cartItemPrice.setText(String.valueOf(itemPrice.get(position)));

        holder.btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = itemName.get(pos);
                int price = itemPrice.get(pos);
                int itemid = itemIDs.get(pos);
                dbHandler.addToOrders(MainActivity.user.getId(), itemid, name, price);
                Toast.makeText(context, "Bought item" + itemid, Toast.LENGTH_SHORT).show();
            }
        });
        holder.btnRemoveCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int itemid = itemIDs.get(pos);
                dbHandler.deleteOrder(itemid);
                Toast.makeText(context, "Removed from cart" + itemid, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemName.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageButton cartImage;
        TextView cartItemName, cartItemPrice;
        Button btnBuy, btnRemoveCart;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cartImage = itemView.findViewById(R.id.cItemImage);
            cartItemName = itemView.findViewById(R.id.cItemName);
            cartItemPrice = itemView.findViewById(R.id.cItemPrice);
            btnBuy = itemView.findViewById(R.id.btnCartBuy);
            btnRemoveCart = itemView.findViewById(R.id.btnRemove);
        }
    }
}
