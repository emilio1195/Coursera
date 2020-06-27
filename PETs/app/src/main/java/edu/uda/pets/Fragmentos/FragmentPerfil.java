package edu.uda.pets.Fragmentos;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

import edu.uda.pets.Adapter.AdaptadorFotosPerfil;
import edu.uda.pets.POJO.FotosPerfil;
import edu.uda.pets.R;


/**
 * https://github.com/lopspower/CircularImageView
 */
public class FragmentPerfil extends Fragment {
    private RecyclerView recyclerView;
    ArrayList<FotosPerfil> ListFotosPerfil;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment_perfil, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.RVperfil);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        gridLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        addFotos();
        AdapterInit();
        return v;
    }

    private void addFotos(){
        ListFotosPerfil = new ArrayList<FotosPerfil>();
        ListFotosPerfil.add(new FotosPerfil(R.drawable.kata1,"235"));
        ListFotosPerfil.add(new FotosPerfil(R.drawable.kata2,"566"));
        ListFotosPerfil.add(new FotosPerfil(R.drawable.kata3,"244"));
        ListFotosPerfil.add(new FotosPerfil(R.drawable.kata4,"2222"));
        ListFotosPerfil.add(new FotosPerfil(R.drawable.kata5,"366"));
        ListFotosPerfil.add(new FotosPerfil(R.drawable.kata6,"878"));
        ListFotosPerfil.add(new FotosPerfil(R.drawable.kata7,"700"));
        ListFotosPerfil.add(new FotosPerfil(R.drawable.kata8,"1333"));
        ListFotosPerfil.add(new FotosPerfil(R.drawable.kata9,"997"));


    }

    private void AdapterInit(){
        AdaptadorFotosPerfil adaptadorFotosPerfil = new AdaptadorFotosPerfil(ListFotosPerfil,getActivity());
        recyclerView.setAdapter(adaptadorFotosPerfil);
    }

}
