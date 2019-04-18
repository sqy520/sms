package dao.control;

import biz.EmployeeBiz;
import biz.impl.EmployeeBizImpl;
import dao.view.View;
import domain.Employee;
import util.UserInput;

public class Control {

	private View v;
	private UserInput in;
	private EmployeeBiz biz;
	private static Employee emp=new Employee();

	public Control() {
		this.v=new View();
		this.in=new UserInput();
		this.biz=new EmployeeBizImpl();
	}
	public void start() {
		do {

			if (in.getString("是否录入？(y/n)：").equals("n")) {
				break;
			}
			add();
		} while (true);
		while (true) {
			v.login();
			if (login()) {
				while (true) {
					v.welcome();
					switch (in.getInt("请选择：")) {
					case 1:
						show();
						break;
					case 2:
						change();
						break;
					case 3:

					case 0:
						System.out.println("系统退出");
						System.exit(0);
					}
				}				
			}
		}
	}

	public void add() {
		int id=in.getInt("请输入员工ID");
		if (biz.selectById(id)!=null) {
			System.out.println("该员工已经存入");
			return;
		}
		String name=in.getString("请输入员工姓名：");
		String pswd=in.getString("请输入员工密码：");
		int py=in.getInt("请输入员工级别：");
		biz.addEmpliyee(id, name, pswd, py);
	}
	
	public boolean login() {
		int id=in.getInt("请输入员工ID");
		if (biz.selectById(id)==null) {
			System.out.println("该员工不存在！");
			return false;
		}
		String pswd=in.getString("请输入员工密码：");
		if (biz.selectById(id).getEmPswd().equals(pswd)) {
			emp=biz.selectById(id);
			return true;
		}
		System.out.println("密码错误！");
		return false;

	}
	
	public void show() {
		System.out.println(">>>个人信息：");
		System.out.println(biz.selectById(emp.getEmId()).toString());
	}
	
	public void change() {
		String pswd=in.getString("请输入新的密码：");
		if (biz.changePass(emp, pswd)) {
			System.out.println("密码修改成功！");
		}else {
			System.out.println("密码修改失败！");
		}
	}
	
	

}
