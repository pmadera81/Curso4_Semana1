package com.pmadera.mascotas.resApi.adapter.deserializador;

import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.pmadera.mascotas.pojo.Mascota;
import com.pmadera.mascotas.resApi.adapter.ConstantesRestApi;
import com.pmadera.mascotas.resApi.adapter.EndpointsApi;
import com.pmadera.mascotas.resApi.adapter.Model.MascotaResponse;
import com.pmadera.mascotas.resApi.adapter.RestApiAdapter;
import com.pmadera.mascotas.resApi.adapter.jsonKeys;


import java.lang.reflect.Type;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MascotaDeserializador implements JsonDeserializer<MascotaResponse> {
    private ArrayList<Mascota> listaMascotas;
    @Override
    public MascotaResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson=new Gson();

        MascotaResponse contactoResponse= gson.fromJson(json, MascotaResponse.class);

        JsonArray mascotaResponseData = json.getAsJsonObject().getAsJsonArray(jsonKeys.MEDIA_RESPONSE_ARRAY);

        contactoResponse.setMascotas(deserializarMascotaoJson(mascotaResponseData));


        return contactoResponse;
    }

    private ArrayList<Mascota> deserializarMascotaoJson(JsonArray mascotaResponseData){
        ArrayList<Mascota> mascotas=new ArrayList<>();

        Retrofit retrofit=new Retrofit.Builder().baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();

        EndpointsApi endpointsApi=retrofit.create(EndpointsApi.class);

        try {
            for (int i = 0; i < mascotaResponseData.size(); i++) {
                JsonObject mascotaResponseDataObject = mascotaResponseData.get(i).getAsJsonObject();

                String id = mascotaResponseDataObject.get(jsonKeys.ID).getAsString();

                Mascota m = new Mascota();
                m.setId(id);

                cargoFoto(m, endpointsApi);
                mascotas.add(m);


            }
            //POR ALGUN MOTIBO LA ULTIMA FOTO NO ME LA CARGABA
            //ACA BOY OTRA VEZ A BUSCAR LA IMAGEN
            cargoFoto(mascotas.get(mascotas.size()-1), endpointsApi);


        }
        catch (Exception e){
            Log.i("ERROR DE COMUNICACION",e.getMessage());
        }

        return mascotas;
    }

    private void cargoFoto(final Mascota oMascota, EndpointsApi endpointsApi) throws Exception{

        Call<Mascota> call=endpointsApi.find(oMascota.getId());

        //retraso de 1/2 segundo para que de tiempo de cargar las imagenes
        Thread.sleep(500);

            call.enqueue(new Callback<Mascota>() {

                @Override
                public void onResponse(Call<Mascota> call, Response<Mascota> response) {

                    if (response.isSuccessful()) {
                        Mascota m = response.body();

                        String urlImagen = m.getMedia_url();

                        oMascota.setMedia_url(urlImagen);

                    }

                }

                @Override
                public void onFailure(Call<Mascota> call, Throwable t) {
                    //Toast.makeText(this, "Algo paso en la conexion, intenta de nuevo", Toast.LENGTH_LONG).show();

                    Log.i("FALLO LA CONEXION", t.toString());
                }
            });




    }


}
