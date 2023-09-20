package com.example.demo.Service;

import java.util.List;

import com.example.demo.VO.ActorVO;
import com.example.demo.VO.DataVO;

public interface DvdrentalService {
	
	List<ActorVO> selectActorList();
	
	int insertData(DataVO dataVO);
}
