package com.hanapos.OrderEntry_Alais_PickUp_PhoneOrderTest;

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

public class Hana_T158_Pickup_RecipientSection_SelectOptionMultipleSelect_FT extends TestBaseClass {
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private OrderEntry_Alais_PhoneOrderPage phoneorder;
	private Order_Confirmation_Page orderconfirmationpage;
	private DashboardOrderPage dashboardorder;
	
	
	//,dataProvider="fetch_Excel_Data"
	@Test(enabled=true,groups= {"Regression"}) 
	public void Validate_Hana_T158_Pickup_RecipientSection_SelectOptionMultipleSelect_Functionality_Test() {
		SoftAssert softassert = new SoftAssert();
		logger.info("**** Starting  Validate_Hana_T158_Pickup_RecipientSection_SelectOptionMultipleSelect_Functionality_Test ****");
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
			delayWithGivenTime(1000);
			phoneorder.EnterReciAddress1("1160 W 5th St");
			phoneorder.SearchAndSelectReciAddress1("1160 W 5th St, Washington, MO");
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getReciAddress1(),"1160 W 5th St","Test Step - 8 - Recipient address 1 is not matched with customer address 1 field on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciZipcode(),"63090","Test Step - 8 - Recipient address 2 is not matched with customer address 2 on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciCity(),"Washington","Test Step - 8 - Recipient city is not matched with customer city on phone order page recipient section");
			softassert.assertEquals(phoneorder.getRecipientState(),"MO","Test Step - 8 - Recipient phone number is not matched with customer phonenumber 1 field on phone order page recipient section");
		
			// Test Step - 9
			delayWithGivenTime(1000);
			phoneorder.ClickSelectOptions_OnRecipient();
			delayWithGivenTime(2000);
			phoneorder.Click_FrequentAddrOption();
			phoneorder.Click_SaveFuneralOption();
			delayWithGivenTime(2000);
						
			// Test Step - 10
			delayWithGivenTime(1000);
			phoneorder.ClickSelectOptions_OnRecipient();
			delayWithGivenTime(1000);
			phoneorder.Click_ConfidentialOption();
			delayWithGivenTime(1000);

			// Test Step - 11
			delayWithGivenTime(1000);
			phoneorder.ClickSelectOptions_OnRecipient();
			delayWithGivenTime(1000);
			phoneorder.Click_SelectAllOption();
			delayWithGivenTime(1000);
			softassert.assertEquals(phoneorder.getSelectedOption(), "All selected (3)","Test Step - 11 - Selected All options is not displayed on phone order page recipient section");
	
