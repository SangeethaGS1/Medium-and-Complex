package com.training.sanity.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ScreenShot;
import com.training.pom.UniformPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ReturnOrderTest {
	
	
	private WebDriver driver;
	private String baseUrl;
	private UniformPOM uniformPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	static ExtentReports extent;
	ExtentTest logger;
	String rId ="147";
	String cId = "Sangeetha G S";
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
//		System.out.println(System.getProperty("user.dir"));
		extent = new ExtentReports(System.getProperty("user.dir")+"\\test-output\\my2ns.html", true);
		extent.loadConfig(new File(System.getProperty("user.dir" )+ "\\tests\\com\\training\\sanity\\tests\\extent-config.xml\\"));
	}
	@BeforeMethod
	public void setUp() throws Exception {
		logger = extent.startTest("ReturnOrder");
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		uniformPOM = new UniformPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		logger.log(LogStatus.PASS, "Application Opened");
	}
	
	@Test
	public void returnOrder() throws InterruptedException {
		
		uniformPOM.sendUserName("admin");
		uniformPOM.sendPassword("admin@123");
		uniformPOM.clickLoginBtn();
		logger.log(LogStatus.PASS, "Successfully logged in");
		Thread.sleep(1000);
		uniformPOM.clickOrder();
		Actions action = new Actions(driver);
		action.moveToElement(uniformPOM.clickOrder()).perform();
		uniformPOM.clickreturnLink();
		logger.log(LogStatus.PASS, "Clicked on ReturnOrders link");
		Thread.sleep(2000);
		uniformPOM.sendreturnId(rId);
		uniformPOM.clickFilterBtn();
		int size = uniformPOM.getReturnOrderLists().size();
		logger.log(LogStatus.PASS, "Size of Filtered return orders - " +size);
		for (int i=0;i<size;i++) {
//			System.out.println(uniformPOM.getReturnOrderLists().get(i).getText());
			if (!uniformPOM.getReturnOrderLists().get(i).getText().equals(rId)){
				logger.log(LogStatus.FAIL, "Return Orders are not same as provided in the criteria");
			}
			else
				logger.log(LogStatus.PASS, "Return Orders are same as provided in the criteria");	
		}
		
		uniformPOM.clearreturnId();
		uniformPOM.sendcustomerBox(cId);
		uniformPOM.clickFilterBtn();
		
		int sizeC = uniformPOM.getReturnOrderCustomerLists().size();
		logger.log(LogStatus.PASS, "Size of Filtered return orders based on entered data in customer - " +sizeC );
		for (int i=0;i<size;i++) {
//			System.out.println(uniformPOM.getReturnOrderLists().get(i).getText());
			if (!uniformPOM.getReturnOrderCustomerLists().get(i).getText().equals(cId)){
				logger.log(LogStatus.FAIL, "Return Orders are not same as provided in the Customer Text criteria");
			}
			else
				logger.log(LogStatus.PASS, "Return Orders are same as provided in the Customer Text criteria");	
		}
		
		
		
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

}
