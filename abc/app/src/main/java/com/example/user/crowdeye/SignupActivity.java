package com.example.user.crowdeye;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.ref.ReferenceQueue;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static android.R.attr.name;
import static android.widget.Toast.LENGTH_LONG;

public class SignupActivity extends AppCompatActivity {
    EditText etFName,etLName,etEmail,etPhoneNumber,etPassword;
    String Fname,Lname,Email,Phonenumber,Password;
    InputStream is = null;
    String result = null;
    String line = null;
    Context etx=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        etFName = (EditText) findViewById(R.id.etFName);
        etLName = (EditText) findViewById(R.id.etLName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPhoneNumber = (EditText) findViewById(R.id.etPhoneNumber);
        etPassword = (EditText) findViewById(R.id.etPassword);
        final Button bNext = (Button) findViewById(R.id.bNext);
        final Button bSignInFacebook = (Button) findViewById(R.id.bSignInFacebook);



        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                register_register(v);
                Intent NextIntent = new Intent(SignupActivity.this, UserActivity.class);
                SignupActivity.this.startActivity(NextIntent);

            }
        });

        bSignInFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent SigninFacebookIntent = new Intent(SignupActivity.this, FacebookLoginActivity.class);
                SignupActivity.this.startActivity(SigninFacebookIntent);

            }
        });


    }


    public void register_register(View v){
        Fname=etFName.getText().toString();
        Lname=etLName.getText().toString();
        Email=etEmail.getText().toString();
        Phonenumber=etPhoneNumber.getText().toString();
        Password=etPassword.getText().toString();
        Background b=new Background();
        b.execute(Fname,Lname,Email,Phonenumber,Password);


    }

    class Background extends AsyncTask<String,String,String> {


        @Override
        protected String doInBackground(String... params) {
            String etFName1=params[0];
            String etLName1=params[1];
            String etEmail1=params[2];
            String etPhoneNumber1=params[3];
            String etPassword1=params[4];
            String data="";
            int tmp;

            try {
                URL url=new URL("http://10.0.2.2/register.php");
                String urlParams="first_name="+Fname+"&last_name="+Lname+"&email="+Email+"&phone_number="+Phonenumber+"&password="+Password;
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Content-Type",
                        "application/x-www-form-urlencoded");
                httpURLConnection.setFixedLengthStreamingMode(
                        urlParams.getBytes().length);
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
