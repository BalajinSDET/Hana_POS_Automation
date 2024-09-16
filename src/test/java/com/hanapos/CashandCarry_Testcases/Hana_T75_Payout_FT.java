package com.hanapos.CashandCarry_Testcases;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
import com.hanapos.utilities.CustomSoftAssert;
import com.hanapos.utilities.DataLibrary;

public class Hana_T75_Payout_FT extends TestBaseClass{
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private CashAndCarryPage cashandcarry;
	public static ExecutorService executorService;
	private static final int THREAD_POOL_SIZE = 2;
	
	// SoftAssert softassert = new SoftAssert(); - I have modified this to use CustomSoftAssert
	CustomSoftAssert softassert = new CustomSoftAssert();
	
	/*
	 * HANA-T72 - 1 to 7 - Verify Open drawer Functionality
	 */
	//retryAnalyzer= com.hanapos.utilities.RetryTest.class,
	@Test(enabled=true,groups= {"Regression"}) 
	public void  Validate_Hana_T75_Payout_Test() throws InterruptedException, IOException {
		// Test Step - 1
		logger.info("**** Starting Hana_T75_Payout_CashAndCarryTest  ****");
	
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
			cashandcarry.ClickPayOutBtn();
			logger.info("User clicked on pay out button..");
			softassert.assertTrue(cashandcarry.VerifyPasswordPopupIsDisplayed(),"Verify password popup is not displayed");
			softassert.assertTrue(cashandcarry.VerifyPasswordPopup(),"Verify password header popup is not displayed");
			logger.info("User navigated to hana dashboard page sucess..");

			// Test Step - 6
			cashandcarry.EnterVerifyPassword("1234");
			softassert.assertEquals(cashandcarry.getEnteredVerifyPassword(), "1234", "Entered verify password data is not displayed");
			
			// Test Step - 7
			cashandcarry.ClickVerifyBtnOnPasswordPopup();
			delayWithGivenTime(1000);
			
			// Test Step - 8
			delayWithGivenTime(1000);
			softassert.assertTrue(cashandcarry.VerifyCashDrawPopupDisplayed(),"Cash draw popup is not displayed");
			cashandcarry.SelectShopCashDrawPopup("Hana POS (Canada)");
			delayWithGivenTime(1000);
			cashandcarry.Select_CashRegisterId("SAM");
			delayWithGivenTime(1000);
			softassert.assertEquals(cashandcarry.getSelectedCashRegisterId(), "SAM", "Selected cash register id is not displayed");
			
			// Test Step - 9
			cashandcarry.EnterNameonCashDrawPopup("Test Automation");
			delayWithGivenTime(1000);
			softassert.assertEquals(cashandcarry.getEnteredNameonCashDrawPopup(), "Test Automation", "Entered name on cash draw popup is not displayed");
			
			// Test Step - 10
			cashandcarry.EnterReasononCashDrawPopup("This is a automation testing reason");
			delayWithGivenTime(1000);
			softassert.assertEquals(cashandcarry.getEnteredReasononCashDrawPopup(), "This is a automation testing reason", "Entered reason on cash draw popup is not displayed");
		
			// Test Step - 11
			cashandcarry.EnterSubTotalonCashDrawPopup("abcdcef");
			delayWithGivenTime(1000);
			softassert.assertEquals(cashandcarry.getEnteredSubTotalonCashDrawPopup(), "", "Entered alphabetic characters in sub total on cash draw popup is accepted");
			
			// Test Step - 12
			cashandcarry.EnterSubTotalonCashDrawPopup("@#$%^");
			delayWithGivenTime(1000);
			softassert.assertEquals(cashandcarry.getEnteredSubTotalonCashDrawPopup(), "", "Entered special character in sub total on cash draw popup is accepted");
			
			// Test Step - 13
			cashandcarry.EnterSubTotalonCashDrawPopup("123456");
			delayWithGivenTime(1000);
			softassert.assertEquals(cashandcarry.getEnteredSubTotalonCashDrawPopup(), "123456", "Entered numeric characters in sub total on cash draw popup is not accepted");
			
			// Test Step - 14
			cashandcarry.EnterTaxAmountonCashDrawPopup("abcdcef");
			delayWithGivenTime(1000);
			softassert.assertEquals(cashandcarry.getEnteredTaxAmountonCashDrawPopup(), "", "Entered alphabetic characters in tax on cash draw popup is accepted");
			
			// Test Step - 15
			cashandcarry.EnterTaxAmountonCashDrawPopup("@#$%^");
			delayWithGivenTime(1000);
			softassert.assertEquals(cashandcarry.getEnteredTaxAmountonCashDrawPopup(), "", "Entered special character in tax on cash draw popup is accepted");
			
			// Test Step - 16
			cashandcarry.EnterTaxAmountonCashDrawPopup("10");
			delayWithGivenTime(1000);
			softassert.assertEquals(cashandcarry.getEnteredTaxAmountonCashDrawPopup(), "10", "Entered numeric characters in tax on cash draw popup is not accepted");
			
			// Test Step - 17
			softassert.assertFalse(cashandcarry.VerifyGrandTotalonCashDrawPopup(),"Grand total field is not disabled");
			
			// Test Step - 18
			cashandcarry.ClickCloseIcon();
			
			// Test Step - 19
			cashandcarry.ClickOnReconcileBtn();
			softassert.assertTrue(cashandcarry.VerifyReconcilePopupDisplayed(),"Reconcile popup is not displayed");
			cashandcarry.SelectShopReconcilePopup("Hana POS (Canada)");
			cashandcarry.Select_CashRegistryIdonReconcilePopup("Test");
			
			//softassert.assertEquals(cashandcarry.getSelectedCashRegistryonReconcilePopup(),"SAM","Cash drawer popup selected cash registry is not displayed");
			delayWithGivenTime(3000);
			cashandcarry.getPayOut_Amount_OnReconcilePopup();
			
			cashandcarry.ClickPayOutBtn();
			logger.info("User clicked on pay out button..");
			softassert.assertTrue(cashandcarry.VerifyPasswordPopupIsDisplayed(),"Verify password popup is not displayed");
			softassert.assertTrue(cashandcarry.VerifyPasswordPopup(),"Verify password header popup is not displayed");
			logger.info("User navigated to hana dashboard page sucess..");

			cashandcarry.EnterVerifyPassword("1234");
			softassert.assertEquals(cashandcarry.getEnteredVerifyPassword(), "1234", "Entered verify password data is not displayed");
			
			cashandcarry.ClickVerifyBtnOnPasswordPopup();
			delayWithGivenTime(1000);
			
			// Test Step - 20
			softassert.assertTrue(cashandcarry.VerifyCashDrawPopupDisplayed(),"Cash draw popup is not displayed");
			cashandcarry.SelectShopCashDrawPopup("Hana POS (Canada)");
			cashandcarry.Select_CashRegisterId("Test");
			cashandcarry.EnterNameonCashDrawPopup("Test Automation");
			cashandcarry.EnterReasononCashDrawPopup("This is a automation testing reason");
			cashandcarry.EnterSubTotalonCashDrawPopup("100");
			cashandcarry.EnterTaxAmountonCashDrawPopup("10");
			cashandcarry.ClickSaveBtnOnCashDrawPopup();
			delayWithGivenTime(1000);
			softassert.assertTrue(cashandcarry.VerifySuccessMessageIsDisplayed(),"Success message is not displayed");
			delayWithGivenTime(1000);

			
			//RobotDismissAlert();
			logger.info("User click the cancel button on webclientprint window popup");
			
			// Test Step - 21
			delayWithGivenTime(1000);
			cashandcarry.ClickOnReconcileBtn();
			softassert.assertTrue(cashandcarry.VerifyReconcilePopupDisplayed(),"Reconcile popup is not displayed");
			cashandcarry.SelectShopReconcilePopup("Hana POS (Canada)");
			cashandcarry.Select_CashRegistryIdonReconcilePopup("Test");
			
			//softassert.assertEquals(cashandcarry.getSelectedCashRegistryonReconcilePopup(),"SAM","Cash drawer popup selected cash registry is not displayed");
			delayWithGivenTime(3000);
			softassert.assertEquals(cashandcarry.getPayOut_Amount_OnReconcilePopup(),cashandcarry.ExpectedCalculatedPayoutAmount(),"Payout amount on reconcile popup is not displayed");
			
			//RobotDismissAlert();
			logger.info("User click the cancel button on webclientprint window popup");
			delayWithGivenTime(1000);			
			softassert.assertAll();
			logger.info("**** Finished Hana_T75_Payout_CashAndCarryTest  ****");

		} catch (Exception e) {
			Assert.fail("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
