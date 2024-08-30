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

public class Hana_T183_OrderEntryPage_Pickup_ProductSection_GiftCardSale_popup_Edit_GiftCard_Denominations_Edit_Functionality extends TestBaseClass {
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private OrderEntry_Alais_PhoneOrderPage phoneorder;

	
	//,dataProvider="fetch_Excel_Data"
	@Test(enabled=true,groups= {"Regression"}) 
	public void Validate_Hana_T177_OrderEntry_Pickup_PaymentSection_GiftCardPayment_Functionality_Test() {
		SoftAssert softassert = new SoftAssert();
		logger.info("**** Starting  Validate_Hana_T177_OrderEntry_Pickup_PaymentSection_GiftCardPayment_Functionality_Test ****");
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
			dashboard.ClickOrderEntry();
			logger.info("User hover the mouse on New order and clicked on order entry");
			
			// Test Step - 4
			phoneorder = new OrderEntry_Alais_PhoneOrderPage();
			phoneorder.Click_AddGiftCardIcon_OnPhoneorderPage();
			softassert.assertTrue(phoneorder.Verify_GiftCardPopup_OnPhoneorderPage(), "Test Step - 4 - Gift Card popup is not displayed");
			
			// Test Step - 5
			phoneorder.Click_EditIcon_OnGiftCardPopup();
			softassert.assertTrue(phoneorder.Verify_EditGiftCardDenomination_Popup_IsDisplayed(),"Test Step - 5 - Edit gift card denomination popup is not displayed");
			
			//Test Step - 6
			phoneorder.Enter_Denomination7_OnEditDenominationGiftCardPopup("220");
			softassert.assertEquals(phoneorder.get_Entered_Denomination7(),"220","Test Step - 6 - Entered denomination 7 is not displayed");
			phoneorder.Click_CancelButton_OnEditDenominationGiftCardPopup();
			softassert.assertTrue(phoneorder.Verify_GiftCardPopup_OnPhoneorderPage(), "Test Step - 6 - Gift Card popup is not displayed");
			
			// Test Step - 7
			phoneorder.Click_EditIcon_OnGiftCardPopup();
			softassert.assertTrue(phoneorder.Verify_EditGiftCardDenomination_Popup_IsDisplayed(),"Test Step - 7 - Edit gift card denomination popup is not displayed");
			phoneorder.Enter_Denomination7_OnEditDenominationGiftCardPopup("220");
			softassert.assertEquals(phoneorder.get_Entered_Denomination7(),"220","Test Step - 7 - Entered denomination 7 is not displayed");
			
			// Test Step - 8
			phoneorder.Click_SubmitButton_OnEditDenominationGiftCardPopup();
			softassert.assertEquals(phoneorder.verifySuccessToastMessageText(), "Gift Card Denominations Saved Successfully","Test Step - 8 - Gift card denomination saved successfully has been added toasted message is not displayed");
			softassert.assertTrue(phoneorder.Verify_GiftCardPopup_OnPhoneorderPage(), "Test Step - 8 - Gift Card popup is not displayed");
			
			// Test Step - 9
			softassert.assertEquals(phoneorder.get_InstantDenomination7(),"$220","Test Step - 9 - updated Instant denomination 7 is not displayed on gift card popup");
			
			// Test Step - 10			
			phoneorder.Click_GiftCardInstantDenomination7();
			softassert.assertEquals(phoneorder.get_giftcardamountTextboxField(), "220.00","Test Step - 10 - Gift card amount is not displayed as expected behaviour");
			softassert.assertEquals(phoneorder.get_giftCardTotalAmount(), "220.00","Test Step - 10 - Gift card total amount is not displayed as expected behaviour");
		
			// Set previously displayed data...
			phoneorder.Click_EditIcon_OnGiftCardPopup();
			softassert.assertTrue(phoneorder.Verify_EditGiftCardDenomination_Popup_IsDisplayed(),"Test Step - 7 - Edit gift card denomination popup is not displayed");
			phoneorder.Enter_Denomination7_OnEditDenominationGiftCardPopup("210");
			phoneorder.Click_SubmitButton_OnEditDenominationGiftCardPopup();
			softassert.assertEquals(phoneorder.verifySuccessToastMessageText(), "Gift Card Denominations Saved Successfully","Test Step - 11 - Gift card denomination saved successfully has been added toasted message is not displayed");
			softassert.assertTrue(phoneorder.Verify_GiftCardPopup_OnPhoneorderPage(), "Test Step - 11 - Gift Card popup is not displayed");
	
		
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Test case failed due to exception " + e.getMessage());
			logger.error("Test case failed due to exception " + e.getMessage());
		} finally {
			softassert.assertAll();
		}
	}
}