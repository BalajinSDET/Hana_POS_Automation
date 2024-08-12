package com.hanapos.OrderEntry_Alais_PickUp_PhoneOrderTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hanapos.pageObjects.CustomerPage;
import com.hanapos.pageObjects.HanaDashBoardPage;
import com.hanapos.pageObjects.LoginPage;
import com.hanapos.pageObjects.OrderEntry_Alais_PhoneOrderPage;
import com.hanapos.pageObjects.Order_Confirmation_Page;
import com.hanapos.seleniumProjectBase.TestBaseClass;

public class Hana_T098_Pickup_CustomerSection_Edit_Customer_CustomerDetails_FT extends TestBaseClass {
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private OrderEntry_Alais_PhoneOrderPage phoneorder;
	private Order_Confirmation_Page orderconfirmationpage;
	private CustomerPage customerpage;
	//,dataProvider="fetch_Excel_Data"
	@Test(enabled=true,groups= {"Regression"}) 
	public void Validate_Hana_T098_Pickup_CustomerSection_Edit_Customer_CustomerDetails_Test() {
		SoftAssert softassert = new SoftAssert();
		logger.info("**** Starting  Hana_T98_Pickup_CustomerSection_Edit_Customer_CustomerDetails_FT  ****");
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
			
			// Test Step - 9			
			phoneorder.Click_CustEditIcon();
			softassert.assertTrue(phoneorder.Verify_CustomerDetailsPopupAppears(), "Test Step - 9 - Customer details popup on is not displayed on phone order page");
			
			// Test Step - 10
			phoneorder.Click_ProfileTab_OnCustDetailsPopup();
			delayWithGivenTime(1000);
			softassert.assertFalse(phoneorder.Verify_CustomerDetails_Popup_ProfileTab(),"Test Step - 10 -profile tab is not displayed on Customer details popup on is not displayed on phone order page");
			
			// Test Step - 11
			softassert.assertFalse(phoneorder.Verify_CustomerIDField_Disabled(),"Test Step - 11 -Customer Id field is not disabled on Customer details popup on is not displayed on phone order page");
			
			// Test Step - 12
			phoneorder.Enter_CompanyName_OnCustDetailsPopup("Hana_Sister");
			phoneorder.Enter_FirstName_OnCustDetailsPopup("David");
			phoneorder.Enter_LastName_OnCustDetailsPopup("Abish");
			phoneorder.Enter_Email_OnCustDetailsPopup("hanaposqa@gmail.com");
			phoneorder.Enter_Address1_OnCustDetailsPopup("3402 Park Blvd 1");
			phoneorder.Enter_ZipCode_OnCustDetailsPopup("92103");
			phoneorder.Enter_Country_OnCustDetailsPopup("United States");
			phoneorder.Enter_City_OnCustDetailsPopup("San Diego");
			phoneorder.Enter_PhoneNumber_OnCustDetailsPopup("956-655-0756");
			phoneorder.Enter_AltPhoneNumber_OnCustDetailsPopup("956-655-0756");
			
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.get_CompanyName_OnCustDetailsPopup(),"Hana_Sister", "Test Step - 12 - Company name is not displayed on phone order page");
			softassert.assertEquals(phoneorder.get_FirstName_OnCustDetailsPopup(),"David", "Test Step - 12 - First name is not displayed on phone order page");
			softassert.assertEquals(phoneorder.get_LastName_OnCustDetailsPopup(),"Abish", "Test Step - 12 - Last name is not displayed on phone order page");
			softassert.assertEquals(phoneorder.get_Email_OnCustDetailsPopup(),"hanaposqa@gmail.com", "Test Step - 12 - email id is not displayed on phone order page");
			softassert.assertEquals(phoneorder.get_Address1_OnCustDetailsPopup(),"3402 Park Blvd 1", "Test Step - 12 - address 1 is not displayed on phone order page");
			softassert.assertEquals(phoneorder.get_Country_OnCustDetailsPopup(),"United States", "Test Step - 12 - Country is not displayed on phone order page");
			softassert.assertEquals(phoneorder.get_ZipCode_OnCustDetailsPopup(),"92103", "Test Step - 12 - Zipcode is not displayed on phone order page");
			softassert.assertEquals(phoneorder.get_City_OnCustDetailsPopup(),"San Diego", "Test Step - 12 - city is not displayed on phone order page");
			softassert.assertEquals(phoneorder.get_PhoneNumber_OnCustDetailsPopup(),"956-655-0756", "Test Step - 12 - phone number 1 is not displayed on phone order page");
			softassert.assertEquals(phoneorder.get_AltPhoneNumber_OnCustDetailsPopup(),"956-655-0756", "Test Step - 12 - Alt phone number is not displayed on phone order page");
			
