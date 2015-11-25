package Controller;

import java.util.ArrayList;

import Entity.BusinessUnit;
import Model.BusinessUnitModel;

/*@auther yixiu
 * 往来单位信息管理控制器
 * */

public class bussUnitControl{
	
	private BusinessUnitModel bum = new BusinessUnitModel();
	private ArrayList<BusinessUnit> buLst = new ArrayList<BusinessUnit>();
	private BusinessUnit bu = new BusinessUnit();
	
	public void addBussUnit(BusinessUnit bu){
		bum.add(bu);
	}
	
	public ArrayList<String> getBussUnitId(){
		ArrayList<String> BsiUnitNums = new ArrayList<String>();
		ArrayList<BusinessUnit> acctArry = new ArrayList<BusinessUnit>();
		acctArry = bum.select();
		
		int num = acctArry.size();
		for(int i = 0;i<num;i++){
			BsiUnitNums.add(acctArry.get(i).getUnitId());
		}
		
		return BsiUnitNums;		
	}

	public void delBussUnit(String id){
		bum.delete(id);
	}
	
	public void updateBu(BusinessUnit bu){
		bum.update(bu);
	}
	
	public BusinessUnit findById(String unitId){
		unitId.trim();
		BusinessUnit busUnit = new BusinessUnit();
		busUnit = bum.findById(unitId);
		return busUnit;
	}
}
