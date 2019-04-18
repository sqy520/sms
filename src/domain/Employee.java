package domain;

public class Employee {
	//属性
	private int emId;
	private String emName;
	private String emPswd;
	private int emPriority;
	//构造方法
	public Employee(int emId, String emName, String emPswd, int emPriority) {
		super();
		this.emId = emId;
		this.emName = emName;
		this.emPswd = emPswd;
		this.emPriority = emPriority;
	}
	public Employee() {
		super();
	}
	//get、set方法
	public int getEmId() {
		return emId;
	}
	public void setEmId(int emId) {
		this.emId = emId;
	}
	public String getEmName() {
		return emName;
	}
	public void setEmName(String emName) {
		this.emName = emName;
	}
	public String getEmPswd() {
		return emPswd;
	}
	public void setEmPswd(String emPswd) {
		this.emPswd = emPswd;
	}
	public int getEmPriority() {
		return emPriority;
	}
	public void setEmPriority(int emPriority) {
		this.emPriority = emPriority;
	}
	//自定义方法
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.emId+"\t"+emName+"\t"+emPswd+"\t"+emPriority;
	}
	
	public  String show() {
		return this.emId+"#"+emName+"#"+emPswd+"#"+emPriority;
	}
}
