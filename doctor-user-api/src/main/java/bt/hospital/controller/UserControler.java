package bt.hospital.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bt.hospital.dao.UserDao;
import bt.hospital.dto.UserDto;


@Controller
@RequestMapping("/userController")
public class UserControler {
	@Autowired
	UserDao dao;
	@RequestMapping(value="/getuserdetails")
	@ResponseBody
	public UserDto gettimescheduledetails(String id) {
		UserDto user=null;
	    try {
	    	user =dao.getpatientdetails(id);
	    }
	    catch (Exception ex) {
	    	return null;
	    }
	    return user;
	}
}
