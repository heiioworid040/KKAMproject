package com.project.dao;

import java.sql.Timestamp;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.project.domain.UserDTO;

@Repository
public class UserDAO {
	
	@Inject
	private SqlSession sqlSession;
	private static final String namespace="com.project.mappers.userMapper";
	
	public UserDTO userCheck(UserDTO userDTO) {
		return sqlSession.selectOne(namespace+".userCheck",userDTO);
	}

	public void insertUser(UserDTO userDTO) {
		sqlSession.insert(namespace+".insertUser", userDTO);
	}

}