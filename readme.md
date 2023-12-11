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

# KB헬스케어_PostGRE Replica구성_개발자가이드_v1.0

![img](./img/슬라이드1.PNG)
![img](./img/슬라이드2.PNG)
![img](./img/슬라이드3.PNG)
![img](./img/슬라이드4.PNG)
![img](./img/슬라이드5.PNG)
![img](./img/슬라이드6.PNG)
![img](./img/슬라이드7.PNG)
![img](./img/슬라이드8.PNG)
![img](./img/슬라이드9.PNG)
![img](./img/슬라이드10.PNG)
![img](./img/슬라이드11.PNG)
![img](./img/슬라이드12.PNG)
![img](./img/슬라이드13.PNG)
![img](./img/슬라이드14.PNG)
![img](./img/슬라이드15.PNG)
![img](./img/슬라이드16.PNG)
![img](./img/슬라이드17.PNG)
![img](./img/슬라이드18.PNG)
![img](./img/슬라이드19.PNG)
![img](./img/슬라이드20.PNG)
![img](./img/슬라이드21.PNG)
![img](./img/슬라이드22.PNG)
![img](./img/슬라이드23.PNG)
![img](./img/슬라이드24.PNG)
![img](./img/슬라이드25.PNG)
![img](./img/슬라이드26.PNG)
![img](./img/슬라이드27.PNG)
![img](./img/슬라이드28.PNG)
![img](./img/슬라이드29.PNG)