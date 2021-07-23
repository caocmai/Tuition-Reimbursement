package dev.mai.repositories;

import java.util.List;

import dev.mai.models.MoreInfoRequest;

public interface MoreInfoRequestRepo {
	
	public MoreInfoRequest addMoreInfoRequest(MoreInfoRequest m);
	public MoreInfoRequest getMoreInfoRequest(int id);
	public List<MoreInfoRequest> getAllMoreInfoRequests();
	public MoreInfoRequest updateMoreInfoRequest(MoreInfoRequest changeM);
	public MoreInfoRequest deleteMoreInfoRequest(int id);

}
