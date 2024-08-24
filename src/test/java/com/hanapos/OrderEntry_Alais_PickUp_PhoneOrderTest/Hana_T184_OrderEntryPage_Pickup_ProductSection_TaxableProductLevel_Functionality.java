package com.hanapos.OrderEntry_Alais_PickUp_PhoneOrderTest;

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

public class Hana_T184_OrderEntryPage_Pickup_ProductSection_TaxableProductLevel_Functionality extends TestBaseClass {
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private OrderEntry_Alais_PhoneOrderPage phoneorder;
	private Order_Confirmation_Page orderconfirmationpage;
	private DashboardOrderPage dashboardorder;
	
	//,dataProvider="fetch_Excel_Data"
	@Test(enabled=true,groups= {"Regression"}) 
	public void Validate_Hana_T184_OrderEntryPage_Pickup_ProductSection_TaxableProductLevel_Functionality_Test() {
		SoftAssert softassert = new SoftAssert();
		logger.info("**** Starting  Validate_Hana_T184_OrderEntryPage_Pickup_ProductSection_TaxableProductLevel_Functionality_Test ****");
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
			softassert.assertTrue(phoneorder.Verify_ProductSection_Appears_OnPhoneorder(),"Test Step - 5 - Product section is not displayed on phoneorder page");
		
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
			delayWithGivenTime(2000);
			
			// Test Step - 8
			phoneorder.EnterReciFirstName("Abi");
			phoneorder.SearchAndSelect_RecipientNameFromAutoSuggestion("Abish David 114 N CHURCH ST PICK UP (9566550756,9566550756)");
			delayWithGivenTime(2000);
			phoneorder.SelectReciCountry("United States");
			phoneorder.EnterReciPhone("956-655-0756");
			delayWithGivenTime(1000);
			phoneorder.SelectReciLocation("Church");
			delayWithGivenTime(1000);
			phoneorder.EnterDeliveryDateOnReciSection();
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getReciFirstName(),"Abish","Test Step - 8 - Entered first name is not displayed on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciLastName(),"David","Test Step - 8 - Entered last name is not displayed on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciAddress1(),"114 N CHURCH ST","Test Step - 8 - Entered address 1 is not displayed on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciAddress2(),"PICK UP","Test Step - 8 - Entered address 2 is not displayed on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciZipcode(),"63084","Test Step - 8 - Entered zipcode is not displayed on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciCity(),"UNION","Test Step - 8 - Entered city is not displayed on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciPhone(),"956-655-0756","Test Step - 8 - Recipient phone number is not displayed on phone order page recipient section");

