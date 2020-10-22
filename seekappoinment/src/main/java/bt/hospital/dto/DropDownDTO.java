package bt.hospital.dto;

import java.io.Serializable;

public class DropDownDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private int headerId;
	private String headerName;
	private String identifier;
	
	public DropDownDTO() {}
	
	public DropDownDTO(Object[] input) {
		setHeaderId((int) input[0]);
		setHeaderName("");
		setIdentifier("");
		if(input[1] != null){
			setHeaderName((String) input[1]);
		}
		if(input[2] != null){
			setIdentifier((String) input[2]);
		}
	}
	
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

}
