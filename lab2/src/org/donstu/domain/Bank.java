package org.donstu.domain;

import java.io.Serializable;
import java.util.List;

public class Bank implements Serializable {
    private List<ContactReason> contactReasons;
    private List<Employee> employers;
    private List<Place> places;
    private List<Ticket> tickets;

    public List<ContactReason> getContactReasons() {
        return contactReasons;
    }

    public void setContactReasons(List<ContactReason> contactReasons) {
        this.contactReasons = contactReasons;
    }

    public List<Employee> getEmployers() {
        return employers;
    }

    public void setEmployers(List<Employee> employers) {
        this.employers = employers;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
