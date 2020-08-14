package edu.bit.ex.security;

import java.security.Principal;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */
@Log4j
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	//void���� ���� /admin/adminHome �� ��� ���󰡼�  .jsp��������.
	@GetMapping("/admin/adminHome")
	public void adminHome() {
		log.info("adminHome..");
	}
	@GetMapping("/login/loginForm")
	public String loginform() {
		log.info("loginform");
		return "login/loginForm";
	}
	@GetMapping("/user/userHome")
	public void userHome() {
		log.info("userHome..");
	}
	@GetMapping("/login/accessDenied")
	public void accessDenied() {
		log.info("accessDenied..");
	}
	@GetMapping("/loginInfo")
	public String loginInfo(Principal principal) {
		log.info("���� ���������� ");
		
		String user_id;
		
		//1.SpringContextHolder�� ���Ͽ� �������� ��� (�Ϲ����κ󿡼� ����Ҽ�����)
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		user_id = auth.getName();
		UserDetails userDetails = (UserDetails)auth.getPrincipal();
		//SpringContextHolder �ȿ� Authentication �ȿ� Principal �ȿ� UserDetails �ȿ� User .
		
		System.out.println("�������̵�:"+userDetails.getUsername());
		//2.controller�� ���ؼ� principal��ü�� �������¹�� 
//		UserDetails userDetail = (UserDetails) principal;
//		System.out.println(userDetail.getUsername());
		//3.userŬ������ ��ȯ �Ͽ� �������� ��� 
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println(user.getUsername());
		
		
		//db���� �������� 5���� ��ä �ܿ�� .
		
		
		return "login/3list";
	}
}
