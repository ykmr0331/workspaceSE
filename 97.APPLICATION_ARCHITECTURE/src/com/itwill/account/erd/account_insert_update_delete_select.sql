--insert
INSERT INTO JDEVELOPER00.ACCOUNT (NO, OWNER, BALANCE, IYUL)  VALUES (account_no_seq.nextval, 'KIM', 56000, 3.8);
INSERT INTO JDEVELOPER00.ACCOUNT (NO, OWNER, BALANCE, IYUL)  VALUES (account_no_seq.nextval, 'LEE', 34000, 4.8);
INSERT INTO JDEVELOPER00.ACCOUNT (NO, OWNER, BALANCE, IYUL)  VALUES (account_no_seq.nextval, 'PARK', 16000, 3.9);
INSERT INTO JDEVELOPER00.ACCOUNT (NO, OWNER, BALANCE, IYUL)  VALUES (account_no_seq.nextval, 'CHOI', 50000, 2.7);
INSERT INTO JDEVELOPER00.ACCOUNT (NO, OWNER, BALANCE, IYUL)  VALUES (account_no_seq.nextval, 'SIM', 19000, 1.7);
INSERT INTO JDEVELOPER00.ACCOUNT (NO, OWNER, BALANCE, IYUL)  VALUES (account_no_seq.nextval, 'HIM', 90000, 2.5);
INSERT INTO JDEVELOPER00.ACCOUNT (NO, OWNER, BALANCE, IYUL)  VALUES (account_no_seq.nextval, 'EIM', 89000, 4.1);
INSERT INTO JDEVELOPER00.ACCOUNT (NO, OWNER, BALANCE, IYUL)  VALUES (account_no_seq.nextval, 'PIM', 77000, 9.8);
--udate
UPDATE JDEVELOPER00.ACCOUNT
  SET OWNER = DEFAULT, BALANCE = DEFAULT, IYUL = DEFAULT
  WHERE NO = 1;
 
DELETE FROM JDEVELOPER00.ACCOUNT
 WHERE NO = 1 ;
 
 
SELECT NO, OWNER, BALANCE, IYUL
  FROM JDEVELOPER00.ACCOUNT
  WHERE NO = 1;
 
SELECT NO, OWNER, BALANCE, IYUL
  FROM JDEVELOPER00.ACCOUNT;
  
  