package com.kkam.notice.action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kkam.notice.db.NoticeDAO;
import com.kkam.notice.db.NoticeDTO;
import com.kkam.user.action.Action;
import com.kkam.user.action.ActionForward;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class NoticeWritePro implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		System.out.println("NoticeWritePro execute()");
		String uploadPath=req.getRealPath("img/upload");
		System.out.println(uploadPath);
	
		int maxSize=10*1024*1024;
		
		MultipartRequest multi=new MultipartRequest(req, uploadPath, maxSize, "utf-8", new DefaultFileRenamePolicy());
		String name=multi.getParameter("nick");
		String title=multi.getParameter("title");
		String text=multi.getParameter("text");
		String nick=multi.getParameter("nick");
		String id=multi.getParameter("id");
		int view=0;
		Timestamp date=new Timestamp(System.currentTimeMillis());
		String img=multi.getFilesystemName("img");
		
		NoticeDTO dto = new NoticeDTO();
		dto.setN_date(date);
		dto.setN_title(title);
		dto.setN_text(text);
		dto.setN_img(img);
		dto.setN_view(view);
		dto.setU_nick(nick);
		dto.setU_id(id);
		
		NoticeDAO dao = new NoticeDAO();
		dao.insertNotice(dto);
		
		ActionForward forward=new ActionForward();
		forward.setPath("NoticeList.bo");
		forward.setRedirect(true);
		return forward;

	}

}
