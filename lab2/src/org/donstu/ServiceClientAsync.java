package org.donstu;


import org.donstu.async.BankService;
import org.donstu.async.BankService_Service;
import org.donstu.async.Employee;
import org.donstu.async.GetAvailableEmployersResponse;


import javax.xml.namespace.QName;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ServiceClientAsync {
    private static final QName FQDN = new QName("https://donstu.org/bank", "BankService");

    private static URL getWsdlUrl(String urlStr) {
        try {
            return new URL(urlStr);
        } catch (MalformedURLException e) {
            throw new RuntimeException();
        }
    }

    public void processFreeEmployees(URL url) {
        Response<GetAvailableEmployersResponse> response = null;
        try {
            BankService_Service svc = new BankService_Service(url, FQDN);
            BankService port = svc.getBankPort();
            response = port.getAvailableEmployersAsync();
            while (!response.isDone()) {
                try {
                    System.out.println("Ждём ответа...");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (Exception e) {
            System.err.println("Ошибка при получении данных о зонах:");
            e.printStackTrace();
        }
        try {
            List<Employee> freeEmployers = response.get().getReturn();
            freeEmployers.forEach(employee -> System.out.println("Employee{" +
                    "employee='" + employee.getFullname() + '\'' +
                    ", place=" + employee.getPlace().getNumber() +
                    '}'));
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }


    class FreeEmployersAsyncHandler implements AsyncHandler<GetAvailableEmployersResponse> {
       @Override
        public void handleResponse(Response<GetAvailableEmployersResponse> res) {
            System.out.println("Результат готов!");
            try {
                List<Employee> freeEmployers = res.get().getReturn();
                freeEmployers.forEach(employee -> System.out.println("Employee{" +
                        "employee='" + employee.getFullname() + '\'' +
                        ", place=" + employee.getPlace().getNumber() +
                        '}'));
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void processAvailableEmployeesCallback(URL url) {
        try {
            BankService_Service svc = new BankService_Service(url, FQDN);
            BankService port = svc.getBankPort();

            port.getAvailableEmployersAsync(new FreeEmployersAsyncHandler());

            System.out.println("Запрос отправлен, ожидаем callback...");
            // Даем время для получения ответа
            Thread.sleep(1000);

        } catch (Exception e) {
            System.err.println("Ошибка при обработке callback:");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            URL wsdlUrl = getWsdlUrl("http://127.0.0.1:8088/bank-service?wsdl");
            ServiceClientAsync client = new ServiceClientAsync();
            client.processFreeEmployees(wsdlUrl);
            client.processAvailableEmployeesCallback(wsdlUrl);
        } catch (Exception e) {
            System.err.println("Ошибка при запуске клиента:");
            e.printStackTrace();
        }
    }
}