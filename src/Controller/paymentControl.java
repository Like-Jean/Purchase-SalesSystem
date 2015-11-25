package Controller;
/*@author Like
 * version 1.0
 * ���Ƹ����¼�롢��ѯ��ɾ��
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
     private employee financeWorker =null;//��¼��ǰ�����Ĳ�����Ա
     private boolean permission = false;//���Ƶ�ǰ������Ա�Ƿ���Ȩ�޽��в���
     private float totalPrice = 0;
     private String acct_id;
     //�ҳ����ݿ��е�������λ��
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
     
   //�ҳ����ݿ��е��˻���
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
     //¼�븶�
     public boolean entryPayment(payment pay){
    	 if(permission==false) return false;
    	 if(purm.findByPurch_id(pay.getMatchingMenu())!=null){  //�ж���ص����Ƿ��ڽ�������
    		 pm.add(pay);
    		 return true;
    	 }
    	 return false;
     }
     
     //��ѯ���
     public ArrayList<payment> checkPayment(payment pay){
    	 ArrayList<payment> showList = new ArrayList<payment>();
    	 if(permission==false) return showList;
    	 if(pay.getPaymentId()!=null&&!(pay.getPaymentId().equals(""))){ //�ж��Ƿ���Ҫͨ�����������ѯ����ͬ
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
     
     //ɾ�����
     public void delete(String paymentID){
    	 if(permission==false) return;
    	 pm.delete(paymentID);
     }
     
     //���¸��
     public void update(payment pay){
    	 if(permission==false) return;
    	 pm.update(pay);
     }
     //���������ԱID������Ա�����н��в�ѯ��˶�
     public boolean checkOutPermissions(String inputID){
    	 financeWorker=em.findById(inputID);
    	 if(financeWorker.getEmpl_department().equals("Finance")){  //�ж����Ƿ�Ϊ������Ա
    		 permission = true;
    	 }
    	 return false;
     }
     //��ȡ������
     public void setTotalPayment(float totalpayment){
    	 totalPrice=totalpayment;
     }
 	//�������Ƿ��㹻
 	public boolean checkBalance(String acc_id){
 		accountModel acc=new accountModel();
 		if(acc.findById(acc_id).getAcc_balance() > totalPrice)
 			return true;
 		return false;
 	}
 	//����
 		public void pay(){
 			account acc = new account();
 			acc = acm.findById(acct_id);
 			float balance = acc.getAcc_balance();
 			balance-=totalPrice;
 			acc.setAcc_balance(balance);
 			acm.update(acc);
 		}
}
