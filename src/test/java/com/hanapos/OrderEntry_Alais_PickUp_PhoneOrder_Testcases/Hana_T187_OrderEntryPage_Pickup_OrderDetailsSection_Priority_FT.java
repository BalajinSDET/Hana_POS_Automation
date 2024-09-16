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

public class Hana_T187_OrderEntryPage_Pickup_OrderDetailsSection_Priority_FT extends TestBaseClass {
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private OrderEntry_Alais_PhoneOrderPage phoneorder;
	private DashboardOrderPage dashboardorder;
	
	private Order_Confirmation_Page orderconfirmationpage;
	
	//,dataProvider="fetch_Excel_Data"
	@Test(enabled=true,groups= {"Regression"}) 
	public void Validate_Hana_T187_OrderEntryPage_Pickup_OrderDetailsSection_Priority_Functionality_Test() {
		// SoftAssert softassert = new SoftAssert(); - I have modified this to use CustomSoftAssert
		CustomSoftAssert softassert = new CustomSoftAssert();
		
		logger.info("**** Starting  Validate_Hana_T187_OrderEntryPage_Pickup_OrderDetailsSection_Priority_Functionality_Test ****");
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
			phoneorder.ClickPickupTypeOnPhoneOrderPage();
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getHighlightedColorOnPickupTypeOnPhoneOrderPage(),"#2f9bc8", "Test Step - 6 - Pickup type is not highlighted in blue color");		
		
			phoneorder.Select_SalesPersonOn_PhoneOrderEntryPage("Stuart Markwood");
			softassert.assertTrue(phoneorder.VerifyCustSectionAppears(), "Test Step - 6 - Customer section is not displayed on phone order page");
			phoneorder.SearchAndSelectCustomerOnCust_Section("Abish");
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getFirstnameOnPhoneOrderPage(),"Abish", "Test Step - 6 - First name is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getLastnameOnPhoneOrderPage(),"David", "Test Step - 6 - Last name is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getCompanyNameOnPhoneOrderPage(),"Hana_Sisterchicks", "Test Step - 6 - Company name is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getEmailIdOnPhoneOrderPage(),"hanaposqateam@gmail.com", "Test Step - 6 - email id is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getAddress1OnPhoneOrderPage(),"3402 Park Blvd", "Test Step - 6 - address 1 is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getAddress2OnPhoneOrderPage(),"", "Test Step - 6 - Address 2 is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getZipCodeOnPhoneOrderPage(),"92103", "Test Step - 6 - Zipcode is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getCityOnPhoneOrderPage(),"San Diego", "Test Step - 6 - city is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getPhoneNumberOnPhoneOrderPage(),"956-655-0756", "Test Step - 6 - phone number 1 is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getAltPhoneNumberOnPhoneOrderPage(),"956-655-0756", "Test Step - 6 - Alt phone number is not displayed on phone order page");		
			
			delayWithGivenTime(1000);
			phoneorder.SearchAndSelectReciAddress1("1160 W 5th St, Washington, MO");
			delayWithGivenTime(2000);
			phoneorder.Enter_DeliveryTime_OnRecipientSection();
			phoneorder.Select_DeliveryOnTime_Dropdown("Exactly At");
					
			// Test Step - 7
			phoneorder.SelectOccasion_On_OrderDetails_In_PhoneOrderPage("Birthday");
			softassert.assertEquals(phoneorder.getSelectedOccasionOnPhoneOrderPage(),"Birthday","Test Step - 7 - Order details selected occasion is not displayed");
			
			// Test Step - 8
			softassert.assertFalse(phoneorder.Verify_PriorityCheckBoxIsSelected(),"Test Step - 8 - Priority checkbox is selected as default on Order details section");
			
			// Test Step - 9
			phoneorder.Click_PriorityCheckBox_OnOrderDetails();
			
			// Test Step - 10	
			phoneorder.SearchandSelectItemcodeOnPhoneOrderPage("rrd","rrd-Red Rose Deluxe");
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getProdDetailsItemcode1OnPhoneOrderPage(),"rrd","Test Step - 10 - Item code is not displayed on phone order page product details section");
			softassert.assertEquals(phoneorder.getProdDetailsItemDescription1OnPhoneOrderPage(),"Red Rose Deluxe","Test Step - 10 - Item description is not displayed on phone order page product details section"); 
			softassert.assertEquals(phoneorder.getProdItemQty1OnPhoneOrderPage(),"1","Test Step - 10 - Item quantity is not displayed on phone order page product details section");
			softassert.assertEquals(phoneorder.getUnitPriceOnProdDetails(),"299.00","Test Step - 10 - Item price is not displayed on phone order page product details section");
			delayWithGivenTime(2000);
			
			// Test Step - 11
			phoneorder.SelectPaymentTypeOnPhoneOrderPage_PaymentSection("Invoice/House Account");
			delayWithGivenTime(1000);
			phoneorder.ClickPlaceOrderButton();
			delayWithGivenTime(1000);
			getDriver().switchTo().activeElement();
			softassert.assertTrue(phoneorder.VerifyConfirmationPopupOnPhoneOrderPage(), "Test Step - 11 - Confirmation popup is not displayed on phone order page");
			delayWithGivenTime(2000);
			
			// Test Step - 12
			phoneorder.ClickSubmitButton_On_ConfirmationPopup();
			delayWithGivenTime(2000);
			orderconfirmationpage = new Order_Confirmation_Page();
			softassert.assertTrue(orderconfirmationpage.VerifyOrderConfirmationPage(), "Test Step - 12 - Order confirmation page is not displayed");
			
			// Test Step - 13
			delayWithGivenTime(1000);
			dashboard.ClickOrder();
			delayWithGivenTime(1000);
			logger.info("User click the order menu on hana dashboard page");	
			dashboardorder = new DashboardOrderPage();	                   
			softassert.assertEquals(dashboardorder.validateDashboardOrderPage(),prop.getProperty("livedashboardorderURL"),"Test Step - 13 - Dashboard order page is not displayed");				
			
			// Test Step - 14
			dashboardorder.EnterGlobalSearch(dashboardorder.get_InvoiceNumber_PhoneOrder_PickUp_InvoiceHouse());
			delayWithGivenTime(1000);
			softassert.assertTrue(dashboardorder.Verify_RedFlagIcon_IsAppears(),"Test Step - 14 - Red flag icon is not displayed on dashboard order page");
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Test case failed due to exception " + e.getMessage());
			logger.error("Test case failed due to exception " + e.getMessage());
		} finally {
			softassert.assertAll();
		}
	}
}