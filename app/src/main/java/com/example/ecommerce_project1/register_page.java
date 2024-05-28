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

public class register_page extends AppCompatActivity {
    TextView linkSignin;
    EditText eusername, eemail, epassword;
    Button Register;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btnSignup), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        mAuth = FirebaseAuth.getInstance();
        eusername = findViewById(R.id.eUsernameLogin);
        eemail = findViewById(R.id.eEmailRegister);
        epassword = findViewById(R.id.ePasswordLogin);
        Register = findViewById(R.id.btnSignup);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = eusername.getText().toString();
                String email = eemail.getText().toString();
                String password = epassword.getText().toString();

                if (eusername.getText().toString().isEmpty()) {
                    Toast.makeText(register_page.this, "Enter username", Toast.LENGTH_SHORT).show();
                }
                if (eemail.getText().toString().isEmpty()) {
                    Toast.makeText(register_page.this, "Enter email", Toast.LENGTH_SHORT).show();
                }
                if (epassword.getText().toString().length() < 6) {
                    Toast.makeText(register_page.this, "Password length too short", Toast.LENGTH_SHORT).show();
                }
                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(register_page.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(register_page.this, "Registered Successfully, enter correct format", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(register_page.this, MainActivity.class));
                        } else {
                            Log.e("Firebase Auth", "Sign-in failed", task.getException()); //
                            Toast.makeText(register_page.this, "Failed to register", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
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