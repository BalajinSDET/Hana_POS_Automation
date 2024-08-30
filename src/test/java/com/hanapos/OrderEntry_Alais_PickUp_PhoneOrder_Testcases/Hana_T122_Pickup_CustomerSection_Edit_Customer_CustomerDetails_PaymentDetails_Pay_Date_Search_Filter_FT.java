package com.hanapos.OrderEntry_Alais_PickUp_PhoneOrder_Testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hanapos.pageObjects.HanaDashBoardPage;
import com.hanapos.pageObjects.LoginPage;
import com.hanapos.pageObjects.OrderEntry_Alais_PhoneOrderPage;
import com.hanapos.seleniumProjectBase.TestBaseClass;

public class Hana_T122_Pickup_CustomerSection_Edit_Customer_CustomerDetails_PaymentDetails_Pay_Date_Search_Filter_FT extends TestBaseClass {
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private OrderEntry_Alais_PhoneOrderPage phoneorder;

	//,dataProvider="fetch_Excel_Data"
	@Test(enabled=true,groups= {"Regression"}) 
	public void Validate_Hana_T122_Pickup_CustomerSection_Edit_Customer_CustomerDetails_PaymentDetails_Pay_Date_Search_Filter_Functionality_Test() {
		SoftAssert softassert = new SoftAssert();
		logger.info("**** Starting Hana_T122_Pickup_CustomerSection_Edit_Customer_CustomerDetails_PaymentDetails_Pay_Date_Search_Filter_FT  ****");
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
			softassert.assertTrue(phoneorder.Verify_CustEditIcon_Appears(), "Test Step - 7 - Customer edit icon on phone order page is not displayed");
			
			// Test Step - 8
			phoneorder.Click_CustEditIcon();
			softassert.assertTrue(phoneorder.Verify_CustomerDetailsPopupAppears(), "Test Step - 8 - Customer details popup on is not displayed on phone order page");			
			
			// Test Step - 9
			delayWithGivenTime(1000);
			phoneorder.ClickOn_PaymentDetails_CustomerDetailsPopup();
			ThreadWait(4000);
			softassert.assertTrue(phoneorder.Verify_TableGridOnPaymentDetailsTab_IsAppear(), "Test Step - 9 - payment details tab webtable grid is not displayed");		
						
			// Test Step - 10
			ThreadWait(1000);
			
			phoneorder.Enter_PayDateSearchBox_OnPaymentDetailsTab(CurrentDate());
			softassert.assertEquals(phoneorder.get_PayDate_Paymentdetailstab(), CurrentDate(),"Test Step - 10 - Entered date value on date picker input box field is not displayed");
		
			// Test Step - 11
			
			
			RobotPressEnter();
			softassert.assertTrue(phoneorder.Verify_PayDate_Paymentdetailstab(CurrentDate()),"Test Step - 11 - Filtered Pay date is not displayed on the payment details tab at customer details popup");
			
			// Test Step - 12
			phoneorder.Enter_PayDateSearchBox_OnPaymentDetailsTab(CurrentDate());
		
			// Test Step - 13
			RobotPressEnter();
			softassert.assertTrue(phoneorder.Verify_PayDate_Paymentdetailstab(CurrentDate()),"Test Step - 13 - Filtered Pay Date is not displayed on the payment details tab at customer details popup");
			
			// Test Step - 14
			phoneorder.Enter_PayDateSearchBox_OnPaymentDetailsTab("13/32/20200");	
			RobotPressEnter();
			softassert.assertEquals(phoneorder.get_PayDate_Paymentdetailstab(), "","Test Step - 14 - Entered invalid date value on date picker input box field is not removed");
			
			// Test Step - 15			
			phoneorder.Enter_PayDateSearchBox_OnPaymentDetailsTab(phoneorder.NextDate());	
			RobotPressEnter();
			softassert.assertTrue(phoneorder.Verify_NoCustomerPaymentsFound_PaymentDetailsTab(),"Test Step - 15 - Filtered future Pay Date is not displayed message as No Customer Payments Found on the payment details tab at customer details popup");			
			
			// Test Step - 16
			softassert.assertTrue(phoneorder.Verify_PayDateSearchBox_ClearButton_Appears(),"Test Step - 16 - Clear button in Pay Date search box is not displayed");
			
			// Test Step - 17
			phoneorder.Click_PayDateSearchBox_ClearButton();
			softassert.assertEquals(phoneorder.get_PayDate_Paymentdetailstab(), "","Test Step - 17 - In Pay Date searchbox entered data is not cleared");
			
			// Test Step - 18
			softassert.assertTrue(phoneorder.Verify_FilterIconOptions_PayDateOnPaymentDetailsTab_OnCustomerDetailsPopup(),"Test Step - 18 - Filter icon on pay date it does not displayed the options");
			
			// Test Step - 19 
			phoneorder.Click_CalendarIconOnPayDate_OnPaymentDetailsTab();
			delayWithGivenTime(1000);
			phoneorder.SelectTheDate_FromDatePickerIcon_OnPaymentDetailsTab();
			delayWithGivenTime(1000);
			phoneorder.Click_FilterIconOptions_PayDateOnPaymentDetailsTab_OnCustomerDetailsPopup();
			delayWithGivenTime(1000);
			phoneorder.Click_FilterIconOptions_PayDateOnPaymentDetailsTab_OnCustomerDetailsPopup("Is equal to");
			delayWithGivenTime(1000);
			softassert.assertTrue(phoneorder.Verify_PayDate_Paymentdetailstab(CurrentDate()),"Test Step - 19 - Filtered Pay date is not displayed on the payment details tab at customer details popup");

			// Test Step - 20
			phoneorder.Click_FilterIconOptions_PayDateOnPaymentDetailsTab_OnCustomerDetailsPopup("Is not equal to");
			delayWithGivenTime(1000);
			softassert.assertFalse(phoneorder.Verify_PayDate_Paymentdetailstab(CurrentDate()),"Test Step - 20 - Based on selecting the filter option pay date is not displayed on the payment details tab at customer details popup");
			
			// Test Step - 21
			phoneorder.Click_FilterIconOptions_PayDateOnPaymentDetailsTab_OnCustomerDetailsPopup("Is after or equal to");
			delayWithGivenTime(1000);
			softassert.assertTrue(phoneorder.Verify_PayDate_Paymentdetailstab(CurrentDate()),"Test Step - 21 - Based on selecting the filter option pay date is not displayed on the payment details tab at customer details popup");

			// Test Step - 22
			phoneorder.Click_FilterIconOptions_PayDateOnPaymentDetailsTab_OnCustomerDetailsPopup("Is after");
			delayWithGivenTime(1000);
			/*if(phoneorder.Verify_NoCustomerPaymentsFound_PaymentDetailsTab()==true) {
			softassert.assertTrue(phoneorder.Verify_NoCustomerPaymentsFound_PaymentDetailsTab(),"Test Step - 22 - Based on selecting the filter option pay date not displayed No Payment Customer found message on the payment details tab at customer details popup");
			}else {*/
			softassert.assertTrue(phoneorder.Verify_PayDate_Paymentdetailstab(CurrentDate()),"Test Step - 22 - Based on selecting the filter option pay date is not displayed on the payment details tab at customer details popup");
		//	}
			
			// Test Step - 23
			phoneorder.Click_FilterIconOptions_PayDateOnPaymentDetailsTab_OnCustomerDetailsPopup("Is before or equal to");
			delayWithGivenTime(1000);
			softassert.assertTrue(phoneorder.Verify_PayDate_Paymentdetailstab(CurrentDate()),"Test Step - 23 - Based on selecting the filter option pay date is not displayed on the payment details tab at customer details popup");	
			
			// Test Step - 24
			phoneorder.Click_PayDateSearchBox_ClearButton();
			softassert.assertEquals(phoneorder.get_PayDate_Paymentdetailstab(), "","Test Step - 24 - In Pay Date searchbox entered data is not cleared");
			
			
			} catch (Exception e) {
			e.printStackTrace();
			softassert.fail();
		} finally {
			softassert.assertAll();
		}
	}
}