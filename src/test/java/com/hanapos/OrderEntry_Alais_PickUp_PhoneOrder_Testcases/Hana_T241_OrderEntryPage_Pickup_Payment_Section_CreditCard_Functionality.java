package com.hanapos.OrderEntry_Alais_PickUp_PhoneOrder_Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hanapos.pageObjects.DashboardOrderPage;
import com.hanapos.pageObjects.HanaDashBoardPage;
import com.hanapos.pageObjects.LoginPage;
import com.hanapos.pageObjects.OrderEntry_Alais_PhoneOrderPage;
import com.hanapos.pageObjects.Order_Confirmation_Page;
import com.hanapos.seleniumProjectBase.TestBaseClass;
import com.hanapos.utilities.DataLibrary;

public class Hana_T241_OrderEntryPage_Pickup_Payment_Section_CreditCard_Functionality extends TestBaseClass {
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private OrderEntry_Alais_PhoneOrderPage phoneorder;
	private Order_Confirmation_Page orderconfirmationpage;
	private DashboardOrderPage dashboardorder;
	
	public static final String dataSheetName = "Hana_T81";
	//,dataProvider="fetch_Excel_Data"
	
	@DataProvider(name = "fetch_Excel_Data") 
	public Object[][] fetchData() throws IOException { 
		return DataLibrary.readExcelData(dataSheetName); 
	}

	
	
	@Test(enabled=true,groups= {"Regression"},dataProvider="fetch_Excel_Data") //,invocationCount=5
	public void Validate_Hana_T241_OrderEntryPage_Pickup_Payment_Section_CreditCard_Functionality_Test(
			String salesperson, String customername, String recifname, String recilname, String reciaddress1, String reciaddress2, String recizip, String recicity,
			String recicountry, String reciphone, String recilocation,String occasion, String searchandselectitemcode, String paymenttype) {
		SoftAssert softassert = new SoftAssert();
		logger.info("**** Starting  Hana_T241_OrderEntryPage_Pickup_Payment_Section_CreditCard_Functionality  ****");
		logger.debug("capturing application debug logs....");
		try {
			// Test Step - 1
			lp = new LoginPage();
			softassert.assertTrue(lp.LoginPageIsDisplayed(),"Login page is not displayed");
			logger.info("User on the hana pos login page");
			
			// Test Step - 2
			lp.EnterUserName(prop.getProperty("bestuname"));
			logger.info("User entered the username as "+prop.getProperty("bestuname"));
			lp.EnterPassword(prop.getProperty("bestpass"));
			logger.info("User entered the password as "+prop.getProperty("bestpass"));
			lp.ClickLoginButton();
			logger.info("User clicked on Login button");

			dashboard = new HanaDashBoardPage();
			softassert.assertTrue(dashboard.VerifyHanaDashBoardPage(),"Page does not navigated to hana dashboard page");
			logger.info("User navigated to hana dashboard page");
			dashboard.SelectShopNameDropDown(prop.getProperty("bestshopname"));
			logger.info("User select the shopname on dashbaord page as "+prop.getProperty("bestshopname"));
			
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
			
			// Test Step - 6
			phoneorder.Select_SalesPersonOn_PhoneOrderEntryPage(salesperson);
			phoneorder.SearchAndSelectCustomerOnCust_Section(customername);
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

			// Test Step - 7
			phoneorder.EnterReciFirstName(recifname);
			phoneorder.EnterReciLastName(recilname);
			phoneorder.EnterReciAddress1(reciaddress1);
			phoneorder.EnterReciAddress2(reciaddress2);
			phoneorder.EnterReciZipcode(recizip);
			delayWithGivenTime(1000);
			//phoneorder.EnterReciCity(recicity);
			phoneorder.SelectReciCountry(recicountry);
			phoneorder.EnterReciPhone(reciphone);
			delayWithGivenTime(1000);
			phoneorder.SelectReciLocation(recilocation);
			phoneorder.Select_Zone_OnRecipientSection("TestZone");
			delayWithGivenTime(1000);
			phoneorder.EnterDeliveryDateOnReciSection();
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getReciFirstName(),"Abish","Test Step - 7 - Entered first name is not displayed on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciLastName(),"David","Test Step - 7 - Entered last name is not displayed on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciAddress1(),"3402 Park Blvd","Test Step - 7 - Entered address 1 is not displayed on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciAddress2(),"PICK UP","Test Step - 7 - Entered address 2 is not displayed on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciZipcode(),"92103","Test Step - 7 - Entered zipcode is not displayed on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciCity(),"San Diego","Test Step - 7 - Entered city is not displayed on phone order page recipient section");
			softassert.assertEquals(phoneorder.getSelectedCountryOnReciCountry(),"United States","Test Step - 7 - Selected country is not displayed on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciPhone(),"956-655-0756","Test Step - 7 - Recipient phone number is not displayed on phone order page recipient section");
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getSelectedLocationOnReciLocation(),"Church","Test Step - 7 - Recipient location is not displayed on phone order page recipient section");
			softassert.assertEquals(phoneorder.getDeliveryDateOnReciSection(),NextDate(),"Test Step - 7 - Delivery date is not displayed on phone order page recipient section");
		
			//Test Step - 8
			phoneorder.SelectOccasion_On_OrderDetails_In_PhoneOrderPage(occasion);
			phoneorder.EnterViewShortCode();			
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getSelectedOccasionOnPhoneOrderPage(),"Birthday","Test Step - 8 - Selected Occasion is not displayed on phone order page order details section");
			softassert.assertEquals(phoneorder.getEnteredViewShortCode(),"Happy Birthday! Hope you have an amazing day!","Test Step - 8 -Entered Short code is not displayed on phone order page order details section");
			delayWithGivenTime(2000);
		
			// Test Step - 9
			phoneorder.SearchandSelectItemcodeOnPhoneOrderPage(searchandselectitemcode,"rrd-Red Rose Deluxe");
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getProdDetailsItemcode1OnPhoneOrderPage(),"rrd","Test Step - 9 - Item code is not displayed on phone order page product details section");
			softassert.assertEquals(phoneorder.getProdDetailsItemDescription1OnPhoneOrderPage(),"Red Rose Deluxe","Test Step - 9 - Item description is not displayed on phone order page product details section"); 
			softassert.assertEquals(phoneorder.getProdItemQty1OnPhoneOrderPage(),"1","Test Step - 9 - Item quantity is not displayed on phone order page product details section");
			
