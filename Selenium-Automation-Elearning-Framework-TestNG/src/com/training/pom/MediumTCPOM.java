package com.training.pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MediumTCPOM {
	
private WebDriver driver; 
public String tes;
	
	public MediumTCPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(css="button.btn.btn-primary")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//*[@id='customer']/a")
	private WebElement customerBtn;
	
	@FindBy(xpath="//*[@id='customer']/ul/li[2]/a")
	private WebElement customerGroupLink;
	
	@FindBy(xpath="//*[@id='customer']/ul/li")
	public List<WebElement> customerIcon;
	
	@FindBy(xpath="//*[@id='customer']//child::a[text()='Customers']")
	private WebElement customerLink;
		
		@FindBy(xpath="//*[@id='content']//child::a")
		private WebElement addBtnCustomer;
	
	@FindBy(xpath="//*[@id='form-customer-group']//child::input[@name='customer_group_description[1][name]']")
	private WebElement customerGrpName;
	
	@FindBy(id="input-description1")
	private WebElement customerDescription;
	
	@FindBy(name="approval")
	private WebElement rdBtn;
	
	@FindBy(xpath="//*[@id='content']//child::button/i")
	private WebElement saveBtn;
	
	@FindBy(xpath="//*[@class=\"close\"]//parent::div")
	private WebElement successMsg;
	
	  @FindBy(xpath="//*[@id='reports']/a/i")
	   public WebElement report;
	  
	  @FindBy(xpath="//*[@id='reports']/ul/li[3]/a")
	  public WebElement reportOfCustomer;
	  
	  @FindBy(id="input-customer-group")
	public WebElement customerGrp;
	  
	  @FindBy(xpath="//*[@id='content']//child::h3")
	  public WebElement title;
	  
	  @FindBy(id="input-firstname")
	  public WebElement sendFirstName;
	  
	  @FindBy(id="input-lastname")
	  public WebElement sendLastName;
	  
	  @FindBy(id="input-email")
	  public WebElement sendEmail;
	  
	  @FindBy(id="input-telephone")
	  public WebElement sendPhone;
	  
	  @FindBy(id="input-password")
	  public WebElement sendPassword;
	  
	  @FindBy(id="input-confirm")
	  public WebElement sendConfirmPassword;
	  
	  @FindBy(xpath="//*[@id='address-add']/a")
	  private WebElement clickAddAddress;
	   
	  @FindBy(id="input-firstname1")
	  public WebElement sendFirstName1;
	  
	  @FindBy(id="input-lastname1")
	  public WebElement sendLastName1;
	  
	  @FindBy(id="input-address-11")
	  public WebElement address1;
	  
	  @FindBy(id="input-address-21")
	  public WebElement address2;
	  
	  @FindBy(id="input-city1")
	  public WebElement city;
	  
	  @FindBy(id="input-postcode1")
	  public WebElement postalcode;
	  
	  @FindBy(id="input-country1")
	  public WebElement country;
	  
	  @FindBy(id="input-zone1")
	  public WebElement state;
	  
	  @FindBy(xpath="//*[@id='content']/div[2]/div[1]")
	  public WebElement messageAlert;
	  
	  @FindBy(xpath="//*[@id='form-customer']//child::tbody/tr[1]/td[8]/a")
	  private WebElement editBtn;
	  
	  @FindBy(xpath="//*[@id='address']//child::li[2]/a")
	  private WebElement add1Link;
	  
	  @FindBy(xpath="//*[@id='form-customer']//child::li[4]/a")
	  private WebElement rewardPoints;
	  
	  @FindBy(id="button-reward")
	  private WebElement addRewardPoints;
	  
	  @FindBy(id="input-reward-description")
	  public WebElement rewardDesc;
	  
	  @FindBy(id="input-points")
	  public WebElement points;
	  
	  @FindBy(xpath="//*[@id='tab-reward']/div")
	private WebElement rewardSucMsg;
	  
	  @FindBy(xpath="//*[@id='reports']/ul/li[3]/ul/li[4]/a")
	  private WebElement reportRewardPOints;

	  @FindBy(xpath="//*[@id='content']//child::tbody/tr")
	  private List<WebElement> rewardLists;
	  
	  @FindBy(xpath="//li[@id='sale']/a/i")
		private WebElement order;
		
		@FindBy(xpath="//li[@id='sale']/ul/li/a")
		private WebElement orderlink;
		
		@FindBy(xpath="//*[@id='form-order']//child::tbody/tr[9]/td[8]/a[1]")
		private WebElement viewIcon;
		
		@FindBy(id="button-invoice")
		private WebElement invoiceBtn;
		
		@FindBy(id="invoice")
		public WebElement invoiceNumber;
		
		@FindBy(id="input-order-status")
		public WebElement orderStatus;
		
		@FindBy(id="button-history")
		private WebElement addHistoryBtn;
		
		@FindBy(css="div.alert.alert-success")
		private WebElement tabText;
		
		@FindBy(xpath="//*[@id='reports']/ul/li/a")
		   public WebElement sales;
		
		@FindBy(xpath="//*[@id='reports']/ul//child::ul/li/a")
		private WebElement salesOrder;
		
		@FindBy(xpath="//*[@id='button-invoice']//following-sibling::a")
		private WebElement addNewOrderBtn;
		
		@FindBy(id="button-customer")
		private WebElement continueBtn;
		
		@FindBy(xpath="//*[@id='order']/li[2]")
		public WebElement productTab;
		
	@FindBy(id="input-product")
	public WebElement inputprsdt;
	
	@FindBy(id="input-quantity")
	public WebElement quantity;
	
	@FindBy(id="button-product-add")
	private WebElement addprdt;
	
	@FindBy(xpath="//*[@id='cart']/tr/td")
	private List<WebElement> products;
	
	@FindBy(id="button-cart")
	private WebElement continueCart;
	
	@FindBy(id="input-payment-firstname")
	  public WebElement sendFirstNameip;
	  
	  @FindBy(id="input-payment-lastname")
	  public WebElement sendLastNameip;
	  
	  @FindBy(id="input-payment-address-1")
	  public WebElement address1ip;
	  
	  @FindBy(id="input-payment-address-2")
	  public WebElement address2ip;
	  
	  @FindBy(id="input-payment-city")
	  public WebElement cityip;
	  
	  @FindBy(id="input-payment-postcode")
	  public WebElement postalcodeip;
	  
	  @FindBy(id="input-payment-country")
	  public WebElement countryip;
	  
	  @FindBy(id="input-payment-zone")
	  public WebElement stateip;
	  
	  @FindBy(id="button-payment-address")
	  private WebElement continueCartBtn;
	  
	  @FindBy(id="input-shipping-firstname")
	  public WebElement sendFirstNameship;
	  
	  @FindBy(id="input-shipping-lastname")
	  public WebElement sendLastNameship;
	  
	  @FindBy(id="input-shipping-address-1")
	  public WebElement address1ship;
	  
	  @FindBy(id="input-shipping-address-2")
	  public WebElement address2ship;
	  
	  @FindBy(id="input-shipping-city")
	  public WebElement cityship;
	  
	  @FindBy(id="input-shipping-postcode")
	  public WebElement postalcodeship;
	  
	  @FindBy(id="input-shipping-country")
	  public WebElement countryship;
	  
	  @FindBy(id="input-shipping-zone")
	  public WebElement stateship;
	  
	  @FindBy(id="button-shipping-address")
	  private WebElement continueCartBtnship;
	  
	  @FindBy(id="input-shipping-method")
	  public WebElement inputShipping;
	  
	  @FindBy(id="button-shipping-method")
	  private WebElement applyBtn;
	  
	  @FindBy(id="input-payment-method")
	  public WebElement COD;
	  
	  @FindBy(id="button-payment-method")
	  private WebElement CODBtn;
	 
		  
	  @FindBy(id="button-save")
	  private WebElement BtnSave;
	  
	  @FindBy(id="input-customer")
	  public WebElement customerName;
	  
	  @FindBy(xpath="//*[@id='content']/div[2]/div")
	  public WebElement placedOrder;
	  
	  @FindBy(xpath="//a[@class='dropdown-toggle']")
	  public WebElement userBtn;
	  
	  @FindBy(xpath="//*[@class='dropdown-menu dropdown-menu-right myaccount-menu']/li[2]/a")
	  public WebElement userLoginBtn;
	  
	  @FindBy(id="input-email")
	  public WebElement emailid;
	  
	  @FindBy(id="input-password")
	  public WebElement loginpwd;
	  
	  @FindBy(xpath="//*[@value='Login']")
	  public WebElement lbtn;
	  
	  public void clickBtnSave() {
		  this.BtnSave.click();
	  }
	  
	public ArrayList<String> getValuesOfProducts() {
		ArrayList<String> lest = new ArrayList<String>();
		for (WebElement e : this.products) {
			lest.add(e.getText());
		}
		return lest;
	}
	
	public void clickContinueCart() {
		this.continueCart.click();
	}
	
	public void clickApplyBtn() {
		this.applyBtn.click();
	}
	
	public void clickCODBtn() {
		this.CODBtn.click();
	}
	
public void clickContinueCartPay() {
	this.continueCartBtn.click();
}

public void clickContinueCartBtnship() {
	this.continueCartBtnship.click();
}
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	public boolean verifyproductTabEnabled() {
	String value = this.productTab.getAttribute("class");
//	System.out.println(value);
	if (value.contains("active")) {
		return true;
			}
	else 
		return false;
	}
	
	public WebElement getCustomerBtn() {
		return this.customerBtn;
	}
	
	public WebElement getCustomerLink() {
		return this.customerLink;
	}

	public WebElement clickCustomerGroupLink() {
		return this.customerGroupLink;
	}
	
	public void clickAddNewBtnCustomer() {
		 this.addBtnCustomer.click();
	}
	
	public void sendCustomerGrpName(String customerGrpName) {
		this.customerGrpName.clear();
		this.customerGrpName.sendKeys(customerGrpName);
		}
	
	public void clearCustomerGrpName() {
		this.customerGrpName.clear();
		
		}
	
	public boolean verifyCustomerGrpName() {
	return	this.customerGrpName.isDisplayed();
	}
	
	public void sendcustomerDescription(String customerDescription) {
		this.customerDescription.clear();
		this.customerDescription.sendKeys(customerDescription);
		}
	public boolean verifycustomerDescription() {
		return	this.customerDescription.isDisplayed();
		}
	
	public void clearcustomerDescription() {
		this.customerDescription.clear();
		
		}
	
	public void clickrdBtn() {
		this.rdBtn.click();
	}
	
	public boolean verifyrdBtn() {
		return	this.rdBtn.isEnabled();
		}


	public void clickSaveBtn() {
		this.saveBtn.click();
	}
	public String getFirstMsg() {
		return this.title.getText();
	}
	
	public String getPlacedOrder() {
		return this.placedOrder.getText();
	}
	
	public String getTabText() {
		return this.tabText.getText();
	}
	
	public String getSuccessMsg() {
		return this.successMsg.getText();
	}
	
	public String getRewardSuccessMsg() {
		return this.rewardSucMsg.getText();
	}
	public String getFinalSuccessMsg() {
		return this.successMsg.getText();
	}
	public void clickreportOfCustomer() {
		this.reportOfCustomer.click(); 
	}
	public void clickEditBtn() {
		this.editBtn.click();
	}
	public void clickAddprdt() {
		this.addprdt.click();
	}
	
	public void clickadd1Link() {
		this.add1Link.click();
	}
	
	public boolean verifyEnabled() {
		return this.addRewardPoints.isEnabled();
	}
	
	public void clickAddRewardPoint() {
		this.addRewardPoints.click();
	}
	
	public void clickreportRewardPOints() {
		 this.reportRewardPOints.click();
	}
	public WebElement clickOrder() {
		return order; 
	}
	
	public WebElement clickOrderLink() {
		return orderlink;
	}
	
	public void clickViewIcon() {
		this.viewIcon.click();
	}
	
	public void clickSalesOrder() {
		this.salesOrder.click();
	}
	
	public void selectMethod(WebElement ele, String text) {
		Select sel = new Select(ele);
		sel.selectByVisibleText(text);	}
	
	public void selectMethodbyValue(WebElement ele, String value) {
		Select sel = new Select(ele);
		sel.selectByValue(value);	}
	
	public void sendNameValue(String firstName, WebElement WE) {
		WE.clear();
		WE.sendKeys(firstName);
	}
	
	public void clickAddressBtn() {
		this.clickAddAddress.click(); 
	}
	
	public void clickRewardPoints() {
		this.rewardPoints.click();
	}
	
	public void clickInvoiceBtn() {
		this.invoiceBtn.click();
	}
	
	public void clickAddHistoryBtn() {
		this.addHistoryBtn.click();
	}
	
	public void clickAddNewOrderBtn() {
		this.addNewOrderBtn.click();
	}
	
	public void clickContinueBtn() {
		this.continueBtn.click();
	}
	
	public boolean getrewardLists() {
		 int l = this.rewardLists.size();
		 if (l>0) {
			 return true;
		 }
		 else 
			 return false;
	  }
	public boolean verifyDisplayed(WebElement e, String name, String input) {
			if(e.isDisplayed()==true && input.equals("keyboard")) {
				if(e.getAttribute("value").equals(name)) {
//					System.out.println(e.getAttribute("value"));
					return true;
					}
				else
					return false;
		}
			else if (e.isDisplayed()==true && input.equals("select")) {
				Select sel1 = new Select(e);
			tes=	sel1.getFirstSelectedOption().getText();
					if(tes.equals(name)) {
//					System.out.println(tes);
					return true;
					}
				else
					return false;
			}
			
			else
			return false;
	}
	
	public boolean verifyDisplayedWithoutValue(WebElement e) {
		if(e.isDisplayed()==true) {
				return true;
				}
			else
				return false;
	}
		
	public ArrayList<String> listOfCustomerIcon(List<WebElement> ele) {
		ArrayList<String> app = new ArrayList<String>();
		for (WebElement e : ele) {
		
		app.add(e.getText());
	}
	return app;
}

}