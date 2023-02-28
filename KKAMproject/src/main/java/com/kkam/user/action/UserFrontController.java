package com.kkam.user.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.member.action.ActionForward;

public class UserFrontController extends HttpServlet {
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

		
		if(sPath.equals("/Main.kkam")) {
			forward=new ActionForward();
			forward.setPath("home/main.jsp");
			forward.setRedirect(false);
			
		}else if(sPath.equals("/Join.kkam")) {
			resp.sendRedirect("user/joinForm.jsp");
			RequestDispatcher dispatcher=req.getRequestDispatcher("user/joinForm.jsp");
			dispatcher.forward(req, resp);
			
			forward=new ActionForward();
			forward.setPath(sPath);
			forward.setRedirect(false);
			
		}else if(sPath.equals("/JoinPro.kkam")) {			
			action=new JoinPro();
			try {
				forward=action.execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}else if(sPath.equals("/Login.kkam")) {
			forward=new ActionForward();
			forward.setPath("user/loginForm.jsp");
			forward.setRedirect(false);
			
		}else if(sPath.equals("/LoginPro.kkam")) {			
			action=new LoginPro();
			try {
				forward=action.execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}

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