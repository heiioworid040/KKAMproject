package com.kkam.goods.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kkam.goods.action.Action;
import com.kkam.goods.action.ActionForward;
import com.kkam.user.action.LoginCk;

public class GoodsFrontController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	

	private void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sPath=req.getServletPath();
		
		ActionForward forward=null;
		Action action=null;


		if(sPath.equals("/Goods.kg")) {
			action=new GoodsPro();
			try {
				forward=action.execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(sPath.equals("/GoodsDetails.kg")) {
			forward=new ActionForward();
			forward.setPath("goods/goodsDetails.jsp");
			forward.setRedirect(false);
			
		}else if(sPath.equals("/GoodsWrite.kg")) {
			forward=new ActionForward();
			forward.setPath("goods/goodsWrite.jsp");
			forward.setRedirect(false);
			
		}else if(sPath.equals("/GoodsWritePro.kg")) {			
			action=new GoodsWritePro();
			try {
				forward=action.execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}


		
		/* 여기 위까지 if문 작성 */
		
		if(forward != null) {
			if(forward.isRedirect()==true) {
				resp.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher dispatcher=req.getRequestDispatcher(forward.getPath());
		        dispatcher.forward(req, resp);
			}
		}

	}//doProcess()

}//클래스