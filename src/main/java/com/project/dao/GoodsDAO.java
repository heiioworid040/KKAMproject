package com.project.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.project.domain.BagDTO;
import com.project.domain.GoodsDTO;

@Repository
public class GoodsDAO {
	
	@Inject
	private SqlSession sqlSession;
	private static final String namespace="com.project.mappers.goodsMapper";
	
	public List<GoodsDTO> goodsList(GoodsDTO goodsDTO) {
		return sqlSession.selectList(namespace+".goodsList", goodsDTO);
	}
	
	public List<BagDTO> cartList(BagDTO bagDTO) {
		return sqlSession.selectList(namespace+".cartList", bagDTO);
	}
	
	public void cartAdd(BagDTO bagDTO) {
		sqlSession.insert(namespace+".cartAdd", bagDTO);
	}
	
	public void cartUpdate(BagDTO bagDTO) {
		sqlSession.update(namespace+".cartUpdate", bagDTO);
	}
	
	public void goodsWrite(GoodsDTO goodsDTO) {
		sqlSession.insert(namespace+".goodsWrite", goodsDTO);
	}

	public Integer maxB_num() {
		return sqlSession.selectOne(namespace+".maxB_num");
	}
	
	public Integer maxB_count(BagDTO bagDTO) {
		return sqlSession.selectOne(namespace+".maxB_count", bagDTO);
	}
	
	public String getG_code(BagDTO bagDTO) {
		return sqlSession.selectOne(namespace+".getG_code", bagDTO);
	}

}
