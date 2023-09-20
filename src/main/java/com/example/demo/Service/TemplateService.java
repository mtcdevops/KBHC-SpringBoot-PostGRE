package com.example.demo.Service;

import java.util.List;

import com.example.demo.VO.TemplateVO;

/**
 * [ 템플릿 설명 ]
 * - 해당 파일은 **ServiceImpl 내에서 구현된 구현체를 사용하기 위한 인터페이스 입니다.
 * - 해당 파일의 기능은 구현체에서 작성한 비즈니스 로직을 Controller 내에서 호출하기 위한 interface 입니다.
 *
 * @author lee
 * @since 2022.09.30
 */
public interface TemplateService {
    List<TemplateVO> selectTempList();

    TemplateVO selectTempById(Integer templateId);

    int insertTemp(TemplateVO templateVO);

    int updateTemp(TemplateVO templateVO);

    int deleteTempById(Integer templateId);
}