package bt.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import bt.hospital.apiDto.Repo;
import bt.hospital.apiDto.UserDto;

@Controller
public class IndexController {
	@Autowired
	Repo repo;
	
	@RequestMapping("/")
	  public String index() {
	    return "pages/index";
	  }
	
	
	@RequestMapping("/submitform")
	public String submitform(UserDto reg) {
		
		try {
			
			repo.save(reg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "pages/index" ;
		
		
	}
}
