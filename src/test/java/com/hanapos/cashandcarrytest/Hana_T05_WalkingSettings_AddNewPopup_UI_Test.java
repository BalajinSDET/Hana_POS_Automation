package com.hanapos.cashandcarrytest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hanapos.pageObjects.CashAndCarryPage;
import com.hanapos.pageObjects.HanaDashBoardPage;
import com.hanapos.pageObjects.LoginPage;
import com.hanapos.seleniumProjectBase.TestBaseClass;

public class Hana_T05_WalkingSettings_AddNewPopup_UI_Test extends TestBaseClass {
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private CashAndCarryPage cashandcarry;
	
	SoftAssert softassert = new SoftAssert();
	//retryAnalyzer= com.hanapos.utilities.RetryTest.class,
	@Test(enabled=true,groups= {"Regression"})
	public void Validate_Hana_T05_WalkingSetting_AddNewBtn_UIElement_Test() {
		
		// HANA-POS-TC-005 - Verify Walking Settings Add New Buutton UI Element
		
		//Test Step - 1
		logger.info("**** Starting Hana_T05_WalkingSettings_AddNewPopup_UI_CashAndCarryTest  ****");
		logger.debug("capturing application debug logs....");
		try {
			lp = new LoginPage();
			softassert.assertTrue(lp.LoginPageIsDisplayed(),"Login page is not displayed");
			logger.info("User on the hana pos login page");
			
			lp.EnterUserName(prop.getProperty("username"));
			
			lp.EnterPassword(prop.getProperty("password"));
			lp.ClickLoginButton();
			logger.info("Clicked on Login button..");

			dashboard = new HanaDashBoardPage();
			
			//Test Step - 2
			softassert.assertTrue(dashboard.VerifyHanaDashBoardPage(),"Page does not navigated to hana dashboard page");
			logger.info("User navigated to hana dashboard page sucess..");
			dashboard.SelectShopNameDropDown(prop.getProperty("shopname"));
			dashboard.CashAndCarryMenuClick();							
			cashandcarry = new CashAndCarryPage();

			//Test Step - 3
			logger.info("User hover the mouse on New order and click on Cash and Carry..");
			softassert.assertTrue(cashandcarry.VerifyCashAndCarryPage(), "Cash And Carry page is not displayed");

			logger.info("User verify the Cash and Carry page is displayed..");
					
			//Test Step - 4
			cashandcarry.ClickWalkingSettingIcon();
			delayWithGivenTime(3000);
			softassert.assertTrue(cashandcarry.verifyWalkingSettingPopupIsDisplayed(),"Walking Setting pop up is not displayed");
			delayWithGivenTime(2000);
			
			//Test Step - 5
			cashandcarry.ClickAddNewButtonOnWalkingSettingPopup();
			
			//Test Step - 6
			softassert.assertTrue(cashandcarry.VerifyAddNewWalkingSettingPopupIsDisplayed());
			
			softassert.assertTrue(cashandcarry.clerkIdLabelonAddnewPopupIsExists(),"Clerk Id label is not displayed");
			softassert.assertTrue(cashandcarry.clerkIdTextboxonAddnewPopupIsDisplayed(),"Clerk Id textbox is not displayed");
			softassert.assertTrue(cashandcarry.clerkDescriptionLabelonAddnewPopupIsDisplayed(),"Clerk description label is not displayed");
			softassert.assertTrue(cashandcarry.clerkDescriptionTextboxonAddnewPopupIsDisplayed(),"Clerk description textbox is not displayed");
			softassert.assertTrue(cashandcarry.printerNameonAddnewPopupIsDisplayed(),"printer name label is not displayed");
			softassert.assertTrue(cashandcarry.printerNameTextboxonAddnewPopupIsDisplayed(),"printer name textbox is not displayed");
			softassert.assertTrue(cashandcarry.manufacturerLabelonAddnewPopupIsDisplayed(),"manufacturer label is not displayed");
			softassert.assertTrue(cashandcarry.manufacturerDropdownonAddnewPopupIsDisplayed(),"manufacturer dropdown is not displayed");
			softassert.assertTrue(cashandcarry.modelLabelonAddnewPopupIsDisplayed(),"model label is not displayed");
			softassert.assertTrue(cashandcarry.modelDropdownonAddnewPopupIsDisplayed(),"model dropdown is not displayed");
			softassert.assertTrue(cashandcarry.cashdrawcodeLabelonAddnewPopupIsDisplayed(),"cashdraw label is not displayed");
			softassert.assertTrue(cashandcarry.cashdrawcodeTextboxonAddnewPopupIsDisplayed(),"cashdraw textbox is not displayed");
			softassert.assertTrue(cashandcarry.printercutcodeLabelonAddnewPopupIsDisplayed(),"printercut label is not displayed");
			softassert.assertTrue(cashandcarry.printercutcodeTextboxonAddnewPopupIsDisplayed(),"printercut textbox is not displayed");
			softassert.assertTrue(cashandcarry.clearantApiKeyLabelonAddnewPopupIsDisplayed(),"clearant label is not displayed");
			softassert.assertTrue(cashandcarry.clearantApiKeyTextboxonAddnewPopupIsDisplayed(),"clearant API Key textbox is not displayed");
			softassert.assertTrue(cashandcarry.cloverDeviceIdLabelonAddnewPopupIsDisplayed(),"clover label is not displayed");
			softassert.assertTrue(cashandcarry.cloverDeviceIdTextboxonAddnewPopupIsDisplayed(),"clover device id textbox is not displayed");
			softassert.assertTrue(cashandcarry.clovercashdrawerIdLabelonAddnewPopupIsDisplayed(),"clovercashdrawer label is not displayed");
			softassert.assertTrue(cashandcarry.clovercashdrawerIdsearchicononAddnewPopupIsDisplayed(),"clovercashdrawer search icon is not displayed");
			softassert.assertTrue(cashandcarry.enableCloverPrinteronAddnewPopupIsDisplayed(),"enable clover label is not displayed");
			softassert.assertTrue(cashandcarry.enableCloverPrinterCheckboxonAddnewPopupIsDisplayed(),"enable clover label is not displayed");
			
			if(cashandcarry.openEdgeWebIDonAddnewPopupIsDisplayed()==true){ 
			softassert.assertTrue(cashandcarry.openEdgeWebIDonAddnewPopupIsDisplayed(),"open edge web id label is not displayed");
			}else{
				softassert.fail("open edge web id label is not displayed");
			}
			
			if(cashandcarry.openEdgeWebIDTextboxonAddnewPopupIsDisplayed()==true) {
			softassert.assertTrue(cashandcarry.openEdgeWebIDTextboxonAddnewPopupIsDisplayed(),"open edge web id textbox is not displayed");
			}else{
				softassert.fail("open edge web id textbox is not displayed");
			}
			
			if(cashandcarry.openEdgeTerminalIDLabelonAddnewPopupIsDisplayed()==true) {
			softassert.assertTrue(cashandcarry.openEdgeTerminalIDLabelonAddnewPopupIsDisplayed(),"open edge terminal id label is not displayed");
			}
			else{
				softassert.fail("open edge terminal id label is not displayed");
			}
			
			if(cashandcarry.openEdgeTerminalIDTextboxonAddnewPopupIsDisplayed()==true) {
				softassert.assertTrue(cashandcarry.openEdgeTerminalIDTextboxonAddnewPopupIsDisplayed(),"open edge terminal id label is not displayed");
			}
			else{
				softassert.fail("open edge terminal id label is not displayed");
			}
			if(cashandcarry.openEdgeAuthKeyLabelonAddnewPopupIsDisplayed()==true) {
				softassert.assertTrue(cashandcarry.openEdgeAuthKeyLabelonAddnewPopupIsDisplayed(),"open edge terminal id label is not displayed");
			}
			else{
				softassert.fail("open edge terminal id label is not displayed");
			}
			
			if(cashandcarry.openEdgeAuthKeyTextboxonAddnewPopupIsDisplayed()==true) {
				softassert.assertTrue(cashandcarry.openEdgeAuthKeyTextboxonAddnewPopupIsDisplayed(),"open edge terminal id label is not displayed");		
			}
			else{
				softassert.fail("open edge terminal id label is not displayed");
			}
			softassert.assertTrue(cashandcarry.OpenEdgeCustomerCopyLabelonAddnewPopupIsDisplayed(),"open edge web id label is not displayed");
			softassert.assertTrue(cashandcarry.openEdgeCustomerCopyCheckboxonAddnewPopupIsDisplayed(),"open edge web id checkbox is not displayed");
			softassert.assertTrue(cashandcarry.OpenEdgeMerchantCopyLabelonAddnewPopupIsDisplayed(),"merchant copy label is not displayed");
			softassert.assertTrue(cashandcarry.openEdgeMerchantCopyCheckboxonAddnewPopupIsDisplayed(),"merchant copy checkbox is not displayed");
			softassert.assertTrue(cashandcarry.custCopyNoteLabelonAddnewPopupIsDisplayed(),"customer copy note label is not displayed");
			softassert.assertTrue(cashandcarry.custCopyNoteTextboxonAddnewPopupIsDisplayed(),"customer copy note textbox is not displayed");
			softassert.assertTrue(cashandcarry.merchantCopyNoteLabelonAddnewPopupIsDisplayed(),"merchant copy note label is not displayed");
			softassert.assertTrue(cashandcarry.merchantCopyNoteTextboxonAddnewPopupIsDisplayed(),"merchant copy note textbox is not displayed");

			softassert.assertTrue(cashandcarry.saveBtnonAddnewPopupIsDisplayed(),"save button is not displayed");
			softassert.assertTrue(cashandcarry.cancelBtnonAddnewPopupIsDisplayed(),"cancel button is not displayed");
			softassert.assertTrue(cashandcarry.closeIconOnAddnewPopupIsDisplayed(),"close icon is not displayed");
			
			softassert.assertAll();
			logger.info("***** Ended test cases Hana_T05_WalkingSettings_AddNewPopup_UI_CashAndCarryTest *****");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
			logger.error("Test Case failed due to "+e.getMessage());
		}
	}	
}
