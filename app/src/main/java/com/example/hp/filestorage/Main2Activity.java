package com.example.hp.filestorage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2Activity extends AppCompatActivity {

    TextView userName;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

       userName = findViewById(R.id.textView);
       button = findViewById(R.id.sbmitbtn);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File file = null;
                BufferedReader input = null;
                try{
                    file = getBaseContext().getFileStreamPath("Data");
                    input = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

                    String line;
                    StringBuffer buffer = new StringBuffer();

                    while ((line = input.readLine()) != null){
                        buffer.append(line).append("\n");
                    }

                    input.close();
                    String data = buffer.toString();
                    userName.setText(data);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });
    }
}
