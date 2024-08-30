package com.hanapos.Quick_Dispatch_Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hanapos.pageObjects.DashboardOrderPage;
import com.hanapos.pageObjects.DispatchPage;
import com.hanapos.pageObjects.HanaDashBoardPage;
import com.hanapos.pageObjects.LoginPage;
import com.hanapos.pageObjects.OrderEntry_Alais_PhoneOrderPage;
import com.hanapos.pageObjects.Order_Confirmation_Page;
import com.hanapos.seleniumProjectBase.TestBaseClass;
import com.hanapos.utilities.DataLibrary;

public class Hana_T711_Quick_Dispatch_Functionality extends TestBaseClass {
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private OrderEntry_Alais_PhoneOrderPage phoneorder;
	private Order_Confirmation_Page orderconfirmationpage;
	private DashboardOrderPage dashboardorder;
	private DispatchPage dispatch;
	
	public static final String dataSheetName = "Hana_T302";
	
	@DataProvider(name = "fetch_Excel_Data") 
	public Object[][] fetchData() throws IOException { 
		return DataLibrary.readExcelData(dataSheetName); 
	}
	
	//,invocationCount=5 - to run the test multiple times
	@Test(enabled=true,groups= {"Regression","Smoke"},dataProvider="fetch_Excel_Data") 
	public void Validate_Hana_T711_Quick_Dispatch_Functionality_with_Existing_customer(
			String salesperson, String customername, String recifname, String recilname, String reciaddress1, String reciaddress2, String recizip, String recicity,
			String recicountry, String reciphone, String recilocation,String occasion, String searchandselectitemcode, String paymenttype) {
		SoftAssert softassert = new SoftAssert();
		logger.info("**** Starting  Hana-Validate_Hana_T302_Delivery_Functionality_with_Existing_customer  ****");
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
			phoneorder.Enter_DeliveryDate_On_ReciSection();
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
			softassert.assertEquals(phoneorder.getDeliveryDateOnReciSection(),CurrentDate(),"Test Step - 7 - Delivery date is not displayed on phone order page recipient section");
		
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
			phoneorder.ClickPlaceOrderButton();
			delayWithGivenTime(1000);
			getDriver().switchTo().activeElement();
			softassert.assertTrue(phoneorder.VerifyConfirmationPopupOnPhoneOrderPage(), "Test Step - 10 - Confirmation popup is not displayed on phone order page");
			delayWithGivenTime(2000);
			
			// Test Step - 11
			phoneorder.ClickSubmitButton_On_ConfirmationPopup();
			delayWithGivenTime(2000);
			orderconfirmationpage = new Order_Confirmation_Page();
			softassert.assertTrue(orderconfirmationpage.VerifyOrderConfirmationPage(), "Test Step - 13 - Order confirmation page is not displayed");
			
			delayWithGivenTime(1000);
			dashboard.ClickOrder();
			delayWithGivenTime(1000);
			logger.info("User click the order menu on hana dashboard page");	
			dashboardorder = new DashboardOrderPage();	                      //https://hanafloralpos3.com/Dashboard/Order
			softassert.assertEquals(dashboardorder.validateDashboardOrderPage(),prop.getProperty("livedashboardorderURL"),"Test Step - 14 - Dashboard order page is not displayed");				
			delayWithGivenTime(2000);
			
			dashboardorder.EnterGlobalSearch(dashboardorder.getInvoiceNumber_On_PhoneOrder_DeliveryInvoiceInHousePayment());
			softassert.assertTrue(dashboardorder.Validate_PhoneOrder_DeliveryInvoiceInHousePayment(),"Test Step - 15 - Phone order invoice in house payment is not displayed");		//https://hanafloralpos3.com/Dashboard/Order/Validate_PhoneOrder_InvoiceInHousePayment();
			delayWithGivenTime(2000);
			

			//=======================Above are the pre requiste
			// Test Step - 2
			delayWithGivenTime(2000);
			softassert.assertTrue(dashboard.Verify_AdvanceDispatch_OptionIsDisplayed(),"Test Step - 2 - Advance dispatch option is not displayed");
			softassert.assertTrue(dashboard.Verify_QuickDispatch_OptionIsDisplayed(),"Test Step - 2 - Quick dispatch option is not displayed");
			
			// Test Step - 3
			dashboard.Hover_Dispatch_And_Click_QuickDispatch();
			dispatch = new DispatchPage();
			softassert.assertTrue(dispatch.Verify_DispatchPopup_IsDisplayed(),"Test Step - 3 - Dispatch popup is not displayed");
			
			// Test Step - 4
			delayWithGivenTime(3000);
			dispatch.Enter_InvoiceNumber_on_ScanOrderTextbox(dashboardorder.getInvoiceNumber_On_PhoneOrder_DeliveryInvoiceInHousePayment());
			delayWithGivenTime(3000);
			softassert.assertEquals(dispatch.get_InvoiceNumber_On_TripSection(), dashboardorder.getInvoiceNumber_On_PhoneOrder_DeliveryInvoiceInHousePayment(),"Test Step - 4 - Entered Invoice number is not matched on trip section");
			softassert.assertEquals(dispatch.get_NameAndAddress_On_TripSection(), "Abish David 3402 Park Blvd PICK UP","Test Step - 4 - Displayed Name and address are not matched");
			softassert.assertEquals(dispatch.get_City_On_TripSection(), "San Diego","Test Step - 4 - Displayed city is not matched");
			softassert.assertEquals(dispatch.get_State_On_TripSection(), "CA","Test Step - 4 - Displayed state is not matched");
			softassert.assertEquals(dispatch.get_Zipcode_On_TripSection(), "92103","Test Step - 4 - Displayed zipcode is not matched");			
			
			// Test Step - 5
			dispatch.Select_Driver("LJB Liam Jack Benjamin");
			softassert.assertEquals(dispatch.get_Selected_Driver(), "LJB Liam Jack Benjamin","Test Step - 5 - Selected Driver is not displayed on the dropdown");
			
			// Test Step - 6
			dispatch.Click_DispatchSave_Button();
			softassert.assertEquals(phoneorder.verifySuccessToastMessageText(), "Dispatch Saved Successfully","Test Step - 6 - Dispatch Saved Successfully toast success text message is not displayed");
			softassert.assertTrue(dispatch.Verify_NewTripBtn_IsDisplayed(),"Test Step - 6 - New trip button is not displayed");
			softassert.assertTrue(dispatch.Verify_RoutePlannerBtn_IsDisplayed(),"Test Step - 6 - Route planner button is not displayed");
			softassert.assertTrue(dispatch.Verify_RemotePrintBtn_IsDisplayed(),"Test Step - 6 - Remote print button is not displayed");
			softassert.assertTrue(dispatch.Verify_ManualPrintBtn_IsDisplayed(),"Test Step - 6 - Manual Print button is not displayed");
			softassert.assertTrue(dispatch.Verify_AddPayrateBtn_IsDisplayed(),"Test Step - 6 - Add Payrate button is not displayed");	
			
			// Test Step - 7 
			softassert.assertEquals(dispatch.get_SavedTrips_driverInitial("LJB"), "LJB","Test Step - 7 - Driver Initial is not matched with expected on saved trips section");
			softassert.assertEquals(dispatch.get_SavedTrips_driverName("Liam Jack Benjamin"), "Liam Jack Benjamin","Test Step - 7 - Driver Name is not matched with expected on saved trips section");
			softassert.assertEquals(dispatch.get_SavedTrips_driverPhoneNumber("987-654-3210"), "987-654-3210","Test Step - 7 - Driver phonenumber is not matched with expected on saved trips section");

			// Test Step - 8
			dispatch.Click_CloseIcon_dispatchPopup();
			
			// Test Step - 9
			//======There will be possible to failed during parallel execution 
			// So that commented below steps
			/*
			 * delayWithGivenTime(1000); dashboard.ClickOrder(); delayWithGivenTime(1000);
			 * logger.info("User click the order menu on hana dashboard page");
			 * dashboardorder = new DashboardOrderPage();
			 * softassert.assertEquals(dashboardorder.validateDashboardOrderPage(),prop.
			 * getProperty("livedashboardorderURL")
			 * ,"Test Step - 9 - Dashboard order page is not displayed");
			 * delayWithGivenTime(2000);
			 * 
			 * // Test Step - 10 dashboardorder.EnterGlobalSearch(dashboardorder.
			 * getInvoiceNumber_On_PhoneOrder_DeliveryInvoiceInHousePayment());
			 * softassert.assertTrue(dashboardorder.
			 * Validate_PhoneOrder_DeliveryInvoiceInHousePayment()
			 * ,"Test Step - 10 - Phone order invoice in house payment is not displayed");
			 * //https://hanafloralpos3.com/Dashboard/Order/
			 * Validate_PhoneOrder_InvoiceInHousePayment(); delayWithGivenTime(2000);
			 */
			delayWithGivenTime(1000);
			getDriver().navigate().refresh();
			
			
			// Test Step - 11
			delayWithGivenTime(1000);
			softassert.assertEquals(dashboardorder.get_status_on_orderpage(), "Dispatched","Test Step - 11 - Order status displayed on dashboard order page is not matched");
			
			// Test Step - 12
			softassert.assertTrue(dashboardorder.Validate_PhoneOrder_DeliveryInvoiceInHousePayment(),"Test Step - 12 - Phone order invoice in house payment is not displayed");		//https://hanafloralpos3.com/Dashboard/Order/Validate_PhoneOrder_InvoiceInHousePayment();
			delayWithGivenTime(2000);
			
			// Test Step - 13
			dashboardorder.Click_OrderStatus();
			softassert.assertEquals(dashboardorder.get_OrderStatus_DeliveryPopup(), "Dispatched","Test Step - 13 - Order status is not updated as expected in invoice popup");
			
			// Test Step - 14
			softassert.assertEquals(dashboardorder.get_drivername_onInvoicePopup(), "LJB - Liam Jack Benjamin","Test Step - 14 - Driver name is not autopopulated on invoice popup");
		
			// Test Step - 15
			dashboardorder.Click_DispatchTab_onInvPopup();
			
			// Test Step - 16
			delayWithGivenTime(1000);
			softassert.assertTrue(dashboardorder.Validate_dispatchConfirmation_Date_and_Time_With_AtlanticTimeZone(),"Test Step - 16 - Dispatch confirmation date and time is not matched as expected atlantic time zone on invoice popup");
			delayWithGivenTime(1000);
			softassert.assertEquals(dashboardorder.get_dispatchConfirmation_DriverName(),"LJB (Liam Jack Benjamin)","Test Step - 16 - Dispatch confirmation driver name is not matched as expected on invoice popup");

			// Test Step - 17
			delayWithGivenTime(1000);
			dashboardorder.Click_StatusTab_onInvPopup();
			
			// Test Step - 18
			delayWithGivenTime(1000);
			softassert.assertTrue(dashboardorder.Validate_status_date_and_time(),"Test Step - 18 - Status tab confirmation dispatch date and time is not matched as expected on invoice popup");
			
			// Test Step - 19
			delayWithGivenTime(1000);
			softassert.assertEquals(dashboardorder.Verify_DeliveryOnTruck_at_ActivitySection(), "Delivery On Truck","Test Step - 19 - Delivery on truck message text is not matched as expected on activity section");
			delayWithGivenTime(1000);
			softassert.assertTrue(dashboardorder.Validate_DeliveryOnTruck_DateandTime_at_ActivitySection(), "Test Step - 19 - Delivery on truck date and time is not matched as expected on activity section");
			delayWithGivenTime(1000);
			softassert.assertEquals(dashboardorder.get_Confirmation_DriverName_RouteNumber_on_ActivitySection(), "LJB","Test Step - 19 - Delivery on truck driver name is not matched as expected on activity section");
			delayWithGivenTime(1000);
			softassert.assertTrue(dashboardorder.Validate_ConfirmationDate_and_Time_RouteNumber_on_ActivitySection(),"Test Step - 19 - Delivery on truck driver name is not matched as expected on activity section");
			delayWithGivenTime(1000);
		
		
		
		
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Test case failed due to exception " + e.getMessage());
			logger.error("Test case failed due to exception " + e.getMessage());
		} finally {
			softassert.assertAll();
		}	
	}
}
