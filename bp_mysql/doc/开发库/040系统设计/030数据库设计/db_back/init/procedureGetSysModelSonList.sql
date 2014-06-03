CREATE PROCEDURE procedureGetSysModelSonList(parent_id int) 
begin
    declare level smallint default 1;
    declare cnt int default 0;

		create temporary table if not exists table_temp(MOD_ID int(11), PAR_ID int(11), MOD_NAME varchar(48), MOD_DESC varchar(256), MOD_URL varchar(256), MOD_LEVEL int(1),
																IS_LEAF int(1), ORDER_VALUE int(11), IS_PUBLIC int(1), IS_LOCK int(1) , IS_DEL int(1), SYS_SIGN int(1), level smallint);
		
    create temporary table if not exists table_base(MOD_ID int(11), PAR_ID int(11), MOD_NAME varchar(48), MOD_DESC varchar(256), MOD_URL varchar(256), MOD_LEVEL int(1),
																IS_LEAF int(1), ORDER_VALUE int(11), IS_PUBLIC int(1), IS_LOCK int(1) , IS_DEL int(1), SYS_SIGN int(1), level smallint);
 
    insert into table_temp select a.*, level from sys_module a where a.IS_DEL = 0 and a.PAR_ID = parent_id;
 
    select row_count() into cnt;
    insert into table_base select * from table_temp;
 
    while cnt > 0 do
        set level = level + 1;
        truncate table table_temp;
        insert into table_temp select a.*, level from sys_module a, table_base b where a.PAR_ID = b.mod_id and b.level = level - 1;
        select row_count() into cnt;
        insert into table_base select * from table_temp;
    end while;

    insert into table_base select a.*, 0 from sys_module a where a.MOD_ID = parent_id;
    select a.*, concat(space((a.level) * 2), '|--『', a.mod_name, '』') MOD_NAME_TREE from table_base a order by mod_id;
 
    drop table table_temp;
    drop table table_base;
end
-- call procedureGetSysModelSonList(1000000000);