package edu.uda.pets.vista.favoritos;

import java.util.ArrayList;

import edu.uda.pets.Adapter.AdaptadorFavoritos;
import edu.uda.pets.POJO.DatosPets;

public interface InterfazFavoritosVista {
    public void generarLayoutRCV();
    public AdaptadorFavoritos crearAdaptador(ArrayList<DatosPets> datosPet);
    public void InitAdaptadorfav (AdaptadorFavoritos adaptadorFavoritos);
}
