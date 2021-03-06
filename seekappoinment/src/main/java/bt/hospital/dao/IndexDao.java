package bt.hospital.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.stereotype.Repository;

import bt.hospital.apiDto.UserDto;
import bt.hospital.dto.DropDownDTO;
import bt.hospital.dto.StatusDto;
import bt.hospital.modal.AppointmentModal;
import bt.hospital.modal.DzongkahgModal;
import bt.hospital.modal.UserModal;

@Repository
@Transactional
public class IndexDao {
	@PersistenceContext
	private EntityManager entityManager;
	
	protected Session getCurrentSession() {
        return entityManager.unwrap(Session.class);
    }
	protected org.hibernate.query.Query sqlQuery(String query, Class dtoClazz) {
        return getCurrentSession().createSQLQuery(query).setResultTransformer(new AliasToBeanResultTransformer(dtoClazz));
    }
	protected org.hibernate.query.Query sqlQuery(String query) {
        return getCurrentSession().createSQLQuery(query);
    }
	
	@SuppressWarnings("unchecked")
	public List<DzongkahgModal>  getdzongkhag() {
		try {
			return entityManager.createQuery("from DzongkahgModal").getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Transactional
	public List<DropDownDTO> getdoctorhospital(String paramvalue,String paramtype){
		try {
			List<DropDownDTO> output = new ArrayList<>();
			String sql="";
			if(paramtype.equalsIgnoreCase("hospital")) {
				sql="SELECT h.Id AS headerId,h.hospitalName AS headerName FROM hospitaldetails h WHERE h.dzongkhagId="+paramvalue;
			}
			if(paramtype.equalsIgnoreCase("doctor")) {
				sql="SELECT h.Id AS headerId,h.Full_Name AS headerName FROM t_user_master h WHERE h.Hospital_Id="+paramvalue;
			}
			if(paramtype.equalsIgnoreCase("gewog")) {
				sql="SELECT h.id AS headerId,h.gewogname AS headerName FROM gewog h WHERE h.dzongkhagid="+paramvalue;
			}
			if(paramtype.equalsIgnoreCase("village")) {
				sql="SELECT h.Id AS headerId,h.villageName AS headerName FROM village h WHERE h.gewogId="+paramvalue;
			}
			if(paramtype.equalsIgnoreCase("disease")) {
				sql="SELECT h.Id AS headerId,h.Disease_Name AS headerName FROM t_disease_master h WHERE h.Status='Y'";
			}
			
			Query result_query = sqlQuery(sql,DropDownDTO.class);
			output=result_query.getResultList();
			return output;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}	
	public List<DropDownDTO> getdateslot(String paramval){
		try {
			List<DropDownDTO> output = new ArrayList<>();
			String sql="SELECT t.Id AS headerId,CONCAT(t.Date_Schedule, '(',t.Day,')')  AS headerName FROM t_date_schedule t WHERE t.Doctor_Id="+paramval;
			Query result_query = sqlQuery(sql,DropDownDTO.class);
			output=result_query.getResultList();
			return output;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public List<DropDownDTO> gettimeslot(String paramval){
		try {
			List<DropDownDTO> output = new ArrayList<>();
			String sql="SELECT t.Id AS headerId,t.Time_Schedule AS headerName FROM t_time_schedule t WHERE t.Date_Schedule_Id="+paramval;
			Query result_query = sqlQuery(sql,DropDownDTO.class);
			output=result_query.getResultList();
			return output;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public UserModal getuserdetails(String paramval){
		try {
			String sql = "select p from UserModal p where p.cid="+paramval;
			UserModal output = null;
			
			Query query = entityManager.createQuery(sql);
			
			output = (UserModal) query.getSingleResult();
			
			/*
			 * if ((result!=null)&&(!result.isEmpty())) { output = result.get(0); }
			 */
			
			return output;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public UserDto insertuserdetails(UserModal paramval){
		UserDto dto=new UserDto();
		try {
			entityManager.persist(paramval);
			dto.setStatus("success");
		} catch (Exception e) {
			e.printStackTrace();
			dto.setStatus("failed");
		}
		return dto;
	}
	public int getpatientId(String cid){
		int patId=0;
		try {
			String sql = "select p from UserModal p where p.cid="+cid;
			UserModal output = null;			
			Query query = entityManager.createQuery(sql);			
			output = (UserModal) query.getSingleResult();
			patId=(int) output.getId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return patId;
	}
	public UserDto insertappointmentdetails(AppointmentModal paramval){
		UserDto dto=new UserDto();
		try {
			entityManager.persist(paramval);
			dto.setStatus("success");
		} catch (Exception e) {
			e.printStackTrace();
			dto.setStatus("failed");
		}
		return dto;
	}
	public List<StatusDto> getsearchdetails(String paramval){
		List<StatusDto> dto = new ArrayList<>();
		try {
			String sql="SELECT u.Full_Name patientName, ud.Full_Name doctorname,d.Disease_Name,a.Created_On,s.Status_Name FROM t_appoint_details_application a JOIN t_user_master u ON u.Id=a.Patient_Id JOIN t_user_master ud ON ud.Id=a.Doctor_Id JOIN t_disease_master d ON d.Id=a.Disease_Id JOIN t_status_master s ON s.Id=a.Staus_Id";
			if(paramval.length()==11) {
				sql+=" WHERE u.CID="+paramval;
			}
			else{
				sql+=" WHERE u.Contact_Number="+paramval;
			}
			Query result_query = sqlQuery(sql,StatusDto.class);
			dto=result_query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	

}
