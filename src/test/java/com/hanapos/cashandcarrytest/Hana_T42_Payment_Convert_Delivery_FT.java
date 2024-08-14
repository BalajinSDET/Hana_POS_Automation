package com.hanapos.cashandcarrytest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.hanapos.pageObjects.CashAndCarryPage;
import com.hanapos.pageObjects.CashAndCarryPaymentPage;
import com.hanapos.pageObjects.CustomerPage;
import com.hanapos.pageObjects.DashboardOrderPage;
import com.hanapos.pageObjects.HanaDashBoardPage;
import com.hanapos.pageObjects.LoginPage;
import com.hanapos.pageObjects.OrderEntry_Alais_PhoneOrderPage;
import com.hanapos.seleniumProjectBase.TestBaseClass;
import com.hanapos.utilities.DataLibrary;

public class Hana_T42_Payment_Convert_Delivery_FT extends TestBaseClass{
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private CashAndCarryPage cashandcarry;
	private CashAndCarryPaymentPage cashandcarrypayment;
	
	private OrderEntry_Alais_PhoneOrderPage phoneorder = new OrderEntry_Alais_PhoneOrderPage();
	public static final String dataSheetName = "Hana_T42";
	SoftAssert softassert = new SoftAssert();

	@DataProvider(name = "fetch_Excel_Data") 
	public Object[][] fetchData() throws IOException { 
		return DataLibrary.readExcelData(dataSheetName); 
	}

