package com.pmadera.mascotas;

import com.pmadera.mascotas.adapter.MascotaAdaptador;
import com.pmadera.mascotas.pojo.Mascota;

import java.util.ArrayList;

public interface iMainActivity {
    public void creoLayout();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> listaMascotas);

    public void inicializoAdaptador(MascotaAdaptador pAdaptador);

}
