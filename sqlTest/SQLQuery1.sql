use technoSolution;
insert into users(Email,Pass,RoleId) values('test','test',1);
select * from ((users inner join employee on users.EmployeeNumber = employee.EmployeeNumber) inner join department on employee.DepartmentId = department.DepartmentNumber); 
update users set Email = 'vohungvinh@gmail.com',Pass='826354',RoleId=1 where UserId=2;
select * from users where Email ='vohungvinh@gmail.com'; 
delete from users where UserId ='10s';
select Email from users where (Email='') and (Pass='');

insert into department(DepartmentName,FinanceMN,Decription) values('ke toan',null,'tinh toan');
insert into roles(Department,Decription,Name) values(1,'sdf','nhan vien');
update roles set Decription ='test2',Name ='test2' where Role =1;
insert into roles(Name,Decription) values('vohungivnh','fsdfsdf');
select * from roles;
select * from roles where Role=1;

select DepartmentName from department where DepartmentNumber =1;
delete from department where DepartmentNumber =1;
update department set DepartmentName ='bao ve',FinanceMN=13,Decription='an cuop' where DepartmentNumber='1';

select Name from employee where Name ='';
select Name from employee where EmployeeNumber=4;
select * from (employee inner join users on employee.UserId = users.UserId) ;


select employee.Name, employee.EmployeeNumber from employee,users where (employee.UserId = users.UserId) and (users.RoleId =2) and (users.UserId = 7);
insert into employee(Name,DepartmentId,Manager,UserId) values ('vohungvinh',1,10,8) ;
insert into employee(Name,DepartmentId,Manager,UserId) values ('vo hung vinh',1,1,29);

insert into financeMN(DepartmentNumber,DepartmentNumber2,EmployeeId) values (1,2,13);
select EmployeeId from financeMN where EmployeeId=10;

select * from employee where Name = '* vinh';
select EmployeeNumber,Name from employee;
select * from employee inner join users on employee.UserId = users.UserId;