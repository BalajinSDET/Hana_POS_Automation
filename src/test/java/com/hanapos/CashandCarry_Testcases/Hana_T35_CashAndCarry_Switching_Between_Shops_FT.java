package com.hanapos.CashandCarry_Testcases;

import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hanapos.pageObjects.CashAndCarryPage;
import com.hanapos.pageObjects.HanaDashBoardPage;
import com.hanapos.pageObjects.LoginPage;
import com.hanapos.seleniumProjectBase.TestBaseClass;
import com.hanapos.utilities.DataLibrary;

public class Hana_T35_CashAndCarry_Switching_Between_Shops_FT extends TestBaseClass{
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private CashAndCarryPage cashandcarry;
	public static final String dataSheetName = "Hana_T35";
	SoftAssert softassert = new SoftAssert();

	@DataProvider(name = "fetch_Excel_Data",parallel=true) 
	public Object[][] fetchData() throws IOException { 
		return DataLibrary.readExcelData(dataSheetName); 
	}

	/*
	 * HANA-T33 - 1 to 14 - Verify Cash and Carry Page -Purchase Product with Coupon - Functionality
	 */
	//expectedExceptions = {NoSuchElementException.class},retryAnalyzer= com.hanapos.utilities.RetryTest.class,

	@Test(enabled=true,groups= {"Regression"},dataProvider="fetch_Excel_Data") 
	public void  Validate_Hana_T35_CashAndCarry_Switching_Between_Shops_Test(String searchandselectitemcode, String dashboardshopname,String shopname) throws IOException {
		// Test Step - 1
		logger.info("**** Starting Hana_T35_CashAndCarry_Switching_Between_Shops_ Functionality  ****");
		try {
			lp = new LoginPage();
			softassert.assertTrue(lp.LoginPageIsDisplayed(),"Login page is not displayed");
			logger.info("User on the hana pos login page");
			
			// Test Step - 2
			lp.EnterUserName(prop.getProperty("username"));
			logger.info("User entered username as "+prop.getProperty("username"));
			lp.EnterPassword(prop.getProperty("password"));
			logger.info("User entered password as "+prop.getProperty("password"));
			lp.ClickLoginButton();
			logger.info("Clicked on Login button..");

			dashboard = new HanaDashBoardPage();
			softassert.assertTrue(dashboard.VerifyHanaDashBoardPage(),"Page does not navigated to hana dashboard page");
			logger.info("User navigated to hana dashboard page sucessfully");
			
			// Test Step - 3
			dashboard.SelectShopNameDropDown(dashboardshopname);
			logger.info("User select the shop name as All in the dashboard page");
			
			// Test Step - 4
			dashboard.CashAndCarryMenuClick();	
			cashandcarry = new CashAndCarryPage();
			logger.info("User hover the mouse on New order and click on Cash and Carry..");
			softassert.assertTrue(cashandcarry.VerifyCashAndCarryPage(), "Cash And Carry page is not displayed");
			logger.info("User verify the Cash and Carry page is displayed..");
			
			// Test Step - 5
			delayWithGivenTime(1000);

			softassert.assertEquals(cashandcarry.getShopNameSelectedOption(),"--Select Shop--","Select Shop not is displayed"); //"Hana POS (Canada)"
			logger.info("User select the shop name as "+prop.getProperty("shopname"));
			
			// Test Step - 6
			delayWithGivenTime(1000);
			dashboard.ClickOnHomeIcon();
			logger.info("User clicks on Home icon..");
			delayWithGivenTime(1000);
			softassert.assertTrue(dashboard.VerifyHanaDashBoardPage(),"Page does not navigated to hana dashboard page");
			logger.info("User navigated to hana dashboard page sucessfully");
			
			//Test Step - 7
			dashboard.SelectShopNameDropDown(shopname);
			logger.info("User selected shop name as Hana POS (Canada) from dropdown in the hana dashboard");

			// Test Step - 8
			dashboard.CashAndCarryMenuClick();	
			logger.info("User clicks on Cash and Carry menu..");
			cashandcarry = new CashAndCarryPage();
			logger.info("User hover the mouse on New order and click on Cash and Carry..");
			softassert.assertTrue(cashandcarry.VerifyCashAndCarryPage(), "Cash And Carry page is not displayed");
			logger.info("User verify the Cash and Carry page is displayed..");
			
			//Test Step - 9
			softassert.assertEquals(cashandcarry.getShopNameSelectedOption(),"Hana POS (Canada)","Selected Shopname is not displayed"); //"Hana POS (Canada)"
			logger.info("User select the shop name as Hana POS (Canada) in the cash and carry page");
			
			// Test Step - 10
			cashandcarry.SelectShopName(prop.getProperty("shopname"));
			logger.info("User selected shop name as "+prop.getProperty("shopname") +" from dropdown in the cash and carry page");
			delayWithGivenTime(2000);
			softassert.assertEquals(cashandcarry.getShopNameSelectedOption(),prop.getProperty("shopname"),"Selected Shopname is not displayed"); //"Hana POS (Canada)"
			logger.info("User select the shop name as "+prop.getProperty("shopname") +" in the cash and carry page");
			
			// Test Step - 11
			delayWithGivenTime(1000);
			dashboard.ClickOnHomeIcon();
			logger.info("User clicks on Home icon..");
			delayWithGivenTime(1000);
			softassert.assertTrue(dashboard.VerifyHanaDashBoardPage(),"Page does not navigated to hana dashboard page");
			logger.info("User navigated to hana dashboard page sucessfully");
			
			// Test Step - 12
			delayWithGivenTime(1000);
			softassert.assertEquals(cashandcarry.getShopNameSelectedOption(),prop.getProperty("shopname"),"Selected Shopname is not displayed"); //"Hana POS (Canada)"		
			logger.info("User verify the shop name displayed on cash and carry page and dashboard page shop name are matched");
			softassert.assertAll();
			logger.info("**** Hana_T35_CashAndCarry_Switching_Between_Shops_ Functionality Test Case  ****");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
			logger.error("****Test case failed Hana_T35_CashAndCarry_Switching_Between_Shops_ Functionality Test Case Failed ****" + e.getMessage());
		}	
	}
}
