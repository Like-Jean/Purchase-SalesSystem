package Controller;
/*@auther yixui
 * 模块2的控制器
 * 对于商品库存和账户的初始化*/
import java.util.ArrayList;

import Model.accountModel;
import Model.goodsModel;
import Entity.account;
import Entity.goods;
public class Module2Controller {
	private goodsModel gm = new goodsModel();
	private goods god = new goods();
	private accountModel am = new accountModel();
	
	public ArrayList<String> getGoodsId(){
		ArrayList<String> goodsId = new ArrayList<String>();
		ArrayList<goods> acctArry = new ArrayList<goods>();
		acctArry = gm.select();
		
		int num = acctArry.size();
		for(int i = 0;i<num;i++){
			goodsId.add(acctArry.get(i).getGoods_id());
		}
		
		return goodsId;
	}
	public ArrayList<String> getWareHouseId(String goodsId){
		
		ArrayList<String> wareId = new ArrayList<String>();
		ArrayList<goods> acctArry = new ArrayList<goods>();
		acctArry = gm.findByGoodId(goodsId);
		
		int num = acctArry.size();
		
		for(int i = 0;i<num;i++){
			wareId.add(acctArry.get(i).getWarh_id());
		}
		
		return wareId;
	}	
	public String findNameByGoodsIdandWareId(String goods_id,String ware_id){
		
		goods good = gm.findById(goods_id, ware_id);
		return good.getGoods_name();
	}

	public void increase(String goods_id,String warh_id,int mount){
		gm.increase(goods_id,warh_id,mount);
	}
	public ArrayList<String> getAccountId(){
		ArrayList<String> wareId = new ArrayList<String>();
		ArrayList<account> acctArry = new ArrayList<account>();
		acctArry = am.select();
		
		int num = acctArry.size();
		for(int i = 0;i<num;i++){
			wareId.add(acctArry.get(i).getAcc_id());
		}
		
		return wareId;		
	}	
	public void updateAccount(String id,int balance){
		account acc = new account();
		acc = am.findById(id);
		acc.setAcc_balance(balance);
		am.update(acc);
	}
}
