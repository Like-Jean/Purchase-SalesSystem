package Controller;

/*@author warren
 * version 1.0 
 * ��������controller*/
import java.util.ArrayList;

import Entity.BusinessUnit;
import Entity.account;
import Entity.goods;
import Entity.goodsList;
import Entity.sellGoodsList;
import Entity.sellList;
import Entity.warehouse;
import Model.BusinessUnitModel;
import Model.accountModel;
import Model.sellListModel;
import Model.goodsModel;
import Model.sellGoodsListModel;
import Model.warehouseModel;
import Model.goodsListModel;

public class sellControl {

	private goodsModel gm = new goodsModel();
	private sellListModel pm = new sellListModel();
	private sellGoodsListModel sglm = new sellGoodsListModel();
	private accountModel acm = new accountModel();
	private BusinessUnitModel bum = new BusinessUnitModel();
	private warehouseModel wm = new warehouseModel();

	private goods goodsEntity = null;
	private sellGoodsList sellGoodsListEntity = null;
	private float totalPrice = 0;
	private String acct_id;
	
	public ArrayList<sellList> getAllList()
	{
		ArrayList<sellList> sellLists=new ArrayList<sellList>();
		sellLists=pm.select();
		return sellLists;
		
	}
	// �ҳ����е���ƷID
	public ArrayList<String> findAllId() {

		ArrayList<String> productId = new ArrayList<String>();
		ArrayList<goods> acctArry = new ArrayList<goods>();
		acctArry = gm.select();

		int num = acctArry.size();
		for (int i = 0; i < num; i++) {
			productId.add(acctArry.get(i).getGoods_id());
		}

		return productId;
	}

	// �ҳ����е���Ʒ����
	public ArrayList<String> findAllName() {

		ArrayList<String> productName = new ArrayList<String>();
		ArrayList<goods> acctArry = new ArrayList<goods>();
		acctArry = gm.select();

		int num = acctArry.size();
		for (int i = 0; i < num; i++) {
			productName.add(acctArry.get(i).getGoods_name());
		}

		return productName;
	}

	// ���ݳ�����Ʒ�����Ʒ����и���
	public void updateGoodsQuantityAndCost(sellGoodsList seGList) {
		// ����Ʒ�����ҵ�����Ʒ
		goodsEntity = gm.findById(seGList.getGoods_id(), seGList.getWarh_id());
		int quantity = goodsEntity.getGoods_quantity();
		// ���۶�
		float profit = goodsEntity.getGoods_cost();
		int buyQuantity = seGList.getGoods_quantity();
		// �����۶�������¼���
		profit = (profit * quantity + seGList.getGoods_price() * buyQuantity)
				/ (quantity + buyQuantity);
		//��������˵��һ�£�sellControllerû����֤
		goodsEntity.setGoods_quantity(quantity - buyQuantity);

		goodsEntity.setGoods_cost(profit);
		// ������д�����ݿ�
		gm.update(goodsEntity);
		goodsEntity = null;
	}

	// ��ӳ�����
	public boolean addPurh(sellList seList, ArrayList<sellGoodsList> selGLstArry) {
		// Ҫ��������Ʒ��Ŀ����
		int goodsNum = selGLstArry.size();
		// ��ӽ�����
		acct_id = seList.getAcc_id();
		pm.add(seList);

		for (int i = 0; i < goodsNum; i++) {
			sellGoodsListEntity = selGLstArry.get(i);
			totalPrice += sellGoodsListEntity.getGoods_price()
					* sellGoodsListEntity.getGoods_quantity();
				//����ӽ�������Ʒ���е�
				goodsEntity = new goods();
				goodsEntity.setGoods_id(sellGoodsListEntity.getGoods_id());
				goodsEntity.setGoods_name(sellGoodsListEntity.getGoods_name());
				goodsEntity.setWarh_id(sellGoodsListEntity.getWarh_id());
				goodsEntity.setGoods_cost(sellGoodsListEntity.getGoods_price());
				goodsEntity.setGoods_quantity(0);
				gm.add(goodsEntity);

				goodsEntity = null;
				// ��ӽ�������Ʒ��Ŀ��
				sglm.add(sellGoodsListEntity);

				updateGoodsQuantityAndCost(sellGoodsListEntity);
		}
		// �������
		seList.setSell_totalPrice(totalPrice);
		// �ѽ�����д�����ݿ�
		pm.update(seList);

		sellGoodsListEntity = null;
		return true;
	}

	// ͨ������������ʾ��������Ϣ
	public sellList showSell(String sell_id) {

		sellList puch = pm.findBySell_id(sell_id);

		return puch;
	}

	// ͨ������������ʾ��Ʒ��������Ϣ
	public ArrayList<sellGoodsList> showGoodsList(String sell_id) {
		ArrayList<sellGoodsList> godLstAry = new ArrayList<sellGoodsList>();
		godLstAry = sglm.findBySell(sell_id);

		return godLstAry;
	}

	// �ҳ����ݿ��е��˻���
	public ArrayList<String> checkAcctNum() {

		ArrayList<String> acctNums = new ArrayList<String>();
		ArrayList<account> acctArry = new ArrayList<account>();
		acctArry = acm.select();

		int num = acctArry.size();
		for (int i = 0; i < num; i++) {
			acctNums.add(acctArry.get(i).getAcc_id());
		}

		return acctNums;
	}

	// �ҳ����ݿ���������λ��
	public ArrayList<String> checkBsiUnitNum() {

		ArrayList<String> BsiUnitNums = new ArrayList<String>();
		ArrayList<BusinessUnit> acctArry = new ArrayList<BusinessUnit>();
		acctArry = bum.select();

		int num = acctArry.size();
		for (int i = 0; i < num; i++) {
			BsiUnitNums.add(acctArry.get(i).getUnitId());
		}

		return BsiUnitNums;
	}

	// �ҳ����ݿ��вֿ��
	public ArrayList<String> checkWarhId() {

		ArrayList<String> WarhId = new ArrayList<String>();
		ArrayList<warehouse> acctArry = new ArrayList<warehouse>();
		acctArry = wm.select();

		int num = acctArry.size();
		for (int i = 0; i < num; i++) {
			WarhId.add(acctArry.get(i).getWarh_id());
		}

		return WarhId;
	}

	// �տ�
	public void pay() {
		account acc = new account();
		acc = acm.findById(acct_id);
		float balance = acc.getAcc_balance();
		balance += totalPrice;
		acc.setAcc_balance(balance);
		acm.update(acc);
	}
	//ͨ����ƷID�Ͳֿ�Ų�����Ʒ
		public goods findByGidWid(String goods_id,String warh_id)
		{goods god=new goods();
		god=gm.findById(goods_id, warh_id);
		return god;
		}
}
