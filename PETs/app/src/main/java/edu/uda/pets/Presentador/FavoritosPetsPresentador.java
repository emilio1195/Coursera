package edu.uda.pets.Presentador;

import android.content.Context;

import java.lang.reflect.Array;
import java.util.ArrayList;

import edu.uda.pets.BD.ConstructorFavoritos;
import edu.uda.pets.POJO.DatosPets;
import edu.uda.pets.vista.favoritos.InterfazFavoritosVista;

public class FavoritosPetsPresentador implements InterfazFavoritosPresentador {

    private InterfazFavoritosVista interfazFavoritosVista;
    private Context context;
    private ConstructorFavoritos constructorFavoritos;
    private ArrayList<DatosPets> datosPets;

    public FavoritosPetsPresentador(InterfazFavoritosVista interfazFavoritosVista, Context context) {
        this.interfazFavoritosVista = interfazFavoritosVista;
        this.context = context;
        obtenerPetsFavoritos();
    }

    @Override
    public void obtenerPetsFavoritos() {
        constructorFavoritos = new ConstructorFavoritos(context);
        datosPets = constructorFavoritos.ObtenerPetFavorito();
        mostrarPetsfavoritos();
    }

    @Override
    public void mostrarPetsfavoritos() {
        interfazFavoritosVista.InitAdaptadorfav(interfazFavoritosVista.crearAdaptador(datosPets));
        interfazFavoritosVista.generarLayoutRCV();
    }
}
