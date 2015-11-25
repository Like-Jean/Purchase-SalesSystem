package Controller;


import java.util.ArrayList;



import Entity.goods;
import Entity.warehouse;

import Model.goodsModel;
import Model.warehouseModel;

public class initialInventoryControl {
	
	private goodsModel gm = new goodsModel();
    private warehouseModel wm = new warehouseModel();
	
	
	//�õ����еĲֿ��
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
	
	
	//��ȡ����������ƷID
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
	
	//ͨ��ָ���Ĳֿ�ż���ƷID�õ���Ʒ
	public goods getInformationByWidGid(String goods_id,String warh_id)
	{
		goods g=new goods();
		g=gm.findById(goods_id, warh_id);
		return g;
	}
	
	
	//�õ�ĳ���ֿ��ض���Ʒ�Ŀ����
	public float getValue(String goods_id,String warh_id)
	{
		
		float f;
		goods g=new goods();
		g=gm.findById(goods_id, warh_id);
		f=g.getGoods_quantity()*g.getGoods_cost();
		return f;
		
	}
	
	//�õ�����Ʒ���вֿ��ܵĿ����
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
	
 //���������������ĳ���ֿ�ĳ����Ʒ�Ŀ��
	public  void  addInventory(int i,String goods_id,String warh_id)
	{ 
		gm.increase(goods_id, warh_id, i);
	}
	
	
//������������޸�ĳ���ֿ�ĳ����Ʒ�Ŀ��
	public  void updateInventory(int i,String goods_id,String warh_id)
	{   
		goods g=new goods();
		g=gm.findById(goods_id, warh_id);
		g.setGoods_quantity(i);
		gm.update(g);
	}

//ɾ���ض��ֿ��ض���Ʒ�Ŀ��
	public void deleteInventory (String goods_id,String warh_id)
	{
		gm.delete(goods_id, warh_id);
	}
	
}
