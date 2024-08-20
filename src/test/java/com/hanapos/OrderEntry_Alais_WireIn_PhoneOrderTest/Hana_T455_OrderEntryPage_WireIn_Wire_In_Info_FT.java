package com.hanapos.OrderEntry_Alais_WireIn_PhoneOrderTest;

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

public class Hana_T455_OrderEntryPage_WireIn_Wire_In_Info_FT extends TestBaseClass {
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private OrderEntry_Alais_PhoneOrderPage phoneorder;
	private Order_Confirmation_Page orderconfirmationpage;
	private DashboardOrderPage dashboardorder;
	private CustomerPage customerpage;
	public static final String dataSheetName = "Hana_T303";
	
	@DataProvider(name = "fetch_Excel_Data") 
	public Object[][] fetchData() throws IOException { 
		return DataLibrary.readExcelData(dataSheetName); 
	}

	
	@Test(enabled=true,groups= {"Regression","Smoke"},dataProvider="fetch_Excel_Data") 
	public void Validate_Hana_T455_OrderEntryPage_WireIn_Wire_In_Info_Functionality_Test(String salesperson, String custaddress1, String custzip,String custphone, String recifname, String recilname, String reciaddress1, String reciaddress2, String recizip,
			String recicity, String recicountry, String reciphone, String recilocation, String occasion, String searchandselectitemcode, String paymenttype, String cashregistry) {
		
		SoftAssert softassert = new SoftAssert();
		logger.info("**** Starting  Validate_Hana_T455_OrderEntryPage_WireIn_Wire_In_Info_Functionality_Test  ****");
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
			phoneorder.Click_WireIn_DeliveryType_OnPhoneOrderPage();
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getHighlightedColorOnDeliveryTypeOnPhoneOrderPage(),"#676a6c", "Pickup type is not highlighted in blue color");		
			
