package com.example.dailydubs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText eUsername;
    private EditText ePassword;
    private Button eLogin;
    private TextView eAttemptsCounter;

    private String username = "Admin";
    private String password = "123456789";
    private int counter = 5;

    private boolean isValid = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eUsername = findViewById(R.id.etUsername);
        ePassword = findViewById(R.id.etPassword);
        eLogin = findViewById(R.id.btnLogin);
        eAttemptsCounter = findViewById(R.id.tvAttemptsCounter);

        eLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Check whether the username and password combination is correct
                String inputName = eUsername.getText().toString();
                String inputPassword = ePassword.getText().toString();

                // If the input is empty give notification to the user.
                // If the input does not pass the validation test
                if(inputName.isEmpty() || inputPassword.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please try again", Toast.LENGTH_SHORT).show();
                } else {
                    isValid = validateCredential(inputPassword, inputName);

                    if(!isValid) {
                        // if the credential is false
                        counter--;
                        eAttemptsCounter.setText(String.format("No. of attempts remaining: %d", counter));
                        Toast.makeText(MainActivity.this, "Wrong password / Username", Toast.LENGTH_SHORT).show();

                        // if the counter reach 0, the user can't login
                        if (counter == 0) {
                            eLogin.setEnabled(false);
                        }

                    } else {
                        // if the credential pass
                        Toast.makeText(MainActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();

                        // Reset the counter
                        counter = 5;

                        // Go to a new activity
                        Intent intent = new Intent(MainActivity.this, HomePage.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }

    private boolean validateCredential(String password, String username) {
        if (this.username.equals(username) && this.password.equals(password)) {
            return true;
        }
        return false;
    }
}