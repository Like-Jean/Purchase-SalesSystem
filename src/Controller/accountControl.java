package Controller;
/*@auther yixiu
 * 账户信息管理控制器
 * */
import java.util.ArrayList;

import Entity.account;
import Model.accountModel;

public class accountControl {
	
	private account acc = new account();
	private accountModel am = new accountModel();
	
	public void add(account acc){
		acc.setAcc_balance(0);
		am.add(acc);
	}
	
	public void del(String id){
		am.delete(id);
	}
	
	public void update(account acc){
		acc.setAcc_balance(0);
		am.update(acc);
		
	}
	
	public ArrayList<String> getAccountId(){
		ArrayList<String> wareId = new ArrayList<String>();
		ArrayList<account> acctArry = new ArrayList<account>();
		acctArry = am.select();
		
		int num = acctArry.size();
		for(int i = 0;i<num;i++){
			wareId.add(acctArry.get(i).getAcc_id());
		}
		
		return wareId;		
	}	
	
	public account findById(String id){
		acc = am.findById(id);
		return acc;
	}

}
