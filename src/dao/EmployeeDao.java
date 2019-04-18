package dao;

import java.util.List;

import domain.Employee;
import domain.Information;

public interface EmployeeDao {
	//增加雇员
	public boolean insertEmployee(Employee e);
	//显示所有雇员
	public List<Employee> selectAllEmployee();
	//根据ID查询的方法
	public Employee selectById(int id);
	//创建一个删除雇员的方法
	public boolean deleteById(int id);
	//更改密码的方法
	public boolean changePswd(int id,String pswd);
	//请假的方法
	public boolean insertInformation(Information info);
	//显示所有假条的方法
	public List<Information> selectAllInfomation(int emId);
	//根据ID查假条
	public Information seAppById(int infoId);
	
}
