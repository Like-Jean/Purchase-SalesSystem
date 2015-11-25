package Entity;

import java.util.Date;
import java.text.SimpleDateFormat;

public class purchaseList {

	private String purch_id;
	private String purch_date;
	private float purch_totalPrice;
	private String unit_id;
	private String acc_id;
	public String getPurch_id() {
		return purch_id;
	}
	public void setPurch_id(String purch_id) {
		this.purch_id = purch_id;
	}
	public String getPurch_date() {
		return purch_date;
	}
	public void setPurch_date(String purch_date) {
		this.purch_date = purch_date;
	}
	public void setPurch_date() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  		
		Date date1 = new Date();
		String day1=sdf.format(date1);		
		this.purch_date = day1;
	}	
	public float getPurch_totalPrice() {
		return purch_totalPrice;
	}
	public void setPurch_totalPrice(float purch_totalPrice) {
		this.purch_totalPrice = purch_totalPrice;
	}
	public String getUnit_id() {
		return unit_id;
	}
	public void setUnit_id(String unit_id) {
		this.unit_id = unit_id;
	}
	public String getAcc_id() {
		return acc_id;
	}
	public void setAcc_id(String acc_id) {
		this.acc_id = acc_id;
	}

}
