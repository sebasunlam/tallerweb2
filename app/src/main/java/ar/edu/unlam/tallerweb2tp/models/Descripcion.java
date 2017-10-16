package ar.edu.unlam.tallerweb2tp.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by spardo on 16/10/17.
 */

public class Descripcion {
    @SerializedName("plain_text")
    private String plainText;

    public String getPlainText() {
        return plainText;
    }

    public void setPlainText(String plainText) {
        this.plainText = plainText;
    }
}
