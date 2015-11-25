package Entity;

public class quotationGoodsList {
	private String quoId;//对应报价单号
	private String goods_id;//商品id
	private int goods_quantity;//商品数量
	private float quotedPrice;//报价
	private float otherCost;//其他费用金额
	
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
