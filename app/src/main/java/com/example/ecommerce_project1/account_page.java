package com.example.ecommerce_project1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class account_page extends AppCompatActivity {

    TextView username;
    ImageView btnHome;
    ImageView btnCart;
    ImageView btnUser;
    ImageView btnNotif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_account_page);

        btnHome = findViewById(R.id.navHome);
        btnCart = findViewById(R.id.navCart);
        btnUser = findViewById(R.id.navUser);
        btnNotif = findViewById(R.id.navNotif);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(account_page.this, home_page.class);
                startActivity(intent);
            }
        });

        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        account_page.this, cart.class
                );
                startActivity(intent);
            }
        });

        btnUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        account_page.this, user_page.class
                );
                startActivity(intent);
            }
        });

        btnNotif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        account_page.this, notifications.class
                );
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        username = findViewById(R.id.username);
        String user_name = intent.getStringExtra("user_name");
        username.setText(user_name);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}