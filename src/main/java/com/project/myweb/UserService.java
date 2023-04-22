package com.project.myweb;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.project.domain.UserDTO;

@Repository
public class UserService {
	
	@Inject
	private UserDAO userDAO;
	
	public UserDTO userCheck(UserDTO userDTO) {
		return userDAO.userCheck(userDTO);
	}
	
}