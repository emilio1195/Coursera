package edu.uda.pets.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import edu.uda.pets.POJO.DatosPets;
import edu.uda.pets.R;

//se realiza una extension de la misma clase con el objetivo de lograr el reciclaje
public class AdaptadorFavoritos extends RecyclerView.Adapter<AdaptadorFavoritos.PetsViewHolder> {
    private final Activity activity;
    ArrayList<DatosPets> ListaPets;

    public AdaptadorFavoritos(ArrayList<DatosPets> listaPets, Activity activity) {
        ListaPets = listaPets;
        this.activity = activity;
    }

    @Override
    public PetsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Se encargara de crear la Vista y retornarla
        //Se utilizara el Inflate, el cual se encarga de construir el layout, es decir ir inflando nuestras vistas
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_pet,parent,false);
        return new PetsViewHolder(vista); //se retorna este objeto con el fin de poder colocar el parametro y usar las vistas.
    }
    public int posicion;
    @Override
    public void onBindViewHolder(@NonNull final PetsViewHolder datoPetViewHolder, int position) {
        posicion = position;
        // Asocia las lista de datos con cada view y en nuestro ViewHolder
        final DatosPets datosPets = ListaPets.get(position); //guardamos la posicion de la lista en el obj tipo DatosPets
        //en el ViewHolder tenemos inicializada las vistas por lo cual, seteamos sus valores en este metodo, obteniendo del listado datos
        datoPetViewHolder.fotoPet.setImageResource(datosPets.getFoto());
        datoPetViewHolder.nombrePet.setText(datosPets.getNombre());
        datoPetViewHolder.raza.setText(datosPets.getRaza());
        datoPetViewHolder.contadorLikes.setText(datosPets.getCountLikes());
        datoPetViewHolder.StateLike.setImageResource(datosPets.getImgLike());
        // Toast.makeText(activity,"te Gusta: " + datosPets.getNombre() + ", N likes: " + datosPets.getCountLikes() + ", state Like:" + datosPets.isLike(),Toast.LENGTH_LONG).show();
    }

    @Override
    public int getItemCount() {
        //nos entrega la cantida de item de nuestra lista que se manejaran
        return ListaPets.size();
    }

    public static class PetsViewHolder extends RecyclerView.ViewHolder{

        TextView nombrePet, raza, contadorLikes;
        ImageView fotoPet, StateLike;

        public PetsViewHolder(@NonNull View itemView) {
            super(itemView);
            nombrePet =(TextView) itemView.findViewById(R.id.nombre);
            raza =(TextView) itemView.findViewById(R.id.raza);
            contadorLikes =(TextView) itemView.findViewById(R.id.contadorLikes);
            fotoPet =(ImageView) itemView.findViewById(R.id.foto);
            StateLike = (ImageView) itemView.findViewById(R.id.like);
        }
    }
}
