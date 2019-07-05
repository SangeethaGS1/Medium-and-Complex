package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.ComplexTCBean;
import com.training.bean.LoginBean;
import com.training.dao.ComplexDAO;
import com.training.dao.ELearningDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class ComplexDataProviders {
	
	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<ComplexTCBean> list = new ComplexDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(ComplexTCBean temp : list){
			Object[]  obj = new Object[2]; 
			obj[0] = temp.getProductName(); 
			obj[1] = temp.getQuantity();
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName ="C:/Users/SangeethaShadakshara/Desktop/UN_078_data.xlsx"; 
		return new ApachePOIExcelRead().getExcelContent(fileName); 
	}
	
	@DataProvider(name = "excel-inputs1")
	public Object[][] getExcelData1(){
		String fileName ="C:/Users/SangeethaShadakshara/Desktop/UN_078_1.xlsx"; 
		return new ApachePOIExcelRead().getExcelContent(fileName); 
	}
	
	@DataProvider(name = "excel-inputs2")
	public Object[][] getExcelData2(){
		String fileName ="C:/Users/SangeethaShadakshara/Desktop/UNF_077.xlsx"; 
		return new ApachePOIExcelRead().getExcelContent(fileName); 
	}
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:/Users/Naveen/Desktop/Testing.xls", "Sheet1"); 
	}

}
