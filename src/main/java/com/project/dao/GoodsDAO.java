package com.project.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.project.domain.GoodsDTO;

@Repository
public class GoodsDAO {
	
	@Inject
	private SqlSession sqlSession;
	private static final String namespace="com.project.mappers.goodsMapper";
	
	public List<GoodsDTO> goodsList(GoodsDTO goodsDTO) {
		return sqlSession.selectList(namespace+".goodsList",goodsDTO);
	}
	
	public void goodsWrite(GoodsDTO goodsDTO) {
		sqlSession.selectOne(namespace+".goodsWrite",goodsDTO);
	}

}
