package bt.hospital.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bt.hospital.dao.ReviewDao;
import bt.hospital.dto.ApplicationDetailDto;

@Controller
public class ReviewController {
	@Autowired
	ReviewDao dao;
	@RequestMapping("/")
	public ModelAndView firstPage(HttpServletRequest request) {
		List<ApplicationDetailDto> dto=dao.getapplicationforthisDoc("2");
		request.setAttribute("patientList", dto);
		return new ModelAndView("patientList");
		
	}
}
