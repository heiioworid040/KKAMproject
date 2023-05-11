package com.project.service;

import java.sql.Timestamp;

import javax.inject.Inject;

import org.springframework.stereotype.Service;


import com.project.dao.NoticeDAO;
import com.project.domain.NoticeDTO;

@Service
public class NoticeService {
	
	@Inject
	private NoticeDAO noticeDAO;

	public void insertNotice(NoticeDTO noticeDTO) {
		if(noticeDAO.getMaxNum()==null) {
			noticeDTO.setN_num(1);
		}else {
			noticeDTO.setN_view(noticeDAO.getMaxNum()+1);
		}
		
		noticeDTO.setN_view(0);
		noticeDTO.setN_date(new Timestamp(System.currentTimeMillis()));
		
		noticeDAO.insertNotice(noticeDTO);
	}

}