			if(phoneorder.getUnitPriceOnProdDetails()=="299.00"){ 
				softassert.assertEquals(phoneorder.getUnitPriceOnProdDetails(),"299.00","Test Step - 9 - Item price is not displayed on phone order page product details section");
			}else if (phoneorder.getUnitPriceOnProdDetails()=="309.00") {
				softassert.assertEquals(phoneorder.getUnitPriceOnProdDetails(),"309.00","Test Step - 9 - Item price is not displayed on phone order page product details section");
			}
						
			delayWithGivenTime(2000);
			
			// Test Step - 10			
			phoneorder.SelectPaymentTypeOnPhoneOrderPage_PaymentSection("Credit Card");
			delayWithGivenTime(1000);
			softassert.assertEquals(phoneorder.get_SelectedPaymentType_OnPhoneOrderPage(),"Credit Card", "Test Step - 10 - Selected payment type is not displayed");
		
			// Test Step - 11			
			softassert.assertEquals(phoneorder.get_autopopulated_creditcard_paymenttype_FirstName(), "Abish", "Test Step - 11 - First name textbox field Payment type as credit card section  is not autopopulated");
			
			// Test Step - 12
			softassert.assertEquals(phoneorder.get_autopopulated_creditcard_paymenttype_LastName(), "David", "Test Step - 12 - Last name textbox field Payment type as credit card section  is not autopopulated");

