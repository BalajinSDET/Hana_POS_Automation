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
			dashboard.SelectShopNameDropDown("SISTERCHICKS FLOWERS AND MORE LLC");
			dashboard.CashAndCarryMenuClick();							
			cashandcarry = new CashAndCarryPage();

			//Test Step - 3
			logger.info("User hover the mouse on New order and click on Cash and Carry..");
			softassert.assertTrue(cashandcarry.VerifyCashAndCarryPage(), "Cash And Carry page is not displayed");

			logger.info("User verify the Cash and Carry page is displayed..");

			//Test Step - 4
			cashandcarry.ClickWalkingSettingIcon();
			delayWithGivenTime(2000);
			softassert.assertTrue(cashandcarry.verifyWalkingSettingPopupIsDisplayed(),"Walking Setting pop up is not displayed");
			delayWithGivenTime(1000);

			//Test Step - 5		
			softassert.assertEquals(cashandcarry.getDeleteBtnToolTiponAddnewPopupIsDisplayed(),"Inactive Cash Register");	
			cashandcarry.ClickDeleteBtnOnParticularWalkInSetting();

			//Test Step - 6
			softassert.assertTrue(cashandcarry.verifyDeleteConfirmationPopupIsDisplayed());
			
			//Test Step - 7
			softassert.assertEquals(cashandcarry.verifyDeleteConfirmationPopuText().contains("Are you sure you wish to remove this cash register?"),true);
			softassert.assertTrue(cashandcarry.confirmationcodeTextBoxIsDisplayed());
			softassert.assertEquals(cashandcarry.VerifyconfirmationCodePlaceholder(),"Confirmation code");
			softassert.assertTrue(cashandcarry.CancelBtnInDeleteConfirmationPopupIsDisplayed());
			softassert.assertTrue(cashandcarry.OkBtnInDeleteConfirmationPopup());
			
			//Test Step- 8
			cashandcarry.ClickCancelBtnInDeleteConfirmationPopup();
			
			//Test Step - 9
			cashandcarry.ClickDeleteBtnOnParticularWalkInSetting();
			softassert.assertTrue(cashandcarry.verifyDeleteConfirmationPopupIsDisplayed());
			
			//Test Step - 10
			cashandcarry.EnterConfirmationCodeInDeleteConfirmationPopup("1234");
			cashandcarry.ClickOkBtnInDeleteConfirmationPopup();
			delayWithGivenTime(500);
			softassert.assertEquals(cashandcarry.validateInvalidDeleteConfirmationCode(), "Incorrect confirmation code!");
			softassert.assertTrue(cashandcarry.validateInvalidDeleteConfirmationCodeCrossIcon());
			
			//Test Step - 11
			cashandcarry.EnterDeleteConfirmationCode();
			cashandcarry.ClickOkBtnInDeleteConfirmationPopup();
			softassert.assertTrue(cashandcarry.VerifySuccessMessageIsDisplayed());
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
