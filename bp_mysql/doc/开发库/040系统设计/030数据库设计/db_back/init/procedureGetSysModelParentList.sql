CREATE PROCEDURE procedureGetSysModelParentList(son_id int) 
begin
    declare cnt int default 0;

		create temporary table if not exists table_temp(MOD_ID int(11), PAR_ID int(11), MOD_NAME varchar(48), MOD_DESC varchar(256), MOD_URL varchar(256), MOD_LEVEL int(1),
																IS_LEAF int(1), ORDER_VALUE int(11), IS_PUBLIC int(1), IS_LOCK int(1) , IS_DEL int(1) ,SYS_SIGN int(1));
		
    create temporary table if not exists table_base(MOD_ID int(11), PAR_ID int(11), MOD_NAME varchar(48), MOD_DESC varchar(256), MOD_URL varchar(256), MOD_LEVEL int(1),
																IS_LEAF int(1), ORDER_VALUE int(11), IS_PUBLIC int(1), IS_LOCK int(1) , IS_DEL int(1) ,SYS_SIGN int(1));
 
    insert into table_temp select a.* from sys_module a where a.IS_DEL = 0 and a.mod_id = (select par_id from sys_module where MOD_ID = son_id);
 
    select row_count() into cnt;
    insert into table_base select * from table_temp;
 
    while cnt > 0 do
        truncate table table_temp;
        insert into table_temp select a.* from sys_module a where a.mod_id = (select PAR_ID from table_base order by MOD_LEVEL LIMIT 0, 1);
        select row_count() into cnt;
        insert into table_base select * from table_temp;
    end while;

    insert into table_base select a.* from sys_module a where a.MOD_ID = son_id;
    select a.* from table_base a order by mod_id;
 
    drop table table_temp;
    drop table table_base;
end
-- call procedureGetSysModelParentList(1007002000);