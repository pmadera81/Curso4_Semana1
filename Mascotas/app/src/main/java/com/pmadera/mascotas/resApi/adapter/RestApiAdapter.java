package com.pmadera.mascotas.resApi.adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pmadera.mascotas.pojo.Mascota;
import com.pmadera.mascotas.resApi.adapter.Model.MascotaResponse;
import com.pmadera.mascotas.resApi.adapter.deserializador.MascotaDeserializador;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiAdapter {
    //**************************************************

    public EndpointsApi establecerConexionRestApiInstagram(Gson gson){

        Retrofit retrofit=new Retrofit.Builder().baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson)).build();


        return retrofit.create(EndpointsApi.class);

    }

    public Gson construyeGsonDeserializadorMedia(){
        GsonBuilder gsonBuilder=new GsonBuilder();

        gsonBuilder.registerTypeAdapter(MascotaResponse.class,new MascotaDeserializador());


        return gsonBuilder.create();


    }





}
