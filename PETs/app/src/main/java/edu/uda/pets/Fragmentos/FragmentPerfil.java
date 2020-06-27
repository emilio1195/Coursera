package edu.uda.pets.Fragmentos;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        gridLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        addFotos();
        AdapterInit();
        return v;
    }

    private void addFotos(){
        ListFotosPerfil = new ArrayList<FotosPerfil>();
        ListFotosPerfil.add(new FotosPerfil(R.drawable.katapri,"235"));
        ListFotosPerfil.add(new FotosPerfil(R.drawable.katasec,"566"));
        ListFotosPerfil.add(new FotosPerfil(R.drawable.katater,"244"));
        ListFotosPerfil.add(new FotosPerfil(R.drawable.katacuar,"2222"));
        ListFotosPerfil.add(new FotosPerfil(R.drawable.kataquin,"366"));
        ListFotosPerfil.add(new FotosPerfil(R.drawable.katase,"878"));
        ListFotosPerfil.add(new FotosPerfil(R.drawable.katasep,"700"));
        ListFotosPerfil.add(new FotosPerfil(R.drawable.kataoct,"1333"));
    }

    private void AdapterInit(){
        AdaptadorFotosPerfil adaptadorFotosPerfil = new AdaptadorFotosPerfil(ListFotosPerfil,getActivity());
        recyclerView.setAdapter(adaptadorFotosPerfil);
    }

}
