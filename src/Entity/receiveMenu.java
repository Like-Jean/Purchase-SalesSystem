package Entity;

public class receiveMenu {
	private String recm_id;//�ǿ�ID
	private String rec_date;//�ǿ�����
	private String unitId;//�ǿ�������λ��
	private String unitName;//������λ����
	private String matchingMenu;//��Ӧ����
	private String handler;//������
	private float sell_totalPrice;//�տ���Ǯ��
	private String acc_id;//�տ�����
	
	

	public String getRecm_id()
	{
		return recm_id;
	}
	
	public void setRecm_id(String recm_id)
	{
		this.recm_id=recm_id;
	}
	public String getRec_date()
	{
		return rec_date;
	}
	public void setRec_date(String rec_date)
	{
		this.rec_date=rec_date;
	}
	
	public String getUnitId() {
		return unitId;
	}
	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	
	public String getMatchingMenu()
	{
		return matchingMenu;
	}
	
	public void setMatchingMenu(String matchingMenu)
	{
		this.matchingMenu=matchingMenu;
	}
	
	public String getHandler()
	{
		return handler;
	}
	
	public void setHandler(String handler)
	{
		this.handler=handler;
	}
	
	public float getSell_totalPrice() {
		return sell_totalPrice;
	}
	public void setSell_totalPrice(float sell_totalPrice) {
		this.sell_totalPrice = sell_totalPrice;
	}
	
	
	public String getAcc_id() {
		return acc_id;
	}
	public void setAcc_id(String acc_id) {
		this.acc_id = acc_id;
	}


}
