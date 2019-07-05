package com.training.sanity.tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ScreenShot;
import com.training.pom.MediumTCPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UNF_054 {
	
	private WebDriver driver;
	private String baseUrl;
	private String custURL;
	private String parent_window;
	private String child_window;
	private MediumTCPOM mediumTCPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	static ExtentReports extent;
	ExtentTest logger;
	//comment
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		extent = new ExtentReports(System.getProperty("user.dir")+"\\test-output\\myUNF_054.html", true);
		extent.loadConfig(new File(System.getProperty("user.dir" )+ "\\tests\\com\\training\\sanity\\tests\\extent-config.xml\\"));
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		logger = extent.startTest("CreateOrder");
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		mediumTCPOM = new MediumTCPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		custURL = properties.getProperty("CustomerURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
//		logger.log(LogStatus.PASS,"Customer login page Opened");
		 parent_window = driver.getWindowHandle();
		 System.out.println(parent_window);
		logger.log(LogStatus.PASS,"Admin Application Opened");
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
		logger.log(LogStatus.PASS, "Application closed Successfully");
		extent.endTest(logger);
		extent.flush();
		extent.close();
	}
	
	@Test
	public void orderByAdmin() throws InterruptedException, AWTException {
	
		Robot robot = new Robot();                          
		robot.keyPress(KeyEvent.VK_CONTROL); 
		robot.keyPress(KeyEvent.VK_T); 
		robot.keyRelease(KeyEvent.VK_CONTROL); 
		robot.keyRelease(KeyEvent.VK_T);
		Thread.sleep(2000);
	ArrayList<String> tab = new ArrayList<String> (driver.getWindowHandles());
System.out.println(tab.size());
//driver.switchTo().window(tab.get(1));
//driver.get(custURL);
	if(!tab.get(1).equals(parent_window)) {
		child_window = tab.get(1);
		System.out.println(child_window);
		driver.switchTo().window(child_window);
		driver.get(custURL);
		Thread.sleep(2000);
//	mediumTCPOM.userBtn.click();
		Actions ac1 = new Actions(driver);
ac1.click(mediumTCPOM.userBtn).click(mediumTCPOM.userLoginBtn).build().perform();

//		ac1.clickAndHold(mediumTCPOM.userBtn).perform();
//		ac1.keyDown(Keys.CONTROL).keyDown(Keys.ARROW_DOWN).keyDown(Keys.ARROW_DOWN).click().build().perform();
//	
		Thread.sleep(2000);
		mediumTCPOM.sendNameValue("hema.chandra@gmail.com", mediumTCPOM.emailid);
		mediumTCPOM.sendNameValue("welcome@123", mediumTCPOM.loginpwd);
		mediumTCPOM.lbtn.click();
		
	}

Thread.sleep(2000);
driver.switchTo().window(parent_window);
		mediumTCPOM.sendUserName("admin");
		mediumTCPOM.sendPassword("admin@123");
		mediumTCPOM.clickLoginBtn(); 
		logger.log(LogStatus.PASS, "Login successfully");
		screenShot.captureScreenShot("Login page");
		Thread.sleep(1000);
	Actions ac = new Actions(driver);
//	ac.moveToElement(mediumTCPOM.report).moveToElement(mediumTCPOM.sales).click().build().perform();
//	
//	mediumTCPOM.clickSalesOrder();
	ac.moveToElement(mediumTCPOM.clickOrder()).moveToElement(mediumTCPOM.clickOrderLink()).click().build().perform();
	String Actual = driver.getTitle();
	String Actualsub = mediumTCPOM.getFirstMsg();
	Assert.assertEquals("Orders", Actual);
	Assert.assertEquals("Order List", Actualsub);
	
	mediumTCPOM.clickAddNewOrderBtn();
	String pageTab = mediumTCPOM.getFirstMsg();
	Assert.assertEquals("Add Order", pageTab);
	
//	mediumTCPOM.sendNameValue("Hema Chandra", mediumTCPOM.customerName);
//	boolean cn=	mediumTCPOM.verifyDisplayed(mediumTCPOM.customerName, "Hema Chandra", "keyboard");
//	Assert.assertEquals(true, cn);

	
//	mediumTCPOM.sendNameValue("Hema", mediumTCPOM.sendFirstName);
//boolean fn=	mediumTCPOM.verifyDisplayed(mediumTCPOM.sendFirstName, "Hema", "keyboard");
//Assert.assertEquals(true, fn);
//
//mediumTCPOM.sendNameValue("Chandra", mediumTCPOM.sendLastName);
//boolean LN = mediumTCPOM.verifyDisplayed(mediumTCPOM.sendLastName, "Chandra", "keyboard");
//Assert.assertEquals(true, LN);
//
//mediumTCPOM.sendNameValue("hema.chandra@gmail.com", mediumTCPOM.sendEmail);
//boolean email = mediumTCPOM.verifyDisplayed(mediumTCPOM.sendEmail, "hema.chandra@gmail.com", "keyboard");
//Assert.assertEquals(true, email);
//
//mediumTCPOM.sendNameValue("9654321678", mediumTCPOM.sendPhone);
//boolean phone = mediumTCPOM.verifyDisplayed(mediumTCPOM.sendPhone, "9654321678", "keyboard");
//Assert.assertEquals(true, phone);
Thread.sleep(2000);
mediumTCPOM.sendNameValue("Sangeetha", mediumTCPOM.sendFirstName);
boolean fn=	mediumTCPOM.verifyDisplayed(mediumTCPOM.sendFirstName, "Sangeetha", "keyboard");
Assert.assertEquals(true, fn);

mediumTCPOM.sendNameValue("G S", mediumTCPOM.sendLastName);
boolean LN = mediumTCPOM.verifyDisplayed(mediumTCPOM.sendLastName, "G S", "keyboard");
Assert.assertEquals(true, LN);

mediumTCPOM.sendNameValue("sangeetha@gmail.com", mediumTCPOM.sendEmail);
boolean email = mediumTCPOM.verifyDisplayed(mediumTCPOM.sendEmail, "sangeetha@gmail.com", "keyboard");
Assert.assertEquals(true, email);

mediumTCPOM.sendNameValue("123456789", mediumTCPOM.sendPhone);
boolean phone = mediumTCPOM.verifyDisplayed(mediumTCPOM.sendPhone, "123456789", "keyboard");
Assert.assertEquals(true, phone);

mediumTCPOM.clickContinueBtn();

Thread.sleep(5000);
boolean en = mediumTCPOM.verifyproductTabEnabled();
Assert.assertEquals(true, en);

Thread.sleep(2000);
//mediumTCPOM.sendNameValue("SPORTS T-SHIRTS", mediumTCPOM.inputprsdt);
//boolean prdt = mediumTCPOM.verifyDisplayed(mediumTCPOM.inputprsdt, "SPORTS T-SHIRTS", "keyboard");
//Assert.assertEquals(true, prdt);
//
//Thread.sleep(2000);
//mediumTCPOM.sendNameValue("1", mediumTCPOM.quantity);
//boolean quan = mediumTCPOM.verifyDisplayed(mediumTCPOM.quantity, "1", "keyboard");
//Assert.assertEquals(true, quan);
//
//mediumTCPOM.clickAddprdt();
//
//Thread.sleep(2000);
//
//ArrayList<String> productLists = mediumTCPOM.getValuesOfProducts();
//for (String e : productLists) {
//	if (e.contains("Blazer Girls")) {
//		System.out.println("Product successfully added");
//	}
//}

mediumTCPOM.clickContinueCart();


mediumTCPOM.sendNameValue("Hema",mediumTCPOM.sendFirstNameip);
boolean FN1 = mediumTCPOM.verifyDisplayed(mediumTCPOM.sendFirstNameip, "Hema","keyboard");
Assert.assertEquals(true, FN1);

mediumTCPOM.sendNameValue("Chandra", mediumTCPOM.sendLastNameip);
boolean LN1 = mediumTCPOM.verifyDisplayed(mediumTCPOM.sendLastNameip, "Chandra", "keyboard");
Assert.assertEquals(true, LN1);

mediumTCPOM.sendNameValue("6th Phase", mediumTCPOM.address1ip);
boolean add1 = mediumTCPOM.verifyDisplayed(mediumTCPOM.address1ip, "6th Phase", "keyboard");
Assert.assertEquals(true, add1);

mediumTCPOM.sendNameValue("J P Nagar", mediumTCPOM.address2ip);
boolean add2 = mediumTCPOM.verifyDisplayed(mediumTCPOM.address2ip, "J P Nagar", "keyboard");
Assert.assertEquals(true, add2);

mediumTCPOM.sendNameValue("bangalore", mediumTCPOM.cityip);
boolean city = mediumTCPOM.verifyDisplayed(mediumTCPOM.cityip, "bangalore", "keyboard");
Assert.assertEquals(true, city);

mediumTCPOM.sendNameValue("560078", mediumTCPOM.postalcodeip);
boolean pc = mediumTCPOM.verifyDisplayed(mediumTCPOM.postalcodeip, "560078", "keyboard");
Assert.assertEquals(true, pc);

mediumTCPOM.selectMethod(mediumTCPOM.countryip, "India");
boolean country = mediumTCPOM.verifyDisplayed(mediumTCPOM.countryip, "India", "select");
Assert.assertEquals(true, country);	

mediumTCPOM.selectMethod(mediumTCPOM.stateip, "Karnataka");
boolean state = mediumTCPOM.verifyDisplayed(mediumTCPOM.stateip, "Karnataka", "select");
Assert.assertEquals(true, state);	

mediumTCPOM.clickContinueCartPay();

mediumTCPOM.sendNameValue("Hema",mediumTCPOM.sendFirstNameship);
boolean FNs = mediumTCPOM.verifyDisplayed(mediumTCPOM.sendFirstNameship, "Hema","keyboard");
Assert.assertEquals(true, FNs);

mediumTCPOM.sendNameValue("Chandra", mediumTCPOM.sendLastNameship);
boolean LNs = mediumTCPOM.verifyDisplayed(mediumTCPOM.sendLastNameship, "Chandra", "keyboard");
Assert.assertEquals(true, LNs);

mediumTCPOM.sendNameValue("6th Phase", mediumTCPOM.address1ship);
boolean add1s = mediumTCPOM.verifyDisplayed(mediumTCPOM.address1ship, "6th Phase", "keyboard");
Assert.assertEquals(true, add1s);

mediumTCPOM.sendNameValue("J P Nagar", mediumTCPOM.address2ship);
boolean add2s = mediumTCPOM.verifyDisplayed(mediumTCPOM.address2ship, "J P Nagar", "keyboard");
Assert.assertEquals(true, add2s);

mediumTCPOM.sendNameValue("bangalore", mediumTCPOM.cityship);
boolean citys = mediumTCPOM.verifyDisplayed(mediumTCPOM.cityship, "bangalore", "keyboard");
Assert.assertEquals(true, citys);

mediumTCPOM.sendNameValue("560078", mediumTCPOM.postalcodeship);
boolean pcs = mediumTCPOM.verifyDisplayed(mediumTCPOM.postalcodeship, "560078", "keyboard");
Assert.assertEquals(true, pcs);

mediumTCPOM.selectMethod(mediumTCPOM.countryship, "India");
boolean countrys = mediumTCPOM.verifyDisplayed(mediumTCPOM.countryship, "India", "select");
Assert.assertEquals(true, countrys);	

mediumTCPOM.selectMethod(mediumTCPOM.stateship, "Karnataka");
boolean states = mediumTCPOM.verifyDisplayed(mediumTCPOM.stateship, "Karnataka", "select");
Assert.assertEquals(true, states);	

mediumTCPOM.clickContinueCartBtnship();

mediumTCPOM.selectMethodbyValue(mediumTCPOM.inputShipping, "free.free");
System.out.println(mediumTCPOM.tes);
Select sel1 = new Select(mediumTCPOM.inputShipping);
String Act = sel1.getFirstSelectedOption().getText().substring(0, 13);
Assert.assertEquals(Act, "Free Shipping");

mediumTCPOM.clickApplyBtn();

mediumTCPOM.selectMethod(mediumTCPOM.COD, "Cash On Delivery");
boolean cod = mediumTCPOM.verifyDisplayed(mediumTCPOM.COD, "Cash On Delivery", "select");
Assert.assertEquals(true, cod);

mediumTCPOM.clickCODBtn();

mediumTCPOM.selectMethod(mediumTCPOM.orderStatus, "Complete");
boolean os = mediumTCPOM.verifyDisplayed(mediumTCPOM.orderStatus, "Complete", "select");
Assert.assertEquals(true, os);

mediumTCPOM.clickBtnSave();

	Thread.sleep(2000);
	String ActualTCPlacedOrder = mediumTCPOM.getPlacedOrder().substring(0, 34);
	Assert.assertEquals("Success: You have modified orders!", ActualTCPlacedOrder);
	logger.log(LogStatus.PASS, "Placed Order successfully");
	
	}
}
