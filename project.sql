create table userTable 
(userID varchar2(10) not null unique, 
userNm number(30) not null primary key,
userPw varchar2(20) not null,
userName varchar2(5) not null unique,
userEm varchar2(30) not null unique);

select * from userTable;
--
create table boardTable
(boardNm number(30) not null,
boardTitle varchar2(20) not null,
boardSub varchar2(38) not null,
userNm number(30) REFERENCES userTable(userNm) ON DELETE CASCADE,
boardDate date not null,
boardCount number(38) not null);

create SEQUENCE userNm_SEQ -- 시퀀스를 생성할거야 시퀀스 이름
--증가를 1씩 할거야 (옵션이야 무조건 줘야 되는 코드가 아니야, 안주면 기본값 1)
start with 1  -- 옵션(기본값 1)
increment by 1
maxvalue 38 --  최대 얼마까지 증가를 시킬꺼야?? 옵션(기본값 10^27 까지 가능해)
minvalue 1 -- 옵션(기본값은 1)
nocycle cache 2;

create SEQUENCE BoardNm_SEQ -- 시퀀스를 생성할거야 시퀀스 이름
--증가를 1씩 할거야 (옵션이야 무조건 줘야 되는 코드가 아니야, 안주면 기본값 1)
start with 0 -- 옵션(기본값 1)
increment by 1
maxvalue 38 --  최대 얼마까지 증가를 시킬꺼야?? 옵션(기본값 10^27 까지 가능해)
minvalue 0 -- 옵션(기본값은 1)
nocycle cache 2;

create SEQUENCE boardCount_SEQ -- 시퀀스를 생성할거야 시퀀스 이름
--증가를 1씩 할거야 (옵션이야 무조건 줘야 되는 코드가 아니야, 안주면 기본값 1)
start with 0  -- 옵션(기본값 1)
maxvalue 38 --  최대 얼마까지 증가를 시킬꺼야?? 옵션(기본값 10^27 까지 가능해)
minvalue 0 -- 옵션(기본값은 1)
nocycle cache 2;