show tables;

--직급별 본봉 테이블
create table salary (
	jikkub char(8) not null primary key, /*직급*/
	bonbong int not null
);

--인사관리 테이블
create table insa (
	idx int not null primary key auto_increment,	/*인사관리 고유번호*/
	sabun char(8) not null,	/*직급코드*/
	buseo varchar(10) not null,	/*
);



--이기자사원의 본봉
select bonbong from salary where jikkub = '사원';
select * from salary s, insa i where s.jikkub = i.jikkub;