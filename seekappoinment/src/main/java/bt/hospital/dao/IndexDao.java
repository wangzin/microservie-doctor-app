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

import bt.hospital.dto.DropDownDTO;
import bt.hospital.modal.DzongkahgModal;
import bt.hospital.modal.UserModal;
import netgloo.models.User;

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
			String sql="SELECT t.Id AS headerId, t.Date_Schedule AS headerName,t.Day identifier FROM t_date_schedule t WHERE t.Doctor_Id="+paramval;
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
			return (UserModal) entityManager.createQuery(
			        "from UserModal where cid = :cid")
			        .setParameter("cid", paramval)
			        .getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
