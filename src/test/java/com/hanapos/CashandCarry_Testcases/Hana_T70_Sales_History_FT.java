package com.hanapos.CashandCarry_Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hanapos.pageObjects.CashAndCarryPage;
import com.hanapos.pageObjects.CashAndCarryPaymentPage;
import com.hanapos.pageObjects.CustomerPage;
import com.hanapos.pageObjects.DashboardOrderPage;
import com.hanapos.pageObjects.HanaDashBoardPage;
import com.hanapos.pageObjects.LoginPage;
import com.hanapos.seleniumProjectBase.TestBaseClass;
import com.hanapos.utilities.DataLibrary;

public class Hana_T70_Sales_History_FT extends TestBaseClass{
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private CashAndCarryPage cashandcarry;

	SoftAssert softassert = new SoftAssert();
	/*
	 * HANA-T70 - 1 to 7 - Verify add product without customer Functionality
	 */
//retryAnalyzer= com.hanapos.utilities.RetryTest.class,
	@Test(enabled=true,groups= {"Regression"}) 
	public void  Validate_Hana_T70_Sales_History_Test() throws InterruptedException, IOException {
		// Test Step - 1
		logger.info("**** Starting Hana_T70_Sales_History_CashAndCarryTest  ****");
	
		try {
			lp = new LoginPage();
			softassert.assertTrue(lp.LoginPageIsDisplayed(),"Login page is not displayed");
			logger.info("User on the hana pos login page");
		
			// Test Step - 2
			lp.EnterUserName(prop.getProperty("username"));
			logger.info("User entered username as "+prop.getProperty("username"));
			lp.EnterPassword(prop.getProperty("password"));
			logger.info("User entered username as "+prop.getProperty("password"));
			lp.ClickLoginButton();
			logger.info("User clicked on Login button..");

			dashboard = new HanaDashBoardPage();
			softassert.assertTrue(dashboard.VerifyHanaDashBoardPage(),"Page does not navigated to hana dashboard page");
			logger.info("User navigated to hana dashboard page sucess..");

			// Test Step - 3
			dashboard.SelectShopNameDropDown(prop.getProperty("shopname"));
			logger.info("User selected the shop name as "+prop.getProperty("shopname")+ "in dashboard page");
			softassert.assertTrue(dashboard.VerifyOrderEntryOptionIsDisplayed(),"Order entry option is not displayed");
			softassert.assertTrue(dashboard.Verify_Cashandcarry_OptionIsDisplayed(),"Cash and carry option is not displayed");
		
			// Test Step - 4
			dashboard.CashAndCarryMenuClick();							
			cashandcarry = new CashAndCarryPage();
			logger.info("User hover the mouse on New order and click on Cash and Carry..");
			softassert.assertTrue(cashandcarry.VerifyCashAndCarryPage(), "Cash And Carry page is not displayed");
			logger.info("User verify the Cash and Carry page is displayed..");

			// Test Step - 5
			cashandcarry.ClickSalesHistoryBtn();
			logger.info("User clicked on Sales History button..");
			softassert.assertTrue(dashboard.VerifyHanaDashBoardPage(),"Page does not navigated to hana dashboard page");
			logger.info("User navigated to hana dashboard page sucess..");

			// Test Step - 6
			dashboard.CashAndCarryMenuClick();							
			cashandcarry = new CashAndCarryPage();
			logger.info("User hover the mouse on New order and click on Cash and Carry..");
			softassert.assertTrue(cashandcarry.VerifyCashAndCarryPage(), "Cash And Carry page is not displayed");
			logger.info("User verify the Cash and Carry page is displayed..");
			
			// Test Step - 7
			cashandcarry.PressAltKeyH_SalesHistory();
			softassert.assertTrue(dashboard.VerifyHanaDashBoardPage(),"Page does not navigated to hana dashboard page");
			logger.info("User navigated to hana dashboard page sucess..");		
			
			softassert.assertAll();
		
		} catch (Exception e) {
			Assert.fail("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
