package com.example.loginapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText username =(EditText) findViewById(R.id.username);
        EditText password =(EditText) findViewById(R.id.password);
        EditText conpassword =(EditText) findViewById(R.id.conpassword);
        MaterialButton register =(MaterialButton) findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String conpass = conpassword.getText().toString();

                if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(conpass)) {
                    Toast.makeText(MainActivity.this , "All Fields Required" , Toast.LENGTH_SHORT).show();
                }
                else if (pass.equals(conpass)) {
                    Toast.makeText(MainActivity.this , "Your Account Created Successfully" , Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext() , loginActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(MainActivity.this , "Passwords didn't match" , Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}