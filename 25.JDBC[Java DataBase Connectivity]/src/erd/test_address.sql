select * from address;

--insert
insert into address values(address_no_seq.nextval,'김경호','123-3456','경기도 포천시'); 

--update(pk)
update address set name = '김변경',phone = '888-8888', address = '서울시 강남구' where no =1;

--delete(pk)

delete from address where no =2;

--select(pk select) 
select no, name, phone, address from address where no = 2;

--select ( all select)
select no, name, phone, address from adress;

