package Controller;

import java.util.ArrayList;

import Entity.BusinessUnit;
import Entity.account;
import Entity.employee;
import Entity.receiveMenu;
import Entity.sellList;
import Model.BusinessUnitModel;
import Model.accountModel;
import Model.employeeModel;
import Model.receiveMenuModel;
import Model.sellListModel;

public class receiveMenuControl {
	
	private accountModel acm = new accountModel();
	private receiveMenuModel rem=new  receiveMenuModel();
	private sellListModel pm = new sellListModel();
	private employeeModel em=new employeeModel();
	private BusinessUnitModel bm=new BusinessUnitModel();
	
	
	//收款
		public void getMoney(String acc_id,float totalPrice) {
			account acc = new account();
			acc = acm.findById(acc_id);
			float balance = acc.getAcc_balance();
			balance += totalPrice;
			acc.setAcc_balance(balance);
			acm.update(acc);
		}
	
//添加收款单
	public void  addRmenu(receiveMenu recm)
	{
		rem.add(recm);
		getMoney(recm.getAcc_id(),recm.getSell_totalPrice());
	}
	
	
//通过收款单号显示收款信息
	public receiveMenu showMessage(String recm_id)
	{
		receiveMenu a=new receiveMenu();
		a=rem.findById(recm_id);
		return a;
	}
	
//通过对应单据显示信息
	public sellList  showByMatchingMenu(String sell_id)
	{
		sellList s=new sellList();
		s=pm.findBySell_id(sell_id);
		return s;
	}

	//找出数据库中对应单据号
	public ArrayList<String> checkMatchingMenu(){
		
		ArrayList<String> MenuNum = new ArrayList<String>();
		ArrayList<sellList> acctArry = new ArrayList<sellList>();
		acctArry = pm.select();
		
		int num = acctArry.size();
		for(int i = 0;i<num;i++){
			MenuNum.add(acctArry.get(i).getSell_id());
		}
		
		return MenuNum;
	}
	
	//找出数据库中对应财务部人员姓名
	public ArrayList<String> checkFinanceName(){
		
		ArrayList<String> nameNum = new ArrayList<String>();
		ArrayList<employee> acctArry = new ArrayList<employee>();
		acctArry = em.findByDepartment("财务部              ");
		
		int num = acctArry.size();
	
		for(int i = 0;i<num;i++){
			nameNum.add(acctArry.get(i).getEmpl_name());
		}
		
		return nameNum;
	}
	
	public ArrayList<receiveMenu> getAllMenu()
	{
		ArrayList<receiveMenu> recMenus=new ArrayList<receiveMenu>();
		recMenus=rem.select();
		return recMenus;
		
	}
	
	//通过单位ID找单位
	public BusinessUnit findUnitById(String unitId)
	{	
		BusinessUnit bs=new BusinessUnit();
	bs=bm.findById(unitId);
	return bs;

}
}