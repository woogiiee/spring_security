package edu.bit.ex.service;

import javax.inject.Inject;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.bit.ex.vo.UserVO;
import edu.bit.mapper.UserMapper;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@NoArgsConstructor
@Service
public class UserService {
	
	@Inject
	private BCryptPasswordEncoder passEncoder;
	
	@Inject
	private UserMapper userMapper;
	
	public void addUser(UserVO userVO) {
		
		String password = userVO.getPassword();
	      String encode = passEncoder.encode(password);
	      
	      userVO.setPassword(encode);
	      
	      userMapper.insertUser(userVO);
	      userMapper.insertAuthorities(userVO);
	   }
	}
	

