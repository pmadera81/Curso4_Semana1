package com.pmadera.mascotas.presentador;

import android.content.Context;

import com.pmadera.mascotas.pojo.Mascota;
import com.pmadera.mascotas.vista_fragment.iFavoritosFragment;
import java.util.ArrayList;

public class FavoritosFragmentPresenter implements iFavoritosFragmentPresenter {

    private iFavoritosFragment iFavoritosFragment;
    private Context context;
    private ArrayList<Mascota> listaMascotas;
    //private ConstructorMascotas oConstructorMascotas;

    public FavoritosFragmentPresenter(com.pmadera.mascotas.vista_fragment.iFavoritosFragment iFavoritosFragment, Context context) {
        this.iFavoritosFragment = iFavoritosFragment;
        this.context = context;

        retornar5MascotasMasRating();
    }

    @Override
    public void retornar5MascotasMasRating() {
        /*oConstructorMascotas=new ConstructorMascotas(context);

        listaMascotas=oConstructorMascotas.retornar5MascotasMasRating();

        mostrarMascotas();*/
    }

    @Override
    public void mostrarMascotas() {
        iFavoritosFragment.inicializoAdaptador(iFavoritosFragment.crearAdaptador(listaMascotas));
        iFavoritosFragment.creoLayout();
    }
}
