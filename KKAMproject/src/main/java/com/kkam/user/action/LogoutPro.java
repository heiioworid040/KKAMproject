package com.kkam.user.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutPro implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HttpSession session=req.getSession();
		session.invalidate();
		
		ActionForward forward=new ActionForward();
		forward.setPath("Main.kkam");
		forward.setRedirect(true);
		return forward;
	}
}