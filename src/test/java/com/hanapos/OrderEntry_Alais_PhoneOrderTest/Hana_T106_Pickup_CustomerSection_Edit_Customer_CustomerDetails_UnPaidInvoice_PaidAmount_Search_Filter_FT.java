package com.hanapos.OrderEntry_Alais_PhoneOrderTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hanapos.pageObjects.HanaDashBoardPage;
import com.hanapos.pageObjects.LoginPage;
import com.hanapos.pageObjects.OrderEntry_Alais_PhoneOrderPage;
import com.hanapos.pageObjects.Order_Confirmation_Page;
import com.hanapos.seleniumProjectBase.TestBaseClass;

public class Hana_T106_Pickup_CustomerSection_Edit_Customer_CustomerDetails_UnPaidInvoice_PaidAmount_Search_Filter_FT extends TestBaseClass {
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private OrderEntry_Alais_PhoneOrderPage phoneorder;
	private Order_Confirmation_Page orderconfirmationpage;

	//,dataProvider="fetch_Excel_Data"
	@Test(enabled=true,groups= {"Regression"}) 
	public void Validate_Hana_T106_Pickup_CustomerSection_Edit_Customer_CustomerDetails_UnPaidInvoice_PaidAmount_Search_Filter_Test() {
		SoftAssert softassert = new SoftAssert();
		logger.info("**** Starting  Hana_T106_Pickup_CustomerSection_Edit_Customer_CustomerDetails_UnPaidInvoice_PaidAmount_Search_Filter_FT  ****");
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
			phoneorder.Select_SalesPersonOn_PhoneOrderEntryPage("Stuart Markwood");
			delayWithGivenTime(2000);
			phoneorder.SearchAndSelectCustomerOnCust_Section("Abish");
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getFirstnameOnPhoneOrderPage(),"Abish", "Test Step - 6 - First name is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getLastnameOnPhoneOrderPage(),"David", "Test Step - 6 - Last name is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getCompanyNameOnPhoneOrderPage(),"Hana_Sisterchicks", "Test Step - 6 - Company name is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getEmailIdOnPhoneOrderPage(),"hanaposqateam@gmail.com", "Test Step -6 - email id is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getAddress1OnPhoneOrderPage(),"3402 Park Blvd", "Test Step - 6 - address 1 is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getAddress2OnPhoneOrderPage(),"", "Test Step - 6 - Address 2 is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getZipCodeOnPhoneOrderPage(),"92103", "Test Step - 6 - Zipcode is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getCityOnPhoneOrderPage(),"San Diego", "Test Step - 6 - city is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getPhoneNumberOnPhoneOrderPage(),"956-655-0756", "Test Step - 6 - phone number 1 is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getAltPhoneNumberOnPhoneOrderPage(),"956-655-0756", "Test Step - 6 - Alt phone number is not displayed on phone order page");
			delayWithGivenTime(2000);
		
			// Test Step - 7
			softassert.assertTrue(phoneorder.Verify_CustEditIcon_Appears(), "Test Step - 7 - Customer clear button is not displayed on phone order page");			
			
			// Test Step  - 8
			phoneorder.Click_CustEditIcon();
			softassert.assertTrue(phoneorder.Verify_CustomerDetailsPopupAppears(), "Test Step - 8 - Customer details popup on is not displayed on phone order page");
			
			// Test Step - 9
			delayWithGivenTime(1000);
			phoneorder.Click_UnpaidInvoiceTab_OnCustDetailsPopup();
			delayWithGivenTime(1000);			
		
			// Test Step - 10			
			phoneorder.Enter_PaidAmount_OnInvoiceSearchBox_UnpaidInvoiceTab("500");
	
			// Test Step - 11
			RobotPressEnter();
			delayWithGivenTime(1000);
			softassert.assertEquals(phoneorder.get_PaidAmount_UnpaidInvoiceTable_OnUnpaidInvoiceTab(),phoneorder.get_PaidAmount_UnpaidInvoiceTable_OnUnpaidInvoiceTab(),
					"Test Step - 11 Displayed paid amount is did not matched with previously searched invoice number on unpaid invoice grid table");
			
			// Test Step - 12
			phoneorder.Enter_PaidAmount_OnInvoiceSearchBox_UnpaidInvoiceTab("50");
			
			// Test Step 13
			RobotPressEnter();
			delayWithGivenTime(1000);
			softassert.assertEquals(phoneorder.get_PaidAmount_UnpaidInvoiceTable_OnUnpaidInvoiceTab(),phoneorder.get_PaidAmount_UnpaidInvoiceTable_OnUnpaidInvoiceTab(),
					"Test Step - 13 Displayed paid amount is did not matched with previously searched invoice number on unpaid invoice grid table");
			
			// Test Step - 14
			phoneorder.Enter_PaidAmount_OnInvoiceSearchBox_UnpaidInvoiceTab("123445");
			RobotPressEnter();
			delayWithGivenTime(1000);
			softassert.assertEquals(phoneorder.get_PaidAmount_UnpaidInvoiceTable_OnUnpaidInvoiceTab(),phoneorder.get_PaidAmount_UnpaidInvoiceTable_OnUnpaidInvoiceTab(),
					"Test Step - 14 Displayed paid amount is did not matched with previously searched invoice number on unpaid invoice grid table");
		
			// Test Step - 15
			softassert.assertTrue(phoneorder.Verify_ClearButton_AppearsOnPaidAmtSearchtextbox_UnpaidInvoiceTab(), "Test Step - 15 - Clear button is not displayed on invoice search textbox at unpaid invoice tab in customer details popup");
			
			// Test Step - 16
			delayWithGivenTime(1000);
			phoneorder.Click_Clearbutton_PaidAmtsearchtextbox_UnpaidInvoiceTab();
			delayWithGivenTime(1000);
			softassert.assertEquals(phoneorder.get_PaidAmount_UnpaidInvoiceTable_OnUnpaidInvoiceTab(),"","Test Step - 16 - Entered invoice number on search text box is not getting cleared ");
			softassert.assertNotEquals(phoneorder.Verify_ListofInvoiceNumbers_Appears_InUnpaidInvoiceTable_OnUnpaidInvoiceTab(), 0,"Test Step - 16 - Unpaid Invoices are not displayed in unpaid invoice table on unpaid invoice tab customer details popup");
			
			
			
			
			
			
			
			
			// Pre - requisite for Test Step - 10	
			delayWithGivenTime(1000);
			phoneorder.Click_Customer_DetailsPopupCloseBtn();
			delayWithGivenTime(2000);

			phoneorder.SearchAndSelectCustomerOnCust_Section("Abish");
			delayWithGivenTime(2000);
			
			phoneorder.EnterReciFirstName("Abish");
			phoneorder.EnterReciLastName("David");
			phoneorder.EnterDeliveryDateOnReciSection();
			delayWithGivenTime(2000);
			phoneorder.SelectOccasion_On_OrderDetails_In_PhoneOrderPage("Birthday");
			phoneorder.EnterViewShortCode();			
			delayWithGivenTime(2000);
			phoneorder.SearchandSelectItemcodeOnPhoneOrderPage("rrd");
			delayWithGivenTime(2000);
			phoneorder.SelectPaymentTypeOnPhoneOrderPage_PaymentSection("Invoice/House Account");
			delayWithGivenTime(1000);
		
			phoneorder.ClickPlaceOrderButton();
			delayWithGivenTime(1000);
			getDriver().switchTo().activeElement();
			delayWithGivenTime(2000);
			phoneorder.ClickSubmitButton_On_ConfirmationPopup();
			delayWithGivenTime(2000);
			orderconfirmationpage = new Order_Confirmation_Page();
			softassert.assertTrue(orderconfirmationpage.VerifyOrderConfirmationPage(), "Test Step - 13 - Order confirmation page is not displayed");
			delayWithGivenTime(2000);

			dashboard.ClickOnHomeIcon();
			delayWithGivenTime(2000);
			dashboard.ClickOrderEntry();
			delayWithGivenTime(2000);
			phoneorder = new OrderEntry_Alais_PhoneOrderPage();
			phoneorder.ClickPickupTypeOnPhoneOrderPage();
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getHighlightedColorOnPickupTypeOnPhoneOrderPage(),"#2f9bc8", "Test Step - 5 - Pickup type is not highlighted in blue color");		
			
