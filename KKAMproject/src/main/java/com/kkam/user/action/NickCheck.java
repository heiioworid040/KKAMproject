package com.kkam.user.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kkam.user.db.LoginDAO;
import com.kkam.user.db.UserDAO;
import com.kkam.user.db.UserDTO;

public class NickCheck implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("utf-8");
		String nick=req.getParameter("nick");
		UserDAO dao=new UserDAO();
		UserDTO dto=dao.getUser_nick(nick);
		String result="";
		
		if(dto!=null) {
			result="닉네임 중복";
		}else {
			result="닉네임 사용가능";
		}
		
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out=resp.getWriter();
		out.println(result);
		out.close();
		
		return null;

	
	}

}
