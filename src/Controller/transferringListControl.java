package Controller;
/*
 * version 1.0 
 * ���۵�controller*/
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
	
	//�ҳ���Ʒ���е���Ʒ������
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
		//�ҳ���Ʒ���е���ƷID
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
		//�ҳ����ݿ��вֿ��
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
		//ͨ���������ŷ��ص�����
		public transferringList showTransferringList(String transferringListId){
			
			transferringList tsl = tlm.findBytransferringListId(transferringListId);
			
			return tsl;
		}
		//����һ��������
		public boolean addTransferringList(transferringList tsl){
			tlm.update(tsl);
			//�����ֿ���٣�����ֿ�����
			gm.reduce2(tsl.getGoods_name(), tsl.getOutWarehouseId(), tsl.getQuantities());
			gm.increase2(tsl.getGoods_name(), tsl.getInWarehouseId(), tsl.getQuantities());
			return true;
		}
		//�ҳ����ݿ��еĲ�����Ա��ID
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
	     //�ԱȲֿ��и�����Ʒ���Ƶ���Ʒ�������û���������������û��������������򷵻�false
	     public boolean enoughQuantities(transferringList list){
	    	return gm.getQuantity2(list.getGoods_name(), list.getOutWarehouseId())>=list.getQuantities();
	     }
}