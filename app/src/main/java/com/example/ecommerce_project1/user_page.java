package com.example.ecommerce_project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class user_page extends AppCompatActivity {

    ImageView btnHome;
    ImageView btnCart;
    ImageView btnUser;
    ImageView btnNotif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_page);

        btnHome = findViewById(R.id.navHome);
        btnCart = findViewById(R.id.navCart);
        btnUser = findViewById(R.id.navUser);
        btnNotif = findViewById(R.id.navNotif);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(user_page.this, home_page.class);
                startActivity(intent);
            }
        });

        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        user_page.this, cart.class
                );
                startActivity(intent);
            }
        });

        btnUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        user_page.this, user_page.class
                );
                startActivity(intent);
            }
        });

        btnNotif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        user_page.this, notifications.class
                );
                startActivity(intent);
            }
        });
    }

    public void onClickHomeIcon(View v){
        Intent intent = new Intent(user_page.this, home_page.class);
        startActivity(intent);
    }
}