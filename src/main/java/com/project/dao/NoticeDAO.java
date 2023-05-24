package com.project.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.project.domain.NoticeDTO;
import com.project.domain.PageDTO;

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

	public List<NoticeDTO> getNoticeList(PageDTO pageDTO) {
		pageDTO.setStartRow(pageDTO.getStartRow()-1);
		return sqlSession.selectList(namespace+".getNoticeList", pageDTO);
	}

	public int getNoticeCount(PageDTO pageDTO) {
		return sqlSession.selectOne(namespace+".getNoticeCount", pageDTO);
	}

	public NoticeDTO getNotice(int n_num) {
		return sqlSession.selectOne(namespace+".getNotice", n_num);
	}


	
}
