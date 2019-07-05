package com.training.sanity.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.dataproviders.ComplexDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.ComplexTCPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UNF_077 {
	
	private WebDriver driver;
	private String baseUrl;
	private ComplexTCPOM complexTCPOM;
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
//		System.out.println(System.getProperty("user.dir"));
		extent = new ExtentReports(System.getProperty("user.dir")+"\\test-output\\myUNF_077.html", true);
		extent.loadConfig(new File(System.getProperty("user.dir" )+ "\\tests\\com\\training\\sanity\\tests\\extent-config.xml\\"));
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
//		logger = extent.startTest("ModifyOrder");
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		complexTCPOM = new ComplexTCPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
//		logger.log(LogStatus.PASS,"Application Opened");
		complexTCPOM.sendUserName("admin");
		complexTCPOM.sendPassword("admin@123");
		complexTCPOM.clickLoginBtn(); 
//		logger.log(LogStatus.PASS, "Login successfully");
		Thread.sleep(1000);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test(dataProvider = "excel-inputs2", dataProviderClass = ComplexDataProviders.class)
	public void createCategory(String ProductName, String Quantity) throws InterruptedException {
		complexTCPOM.clickOrder();
		String Actual = driver.getTitle();
		String Actualsub = complexTCPOM.getFirstMsg();
		Assert.assertEquals("Orders", Actual);
		Assert.assertEquals("Order List", Actualsub);
		
		complexTCPOM.clickName(complexTCPOM.editOrderBtn);
		String Actualsub1 = complexTCPOM.getFirstMsg();
		Assert.assertEquals("Edit Order", Actualsub1);
		Thread.sleep(2000);
		complexTCPOM.clickName(complexTCPOM.firstContinue);
		Thread.sleep(2000);
		boolean sc = complexTCPOM.verifyproductTabEnabled(complexTCPOM.cartList);
		Thread.sleep(2000);
		System.out.println(sc);
		Assert.assertEquals(true, sc);
		
		if (!complexTCPOM.getTextMethod(complexTCPOM.cart).contains("No results!")) {
			complexTCPOM.clickName(complexTCPOM.deleteBtn);
		}
		
//		complexTCPOM.sendNameValue(ProductName, complexTCPOM.inputprsdt);
//		boolean prdt = complexTCPOM.verifyDisplayed(complexTCPOM.inputprsdt, ProductName, "keyboard");
//		Assert.assertEquals(true, prdt);
		
			Thread.sleep(2000);
		complexTCPOM.clickName(complexTCPOM.inputprsdt);
		complexTCPOM.sendNameValue(ProductName, complexTCPOM.inputprsdt);
		Thread.sleep(2000);
		complexTCPOM.getListofProducts(ProductName);
		String actualLink1 = complexTCPOM.getTextMethod(complexTCPOM.inputprsdt);
				Assert.assertTrue(!actualLink1.contains(ProductName));
		
		
		complexTCPOM.sendNameValue(Quantity, complexTCPOM.quantity);
		boolean quan = complexTCPOM.verifyDisplayed(complexTCPOM.quantity, Quantity, "keyboard");
		Assert.assertEquals(true, quan);
		Thread.sleep(2000);
		complexTCPOM.clickName(complexTCPOM.AddProductBtn);
		Thread.sleep(2000);
		ArrayList<String> productLists = complexTCPOM.getValuesOfProducts();
		for (String e : productLists) {
			
			if (e.contains(ProductName)) {
					break;
			}
			else 
				System.out.println("Added products not available");
		}
		Thread.sleep(2000);
		complexTCPOM.clickName(complexTCPOM.continueCart);
		Thread.sleep(2000);
		boolean pd = complexTCPOM.verifyproductTabEnabled(complexTCPOM.PDtaben);
		Assert.assertEquals(true, pd);
		
		complexTCPOM.clickName(complexTCPOM.continueCartBtn);
		Thread.sleep(2000);
		boolean sd = complexTCPOM.verifyproductTabEnabled(complexTCPOM.SDtaben);
		Assert.assertEquals(true, sd);
		
		complexTCPOM.clickName(complexTCPOM.BSContBtn);
		Thread.sleep(2000);
		boolean td = complexTCPOM.verifyproductTabEnabled(complexTCPOM.totalen);
		Assert.assertEquals(true, td);
		
		complexTCPOM.selectMethodbyValue(complexTCPOM.inputShipping, "free.free");
		System.out.println(complexTCPOM.tes);
		Select sel1 = new Select(complexTCPOM.inputShipping);
		String Act = sel1.getFirstSelectedOption().getText().substring(0, 13);
		Assert.assertEquals(Act, "Free Shipping");

		complexTCPOM.clickName(complexTCPOM.applyBtn);
		Thread.sleep(2000);
		
		complexTCPOM.clickName(complexTCPOM.finalsaveBtn);
		Thread.sleep(2000);
		String actualfmsg = complexTCPOM.getTextMethod(complexTCPOM.finalmsg).substring(0, 34);
		Assert.assertEquals(actualfmsg, "Success: You have modified orders!");	
		
		
	}

}
