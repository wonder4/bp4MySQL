CREATE PROCEDURE procedureGetHelpModelParentList(son_id int) 
begin
    declare cnt int default 0;

	create temporary table if not exists table_temp(ID int(11), H_MOD_ID int(11), PAR_ID int(11), MOD_NAME varchar(48), MOD_DESC varchar(256), 
		MOD_URL varchar(256), ORDER_VALUE int(11), IS_LOCK int(1) , DEL_MARK int(1));
		
    create temporary table if not exists table_base(ID int(11), H_MOD_ID int(11), PAR_ID int(11), MOD_NAME varchar(48), MOD_DESC varchar(256), 
		MOD_URL varchar(256), ORDER_VALUE int(11), IS_LOCK int(1) , DEL_MARK int(1));
 
    insert into table_temp select a.* from help_module a where a.DEL_MARK = 0 and a.h_mod_id = (select par_id from help_module where H_MOD_ID = son_id);
 
    select row_count() into cnt;
    insert into table_base select * from table_temp;
 
    while cnt > 0 do
        truncate table table_temp;
        insert into table_temp select a.* from help_module a where a.h_mod_id = (select PAR_ID from table_base order by h_mod_id LIMIT 0, 1);
        select row_count() into cnt;
        insert into table_base select * from table_temp;
    end while;

    insert into table_base select a.* from help_module a where a.H_MOD_ID = son_id;
    select a.* from table_base a order by h_mod_id;
 
    drop table table_temp;
    drop table table_base;
end
-- call procedureGetHelpModelParentList(10010000);