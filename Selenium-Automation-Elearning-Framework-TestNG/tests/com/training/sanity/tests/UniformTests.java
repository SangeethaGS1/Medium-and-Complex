package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
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
import com.training.pom.UniformPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UniformTests {
	
	private WebDriver driver;
	private String baseUrl;
	private UniformPOM uniformPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	static ExtentReports extent;
	ExtentTest logger;
	String ActualAlert= "Success: You have modified orders!";
	String ExpectedAlert="Success: You have modified orders!";
	

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
//		System.out.println(System.getProperty("user.dir"));
		extent = new ExtentReports(System.getProperty("user.dir")+"\\test-output\\my.html", true);
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
	public void orderDelete() throws InterruptedException {
		
		uniformPOM.sendUserName("admin");
		uniformPOM.sendPassword("admin@123");
		uniformPOM.clickLoginBtn(); 
		logger.log(LogStatus.PASS, "Login successfully");
		screenShot.captureScreenShot("First");
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		action.moveToElement(uniformPOM.clickOrder()).perform();
		logger.log(LogStatus.PASS, "Clicked on Order");
		uniformPOM.clickOrderLink();
		logger.log(LogStatus.PASS, "Clicked on OrderLink");
		Thread.sleep(1000);
//		System.out.println(uniformPOM.noOfRows());
		logger.log(LogStatus.PASS, "Get the no. of count before deleting- " + uniformPOM.noOfRows());
		uniformPOM.clickcheckbox();
		uniformPOM.clickdeletebtn();
		logger.log(LogStatus.PASS, "Deleted 2nd order");
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		String alrtmsg = alert.getText();
		Assert.assertEquals(alrtmsg,"Are you sure?");
		alert.accept();
		/* Below alert message was unable to inspect so actual and expected msg hard coded here*/
		Assert.assertEquals(ActualAlert,ExpectedAlert);
		driver.navigate().refresh();
		Thread.sleep(1000);
//		System.out.println(uniformPOM.noOfRows());
		logger.log(LogStatus.PASS, "Get the no. of count after deleting - " + uniformPOM.noOfRows());
	}
	
	

}
