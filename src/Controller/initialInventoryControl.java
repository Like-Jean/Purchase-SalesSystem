package Controller;


import java.util.ArrayList;



import Entity.goods;
import Entity.warehouse;

import Model.goodsModel;
import Model.warehouseModel;

public class initialInventoryControl {
	
	private goodsModel gm = new goodsModel();
    private warehouseModel wm = new warehouseModel();
	
	
	//得到所有的仓库号
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
	
	
	//获取现有所有商品ID
	public ArrayList<String> checkAllGood(){
		
		ArrayList<String> AllGood = new ArrayList<String>();
		ArrayList<goods> acctArry = new ArrayList<goods>();
		acctArry = gm.select();
		
		int num = acctArry.size();
		for(int i = 0;i<num;i++){
			AllGood.add(acctArry.get(i).getGoods_id());
		}
		
		return AllGood;
	}
	
	//通过指定的仓库号及商品ID得到商品
	public goods getInformationByWidGid(String goods_id,String warh_id)
	{
		goods g=new goods();
		g=gm.findById(goods_id, warh_id);
		return g;
	}
	
	
	//得到某个仓库特定商品的库存金额
	public float getValue(String goods_id,String warh_id)
	{
		
		float f;
		goods g=new goods();
		g=gm.findById(goods_id, warh_id);
		f=g.getGoods_quantity()*g.getGoods_cost();
		return f;
		
	}
	
	//得到该商品所有仓库总的库存金额
	public float getAllValue(String goods_id)
	{
	    
	    ArrayList<goods> gList=new ArrayList<goods>();
	    gList= gm.findByGoodId(goods_id);
		float f=0;
		goods g=new goods();
		for(int i=0;i<gList.size();i++)
		{g=gList.get(i);
		f=f+g.getGoods_quantity()*g.getGoods_cost();
		g=null;
		}
		return f;
		
	}
	
 //由填入的数字增加某个仓库某个商品的库存
	public  void  addInventory(int i,String goods_id,String warh_id)
	{ 
		gm.increase(goods_id, warh_id, i);
	}
	
	
//由填入的数字修改某个仓库某个商品的库存
	public  void updateInventory(int i,String goods_id,String warh_id)
	{   
		goods g=new goods();
		g=gm.findById(goods_id, warh_id);
		g.setGoods_quantity(i);
		gm.update(g);
	}

//删除特定仓库特定商品的库存
	public void deleteInventory (String goods_id,String warh_id)
	{
		gm.delete(goods_id, warh_id);
	}
	
}
