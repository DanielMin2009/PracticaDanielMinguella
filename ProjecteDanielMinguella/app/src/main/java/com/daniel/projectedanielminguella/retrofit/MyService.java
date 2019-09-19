package com.daniel.projectedanielminguella.retrofit;

import com.daniel.projectedanielminguella.model.PeliculaGhibli;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyService {
    @GET("films/")
    Call <List<PeliculaGhibli>> getPeliculas();
}
