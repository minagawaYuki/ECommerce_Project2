package com.example.ecommerce_project1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.ecommerce_project1.MainActivity;
import com.example.ecommerce_project1.R;

public class register_page extends AppCompatActivity {
    TextView linkSignin;
    EditText username;
    Button Register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        username = findViewById(R.id.eUsernameRegister);
        Register = findViewById(R.id.btnSignin);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Username = username.getText().toString();
                Intent intent = new Intent(register_page.this, account_page.class);
                intent.putExtra("user_name", Username);
                startActivity(intent);
            }
        });


        linkSignin = (TextView) findViewById(R.id.txtSignin);
        linkSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(
                        register_page.this, MainActivity.class
                );
                startActivity(intent1);
            }
        });
    }
}