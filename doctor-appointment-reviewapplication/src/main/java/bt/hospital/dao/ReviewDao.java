package bt.hospital.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.stereotype.Repository;

import bt.hospital.dto.ApplicationDetailDto;


@Repository
public class ReviewDao {
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
	
	public List<ApplicationDetailDto> getapplicationforthisDoc(String paramval){
		List<ApplicationDetailDto> dto = new ArrayList<>();
		try {
			String sql="SELECT u.Full_Name patientName, ud.Full_Name doctorname,d.Disease_Name,a.Created_On,s.Status_Name FROM t_appoint_details_application a JOIN t_user_master u ON u.Id=a.Patient_Id JOIN t_user_master ud ON ud.Id=a.Doctor_Id JOIN t_disease_master d ON d.Id=a.Disease_Id JOIN t_status_master s ON s.Id=a.Staus_Id";
			if(paramval.length()==11) {
				sql+=" WHERE ud.Id="+paramval;
			}
			Query result_query = sqlQuery(sql,ApplicationDetailDto.class);
			dto=result_query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
}
