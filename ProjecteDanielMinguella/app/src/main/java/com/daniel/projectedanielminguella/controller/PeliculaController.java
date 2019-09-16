package com.daniel.projectedanielminguella.controller;

import android.content.Context;

import androidx.room.Room;

import com.daniel.projectedanielminguella.database.PeliculaDao;
import com.daniel.projectedanielminguella.database.PeliculaDatabase;
import com.daniel.projectedanielminguella.model.Pelicula;

import java.util.List;

public class PeliculaController {
    private static PeliculaController controller;

    private PeliculaDao peliculaDao;

    private PeliculaController(Context context) {
        Context appContext = context.getApplicationContext();
        PeliculaDatabase database = Room.databaseBuilder(appContext, PeliculaDatabase.class, "pelicula")
                .allowMainThreadQueries().build();
        peliculaDao = database.getPeliculaDao();
    }

    public static PeliculaController get(Context context) {
        if (controller == null) {
            controller = new PeliculaController(context);
        }
        return controller;
    }

    public List<Pelicula> getPeliculas() {
        return peliculaDao.getPeliculas();
    }

    public Pelicula getPelicula(String id) {
        return peliculaDao.getPelicula(id);
    }

    public void createPelicula(Pelicula p) {
        peliculaDao.addPelicula(p);
    }

    public void deletePelicula(Pelicula p) {
        peliculaDao.deletePelicula(p);
    }

    public void updatePelicula(Pelicula p) {
        peliculaDao.updatePelicula(p);
    }
}
