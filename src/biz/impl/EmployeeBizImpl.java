package biz.impl;

import java.util.List;

import biz.EmployeeBiz;
import dao.EmployeeDao;
import dao.impl.EmployeeDaoImpl;
import domain.Employee;
import domain.Information;

public class EmployeeBizImpl implements EmployeeBiz {
	private EmployeeDao emp;
	public EmployeeBizImpl() {
		super();
		this.emp = new EmployeeDaoImpl();
	}

	@Override
	public String addEmpliyee(int id, String name, String pswd, int priority) {
		return this.emp.insertEmployee(new Employee(id, name, pswd, priority))?"添加成功！":"添加失败";
	}

	@Override
	public Employee selectById(int id) {
		
		return emp.selectById(id);
	}
	
	@Override
	public boolean changePass(Employee e, String pswd) {
		return emp.changePswd(e.getEmId(), pswd);
	}

	@Override
	public String addApply(int employeeId, int infoId, String applyTime, String doTime, int days, String applyType,
			String reason) {
		
		return this.emp.insertInformation(new Information(employeeId, infoId, applyTime, doTime, days, applyType, reason))?"添加成功！":"添加失败";
	}

	@Override
	public List<Information> selectApply(int employeeId) {
		// TODO Auto-generated method stub
		return emp.selectAllInfomation(employeeId);
	}

	@Override
	public Information seAppById(int infoId) {
		// TODO Auto-generated method stub
		return null;
	}

}
