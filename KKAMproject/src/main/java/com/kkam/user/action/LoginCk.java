package com.kkam.user.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kkam.user.db.LoginDAO;
//import com.kkam.user.db.UserDAO;
import com.kkam.user.db.UserDTO;

public class LoginCk implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String id=req.getParameter("id");
		String pw=req.getParameter("pw");
		String result="";
		
		LoginDAO dao = new LoginDAO();
		UserDTO dto = dao.Login(id, pw);
		
		if(dto==null) {
			result = "아이디 혹은 비밀번호가 일치하지 않습니다.";
		}
		
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println(result);
		out.close();
		return null;
	}
}