			// Test Step - 9
			phoneorder.SelectOccasion_On_OrderDetails_In_PhoneOrderPage("Birthday");
			phoneorder.EnterViewShortCode();			
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getSelectedOccasionOnPhoneOrderPage(),"Birthday","Test Step - 9 - Selected Occasion is not displayed on phone order page order details section");
			softassert.assertTrue(phoneorder.getEnteredViewShortCode().equalsIgnoreCase("Happy Birthday! Hope You Have An Amazing Day!"),"Test Step - 9 -Entered Short code is not displayed on phone order page order details section");
			delayWithGivenTime(2000);	
			
			// Test Step - 10
			
			softassert.assertTrue(phoneorder.Verify_ProductSuggestions_Appears("rrd"),"Test Step - 10 - In Item code row 1 on product section autosuggestions are not displayed");
			
			// Test Step - 11
			phoneorder.SearchandSelectItemcodeOnPhoneOrderPage("rrd");
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getProdDetailsItemcode1OnPhoneOrderPage(),"rrd","Test Step - 11 - Item code is not displayed on phone order page product details section");
			softassert.assertEquals(phoneorder.getProdDetailsItemDescription1OnPhoneOrderPage(),"Red Rose Deluxe","Test Step - 11 - Item description is not displayed on phone order page product details section"); 
			softassert.assertEquals(phoneorder.getProdItemQty1OnPhoneOrderPage(),"1","Test Step - 11 - Item quantity is not displayed on phone order page product details section");
			
			if(phoneorder.getUnitPriceOnProdDetails()=="299.00"){ 
				softassert.assertEquals(phoneorder.getUnitPriceOnProdDetails(),"299.00","Test Step - 11 - Item price is not displayed on phone order page product details section");
			}else if (phoneorder.getUnitPriceOnProdDetails()=="309.00") {
				softassert.assertEquals(phoneorder.getUnitPriceOnProdDetails(),"309.00","Test Step - 11 - Item price is not displayed on phone order page product details section");
			}
			
			delayWithGivenTime(2000);
			
			// Test Step - 12
			softassert.assertTrue(phoneorder.Verify_Item_Row1_ProdDetails_TaxableCheckBox_IsChecked(),"Test Step - 12 - Item row 1 on product section taxable checkbox is not checked as default");
			
			// Test Step - 13
			phoneorder.Select_ProductTaxType("QA Tax");
			softassert.assertEquals(phoneorder.get_selected_ProductTaxType(),"QA Tax","Test Step - 13 - Selected product tax type is not displayed on phone order page");
			delayWithGivenTime(2000);
			if(phoneorder.get_TaxAmount_PaymentSection()=="2.99"){ 
			softassert.assertEquals(phoneorder.get_TaxAmount_PaymentSection(), "2.99","Test Step - 13 - Tax amount is not displayed on phone order page payment section");
			}else if(phoneorder.get_TaxAmount_PaymentSection()=="3.09") {
				softassert.assertEquals(phoneorder.get_TaxAmount_PaymentSection(), "3.09","Test Step - 13 - Tax amount is not displayed on phone order page payment section");
			}	
			
			// Test Step- 14
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.validate_grandTotal_OnPaymentSection(),phoneorder.getGrandTotalAmount(),"Test Step - 14 - Grand total is not displayed on phone order page payment section");
			
			// Test Step - 15
			phoneorder.ClickOn_Row1_Item_ProdDetails_TaxableCheckBox();
			softassert.assertTrue(phoneorder.Verify_Item_Row1_ProdDetails_TaxableCheckBox_IsChecked(),"Test Step - 15 - Item row 1 on product section taxable checkbox is not unchecked ");
			
			// Test Step - 16
			softassert.assertEquals(phoneorder.get_TaxAmount_PaymentSection(), "0.00","Test Step - 16 - Tax amount is not displayed on phone order page payment section");
			
			// Test Step - 17
			phoneorder.SearchandSelectItemcodeOnPhoneOrderPage("rrd");
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getProdDetailsItemcode1OnPhoneOrderPage(),"rrd","Test Step - 17 - Item code is not displayed on phone order page product details section");
			softassert.assertEquals(phoneorder.getProdDetailsItemDescription1OnPhoneOrderPage(),"Red Rose Deluxe","Test Step - 17 - Item description is not displayed on phone order page product details section"); 
			softassert.assertEquals(phoneorder.getProdItemQty1OnPhoneOrderPage(),"1","Test Step - 17 - Item quantity is not displayed on phone order page product details section");
			
			if(phoneorder.getUnitPriceOnProdDetails()=="299.00"){ 
				softassert.assertEquals(phoneorder.getUnitPriceOnProdDetails(),"299.00","Test Step - 17 - Item price is not displayed on phone order page product details section");
			}else if (phoneorder.getUnitPriceOnProdDetails()=="309.00") {
				softassert.assertEquals(phoneorder.getUnitPriceOnProdDetails(),"309.00","Test Step - 17 - Item price is not displayed on phone order page product details section");
			}
			
			delayWithGivenTime(2000);

			softassert.assertTrue(phoneorder.Verify_Item_Row1_ProdDetails_TaxableCheckBox_IsChecked(),"Test Step - 17 - Item row 1 on product section taxable checkbox is not checked as default");
			
			// Test Step - 18
			phoneorder.Select_ProductTaxType("QA Tax");
			softassert.assertEquals(phoneorder.get_selected_ProductTaxType(),"QA Tax","Test Step - 18 - Selected product tax type is not displayed on phone order page");
			delayWithGivenTime(2000);
			if(phoneorder.get_TaxAmount_PaymentSection()=="2.99"){ 
			softassert.assertEquals(phoneorder.get_TaxAmount_PaymentSection(), "2.99","Test Step - 18 - Tax amount is not displayed on phone order page payment section");
			}else if(phoneorder.get_TaxAmount_PaymentSection()=="3.09") {
				softassert.assertEquals(phoneorder.get_TaxAmount_PaymentSection(), "3.09","Test Step - 18 - Tax amount is not displayed on phone order page payment section");
			}	
			
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.validate_grandTotal_OnPaymentSection(),phoneorder.getGrandTotalAmount(),"Test Step - 14 - Grand total is not displayed on phone order page payment section");
			
			// Test Step - 19
			phoneorder.SelectPaymentTypeOnPhoneOrderPage_PaymentSection("Invoice/House Account");
			delayWithGivenTime(1000);
			phoneorder.ClickPlaceOrderButton();
			delayWithGivenTime(1000);
			getDriver().switchTo().activeElement();
			
			// Test Step - 20
			softassert.assertTrue(phoneorder.VerifyConfirmationPopupOnPhoneOrderPage(), "Test Step - 20 - Confirmation popup is not displayed on phone order page");
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.get_taxAmountOnOrderconfirmation_Popup(), "2.69","Test Step - 20 - Tax amount on order confirmation page is not displayed");			
			
			// Test Step - 21
			phoneorder.ClickSubmitButton_On_ConfirmationPopup();
			delayWithGivenTime(2000);
			orderconfirmationpage = new Order_Confirmation_Page();
			softassert.assertTrue(orderconfirmationpage.VerifyOrderConfirmationPage(), "Test Step - 21 - Order confirmation page is not displayed");
			
			// Test Step - 22 == teststep mistake
			
			// Test Step - 23
			softassert.assertEquals(orderconfirmationpage.get_Taxable(),"Yes","Test Step - 23 - Taxable Yes is not displayed on order confirmation page");
			
			// Test Step - 24
			delayWithGivenTime(1000);
			dashboard.ClickOrder();
			delayWithGivenTime(1000);
			logger.info("User click the order menu on hana dashboard page");	
			dashboardorder = new DashboardOrderPage();	                   
			softassert.assertEquals(dashboardorder.validateDashboardOrderPage(),prop.getProperty("livedashboardorderURL"),"Test Step - 24 - Dashboard order page is not displayed");				
			
			// Test Step - 25
			dashboardorder.EnterGlobalSearch(dashboardorder.get_InvoiceNumber_PhoneOrder_PickUp_InvoiceHouse());
			delayWithGivenTime(1000);
			softassert.assertTrue(dashboardorder.Validate_PhoneOrder_InvoiceInHousePayment(),"Test Step - 25 - Phone order invoice in house payment is not displayed");		//https://hanafloralpos3.com/Dashboard/Order/Validate_PhoneOrder_InvoiceInHousePayment();
			delayWithGivenTime(1000);
			
			// Test Step - 26
			dashboardorder.ClickInvoiceInhousePayment_on_PhoneOrder_on_SenderorCustomer_OnOrderPage();
			
			// Test Step - 27
			delayWithGivenTime(1000);
			softassert.assertEquals(dashboardorder.get_SalesTax_On_DeliveryPopup_Invoice(), "$02.69","Test Step - 27 - Sales tax on delivery popup invoice is not displayed");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Test case failed due to exception " + e.getMessage());
			logger.error("Test case failed due to exception " + e.getMessage());
		} finally {
			softassert.assertAll();
		}
	}
}