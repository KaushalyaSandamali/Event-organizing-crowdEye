package com.example.user.crowdeye;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FacebookLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook_login);

        final Button bCancel =(Button) findViewById(R.id.bCancel);
        final Button bOk =(Button) findViewById(R.id.bOk);

        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent OkIntent = new Intent(FacebookLoginActivity.this, UserProfileActivity.class);
                FacebookLoginActivity.this.startActivity(OkIntent);

            }
        });

        bCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent CancelIntent = new Intent(FacebookLoginActivity.this, LoginActivity.class);
                FacebookLoginActivity.this.startActivity(CancelIntent);

            }
        });
    }

}
