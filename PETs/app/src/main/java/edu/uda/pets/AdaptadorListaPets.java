package edu.uda.pets;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Stack;

//se realiza una extension de la misma clase con el objetivo de lograr el reciclaje
public class AdaptadorListaPets extends RecyclerView.Adapter<AdaptadorListaPets.PetsViewHolder> {
    private final Activity activity;
    ArrayList<DatosPets> ListaPets;

    public AdaptadorListaPets(ArrayList<DatosPets> listaPets, Activity activity) {
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

        datoPetViewHolder.StateLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int conteo;
                if (datosPets.isLike()){        ///condicional para evaluar si se da like o si se quita el like
                    datosPets.setLike(false);       //obj que contiene el estado del like
                    datosPets.setImgLike(R.drawable.unlike);    //guardamos la imagen de desmarcado en el obj
                    conteo = Integer.parseInt(datosPets.getCountLikes()) - 1;   // se resta un decimal al quitar el like
                }
                else {  //condicional cuando le da a me gusta
                    datosPets.setLike(true);
                    datosPets.setImgLike(R.drawable.like);
                    conteo = Integer.parseInt(datosPets.getCountLikes()) + 1;
                }
                datosPets.setCountLikes(String.valueOf(conteo)); //se guarda el conteo en el obj
                datoPetViewHolder.StateLike.setImageResource(datosPets.getImgLike());       ///se actualiza la ImagenLike con el estado actual
                datoPetViewHolder.contadorLikes.setText(datosPets.getCountLikes());         //Se actualiza el TextView contador al dar like o quitarlo

               // Toast.makeText(activity,"te Gusta: " + datosPets.getNombre() + ", N likes: " + datosPets.getCountLikes() + ", state Like:" + datosPets.isLike(),Toast.LENGTH_LONG).show();
            }
        });
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
