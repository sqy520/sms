package dao.view;

public class View {
	//登录
	public void login() {
		System.out.println("******员工管理系统******");
		System.out.println();
		System.out.println("请登录：");
	}
	public void welcome() {
			System.out.println(">>>员工信息管理");
			System.out.println();
			System.out.println("1.查看个人信息");
			System.out.println("2.修改密码");
			System.out.println("3.请假");
			System.out.println("4.查看假条");
			System.out.println("0.退出");
	}
}
