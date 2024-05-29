package com.example.ecommerce_project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class user_page extends AppCompatActivity {

    ImageView btnHome;
    ImageView btnCart;
    ImageView btnUser;
    ImageView btnNotif;
    EditText eusername;
    EditText eemail;
    Button btnSave;
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_page);

        btnHome = findViewById(R.id.navHome);
        btnCart = findViewById(R.id.navCart);
        btnUser = findViewById(R.id.navUser);
        btnNotif = findViewById(R.id.navNotif);
        eusername = findViewById(R.id.txtUsernameField);
        eemail = findViewById(R.id.txtEmail);
        btnSave = findViewById(R.id.btnSave);
        dbHandler = new DBHandler(this);

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
        eusername.setText(MainActivity.user.getUsername());
        eemail.setText(MainActivity.user.getEmail());
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHandler.updateUser(MainActivity.user.getId(), eusername.getText().toString());
                MainActivity.user.setUsername(eusername.getText().toString());
            }
        });
    }

    public void onClickHomeIcon(View v){
        Intent intent = new Intent(user_page.this, home_page.class);
        startActivity(intent);
    }
}