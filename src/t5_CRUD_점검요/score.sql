show tables

create table score (
	idx int not null auto_increment primary key, /*성적 고유번호*/
	name varchar(20) not null,
	kor int default 0,
	eng int default 0,
	mat int default 0
);

desc score;
drop table score;

insert into score values (default,'홍길동',100,90,80);

select * from score;