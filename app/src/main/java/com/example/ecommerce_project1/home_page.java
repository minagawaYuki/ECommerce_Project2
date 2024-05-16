package com.example.ecommerce_project1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class home_page extends AppCompatActivity {
    ImageButton btnCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btnCart), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnCart = (ImageButton) findViewById(R.id.btnCart);
        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(home_page.this, cart.class);
                startActivity(intent1);
            }
        });
    }

    public void onClickUserIcon(View v){
        Intent intent = new Intent(home_page.this, user_page.class);
        startActivity(intent);
    }
}