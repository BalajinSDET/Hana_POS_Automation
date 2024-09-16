package com.hanapos.OrderEntry_Alais_WireOut_PhoneOrder_Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hanapos.pageObjects.DashboardOrderPage;
import com.hanapos.pageObjects.HanaDashBoardPage;
import com.hanapos.pageObjects.LoginPage;
import com.hanapos.pageObjects.OrderEntry_Alais_PhoneOrderPage;
import com.hanapos.pageObjects.Order_Confirmation_Page;
import com.hanapos.seleniumProjectBase.TestBaseClass;
import com.hanapos.utilities.CustomSoftAssert;
import com.hanapos.utilities.DataLibrary;

public class Hana_T519_OrderEntryPage_WireOut_Functionality_with_Existing_customer_FT extends TestBaseClass {
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private OrderEntry_Alais_PhoneOrderPage phoneorder;
	private Order_Confirmation_Page orderconfirmationpage;
	private DashboardOrderPage dashboardorder;
	String invoiceNumber;
	public static final String dataSheetName = "Hana_T302";
	
	@DataProvider(name = "fetch_Excel_Data") 
	public Object[][] fetchData() throws IOException { 
		return DataLibrary.readExcelData(dataSheetName); 
	}
	
	
	@Test(enabled=true,groups= {"Regression","Smoke"},dataProvider="fetch_Excel_Data") 
	public void Validate_Hana_T519_OrderEntryPage_WireOut_Functionality_with_Existing_customer_Functionality_Test(
			String salesperson, String customername, String recifname, String recilname, String reciaddress1, String reciaddress2, String recizip, String recicity,
			String recicountry, String reciphone, String recilocation,String occasion, String searchandselectitemcode, String paymenttype) {
		// SoftAssert softassert = new SoftAssert(); - I have modified this to use CustomSoftAssert
		CustomSoftAssert softassert = new CustomSoftAssert();
		
		logger.info("**** Starting  Hana-Validate_Hana_T519_OrderEntryPage_WireOut_Functionality_with_Existing_customer_Functionality_Test  ****");
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
			phoneorder.Click_WireOut_DeliveryType_OnPhoneOrderPage();
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getHighlightedColorOnDeliveryTypeOnPhoneOrderPage(),"#676a6c", "Pickup type is not highlighted in blue color");		
			
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
			softassert.assertTrue(phoneorder.Verify_ProductSuggestions_Appears("rrd"),"Test Step - 9 - In Item code row 1 on product section autosuggestions are not displayed");
			phoneorder.SearchandSelectItemcodeOnPhoneOrderPage("rrd","rrd Red Rose Small");
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getProdDetailsItemcode1OnPhoneOrderPage(),"rrd","Test Step - 9 - Item code is not displayed on phone order page product details section");
			if(phoneorder.getProdDetailsItemDescription1OnPhoneOrderPage()=="Red Rose Small") {
			softassert.assertEquals(phoneorder.getProdDetailsItemDescription1OnPhoneOrderPage(),"Red Rose Small","Test Step - 9 - Item description is not displayed on phone order page product details section"); 
			}else if(phoneorder.getProdDetailsItemDescription1OnPhoneOrderPage()=="") {
				softassert.assertEquals(phoneorder.getProdDetailsItemDescription1OnPhoneOrderPage(),"","Test Step - 9 - Item description is not displayed on phone order page product details section"); 
			}
			softassert.assertEquals(phoneorder.getProdItemQty1OnPhoneOrderPage(),"1","Test Step - 9 - Item quantity is not displayed on phone order page product details section");
			
			if(phoneorder.getUnitPriceOnProdDetails()=="199.00"){ 
				softassert.assertEquals(phoneorder.getUnitPriceOnProdDetails(),"199.00","Test Step - 9 - Item price is not displayed on phone order page product details section");
			}else if (phoneorder.getUnitPriceOnProdDetails()=="209.00") {
				softassert.assertEquals(phoneorder.getUnitPriceOnProdDetails(),"209.00","Test Step - 9 - Item price is not displayed on phone order page product details section");
			}else {
				System.out.println("Test Step - 9 - Item price is displayed as empty or blank on phone order page product details section");
			}
			
			delayWithGivenTime(2000);
			
			// Test Step - 10
			phoneorder.SelectPaymentTypeOnPhoneOrderPage_PaymentSection(paymenttype);
			delayWithGivenTime(1000);
			phoneorder.Select_WireOut_PaymentMethod("FSN");
			phoneorder.Enter_WireoutFlorist("63084");
			phoneorder.set_Amount_wireout_paymentsection();
			phoneorder.ClickPlaceOrderButton();
			delayWithGivenTime(1000);
			getDriver().switchTo().activeElement();
			softassert.assertTrue(phoneorder.VerifyConfirmationPopupOnPhoneOrderPage(), "Test Step - 10 - Confirmation popup is not displayed on phone order page");
			delayWithGivenTime(2000);
			
			// Test Step - 11
			phoneorder.ClickCancelButton_On_ConfirmationPopup();
			
			// Test Step - 12
			phoneorder.ClickPlaceOrderButton();
			softassert.assertTrue(phoneorder.VerifyConfirmationPopupOnPhoneOrderPage(), "Test Step - 12 - Confirmation popup is not displayed on phone order page");
			delayWithGivenTime(2000);
			
			// Test Step - 13
			phoneorder.ClickSubmitButton_On_ConfirmationPopup();
			delayWithGivenTime(2000);
			orderconfirmationpage = new Order_Confirmation_Page();
			softassert.assertTrue(orderconfirmationpage.VerifyOrderConfirmationPage(), "Test Step - 13 - Order confirmation page is not displayed");
			delayWithGivenTime(500);
			invoiceNumber = orderconfirmationpage.get_invoiceNumber_on_OrderConfirmation_Page();
		
			// Test Step - 14
			delayWithGivenTime(1000);
			dashboard.ClickOrder();
			delayWithGivenTime(1000);
			logger.info("User click the order menu on hana dashboard page");	
			dashboardorder = new DashboardOrderPage();	                      //https://hanafloralpos3.com/Dashboard/Order
			softassert.assertEquals(dashboardorder.validateDashboardOrderPage(),prop.getProperty("livedashboardorderURL"),"Test Step - 14 - Dashboard order page is not displayed");				
			
			// Test Step - 15
			delayWithGivenTime(2000);
			dashboardorder.EnterGlobalSearch(invoiceNumber); //dashboardorder.get_PhoneOrder_WireOut_InvoiceInHousePayment()		
			delayWithGivenTime(1000);
			softassert.assertTrue(dashboardorder.Validate_PhoneOrder_WireOut_InvoiceInHousePayment(),"Test Step - 15 - In order summary page, Respective wire out Phone order invoice in house payment order is not displayed");		//https://hanafloralpos3.com/Dashboard/Order/Validate_PhoneOrder_InvoiceInHousePayment();
			delayWithGivenTime(2000);
			dashboardorder.Click_PhoneOrder_WireOut_InvoiceInHousePayment();

			//Test Step - 16
			delayWithGivenTime(2000);
			softassert.assertEquals(dashboardorder.getRecipientName_OnDeliveryPopup(),"Abish David", "Test Step 16 - Recipient name is not displayed on delivery popup");
			softassert.assertEquals(dashboardorder.getRecipientPhoneNum_OnDeliveryPopup(),"956-655-0756","Test Step 16 - Recipient phone number is not displayed on delivery popup");
			delayWithGivenTime(2000);
			softassert.assertEquals(dashboardorder.getRecipientAddress_OnDeliveryPopup(),"3402 Park Blvd PICK UP San Diego CA 92103 US", "Test Step 16 - Recipient address is not displayed on delivery popup");
			softassert.assertEquals(dashboardorder.getCustAndcompyNameOnDeliveryPopup(),"Hana_Sisterchicks | Abish David","Test Step - 16 - customer and company name on delivery popup is not matched");
			delayWithGivenTime(2000);
			softassert.assertEquals(dashboardorder.getCustAddressOnDeliveryPopup(),"3402 Park Blvd","Test Step - 16 -customer address on delivery popup is not matched");
			softassert.assertEquals(dashboardorder.getCustPhoneNumOnDeliveryPopup(),"956-655-0756","Test Step - 16 -customer phone number on delivery popup is not matched");
			softassert.assertEquals(dashboardorder.getCustEmailOnDeliveryPopup(),"hanaposqateam@gmail.com","Test Step - 16 - customer phone number on delivery popup is not matched");
			logger.info("User verified displayed customer type, customer name, company name, Address, Phone number & email are matched");
			delayWithGivenTime(2000);			
			softassert.assertEquals(dashboardorder.Verify_OrderType_Displayed_on_DeliveryPopup(), "Wire Out Phone Order","Test Step - 16 - Proper Order type is not displayed on delivery popup");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Test case failed due to exception " + e.getMessage());
			logger.error("Test case failed due to exception " + e.getMessage());
		} finally {
			softassert.assertAll();
		}	
	}
}
