package com.training.pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UniformPOM {
private WebDriver driver; 

	
	public UniformPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(css="button.btn.btn-primary")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//li[@id='sale']/a/i")
	private WebElement order;
	
	@FindBy(xpath="//li[@id='sale']/ul/li/a")
	private WebElement orderlink;
	
	@FindBy(xpath="//*[@id='form-order']//child::tbody/tr[2]/td/input")
	private WebElement checkbox;
	
	@FindBy(xpath="//*[@id='form-order']//child::tbody/tr[2]/td[8]/button")
	private WebElement deletebtn;
	
	@FindBy(xpath="//*[@id='form-order']//child::tbody/tr")
	private List<WebElement> rows;
	
	@FindBy(xpath="//li[@id='sale']/ul/li[3]/a")
	private WebElement returnLink;
	
	@FindBy(id="input-return-id")
	private WebElement returnId;
	
	@FindBy(id="button-filter")
	private WebElement filterBtn;
	
	@FindBy(xpath="//*[@id=\"form-return\"]/div/table/tbody/tr/td[2]")
	private List<WebElement> returnOrderLists;
	
	@FindBy(id="input-customer")
	private WebElement customerBox;
	
	@FindBy(xpath="//*[@id=\"form-return\"]/div/table/tbody/tr/td[4]")
	private List<WebElement> returnOrderCustomerLists;
	
   @FindBy(xpath="//*[@id='reports']/a/i")
   private WebElement report;
   
   @FindBy(xpath="//*[@id='reports']/ul/li/a")
   private WebElement sales;
   
   @FindBy(xpath="//*[@id='reports']/a/i")
		   private List<WebElement> reportList;
   
   @FindBy(xpath="//*[@id='reports']//child::ul[@class='collapse in']/li/a")
   private List<WebElement> listsales;
   
   @FindBy(xpath="//*[@id='reports']//child::ul[@class='collapse in']/li[2]/a")
   private WebElement tax;
   
   @FindBy(id="input-group")
   private WebElement groupBox;
   
   
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void sendreturnId(String returnId) {
		this.returnId.clear();
		this.returnId.sendKeys(returnId);
	}
	
	public void clearreturnId() {
		this.returnId.clear();
	}
	
	
	public void sendcustomerBox(String customerBox) {
		this.customerBox.clear();
		this.customerBox.sendKeys(customerBox);
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}

	public WebElement clickOrder() {
		return order; 
	}
	
	public void clickreturnLink() {
		this.returnLink.click(); 
	}
	
	public void clickOrderLink() {
		this.orderlink.click(); 
	}
	
	public void clickcheckbox() {
		this.checkbox.click(); 
	}
	
	public void clickdeletebtn() {
		this.deletebtn.click(); 
	}
		
		public int noOfRows() {
			return	rows.size();
			
		}
		
		public void clickFilterBtn() {
			this.filterBtn.click();
		}
		
		public List<WebElement> getReturnOrderLists() {
			return this.returnOrderLists;
		}
		
		public List<WebElement> getReturnOrderCustomerLists() {
			return this.returnOrderCustomerLists;
		}
		
		public WebElement reportElement() {
			return this.report;
		}
		
		public WebElement salesElement() {
			return this.sales;
		}
		
		public void clickTaxElement() {
			this.tax.click();
		}
		
		public WebElement groupBoxElement() {
			return this.groupBox;
		}
		
		public List<WebElement> getreportList(){
			return this.reportList;
		}
		
		public List<WebElement> getsalesList(){
			return this.listsales;
		}
} 
	


