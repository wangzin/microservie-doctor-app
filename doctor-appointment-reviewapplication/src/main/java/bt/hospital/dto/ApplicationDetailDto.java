package bt.hospital.dto;

import java.sql.Timestamp;

public class ApplicationDetailDto {
	private String patientName;
	private String doctorname;
	private String Disease_Name;
	private Timestamp Created_On;
	private String Status_Name;
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getDoctorname() {
		return doctorname;
	}
	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}
	public String getDisease_Name() {
		return Disease_Name;
	}
	public void setDisease_Name(String disease_Name) {
		Disease_Name = disease_Name;
	}
	public Timestamp getCreated_On() {
		return Created_On;
	}
	public void setCreated_On(Timestamp created_On) {
		Created_On = created_On;
	}
	public String getStatus_Name() {
		return Status_Name;
	}
	public void setStatus_Name(String status_Name) {
		Status_Name = status_Name;
	}
	
	
}
