package com.daniel.projectedanielminguella.retrofit;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.daniel.projectedanielminguella.R;
import com.daniel.projectedanielminguella.model.PeliculaGhibli;

import java.util.ArrayList;

public class PeliculaGhibliAdapter extends ArrayAdapter<PeliculaGhibli> {
    int layoutResourceId;

    Context context;

    ArrayList<PeliculaGhibli> data;

    public PeliculaGhibliAdapter(Context context, int layoutResourceId, ArrayList<PeliculaGhibli> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        row = inflater.inflate(layoutResourceId, parent, false);
        TextView tv_titleInspiration = (TextView) row.findViewById(R.id.tv_titleInspiration);

        PeliculaGhibli p = data.get(position);
        tv_titleInspiration.setText(p.getTitle());
        return row;
    }
}
