
package ar.edu.unlam.tallerweb2tp.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Shipping {

    @SerializedName("mode")
    @Expose
    private String mode;
    @SerializedName("local_pick_up")
    @Expose
    private Boolean localPickUp;
    @SerializedName("free_shipping")
    @Expose
    private Boolean freeShipping;
    @SerializedName("methods")
    @Expose
    private List<Object> methods = null;
    @SerializedName("dimensions")
    @Expose
    private Object dimensions;
    @SerializedName("tags")
    @Expose
    private List<Object> tags = null;

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Boolean getLocalPickUp() {
        return localPickUp;
    }

    public void setLocalPickUp(Boolean localPickUp) {
        this.localPickUp = localPickUp;
    }

    public Boolean getFreeShipping() {
        return freeShipping;
    }

    public void setFreeShipping(Boolean freeShipping) {
        this.freeShipping = freeShipping;
    }

    public List<Object> getMethods() {
        return methods;
    }

    public void setMethods(List<Object> methods) {
        this.methods = methods;
    }

    public Object getDimensions() {
        return dimensions;
    }

    public void setDimensions(Object dimensions) {
        this.dimensions = dimensions;
    }

    public List<Object> getTags() {
        return tags;
    }

    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

}
