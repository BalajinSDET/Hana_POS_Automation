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

public class Hana_T161_OrderEntry_Pickup_OrderDetailsSection_SendRemainderChecked_FT extends TestBaseClass {
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private OrderEntry_Alais_PhoneOrderPage phoneorder;
	private Marketing_RemaindersPage remainders;
	
	private Order_Confirmation_Page orderconfirmationpage;
	
	//,dataProvider="fetch_Excel_Data"
	@Test(enabled=true,groups= {"Regression"}) 
	public void Validate_Hana_T161_OrderEntry_Pickup_OrderDetailsSection_SendRemainderChecked_Functionality_Test() {
		SoftAssert softassert = new SoftAssert();
		logger.info("**** Starting  Validate_Hana_T161_OrderEntry_Pickup_OrderDetailsSection_SendRemainderChecked_Functionality_Test ****");
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
			softassert.assertEquals(phoneorder.getHighlightedColorOnPickupTypeOnPhoneOrderPage(),"#2f9bc8", "Test Step - 5 - Pickup type is not highlighted in blue color");		
		
			// Test Step - 7
			phoneorder.Select_SalesPersonOn_PhoneOrderEntryPage("Stuart Markwood");
			softassert.assertTrue(phoneorder.VerifyCustSectionAppears(), "Test Step - 7 - Customer section is not displayed on phone order page");
			phoneorder.SearchAndSelectCustomerOnCust_Section("Abish");
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getFirstnameOnPhoneOrderPage(),"Abish", "Test Step - 7 - First name is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getLastnameOnPhoneOrderPage(),"David", "Test Step - 7 - Last name is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getCompanyNameOnPhoneOrderPage(),"Hana_Sisterchicks", "Test Step - 7 - Company name is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getEmailIdOnPhoneOrderPage(),"hanaposqateam@gmail.com", "Test Step - 7 - email id is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getAddress1OnPhoneOrderPage(),"3402 Park Blvd", "Test Step - 7 - address 1 is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getAddress2OnPhoneOrderPage(),"", "Test Step - 7 - Address 2 is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getZipCodeOnPhoneOrderPage(),"92103", "Test Step - 7 - Zipcode is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getCityOnPhoneOrderPage(),"San Diego", "Test Step - 7 - city is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getPhoneNumberOnPhoneOrderPage(),"956-655-0756", "Test Step - 7 - phone number 1 is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getAltPhoneNumberOnPhoneOrderPage(),"956-655-0756", "Test Step - 7 - Alt phone number is not displayed on phone order page");		
			
			// Test Step - 8
			delayWithGivenTime(1000);
			phoneorder.SearchAndSelectReciAddress1("1160 W 5th St, Washington, MO");
			delayWithGivenTime(2000);
			phoneorder.Enter_DeliveryTime_OnRecipientSection();
			phoneorder.Select_DeliveryOnTime_Dropdown("Exactly At");
		
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getReciAddress1(),"1160 W 5th St","Test Step - 8 - Recipient address 1 is not matched with customer address 1 field on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciZipcode(),"63090","Test Step - 8 - Recipient address 2 is not matched with customer address 2 on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciCity(),"Washington","Test Step - 8 - Recipient city is not matched with customer city on phone order page recipient section");
			softassert.assertEquals(phoneorder.getRecipientState(),"MO","Test Step - 8 - Recipient phone number is not matched with customer phonenumber 1 field on phone order page recipient section");
		
			// Test Step - 9
			softassert.assertFalse(phoneorder.Verify_SendRemainder_OnOrderDetailsIsAppears(),"Test Step - 9 - Send remainder checkbox is displayed on Order details section");

			// Test Step - 10
			phoneorder.SelectOccasion_On_OrderDetails_In_PhoneOrderPage("Birthday");
			softassert.assertEquals(phoneorder.getSelectedOccasionOnPhoneOrderPage(),"Birthday","Test Step - 10 - Order details selected occasion is not displayed");
			
			// Test Step - 11
			softassert.assertTrue(phoneorder.Verify_SendRemainderCheckBoxIsSelected(),"Test Step - 11 - Send remainder checkbox is not displayed on Order details section");
			
