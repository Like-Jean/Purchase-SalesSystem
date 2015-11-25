package Controller;
/*
 * version 1.0 
 * 销售单controller*/
import java.util.ArrayList;

import Entity.employee;
import Entity.goods;
import Entity.sellingGoodsList;
import Entity.transferringList;
import Entity.sellingList;
import Entity.warehouse;
import Model.employeeModel;
import Model.transferringListModel;
import Model.goodsModel;
import Model.warehouseModel;

public class transferringListControl {

	private goodsModel gm = new goodsModel();
	private transferringListModel tlm = new transferringListModel();
	private warehouseModel wm = new warehouseModel();
	private employeeModel em=new employeeModel();
	
	private goods goodsEntity = null; 
	private transferringList transferringListEntity = null;
	
	//找出商品表中的商品的名字
		public ArrayList<String> findProductName(){
			ArrayList<String> productName = new ArrayList<String>();
			ArrayList<goods> acctArry = new ArrayList<goods>();
			acctArry = gm.select();
			
			int num = acctArry.size();
			for(int i = 0;i<num;i++){
				productName.add(acctArry.get(i).getGoods_name());
			}
			
			return productName;
		}
		//找出商品表中的商品ID
		public ArrayList<String> findProductId(){
			ArrayList<String> productId = new ArrayList<String>();
			ArrayList<goods> acctArry = new ArrayList<goods>();
			acctArry = gm.select();
			
			int num = acctArry.size();
			for(int i = 0;i<num;i++){
				productId.add(acctArry.get(i).getGoods_id());
			}
			
			return productId;
		}
		//找出数据库中仓库号
		public ArrayList<String> checkWarhId(){
			
			ArrayList<String> WarhId = new ArrayList<String>();
			ArrayList<warehouse> acctArry = new ArrayList<warehouse>();
			acctArry = wm.select();
			
			int num = acctArry.size();
			for(int i = 0;i<num;i++){
				WarhId.add(acctArry.get(i).getWarh_id());
			}
			
			return WarhId;
		}
		//通过调拨单号返回调拨单
		public transferringList showTransferringList(String transferringListId){
			
			transferringList tsl = tlm.findBytransferringListId(transferringListId);
			
			return tsl;
		}
		//增加一条调拨单
		public boolean addTransferringList(transferringList tsl){
			tlm.update(tsl);
			//调出仓库减少，调入仓库增加
			gm.reduce2(tsl.getGoods_name(), tsl.getOutWarehouseId(), tsl.getQuantities());
			gm.increase2(tsl.getGoods_name(), tsl.getInWarehouseId(), tsl.getQuantities());
			return true;
		}
		//找出数据库中的财务人员的ID
	     public ArrayList<String> findEmployeeId(){
	 		
	 		ArrayList<String> EmployeeId = new ArrayList<String>();
	 		ArrayList<employee> acctArry = new ArrayList<employee>();
	 		acctArry = em.select();
	 		
	 		int num = acctArry.size();
	 		for(int i = 0;i<num;i++){
	 			EmployeeId.add(acctArry.get(i).getEmpl_id());
	 		}
	 		
	 		return EmployeeId;
	 	}
	     //对比仓库中给定商品名称的商品数量与用户输入数量，如果用户输入数量过大，则返回false
	     public boolean enoughQuantities(transferringList list){
	    	return gm.getQuantity2(list.getGoods_name(), list.getOutWarehouseId())>=list.getQuantities();
	     }
}