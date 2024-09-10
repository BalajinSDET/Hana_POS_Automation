package com.hanapos.OrderEntry_Alais_PickUp_PhoneOrder_Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hanapos.pageObjects.CustomerPage;
import com.hanapos.pageObjects.HanaDashBoardPage;
import com.hanapos.pageObjects.LoginPage;
import com.hanapos.pageObjects.OrderEntry_Alais_PhoneOrderPage;
import com.hanapos.pageObjects.Order_Confirmation_Page;
import com.hanapos.seleniumProjectBase.TestBaseClass;

public class Hana_T104_Pickup_CustomerSection_Edit_Customer_CustomerDetails_UnPaidInvoice_FT extends TestBaseClass {
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private OrderEntry_Alais_PhoneOrderPage phoneorder;

	//,dataProvider="fetch_Excel_Data"
	@Test(enabled=true,groups= {"Regression"}) 
	public void Validate_Hana_T104_Pickup_CustomerSection_Edit_Customer_CustomerDetails_UnPaidInvoice_Test() {
		SoftAssert softassert = new SoftAssert();
		logger.info("**** Starting  Hana_T311_OrderEntryPage_Delivery_CustomerSection_Edit_Customer_CustomerDetails_UnPaidInvoice_FT  ****");
		logger.debug("capturing application debug logs....");
		try {
			// Test Step - 1
			lp = new LoginPage();
			softassert.assertTrue(lp.LoginPageIsDisplayed(),"Test Step - 1 : Login page is not displayed");
			logger.info("User on the hana pos login page");
			
			// Test Step - 2
			lp.EnterUserName(prop.getProperty("username"));
			logger.info("User entered the username as "+prop.getProperty("username"));
			lp.EnterPassword(prop.getProperty("password"));
			logger.info("User entered the password as "+prop.getProperty("password"));
			lp.ClickLoginButton();
			logger.info("User clicked on Login button");

			dashboard = new HanaDashBoardPage();
			softassert.assertTrue(dashboard.VerifyHanaDashBoardPage(),"Test Step - 2 : Hana dashboard page is not displayed");
			logger.info("User navigated to hana dashboard page");
			dashboard.SelectShopNameDropDown(prop.getProperty("shopname"));
			logger.info("User select the shopname on dashbaord page as "+prop.getProperty("shopname"));
			
			// Test Step - 3
			delayWithGivenTime(2000);
			softassert.assertTrue(dashboard.VerifyOrderEntryOptionIsDisplayed(),"Test Step - 3 : Order entry option is not displayed");
			softassert.assertTrue(dashboard.Verify_Cashandcarry_OptionIsDisplayed(),"Test Step - 3 : Cash and carry option is not displayed");
		
			// Test Step - 4
			dashboard.ClickOrderEntry();
			logger.info("User hover the mouse on New order and clicked on order entry");
			
			// Test Step - 5
			phoneorder = new OrderEntry_Alais_PhoneOrderPage();
			phoneorder.ClickPickupTypeOnPhoneOrderPage();
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getHighlightedColorOnPickupTypeOnPhoneOrderPage(),"#2f9bc8", "Test Step - 5 - Pickup type is not highlighted in blue color");		
		
			//Test Step - 6
			softassert.assertTrue(phoneorder.VerifyCustSectionAppears(), "Test Step - 6 - Customer section is not displayed on phone order page");
			
			// Test Step - 7
			phoneorder.Select_SalesPersonOn_PhoneOrderEntryPage("Stuart Markwood");
			delayWithGivenTime(2000);
			phoneorder.SearchAndSelect_CustomerOnCust_Section("Abish", "Abish David");
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getFirstnameOnPhoneOrderPage(),"Abish", "Test Step - 7 - First name is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getLastnameOnPhoneOrderPage(),"David", "Test Step - 7 - Last name is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getCompanyNameOnPhoneOrderPage(),"Hana_Sisterchicks", "Test Step - 7 - Company name is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getEmailIdOnPhoneOrderPage(),"hanaposqateam@gmail.com", "Test Step -7 - email id is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getAddress1OnPhoneOrderPage(),"3402 Park Blvd", "Test Step - 7 - address 1 is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getAddress2OnPhoneOrderPage(),"", "Test Step - 7- Address 2 is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getZipCodeOnPhoneOrderPage(),"92103", "Test Step -7 - Zipcode is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getCityOnPhoneOrderPage(),"San Diego", "Test Step -7 - city is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getPhoneNumberOnPhoneOrderPage(),"956-655-0756", "Test Step - 7 - phone number 1 is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getAltPhoneNumberOnPhoneOrderPage(),"956-655-0756", "Test Step - 7 - Alt phone number is not displayed on phone order page");
			delayWithGivenTime(2000);
		
			// Test Step - 8
			softassert.assertTrue(phoneorder.Verify_CustEditIcon_Appears(), "Test Step - 8 - Customer clear button is not displayed on phone order page");			
			phoneorder.Click_CustEditIcon();
			softassert.assertTrue(phoneorder.Verify_CustomerDetailsPopupAppears(), "Test Step - 9 - Customer details popup on is not displayed on phone order page");
			
			// Test Step - 9
			delayWithGivenTime(1000);
			phoneorder.Click_UnpaidInvoiceTab_OnCustDetailsPopup();
			delayWithGivenTime(1000);
			
		
			// Test Step - 10
			phoneorder.Click_Row1Inv_UnpaidInvoiceTab_OnCustDetailsPopup();
			softassert.assertTrue(phoneorder.Verify_InvoicePopup_Appears_OnUnpaidInvoiceTab(),"Test Step - 10 - Invoice details popup is not displayed on phone order page");
			phoneorder.ClickCloseIcon_InvoicePopup_OnUnpaidInvoiceTab();
		
			// Test Step - 11
			softassert.assertFalse(phoneorder.Verify_MakePaymentBtn_InvoicePopup_OnUnpaidInvoiceTab(),"Test Step - 11 - Make payment button is enabled on unpaid invoice tab at phone order page");
			
			// Test Step - 12
			phoneorder.Click_Row1_Checkbox_UnpaidInvoiceTab_OnCustDetailsPopup();
			
			// Test Step - 13
			phoneorder.Click_MakePaymentBtn_InvoicePopup_OnUnpaidInvoiceTab();
			
			// Test Step - 14
			softassert.assertTrue(phoneorder.Verify_InvoicePaymentDetails_UnpaidInvoiceTab_OnCustDetailsPopup(),"Test Step - 14 - Invoice payment details section is not displayed on phone order page");
			
			// Test Step - 15
			delayWithGivenTime(2000);
			phoneorder.Select_PaymentMethod_OnUnpaidInvoiceTab("Cash");
			phoneorder.Select_CashRegistry_OnUnpaidInvoiceTab("Cash Register2");
			
			//Test Step - 16
			phoneorder.EnterPaymentAmount_InvoiceDetails_UnpaidInvoiceTab();
			phoneorder.Click_cancelButton_InvoiceDetails_UnpaidInvoiceTab();
			
			//Test Step - 17
			phoneorder.Click_MakePaymentBtn_InvoicePopup_OnUnpaidInvoiceTab();
			delayWithGivenTime(2000);
			softassert.assertTrue(phoneorder.Verify_InvoicePaymentDetails_UnpaidInvoiceTab_OnCustDetailsPopup(),"Test Step - 14 - Invoice payment details section is not displayed on phone order page");
			phoneorder.Select_PaymentMethod_OnUnpaidInvoiceTab("Cash");
			phoneorder.Select_CashRegistry_OnUnpaidInvoiceTab("Cash Register2");	
			phoneorder.EnterPaymentAmount_InvoiceDetails_UnpaidInvoiceTab();
			phoneorder.Click_SubmitButton_InvoiceDetails_UnpaidInvoiceTab();
			
			delayWithGivenTime(1000);
			softassert.assertTrue(phoneorder.Verify_SuccessMessage_InvoiceDetails_UnpaidInvoiceTab(),"Test Step - 17 - Payment processed successfully message is not displayed on unpaid invoice tab on customer details popup on phone order page");
			
			// Test Step -18
			delayWithGivenTime(1000);
			softassert.assertEquals(phoneorder.get_SelectedCashRegistry_InvoiceDetails_UnpaidInvoiceTab(),"Cash Register2", "Test Step - 18 - Selected cash registry is not displayed on unpaid invoice tab in confirmation section at customer details popup on phone order page");
			softassert.assertEquals(phoneorder.get_emailreceipt_UnpaidInvoiceTab(),"hanaposqateam@gmail.com", "Test Step - 18 - Email receipt is not displayed on unpaid invoice tab in confirmation section at customer details popup on phone order page");
			
			// Test Step - 19
			delayWithGivenTime(1000);
			phoneorder.Click_PrintRecieptButton_ConfirmationSection_UnpaidInvoiceTab();
		//	RobotDismissAlert();
			delayWithGivenTime(1000);
			softassert.assertTrue(phoneorder.verifySuccessToastMessageAppears(),"Test Step - 19 - Success toast message is not displayed on unpaid invoice tab in confirmation section at customer details popup on phone order page");
			softassert.assertEquals(phoneorder.verifySuccessToastMessageText(),"Receipt Print Completed Successfully", "Test Step - 19 - Success toast message text is not displayed on unpaid invoice tab in confirmation section at customer details popup on phone order page");			
			
			// Test Step - 20
			delayWithGivenTime(1000);
			phoneorder.Click_EmailRecieptButton_ConfirmationSection_UnpaidInvoiceTab();
			delayWithGivenTime(1000);
			softassert.assertTrue(phoneorder.verifySuccessToastMessageAppears(),"Test Step - 20 - Success toast message is not displayed on unpaid invoice tab in confirmation section at customer details popup on phone order page");
			softassert.assertEquals(phoneorder.verifySuccessToastMessageText(),"Email Sent Successfully.", "Test Step - 20 - Success toast message text is not displayed on unpaid invoice tab in confirmation section at customer details popup on phone order page");			
			
			// Test Step - 21
			delayWithGivenTime(1000);
			phoneorder.ClickBackButton_ConfirmationSection_UnpaidInvoiceTab();
			delayWithGivenTime(1000);
			softassert.assertTrue(phoneorder.Verify_UnpaidInvoiceTable_UnpaidInvoiceTab(),"Test Step - 21 - Unpaid invoice table is not displayed on unpaid invoice tab in customer details popup on phone order page");
			
		} catch (Exception e) {
			Assert.fail("Test case failed due to exception " + e.getMessage());
			logger.error("Test case failed due to exception " + e.getMessage());
		} finally {
			softassert.assertAll();
		}
	}
}