package com.kkam.goods.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kkam.goods.db.GoodsDAO;
import com.kkam.goods.db.GoodsDTO;

public class GoodsPro implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		GoodsDAO dao=new GoodsDAO();
		ArrayList<GoodsDTO> GoodsList=dao.GoodsList();
		
		req.setAttribute("GoodsList", GoodsList);
		ActionForward forward=new ActionForward();
		forward.setPath("goods/goodsForm.jsp");
		forward.setRedirect(false);
		return forward;
	}
}
