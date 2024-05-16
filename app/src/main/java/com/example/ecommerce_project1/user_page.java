package com.example.ecommerce_project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class user_page extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_page);
    }

    public void onClickHomeIcon(View v){
        Intent intent = new Intent(user_page.this, home_page.class);
        startActivity(intent);
    }
}