			// Test Step - 13
			softassert.assertEquals(phoneorder.get_autopopulated_creditcard_paymenttype_Zipcode(), "92103", "Test Step - 13 - Zipcode textbox field Payment type as credit card section  is not autopopulated");
			
			// Test Step - 14
			softassert.assertEquals(phoneorder.get_autopopulated_creditcard_paymenttype_City(), "San Diego", "Test Step - 14 - City textbox field Payment type as credit card section  is not autopopulated");
			
			// Test Step - 15
			softassert.assertEquals(phoneorder.get_autopopulated_creditcard_paymenttype_State(), "CA", "Test Step - 15 - State textbox field Payment type as credit card section  is not autopopulated");
			
			// Test Step - 16
			softassert.assertEquals(phoneorder.get_Selected_creditcard_paymenttype_Country(), "United States", "Test Step - 16 - Country textbox field Payment type as credit card section  is not autopopulated");
			
			// Test Step - 17 
			phoneorder.Enter_CreditCardNumber_CCPaymentSection_On_PhoneOrderPage("4111-1111-1111-1111");
			softassert.assertEquals(phoneorder.get_entered_CreditcardNumber_CCPaymentSection_On_PhoneOrderPage(), "4111-1111-1111-1111","Test Step - 17 - Entered credit card number is not displayed on credit card payment section");
			
			// Test Step - 18
			phoneorder.Enter_ExpiredDate_CCPaymentSection_On_PhoneOrderPage("0729");
			softassert.assertEquals(phoneorder.get_entered_ExpiredDate_CCPaymentSection_On_PhoneOrderPage(), "0729","Test Step - 18 - Entered credit card expire date is not displayed on credit card payment section");
			
			// Test Step - 19
			phoneorder.Enter_CCV_CCPaymentSection_On_PhoneOrderPage("111");
			softassert.assertEquals(phoneorder.get_entered_CVV_CCPaymentSection_On_PhoneOrderPage(), "111","Test Step - 19 - Entered credit card CVV code is not displayed on credit card payment section");
		
			// Test Step - 20
			phoneorder.ClickPlaceOrderButton();
			
			// Test Step - 21
			phoneorder.ClickSubmitButton_On_ConfirmationPopup();
			delayWithGivenTime(2000);
			orderconfirmationpage = new Order_Confirmation_Page();
			softassert.assertTrue(orderconfirmationpage.VerifyOrderConfirmationPage(), "Test Step - 21 - Order confirmation page is not displayed");
			
			// Test Step - 22
			softassert.assertEquals(orderconfirmationpage.get_PaymentType(), "Credit Card", "Test Step - 22 - Payment type is not displayed on order confirmation page");

			// Test Step - 23
			delayWithGivenTime(1000);
			dashboard.ClickOrder();
			delayWithGivenTime(1000);
			logger.info("User click the order menu on hana dashboard page");	
			dashboardorder = new DashboardOrderPage();	                      
			softassert.assertEquals(dashboardorder.validateDashboardOrderPage(),prop.getProperty("livedashboardorderURL"),"Test Step - 23 - Dashboard order page is not displayed");				
			
			// Test Step - 24
			dashboardorder.EnterGlobalSearch(dashboardorder.get_InvoiceNumber_PhoneOrder_PickUp_CC_PaymentType());
			delayWithGivenTime(1000);
			softassert.assertTrue(dashboardorder.Validate_PhoneOrder_CC_PaymentType_PickUp_InvoiceNumber(),"Test Step - 24 - In orders summary page Donation payment type invoice number is not displayed for placed order");		
			delayWithGivenTime(1000);
			softassert.assertEquals(dashboardorder.Validate_PhoneOrder_CC_PaymentType_PickUp_ModeOfPayment(),"Credit Card","Test Step - 24 - Mode of payment as Donation type is not displayed");
					
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Test case failed due to exception " + e.getMessage());
			logger.error("Test case failed due to exception " + e.getMessage());
		} finally {
			softassert.assertAll();
		}	
	}
}
