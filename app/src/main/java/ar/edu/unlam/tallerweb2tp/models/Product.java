
package ar.edu.unlam.tallerweb2tp.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("id")
    private String id;
    @SerializedName("title")
    private String title;
    @SerializedName("descriptions")
    private List<Descripcion> descriptions;
    @SerializedName("pictures")
    private List<Picture> pictures;
    @SerializedName("price")
    private String precio;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Descripcion> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<Descripcion> descriptions) {
        this.descriptions = descriptions;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    public String getPrecio(){
        return "$ " + precio;
    }

    public void setPrecio(String precio){
        this.precio = precio;
    }
}
