package com.example.user.crowdeye;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Mapacticity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapacticity);


        final Button bEventDetails =(Button) findViewById(R.id.bEventDetails);


        bEventDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent EventDetailsIntent = new Intent(Mapacticity.this, EventDetails.class);
                Mapacticity.this.startActivity(EventDetailsIntent);

            }
        });



    }
}
