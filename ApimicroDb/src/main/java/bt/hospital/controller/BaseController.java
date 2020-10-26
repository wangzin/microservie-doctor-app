package bt.hospital.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import bt.hospital.dao.BaseDao;
import bt.hospital.dto.CommonDto;

@RestController
@RequestMapping("/MicroBaseService")
public class BaseController {
	@Autowired
	BaseDao dao;
	@RequestMapping(value="/gettimescheduledetails")
	@ResponseBody
	public List<CommonDto> gettimescheduledetails(String id) {
		
		List<CommonDto> user =new ArrayList<CommonDto>();
	    try {
	    	user =dao.gettimescheduledetails(id);
	    }
	    catch (Exception ex) {
	    	return null;
	    }
	    return user;
	}
	@RequestMapping(value="/gettimeslotdetails")
	@ResponseBody
	public List<CommonDto> gettimeslotdetails(String id) {
		
		List<CommonDto> user =new ArrayList<CommonDto>();
	    try {
	    	System.out.println("int the time slot api");
	    	user =dao.gettimeslotdetails(id);
	    }
	    catch (Exception ex) {
	    	return null;
	    }
	    return user;
	}
	
}
