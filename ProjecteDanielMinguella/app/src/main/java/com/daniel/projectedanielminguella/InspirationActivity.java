package com.daniel.projectedanielminguella;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.daniel.projectedanielminguella.model.PeliculaGhibli;
import com.daniel.projectedanielminguella.retrofit.MyService;
import com.daniel.projectedanielminguella.retrofit.PeliculaGhibliAdapter;
import com.daniel.projectedanielminguella.retrofit.RetrofitClientInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InspirationActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<PeliculaGhibli> peliculasGhibli;
    PeliculaGhibliAdapter adapter;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inspiration);

        peliculasGhibli = new ArrayList<>();
        listView = findViewById(R.id.listviewGhibli);
        adapter = new PeliculaGhibliAdapter(this, R.layout.rowinspiration, peliculasGhibli);
        listView.setAdapter(adapter);
        progressBar = findViewById(R.id.progressBar);

        getFilms();
    }

    private void getFilms() {
        MyService service = RetrofitClientInstance.getRetrofitInstance().create(MyService.class);
        Call<List<PeliculaGhibli>> call = service.getPeliculas();
        call.enqueue(new Callback<List<PeliculaGhibli>>() {
            @Override
            public void onResponse(Call<List<PeliculaGhibli>> call, Response<List<PeliculaGhibli>> response) {
                peliculasGhibli.clear();
                peliculasGhibli.addAll(response.body());
                adapter.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);

            }

            @Override
            public void onFailure(Call<List<PeliculaGhibli>> call, Throwable t) {

                Toast.makeText(getApplicationContext(), "Error de conexió a la web de Ghibli", Toast.LENGTH_LONG).show();
            }
        });

    }


}
