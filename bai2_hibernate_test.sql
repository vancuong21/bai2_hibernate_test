drop database if exists bai2_hibernate_test;
create database if not exists bai2_hibernate_test;
use bai2_hibernate_test;

drop table product;

SELECT * FROM product;

alter table product
    drop column status;

SELECT * FROM testtable;
SELECT * FROM student;
drop table testtable;

CREATE TABLE studentSeq (
    next_val BIGINT
);
insert into studentSeq(next_val)
values (100);
SELECT 
    *
FROM
    studentSeq;
drop table studentSeq;

UPDATE studentSeq 
SET 
    next_val = next_val + 1;


SELECT 
    *
FROM
    billdetail;

insert into category(name)
values ('Thịt, Rau Củ'),
       ('Bách Hóa'),
       ('Nhà Cửa'),
       ('Điện Tử'),
       ('Thiết Bị Số'),
       ('Điện Thoại'),
       ('Mẹ & Bé'),
       ('Làm Đẹp'),
       ('Gia Dụng'),
       ('Thời trang nữ'),
       ('Thời trang nam'),
       ('Giày nữ'),
       ('Túi nữ'),
       ('Giày nam'),
       ('Túi nam'),
       ('Balo & Vali'),
       ('Phụ kiện'),
       ('Đồng hồ'),
       ('Laptop'),
       ('Quốc Tế'),
       ('Voucher'),
       ('XeSách'),
       ('Thể Thao'),
       ('Máy Ảnh');

SELECT * FROM product
INNER JOIN
	category c ON product.category_id = c.id;
    