			// Test Step - 12
			phoneorder.Enter_DeliveryTime_OnRecipientSection();
			phoneorder.Select_DeliveryOnTime_Dropdown("Exactly At");
			delayWithGivenTime(1000);
			phoneorder.SelectOccasion_On_OrderDetails_In_PhoneOrderPage("Birthday");
			phoneorder.EnterViewShortCode();			
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getSelectedOccasionOnPhoneOrderPage(),"Birthday","Test Step - 12 - Selected Occasion is not displayed on phone order page order details section");
			softassert.assertEquals(phoneorder.getEnteredViewShortCode(),"Happy Birthday! Hope you have an amazing day!","Test Step - 12 -Entered Short code is not displayed on phone order page order details section");
			delayWithGivenTime(2000);
			
			// Test Step - 13
			phoneorder.SearchandSelectItemcodeOnPhoneOrderPage("rrd");
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getProdDetailsItemcode1OnPhoneOrderPage(),"rrd","Test Step - 13 - Item code is not displayed on phone order page product details section");
			softassert.assertEquals(phoneorder.getProdDetailsItemDescription1OnPhoneOrderPage(),"Red Rose Deluxe","Test Step - 13 - Item description is not displayed on phone order page product details section"); 
			softassert.assertEquals(phoneorder.getProdItemQty1OnPhoneOrderPage(),"1","Test Step - 13 - Item quantity is not displayed on phone order page product details section");
			softassert.assertEquals(phoneorder.getUnitPriceOnProdDetails(),"299.00","Test Step - 13 - Item price is not displayed on phone order page product details section");
			delayWithGivenTime(2000);
			
			// Test Step - 14
			phoneorder.SelectPaymentTypeOnPhoneOrderPage_PaymentSection("Invoice/House Account");
			delayWithGivenTime(1000);
			phoneorder.ClickPlaceOrderButton();
			delayWithGivenTime(1000);
			getDriver().switchTo().activeElement();
			softassert.assertTrue(phoneorder.VerifyConfirmationPopupOnPhoneOrderPage(), "Test Step - 14 - Confirmation popup is not displayed on phone order page");
			delayWithGivenTime(2000);
			
			// Test Step - 15
			phoneorder.ClickSubmitButton_On_ConfirmationPopup();
			delayWithGivenTime(2000);
			orderconfirmationpage = new Order_Confirmation_Page();
			softassert.assertTrue(orderconfirmationpage.VerifyOrderConfirmationPage(), "Test Step - 15 - Order confirmation page is not displayed");
			
			// Test Step - 16
			delayWithGivenTime(1000);
			dashboard.ClickOrder();
			delayWithGivenTime(1000);
			logger.info("User click the order menu on hana dashboard page");	
			dashboardorder = new DashboardOrderPage();	                      //https://hanafloralpos3.com/Dashboard/Order
			softassert.assertEquals(dashboardorder.validateDashboardOrderPage(),prop.getProperty("livedashboardorderURL"),"Test Step - 16 - Dashboard order page is not displayed");				
			
			// Test Step - 17
			softassert.assertTrue(dashboardorder.Validate_PhoneOrder_InvoiceInHousePayment(),"Test Step - 17 - Phone order invoice in house payment is not displayed");		//https://hanafloralpos3.com/Dashboard/Order/Validate_PhoneOrder_InvoiceInHousePayment();
			delayWithGivenTime(2000);
			
			// Test Step - 18
			dashboardorder.ClickInvoiceInhousePayment_on_PhoneOrder_on_SenderorCustomer_OnOrderPage();
	
			// Test Step - 19
			softassert.assertTrue(dashboardorder.Verify_ConfidentialReqMessage_Appears(),"Test Step - 19- Customer requested confidentiality message is not displayed on delivery popup");
			softassert.assertEquals(dashboardorder.Verify_ConfidentialReqTextMessage_Appears(),"Customer requested confidentiality", "Test Step - 17 - Customer requested confidentiality text message is not displayed properly on delivery popup");
			delayWithGivenTime(1000);
			dashboardorder.ClickCloseIconOnDeliveryPopup();
			delayWithGivenTime(2000);
			
			// Test Step - 20
			dashboard = new HanaDashBoardPage();
			dashboard.Click_settingsSubmenu();
			ThreadWait(2000);
			Configuration_SettingsPage settingsPage= new Configuration_SettingsPage();
			softassert.assertTrue(settingsPage.Verify_Configuration_SettingsPage(), "Test Step - 20 - Settings page is not displayed");
			
			// Test Step - 21
			settingsPage.Click_OrderEntryLeftMenu();
			
			// Test Step - 22
			settingsPage.Click_FuneralLogMenu();
			
			// Test Step - 23
			delayWithGivenTime(3000);
			softassert.assertEquals(settingsPage.getDisplayedFirstName(), "Abish", "Test Step - 23 - First Name Compared with recipient section saved information is not matched with configuration order entry menu funeral log submenu");
			softassert.assertEquals(settingsPage.getDisplayedLastName(), "David", "Test Step - 23 - Last Name Compared with recipient section saved information is not matched with configuration order entry menu funeral log submenu");
			softassert.assertEquals(settingsPage.getDisplayedDeliveryDate(), CurrentDate(), "Test Step - 23 - Delivery Date Compared with recipient section saved information is not matched with configuration order entry menu funeral log submenu");
			softassert.assertEquals(settingsPage.getDisplayedDeliveryTime(), "05:30 pm", "Test Step - 23 - Delivery Time Compared with recipient section saved information is not matched with configuration order entry menu funeral log submenu");
			softassert.assertEquals(settingsPage.getDisplayedDeliveryOn(), "Exactly At", "Test Step - 23 - Delivery On Compared with recipient section saved information is not matched with configuration order entry menu funeral log submenu");
			softassert.assertEquals(settingsPage.getDisplayedDeliveryAddress1(), "1160 W 5th St", "Test Step - 23 - Delivery Address 1 Compared with recipient section saved information is not matched with configuration order entry menu funeral log submenu");
			softassert.assertEquals(settingsPage.getDisplayedDeliveryAddress2(), "PICK UP", "Test Step - 23 - Delivery Address 2 Compared with recipient section saved information is not matched with configuration order entry menu funeral log submenu");
				
			// Test Step - 24
			settingsPage.Click_EditIcon_FuneralLogGridTableRow1();
			softassert.assertTrue(settingsPage.Verify_FuneralLog_AddNewRecord_Popup(), "Test Step - 24 - Funeral Log Add new record popup is not displayed");
			softassert.assertEquals(settingsPage.getFirstNameFuneralLogAddNewRecordPopup(), "Abish","Test Step - 24 - First Name Compared with recipient section saved information is not matched with configuration order entry menu funeral log submenu ");			
			softassert.assertEquals(settingsPage.getLastNameFuneralLogAddNewRecordPopup(), "David","Test Step - 24 - Last Name Compared with recipient section saved information is not matched with configuration order entry menu funeral log submenu ");			
			delayWithGivenTime(1000);
			softassert.assertEquals(settingsPage.getSelectedDeliveryDateFuneralLogAddNewRecordPopup(), CurrentDate()          ,"Test Step - 23 - Delivery Date Compared with recipient section saved information is not displayed on configuration order entry menu funeral log submenu");
			softassert.assertEquals(settingsPage.getEnteredAddress1FuneralLogAddNewRecordPopup(), "1160 W 5th St","Test Step - 23 - Delivery Address 1 Compared with recipient section saved information is not displayed on configuration order entry menu funeral log submenu");
			delayWithGivenTime(1000);		
			//softassert.assertEquals(settingsPage.getSelectedDeliveryOnFuneralLogAddNewRecordPopup(), "Exactly At","Test Step - 23 - Delivery On Compared with recipient section saved information is not displayed on configuration order entry menu funeral log submenu");
			//softassert.assertEquals(settingsPage.getSelectedDeliveryTimeFuneralLogAddNewRecordPopup(), "5:30 PM","Test Step - 23 - Delivery Time Compared with recipient section saved information is not displayed on configuration order entry menu funeral log submenu");
	
			settingsPage.Click_CloseIcon_FuneralLogAddNewRecordPopup();
			delayWithGivenTime(1000);
			settingsPage.Click_DeleteIcon_FuneralLogGridTableRow1();
			delayWithGivenTime(1000);
			settingsPage.Click_Row1_DeleteIcon_FuneralLogGridTableRow2();
			
			// Test Step - 25
			delayWithGivenTime(1000);
			settingsPage.Click_OrderEntryBreadCrumbLink();
			
			// Test Step - 26
			settingsPage.Click_CommonAddressManagement();
			delayWithGivenTime(2000);
			
			// Test Step - 27
			softassert.assertTrue(settingsPage.Verify_Address1_CommonAddressManagement_IsDisplayed("1160 W 5th St"),"Test Step - 27 - Recipient address 1 field is not displayed on order entry menu common address management section");
			
			// Test Step - 28
			softassert.assertEquals(settingsPage.Verify_DisplayedAddress1_CommonAddressManagement(), "1160 W 5th St", "Test Step - 28 - Displayed address1 in configuration settings page on common address management page is not matched with recipient address1 field");
			delayWithGivenTime(1000);
			//==================Delete the address to avoid junks==========================
			settingsPage.Click_Row1_DeleteIcon();
			settingsPage.Click_YesButton_On_DeleteConfirmation();
	
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Test case failed due to exception " + e.getMessage());
			logger.error("Test case failed due to exception " + e.getMessage());
		} finally {
			softassert.assertAll();
		}
	}
}