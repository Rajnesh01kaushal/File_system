package com.example.hp.filestorage;

import android.content.Intent;
import android.os.FileObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;

public class MainActivity extends AppCompatActivity {

    EditText name,password,email,city;
    Spinner spinner;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.nameTx);
        password = findViewById(R.id.password);
        email = findViewById(R.id.emailTx);
        city = findViewById(R.id.cityTx);
        spinner = findViewById(R.id.spinner);
        button = findViewById(R.id.button);

        final  String[] State = {"Bihar","Jharkhand","Orissa"};
        ArrayAdapter<String>arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,State);
                spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);

                String userName = name.getText().toString();
                String userPassword = password.getText().toString();
                String userEmail = email.getText().toString();
                String userCity = city.getText().toString();
                String spinnerData = spinner.getSelectedItem().toString();

                if (TextUtils.isEmpty(name.getText())) {
                    name.setError("failed");
                    return;
                }
                if (TextUtils.isEmpty(password.getText())) {
                    password.setError("failed");
                    return;
                }
                if (TextUtils.isEmpty(email.getText())) {
                    email.setError("failed");
                    return;
                }
                if (TextUtils.isEmpty(city.getText())) {
                    city.setError("failed");
                    return;
                }

                String Data = "Name:" +userName + "\n" + "Password:" + userPassword + "\n" + "Email:" + userEmail + "\n" + "State:" + spinnerData + "\n" + "City:" + userCity;
                FileOutputStream fos;


                try {
                    fos = openFileOutput("userName", MODE_PRIVATE);
                    fos.write(Data.getBytes());
                    fos.close();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                startActivity(intent);


            }

            });


    }
}
