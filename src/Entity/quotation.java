package Entity;

public class quotation {
	
	private String quoId;//ID
	private String quoDate;//日期
	private String unitId;//客户ID
	private String unitName;//客户名称
	private String handler;//经手人
	private String remarks;//备注
	
	public String getQuoId() {
		return quoId;
	}
	public void setQuoId(String quoId) {
		this.quoId=quoId;
	}

	public String getQuoDate() {
		return quoDate;
	}
	public void setQuoDate(String quoDate) {
		this.quoDate=quoDate;
	}

	public String getUnitId() {
		return unitId;
	}
	public void setUnitId(String unitId) {
		this.unitId=unitId;
	}
	
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName=unitName;
	}
	
	public String getHandler() {
		return handler;
	}

	public void setHandler(String handler) {
		this.handler=handler;
	}
	
	public String getRemarks() {
		return remarks;
	}	
	public void setRemarks(String remarks) {
		this.remarks=remarks;
	}	
	
		
	

}
