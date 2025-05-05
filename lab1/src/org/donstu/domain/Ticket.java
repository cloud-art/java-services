package org.donstu.domain;

import java.io.Serializable;

public class Ticket implements Serializable {
    private ContactReason contactReason;
    private Integer place;

    public ContactReason getContactReason() {
        return contactReason;
    }

    public void setContactReason(ContactReason contactReason) {
        this.contactReason = contactReason;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }
}
