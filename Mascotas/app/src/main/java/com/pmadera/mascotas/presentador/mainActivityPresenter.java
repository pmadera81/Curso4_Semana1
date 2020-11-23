package com.pmadera.mascotas.presentador;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.pmadera.mascotas.pojo.Mascota;
import com.pmadera.mascotas.resApi.adapter.EndpointsApi;
import com.pmadera.mascotas.resApi.adapter.Model.MascotaResponse;
import com.pmadera.mascotas.resApi.adapter.RestApiAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class mainActivityPresenter implements iMainActivityPresenter{

    private com.pmadera.mascotas.iMainActivity iMainActivity;
    private Context context;
    private ArrayList<Mascota> listaMascotas;

    public mainActivityPresenter(com.pmadera.mascotas.iMainActivity iMainActivity, Context context) {
        this.iMainActivity = iMainActivity;
        this.context = context;


    }


    @Override
    public void obtenerImagenes() {
        RestApiAdapter restApiAdapter=new RestApiAdapter();

        Gson gsonMedia= restApiAdapter.construyeGsonDeserializadorMedia();

        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMedia);

        Call<MascotaResponse> mascotaResponseCall = endpointsApi.getMedia();

        mascotaResponseCall.enqueue(new Callback<MascotaResponse>() {
            @Override
            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                MascotaResponse contactoResponse = response.body();

                listaMascotas = contactoResponse.getMascotas();

                mostrarMascotas();
            }

            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {
                Toast.makeText(context, "Algo paso en la conexion, intenta de nuevo", Toast.LENGTH_LONG).show();

                Log.i("FALLO LA CONEXION",t.toString());
            }
        });
    }

    @Override
    public void mostrarMascotas() {
        iMainActivity.inicializoAdaptador(iMainActivity.crearAdaptador(listaMascotas));
        iMainActivity.creoLayout();
    }



}
