package Controller;
/*
 * version 1.0 
 * ���۵�controller*/
import java.util.ArrayList;

import Entity.BusinessUnit;
import Entity.account;
import Entity.goods;
import Entity.sellingGoodsList;
import Entity.sellingList;
import Entity.warehouse;
import Model.BusinessUnitModel;
import Model.accountModel;
import Model.sellingGoodsListModel;
import Model.goodsModel;
import Model.sellingListModel;
import Model.warehouseModel;

public class sellingListControl {

	private goodsModel gm = new goodsModel();
	private sellingListModel sm = new sellingListModel();
	private sellingGoodsListModel slm = new sellingGoodsListModel();
	private accountModel acm = new accountModel();
	private BusinessUnitModel bum = new BusinessUnitModel();
	private warehouseModel wm = new warehouseModel();
	
	private goods goodsEntity = null; 
	private sellingGoodsList sellingGoodsListEntity = null;
	private float totalPrice = 0;
	private String acct_id;
	
	//������Ʒ�Ƿ�����������Ʒ����
	public boolean checkGoods(sellingGoodsList goo){
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

	//������۵�
	public boolean addPurh(sellingList sellingList,ArrayList<sellingGoodsList> gooLstArry){
		//Ҫ��ӵ���Ʒ��Ŀ����
		int goodsNum = gooLstArry.size();
		//������۵�
		acct_id = sellingList.getAcc_id();
		sm.add(sellingList);
		
		for(int i = 0;i<goodsNum;i++){
			sellingGoodsListEntity = gooLstArry.get(i);
			totalPrice += sellingGoodsListEntity.getGoods_price()*sellingGoodsListEntity.getGoods_quantity();			
		}
		//����ܼ�
		sellingList.setSelling_totalPrice(totalPrice);
		//�����۵�д�����ݿ�
		sm.update(sellingList);
		
		sellingGoodsListEntity = null;
		return true;
	}
    //ͨ�������۵�����ʾ��������Ϣ
	public sellingList showPurchase(String sellingList_id){
		
		sellingList slt = sm.findBySell_id(sellingList_id);
		
		return slt;
	}
    //ͨ�����۵�����ʾ��Ʒ��������Ϣ
	public ArrayList<sellingGoodsList> showGoodsList(String sellingList_id){
		ArrayList<sellingGoodsList> godLstAry = new ArrayList<sellingGoodsList>();
		godLstAry = slm.findBysellingList(sellingList_id);
		
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
	//�ҳ���Ʒ���е���Ʒ������
	public ArrayList<String> findProductName(){
		ArrayList<String> productName = new ArrayList<String>();
		ArrayList<goods> acctArry = new ArrayList<goods>();
		acctArry = gm.select();
		
		int num = acctArry.size();
		for(int i = 0;i<num;i++){
			productName.add(acctArry.get(i).getGoods_name());
		}
		
		return productName;
	}
	//�ҳ���Ʒ���е���ƷID
	public ArrayList<String> findProductId(){
		ArrayList<String> productId = new ArrayList<String>();
		ArrayList<goods> acctArry = new ArrayList<goods>();
		acctArry = gm.select();
		
		int num = acctArry.size();
		for(int i = 0;i<num;i++){
			productId.add(acctArry.get(i).getGoods_id());
		}
		
		return productId;
	}
	
}