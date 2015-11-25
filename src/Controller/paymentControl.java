package Controller;
/*@author Like
 * version 1.0
 * 控制付款单的录入、查询、删改
 */

import java.util.ArrayList;

import Entity.BusinessUnit;
import Entity.account;
import Entity.payment;
import Model.paymentModel;
import Entity.employee;
import Model.BusinessUnitModel;
import Model.accountModel;
import Model.employeeModel;
import Model.purchaseListModel;
import Entity.purchaseList;

public class paymentControl {

	private paymentModel pm = new paymentModel();
     private employeeModel em = new employeeModel();
     private purchaseListModel purm = new purchaseListModel();
     private BusinessUnitModel bum = new BusinessUnitModel();
     private accountModel acm = new accountModel();
     private employee financeWorker =null;//记录当前操作的财务人员
     private boolean permission = false;//控制当前操作人员是否有权限进行操作
     private float totalPrice = 0;
     private String acct_id;
     //找出数据库中的往来单位号
     public ArrayList<String> checkBsiUnitNum(){
 		
 		ArrayList<String> BsiUnitNums = new ArrayList<String>();
 		ArrayList<BusinessUnit> acctArry = new ArrayList<BusinessUnit>();
 		acctArry = bum.select();
 		
 		int num = acctArry.size();
 		for(int i = 0;i<num;i++){
 			BsiUnitNums.add(acctArry.get(i).getUnitId());
 		}
 		
 		return BsiUnitNums;
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
     
   //找出数据库中的账户号
 	public ArrayList<String> checkAcctNum(){
 		
 		ArrayList<String> acctNums = new ArrayList<String>();
 		ArrayList<account> acctArry = new ArrayList<account>();
 		acctArry = acm.select();
 		
 		int num = acctArry.size();
 		for(int i = 0;i<num;i++){
 			acctNums.add(acctArry.get(i).getAcc_id());
 		}
 		
 		return acctNums;
 	}
     //录入付款单
     public boolean entryPayment(payment pay){
    	 if(permission==false) return false;
    	 if(purm.findByPurch_id(pay.getMatchingMenu())!=null){  //判定相关单据是否在进货单中
    		 pm.add(pay);
    		 return true;
    	 }
    	 return false;
     }
     
     //查询付款单
     public ArrayList<payment> checkPayment(payment pay){
    	 ArrayList<payment> showList = new ArrayList<payment>();
    	 if(permission==false) return showList;
    	 if(pay.getPaymentId()!=null&&!(pay.getPaymentId().equals(""))){ //判定是否需要通过付款单号来查询，下同
    		 showList.add(pm.findByPaymentId(pay.getPaymentId()));
    	 }
    	 if(pay.getMatchingMenu()!=null&&!(pay.getMatchingMenu().equals(""))){
    		 showList = pm.findByMatchingMenu(pay.getMatchingMenu());
    	 }
    	 if (pay.getFinanceWorker()!=null&&!(pay.getFinanceWorker().equals(""))){
    		 showList = pm.findByFinaceWorker(pay.getFinanceWorker());
    	 }
    	 if(pay.getAccId()!=null&&!(pay.getAccId().equals(""))){
    		 showList = pm.findByAccId(pay.getAccId());
    	 }
    	 if(pay.getUnitId()!=null&&!(pay.getUnitId().equals(""))){
    		 showList = pm.findByUnitId(pay.getUnitId());
    	 }
    	 if(pay.getPaymentDate()!=null&&!(pay.getUnitId().equals(""))){
    		 showList = pm.findByPaymentDate(pay.getPaymentDate());
    	 }
    	 
    	 return showList;
     }
     
     //删除付款单
     public void delete(String paymentID){
    	 if(permission==false) return;
    	 pm.delete(paymentID);
     }
     
     //更新付款单
     public void update(payment pay){
    	 if(permission==false) return;
    	 pm.update(pay);
     }
     //输入财务人员ID，并在员工表中进行查询与核对
     public boolean checkOutPermissions(String inputID){
    	 financeWorker=em.findById(inputID);
    	 if(financeWorker.getEmpl_department().equals("Finance")){  //判定其是否为财务部人员
    		 permission = true;
    	 }
    	 return false;
     }
     //获取付款金额
     public void setTotalPayment(float totalpayment){
    	 totalPrice=totalpayment;
     }
 	//检查余额是否足够
 	public boolean checkBalance(String acc_id){
 		accountModel acc=new accountModel();
 		if(acc.findById(acc_id).getAcc_balance() > totalPrice)
 			return true;
 		return false;
 	}
 	//付款
 		public void pay(){
 			account acc = new account();
 			acc = acm.findById(acct_id);
 			float balance = acc.getAcc_balance();
 			balance-=totalPrice;
 			acc.setAcc_balance(balance);
 			acm.update(acc);
 		}
}
