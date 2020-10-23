package bt.hospital.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bt.hospital.dao.IndexDao;
import bt.hospital.dto.DropDownDTO;
import bt.hospital.modal.DzongkahgModal;
import bt.hospital.modal.UserModal;

@Service
public class IndexService {
	@Autowired
	IndexDao dao;
	public List<DzongkahgModal> getDzongkhag() {
        try {
            return dao.getdzongkhag();
        } catch (Exception e) {
        	e.printStackTrace();
            return null;
        }
    }
	public List<DropDownDTO> getdoctorhospital(String paramval,String paramtype){
		return dao.getdoctorhospital(paramval,paramtype);
	}
	
	public List<DropDownDTO> getdateslot(String paramval){
		return dao.getdateslot(paramval);
	}
	
	public List<DropDownDTO> gettimeslot(String paramval){
		return dao.gettimeslot(paramval);
	}
	public UserModal getuserdetails(String paramval){
		return dao.getuserdetails(paramval);
	}
	
	

}
