package com.hanapos.CashandCarry_Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hanapos.pageObjects.CashAndCarryPage;
import com.hanapos.pageObjects.HanaDashBoardPage;
import com.hanapos.pageObjects.LoginPage;
import com.hanapos.seleniumProjectBase.TestBaseClass;
import com.hanapos.utilities.DataLibrary;

public class Hana_T06_WalkingSettings_AddNewCashRegister_FT extends TestBaseClass {
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private CashAndCarryPage cashandcarry;
	public static final String dataSheetName = "Hana_T06";
	SoftAssert softassert = new SoftAssert();

	@DataProvider(name = "fetch_Excel_Data") 
	public Object[][] fetchData() throws IOException { 
		return DataLibrary.readExcelData(dataSheetName); 
	}
//retryAnalyzer= com.hanapos.utilities.RetryTest.class,
	@Test(enabled=true,groups= {"Regression"},dataProvider="fetch_Excel_Data")
	public void Validate_Hana_T06_WalkingSetting_AddNew_CashRegister_Test(String clerkid,String clerkdescription, String printername,String manufacturer,
			String model,String cashdrawcode,String printercutcode,String customercopynote,String merchantcopynote) {

		// HANA-T06 - Verify Walking Settings Add New Cash Register

		//Test Step - 1
		logger.info("**** Starting Hana_T06_WalkingSettings_AddNewCashRegister_CashAndCarryTest  ****");
		logger.debug("capturing application debug logs....");
		try {
			lp = new LoginPage();
			softassert.assertTrue(lp.LoginPageIsDisplayed(),"Login page is not displayed");
			logger.info("User on the hana pos login page");
			
			logger.info("Entering valid username and password..");
			lp.EnterUserName(prop.getProperty("username"));
			lp.EnterPassword(prop.getProperty("password"));
			lp.ClickLoginButton();
			logger.info("Clicked on Login button..");

			dashboard = new HanaDashBoardPage();

			//Test Step - 2
			Assert.assertTrue(dashboard.VerifyHanaDashBoardPage(),"Page does not navigated to hana dashboard page");
			logger.info("User navigated to hana dashboard page sucess..");
			dashboard.SelectShopNameDropDown(prop.getProperty("shopname"));
			logger.info("User selected the shop name as "+prop.getProperty("shopname")+ "in dashboard page");
			dashboard.CashAndCarryMenuClick();							
			cashandcarry = new CashAndCarryPage();

			//Test Step - 3
			logger.info("User hover the mouse on New order and click on Cash and Carry..");
			Assert.assertTrue(cashandcarry.VerifyCashAndCarryPage(), "Cash And Carry page is not displayed");

			logger.info("User verify the Cash and Carry page is displayed..");

			//Test Step - 4
			cashandcarry.ClickWalkingSettingIcon();
			delayWithGivenTime(4000);
			softassert.assertTrue(cashandcarry.verifyWalkingSettingPopupIsDisplayed(),"Walking Setting pop up is not displayed");
			delayWithGivenTime(3000);

			//Test Step - 5
			cashandcarry.ClickAddNewButtonOnWalkingSettingPopup();

			//Test Step - 6
			softassert.assertTrue(cashandcarry.VerifyAddNewWalkingSettingPopupIsDisplayed());

			cashandcarry.EnterClerkIDonAddnewPopup(clerkid);
			cashandcarry.EnterClerkDescriptiononAddnewPopup(clerkdescription);
			cashandcarry.EnterPrinterNameonAddnewPopup(printername);

			// Test Step - 7
			cashandcarry.SelectManufacturerOnAddNewPopup(manufacturer);

			// Test Step - 8
			cashandcarry.SelectModelOnAddNewPopup(model);

			//Test Step - 9
			softassert.assertEquals(cashandcarry.getCashdrawcodeOnAddnewPopup(), cashdrawcode);

			//Test Step - 10
			softassert.assertEquals(cashandcarry.getPrinterCutCodeOnAddnewPopup(),printercutcode);

			//Test Step - 11 - test failed due to validation error	
			delayWithGivenTime(3000);
			cashandcarry.SelectManufacturerOnAddNewPopup(manufacturer);

			//Test Step - 12
			cashandcarry.SelectModelOnAddNewPopup(model);
			softassert.assertEquals(cashandcarry.getCashdrawcodeOnAddnewPopup(), cashdrawcode);
			softassert.assertEquals(cashandcarry.getPrinterCutCodeOnAddnewPopup(),printercutcode);
			
			//Test Step - 13
			cashandcarry.ClickCustomerCopyCheckboxOnAddnewPopup();
			softassert.assertTrue(cashandcarry.custCopyCheckBoxonAddNewpopUPIsSelected());
			cashandcarry.ClickMerchantCopyCheckboxOnAddnewPopup();		
			softassert.assertTrue(cashandcarry.merchantCopyCheckBoxonAddNewpopUPIsSelected());

			//Test Step - 14
			cashandcarry.EnterCustCopyNoteonAddnewPopup(customercopynote);
			softassert.assertEquals(cashandcarry.getEnteredCustCopyNoteonAddnewPopup(),customercopynote);

			//Test Step - 15 
			cashandcarry.EnterMerchantCopyNoteonAddnewPopup(merchantcopynote);
			softassert.assertEquals(cashandcarry.getEnteredMerchantCopyNoteonAddnewPopup(),merchantcopynote);

			//Test Step - 16
			cashandcarry.ClickCancelBtnonAddnewPopup();

			// Test Step - 17
			delayWithGivenTime(2000);
			softassert.assertTrue(cashandcarry.verifyWalkingSettingPopupIsDisplayed(),"Walking Setting pop up is not displayed");
			cashandcarry.ClickAddNewButtonOnWalkingSettingPopup();
			softassert.assertTrue(cashandcarry.VerifyAddNewWalkingSettingPopupIsDisplayed());
			cashandcarry.EnterClerkIDonAddnewPopup(clerkid);
			cashandcarry.EnterClerkDescriptiononAddnewPopup(clerkdescription);
			cashandcarry.EnterPrinterNameonAddnewPopup(printername);
			cashandcarry.SelectManufacturerOnAddNewPopup(manufacturer);
			cashandcarry.SelectModelOnAddNewPopup(model);
			softassert.assertEquals(cashandcarry.getCashdrawcodeOnAddnewPopup(), cashdrawcode);
			softassert.assertEquals(cashandcarry.getPrinterCutCodeOnAddnewPopup(),printercutcode);
			cashandcarry.SelectManufacturerOnAddNewPopup(manufacturer);
			cashandcarry.SelectModelOnAddNewPopup(model);
			softassert.assertEquals(cashandcarry.getCashdrawcodeOnAddnewPopup(), cashdrawcode);
			softassert.assertEquals(cashandcarry.getPrinterCutCodeOnAddnewPopup(),printercutcode);
			cashandcarry.ClickCustomerCopyCheckboxOnAddnewPopup();
			softassert.assertTrue(cashandcarry.custCopyCheckBoxonAddNewpopUPIsSelected());
			cashandcarry.ClickMerchantCopyCheckboxOnAddnewPopup();		
			softassert.assertTrue(cashandcarry.merchantCopyCheckBoxonAddNewpopUPIsSelected());
			cashandcarry.EnterCustCopyNoteonAddnewPopup(customercopynote);
			softassert.assertEquals(cashandcarry.getEnteredCustCopyNoteonAddnewPopup(),customercopynote);
			cashandcarry.EnterMerchantCopyNoteonAddnewPopup(merchantcopynote);
			softassert.assertEquals(cashandcarry.getEnteredMerchantCopyNoteonAddnewPopup(),merchantcopynote);

			cashandcarry.ClickSaveBtnonAddnewPopup();
			softassert.assertTrue(cashandcarry.VerifySuccessMessageIsDisplayed());
			softassert.assertTrue(cashandcarry.VerifyWalkingSettingNewlyAdded());
			delayWithGivenTime(1000);
			
			//Test Step - 18
			cashandcarry.ClickNewlyCreatedEditBtnOnWalkInSetting();
			delayWithGivenTime(1000);
			
			softassert.assertEquals(cashandcarry.getEnteredClerkIDonAddnewPopup(),"10");
			softassert.assertEquals(cashandcarry.getEnteredClerkDescriptiononAddnewPopup(),clerkdescription);
			softassert.assertEquals(cashandcarry.getEnteredPrinterNameonAddnewPopup(),printername);
			delayWithGivenTime(1000);
			softassert.assertEquals(cashandcarry.getFirstSelectedManufacturerOptionOnAddNewPopup(),manufacturer);
			softassert.assertEquals(cashandcarry.getFirstSelectedModelOptionOnAddNewPopup(),model);
			delayWithGivenTime(1000);
			softassert.assertEquals(cashandcarry.getCashdrawcodeOnAddnewPopup(), cashdrawcode);
			softassert.assertEquals(cashandcarry.getPrinterCutCodeOnAddnewPopup(),printercutcode);
			delayWithGivenTime(1000);
			softassert.assertTrue(cashandcarry.custCopyCheckBoxonAddNewpopUPIsSelected());
			softassert.assertTrue(cashandcarry.merchantCopyCheckBoxonAddNewpopUPIsSelected());
			delayWithGivenTime(1000);
			softassert.assertEquals(cashandcarry.getEnteredCustCopyNoteonAddnewPopup(),customercopynote);
			
			if(cashandcarry.getEnteredMerchantCopyNoteonAddnewPopup().equals(merchantcopynote)) {
			softassert.assertEquals(cashandcarry.getEnteredMerchantCopyNoteonAddnewPopup(),merchantcopynote);
			}else {
				softassert.fail("Automation Merchant Copy Note is not displayed");
			}
			
			softassert.assertAll();
			logger.info("**** Ending Hana_T06_WalkingSettings_AddNewCashRegister_FT  ****");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
			logger.error("Test case failed due to exception", e.getMessage());
		}
	}	
}
