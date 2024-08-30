package com.hanapos.OrderEntry_Alais_PickUp_PhoneOrder_Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hanapos.pageObjects.DashboardOrderPage;
import com.hanapos.pageObjects.HanaDashBoardPage;
import com.hanapos.pageObjects.LoginPage;
import com.hanapos.pageObjects.OrderEntry_Alais_PhoneOrderPage;
import com.hanapos.pageObjects.Order_Confirmation_Page;
import com.hanapos.seleniumProjectBase.TestBaseClass;

public class Hana_T160_OrderEntry_Pickup_OrderDetailsSection_SendRemainderField_FT extends TestBaseClass {
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private OrderEntry_Alais_PhoneOrderPage phoneorder;

	
	//,dataProvider="fetch_Excel_Data"
	@Test(enabled=true,groups= {"Regression"}) 
	public void Validate_Hana_T160_OrderEntry_Pickup_OrderDetailsSection_SendRemainderField_Functionality_Test() {
		SoftAssert softassert = new SoftAssert();
		logger.info("**** Starting  Validate_Hana_T160_OrderEntry_Pickup_OrderDetailsSection_SendRemainderField_Functionality_Test ****");
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
			softassert.assertTrue(phoneorder.Verify_OrderDetailsSectionAppears(),"Test Step - 5 - Order details section is not displayed");
			
			// Test Step - 6
			phoneorder.ClickPickupTypeOnPhoneOrderPage();
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getHighlightedColorOnPickupTypeOnPhoneOrderPage(),"#2f9bc8", "Test Step - 5 - Pickup type is not highlighted in blue color");		
		
			// Test Step - 7
			softassert.assertFalse(phoneorder.Verify_SendRemainder_OnOrderDetailsIsAppears(),"Test Step - 7 - Send remainder checkbox is displayed on Order details section");
			
			// Test Step - 8
			phoneorder.SelectOccasion_On_OrderDetails_In_PhoneOrderPage("Birthday");
			softassert.assertEquals(phoneorder.getSelectedOccasionOnPhoneOrderPage(),"Birthday","Test Step - 8 - Order details selected occasion is not displayed");
			
			// Test Step - 9
			softassert.assertTrue(phoneorder.Verify_SendRemainder_OnOrderDetailsIsAppears(),"Test Step - 9 - Send remainder checkbox is not displayed on Order details section");
	
			// Test Step - 10
			phoneorder.SelectOccasion_On_OrderDetails_In_PhoneOrderPage("Baby Shower");
			softassert.assertEquals(phoneorder.getSelectedOccasionOnPhoneOrderPage(),"Baby Shower","Test Step - 10 - Order details selected occasion is not displayed");
			
			// Test Step - 11
			softassert.assertFalse(phoneorder.Verify_SendRemainder_OnOrderDetailsIsAppears(),"Test Step - 11 - Send remainder checkbox is not displayed on Order details section");
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Test case failed due to exception " + e.getMessage());
			logger.error("Test case failed due to exception " + e.getMessage());
		} finally {
			softassert.assertAll();
		}
	}
}