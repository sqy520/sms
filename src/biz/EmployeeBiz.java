package biz;

import java.util.List;

import domain.Employee;
import domain.Information;

public interface EmployeeBiz {
	//增加雇员的业务
	public String addEmpliyee(int id,String name,String pswd, int priority);
	//查询个人信息的业务
	public Employee selectById(int id);
	//更改密码的业务
	public boolean changePass(Employee e,String pswd);
	//创建请假的业务
	public String addApply(int employeeId,int infoId, String applyTime, String doTime, int days, String applyType, String reason);
	//创建查看假条的业务
	public List<Information> selectApply(int employeeId);
	public Information seAppById(int infoId);
}
