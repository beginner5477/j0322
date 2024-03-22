show tables;

create table insarok (
	idx int not null auto_increment primary key, /*고유번호*/
	buser varchar(10) not null, /*부서번호*/
	name varchar(20) not null,/*부서원(성명)*/
	jikwi varchar(10) not null default '사원', /*직위*/
	gender char(2) not null default '남자', /*성별*/
	age int default 25,		/*나이*/
	ipsail datetime not null default now(), /*입사일(기본값:오늘날짜)*/
	address varchar(50) 					/*주소(null허용)*/
--	primary key(idx) 이런 방식으로도 가능함.
);
desc insarok;

insert into insarok values (default,'인사과','홍길동','과장',default,38,'1995-1-5','서울');
insert into insarok values (default,'총무과','김도완','부장',default,34,'1990-3-5','청주');
insert into insarok values (default,'영업과','이기자','사원',default,31,'2000-1-5','제주');
insert into insarok values (default,'자재과','아이브','사원',default,30,'1996-2-22','서울');
insert into insarok values (default,'인사과','이하늘','사원',default,25,'2010-3-5','서울');
insert into insarok values (default,'영업과','세라핌','대리',default,22,'2022-1-5','서울');
insert into insarok values (default,'총무과','미카엘','대리',default,36,'1998-4-8','대구');
insert into insarok values (default,'영업과','루시퍼','대리',default,40,'2009-8-6','대전');
insert into insarok values (default,'총무과','바알','사원',default,45,'2016-1-5','서울');
insert into insarok values (default,'인사과','메피스토','사원',default,49,'2020-1-5','서울');
insert into insarok values (default,'총무과','나다라','사원',default,32,'2022-1-5','서울');
insert into insarok values (default,'자재과','가나다','사원',default,54,'1989-11-5','부산');
insert into insarok values (default,'자재과','안녕해','사원',default,64,'2021-12-5','서울');
insert into insarok values (default,'인사과','누구셈','사원',default,22,'2004-3-5','울산');
insert into insarok values (default,'자재과','자자자','사원',default,35,'1999-8-5','서울');
insert into insarok values (default,'자재과','죠죠러','사원',default,65,'2013-4-5','삼척');
insert into insarok values (default,'인사과','오타쿠','사원',default,45,'2002-6-5','서울');
insert into insarok values (default,'총무과','십타쿠','과장',default,45,'1988-5-5','태백');
insert into insarok values (default,'총무과','누구지','과장',default,38,'1999-2-5','서울');
insert into insarok values (default,'인사과','뭐할까','부장',default,35,'2005-7-5','청주');
insert into insarok values (default,'영업과','운동해','과장',default,32,'2017-7-7','서울');
insert into insarok values (default,'인사과','홍길동','부장',default,33,'2024-7-25','청주');

select * from insarok;

--insarok테이블의 성명/직위/주소 필드만 모든 자료 표시하시오
select name,jikwi,address from insarok;

--홍길동 레코드만 출력하시오
select * from insarok where name = '홍길동';

--서울에 사는 홍길동 레코드만 출력하쇼
select *from insarok where address = '서울' and name ='홍길동';

--홍길동 사원만 출력하쇼
select * from insarok where name='홍길동' and jikwi='사원';

--서울에 사는 모든사람출력하쇼
select * from insarok where address = '서울';

--입사년도가 2000년이전에 입사한 직원을 보여주시오
select * from insarok where ipsail < '2000-1-1';

--서울에 살지 않는 사람을 출력하쇼
select * from insarok where address != '서울';
select * from insarok where address <> '서울';

--입사년도가 2000년~2010년에 해당하는 직원을 출력하쇼
select * from insarok where ipsail < '2011-1-1' and ipsail >= '2000-1-1';
--앞의 범위 연산자 대신에 between~and로 대체가능
select * from insarok where ipsail between  '2000-1-1' and '2010-12-31';

--30대 회사원 출력
select * from insarok where age >= 30 and age <= 39;
select * from insarok where age between 30 and 39;

--서울 부산에 사는 직원 출력
select * from insarok where address = '서울' or address = '부산';
--앞의 or 연산자는 in()으로 변경가능
select * from insarok where address in('서울','부산');

--서울/부산에 사는 사원만 출력
select * from insarok where jikwi = '사원' and address in('서울','부산');

--'김'씨만 출력하세요
select * from insarok where name like '김%';
--'하늘'로 끝나느 이름을 가진 직원출력
select * from insarok where name like '%하늘';
--'바알'을 '이재혁'으로 이름변경하쇼
update insarok set name = '이재혁' where name = '바알';
update insarok set name = '가재다' where name = '가나다';
update insarok set name = '재다라' where name = '나다라';

--이름중에서 '재'라는 글자를 포함한 직원의 직급을 '과장'으로 변경하쇼

select * from insarok where name like '%재%';
update insarok set jikwi='과장' where name like (%재%);

--이름중에서 '재'란 글자를 포함하고 '서울'에 사는 직원의 이름과 입사일을 출력하쇼
select name,ipsail,address from insarok where name like '%재%' and address = '서울';

--이름중에서 '재'란 글자를 포함하고 '서울'에 사는 직원중에 나이가 40이상인 사람을 퇴사시키시오.
delete from insarok where name like '%재%' and address = '서울' and age >= 40;


--이름중에 2번째글자가 '나'인것을 출력하쇼
select * from insarok where name like '_나%';

--이름 오름차순으로 출력하시오(순서: order by~~, 오름차순:asc(생략가능),내림차순:desc
select * from insarok  order by name;
select * from insarok  order by name desc;

--남자인 자료중에서 나이 오름차순으로 출력
select * from insarok where gender ='남자' order by age;

--미카엘 성별을 남자에서 여자로 변경
update insarok set gender ='여자' where name ='미카엘';

--남자인 자료중에서 나이 오름차순으로, 같은 나이면 입사일 내림차순으로 출력하쇼
select * from insarok where gender ='남자' order by age, ipsail desc;

--전체자료중에 5명만 출력하시오(limit 숫자는 입력된 순서대로 나옴)
select * from insarok limit 5;
--전체자료중 뒤에서 5명만 출력하시오(나중에 입력한 회원 5명)
select * from insarok order by idx desc limit 5;

--남자회원 5명만 나이 내림차순으로 보여주세요
select * from insarok where gender='남자' order by age desc limit 5;

--남자회원중에서 앞에서 2명을 빼고, 5명만 출력하세요
select * from insarok where gender = '남자' order by idx  limit 2,5;