package Entity;

public class payment {
	private String paymentId;
	private String paymentDate;
	private String unitId;
	private String financeWorker;
	private String matchingMenu;
	private float totalPayment;
	private String accId;
	
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getUnitId() {
		return unitId;
	}
	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}
	public String getFinanceWorker() {
		return financeWorker;
	}
	public void setFinanceWorker(String financeWorker) {
		this.financeWorker = financeWorker;
	}
	public String getMatchingMenu() {
		return matchingMenu;
	}
	public void setMatchingMenu(String matchingMenu) {
		this.matchingMenu = matchingMenu;
	}
	public float getTotalPayment() {
		return totalPayment;
	}
	public void setTotalPayment(float totalPayment) {
		this.totalPayment = totalPayment;
	}
	public String getAccId() {
		return accId;
	}
	public void setAccId(String accId) {
		this.accId = accId;
	}
}
