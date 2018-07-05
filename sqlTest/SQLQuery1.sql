use technoSolution;
insert into users(Email,Pass,RoleId,EmployeeNumber) values('test','test',1,13);
insert into department(DepartmentName,FinanceMN,Decription) values('ke toan',null,'tinh toan');
insert into role(Department,Decription,Name) values(1,'sdf','nhan vien');
select Name from employee where Name ='';
select Name from employee where EmployeeNumber=4;