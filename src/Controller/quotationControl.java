package Controller;

import java.util.ArrayList;

import Entity.*;
import Model.*;

public class quotationControl {
	
	private quotationModel quom=new quotationModel();
	private quotationGoodsListModel quoGM=new quotationGoodsListModel();
	private goodsModel gm = new goodsModel();
	private BusinessUnitModel bum = new BusinessUnitModel();
	private employeeModel em=new employeeModel();
	private quotationGoodsList quoEntity=new quotationGoodsList();
	
	//得到本次quoId
	public String getThisQuoId()
	{
		int ID=0;
		ArrayList<quotation> quoLists = new ArrayList<quotation>();
		quoLists=quom.select();
		String Qid="";
		if(quoLists.size()==0)
		{Qid="Q"+"00001";}
		else{
		for (int j=0;j<quoLists.size();j++)
		{
			quotation q=(quotation)quoLists.get(j);
			Qid=q.getQuoId();
			}
		Qid=Qid.trim();
		ID=Integer.parseInt(Qid.substring(Qid.length()-5));
		Qid="S"+String.format("%05d", ID+1);
		}
		return Qid;
		
	}
	
	
	//找出往来单位号
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
	
	
	//根据往来单位号得到名字
	public String getUNameById(String unitId)
	{
		BusinessUnit b=new BusinessUnit ();
		b=bum.findById(unitId);
		String x=b.getUnitName();
		return x;
	}
	
	
	//找出数据库中对应销售部人员姓名
	public ArrayList<String> checkSaleName(){
		
		ArrayList<String> nameNum = new ArrayList<String>();
		ArrayList<employee> acctArry = new ArrayList<employee>();
		acctArry = em.findByDepartment("销售部");
		
		int num = acctArry.size();
	
		for(int i = 0;i<num;i++){
			nameNum.add(acctArry.get(i).getEmpl_name());
		}
		
		return nameNum;
	}
	
	//获取现有商品ID
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
	
	
	//通过ID获取商品数量
	public int getQuantitybyId(String goods_id)
	{
		ArrayList<goods> goodsList = new ArrayList<goods>();
		goodsList=gm.findByGoodId(goods_id);
		int m=goodsList.size();
		int quantity=0;
		for(int i=0;i<m;i++)
		{
			quantity=quantity+(goodsList.get(i).getGoods_quantity());
		}
		
		return quantity;
	}
	

	// 添加报价单
	public boolean addQuo(quotation quo, ArrayList<quotationGoodsList> quoGArry) {
		// 要报价的商品条目数量
		int goodsNum = quoGArry.size();
		// 添加报价单
		quom.add(quo);

		for (int i = 0; i < goodsNum; i++) {
			
			quoEntity = quoGArry.get(i);
            quoGM.add(quoEntity);

		}
         quoEntity = null;
		return true;
	}

	}
