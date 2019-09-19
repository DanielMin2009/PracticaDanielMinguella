package com.daniel.projectedanielminguella;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.daniel.projectedanielminguella.controller.PeliculaController;
import com.daniel.projectedanielminguella.model.Pelicula;

public class FormActivity extends AppCompatActivity {

    EditText et_title, et_description, et_year, et_puntuation, et_urlimage;
    PeliculaController controller;
    Pelicula pelicula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        et_title = findViewById(R.id.et_title);
        et_description = findViewById(R.id.et_description);
        et_year = findViewById(R.id.et_year);
        et_puntuation = findViewById(R.id.et_puntuation);
        et_urlimage = findViewById(R.id.et_urlimage);

        controller = PeliculaController.get(this);
    }

    public void createFilm(View view) {

        if (checkFields()) {
            String titol = et_title.getText().toString();
            String descripcio = et_description.getText().toString();
            int any = Integer.parseInt(et_year.getText().toString());
            int puntuacio = Integer.parseInt(et_puntuation.getText().toString());
            String imatge = et_urlimage.getText().toString();

            pelicula = new Pelicula(titol, descripcio, any, puntuacio, imatge);
            controller.createPelicula(pelicula);

            finish();
        }
    }

    private boolean checkFields() {

        String titol = et_title.getText().toString();
        String descripcio = et_description.getText().toString();
        String any = et_year.getText().toString();
        String puntuacio = et_puntuation.getText().toString();
        String imatge = et_urlimage.getText().toString();

        boolean valid = true;

        if ("".equals(titol)) {
            et_title.setError(getString(R.string.errEmptyTitle));
            valid = false;
        }
        if ("".equals(descripcio)) {
            et_description.setError(getString(R.string.errEmptyDescription));
            valid = false;
        }
        if ("".equals(any)) {
            et_year.setError(getString(R.string.errEmptyYear));
            valid = false;
        }
        if ("".equals(puntuacio)) {
            et_puntuation.setError(getString(R.string.errEmptyPuntuation));
            valid = false;
        } else {
            int puntuation = Integer.parseInt(et_puntuation.getText().toString());
                if (puntuation > 5 && puntuation > 0) {
                    et_puntuation.setError(getString(R.string.errPuntuation5));
                    valid = false;
                }
            }

        if ("".equals(imatge)) {
            et_urlimage.setError(getString(R.string.errEmptyImg));
            valid = false;
        }
        return valid;
    }
}
