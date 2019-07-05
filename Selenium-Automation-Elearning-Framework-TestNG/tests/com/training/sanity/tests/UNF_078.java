package com.training.sanity.tests;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.dataproviders.ComplexDataProviders;
import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.ComplexTCPOM;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UNF_078 {
	
	private WebDriver driver;
	private String baseUrl;
	private ComplexTCPOM complexTCPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	static ExtentReports extent;
	ExtentTest logger;
	//comment
	//comment
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
//		System.out.println(System.getProperty("user.dir"));
		extent = new ExtentReports(System.getProperty("user.dir")+"\\test-output\\myUNF_078.html", true);
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
//		logger.log(LogStatus.PASS, "Application closed Successfully");
//		extent.endTest(logger);
//		extent.flush();
//		extent.close();
	}
	
	@Test(dataProvider = "excel-inputs", dataProviderClass = ComplexDataProviders.class)
	public void createCategory(String CategoryName, String Description, String Meta_tag_Title,String Meta_tag_Description) throws InterruptedException {


		
		complexTCPOM.clickCategory();
		List<String> ActualColumCategory = complexTCPOM.getCategoryColumn();
		List<String> ExpectedColumCategory = new ArrayList<String>();
		ExpectedColumCategory.add("Category Name");
		ExpectedColumCategory.add("Sort Order");
		ExpectedColumCategory.add("Action");
		Assert.assertEquals(ActualColumCategory, ExpectedColumCategory);
		
		complexTCPOM.clickName(complexTCPOM.addNewBtn);
		String actualheader = complexTCPOM.getTextMethod(complexTCPOM.pageAddText);
		String expectedheader = "Add Category";
		Assert.assertEquals(actualheader, expectedheader);
		
		

complexTCPOM.sendNameValue(CategoryName,complexTCPOM.categoryName);
		boolean FN = complexTCPOM.verifyDisplayed(complexTCPOM.categoryName, CategoryName,"keyboard");
		Assert.assertEquals(true, FN);
		
		complexTCPOM.sendNameValue(Description,complexTCPOM.categoryDescription);
		String actualCD = complexTCPOM.getTextMethod(complexTCPOM.categoryDescription);
		Assert.assertEquals(actualCD, Description);
		
		complexTCPOM.sendNameValue(Meta_tag_Title,complexTCPOM.megaTitle);
		boolean FN2 = complexTCPOM.verifyDisplayed(complexTCPOM.megaTitle, Meta_tag_Title,"keyboard");
		Assert.assertEquals(true, FN2);
		
		complexTCPOM.sendNameValue(Meta_tag_Description,complexTCPOM.megaTitleDescription);
		boolean FN3 = complexTCPOM.verifyDisplayed(complexTCPOM.megaTitleDescription, Meta_tag_Description,"keyboard");
		Assert.assertEquals(true, FN3);
		
		
		complexTCPOM.clickName(complexTCPOM.dataTab);
		
			boolean DF1 = complexTCPOM.verifyDisplayed(complexTCPOM.inputColumn, "1","keyboard");
		Assert.assertEquals(true, DF1);
		
		boolean DF2 = complexTCPOM.verifyDisplayed(complexTCPOM.inputOrder, "0","keyboard");
	Assert.assertEquals(true, DF2);
	
	boolean DF3 = complexTCPOM.verifyDisplayed(complexTCPOM.inputStatus, "Enabled","select");
Assert.assertEquals(true, DF3);

complexTCPOM.clickName(complexTCPOM.designTab);
		
complexTCPOM.clickName(complexTCPOM.saveCategoryBtn);

String header1 = complexTCPOM.getTextMethod(complexTCPOM.savedCategoryMsg).substring(0, 38);
Assert.assertEquals(header1, "Success: You have modified categories!");

String header2 = complexTCPOM.getTextMethod(complexTCPOM.savedCategoryMsgPage);		
Assert.assertEquals(header2, "Category List");

}
	@Test(dataProvider = "excel-inputs1", dataProviderClass = ComplexDataProviders.class,priority=1)
	public void createProduct(String ProductName,String MetaTitle, String Model, String Category) throws InterruptedException {
		
		complexTCPOM.clickProduct();
		String Actualproductpage = complexTCPOM.getTextMethod(complexTCPOM.productListPage);
		Assert.assertEquals(Actualproductpage, "Product List");
		
		Thread.sleep(2000);
		
		complexTCPOM.clickName(complexTCPOM.addProductNewbtn);
		String ActualAddproductpage = complexTCPOM.getTextMethod(complexTCPOM.productListPage);
		Assert.assertEquals(ActualAddproductpage, "Add Product");
		
		complexTCPOM.sendNameValue(ProductName, complexTCPOM.productname);
		boolean PN1 = complexTCPOM.verifyDisplayed(complexTCPOM.productname, ProductName,"keyboard");
		Assert.assertEquals(true, PN1);
		
		
		complexTCPOM.sendNameValue(MetaTitle, complexTCPOM.MetaTitleProduct);
		boolean PN2 = complexTCPOM.verifyDisplayed(complexTCPOM.MetaTitleProduct, MetaTitle,"keyboard");
		Assert.assertEquals(true, PN2);
		
		complexTCPOM.clickName(complexTCPOM.dataTab);
		
		complexTCPOM.sendNameValue(Model, complexTCPOM.model);
		boolean P2 = complexTCPOM.verifyDisplayed(complexTCPOM.model, Model,"keyboard");
		Assert.assertEquals(true, P2);
		
		complexTCPOM.clickName(complexTCPOM.linkTab);
		
		
		String actualLinks = complexTCPOM.getTextMethod(complexTCPOM.manufacturer);
		Assert.assertEquals(actualLinks, "Manufacturer");
		
		complexTCPOM.clickName(complexTCPOM.inputCategory);
		Thread.sleep(1000);
complexTCPOM.getListofCategory(Category);
String actualLink = complexTCPOM.getTextMethod(complexTCPOM.getCategory);
		Assert.assertTrue(actualLink.contains(Category));
		
		complexTCPOM.clickName(complexTCPOM.SaveBtn);
		String actualfmsg = complexTCPOM.getTextMethod(complexTCPOM.finalmsg).substring(0, 36);
		Assert.assertEquals(actualfmsg, "Success: You have modified products!");	
		
		
	}
}
