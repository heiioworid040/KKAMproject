package com.kkam.user.action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kkam.user.db.UserDAO;
import com.kkam.user.db.UserDTO;

public class JoinPro implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String id=req.getParameter("id");
		String pw=req.getParameter("pw");
		String name=req.getParameter("name");
		String nick=req.getParameter("nick");
		int birth=Integer.parseInt(req.getParameter("birth"));
		Timestamp U_createdate=new Timestamp(System.currentTimeMillis());
		int phone=Integer.parseInt(req.getParameter("phone"));
		String email=req.getParameter("email");
		String emailD=req.getParameter("emailD");
		String grade=req.getParameter("grade");
		String address=req.getParameter("address");
		String address2=req.getParameter("address2");
		
		UserDTO dto=new UserDTO();
		dto.setU_id(id);
		dto.setU_pw(pw);
		dto.setU_name(name);
		dto.setU_nick(nick);
		dto.setU_birth(birth);
		dto.setU_createdate(U_createdate);
		dto.setU_phone(phone);
		dto.setU_email(email);
		dto.setU_emailD(emailD);
		dto.setU_grade(grade);
		dto.setU_address(address);
		dto.setU_address2(address2);
		
		UserDAO dao=new UserDAO();
		dao.insertUser(dto);
		ActionForward forward=new ActionForward();
		forward.setPath("Login.kkam");
		forward.setRedirect(true);
		return forward;
	}

}
