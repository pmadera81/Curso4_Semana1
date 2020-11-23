package com.pmadera.mascotas.vista_fragment;

import com.pmadera.mascotas.adapter.MascotaAdaptador;
import com.pmadera.mascotas.adapter.MascotaAdaptadorFavoritos;
import com.pmadera.mascotas.pojo.Mascota;

import java.util.ArrayList;

public interface iFavoritosFragment {

    public void creoLayout();

    public MascotaAdaptadorFavoritos crearAdaptador(ArrayList<Mascota> listaMascotas);

    public void inicializoAdaptador(MascotaAdaptadorFavoritos pAdaptador);

}


