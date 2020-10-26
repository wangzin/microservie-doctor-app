package bt.hospital.dto;

public class UserDto {
	private String CID;
	private String Contact_Number;
	private String Full_Name;
	private String Gender;
	private String Username_Email;
	private String Village_Id;
	private String dzongkhagname;
	private int dzongkhgaId;
	private String gewogname;
	private int gewogId;  
	private String villageName;
	public String getCID() {
		return CID;
	}
	public void setCID(String cID) {
		CID = cID;
	}
	public String getContact_Number() {
		return Contact_Number;
	}
	public void setContact_Number(String contact_Number) {
		Contact_Number = contact_Number;
	}
	public String getFull_Name() {
		return Full_Name;
	}
	public void setFull_Name(String full_Name) {
		Full_Name = full_Name;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getUsername_Email() {
		return Username_Email;
	}
	public void setUsername_Email(String username_Email) {
		Username_Email = username_Email;
	}
	public String getVillage_Id() {
		return Village_Id;
	}
	public void setVillage_Id(String village_Id) {
		Village_Id = village_Id;
	}
	public String getDzongkhagname() {
		return dzongkhagname;
	}
	public void setDzongkhagname(String dzongkhagname) {
		this.dzongkhagname = dzongkhagname;
	}
	public int getDzongkhgaId() {
		return dzongkhgaId;
	}
	public void setDzongkhgaId(int dzongkhgaId) {
		this.dzongkhgaId = dzongkhgaId;
	}
	public String getGewogname() {
		return gewogname;
	}
	public void setGewogname(String gewogname) {
		this.gewogname = gewogname;
	}
	public int getGewogId() {
		return gewogId;
	}
	public void setGewogId(int gewogId) {
		this.gewogId = gewogId;
	}
	public String getVillageName() {
		return villageName;
	}
	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}
	
}
