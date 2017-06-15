package com.example.user.crowdeye;

import android.content.Context;
import android.content.Intent;
import android.database.CursorJoiner;
import android.os.AsyncTask;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static android.Manifest.permission_group.LOCATION;
import static android.support.v4.app.ActivityCompat.startActivity;

/**
 * Created by Kaushalya Sandamali on 3/11/2017.
 */

public class Main extends AsyncTask<String,String,String> {
    private static Context ctx;
    EditText etEventName,etDescription,etStartDate,etEndDate,etLocationName,etLocation;
    String EName,DName,SDate,EDate,LName,Location;

    Main(Context ctx){
        this.ctx=ctx;
    }

    @Override
    protected String doInBackground(String... params) {
        String EName=params[0];

        String data="";
        int tmp;

        try{
            URL url=new URL("http://10.0.2.2/viewEvents.php");
            //String urlParams="event_name="+EName+"&description="+DName+"&start_date="+SDate+"&end_date="+EDate+"&location_name="+LName+"&Location="+Location;
            HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
            httpURLConnection.setDoOutput(true);
            OutputStream os=httpURLConnection.getOutputStream();
            //os.write(urlParams.getBytes());
            os.flush();
            os.close();
            String line="";
            InputStream is=httpURLConnection.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(is));
            while((line=bufferedReader.readLine())!=null){
                data+=line;
            }

           // while((tmp=is.read())!=-1){
            //    data+=(char)tmp;
           // }

            is.close();
            httpURLConnection.disconnect();

            return data;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return "Exception: "+e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
            return "Exception: "+e.getMessage();
        }

    }

    @Override
    protected void onPostExecute(String s) {
        String err=null;
        String ENAME="";
        try {
            JSONObject root=new JSONObject(s);
            JSONArray result=root.getJSONArray("result");
            int limit=result.length();
            for(int i=0;i<limit;i++)
                ENAME+= result.getJSONObject(i).getString("name");
          //  ENAME=result.getString("name");
           /* DNAME=user_data.getString("DName");
            SDATA=user_data.getString("SDate");
            EDATA=user_data.getString("EDate");
            LNAME=user_data.getString("LName");
            LOCATION=user_data.getString("Location");*/

        } catch (JSONException e) {
            e.printStackTrace();
            err="Exeption: "+e.getMessage();
        }


        Intent i=new Intent(ctx,EventDetails.class);
        i.putExtra("EName",ENAME);
       /* i.putExtra("DName",DNAME);
        i.putExtra("SDate",SDATA);
        i.putExtra("EDate",EDATA);
        i.putExtra("LName",LNAME);
        i.putExtra("Location",LOCATION);*/
        ctx.startActivity(i);
    }
}
