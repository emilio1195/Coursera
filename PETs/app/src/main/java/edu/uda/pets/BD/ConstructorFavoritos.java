package edu.uda.pets.BD;

import android.content.ContentValues;
import android.content.Context;
import android.widget.BaseAdapter;

import java.util.ArrayList;

import edu.uda.pets.POJO.DatosPets;

public class ConstructorFavoritos {

    private Context context;
    public ConstructorFavoritos(Context context) {
        this.context = context;
    }

    public void insertarFavorito(BaseDatosFavoritos dbF, DatosPets datosPets){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBD.NAME_MASCOTA,datosPets.getNombre());
        contentValues.put(ConstantesBD.RAZA_MASCOTA,datosPets.getRaza());
        contentValues.put(ConstantesBD.LIKES_MASCOTA,datosPets.getCountLikes());
        contentValues.put(ConstantesBD.FOTO_MASCOTA, datosPets.getFoto());
        dbF.insertarFavorito(contentValues);

    }
    public void BorrarFilaFavorito(BaseDatosFavoritos dbF, int code){
        dbF.borrarFila(code);
    }

    public ArrayList<DatosPets> ObtenerPetFavorito(){
        BaseDatosFavoritos dbFavoritos = new BaseDatosFavoritos(context);
        return dbFavoritos.obtenerFavoritos();
    }
}
