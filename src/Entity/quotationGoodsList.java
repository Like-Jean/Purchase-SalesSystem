package Entity;

public class quotationGoodsList {
	private String quoId;//��Ӧ���۵���
	private String goods_id;//��Ʒid
	private int goods_quantity;//��Ʒ����
	private float quotedPrice;//����
	private float otherCost;//�������ý��
	
	public String getQuoId() {
		return quoId;
	}
	public void setQuoId(String quoId) {
		this.quoId=quoId;
	}
	
	public String getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}
	
	public int getGoods_quantity() {
		return goods_quantity;
	}
	public void setGoods_quantity(int goods_quantity) {
		this.goods_quantity = goods_quantity;
	}
	
	public float getQuotedPrice() {
		return quotedPrice;
	}
	public void setQuotedPrice(float quotedPrice) {
		this.quotedPrice=quotedPrice;
	}
	
	public float getOtherCost() {
		return otherCost;
	}
	public void setOtherCost(float otherCost) {
		this.otherCost=otherCost;
	}
	
	

}
