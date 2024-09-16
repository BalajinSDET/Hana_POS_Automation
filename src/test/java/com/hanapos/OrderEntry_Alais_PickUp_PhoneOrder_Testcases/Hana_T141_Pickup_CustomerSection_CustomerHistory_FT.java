package com.hanapos.OrderEntry_Alais_PickUp_PhoneOrder_Testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hanapos.pageObjects.DashboardOrderPage;
import com.hanapos.pageObjects.HanaDashBoardPage;
import com.hanapos.pageObjects.LoginPage;
import com.hanapos.pageObjects.OrderEntry_Alais_PhoneOrderPage;
import com.hanapos.pageObjects.Order_Confirmation_Page;
import com.hanapos.seleniumProjectBase.TestBaseClass;
import com.hanapos.utilities.CustomSoftAssert;

public class Hana_T141_Pickup_CustomerSection_CustomerHistory_FT extends TestBaseClass {
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private OrderEntry_Alais_PhoneOrderPage phoneorder;
	private DashboardOrderPage dashboardorder;
	private Order_Confirmation_Page orderconfirmationpage;
	String invoiceNumber;
	String invoice_Number;
	// ,dataProvider="fetch_Excel_Data"
	@Test(enabled = true, groups = { "Regression" })
	public void Validate_Hana_T141_Pickup_CustomerSection_CustomerHistory_Functionality_Test() {
		// SoftAssert softassert = new SoftAssert(); - I have modified this to use CustomSoftAssert
		CustomSoftAssert softassert = new CustomSoftAssert();
		
		logger.info("**** Starting Hana_T141_Pickup_CustomerSection_CustomerHistory_Functionality_Test  ****");
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
			phoneorder.SearchAndSelectCustomerOnCust_Section("Abish David");
			delayWithGivenTime(2000);
					
			// Test Step - 7
			delayWithGivenTime(1000);
			phoneorder.SelectReciCountry("United States");
			phoneorder.EnterReciPhone("956-655-0756");
			delayWithGivenTime(1000);
			phoneorder.SelectReciLocation("Church");
			delayWithGivenTime(1000);
			phoneorder.EnterDeliveryDateOnReciSection();
			delayWithGivenTime(2000);
			
			//Test Step - 8
			delayWithGivenTime(2000);
			phoneorder.SelectOccasion_On_OrderDetails_In_PhoneOrderPage("Birthday");
			phoneorder.EnterViewShortCode();			
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getSelectedOccasionOnPhoneOrderPage(),"Birthday","Test Step - 8 - Selected Occasion is not displayed on phone order page order details section");
			softassert.assertEquals(phoneorder.getEnteredViewShortCode(),"Happy Birthday! Hope you have an amazing day!","Test Step - 8 -Entered Short code is not displayed on phone order page order details section");
			delayWithGivenTime(2000);
		
