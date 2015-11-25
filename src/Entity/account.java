package Entity;
/*@author hongyu
 *@version 1.0
 * 
 * */
public class account {
	private String acc_id;//·Ç¿Õ
	private float acc_balance;//·Ç¿Õ
	private String acc_bank;//·Ç¿Õ
	private String acc_remark;
	public String getAcc_id() {
		return acc_id;
	}
	public void setAcc_id(String acc_id) {
		this.acc_id = acc_id;
	}
	public float getAcc_balance() {
		return acc_balance;
	}
	public void setAcc_balance(float acc_balance) {
		this.acc_balance = acc_balance;
	}
	public String getAcc_bank() {
		return acc_bank;
	}
	public void setAcc_bank(String acc_bank) {
		this.acc_bank = acc_bank;
	}
	public String getAcc_remark(){
		return acc_remark;
	}
	public void setAcc_remark(String acc_remark) {
		this.acc_remark = acc_remark;
	}

}
