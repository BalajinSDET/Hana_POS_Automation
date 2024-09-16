package com.hanapos.CashandCarry_Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.hanapos.pageObjects.CashAndCarryPage;
import com.hanapos.pageObjects.HanaDashBoardPage;
import com.hanapos.pageObjects.LoginPage;
import com.hanapos.seleniumProjectBase.TestBaseClass;
import com.hanapos.utilities.CustomSoftAssert;

public class Hana_T04_WalkingSettings_UI_Test extends TestBaseClass {
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private CashAndCarryPage cashandcarry;
	
	// SoftAssert softassert = new SoftAssert(); - I have modified this to use CustomSoftAssert
	CustomSoftAssert softassert = new CustomSoftAssert();
	//retryAnalyzer= com.hanapos.utilities.RetryTest.class,
	@Test(enabled=true,groups= {"Regression"})
	public void Validate_Hana_T04_WalkingSetting_UIElement_Test() {		
		//Test Step - 1
		logger.info("**** Starting Hana_T04_WalkingSettings_UI_CashAndCarryTest  ****");
		logger.debug("capturing application debug logs....");
		try {
			lp = new LoginPage();
			softassert.assertTrue(lp.LoginPageIsDisplayed(),"Login page is not displayed");
			logger.info("User on the hana pos login page");
			
			lp.EnterUserName(prop.getProperty("username"));
			logger.info("User entered the username as "+prop.getProperty("username"));
			lp.EnterPassword(prop.getProperty("password"));
			logger.info("User entered the password as "+prop.getProperty("password"));
			lp.ClickLoginButton();
			logger.info("Clicked on Login button..");

			dashboard = new HanaDashBoardPage();
			
			//Test Step - 2
			softassert.assertTrue(dashboard.VerifyHanaDashBoardPage(),"Page does not navigated to hana dashboard page");
			logger.info("User navigated to hana dashboard page sucess..");
			dashboard.SelectShopNameDropDown(prop.getProperty("shopname"));
			logger.info("User selected the shop name as "+prop.getProperty("shopname")+ "in dashboard page");
			dashboard.CashAndCarryMenuClick();							
			cashandcarry = new CashAndCarryPage();

			//Test Step - 3
			logger.info("User hover the mouse on New order and click on Cash and Carry..");
			softassert.assertTrue(cashandcarry.VerifyCashAndCarryPage(), "Cash And Carry page is not displayed");

			logger.info("User verify the Cash and Carry page is displayed..");
			
			//Test Step - 4
			softassert.assertEquals(cashandcarry.VerifyWalkingSettingsToolTip(), "WalkIns Settings","***Walking Settings tooltip is not displayed***");	
			
			//Test Step - 5
			cashandcarry.ClickWalkingSettingIcon();
			delayWithGivenTime(3000);
			
			//Test step - 6
			delayWithGivenTime(1000);
			softassert.assertTrue(cashandcarry.verifyWalkingSettingPopupIsDisplayed(),"Walking Setting pop up is not displayed");
			delayWithGivenTime(3000);
			softassert.assertEquals(cashandcarry.VerifyDefaultShopNameonWalkingSettings(), "SISTERCHICKS FLOWERS AND MORE LLC","***Default shop name is not displayed***");
			softassert.assertTrue(cashandcarry.VerifyAddNewButtonIsDisplayedonWalkinsSettings(),"Add new button is not displayed");	
			softassert.assertTrue(cashandcarry.VerifyWalkingPopupCloseIcon(),"walking setting pop up close icon is not displayed");
			delayWithGivenTime(3000);
			softassert.assertEquals(cashandcarry.VerifyShopTableHeaderonWalkingSettingSno(),"S.No.","***S.No. header is not displayed***");
			softassert.assertEquals(cashandcarry.VerifyShopTableHeaderonWalkingSettingClerkId(),"ClerkID","***ClerkID header is not displayed***");
			softassert.assertEquals(cashandcarry.VerifyWalkingSettingShopPrinterName(),"PrinterName","***Printer Name header is not displayed***");
			softassert.assertEquals(cashandcarry.VerifyWalkingSettingShopCashDrawcode(),"CashdrawCode","***Cash draw Code header is not displayed***");
			softassert.assertEquals(cashandcarry.VerifyWalkingSettingPrinterCutCode(),"PrintCutCode","***Print Cut Code header is not displayed***");
			softassert.assertEquals(cashandcarry.VerifyClerkDescWalkingSetting(),"ClerkDesc","***Clerk description header is not displayed***");
			softassert.assertEquals(cashandcarry.VerifyWalkingSettingCustcopy(),"CustomerCopy","***Customer Copy header is not displayed***");
			softassert.assertEquals(cashandcarry.VerifyWalkingSettingActionheader(),"Action","***Action header is not displayed***");
			
			delayWithGivenTime(3000);
			
			softassert.assertTrue(cashandcarry.ValidateEditBtnPresenceOnWalkingSettingPopup(), "Edit button is not displayed");
			softassert.assertTrue(cashandcarry.ValidateDeleteIconPresenceOnWalkingSettingPopup(),"Delete button is not displayed");
			
			// Test Step - 7
			cashandcarry.ClickWalkingSettingPopupCloseIcon();
			softassert.assertAll();
			logger.info("Ended the test case - Hana_T04_WalkingSettings_UI_CashAndCarryTest");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
			logger.error("Failed the test case - Hana_T04_WalkingSettings_UI_CashAndCarryTest");
		}
	}	
}
