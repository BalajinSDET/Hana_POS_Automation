package com.hanapos.OrderEntry_Alais_PickUp_PhoneOrder_Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hanapos.pageObjects.DashboardOrderPage;
import com.hanapos.pageObjects.HanaDashBoardPage;
import com.hanapos.pageObjects.LoginPage;
import com.hanapos.pageObjects.Marketing_RemaindersPage;
import com.hanapos.pageObjects.OrderEntry_Alais_PhoneOrderPage;
import com.hanapos.pageObjects.Order_Confirmation_Page;
import com.hanapos.seleniumProjectBase.TestBaseClass;
import com.hanapos.utilities.CustomSoftAssert;

public class Hana_T174_OrderEntry_Pickup_ProductSection_FT extends TestBaseClass {
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private OrderEntry_Alais_PhoneOrderPage phoneorder;
	private Order_Confirmation_Page orderconfirmationpage;
	private DashboardOrderPage dashboardorder;
	
	//,dataProvider="fetch_Excel_Data"
	@Test(enabled=true,groups= {"Regression"}) 
	public void Validate_Hana_T174_OrderEntry_Pickup_ProductSection_Functionality_Test() {
		// SoftAssert softassert = new SoftAssert(); - I have modified this to use CustomSoftAssert
		CustomSoftAssert softassert = new CustomSoftAssert();
		
		logger.info("**** Starting  Validate_Hana_T174_OrderEntry_Pickup_ProductSection_Functionality_Test ****");
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
			softassert.assertTrue(phoneorder.Verify_ProductSectionLabel_Appears(),"Test Step - 5 - product section is not appears on phoneorder page");
			
			// Test Step - 6
			phoneorder.ClickPickupTypeOnPhoneOrderPage();
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getHighlightedColorOnPickupTypeOnPhoneOrderPage(),"#2f9bc8", "Test Step - 6 - Pickup type is not highlighted in blue color");		
		
			// Test Step - 7
			phoneorder.Select_SalesPersonOn_PhoneOrderEntryPage("Stuart Markwood");
			softassert.assertTrue(phoneorder.VerifyCustSectionAppears(), "Test Step - 7 - Customer section is not displayed on phone order page");
			phoneorder.SearchAndSelectCustomerOnCust_Section("Abish");
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getFirstnameOnPhoneOrderPage(),"Abish", "Test Step - 7 - First name is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getLastnameOnPhoneOrderPage(),"David", "Test Step - 7 - Last name is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getCompanyNameOnPhoneOrderPage(),"Hana_Sisterchicks", "Test Step - 7 - Company name is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getEmailIdOnPhoneOrderPage(),"hanaposqateam@gmail.com", "Test Step - 7 - email id is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getAddress1OnPhoneOrderPage(),"3402 Park Blvd", "Test Step - 7 - address 1 is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getAddress2OnPhoneOrderPage(),"", "Test Step - 7 - Address 2 is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getZipCodeOnPhoneOrderPage(),"92103", "Test Step - 7 - Zipcode is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getCityOnPhoneOrderPage(),"San Diego", "Test Step - 7 - city is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getPhoneNumberOnPhoneOrderPage(),"956-655-0756", "Test Step - 7 - phone number 1 is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getAltPhoneNumberOnPhoneOrderPage(),"956-655-0756", "Test Step - 7 - Alt phone number is not displayed on phone order page");		
			
