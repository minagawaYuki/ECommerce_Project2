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

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private Context context;
    private ArrayList<String> itemName;
    private ArrayList<Integer> itemPrice;
    private ArrayList<String> itemDescription;
    private ArrayList<Integer> itemImages;
    private DBHandler dbHandler;

    public CustomAdapter(Context context, ArrayList<String> itemName, ArrayList<Integer> itemPrice, ArrayList<String> itemDescription, ArrayList<Integer> itemImages, DBHandler dbHandler) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemDescription = itemDescription;
        this.itemImages = itemImages;
        this.context = context;
        this.dbHandler = dbHandler;
    }

    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.itemrow, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, int position) {
        int pos = position;
        holder.itemNameText.setText(String.valueOf(itemName.get(position)));
        holder.itemPriceText.setText(String.valueOf(itemPrice.get(position)));
        holder.itemImage.setImageResource(itemImages.get(position));
        holder.btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        holder.btnAddCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = itemName.get(pos);
                int price = itemPrice.get(pos);
                int itemid = itemImages.get(pos);
                dbHandler.addToCart(MainActivity.user.getId(), itemid, name, price);
                Toast.makeText(context, "Added to cart item" + itemid, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemName.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemNameText, itemPriceText, itemDescriptionText;
        ImageButton itemImage;
        Button btnBuy, btnAddCart;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemNameText = itemView.findViewById(R.id.itemName);
            itemPriceText = itemView.findViewById(R.id.itemPrice);
            itemDescriptionText = itemView.findViewById(R.id.itemDescription);
            itemImage = itemView.findViewById(R.id.itemImage);
            btnBuy = itemView.findViewById(R.id.btnBuy);
            btnAddCart = itemView.findViewById(R.id.btnAddCart);
        }
    }
}
