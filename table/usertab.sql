prompt PL/SQL Developer import file
prompt Created on 2017Äê5ÔÂ18ÈÕ by Administrator
set feedback off
set define off
prompt Creating USERTAB...
create table USERTAB
(
  userno    NUMBER not null,
  uname     VARCHAR2(10),
  upassword NUMBER
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
create unique index UPASSWORD on USERTAB (UPASSWORD)
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
create unique index USERNO on USERTAB (USERNO)
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
alter table USERTAB
  add constraint PK_NO primary key (USERNO);
alter table USERTAB
  add constraint UK_WORD unique (UPASSWORD);

prompt Disabling triggers for USERTAB...
alter table USERTAB disable all triggers;
prompt Deleting USERTAB...
delete from USERTAB;
commit;
prompt Loading USERTAB...
insert into USERTAB (userno, uname, upassword)
values (1, 'kobe', 24);
insert into USERTAB (userno, uname, upassword)
values (5, 'tmac', 1);
insert into USERTAB (userno, uname, upassword)
values (41, 'xiao', 2);
insert into USERTAB (userno, uname, upassword)
values (42, 'liang', 1989);
insert into USERTAB (userno, uname, upassword)
values (101, 'jordan', 23);
insert into USERTAB (userno, uname, upassword)
values (24, 'yaoming', 11);
insert into USERTAB (userno, uname, upassword)
values (25, 'wade', 3);
commit;
prompt 7 records loaded
prompt Enabling triggers for USERTAB...
alter table USERTAB enable all triggers;
set feedback on
set define on
prompt Done.
