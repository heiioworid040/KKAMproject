package com.project.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.project.domain.BasketDTO;
import com.project.domain.GoodsDTO;

@Repository
public class GoodsDAO {
	
	@Inject
	private SqlSession sqlSession;
	private static final String namespace="com.project.mappers.goodsMapper";
	
	public List<GoodsDTO> goodsList(GoodsDTO goodsDTO) {
		return sqlSession.selectList(namespace+".goodsList", goodsDTO);
	}
	
	public List<GoodsDTO> goodsList(String G_code) {
		return sqlSession.selectList(namespace+".goodsDetail", G_code);
	}
	
	public List<BasketDTO> basketList(String id) {
		return sqlSession.selectList(namespace+".basketList", id);
	}
	
	public void basketAdd(BasketDTO bagDTO) {
		sqlSession.insert(namespace+".basketAdd", bagDTO);
	}
	
	public void basketUpdate(BasketDTO bagDTO) {
		sqlSession.update(namespace+".basketUpdate", bagDTO);
	}

	public Integer basketAllPrice(String id) {
		return sqlSession.selectOne(namespace+".basketAllPrice", id);
	}
	
	public void goodsWrite(GoodsDTO goodsDTO) {
		sqlSession.insert(namespace+".goodsWrite", goodsDTO);
	}

	public Integer maxB_num() {
		return sqlSession.selectOne(namespace+".maxB_num");
	}
	
	public Integer maxB_count(BasketDTO bagDTO) {
		return sqlSession.selectOne(namespace+".maxB_count", bagDTO);
	}
	
	public String getG_code(BasketDTO bagDTO) {
		return sqlSession.selectOne(namespace+".getG_code", bagDTO);
	}

}
