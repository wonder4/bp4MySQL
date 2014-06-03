CREATE PROCEDURE procedureGetBaseClassParentList(cls_scope int, son_id int) 
begin
    declare cnt int default 0;

	create temporary table if not exists table_temp(CLS_ID int(11), CLS_SCOPE int(2), CLS_NAME varchar(48), PAR_ID int(11),  ROOT_ID int(11), 
		 ORDER_VALUE int(11), IS_LOCK int(1) , IS_DEL int(1));
		
    create temporary table if not exists table_base(CLS_ID int(11), CLS_SCOPE int(2), CLS_NAME varchar(48), PAR_ID int(11),  ROOT_ID int(11), 
		 ORDER_VALUE int(11), IS_LOCK int(1) , IS_DEL int(1));
 
    insert into table_temp select a.CLS_ID, a.CLS_SCOPE, a.CLS_NAME, a.PAR_ID, a.ROOT_ID, a.ORDER_VALUE, a.IS_LOCK, a.IS_DEL 
							from BASE_CLASS a where a.IS_DEL = 0 and a.CLS_ID = (select par_id from BASE_CLASS where CLS_ID = son_id and CLS_SCOPE = cls_scope);
 
    select row_count() into cnt;
    insert into table_base select * from table_temp;
 
    while cnt > 0 do
        truncate table table_temp;
        insert into table_temp select a.CLS_ID, a.CLS_SCOPE, a.CLS_NAME, a.PAR_ID, a.ROOT_ID, a.ORDER_VALUE, a.IS_LOCK, a.IS_DEL
								from BASE_CLASS a where a.CLS_ID = (select PAR_ID from table_base order by CLS_ID LIMIT 0, 1);
        select row_count() into cnt;
        insert into table_base select * from table_temp;
    end while;

    insert into table_base select a.CLS_ID, a.CLS_SCOPE, a.CLS_NAME, a.PAR_ID, a.ROOT_ID, a.ORDER_VALUE, a.IS_LOCK, a.IS_DEL 
				from BASE_CLASS a where a.CLS_ID = son_id;
    select a.* from table_base a order by CLS_ID;
 
    drop table table_temp;
    drop table table_base;
end
-- call procedureGetBaseClassParentList(1, 10001);