			// Test Step - 8
			phoneorder.ClickReciNameOnPhoneOrderPage();
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getReciFirstName(),"Abish","Test Step - 8 - Displayed first name is not matched with customer firstname on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciLastName(),"David","Test Step - 8 - Displayed last name is not matched with customer lastname on phone order page recipient section");
			delayWithGivenTime(1000);
			phoneorder.EnterReciAddress1("1160 W 5th St");
			phoneorder.SearchAndSelectReciAddress1("1160 W 5th St, Washington, MO");
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getReciAddress1(),"1160 W 5th St","Test Step - 8 - Recipient address 1 is not matched with customer address 1 field on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciZipcode(),"63090","Test Step - 8 - Recipient address 2 is not matched with customer address 2 on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciCity(),"Washington","Test Step - 8 - Recipient city is not matched with customer city on phone order page recipient section");
			softassert.assertEquals(phoneorder.getRecipientState(),"MO","Test Step - 8 - Recipient phone number is not matched with customer phonenumber 1 field on phone order page recipient section");
			phoneorder.EnterDeliveryDateOnReciSection();
			phoneorder.Enter_DeliveryTime_OnRecipientSection();
			phoneorder.Select_DeliveryOnTime_Dropdown("Exactly At");
			delayWithGivenTime(1000);

			// Test Step - 9
			phoneorder.SelectOccasion_On_OrderDetails_In_PhoneOrderPage("Birthday");
			softassert.assertEquals(phoneorder.getSelectedOccasionOnPhoneOrderPage(),"Birthday","Test Step - 9 - Selected Occasion is not displayed on phone order page order details section");
			phoneorder.EnterViewShortCode();	
			softassert.assertEquals(phoneorder.getEnteredViewShortCode(),"Happy Birthday! Hope you have an amazing day!","Test Step - 9 -Entered Short code is not displayed on phone order page order details section");

			// Test Step - 10
			softassert.assertTrue(phoneorder.Verify_ProductSuggestions_Appears("rrd"),"Test Step - 10 - Product autosugestion are not displayed");
			
			// Test Step - 11
			phoneorder.SearchandSelectItemcodeOnPhoneOrderPage("rrd","rrd-Red Rose Deluxe");
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getProdDetailsItemcode1OnPhoneOrderPage(),"rrd","Test Step - 11 - Item code is not displayed on phone order page product details section");
			softassert.assertEquals(phoneorder.getProdDetailsItemDescription1OnPhoneOrderPage(),"Red Rose Deluxe","Test Step - 11 - Item description is not displayed on phone order page product details section"); 
			softassert.assertEquals(phoneorder.getProdItemQty1OnPhoneOrderPage(),"1","Test Step - 11 - Item quantity is not displayed on phone order page product details section");
			softassert.assertEquals(phoneorder.getUnitPriceOnProdDetails(),"299.00","Test Step - 11 - Item price is not displayed on phone order page product details section");
			delayWithGivenTime(2000);
			
			// Test Step - 12
			phoneorder.Click_ProductRemoveIcon_Row1();
			delayWithGivenTime(2000);
			softassert.assertTrue(phoneorder.Verify_ProductRow1Details_Removed(),"Test Step - 12 - Row 1 added products is not removed on product section");
			
			// Test Step - 13
			softassert.assertTrue(phoneorder.Verify_AutosugestionsList_OnItemDescription_Appears("Red Rose"),"Test Step - 10 - Product autosugestion are not displayed");

			// Test Step - 14
			phoneorder.SearchAndSelect_WithItemDescription("Red Rose","Red Rose Deluxe");
			softassert.assertEquals(phoneorder.get_ItemCodeRow2_ProductDetails(), "rrd","Test Step - 14 - Item code row 2 on product details section");
			softassert.assertEquals(phoneorder.get_ItemDescriptionRow2_ProductDetails(), "Red Rose Deluxe","Test Step - 14 - Item description row 2 on product details section");
			softassert.assertEquals(phoneorder.get_ItemQtyRow2_ProductDetails(), "1","Test Step - 14 - Item quantity row 2 on product details section");
			softassert.assertEquals(phoneorder.get_ItemPriceRow2_ProductDetails(), "299.00","Test Step - 14 - Item price row 2 on product details section");
			
			// Test Step - 15
			phoneorder.Click_AddIcon_Row3();
			softassert.assertTrue(phoneorder.Verify_Row4_ProductDetailsItemcode_Appears(),"Test Step - 15 - New row is added on product details table grid");
			
			// Test Step - 16
			phoneorder.EnterSpecialInstructions_ProductDetailsSection("Automation Test special instruction");
			softassert.assertEquals(phoneorder.get_SpecialInstructions_ProductDetailsSection(), "Automation Test special instruction","Test Step - 16 - Special Instruction on product details section");
			
			// Test Step - 17
			phoneorder.EnterDriverInstructions_ProductDetailsSection("Automation Test Driver Instruction");
			softassert.assertEquals(phoneorder.get_DriverInstructions_ProductDetailsSection(), "Automation Test Driver Instruction","Test Step - 17 - Driver Instruction on product details section");
			
			// Test Step - 18
			phoneorder.EnterCustomerPrivateNotesInstructions_ProductDetailsSection("Automation Test Private Notes");
			softassert.assertEquals(phoneorder.get_CustomerPrivateNotesInstructions_ProductDetailsSection(), "Automation Test Private Notes","Test Step - 17 - Driver Instruction on product details section");
			softassert.assertEquals(phoneorder.verifySuccessToastMessageText(), "Customer Notes updated successfully","Test Step - 18 - Success toast message text as customer notes updated successfully is not displayed properly");
			
			//Test Step - 19
			phoneorder.Select_ProductTaxType("Tax Exemption");
			softassert.assertEquals(phoneorder.get_selected_ProductTaxType(),"Tax Exemption","Test Step - 19 - Selected product tax type is not displayed on phone order page");
			
			// Test Step - 20
			phoneorder.Enter_ProductTaxId("1234");
			softassert.assertEquals(phoneorder.get_ProductTaxId(), "1234","Test Step - 20 - Entered Product tax id is not displayed on phone order page");
			
			// Test Step - 21
			phoneorder.Select_ProdSourceCode("Friend");
			softassert.assertEquals(phoneorder.get_selected_ProdSourceCode(), "Friend","Test Step - 21 - Selected Product source code is not displayed on phone order page");

			// Test Step - 22
			phoneorder.Select_ProdCustType("Retail");
			softassert.assertEquals(phoneorder.get_selected_ProdCustType(),"Retail","Test Step - 22 - Selected product customer type is not displayed on phoneorder");
			
			// Test Step - 23
			phoneorder.SelectPaymentTypeOnPhoneOrderPage_PaymentSection("Invoice/House Account");
			delayWithGivenTime(1000);
			phoneorder.ClickPlaceOrderButton();
			delayWithGivenTime(1000);
			getDriver().switchTo().activeElement();
			softassert.assertTrue(phoneorder.VerifyConfirmationPopupOnPhoneOrderPage(), "Test Step - 14 - Confirmation popup is not displayed on phone order page");
			delayWithGivenTime(2000);
			
			// Test Step - 24
			phoneorder.ClickSubmitButton_On_ConfirmationPopup();
			delayWithGivenTime(2000);
			orderconfirmationpage = new Order_Confirmation_Page();
			softassert.assertTrue(orderconfirmationpage.VerifyOrderConfirmationPage(), "Test Step - 15 - Order confirmation page is not displayed");
			
			// Test Step - 25
			delayWithGivenTime(1000);
			dashboard.ClickOrder();
			delayWithGivenTime(1000);
			logger.info("User click the order menu on hana dashboard page");	
			dashboardorder = new DashboardOrderPage();	                      //https://hanafloralpos3.com/Dashboard/Order
			softassert.assertEquals(dashboardorder.validateDashboardOrderPage(),prop.getProperty("livedashboardorderURL"),"Test Step - 16 - Dashboard order page is not displayed");				
			
			// Test Step - 26
			softassert.assertTrue(dashboardorder.Validate_PhoneOrder_InvoiceInHousePayment(),"Test Step - 17 - Phone order invoice in house payment is not displayed");		//https://hanafloralpos3.com/Dashboard/Order/Validate_PhoneOrder_InvoiceInHousePayment();
			delayWithGivenTime(2000);
			dashboardorder.ClickInvoiceInhousePayment_on_PhoneOrder_on_SenderorCustomer_OnOrderPage();

			// Test Step - 27
			softassert.assertEquals(dashboardorder.get_ProductDescription_OnInvPopup(),"rrd - Red Rose Deluxe","Test Step - 27 - Product Item description on invoice popup on order page compared with added product on phone order page are not matched");
			
			// Test Step - 28
			softassert.assertEquals(dashboardorder.get_sourcecode_displayed_OnInvPopup(),"Friend","Test Step - 28 - Displayed source code on invoice popup on order page compared with added product on phone order page are not matched");
			
			// Test Step - 29
			softassert.assertEquals(dashboardorder.get_SpecialInstruction_displayed_OnInvPopup(), "Automation Test Special Instruction","Test Step - 29 - Special instruction displayed on invoice popup on order page compared with added product section on phone order page are not matched ");
			
			// Test Step - 30
			softassert.assertEquals(dashboardorder.get_DriverInstruction_displayed_OnInvPopup(), "Automation Test Driver Instruction","Test Step - 30 - Driver instruction displayed on invoice popup on order page compared with added product section on phone order page are not matched ");

			// Test Step - 31
			softassert.assertEquals(dashboardorder.get_Displayed_DeliveryType_OnInvPopup(), "Pick Up Phone Order","Test Step - 31 - Displayed delivery type on invoice popup on order page compared with phoneorder selected delivery type is not matched");
						
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Test case failed due to exception " + e.getMessage());
			logger.error("Test case failed due to exception " + e.getMessage());
		} finally {
			softassert.assertAll();
		}
	}
}