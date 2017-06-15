package com.example.user.crowdeye;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.util.ArrayList;

public class EventAdapter extends ArrayAdapter<Events> {
    ArrayList<Events> EventList;
    LayoutInflater vi;
    int Resource;
    ViewHolder holder;

    public EventAdapter(Context context, int resource, ArrayList<Events> objects) {
        super(context, resource, objects);
        vi = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Resource = resource;
        EventList = objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // convert view = design
        View v = convertView;
        if (v == null) {
            holder = new ViewHolder();
            v = vi.inflate(Resource, null);

            holder.eventName = (TextView) v.findViewById(R.id.eventName);

            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }
      holder.eventName.setText("Reg No :"+EventList.get(position).getEventName());
      return v;

    }

    static class ViewHolder {

        public TextView eventName;

    }

   
}
