package Entity;
//仓库调拨单
public class transferringList {
	private String transferringListId;
	private String transferringList_date;
	private int quantities;
	private String goods_name;
	//调出仓库
	private String outWarehouseId;
	//调出仓库
	private String inWarehouseId;
	//经手人
	private String handler;
	
	public String getTransferringListId(){
		return transferringListId;
	}
	public void setTransferringListId(String transferringListId) {
		this.transferringListId = transferringListId;
	}
	public String getTransferringList_date() {
		return transferringList_date;
	}
	public void setTransferringList_date(String transferringList_date) {
		this.transferringList_date = transferringList_date;
	}
	public int getQuantities() {
		return quantities;
	}
	public void setQuantities(int quantities) {
		this.quantities = quantities;
	}
	public String getOutWarehouseId() {
		return outWarehouseId;
	}
	public void setOutWarehouseId(String outWarehouseId) {
		this.outWarehouseId = outWarehouseId;
	}
	public String getHandler(){
		return handler;
	}
	public void setHandler(String handler){
		this.handler=handler;
	}
	public String getInWarehouseId() {
		return inWarehouseId;
	}
	public void setInWarehouseId(String inWarehouseId) {
		this.inWarehouseId = inWarehouseId;
	}
	public void setGoods_name(String goods_name){
		this.goods_name=goods_name;
	}
	public String getGoods_name(){
		return goods_name;
	}
}
