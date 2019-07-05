package com.training.sanity.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
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

public class UNF_053 {
	
	private WebDriver driver;
	private String baseUrl;
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
		extent = new ExtentReports(System.getProperty("user.dir")+"\\test-output\\myUNF_053.html", true);
		extent.loadConfig(new File(System.getProperty("user.dir" )+ "\\tests\\com\\training\\sanity\\tests\\extent-config.xml\\"));
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		logger = extent.startTest("DeleteOrder");
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		mediumTCPOM = new MediumTCPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		logger.log(LogStatus.PASS,"Application Opened");
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
	public void invoiceVerify() throws InterruptedException {
		
		mediumTCPOM.sendUserName("admin");
		mediumTCPOM.sendPassword("admin@123");
		mediumTCPOM.clickLoginBtn(); 
		logger.log(LogStatus.PASS, "Login successfully");
		screenShot.captureScreenShot("Login page");
		Thread.sleep(1000);
		Actions act = new Actions(driver);
		act.moveToElement(mediumTCPOM.clickOrder()).moveToElement(mediumTCPOM.clickOrderLink()).click().build().perform();
		String msg = mediumTCPOM.getFirstMsg();
		Assert.assertEquals("Order List", msg);
		
		mediumTCPOM.clickViewIcon();
		String msghead = mediumTCPOM.getFirstMsg();
		Assert.assertEquals("Order Details", msghead);
		
		mediumTCPOM.clickInvoiceBtn();
		Thread.sleep(1000);
	boolean check = mediumTCPOM.verifyDisplayedWithoutValue(mediumTCPOM.invoiceNumber);
		Assert.assertEquals(true, check);
		
		mediumTCPOM.selectMethod(mediumTCPOM.orderStatus, "Complete");
		boolean  msg1 = mediumTCPOM.verifyDisplayed(mediumTCPOM.orderStatus, "Complete", "select");
		Assert.assertEquals(true, msg1);
		
		mediumTCPOM.clickAddHistoryBtn();
		
		String tab = mediumTCPOM.getTabText().substring(0, 34);
		Assert.assertEquals("Success: You have modified orders!", tab);
		
		
		
		
		

	}
}
