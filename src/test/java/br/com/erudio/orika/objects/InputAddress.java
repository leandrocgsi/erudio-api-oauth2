package br.com.erudio.orika.objects;

import java.io.Serializable;

public class InputAddress implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String road;
    private Integer number;
    private String town;

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }    
}