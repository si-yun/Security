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
	//void적는 이유 /admin/adminHome 이 경로 따라가서  .jsp실행해줌.
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
		log.info("수업 존나빠르네 ");
		
		String user_id;
		
		//1.SpringContextHolder를 통하여 가져오는 방법 (일반적인빈에서 사용할수있음)
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		user_id = auth.getName();
		UserDetails userDetails = (UserDetails)auth.getPrincipal();
		//SpringContextHolder 안에 Authentication 안에 Principal 안에 UserDetails 안에 User .
		
		System.out.println("유저아이디:"+userDetails.getUsername());
		//2.controller를 통해서 principal객체로 가져오는방법 
//		UserDetails userDetail = (UserDetails) principal;
//		System.out.println(userDetail.getUsername());
		//3.user클래스로 변환 하여 가져오는 방법 
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println(user.getUsername());
		
		
		//db에서 가져오는 5개의 객채 외우기 .
		
		
		return "login/3list";
	}
}
