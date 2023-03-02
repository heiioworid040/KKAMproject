package com.kkam.user.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kkam.user.db.UserDAO;
import com.kkam.user.db.UserDTO;

public class IdCheck implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("utf-8");
		String id=req.getParameter("id");
		UserDAO dao = new UserDAO();
		UserDTO dto = dao.getUser(id);
		String result="";
		
		if(dto!=null) {
			result="아이디 중복";
		}else {
			result="아이디 사용가능";
		}
		
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out=resp.getWriter();
		out.println(result);
		out.close();
		return null;
	}

}
