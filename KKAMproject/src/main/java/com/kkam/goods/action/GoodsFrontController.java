package com.kkam.goods.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kkam.goods.action.Action;
import com.kkam.goods.action.ActionForward;

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
			forward=new ActionForward();
			forward.setPath("goods/goodsForm.jsp");
			forward.setRedirect(false);

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