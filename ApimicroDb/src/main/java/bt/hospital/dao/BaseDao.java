package bt.hospital.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.stereotype.Repository;

import bt.hospital.dto.CommonDto;

@Repository
public class BaseDao {
	@PersistenceContext
	private EntityManager entityManager;
	protected Session getCurrentSession() {
        return entityManager.unwrap(Session.class);
    }
	protected org.hibernate.query.Query sqlQuery(String query, Class dtoClazz) {
        return getCurrentSession().createSQLQuery(query).setResultTransformer(new AliasToBeanResultTransformer(dtoClazz));
    }
	
	@SuppressWarnings("unchecked")
	public List<CommonDto>  gettimescheduledetails(String paramval) {
		try {
			List<CommonDto> output = new ArrayList<>();
			String sql="SELECT t.Id AS headerId,t.scheduleDate  AS headerName FROM schedule_master t WHERE t.doctorId="+paramval;
			Query result_query = sqlQuery(sql,CommonDto.class);
			output=result_query.getResultList();
			return output;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@SuppressWarnings("unchecked")
	public List<CommonDto>  gettimeslotdetails(String paramval) {
		try {
			List<CommonDto> output = new ArrayList<>();
			String sql="SELECT t.`Id` AS headerId,CONCAT(t.`availableFrom`,'-',t.`availableTo`) AS headerName FROM `schedule_detail` t WHERE t.`scheduleDetailId`="+paramval;
			Query result_query = sqlQuery(sql,CommonDto.class);
			output=result_query.getResultList();
			return output;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
