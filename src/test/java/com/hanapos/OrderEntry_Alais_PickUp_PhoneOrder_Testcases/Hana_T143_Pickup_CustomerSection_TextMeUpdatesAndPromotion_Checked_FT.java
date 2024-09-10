package com.hanapos.OrderEntry_Alais_PickUp_PhoneOrder_Testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hanapos.pageObjects.DashboardOrderPage;
import com.hanapos.pageObjects.HanaDashBoardPage;
import com.hanapos.pageObjects.LoginPage;
import com.hanapos.pageObjects.OrderEntry_Alais_PhoneOrderPage;

import com.hanapos.seleniumProjectBase.TestBaseClass;
import com.hanapos.utilities.EmailReader;

public class Hana_T143_Pickup_CustomerSection_TextMeUpdatesAndPromotion_Checked_FT extends TestBaseClass {
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private OrderEntry_Alais_PhoneOrderPage phoneorder;
	private DashboardOrderPage dashboardorder;

	// ,dataProvider="fetch_Excel_Data"
	@Test(enabled = true, groups = { "Regression" })
	public void Validate_Hana_T143_Pickup_CustomerSection_TextMeUpdatesAndPromotion_Checked_Functionality_Test() {
		SoftAssert softassert = new SoftAssert();
		logger.info("**** Starting Hana_T143_Pickup_CustomerSection_TextMeUpdatesAndPromotion_Checked_FT  ****");
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
			softassert.assertTrue(phoneorder.VerifyCustSectionAppears(),"Test Step - 5 - Customer section is not displayed on phone order page");

			// Test Step - 6
			phoneorder.Select_SalesPersonOn_PhoneOrderEntryPage("Stuart Markwood");
			phoneorder.SearchAndSelectCustomerOnCust_Section("Abish");
			delayWithGivenTime(2000);
			phoneorder.Click_CustEditIcon();
			delayWithGivenTime(2000);
			phoneorder.Click_SMSToogleOn_CustDetailsPopup();
			phoneorder.Click_UpdateBtn_OnCustDetailsPopup();
			phoneorder.Click_Customer_DetailsPopupCloseBtn();
			
			delayWithGivenTime(2000);
			softassert.assertTrue(phoneorder.VerifyCustSectionAppears(),"Test Step - 6 - Customer section is not displayed on phone order page");
			delayWithGivenTime(500);
			softassert.assertFalse(phoneorder.Verify_TextmepromotionCheckboxIsChecked_OnPhoneorderPage(), "Test Step - 6 - Text me promotion checkbox is not checked on phone order page");
			
			// Test Step - 7
			phoneorder.Click_TextmePromotionCheckBox_OnphoneOrderPage();
			delayWithGivenTime(500);
			softassert.assertFalse(phoneorder.Verify_TextmepromotionCheckboxIsChecked_OnPhoneorderPage(), "Test Step - 7 - Text me promotion checkbox is not unchecked on phone order page");

			// Test Step - 8
			phoneorder.Click_TextmePromotionCheckBox_OnphoneOrderPage();
			delayWithGivenTime(500);
			softassert.assertFalse(phoneorder.Verify_TextmepromotionCheckboxIsChecked_OnPhoneorderPage(), "Test Step - 8 - Text me promotion checkbox is not checked on phone order page");

			// Test Step - 9
			phoneorder.ClickPickupTypeOnPhoneOrderPage();
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getHighlightedColorOnPickupTypeOnPhoneOrderPage(), "#2f9bc8",
					"Test Step - 9 - Pickup type is not highlighted in blue color");

			phoneorder.Select_SalesPersonOn_PhoneOrderEntryPage("Stuart Markwood");
			phoneorder.SearchAndSelectCustomerOnCust_Section("Abish");
			delayWithGivenTime(1000);
			softassert.assertEquals(phoneorder.getFirstnameOnPhoneOrderPage(), "Abish",
					"Test Step - 9 - First name is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getLastnameOnPhoneOrderPage(), "David",
					"Test Step - 9 - Last name is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getCompanyNameOnPhoneOrderPage(), "Hana_Sisterchicks",
					"Test Step - 9 - Company name is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getEmailIdOnPhoneOrderPage(), "hanaposqateam@gmail.com",
					"Test Step - 9 - email id is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getAddress1OnPhoneOrderPage(), "3402 Park Blvd",
					"Test Step - 9 - address 1 is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getAddress2OnPhoneOrderPage(), "",
					"Test Step - 9 - Address 2 is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getZipCodeOnPhoneOrderPage(), "92103",
					"Test Step - 9 - Zipcode is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getCityOnPhoneOrderPage(), "San Diego",
					"Test Step - 9 - city is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getPhoneNumberOnPhoneOrderPage(), "956-655-0756",
					"Test Step - 9 - phone number 1 is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getAltPhoneNumberOnPhoneOrderPage(), "956-655-0756",
					"Test Step - 9 - Alt phone number is not displayed on phone order page");
			delayWithGivenTime(2000);
			
