package com.example.demo.Service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Mapper.TemplateMapper;
import com.example.demo.VO.TemplateVO;

import lombok.extern.slf4j.Slf4j;

/**
 * [ 템플릿 설명 ]
 * - 해당 파일은 서비스의 비즈니스 로직을 구현하는 곳입니다.
 * - 해당 *ServiceImpl 에서는 @Service 어노테이션을 필수적으로 사용합니다.
 */
@Slf4j
@Service
public class TemplateServiceImpl implements TemplateService {

    /**
     * '생성자 주입 형태'로 사용합니다.
     * - Autowired 는 권장되지 않기에 생성자 주입 형태로 구성합니다.
     */
    private final SqlSession sqlSession;

    public TemplateServiceImpl(SqlSession ss) {
        this.sqlSession = ss;
    }


    /**
     * Template 리스트 값 조회
     *
     * @return List<TemplateVO> 반환값
     */
    @Transactional(readOnly = true)
    public List<TemplateVO> selectTempList() {
        TemplateMapper tm = sqlSession.getMapper(TemplateMapper.class);
        return tm.selectTempList();
    }

    /**
     * 키 값을 기반으로 Template 리스트 조회
     *
     * @param templateId 조회 키 값
     * @return TemplateVO 반환 값
     */
    @Transactional(readOnly = true)
    public TemplateVO selectTempById(Integer templateId) {
        TemplateMapper tm = sqlSession.getMapper(TemplateMapper.class);
        return tm.selectTempById(templateId);
    }

    /**
     * Template INSERT
     *
     * @param templateVO 저장 할 값
     * @return TemplateVO 결과값 반환
     */
    @Transactional
    public int insertTemp(TemplateVO templateVO) {
        TemplateMapper tm = sqlSession.getMapper(TemplateMapper.class);
        return tm.insertTemp(templateVO);
    }

    /**
     * Template Update
     *
     * @param templateVO Update Value
     * @return TemplateVO 결과값 반환
     */
    @Transactional
    public int updateTemp(TemplateVO templateVO) {
        TemplateMapper tm = sqlSession.getMapper(TemplateMapper.class);
        return tm.updateTemp(templateVO);
    }

    /**
     * Template Delete
     *
     * @param tempId 삭제 아이디
     * @return TemplateVO 결과값 반환
     */
    @Transactional
    public int deleteTempById(Integer templateId) {
        TemplateMapper tm = sqlSession.getMapper(TemplateMapper.class);
        return tm.deleteTempById(templateId);
    }
}