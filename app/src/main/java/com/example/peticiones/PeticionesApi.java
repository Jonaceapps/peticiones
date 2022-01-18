package com.example.peticiones;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

interface PeticionesApi {

    @GET("trapi")
    Call<List<ResponseTrapiItem>> obtenerArtistas();
}
