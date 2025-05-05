package org.donstu.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import static javax.jws.soap.SOAPBinding.ParameterStyle.WRAPPED;
import static javax.jws.soap.SOAPBinding.Style.DOCUMENT;
import static javax.jws.soap.SOAPBinding.Use.LITERAL;

import org.donstu.domain.ContactReason;
import org.donstu.domain.Employee;
import org.donstu.domain.Place;

@WebService(serviceName = "BankService", portName = "BankPort",
        targetNamespace = "https://donstu.org/bank")
@SOAPBinding(style = DOCUMENT, use = LITERAL, parameterStyle = WRAPPED)
public class BankService {

    @WebMethod(operationName = "getAvailableEmployers")
    public List<Employee> getAvailableEmployers() {
        // Логика обработки
        List<ContactReason> contactReasons = new ArrayList<>();
        List<Place> places = new ArrayList<>();
        List<Employee> availableEmployers = new ArrayList<>();

        contactReasons.add(new ContactReason("Оплата услуг", Boolean.TRUE));
        places.add(new Place(1, contactReasons, Boolean.TRUE));
        places.add(new Place(2, contactReasons, Boolean.TRUE));

        availableEmployers.add(new Employee("Василий Васильев Васильевич", places.get(0)));
        availableEmployers.add(new Employee("Артём Артёмов Артёмович", places.get(1)));

        return availableEmployers;
    }
}