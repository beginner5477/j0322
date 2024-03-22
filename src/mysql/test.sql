show tables;
select * from test;
select * from hoewon;
create table test (
	name varchar(20) not null,			--성명
	age int default 20,					--나이
	gender varchar(2) default '남자',		--성별
	address varchar(50)					--주소
);
drop table test;
delete from test;
desc test;

insert into test values ('김도완', 30,default,'청주');
insert into test values ('남순복', 60,'여자','청주');
insert into test values ('김재홍', 61,'남자','이천');
insert into test values ('김민호', 32,default,'청주');

delete from test where name = '김도완';

--레코드 수정하기: update 테이블명 set 필드명 ='수정내용' where '조건(필드명=값)';
update test set age=25 where name = '김도완';

--남자들만 나이를 1살씩 모두 더하시오.
update test set age=age-1;
update test set age=age+1 where gender ='남자';

--서울에 사는 사람들만 보여주세요.
select * from test where address ='청주';
select * from test where address ='청주' or address = '이천';

--나이가 30살 미만인 회원을 보여주시오.
select * from test where age < 30;
--나이가 30살 미만인 여자 회원을 보여주시오.
select * from test where age < 30 and gender = '여자';

--청주에 사는 회원 확인
select * from test where address = '청주'; 
--청주에 사는 회원 삭제
delete from test where address = '청주';
--청주/남자/19/김도완 회원을 등록하세요
insert into test values('김도완',19,default,'청주');
