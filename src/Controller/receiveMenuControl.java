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
	
	
	//�տ�
		public void getMoney(String acc_id,float totalPrice) {
			account acc = new account();
			acc = acm.findById(acc_id);
			float balance = acc.getAcc_balance();
			balance += totalPrice;
			acc.setAcc_balance(balance);
			acm.update(acc);
		}
	
//����տ
	public void  addRmenu(receiveMenu recm)
	{
		rem.add(recm);
		getMoney(recm.getAcc_id(),recm.getSell_totalPrice());
	}
	
	
//ͨ���տ����ʾ�տ���Ϣ
	public receiveMenu showMessage(String recm_id)
	{
		receiveMenu a=new receiveMenu();
		a=rem.findById(recm_id);
		return a;
	}
	
//ͨ����Ӧ������ʾ��Ϣ
	public sellList  showByMatchingMenu(String sell_id)
	{
		sellList s=new sellList();
		s=pm.findBySell_id(sell_id);
		return s;
	}

	//�ҳ����ݿ��ж�Ӧ���ݺ�
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
	
	//�ҳ����ݿ��ж�Ӧ������Ա����
	public ArrayList<String> checkFinanceName(){
		
		ArrayList<String> nameNum = new ArrayList<String>();
		ArrayList<employee> acctArry = new ArrayList<employee>();
		acctArry = em.findByDepartment("����              ");
		
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
	
	//ͨ����λID�ҵ�λ
	public BusinessUnit findUnitById(String unitId)
	{	
		BusinessUnit bs=new BusinessUnit();
	bs=bm.findById(unitId);
	return bs;

}
}