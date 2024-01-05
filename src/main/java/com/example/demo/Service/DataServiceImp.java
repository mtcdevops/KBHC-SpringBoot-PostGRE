package com.example.demo.Service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Mapper.DataMapper;
import com.example.demo.VO.DataInfoVO;

import lombok.extern.slf4j.Slf4j;

@Lazy
@Slf4j
@Service
@Transactional
public class DataServiceImp implements DataService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final SqlSession sqlSession;
    private ScheduledExecutorService executorService;
    private AutoCRUD_thread insert;
    
    @Autowired
    public DataServiceImp(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
        // Initialize the executorService when the thread is created
        this.executorService = Executors.newSingleThreadScheduledExecutor();
    }

    public void setFixedDelay(int interval) {
        System.out.println(interval);
        // executorService가 종료되었는지 확인하고 종료되지 않았다면 종료
        if (!executorService.isTerminated()) {
            executorService.shutdown();
            try {
                // 최대 5초간 작업이 완료될 때까지 대기
                if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                    // 작업이 완료되지 않았다면 강제 종료
                    executorService.shutdownNow();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        // executorService가 종료된 경우 새로 생성
        if (executorService.isTerminated()) {
            executorService = Executors.newSingleThreadScheduledExecutor();
            System.out.println("종료가 되면 다시 새로 생성된다.");
        }

        // 새로운 작업을 스케줄링
        executorService.scheduleWithFixedDelay(this::insertData, 0, interval, TimeUnit.MILLISECONDS);

        // 추가로 종료 처리가 필요한 경우
        if (interval == 0) {
            System.out.println("isTerminated");
            executorService.shutdownNow();
        }
    }

    public void insertData() {
    	insert = new AutoCRUD_thread("WRITE", sqlSession);
        logger.info("master ...ing");
        insert.start(); // Thread 시작
    }
}

