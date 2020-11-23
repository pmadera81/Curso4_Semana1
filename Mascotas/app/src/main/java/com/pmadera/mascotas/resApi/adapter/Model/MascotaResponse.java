package com.pmadera.mascotas.resApi.adapter.Model;

import com.pmadera.mascotas.pojo.Mascota;


import java.util.ArrayList;

public class MascotaResponse {

    ArrayList<Mascota> mascotas;

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascota) {
        this.mascotas = mascota;
    }
}
