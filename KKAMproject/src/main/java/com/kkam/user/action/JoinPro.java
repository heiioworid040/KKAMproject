package com.kkam.user.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kkam.user.db.UserDAO;
import com.kkam.user.db.UserDTO;

public class JoinPro implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("utf-8");
		
		String id=req.getParameter("id");
		String pw=req.getParameter("pw");
		String name=req.getParameter("name");
		String nick=req.getParameter("nick");
		String birth=req.getParameter("birth");
//		int birth=Integer.parseInt(req.getParameter("birth"));
		int phone=Integer.parseInt(req.getParameter("phone"));
		String email=req.getParameter("email");
//		String emailD=req.getParameter("emailD");
		String address=req.getParameter("address");
		String addressD=req.getParameter("addressD");

		
		UserDTO dto=new UserDTO();
		dto.setU_id(id);
		dto.setU_pw(pw);
		dto.setU_name(name);
		dto.setU_nick(nick);
		dto.setU_birth(birth);
		dto.setU_phone(phone);
		dto.setU_email(email);
//		dto.setU_emailD(emailD);
		dto.setU_address(address);
		dto.setU_addressD(addressD);

		
		UserDAO dao=new UserDAO();
	
		UserDTO idck=dao.getUser(id);
		UserDTO nickck=dao.getUser_nick(nick);
		
		ActionForward forward=null;
		
			if(idck!=null) {
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out=resp.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('아이디 중복')");
			out.println("history.back()");
			out.println("</script>");
			out.close();
			
			}else if(nickck!=null){
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out=resp.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('닉네임 중복')");
			out.println("history.back()");
			out.println("</script>");
			out.close();
			
			}else {
			dao.insertUser(dto);
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out=resp.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('회원가입 완료')");
			out.println("location.href = 'Main.kkam'");
			out.println("</script>");
			out.close();
			}
		
		
		
		return forward;
	}

}
