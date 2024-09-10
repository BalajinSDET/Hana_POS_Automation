package com.hanapos.OrderEntry_Alais_DeliveryType_PhoneOrder_Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hanapos.pageObjects.CustomerPage;
import com.hanapos.pageObjects.DashboardOrderPage;
import com.hanapos.pageObjects.HanaDashBoardPage;
import com.hanapos.pageObjects.LoginPage;
import com.hanapos.pageObjects.OrderEntry_Alais_PhoneOrderPage;
import com.hanapos.pageObjects.Order_Confirmation_Page;
import com.hanapos.seleniumProjectBase.TestBaseClass;
import com.hanapos.utilities.DataLibrary;

public class Hana_T303_Delivery_Functionality_with_New_customer_FT extends TestBaseClass {
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private OrderEntry_Alais_PhoneOrderPage phoneorder;
	private Order_Confirmation_Page orderconfirmationpage;
	private DashboardOrderPage dashboardorder;
	private CustomerPage customerpage;
	public static final String dataSheetName = "Hana_T303";
	String invoiceNumber;
	String customerName;
	@DataProvider(name = "fetch_Excel_Data") 
	public Object[][] fetchData() throws IOException { 
		return DataLibrary.readExcelData(dataSheetName); 
	}

	
	@Test(enabled=true,groups= {"Regression","Smoke"},dataProvider="fetch_Excel_Data") 
	public void Validate_Hana_T303_Delivery_Functionality_with_New_customer_Functionality_Test(String salesperson, String custaddress1, String custzip,String custphone, String recifname, String recilname, String reciaddress1, String reciaddress2, String recizip,
			String recicity, String recicountry, String reciphone, String recilocation, String occasion, String searchandselectitemcode, String paymenttype, String cashregistry) {
		
		SoftAssert softassert = new SoftAssert();
		logger.info("**** Starting  Validate_Hana_T303_Delivery_Functionality_with_New_customer_Functionality_Test  ****");
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
			phoneorder.ClickDeliveryTypeOnPhoneOrderPage();
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getHighlightedColorOnDeliveryTypeOnPhoneOrderPage(),"#676a6c", "Pickup type is not highlighted in blue color");		
			
