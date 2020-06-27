package edu.uda.pets.Fragmentos;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import edu.uda.pets.Adapter.AdaptadorListaPets;
import edu.uda.pets.POJO.DatosPets;
import edu.uda.pets.R;


public class FragmentRecyclerView extends Fragment {

    ArrayList<DatosPets> ListaPets;
    private RecyclerView recyclerView;


    public FragmentRecyclerView() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_fragment_recycler_view, container, false);
        View v = inflater.inflate(R.layout.fragment_fragment_recycler_view, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.RVPet);
        LinearLayoutManager linearLayoutV = new LinearLayoutManager(getActivity()); //Se colocara en este contexto un LinearLayout Vertical
        linearLayoutV.setOrientation(RecyclerView.VERTICAL);
        // que formara el Recycler view en la actividad
        recyclerView.setLayoutManager(linearLayoutV); //configuramos que el recycler view obtenga todas las caracteristicas de un LinearLayout
        RegistroDatosPets();
        CrearAdapter();
        return v;
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
        AdaptadorListaPets adaptadorListaPets = new AdaptadorListaPets(ListaPets,getActivity());
        recyclerView.setAdapter(adaptadorListaPets);
    }
}
