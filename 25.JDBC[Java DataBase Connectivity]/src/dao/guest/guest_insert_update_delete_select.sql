--guest
/*
이름             널?       유형             
-------------- -------- -------------- 
GUEST_NO       NOT NULL NUMBER(10)     
GUEST_NAME              VARCHAR2(50)   
GUEST_DATE              DATE           
GUEST_EMAIL             VARCHAR2(50)   
GUEST_HOMEPAGE          VARCHAR2(50)   
GUEST_TITLE             VARCHAR2(100)  
GUEST_CONTENT           VARCHAR2(4000) 
*/
--pk delete 
delete from guest where guest_no=1;
--insert
insert into guest values(guest_guest_no_seq.nextval,'김경호1',sysdate,'guard1@naver.com','http://www.naver.com','방병록사용법1','잘사용하세요1');
insert into guest values(guest_guest_no_seq.nextval,'김경호2',sysdate,'guard2@naver.com','http://www.naver.com','방병록사용법2','잘사용하세요2');
insert into guest values(guest_guest_no_seq.nextval,'김경호3',sysdate,'guard3@naver.com','http://www.naver.com','방병록사용법3','잘사용하세요3');
insert into guest values(guest_guest_no_seq.nextval,'김경호4',sysdate,'guard4@naver.com','http://www.naver.com','방병록사용법4','잘사용하세요4');
insert into guest values(guest_guest_no_seq.nextval,'김경호5',sysdate,'guard5@naver.com','http://www.naver.com','방병록사용법5','잘사용하세요5');
--pk update
update guest set guest_name='name수정',
                 guest_email='email수정',
                 guest_homepage='homepage수정',
                 guest_title='title수정',
                 guest_content='content수정'
where guest_no=1;
--select pk
select * from guest where guest_no=1;
--select all
select * from guest;

commit;
