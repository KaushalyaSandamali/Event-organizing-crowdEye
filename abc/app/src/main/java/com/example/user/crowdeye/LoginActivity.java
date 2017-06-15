package com.example.user.crowdeye;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final Button bLogin =(Button) findViewById(R.id.bLogin);
        final Button bSignUp =(Button) findViewById(R.id.bNext);
        final Button bLoginWithFacebook =(Button) findViewById(R.id.bLoginWithFacebook);

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LoginIntent = new Intent(LoginActivity.this, Login2Activity.class);
                LoginActivity.this.startActivity(LoginIntent);

            }
        });

        bSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent SignUpIntent = new Intent(LoginActivity.this, SignupActivity.class);
                LoginActivity.this.startActivity(SignUpIntent);

            }
        });

        bLoginWithFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LoginWithFacebookIntent = new Intent(LoginActivity.this, FacebookLoginActivity.class);
                LoginActivity.this.startActivity(LoginWithFacebookIntent);

            }
        });


    }
}
