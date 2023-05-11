package com.project.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.project.domain.NoticeDTO;

@Repository
public class NoticeDAO {
	
	@Inject
	private SqlSession sqlSession;
	private static final String namespace = "com.project.mappers.noticeMapper";
	
	public Integer getMaxNum() {
		return sqlSession.selectOne(namespace+".getMaxNum");
	}

	public void insertNotice(NoticeDTO noticeDTO) {
		sqlSession.insert(namespace + ".insertNotice", noticeDTO);
	}
	
}
