
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
CREATE TABLE public."data" (
	num int4 NOT NULL GENERATED ALWAYS AS IDENTITY,
	contents text NULL,
	"date" timestamp NULL,
	CONSTRAINT data_pkey PRIMARY KEY (num)
);
```