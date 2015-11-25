package Controller;
/*@author Like
 * version 1.0
 * 用于财务人员定期查询并打印银行账户资金报表
 */

import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Date;

import Entity.BusinessUnit;
import Entity.employee;
import Entity.payment;
import Entity.account;
import Entity.receiveMenu;

import Model.paymentModel;
import Model.accountModel;
import Model.employeeModel;
import Model.receiveMenuModel;
public class capitalReportControl {
	private paymentModel pm = new paymentModel();
	private receiveMenuModel rm = new receiveMenuModel();
	private accountModel am = new accountModel();
	private employeeModel em = new employeeModel();
	
	private String startDate = new String();
	private String endDate = new String();
	private String accountId = new String();
	private String capital = new String();
	private float initialAmount;
	private float endAmount;
	private float totalExpend;
	private float totalIncome;
	
	private employee financeWorker = null;//记录当前操作的财务人员
    private boolean permission = false;//控制当前操作人员是否有权限进行操作
	
    //查找所有财务人员
	public ArrayList<String> checkFinaceWorker() {

		ArrayList<String> FinaceWorker = new ArrayList<String>();
		ArrayList<employee> acctArry = new ArrayList<employee>();
		acctArry = em.findByDepartment("财务部              ");

		int num = acctArry.size();
		for (int i = 0; i < num; i++) {			
			FinaceWorker.add(acctArry.get(i).getEmpl_id());
		}

		return FinaceWorker;
	}

    //查找所有账户
	public ArrayList<String> checkAccount() {

		ArrayList<String> Account = new ArrayList<String>();
		ArrayList<account> acctArry = new ArrayList<account>();
		acctArry = am.select();

		int num = acctArry.size();
		System.out.print(num);
		for (int i = 0; i < num; i++) {
			Account.add(acctArry.get(i).getAcc_id());
		}

		return Account;
	}

	//设置当前操作的财务人员、账户和权限
	public void setWorkerAndPermission(String workerId){
		this.accountId = accountId;
		permission = true;
	}
	
	public void checkAccountCapital(String startDate1,String endDate2,String account){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		this.startDate = startDate1;
		this.endDate = endDate2;
		
		ArrayList<String> capitalList = new ArrayList<String>();//用以统计每条收支记录
		String bufferRecord = new String(); //用以暂存银行账户每条收支记录
		
		totalExpend = 0;
		ArrayList<payment> paymentList = new ArrayList<payment>();//查找支出记录
		paymentList = pm.findByPaymentDates(startDate, endDate);
		int size = paymentList.size();
		for(int i=0;i<size;i++){
			if(paymentList.get(i).getAccId().equals(account)){
				bufferRecord = paymentList.get(i).getPaymentDate()+"  "+paymentList.get(i).getMatchingMenu()+"  支出："+paymentList.get(i).getTotalPayment();
				capitalList.add(bufferRecord);
				totalExpend = totalExpend+paymentList.get(i).getTotalPayment();
			}
		}
		
		totalIncome = 0;
		ArrayList<receiveMenu> receiveList = new ArrayList<receiveMenu>();//查找收入记录
		receiveList = rm.findByReceiveDates(startDate, endDate);
		size = receiveList.size();
		for(int i=0;i<size;i++){
			if(receiveList.get(i).getAcc_id().equals(account)){
				bufferRecord = receiveList.get(i).getRec_date()+"  "+receiveList.get(i).getMatchingMenu()+"  收入："+receiveList.get(i).getSell_totalPrice()+"\n";
				capitalList.add(bufferRecord);
				totalIncome = totalIncome+receiveList.get(i).getSell_totalPrice();
			}
		}
		
		capital = capitalList.get(0);//将capitalList中的数据转入capital这一个String中
		for(int i=1;i<paymentList.size()+receiveList.size();i++)
		{
			capital = capital + capitalList.get(i);
		}
		
		String instanceDate = new String();//获取当前日期
		instanceDate = sdf.format(sdf.getDateInstance());
		float totalIncome1=0,totalExpend1=0;//用以存储从截至日期到当前日期的收支总数
		
		paymentList = pm.findByPaymentDates(endDate, instanceDate);//通过计算从截至日期到当前日期的收支总数反推出处在截至日期时的账户余额
		size = paymentList.size();
		for(int i=0;i<size;i++){
			if(paymentList.get(i).getAccId().equals(account)){
				totalExpend1 = totalExpend1+paymentList.get(i).getTotalPayment();
			}
		}
		
		receiveList = rm.findByReceiveDates(endDate, instanceDate);
		size = receiveList.size();
		for(int i=0;i<size;i++){
			if(receiveList.get(i).getAcc_id().equals(account)){
				totalIncome1 = totalIncome1+receiveList.get(i).getSell_totalPrice();
			}
		}
		
		endAmount = am.findById(account).getAcc_balance()-totalExpend1+totalIncome1;//通过当前账户余额计算截至日期时的账户余额
		initialAmount = endAmount-totalExpend+totalIncome;//通过截至日期的账户余额计算起始日期的账户余额
	}
	
	//获取期初金额
	public String getInitialAmount(){
		String initial = new String();
		initial = initialAmount+"";
		return initial;
	}
	
	//获取期末金额
	public String getEndAmount(){
		String end = new String();
		end = endAmount+"";
		return end;
	}
	
	//获取总收入
	public String getTotalIncome(){
		String income = new String();
		income = totalIncome+"";
		return income;
	}
	
	//获取总支出
	public String getTotalExpend(){
		String expand = new String();
		expand = totalExpend+"";
		return expand;
	}
	
	//获取具体明细
	public String getCapital(){
		return capital;
	}
}
	
