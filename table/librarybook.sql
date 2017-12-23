prompt PL/SQL Developer import file
prompt Created on 2017��5��18�� by Administrator
set feedback off
set define off
prompt Creating LIBRARYBOOK...
create table LIBRARYBOOK
(
  bookno    VARCHAR2(12) not null,
  bookname  VARCHAR2(24),
  bookprice NUMBER(7,2),
  bookinven NUMBER(5),
  booktype  VARCHAR2(12),
  times     NUMBER(5) default 0
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table LIBRARYBOOK
  add constraint PK_BOOKNO primary key (BOOKNO)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt Disabling triggers for LIBRARYBOOK...
alter table LIBRARYBOOK disable all triggers;
prompt Deleting LIBRARYBOOK...
delete from LIBRARYBOOK;
commit;
prompt Loading LIBRARYBOOK...
insert into LIBRARYBOOK (bookno, bookname, bookprice, bookinven, booktype, times)
values ('1002', '����', 34.5, 65, 'С˵��', 9);
insert into LIBRARYBOOK (bookno, bookname, bookprice, bookinven, booktype, times)
values ('1003', '���μ�', 45.23, 20, '������', 5);
insert into LIBRARYBOOK (bookno, bookname, bookprice, bookinven, booktype, times)
values ('1004', '���Ʋ��', 23.45, 41, '������', 2);
insert into LIBRARYBOOK (bookno, bookname, bookprice, bookinven, booktype, times)
values ('1005', '������', 13.8, 30, '������', 2);
insert into LIBRARYBOOK (bookno, bookname, bookprice, bookinven, booktype, times)
values ('1071', '����', 23, 34, 'С˵��', 0);
insert into LIBRARYBOOK (bookno, bookname, bookprice, bookinven, booktype, times)
values ('1007', '�������������ɵ�', 34.67, 32, '������', 3);
insert into LIBRARYBOOK (bookno, bookname, bookprice, bookinven, booktype, times)
values ('1009', 'ƽ��������', 23.23, 40, '������', 2);
insert into LIBRARYBOOK (bookno, bookname, bookprice, bookinven, booktype, times)
values ('1010', '��¹ԭ', 32.44, 30, 'С˵��', 0);
insert into LIBRARYBOOK (bookno, bookname, bookprice, bookinven, booktype, times)
values ('1011', 'Χ��', 12.21, 52, 'С˵��', 0);
insert into LIBRARYBOOK (bookno, bookname, bookprice, bookinven, booktype, times)
values ('1012', '����˹̹�����', 12.21, 29, '������', 2);
insert into LIBRARYBOOK (bookno, bookname, bookprice, bookinven, booktype, times)
values ('1013', '�����ʷ', 24.11, 42, '������', 2);
insert into LIBRARYBOOK (bookno, bookname, bookprice, bookinven, booktype, times)
values ('1024', '������', 23.11, 64, 'С˵��', 0);
insert into LIBRARYBOOK (bookno, bookname, bookprice, bookinven, booktype, times)
values ('1023', '������Դ', 21.86, 24, '������', 4);
insert into LIBRARYBOOK (bookno, bookname, bookprice, bookinven, booktype, times)
values ('1022', '��', 17.34, 31, 'С˵��', 0);
insert into LIBRARYBOOK (bookno, bookname, bookprice, bookinven, booktype, times)
values ('1021', '��������о�', 34.23, 42, '��ѧ��', 0);
insert into LIBRARYBOOK (bookno, bookname, bookprice, bookinven, booktype, times)
values ('1020', '�����Լ��', 23.85, 52, '��ѧ��', 0);
insert into LIBRARYBOOK (bookno, bookname, bookprice, bookinven, booktype, times)
values ('1019', '��', 45.32, 13, 'С˵��', 0);
insert into LIBRARYBOOK (bookno, bookname, bookprice, bookinven, booktype, times)
values ('1018', '����������', 23.45, 52, '��ѧ��', 0);
insert into LIBRARYBOOK (bookno, bookname, bookprice, bookinven, booktype, times)
values ('1017', '��ά����', 21.15, 53, '������', 0);
insert into LIBRARYBOOK (bookno, bookname, bookprice, bookinven, booktype, times)
values ('1016', '����ʥĸԺ', 23.78, 64, '������', 0);
insert into LIBRARYBOOK (bookno, bookname, bookprice, bookinven, booktype, times)
values ('1015', '����������', 34.23, 13, '��ѧ��', 0);
insert into LIBRARYBOOK (bookno, bookname, bookprice, bookinven, booktype, times)
values ('1014', '��', 15.67, 13, 'С˵��', 0);
insert into LIBRARYBOOK (bookno, bookname, bookprice, bookinven, booktype, times)
values ('1025', '��Хɽׯ', 25.33, 42, '������', 0);
insert into LIBRARYBOOK (bookno, bookname, bookprice, bookinven, booktype, times)
values ('1026', 'ѧ��˼¼', 44.23, 13, '��ѧ��', 0);
insert into LIBRARYBOOK (bookno, bookname, bookprice, bookinven, booktype, times)
values ('1028', '��������', 17.21, 34, '������', 0);
insert into LIBRARYBOOK (bookno, bookname, bookprice, bookinven, booktype, times)
values ('1029', '�����', 25.34, 23, '��ѧ��', 0);
insert into LIBRARYBOOK (bookno, bookname, bookprice, bookinven, booktype, times)
values ('1051', '���ҵ���', 20, 28, '��־��', 0);
insert into LIBRARYBOOK (bookno, bookname, bookprice, bookinven, booktype, times)
values ('1008', 'ʱ���ʷ', 76.34, 20, '������', 2);
commit;
prompt 28 records loaded
prompt Enabling triggers for LIBRARYBOOK...
alter table LIBRARYBOOK enable all triggers;
set feedback on
set define on
prompt Done.
