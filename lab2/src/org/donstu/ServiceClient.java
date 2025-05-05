package org.donstu;

import org.donstu.client.BankService;
import org.donstu.client.BankService_Service;
import org.donstu.client.Employee;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class ServiceClient {
    private static final QName FQDN = new QName("https://donstu.org/bank", "BankService");

    private static URL getWsdlUrl(String urlStr) {
        URL url = null;
        try {
            url = new URL(urlStr);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return url;
    }

    public void processFreeEmployees(URL url) {
        BankService_Service svc = new BankService_Service(url, FQDN);
        BankService port = svc.getBankPort();
        List<Employee> freePlaces = port.getAvailableEmployers();
        freePlaces.forEach(employee -> System.out.println("Employee{" +
                "employee='" + employee.getFullname() + '\'' +
                ", place=" + employee.getPlace().getNumber() +
                '}'));
    }

    public static void main(String[] args) {
        URL wsdlUrl = getWsdlUrl("http://127.0.0.1:8088/bank-service?wsdl");
        ServiceClient client = new ServiceClient();
        client.processFreeEmployees(wsdlUrl);
    }
}
