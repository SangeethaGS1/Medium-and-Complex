package com.training.bean;

public class ComplexTCBean {
	
	private String ProductName;
	private String Quantity;
	
	public ComplexTCBean() {
		
	}
	
public ComplexTCBean(String ProductName,String Quantity) {
	this.ProductName =ProductName;
	this.Quantity = Quantity;
		
	}

public String getProductName() {
	return ProductName;
}

public void setProductName(String productName) {
	ProductName = productName;
}

public String getQuantity() {
	return Quantity;
}

public void setQuantity(String quantity) {
	Quantity = quantity;
}

@Override
public String toString() {
	return "ComplexTCBean [ProductName=" + ProductName + ", Quantity=" + Quantity + "]";
}

}
