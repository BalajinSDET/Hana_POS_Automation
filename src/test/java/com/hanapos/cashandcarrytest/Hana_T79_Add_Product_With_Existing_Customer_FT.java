package com.hanapos.cashandcarrytest;

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
import com.hanapos.utilities.DataLibrary;

public class Hana_T79_Add_Product_With_Existing_Customer_FT extends TestBaseClass{
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private CashAndCarryPage cashandcarry;
	private CashAndCarryPaymentPage cashandcarrypayment;
	private DashboardOrderPage dashboardorder;
	public static final String dataSheetName = "Hana_T14";
	public static ExecutorService executorService;
	private static final int THREAD_POOL_SIZE = 2;
	SoftAssert softassert = new SoftAssert();

	@DataProvider(name = "fetch_Excel_Data") 
	public Object[][] fetchData() throws IOException { 
		return DataLibrary.readExcelData(dataSheetName); 
	}

	/*
	 * HANA-T14 - 1 to 16 - Verify Add Product Functionality
	 */
//retryAnalyzer= com.hanapos.utilities.RetryTest.class,

	@Test(enabled=true,groups= {"Smoke","Regression"},dataProvider="fetch_Excel_Data") 
	public void  Validate_Hana_T79_Add_Product_With_Existing_Customer_Test(String searchandselectitemcode) throws InterruptedException, IOException {
		// Test Step - 1
		logger.info("**** Starting Hana_T79_Add_Product_CashAndCarryTest  ****");
		try {
			lp = new LoginPage();
			softassert.assertTrue(lp.LoginPageIsDisplayed(),"Login page is not displayed");
			logger.info("User on the hana pos login page");
			
			// Test Step - 2
			logger.info("Entering valid username and password..");
			lp.EnterUserName(prop.getProperty("username"));
			lp.EnterPassword(prop.getProperty("password"));
			lp.ClickLoginButton();
			logger.info("Clicked on Login button..");

			dashboard = new HanaDashBoardPage();
			Assert.assertTrue(dashboard.VerifyHanaDashBoardPage(),"Page does not navigated to hana dashboard page");
			logger.info("User navigated to hana dashboard page sucess..");
			
			// Test Step - 3
			dashboard.SelectShopNameDropDown(prop.getProperty("shopname"));
			dashboard.CashAndCarryMenuClick();							
			cashandcarry = new CashAndCarryPage();
			logger.info("User hover the mouse on New order and click on Cash and Carry..");
			Assert.assertTrue(cashandcarry.VerifyCashAndCarryPage(), "Cash And Carry page is not displayed");
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
			softassert.assertTrue(cashandcarry.IsPayButtonDisabled(), "Pay button is not disabled");
			
			// Test Step - 8
			cashandcarry.SearchAndSelectTheItemCode(searchandselectitemcode);

			softassert.assertEquals(cashandcarry.ItemDescriptionValueIsExist(), "Red Rose Deluxe");	
			softassert.assertEquals(cashandcarry.ItemQtyValueIsExist(), "1");
			softassert.assertEquals(cashandcarry.ItemPriceValueIsExist(), "309");
			softassert.assertEquals(cashandcarry.ItemDiscountAmountIsExist(),"0");
			softassert.assertEquals(cashandcarry.ItemDiscountPercentageValueIsExist(), "0");

			// Test Step - 9
			cashandcarry.ClickAddItem();
			softassert.assertTrue(cashandcarry.VerifyAddedItem());
			softassert.assertEquals(cashandcarry.getAddedItemCode(),"rrd");
			softassert.assertEquals(cashandcarry.GetAddedItemDescription(),"Red Rose Deluxe");
			softassert.assertEquals(cashandcarry.GetAddedItemQty(), "1");
			softassert.assertEquals(cashandcarry.GetAddedItemExtPrice(), "$309.00");
			softassert.assertEquals(cashandcarry.GetAddedItemPrice(), "$309.00");
			softassert.assertEquals(cashandcarry.GetAddedItemDiscountAmount(), "$ 0.00");
			softassert.assertEquals(cashandcarry.GetAddedItemDiscountPercentage(),"0.00");

			//Delete the added item on Cash and Carry page
			cashandcarry.ClickRow1DeleteIcon();

			//Test Step - 10	
			delayWithGivenTime(2000);
			logger.info("User verify add the title product to the Cash and Carry page is displayed..");
			softassert.assertEquals(cashandcarry.getDisplayedProductTitletooltip().contains("ballonsYY-"), true);		
			
			// Test Step - 11
			delayWithGivenTime(2000);
			logger.info("User verify add the title product to the Cash and Carry page is displayed..");
			cashandcarry.ClickParticularProdTitle();
			softassert.assertEquals(cashandcarry.getAddedItemCode(),"ballonsYY");
			cashandcarry.EnterCustomerName("Test Automation");
			logger.info("User enter the customer name");
			cashandcarry.SelectTaxType("Tax Exemption");
			cashandcarry.SelectOccasion("Birthday");
			
			// Test Step - 12
			cashandcarry.ClickPayButton();
			delayWithGivenTime(2000);
			logger.info("User fillout the customer,tax type & occasion details and click on Pay button");
			cashandcarrypayment = new CashAndCarryPaymentPage();
			softassert.assertTrue(cashandcarrypayment.IsPaymentPageDisplayed(),"Cash And Carry payment page is not displayed");
			logger.info("User is on Cash And Carry payment page");
			
			// Test Step - 13
			cashandcarrypayment.ClickCashTab();
			logger.info("User select the payment type as cash tab");
			cashandcarrypayment.EnterGivenAmount();
			logger.info("User enter the amount in given amount field");		
			
			logger.info("User search and select the customer ");	
			cashandcarrypayment.ClickProcessPaymentBtn();
			softassert.assertTrue(cashandcarrypayment.SuccessToastMsg(),"Test Step - 13 - success toast message is not displayed"); 		
			logger.info("User verified the order payment done successfully");
			softassert.assertEquals(cashandcarrypayment.getOrderConfirmationToastMsg(),"Order payment done successfully");
			delayWithGivenTime(1000);
		
			if(cashandcarrypayment.getConfirmationPopup()==true) {
				cashandcarrypayment.VerifyOrderConfirmationPopup();
				cashandcarrypayment.GetOrderConfirmationMsgAndInvoiceNo();		
				cashandcarrypayment.GetInvoiceNumber();
				System.out.println("Order invoice number is :"+cashandcarrypayment.GetInvoiceNumber());				
				cashandcarrypayment.GetTenderPrice();
				System.out.println("The remaining amount given to customer is :"+cashandcarrypayment.GetTenderPrice());			
			}	
			delayWithGivenTime(1000);
				
			getDriver().switchTo().activeElement();
			delayWithGivenTime(2000);

			RobotDismissAlert();
			logger.info("User click the cancel button on webclientprint window popup");
			delayWithGivenTime(1000);
			
			// Test Step - 14
			cashandcarrypayment.ClickOrderConfirmationPopupCloseBtn();
			logger.info("User select the payment type as cash tab");
			
			
			// Test Step - 15
			delayWithGivenTime(1000);
			dashboard.ClickOrder();
			delayWithGivenTime(1000);
			logger.info("User click the order menu on hana dashboard page");	
			dashboardorder = new DashboardOrderPage();	
			
			//Test Step - 16
			softassert.assertEquals(dashboardorder.validateDashboardOrderPage(),prop.getProperty("livedashboardorderURL"),"Test Step - 16 - Dashboard order page is not displayed");				
			logger.info("User verify that the order page is navigated to dashboard order page");
			delayWithGivenTime(1000);
			softassert.assertTrue(dashboardorder.ValidateInvoiceNumber(), "Test Step - 16 invoice number is not displayed");
			
			// Test Step - 17
			softassert.assertEquals(dashboardorder.GetSenderorCustomerOnOrderPage().contains("Test Automation pvt ltd | Test Automation"),true, "Test Step - 17 Sender or customer name is not displayed");
			softassert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
			logger.error(e.getMessage());
		}
	}
}
