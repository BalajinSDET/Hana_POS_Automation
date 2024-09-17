package com.hanapos.CashandCarry_Testcases;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hanapos.pageObjects.CashAndCarryPage;
import com.hanapos.pageObjects.CashAndCarryPaymentPage;
import com.hanapos.pageObjects.DashboardOrderPage;
import com.hanapos.pageObjects.HanaDashBoardPage;
import com.hanapos.pageObjects.LoginPage;
import com.hanapos.seleniumProjectBase.TestBaseClass;
import com.hanapos.utilities.CustomSoftAssert;
import com.hanapos.utilities.DataLibrary;

public class Hana_T14_Add_Product_FT extends TestBaseClass{
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private CashAndCarryPage cashandcarry;
	private CashAndCarryPaymentPage cashandcarrypayment;
	private DashboardOrderPage dashboardorder;
	public static final String dataSheetName = "Hana_T14";
	public static ExecutorService executorService;
	private static final int THREAD_POOL_SIZE = 2;
	String invoicenumber;
	// SoftAssert softassert = new SoftAssert(); - I have modified this to use CustomSoftAssert
	CustomSoftAssert softassert = new CustomSoftAssert();

	@DataProvider(name = "fetch_Excel_Data") 
	public Object[][] fetchData() throws IOException { 
		return DataLibrary.readExcelData(dataSheetName); 
	}

