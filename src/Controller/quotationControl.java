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
	
	//�õ�����quoId
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
	
	
	//�ҳ�������λ��
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
	
	
	//����������λ�ŵõ�����
	public String getUNameById(String unitId)
	{
		BusinessUnit b=new BusinessUnit ();
		b=bum.findById(unitId);
		String x=b.getUnitName();
		return x;
	}
	
	
	//�ҳ����ݿ��ж�Ӧ���۲���Ա����
	public ArrayList<String> checkSaleName(){
		
		ArrayList<String> nameNum = new ArrayList<String>();
		ArrayList<employee> acctArry = new ArrayList<employee>();
		acctArry = em.findByDepartment("���۲�");
		
		int num = acctArry.size();
	
		for(int i = 0;i<num;i++){
			nameNum.add(acctArry.get(i).getEmpl_name());
		}
		
		return nameNum;
	}
	
	//��ȡ������ƷID
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
	
	
	//ͨ��ID��ȡ��Ʒ����
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
	

	// ��ӱ��۵�
	public boolean addQuo(quotation quo, ArrayList<quotationGoodsList> quoGArry) {
		// Ҫ���۵���Ʒ��Ŀ����
		int goodsNum = quoGArry.size();
		// ��ӱ��۵�
		quom.add(quo);

		for (int i = 0; i < goodsNum; i++) {
			
			quoEntity = quoGArry.get(i);
            quoGM.add(quoEntity);

		}
         quoEntity = null;
		return true;
	}

	}
