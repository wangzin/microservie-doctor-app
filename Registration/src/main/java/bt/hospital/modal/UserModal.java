package bt.hospital.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "t_user_master")
public class UserModal {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Id")
    private long id;	
	@Column(name="CID")
    private String cid;
	@Column(name="Full_Name")
    private String fullName;
	@Column(name="Gender")
    private String gendar;
	@Column(name="Village_Id")
    private String villageId;
	@Column(name="Hospital_Id")
    private String hospitalId;
	@Column(name="Contact_Number")
    private String contact;
	@Column(name="Email_Id")
    private String email;
	@Column(name="Role_Id")
    private String roleId;
	
	public UserModal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserModal(long id, String cid, String fullName, String gendar, String villageId, String hospitalId, String contact,
			String email, String roleId) {
		super();
		this.id = id;
		this.cid = cid;
		this.fullName = fullName;
		this.gendar = gendar;
		this.villageId = villageId;
		this.hospitalId = hospitalId;
		this.contact = contact;
		this.email = email;
		this.roleId = roleId;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getGendar() {
		return gendar;
	}
	public void setGendar(String gendar) {
		this.gendar = gendar;
	}
	public String getVillageId() {
		return villageId;
	}
	public void setVillageId(String villageId) {
		this.villageId = villageId;
	}
	public String getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	
	
	
	
	

}
