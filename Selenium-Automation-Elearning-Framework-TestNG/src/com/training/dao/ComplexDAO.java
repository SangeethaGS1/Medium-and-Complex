package com.training.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.training.bean.ComplexTCBean;
import com.training.connection.GetConnection;
import com.training.utility.LoadDBDetails;

public class ComplexDAO {
	
Properties properties; 
	
	public ComplexDAO() {
		 try {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/sql.properties");
			properties.load(inStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<ComplexTCBean> getLogins(){
		String sql = properties.getProperty("get.logins"); 
		
		GetConnection gc  = new GetConnection(); 
		List<ComplexTCBean> list = null;
		try {
			gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
			list = new ArrayList<ComplexTCBean>(); 
			
			gc.rs1 = gc.ps1.executeQuery(); 
			
			while(gc.rs1.next()) {
			
				ComplexTCBean temp = new ComplexTCBean(); 
				temp.setProductName(gc.rs1.getString(1));
				temp.setQuantity(gc.rs1.getString(2));

				list.add(temp); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list; 
	}
	
	public static void main(String[] args) {
		new ComplexDAO().getLogins().forEach(System.out :: println);
	}
	

}
