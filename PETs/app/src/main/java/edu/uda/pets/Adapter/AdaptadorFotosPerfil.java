package edu.uda.pets.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import edu.uda.pets.Contacto;
import edu.uda.pets.POJO.FotosPerfil;
import edu.uda.pets.R;

public class AdaptadorFotosPerfil extends RecyclerView.Adapter<AdaptadorFotosPerfil.PerfilViewHolder> {

    ArrayList<FotosPerfil> ListfotosPerfil;

    public static class  PerfilViewHolder extends RecyclerView.ViewHolder{
        ImageView foto;
        TextView rating;
        public PerfilViewHolder(@NonNull View itemView) {
            super(itemView);
            foto = (ImageView) itemView.findViewById(R.id.foto);
            rating = (TextView) itemView.findViewById(R.id.txtrating);
        }
    }

    @NonNull
    @Override
    public PerfilViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_foto_rating,parent,false);

        return new PerfilViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PerfilViewHolder perfilViewHolder, int position) {
        final FotosPerfil fotosPerfil = ListfotosPerfil.get(position);
        perfilViewHolder.foto.setImageResource(fotosPerfil.getFoto());
        perfilViewHolder.rating.setText(fotosPerfil.getRating());
    }

    @Override
    public int getItemCount() {
        return ListfotosPerfil.size();
    }

    private final Activity activity;
    public AdaptadorFotosPerfil(ArrayList<FotosPerfil> listfotosPerfil, Activity activity) {
        ListfotosPerfil = listfotosPerfil;
        this.activity=activity;
    }
}
