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

public class Hana_T101_Pickup_CustomerSection_Edit_Customer_CustomerDetails_CreditCard_AddNewCard_FT extends TestBaseClass {
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private OrderEntry_Alais_PhoneOrderPage phoneorder;

	//,dataProvider="fetch_Excel_Data"
	@Test(enabled=true,groups= {"Regression"}) 
	public void Validate_Hana_T101_Pickup_CustomerSection_Edit_Customer_CustomerDetails_CreditCard_AddNewCard_Test() {
		SoftAssert softassert = new SoftAssert();
		logger.info("**** Starting  Hana_T101_Pickup_CustomerSection_Edit_Customer_CustomerDetails_CreditCard_AddNewCard_FT  ****");
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
			phoneorder.SearchAndSelectCustomerOnCust_Section("Abish");
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
			phoneorder.Click_CreditCardTab_OnCustDetailsPopup();
			delayWithGivenTime(1000);
		
			// Test Step - 10	
			phoneorder.Click_AddNewBtn_CreditCardTab_OnCustDetailsPopup();
			softassert.assertTrue(phoneorder.Verify_AddNewInformation_Popup(),"Test Step - 10 - Add new information popup on credit card tab is not displayed on phone order page");
			
			// Test Step - 11
			delayWithGivenTime(2000);
			phoneorder.Enter_CreditCardTab_FirstName_OnCustDetailsPopup("Abish");
			softassert.assertEquals(phoneorder.get_CreditCardTab_EnteredFirstName_OnCustDetailsPopup(),"Abish", "Test Step - 11 - Entered first name on customer details popup at credit card tab is not displayed on phone order page");			
			
			// Test Step - 12
			phoneorder.Enter_CreditCardTab_LastName_OnCustDetailsPopup("David");
			softassert.assertEquals(phoneorder.get_CreditCardTab_EnteredLastName_OnCustDetailsPopup(),"David", "Test Step - 12 - Entered last name on customer details popup at credit card tab is not displayed on phone order page");
			
			//Test Step - 13
			phoneorder.Enter_CreditCardTab_CreditCardNumber_OnCustDetailsPopup("4242424242424242");
			softassert.assertEquals(phoneorder.get_CreditCardTab_EnteredCreditCardNumber_OnCustDetailsPopup(),"4242424242424242", "Test Step - 13 - Entered credit card number on customer details popup at credit card tab is not displayed on phone order page");
			
			//Test Step - 14
			phoneorder.Enter_CreditCardTab_ExpDate_OnCustDetailsPopup("1026");
			softassert.assertEquals(phoneorder.get_CreditCardTab_EnteredExpDate_OnCustDetailsPopup(),"1026", "Test Step - 14 - Entered exp date on customer details popup at credit card tab is not displayed on phone order page");
			
			// Test Step - 15
			phoneorder.Enter_CreditCardTab_CVV_OnCustDetailsPopup("123");
			softassert.assertEquals(phoneorder.get_CreditCardTab_EnteredCVV_OnCustDetailsPopup(),"123", "Test Step - 15 - Entered CVV on customer details popup at credit card tab is not displayed on phone order page");
			
			// Test Step - 16
			phoneorder.Enter_CreditCardTab_Zipcode_OnCustDetailsPopup("12345");
			softassert.assertEquals(phoneorder.get_CreditCardTab_EnteredZipcode_OnCustDetailsPopup(),"12345", "Test Step - 16 - Entered zipcode on customer details popup at credit card tab is not displayed on phone order page");
			
			//Test Step- 17
			phoneorder.Click_SaveBtn_CreditCardTab_OnCustDetailsPopup();
			softassert.assertTrue(phoneorder.Verify_SavedInformation_Popup(),"Test Step - 17 - Saved information popup on credit card tab is not displayed on phone order page");			
		
			// Test Step - 18
			phoneorder.Click_CloseIcon_CreditCardTab_OnCustDetailsPopup();
			
			// Test Step - 19
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Test case failed due to exception " + e.getMessage());
			logger.error("Test case failed due to exception " + e.getMessage());
		} finally {
			softassert.assertAll();
		}
	}
}