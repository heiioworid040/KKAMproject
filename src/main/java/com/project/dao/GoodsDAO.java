package com.project.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.project.domain.BasketDTO;
import com.project.domain.BasketDTO.BasketQuery;
import com.project.domain.GoodsDTO;
import com.project.domain.LikeDTO;
import com.project.domain.OrderDTO;

@Repository
public class GoodsDAO {
	
	@Inject
	private SqlSession sqlSession;
	private static final String namespace="com.project.mappers.goodsMapper";
//	중복 메서드 정리, 메서드 구분 예정
	public List<GoodsDTO> goodsList(GoodsDTO goodsDTO) {
		return sqlSession.selectList(namespace+".goodsList", goodsDTO);
	}
	
	public List<GoodsDTO> goodsList(String G_code) {
		return sqlSession.selectList(namespace+".goodsDetail", G_code);
	}
	
	public GoodsDTO goods(String G_code) {
		return sqlSession.selectOne(namespace+".goodsDetail", G_code);
	}
	
	public List<BasketDTO> basketList(String id) {
		return sqlSession.selectList(namespace+".basketList", id);
	}
	
	public List<BasketDTO> basketList(String id, List<String> ck) {
		BasketQuery query = new BasketQuery(id, ck);
		return sqlSession.selectList(namespace+".basketCkList", query);
	}
	
	public void basketAdd(BasketDTO basketDTO) {
		sqlSession.insert(namespace+".basketAdd", basketDTO);
	}
	
	public void basketUpdate(BasketDTO basketDTO) {
		sqlSession.update(namespace+".basketUpdate", basketDTO);
	}

	public Integer basketAllPrice(String id) {
		return sqlSession.selectOne(namespace+".basketAllPrice", id);
	}
	
	public Integer basketAllCount(String id) {
		return sqlSession.selectOne(namespace+".basketAllCount", id);
	}

	public List<OrderDTO> orderList(String id) {
		return sqlSession.selectList(namespace+".orderList", id);
	}
	
	public List<OrderDTO> orderGList(String O_code) {
		return sqlSession.selectList(namespace+".orderGList", O_code);
	}

	public OrderDTO orderDetail(String O_code) {
		return sqlSession.selectOne(namespace+".orderDetail", O_code);
	}
	
	public void orderAdd(OrderDTO orderDTO) {
		sqlSession.insert(namespace+".ordersAdd", orderDTO);
		sqlSession.insert(namespace+".deliveryAdd", orderDTO);
	}
	
	public void orderDAdd(OrderDTO orderDTO) {
		sqlSession.insert(namespace+".ordersDAdd", orderDTO);
	}
	
	public void basketDel(BasketDTO basketDTO) {
		sqlSession.delete(namespace+".basketDel", basketDTO);
	}
	
	public void basketAllDel(BasketDTO basketDTO) {
		sqlSession.delete(namespace+".basketAllDel", basketDTO);
	}
	
	public List<LikeDTO> likeList(String id) {
		return sqlSession.selectList(namespace+".likeList", id);
	}
	
	public String likeSelect(LikeDTO likeDTO) {
		return sqlSession.selectOne(namespace+".likeSelect", likeDTO);
	}
	
	public void likeAdd(LikeDTO likeDTO) {
		sqlSession.insert(namespace+".likeAdd", likeDTO);
	}
	
	public void likeDel(LikeDTO likeDTO) {
		sqlSession.delete(namespace + ".likeDel", likeDTO);
	}
	
	public void goodsWrite(GoodsDTO goodsDTO) {
		sqlSession.insert(namespace+".goodsWrite", goodsDTO);
	}

	public Integer maxB_num() {
		return sqlSession.selectOne(namespace+".maxB_num");
	}
	
	public Integer maxB_count(BasketDTO basketDTO) {
		return sqlSession.selectOne(namespace+".maxB_count", basketDTO);
	}
	
	public String getG_code(BasketDTO basketDTO) {
		return sqlSession.selectOne(namespace+".getG_code", basketDTO);
	}
	
	public Integer maxOD_num() {
		return sqlSession.selectOne(namespace+".maxOD_num");
	}
	
	public Integer maxD_num() {
		return sqlSession.selectOne(namespace+".maxD_num");
	}
	
	public String getO_code(OrderDTO orderDTO) {
		return sqlSession.selectOne(namespace+".getO_code", orderDTO);
	}
	
	public Integer maxO_code(OrderDTO orderDTO) {
		return sqlSession.selectOne(namespace+".maxO_code", orderDTO);
	}
	
	public Integer maxL_num() {
		return sqlSession.selectOne(namespace+".maxL_num");
	}

}
