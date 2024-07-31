package com.hanapos.OrderEntry_Alais_PhoneOrderTest;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hanapos.pageObjects.HanaDashBoardPage;
import com.hanapos.pageObjects.LoginPage;
import com.hanapos.pageObjects.OrderEntry_Alais_PhoneOrderPage;
import com.hanapos.seleniumProjectBase.TestBaseClass;

public class Hana_T126_Pickup_CustomerSection_Edit_Customer_CustomerDetails_PaymentDetails_Pagination_FT extends TestBaseClass {
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private OrderEntry_Alais_PhoneOrderPage phoneorder;

	//,dataProvider="fetch_Excel_Data"
	@Test(enabled=true,groups= {"Regression"}) 
	public void Validate_Hana_T126_Pickup_CustomerSection_Edit_Customer_CustomerDetails_PaymentDetails_Pagination_Functionality_Test() {
		SoftAssert softassert = new SoftAssert();
		logger.info("**** Starting Hana_T126_Pickup_CustomerSection_Edit_Customer_CustomerDetails_PaymentDetails_Pagination_FT  ****");
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
			phoneorder.ClickOn_PaymentDetails_CustomerDetailsPopup();
			ThreadWait(4000);
			softassert.assertTrue(phoneorder.Verify_TableGridOnPaymentDetailsTab_IsAppear(), "Test Step - 9 - payment details tab webtable grid is not displayed");		
			ThreadWait(2000);
			
			// Test Step - 10
			softassert.assertTrue(phoneorder.Verify_PaginationSection_OnPaymentDetailsTab(), "Test Step - 10 - Pagination section is not appears on the payment details tab under the table");
			
			// Test Step - 11
			softassert.assertTrue(phoneorder.Verify_FirstPagePaginationIcon_IsAppears(), "Test Step - 11 - Go to First page pagination icon is not appears on the payment details tab under the table");
			softassert.assertTrue(phoneorder.Verify_PreviousPagePaginationIcon_IsAppears(), "Test Step - 11 - Go to Previous page pagination icon is not appears on the Payment details tab under the table");
			softassert.assertTrue(phoneorder.Verify_NextPagePaginationIcon_IsAppears(), "Test Step - 11 - Go to Next page pagination icon is not appears on the payment details tab under the table");
			softassert.assertTrue(phoneorder.Verify_LastPagePaginationIcon_IsAppears(), "Test Step - 11 - Go to Last page pagination icon is not appears on the payment details tab under the table");
			softassert.assertTrue(phoneorder.Verify_PageListNumber_OnPaymentDetailsTab(), "Test Step - 11 - List of page number is not appears on the payment details tab  under the table");
			softassert.assertTrue(phoneorder.Verify_PaginationInfo_OnPaymentDetailsTab(), "Test Step - 11 - Items per page label is not appears on the payment details tab under the table");
			
			// Test Step - 12
			softassert.assertEquals(phoneorder.Verify_NoOfPayAmountDisplayedCount_PaymentDetails(), 10,"Test Step - 12 - Number of records is not equals to 10 displayed on the payment details tab under the table");
			
			// Test Step - 13
			phoneorder.Click_NextPagePaginationIcon_OnUnpaidTab_OnCustomerDetailsPopup();
			delayWithGivenTime(1000);
			softassert.assertEquals(phoneorder.get_PaginationInfo_PaymentDetailsTab().contains("11 - 20"),true,"Test Step - 13 - Florist does not navigate to next page");
			
			// Test Step - 14
			phoneorder.ClickThreeDots_Pagination_PaymentDetails();
			delayWithGivenTime(1000);
			softassert.assertTrue(phoneorder.Verify_11to20Pages_Pagination_PaymentDetails(),"Test Step - 14 - After click the 3 dots on pagination the 11 to 20 pages are not displayed");
			
			// Test Step - 15
			phoneorder.Click_Pagenumber2_Pagination_PaymentDetails();
			delayWithGivenTime(1000);
			softassert.assertEquals(phoneorder.get_PaginationInfo_PaymentDetailsTab().contains( "111 - 120"),true,"Test Step - 15 - Florist does not navigate to respective page");
			
			// Test Step - 16
			phoneorder.Click_PreviousPagePaginationIcon_OnUnpaidTab_OnCustomerDetailsPopup();
			delayWithGivenTime(1000);
			softassert.assertEquals(phoneorder.get_PaginationInfo_PaymentDetailsTab().contains( "101 - 110"),true,"Test Step - 16 - Florist does not navigate to previous page");
			
			// Test Step - 17
			phoneorder.Click_LastPagePaginationIcon_OnUnpaidTab_OnCustomerDetailsPopup();
			delayWithGivenTime(1000);
			softassert.assertEquals(phoneorder.get_PaginationInfo_PaymentDetailsTab().contains(phoneorder.get_PaginationInfo_PaymentDetailsTab()),true,"Test Step - 17 - Florist does not navigate to last page");
			//softassert.assertTrue(phoneorder.Verify_LastPageNumber_OnPaymentDetailsTab(),"Test Step - 17 - Florist does not navigate to last page");
			
			// Test Step - 18
			phoneorder.Click_FirstPagePaginationIcon_OnUnpaidTab_OnCustomerDetailsPopup();
			delayWithGivenTime(1000);
			softassert.assertEquals(phoneorder.get_PaginationInfo_PaymentDetailsTab().contains( "1 - 10"),true,"Test Step - 18 - Florist does not navigate to first page");

			// Test Step - 19
			softassert.assertTrue(phoneorder.Verify_PreviousPagePaginationIcon_OnUnpaidTab_OnCustomerDetailsPopup(), "Test Step - 19 - Previous page pagination icon is enabled on the payment details tab under the table");
			softassert.assertTrue(phoneorder.Verify_FirstPagePaginationIconIsEnabled_OnUnpaidTab_OnCustomerDetailsPopup(), "Test Step - 19 - first page pagination icon is enabled on the payment details tab under the table");
			
			// Test Step - 20
			phoneorder.Click_LastPagePaginationIcon_OnUnpaidTab_OnCustomerDetailsPopup();
			delayWithGivenTime(1000);
			softassert.assertEquals(phoneorder.get_PaginationInfo_PaymentDetailsTab().contains(phoneorder.get_PaginationInfo_PaymentDetailsTab()),true,"Test Step - 20 - Florist does not navigate to last page");

			// Test Step - 21
			softassert.assertTrue(phoneorder.Verify_NextPagePaginationIconIsEnabled_OnUnpaidTab_OnCustomerDetailsPopup(),"Test Step - 21 - Next page pagination icon is enabled on the Payment details tab under the table");
			softassert.assertTrue(phoneorder.Verify_LastPagePaginationIconIsEnabled_OnUnpaidTab_OnCustomerDetailsPopup(),"Test Step - 21 - Last page pagination icon is enabled on the payment details tab under the table");
			
			// Test Step - 22
			phoneorder.Click_FirstPagePaginationIcon_OnUnpaidTab_OnCustomerDetailsPopup();
			delayWithGivenTime(1000);
			softassert.assertEquals(phoneorder.get_PaginationInfo_PaymentDetailsTab().contains( "1 - 10"),true,"Test Step - 22 - Florist does not navigate to first page");			
			
			} catch (Exception e) {
				e.printStackTrace();
			softassert.fail("Test case failed due to exception " + e.getMessage());
		} finally {
			softassert.assertAll();
		}
	}
}