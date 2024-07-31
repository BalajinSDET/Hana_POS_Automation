package com.hanapos.OrderEntry_Alais_PhoneOrderTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hanapos.pageObjects.HanaDashBoardPage;
import com.hanapos.pageObjects.LoginPage;
import com.hanapos.pageObjects.OrderEntry_Alais_PhoneOrderPage;
import com.hanapos.seleniumProjectBase.TestBaseClass;

public class Hana_T090_Pickup_CustomerSection_AddressLookup_FT extends TestBaseClass {
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private OrderEntry_Alais_PhoneOrderPage phoneorder;
	
	//,dataProvider="fetch_Excel_Data"
	@Test(enabled=true,groups= {"Regression"}) 
	public void Validate_Hana_T090_Pickup_CustomerSection_AddressLookup_Test() {
		SoftAssert softassert = new SoftAssert();
		logger.info("**** Starting  Hana_T90_Pickup_CustomerSection_AddressLookup_FT  ****");
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
			softassert.assertTrue(phoneorder.VerifyCustSectionAppears(), "Test Step - 6 - Customer section is not displayed on phone order page");
			
			// Test Step - 7
			phoneorder.Select_SalesPersonOn_PhoneOrderEntryPage("Stuart Markwood");
			phoneorder.EnterCustomerFirstName("Mike");
			softassert.assertEquals(phoneorder.getFirstnameOnPhoneOrderPage().contains("Mike"),true, "Test Step - 7 - First name is not displayed on phone order page");

			// Test Step - 8
			phoneorder.EnterCustomerLastName("Tyson");
			softassert.assertEquals(phoneorder.getLastnameOnPhoneOrderPage().contains("Tyson"),true, "Test Step - 8 - Last name is not displayed on phone order page");

			// Test Step - 9
			phoneorder.EnterCustomerCompanyName("Mike tyson ltd");
			softassert.assertEquals(phoneorder.getCompanyNameOnPhoneOrderPage().contains("Mike tyson ltd"),true, "Test Step - 9 - Company name is not displayed on phone order page");
			
			// Test Step - 10
			phoneorder.EnterCustomerEmailId("hanaposqateam@gmail.com");
			softassert.assertEquals(phoneorder.getEmailIdOnPhoneOrderPage().contains("hanaposqateam@gmail.com"),true, "Test Step - 10 - Email ID is not displayed on phone order page");

			// Test Step - 11
			phoneorder.EnterAddress1("Texas Road");
			delayWithGivenTime(1000);
			softassert.assertFalse(phoneorder.VerifyGoogleMap_Address1_CustSection(),"Test Step - 11 - Address 1 field google map does not show autosuggestion");
			
			// Test Step - 12
			delayWithGivenTime(1000);
			phoneorder.SearchAndSelect_Address1_CustSection("Broome", "Broome Street New York");
			delayWithGivenTime(1000);
			softassert.assertEquals(phoneorder.getAddress1OnPhoneOrderPage(),"Broome St", "Test Step - 12 - address 1 is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getZipCodeOnPhoneOrderPage(),"", "Test Step - 12 - Zipcode is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getCityOnPhoneOrderPage(),"New York", "Test Step - 12 - city is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getStateOnPhoneOrderPage(),"NY", "Test Step - 12 - state is not displayed on phone order page");
			phoneorder.EnterPhoneNumber("1234567890");
			
			// Test Step - 13
			delayWithGivenTime(1000);
			phoneorder.SearchAndSelect_Address1_CustSection("10 S Main St Driggs", "10 S Main St Driggs");
			delayWithGivenTime(1000);
			softassert.assertEquals(phoneorder.getAddress1OnPhoneOrderPage(),"10 S Main St", "Test Step - 12 - address 1 is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getZipCodeOnPhoneOrderPage(),"83422", "Test Step - 12 - Zipcode is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getCityOnPhoneOrderPage(),"Driggs", "Test Step - 12 - city is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getStateOnPhoneOrderPage(),"ID", "Test Step - 12 - state is not displayed on phone order page");
			phoneorder.EnterPhoneNumber("1234567890");
			softassert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Test case failed due to exception " + e.getMessage());
			logger.error("Test case failed due to exception " + e.getMessage());
		} finally {
			softassert.assertAll();
		}
	}
}