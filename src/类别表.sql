drop database if exists shop;

create database shop default character set utf8;

use shop;

drop table if exists category;

create table category
(
   /* 类别编号,自动增长 */
   id  int not null auto_increment,
   /* 类别名称 */
   type varchar(20),
   /* 类别是否为热点类别,热点类别才有可能显示在首页 */
   hot  bool default false,
   /* 设置类别编号为主键 */
   primary key (id)
);


select * from category;

insert into td_user(USERNAME,PASSWORD,Phuone,MONEY,ROLE,IOCN,CREATETIME) values();

insert into category(type,hot,u_id) values('男装',0,1);
DELETE FROM Category  WHERE id in (4)


select product0_.id as id1_0_, category1_.id as id0_1_, product0_.name as name1_0_, product0_.price as price1_0_, product0_.pic as pic1_0_, product0_.remark as remark1_0_, product0_.xremark as xremark1_0_, product0_.date as date1_0_, product0_.commend as commend1_0_, product0_.open as open1_0_, product0_.cid as cid1_0_, category1_.type as type0_1_, category1_.hot as hot0_1_, category1_.u_id as u4_0_1_ from shop.product product0_ left outer join category category1_ on product0_.cid=category1_.id where product0_.name like % %  limit 5

 select
        product0_.id as id1_0_,
        category1_.id as id0_1_,
        product0_.name as name1_0_,
        product0_.price as price1_0_,
        product0_.pic as pic1_0_,
        product0_.remark as remark1_0_,
        product0_.xremark as xremark1_0_,
        product0_.date as date1_0_,
        product0_.commend as commend1_0_,
        product0_.open as open1_0_,
        product0_.cid as cid1_0_,
        category1_.type as type0_1_,
        category1_.hot as hot0_1_,
        category1_.u_id as u4_0_1_ 
    from
        shop.product product0_ 
    left outer join
        category category1_ 
            on product0_.cid=category1_.id 
    where
        product0_.name like "% %" limit 8
