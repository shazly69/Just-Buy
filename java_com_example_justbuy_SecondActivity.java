package com.example.justbuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity
{
    Button loginbtn,registerbtn,guest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        registerbtn = findViewById(R.id.RegisterButton);

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this , RegisterActivity.class);
                startActivity(intent);
            }
        });
        guest = findViewById(R.id.GuestButton);
        guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this , CategoriesActivity.class);
                startActivity(intent);
            }
        });
        loginbtn = findViewById(R.id.LoginButton);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this , LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}