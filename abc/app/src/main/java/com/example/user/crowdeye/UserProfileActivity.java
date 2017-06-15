package com.example.user.crowdeye;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UserProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        final EditText etUsername =(EditText) findViewById(R.id.etUsername);
        final EditText etEmail =(EditText) findViewById(R.id.etEmail);
        final TextView WelcomeMsg =(TextView) findViewById(R.id.tvWelcomeMsg);

        final Button bViewEvents =(Button) findViewById(R.id.bViewEvents);
        final Button bCreateEvent =(Button) findViewById(R.id.bCreateEvent);


        bViewEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Main m = new Main(UserProfileActivity.this);
                m.execute();
               // Intent ViewEventsIntent = new Intent(UserProfileActivity.this, EventDetails.class);
               // UserProfileActivity.this.startActivity(ViewEventsIntent);

            }
        });
        bCreateEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent CreateEvenIntent = new Intent(UserProfileActivity.this, CreateEvents.class);
                UserProfileActivity.this.startActivity(CreateEvenIntent);

            }
        });

    }
}
