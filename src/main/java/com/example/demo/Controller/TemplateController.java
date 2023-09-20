package com.example.demo.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Service.TemplateService;
import com.example.demo.VO.TemplateVO;

import jakarta.validation.Valid;
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
@Slf4j
@RequestMapping("/temp")
@Controller
public class TemplateController {

    // 필드 주입이 아닌 생성자 주입형태로 사용합니다. '생성자 주입 형태'로 사용합니다.
    private final TemplateService templateService;

    public TemplateController(TemplateService ts) {
        this.templateService = ts;
    }


    /**
     * [VIEW] Thymeleaf 화면 만을 출력하는 함수
     *
     * @param model 전송 할 데이터
     * @return 페이지
     */
    @GetMapping("main")
    public String selectTemplateView(Model model) {
    	System.out.println("TEST");
        model.addAttribute("title", "템플릿 화면");
        return "temp/templatePage";
    }

    /**
     * [API] 템플릿 리스트 출력 함수
     *
     * @return ApiResponseWrapper<List < TemplateVO>> : 응답 결과 및 응답 코드 반환
     */
    @PostMapping("templateList")
    public ResponseEntity<List<TemplateVO>> selectTemplateList() {
        List<TemplateVO> resultList = templateService.selectTempList();
        return new ResponseEntity<>(resultList, HttpStatus.OK);
    }

    /**
     * [API] 템플릿 아이디 별 조회
     *
     * @param templateVO 템플릿 생성 데이터
     * @return ApiResponseWrapper<TemplateVO> : 응답 결과 및 응답 코드 반환
     */

    @PutMapping("selectTempById")
    public ResponseEntity<TemplateVO> selectTemplateById(@Valid @RequestBody TemplateVO templateVO) {
        TemplateVO result = templateService.selectTempById(templateVO.getTemplateId());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * [API] 템플릿 생성 함수
     *
     * @param templateVO 템플릿 생성 데이터
     * @return ApiResponseWrapper<TemplateVO> : 응답 결과 및 응답 코드 반환
     */
    @PostMapping("insertTemplate")
    public ResponseEntity<Integer> insertTemplate(@Valid @RequestBody TemplateVO templateVO) {
        Integer result = templateService.insertTemp(templateVO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * [API] 템플릿 수정 함수
     *
     * @param templateVO 템플릿 생성 데이터
     * @return ApiResponseWrapper<TemplateVO> : 응답 결과 및 응답 코드 반환
     */
    @PutMapping("updateTemplate")
    public ResponseEntity<Integer> updateTemplate(@Valid @RequestBody TemplateVO templateVO) {
        Integer result = templateService.updateTemp(templateVO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * [API] 템플릿 삭제 함수
     *
     * @param templateVO 템플릿 생성 데이터
     * @return ApiResponseWrapper<TemplateVO> : 응답 결과 및 응답 코드 반환
     */
    @DeleteMapping("deleteTemplate")
    public ResponseEntity<Integer> deleteTemplate(@Valid @RequestBody TemplateVO templateVO) {
        Integer result = templateService.deleteTempById(templateVO.getTemplateId());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}