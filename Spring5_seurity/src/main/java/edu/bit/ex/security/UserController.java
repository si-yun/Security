package edu.bit.ex.security;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.bit.ex.service.UserService;
import edu.bit.ex.vo.UserVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */
@Controller
@Log4j
@AllArgsConstructor
public class UserController {
   
   private UserService userservice;
   
   
   @GetMapping(value = "/user/userForm")
   public void userForm() {
      log.info("Welcome userForm");
   }
   
   @PostMapping("/user/addUser")
   public String adduser(UserVO userVO) {
      log.info("post resister");
      
      userservice.addUser(userVO);
      return "redirect:/";
      
   }
   
  
   
   
   
   
}