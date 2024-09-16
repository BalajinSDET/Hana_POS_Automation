package com.hanapos.OrderEntry_Alais_PickUp_PhoneOrder_Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hanapos.pageObjects.Configuration_SettingsPage;
import com.hanapos.pageObjects.DashboardOrderPage;
import com.hanapos.pageObjects.HanaDashBoardPage;
import com.hanapos.pageObjects.LoginPage;
import com.hanapos.pageObjects.OrderEntry_Alais_PhoneOrderPage;
import com.hanapos.pageObjects.Order_Confirmation_Page;
import com.hanapos.seleniumProjectBase.TestBaseClass;
import com.hanapos.utilities.CustomSoftAssert;

public class Hana_T155_OrderEntryPage_Pickup_RecipientSection_SaveFuneral_FT extends TestBaseClass {
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private OrderEntry_Alais_PhoneOrderPage phoneorder;
	private DashboardOrderPage dashboardorder;
	private Order_Confirmation_Page orderconfirmationpage;
	
	//,dataProvider="fetch_Excel_Data"
	@Test(enabled=true,groups= {"Regression"}) 
	public void Validate_Hana_T155_OrderEntryPage_Pickup_RecipientSection_SaveFuneral_Functionality_Test() {
		// SoftAssert softassert = new SoftAssert(); - I have modified this to use CustomSoftAssert
		CustomSoftAssert softassert = new CustomSoftAssert();
		
		logger.info("**** Starting  Validate_Hana_T155_OrderEntryPage_Pickup_RecipientSection_SaveFuneralx_Functionality_Test ****");
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
			softassert.assertEquals(phoneorder.getHighlightedColorOnPickupTypeOnPhoneOrderPage(),"#2f9bc8", "Test Step - 5 - Pickup type is not highlighted in blue color");		
		
			// Test Step - 6
			phoneorder.Select_SalesPersonOn_PhoneOrderEntryPage("Stuart Markwood");
			softassert.assertTrue(phoneorder.VerifyCustSectionAppears(), "Test Step - 6 - Customer section is not displayed on phone order page");
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
			
			// Test Step - 7
			phoneorder.ClickReciNameOnPhoneOrderPage();
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getReciFirstName(),"Abish","Test Step - 7 - Displayed first name is not matched with customer firstname on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciLastName(),"David","Test Step - 7 - Displayed last name is not matched with customer lastname on phone order page recipient section");
			
			// Test Step - 8
			softassert.assertEquals(phoneorder.getReciAddress1(),"114 N CHURCH ST","Test Step - 8 - Displayed recipient address 1 is not matched with customer address 1 field on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciAddress2(),"PICK UP","Test Step - 8 - Displayed recipient address 2 is not matched with customer address 2 on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciPhone(),"956-444-0756","Test Step - 8 - Recipient phone number is not matched with customer phonenumber 1 field on phone order page recipient section");
			softassert.assertEquals(phoneorder.getRecipientPhone2OnPhoneOrderPage(),"956-444-0756","Test Step - 8 - Recipient alt phone number is not matched with customer phonenumber2 on phone order page recipient section");
			
			// Test Step - 9
			phoneorder.EnterReciPhone("9566550756");
			phoneorder.EnterRecipientPhone2OnPhoneOrderPage("9566550756");
			softassert.assertEquals(phoneorder.getReciPhone(),"956-655-0756","Test Step - 9 - Recipient phone number is not matched with customer phonenumber 1 field on phone order page recipient section");
			softassert.assertEquals(phoneorder.getRecipientPhone2OnPhoneOrderPage(),"956-655-0756","Test Step - 9 - Recipient phone number is not matched with customer phonenumber 1 field on phone order page recipient section");

			// Test Step - 10
			phoneorder.Select_Location_OnRecipientSection("Funeral Home");
			softassert.assertEquals(phoneorder.getSelectedLocation_OnRecipientSection(), "Funeral Home","Test Step - 10 - Selected recipient location is not displayed on recipient location field");
			
			// Test Step - 11
			phoneorder.Select_Zone_OnRecipientSection("Automation Zone");
			softassert.assertEquals(phoneorder.getSelectedZone_OnRecipientSection(), "Automation Zone","Test Step - 11 - Selected recipient zone is not displayed on recipient zone field");
			
			// Test Step - 12
			delayWithGivenTime(1000);
			phoneorder.ClickSelectOptions_OnRecipient();
			phoneorder.Click_SaveFuneralOption();
			
			// Test Step - 13
			phoneorder.Enter_DeliveryTime_OnRecipientSection();
			
			// Test Step - 14
			phoneorder.Select_DeliveryOnTime_Dropdown("Exactly At");
			
			// Test Step - 15
			phoneorder.SelectOccasion_On_OrderDetails_In_PhoneOrderPage("Birthday");
			phoneorder.EnterViewShortCode();			
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getSelectedOccasionOnPhoneOrderPage(),"Birthday","Test Step - 10 - Selected Occasion is not displayed on phone order page order details section");
			softassert.assertEquals(phoneorder.getEnteredViewShortCode(),"Happy Birthday! Hope you have an amazing day!","Test Step - 10 -Entered Short code is not displayed on phone order page order details section");
			delayWithGivenTime(2000);
			
