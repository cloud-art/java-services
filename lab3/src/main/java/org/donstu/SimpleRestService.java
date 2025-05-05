package org.donstu;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpServer;
import org.donstu.domain.Employee;
import org.donstu.domain.Place;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SimpleRestService {
    private static final int PORT = 8080;
    private static final int OK = 200;
    private static final int NOT_ALLOWED = 405;


    private static List<Employee> employers = new ArrayList<>();
    static {
        Place place = new Place(1, new ArrayList<>(), Boolean.TRUE);
        employers.add(new Employee("First", place));
        employers.add(new Employee("Second", place));
        employers.add(new Employee("Third", place));
    }

    public static void main(String[] args) {
        try {
            HttpServer httpServer = HttpServer.create(new InetSocketAddress(PORT), 0);
            httpServer.createContext("/employee/list", httpExchange -> {
                if ("GET".equals(httpExchange.getRequestMethod())) {
                    httpExchange.getResponseHeaders().set("Content-Type", "application/json");
                    httpExchange.sendResponseHeaders(OK, 0);
                    ObjectMapper mapper = new ObjectMapper();
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    mapper.writeValue(baos, employers);
                    byte[] body = baos.toByteArray();
                    OutputStream os = httpExchange.getResponseBody();
                    os.write(body);
                    os.close();
                } else {
                    httpExchange.sendResponseHeaders(NOT_ALLOWED, -1);
                }
            });
            httpServer.setExecutor(null);
            httpServer.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
