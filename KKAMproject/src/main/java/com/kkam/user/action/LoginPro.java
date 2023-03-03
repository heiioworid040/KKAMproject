package com.kkam.user.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kkam.user.db.LoginDAO;
//import com.kkam.user.db.UserDAO;
import com.kkam.user.db.UserDTO;

public class LoginPro implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String id=req.getParameter("id");
		String pw=req.getParameter("pw");
		
		LoginDAO dao = new LoginDAO();
//		UserDAO dao = new UserDAO();
		UserDTO dto = dao.Login(id, pw);
		
		ActionForward forward = null;
		
		if(dto!=null) {
			HttpSession session=req.getSession();
			session.setAttribute("id", id);
			
			forward = new ActionForward();
			forward.setPath("Main.kkam");
			forward.setRedirect(true);
		}else {
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}
		
		return forward;
	}
}