			delayWithGivenTime(2000);
			phoneorder.SearchAndSelectCustomerOnCust_Section("Abish");
			delayWithGivenTime(2000);
			phoneorder.Click_CustEditIcon();
		//	softassert.assertTrue(phoneorder.Verify_CustomerDetailsPopupAppears(), "Test Step - 8 - Customer details popup on is not displayed on phone order page");	
			delayWithGivenTime(1000);
			phoneorder.Click_UnpaidInvoiceTab_OnCustDetailsPopup();
			delayWithGivenTime(1000);
					
			phoneorder.Click_LastRowCheckbox_OnUnpaidInvoiceTable_UnpaidInvoiceTab();

			phoneorder.Click_MakePaymentBtn_InvoicePopup_OnUnpaidInvoiceTab();
	
			softassert.assertTrue(phoneorder.Verify_InvoicePaymentDetails_UnpaidInvoiceTab_OnCustDetailsPopup(),"Test Step - 14 - Invoice payment details section is not displayed on phone order page");
			delayWithGivenTime(2000);
			phoneorder.Select_PaymentMethod_OnUnpaidInvoiceTab("Cash");
			phoneorder.Select_CashRegistry_OnUnpaidInvoiceTab("Cash Register2");
	
			phoneorder.Enter_PaymentAmount_InvoiceDetails_UnpaidInvoiceTab("50");
			phoneorder.Click_SubmitButton_InvoiceDetails_UnpaidInvoiceTab();
			delayWithGivenTime(1000);
			phoneorder.ClickBackButton_ConfirmationSection_UnpaidInvoiceTab();
			delayWithGivenTime(1000);
			softassert.assertTrue(phoneorder.Verify_UnpaidInvoiceTable_UnpaidInvoiceTab(),"Test Step - 21 - Unpaid invoice table is not displayed on unpaid invoice tab in customer details popup on phone order page");
			delayWithGivenTime(1000);
			
		} catch (Exception e) {
			Assert.fail("Test case failed due to exception " + e.getMessage());
			logger.error("Test case failed due to exception " + e.getMessage());
		} finally {
			softassert.assertAll();
		}
	}
}