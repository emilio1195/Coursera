package edu.uda.pets;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import edu.uda.pets.Adapter.AdaptadorListaPets;
import edu.uda.pets.POJO.DatosPets;

public class FavoritosPets extends AppCompatActivity {
    private ArrayList<DatosPets> pilaPets;
    private RecyclerView recyclerView;
    private Toolbar toolbar;
    ArrayList<DatosPets> lista = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos_pets);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null ){
            setSupportActionBar(toolbar);
        }
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true); //se puede activar aqui o atraves del manifest
        recyclerView = (RecyclerView) findViewById(R.id.RVFavoritos);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        addListaPet();
        adaptadorFavoritos();
    }
    private void addListaPet(){
        pilaPets = new ArrayList<>();
        pilaPets.add(new DatosPets("Valentín","Chiguagua","502",R.drawable.vale,false,R.drawable.like));
        pilaPets.add(new DatosPets("Kata","Angora Turca","266",R.drawable.kata,false,R.drawable.like));
        pilaPets.add(new DatosPets("Mia","American Wirehair","312",R.drawable.mia,false,R.drawable.like));
        pilaPets.add(new DatosPets("Chily","French Poodle","882",R.drawable.chily,false,R.drawable.like));
        pilaPets.add(new DatosPets("Nory","Scottish Fold","982",R.drawable.scottish_fold,false,R.drawable.like));


    }
    private void adaptadorFavoritos(){
        AdaptadorListaPets adapterFavoritos = new AdaptadorListaPets(pilaPets,this);
        recyclerView.setAdapter(adapterFavoritos);

    }
}
