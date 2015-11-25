package Controller;
/*@auther yixiu
 * 商品信息管理控制器
 * */
import java.util.ArrayList;

import Entity.BusinessUnit;
import Entity.goods;
import Entity.warehouse;
import Model.goodsModel;
import Model.warehouseModel;

public class goodsControl {

	private goods good = new goods();
	private goodsModel gm = new goodsModel();
	//private ArrayList<goods> goodsList = new ArrayList<goods>();
	private warehouseModel wm = new warehouseModel();
	
	public void addGood(goods good){
		good.setGoods_quantity(0);//初始商品数量为0
		gm.add(good);
	}
	
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
	public ArrayList<String> getWareHouseId(){
		ArrayList<String> goodsId = new ArrayList<String>();
		ArrayList<goods> acctArry = new ArrayList<goods>();
		acctArry = gm.select();
		
		int num = acctArry.size();
		for(int i = 0;i<num;i++){
			goodsId.add(acctArry.get(i).getWarh_id());
		}
		
		return goodsId;
	}	
	public void delGood(String id,String warh_id){
		gm.delete(id, warh_id);
	}
	
	public goods findByGoodsIdandWareId(String goods_id,String ware_id){
		
		good = gm.findById(goods_id, ware_id);
		return good;
	}
	
	public void update(goods good){
		good.setGoods_quantity(0);
		gm.update(good);
	}
}
