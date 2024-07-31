package com.hanapos.OrderEntry_Alais_PhoneOrderTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hanapos.pageObjects.HanaDashBoardPage;
import com.hanapos.pageObjects.LoginPage;
import com.hanapos.pageObjects.OrderEntry_Alais_PhoneOrderPage;
import com.hanapos.seleniumProjectBase.TestBaseClass;

public class Hana_T085_Pickup_CustomerSection_SearchExistingCustomer_FT extends TestBaseClass {
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private OrderEntry_Alais_PhoneOrderPage phoneorder;
	
	//,dataProvider="fetch_Excel_Data"
	@Test(enabled=true,groups= {"Regression"}) 
	public void Validate_Hana_T085_Pickup_CustomerSection_SearchExistingCustomer_Test() {
		SoftAssert softassert = new SoftAssert();
		logger.info("**** Starting  Hana_T85_Pickup_CustomerSection_SearchExistingCustomer_FT  ****");
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
			phoneorder.ClickPickupTypeOnPhoneOrderPage();
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getHighlightedColorOnPickupTypeOnPhoneOrderPage(),"#2f9bc8", "Pickup type is not highlighted in blue color");		
		
			//Test Step - 6
			phoneorder.Select_SalesPersonOn_PhoneOrderEntryPage("Stuart Markwood");
			softassert.assertTrue(phoneorder.VerifyCustSectionAppears(), "Test Step - 6 - Customer section is not displayed on phone order page");
			
			// Test Step - 7
			phoneorder.SearchAndSelect_CustomerOnCust_Section("Abi", "Abish David");
			delayWithGivenTime(2000);
			
			// Test Step - 8
			phoneorder.ClickOn_CustClearBtn();
			delayWithGivenTime(2000);
			softassert.assertTrue(phoneorder.VerifyAutosuggestion_Displayed_On_Cust_Section("@#$$!$#"),"Autosuggestion is displayed on customer section");
			delayWithGivenTime(2000);
		
			// Test Step - 9
			phoneorder.ClickOn_CustClearBtn();
			delayWithGivenTime(2000);
			phoneorder.SearchAndSelectCustomerOnCust_Section("Abish");
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getFirstnameOnPhoneOrderPage(),"Abish", "Test Step - 9 - First name is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getLastnameOnPhoneOrderPage(),"David", "Test Step - 9 - Last name is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getCompanyNameOnPhoneOrderPage(),"Hana_Sisterchicks", "Test Step - 9 - Company name is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getEmailIdOnPhoneOrderPage(),"hanaposqateam@gmail.com", "Test Step -9 - email id is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getAddress1OnPhoneOrderPage(),"3402 Park Blvd", "Test Step - 9 - address 1 is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getAddress2OnPhoneOrderPage(),"", "Test Step - 9- Address 2 is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getZipCodeOnPhoneOrderPage(),"92103", "Test Step -9 - Zipcode is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getCityOnPhoneOrderPage(),"San Diego", "Test Step -9 - city is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getPhoneNumberOnPhoneOrderPage(),"956-655-0756", "Test Step - 9 - phone number 1 is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getAltPhoneNumberOnPhoneOrderPage(),"956-655-0756", "Test Step - 9 - Alt phone number is not displayed on phone order page");

			// Test Step - 10
			softassert.assertFalse(phoneorder.VerifyFnameField_On_CustSection_IsDisabled(),"Test STep - 10 - First name field is not disabled");
			softassert.assertFalse(phoneorder.VerifyLnameField_On_CustSection_IsDisabled(),"Test Step - 10 - Last name field is not disabled");
			softassert.assertFalse(phoneorder.VerifyCompanyNameField_On_CustSection_IsDisabled(),"Test Step - 10 - Company name field is not disabled");
			softassert.assertFalse(phoneorder.VerifyEmailIdField_On_CustSection_IsDisabled(),"Test Step - 10 - Email id field is not disabled");
			softassert.assertFalse(phoneorder.VerifyAddress1Field_On_CustSection_IsDisabled(),"Test Step - 10 - Address 1 field is not disabled");
			softassert.assertFalse(phoneorder.VerifyZipcodeField_On_CustSection_IsDisabled(),"Test Step - 10 - Zip code field is not disabled");
			softassert.assertFalse(phoneorder.VerifyCityField_On_CustSection_IsDisabled(),"Test Step - 10 - City field is not disabled");
			softassert.assertFalse(phoneorder.VerifyPhonenumberField_On_CustSection_IsDisabled(),"Test Step - 10 - Phone number 1 field is not disabled");
			softassert.assertFalse(phoneorder.VerifyAltPhonenumberField_On_CustSection_IsDisabled(),"Test Step - 10 - Alt phone number field is not disabled");		
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Test case failed due to exception " + e.getMessage());
			logger.error("Test case failed due to exception " + e.getMessage());
		} finally {
			softassert.assertAll();
		}
	}
}