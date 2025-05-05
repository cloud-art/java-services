package org.donstu.controllers;

import org.donstu.domain.Employee;
import org.donstu.domain.Place;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/employee")
public class EmployeeController {
    private static List<Employee> employers = new ArrayList<>();
    static {
        Place place = new Place(1, new ArrayList<>(), Boolean.TRUE);
        employers.add(new Employee("First", place));
        employers.add(new Employee("Second", place));
        employers.add(new Employee("Third", place));
    }

    @GET
    @Path("/")
    @Produces({MediaType.APPLICATION_JSON})
    public Response defaultPath() {
        return getEmployers();
    }

    @GET
    @Path("/list")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getEmployers() {
        GenericEntity<List<Employee>> genericEntity = new GenericEntity<List<Employee>>(employers) {};
        return Response.ok(genericEntity).build();
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getEmployer(@PathParam("id") String id) {
        int num = Integer.parseInt(id);
        if (employers.size() <= num) {
            return Response.ok().build();
        } else {
            return Response.ok(employers.get(num)).build();
        }
    }
}
