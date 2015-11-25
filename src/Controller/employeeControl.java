package Controller;
/*@auther yixiu
 * 员工信息管理控制器
 * */
import java.util.ArrayList;

import Entity.employee;
import Entity.warehouse;
import Model.employeeModel;

public class employeeControl {
	
	private employee epl = new employee();
	private employeeModel em = new employeeModel();
	
	public void add(employee e){
		em.add(e);
	}
	
	public ArrayList<String> getEplId(){
		ArrayList<String> eplId = new ArrayList<String>();
		ArrayList<employee> acctArry = new ArrayList<employee>();
		acctArry = em.select();
		
		int num = acctArry.size();
		for(int i = 0;i<num;i++){
			eplId.add(acctArry.get(i).getEmpl_id());
		}
		
		return eplId;		
	}
	
	public employee findById(String id){
		return em.findById(id);
	}
	
	public void del(String id){
		em.delete(id);
	}
	
	public void update(employee e){
		em.update(e);
	}

}
