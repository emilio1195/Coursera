package edu.uda.pets.vista.favoritos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;

import edu.uda.pets.Adapter.AdaptadorFavoritos;
import edu.uda.pets.Adapter.AdaptadorListaPets;
import edu.uda.pets.POJO.DatosPets;
import edu.uda.pets.Presentador.FavoritosPetsPresentador;
import edu.uda.pets.Presentador.InterfazFavoritosPresentador;
import edu.uda.pets.R;

public class FavoritosPets extends AppCompatActivity implements InterfazFavoritosVista {
    private ArrayList<DatosPets> pilaPets;
    private RecyclerView recyclerView;
    private Toolbar toolbar;
    private Context context;
    private InterfazFavoritosPresentador interfazFavoritosPresentador;
    ArrayList<DatosPets> lista = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos_pets);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null ){
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true); //se puede activar aqui o atraves del manifest
        recyclerView = (RecyclerView) findViewById(R.id.RVFavoritos);

        ////Se instancia el obj de presentador el cual inicializara todo los metodos que van en cadena
        // para ejecutar la extraccion de los dabos de la BD
        interfazFavoritosPresentador  = new FavoritosPetsPresentador(this,getBaseContext());

        //addListaPet();
        //adaptadorFavoritos();
    }
    /*private void addListaPet(){
        pilaPets = new ArrayList<>();
        pilaPets.add(new DatosPets("Valentín","Chiguagua","502",R.drawable.vale,false,R.drawable.like));
        pilaPets.add(new DatosPets("Kata","Angora Turca","266",R.drawable.kata,false,R.drawable.like));
        pilaPets.add(new DatosPets("Mia","American Wirehair","312",R.drawable.mia,false,R.drawable.like));
        pilaPets.add(new DatosPets("Chily","French Poodle","882",R.drawable.chily,false,R.drawable.like));
        pilaPets.add(new DatosPets("Nory","Scottish Fold","982",R.drawable.scottish_fold,false,R.drawable.like));


    }*/

    //private void adaptadorFavoritos(){


    @Override
    public void generarLayoutRCV() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public AdaptadorFavoritos crearAdaptador(ArrayList<DatosPets> datosPet) {
        AdaptadorFavoritos adapterFavoritos = new AdaptadorFavoritos(datosPet,this);
        return adapterFavoritos;
    }

    @Override
    public void InitAdaptadorfav(AdaptadorFavoritos adaptadorFavoritos) {
        recyclerView.setAdapter(adaptadorFavoritos);
    }
}