			// Test Step - 13
			phoneorder.Click_LateFeeSetting_OnCustDetailsPopup();
			delayWithGivenTime(1000);
			softassert.assertTrue(phoneorder.Verify_LateFeeSetting_Enabled_OnCustDetailsPopup(), "Test Step - 13 - late fee toogle button is not enabled");
			delayWithGivenTime(1000);
			phoneorder.Click_LateFeeSetting_OnCustDetailsPopup();
			
			// Test Step - 14
			phoneorder.Click_UpdateBtn_OnCustDetailsPopup();
			softassert.assertTrue(phoneorder.verifySuccessToastMessageAppears(),"Test Step - 14 - success message is not displayed");
			softassert.assertEquals(phoneorder.verifySuccessToastMessageText(), "Customer details updated successfully","Test step - 14 - success message displayed text is not matched");
			
			// Test Step - 15
			delayWithGivenTime(2000);
			phoneorder.Click_Customer_DetailsPopupCloseBtn();
			
			delayWithGivenTime(3000);
			// Test Step - 16
			softassert.assertEquals(phoneorder.getFirstnameOnPhoneOrderPage(),"David", "Test Step - 16 - First name is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getLastnameOnPhoneOrderPage(),"Abish", "Test Step - 16 - Last name is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getCompanyNameOnPhoneOrderPage(),"Hana_Sister", "Test Step - 16 - Company name is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getEmailIdOnPhoneOrderPage(),"hanaposqa@gmail.com", "Test Step - 16 - email id is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getAddress1OnPhoneOrderPage(),"3402 Park Blvd 1", "Test Step - 16 - address 1 is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getAddress2OnPhoneOrderPage(),"", "Test Step - 16 - Address 2 is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getZipCodeOnPhoneOrderPage(),"92103", "Test Step - 6 - Zipcode is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getCityOnPhoneOrderPage(),"San Diego", "Test Step - 6 - city is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getPhoneNumberOnPhoneOrderPage(),"956-655-0756", "Test Step - 6 - phone number 1 is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getAltPhoneNumberOnPhoneOrderPage(),"956-655-0756", "Test Step - 6 - Alt phone number is not displayed on phone order page");

			// Test Step -17
			delayWithGivenTime(3000);
			phoneorder.EnterReciFirstName("Abish");
			phoneorder.EnterReciLastName("David");
			phoneorder.EnterReciAddress1("3402 Park Blvd");
			phoneorder.EnterReciAddress2("PICK UP");
			phoneorder.EnterReciZipcode("92103");
			delayWithGivenTime(1000);
			phoneorder.EnterReciCity("San Diego");
			phoneorder.SelectReciCountry("United States");
			phoneorder.EnterReciPhone("956-655-0756");
			delayWithGivenTime(1000);
			phoneorder.SelectReciLocation("Church");
			delayWithGivenTime(1000);
			phoneorder.EnterDeliveryDateOnReciSection();
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getReciFirstName(),"Abish","Test Step - 17 - Entered first name is not displayed on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciLastName(),"David","Test Step - 17 - Entered last name is not displayed on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciAddress1(),"3402 Park Blvd","Test Step - 17 - Entered address 1 is not displayed on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciAddress2(),"PICK UP","Test Step - 17 - Entered address 2 is not displayed on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciZipcode(),"92103","Test Step - 17 - Entered zipcode is not displayed on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciCity(),"San Diego","Test Step - 17 - Entered city is not displayed on phone order page recipient section");
			softassert.assertEquals(phoneorder.getSelectedCountryOnReciCountry(),"United States","Test Step - 17 - Selected country is not displayed on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciPhone(),"956-655-0756","Test Step - 17 - Recipient phone number is not displayed on phone order page recipient section");
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getSelectedLocationOnReciLocation(),"Church","Test Step - 17 - Recipient location is not displayed on phone order page recipient section");
			softassert.assertEquals(phoneorder.getDeliveryDateOnReciSection(),phoneorder.NextDate(),"Test Step - 17 - Delivery date is not displayed on phone order page recipient section");
		
			// Test Step - 18
			phoneorder.SelectOccasion_On_OrderDetails_In_PhoneOrderPage("Birthday");
			phoneorder.EnterViewShortCode();			
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getSelectedOccasionOnPhoneOrderPage(),"Birthday","Test Step - 18 - Selected Occasion is not displayed on phone order page order details section");
			softassert.assertEquals(phoneorder.getEnteredViewShortCode(),"Happy Birthday! Hope you have an amazing day!","Test Step - 18 -Entered Short code is not displayed on phone order page order details section");
			delayWithGivenTime(2000);
		
