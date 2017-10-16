
package ar.edu.unlam.tallerweb2tp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchLocation {

    @SerializedName("neighborhood")
    @Expose
    private Neighborhood neighborhood;
    @SerializedName("city")
    @Expose
    private City_ city;
    @SerializedName("state")
    @Expose
    private State_ state;

    public Neighborhood getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(Neighborhood neighborhood) {
        this.neighborhood = neighborhood;
    }

    public City_ getCity() {
        return city;
    }

    public void setCity(City_ city) {
        this.city = city;
    }

    public State_ getState() {
        return state;
    }

    public void setState(State_ state) {
        this.state = state;
    }

}
