package bt.hospital.apiDto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_user_master")
public class UserDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "CID")
	private String cid;
	
	@Column(name = "Username_Email")
	private String email;
	

	@Column(name = "Password")
	private String password;
	
	
	@Column(name = "Full_Name")
	private String fullName;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "Gender")
	private String gender;
	
	@Column(name = "Contact_Number")
	private String phonenumber;
	
	@Column(name = "Role_Id")
	private String Role;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	@Override
	public String toString() {
		return "UserDto [email=" + email + ", cid=" + cid + ", fullName=" + fullName + ", gender=" + gender
				+ ", phonenumber=" + phonenumber + ", Role=" + Role + "]";
	}

	
	

}

	
	