			// Test Step - 6
			phoneorder.Select_SalesPersonOn_PhoneOrderEntryPage(salesperson);
			phoneorder.EnterCustomerFirstName("Mike"+twodigitrandomeString());
			phoneorder.EnterCustomerLastName("Jones"+twodigitrandomeString());
			phoneorder.EnterAddress1(custaddress1);
			phoneorder.EnterZipCode(custzip);
			phoneorder.EnterPhoneNumber(custphone);
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getFirstnameOnPhoneOrderPage().contains("Mike"),true, "Test Step - 6 - First name is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getLastnameOnPhoneOrderPage().contains("Jones"),true, "Test Step - 6 - Last name is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getAddress1OnPhoneOrderPage(),"2715 35th Ave Ct", "Test Step - 6 - address 1 is not displayed on phone order page");
			
			if(phoneorder.getZipCodeOnPhoneOrderPage()=="94116") {
				softassert.assertEquals(phoneorder.getZipCodeOnPhoneOrderPage(),"94116", "Test Step - 6 - Zipcode is not displayed on phone order page");
			}else if(phoneorder.getZipCodeOnPhoneOrderPage()=="80634") {
				softassert.assertEquals(phoneorder.getZipCodeOnPhoneOrderPage(),"80634", "Test Step - 6 - Zipcode is not displayed on phone order page");
			}
			
			if(phoneorder.getCityOnPhoneOrderPage()=="San Francisco") {
				softassert.assertEquals(phoneorder.getCityOnPhoneOrderPage(),"San Francisco", "Test Step - 6 - city is not displayed on phone order page");
			}else if(phoneorder.getCityOnPhoneOrderPage()=="Greeley") {
				softassert.assertEquals(phoneorder.getCityOnPhoneOrderPage(),"Greeley", "Test Step - 6 - city is not displayed on phone order page");
			}
			
			softassert.assertEquals(phoneorder.getPhoneNumberOnPhoneOrderPage(),"956-655-0756", "Test Step - 6 - phone number 1 is not displayed on phone order page");
			phoneorder.EnterReciFirstName("");
			delayWithGivenTime(2000);
			softassert.assertTrue(phoneorder.Verify_NewCustomer_Label_Appears(), "Test Step - 6 - New customer label is not displayed on phone order page");
		
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
			phoneorder.SelectPaymentTypeOnPhoneOrderPage_PaymentSection(paymenttype);
			delayWithGivenTime(1000);
			softassert.assertEquals(phoneorder.getDisplayedPaymentTypeSelectedOption(),"Cash","Test Step - 10 - Selected Payment type is not displayed on phone order page payment section");
			delayWithGivenTime(1000);
			phoneorder.EnterCashAmount();
			delayWithGivenTime(1000);
			phoneorder.SelectCashRegistry_On_CashPaymentType(cashregistry);
			phoneorder.ClickPlaceOrderButton();
			delayWithGivenTime(2000);
			getDriver().switchTo().activeElement();
			softassert.assertTrue(phoneorder.VerifyConfirmationPopupOnPhoneOrderPage(), "Test Step - 10 - Confirmation popup is not displayed on phone order page");
			delayWithGivenTime(2000);
			
			// Test Step - 11
			phoneorder.ClickCancelButton_On_ConfirmationPopup();
			
			// Test Step - 12
			phoneorder.ClickPlaceOrderButton();
			delayWithGivenTime(1000);
			softassert.assertTrue(phoneorder.VerifyConfirmationPopupOnPhoneOrderPage(), "Test Step - 12 - Confirmation popup is not displayed on phone order page");
			delayWithGivenTime(1000);
			
			// Test Step - 13
			phoneorder.ClickSubmitButton_On_ConfirmationPopup();
			delayWithGivenTime(2000);
			orderconfirmationpage = new Order_Confirmation_Page();
			softassert.assertTrue(orderconfirmationpage.VerifyOrderConfirmationPage(), "Test Step - 13 - Order confirmation page is not displayed");
			delayWithGivenTime(500);
			invoiceNumber = orderconfirmationpage.get_invoiceNumber_on_OrderConfirmation_Page();
			customerName = orderconfirmationpage.getCustomerFname() + " " + orderconfirmationpage.getCustomerLname();

			// Test Step - 14
			dashboard.ClickOrder();
			delayWithGivenTime(1000);
			logger.info("User click the order menu on hana dashboard page");	
			dashboardorder = new DashboardOrderPage();	                     
			softassert.assertEquals(dashboardorder.validateDashboardOrderPage(),prop.getProperty("livedashboardorderURL"),"Test Step - 14 - Dashboard order page is not displayed");				
			
			// Test Step - 15,20
			dashboardorder.EnterGlobalSearch(invoiceNumber); //dashboardorder.get_InvoiceNumber_PhoneOrder_Delivery_AsCashPayment()
			delayWithGivenTime(1000);			
			softassert.assertTrue(dashboardorder.Validate_DeliveryAsCashPayment_on_PhoneOrder_on_SenderorCustomer_OnOrderPage(),"Test Step - 15 - Phone order cash payment is not displayed");		//https://hanafloralpos3.com/Dashboard/Order/Validate_PhoneOrder_InvoiceInHousePayment();
			delayWithGivenTime(2000);
			
			dashboardorder.Click_DeliveryAsCashPayment_on_PhoneOrder_on_SenderorCustomer_OnOrderPage();
			delayWithGivenTime(1000);
			
			softassert.assertEquals(dashboardorder.getRecipientName_OnDeliveryPopup(),"Abish David", "Test Step 15 - Recipient name is not displayed on delivery popup");
			softassert.assertEquals(dashboardorder.getRecipientPhoneNum_OnDeliveryPopup(),"956-655-0756","Test Step 15 - Recipient phone number is not displayed on delivery popup");
			softassert.assertEquals(dashboardorder.getRecipientAddress_OnDeliveryPopup(),"3402 Park Blvd PICK UP San Diego CA 92103 US", "Test Step 15 - Recipient address is not displayed on delivery popup");
			delayWithGivenTime(2000);
			softassert.assertEquals(dashboardorder.getCustAndcompyNameOnDeliveryPopup().contains("Mike Jones"),false,"Test Step - 15 - customer and company name on delivery popup is not matched");
			System.out.println(dashboardorder.getCustAndcompyNameOnDeliveryPopup() +" - Newly registered customer name");
			softassert.assertEquals(dashboardorder.getCustAddressOnDeliveryPopup(),"2715 35th Ave Ct","Test Step - 15 -customer address on delivery popup is not matched");
			softassert.assertEquals(dashboardorder.getCustPhoneNumOnDeliveryPopup(),"956-655-0756","Test Step - 15 -customer phone number on delivery popup is not matched");
			logger.info("User verified displayed customer type, customer name, company name, Address, Phone number & email are matched");
			delayWithGivenTime(2000);		
			
			softassert.assertEquals(dashboardorder.Verify_OrderType_Displayed_on_DeliveryPopup(), "Delivery Phone Order","Test Step - 16 - Proper Order type is not displayed on delivery popup");
			dashboardorder.ClickCloseIconOnDeliveryPopup();
			
			// Test Step - 16
			delayWithGivenTime(2000);
			customerpage = new CustomerPage();
			dashboardorder.ClickCustomerMenuOnDashboard();
			logger.info("User clicks on customer menu on dashboard");
			delayWithGivenTime(2000);
			softassert.assertTrue(customerpage.VerifyCustomerMenuPage(),"Test Step - 16 - customer menu page is not displayed");
			logger.info("User verify that customer menu page is displayed successfully");
			
			// Test Step - 17
			customerpage.Enter_CustomerName_searchbox_OnCustTable(customerName);
			ThreadWait(1000);
			delayWithGivenTime(2000);
			softassert.assertEquals(customerpage.VerifyPhoneNumberOnCustTable(),"956-655-0756","Test Step - 17 -Phone number on customer table is not matched");
			logger.info("User verify that phone number on customer table");
			softassert.assertEquals(customerpage.VerifyAddressOnCustTable(),"2715 35th Ave Ct","Test Step - 17 - Address on customer table is not matched");
			logger.info("User verify that address on customer table");
	
			// Test Step - 18
			delayWithGivenTime(2000);
			customerpage.ClickCustomerTableRow1();
			logger.info("User clicks the displayed customer in the table ");
			delayWithGivenTime(3000);
			softassert.assertTrue(customerpage.VerifyCustomerDetailsPopup(),"Test Step - 18 - Customer details pop up is not displayed");
			logger.info("User verify that customer details popup is displayed");
			
			// Test Step - 19
			delayWithGivenTime(2000);
			softassert.assertEquals(customerpage.getCustDetailsFirstNameTextBox().contains("Mike"), true,"Test Step - 19 - Added on first name field are not properly displayed");
			logger.info("User verify the first name field entered data is displayed");
			softassert.assertEquals(customerpage.getCustDetailsLastNameTextBox().contains("Jones"), true,"Test Step - 19 - Added on first name field are not properly displayed");
			logger.info("User verify the last name field entered data is displayed");
			softassert.assertEquals(customerpage.getCustDetailsPhoneNumberTextbox(), "956-655-0756","Test Step - 19 - Added on phone number field are not properly displayed");
			logger.info("User verify the phone number field entered data is displayed");
			softassert.assertEquals(customerpage.getCustDetailsAddress1TextBox(),"2715 35th Ave Ct","Test Step - 19 - Added address 1 field is not properly displayed");
			logger.info("User verify that address 1 field entered data is displayed");			
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Test case failed due to exception " + e.getMessage());
			logger.error("Test case failed due to exception " + e.getMessage());
		} finally {
			softassert.assertAll();
		}
	}
}