package com.hanapos.OrderEntry_Alais_PickUp_PhoneOrder_Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hanapos.pageObjects.Configuration_SettingsPage;
import com.hanapos.pageObjects.DashboardOrderPage;
import com.hanapos.pageObjects.HanaDashBoardPage;
import com.hanapos.pageObjects.LoginPage;
import com.hanapos.pageObjects.Marketing_RemaindersPage;
import com.hanapos.pageObjects.OrderEntry_Alais_PhoneOrderPage;
import com.hanapos.pageObjects.Order_Confirmation_Page;
import com.hanapos.seleniumProjectBase.TestBaseClass;
import com.hanapos.utilities.CustomSoftAssert;

public class Hana_T197_OrderEntryPage_Pickup_ProductSection_CreateRecipe_MarkupSettings_Functionality extends TestBaseClass {
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private OrderEntry_Alais_PhoneOrderPage phoneorder;
	private Configuration_SettingsPage configuration_SettingsPage;
	
	//,dataProvider="fetch_Excel_Data"
	@Test(enabled=true,groups= {"Regression"}) 
	public void Validate_Hana_T197_OrderEntryPage_Pickup_ProductSection_CreateRecipe_MarkupSettings_Functionality_Test() {
		// SoftAssert softassert = new SoftAssert(); - I have modified this to use CustomSoftAssert
		CustomSoftAssert softassert = new CustomSoftAssert();
		
		logger.info("**** Starting  Validate_Hana_T197_OrderEntryPage_Pickup_ProductSection_CreateRecipe_MarkupSettings_Functionality_Test ****");
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
			phoneorder.SearchandSelectItemcodeOnPhoneOrderPage("rrd","rrd-Red Rose Deluxe");
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getProdDetailsItemcode1OnPhoneOrderPage(),"rrd","Test Step - 11 - Item code is not displayed on phone order page product details section");
			softassert.assertEquals(phoneorder.getProdDetailsItemDescription1OnPhoneOrderPage(),"Red Rose Deluxe","Test Step - 11 - Item description is not displayed on phone order page product details section"); 
			softassert.assertEquals(phoneorder.getProdItemQty1OnPhoneOrderPage(),"1","Test Step - 11 - Item quantity is not displayed on phone order page product details section");
			
			if(phoneorder.getUnitPriceOnProdDetails()=="299.00"){ 
				softassert.assertEquals(phoneorder.getUnitPriceOnProdDetails(),"299.00","Test Step - 11 - Item price is not displayed on phone order page product details section");
			}else if (phoneorder.getUnitPriceOnProdDetails()=="309.00") {
				softassert.assertEquals(phoneorder.getUnitPriceOnProdDetails(),"309.00","Test Step - 11 - Item price is not displayed on phone order page product details section");
			}
			
			// Test Step - 12
			delayWithGivenTime(2000);
			softassert.assertTrue(phoneorder.Verify_ProductDetails_Row1_Recipe(),"Test Step - 12 - Recipe icon is not displayed on row 1 product");		
			
			// Test Step - 13
			phoneorder.Click_ProductDetails_Row1_Recipe();
			delayWithGivenTime(2000);
			softassert.assertTrue(phoneorder.Verify_CreateRecipe_Popup(),"Test Step - 13 - Create Recipe popup is not displayed");
			
			// Test Step - 14
			softassert.assertTrue(phoneorder.Verify_CreateRecipe_Popup_SettingsIcon_IsDisplayed(),"Test Step - 14 - Settings icon is not displayed on Create Recipe popup");
			
			// Test Step - 15
			phoneorder.Click_CreateRecipePopup_Settings_Button();
			softassert.assertTrue(phoneorder.Verify_MarkupSettings_Popup_IsDisplayed(),"Test Step - 15 - In Settings icon markup settings popup is not displayed on Create Recipe popup");
			
			// Test Step - 16
			phoneorder.Enter_MarkupPercentage_Field1("20.00");
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.get_entered_markupPercentage_Field1(),"20.00", "Test Step - 16 - Markup percentage is not displayed on Create Recipe popup");
			
			// Test Step - 17
			phoneorder.Click_SaveBtn_Markup_SettingsPopup();
			delayWithGivenTime(1000);
			softassert.assertEquals(phoneorder.verifySuccessToastMessageText(),"Component Updated!","Test Step - 17 - Toast message is not displayed on Create Recipe popup after update the markup percentage");
			
			// Test Step - 18
			delayWithGivenTime(2000);
			phoneorder.Click_CreateRecipePopup_Settings_Button();
			softassert.assertTrue(phoneorder.Verify_MarkupSettings_Popup_IsDisplayed(),"Test Step - 18 - In Settings icon markup settings popup is not displayed on Create Recipe popup");
		
			// Test Step - 19
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.get_entered_markupPercentage_Field1(),"20.00", "Test Step - 19 - Markup percentage is not displayed on Create Recipe popup");
			
			// Test Step - 20
			phoneorder.Click_CloseIconButton_MarkupSettingsPopup();
			
			// Test Step - 21
			phoneorder.Click_CloseIcon_CreateRecipePopup();
			delayWithGivenTime(2000);
			phoneorder.Click_NoNeedConfirmationAlert_CreateRecipe_Popup();
			
			// Test Step - 22
			dashboard = new HanaDashBoardPage();
			dashboard.Click_settingsSubmenu();
			delayWithGivenTime(1000);
			configuration_SettingsPage = new Configuration_SettingsPage();
			softassert.assertTrue(configuration_SettingsPage.Verify_Configuration_SettingsPage(),"Test Step - 22 - Configuration Settings page is not displayed"); ;
			
			// Test Step - 23
			configuration_SettingsPage.Click_InventoryManagement_LeftMenu();
			softassert.assertTrue(configuration_SettingsPage.Verify_InventoryManagement_Section_ConfigurationSetting_IsDisplayed(),"Test Step - 23 - Inventory Management section is not displayed");
			
			// Test Step - 24
			configuration_SettingsPage.Click_InventoryManagement_Section_ComponentCategory();
			softassert.assertTrue(configuration_SettingsPage.Verify_componentCategory_Page_IsDisplayed(),"Test Step - 24 - Component Category page is not displayed");
			
			// Test Step - 25
			softassert.assertEquals(configuration_SettingsPage.get_ComponentMarkup_Value(),"20.00","Test Step - 25 - Markup value is not updated on configuration settings - Inventory Management - Component Category page");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Test case failed due to exception " + e.getMessage());
			logger.error("Test case failed due to exception " + e.getMessage());
		} finally {
			softassert.assertAll();
		}
	}
}