create table if not exists resume_test.tb_resume
(
	id bigint auto_increment
		primary key,
	name tinytext null,
	address tinytext null,
	phone tinytext null
);



INSERT INTO resume_test.tb_resume (id, name, address, phone) VALUES (1, '测试', 'chaina', '110');