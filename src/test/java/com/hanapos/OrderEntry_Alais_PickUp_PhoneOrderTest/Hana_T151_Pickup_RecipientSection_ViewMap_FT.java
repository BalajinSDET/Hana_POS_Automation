package com.hanapos.OrderEntry_Alais_PickUp_PhoneOrderTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hanapos.pageObjects.DashboardOrderPage;
import com.hanapos.pageObjects.HanaDashBoardPage;
import com.hanapos.pageObjects.LoginPage;
import com.hanapos.pageObjects.OrderEntry_Alais_PhoneOrderPage;
import com.hanapos.pageObjects.Order_Confirmation_Page;
import com.hanapos.seleniumProjectBase.TestBaseClass;

public class Hana_T151_Pickup_RecipientSection_ViewMap_FT extends TestBaseClass {
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private OrderEntry_Alais_PhoneOrderPage phoneorder;
	private DashboardOrderPage dashboardorder;
	private Order_Confirmation_Page orderconfirmationpage;
	
	//,dataProvider="fetch_Excel_Data"
	@Test(enabled=true,groups= {"Regression"}) 
	public void Validate_Hana_T151_Pickup_RecipientSection_ViewMap_Functionality_Test() {
		SoftAssert softassert = new SoftAssert();
		logger.info("**** Starting  Validating_Hana_T151_Pickup_RecipientSection_ViewMap_Functionality_Test ****");
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
			softassert.assertTrue(phoneorder.Verify_RecipientSectionAppears(), "Recipient section is not displayed on Phone order page is not displayed");
		
			// Test Step - 6
			phoneorder.ClickPickupTypeOnPhoneOrderPage();
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getHighlightedColorOnPickupTypeOnPhoneOrderPage(),"#2f9bc8", "Pickup type is not highlighted in blue color");		
		
			//Test Step - 7
			phoneorder.Select_SalesPersonOn_PhoneOrderEntryPage("Stuart Markwood");
			softassert.assertTrue(phoneorder.VerifyCustSectionAppears(), "Test Step - 6 - Customer section is not displayed on phone order page");
			phoneorder.SearchAndSelectCustomerOnCust_Section("Abish");
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
			
			// Test Step - 8
			phoneorder.ClickReciNameOnPhoneOrderPage();
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getReciFirstName(),"Abish","Test Step - 8 - Displayed first name is not matched with customer firstname on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciLastName(),"David","Test Step - 8 - Displayed last name is not matched with customer lastname on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciAddress1(),"114 N CHURCH ST","Test Step - 8 - Displayed recipient address 1 is not matched with customer address 1 field on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciAddress2(),"PICK UP","Test Step - 8 - Displayed recipient address 2 is not matched with customer address 2 on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciPhone(),"956-444-0756","Test Step - 8 - Recipient phone number is not matched with customer phonenumber 1 field on phone order page recipient section");
			softassert.assertEquals(phoneorder.getRecipientPhone2OnPhoneOrderPage(),"956-444-0756","Test Step - 8 - Recipient alt phone number is not matched with customer phonenumber2 on phone order page recipient section");

			// Test Step - 9
			phoneorder.Click_ReciAddress1();
			delayWithGivenTime(1000);
			softassert.assertTrue(phoneorder.Verify_MapIconIsAppear_OnRecipientAddress1(),"Test Step - 9 - Map icon is not displayed on next to recipient address 1 field");
			
			// Test Step - 10
			delayWithGivenTime(1000);
			phoneorder.Click_MapIconOn_RecipientAddress1();
			delayWithGivenTime(1000);
			softassert.assertTrue(phoneorder.Verify_MapDirectionPopup_IsAppear(), "Test Step - 10 - Map direction popup is not displayed on next to recipient address 1 field");
			
			// Test Step - 11
			
			phoneorder.Click_Row1DirectionInstructions_OnMapDirectionPopup();
			
			softassert.assertTrue(phoneorder.Verify_TooltipTextIsAppear_OnMapDirectionPopup(), "Test Step - 11 - Tooltip text is not displayed on selected row 1 direction instructions on next to recipient address 1 field");
			
			// Test Step - 12
			phoneorder.Click_CloseIcon_OnMapDirectionPopup();
			
			softassert.assertFalse(phoneorder.Verify_TooltipClosed_OnMapDirectionPopup(), "Test Step - 12 - Tooltip text is displayed on selected row 1 direction instructions on next to recipient address 1 field");

			// Test Step - 13
			phoneorder.Click_SatelliteMapIcon_OnMapDirectionPopup_ReciAddress1();
			
			// Test Step - 14
			phoneorder.MouseHoverSatelliteTabAndClickLabel_SatelliteMapIcon();
			
			// Test Step - 15
			phoneorder.ClickMapTab_OnMapDirectionPopup_ReciAddress1();
			
			// Test Step - 16
			phoneorder.MouseHoverMapTabAndClickTerrain_OnMapDirectionPopup_ReciAddress1();
			
			// Test Step - 17
			phoneorder.Click_PlusIcon_OnMapDirectionPopup_ReciAddress1();
			delayWithGivenTime(2000);
			softassert.assertTrue(phoneorder.VerifyMapIsZoomIn(),"Test Step - 17 - Map direction popup is not zoom in recipient address 1 field");
			
			// Test Step - 18
			phoneorder.Click_MinusIcon_OnMapDirectionPopup_ReciAddress1();
			delayWithGivenTime(2000);
			softassert.assertTrue(phoneorder.VerifyMapIsZoomOut(),"Test Step - 18 - Map direction popup is not zoom out recipient address 1 field");
			
			// Test Step - 19
			phoneorder.DragAndDrop_DragPegman_OnMapDirectionPopup_ReciAddress1();
			
			//Test Step - 20
			phoneorder.Click_FullscreenIcon_OnMapDirectionPopup_ReciAddress1();
			delayWithGivenTime(2000);
			softassert.assertTrue(phoneorder.Verify_MapDirectionPopup_DisplayedFullScreenMode(),"Test Step - 20 - Map direction popup is not displayed as full screen on recipient address 1 field");
			
			// Test Step - 21
			RobotEscapeKey();
			
			// Test Step - 22
			phoneorder.Click_CloseIconOnMapDirectionPopup_ReciAddress1();
		
			softassert.assertFalse(phoneorder.MapDirectionPopup_isClosed(),"Test Step - 22 - Map direction popup is not closed on  recipient address 1 field");
			
			
			
			
			
			
			
			} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Test case failed due to exception " + e.getMessage());
			logger.error("Test case failed due to exception " + e.getMessage());
		} finally {
			softassert.assertAll();
		}
	}
}