package com.daniel.projectedanielminguella;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.daniel.projectedanielminguella.model.Pelicula;

import java.util.ArrayList;

public class PeliculaAdapter extends ArrayAdapter<Pelicula> {
    int layoutResourceId;
    Context context;
    ArrayList<Pelicula> data;
    TextView tv_title, tv_puntuation;

    public PeliculaAdapter(Context context, int layoutResourceId, ArrayList<Pelicula> data) {
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

        tv_title = row.findViewById(R.id.tv_title);

        String titol = data.get(position).getTitol();
        tv_title.setText(titol);

        tv_puntuation = row.findViewById(R.id.tv_puntuation);

        int puntuacio = data.get(position).getPuntuacio();
        tv_puntuation.setText(puntuacio);

        String descripcio = data.get(position).getDescripcio();
        tv_title.setText(descripcio);

        return row;
    }
}

