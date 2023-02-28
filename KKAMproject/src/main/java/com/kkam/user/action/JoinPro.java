package com.kkam.user.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kkam.user.db.UserDAO;

public class JoinPro implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String id=req.getParameter("id");
		String pass=req.getParameter("pass");
		
		
		UserDAO dao=new UserDAO();
		
		return null;
	}

}
