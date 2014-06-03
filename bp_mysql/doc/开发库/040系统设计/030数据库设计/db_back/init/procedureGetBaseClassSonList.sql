CREATE PROCEDURE procedureGetBaseClassSonList(cls_scope int,parent_id int) 
begin
    declare temp_level int default 1;
    declare cnt int default 0;

	create temporary table if not exists table_temp(CLS_ID int(11), CLS_SCOPE int(2), CLS_NAME varchar(48), PAR_ID int(11),  ROOT_ID int(11), 
		 ORDER_VALUE int(11), IS_LOCK int(1) , IS_DEL int(1) , temp_level int);
		
    create temporary table if not exists table_base(CLS_ID int(11), CLS_SCOPE int(2), CLS_NAME varchar(48), PAR_ID int(11),  ROOT_ID int(11),
																ORDER_VALUE int(11), IS_LOCK int(1) , IS_DEL int(1) , temp_level int);
 
    insert into table_temp select a.CLS_ID, a.CLS_SCOPE, a.CLS_NAME, a.PAR_ID, a.ROOT_ID, a.ORDER_VALUE, a.IS_LOCK, a.IS_DEL, temp_level 
			from BASE_CLASS a where a.IS_DEL = 0 and a.PAR_ID = parent_id and a.CLS_SCOPE = cls_scope;
 
    select row_count() into cnt;
    insert into table_base select * from table_temp;
 
    while cnt > 0 do
        set temp_level = temp_level + 1;
        truncate table table_temp;
        insert into table_temp select a.CLS_ID, a.CLS_SCOPE, a.CLS_NAME, a.PAR_ID, a.ROOT_ID, a.ORDER_VALUE, a.IS_LOCK, a.IS_DEL, temp_level
				from BASE_CLASS a, table_base b where a.PAR_ID = b.cls_id and a.IS_DEL = 0 and b.temp_level = temp_level - 1;
        select row_count() into cnt;
        insert into table_base select * from table_temp;
    end while;

    insert into table_base select a.CLS_ID, a.CLS_SCOPE, a.CLS_NAME, a.PAR_ID, a.ROOT_ID, a.ORDER_VALUE, a.IS_LOCK, a.IS_DEL, 0 
								from BASE_CLASS a where a.CLS_ID = parent_id;
    select a.*, concat(space((a.temp_level) * 2), '|--『', a.CLS_NAME, '』') CLS_NAME_TREE from table_base a order by a.order_value;
 
    drop table table_temp;
    drop table table_base;
end
-- call procedureGetBaseClassSonList(1, -1);