package com.example.justbuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import Controller.DatabaseHandler;
import Model.User;

public class RegisterActivity extends AppCompatActivity {

    DatabaseHandler db;
    Button donebtn,backbtn;

    TextView username , password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db=new DatabaseHandler(this);

        username = findViewById(R.id.username_reg);
        password = findViewById(R.id.password_reg);



        donebtn = findViewById(R.id.Done2);
        donebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                db.addUser(new User(String.valueOf(username) ,String.valueOf(password)));
                Intent intent = new Intent(RegisterActivity.this , LoginActivity.class);
                startActivity(intent);

            }
        });

        backbtn=findViewById(R.id.bck_login2);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this , SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}