	/*
	 * HANA-T37 - 1 to 33 - Verify split payment Functionality
	 */
//retryAnalyzer= com.hanapos.utilities.RetryTest.class,
	@Test(enabled=true,groups= {"Regression"},dataProvider="fetch_Excel_Data") 
	public void  Validate_Hana_T42_Payment_Convert_Delivery_Test(String searchandselectitemcode, String customername, String occasion) throws InterruptedException, IOException {
		// Test Step - 1
		logger.info("**** Starting Hana_T42_Payment_Convert_Delivery_CashAndCarryTest  ****");
		try {
			lp = new LoginPage();
			softassert.assertTrue(lp.LoginPageIsDisplayed(),"Login page is not displayed");
			logger.info("User on the hana pos login page");
			
			// Test Step - 2
			lp.EnterUserName(prop.getProperty("username"));
			logger.info("User entered username as "+prop.getProperty("username"));
			lp.EnterPassword(prop.getProperty("password"));
			logger.info("User entered username as "+prop.getProperty("password"));
			lp.ClickLoginButton();
			logger.info("User clicked on Login button..");

			dashboard = new HanaDashBoardPage();
			Assert.assertTrue(dashboard.VerifyHanaDashBoardPage(),"Page does not navigated to hana dashboard page");
			logger.info("User navigated to hana dashboard page sucess..");
			
			// Test Step - 3
			dashboard.SelectShopNameDropDown(prop.getProperty("shopname"));
			logger.info("User selected the shop name as "+prop.getProperty("shopname")+ "in dashboard page");
			dashboard.CashAndCarryMenuClick();							
			cashandcarry = new CashAndCarryPage();
			logger.info("User hover the mouse on New order and click on Cash and Carry..");
			softassert.assertTrue(cashandcarry.VerifyCashAndCarryPage(), "Cash And Carry page is not displayed");
			logger.info("User verify the Cash and Carry page is displayed..");
			
			// Test Step - 4
			cashandcarry.SelectShopName(prop.getProperty("shopname")); //"Hana POS (Canada)"
			logger.info("User select the shop name as "+prop.getProperty("shopname")+ "in cash and carry page");
			
			//Test Step - 5
			cashandcarry.SelectClerkName(prop.getProperty("clerkname")); //"Automation clerk desc"
			logger.info("User select the clerk name as "+prop.getProperty("clerkname"));
			
			// Test Step - 6
			cashandcarry.SelectEmployeeName(prop.getProperty("employeename")); //"QA Team Automation"
			logger.info("User select the employee name as "+prop.getProperty("employeename"));

			// Test Step - 7
			cashandcarry.SearchAndSelectTheItemCode(searchandselectitemcode);
			softassert.assertEquals(cashandcarry.ItemDescriptionValueIsExist(), "Red Rose Deluxe");	
			softassert.assertEquals(cashandcarry.ItemQtyValueIsExist(), "1");
			
			if(cashandcarry.ItemPriceValueIsExist()=="299") {
				softassert.assertEquals(cashandcarry.ItemPriceValueIsExist(), "299","Item price is not matched with search and selected item code");
			}else if(cashandcarry.ItemPriceValueIsExist()=="309") {
				softassert.assertEquals(cashandcarry.ItemPriceValueIsExist(), "309","Item price is not matched with search and selected item code");
			}	
			
			softassert.assertEquals(cashandcarry.ItemDiscountAmountIsExist(),"0");
			softassert.assertEquals(cashandcarry.ItemDiscountPercentageValueIsExist(), "0");

			// Test Step - 8
			cashandcarry.ClickAddItem();
			softassert.assertTrue(cashandcarry.VerifyAddedItem());
			softassert.assertEquals(cashandcarry.getAddedItemCode(),"rrd");
			softassert.assertEquals(cashandcarry.GetAddedItemDescription(),"Red Rose Deluxe");
			softassert.assertEquals(cashandcarry.GetAddedItemQty(), "1");
			
			if(cashandcarry.GetAddedItemExtPrice()=="$299.00") {
				softassert.assertEquals(cashandcarry.GetAddedItemExtPrice(), "$299.00");
			}else if(cashandcarry.GetAddedItemExtPrice()=="$309.00") {
				softassert.assertEquals(cashandcarry.GetAddedItemExtPrice(), "$309.00");
			}
			
			if(cashandcarry.GetAddedItemPrice()=="$299.00") {
				softassert.assertEquals(cashandcarry.GetAddedItemPrice(), "$299.00");
			}else if(cashandcarry.GetAddedItemPrice()=="$309.00") {
				softassert.assertEquals(cashandcarry.GetAddedItemPrice(), "$309.00");
			}
			
			softassert.assertEquals(cashandcarry.GetAddedItemDiscountAmount(), "$ 0.00");
			softassert.assertEquals(cashandcarry.GetAddedItemDiscountPercentage(),"0.00");

			
			// Test Step - 09
			delayWithGivenTime(2000);
			cashandcarry.ClickParticularProdTitle();
			logger.info("User click on the particular product tile");
			softassert.assertEquals(cashandcarry.getAddedItemCodeRow2(),"ballonsYY");
			logger.info("User verify add the title product to the Cash and Carry page is displayed..");		
			
			// Test Step - 10
			cashandcarry.EnterCustomerName(customername);
			logger.info("User search and select the created customer ");
			cashandcarry.SelectTaxType("Tax Exemption");
			cashandcarry.SelectOccasion(occasion);
			logger.info("User select the Occasion as Birthday");
			
			cashandcarry.ClickPayButton();
			logger.info("User click on Pay button");
			
			delayWithGivenTime(2000);
			cashandcarrypayment = new CashAndCarryPaymentPage();
			softassert.assertTrue(cashandcarrypayment.IsPaymentPageDisplayed(),"Cash And Carry payment page is not displayed");
			logger.info("User navigated to Cash And Carry payment page successfully");
			
			// Test Step - 11
			cashandcarrypayment.ClickConvertToDeliveryBtn();
			delayWithGivenTime(2000);
			
			
			// Test Step -  13
			delayWithGivenTime(2000);
			dismissAlert();
			//	RobotDismissAlert();
			
			// Test Step - 14
			delayWithGivenTime(2000);
			cashandcarrypayment.ClickConvertToDeliveryBtn();
			delayWithGivenTime(2000);
			
			// Test Step - 15
			delayWithGivenTime(2000);
			RobotAccept_LeaveKey_Alert();
			
			// Test Step -16
			delayWithGivenTime(2000);
			phoneorder = new OrderEntry_Alais_PhoneOrderPage();	
			softassert.assertEquals(phoneorder.GetOrderEntryPageTitle(), "Hana | Order", "phone order page is not displayed");
			
			phoneorder.ClickDefaultValuesIcon();
			delayWithGivenTime(3000);
			softassert.assertTrue(phoneorder.VerifyChoosePageDefaultValuesPopup(),"choose page default values popup is not displayed");
			delayWithGivenTime(1000);
			phoneorder.getItemCodeOnCPDV();
			phoneorder.getQtyOnCPDV();
			delayWithGivenTime(500);
			phoneorder.getOccasionOnCPDV();
			phoneorder.getcustomerTypeOnCPDV();
			delayWithGivenTime(500);
			phoneorder.ClickCloseIconOnChoosePageDefaultValuesPopup();
			delayWithGivenTime(5000);
			//softassert.assertTrue(phoneorder.VerifyChoosePageDefaultValuesPopup(),"choose page default values popup is not displayed");
			softassert.assertNotEquals("ryi", phoneorder.getItemcodeOnPhoneOrderPage());
			softassert.assertNotEquals("2", phoneorder.getItemqtyOnPhoneOrderPage());
			delayWithGivenTime(500);
			softassert.assertNotEquals("Anniversary", phoneorder.getSelectedOccasionOnPhoneOrderPage());
			softassert.assertNotEquals("Retail", phoneorder.getSelectedCustTypeOnPhoneOrderPage());
			delayWithGivenTime(3000);
			
			// Test Step - 17
			softassert.assertEquals(phoneorder.getFirstnameOnPhoneOrderPage(), "Test");
			softassert.assertEquals(phoneorder.getLastnameOnPhoneOrderPage(), "Automation");
			softassert.assertEquals(phoneorder.getCompanyNameOnPhoneOrderPage(), "Test Automation pvt ltd ");
			delayWithGivenTime(500);
			softassert.assertEquals(phoneorder.getEmailIdOnPhoneOrderPage(), "hanaposqateam@gmail.com");
			softassert.assertEquals(phoneorder.getAddress1OnPhoneOrderPage(), "Test Automation Address, India");
			softassert.assertEquals(phoneorder.getAddress2OnPhoneOrderPage(), "QA Test Automation, Cbe, Tn, India");
			delayWithGivenTime(500);
			softassert.assertEquals(phoneorder.getZipCodeOnPhoneOrderPage(), "641004");
			softassert.assertEquals(phoneorder.getCityOnPhoneOrderPage(), "Coimbatore");
			softassert.assertEquals(phoneorder.getStateOnPhoneOrderPage(), "Tamilnadu");
			softassert.assertEquals(phoneorder.getPhoneNumberOnPhoneOrderPage(), "919-293-9495");
			softassert.assertEquals(phoneorder.getAltPhoneNumberOnPhoneOrderPage(), "919-293-9896");
			
			// Test Step - 18
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getProdDetailsItemcode1OnPhoneOrderPage(),"rrd");
			softassert.assertEquals(phoneorder.getProdDetailsItemcode2OnPhoneOrderPage(),"ballonsYY");
			softassert.assertEquals(phoneorder.getProdDetailsItemDescription1OnPhoneOrderPage(),"Red Rose Deluxe");
			softassert.assertEquals(phoneorder.getProdDetailsItemDescription2OnPhoneOrderPage(),"Ballons small");
			
			// Test Step - 19
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getSelectedOccasionOnPhoneOrderPage(),"Birthday");
			
			softassert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
			logger.error(e.getMessage());
		}
	}
}
