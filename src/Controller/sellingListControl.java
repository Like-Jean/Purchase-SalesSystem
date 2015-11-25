package Controller;
/*
 * version 1.0 
 * 销售单controller*/
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
	
	//检查该商品是否已在销售商品表中
	public boolean checkGoods(sellingGoodsList goo){
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

	//添加销售单
	public boolean addPurh(sellingList sellingList,ArrayList<sellingGoodsList> gooLstArry){
		//要添加的商品条目数量
		int goodsNum = gooLstArry.size();
		//添加销售单
		acct_id = sellingList.getAcc_id();
		sm.add(sellingList);
		
		for(int i = 0;i<goodsNum;i++){
			sellingGoodsListEntity = gooLstArry.get(i);
			totalPrice += sellingGoodsListEntity.getGoods_price()*sellingGoodsListEntity.getGoods_quantity();			
		}
		//添加总价
		sellingList.setSelling_totalPrice(totalPrice);
		//把销售单写入数据库
		sm.update(sellingList);
		
		sellingGoodsListEntity = null;
		return true;
	}
    //通过进销售单号显示进货单信息
	public sellingList showPurchase(String sellingList_id){
		
		sellingList slt = sm.findBySell_id(sellingList_id);
		
		return slt;
	}
    //通过销售单号显示商品进货单信息
	public ArrayList<sellingGoodsList> showGoodsList(String sellingList_id){
		ArrayList<sellingGoodsList> godLstAry = new ArrayList<sellingGoodsList>();
		godLstAry = slm.findBysellingList(sellingList_id);
		
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
	//找出商品表中的商品的名字
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
	//找出商品表中的商品ID
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