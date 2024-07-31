package com.hanapos.cashandcarrytest;

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

public class Hana_T07_WalkingSettings_EditCashRegister_FT extends TestBaseClass {
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private CashAndCarryPage cashandcarry;
	public static final String dataSheetName = "Hana_T07";
	SoftAssert softassert = new SoftAssert();


	@DataProvider(name = "fetch_Excel_Data") 
	public Object[][] fetchData() throws IOException { 
		return DataLibrary.readExcelData(dataSheetName); 
	}
	//retryAnalyzer= com.hanapos.utilities.RetryTest.class,
	@Test(enabled=true,groups= {"Regression"},dataProvider="fetch_Excel_Data")
	public void Validate_Hana_T07_WalkingSetting_Edit_CashRegister_Test(String clerkid1,String clerkid2) {

		// HANA-T07 - Verify Walking Settings Edit Cash Register
		//Test Step - 1
		logger.info("**** Starting Hana_T07_WalkingSettings_EditCashRegister_Functionality  ****");
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
			dashboard.CashAndCarryMenuClick();							
			cashandcarry = new CashAndCarryPage();

			//Test Step - 3
			logger.info("User hover the mouse on New order and click on Cash and Carry..");
			Assert.assertTrue(cashandcarry.VerifyCashAndCarryPage(), "Cash And Carry page is not displayed");

			logger.info("User verify the Cash and Carry page is displayed..");

			//Test Step - 4
			cashandcarry.ClickWalkingSettingIcon();
			delayWithGivenTime(2000);
			softassert.assertTrue(cashandcarry.verifyWalkingSettingPopupIsDisplayed(),"Walking Setting pop up is not displayed");
			delayWithGivenTime(1000);

			//Test Step - 5	
			softassert.assertEquals(cashandcarry.geteditBtnToolTiponAddnewPopupIsDisplayed(),"Edit");
			
			//Test Step - 6
			delayWithGivenTime(1000);
			cashandcarry.ClickAutomationEditBtnOnWalkInSetting();
			
			delayWithGivenTime(1000);
			softassert.assertTrue(cashandcarry.VerifyAddNewWalkingSettingPopupIsDisplayed());
			
			//Test Step - 7
			delayWithGivenTime(3000);

			cashandcarry.EnterClerkIDonAddnewPopup(clerkid1);
			delayWithGivenTime(1000);
			cashandcarry.ClickCancelBtnonAddnewPopup();
			
			//Test Step - 8
			delayWithGivenTime(1000);
			softassert.assertTrue(cashandcarry.verifyWalkingSettingPopupIsDisplayed(),"Walking Setting pop up is not displayed");
			cashandcarry.ClickAutomationEditBtnOnWalkInSetting();
			delayWithGivenTime(2000);
			
			softassert.assertTrue(cashandcarry.VerifyAddNewWalkingSettingPopupIsDisplayed());
			delayWithGivenTime(1000);
			softassert.assertEquals(cashandcarry.getEnteredClerkIDonAddnewPopup(),"10");
			softassert.assertEquals(cashandcarry.getEnteredClerkDescriptiononAddnewPopup(),"Automation Clerk description");
			softassert.assertEquals(cashandcarry.getEnteredPrinterNameonAddnewPopup(),"Automation Printer");
			delayWithGivenTime(1000);
			softassert.assertEquals(cashandcarry.getFirstSelectedManufacturerOptionOnAddNewPopup(),"Epson");
			softassert.assertEquals(cashandcarry.getFirstSelectedModelOptionOnAddNewPopup(),"M129C");
			delayWithGivenTime(1000);
			softassert.assertEquals(cashandcarry.getCashdrawcodeOnAddnewPopup(), "27,112,0,64,240");
			softassert.assertEquals(cashandcarry.getPrinterCutCodeOnAddnewPopup(),"27,109");
			delayWithGivenTime(1000);
			softassert.assertTrue(cashandcarry.custCopyCheckBoxonAddNewpopUPIsSelected(),"Customer Copy CheckBox is not selected");
			softassert.assertTrue(cashandcarry.merchantCopyCheckBoxonAddNewpopUPIsSelected(),"Merchant Copy CheckBox is not selected");
			delayWithGivenTime(1000);
			softassert.assertEquals(cashandcarry.getEnteredCustCopyNoteonAddnewPopup(),"Automation Customer Copy Note");
			// softassert.assertEquals(cashandcarry.getEnteredMerchantCopyNoteonAddnewPopup(),"");
				
			//Test Step - 9
			delayWithGivenTime(1000);
			cashandcarry.EnterClerkIDonAddnewPopup(clerkid2);
			delayWithGivenTime(1000);
			cashandcarry.ClickSaveBtnonAddnewPopup();
			cashandcarry.VerifySuccessMessageIsDisplayed();
			delayWithGivenTime(1000);
			
			softassert.assertTrue(cashandcarry.verifyWalkingSettingPopupIsDisplayed(),"Walking Setting pop up is not displayed");
			softassert.assertAll();
			logger.info("**** Completed Hana_T07_WalkingSettings_EditCashRegister_FT ****");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
			logger.error("****Test case failed in Hana_T07_WalkingSettings_EditCashRegister_FT due to "+e.getMessage()+"****");
		}
	}	
}
