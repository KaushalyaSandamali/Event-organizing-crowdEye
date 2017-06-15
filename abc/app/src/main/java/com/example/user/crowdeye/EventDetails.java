package com.example.user.crowdeye;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class EventDetails extends AppCompatActivity {

    String EName;
    TextView tvEName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);



//        tvEName=(TextView) findViewById(R.id.textViewEName);

        EName=getIntent().getStringExtra("EName");

      //  tvEName.setText("Event Name "+EName);
    }


    public void setEventList(){



    }


}
