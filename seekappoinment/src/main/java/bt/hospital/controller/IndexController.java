package bt.hospital.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

import bt.hospital.dto.DropDownDTO;
import bt.hospital.modal.DzongkahgModal;
import bt.hospital.modal.UserModal;
import bt.hospital.services.IndexService;

@Controller
public class IndexController {
	@Autowired
	IndexService service;
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
		List<DropDownDTO> dropDownList = new ArrayList<DropDownDTO>();	
		dropDownList = service.gettimeslot(docId);
		UserModal user=service.getuserdetails(ptientId);
		model.addAttribute("timeSlot", dropDownList);
		model.addAttribute("userDetails", user);
        return "pages/appointmentPage";
    }

}
