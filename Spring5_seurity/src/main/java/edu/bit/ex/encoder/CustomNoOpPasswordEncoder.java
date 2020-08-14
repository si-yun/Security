package edu.bit.ex.encoder;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.log4j.Log4j;
@Log4j
public class CustomNoOpPasswordEncoder implements PasswordEncoder{
		// ��ȣȭ �� ������ ���� �׷����������..
	
	
	
	@Override
	public String encode(CharSequence rawPassword) {
		log.warn("before encode :" + rawPassword);
		
	//	�Ϲ����� bean������ �̷��� �������� (������ principal�� �������� �ʱ� ������)
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