			// Test Step - 16
			phoneorder.SearchandSelectItemcodeOnPhoneOrderPage("rrd","rrd-Red Rose Deluxe");
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getProdDetailsItemcode1OnPhoneOrderPage(),"rrd","Test Step - 9 - Item code is not displayed on phone order page product details section");
			softassert.assertEquals(phoneorder.getProdDetailsItemDescription1OnPhoneOrderPage(),"Red Rose Deluxe","Test Step - 9 - Item description is not displayed on phone order page product details section"); 
			softassert.assertEquals(phoneorder.getProdItemQty1OnPhoneOrderPage(),"1","Test Step - 9 - Item quantity is not displayed on phone order page product details section");
			softassert.assertEquals(phoneorder.getUnitPriceOnProdDetails(),"299.00","Test Step - 9 - Item price is not displayed on phone order page product details section");
			delayWithGivenTime(2000);
			
			// Test Step - 17
			phoneorder.SelectPaymentTypeOnPhoneOrderPage_PaymentSection("Invoice/House Account");
			delayWithGivenTime(1000);
			phoneorder.ClickPlaceOrderButton();
			delayWithGivenTime(1000);
			getDriver().switchTo().activeElement();
			softassert.assertTrue(phoneorder.VerifyConfirmationPopupOnPhoneOrderPage(), "Test Step - 10 - Confirmation popup is not displayed on phone order page");
			delayWithGivenTime(2000);
			
			// Test Step - 18
			phoneorder.ClickSubmitButton_On_ConfirmationPopup();
			delayWithGivenTime(2000);
			orderconfirmationpage = new Order_Confirmation_Page();
			softassert.assertTrue(orderconfirmationpage.VerifyOrderConfirmationPage(), "Test Step - 13 - Order confirmation page is not displayed");
			
			// Test Step - 19
			dashboard = new HanaDashBoardPage();
			dashboard.Click_settingsSubmenu();
			ThreadWait(2000);
			Configuration_SettingsPage settingsPage= new Configuration_SettingsPage();
			softassert.assertTrue(settingsPage.Verify_Configuration_SettingsPage(), "Test Step - 14 - Settings page is not displayed");
			
			// Test Step - 20
			settingsPage.Click_OrderEntryLeftMenu();
			
			// Test Step - 21
			settingsPage.Click_FuneralLogMenu();
			
			// Test Step - 22
			delayWithGivenTime(3000);
			softassert.assertEquals(settingsPage.getDisplayedFirstName(), "Abish", "Test Step - 22 - First Name Compared with recipient section saved information is not matched with configuration order entry menu funeral log submenu");
			softassert.assertEquals(settingsPage.getDisplayedLastName(), "David", "Test Step - 22 - Last Name Compared with recipient section saved information is not matched with configuration order entry menu funeral log submenu");
			softassert.assertEquals(settingsPage.getDisplayedDeliveryDate(), CurrentDate(), "Test Step - 22 - Delivery Date Compared with recipient section saved information is not matched with configuration order entry menu funeral log submenu");
			softassert.assertEquals(settingsPage.getDisplayedDeliveryTime(), "05:30 pm", "Test Step - 22 - Delivery Time Compared with recipient section saved information is not matched with configuration order entry menu funeral log submenu");
			softassert.assertEquals(settingsPage.getDisplayedDeliveryOn(), "Exactly At", "Test Step - 22 - Delivery On Compared with recipient section saved information is not matched with configuration order entry menu funeral log submenu");
			softassert.assertEquals(settingsPage.getDisplayedDeliveryAddress1(), "114 N CHURCH ST", "Test Step - 22 - Delivery Address 1 Compared with recipient section saved information is not matched with configuration order entry menu funeral log submenu");
			softassert.assertEquals(settingsPage.getDisplayedDeliveryAddress2(), "PICK UP", "Test Step - 22 - Delivery Address 2 Compared with recipient section saved information is not matched with configuration order entry menu funeral log submenu");

			// Test Step - 23
			settingsPage.Click_EditIcon_FuneralLogGridTableRow1();
			softassert.assertTrue(settingsPage.Verify_FuneralLog_AddNewRecord_Popup(), "Test Step - 23 - Funeral Log Add new record popup is not displayed");
			softassert.assertEquals(settingsPage.getFirstNameFuneralLogAddNewRecordPopup(), "Abish","Test Step - 23 - First Name Compared with recipient section saved information is not matched with configuration order entry menu funeral log submenu ");			
			softassert.assertEquals(settingsPage.getLastNameFuneralLogAddNewRecordPopup(), "David","Test Step - 23 - Last Name Compared with recipient section saved information is not matched with configuration order entry menu funeral log submenu ");			
			delayWithGivenTime(1000);
			softassert.assertEquals(settingsPage.getSelectedDeliveryDateFuneralLogAddNewRecordPopup(), CurrentDate(),"Test Step - 23 - Delivery Date Compared with recipient section saved information is not displayed on configuration order entry menu funeral log submenu");
			softassert.assertEquals(settingsPage.getEnteredAddress1FuneralLogAddNewRecordPopup(), "114 N CHURCH ST","Test Step - 23 - Delivery Address 1 Compared with recipient section saved information is not displayed on configuration order entry menu funeral log submenu");
			delayWithGivenTime(1000);		
			softassert.assertEquals(settingsPage.getSelectedDeliveryOnFuneralLogAddNewRecordPopup(), "Exactly At","Test Step - 23 - Delivery On Compared with recipient section saved information is not displayed on configuration order entry menu funeral log submenu");
			softassert.assertEquals(settingsPage.getSelectedDeliveryTimeFuneralLogAddNewRecordPopup(), "5:30 PM","Test Step - 23 - Delivery Time Compared with recipient section saved information is not displayed on configuration order entry menu funeral log submenu");
			delayWithGivenTime(1000);
			
			//======== To Avoid junk files due to automation delete the funeral log============//
			settingsPage.Click_CloseIcon_FuneralLogAddNewRecordPopup();
			delayWithGivenTime(1000);
			settingsPage.Click_DeleteIcon_FuneralLogGridTableRow1();
			delayWithGivenTime(1000);
			settingsPage.Click_Row1_DeleteIcon_FuneralLogGridTableRow2();
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Test case failed due to exception " + e.getMessage());
			logger.error("Test case failed due to exception " + e.getMessage());
		} finally {
			softassert.assertAll();
		}
	}
}