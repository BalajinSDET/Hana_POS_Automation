package com.hanapos.OrderEntry_Alais_DeliveryType_PhoneOrder_Testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.hanapos.pageObjects.HanaDashBoardPage;
import com.hanapos.pageObjects.LoginPage;
import com.hanapos.pageObjects.OrderEntry_Alais_PhoneOrderPage;
import com.hanapos.pageObjects.Order_Confirmation_Page;
import com.hanapos.seleniumProjectBase.TestBaseClass;
import com.hanapos.utilities.CustomSoftAssert;
import com.hanapos.utilities.ExtentReportManager;

public class Hana_T329_OrderEntryPage_Delivery_CustomerSection_Edit_Customer_CustomerDetails_PaymentDetails_Pay_Date_Search_Filter_Functionality extends TestBaseClass {
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private OrderEntry_Alais_PhoneOrderPage phoneorder;
	private Order_Confirmation_Page orderconfirmationpage;
	String invoiceNumber;

	// SoftAssert softassert = new SoftAssert(); //- I have modified this to use CustomSoftAssert
	CustomSoftAssert softassert = new CustomSoftAssert();
	
	@Test(enabled=true,groups= {"Regression"},description="This test case is used to validate the cash and carry Check Payment Section functionality") 
	public void Validate_Hana_T329_OrderEntryPage_Delivery_CustomerSection_Edit_Customer_CustomerDetails_PaymentDetails_Pay_Date_Search_Filter_Functionality_Test() {
		ExtentTest test = ExtentReportManager.createTest("Phone order delivery type Customer Section Edit Customer CustomerDetails PaymentDetails Pay Date Search Filter functionality Test", "This test case is used to validate the Phone order delivery customer Section Edit Customer CustomerDetails PaymentDetails Pay Date Search Filter functionality");	
		test.log(Status.INFO, "**** Starting Hana_T329_OrderEntryPage_Delivery_CustomerSection_Edit_Customer_CustomerDetails_PaymentDetails_Pay_Date_Search_Filter_Functionality  ****");
		logger.debug("capturing application debug logs....");
		try {
			// Test Step - 1
			lp = new LoginPage();
			softassert.assertTrue(lp.LoginPageIsDisplayed(),"Test Step - 1 : Login page is not displayed");
			logger.info("User on the hana pos login page");
			test.log(Status.PASS, "User on the hana pos login page successfully");
			
			// Test Step - 2
			lp.EnterUserName(prop.getProperty("username"));
			logger.info("User entered the username as "+prop.getProperty("username"));
			test.log(Status.PASS, "User entered the username as "+prop.getProperty("username") + " successfully");
			
			lp.EnterPassword(prop.getProperty("password"));
			logger.info("User entered the password as "+prop.getProperty("password"));
			test.log(Status.PASS, "User entered the password as "+prop.getProperty("password") + " successfully");
			
			lp.ClickLoginButton();
			logger.info("User clicked on Login button");
			test.log(Status.PASS, "User clicked on Login button successfully");
			
			dashboard = new HanaDashBoardPage();
			softassert.assertTrue(dashboard.VerifyHanaDashBoardPage(),"Test Step - 2 : Hana dashboard page is not displayed");
			logger.info("User navigated to hana dashboard page");
			test.log(Status.PASS, "User navigated to hana dashboard page successfully");		
			
			dashboard.SelectShopNameDropDown(prop.getProperty("shopname"));
			logger.info("User select the shopname on dashbaord page as "+prop.getProperty("shopname"));
			test.log(Status.PASS, "Test Step - 2 - User select the shopname on dashbaord page as "+prop.getProperty("shopname") + " successfully");
			
			
			// Test Step - 3
			delayWithGivenTime(2000);
			softassert.assertTrue(dashboard.VerifyOrderEntryOptionIsDisplayed(),"Test Step - 3 : Order entry option is not displayed");
			softassert.assertTrue(dashboard.Verify_Cashandcarry_OptionIsDisplayed(),"Test Step - 3 : Cash and carry option is not displayed");
			test.log(Status.PASS, "Test Step - 3 - User verified the order entry option and cash and carry option is displayed on New order dropdown ");
			
			// Pre- requiste

			// Test Step - 4
			dashboard.ClickOrderEntry();
			logger.info("User hover the mouse on New order and clicked on order entry");
			test.log(Status.PASS, "Test Step - 4 - User hover the mouse on New order and clicked on order entry successfully");
			
			// Test Step - 5
			phoneorder = new OrderEntry_Alais_PhoneOrderPage();
			phoneorder.ClickdeliveryTypeOnPhoneOrderPage();
			test.log(Status.PASS, "User clicked on delivery type on phone order page successfully");
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.get_HighlightedColor_OnDelivery_TypeOnPhoneOrderPage(),"#676a6c", "Test Step - 5 - Delivery type is not highlighted in blue color");		
			test.log(Status.PASS, "Test Step - 5 - Delivery type is highlighted in blue color successfully");
			
			// Test Step - 6
			phoneorder.Select_SalesPersonOn_PhoneOrderEntryPage(prop.getProperty("salesperson"));
			test.log(Status.PASS, "User selected the sales person on phone order page as "+prop.getProperty("salesperson"));
			phoneorder.SearchAndSelectCustomerOnCust_Section(prop.getProperty("cust_firstName"));
			test.log(Status.PASS, "User search and selected the customer on phone order page as "+prop.getProperty("cust_firstName"));
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
			test.log(Status.PASS, "Test Step - 6 - All the customer details are displayed on phone order page successfully");
			
			
			// Test Step - 7
			phoneorder.EnterReciFirstName("Abish");
			phoneorder.EnterReciLastName("David");
			phoneorder.EnterReciAddress1("3402 Park Blvd");
			phoneorder.EnterReciAddress2("PICK UP");
			phoneorder.EnterReciZipcode("92103");
			delayWithGivenTime(1000);
			//phoneorder.EnterReciCity(recicity);
			phoneorder.SelectReciCountry("United States");
			phoneorder.EnterReciPhone("956-655-0756");
			delayWithGivenTime(1000);
			phoneorder.SelectReciLocation("Church");
			delayWithGivenTime(1000);
			phoneorder.EnterDeliveryDateOnReciSection(CurrentDate());
			test.log(Status.PASS, "User entered the all the recipient details on phone order page successfully");
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
			test.log(Status.PASS, "Test Step - 7 - User verified all the recipient details are displayed on phone order page successfully");
			
			//Test Step - 8
			phoneorder.SelectOccasion_On_OrderDetails_In_PhoneOrderPage("Birthday");
			test.log(Status.PASS, "User selected the Occasion on phone order page successfully");
			phoneorder.EnterViewShortCode();			
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getSelectedOccasionOnPhoneOrderPage(),"Birthday","Test Step - 8 - Selected Occasion is not displayed on phone order page order details section");
			softassert.assertEquals(phoneorder.getEnteredViewShortCode(),"Happy Birthday! Hope you have an amazing day!","Test Step - 8 -Entered Short code is not displayed on phone order page order details section");
			test.log(Status.PASS, "Test Step - 8 - User verified all the order details are displayed on phone order page successfully");
			delayWithGivenTime(2000);
		
