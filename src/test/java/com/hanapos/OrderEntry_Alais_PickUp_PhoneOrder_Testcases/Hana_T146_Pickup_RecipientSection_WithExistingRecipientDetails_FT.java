package com.hanapos.OrderEntry_Alais_PickUp_PhoneOrder_Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hanapos.pageObjects.DashboardOrderPage;
import com.hanapos.pageObjects.HanaDashBoardPage;
import com.hanapos.pageObjects.LoginPage;
import com.hanapos.pageObjects.OrderEntry_Alais_PhoneOrderPage;
import com.hanapos.pageObjects.Order_Confirmation_Page;
import com.hanapos.seleniumProjectBase.TestBaseClass;

public class Hana_T146_Pickup_RecipientSection_WithExistingRecipientDetails_FT extends TestBaseClass {
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private OrderEntry_Alais_PhoneOrderPage phoneorder;
	private DashboardOrderPage dashboardorder;
	private Order_Confirmation_Page orderconfirmationpage;
	
	//,dataProvider="fetch_Excel_Data"
	@Test(enabled=true,groups= {"Regression"}) 
	public void Validate_Hana_T146_Pickup_RecipientSection_With_Existing_RecipientDetails_Functionality_Test() {
		SoftAssert softassert = new SoftAssert();
		logger.info("**** Starting  Hana_T146_Pickup_RecipientSection_With_Existing_RecipientDetails_FT  ****");
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
			phoneorder.EnterReciFirstName("Abi");
			softassert.assertEquals(phoneorder.getReciFirstName(),"Abi", "Test Step - 7 - Entered Recipient First name is not displayed on phone order page");
			
			// Test Step - 8
			softassert.assertTrue(phoneorder.Verify_RecipientName_Autosuggestion(), "Test Step - 8 - Recipient first name autosuggestions are not displayed on phone order page");
			
			// Test Step - 9
			phoneorder.SearchAndSelect_RecipientNameFromAutoSuggestion("Abish David 114 N CHURCH ST PICK UP (9566550756)");
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getReciFirstName(),"Abish","Test Step - 9 - Entered first name is not displayed on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciLastName(),"David","Test Step - 9 - Entered last name is not displayed on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciAddress1(),"114 N CHURCH ST","Test Step - 9 - Entered address 1 is not displayed on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciAddress2(),"PICK UP","Test Step - 9 - Entered address 2 is not displayed on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciZipcode(),"63084","Test Step - 9 - Entered zipcode is not displayed on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciCity(),"UNION","Test Step - 9 - Entered city is not displayed on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciPhone(),"956-655-0756","Test Step - 9 - Recipient phone number is not displayed on phone order page recipient section");
			
			// Test Step - 10
			softassert.assertTrue(phoneorder.Verify_AddressverifiedByGoogle_ToastMsgAppears(), "Test Step - 10 - Address verified by google toast message is not displayed on phone order page recipient section");
			
			// Test Step - 11
			softassert.assertEquals(phoneorder.getDeliveryDateOnReciSection(),CurrentDate(), "Test Step - 11 - Delivery date is not displayed on phone order page recipient section");
			
			// Test Step - 12
			
			// Test Step - 13
			delayWithGivenTime(1000);
			phoneorder.EnterReciFirstName("Abish1");
			phoneorder.EnterReciLastName("David1");
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getReciFirstName(),"Abish1", "Test Step - 13 - First name is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getReciLastName(),"David1", "Test Step - 13 - Last name is not displayed on phone order page");
			delayWithGivenTime(500);
			
			// Test Step - 14
			softassert.assertEquals(phoneorder.Verify_RecipientKMS_Appears(),"0 KM", "Test Step - 14 - Recipient distance kms is not displayed on phone order page");
		
			// Test Step - 15
			phoneorder.SelectOccasion_On_OrderDetails_In_PhoneOrderPage("Birthday");
			phoneorder.EnterViewShortCode();			
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getSelectedOccasionOnPhoneOrderPage(),"Birthday","Test Step - 15 - Selected Occasion is not displayed on phone order page order details section");
			softassert.assertTrue(phoneorder.getEnteredViewShortCode().equalsIgnoreCase("Happy Birthday! Hope You Have An Amazing Day!"),"Test Step - 15 -Entered Short code is not displayed on phone order page order details section");
			delayWithGivenTime(2000);
			
			// Test Step - 16
			phoneorder.SearchandSelectItemcodeOnPhoneOrderPage("rrd","rrd Red Rose Deluxe");
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getProdDetailsItemcode1OnPhoneOrderPage(),"rrd","Test Step - 9 - Item code is not displayed on phone order page product details section");
			softassert.assertEquals(phoneorder.getProdDetailsItemDescription1OnPhoneOrderPage(),"Red Rose Deluxe","Test Step - 9 - Item description is not displayed on phone order page product details section"); 
			softassert.assertEquals(phoneorder.getProdItemQty1OnPhoneOrderPage(),"1","Test Step - 9 - Item quantity is not displayed on phone order page product details section");
			softassert.assertEquals(phoneorder.getUnitPriceOnProdDetails(),"299.00","Test Step - 9 - Item price is not displayed on phone order page product details section");
			delayWithGivenTime(2000);
			
			// Test Step - 17
			 phoneorder.SelectPaymentTypeOnPhoneOrderPage_PaymentSection("Cash");
			 delayWithGivenTime(1000);
			 softassert.assertEquals(phoneorder.getDisplayedPaymentTypeSelectedOption(), "Cash","Test Step - 10 - Selected Payment type is not displayed on phone order page payment section" );
			 delayWithGivenTime(2000); 
			 phoneorder.EnterCashAmount();
			 delayWithGivenTime(3000);
			 phoneorder.SelectCashRegistry_On_CashPaymentType("Cash Register2");
			 phoneorder.ClickPlaceOrderButton();
			 			 
			// Test Step - 18
			 delayWithGivenTime(1000);
			getDriver().switchTo().activeElement();
			softassert.assertTrue(phoneorder.VerifyConfirmationPopupOnPhoneOrderPage(),"Test Step - 10 - Confirmation popup is not displayed on phone order page");
			delayWithGivenTime(2000);	
			phoneorder.ClickSubmitButton_On_ConfirmationPopup();
			delayWithGivenTime(2000);
			orderconfirmationpage = new Order_Confirmation_Page();
			softassert.assertTrue(orderconfirmationpage.VerifyOrderConfirmationPage(), "Test Step - 13 - Order confirmation page is not displayed");
			
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