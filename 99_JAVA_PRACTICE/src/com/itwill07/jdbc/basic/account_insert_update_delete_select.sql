--insert
insert into account values(address_no_seq.nextval,'김경호',50000,8);

--pk update 
update account set iyul= 1 ,owner='888-8888',balance=100000000  where no = 11;

--pk delete
delete from account where no=13;

--select (pk select)
select no,owner,balance, iyul from account where no=3;

--select (all select)
select no,owner,balance, iyul from account ;