			// Test Step - 9
			phoneorder.SearchandSelectItemcodeOnPhoneOrderPage("rrd","rrd-Red Rose Deluxe");
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getProdDetailsItemcode1OnPhoneOrderPage(),"rrd","Test Step - 9 - Item code is not displayed on phone order page product details section");
			softassert.assertEquals(phoneorder.getProdDetailsItemDescription1OnPhoneOrderPage(),"Red Rose Deluxe","Test Step - 9 - Item description is not displayed on phone order page product details section"); 
			softassert.assertEquals(phoneorder.getProdItemQty1OnPhoneOrderPage(),"1","Test Step - 9 - Item quantity is not displayed on phone order page product details section");
			delayWithGivenTime(1000);
			if(phoneorder.getUnitPriceOnProdDetails()=="299.00"){ 
				softassert.assertEquals(phoneorder.getUnitPriceOnProdDetails(),"299.00","Test Step - 9 - Item price is not displayed on phone order page product details section");
			}else if (phoneorder.getUnitPriceOnProdDetails()=="309.00") {
				softassert.assertEquals(phoneorder.getUnitPriceOnProdDetails(),"309.00","Test Step - 9 - Item price is not displayed on phone order page product details section");
			}
						
			// Test Step - 10
			delayWithGivenTime(2000);
			phoneorder.SelectPaymentTypeOnPhoneOrderPage_PaymentSection("Cash");
			delayWithGivenTime(1000);
			softassert.assertEquals(phoneorder.getDisplayedPaymentTypeSelectedOption(),"Cash","Test Step - 10 - Selected Payment type is not displayed on phone order page payment section");
			delayWithGivenTime(1000);
			phoneorder.EnterCashAmount();
			delayWithGivenTime(1000);
			phoneorder.SelectCashRegistry_On_CashPaymentType("Cash Register2");
			phoneorder.ClickPlaceOrderButton();
			delayWithGivenTime(2000);
			getDriver().switchTo().activeElement();
			softassert.assertTrue(phoneorder.VerifyConfirmationPopupOnPhoneOrderPage(), "Test Step - 10 - Confirmation popup is not displayed on phone order page");
			delayWithGivenTime(2000);
			
			// Test Step - 11
			phoneorder.ClickCancelButton_On_ConfirmationPopup();
			
			// Test Step - 12
			delayWithGivenTime(1000);
			phoneorder.ClickPlaceOrderButton();
			delayWithGivenTime(1000);
			softassert.assertTrue(phoneorder.VerifyConfirmationPopupOnPhoneOrderPage(), "Test Step - 12 - Confirmation popup is not displayed on phone order page");
			delayWithGivenTime(1000);
			
			// Test Step - 13
			phoneorder.ClickSubmitButton_On_ConfirmationPopup();
			delayWithGivenTime(2000);
			orderconfirmationpage = new Order_Confirmation_Page();
			softassert.assertTrue(orderconfirmationpage.VerifyOrderConfirmationPage(), "Test Step - 13 - Order confirmation page is not displayed");
			
			// Test Step - 14	
			invoiceNumber = orderconfirmationpage.get_invoiceNumber_on_OrderConfirmation_Page();
			delayWithGivenTime(500);
			
			
			
			//	Above is pre - requiste to set previously created customer history.
			//================================================================
			
			
			// Test Step - 3
			delayWithGivenTime(2000);
			softassert.assertTrue(dashboard.VerifyOrderEntryOptionIsDisplayed(),
					"Test Step - 3 : Order entry option is not displayed");
			softassert.assertTrue(dashboard.Verify_Cashandcarry_OptionIsDisplayed(),
					"Test Step - 3 : Cash and carry option is not displayed");

			// Test Step - 4
			dashboard.ClickOrderEntry();
			logger.info("User hover the mouse on New order and clicked on order entry");

			// Test Step - 5
			phoneorder = new OrderEntry_Alais_PhoneOrderPage();
			softassert.assertTrue(phoneorder.VerifyCustSectionAppears(),
					"Test Step - 5 - Customer section is not displayed on phone order page");

			// Test Step - 6
			phoneorder.ClickPickupTypeOnPhoneOrderPage();
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getHighlightedColorOnPickupTypeOnPhoneOrderPage(), "#2f9bc8",
					"Test Step - 6 - Pickup type is not highlighted in blue color");

			// Test Step - 7
			delayWithGivenTime(1000);
			phoneorder.Select_SalesPersonOn_PhoneOrderEntryPage("Stuart Markwood");

			phoneorder.SearchAndSelectCustomerOnCust_Section("Abish");
			delayWithGivenTime(1000);
			softassert.assertEquals(phoneorder.getFirstnameOnPhoneOrderPage(), "Abish",
					"Test Step - 7 - First name is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getLastnameOnPhoneOrderPage(), "David",
					"Test Step - 7 - Last name is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getCompanyNameOnPhoneOrderPage(), "Hana_Sisterchicks",
					"Test Step - 7 - Company name is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getEmailIdOnPhoneOrderPage(), "hanaposqateam@gmail.com",
					"Test Step - 7 - email id is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getAddress1OnPhoneOrderPage(), "3402 Park Blvd",
					"Test Step - 7 - address 1 is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getAddress2OnPhoneOrderPage(), "",
					"Test Step - 7 - Address 2 is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getZipCodeOnPhoneOrderPage(), "92103",
					"Test Step - 7 - Zipcode is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getCityOnPhoneOrderPage(), "San Diego",
					"Test Step - 7 - city is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getPhoneNumberOnPhoneOrderPage(), "956-655-0756",
					"Test Step - 7 - phone number 1 is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getAltPhoneNumberOnPhoneOrderPage(), "956-655-0756",
					"Test Step - 7 - Alt phone number is not displayed on phone order page");
			delayWithGivenTime(2000);

			// Test Step - 8
			phoneorder.Click_CustomerHistory_OnCustomerDetailsSection();
			delayWithGivenTime(1000);
			softassert.assertTrue(phoneorder.Verify_CustomerHistoryPopupAppears_OnCustomerDetailsSection(),
					"Test Step - 8 - Customer history icon popup is not displayed on phone order page");

			// Test Step - 9
			delayWithGivenTime(1000);
			phoneorder.Click_PreviousOrder_OnCustomerHistoryPopup(invoiceNumber);
			delayWithGivenTime(4000);

			// Test Step - 10
			softassert.assertEquals(phoneorder.getDisplayedPaymentTypeSelectedOption(), "Cash",
					"Test Step - 10 - Previous Selected Payment type is not displayed on phone order page payment section");

			// Test Step - 11
			softassert.assertEquals(phoneorder.getReciFirstName(), "Abish",
					"Test Step - 11 - Entered first name is not displayed on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciLastName(), "David",
					"Test Step - 11 - Entered last name is not displayed on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciAddress1(), "114 N CHURCH ST",
					"Test Step - 11 - Entered address 1 is not displayed on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciAddress2(), "PICK UP",
					"Test Step -11 - Entered address 2 is not displayed on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciZipcode(), "63084",
					"Test Step - 11 - Entered zipcode is not displayed on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciCity(), "UNION",
					"Test Step - 11 - Entered city is not displayed on phone order page recipient section");
			softassert.assertEquals(phoneorder.getSelectedCountryOnReciCountry(), "United States",
					"Test Step - 11 - Selected country is not displayed on phone order page recipient section");
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getSelectedLocationOnReciLocation(), "Church",
					"Test Step - 11 - Recipient location is not displayed on phone order page recipient section");
			softassert.assertEquals(phoneorder.getDeliveryDateOnReciSection(), CurrentDate(),
					"Test Step - 11 - Delivery date is not displayed on phone order page recipient section");

			// Test Step - 12
			softassert.assertEquals(phoneorder.getProdDetailsItemcode1OnPhoneOrderPage(), "rrd",
					"Test Step - 12 - Item code is not displayed on phone order page product details section");
			softassert.assertEquals(phoneorder.getProdDetailsItemDescription1OnPhoneOrderPage(), "Red Rose Deluxe",
					"Test Step - 12 - Item description is not displayed on phone order page product details section");
			softassert.assertEquals(phoneorder.getProdItemQty1OnPhoneOrderPage(), "1.00",
					"Test Step - 12 - Item quantity is not displayed on phone order page product details section");
			softassert.assertEquals(phoneorder.getUnitPriceOnProdDetails(), "299.00",
					"Test Step - 12 - Item price is not displayed on phone order page product details section");

			// Test Step - 13
			softassert.assertEquals(phoneorder.getSelectedOccasionOnPhoneOrderPage(), "Birthday",
					"Test Step - 13 - Selected Occasion is not displayed on phone order page order details section");
			softassert.assertEquals(phoneorder.getEnteredViewShortCode(),
					"Happy Birthday! Hope You Have An Amazing Day!",
					"Test Step - 13 -Entered Short code is not displayed on phone order page order details section");

			// Test Step - 14
			softassert.assertEquals(phoneorder.getHighlightedColorOnPickupTypeOnPhoneOrderPage(), "#2f9bc8",
					"Test Step - 14 - Pickup type is not highlighted in blue color");

			// Test Step - 15			
			delayWithGivenTime(1000);
			softassert.assertEquals(phoneorder.getDisplayedPaymentTypeSelectedOption(),"Cash","Test Step - 10 - Selected Payment type is not displayed on phone order page payment section");
			
			delayWithGivenTime(1000);
			phoneorder.EnterCashAmount();
			delayWithGivenTime(1000);
			softassert.assertEquals(phoneorder.get_Entered_CashPaymentType_Amount(), phoneorder.get_Entered_CashPaymentType_Amount(),"Test Step - 10 - Cash payment amount is not displayed on phone order page payment section");
			phoneorder.Click_PlaceOrder_Button();
			softassert.assertTrue(phoneorder.VerifyConfirmationPopupOnPhoneOrderPage(), "Test Step - 10 - Confirmation popup is not displayed on phone order page");

			phoneorder.ClickSubmitButton_On_ConfirmationPopup();
			delayWithGivenTime(1000);

			orderconfirmationpage = new Order_Confirmation_Page();
			softassert.assertTrue(orderconfirmationpage.VerifyOrderConfirmationPage(), "Test Step - 15 - Order confirmation page is not displayed");
			delayWithGivenTime(500);
			invoice_Number = orderconfirmationpage.get_invoiceNumber_on_OrderConfirmation_Page();

			
			// Test Step - 16
			delayWithGivenTime(2000);
			dashboard.ClickOrder();
			delayWithGivenTime(1000);
			logger.info("User click the order menu on hana dashboard page");
			dashboardorder = new DashboardOrderPage();
			softassert.assertEquals(dashboardorder.validateDashboardOrderPage(),
					prop.getProperty("livedashboardorderURL"),
					"Test Step - 16 - Dashboard order page is not displayed");

			// Test Step - 17
			delayWithGivenTime(1000);
			dashboardorder.EnterGlobalSearch(invoice_Number);//dashboardorder.get_InvoiceNumber_PhoneOrder_PickUp_Cash()
			delayWithGivenTime(1000);			
			softassert.assertTrue(dashboardorder.Validate_PhoneOrder_Pickup_Cash_InvoiceNumber(),"Test Step - 17 - Phone order invoice is not displayed");			

		} catch (Exception e) {
			e.printStackTrace();
			softassert.fail();
		} finally {
			softassert.assertAll();
		}
	}
}