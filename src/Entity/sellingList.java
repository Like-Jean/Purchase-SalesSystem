package Entity;

public class sellingList {
	private String selling_id;
	private String selling_date;
	private float selling_totalPrice;
	private String unit_id;
	private String acc_id;
	//æ≠ ÷»À
	private String handler;
	
	public String getSelling_id(){
		return selling_id;
	}
	public void setSelling_id(String selling_id) {
		this.selling_id = selling_id;
	}
	public String getSelling_date() {
		return selling_date;
	}
	public void setSelling_date(String sell_date) {
		this.selling_date = sell_date;
	}
	public float getSelling_totalPrice() {
		return selling_totalPrice;
	}
	public void setSelling_totalPrice(float sell_totalPrice) {
		this.selling_totalPrice = sell_totalPrice;
	}
	public String getUnit_id() {
		return unit_id;
	}
	public void setUnit_id(String unit_id) {
		this.unit_id = unit_id;
	}
	public String getSelling_handler(){
		return handler;
	}
	public void setSelling_handler(String handler){
		this.handler=handler;
	}
	public String getAcc_id() {
		return acc_id;
	}
	public void setAcc_id(String acc_id) {
		this.acc_id = acc_id;
	}
}
