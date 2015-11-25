package Controller;
/*@author Like
 * version 1.0
 * ���ڲ�����Ա���ڲ�ѯ����ӡ�����˻��ʽ𱨱�
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
	
	private employee financeWorker = null;//��¼��ǰ�����Ĳ�����Ա
    private boolean permission = false;//���Ƶ�ǰ������Ա�Ƿ���Ȩ�޽��в���
	
    //�������в�����Ա
	public ArrayList<String> checkFinaceWorker() {

		ArrayList<String> FinaceWorker = new ArrayList<String>();
		ArrayList<employee> acctArry = new ArrayList<employee>();
		acctArry = em.findByDepartment("����              ");

		int num = acctArry.size();
		for (int i = 0; i < num; i++) {			
			FinaceWorker.add(acctArry.get(i).getEmpl_id());
		}

		return FinaceWorker;
	}

    //���������˻�
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

	//���õ�ǰ�����Ĳ�����Ա���˻���Ȩ��
	public void setWorkerAndPermission(String workerId){
		this.accountId = accountId;
		permission = true;
	}
	
	public void checkAccountCapital(String startDate1,String endDate2,String account){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		this.startDate = startDate1;
		this.endDate = endDate2;
		
		ArrayList<String> capitalList = new ArrayList<String>();//����ͳ��ÿ����֧��¼
		String bufferRecord = new String(); //�����ݴ������˻�ÿ����֧��¼
		
		totalExpend = 0;
		ArrayList<payment> paymentList = new ArrayList<payment>();//����֧����¼
		paymentList = pm.findByPaymentDates(startDate, endDate);
		int size = paymentList.size();
		for(int i=0;i<size;i++){
			if(paymentList.get(i).getAccId().equals(account)){
				bufferRecord = paymentList.get(i).getPaymentDate()+"  "+paymentList.get(i).getMatchingMenu()+"  ֧����"+paymentList.get(i).getTotalPayment();
				capitalList.add(bufferRecord);
				totalExpend = totalExpend+paymentList.get(i).getTotalPayment();
			}
		}
		
		totalIncome = 0;
		ArrayList<receiveMenu> receiveList = new ArrayList<receiveMenu>();//���������¼
		receiveList = rm.findByReceiveDates(startDate, endDate);
		size = receiveList.size();
		for(int i=0;i<size;i++){
			if(receiveList.get(i).getAcc_id().equals(account)){
				bufferRecord = receiveList.get(i).getRec_date()+"  "+receiveList.get(i).getMatchingMenu()+"  ���룺"+receiveList.get(i).getSell_totalPrice()+"\n";
				capitalList.add(bufferRecord);
				totalIncome = totalIncome+receiveList.get(i).getSell_totalPrice();
			}
		}
		
		capital = capitalList.get(0);//��capitalList�е�����ת��capital��һ��String��
		for(int i=1;i<paymentList.size()+receiveList.size();i++)
		{
			capital = capital + capitalList.get(i);
		}
		
		String instanceDate = new String();//��ȡ��ǰ����
		instanceDate = sdf.format(sdf.getDateInstance());
		float totalIncome1=0,totalExpend1=0;//���Դ洢�ӽ������ڵ���ǰ���ڵ���֧����
		
		paymentList = pm.findByPaymentDates(endDate, instanceDate);//ͨ������ӽ������ڵ���ǰ���ڵ���֧�������Ƴ����ڽ�������ʱ���˻����
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
		
		endAmount = am.findById(account).getAcc_balance()-totalExpend1+totalIncome1;//ͨ����ǰ�˻��������������ʱ���˻����
		initialAmount = endAmount-totalExpend+totalIncome;//ͨ���������ڵ��˻���������ʼ���ڵ��˻����
	}
	
	//��ȡ�ڳ����
	public String getInitialAmount(){
		String initial = new String();
		initial = initialAmount+"";
		return initial;
	}
	
	//��ȡ��ĩ���
	public String getEndAmount(){
		String end = new String();
		end = endAmount+"";
		return end;
	}
	
	//��ȡ������
	public String getTotalIncome(){
		String income = new String();
		income = totalIncome+"";
		return income;
	}
	
	//��ȡ��֧��
	public String getTotalExpend(){
		String expand = new String();
		expand = totalExpend+"";
		return expand;
	}
	
	//��ȡ������ϸ
	public String getCapital(){
		return capital;
	}
}
	
