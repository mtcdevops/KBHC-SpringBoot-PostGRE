# PostgreSQL 이중화 테스트 
- Spring boot : 2.7
- JDK : 11
- postgresql : 14

## DATA drop
```
DROP table public."data"
```

## DATA 테이블 생성 [2023-12-06]
- 환경이 바뀌면서 rw컬럼에 null이 들어가는 경우가 발생
```
CREATE TABLE data (
  num serial PRIMARY KEY,
  webserver_name varchar(50),
  contents text,
  date timestamp DEFAULT NULL,
  rw varchar(10) NULL
);


```

# [KB헬스케어_PostGRE Replica구성_개발자가이드_v1.0]()