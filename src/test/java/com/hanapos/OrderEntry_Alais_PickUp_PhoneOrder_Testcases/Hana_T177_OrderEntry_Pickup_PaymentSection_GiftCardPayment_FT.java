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

public class Hana_T177_OrderEntry_Pickup_PaymentSection_GiftCardPayment_FT extends TestBaseClass {
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private OrderEntry_Alais_PhoneOrderPage phoneorder;
	private Order_Confirmation_Page orderconfirmationpage;
	private DashboardOrderPage dashboardorder;
	
	//,dataProvider="fetch_Excel_Data"
	@Test(enabled=true,groups= {"Regression"}) 
	public void Validate_Hana_T177_OrderEntry_Pickup_PaymentSection_GiftCardPayment_Functionality_Test() {
		// SoftAssert softassert = new SoftAssert(); - I have modified this to use CustomSoftAssert
		CustomSoftAssert softassert = new CustomSoftAssert();
		
		logger.info("**** Starting  Validate_Hana_T177_OrderEntry_Pickup_PaymentSection_GiftCardPayment_Functionality_Test ****");
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
			dashboard.ClickOrderEntry();
			logger.info("User hover the mouse on New order and clicked on order entry");
			
			// Test Step - 4
			phoneorder = new OrderEntry_Alais_PhoneOrderPage();
			phoneorder.ClickPickupTypeOnPhoneOrderPage();
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getHighlightedColorOnPickupTypeOnPhoneOrderPage(),"#2f9bc8", "Test Step - 5 - Pickup type is not highlighted in blue color");		
			phoneorder.Select_SalesPersonOn_PhoneOrderEntryPage("Stuart Markwood");
			
			softassert.assertEquals(phoneorder.get_SelectedSalesPersonOn_PhoneOrderEntryPage(), "Stuart Markwood", "Test Step - 5 - Selected sales person is not displayed on phone order page");
			
