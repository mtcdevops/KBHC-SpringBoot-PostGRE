package com.example.demo.Controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Service.DvdrentalService;
import com.example.demo.VO.ActorVO;
import com.example.demo.VO.DataVO;
import com.example.demo.VO.TemplateVO;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/dvd")
@Controller
public class DvdrentalController {
	
	// 필드 주입이 아닌 생성자 주입형태로 사용합니다. '생성자 주입 형태'로 사용합니다.
    private final DvdrentalService dvdrentalService;

	public DvdrentalController(DvdrentalService dvdrentalService) {
		super();
		this.dvdrentalService = dvdrentalService;
	}
    
	@GetMapping("actorList")
    public ResponseEntity<List<ActorVO>> selectActorList() {
        List<ActorVO> resultList = dvdrentalService.selectActorList();
        log.info(resultList.toString());
        return new ResponseEntity<>(resultList, HttpStatus.OK);
    }
	
	int count = 0;
	@Scheduled(fixedDelay = 1000)
	@GetMapping("insertData")
    public ResponseEntity<Integer> insertData() {
		DataVO dataVO = new DataVO();
		Integer result = null;
		count++ ;
		System.out.println(">>> : "+count);
		dataVO.setDate(new Timestamp(System.currentTimeMillis()));
		dataVO.setContents(Integer.toString(count));
		try {
			result = dvdrentalService.insertData(dataVO);
		} catch (Exception e) {
			dataVO.setContents("Exception : "+e);
			System.out.println(e);
			result = dvdrentalService.insertData(dataVO);
		}
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
}
