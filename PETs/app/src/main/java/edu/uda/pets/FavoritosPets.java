package edu.uda.pets;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FavoritosPets extends AppCompatActivity {
    private ArrayList<DatosPets> pilaPets;
    private RecyclerView recyclerView;
    ArrayList<DatosPets> lista = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos_pets);
        //getActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle bundle = new Bundle();
        //recuperamos el bundle
        bundle = getIntent().getBundleExtra("BundleLista");
        //recuperamos la lista del bundle
        lista = (ArrayList<DatosPets>) bundle.getSerializable("ListaPets");
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
