package com.training.sanity.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

public class UNF_052 {
	
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
		extent = new ExtentReports(System.getProperty("user.dir")+"\\test-output\\myUNF_052.html", true);
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
	public void rewardPointsVerify() throws InterruptedException {
		
		mediumTCPOM.sendUserName("admin");
		mediumTCPOM.sendPassword("admin@123");
		mediumTCPOM.clickLoginBtn(); 
		logger.log(LogStatus.PASS, "Login successfully");
		screenShot.captureScreenShot("Login page");
		Thread.sleep(1000);
//		ArrayList<String> expected = mediumTCPOM.listOfCustomerIcon(mediumTCPOM.customerIcon);
//		ArrayList<String> actual = new ArrayList<String>();
//		actual.add("Customers");
//		actual.add("Customer Group");
//		actual.add("Custom Fields");
//		Assert.assertEquals(expected,actual);
		Actions act = new Actions(driver);
		act.moveToElement(mediumTCPOM.getCustomerBtn())
		.moveToElement(mediumTCPOM.getCustomerLink())
		.click().build().perform();
		String actualPageName = mediumTCPOM.title.getText();
		Assert.assertEquals("Customer List", actualPageName);
		mediumTCPOM.clickEditBtn();
		String actualPN = mediumTCPOM.title.getText();
		Assert.assertEquals("Edit Customer", actualPN);

		mediumTCPOM.sendFirstName.clear();
		mediumTCPOM.sendNameValue("",mediumTCPOM.sendFirstName);
		boolean FNR = mediumTCPOM.verifyDisplayed(mediumTCPOM.sendFirstName, "","keyboard");
		Assert.assertEquals(true, FNR);
		
		mediumTCPOM.sendNameValue("Deepa",mediumTCPOM.sendFirstName);
		boolean FN = mediumTCPOM.verifyDisplayed(mediumTCPOM.sendFirstName, "Deepa","keyboard");
		Assert.assertEquals(true, FN);
		
		mediumTCPOM.clickadd1Link();
		boolean a = mediumTCPOM.verifyDisplayedWithoutValue(mediumTCPOM.sendFirstName1);
		Assert.assertEquals(true, a);
		boolean b =mediumTCPOM.verifyDisplayedWithoutValue(mediumTCPOM.sendLastName1);
		Assert.assertEquals(true, b);
		boolean c= mediumTCPOM.verifyDisplayedWithoutValue(mediumTCPOM.address1);
		Assert.assertEquals(true, c);
		boolean d =mediumTCPOM.verifyDisplayedWithoutValue(mediumTCPOM.address2);
		Assert.assertEquals(true, d);
		boolean e =mediumTCPOM.verifyDisplayedWithoutValue(mediumTCPOM.city);
		Assert.assertEquals(true, e);
		boolean f =mediumTCPOM.verifyDisplayedWithoutValue(mediumTCPOM.postalcode);
		Assert.assertEquals(true, f);
		boolean g =mediumTCPOM.verifyDisplayedWithoutValue(mediumTCPOM.country);
		Assert.assertEquals(true, g);
		boolean h =mediumTCPOM.verifyDisplayedWithoutValue(mediumTCPOM.state);
		Assert.assertEquals(true, h);
		
		mediumTCPOM.sendNameValue("8796545", mediumTCPOM.postalcode);
		boolean pc = mediumTCPOM.verifyDisplayed(mediumTCPOM.postalcode, "8796545", "keyboard");
		Assert.assertEquals(true, pc);
		//Rewards point page
		mediumTCPOM.clickRewardPoints();
		boolean button = mediumTCPOM.verifyEnabled();
		Assert.assertEquals(true, button);
		
		mediumTCPOM.sendNameValue("Festival bonanza", mediumTCPOM.rewardDesc);
		boolean RD = mediumTCPOM.verifyDisplayed(mediumTCPOM.rewardDesc, "Festival bonanza", "keyboard");
		Assert.assertEquals(true, RD);
		
		mediumTCPOM.sendNameValue("30", mediumTCPOM.points);
		boolean poin = mediumTCPOM.verifyDisplayed(mediumTCPOM.points, "30", "keyboard");
		Assert.assertEquals(true, poin);
		
		mediumTCPOM.clickAddRewardPoint();
		Thread.sleep(1000);
		String finalRewardActualmsg = mediumTCPOM.getRewardSuccessMsg().substring(0, 37)	;
		String finalRewardExpectedmsg ="Success: You have modified customers!";
		Assert.assertEquals(finalRewardExpectedmsg,finalRewardActualmsg);
		
		mediumTCPOM.clickSaveBtn();
		
		String finalExpectedmsg = "Success: You have modified customers!";
		String finalActualmsg = mediumTCPOM.getFinalSuccessMsg().substring(0, 37);
		Assert.assertEquals(finalExpectedmsg,finalActualmsg);
		
		Actions ac = new Actions(driver);
		ac.moveToElement(mediumTCPOM.report).moveToElement(mediumTCPOM.reportOfCustomer).click().build().perform();
		mediumTCPOM.clickreportRewardPOints();
		
		boolean list = mediumTCPOM.getrewardLists();
		Assert.assertEquals(true, list);
		
		
		
		
	}
}
