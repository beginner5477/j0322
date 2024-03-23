show tables;
--직급별 본봉 테이블
create table salary (
	jikkub char(8) not null primary key, /*직급*/
	bonbong int not null
);

--인사관리 테이블
create table insa (
	idx int not null primary key auto_increment,	/*인사관리 고유번호*/
	sabun char(8) not null,	/*직급코드날짜 월일 + 들어온 순서?조합번호*/
	buseo varchar(10) not null, /*부서명*/
	name varchar(20) not null,	/*이름*/
	jikkub char(8) not null,	/*직급*/
	age int default 25,
	ipsail datetime default now(),
	gender char(3) default '여자',
	address varchar(40),
	unique key (sabun),
	foreign key (jikkub) references salary (jikkub) 
);
desc salary;
delete from insa where name = '남순복';
desc insa;
drop table salary;
drop table insa;
insert into salary values ('부장', 5000000);
insert into salary values ('과장', 4000000);
insert into salary values ('대리', 3000000);
insert into salary values ('사원', 2000000);
select * from salary;
select * from insa;
insert into insa values (default,'24032101','인사과','홍길동','과장',35,'2000-1-5','남자','서울');
insert into insa values (default,'24032102','영업과','김말숙','대리',31,'2007-11-25',default,'청주');
insert into insa values (default,'24032201','총무과','이기자','사원',25,'2022-8-22','남자','서울');
insert into insa values (default,'24032202','자재과','김도완','대리',30,'2023-12-15','남자','청주');

select salary.bonbong, insa.name from salary, insa where salary.jikkub = insa.jikkub && insa.name = '김도완';

--join 하는법
select i.name, i.jikkub, s.bonbong from salary s, insa i where s.jikkub = i.jikkub;