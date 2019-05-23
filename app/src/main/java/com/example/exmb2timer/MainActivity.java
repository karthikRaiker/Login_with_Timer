package com.example.exmb2timer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    EditText unmae,passwd;
    Button login,cancel;
    Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        unmae = findViewById(R.id.usernm);
        passwd = findViewById(R.id.passwd);
        login = findViewById(R.id.login);
        cancel = findViewById(R.id.cancel);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(unmae.getText().toString().equals("admin") && passwd.getText().toString().equals("password"))
                {
                    timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),"login successful",Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(MainActivity.this,Main2Activity.class);
                            startActivity(i);
                           // Toast.makeText(MainActivity.this,"login successful",Toast.LENGTH_SHORT).show();
                            //finish();
                        }
                    },5000);

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"login failure",Toast.LENGTH_SHORT).show();
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
