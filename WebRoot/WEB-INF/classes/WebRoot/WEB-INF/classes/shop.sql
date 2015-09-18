drop table if exists forder;


drop table if exists sorder;

drop table if exists status;

drop table if exists user;

/*==============================================================*/
/* Table: forder                                                */
/*==============================================================*/
create table forder
(
   id                   int not null auto_increment,
   uid                  int,
   sid                  int,
   name                 varchar(20) not null,
   phone                varchar(20) not null,
   remak                varchar(30),
   price                float(6,2) not null,
   createdate           date not null,
   post                 varchar(6),
   address              varchar(50) not null,
   primary key (id)
);

/*==============================================================*/
/* Table: product                                               */
/*==============================================================*/


/*==============================================================*/
/* Table: sorder                                                */
/*==============================================================*/
create table sorder
(
   id                   int not null auto_increment,
   fid                  int,
   name                 varchar(20) not null,
   price                float(6,2) not null,
   number               int not null,
   primary key (id)
);

/*==============================================================*/
/* Table: status                                                */
/*==============================================================*/
create table status
(
   id                   int not null auto_increment,
   status               varchar(10) not null,
   primary key (id)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   id                   int not null auto_increment,
   login                varchar(10),
   name                 varchar(20),
   pwd                  varchar(20),
   sex                  varchar(5),
   phone                varchar(20),
   Email                varchar(20),
   primary key (id)
);

alter table forder add constraint FK_Relationship_4 foreign key (sid)
      references status (id) on delete restrict on update restrict;

alter table forder add constraint FK_user_cart foreign key (uid)
      references user (id) on delete restrict on update restrict;

alter table sorder add constraint FK_Relationship_2 foreign key (fid)
      references forder (id) on delete restrict on update restrict;

alter table sorder add constraint FK_Relationship_3 foreign key (pid)
      references product (id) on delete restrict on update restrict;
