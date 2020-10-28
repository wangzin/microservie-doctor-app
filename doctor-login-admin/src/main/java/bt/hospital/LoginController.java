package bt.hospital;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	@GetMapping("/")
	public ModelAndView loginPage(){
		System.out.println("inside the welcome controller");
		return new ModelAndView("login");
	}
	@GetMapping("/dashboard")
	public  ModelAndView getUser()
	{
		System.out.println("inside the dashbood controller");
		return new ModelAndView("dashboard");
	}
//	@GetMapping("/admin")
//	public  ModelAndView getAdmin()
//	{
//		System.out.println("inside the welcome controller");
//		return new ModelAndView("Admindashboard");
//	}
//	@GetMapping("/doctor")
//	public  ModelAndView getDoctor()
//	{
//		System.out.println("inside the welcome controller");
//		return new ModelAndView("Doctordashboard");
//	}

}