			// Test Step - 6
			phoneorder.Select_SalesPersonOn_PhoneOrderEntryPage(salesperson);
			phoneorder.Enter_WireIn_Fname("Abish");
			phoneorder.Enter_WireIn_Lname("David");
			phoneorder.Enter_WireIn_ShopCode("123");
			phoneorder.Enter_WireIn_ShopName("SisterChicks Flower Shop");
			phoneorder.Select_WireInMethod("FSN");
			phoneorder.Enter_WireIn_OrderNumber("1234FFSC");
			phoneorder.Enter_WireIn_PhoneNumber("9566550756");
			phoneorder.Enter_WireIn_Email("hanaposqateam@gmail.com");
			phoneorder.Enter_WireIn_ShopAddress(custaddress1);
			phoneorder.Enter_WireIn_Comments("Test Automation wire in order");
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.get_Entered_WireIn_Fname(),"Abish", "Test Step - 6 - First name is not displayed on phone order page");
			softassert.assertEquals(phoneorder.get_Entered_WireIn_Lname(),"David", "Test Step - 6 - Last name is not displayed on phone order page");
			softassert.assertEquals(phoneorder.get_Entered_WireIn_ShopCode(), "123","Test Step - 6 - Entered WireIn shop code is not displayed on phone order page");
			softassert.assertEquals(phoneorder.get_Entered_WireIn_ShopName(), "SisterChicks Flower Shop","Test Step - 6 - Entered WireIn shop name is not displayed on phone order page");
			softassert.assertEquals(phoneorder.get_Selected_WireInMethod(), "FSN","Test Step - 6 - Selected WireIn method is not displayed on phone order page");
			softassert.assertEquals(phoneorder.get_Entered_WireIn_OrderNumber(), "1234FFSC","Test Step - 6 - Entered WireIn order number is not displayed on phone order page");
			softassert.assertEquals(phoneorder.get_Entered_WireIn_PhoneNumber(), "956-655-0756","Test Step - 6 - Entered phone number on customer details popup is not displayed on phone order page");
			softassert.assertEquals(phoneorder.get_Entered_WireIn_Email(), "hanaposqateam@gmail.com","Test Step - 6 - Entered shop Email id on customer details popup is not displayed on phone order page");
			softassert.assertEquals(phoneorder.get_Entered_WireIn_ShopAddress(),"2715 35th Ave", "Test Step - 6 - Entered shop address  is not displayed on phone order page");
			softassert.assertEquals(phoneorder.get_Entered_WireIn_Comments(),"Test Automation wire in order", "Test Step - 6 - Shop Wire In Comments is not displayed on phone order page");
			delayWithGivenTime(2000);
		
			// Test Step - 7
			phoneorder.EnterReciFirstName("Abish");
			phoneorder.EnterReciLastName("David");
			phoneorder.EnterReciAddress1(reciaddress1);
			
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
			phoneorder.SearchandSelectItemcodeOnPhoneOrderPage(searchandselectitemcode);
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
			phoneorder.ClickPlaceOrderButton();
			delayWithGivenTime(2000);
			getDriver().switchTo().activeElement();
			softassert.assertTrue(phoneorder.VerifyConfirmationPopupOnPhoneOrderPage(), "Test Step - 10 - Confirmation popup is not displayed on phone order page");
			delayWithGivenTime(2000);
						
			// Test Step - 11
			phoneorder.ClickSubmitButton_On_ConfirmationPopup();
			delayWithGivenTime(2000);
			orderconfirmationpage = new Order_Confirmation_Page();
			softassert.assertTrue(orderconfirmationpage.VerifyOrderConfirmationPage(), "Test Step - 11 - Order confirmation page is not displayed");
			
			// Test Step - 12
			orderconfirmationpage = new Order_Confirmation_Page();
			softassert.assertEquals(orderconfirmationpage.getCustomerFname(), "Abish","Test Step - 12 - Added first name on customer section in phoneorder page and compared with order confirmation page displayed first name are not matched");
			softassert.assertEquals(orderconfirmationpage.getCustomerLname(), "David","Test Step - 12 - Added last name on customer section in phoneorder page and compared with order confirmation page displayed last name are not matched");
			softassert.assertEquals(orderconfirmationpage.getCustomerAddress(), "2715 35th Ave","Test Step - 12 - Added address on customer section in phoneorder page and compared with order confirmation page displayed addresses are not matched");
			
			// Test Step - 13
			softassert.assertEquals(orderconfirmationpage.getCustomerCity(), "SisterChicks Flower Shop(123)","Test Step - 13 - Added shop name on customer section in phoneorder page and compared with order confirmation page displayed shopname are not matched");
			
			// Test Step - 14
			softassert.assertEquals(orderconfirmationpage.getRecipientFname(), "Abish","Test Step - 14 - Added first name on recipient section in phoneorder page and compared with order confirmation page displayed first name are not matched");
			softassert.assertEquals(orderconfirmationpage.getRecipientLname(), "David","Test Step - 14 - Added last name on recipient section in phoneorder page and compared with order confirmation page displayed last name are not matched");
			softassert.assertEquals(orderconfirmationpage.getRecipientAddress1(), "3402 Park Blvd","Test Step - 14 - Added address on recipient section in phoneorder page and compared with order confirmation page displayed addresses are not matched");	
			softassert.assertEquals(orderconfirmationpage.getRecipientCity(), "San Diego","Test Step - 14 - Added city on recipient section in phoneorder page and compared with order confirmation page displayed city are not matched");			
			softassert.assertEquals(orderconfirmationpage.getRecipientState(), "CA","Test Step - 14 - Added State on recipient section in phoneorder page and compared with order confirmation page displayed state are not matched");
			softassert.assertEquals(orderconfirmationpage.getRecipientZip(), "92103", "Test Step - 14 - Added zip code on recipient section in phoneorder page and compared with order confirmation page displayed zip code are not matched");

			// Test Step - 15
			softassert.assertEquals(orderconfirmationpage.get_itemcode1(), "rrd", "Test Step - 15 - Added item code on recipient section in phoneorder page and compared with order confirmation page displayed item code are not matched");
			softassert.assertEquals(orderconfirmationpage.get_itemdescription1(), "Red Rose Deluxe", "Test Step - 15 - Added item description on recipient section in phoneorder page and compared with order confirmation page displayed item description are not matched");
			softassert.assertEquals(orderconfirmationpage.get_itemqty1(), "1", "Test Step - 15 - Added item quantity on recipient section in phoneorder page and compared with order confirmation page displayed item quantity are not matched");
			
			if(orderconfirmationpage.get_itemunitprice1()=="$299.00") {
				softassert.assertEquals(orderconfirmationpage.get_itemunitprice1(), "$299.00", "Test Step - 15 - Added item unit price on recipient section in phoneorder page and compared with order confirmation page displayed item unit price are not matched");
			}else if(orderconfirmationpage.get_itemunitprice1()=="$309.00") {
				softassert.assertEquals(orderconfirmationpage.get_itemunitprice1(), "$309.00", "Test Step - 15 - Added item unit price on recipient section in phoneorder page and compared with order confirmation page displayed item unit price are not matched");
			}
			
			// Test Step - 16
			softassert.assertEquals(orderconfirmationpage.get_PaymentType(), "FSN", "Test Step - 16 - Payment type is not displayed on order confirmation page");
			
			// Test Step - 17
			delayWithGivenTime(1000);
			dashboard.ClickOrder();
			delayWithGivenTime(1000);
			logger.info("User click the order menu on hana dashboard page");	
			dashboardorder = new DashboardOrderPage();	                     
			softassert.assertEquals(dashboardorder.validateDashboardOrderPage(),prop.getProperty("livedashboardorderURL"),"Test Step - 14 - Dashboard order page is not displayed");				
			
			// Test Step - 18
			delayWithGivenTime(2000);
			dashboardorder.EnterGlobalSearch(dashboardorder.getInvoiceNumber_WireInDeliveryType_Appears_OnOrderPage());		
			delayWithGivenTime(1000);
			softassert.assertTrue(dashboardorder.Validate_WireInOrderType_Appears_OnOrderPage(),"Test Step - 18 - Wire in order type is not displayed on order page");
			softassert.assertEquals(dashboardorder.get_WireInOrderType_Text_OnOrderPage(),"FSN Order","Test Step - 18 - Wire in order type is not displayed on order page");
			
			// Test Step - 19
			delayWithGivenTime(1000);
			softassert.assertTrue(dashboardorder.Validate_WireInDeliveryType_Appears_OnOrderPage(),"Test Step - 19 - Wire in delivery type is not displayed on order details page");
			softassert.assertEquals(dashboardorder.get_WireInDeliveryType_Text_OnOrderPage(),"Wire In","Test Step - 19 - Wire in delivery type is not displayed on order page");

			// Test Step - 20
			delayWithGivenTime(1000);
			softassert.assertTrue(dashboardorder.Validate_WireInMOP_Appears_OnOrderPage(),"Test Step - 20 - Wire in MOP is not displayed on order details page");
			softassert.assertEquals(dashboardorder.get_WireInMOP_Text_OnOrderPage(),"FSN","Test Step - 20 - Wire in MOP type is not displayed on order page");
		
		} catch (Exception e) {
			e.printStackTrace();
			softassert.fail("Test case failed due to exception " + e.getMessage());
			logger.error("Test case failed due to exception " + e.getMessage());
		} finally {
			softassert.assertAll();
		}
	}
}