show tables;
/* 기본키(primary key): 테이블을 대표하는 키, 명명 중복을 허용하지않는다 , 여러개 올수있다.*/
create table test1 (
	idx int not null auto_increment,
	name varchar(20) not null,
	age int default 20,
	address varchar(50),
	primary key(idx)
);
select *from test1;
drop table test1;
insert into test1 values (default,'홍길동',default,'서울');
insert into test1 values (default,'김말숙',25,'청주');
insert into test1 values (1,'김말숙',25,'청주');
select * from test1;

create table test2 (
	idx int not null auto_increment,
	name varchar(20) not null,
	age int default 20,
	test2Code varchar(10) not null,
	primary key(idx) /*and 개념으로 본다 둘다 중복되어야 프라이머리키 작동함.*/
);
drop table test2;
insert into test2 values(default,'이기자',23,'aaa');
insert into test2 values(default,'김길자',33,'bbb');
select *from test2;
insert into test2 values (1,'김말숙',25,'ccc');
insert into test2 values (default,'김말숙',25,'ddd');


/*UNIQUE KEY: 중복불허를 위해 설정하는 키 (primary키가 이미 사용되었을때 중복을 불허하고자 쓴다.)*/
create table test3 (
	idx int not null auto_increment,
	name varchar(20) not null,
	age int default 20,
	job varchar(10) not null,
	address varchar(20) not null,
	test3Code varchar(10) not null,
	primary key(idx),
	UNIQUE KEY(test3Code)
);
desc test3;
insert into test3 values(default,'하호하',13, '학생','서울','ddd');
insert into test3 values(default,'대나무',43,'회사원','청주','eee');
insert into test3 values(default,'사과나무',27,'군인','대전','ggg');
insert into test3 values(1,'감나무',19,'fff');
insert into test3 values(default,'감나무',19,'eee');
select * from test3;

/*
	외래키(Foreign key)
	하나의 테이블에서 다른 테이블의 정보를 찾을때 연결역할을 하는 키
	조건: 현재 테이블의 필드에 외래키를 설정하려한다면, 반드시 상대쪽 테이블의 해당필드는 
	primary key이거나 unique key로 등록되어야한다.
	또한, 외래키로 지정하려는 필드는 상대쪽 테이블 필드의 해당속성과 동일하여야 한다~.
 */
create table test4 (
	idx int not null auto_increment primary key,
	gender char(2) default'남자',
	test2Idx int not null,
	test3Code varchar(10) not null,
	foreign key (test3Code) references test3 (test3Code),
	foreign key (test2Idx) references test2 (idx)
);
insert into test4 values(default,default,1,'ggg');
insert into test4 values(default,default,1,'ccc');
select * from test3,test4; /*크로스조인 경우의수 같이 표현*/

--join 시킨다고함.
--select 필드명 from 테이블명 where 조건식
select test3.*,gender from test3, test4;
select t3.idx as 고유번호,t4.gender as 성별 from test3 t3, test4 t4;
/*테이블이 서로 포린키로 연결되어있을때는 앞에 테이블명을 붙여줘야댐*/
select t3.*,t4.gender from test3 t3, test4 t4 where t3.test3Code = t4.test3Code;