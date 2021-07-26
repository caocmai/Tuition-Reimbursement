package dev.mai.models;

public class JsonMoreInfo {
	
	private String requestId;
	private String fromId;
	private String toId;
	private String reason;
	
	public JsonMoreInfo() {
		super();
	}

	public JsonMoreInfo(String requestId, String fromId, String toId, String reason) {
		super();
		this.requestId = requestId;
		this.fromId = fromId;
		this.toId = toId;
		this.reason = reason;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getFromId() {
		return fromId;
	}

	public void setFromId(String fromId) {
		this.fromId = fromId;
	}

	public String getToId() {
		return toId;
	}

	public void setToId(String toId) {
		this.toId = toId;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "JsonMoreInfo [requestId=" + requestId + ", fromId=" + fromId + ", toId=" + toId + ", reason=" + reason
				+ "]";
	}
	
	
	
	
	
	
	

}
