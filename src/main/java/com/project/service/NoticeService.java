package com.project.service;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;


import com.project.dao.NoticeDAO;
import com.project.domain.NoticeDTO;
import com.project.domain.PageDTO;

@Service
public class NoticeService {
	
	@Inject
	private NoticeDAO noticeDAO;

	public void insertNotice(NoticeDTO noticeDTO) {
		System.out.println("NoticeService insertNotice");
		if(noticeDAO.getMaxNum()==null) {
			noticeDTO.setN_num(1);
		}else {
			noticeDTO.setN_num(noticeDAO.getMaxNum()+1);
		}
		
		noticeDTO.setN_view(0);
		noticeDTO.setN_date(new Timestamp(System.currentTimeMillis()));
		
		noticeDAO.insertNotice(noticeDTO);
	}

	public List<NoticeDTO> getNoticeList(PageDTO pageDTO) {
		
		int startRow = (pageDTO.getCurrentPage()-1)*pageDTO.getPageSize()+1;
		int endRow = startRow + pageDTO.getPageSize()-1;
		
		pageDTO.setStartRow(startRow);
		pageDTO.setEndRow(endRow);
		
		return noticeDAO.getNoticeList(pageDTO);
	}

	public int getNoticeCount(PageDTO pageDTO) {
		return noticeDAO.getNoticeCount(pageDTO);
	}

	public NoticeDTO getNotice(int n_num) {
		return noticeDAO.getNotice(n_num);
	}

	public void update(NoticeDTO noticeDTO) {
		noticeDAO.update(noticeDTO);
		
	}

	public void delete(int n_num) {
		noticeDAO.delete(n_num);
	}


}
