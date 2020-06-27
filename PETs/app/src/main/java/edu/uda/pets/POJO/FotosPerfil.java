package edu.uda.pets.POJO;

public class FotosPerfil {
    private int foto;
    private String rating;

    public FotosPerfil(int foto, String rating) {
        this.foto = foto;
        this.rating = rating;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
