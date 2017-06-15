package com.example.user.crowdeye;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);


        final Button bChooseAPhoto =(Button) findViewById(R.id.bChooseAPhoto);
        final Button bTakeANewPhoto =(Button) findViewById(R.id.bTakeANewPhoto);
        final Button bSignUp =(Button) findViewById(R.id.bSignUp);

        bSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent SignUpIntent = new Intent(UserActivity.this, UserProfileActivity.class);
                UserActivity.this.startActivity(SignUpIntent);

            }
        });
    }
}
