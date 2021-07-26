package dev.mai.models;

public class GetJsonId {
	
	private String id;
	private String amount;
	private String reason;
	

	public GetJsonId() {
		super();
	}

	public GetJsonId(String id) {
		super();
		this.id = id;
	}
	
	public GetJsonId(String id, String amount, String reason) {
		super();
		this.id = id;
		this.amount = amount;
		this.reason = reason;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "GetJsonId [id=" + id + ", amount=" + amount + ", reason=" + reason + "]";
	}
	
	
	
	

}
