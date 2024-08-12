package com.hanapos.OrderEntry_Alais_PickUp_PhoneOrderTest;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hanapos.pageObjects.DashboardOrderPage;
import com.hanapos.pageObjects.HanaDashBoardPage;
import com.hanapos.pageObjects.LoginPage;
import com.hanapos.pageObjects.OrderEntry_Alais_PhoneOrderPage;

import com.hanapos.seleniumProjectBase.TestBaseClass;

public class Hana_T141_Pickup_CustomerSection_CustomerHistory_FT extends TestBaseClass {
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private OrderEntry_Alais_PhoneOrderPage phoneorder;
	private DashboardOrderPage dashboardorder;

	// ,dataProvider="fetch_Excel_Data"
	@Test(enabled = true, groups = { "Regression" })
	public void Validate_Hana_T141_Pickup_CustomerSection_CustomerHistory_Functionality_Test() {
		SoftAssert softassert = new SoftAssert();
		logger.info("**** Starting Hana_T141_Pickup_CustomerSection_CustomerHistory_Functionality_Test  ****");
		logger.debug("capturing application debug logs....");
		try {
			// Test Step - 1
			lp = new LoginPage();
			softassert.assertTrue(lp.LoginPageIsDisplayed(), "Test Step - 1 : Login page is not displayed");
			logger.info("User on the hana pos login page");

			// Test Step - 2
			lp.EnterUserName(prop.getProperty("username"));
			logger.info("User entered the username as " + prop.getProperty("username"));
			lp.EnterPassword(prop.getProperty("password"));
			logger.info("User entered the password as " + prop.getProperty("password"));
			lp.ClickLoginButton();
			logger.info("User clicked on Login button");

			dashboard = new HanaDashBoardPage();
			softassert.assertTrue(dashboard.VerifyHanaDashBoardPage(),
					"Test Step - 2 : Hana dashboard page is not displayed");
			logger.info("User navigated to hana dashboard page");
			dashboard.SelectShopNameDropDown(prop.getProperty("shopname"));
			logger.info("User select the shopname on dashbaord page as " + prop.getProperty("shopname"));

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
			phoneorder.Click_PreviousOrder_OnCustomerHistoryPopup("9038000");
			delayWithGivenTime(3000);

			// Test Step - 10
			softassert.assertEquals(phoneorder.getDisplayedPaymentTypeSelectedOption(), "Cash",
					"Test Step - 10 - Previous Selected Payment type is not displayed on phone order page payment section");

			// Test Step - 11
			delayWithGivenTime(2000);
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
			softassert.assertEquals(phoneorder.getDeliveryDateOnReciSection(), "",
					"Test Step - 11 - Delivery date is not displayed on phone order page recipient section");

			// Test Step - 12
			softassert.assertEquals(phoneorder.getProdDetailsItemcode1OnPhoneOrderPage(), "rrd",
					"Test Step - 9 - Item code is not displayed on phone order page product details section");
			softassert.assertEquals(phoneorder.getProdDetailsItemDescription1OnPhoneOrderPage(), "Red Rose Deluxe",
					"Test Step - 9 - Item description is not displayed on phone order page product details section");
			softassert.assertEquals(phoneorder.getProdItemQty1OnPhoneOrderPage(), "1.00",
					"Test Step - 9 - Item quantity is not displayed on phone order page product details section");
			softassert.assertEquals(phoneorder.getUnitPriceOnProdDetails(), "299.00",
					"Test Step - 9 - Item price is not displayed on phone order page product details section");

			// Test Step - 13
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getSelectedOccasionOnPhoneOrderPage(), "Birthday",
					"Test Step - 8 - Selected Occasion is not displayed on phone order page order details section");
			softassert.assertEquals(phoneorder.getEnteredViewShortCode(),
					"Happy Birthday! Hope You Have An Amazing Day!",
					"Test Step - 8 -Entered Short code is not displayed on phone order page order details section");

			// Test Step - 14
			softassert.assertEquals(phoneorder.getHighlightedColorOnPickupTypeOnPhoneOrderPage(), "#2f9bc8",
					"Test Step - 6 - Pickup type is not highlighted in blue color");

			// Test Step - 15
			delayWithGivenTime(1000);
			phoneorder.EnterDeliveryDateOnReciSection();
			phoneorder.SelectPaymentTypeOnPhoneOrderPage_PaymentSection("Cash");
			delayWithGivenTime(1000);
			softassert.assertEquals(phoneorder.getDisplayedPaymentTypeSelectedOption(), "Cash",
					"Test Step - 10 - Selected Payment type is not displayed on phone order page payment section");
			delayWithGivenTime(2000);
			phoneorder.EnterCashAmount();
			phoneorder.SelectCashRegistry_On_CashPaymentType("Cash Register2");

			phoneorder.ClickPlaceOrderButton();
			delayWithGivenTime(1000);
			softassert.assertTrue(phoneorder.VerifyConfirmationPopupOnPhoneOrderPage(),
					"Test Step - 10 - Confirmation popup is not displayed on phone order page");
			delayWithGivenTime(2000);
			phoneorder.ClickSubmitButton_On_ConfirmationPopup();
			delayWithGivenTime(1000);

			// Test Step - 16
			delayWithGivenTime(2000);
			dashboard.ClickOrder();
			delayWithGivenTime(1000);
			logger.info("User click the order menu on hana dashboard page");
			dashboardorder = new DashboardOrderPage(); // https://hanafloralpos3.com/Dashboard/Order
			softassert.assertEquals(dashboardorder.validateDashboardOrderPage(),
					prop.getProperty("livedashboardorderURL"),
					"Test Step - 16 - Dashboard order page is not displayed");

			// Test Step - 17
			delayWithGivenTime(1000);
			softassert.assertTrue(dashboardorder.Validate_PhoneOrder_Invoice(),
					"Test Step - 17 - Phone order invoice is not displayed");

			// Above test case is passed for existing customer order

			// Below test case is passed for customer new order validation....

			// Test Step - 4
			delayWithGivenTime(2000);
			dashboard.ClickOnHomeIcon();
			delayWithGivenTime(1000);
			softassert.assertTrue(dashboard.VerifyOrderEntryOptionIsDisplayed(),
					"Test Step - 3 : Order entry option is not displayed");

			delayWithGivenTime(1000);
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
			phoneorder.Click_PreviousOrder_OnCustomerHistoryPopup("9038000");
			delayWithGivenTime(3000);

			// Test Step - 10
			softassert.assertEquals(phoneorder.getDisplayedPaymentTypeSelectedOption(), "Cash",
					"Test Step - 10 - Previous Selected Payment type is not displayed on phone order page payment section");

			// Test Step - 11
			delayWithGivenTime(2000);
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
			softassert.assertEquals(phoneorder.getDeliveryDateOnReciSection(), "",
					"Test Step - 11 - Delivery date is not displayed on phone order page recipient section");

			// Test Step - 12
			softassert.assertEquals(phoneorder.getProdDetailsItemcode1OnPhoneOrderPage(), "rrd",
					"Test Step - 9 - Item code is not displayed on phone order page product details section");
			softassert.assertEquals(phoneorder.getProdDetailsItemDescription1OnPhoneOrderPage(), "Red Rose Deluxe",
					"Test Step - 9 - Item description is not displayed on phone order page product details section");
			softassert.assertEquals(phoneorder.getProdItemQty1OnPhoneOrderPage(), "1.00",
					"Test Step - 9 - Item quantity is not displayed on phone order page product details section");
			softassert.assertEquals(phoneorder.getUnitPriceOnProdDetails(), "299.00",
					"Test Step - 9 - Item price is not displayed on phone order page product details section");

			// Test Step - 13
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getSelectedOccasionOnPhoneOrderPage(), "Birthday",
					"Test Step - 8 - Selected Occasion is not displayed on phone order page order details section");
			softassert.assertEquals(phoneorder.getEnteredViewShortCode(),
					"Happy Birthday! Hope You Have An Amazing Day!",
					"Test Step - 8 -Entered Short code is not displayed on phone order page order details section");

