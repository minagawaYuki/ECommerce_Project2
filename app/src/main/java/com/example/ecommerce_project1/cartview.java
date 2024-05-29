package com.example.ecommerce_project1;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class cartview extends AppCompatActivity {
    private DBHandler dbHandler;
    RecyclerView recyclerView;
    private ArrayList<String> itemName;
    private ArrayList<Integer> itemPrice;
    private ArrayList<String> itemQuantity;
    private ArrayList<String> itemImage;
    private ArrayList<String> itemDescription;
    private ArrayList<Integer> itemImages;
    private ArrayList<Integer> itemIDs;
    CustomAdapter customAdapter;
    Button btnOrder, btnCart;
    TextView username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cartview);

        username = findViewById(R.id.tfUsername);

        Intent intent = getIntent();

        String userName = intent.getStringExtra("user_name");

        username.setText(userName);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnOrder = findViewById(R.id.btnOrderHistory);
        btnCart = findViewById(R.id.btnCartActivity);
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(
                        cartview.this, order_history.class
                );
                startActivity(intent1);
            }
        });
        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(
                        cartview.this, cart_page.class
                );
                startActivity(intent1);
            }
        });

        dbHandler = new DBHandler(this);;
        recyclerView = findViewById(R.id.recycleView);
        itemName = new ArrayList<>();
        itemPrice = new ArrayList<>();
        itemQuantity = new ArrayList<>();
        itemImage = new ArrayList<>();
        itemImages = new ArrayList<>();
        itemDescription = new ArrayList<>();
        itemIDs = new ArrayList<>();
        storeItemInArrays();
        customAdapter = new CustomAdapter(this, itemName, itemPrice, itemDescription, itemImages, itemIDs, dbHandler);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
    public void storeItemInArrays() {
        Cursor cursor = dbHandler.getAllItems();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No items in cart", Toast.LENGTH_SHORT).show();
            return;
        } else {
            while (cursor.moveToNext()) {
                itemName.add(cursor.getString(1));
                itemPrice.add(cursor.getInt(2));
                itemImages.add(getImageResourceId(cursor.getInt(0)));
                itemIDs.add(cursor.getInt(0));
                System.out.println("Item name");
            }
        }
    }
    private int getImageResourceId(int id) {
        switch (id) {
            case 1: return R.drawable.laptop1;
            case 2: return R.drawable.laptop2;
            case 3: return R.drawable.laptop3;
            case 4: return R.drawable.phone11;
            case 5: return R.drawable.phone22;
            case 6: return R.drawable.phone3;
            case 7: return R.drawable.gpu11;
            case 8: return R.drawable.gpu22;
            default: return R.drawable.gpu33;
        }
    }
}