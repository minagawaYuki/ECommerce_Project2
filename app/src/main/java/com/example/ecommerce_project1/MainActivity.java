package com.example.ecommerce_project1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    TextView linkRegister;
    EditText edtEmail;
    EditText edtPassword;
    String userEmail;
    String password;
    Button btnSignin;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btnCart), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        mAuth = FirebaseAuth.getInstance();
        edtEmail = findViewById(R.id.eUsernameLogin);
        edtPassword = findViewById(R.id.ePasswordLogin);
        userEmail = "default";
        password = "default";
        linkRegister = findViewById(R.id.txtSignin);
        btnSignin = findViewById(R.id.btnSignin);
        linkRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(
                        MainActivity.this, home_page.class
                );
                startActivity(intent1);
            }
        });
        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if (edtEmail.getText().toString().isEmpty()) {
                Toast.makeText(MainActivity.this, "Enter email", Toast.LENGTH_SHORT).show();
            } else {
                userEmail = edtEmail.getText().toString();
            }
            if (edtPassword.getText().toString().length() > 5) {
                password = edtPassword.getText().toString();
            } else {
            }
            mAuth.signInWithEmailAndPassword(userEmail, password).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()) {
                        Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, home_page.class));
                    }   else {
                        Log.e("Firebase Auth", "Sign-in failed", task.getException()); //
                        Toast.makeText(MainActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            }
            });
    }
}