			// Test Step - 9
			phoneorder.SearchandSelectItemcodeOnPhoneOrderPage("rrd","rrd-Red Rose Deluxe");
			test.log(Status.PASS, "User search and selected with item code on phone order page successfully");
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getProdDetailsItemcode1OnPhoneOrderPage(),"rrd","Test Step - 9 - Item code is not displayed on phone order page product details section");
			softassert.assertEquals(phoneorder.getProdDetailsItemDescription1OnPhoneOrderPage(),"Red Rose Deluxe","Test Step - 9 - Item description is not displayed on phone order page product details section"); 
			softassert.assertEquals(phoneorder.getProdItemQty1OnPhoneOrderPage(),"1","Test Step - 9 - Item quantity is not displayed on phone order page product details section");
			
			if(phoneorder.getUnitPriceOnProdDetails()=="299.00"){ 
				softassert.assertEquals(phoneorder.getUnitPriceOnProdDetails(),"299.00","Test Step - 9 - Item price is not displayed on phone order page product details section");
			}else if (phoneorder.getUnitPriceOnProdDetails()=="309.00") {
				softassert.assertEquals(phoneorder.getUnitPriceOnProdDetails(),"309.00","Test Step - 9 - Item price is not displayed on phone order page product details section");
			}

			test.log(Status.PASS, "Test Step - 9 - User verified all the product details are displayed on phone order page successfully");
			delayWithGivenTime(2000);			
			
			// Test Step - 10			
			// Invoice/House Account - payment method
			phoneorder.SelectPaymentTypeOnPhoneOrderPage_PaymentSection("Invoice/House Account");
			test.log(Status.PASS, "User selected the payment type on phone order page successfully");
			delayWithGivenTime(1000);
			softassert.assertEquals(phoneorder.get_SelectedPaymentType_OnPhoneOrderPage(),"Invoice/House Account", "Test Step - 10 - Selected payment type is not displayed");
			test.log(Status.PASS, "Test Step - 10 - User verified selected payment type is displayed on phone order page successfully");
			
			// Test Step - 11
			softassert.assertTrue(phoneorder.Verify_PO_NumberField_IsDisplayed_On_InvoiceHouseAccount_PaymentSection(),"Test Step - 11 - Po Number field is not displayed on invoice house account payment section");
			test.log(Status.PASS, "Test Step - 11 - User verified Po Number field is displayed on phone order page successfully");
			softassert.assertTrue(phoneorder.Verify_Payment_TermsField_IsDisplayed_On_InvoiceHouseAccount_PaymentSection(),"Test Step - 11 - payment terms field is not displayed on invoice house account payment section");
			test.log(Status.PASS, "Test Step - 11 - User verified payment terms field is displayed on phone order page successfully");
			
			// Test Step - 12
			phoneorder.ClickPlaceOrderButton();
			test.log(Status.PASS, "User clicked on place order button on phone order page successfully");
			softassert.assertTrue(phoneorder.VerifyConfirmationPopupOnPhoneOrderPage(), "Test Step - 12 - Confirmation popup is not displayed on phone order page");
			test.log(Status.PASS, "Test Step - 12 - User verified confirmation popup is displayed on phone order page successfully");
			delayWithGivenTime(2000);
			
			// Test Step - 13
			phoneorder.ClickSubmitButton_On_ConfirmationPopup();
			delayWithGivenTime(2000);
			test.log(Status.PASS, "User clicked on submit button on confirmation popup on phone order page successfully");
			orderconfirmationpage = new Order_Confirmation_Page();
			softassert.assertTrue(orderconfirmationpage.VerifyOrderConfirmationPage(), "Test Step - 13 - Order confirmation page is not displayed");
			test.log(Status.PASS, "Test Step - 13 - User verified order confirmation page is displayed successfully");
			delayWithGivenTime(500);
			invoiceNumber = orderconfirmationpage.get_invoiceNumber_on_OrderConfirmation_Page();
	
			dashboard.ClickOnHomeIcon();
			
			// Test Step - 3
			delayWithGivenTime(2000);
			softassert.assertTrue(dashboard.VerifyOrderEntryOptionIsDisplayed(),"Test Step - 3 : Order entry option is not displayed");
			softassert.assertTrue(dashboard.Verify_Cashandcarry_OptionIsDisplayed(),"Test Step - 3 : Cash and carry option is not displayed");
			test.log(Status.PASS, "Test Step - 3 - User verified order entry option is displayed successfully");
			
			// Test Step - 4
			dashboard.ClickOrderEntry();
			logger.info("User hover the mouse on New order and clicked on order entry");
			test.log(Status.PASS, "User clicked on order entry successfully");
			
			// Test Step - 5
			phoneorder = new OrderEntry_Alais_PhoneOrderPage();
			phoneorder.ClickdeliveryTypeOnPhoneOrderPage();
			test.log(Status.PASS, "User clicked on delivery type on phone order page successfully");
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.get_HighlightedColor_OnDelivery_TypeOnPhoneOrderPage(),"#676a6c", "Test Step - 5 - Delivery type is not highlighted in blue color");		
			test.log(Status.PASS, "Test Step - 5 - User verified delivery type is highlighted in blue color successfully");
			
			//Test Step - 6
			delayWithGivenTime(2000);
			phoneorder.SearchAndSelectCustomerOnCust_Section(prop.getProperty("cust_firstName"));
			test.log(Status.PASS, "User searched and selected customer on customer section successfully");
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
			test.log(Status.PASS, "Test Step - 6 - User verified customer details on phone order page successfully");
					
			// Test Step - 7	
			softassert.assertTrue(phoneorder.Verify_CustEditIcon_Appears(), "Test Step - 7 - Customer edit icon on phone order page is not displayed");
			test.log(Status.PASS, "Test Step - 7 - User verified customer edit icon is displayed successfully");
			
			// Test Step - 8
			phoneorder.Click_CustEditIcon();
			test.log(Status.PASS, "User clicked on customer edit icon successfully");
			softassert.assertTrue(phoneorder.Verify_CustomerDetailsPopupAppears(), "Test Step - 8 - Customer details popup on is not displayed on phone order page");			
			test.log(Status.PASS, "Test Step - 8 - User verified customer details popup is displayed successfully");
			
			// Test Step - 9
			delayWithGivenTime(1000);
			phoneorder.ClickOn_PaymentDetails_CustomerDetailsPopup();
			test.log(Status.PASS, "User clicked on payment details tab successfully");
			ThreadWait(4000);
			softassert.assertTrue(phoneorder.Verify_TableGridOnPaymentDetailsTab_IsAppear(), "Test Step - 9 - payment details tab webtable grid is not displayed");		
			test.log(Status.PASS, "Test Step - 9 - User verified payment details tab web table grid is displayed successfully");
			
			// Test Step - 10
			ThreadWait(1000);			
			phoneorder.Enter_PayDateSearchBox_OnPaymentDetailsTab(CurrentDate());
			test.log(Status.PASS, "User entered pay date on payment details tab successfully");
			softassert.assertEquals(phoneorder.get_PayDate_Paymentdetailstab(), CurrentDate(),"Test Step - 10 - Entered date value on date picker input box field is not displayed");
			test.log(Status.PASS, "Test Step - 10 - User verified pay date is displayed on payment details tab successfully");
			
			// Test Step - 11			
			RobotPressEnter();
			test.log(Status.PASS, "User pressed enter key successfully");
			softassert.assertTrue(phoneorder.Verify_PayDate_Paymentdetailstab(CurrentDate()),"Test Step - 11 - Filtered Pay date is not displayed on the payment details tab at customer details popup");
			test.log(Status.PASS, "Test Step - 11 - User verified filtered pay date is displayed on payment details tab successfully");
			
			// Test Step - 12
			phoneorder.Enter_PayDateSearchBox_OnPaymentDetailsTab(CurrentDate());
			test.log(Status.PASS, "User entered pay date on payment details tab successfully");
			
			// Test Step - 13
			RobotPressEnter();
			test.log(Status.PASS, "User pressed enter key successfully");
			softassert.assertTrue(phoneorder.Verify_PayDate_Paymentdetailstab(CurrentDate()),"Test Step - 13 - Filtered Pay Date is not displayed on the payment details tab at customer details popup");
			test.log(Status.PASS, "Test Step - 13 - User verified filtered pay date is displayed on payment details tab successfully");
			
			// Test Step - 14
			phoneorder.Enter_PayDateSearchBox_OnPaymentDetailsTab("13/32/20200");
			test.log(Status.PASS, "User entered invalid pay date on payment details tab successfully");
			RobotPressEnter();
			softassert.assertEquals(phoneorder.get_PayDate_Paymentdetailstab(), "","Test Step - 14 - Entered invalid date value on date picker input box field is not removed");
			
			if(phoneorder.get_PayDate_Paymentdetailstab()=="") {
				test.log(Status.PASS, "Test Step - 14 - User verified invalid pay date is removed on displayed on payment details tab successfully");
			}else {
				test.log(Status.FAIL, "Test Step - 14 - User verified invalid pay date is not displayed on payment details tab successfully");

			}
			// Test Step - 15			
			phoneorder.Enter_PayDateSearchBox_OnPaymentDetailsTab(phoneorder.NextDate());	
			test.log(Status.PASS, "User entered future pay date on payment details tab successfully");
			RobotPressEnter();
			test.log(Status.PASS, "User pressed enter key successfully");
			softassert.assertTrue(phoneorder.Verify_NoCustomerPaymentsFound_PaymentDetailsTab(),"Test Step - 15 - Filtered future Pay Date is not displayed message as No Customer Payments Found on the payment details tab at customer details popup");			
			test.log(Status.PASS, "Test Step - 15 - User verified filtered future pay date is displayed on payment details tab successfully");
			
			// Test Step - 16
			softassert.assertTrue(phoneorder.Verify_PayDateSearchBox_ClearButton_Appears(),"Test Step - 16 - Clear button in Pay Date search box is not displayed");
			test.log(Status.PASS, "Test Step - 16 - User verified clear button is displayed on payment details tab successfully");
			
			// Test Step - 17
			phoneorder.Click_PayDateSearchBox_ClearButton();
			test.log(Status.PASS, "User clicked on clear button successfully");
			softassert.assertEquals(phoneorder.get_PayDate_Paymentdetailstab(), "","Test Step - 17 - In Pay Date searchbox entered data is not cleared");
			test.log(Status.PASS, "Test Step - 17 - User verified in Pay Date searchbox entered data is cleared successfully");
			
			// Test Step - 18
			softassert.assertTrue(phoneorder.Verify_FilterIconOptions_PayDateOnPaymentDetailsTab_OnCustomerDetailsPopup(),"Test Step - 18 - Filter icon on pay date it does not displayed the options");
			test.log(Status.PASS, "Test Step - 18 - User verified filter icon is displayed on payment details tab successfully");
			
			// Test Step - 19 
			phoneorder.Click_CalendarIconOnPayDate_OnPaymentDetailsTab();
			test.log(Status.PASS, "User clicked on calendar icon on pay date on payment details tab successfully");
			delayWithGivenTime(1000);
			phoneorder.SelectTheDate_FromDatePickerIcon_OnPaymentDetailsTab();
			test.log(Status.PASS, "User selected date from date picker on payment details tab successfully");
			delayWithGivenTime(1000);
			phoneorder.Click_FilterIconOptions_PayDateOnPaymentDetailsTab_OnCustomerDetailsPopup();
			delayWithGivenTime(1000);
			test.log(Status.PASS, "User clicked on filter icon on pay date on payment details tab successfully");
			phoneorder.Click_FilterIconOptions_PayDateOnPaymentDetailsTab_OnCustomerDetailsPopup("Is equal to");
			delayWithGivenTime(1000);
			test.log(Status.PASS, "User selected filter option on pay date on payment details tab successfully");
			softassert.assertTrue(phoneorder.Verify_PayDate_Paymentdetailstab(CurrentDate()),"Test Step - 19 - Filtered Pay date is not displayed on the payment details tab at customer details popup");
			test.log(Status.PASS, "Test Step - 19 - User verified filtered pay date is displayed on payment details tab successfully");
			
			// Test Step - 20
			phoneorder.Click_FilterIconOptions_PayDateOnPaymentDetailsTab_OnCustomerDetailsPopup("Is not equal to");
			delayWithGivenTime(1000);
			test.log(Status.PASS, "User selected filter option on pay date on payment details tab successfully");
			softassert.assertFalse(phoneorder.Verify_PayDate_Paymentdetailstab(CurrentDate()),"Test Step - 20 - Based on selecting the filter option pay date is not displayed on the payment details tab at customer details popup");
			test.log(Status.PASS, "Test Step - 20 - User verified filtered pay date is not displayed on payment details tab successfully");
			
			// Test Step - 21
			phoneorder.Click_FilterIconOptions_PayDateOnPaymentDetailsTab_OnCustomerDetailsPopup("Is after or equal to");
			delayWithGivenTime(1000);
			test.log(Status.PASS, "User selected filter option on pay date on payment details tab successfully");
			softassert.assertTrue(phoneorder.Verify_PayDate_Paymentdetailstab(CurrentDate()),"Test Step - 21 - Based on selecting the filter option pay date is not displayed on the payment details tab at customer details popup");
			test.log(Status.PASS, "Test Step - 21 - User verified filtered pay date is displayed on payment details tab successfully");
			
			// Test Step - 22
			phoneorder.Click_FilterIconOptions_PayDateOnPaymentDetailsTab_OnCustomerDetailsPopup("Is after");
			delayWithGivenTime(1000);
			test.log(Status.PASS, "User selected filter option on pay date on payment details tab successfully");
			/*if(phoneorder.Verify_NoCustomerPaymentsFound_PaymentDetailsTab()==true) {
			softassert.assertTrue(phoneorder.Verify_NoCustomerPaymentsFound_PaymentDetailsTab(),"Test Step - 22 - Based on selecting the filter option pay date not displayed No Payment Customer found message on the payment details tab at customer details popup");
			}else {*/
			softassert.assertTrue(phoneorder.Verify_PayDate_Paymentdetailstab(CurrentDate()),"Test Step - 22 - Based on selecting the filter option pay date is not displayed on the payment details tab at customer details popup");
			test.log(Status.PASS, "Test Step - 22 - User verified filtered pay date is displayed on payment details tab successfully");
			//	}
			
			// Test Step - 23
			phoneorder.Click_FilterIconOptions_PayDateOnPaymentDetailsTab_OnCustomerDetailsPopup("Is before or equal to");
			delayWithGivenTime(1000);
			test.log(Status.PASS, "User selected filter option on pay date on payment details tab successfully");
			softassert.assertTrue(phoneorder.Verify_PayDate_Paymentdetailstab(CurrentDate()),"Test Step - 23 - Based on selecting the filter option pay date is not displayed on the payment details tab at customer details popup");	
			test.log(Status.PASS, "Test Step - 23 - User verified filtered pay date is displayed on payment details tab successfully");
			
			// Test Step - 24
			phoneorder.Click_PayDateSearchBox_ClearButton();
			test.log(Status.PASS, "User clicked on clear button on pay date searchbox successfully");
			softassert.assertEquals(phoneorder.get_PayDate_Paymentdetailstab(), "","Test Step - 24 - In Pay Date searchbox entered data is not cleared");
			test.log(Status.PASS, "Test Step - 24 - User cleared data in pay date searchbox successfully");
			test.log(Status.INFO, "**** Starting Hana T329 Delivery type Order Entry Page Customer Section Edit Customer Customer Details Payment Details Pay Date Search Filter Functionality Test ****");

			} catch (Exception e) {
			e.printStackTrace();
			softassert.fail();
		} finally {
			softassert.assertAll();
		}
	}
}