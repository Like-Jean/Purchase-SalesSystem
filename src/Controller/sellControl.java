package Controller;

/*@author warren
 * version 1.0 
 * 出货功能controller*/
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
	// 找出所有的商品ID
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

	// 找出所有的商品名称
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

	// 根据出货商品表对商品表进行更新
	public void updateGoodsQuantityAndCost(sellGoodsList seGList) {
		// 在商品表中找到该商品
		goodsEntity = gm.findById(seGList.getGoods_id(), seGList.getWarh_id());
		int quantity = goodsEntity.getGoods_quantity();
		// 销售额
		float profit = goodsEntity.getGoods_cost();
		int buyQuantity = seGList.getGoods_quantity();
		// 对销售额进行重新计算
		profit = (profit * quantity + seGList.getGoods_price() * buyQuantity)
				/ (quantity + buyQuantity);
		//这里严重说明一下！sellController没有验证
		goodsEntity.setGoods_quantity(quantity - buyQuantity);

		goodsEntity.setGoods_cost(profit);
		// 把数据写回数据库
		gm.update(goodsEntity);
		goodsEntity = null;
	}

	// 添加出货单
	public boolean addPurh(sellList seList, ArrayList<sellGoodsList> selGLstArry) {
		// 要出货的商品条目数量
		int goodsNum = selGLstArry.size();
		// 添加进货单
		acct_id = seList.getAcc_id();
		pm.add(seList);

		for (int i = 0; i < goodsNum; i++) {
			sellGoodsListEntity = selGLstArry.get(i);
			totalPrice += sellGoodsListEntity.getGoods_price()
					* sellGoodsListEntity.getGoods_quantity();
				//先添加进销售商品表中的
				goodsEntity = new goods();
				goodsEntity.setGoods_id(sellGoodsListEntity.getGoods_id());
				goodsEntity.setGoods_name(sellGoodsListEntity.getGoods_name());
				goodsEntity.setWarh_id(sellGoodsListEntity.getWarh_id());
				goodsEntity.setGoods_cost(sellGoodsListEntity.getGoods_price());
				goodsEntity.setGoods_quantity(0);
				gm.add(goodsEntity);

				goodsEntity = null;
				// 添加进销售商品条目表
				sglm.add(sellGoodsListEntity);

				updateGoodsQuantityAndCost(sellGoodsListEntity);
		}
		// 添加利润
		seList.setSell_totalPrice(totalPrice);
		// 把进货单写入数据库
		pm.update(seList);

		sellGoodsListEntity = null;
		return true;
	}

	// 通过出货单号显示进货单信息
	public sellList showSell(String sell_id) {

		sellList puch = pm.findBySell_id(sell_id);

		return puch;
	}

	// 通过出货单号显示商品进货单信息
	public ArrayList<sellGoodsList> showGoodsList(String sell_id) {
		ArrayList<sellGoodsList> godLstAry = new ArrayList<sellGoodsList>();
		godLstAry = sglm.findBySell(sell_id);

		return godLstAry;
	}

	// 找出数据库中的账户号
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

	// 找出数据库中往来单位号
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

	// 找出数据库中仓库号
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

	// 收款
	public void pay() {
		account acc = new account();
		acc = acm.findById(acct_id);
		float balance = acc.getAcc_balance();
		balance += totalPrice;
		acc.setAcc_balance(balance);
		acm.update(acc);
	}
	//通过商品ID和仓库号查找商品
		public goods findByGidWid(String goods_id,String warh_id)
		{goods god=new goods();
		god=gm.findById(goods_id, warh_id);
		return god;
		}
}
