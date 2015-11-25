package Controller;
/*@author yixiu
 * version 1.0 
 * ��������controller*/
import java.util.ArrayList;

import Entity.BusinessUnit;
import Entity.account;
import Entity.goods;
import Entity.goodsList;
import Entity.purchaseList;
import Entity.warehouse;
import Model.BusinessUnitModel;
import Model.accountModel;
import Model.goodsListModel;
import Model.goodsModel;
import Model.purchaseListModel;
import Model.warehouseModel;

public class purchaseControl {

	private goodsModel gm = new goodsModel();
	private purchaseListModel pm = new purchaseListModel();
	private goodsListModel glm = new goodsListModel();
	private accountModel acm = new accountModel();
	private BusinessUnitModel bum = new BusinessUnitModel();
	private warehouseModel wm = new warehouseModel();
	
	private goods goodsEntity = null;
	private goodsList goodsListEntity = null;
	private float totalPrice = 0;
	private String acct_id;
	
	//������Ʒ�Ƿ�������Ʒ����
	public boolean checkGoods(goodsList goo){
		//��goodsList�е���Ʒ�źͲֿ�Ų�ѯ�Ƿ��и���Ʒ����
		goodsEntity = gm.findById(goo.getGoods_id(), goo.getWarh_id());
		if(goodsEntity.getGoods_id() == null){
			//����ע��Ҫ����Ϊnull
			goodsEntity = null;
			return false;
			}
		else{
			goodsEntity = null;
			return true;
			}
	}
	//���ݽ�����Ʒ�����Ʒ����и���
	public void updateGoodsQuantityAndCost(goodsList godLst){
		//����Ʒ�����ҵ�����Ʒ
		goodsEntity = gm.findById(godLst.getGoods_id(), godLst.getWarh_id());
		int quantity = goodsEntity.getGoods_quantity();
		float cost = goodsEntity.getGoods_cost();
		int buyQuantity = godLst.getGoods_quantity();
		//�Գɱ��������¼���
		cost = (cost*quantity+godLst.getGoods_price()*buyQuantity)/(quantity+buyQuantity);		
		goodsEntity.setGoods_quantity(quantity+buyQuantity);
		
		goodsEntity.setGoods_cost(cost);
		//������д�����ݿ�
		gm.update(goodsEntity);
		goodsEntity = null;
	}
	//��ӽ�����
	public boolean addPurh(purchaseList prhLst,ArrayList<goodsList> gooLstArry){
		//Ҫ��ӵ���Ʒ��Ŀ����
		int goodsNum = gooLstArry.size();
		//��ӽ�����
		acct_id = prhLst.getAcc_id();
		pm.add(prhLst);
		
		for(int i = 0;i<goodsNum;i++){
			goodsListEntity = gooLstArry.get(i);
			totalPrice += goodsListEntity.getGoods_price()*goodsListEntity.getGoods_quantity();
			//����Ƿ���ڸ���Ʒ
			if(checkGoods(goodsListEntity) == true){
				//�ǵĻ�����ӽ���Ʒ��Ŀ��
				glm.add(goodsListEntity);

				updateGoodsQuantityAndCost(goodsListEntity);			
			}
			else{
				//���ǵĻ�������ӽ���Ʒ���е�
				goodsEntity = new goods();
				goodsEntity.setGoods_id(goodsListEntity.getGoods_id());
				goodsEntity.setGoods_name(goodsListEntity.getGoods_name());
				goodsEntity.setWarh_id(goodsListEntity.getWarh_id());
				goodsEntity.setGoods_cost(goodsListEntity.getGoods_price());
				goodsEntity.setGoods_quantity(0);
				gm.add(goodsEntity);

				goodsEntity = null;
				//��ӽ���Ʒ��Ŀ��
				glm.add(goodsListEntity);
				
				updateGoodsQuantityAndCost(goodsListEntity);
			}
		}
		//����ܼ�
		prhLst.setPurch_totalPrice(totalPrice);
		//�ѽ�����д�����ݿ�
		pm.update(prhLst);
		
		goodsListEntity = null;
		return true;
	}
    //ͨ������������ʾ��������Ϣ
	public purchaseList showPurchase(String purchase_id){
		
		purchaseList puch = pm.findByPurch_id(purchase_id);
		
		return puch;
	}
    //ͨ������������ʾ��Ʒ��������Ϣ
	public ArrayList<goodsList> showGoodsList(String purchase_id){
		ArrayList<goodsList> godLstAry = new ArrayList<goodsList>();
		godLstAry = glm.findByPurchase(purchase_id);
		
		return godLstAry;
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
	//�ҳ����ݿ���������λ��
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
	//�ҳ����ݿ��вֿ��
	public ArrayList<String> checkWarhId(){
		
		ArrayList<String> WarhId = new ArrayList<String>();
		ArrayList<warehouse> acctArry = new ArrayList<warehouse>();
		acctArry = wm.select();
		
		int num = acctArry.size();
		for(int i = 0;i<num;i++){
			WarhId.add(acctArry.get(i).getWarh_id());
		}
		
		return WarhId;
	}
	//�������Ƿ��㹻
	public boolean checkBalance(String acc_id){
		accountModel acc=new accountModel();
		if(acc.findById(acc_id).getAcc_balance() > totalPrice)
			return true;
		return false;
	}
	public float balance(String ss){
		account acc = new account();
		acc = acm.findById(ss);
		return acc.getAcc_balance();
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
