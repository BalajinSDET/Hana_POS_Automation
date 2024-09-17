package com.hanapos.CashandCarry_Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hanapos.pageObjects.CashAndCarryPage;
import com.hanapos.pageObjects.HanaDashBoardPage;
import com.hanapos.pageObjects.LoginPage;
import com.hanapos.seleniumProjectBase.TestBaseClass;
import com.hanapos.utilities.CustomSoftAssert;

public class Hana_T08_WalkingSettings_DeleteCashRegister_FT extends TestBaseClass {
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private CashAndCarryPage cashandcarry;

	// SoftAssert softassert = new SoftAssert(); - I have modified this to use CustomSoftAssert
	CustomSoftAssert softassert = new CustomSoftAssert();
//retryAnalyzer= com.hanapos.utilities.RetryTest.class,
	@Test(enabled=true,groups= {"Regression"})
	public void Validate_Hana_T08_WalkingSetting_Delete_CashRegister_Test() {
		// HANA-T8 - Verify Walking Settings delete Cash Register

		//Test Step - 1
		logger.info("**** Starting Hana_T08_WalkingSettings_Delete_CashRegister_FunctionalityTest  ****");
		logger.debug("capturing application debug logs....");
		try {
			lp = new LoginPage();
			softassert.assertTrue(lp.LoginPageIsDisplayed(),"Test Step - 1 : Login page is not displayed");
			logger.info("User on the hana pos login page");
			
			logger.info("Entering valid username and password..");
			lp.EnterUserName(prop.getProperty("username"));
			lp.EnterPassword(prop.getProperty("password"));
			lp.ClickLoginButton();
			logger.info("Clicked on Login button..");

			dashboard = new HanaDashBoardPage();

			//Test Step - 2
			Assert.assertTrue(dashboard.VerifyHanaDashBoardPage(),"Test Step - 2 : Hana dashboard Page does not navigated to hana dashboard page");
			logger.info("User navigated to hana dashboard page sucess..");
			dashboard.SelectShopNameDropDown("SISTERCHICKS FLOWERS AND MORE LLC");
			dashboard.CashAndCarryMenuClick();							
			cashandcarry = new CashAndCarryPage();

			//Test Step - 3
			logger.info("User hover the mouse on New order and click on Cash and Carry..");
			softassert.assertTrue(cashandcarry.VerifyCashAndCarryPage(), "Test Step - 3 : Cash And Carry page is not displayed");

			logger.info("User verify the Cash and Carry page is displayed..");

			//Test Step - 4
			cashandcarry.ClickWalkingSettingIcon();
			delayWithGivenTime(2000);
			softassert.assertTrue(cashandcarry.verifyWalkingSettingPopupIsDisplayed(),"Test Step - 4 : Walking Setting pop up is not displayed");
			delayWithGivenTime(1000);

			//Test Step - 5		
			softassert.assertEquals(cashandcarry.getDeleteBtnToolTiponAddnewPopupIsDisplayed(),"Inactive Cash Register","Test Step - 5 - Delete button tooltip is not displayed");	
			cashandcarry.ClickDeleteBtnOnParticularWalkInSetting();

			//Test Step - 6
			softassert.assertTrue(cashandcarry.verifyDeleteConfirmationPopupIsDisplayed(),"Test Step - 6 : Delete confirmation pop up is not displayed");
			
			//Test Step - 7
			softassert.assertEquals(cashandcarry.verifyDeleteConfirmationPopuText().contains("Are you sure you wish to remove this cash register?"),true,"Test Step - 7 - Delete confirmation pop up text is not displayed");
			softassert.assertTrue(cashandcarry.confirmationcodeTextBoxIsDisplayed(),"Test Step - 7 - Delete confirmation pop up text is not displayed");
			softassert.assertEquals(cashandcarry.VerifyconfirmationCodePlaceholder(),"Confirmation code","Test Step - 7 - Delete confirmation pop up text is not displayed");
			softassert.assertTrue(cashandcarry.CancelBtnInDeleteConfirmationPopupIsDisplayed(),"Test Step - 7 - Delete confirmation pop up text is not displayed");
			softassert.assertTrue(cashandcarry.OkBtnInDeleteConfirmationPopup(),"Test Step - 7 - Delete confirmation pop up text is not displayed");
			
			//Test Step- 8
			cashandcarry.ClickCancelBtnInDeleteConfirmationPopup();
			
			//Test Step - 9
			cashandcarry.ClickDeleteBtnOnParticularWalkInSetting();
			softassert.assertTrue(cashandcarry.verifyDeleteConfirmationPopupIsDisplayed(),"Test Step - 9 : Delete confirmation pop up is not displayed");
			
			//Test Step - 10
			cashandcarry.EnterConfirmationCodeInDeleteConfirmationPopup("1234");
			cashandcarry.ClickOkBtnInDeleteConfirmationPopup();
			delayWithGivenTime(500);
			softassert.assertEquals(cashandcarry.validateInvalidDeleteConfirmationCode(), "Incorrect confirmation code!","Test Step - 10 - Delete confirmation pop up text is not displayed");
			softassert.assertTrue(cashandcarry.validateInvalidDeleteConfirmationCodeCrossIcon(),"Test Step - 10 - Delete confirmation pop up text is not displayed");
			
			//Test Step - 11
			cashandcarry.EnterDeleteConfirmationCode();
			cashandcarry.ClickOkBtnInDeleteConfirmationPopup();
			softassert.assertTrue(cashandcarry.VerifySuccessMessageIsDisplayed(),"Test Step - 11 - Delete confirmation pop up text is not displayed");
			//Cash Register Inactived successfully
			softassert.assertAll();
			logger.info("**** Ended Hana_T08_WalkingSettings_Delete_CashRegister_FunctionalityTest  ****");
		
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
			logger.error("Test case failed due to "+e.getMessage());
		}
	}	
}
