package bt.hospital.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import bt.hospital.apiDto.CommonDto;
import bt.hospital.dto.DropDownDTO;
import bt.hospital.apiDto.UserDto;
import bt.hospital.modal.AppointmentModal;
import bt.hospital.modal.DzongkahgModal;
import bt.hospital.modal.UserModal;
import bt.hospital.services.IndexService;

@Controller
public class IndexController {
	private static final int CommonDto = 0;
	@Autowired
	IndexService service;
	@Autowired
	private Environment env;
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@RequestMapping("/")
    public String index(Model model) {
		List<DzongkahgModal> dzongkhag = service.getDzongkhag();
		model.addAttribute("dzongkhaglist", dzongkhag);
        return "pages/index";
    }
	
	@RequestMapping("/gethosptaldoctor")
	protected void gethosptaldoctor(HttpServletRequest request, HttpServletResponse response){
		try {
			response.setContentType("application/json;charset=utf-8");
			PrintWriter out = response.getWriter();
			String paramvalue = request.getParameter("paramvalue");
			String paramtype = request.getParameter("paramtype");
			out.println(populateDropDown(paramvalue,paramtype));
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public String populateDropDown(String paramvalue, String paramtype){
		String jsonText = "";
		Gson gson = new Gson();
		List<DropDownDTO> dropDownList = new ArrayList<DropDownDTO>();
		try {
			dropDownList = service.getdoctorhospital(paramvalue,paramtype);
			jsonText = gson.toJson(dropDownList);
			jsonText = new String(jsonText.getBytes("UTF-8"), "UTF-8");
			return jsonText;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@RequestMapping("/displayappointmentPage")
    public String displayappointmentPage(HttpServletRequest request, Model model) {
		String docId=request.getParameter("doctor");
		String ptientId=request.getParameter("cid");
		
		RestTemplate restTemplate = new RestTemplate();
		String directory = env.getProperty("baseEndPoint");
		String endpointUrl = directory+"gettimescheduledetails?id="+docId;
		ResponseEntity<CommonDto[]> responseEntity = restTemplate.getForEntity(endpointUrl, CommonDto[].class);
		List<CommonDto> object = Arrays.asList(responseEntity.getBody());
		model.addAttribute("timeSlot", object);
		
		String userUrl = env.getProperty("baseEndPointForuser");
		String endpointUrluser = userUrl+"getuserdetails?id="+ptientId;
		ResponseEntity<UserDto> userenety = restTemplate.getForEntity(endpointUrluser, UserDto.class);
		UserDto userobj = userenety.getBody();
		model.addAttribute("patientdetails", userobj);
		List<DzongkahgModal> dzongkhag = service.getDzongkhag();
		model.addAttribute("dzongkhaglist", dzongkhag);
		List<DropDownDTO> disease = service.getdoctorhospital(null,"disease");
		model.addAttribute("diseaselist", disease);
		model.addAttribute("cid", ptientId);
		model.addAttribute("docId", docId);
		
        return "pages/appointmentPage";
    }
	
	@RequestMapping("/gettimeschedule")
	protected void gettimeschedule(HttpServletRequest request, HttpServletResponse response){
		String jsonText = "";
		Gson gson = new Gson();
		try {
			response.setContentType("application/json;charset=utf-8");
			PrintWriter out = response.getWriter();
			String paramvalue = request.getParameter("paramvalue");
			RestTemplate restTemplate = new RestTemplate();
			String directory = env.getProperty("baseEndPoint");
			String endpointUrl = directory+"gettimeslotdetails?id="+paramvalue;
			ResponseEntity<CommonDto[]> responseEntity = restTemplate.getForEntity(endpointUrl, CommonDto[].class);
			List<CommonDto> object = Arrays.asList(responseEntity.getBody());
			jsonText = gson.toJson(object);
			jsonText = new String(jsonText.getBytes("UTF-8"), "UTF-8");
			out.println(jsonText);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	@RequestMapping("/submitform")
	public String submitform(HttpServletRequest request, Model model) {
		String docId=request.getParameter("doctor");
		if(request.getParameter("type").equalsIgnoreCase("newdata")) {
			UserModal userdto=new UserModal();
			userdto.setCid(request.getParameter("cid"));
			userdto.setFullName(request.getParameter("fullName"));
			userdto.setGendar(request.getParameter("gender"));
			userdto.setEmail(request.getParameter("email"));
			userdto.setContact(request.getParameter("phonenumber"));
			userdto.setVillageId(request.getParameter("village"));
			userdto.setRoleId("2");
			service.insertuserdetails(userdto);
		}
		int patientId=service.getpatientId(request.getParameter("cid"));
		AppointmentModal app=new AppointmentModal();
		app.setDoctor_Id(Integer.parseInt(request.getParameter("docId")));
		app.setDisease_Id(Integer.parseInt(request.getParameter("disease")));
		app.setDate_Schedule_Id(Integer.parseInt(request.getParameter("dateschedule")));
		app.setTime_Slot_Id(Integer.parseInt(request.getParameter("timeslot")));
		app.setPatient_Id(patientId);
		UserDto dto =service.insertappointmentdetails(app);
		String message="";
		if(dto.getStatus().equalsIgnoreCase("success")) {
			message="Your Appointment Details is submitted. You may track your application status from tract application"; 
		}
		else {
			message="Not able to create your application. Please try again";
		}
		model.addAttribute("message", message);
		return "pages/acknowledgement";
	}

}