			// Test Step - 19
			phoneorder.SearchandSelectItemcodeOnPhoneOrderPage("rrd");
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getProdDetailsItemcode1OnPhoneOrderPage(),"rrd","Test Step - 19 - Item code is not displayed on phone order page product details section");
			softassert.assertEquals(phoneorder.getProdDetailsItemDescription1OnPhoneOrderPage(),"Red Rose Deluxe","Test Step - 19 - Item description is not displayed on phone order page product details section"); 
			softassert.assertEquals(phoneorder.getProdItemQty1OnPhoneOrderPage(),"1","Test Step - 19 - Item quantity is not displayed on phone order page product details section");
			softassert.assertEquals(phoneorder.getUnitPriceOnProdDetails(),"309.00","Test Step - 19 - Item price is not displayed on phone order page product details section");
			delayWithGivenTime(2000);
			
			// Test Step - 20
			phoneorder.SelectPaymentTypeOnPhoneOrderPage_PaymentSection("Cash");
			delayWithGivenTime(1000);
			softassert.assertEquals(phoneorder.getDisplayedPaymentTypeSelectedOption(),"Cash","Test Step - 20 - Selected Payment type is not displayed on phone order page payment section");
			delayWithGivenTime(2000);
			phoneorder.EnterCashAmount();
			delayWithGivenTime(3000);
			phoneorder.SelectCashRegistry_On_CashPaymentType("Cash Register2");
			phoneorder.ClickPlaceOrderButton();
			delayWithGivenTime(1000);
			getDriver().switchTo().activeElement();
			softassert.assertTrue(phoneorder.VerifyConfirmationPopupOnPhoneOrderPage(), "Test Step - 20 - Confirmation popup is not displayed on phone order page");
			delayWithGivenTime(2000);
			
			// Test Step - 21
			phoneorder.ClickSubmitButton_On_ConfirmationPopup();
			delayWithGivenTime(2000);
			
			// Test Step - 22
			delayWithGivenTime(2000);
			orderconfirmationpage = new Order_Confirmation_Page();
			softassert.assertTrue(orderconfirmationpage.VerifyOrderConfirmationPage(), "Test Step - 22 - Order confirmation page is not displayed");
			softassert.assertEquals(orderconfirmationpage.getCustomerFname(),"David","Test Step - 22 - first name is not matched");
			softassert.assertEquals(orderconfirmationpage.getCustomerLname(),"Abish","Test Step - 22 - Last name is not matched");
			softassert.assertEquals(orderconfirmationpage.getCustomerPhone1(),"956-655-0756","Test Step - 22 - phone number 1 is not matched");
			softassert.assertEquals(orderconfirmationpage.getCustomerPhone2(),", 956-655-0756","Test Step - 22 - phone number 2 is not matched");
			softassert.assertEquals(orderconfirmationpage.getCustomerAddress(),"3402 Park Blvd 1","Test Step - 22 - address 1 is not matched");
			softassert.assertEquals(orderconfirmationpage.getCustomerCity(),"San Diego","Test Step - 22 - city is not matched");
			softassert.assertEquals(orderconfirmationpage.getCustomerState(),"CA","Test Step - 22 - state is not matched");
			softassert.assertEquals(orderconfirmationpage.getCustomerZip(),"92103","Test Step - 22 - zip is not matched");

			// Test Step - 23
			delayWithGivenTime(3000);
			dashboard.ClickCustomersMenu();
			customerpage = new CustomerPage();
			delayWithGivenTime(5000);
			softassert.assertTrue(customerpage.VerifyCustomerMenuPage(), "Test Step - 23 - customer menu page heading is not displayed");
			
			// Test Step - 24
			delayWithGivenTime(4000);
			customerpage.Search_and_SelectCustomerName("David Ab","David Abish");
			
			delayWithGivenTime(4000);
			softassert.assertEquals(customerpage.VerifyCompanyNameOnCustTable(),"Hana_Sister","Test Step 24 - Company Name on customer table is not matched");
			logger.info("User verify that company name on customer table");
			softassert.assertEquals(customerpage.VerifyPhoneNumberOnCustTable(),"956-655-0756","Test Step - 24 - Phone number on customer table is not matched");
			logger.info("User verify that phone number on customer table");
			softassert.assertEquals(customerpage.VerifyAddressOnCustTable(),"3402 Park Blvd 1","Test Step - 24 - Address on customer table is not matched");
			logger.info("User verify that address on customer table");
			softassert.assertEquals(customerpage.VerifyCityStateZipCodeOnCustTable(),"San Diego CA 92103","Test Step - 24 - City, State & Zipcode on customer table is not matched");
			logger.info("User verify that city, state and zipcode on customer table");
			
			// Test Step - 25
			customerpage.ClickCustomerTableRow1();
			logger.info("User clicks the displayed customer in the table ");
			delayWithGivenTime(2000);
			softassert.assertTrue(customerpage.VerifyCustomerDetailsPopup(),"Customer details pop up is not displayed");
			logger.info("User verify that customer details popup is displayed");
			delayWithGivenTime(2000);
			softassert.assertEquals(customerpage.getCustDetailsCompanyNameTextBox(), "Hana_Sister"," Test - 25 - Added on company name field are not properly displayed");
			logger.info("User verified that entered company name entered data is displayed on add new customer popup");
			softassert.assertEquals(customerpage.getCustDetailsFirstNameTextBox(), "David","Test Step - 25 - on first name field are not properly displayed");
			logger.info("User verify the first name field entered data is displayed");
			softassert.assertEquals(customerpage.getCustDetailsLastNameTextBox(), "Abish","Test Step - 25 - on last name field are not properly displayed");
			logger.info("User verify the last name field entered data is displayed");
			softassert.assertEquals(customerpage.getCustDetailsPhoneNumberTextbox(), "9566550756","Test Step - 25 - on phone number field are not properly displayed");
			logger.info("User verify the phone number field entered data is displayed");
			softassert.assertEquals(customerpage.getCustDetailsAltPhoneNumberTextBox(), "9566550756","Test Step - 25 - on alternative phone number field are not properly displayed");
			logger.info("User verify the alternative phone number field entered data is displayed");
			softassert.assertEquals(customerpage.getCustDetailsAddress1TextBox(),"3402 Park Blvd 1","Test Step - 25 - address 1 field is not properly displayed");
			logger.info("User verify that address 1 field entered data is displayed");
			softassert.assertEquals(customerpage.getCustDetailsZipCodeTextBox(), "92103","Test Step - 25 - zip code field in customer details popup is not displayed");
			logger.info("User verify that zipcode field entered data is displayed");
			softassert.assertEquals(customerpage.getCustDetailsCityTextBox(), "San Diego","Test Step - 25 - city field in customer details popup is not displayed");
			logger.info("User verify that city field entered data is displayed");
			softassert.assertEquals(customerpage.getCustDetailsStateTextBox(), "CA","Test Step - 25 - state field in customer details popup is not displayed");
			logger.info("User verify that state field entered data is displayed");
			softassert.assertEquals(customerpage.getCustDetailsEmailTextBox(), "hanaposqa@gmail.com","Test Step - 25 - email id field in customer details popup is not displayed");
			logger.info("User verify that email id field entered data is displayed");
			softassert.assertTrue(customerpage.ValidateCustDetailsLateFeeSettingToogle(),"Test Step - 25 - Late Fee Setting toogle in customer details popup is enabled");
			logger.info("User verify that enable loyalty toogle is disabled");
			customerpage.ClickCustomerDetailsPopupCloseIcon();
			logger.info("User clicks on customer details popup close icon");
			
			// Update previous customer details
			delayWithGivenTime(2000);
			dashboard.ClickOnHomeIcon();
			
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
			delayWithGivenTime(2000);
			phoneorder.SearchAndSelectCustomerOnCust_Section("Abish");
			delayWithGivenTime(2000);
			phoneorder.Click_CustEditIcon();
			delayWithGivenTime(2000);
			phoneorder.Enter_CompanyName_OnCustDetailsPopup("Hana_Sisterchicks");
			phoneorder.Enter_FirstName_OnCustDetailsPopup("Abish");
			phoneorder.Enter_LastName_OnCustDetailsPopup("David");
			phoneorder.Enter_Email_OnCustDetailsPopup("hanaposqateam@gmail.com");
			phoneorder.Enter_Address1_OnCustDetailsPopup("3402 Park Blvd");
			phoneorder.Enter_ZipCode_OnCustDetailsPopup("92103");
			phoneorder.Enter_Country_OnCustDetailsPopup("United States");
			phoneorder.Enter_City_OnCustDetailsPopup("San Diego");
			phoneorder.Enter_PhoneNumber_OnCustDetailsPopup("956-655-0756");
			phoneorder.Enter_AltPhoneNumber_OnCustDetailsPopup("956-655-0756");
			
			phoneorder.Click_UpdateBtn_OnCustDetailsPopup();
			softassert.assertTrue(phoneorder.verifySuccessToastMessageAppears(),"Test Step - 14 - success message is not displayed");
			softassert.assertEquals(phoneorder.verifySuccessToastMessageText(), "Customer details updated successfully","Test step - 14 - success message displayed text is not matched");
					
		
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Test case failed due to exception " + e.getMessage());
			logger.error("Test case failed due to exception " + e.getMessage());
		} finally {
			softassert.assertAll();
		}
	}
}