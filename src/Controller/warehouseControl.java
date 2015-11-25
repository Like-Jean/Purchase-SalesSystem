package Controller;
/*@auther yixiu
 * 仓库信息管理控制器
 * */
import java.util.ArrayList;

import Entity.warehouse;
import Model.warehouseModel;

public class warehouseControl {
	
	private warehouseModel wm = new warehouseModel();
	private warehouse wh = new warehouse();
	//private ArrayList<warehouse> whList = new ArrayList<warehouse>();
	
	public void add(warehouse wh){
		wm.add(wh);
	}
	
	public void del(String id){
		wm.delete(id);
	}

	public ArrayList<String> getWareId(){
		ArrayList<String> wareId = new ArrayList<String>();
		ArrayList<warehouse> acctArry = new ArrayList<warehouse>();
		acctArry = wm.select();
		
		int num = acctArry.size();
		for(int i = 0;i<num;i++){
			wareId.add(acctArry.get(i).getWarh_id());
		}
		
		return wareId;		
	}
	
	public void update(warehouse wh){
		wm.update(wh);
	}
	
	public warehouse findById(String id){
		wh = wm.findById(id);
		return wh;
	}
}
