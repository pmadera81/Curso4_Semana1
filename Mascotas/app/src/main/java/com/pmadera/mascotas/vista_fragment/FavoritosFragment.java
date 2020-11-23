package com.pmadera.mascotas.vista_fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pmadera.mascotas.R;
import com.pmadera.mascotas.adapter.MascotaAdaptador;
import com.pmadera.mascotas.adapter.MascotaAdaptadorFavoritos;
import com.pmadera.mascotas.pojo.Mascota;
import com.pmadera.mascotas.presentador.FavoritosFragmentPresenter;
import com.pmadera.mascotas.presentador.iFavoritosFragmentPresenter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FavoritosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FavoritosFragment extends Fragment implements iFavoritosFragment {

    private ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotasFavoritas;
    private iFavoritosFragmentPresenter presenter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FavoritosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FavoritosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FavoritosFragment newInstance(String param1, String param2) {
        FavoritosFragment fragment = new FavoritosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fragment_favoritos,container,false);

        rvMascotasFavoritas = (RecyclerView) v.findViewById(R.id.rvMascotasFav);


        presenter=new FavoritosFragmentPresenter(this,getContext());

        return v;


    }



    @Override
    public void creoLayout() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotasFavoritas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptadorFavoritos crearAdaptador(ArrayList<Mascota> listaMascotas) {
        MascotaAdaptadorFavoritos oAdaptador=new MascotaAdaptadorFavoritos(listaMascotas,getActivity());

        return oAdaptador;
    }

    @Override
    public void inicializoAdaptador(MascotaAdaptadorFavoritos pAdaptador) {
        rvMascotasFavoritas.setAdapter(pAdaptador);
    }
}