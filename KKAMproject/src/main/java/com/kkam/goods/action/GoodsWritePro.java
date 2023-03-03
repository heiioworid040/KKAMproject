package com.kkam.goods.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kkam.goods.db.GoodsDAO;
import com.kkam.goods.db.GoodsDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class GoodsWritePro implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("utf-8");
		String uploadPath=req.getRealPath("/img/goods");
		System.out.println(uploadPath);
		int maxSize=10*1024*1024;
		MultipartRequest multi=new MultipartRequest(req, uploadPath, maxSize, "utf-8", new DefaultFileRenamePolicy());
		
		String code=multi.getParameter("code");
		int stop=Integer.parseInt(multi.getParameter("stop"));
		String product=multi.getParameter("product");
		String desc=multi.getParameter("desc");
		int price=Integer.parseInt(multi.getParameter("price"));
		String imgS=multi.getFilesystemName("imgS");
		
		System.out.println(code);
		GoodsDTO dto=new GoodsDTO();
		dto.setG_code(code);
		dto.setG_stop(stop);
		dto.setG_product(product);
		dto.setG_desc(desc);
		dto.setG_price(price);
		dto.setG_imgS(imgS);
//		dto.setG_img(img);
		
		
		GoodsDAO dao=new GoodsDAO();
		dao.insertGoods(dto);
		
		ActionForward forward=new ActionForward();
		forward.setPath("Goods.kg");
		forward.setRedirect(true);
		return forward;
	}

}