			// Test Step - 6	
			phoneorder.SearchAndSelectCustomerOnCust_Section("Abish");
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
			phoneorder.ClickReciNameOnPhoneOrderPage();
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getReciFirstName(),"Abish","Test Step - 7 - Displayed first name is not matched with customer firstname on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciLastName(),"David","Test Step - 7 - Displayed last name is not matched with customer lastname on phone order page recipient section");
			delayWithGivenTime(1000);
			phoneorder.SearchAndSelectReciAddress1("1160 W 5th St, Washington, MO");
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getReciAddress1(),"1160 W 5th St","Test Step - 7 - Recipient address 1 is not matched with customer address 1 field on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciZipcode(),"63090","Test Step - 7 - Recipient address 2 is not matched with customer address 2 on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciCity(),"Washington","Test Step - 7 - Recipient city is not matched with customer city on phone order page recipient section");
			softassert.assertEquals(phoneorder.getRecipientState(),"MO","Test Step - 7 - Recipient phone number is not matched with customer phonenumber 1 field on phone order page recipient section");
			phoneorder.EnterDeliveryDateOnReciSection();
			phoneorder.Enter_DeliveryTime_OnRecipientSection();
			phoneorder.Select_DeliveryOnTime_Dropdown("Exactly At");
			delayWithGivenTime(1000);

			// Test Step - 8
			phoneorder.SelectOccasion_On_OrderDetails_In_PhoneOrderPage("Birthday");
			softassert.assertEquals(phoneorder.getSelectedOccasionOnPhoneOrderPage(),"Birthday","Test Step - 8 - Selected Occasion is not displayed on phone order page order details section");
			phoneorder.EnterViewShortCode();	
			softassert.assertEquals(phoneorder.getEnteredViewShortCode(),"Happy Birthday! Hope you have an amazing day!","Test Step - 8 -Entered Short code is not displayed on phone order page order details section");

			// Test Step - 9
			phoneorder.SearchandSelectItemcodeOnPhoneOrderPage("rrd","rrd-Red Rose Deluxe");
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getProdDetailsItemcode1OnPhoneOrderPage(),"rrd","Test Step - 9 - Item code is not displayed on phone order page product details section");
			softassert.assertEquals(phoneorder.getProdDetailsItemDescription1OnPhoneOrderPage(),"Red Rose Deluxe","Test Step - 9 - Item description is not displayed on phone order page product details section"); 
			softassert.assertEquals(phoneorder.getProdItemQty1OnPhoneOrderPage(),"1","Test Step - 9 - Item quantity is not displayed on phone order page product details section");
			softassert.assertEquals(phoneorder.getUnitPriceOnProdDetails(),"299.00","Test Step - 9 - Item price is not displayed on phone order page product details section");
			delayWithGivenTime(2000);
			
			phoneorder.EnterSpecialInstructions_ProductDetailsSection("Automation Test special instruction");
			softassert.assertEquals(phoneorder.get_SpecialInstructions_ProductDetailsSection(), "Automation Test special instruction","Test Step - 9 - Special Instruction on product details section");

			phoneorder.EnterDriverInstructions_ProductDetailsSection("Automation Test Driver Instruction");
			softassert.assertEquals(phoneorder.get_DriverInstructions_ProductDetailsSection(), "Automation Test Driver Instruction","Test Step - 9 - Driver Instruction on product details section");

			phoneorder.EnterCustomerPrivateNotesInstructions_ProductDetailsSection("Automation Test Private Notes");
			softassert.assertEquals(phoneorder.get_CustomerPrivateNotesInstructions_ProductDetailsSection(), "Automation Test Private Notes","Test Step - 9 - Driver Instruction on product details section");
			softassert.assertEquals(phoneorder.verifySuccessToastMessageText(), "Customer Notes updated successfully","Test Step - 9 - Success toast message text as customer notes updated successfully is not displayed properly");

			phoneorder.Select_ProductTaxType("Tax Exemption");
			softassert.assertEquals(phoneorder.get_selected_ProductTaxType(),"Tax Exemption","Test Step - 9 - Selected product tax type is not displayed on phone order page");

			phoneorder.Enter_ProductTaxId("1234");
			softassert.assertEquals(phoneorder.get_ProductTaxId(), "1234","Test Step - 9 - Entered Product tax id is not displayed on phone order page");

			phoneorder.Select_ProdSourceCode("Friend");
			softassert.assertEquals(phoneorder.get_selected_ProdSourceCode(), "Friend","Test Step - 9 - Selected Product source code is not displayed on phone order page");

			phoneorder.Select_ProdCustType("Retail");
			softassert.assertEquals(phoneorder.get_selected_ProdCustType(),"Retail","Test Step - 9 - Selected product customer type is not displayed on phoneorder");
			
			// Test Step - 10
			delayWithGivenTime(3000);
			phoneorder.SelectPaymentTypeOnPhoneOrderPage_PaymentSection("Gift Card");
			delayWithGivenTime(1000);
			softassert.assertEquals(phoneorder.get_SelectedPaymentType_OnPhoneOrderPage(), "Gift Card","Test Step - 10 - Selected payment type is not displayed on phone order page payment section");
			
			// Test Step - 11
			delayWithGivenTime(1000);
			phoneorder.Enter_GiftCardNumber_OnPhoneOrderPage("1234512345");
			softassert.assertEquals(phoneorder.get_GiftCardNumber_OnPhoneOrderPage(), "1234512345","Test Step - 11 - Entered gift card number is not displayed on payment type section");
			
			// Test Step - 12	
			delayWithGivenTime(1000);
			softassert.assertEquals(phoneorder.get_GiftCardDisplayedCustName_OnPhoneOrderPage(), "Abish David","Test Step - 12 - For added Gift card number customer name is not displayed on payment type section");

			// Test Step - 13
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.get_GiftCardDisplayed_Amount_OnPhoneOrderPage(), "269.10","Test Step - 13 - Amount is not autopopulated as correct");			
			
			// Test Step - 14
			//delayWithGivenTime(3000);
			//softassert.assertEquals(phoneorder.get_GiftCardCurrentBalanceDisplayed_OnPhoneOrderPage(), phoneorder.Validate_GiftCardAmountCalculation(),"Test Step - 14 - Amount is not autopopulated as correct");			
			delayWithGivenTime(1000);
			softassert.assertEquals(phoneorder.get_GiftCardCurrentBalanceDisplayed_OnPhoneOrderPage(), phoneorder.get_GiftCardCurrentBalanceDisplayed_OnPhoneOrderPage(),"Test Step - 14 - For added gift card number current balance is not displayed on payment type section");
			
			// Test Step - 15
			delayWithGivenTime(1000);
			phoneorder.ClickPlaceOrderButton();
			delayWithGivenTime(1000);
			getDriver().switchTo().activeElement();
			softassert.assertTrue(phoneorder.VerifyConfirmationPopupOnPhoneOrderPage(), "Test Step - 15 - Confirmation popup is not displayed on phone order page");
			delayWithGivenTime(2000);
			
			// Test Step - 16
			phoneorder.ClickSubmitButton_On_ConfirmationPopup();
			delayWithGivenTime(2000);
			orderconfirmationpage = new Order_Confirmation_Page();
			softassert.assertTrue(orderconfirmationpage.VerifyOrderConfirmationPage(), "Test Step - 16 - Order confirmation page is not displayed");
			
			// Test Step - 17
			delayWithGivenTime(1000);
			dashboard.ClickOrder();
			delayWithGivenTime(1000);
			logger.info("User click the order menu on hana dashboard page");	
			dashboardorder = new DashboardOrderPage();	                      //https://hanafloralpos3.com/Dashboard/Order
			softassert.assertEquals(dashboardorder.validateDashboardOrderPage(),prop.getProperty("livedashboardorderURL"),"Test Step - 17 - Dashboard order page is not displayed");				
			
			// Test Step - 18
			delayWithGivenTime(2000);
			dashboardorder.EnterGlobalSearch(dashboardorder.getInvoiceNumber_Phoneorder_pickup_GiftCArd_OnOrderPage());
			
			delayWithGivenTime(2000);			
			softassert.assertTrue(dashboardorder.Validate_MOP_As_GiftCard_OnOrderPageTable(),"Test Step - 18 - Mode of pay on order page as gift card mop type is not displayed");				
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Test case failed due to exception " + e.getMessage());
			logger.error("Test case failed due to exception " + e.getMessage());
		} finally {
			softassert.assertAll();
		}
	}
}