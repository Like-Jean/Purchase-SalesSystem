package Entity;

public class sellingGoodsList {
	
	private String sellingListId;
	private String warh_id;
	private String goods_id;
	private String goods_name;
	private int goods_quantity;
	private float goods_price;
	
	public String getSellingList_id()
	{
		return sellingListId;
	}
	public void setSellingList_id(String sellingListId)
	{
		this.sellingListId=sellingListId;
	}
	
	public String getWarh_id() 
	{
		return warh_id;
	}
	public void setWarh_id(String warh_id) 
	{
		this.warh_id = warh_id;
	}
	
	public String getGoods_id() 
	{
		return goods_id;
	}
	public void setGoods_id(String goods_id) 
	{
		this.goods_id = goods_id;
	}
	
	public String getGoods_name() 
	{
		return goods_name;
	}
	public void setGoods_name(String goods_name) 
	{
		this.goods_name = goods_name;
	}
	
	public int getGoods_quantity() {
		return goods_quantity;
	}
	public void setGoods_quantity(int goods_quantity) {
		this.goods_quantity = goods_quantity;
	}
	
	public float getGoods_price() {
		return goods_price;
	}
	public void setGoods_price(float goods_price) {
		this.goods_price = goods_price;
	}
}
