package com.hanapos.cashandcarrytest;

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

public class Hana_T72_Open_Drawer_FT extends TestBaseClass{
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private CashAndCarryPage cashandcarry;

	SoftAssert softassert = new SoftAssert();
	
	/*
	 * HANA-T72 - 1 to 7 - Verify Open drawer Functionality
	 */
//retryAnalyzer= com.hanapos.utilities.RetryTest.class,
	@Test(enabled=true,groups= {"Regression"}) 
	public void  Validate_Hana_T72_Open_Drawer_Test() throws InterruptedException, IOException {
		// Test Step - 1
		logger.info("**** Starting Hana_T72_Open_Drawer_CashAndCarryTest  ****");
	
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
			cashandcarry.ClickOpenDrawerBtn();
			logger.info("User clicked on open drawer button..");
			softassert.assertTrue(cashandcarry.VerifyPasswordPopupIsDisplayed(),"Verify password popup is not displayed");
			softassert.assertTrue(cashandcarry.VerifyPasswordPopup(),"Verify password header popup is not displayed");
			logger.info("User navigated to hana dashboard page sucess..");

			// Test Step - 6
			cashandcarry.EnterVerifyPassword("1234");
			softassert.assertEquals(cashandcarry.getEnteredVerifyPassword(), "1234", "Entered verify password data is not displayed");
			
			// Test Step - 7
			cashandcarry.ClickVerifyBtnOnPasswordPopup();
			delayWithGivenTime(1000);
			getDriver().switchTo().activeElement();
			//RobotDismissAlert();
			logger.info("User click the cancel button on webclientprint window popup");
			delayWithGivenTime(1000);			
			softassert.assertAll();
			logger.info("**** Finished Hana_T72_Open_Drawer_CashAndCarryTest  ****");

		} catch (Exception e) {
			Assert.fail("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
