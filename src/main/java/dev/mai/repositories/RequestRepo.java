package dev.mai.repositories;

import java.util.List;

import dev.mai.models.Employee;
import dev.mai.models.Request;

public interface RequestRepo {
	
	public Request addRequest(Request r);
	public Request getRequest(int id);
	public List<Request> getAllRequest();
	public Request updateRequest(Request changeR);
	public Request deleteRequest(int id);

	public List<Request> getPendingRequests(Employee e);

}
