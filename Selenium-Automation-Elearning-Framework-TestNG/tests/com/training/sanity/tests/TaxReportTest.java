package com.training.sanity.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import com.training.pom.UniformPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TaxReportTest {
	
	private WebDriver driver;
	private String baseUrl;
	private UniformPOM uniformPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	static ExtentReports extent;
	ExtentTest logger;
	String[] reportsTextLinkExpected = {"Sales", "Products", "Customers", "Marketing"};

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
//		System.out.println(System.getProperty("user.dir"));
		extent = new ExtentReports(System.getProperty("user.dir")+"\\test-output\\myTax.html", true);
		extent.loadConfig(new File(System.getProperty("user.dir" )+ "\\tests\\com\\training\\sanity\\tests\\extent-config.xml\\"));
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		logger = extent.startTest("DeleteOrder");
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		uniformPOM = new UniformPOM(driver); 
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
	public void taxReport() throws InterruptedException {
		
		uniformPOM.sendUserName("admin");
		uniformPOM.sendPassword("admin@123");
		uniformPOM.clickLoginBtn(); 
		logger.log(LogStatus.PASS, "Login successfully");
		screenShot.captureScreenShot("First screen page");
		Thread.sleep(1000);
//		int reportsLinkTotal = uniformPOM.getreportList().size();
//		ArrayList<String> reportsTextLinkActual = new ArrayList<String>();
//		for (int i=0;i<uniformPOM.getreportList().size();i++) {
//			reportsTextLinkActual.add(uniformPOM.getreportList().get(i).getText());
//				}
//		Assert.assertEquals(reportsTextLinkActual, reportsTextLinkExpected);
		Actions action = new Actions(driver);
		action.moveToElement(uniformPOM.reportElement()).moveToElement(uniformPOM.salesElement()).click().build().perform();
		uniformPOM.clickTaxElement();
		logger.log(LogStatus.PASS, "Successfully clicked Tax report");
		Thread.sleep(2000);
		Select sel = new Select(uniformPOM.groupBoxElement());
		sel.selectByVisibleText("Weeks");
		uniformPOM.clickFilterBtn();
//		System.out.println(driver.getTitle());
		screenShot.captureScreenShot("Tax order reports page");
		logger.log(LogStatus.PASS, driver.getTitle() + "page" );
		
	}
	
}
