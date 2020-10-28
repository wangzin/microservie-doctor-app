package bt.hospital.dto;

import java.io.Serializable;

public class CommonDto implements Serializable{

	private static final long serialVersionUID = 1L;
	private int headerId;
	private String headerName;
	private String identifier;
	private String exception;
	
	public CommonDto() {}
	
	public int getHeaderId() {
		return headerId;
	}
	public void setHeaderId(int headerId) {
		this.headerId = headerId;
	}
	public String getHeaderName() {
		return headerName;
	}
	public void setHeaderName(String headerName) {
		this.headerName = headerName;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}
	

}