			// Test Step - 12
			phoneorder.SearchandSelectItemcodeOnPhoneOrderPage("rrd","rrd-Red Rose Deluxe");
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getProdDetailsItemcode1OnPhoneOrderPage(),"rrd","Test Step - 12 - Item code is not displayed on phone order page product details section");
			softassert.assertEquals(phoneorder.getProdDetailsItemDescription1OnPhoneOrderPage(),"Red Rose Deluxe","Test Step - 12 - Item description is not displayed on phone order page product details section"); 
			softassert.assertEquals(phoneorder.getProdItemQty1OnPhoneOrderPage(),"1","Test Step - 12 - Item quantity is not displayed on phone order page product details section");
			softassert.assertEquals(phoneorder.getUnitPriceOnProdDetails(),"299.00","Test Step - 12 - Item price is not displayed on phone order page product details section");
			delayWithGivenTime(2000);
			
			// Test Step - 13
			phoneorder.SelectPaymentTypeOnPhoneOrderPage_PaymentSection("Invoice/House Account");
			delayWithGivenTime(1000);
			phoneorder.ClickPlaceOrderButton();
			delayWithGivenTime(1000);
			getDriver().switchTo().activeElement();
			softassert.assertTrue(phoneorder.VerifyConfirmationPopupOnPhoneOrderPage(), "Test Step - 13 - Confirmation popup is not displayed on phone order page");
			delayWithGivenTime(2000);
			
			// Test Step - 14
			phoneorder.ClickSubmitButton_On_ConfirmationPopup();
			delayWithGivenTime(2000);
			orderconfirmationpage = new Order_Confirmation_Page();
			softassert.assertTrue(orderconfirmationpage.VerifyOrderConfirmationPage(), "Test Step - 14 - Order confirmation page is not displayed");
			
			// Test Step - 15
			dashboard.Click_Marketing_RemainderMenu();
			
			// Test Step - 16
			delayWithGivenTime(2000);
			remainders = new Marketing_RemaindersPage();
			softassert.assertTrue(remainders.Verify_RemaindersHeaderAppears(),"Test Step - 16 - Marketing menu Remainders page is not displayed");
			
			// Test Step - 17
			remainders.Select_ShopDropDownRemaindersPage(prop.getProperty("shopname"));
			delayWithGivenTime(3000);
			remainders.Click_Row1ActionButton();
			remainders.Click_Row1EditReminder();
			
			// Test Step - 18
			remainders.Verify_EditReminderPopupAppears();
			softassert.assertTrue(remainders.Verify_EditReminderPopupAppears(),"Test Step - 18 - Edit reminder popup is not displayed");
			softassert.assertEquals(remainders.get_CustomerName_EditReminderPopup(), "Abish David","Test Step - 18 - Customer name is not displayed on Edit reminder popup");
			softassert.assertEquals(remainders.get_CustomerEmail_EditReminderPopup(), "hanaposqateam@gmail.com","Test Step - 18 - Customer email is not displayed on Edit reminder popup");
			softassert.assertEquals(remainders.get_RecipientFirstName_EditReminderPopup(), "Abish","Test Step - 18 - Recipient first name is not displayed on Edit reminder popup");
			softassert.assertEquals(remainders.get_RecipientLastName_EditReminderPopup(), "David","Test Step - 18 - Recipient last name is not displayed on Edit reminder popup");
			softassert.assertEquals(remainders.get_Occation_EditReminderPopup(), "Birthday","Test Step - 18 - Occasion is not displayed on Edit reminder popup");
			softassert.assertEquals(remainders.get_ReminderType_EditReminderPopup(), "Birthday","Test Step - 18 - Remainder type is not displayed on Edit reminder popup");
			softassert.assertEquals(remainders.get_ReminderDate_EditReminderPopup(), "July 31","Test Step - 18 - Remainder date is not displayed on Edit reminder popup");

			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Test case failed due to exception " + e.getMessage());
			logger.error("Test case failed due to exception " + e.getMessage());
		} finally {
			softassert.assertAll();
		}
	}
}