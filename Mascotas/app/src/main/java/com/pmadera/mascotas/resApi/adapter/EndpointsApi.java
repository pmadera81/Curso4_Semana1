package com.pmadera.mascotas.resApi.adapter;

import com.pmadera.mascotas.pojo.Mascota;
import com.pmadera.mascotas.resApi.adapter.Model.MascotaResponse;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface EndpointsApi {

    @GET(ConstantesRestApi.URL_GET_MEDIA_USER)
    Call<MascotaResponse> getMedia();


    @GET(ConstantesRestApi.URL_CONTENIDO_FOTO)
    Call<Mascota> find(@Path("id") String id) ;

}
