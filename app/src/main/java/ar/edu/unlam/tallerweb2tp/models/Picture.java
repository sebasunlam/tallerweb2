package ar.edu.unlam.tallerweb2tp.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by spardo on 16/10/17.
 */

public class Picture {
    @SerializedName("id")
    private String id;
    @SerializedName("url")
    private String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
