package edu.bit.ex.encoder;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.log4j.Log4j;
@Log4j
public class CustomNoOpPasswordEncoder implements PasswordEncoder{
		// 암호화 안 했으니 날것 그래도집어넣음..
	
	
	
	@Override
	public String encode(CharSequence rawPassword) {
		log.warn("before encode :" + rawPassword);
		
	//	일반적인 bean에서는 이렇게 적용해줌 (이유는 principal을 제공하지 않기 때문에)
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		user_id = auth.getName();
//		UserDetails userDetails = (UserDetails)auth.getPrincipal();
		
		return rawPassword.toString();
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		log.warn("matches :" + rawPassword+":"+encodedPassword);
		
		return rawPassword.toString().equals(encodedPassword);
	}

}
