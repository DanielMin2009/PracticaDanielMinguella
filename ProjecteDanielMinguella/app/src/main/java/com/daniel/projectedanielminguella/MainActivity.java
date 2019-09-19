package com.daniel.projectedanielminguella;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.daniel.projectedanielminguella.controller.PeliculaController;
import com.daniel.projectedanielminguella.model.Pelicula;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    PeliculaAdapter adapter;
    ArrayList<Pelicula> peliculas;
    PeliculaController controller;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences("myPreferences", MODE_PRIVATE);

        if ("".equals(preferences.getString("user", "")))
        {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }

        listView = findViewById(R.id.listview);
        peliculas = new ArrayList<Pelicula>();
        adapter = new PeliculaAdapter(this, R.layout.row, peliculas);
        listView.setAdapter(adapter);
        controller = PeliculaController.get(this);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);

                intent.putExtra("idPelicula", peliculas.get(position).getId());

                startActivity(intent);
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        showPeliculas();

    }

    private void showPeliculas() {
        peliculas.clear();
        peliculas.addAll(controller.getPeliculas());
        adapter.notifyDataSetChanged();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_movie:
                Intent intent = new Intent(MainActivity.this, FormActivity.class);
                startActivity(intent);
                return (true);

            case R.id.inspiration:
                Intent intent2 = new Intent(MainActivity.this, InspirationActivity.class);
                startActivity(intent2);
                return (true);

        }
        return (super.onOptionsItemSelected(item));



    }
}
