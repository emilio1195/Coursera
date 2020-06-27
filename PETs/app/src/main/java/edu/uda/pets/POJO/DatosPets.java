package edu.uda.pets.POJO;

import android.graphics.drawable.Drawable;

public class DatosPets {
    private String Nombre, Raza, CountLikes;
    private int foto, imgLike;
    private boolean State_like;

    public DatosPets(String nombre, String raza, String countLikes, int foto, boolean like,int imgLike ) {
        Nombre = nombre;
        Raza = raza;
        CountLikes = countLikes;
        this.foto = foto;
        this.State_like = like;
        this.imgLike = imgLike;
    }

    public int getImgLike() {
        return imgLike;
    }

    public void setImgLike(int imgLike) {
        this.imgLike = imgLike;
    }

    public boolean isLike() {
        return State_like;
    }

    public void setLike(boolean like) {
        this.State_like = like;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getRaza() {
        return Raza;
    }

    public void setRaza(String raza) {
        Raza = raza;
    }

    public String getCountLikes() {
        return CountLikes;
    }

    public void setCountLikes(String countLikes) {
        CountLikes = countLikes;
    }


}