			// Test Step - 10
			delayWithGivenTime(1000);
			phoneorder.EnterDeliveryDateOnReciSection();
			
			softassert.assertEquals(phoneorder.getReciFirstName(), "Abish",
					"Test Step - 10 - Entered first name is not displayed on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciLastName(), "David",
					"Test Step - 10 - Entered last name is not displayed on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciAddress1(), "114 N CHURCH ST",
					"Test Step - 10 - Entered address 1 is not displayed on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciAddress2(), "PICK UP",
					"Test Step - 10 - Entered address 2 is not displayed on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciZipcode(), "63084",
					"Test Step - 10 - Entered zipcode is not displayed on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciCity(), "UNION",
					"Test Step - 10 - Entered city is not displayed on phone order page recipient section");
			softassert.assertEquals(phoneorder.getSelectedCountryOnReciCountry(), "United States",
					"Test Step - 10 - Selected country is not displayed on phone order page recipient section");
			delayWithGivenTime(2000);
			
			
			// Test Step - 11
			phoneorder.SelectOccasion_On_OrderDetails_In_PhoneOrderPage("Birthday");
			phoneorder.EnterViewShortCode();			
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getSelectedOccasionOnPhoneOrderPage(),"Birthday","Test Step - 11 - Selected Occasion is not displayed on phone order page order details section");
			softassert.assertEquals(phoneorder.getEnteredViewShortCode(),"Happy Birthday! Hope you have an amazing day!","Test Step - 11 -Entered Short code is not displayed on phone order page order details section");
			delayWithGivenTime(2000);
			
			// Test Step - 12
			phoneorder.SearchandSelect_ItemcodeOnPhoneOrderPage("rrd","rrd Red Rose Deluxe");
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getProdDetailsItemcode1OnPhoneOrderPage(),"rrd","Test Step - 12 - Item code is not displayed on phone order page product details section");
			softassert.assertEquals(phoneorder.getProdDetailsItemDescription1OnPhoneOrderPage(),"Red Rose Deluxe","Test Step - 12 - Item description is not displayed on phone order page product details section"); 
			softassert.assertEquals(phoneorder.getProdItemQty1OnPhoneOrderPage(),"1","Test Step - 12 - Item quantity is not displayed on phone order page product details section");
			softassert.assertEquals(phoneorder.getUnitPriceOnProdDetails(),"299.00","Test Step - 12 - Item price is not displayed on phone order page product details section");
			delayWithGivenTime(2000);
			
			// Test Step - 13
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
			
			// Test Step -14
			delayWithGivenTime(2000);
			phoneorder.ClickSubmitButton_On_ConfirmationPopup();
			delayWithGivenTime(1000);
			
			// Test Step - 15
			delayWithGivenTime(2000);
			dashboard.ClickOrder();
			delayWithGivenTime(2000);
			logger.info("User click the order menu on hana dashboard page");
			dashboardorder = new DashboardOrderPage(); // https://hanafloralpos3.com/Dashboard/Order
			
			// Test Step - 16
			softassert.assertEquals(dashboardorder.validateDashboardOrderPage(),
					prop.getProperty("livedashboardorderURL"),
					"Test Step - 16 - Dashboard order page is not displayed");
			
		
			// Test Step - 17
			// Not feasible to automate email reader functionality
		//	ThreadWait(15000);
		//	EmailReader.getInstance();
		//	System.out.println("Received Email Invoice number is :" + EmailReader.getInvoiceNumber());
					
			
			// Set previous test data
			dashboard.ClickOnHomeIcon();
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
			softassert.assertTrue(phoneorder.VerifyCustSectionAppears(),"Test Step - 5 - Customer section is not displayed on phone order page");

			// Test Step - 6
			phoneorder.Select_SalesPersonOn_PhoneOrderEntryPage("Stuart Markwood");
			phoneorder.SearchAndSelectCustomerOnCust_Section("Abish");
			delayWithGivenTime(2000);
			phoneorder.Click_CustEditIcon();
			delayWithGivenTime(2000);
			phoneorder.Click_SMSToogleOn_CustDetailsPopup();
			phoneorder.Click_UpdateBtn_OnCustDetailsPopup();
			phoneorder.Click_Customer_DetailsPopupCloseBtn();

			
			
		} catch (Exception e) {
			e.printStackTrace();
			softassert.fail();
		} finally {
			softassert.assertAll();
		}
	}
}