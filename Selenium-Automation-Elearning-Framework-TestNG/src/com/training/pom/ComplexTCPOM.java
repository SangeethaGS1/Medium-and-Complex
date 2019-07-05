package com.training.pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ComplexTCPOM {
	
	private WebDriver driver; 
	public String tes;
		
		public ComplexTCPOM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(id="input-username")
		private WebElement userName; 
		
		@FindBy(id="input-password")
		private WebElement password;
		
		@FindBy(css="button.btn.btn-primary")
		private WebElement loginBtn; 

		@FindBy(xpath="//*[@id='catalog']/a")
		private WebElement catalog; 
		
		@FindBy(xpath="//*[@id='catalog']/ul/li/a")
		private WebElement categories; 
		
		@FindBy(xpath="//*[@id='form-category']//child::thead/tr/td")
		private List<WebElement> categoriesColumn;
		
		@FindBy(xpath="//*[@id='content']/div/div/div/a")
		public WebElement addNewBtn;
		
		@FindBy(xpath="//*[@id='content']//child::h3")
		public WebElement pageAddText;
		
		@FindBy(id="input-name1")
		public WebElement categoryName;
		
		@FindBy(xpath="//*[@class='note-editable panel-body']")
		public WebElement categoryDescription;
		
		@FindBy(id="input-meta-title1")
		public WebElement megaTitle;
		
		@FindBy(id="input-meta-description1")
		public WebElement megaTitleDescription;
		
		@FindBy(linkText="Data")
		public WebElement dataTab;
		
		@FindBy(id="input-column")
		public WebElement inputColumn;
		
		@FindBy(id="input-sort-order")
		public WebElement inputOrder;
		
		@FindBy(id="input-status")
		public WebElement inputStatus;
		
		@FindBy(linkText="Design")
		public WebElement designTab;
		
		@FindBy(xpath="//*[@id='content']//child::button[@type='submit']")
		public WebElement saveCategoryBtn;
		
		@FindBy(xpath="//*[@id='content']/div[2]/div")
		public WebElement savedCategoryMsg;
		
		@FindBy(xpath="//*[@id='content']/div[2]//child::h3")
		public WebElement savedCategoryMsgPage;
		
		@FindBy(linkText="Products")
		private WebElement products;
		
		@FindBy(xpath="//*[@id='content']/div[2]//child::h3")
		public WebElement productListPage;
		
		@FindBy(xpath="//*[@id='content']/div[@class='page-header']//child::a[@class='btn btn-primary']")
		public WebElement addProductNewbtn;
		
		@FindBy(id="input-name1")
		public WebElement productname;
		
		@FindBy(id="input-meta-title1")
		public WebElement MetaTitleProduct;
		
		@FindBy(id="input-model")
		public WebElement model;
		
		@FindBy(linkText="Links")
		public WebElement linkTab;
		
		@FindBy(xpath="//*[@id='tab-links']/div/label")
		public WebElement manufacturer;
		
		@FindBy(id="input-category")
		public WebElement inputCategory;
		
		@FindBy(xpath="//*[@id='input-category']//following-sibling::ul/li")
		private List<WebElement> categoryList;
		
		@FindBy(xpath="//*[@id='product-category']/div")
		public WebElement getCategory;
		
		@FindBy(xpath="//*[@type='submit']")
		public WebElement SaveBtn;
		
		@FindBy(xpath="//*[@id='content']/div[2]/div")
		public WebElement finalmsg;
		
		  @FindBy(xpath="//li[@id='sale']/a/i")
			private WebElement order;
		  
			@FindBy(xpath="//li[@id='sale']/ul/li/a")
			private WebElement orderlink;
	
			  @FindBy(xpath="//*[@id='content']//child::h3")
			  public WebElement title;
			  
			  @FindBy(xpath="//*[@id='form-order']//child::tbody/tr[1]/td[8]/a[2]")
				public WebElement editOrderBtn; 
			
			  @FindBy(id="button-customer")
			  public WebElement firstContinue;
			  
			  @FindBy(linkText="2. Products")
			  public WebElement productTab;
			  
			  @FindBy(xpath="//*[@id='cart']/tr[1]")
			  public WebElement cart;
			  
			  @FindBy(xpath="//*[@id='cart']/tr[1]/td[6]/button")
			  public WebElement deleteBtn;
			  
			  @FindBy(id="input-product")
				public WebElement inputprsdt;
			  
			  @FindBy(id="input-quantity")
				public WebElement quantity;
			  
				@FindBy(xpath="//*[@id='input-product']//following-sibling::ul/li")
				private List<WebElement> productList;
				
				@FindBy(id="button-product-add")
				public WebElement AddProductBtn;
				
				@FindBy(xpath="//*[@id='cart']/tr/td[1]")
				private List<WebElement> productLis;
				
				@FindBy(id="button-cart")
				public WebElement continueCart;
				
				@FindBy(linkText="3. Payment Details")
				public WebElement PDtab;
				
				  @FindBy(id="button-payment-address")
				  public WebElement continueCartBtn;
				  
				  @FindBy(linkText="4. Shipping Details")
					public WebElement SDtab; 
				
				  @FindBy(id="button-shipping-address")
				  public WebElement BSContBtn;
				  
				  @FindBy(linkText="5. Totals")
						public WebElement total; 
				  
				  @FindBy(id="button-save")
				  public WebElement finalsaveBtn; 
				  
				  @FindBy(xpath="//*[@id='order']/li[2]")
				  public WebElement cartList;
				  
				  @FindBy(xpath="//*[@id='order']/li[3]")
					public WebElement PDtaben;
				  
				  @FindBy(xpath="//*[@id='order']/li[4]")
					public WebElement SDtaben;
				  
				  @FindBy(xpath="//*[@id='order']/li[5]")
					public WebElement totalen;
				  
				  @FindBy(id="input-shipping-method")
				  public WebElement inputShipping;
				  
				  @FindBy(id="button-shipping-method")
				public WebElement applyBtn;
				  
					public void selectMethodbyValue(WebElement ele, String value) {
						Select sel = new Select(ele);
						sel.selectByValue(value);	}
				
				public ArrayList<String> getValuesOfProducts() {
					ArrayList<String> lest = new ArrayList<String>();
					for (WebElement e : this.productLis) {
						lest.add(e.getText());
					}
					return lest;
				}
				
//			  public String getcartSize() {
//				 
//				  return this.cart.getAttribute("value");
//			  }
			  
			  public boolean verifyproductTabEnabled(WebElement e) {
					String value = e.getAttribute("class");
					System.out.println(value);
					if (value.contains("active")) {
						return true;
							}
					else 
						return false;
					}
			  
			  public String getFirstMsg() {
					return this.title.getText();
				}
			  
		public void clickCategory() {
			Actions act = new Actions(driver);
			act.click(this.catalog).click(this.categories).build().perform();
		}
		
		public void clickProduct() {
			Actions act = new Actions(driver);
			act.click(this.catalog).click(this.products).build().perform();

		}
		
		public void clickOrder() {
			Actions act = new Actions(driver);
			act.click(this.order).click(this.orderlink).build().perform();
		}
		
		public List<String> getCategoryColumn(){
			List<String> columnList = new ArrayList<String>();
			int size = this.categoriesColumn.size();
			for (int i=1;i<size;i++) {
			columnList.add(this.categoriesColumn.get(i).getText());
			}
			return columnList;
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
		
		public void sendNameValue(String firstName, WebElement WE) {
			WE.clear();
			WE.sendKeys(firstName);
		}
		
		public void clickName( WebElement WE) {
			WE.click();
		}
		
		public String getTextMethod( WebElement WE) {
		String s = 	WE.getText();
		return s;
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
		
		public void getListofCategory(String Category) {
			ArrayList<String> result = new ArrayList<String>();
			int si = this.categoryList.size();
			for (int i=0;i<si;i++) {
			result.add(this.categoryList.get(i).getText());
			
			if(this.categoryList.get(i).getText().contains(Category)) {
			 this.categoryList.get(i).click();
			 System.out.println(result);
				break;
			}
			}
			System.out.println(result);	
		}
		
		public void getListofProducts(String ProductName) throws InterruptedException {
			ArrayList<String> result1 = new ArrayList<String>();
			int si1 = this.productList.size();
			System.out.println(si1);
			for (int i=0;i<si1;i++) {
			result1.add(this.productList.get(i).getText());
			
			if(this.productList.get(i).getText().contains(ProductName)) {
				Thread.sleep(1000);
			 this.productList.get(i).click();
			 Thread.sleep(1000);
			 System.out.println(result1);
				break;
			}
			}
			System.out.println(result1);	
		}
}
