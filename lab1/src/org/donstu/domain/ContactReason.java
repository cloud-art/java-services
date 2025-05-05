package org.donstu.domain;

import java.io.Serializable;

public class ContactReason implements Serializable {
    private String title;
    // Необоходимо для отключения некоторых услуг
    private Boolean available;

    public ContactReason(String title, Boolean available) {
        this.title = title;
        this.available = available;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
