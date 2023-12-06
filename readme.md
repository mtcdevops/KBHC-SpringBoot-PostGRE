# PostgreSQL 이중화 테스트 
- Spring boot : 2.7
- JDK : 11
- postgresql : 14

## DATA drop
```
DROP table public."data"
```

## DATA 테이블 생성
```
CREATE TABLE data (
  num serial PRIMARY KEY,
  webserver_name varchar(50),
  contents text,
  date timestamp DEFAULT NULL,
  rw varchar(10) NOT NULL
);


```