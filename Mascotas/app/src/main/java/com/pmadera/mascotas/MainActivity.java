package com.pmadera.mascotas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pmadera.mascotas.adapter.MascotaAdaptador;
import com.pmadera.mascotas.pojo.Mascota;
import com.pmadera.mascotas.presentador.iMainActivityPresenter;
import com.pmadera.mascotas.presentador.mainActivityPresenter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements iMainActivity{

    //private ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;
    private FloatingActionButton btnTopFive;
    private iMainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        rvMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

       btnTopFive=(FloatingActionButton)findViewById(R.id.btnTopFive);

        btnTopFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, FavoritosActivity.class);

                startActivity(intent);
            }
        });

        presenter=new mainActivityPresenter(MainActivity.this,this);

        presenter.obtenerImagenes();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent=null;

        switch (item.getItemId()){

            case R.id.mContacto:
                intent=new Intent(this,ContactoActivity.class);
                startActivity(intent);
                break;

            case R.id.mAcerca:
                intent=new Intent(this,AcercaActivity.class);
                startActivity(intent);
                break;

            case R.id.mConfigCuenta:
                intent=new Intent(this,ConfigurarCuentaActivity.class);
                startActivity(intent);
                break;



        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void creoLayout() {
        /*LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);*/

        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        rvMascotas.setLayoutManager(gridLayoutManager);

    }

    @Override
    public  MascotaAdaptador crearAdaptador(ArrayList<Mascota> listaMascotas) {
        MascotaAdaptador oAdaptador=new MascotaAdaptador(listaMascotas,this);

        return oAdaptador;
    }

    @Override
    public void inicializoAdaptador(MascotaAdaptador pAdaptador) {

        rvMascotas.setAdapter(pAdaptador);
    }
}