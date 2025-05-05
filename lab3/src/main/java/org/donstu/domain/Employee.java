package org.donstu.domain;

import java.io.Serializable;

public class Employee implements Serializable {
    private String fullname;
    private Place place;

    public Employee(String fullname, Place place) {
        this.fullname = fullname;
        this.place = place;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
}
