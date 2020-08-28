package edu.bit.ex.vo;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Getter
@Setter

public class CustomUser extends User {

	private EmpVO emp;

	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		// TODO Auto-generated constructor stub
	}

	public CustomUser(EmpVO empVO) {
		super(empVO.getEname(), Integer.toString(empVO.getEmpno()),
				Collections.singletonList(new SimpleGrantedAuthority(empVO.getAuthorities())));

		this.emp = empVO;
	}
}