drop database if exists bai2_hibernate_test;
create database if not exists bai2_hibernate_test;
use bai2_hibernate_test;

drop table product;

select * from product;

alter table product
    drop column status;

select * from testtable;
select * from student;
drop table testtable;

create table studentSeq(
	next_val bigint
);
insert into studentSeq(next_val) values(100);
select * from studentSeq;
drop table studentSeq;

update studentSeq set next_val = next_val + 1;


select * from billdetail;