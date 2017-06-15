package com.example.user.crowdeye;

import android.content.Context;
import android.content.Intent;
import android.net.http.SslCertificate;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static android.widget.Toast.LENGTH_LONG;

public class CreateEvents extends AppCompatActivity {
    EditText etEventName,etDescription,etStartDate,etEndDate,etLocationName,etLocation;
    String EName,DName,SDate,EDate,LName,Location;
    InputStream is = null;
    String result = null;
    String line = null;
    Context etx=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_events);

          etEventName =(EditText) findViewById(R.id.etEventName);
          etDescription =(EditText) findViewById(R.id.etDescription);
          etStartDate =(EditText) findViewById(R.id.etStartDate);
          etEndDate =(EditText) findViewById(R.id.etEndDate);
          etLocationName =(EditText) findViewById(R.id.etLocationName);
          etLocation =(EditText) findViewById(R.id.etLocation);
        final Button bCreate =(Button) findViewById(R.id.bCreate);


        bCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register_register(v);
            }
        });
    }

    public void register_register(View v){
        EName=etEventName.getText().toString();
        DName=etDescription.getText().toString();
        SDate=etStartDate.getText().toString();
        EDate=etEndDate.getText().toString();
        LName=etLocationName.getText().toString();
        Location=etLocation.getText().toString();
        Background b=new Background();
        b.execute(EName,DName,SDate,EDate,LName,Location);
    }

    class Background extends AsyncTask<String,String,String> {

        @Override
        protected String doInBackground(String... params) {
            String etEventName1=params[0];
            String etDescription1=params[1];
            String etStartDate1=params[2];
            String etEndDate1=params[3];
            String etLocationName1=params[4];
            String etLocation1=params[5];
            String data="";
            int tmp;
            try {
                URL url=new URL("http://10.0.2.2/eventCreate.php");
                String urlParams="event_name="+EName+"&description="+DName+"&start_date="+SDate+"&end_date="+EDate+"&location_name="+LName+"&Location="+Location;
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
                httpURLConnection.setFixedLengthStreamingMode(urlParams.getBytes().length);
                PrintWriter out = new PrintWriter(httpURLConnection.getOutputStream());
                out.print(urlParams);
                out.close();

                /*while((tmp=is.read())!=-1){
                    data+=(char)tmp;
                }
                Log.e("++++++++++>>>>>>>>>>",data);*/
                //is.close();
                data =httpURLConnection.getResponseMessage();
                httpURLConnection.disconnect();
                //Log.e("++++++++++>>>>>>>>>>",data);
                return data;
            } catch (MalformedURLException e) {
                e.printStackTrace();
                return "failed1"+ e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return "failed2"+e.getMessage();
            }

        }

        @Override
        protected void onPostExecute(String s) {
            if(s.equals("")){
                s="data saved successfully";
                Toast.makeText(getApplicationContext(),s, LENGTH_LONG).show();
            }
            Toast.makeText(getApplicationContext(),s, Toast.LENGTH_LONG).show();
        }
    }
}
