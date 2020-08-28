package edu.bit.ex.vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class EmpVO {
	int empno;    //NOT NULL NUMBER(4)    
	String ename; //             VARCHAR2(10) 
	String job;//               VARCHAR2(9)  
	int mgr;//               NUMBER(4)    
	Timestamp hiredate;//          DATE         
	int sal;//               NUMBER(7,2)  
	int comm;//              NUMBER(7,2)  
	int deptno;//            NUMBER(2)  
	
	public String getAuthorities() {
		String authorities = "ROLE_USER";
		
		if(getJob().trim().toUpperCase().equals("MANAGER"))
			authorities = "ROLE_ADMIN";
		
		return authorities;
	}
	
}