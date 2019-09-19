package com.daniel.projectedanielminguella;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.daniel.projectedanielminguella.controller.PeliculaController;
import com.daniel.projectedanielminguella.model.Pelicula;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    String title, description, image, idPelicula;
    int year, puntuation;

    PeliculaController controller;

    Pelicula pelicula;

    TextView tv_title, tv_description, tv_year, tv_puntuation;

    ImageView iv_urlimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        idPelicula = getIntent().getStringExtra("idPelicula");
        controller = PeliculaController.get(this);
        pelicula = controller.getPelicula(idPelicula);

        initFilms();
        showFilm();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    private void initFilms()
    {
        tv_title = findViewById(R.id.tv_title);
        tv_description = findViewById(R.id.tv_description);
        tv_year = findViewById(R.id.tv_year);
        tv_puntuation = findViewById(R.id.tv_puntuation);
        iv_urlimage = findViewById(R.id.iv_urlimage);
    }

    private void showFilm()
    {
        tv_title.setText(pelicula.getTitol());
        tv_description.setText(pelicula.getDescripcio());
        tv_year.setText(String.valueOf(pelicula.getAny()));
        tv_puntuation.setText(String.valueOf(pelicula.getPuntuacio()));
        image = pelicula.getImatge();

        Picasso.get().load(image)
                .into(iv_urlimage);




    }

    public void delete(View view) {
        controller.deletePelicula(pelicula);
        finish();
    }
}

