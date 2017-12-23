prompt PL/SQL Developer import file
prompt Created on 2017年5月18日 by Administrator
set feedback off
set define off
prompt Creating BORROWBOOK...
create table BORROWBOOK
(
  onlyno    NUMBER(10) not null,
  rname     VARCHAR2(20),
  bookno    VARCHAR2(12),
  bookname  VARCHAR2(20),
  bookprice NUMBER(10,2),
  booktype  VARCHAR2(12),
  lenddate  DATE default sysdate,
  maxdate   DATE default sysdate+7,
  actudate  DATE,
  finemoney NUMBER(10,2),
  rentmoney NUMBER(10,2),
  bookstate VARCHAR2(12) default '未还'
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
alter table BORROWBOOK
  add constraint PK_ONLY primary key (ONLYNO)
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
alter table BORROWBOOK
  add constraint FK_RNAME foreign key (RNAME)
  references REGLIBRARY (RNAME);

prompt Disabling triggers for BORROWBOOK...
alter table BORROWBOOK disable all triggers;
prompt Disabling foreign key constraints for BORROWBOOK...
alter table BORROWBOOK disable constraint FK_RNAME;
prompt Deleting BORROWBOOK...
delete from BORROWBOOK;
commit;
prompt Loading BORROWBOOK...
insert into BORROWBOOK (onlyno, rname, bookno, bookname, bookprice, booktype, lenddate, maxdate, actudate, finemoney, rentmoney, bookstate)
values (83, 'likui', '1003', '西游记', 45.23, '名著类', to_date('19-01-2017 14:48:57', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-01-2017 14:48:57', 'dd-mm-yyyy hh24:mi:ss'), to_date('03-02-2017', 'dd-mm-yyyy'), 0, 5, '已还');
insert into BORROWBOOK (onlyno, rname, bookno, bookname, bookprice, booktype, lenddate, maxdate, actudate, finemoney, rentmoney, bookstate)
values (128, 'liangxiaoke', '1015', '存在于虚无', 34.23, '哲学类', to_date('03-02-2017 15:41:36', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-02-2017 15:41:36', 'dd-mm-yyyy hh24:mi:ss'), to_date('03-02-2017', 'dd-mm-yyyy'), 0, 6, '已还');
insert into BORROWBOOK (onlyno, rname, bookno, bookname, bookprice, booktype, lenddate, maxdate, actudate, finemoney, rentmoney, bookstate)
values (81, 'likui', '1001', '三国演义', 24.5, '名著类', to_date('19-01-2017 14:38:30', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-01-2017 14:38:30', 'dd-mm-yyyy hh24:mi:ss'), to_date('03-02-2017', 'dd-mm-yyyy'), 0, 5, '已还');
insert into BORROWBOOK (onlyno, rname, bookno, bookname, bookprice, booktype, lenddate, maxdate, actudate, finemoney, rentmoney, bookstate)
values (127, 'liangxiaoke', '1009', '平凡的世界', 23.23, '名著类', to_date('03-02-2017 15:40:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-02-2017 15:40:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('03-02-2017', 'dd-mm-yyyy'), 0, 6, '已还');
insert into BORROWBOOK (onlyno, rname, bookno, bookname, bookprice, booktype, lenddate, maxdate, actudate, finemoney, rentmoney, bookstate)
values (9, 'likui', '1007', '钢铁是怎样炼成的', 34.67, '名著类', to_date('17-01-2017 21:10:06', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-01-2017', 'dd-mm-yyyy'), to_date('03-02-2017', 'dd-mm-yyyy'), 0, 5, '已还');
insert into BORROWBOOK (onlyno, rname, bookno, bookname, bookprice, booktype, lenddate, maxdate, actudate, finemoney, rentmoney, bookstate)
values (4, 'likui', '1008', '时间简史', 76.34, '科普类', to_date('14-01-2017 21:09:31', 'dd-mm-yyyy hh24:mi:ss'), to_date('21-01-2017 21:09:31', 'dd-mm-yyyy hh24:mi:ss'), to_date('03-02-2017', 'dd-mm-yyyy'), 0, 5, '已还');
insert into BORROWBOOK (onlyno, rname, bookno, bookname, bookprice, booktype, lenddate, maxdate, actudate, finemoney, rentmoney, bookstate)
values (7, 'likui', '1001', '三国演义', 24.5, '名著类', to_date('11-01-2017 21:09:54', 'dd-mm-yyyy hh24:mi:ss'), to_date('25-01-2017', 'dd-mm-yyyy'), to_date('03-02-2017', 'dd-mm-yyyy'), 0, 5, '已还');
insert into BORROWBOOK (onlyno, rname, bookno, bookname, bookprice, booktype, lenddate, maxdate, actudate, finemoney, rentmoney, bookstate)
values (2, 'likui', '1001', '三国演义', 24.5, '名著类', to_date('12-01-2017 21:09:14', 'dd-mm-yyyy hh24:mi:ss'), to_date('19-01-2017 21:09:14', 'dd-mm-yyyy hh24:mi:ss'), to_date('03-02-2017', 'dd-mm-yyyy'), 0, 5, '已还');
insert into BORROWBOOK (onlyno, rname, bookno, bookname, bookprice, booktype, lenddate, maxdate, actudate, finemoney, rentmoney, bookstate)
values (5, 'likui', '1003', '西游记', 45.23, '名著类', to_date('08-01-2017 21:09:35', 'dd-mm-yyyy hh24:mi:ss'), to_date('15-01-2017 21:09:35', 'dd-mm-yyyy hh24:mi:ss'), to_date('03-02-2017', 'dd-mm-yyyy'), 0, 5, '已还');
insert into BORROWBOOK (onlyno, rname, bookno, bookname, bookprice, booktype, lenddate, maxdate, actudate, finemoney, rentmoney, bookstate)
values (8, 'likui', '1002', '水浒传', 34.5, '名著类', to_date('07-01-2017 21:09:57', 'dd-mm-yyyy hh24:mi:ss'), to_date('14-01-2017 21:09:57', 'dd-mm-yyyy hh24:mi:ss'), to_date('03-02-2017', 'dd-mm-yyyy'), 0, 5, '已还');
insert into BORROWBOOK (onlyno, rname, bookno, bookname, bookprice, booktype, lenddate, maxdate, actudate, finemoney, rentmoney, bookstate)
values (10, 'likui', '1012', '爱因斯坦相对论', 12.21, '科普类', to_date('05-01-2017 21:10:13', 'dd-mm-yyyy hh24:mi:ss'), to_date('12-01-2017 21:10:13', 'dd-mm-yyyy hh24:mi:ss'), to_date('03-02-2017', 'dd-mm-yyyy'), 0, 5, '已还');
insert into BORROWBOOK (onlyno, rname, bookno, bookname, bookprice, booktype, lenddate, maxdate, actudate, finemoney, rentmoney, bookstate)
values (3, 'likui', '1009', '平凡的世界', 23.23, '名著类', to_date('04-01-2017 21:09:22', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-01-2017 21:09:22', 'dd-mm-yyyy hh24:mi:ss'), to_date('03-02-2017', 'dd-mm-yyyy'), 0, 5, '已还');
insert into BORROWBOOK (onlyno, rname, bookno, bookname, bookprice, booktype, lenddate, maxdate, actudate, finemoney, rentmoney, bookstate)
values (6, 'likui', '1001', '三国演义', 24.5, '名著类', to_date('02-01-2017 21:09:40', 'dd-mm-yyyy hh24:mi:ss'), to_date('16-01-2017', 'dd-mm-yyyy'), to_date('03-02-2017', 'dd-mm-yyyy'), 0, 5, '已还');
insert into BORROWBOOK (onlyno, rname, bookno, bookname, bookprice, booktype, lenddate, maxdate, actudate, finemoney, rentmoney, bookstate)
values (11, 'likui', '1013', '万物简史', 24.11, '科普类', to_date('01-01-2017 21:10:18', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-01-2017', 'dd-mm-yyyy'), to_date('03-02-2017', 'dd-mm-yyyy'), 0, 5, '已还');
insert into BORROWBOOK (onlyno, rname, bookno, bookname, bookprice, booktype, lenddate, maxdate, actudate, finemoney, rentmoney, bookstate)
values (84, 'likui', '1004', '斗破苍穹', 23.45, '玄幻类', to_date('19-01-2017 14:49:01', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-01-2017 14:49:01', 'dd-mm-yyyy hh24:mi:ss'), to_date('03-02-2017', 'dd-mm-yyyy'), 0, 5, '已还');
insert into BORROWBOOK (onlyno, rname, bookno, bookname, bookprice, booktype, lenddate, maxdate, actudate, finemoney, rentmoney, bookstate)
values (82, 'likui', '1002', '三国', 34.5, '小说类', to_date('19-01-2017 14:48:50', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-01-2017 14:48:50', 'dd-mm-yyyy hh24:mi:ss'), to_date('03-02-2017', 'dd-mm-yyyy'), 0, 5, '已还');
insert into BORROWBOOK (onlyno, rname, bookno, bookname, bookprice, booktype, lenddate, maxdate, actudate, finemoney, rentmoney, bookstate)
values (85, 'likui', '1002', '三国', 34.5, '小说类', to_date('19-01-2017 14:49:42', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-01-2017 14:49:42', 'dd-mm-yyyy hh24:mi:ss'), to_date('03-02-2017', 'dd-mm-yyyy'), 0, 5, '已还');
insert into BORROWBOOK (onlyno, rname, bookno, bookname, bookprice, booktype, lenddate, maxdate, actudate, finemoney, rentmoney, bookstate)
values (86, 'likui', '1002', '三国', 34.5, '小说类', to_date('19-01-2017 14:51:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-01-2017 14:51:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('03-02-2017', 'dd-mm-yyyy'), 0, 5, '已还');
commit;
prompt 18 records loaded
prompt Enabling foreign key constraints for BORROWBOOK...
alter table BORROWBOOK enable constraint FK_RNAME;
prompt Enabling triggers for BORROWBOOK...
alter table BORROWBOOK enable all triggers;
set feedback on
set define on
prompt Done.
