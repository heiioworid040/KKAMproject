package com.kkam.goods.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kkam.goods.db.GoodsDAO;
import com.kkam.goods.db.GoodsDTO;

public class GoodsPro implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String code=req.getParameter("G_code");
		System.out.println(code);
		GoodsDAO dao=new GoodsDAO();
		ArrayList<GoodsDTO> GoodsList=null;
		
		
		ActionForward forward=new ActionForward();
		if(code==null) {
			GoodsList=dao.GoodsList();
			forward.setPath("goods/goodsForm.jsp");
		} else {
			GoodsList=dao.GoodsList(code);
			forward.setPath("goods/goodsDetails.jsp");
		}
		
		req.setAttribute("GoodsList", GoodsList);
		forward.setRedirect(false);
		return forward;
	}
}
