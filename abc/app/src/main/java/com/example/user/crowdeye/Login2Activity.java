package com.example.user.crowdeye;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        final EditText etUsername =(EditText) findViewById(R.id.etUsername);
        final EditText etPassword =(EditText) findViewById(R.id.etPassword);
        final Button bLogin =(Button) findViewById(R.id.bLogin);

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LoginIntent = new Intent(Login2Activity.this, UserProfileActivity.class);
                Login2Activity.this.startActivity(LoginIntent);

            }
        });




    }
}
