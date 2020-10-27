package bt.hospital.modal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents an User for this web application.
 */
@Entity
@Table(name = "dzongkhag")
public class DzongkahgModal {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;	
	
	@Column(name="dzongkhagname")
    private String Dzongkhag_Name;
	@Column(name="enable")
    private String Status;
    
    public DzongkahgModal() { }
    
    public DzongkahgModal(String Dzongkhag_Name, String Status) {
		this.Dzongkhag_Name = Dzongkhag_Name;
		this.Status = Status;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDzongkhag_Name() {
		return Dzongkhag_Name;
	}
	public void setDzongkhag_Name(String dzongkhag_Name) {
		Dzongkhag_Name = dzongkhag_Name;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
    
    

}
