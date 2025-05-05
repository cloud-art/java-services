package org.donstu;

import org.donstu.service.BankService;
import javax.xml.ws.Endpoint;

public class ServiceHost {
    public static void main(String[] args) {
        System.out.println("Starting Host Service...");
        Endpoint.publish("http://127.0.0.1:8088/bank-service", new BankService());
    }
}