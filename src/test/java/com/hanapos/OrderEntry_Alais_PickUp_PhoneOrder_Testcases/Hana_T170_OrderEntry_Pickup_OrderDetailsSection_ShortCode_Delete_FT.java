package com.hanapos.OrderEntry_Alais_PickUp_PhoneOrder_Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hanapos.pageObjects.DashboardOrderPage;
import com.hanapos.pageObjects.HanaDashBoardPage;
import com.hanapos.pageObjects.LoginPage;
import com.hanapos.pageObjects.Marketing_RemaindersPage;
import com.hanapos.pageObjects.OrderEntry_Alais_PhoneOrderPage;
import com.hanapos.pageObjects.Order_Confirmation_Page;
import com.hanapos.seleniumProjectBase.TestBaseClass;
import com.hanapos.utilities.CustomSoftAssert;

public class Hana_T170_OrderEntry_Pickup_OrderDetailsSection_ShortCode_Delete_FT extends TestBaseClass {
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private OrderEntry_Alais_PhoneOrderPage phoneorder;

	
	//,dataProvider="fetch_Excel_Data"
	@Test(enabled=true,groups= {"Regression"}) 
	public void Validate_Hana_T170_OrderEntry_Pickup_OrderDetailsSection_ShortCode_Delete_Functionality_Test() {
		// SoftAssert softassert = new SoftAssert(); - I have modified this to use CustomSoftAssert
		CustomSoftAssert softassert = new CustomSoftAssert();
		
		logger.info("**** Starting  Validate_Hana_T170_OrderEntry_Pickup_OrderDetailsSection_ShortCode_Delete_Functionality_Test ****");
		logger.debug("capturing application debug logs....");
		try {
			// Test Step - 1
			lp = new LoginPage();
			softassert.assertTrue(lp.LoginPageIsDisplayed(),"Login page is not displayed");
			logger.info("User on the hana pos login page");
			
			// Test Step - 2
			lp.EnterUserName(prop.getProperty("username"));
			logger.info("User entered the username as "+prop.getProperty("username"));
			lp.EnterPassword(prop.getProperty("password"));
			logger.info("User entered the password as "+prop.getProperty("password"));
			lp.ClickLoginButton();
			logger.info("User clicked on Login button");

			dashboard = new HanaDashBoardPage();
			softassert.assertTrue(dashboard.VerifyHanaDashBoardPage(),"Page does not navigated to hana dashboard page");
			logger.info("User navigated to hana dashboard page");
			dashboard.SelectShopNameDropDown(prop.getProperty("shopname"));
			logger.info("User select the shopname on dashbaord page as "+prop.getProperty("shopname"));
			
			// Test Step - 3
			delayWithGivenTime(2000);
			softassert.assertTrue(dashboard.VerifyOrderEntryOptionIsDisplayed(),"Order entry option is not displayed");
			softassert.assertTrue(dashboard.Verify_Cashandcarry_OptionIsDisplayed(),"Cash and carry option is not displayed");
		
			// Test Step - 4
			dashboard.ClickOrderEntry();
			logger.info("User hover the mouse on New order and clicked on order entry");
			
			// Test Step - 5
			phoneorder = new OrderEntry_Alais_PhoneOrderPage();
			softassert.assertTrue(phoneorder.Verify_OrderDetailsSectionAppears(),"Test Step - 5 - Order details section is not displayed");
			
			// Test Step - 6
			delayWithGivenTime(2000);
			phoneorder.Click_ViewShortCodes_Hyperlink();
			
			// Test Step - 7
			// Prerequites - Short code should be added
			delayWithGivenTime(2000);
			softassert.assertTrue(phoneorder.Verify_ViewShortCodes_PopupIsDisplayed(),"Test Step - 7 - View short codes popup is not displayed");
			phoneorder.SetCode_OnViewShortCodesPopup("At");
			delayWithGivenTime(500);
			softassert.assertEquals(phoneorder.get_EnteredCode_OnViewShortCodesPopup(),"At", "Test Step - 7 - Entered Code on short codes popup is not displayed");

			phoneorder.SetValue_OnViewShortCodesPopup("Automation Test");			
			delayWithGivenTime(500);
			softassert.assertEquals(phoneorder.get_EnteredValue_OnViewShortCodesPopup(),"Automation Test","Test Step - 7 - Entered Value on View short codes popup is not displayed");
	
			delayWithGivenTime(1000);
			phoneorder.Click_AddButton_OnViewShortCodesPopup();
			softassert.assertEquals(phoneorder.Verify_ToastMsgText(), "Info", "Test Step - 7 - Toast message text is not displayed properly");
			softassert.assertEquals(phoneorder.verifySuccessToastMessageText(),"New Short Code Added Successfully","Test Step - 7 - Toast message text is not displayed properly");
	
			delayWithGivenTime(1000);
			softassert.assertTrue(phoneorder.Verify_ViewShortCodes_HyperlinkIsDisplayed(),"Test Step - 7 -  view short codes hyperlink is not displayed");
			phoneorder.Click_ViewShortCodes_Hyperlink();			
	
			delayWithGivenTime(2000);
			softassert.assertTrue(phoneorder.Verify_AddedShortCode_IsDisplayed_OnViewShortCodesPopup(),"Test Step - 7 - Added view short codes into the view short codes popup which is not displayed");
			delayWithGivenTime(500);	
			
			softassert.assertTrue(phoneorder.Verify_DeleteIconDisplayed());			
			phoneorder.Click_DeleteIcon_OnShortCodesPopup();
			delayWithGivenTime(500);
		
			softassert.assertTrue(phoneorder.Verify_ConfirmationPopup(), "Test Step - 7 - Confirmation popup is not displayed");
			delayWithGivenTime(500);
			
			// Test Step - 8
			softassert.assertTrue(phoneorder.Verify_DeleteConfirmation(), "Test Step - 8 - Delete confirmation popup and their elements are not displayed");
			
			// Test Step - 9
			phoneorder.Click_NoButtonDeleteConfirmation();
			
			// Test Step - 10
			softassert.assertTrue(phoneorder.Verify_DeleteIconDisplayed(),"Test Step - 10 - Delete icon is not displayed on short codes popup");			
			phoneorder.Click_DeleteIcon_OnShortCodesPopup();
			delayWithGivenTime(500);		
			softassert.assertTrue(phoneorder.Verify_ConfirmationPopup(), "Test Step - 10 - Confirmation popup is not displayed");
			delayWithGivenTime(500);
			softassert.assertTrue(phoneorder.Verify_DeleteConfirmation(), "Test Step - 10 - Delete confirmation popup and their elements are not displayed");		
			phoneorder.Click_DeleteButtonDeleteConfirmation();
			softassert.assertEquals(phoneorder.Verify_ToastMsgText(), "Short code deleted successfully!", "Test Step - 10 - short code deleted successfully! Toast message text is not displayed properly");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Test case failed due to exception " + e.getMessage());
			logger.error("Test case failed due to exception " + e.getMessage());
		} finally {
			softassert.assertAll();
		}
	}
}