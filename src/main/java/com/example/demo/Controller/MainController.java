package com.example.demo.Controller;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Service.DataService;
import com.example.demo.Service.DataServiceImp;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

/**
 * [ 템플릿 설명 ]
 * - 해당 파일은 Restful API 형태로 URL 관리하는 파일입니다
 * - 뷰 자체만을 리턴해주거나 API 호출에 대한 처리를 해줍니다.
 * [ Annotation 설명 ]
 * - @Slf4j : 로그를 위해 사용하는 Annotation
 * - @RestController: Restful API 구조에서 JSON 타입으로 데이터를 반환 받기 위해 사용하는 Annotation
 * - @Controller: Spring MVC 패턴을 사용하기 위한 Annotation
 * - @RequestMapper: Controller URL Default
 *
 * @author lee
 * @since 2022.09.30
 */

@Lazy
@Slf4j
@RequestMapping("/")
@Controller
public class MainController {
	
	static int count;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private final DataService dataService;
	
	@Autowired
	public MainController(DataService dataService) {
		this.dataService = dataService;
	}

	@GetMapping(value = "index")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("index");
		count++;
		logger.info("ACCESS INDEX PAGE COUNT : "+count);
		return modelAndView;
	}
	
	@GetMapping("speed")// url : /speed?interval=1000
	public ResponseEntity<String> adjustSpeed(@RequestParam int interval) {
		// 컨트롤러에서 받은 값을 서비스로 전달하여 속도 동적 조절
		
		// 1초 1회 = 1000
		// 1초 2회 = 500
		
		// 1초 10회 = 100
		// x * interval = 1000
		// interval = 1000/x
		
		interval = 1000/interval;
		dataService.setFixedDelay(interval);
		return ResponseEntity.ok("Speed adjusted to " + interval + " milliseconds");
	}
	
	@GetMapping(value = "test")
	public ModelAndView page_test(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("test");
		System.out.println("TEST");
		return modelAndView;
	}
}
