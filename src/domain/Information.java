package domain;

public class Information {
	private int employeeId;
	private int infoId;
	private String applyTime;
	private String doTime;
	private int days;
	private String applyType;
	private String reason;
	public Information(int employeeId,int infoId, String applyTime, String doTime, int days, String applyType, String reason) {
		super();
		this.employeeId=employeeId;
		this.infoId = infoId;
		this.applyTime = applyTime;
		this.doTime = doTime;
		this.days = days;
		this.applyType = applyType;
		this.reason = reason;
	}
	public Information() {
		super();
	}
	
	public int getInfoId() {
		return infoId;
	}
	public void setInfoId(int infoId) {
		this.infoId = infoId;
	}
	public String getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}
	public String getDoTime() {
		return doTime;
	}
	public void setDoTime(String doTime) {
		this.doTime = doTime;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public String getApplyType() {
		return applyType;
	}
	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.employeeId+"\t"+this.infoId+"\t"+this.applyTime+"\t"+this.doTime+"\t"+this.days+"\t"+this.applyType+"\t"+this.reason;
	}
	public String show() {
		return this.infoId+"#"+this.applyTime+"#"+this.doTime+"#"+this.days+"#"+this.applyType+"#"+this.reason;
	}
	public int getEmployee() {
		return employeeId;
	}
	public void setEmployee(int employeeId) {
		this.employeeId = employeeId;
	}
}