	/*
	 * HANA-T14 - 1 to 16 - Verify Add Product Functionality
	 */
//retryAnalyzer= com.hanapos.utilities.RetryTest.class,
	@Test(enabled=true,groups= {"Smoke","Regression"},dataProvider="fetch_Excel_Data",threadPoolSize = 2) 
	public void  Validate_Hana_T14_Add_Product_Test(String searchandselectitemcode) throws InterruptedException, IOException {
		// Test Step - 1
		logger.info("**** Starting Hana_T14_Add_Product_CashAndCarryTest  ****");
		logger.debug("capturing application debug logs....");
		try {
			lp = new LoginPage();
			softassert.assertTrue(lp.LoginPageIsDisplayed(),"Test Step - 1 : Login page is not displayed");
			logger.info("User on the hana pos login page");
			
			// Test Step - 2
			logger.info("Entering valid username and password..");
			lp.EnterUserName(prop.getProperty("username"));
			lp.EnterPassword(prop.getProperty("password"));
			lp.ClickLoginButton();
			logger.info("Clicked on Login button..");
			delayWithGivenTime(2000);
			dashboard = new HanaDashBoardPage();
			Assert.assertTrue(dashboard.VerifyHanaDashBoardPage(),"Test Step - 2 : Hana dashboard Page does not navigated to hana dashboard page");
			logger.info("User navigated to hana dashboard page sucess..");
			
			// Test Step - 3
			dashboard.SelectShopNameDropDown(prop.getProperty("shopname"));
			delayWithGivenTime(2000);
			dashboard.CashAndCarryMenuClick();							
			cashandcarry = new CashAndCarryPage();
			logger.info("User hover the mouse on New order and click on Cash and Carry..");
			Assert.assertTrue(cashandcarry.VerifyCashAndCarryPage(), "Test Step - 3 : Cash And Carry page is not displayed");
			logger.info("User verify the Cash and Carry page is displayed..");
			
			// Test Step - 4
			cashandcarry.SelectShopName(prop.getProperty("shopname")); //"Hana POS (Canada)"
			logger.info("User select the shop name");
			
			//Test Step - 5
			cashandcarry.SelectClerkName(prop.getProperty("clerkname")); //"Automation clerk desc"
			logger.info("User select the clerk name");
			
			// Test Step - 6
			cashandcarry.SelectEmployeeName(prop.getProperty("employeename")); //"QA Team Automation"
			logger.info("User select the employee name");

			// Test Step - 7
			softassert.assertTrue(cashandcarry.IsPayButtonDisabled(), "Test Step - 7 : Pay button is not disabled");
			
			// Test Step - 8
			cashandcarry.SearchAndSelectTheItemCode(searchandselectitemcode);

			softassert.assertEquals(cashandcarry.ItemDescriptionValueIsExist(), "Red Rose Deluxe","Test Step - 8 : Item description is not matched with search and selected item code");	
			softassert.assertEquals(cashandcarry.ItemQtyValueIsExist(), "1","Test Step - 8 : Item quantity is not matched with search and selected item code");

			if(cashandcarry.ItemPriceValueIsExist()=="299") {
				softassert.assertEquals(cashandcarry.ItemPriceValueIsExist(), "299","Test Step - 8 : Item price is not matched with search and selected item code");
			}else if(cashandcarry.ItemPriceValueIsExist()=="309") {
				softassert.assertEquals(cashandcarry.ItemPriceValueIsExist(), "309","Test Step - 8 : Item price is not matched with search and selected item code");
			}
			
			softassert.assertEquals(cashandcarry.ItemDiscountAmountIsExist(),"0","Test Step - 8 : Item discount amount is not matched with search and selected item code");
			softassert.assertEquals(cashandcarry.ItemDiscountPercentageValueIsExist(), "0","Test Step - 8 : Item discount percentage is not matched with search and selected item code");

			// Test Step - 9
			cashandcarry.ClickAddItem();
			softassert.assertTrue(cashandcarry.VerifyAddedItem(),"Test Step - 9 : Added item is not displayed on grid table row 1");
			softassert.assertEquals(cashandcarry.getAddedItemCode(),"rrd","Test Step - 9 : Added item code is not matched with search and selected item code");
			softassert.assertEquals(cashandcarry.GetAddedItemDescription(),"Red Rose Deluxe","Test Step - 9 : Added item description is not matched with search and selected item code");
			softassert.assertEquals(cashandcarry.GetAddedItemQty(), "1","Test Step - 9 : Added item quantity is not matched with search and selected item code");		
			
			if(cashandcarry.GetAddedItemExtPrice()=="$299.00") {
				softassert.assertEquals(cashandcarry.GetAddedItemExtPrice(), "$299.00","Test Step - 9 : Added item extended price is not matched with search and selected item code");
			}else if(cashandcarry.GetAddedItemExtPrice()=="$309.00") {
				softassert.assertEquals(cashandcarry.GetAddedItemExtPrice(), "$309.00","Test Step - 9 : Added item extended price is not matched with search and selected item code");
			}
			
			if(cashandcarry.GetAddedItemPrice()=="$299.00") {
				softassert.assertEquals(cashandcarry.GetAddedItemPrice(), "$299.00","Test Step - 9 : Added item price is not matched with search and selected item code");
			}else if(cashandcarry.GetAddedItemPrice()=="$309.00") {
				softassert.assertEquals(cashandcarry.GetAddedItemPrice(), "$309.00","Test Step - 9 : Added item price is not matched with search and selected item code");
			}

			softassert.assertEquals(cashandcarry.GetAddedItemDiscountAmount(), "$ 0.00","Test Step - 9 : Added item discount amount is not matched with search and selected item code");
			softassert.assertEquals(cashandcarry.GetAddedItemDiscountPercentage(),"0.00","Test Step - 9 : Added item discount percentage is not matched with search and selected item code");

			//Delete the added item on Cash and Carry page
			cashandcarry.ClickRow1DeleteIcon();

			//Test Step - 10	
			delayWithGivenTime(2000);
			logger.info("User verify add the title product to the Cash and Carry page is displayed..");
			softassert.assertEquals(cashandcarry.getDisplayedProductTitletooltip().contains("ballonsYY-"), true,"Test Step - 10 : Mouse hover on Product title tooltip is not displayed");		
			
			// Test Step - 11
			delayWithGivenTime(2000);
			logger.info("User verify add the title product to the Cash and Carry page is displayed..");
			cashandcarry.ClickParticularProdTitle();
			softassert.assertEquals(cashandcarry.getAddedItemCode(),"ballonsYY","Test Step - 11 : Selected product tile is not displayed");
			cashandcarry.SelectTaxType("Tax Exemption");
			cashandcarry.SelectOccasion("Birthday");
			
			// Test Step - 12
			cashandcarry.ClickPayButton();
			delayWithGivenTime(2000);
			logger.info("User fillout the customer,tax type & occasion details and click on Pay button");
			cashandcarrypayment = new CashAndCarryPaymentPage();
			softassert.assertTrue(cashandcarrypayment.IsPaymentPageDisplayed(),"Test Step - 12 : Cash And Carry payment page is not displayed");
			logger.info("User is on Cash And Carry payment page");
			
			// Test Step - 13
			cashandcarrypayment.ClickCashTab();
			logger.info("User select the payment type as cash tab");
			cashandcarrypayment.EnterGivenAmount();
			logger.info("User enter the amount in given amount field");		
			cashandcarrypayment.SearchAndSelectCustomer("abish");
			logger.info("User search and select the customer ");	
			cashandcarrypayment.ClickProcessPaymentBtn();
			softassert.assertTrue(cashandcarrypayment.SuccessToastMsg(),"Test Step - 13 : Success toast message is not displayed"); 		
			logger.info("User verified the order payment done successfully");
			softassert.assertEquals(cashandcarrypayment.getOrderConfirmationToastMsg(),"Order payment done successfully","Test Step - 13 : Order confirmation message is not displayed");
			
			delayWithGivenTime(1000);
			if(cashandcarrypayment.getConfirmationPopup()==true) {
				cashandcarrypayment.VerifyOrderConfirmationPopup();
				cashandcarrypayment.GetOrderConfirmationMsgAndInvoiceNo();		
				invoicenumber = cashandcarrypayment.GetInvoiceNumber();
				System.out.println("Order invoice number is :"+cashandcarrypayment.GetInvoiceNumber());				
				cashandcarrypayment.GetTenderPrice();
				System.out.println("The remaining amount given to customer is :"+cashandcarrypayment.GetTenderPrice());			
			}	
;		
		//	RobotDismissAlert();
		//	ThreadWait(1000);
			logger.info("User click the cancel button on webclientprint window popup");
			delayWithGivenTime(2000);
			
			// Test Step - 14
			cashandcarrypayment.ClickOrderConfirmationPopupCloseBtn();
			logger.info("User select the payment type as cash tab");			
			
			// Test Step - 15
			ThreadWait(1000);
			delayWithGivenTime(1000);
			dashboard.ClickOrder();
			delayWithGivenTime(1000);
			logger.info("User click the order menu on hana dashboard page");	
			dashboardorder = new DashboardOrderPage();	
			ThreadWait(1000);
			
			//Test Step - 16  
			softassert.assertEquals(dashboardorder.validateDashboardOrderPage(),prop.getProperty("livedashboardorderURL"),"Test Step - 16 - Dashboard order page is not displayed");				
			logger.info("User verify that the order page is navigated to dashboard order page");
			delayWithGivenTime(2000);
			
			dashboardorder.EnterGlobalSearch(invoicenumber); //dashboardorder.getInvoiceNumber_Walkin_pickup_Cash_OnOrderPage()
			
			delayWithGivenTime(2000);
			softassert.assertTrue(dashboardorder.ValidateInvoiceNumber(),"Test Step - 16 - Invoice number is not displayed on hana dashboard order page");		
		
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
			logger.error("Test case failed due to "+e.getMessage());
		}finally {
			softassert.assertAll();
		}
	}
}
