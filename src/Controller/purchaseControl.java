package Controller;
/*@author yixiu
 * version 1.0 
 * 进货功能controller*/
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
	
	//检查该商品是否已在商品表中
	public boolean checkGoods(goodsList goo){
		//用goodsList中的商品号和仓库号查询是否有该商品存在
		goodsEntity = gm.findById(goo.getGoods_id(), goo.getWarh_id());
		if(goodsEntity.getGoods_id() == null){
			//必须注意要设置为null
			goodsEntity = null;
			return false;
			}
		else{
			goodsEntity = null;
			return true;
			}
	}
	//根据进货商品表对商品表进行更新
	public void updateGoodsQuantityAndCost(goodsList godLst){
		//在商品表中找到该商品
		goodsEntity = gm.findById(godLst.getGoods_id(), godLst.getWarh_id());
		int quantity = goodsEntity.getGoods_quantity();
		float cost = goodsEntity.getGoods_cost();
		int buyQuantity = godLst.getGoods_quantity();
		//对成本进行重新计算
		cost = (cost*quantity+godLst.getGoods_price()*buyQuantity)/(quantity+buyQuantity);		
		goodsEntity.setGoods_quantity(quantity+buyQuantity);
		
		goodsEntity.setGoods_cost(cost);
		//把数据写回数据库
		gm.update(goodsEntity);
		goodsEntity = null;
	}
	//添加进货单
	public boolean addPurh(purchaseList prhLst,ArrayList<goodsList> gooLstArry){
		//要添加的商品条目数量
		int goodsNum = gooLstArry.size();
		//添加进货单
		acct_id = prhLst.getAcc_id();
		pm.add(prhLst);
		
		for(int i = 0;i<goodsNum;i++){
			goodsListEntity = gooLstArry.get(i);
			totalPrice += goodsListEntity.getGoods_price()*goodsListEntity.getGoods_quantity();
			//检查是否存在该商品
			if(checkGoods(goodsListEntity) == true){
				//是的话，添加进商品条目表
				glm.add(goodsListEntity);

				updateGoodsQuantityAndCost(goodsListEntity);			
			}
			else{
				//不是的话，先添加进商品表中的
				goodsEntity = new goods();
				goodsEntity.setGoods_id(goodsListEntity.getGoods_id());
				goodsEntity.setGoods_name(goodsListEntity.getGoods_name());
				goodsEntity.setWarh_id(goodsListEntity.getWarh_id());
				goodsEntity.setGoods_cost(goodsListEntity.getGoods_price());
				goodsEntity.setGoods_quantity(0);
				gm.add(goodsEntity);

				goodsEntity = null;
				//添加进商品条目表
				glm.add(goodsListEntity);
				
				updateGoodsQuantityAndCost(goodsListEntity);
			}
		}
		//添加总价
		prhLst.setPurch_totalPrice(totalPrice);
		//把进货单写入数据库
		pm.update(prhLst);
		
		goodsListEntity = null;
		return true;
	}
    //通过进货单号显示进货单信息
	public purchaseList showPurchase(String purchase_id){
		
		purchaseList puch = pm.findByPurch_id(purchase_id);
		
		return puch;
	}
    //通过进货单号显示商品进货单信息
	public ArrayList<goodsList> showGoodsList(String purchase_id){
		ArrayList<goodsList> godLstAry = new ArrayList<goodsList>();
		godLstAry = glm.findByPurchase(purchase_id);
		
		return godLstAry;
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
	//找出数据库中往来单位号
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
	//找出数据库中仓库号
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
	//检查余额是否足够
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
