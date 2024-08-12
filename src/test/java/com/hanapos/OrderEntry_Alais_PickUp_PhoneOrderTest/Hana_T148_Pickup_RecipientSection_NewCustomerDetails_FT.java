package com.hanapos.OrderEntry_Alais_PickUp_PhoneOrderTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hanapos.pageObjects.DashboardOrderPage;
import com.hanapos.pageObjects.HanaDashBoardPage;
import com.hanapos.pageObjects.LoginPage;
import com.hanapos.pageObjects.OrderEntry_Alais_PhoneOrderPage;
import com.hanapos.pageObjects.Order_Confirmation_Page;
import com.hanapos.seleniumProjectBase.TestBaseClass;

public class Hana_T148_Pickup_RecipientSection_NewCustomerDetails_FT extends TestBaseClass {
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private OrderEntry_Alais_PhoneOrderPage phoneorder;
	private DashboardOrderPage dashboardorder;
	private Order_Confirmation_Page orderconfirmationpage;
	
	//,dataProvider="fetch_Excel_Data"
	@Test(enabled=true,groups= {"Regression"}) 
	public void Validate_Hana_T148_Pickup_RecipientSection_NewCustomerDetails_Functionality_Test() {
		SoftAssert softassert = new SoftAssert();
		logger.info("**** Starting  Hana_T148_Pickup_RecipientSection_NewCustomerDetails_FT  ****");
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
			phoneorder.EnterCustomerFirstName("Mark"+twodigitrandomeString());
			phoneorder.EnterCustomerLastName("Smith"+twodigitrandomeString());
			phoneorder.EnterAddress1("3402 Park Blvd");
			phoneorder.EnterZipCode("94610");
			phoneorder.EnterPhoneNumber("956-444-0756");
			phoneorder.EnterAltPhoneNumber("956-444-0756");
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getFirstnameOnPhoneOrderPage().contains("Mark"),true, "Test Step - 6 - First name is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getLastnameOnPhoneOrderPage().contains("Smith"),true, "Test Step - 6 - Last name is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getAddress1OnPhoneOrderPage(),"3402 Park Blvd", "Test Step - 6 - address 1 is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getZipCodeOnPhoneOrderPage(),"94610", "Test Step - 6 - Zipcode is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getPhoneNumberOnPhoneOrderPage(),"956-444-0756", "Test Step - 6 - phone number 1 is not displayed on phone order page");
			phoneorder.EnterReciFirstName("");
			delayWithGivenTime(2000);
			softassert.assertTrue(phoneorder.Verify_NewCustomer_Label_Appears(), "Test Step - 6 - New customer label is not displayed on phone order page");
			
			// Test Step - 7
			softassert.assertEquals(phoneorder.getReciFirstName().contains("Mark"),true,"Test Step - 7 - Displayed first name is not matched with customer first name on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciLastName().contains("Smith"),true,"Test Step - 7 - Displayed last name is not matched with customer last name on phone order page recipient section");
						
			// Test Step - 8
			softassert.assertEquals(phoneorder.getReciAddress1(),"114 N CHURCH ST","Test Step - 8 - Displayed address 1 is not matched with customer address 1 field on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciAddress2(),"PICK UP","Test Step - 8 - Displayed address 2 is not matched with customer address 2 field on phone order page recipient section");
						
			// Test Step - 9
			softassert.assertEquals(phoneorder.getReciPhone(),"956-444-0756","Test Step - 9 - Displayed phone number is not matched with customer phonenumber 1 on phone order page recipient section");
			
			// Test Step - 10
			softassert.assertEquals(phoneorder.getRecipientPhone2OnPhoneOrderPage(),"956-444-0756","Test Step - 10 - Displayed alt phone number is not matched with customer phonenumber2 on phone order page recipient section");
			
			// Test Step - 11
			ThreadWait(3000);
			phoneorder.EnterCustomerFirstName("Ben"+twodigitrandomeString());
			phoneorder.EnterCustomerLastName("Parker"+twodigitrandomeString());
			phoneorder.EnterAddress1("3402 Park Blvd");
			phoneorder.EnterZipCode("92103");
			phoneorder.EnterPhoneNumber("956-444-0756");
			phoneorder.EnterAltPhoneNumber("956-444-0756");
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getFirstnameOnPhoneOrderPage().contains("Ben"),true, "Test Step - 11 - First name is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getLastnameOnPhoneOrderPage().contains("Parker"),true, "Test Step - 11 - Last name is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getAddress1OnPhoneOrderPage().contains("3402 Park Blvd"),true, "Test Step - 11 - address 1 is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getZipCodeOnPhoneOrderPage(),"92103", "Test Step - 11 - Zipcode is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getPhoneNumberOnPhoneOrderPage(),"956-444-0756", "Test Step - 11 - phone number 1 is not displayed on phone order page");
			phoneorder.EnterReciFirstName("");
			delayWithGivenTime(2000);
			softassert.assertTrue(phoneorder.Verify_NewCustomer_Label_Appears(), "Test Step - 11 - New customer label is not displayed on phone order page");
					
			// Test Step - 12
			softassert.assertEquals(phoneorder.getReciFirstName().contains("Ben"),true,"Test Step - 12 - Displayed first name is not matched with customer firstname on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciLastName().contains("Parker"),true,"Test Step - 12 - Displayed last name is not matched with customer lastname on phone order page recipient section");
			
			// Test Step - 13
			softassert.assertEquals(phoneorder.getReciAddress1(),"114 N CHURCH ST","Test Step - 13 - Displayed recipient address 1 is not matched with customer address 1 field on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciAddress2(),"PICK UP","Test Step - 13 - Displayed recipient address 2 is not matched with customer address 2 on phone order page recipient section");
			
			// Test Step - 14
			softassert.assertEquals(phoneorder.getReciPhone(),"956-444-0756","Test Step - 14 - Recipient phone number is not matched with customer phonenumber 1 field on phone order page recipient section");
			
			// Test Step - 15
			softassert.assertEquals(phoneorder.getRecipientPhone2OnPhoneOrderPage(),"956-444-0756","Test Step - 15 - Recipient alt phone number is not matched with customer phonenumber2 on phone order page recipient section");
		
			} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Test case failed due to exception " + e.getMessage());
			logger.error("Test case failed due to exception " + e.getMessage());
		} finally {
			softassert.assertAll();
		}
	}
}