package com.example.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username, pswd;
    RadioButton male,female;
    Button btnlogin, btnregister;
    String description= "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.editText);
        pswd= findViewById(R.id.editText2);
        btnlogin = (Button) findViewById(R.id.button);
        btnregister = (Button) findViewById(R.id.button2);

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(),ProfileManagement.class);
                username.setText(null);
                pswd.setText(null);
                startActivity(i);
            }
        });
    }
}
