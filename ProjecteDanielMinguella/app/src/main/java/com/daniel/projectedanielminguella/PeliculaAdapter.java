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
        tv_puntuation.setText(String.valueOf(puntuacio));

        String titolPeli = data.get(position).getTitol();
        tv_title.setText(titolPeli);

        int puntuation = data.get(position).getPuntuacio();

        if (puntuation <= 1)
        {
            tv_puntuation.setTextColor(context.getResources().getColor(R.color.colorRedCorp));
        }else if (puntuation > 1 && puntuation <= 3)
        {
            tv_puntuation.setTextColor(context.getResources().getColor(R.color.colorPrimaryDark));
        }else
        {
            tv_puntuation.setTextColor(context.getResources().getColor(R.color.colorGreenCorp));
        }


        return row;
    }
}

