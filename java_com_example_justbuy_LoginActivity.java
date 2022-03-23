package com.example.justbuy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

import Controller.DatabaseHandler;
import Model.User;

public class LoginActivity extends AppCompatActivity
{
    DatabaseHandler db;
    Button donebtn,backbtn;
    TextView username , password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db=new DatabaseHandler(this);

        username = findViewById(R.id.username_lgn);
        password = findViewById(R.id.password_lgn);




        donebtn = findViewById(R.id.Done1);
        donebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User(String.valueOf(username) ,String.valueOf(password));
                User user1= db.getUser(String.valueOf(username));
                if (user1 != null)
                {
                Intent intent = new Intent(LoginActivity.this , CategoriesActivity.class);
                startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Registered Successfully!", Toast.LENGTH_LONG).show();
                }
            }
        });

        backbtn=findViewById(R.id.bck_login);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this , SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}