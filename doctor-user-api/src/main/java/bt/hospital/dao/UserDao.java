package bt.hospital.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.stereotype.Repository;

import bt.hospital.dto.UserDto;

@Repository
public class UserDao {
	@PersistenceContext
	private EntityManager entityManager;
	protected Session getCurrentSession() {
        return entityManager.unwrap(Session.class);
    }
	protected org.hibernate.query.Query sqlQuery(String query, Class dtoClazz) {
        return getCurrentSession().createSQLQuery(query).setResultTransformer(new AliasToBeanResultTransformer(dtoClazz));
    }
	@SuppressWarnings("unchecked")
	public UserDto  getpatientdetails(String paramval) {
		UserDto output=null;
		try {
			String sql="SELECT u.CID,u.Contact_Number,u.Full_Name,u.Gender,u.Username_Email,u.Village_Id,d.dzongkhagname,d.id dzongkhgaId,g.gewogname,g.id gewogId, v.villageName FROM t_user_master u JOIN village v ON v.Id=u.Village_Id JOIN gewog g ON g.id=v.gewogId JOIN dzongkhag d ON d.id=g.dzongkhagid WHERE u.CID="+paramval;
			Query result_query = sqlQuery(sql,UserDto.class);
			if(result_query!=null) {
				output=(UserDto) result_query.getSingleResult();
			}
			
			return output;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
