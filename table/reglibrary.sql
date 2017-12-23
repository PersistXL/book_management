prompt PL/SQL Developer import file
prompt Created on 2017年5月18日 by Administrator
set feedback off
set define off
prompt Creating REGLIBRARY...
create table REGLIBRARY
(
  rname      VARCHAR2(12) not null,
  rpassword  VARCHAR2(12),
  rjob       VARCHAR2(12) default '用户',
  rmaxborrow NUMBER(4) default 5,
  rborrowed  NUMBER(4) default 0
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
alter table REGLIBRARY
  add constraint PK_NAME primary key (RNAME)
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

prompt Disabling triggers for REGLIBRARY...
alter table REGLIBRARY disable all triggers;
prompt Deleting REGLIBRARY...
delete from REGLIBRARY;
commit;
prompt Loading REGLIBRARY...
insert into REGLIBRARY (rname, rpassword, rjob, rmaxborrow, rborrowed)
values ('admin', '123456', '管理员', 0, 0);
insert into REGLIBRARY (rname, rpassword, rjob, rmaxborrow, rborrowed)
values ('liubo', '123456', '用户', 10, 0);
insert into REGLIBRARY (rname, rpassword, rjob, rmaxborrow, rborrowed)
values ('jinerbo', '123456', '用户', 10, 0);
insert into REGLIBRARY (rname, rpassword, rjob, rmaxborrow, rborrowed)
values ('liangxiaoke', '123456', '用户', 10, -1);
insert into REGLIBRARY (rname, rpassword, rjob, rmaxborrow, rborrowed)
values ('qingeng', '123456', '用户', 10, 0);
insert into REGLIBRARY (rname, rpassword, rjob, rmaxborrow, rborrowed)
values ('wangxiaofeng', '123456', '用户', 10, 0);
insert into REGLIBRARY (rname, rpassword, rjob, rmaxborrow, rborrowed)
values ('likui', '123456', '用户', 11, 0);
commit;
prompt 7 records loaded
prompt Enabling triggers for REGLIBRARY...
alter table REGLIBRARY enable all triggers;
set feedback on
set define on
prompt Done.
