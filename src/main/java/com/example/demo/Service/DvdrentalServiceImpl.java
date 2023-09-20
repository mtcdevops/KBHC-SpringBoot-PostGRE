package com.example.demo.Service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Mapper.DvdrentalMapper;
import com.example.demo.VO.ActorVO;
import com.example.demo.VO.DataVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DvdrentalServiceImpl implements DvdrentalService {

	/**
     * '생성자 주입 형태'로 사용합니다.
     * - Autowired 는 권장되지 않기에 생성자 주입 형태로 구성합니다.
     */
    private final SqlSession sqlSession;
	
	public DvdrentalServiceImpl(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}

	@Transactional(readOnly = true)
	public List<ActorVO> selectActorList() {
		DvdrentalMapper tm = sqlSession.getMapper(DvdrentalMapper.class);
		return tm.selectActorList();
	}

	@Override
	public int insertData(DataVO dataVO) {
		DvdrentalMapper tm = sqlSession.getMapper(DvdrentalMapper.class);
		return tm.insertData(dataVO);
	}

}
