package com.kkam.user.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserFrontController extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
	

	private void doProcess(HttpServletRequest req, HttpServletResponse resp) {
		String sPath=req.getServletPath();
		
		ActionForward forward=null;
		Action action=null;


		if() {
			
		}
		
		/* 여기 위까지 if문 작성 */
		
		if(forward != null) {
			//이동방식비교
			if(forward.isRedirect()==true) {
				resp.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher dispatcher=
				req.getRequestDispatcher(forward.getPath());
		        dispatcher.forward(req, resp);
			}
		}//이동방식
		
	}//doProcess()
	
}//클래스