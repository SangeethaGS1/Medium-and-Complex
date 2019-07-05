package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
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
import com.training.pom.UniformPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UNF_051 {

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
//		System.out.println(System.getProperty("user.dir"));
		extent = new ExtentReports(System.getProperty("user.dir")+"\\test-output\\myUNF_051.html", true);
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
	public void customerCreate() throws InterruptedException {
		
		mediumTCPOM.sendUserName("admin");
		mediumTCPOM.sendPassword("admin@123");
		mediumTCPOM.clickLoginBtn(); 
		logger.log(LogStatus.PASS, "Login successfully");
		screenShot.captureScreenShot("First");
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		action.moveToElement(mediumTCPOM.getCustomerBtn()).moveToElement(mediumTCPOM.clickCustomerGroupLink()).click().build().perform();
		String actualCustomerPage = driver.getTitle();
		String expectedCustomerPage = "Customer Groups";
		Assert.assertEquals(actualCustomerPage, expectedCustomerPage);
		logger.log(LogStatus.PASS, "Customer group page");
		mediumTCPOM.clickAddNewBtnCustomer();
		String actualAddCustomerPage = driver.getTitle();
		String ExpectedAddCustomerPage = "Add Customer Group";
		mediumTCPOM.sendCustomerGrpName("Premium Member");
		boolean actualCGN = mediumTCPOM.verifyCustomerGrpName();
		boolean expectedCGN = true;
		Assert.assertEquals(expectedCGN, actualCGN);
		mediumTCPOM.sendcustomerDescription("Premium Member");
		boolean actualCD = mediumTCPOM.verifycustomerDescription();
		boolean expectedCD = true;
		Assert.assertEquals(actualCD, expectedCD);
		mediumTCPOM.clickrdBtn();
		boolean actualrd = mediumTCPOM.verifyrdBtn();
				boolean expectedrd = true;
		Assert.assertEquals(actualrd, expectedrd);
		mediumTCPOM.clickSaveBtn();
		String expectedSaveMsg = "Success: You have modified customer groups!"; 
		String actualSaveMsg = mediumTCPOM.getSuccessMsg().substring(0, 43);
		Assert.assertEquals(expectedSaveMsg, actualSaveMsg);
//		if (!actualSaveMsg.contains(expectedSaveMsg)) {
//			System.out.println("unable to modify the customer groups");
//			logger.log(LogStatus.FAIL, "unable to modify the customer groups");
//		}
		Thread.sleep(2000);
		Actions action1 = new Actions(driver);
		action1.moveToElement(mediumTCPOM.getCustomerBtn()).moveToElement(mediumTCPOM.getCustomerLink()).click().build().perform();
		//Customer List page
		String actualPageName = mediumTCPOM.title.getText();
		Assert.assertEquals("Customer List", actualPageName);/*changed to Customers from Customer List title*/
		Thread.sleep(2000);
		logger.log(LogStatus.PASS, "Customer add page");
		mediumTCPOM.clickAddNewBtnCustomer();
		//Add Customer page
		String actualAddCustomer = mediumTCPOM.title.getText();
		Assert.assertEquals("Add Customer", actualAddCustomer);
		Thread.sleep(2000);
		mediumTCPOM.selectMethod(mediumTCPOM.customerGrp, "Premium Member");
		boolean val = mediumTCPOM.verifyDisplayed(mediumTCPOM.customerGrp, "Premium Member","select");
//		System.out.println(mediumTCPOM.customerGrp);
	Assert.assertEquals(true, val);
		mediumTCPOM.sendNameValue("Reena",mediumTCPOM.sendFirstName);
		boolean FN = mediumTCPOM.verifyDisplayed(mediumTCPOM.sendFirstName, "Reena","keyboard");
		Assert.assertEquals(true, FN);
		mediumTCPOM.sendNameValue("Sharma", mediumTCPOM.sendLastName);
		boolean LN = mediumTCPOM.verifyDisplayed(mediumTCPOM.sendLastName, "Sharma", "keyboard");
		Assert.assertEquals(true, LN);
		mediumTCPOM.sendNameValue("reenasharma@gmail.com", mediumTCPOM.sendEmail);
		boolean email = mediumTCPOM.verifyDisplayed(mediumTCPOM.sendEmail, "reenasharma@gmail.com", "keyboard");
		Assert.assertEquals(true, email);
		mediumTCPOM.sendNameValue("9765433214", mediumTCPOM.sendPhone);
		boolean phone = mediumTCPOM.verifyDisplayed(mediumTCPOM.sendPhone, "9765433214", "keyboard");
		Assert.assertEquals(true, phone);

		
		mediumTCPOM.sendNameValue("reenas123", mediumTCPOM.sendPassword);
		boolean pwd = mediumTCPOM.verifyDisplayed(mediumTCPOM.sendPassword, "reenas123", "keyboard");
		Assert.assertEquals(true, pwd);
		
		mediumTCPOM.sendNameValue("reenas123", mediumTCPOM.sendConfirmPassword);
		boolean cpwd = mediumTCPOM.verifyDisplayed(mediumTCPOM.sendConfirmPassword, "reenas123", "keyboard");
		Assert.assertEquals(true, cpwd);
		
		mediumTCPOM.clickAddressBtn();
		
		mediumTCPOM.sendNameValue("Reena",mediumTCPOM.sendFirstName1);
		boolean FN1 = mediumTCPOM.verifyDisplayed(mediumTCPOM.sendFirstName1, "Reena","keyboard");
		Assert.assertEquals(true, FN1);
		mediumTCPOM.sendNameValue("Sharma", mediumTCPOM.sendLastName1);
		boolean LN1 = mediumTCPOM.verifyDisplayed(mediumTCPOM.sendLastName1, "Sharma", "keyboard");
		Assert.assertEquals(true, LN1);
		
		mediumTCPOM.sendNameValue("4th Block", mediumTCPOM.address1);
		boolean add1 = mediumTCPOM.verifyDisplayed(mediumTCPOM.address1, "4th Block", "keyboard");
		Assert.assertEquals(true, add1);
		
		mediumTCPOM.sendNameValue("Jayanagar", mediumTCPOM.address2);
		boolean add2 = mediumTCPOM.verifyDisplayed(mediumTCPOM.address2, "Jayanagar", "keyboard");
		Assert.assertEquals(true, add2);
		
		mediumTCPOM.sendNameValue("bangalore", mediumTCPOM.city);
		boolean city = mediumTCPOM.verifyDisplayed(mediumTCPOM.city, "bangalore", "keyboard");
		Assert.assertEquals(true, city);
		
		mediumTCPOM.sendNameValue("560014", mediumTCPOM.postalcode);
		boolean pc = mediumTCPOM.verifyDisplayed(mediumTCPOM.postalcode, "560014", "keyboard");
		Assert.assertEquals(true, pc);
		
		mediumTCPOM.selectMethod(mediumTCPOM.country, "India");
		boolean country = mediumTCPOM.verifyDisplayed(mediumTCPOM.country, "India", "select");
	Assert.assertEquals(true, country);	
		
		mediumTCPOM.selectMethod(mediumTCPOM.state, "Karnataka");
		boolean state = mediumTCPOM.verifyDisplayed(mediumTCPOM.state, "Karnataka", "select");
		Assert.assertEquals(true, state);	
		
		mediumTCPOM.clickSaveBtn();
		
		String finalExpectedmsg = "Success: You have modified customers!";
		String finalActualmsg = mediumTCPOM.getFinalSuccessMsg().substring(0, 37);
		System.out.println(finalActualmsg);
		Assert.assertEquals(finalExpectedmsg,finalActualmsg);
//		if(!finalActualmsg.contains(finalExpectedmsg)) {
//			System.out.println("Unable to modify the customers");
//			logger.log(LogStatus.FAIL, "Unable to modify the customers");
//			Assert.assertTrue(false);
//		}
		
		
				
		
		
}
	
}
