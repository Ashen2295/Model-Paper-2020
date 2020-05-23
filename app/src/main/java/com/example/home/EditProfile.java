package com.example.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class EditProfile extends AppCompatActivity {

    TextView gender;
    EditText  username, pswd, dob;
    Button btnedit, btndelete, btnSearch;
    RadioButton male, female;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);


        gender = findViewById(R.id.textView10);
        username = findViewById(R.id.editText6);
        pswd = findViewById(R.id.editText7);
        dob = findViewById(R.id.editText8);
        btnedit = findViewById(R.id.button4);
        btndelete = findViewById(R.id.button5);
        male = (RadioButton) findViewById(R.id.radioButton3);
        female = (RadioButton) findViewById(R.id.radioButton4);
        btnSearch = (Button) findViewById(R.id.button6);


        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DBHalper pdbHandler = new DBHalper(getApplicationContext());
                List usname = pdbHandler.readAllInfo(username.getText().toString());

                if (usname.isEmpty()){
                    Toast.makeText(EditProfile.this, "No Details", Toast.LENGTH_SHORT).show();
                    username.setText(null);
                }
                else {

                    Toast.makeText(EditProfile.this, "Details Found of "+usname.get(0).toString(), Toast.LENGTH_SHORT).show();
                    username.setText(usname.get(0).toString());
                    dob.setText(usname.get(1).toString());
                    gender.setText(usname.get(2).toString());



                }

            }
        });

        btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DBHalper pdbHandler = new DBHalper(getApplicationContext());

                Boolean status = pdbHandler.updateInfo(username.getText().toString(),dob.getText().toString(),gender.getText().toString());
                if (status){
                    Toast.makeText(EditProfile.this, "Successfully Updated", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(EditProfile.this, "Update Failed", Toast.LENGTH_SHORT).show();
                }

            }
        });


        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DBHalper pdbHandler = new DBHalper(getApplicationContext());
                pdbHandler.deleteInfo(username.getText().toString());

                Toast.makeText(EditProfile.this, "Successfully Removed", Toast.LENGTH_SHORT).show();

                username.setText(null);
                pswd.setText(null);
                dob.setText(null);
                gender.setText(null);
            }
        });
    }
}
