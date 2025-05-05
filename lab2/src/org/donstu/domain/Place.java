package org.donstu.domain;

import java.io.Serializable;
import java.util.List;

public class Place implements Serializable {
    private Integer number;
    private List<ContactReason> contactReasons;
    private Boolean available;

    public Place(Integer number, List<ContactReason> contactReasons, Boolean available) {
        this.number = number;
        this.contactReasons = contactReasons;
        this.available = available;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public List<ContactReason> getContactReasons() {
        return contactReasons;
    }

    public void setContactReasons(List<ContactReason> contactReasons) {
        this.contactReasons = contactReasons;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setPlace(Boolean available) {
        this.available = available;
    }
}