			// Test Step - 14
			softassert.assertEquals(phoneorder.getHighlightedColorOnPickupTypeOnPhoneOrderPage(), "#2f9bc8",
					"Test Step - 6 - Pickup type is not highlighted in blue color");

			// Test Step - 15
			delayWithGivenTime(1000);
			phoneorder.EnterDeliveryDateOnReciSection();
			phoneorder.SelectPaymentTypeOnPhoneOrderPage_PaymentSection("Cash");
			delayWithGivenTime(1000);
			softassert.assertEquals(phoneorder.getDisplayedPaymentTypeSelectedOption(), "Cash",
					"Test Step - 10 - Selected Payment type is not displayed on phone order page payment section");
			delayWithGivenTime(2000);
			phoneorder.EnterCashAmount();
			phoneorder.SelectCashRegistry_On_CashPaymentType("Cash Register2");

			phoneorder.ClickPlaceOrderButton();
			delayWithGivenTime(1000);
			softassert.assertTrue(phoneorder.VerifyConfirmationPopupOnPhoneOrderPage(),
					"Test Step - 10 - Confirmation popup is not displayed on phone order page");
			delayWithGivenTime(2000);
			phoneorder.ClickSubmitButton_On_ConfirmationPopup();
			delayWithGivenTime(1000);

			// Test Step - 16
			delayWithGivenTime(2000);
			dashboard.ClickOrder();
			delayWithGivenTime(1000);
			logger.info("User click the order menu on hana dashboard page");
			dashboardorder = new DashboardOrderPage(); // https://hanafloralpos3.com/Dashboard/Order
			softassert.assertEquals(dashboardorder.validateDashboardOrderPage(),
					prop.getProperty("livedashboardorderURL"),
					"Test Step - 16 - Dashboard order page is not displayed");

			// Test Step - 17
			delayWithGivenTime(1000);
			softassert.assertTrue(dashboardorder.Validate_PhoneOrder_Invoice(),
					"Test Step - 17 - Phone order invoice is not displayed");

		} catch (Exception e) {
			e.printStackTrace();
			softassert.fail();
		} finally {
			softassert.assertAll();
		}
	}
}