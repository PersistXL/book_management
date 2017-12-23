prompt PL/SQL Developer import file
prompt Created on 2017年5月18日 by Administrator
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
values ('1002', '三国', 34.5, 65, '小说类', 9);
insert into LIBRARYBOOK (bookno, bookname, bookprice, bookinven, booktype, times)
values ('1003', '西游记', 45.23, 20, '名著类', 5);
insert into LIBRARYBOOK (bookno, bookname, bookprice, bookinven, booktype, times)
values ('1004', '斗破苍穹', 23.45, 41, '玄幻类', 2);
insert into LIBRARYBOOK (bookno, bookname, bookprice, bookinven, booktype, times)
values ('1005', '大主宰', 13.8, 30, '玄幻类', 2);
insert into LIBRARYBOOK (bookno, bookname, bookprice, bookinven, booktype, times)
values ('1071', '三体', 23, 34, '小说类', 0);
insert into LIBRARYBOOK (bookno, bookname, bookprice, bookinven, booktype, times)
values ('1007', '钢铁是怎样炼成的', 34.67, 32, '名著类', 3);
insert into LIBRARYBOOK (bookno, bookname, bookprice, bookinven, booktype, times)
values ('1009', '平凡的世界', 23.23, 40, '名著类', 2);
insert into LIBRARYBOOK (bookno, bookname, bookprice, bookinven, booktype, times)
values ('1010', '白鹿原', 32.44, 30, '小说类', 0);
insert into LIBRARYBOOK (bookno, bookname, bookprice, bookinven, booktype, times)
values ('1011', '围城', 12.21, 52, '小说类', 0);
insert into LIBRARYBOOK (bookno, bookname, bookprice, bookinven, booktype, times)
values ('1012', '爱因斯坦相对论', 12.21, 29, '科普类', 2);
insert into LIBRARYBOOK (bookno, bookname, bookprice, bookinven, booktype, times)
values ('1013', '万物简史', 24.11, 42, '科普类', 2);
insert into LIBRARYBOOK (bookno, bookname, bookprice, bookinven, booktype, times)
values ('1024', '大主宰', 23.11, 64, '小说类', 0);
insert into LIBRARYBOOK (bookno, bookname, bookprice, bookinven, booktype, times)
values ('1023', '物种起源', 21.86, 24, '科普类', 4);
insert into LIBRARYBOOK (bookno, bookname, bookprice, bookinven, booktype, times)
values ('1022', '秋', 17.34, 31, '小说类', 0);
insert into LIBRARYBOOK (bookno, bookname, bookprice, bookinven, booktype, times)
values ('1021', '人类理解研究', 34.23, 42, '哲学类', 0);
insert into LIBRARYBOOK (bookno, bookname, bookprice, bookinven, booktype, times)
values ('1020', '社会契约论', 23.85, 52, '哲学类', 0);
insert into LIBRARYBOOK (bookno, bookname, bookprice, bookinven, booktype, times)
values ('1019', '春', 45.32, 13, '小说类', 0);
insert into LIBRARYBOOK (bookno, bookname, bookprice, bookinven, booktype, times)
values ('1018', '共产党宣言', 23.45, 52, '哲学类', 0);
insert into LIBRARYBOOK (bookno, bookname, bookprice, bookinven, booktype, times)
values ('1017', '万维宇宙', 21.15, 53, '科普类', 0);
insert into LIBRARYBOOK (bookno, bookname, bookprice, bookinven, booktype, times)
values ('1016', '巴黎圣母院', 23.78, 64, '名著类', 0);
insert into LIBRARYBOOK (bookno, bookname, bookprice, bookinven, booktype, times)
values ('1015', '存在于虚无', 34.23, 13, '哲学类', 0);
insert into LIBRARYBOOK (bookno, bookname, bookprice, bookinven, booktype, times)
values ('1014', '家', 15.67, 13, '小说类', 0);
insert into LIBRARYBOOK (bookno, bookname, bookprice, bookinven, booktype, times)
values ('1025', '呼啸山庄', 25.33, 42, '名著类', 0);
insert into LIBRARYBOOK (bookno, bookname, bookprice, bookinven, booktype, times)
values ('1026', '学沉思录', 44.23, 13, '哲学类', 0);
insert into LIBRARYBOOK (bookno, bookname, bookprice, bookinven, booktype, times)
values ('1028', '悲惨世界', 17.21, 34, '名著类', 0);
insert into LIBRARYBOOK (bookno, bookname, bookprice, bookinven, booktype, times)
values ('1029', '理想国', 25.34, 23, '哲学类', 0);
insert into LIBRARYBOOK (bookno, bookname, bookprice, bookinven, booktype, times)
values ('1051', '国家地理', 20, 28, '杂志类', 0);
insert into LIBRARYBOOK (bookno, bookname, bookprice, bookinven, booktype, times)
values ('1008', '时间简史', 76.34, 20, '科普类', 2);
commit;
prompt 28 records loaded
prompt Enabling triggers for LIBRARYBOOK...
alter table LIBRARYBOOK enable all triggers;
set feedback on
set define on
prompt Done.
