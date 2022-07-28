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
