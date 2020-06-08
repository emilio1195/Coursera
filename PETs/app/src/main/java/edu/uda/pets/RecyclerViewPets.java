package edu.uda.pets;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

//En esta clase se instancian los Valores o datos de cada mascota
public class RecyclerViewPets extends AppCompatActivity {
    ArrayList<DatosPets> ListaPets;
    private RecyclerView recyclerView;
    ImageView btnLike;
    private Toolbar myBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_pets);
        //myBar = (Toolbar) findViewById(R.id.userActionBar);
        //setActionBar(myBar);
        recyclerView = (RecyclerView) findViewById(R.id.RVPet);
        LinearLayoutManager linearLayoutV = new LinearLayoutManager(this); //Se colocara en este contexto un LinearLayout Vertical
        // que formara el Recycler view en la actividad
        recyclerView.setLayoutManager(linearLayoutV); //configuramos que el recycler view obtenga todas las caracteristicas de un LinearLayout
        RegistroDatosPets();
        CrearAdapter();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.btnfavoritos, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Favoritos:
                Intent favoritosVentana = new Intent(RecyclerViewPets.this,FavoritosPets.class);
                /*Bundle bund = new Bundle();
                bund.putSerializable("ListaPets", ListaPets);
                //le pasamos el bundle a la otra actividad
                favoritosVentana.putExtra("BundleLista",bund);*/
                startActivity(favoritosVentana);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void RegistroDatosPets(){
        ListaPets = new ArrayList<DatosPets>();
        ListaPets.add(new DatosPets("Lita","Chiguagua","201", R.drawable.lita,false,R.drawable.unlike));
        ListaPets.add(new DatosPets("Valentín","Chiguagua","501",R.drawable.vale,false,R.drawable.unlike));
        ListaPets.add(new DatosPets("Ojis","Balinese","744",R.drawable.ojis,false,R.drawable.unlike));
        ListaPets.add(new DatosPets("Kata","Angora Turca","265",R.drawable.kata,false,R.drawable.unlike));
        ListaPets.add(new DatosPets("Kyra","Schnauzer","911",R.drawable.kyra,false,R.drawable.unlike));
        ListaPets.add(new DatosPets("Mia","American Wirehair","311",R.drawable.mia,false,R.drawable.unlike));
        ListaPets.add(new DatosPets("Chily","French Poodle","881",R.drawable.chily,false,R.drawable.unlike));
        ListaPets.add(new DatosPets("Franshua","Scottish Fold","981",R.drawable.munchkin,false,R.drawable.unlike));
        ListaPets.add(new DatosPets("Genna","Blood Hound","571",R.drawable.genna,false,R.drawable.unlike));
        ListaPets.add(new DatosPets("Max","Pastor Alemán","651",R.drawable.nena,false,R.drawable.unlike));
        ListaPets.add(new DatosPets("Nory","Scottish Fold","981",R.drawable.scottish_fold,false,R.drawable.unlike));
    }

    private void CrearAdapter(){
        AdaptadorListaPets adaptadorListaPets = new AdaptadorListaPets(ListaPets,this);
        recyclerView.setAdapter(adaptadorListaPets);
    }

}
