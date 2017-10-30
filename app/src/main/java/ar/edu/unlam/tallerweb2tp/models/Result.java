package ar.edu.unlam.tallerweb2tp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by spardo on 16/10/17.
 */

public class Result {

    @SerializedName("id")
    private String id;
    @SerializedName("title")
    private String titulo;
    @SerializedName("thumbnail")
    private String imgUrl;
    @SerializedName("price")
    private String precio;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
}
