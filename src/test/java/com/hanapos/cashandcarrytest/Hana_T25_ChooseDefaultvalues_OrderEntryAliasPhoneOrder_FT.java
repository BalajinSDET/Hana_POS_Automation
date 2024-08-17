package com.hanapos.cashandcarrytest;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.hanapos.pageObjects.CashAndCarryPage;
import com.hanapos.pageObjects.CashAndCarryPaymentPage;
import com.hanapos.pageObjects.HanaDashBoardPage;
import com.hanapos.pageObjects.LoginPage;
import com.hanapos.pageObjects.OrderEntry_Alais_PhoneOrderPage;
import com.hanapos.seleniumProjectBase.TestBaseClass;
import com.hanapos.utilities.DataLibrary;

public class Hana_T25_ChooseDefaultvalues_OrderEntryAliasPhoneOrder_FT extends TestBaseClass{
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private CashAndCarryPage cashandcarry;
	private OrderEntry_Alais_PhoneOrderPage phoneorder;
	public static final String dataSheetName = "Hana_T22";
	SoftAssert softassert = new SoftAssert();

	@DataProvider(name = "fetch_Excel_Data")  
	public Object[][] fetchData() throws IOException { 
		return DataLibrary.readExcelData(dataSheetName); 
	}

	/*
	 * HANA-T22 - 1 to 29 - Verify choose default values Functionality
	 */
	// retryAnalyzer= com.hanapos.utilities.RetryTest.class,
	@Test(enabled=true,groups= {"Regression"},dataProvider="fetch_Excel_Data",threadPoolSize = 3) 
	public void  Validate_Hana_T25_Choose_Default_Values_OrderEntryAliasPhoneOrderPage_Test(String bankname,String checknumber,String nameofcheck,String Splqty,String qty,String occasion,String salespersonname,String customershortname, 
			String sourcecode,String searchandselectitemcode) throws InterruptedException, IOException {

		// Test Step - 1
		logger.info("**** Starting Hana_T25_ChooseDefaultvalues_Cash_and_Carry_Functional Test  ****");
		logger.info("User on the hana pos login page and entering valid username and password..");
		try {
			lp = new LoginPage();
			softassert.assertTrue(lp.LoginPageIsDisplayed(),"Login page is not displayed");
			logger.info("User on the hana pos login page");

			// Test Step - 2
			lp.EnterUserName(prop.getProperty("username"));
			logger.info("User entered username as "+prop.getProperty("username"));
			lp.EnterPassword(prop.getProperty("password"));
			logger.info("User entered password as "+prop.getProperty("password"));
			lp.ClickLoginButton();
			logger.info("Clicked on Login button..");

			dashboard = new HanaDashBoardPage();
			Assert.assertTrue(dashboard.VerifyHanaDashBoardPage(),"Page does not navigated to hana dashboard page");
			logger.info("User navigated to hana dashboard page sucessfully");

			// Test Step - 3
			dashboard.SelectShopNameDropDown(prop.getProperty("shopname"));
			logger.info("User selected shop name as "+prop.getProperty("shopname") +" from dropdown in the hana dashboard");
			dashboard.CashAndCarryMenuClick();							
			cashandcarry = new CashAndCarryPage();
			logger.info("User hover the mouse on New order and click on Cash and Carry..");
			Assert.assertTrue(cashandcarry.VerifyCashAndCarryPage(), "Cash And Carry page is not displayed");
			logger.info("User verify the Cash and Carry page is displayed..");

			// Test Step - 4
			cashandcarry.ClickChooseDefaultValue();
			logger.info("User clicked on Choose Default Values button..");
			softassert.assertTrue(cashandcarry.ValidateChoosePageDefaultValuePopupIsDisplayed());
			logger.info("User verify the Choose Default Values popup is displayed..");

			// Test Step - 5
			cashandcarry.SelectShopOnChoosePageDefaultValues(prop.getProperty("shopname"));
			logger.info("User selected shop name as "+prop.getProperty("shopname"));
			delayWithGivenTime(2000);
			softassert.assertEquals(cashandcarry.getFirstSelectedOptionOnPageNameDD(),"Cash & Carry","Page Name is not displayed as Cash & Carry");
			logger.info("User verify the Page Name is displayed as Cash & Carry..");
			softassert.assertEquals(cashandcarry.getSelectShopOnCPDV(),prop.getProperty("shopname"),"Page Name is not displayed as Cash & Carry");
			logger.info("User verify the Page Name is displayed as Cash & Carry..");

			// Test Step - 6
			cashandcarry.SelectPageNameOnCPDV("PhoneOrder");

			// Test Step - 7
			cashandcarry.EnterItemCodeOnCPDV("RRD");
			delayWithGivenTime(300);
			softassert.assertEquals(cashandcarry.getEnteredItemCodeOnCPDV(), "RRD", "Entered item code is displayed");

			//Test Step - 8
			cashandcarry.EnterQtyonPhoneOrderCPDV("1");
			delayWithGivenTime(300);
			softassert.assertEquals(cashandcarry.getEnteredQtyonPhoneOrderCPDV(), "1","Entered Qty is displayed");

			// Test Step - 9
			cashandcarry.EnterQtyonPhoneOrderCPDV("AB*&");
			delayWithGivenTime(300);
			softassert.assertEquals(cashandcarry.getEnteredQtyonPhoneOrderCPDV(), "","Entered alpha & spl characters are accepted in qty field");
			cashandcarry.EnterQtyonPhoneOrderCPDV("1");
			
			// Test Step - 10
			cashandcarry.EnterRecipientPhone("HANAPOSPHN");
			delayWithGivenTime(300);
			softassert.assertEquals(cashandcarry.getEnteredRecipientPhoneonPhoneOrderCPDV(),"", "Entered alpha characters are accepted in recipent phone field");

			// Test Step - 11
			cashandcarry.EnterRecipientPhone("8324872387");
			delayWithGivenTime(300);
			softassert.assertEquals(cashandcarry.getEnteredRecipientPhoneonPhoneOrderCPDV(),"832-487-2387", "Entered alpha characters are accepted in recipent phone field");

			// Test Step - 12
			cashandcarry.EnterZipcodeOnPhoneOrderCPDV("sd&^&");
			delayWithGivenTime(300);
			softassert.assertEquals(cashandcarry.getEnteredZipcodeOnPhoneOrderCPDV(),"", "Entered alpha characters are accepted in zipcode field");

			// Test Step - 13
			cashandcarry.EnterZipcodeOnPhoneOrderCPDV("32013");
			delayWithGivenTime(300);
			softassert.assertEquals(cashandcarry.getEnteredZipcodeOnPhoneOrderCPDV(),"32013", "Entered alpha characters are accepted in zipcode field");

			// Test Step - 14
			cashandcarry.SelectDefaultWireInMethod("FSN");
			delayWithGivenTime(300);
			softassert.assertEquals(cashandcarry.getSelectedDefaultWireInMethod(), "FSN","Selected data is not displayed");

			// Test Step - 15
			cashandcarry.SelectDefaultWireOutMethod("Bloomnet");
			delayWithGivenTime(300);
			softassert.assertEquals(cashandcarry.getSelectedDefaultWireOutMethod(), "Bloomnet","Selected data is not displayed");

			// Test Step - 16
			cashandcarry.SelectDefaultPaymentType("Check");
			delayWithGivenTime(300);
			softassert.assertEquals(cashandcarry.getSelectedDefaultPaymentType(), "Check","Selected data is not displayed");

			// Test Step -17
			cashandcarry.SelectDefaultCustomerType("Retail");
			delayWithGivenTime(300);
			softassert.assertEquals(cashandcarry.getSelectedDefaultCustomerType(), "Retail","Selected data is not displayed");

			// Test Step - 18
			cashandcarry.SelectDefaultSalesPerson("Stuart");
			delayWithGivenTime(300);
			softassert.assertEquals(cashandcarry.getSelectedDefaultSalesPerson(), "Stuart","Selected data is not displayed");

			// Test Step - 19
			cashandcarry.SelectDefaultCountry("United States");
			delayWithGivenTime(300);
			softassert.assertEquals(cashandcarry.getSelectedDefaultCountry(), "United States","Selected data is not displayed");

			// Test Step - 20
			cashandcarry.SelectDefaultLocation("Business");
			delayWithGivenTime(300);
			softassert.assertEquals(cashandcarry.getSelectedDefaultLocation(), "Business","Selected data is not displayed");

			// Test Step - 21
			cashandcarry.SelectDefaultOccasion("Birthday");
			delayWithGivenTime(300);
			softassert.assertEquals(cashandcarry.getSelectedDefaultOccasion(), "Birthday","Selected data is not displayed");

			// Test Step - 22
			cashandcarry.SelectDefaultOrderType("Delivery");
			delayWithGivenTime(300);
			softassert.assertEquals(cashandcarry.getSelectedDefaultOrderType(), "Delivery","Selected data is not displayed");

			// Test Step - 23
			cashandcarry.ClickCloseIconOnChooseDefaultValuesPage();
			Assert.assertTrue(cashandcarry.VerifyCashAndCarryPage(), "Cash And Carry page is not displayed");
			logger.info("User verify the Cash and Carry page is displayed..");

			// Test Step - 24
			delayWithGivenTime(3000);
			cashandcarry.ClickChooseDefaultValue();
			logger.info("User clicked on Choose Default Values button..");
			delayWithGivenTime(2000);
			softassert.assertTrue(cashandcarry.ValidateChoosePageDefaultValuePopupIsDisplayed());
			logger.info("User verify the Choose Default Values popup is displayed..");

			cashandcarry.SelectShopOnChoosePageDefaultValues(prop.getProperty("shopname"));
			logger.info("User selected shop name as "+prop.getProperty("shopname"));
			delayWithGivenTime(2000);
			softassert.assertEquals(cashandcarry.getFirstSelectedOptionOnPageNameDD(),"Cash & Carry","Page Name is not displayed as Cash & Carry");
			logger.info("User verify the Page Name is displayed as Cash & Carry..");
			softassert.assertEquals(cashandcarry.getSelectShopOnCPDV(),prop.getProperty("shopname"),"Page Name is not displayed as Cash & Carry");
			logger.info("User verify the Page Name is displayed as Cash & Carry..");

			cashandcarry.SelectPageNameOnCPDV("PhoneOrder");

			cashandcarry.EnterItemCodeOnCPDV("RRD");
			softassert.assertEquals(cashandcarry.getEnteredItemCodeOnCPDV(), "RRD", "Entered item code is displayed");

			cashandcarry.EnterQtyonPhoneOrderCPDV("1");
			softassert.assertEquals(cashandcarry.getEnteredQtyonPhoneOrderCPDV(), "1","Entered Qty is displayed");

			cashandcarry.EnterQtyonPhoneOrderCPDV("AB*&");

			softassert.assertEquals(cashandcarry.getEnteredQtyonPhoneOrderCPDV(), "","Entered alpha & spl characters are accepted in qty field");
			cashandcarry.EnterQtyonPhoneOrderCPDV("1");

			cashandcarry.EnterRecipientPhone("HANAPOSPHN");

			softassert.assertEquals(cashandcarry.getEnteredRecipientPhoneonPhoneOrderCPDV(),"", "Entered alpha characters are accepted in recipent phone field");

			cashandcarry.EnterRecipientPhone("832-487-2387");

			softassert.assertEquals(cashandcarry.getEnteredRecipientPhoneonPhoneOrderCPDV(),"832-487-2387", "Test Step - 24 - Entered alpha characters are accepted in recipent phone field");

			cashandcarry.EnterZipcodeOnPhoneOrderCPDV("sd&^&");
			
			softassert.assertEquals(cashandcarry.getEnteredZipcodeOnPhoneOrderCPDV(),"", "Entered alpha characters are accepted in zipcode field");

			cashandcarry.EnterZipcodeOnPhoneOrderCPDV("32013");

			softassert.assertEquals(cashandcarry.getEnteredZipcodeOnPhoneOrderCPDV(),"32013", "Entered alpha characters are accepted in zipcode field");

			cashandcarry.SelectDefaultWireInMethod("FSN");

			softassert.assertEquals(cashandcarry.getSelectedDefaultWireInMethod(), "FSN","Selected data is not displayed");

			cashandcarry.SelectDefaultWireOutMethod("Bloomnet");

			softassert.assertEquals(cashandcarry.getSelectedDefaultWireOutMethod(), "Bloomnet","Selected data is not displayed");

			cashandcarry.SelectDefaultPaymentType("Check");

			softassert.assertEquals(cashandcarry.getSelectedDefaultPaymentType(), "Check","Selected data is not displayed");

			cashandcarry.SelectDefaultCustomerType("Corporate");

			softassert.assertEquals(cashandcarry.getSelectedDefaultCustomerType(), "Corporate","Selected data is not displayed");

			cashandcarry.SelectDefaultSalesPerson("Stuart");

			softassert.assertEquals(cashandcarry.getSelectedDefaultSalesPerson(), "Stuart","Selected data is not displayed");

			cashandcarry.SelectDefaultCountry("Canada");

			softassert.assertEquals(cashandcarry.getSelectedDefaultCountry(), "Canada","Selected data is not displayed");

			cashandcarry.SelectDefaultLocation("Business");
			delayWithGivenTime(1000);
			softassert.assertEquals(cashandcarry.getSelectedDefaultLocation(), "Business","Selected data is not displayed");

			cashandcarry.SelectDefaultOccasion("Birthday");

			softassert.assertEquals(cashandcarry.getSelectedDefaultOccasion(), "Birthday","Selected data is not displayed");

			cashandcarry.SelectDefaultOrderType("Delivery");
			
			softassert.assertEquals(cashandcarry.getSelectedDefaultOrderType(), "Delivery","Selected data is not displayed");

			cashandcarry.ClickUpdateButtonOnChooseDefaultValuesPage();
			
			// Test Step - 25
			cashandcarry.ClickCloseIconOnChooseDefaultValuesPage();
			delayWithGivenTime(1000);
			
			softassert.assertTrue(cashandcarry.VerifySuccessMessageIsDisplayed(), "Toast message is not displayed");
			Assert.assertTrue(cashandcarry.VerifyCashAndCarryPage(), "Cash And Carry page is not displayed");
			logger.info("User verify the Cash and Carry page is displayed..");

			// Test Step - 26
			dashboard.ClickOrderEntry();
			phoneorder = new OrderEntry_Alais_PhoneOrderPage();
			softassert.assertEquals(phoneorder.GetOrderEntryPageTitle(),"Hana | Order","Phone Order page is not displayed");

			// Test Step - 27
			phoneorder.ClickDefaultValuesIcon();
			phoneorder.VerifyChoosePageDefaultValuesPopup();

			// Test Step - 28
			softassert.assertEquals(phoneorder.getItemCodeOnCPDV(),"RRD");
			softassert.assertEquals(phoneorder.getItemqtyOnPhoneOrderPage(),"1");
			softassert.assertEquals(phoneorder.getDisplayedRecipientphoneOnPhoneOrderPage(),"832-487-2387");
			softassert.assertEquals(phoneorder.getDisplayedRecipientZipcodeOnPhoneOrderPage(),"32013");
			softassert.assertEquals(phoneorder.getSelectedWireInMethodOnPhoneOrderPage(),"FSN");
			softassert.assertEquals(phoneorder.getSelectedWireOutMethodOnPhoneOrderPage(),"Bloomnet");
			softassert.assertEquals(phoneorder.getSelectedPaymentTypeOnPhoneOrderPage(),"Check");
			softassert.assertEquals(phoneorder.getSelectedCustomerTypeOnPhoneOrderPage(),"Corporate");
			softassert.assertEquals(phoneorder.getSelectedSalesPersonOnPhoneOrderPage(),"Stuart");
			softassert.assertEquals(phoneorder.getSelectedCountryOnPhoneOrderPage(),"Canada");
			softassert.assertEquals(phoneorder.getSelectedLocationOnPhoneOrderPage(),"Business");
			softassert.assertEquals(phoneorder.getSelectedOccasionOnPhoneOrderPage(),"Birthday");
			softassert.assertEquals(phoneorder.getSelectedOrderTypeOnPhoneOrderPage(),"Delivery");

			// Test Step - 29
			phoneorder.ClickCloseIconOnChoosePageDefaultValuesPopup();
			
			// Test Step - 30
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getProdDetailsItemcode1OnPhoneOrderPage(),"RRD");
			
			// Test Step - 31
			delayWithGivenTime(500);
			softassert.assertEquals(phoneorder.getProdItemQty1OnPhoneOrderPage(),"1");

			// Test Step - 32
			
			delayWithGivenTime(500);
			softassert.assertEquals(phoneorder.getRecipientPhoneOnPhoneOrderPage(),"832-487-2387");
			
			// Test Step - 33
			
			delayWithGivenTime(500);
			softassert.assertEquals(phoneorder.getRecipientZipcodeOnPhoneOrderPage(),"32013");
				
			// Test Step - 34
			delayWithGivenTime(500);
			phoneorder.ClickWireInMethodOnPhoneOrderPage();

			// Test Step - 35
			softassert.assertEquals(phoneorder.getDisplayedWireInSelectedOption(), "FSN");;

			// Test Step - 36
			delayWithGivenTime(500);
			phoneorder.ClickWireOutMethodOnPhoneOrderPage();
				
			// Test Step - 37
			softassert.assertEquals(phoneorder.getDisplayedWireOutSelectedOption(), "Bloomet");

			// Test Step - 38
			delayWithGivenTime(500);
			phoneorder.ClickdeliveryTypeOnPhoneOrderPage();
			
			// Test Step - 39 
			softassert.assertEquals(phoneorder.getDisplayedPaymentTypeSelectedOption(), "Check");
			delayWithGivenTime(500);
			phoneorder.ClickPickupTypeOnPhoneOrderPage();
			softassert.assertEquals(phoneorder.getDisplayedPaymentTypeSelectedOption(), "Check");
			
			// Test Step - 40
			delayWithGivenTime(500);
			softassert.assertEquals(phoneorder.getSelectedCustTypeOnPhoneOrderPage(), "Corporate");
			
			// Test Step - 41
			delayWithGivenTime(500);
			softassert.assertEquals(phoneorder.getDisplayedSalesPersonSelectedOption(), "Stuart Markwood");
			
			// Test Step - 42
			delayWithGivenTime(500);
			softassert.assertEquals(phoneorder.getDisplayedCountryonRecipientSecOnPhoneOrderPage(), "Canada");
			
			// Test Step - 43	
			delayWithGivenTime(500);
			softassert.assertEquals(phoneorder.getDisplayedLocationonRecipientSecOnPhoneOrderPage(), "Business");
			
			// Test Step - 44
			delayWithGivenTime(500);
			softassert.assertEquals(phoneorder.getSelectedOccasionOnPhoneOrderPage(), "Birthday");
			
			// Test Step - 45
			delayWithGivenTime(1000);
			phoneorder.ClickPickupTypeOnPhoneOrderPage();
			delayWithGivenTime(1000);
			softassert.assertTrue(phoneorder.verifyPickupOrderTypesIsHighlighted(),"pickup order is not highlighted");
			delayWithGivenTime(2000);
			phoneorder.ClickdeliveryTypeOnPhoneOrderPage();
			delayWithGivenTime(1000);
			softassert.assertTrue(phoneorder.verifyDeliveryOrderTypesIsHighlighted(),"delivery order is not highlighted");
			delayWithGivenTime(1000);
			phoneorder.ClickWireInMethodOnPhoneOrderPage();
			delayWithGivenTime(1000);
			softassert.assertTrue(phoneorder.verifyWireInOrderTypesIsHighlighted(),"wire in order type is not highlighted");
			delayWithGivenTime(1000);
			phoneorder.ClickWireOutMethodOnPhoneOrderPage();
			delayWithGivenTime(1000);
			softassert.assertTrue(phoneorder.verifyWireOutOrderTypesIsHighlighted(),"wireout order type is not highlighted");

			softassert.assertAll();
			logger.info("**** Finished Hana_T25_ChooseDefaultvalues_OrderEntryAliasPhoneOrder_FT Test Case  ****");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
			logger.error("**** Failed Hana_T25_ChooseDefaultvalues_OrderEntryAliasPhoneOrder_FT Test Case  ****");
		}	

	}
}
