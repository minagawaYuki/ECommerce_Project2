package com.example.ecommerce_project1;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class order_history extends AppCompatActivity {
    private DBHandler dbHandler;
    RecyclerView recyclerView;
    private ArrayList<String> itemName;
    private ArrayList<Integer> itemPrice;
    private ArrayList<String> itemQuantity;
    private ArrayList<String> itemImage;
    private ArrayList<String> itemDescription;
    private ArrayList<Integer> itemImages;
    orderHistoryAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_order_history);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        dbHandler = new DBHandler(this);;
        recyclerView = findViewById(R.id.recycleView2);
        itemName = new ArrayList<>();
        itemPrice = new ArrayList<>();
        itemQuantity = new ArrayList<>();
        itemImage = new ArrayList<>();
        itemImages = new ArrayList<>();
        itemDescription = new ArrayList<>();
        storeItemInArrays();
        customAdapter = new orderHistoryAdapter(this, itemName, itemPrice, itemDescription, itemImages);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
    public void storeItemInArrays() {
        Cursor cursor = dbHandler.getOrderItems();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No items in cart", Toast.LENGTH_SHORT).show();
            return;
        } else {
            while (cursor.moveToNext()) {
                itemName.add(cursor.getString(2));
                itemPrice.add(cursor.getInt(3));
                itemImages.add(getImageResourceId(cursor.getInt(1)));
                System.out.println("Item name");
            }
        }
    }
    private int getImageResourceId(int id) {
        switch (id) {
            case 1:
                return R.drawable.laptop1;
            case 2:
                return R.drawable.laptop2;
            // Add more cases for different product names
            case 3:
                return R.drawable.laptop3;
            case 4:
                return R.drawable.phone11;
            // Add more cases for different product names
            case 5:
                return R.drawable.phone22;
            case 6:
                return R.drawable.phone3;
            // Add more cases for different product names
            case 7:
                return R.drawable.gpu11;
            case 8:
                return R.drawable.gpu22;
            // Add more cases for different product names
            default:
                return R.drawable.gpu33; // Default image if no match found
        }
    }
}