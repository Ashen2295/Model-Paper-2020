package com.example.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileManagement extends AppCompatActivity {

    TextView gender;
    EditText  username, pswd, dob;
    Button btnupdate;
    RadioButton male, female;
    String description= "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_management);

        gender = findViewById(R.id.textView6);
        username = findViewById(R.id.editText3);
        pswd = findViewById(R.id.editText4);
        dob = findViewById(R.id.editText5);
        btnupdate = findViewById(R.id.button3);
        male = (RadioButton) findViewById(R.id.radioButton);
        female = (RadioButton) findViewById(R.id.radioButton2);

        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DBHalper pdbHandler = new DBHalper(getApplicationContext());
                long newID = pdbHandler.addInfo(username.getText().toString(), pswd.getText().toString(), dob.getText().toString(), gender.getText().toString());
                Toast.makeText(ProfileManagement.this, "Details Added under User ID: " + newID, Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(),EditProfile.class);
                username.setText(null);
                pswd.setText(null);
                dob.setText(null);
                gender.setText(null);
                startActivity(i);
            }
        });
    }
}
