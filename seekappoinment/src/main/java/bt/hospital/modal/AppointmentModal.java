package bt.hospital.modal;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.print.attribute.standard.DateTimeAtCreation;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "t_appoint_details_application")
public class AppointmentModal {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Id")
    private long id;	
	private int Date_Schedule_Id;
	private int Time_Slot_Id;
	private int Doctor_Id;
	private int Patient_Id;
	private int Disease_Id;
	private int Staus_Id;
	@CreationTimestamp
	private Timestamp Created_On;
	@CreationTimestamp
	private Timestamp Updated_On;
	private int	Updated_By;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getDate_Schedule_Id() {
		return Date_Schedule_Id;
	}
	public void setDate_Schedule_Id(int date_Schedule_Id) {
		Date_Schedule_Id = date_Schedule_Id;
	}
	public int getTime_Slot_Id() {
		return Time_Slot_Id;
	}
	public void setTime_Slot_Id(int time_Slot_Id) {
		Time_Slot_Id = time_Slot_Id;
	}
	public int getDoctor_Id() {
		return Doctor_Id;
	}
	public void setDoctor_Id(int doctor_Id) {
		Doctor_Id = doctor_Id;
	}
	public int getPatient_Id() {
		return Patient_Id;
	}
	public void setPatient_Id(int patient_Id) {
		Patient_Id = patient_Id;
	}
	public int getDisease_Id() {
		return Disease_Id;
	}
	public void setDisease_Id(int disease_Id) {
		Disease_Id = disease_Id;
	}
	public int getStaus_Id() {
		return Staus_Id;
	}
	public void setStaus_Id(int staus_Id) {
		Staus_Id = staus_Id;
	}
	public Timestamp getCreated_On() {
		return Created_On;
	}
	public void setCreated_On(Timestamp created_On) {
		Created_On = created_On;
	}
	public Timestamp getUpdated_On() {
		return Updated_On;
	}
	public void setUpdated_On(Timestamp updated_On) {
		Updated_On = updated_On;
	}
	public int getUpdated_By() {
		return Updated_By;
	}
	public void setUpdated_By(int updated_By) {
		Updated_By = updated_By;
	}
	
}
