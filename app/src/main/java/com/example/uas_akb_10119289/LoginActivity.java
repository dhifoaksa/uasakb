package com.example.uas_akb_10119289;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.uas_akb_10119289.main.dashboard.DashboardActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        Button loginButton = findViewById(R.id.login);
        final EditText usernameInput = findViewById(R.id.username);
        final EditText passwordInput =  findViewById(R.id.password);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(usernameInput.getText().toString(),passwordInput.getText().toString() );

            }
        });

        TextView registerLink = findViewById(R.id.register_btn);
        registerLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }


    private void login(String email, String password) {

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();

                            Toast.makeText(LoginActivity.this, "Authentication Success." + user.getEmail(),
                                    Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
                            finish();

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }
                });

    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser user =  mAuth.getCurrentUser();
        if(user != null) {
            startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
            finish();
        }
    }
}