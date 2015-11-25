package Controller;
/*@auther yixiu
 * 模块3的控制器
 * 处理view中的Login.java和
 * AuthoManage.java和
 * UpdatePsw.java*/
import java.util.ArrayList;

import Entity.employee;
import Entity.systemAdministrator;
import Entity.users;
import Model.employeeModel;
import Model.sysAdmModel;
import Model.usersModel;

public class Module3Controller {
	
	private usersModel um = new usersModel();
	private employeeModel em = new employeeModel();
	private sysAdmModel sm = new sysAdmModel();
	
	public boolean login(String id,String passw){
		users us = new users();
		us = um.findById(id);

		if(us.getUsers_psw().trim().equals(passw))
			return true;
		else 
			return false;
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
	
	public void add(users u){
		um.add(u);
	}
	
	public ArrayList<String> getUsId(){
		ArrayList<String> eplId = new ArrayList<String>();
		ArrayList<users> acctArry = new ArrayList<users>();
		acctArry = um.selsct();
		
		int num = acctArry.size();
		for(int i = 0;i<num;i++){
			eplId.add(acctArry.get(i).getUsers_id());
		}
		
		return eplId;		
	}	
	
	public users findById(String id){
		return um.findById(id);
	}
	
	public String getPsw(String id){
		users us = new users();
		us = um.findById(id);
		return us.getUsers_psw();
	}
	
	public void update(users u){
		um.update(u);
	}
	
	public void delete(String id){
		um.delete(id);
	}

	public void updatePsw(String id,String psw){
		um.updatePsw(id, psw);
	}

	public int getAuthority(String id){
		users us = new users();
		us = um.findById(id);
		return us.getUsers_authority();
				
	}
	public boolean login2(String id,String passw){
		systemAdministrator us = new systemAdministrator();
		us = sm.findById(id);

		if(us.getPassword().trim().equals(passw))
			return true;
		else 
			return false;
	}
}
