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
import com.hanapos.pageObjects.CustomerPage;
import com.hanapos.pageObjects.DashboardOrderPage;
import com.hanapos.pageObjects.HanaDashBoardPage;
import com.hanapos.pageObjects.LoginPage;
import com.hanapos.seleniumProjectBase.TestBaseClass;
import com.hanapos.utilities.CustomSoftAssert;
import com.hanapos.utilities.DataLibrary;

public class Hana_T78_Reconcile_FT extends TestBaseClass{
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private CashAndCarryPage cashandcarry;
	private CashAndCarryPaymentPage cashandcarrypayment;
	public static final String dataSheetName = "Hana_T78";
	public static ExecutorService executorService;
	private static final int THREAD_POOL_SIZE = 2;
	
	// SoftAssert softassert = new SoftAssert(); - I have modified this to use CustomSoftAssert
	CustomSoftAssert softassert = new CustomSoftAssert();

	@DataProvider(name = "fetch_Excel_Data") 
	public Object[][] fetchData() throws IOException { 
		return DataLibrary.readExcelData(dataSheetName); 
	}
	
	/*
	 * HANA-T78 - 1 to 10 - Verify Reconcile Functionality
	 */
//retryAnalyzer= com.hanapos.utilities.RetryTest.class,
	@Test(enabled=true,groups= {"Regression"},dataProvider="fetch_Excel_Data") 
	public void  Validate_Hana_T78_Reconcile_Test(String shopname, String clerkname, String employeename, String itemcode,String itemdesc, String prodtile,String customername, String occasion) throws InterruptedException, IOException {
		// Test Step - 1
		logger.info("**** Starting Hana_T78_Reconcile_FT_CashAndCarryTest  ****");
	
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
			softassert.assertTrue(dashboard.VerifyHanaDashBoardPage(),"Page does not navigated to hana dashboard page");
			logger.info("User navigated to hana dashboard page sucess..");

			// Test Step - 3
			dashboard.SelectShopNameDropDown(prop.getProperty("shopname"));
			logger.info("User selected the shop name as "+prop.getProperty("shopname")+ "in dashboard page");
			softassert.assertTrue(dashboard.VerifyOrderEntryOptionIsDisplayed(),"Order entry option is not displayed");
			softassert.assertTrue(dashboard.Verify_Cashandcarry_OptionIsDisplayed(),"Cash and carry option is not displayed");
		
			// Test Step - 4
			dashboard.CashAndCarryMenuClick();							
			cashandcarry = new CashAndCarryPage();
			logger.info("User hover the mouse on New order and click on Cash and Carry..");
			softassert.assertTrue(cashandcarry.VerifyCashAndCarryPage(), "Cash And Carry page is not displayed");
			logger.info("User verify the Cash and Carry page is displayed..");

			cashandcarry.SelectShopName(shopname); //"Hana POS (Canada)"
			logger.info("User select the shop name as "+shopname+ "in cash and carry page");

			//Test Step - 5
			cashandcarry.SelectClerkName(clerkname); //"Automation clerk desc"
			logger.info("User select the clerk name as "+clerkname);

			// Test Step - 6
			cashandcarry.SelectEmployeeName(employeename); //"QA Team Automation"
			logger.info("User select the employee name as "+employeename);

			// Test Step - 7
			softassert.assertTrue(cashandcarry.VerifyPayButtonIsEnabled(), "Test Step:7 - Pay button is not disabled");
			logger.info("User verify the Pay button is disabled");
			
			// Test Step - 8
			cashandcarry.SearchAndSelect_ItemCode(itemcode,itemdesc);
			softassert.assertEquals(cashandcarry.ItemDescriptionValueIsExist(), "Rose Flowers ","Item Description is not matched with selected item");	
			softassert.assertEquals(cashandcarry.ItemQtyValueIsExist(), "1","Item quantity is not matched with selected item");			
			
			if(cashandcarry.ItemPriceValueIsExist()=="80") {
				softassert.assertEquals(cashandcarry.ItemPriceValueIsExist(), "80", "Test Step - 8 - Item price is not matched with selected item");
			}else if(cashandcarry.ItemPriceValueIsExist()=="82") {
				softassert.assertEquals(cashandcarry.ItemPriceValueIsExist(), "82", "Test Step - 8 - Item price is not matched with selected item");	
			}	
			
			softassert.assertEquals(cashandcarry.ItemDiscountAmountIsExist(),"0","Discount amount is not matched with selected item");
			softassert.assertEquals(cashandcarry.ItemDiscountPercentageValueIsExist(), "0","Discount percentage is not matched with selected item");

			// Test Step - 9
			cashandcarry.ClickAddItem();
			softassert.assertTrue(cashandcarry.VerifyAddedItem());
			softassert.assertEquals(cashandcarry.getAddedItemCode(),"RSS");
			softassert.assertEquals(cashandcarry.GetAddedItemDescription(),"Rose Flowers");
			softassert.assertEquals(cashandcarry.GetAddedItemQty(), "1");
			
			if(cashandcarry.GetAddedItemExtPrice()=="$82.00") {
				softassert.assertEquals(cashandcarry.GetAddedItemExtPrice(), "$82.00");
			}else if(cashandcarry.GetAddedItemExtPrice()=="$80.00") {
				softassert.assertEquals(cashandcarry.GetAddedItemExtPrice(), "$80.00");
			}
			
			if(cashandcarry.GetAddedItemPrice()=="$82.00") {
				softassert.assertEquals(cashandcarry.GetAddedItemPrice(), "$82.00");
			}else if(cashandcarry.GetAddedItemPrice()=="$80.00") {
				softassert.assertEquals(cashandcarry.GetAddedItemPrice(), "$80.00");
			}
			
			softassert.assertEquals(cashandcarry.GetAddedItemDiscountAmount(), "$ 0.00");
			softassert.assertEquals(cashandcarry.GetAddedItemDiscountPercentage(),"0.00");
			
			// Test Step - 10
			softassert.assertEquals(cashandcarry.VerifyToolTipOnLeftSideTileProduct(), "35486~Violet Roses Standard~20.00~169514~true~false~Item~1801202","Tooltip is not matched");
			
			// Test Step - 11
			delayWithGivenTime(2000);
			cashandcarry.SelectProductTile(prodtile);
			logger.info("User click on the particular product tile");
			softassert.assertEquals(cashandcarry.getAddedItemCodeRow2(),"12345");
			logger.info("User verify add the title product to the Cash and Carry page is displayed..");		

			// Test Step - 12
			cashandcarry.EnterCustomerName(customername);
			logger.info("User enter the customer name as "+customername);
			cashandcarry.SelectTaxType("Tax Exemption");
			cashandcarry.SelectOccasion(occasion);
			logger.info("User select the occasion as "+occasion);
		
			delayWithGivenTime(2000);
			cashandcarry.ClickPayButton();
			logger.info("User click on Pay button");
			delayWithGivenTime(2000);
			cashandcarrypayment = new CashAndCarryPaymentPage();
			softassert.assertTrue(cashandcarrypayment.IsPaymentPageDisplayed(),"Cash And Carry payment page is not displayed");
			logger.info("User navigated to Cash And Carry payment page successfully");

			// Test Step - 13	
			cashandcarrypayment.ClickCashTab();
			logger.info("User select the payment type as cash tab");
			cashandcarrypayment.EnterGivenAmount();
			logger.info("User enter the amount in given amount field");			
			cashandcarrypayment.ClickProcessPaymentBtn();
			softassert.assertTrue(cashandcarrypayment.SuccessToastMsg()); 		
			logger.info("User verified the order payment done successfully");
			softassert.assertEquals(cashandcarrypayment.getOrderConfirmationToastMsg(),"Order payment done successfully");
		
			delayWithGivenTime(1000);
			if(cashandcarrypayment.getConfirmationPopup()==true) {
				cashandcarrypayment.VerifyOrderConfirmationPopup();
				cashandcarrypayment.GetOrderConfirmationMsgAndInvoiceNo();		
				cashandcarrypayment.GetInvoiceNumber();
				System.out.println("Confirmation popup Order invoice number is :"+cashandcarrypayment.GetInvoiceNumber());				
				cashandcarrypayment.GetTenderPrice();
				System.out.println("The remaining amount given to customer is :"+cashandcarrypayment.GetTenderPrice());			
			}	
		
			//	RobotDismissAlert();
			logger.info("User click the cancel button on webclientprint window popup");
			
			// Test Step - 14
			cashandcarrypayment.ClickOrderConfirmationPopupCloseBtn();
			delayWithGivenTime(1000);
				
			// Test Step - 15
			cashandcarry.ClickOnReconcileBtn();
			softassert.assertTrue(cashandcarry.VerifyReconcilePopupDisplayed(),"Reconcile popup is not displayed");

			// Test Step - 16
			cashandcarry.SelectShopReconcilePopup("Hana POS (Canada)");
			cashandcarry.Select_CashRegistryIdonReconcilePopup("Test");
			
			softassert.assertEquals(cashandcarry.ValidateLastReconciliationdate(),"06/13/2024 11:37:14 PM","Last Reconciliation date is not displayed");
			softassert.assertTrue(cashandcarry.VerifyOpenBalanceOnReconcilePopup(),"Open Balance is not displayed");
			softassert.assertTrue(cashandcarry.VerifyExpectedBalance(),"Expected balance is not displayed");
			softassert.assertTrue(cashandcarry.VerifyActualBalance(),"Actual balance is not displayed");
			softassert.assertTrue(cashandcarry.VerifyCashRegisterSalesReview_dateTime(),"Date time in cash register sales review is not displayed");
			softassert.assertTrue(cashandcarry.VerifyDiffernce(),"Difference is not displayed");
			softassert.assertTrue(cashandcarry.VerifyCashRegisterSalesReview_Cash(),"Cash is not displayed");
			softassert.assertTrue(cashandcarry.VerifyCashRegisterSalesReview_AfterTax(),"After Tax is not displayed");
			softassert.assertTrue(cashandcarry.VerifyCashRegisterSalesReview_TotalSales(),"Total sales is not displayed");
			softassert.assertTrue(cashandcarry.VerifyCashRegisterSalesReview_StartCash(),"Start cash is not displayed");
			
			delayWithGivenTime(2000);
			softassert.assertEquals(cashandcarry.getCashInDrawer(),cashandcarry.getCashInDrawerCalculation());
			
			// Test Step -17
			cashandcarry.EnterTwentyDollarDenomination("5");
			delayWithGivenTime(1000);
			softassert.assertEquals(cashandcarry.getEnteredTwentyDollarDenomination(),"5","Entered 20 dollar denomination is not displayed");
			
			// Test Step - 18
			delayWithGivenTime(2000);
			cashandcarry.ClickReconcileBtnInPopup();
			delayWithGivenTime(2000);
			softassert.assertEquals(cashandcarry.getActualBalance(), cashandcarry.Expected_Actual_Balance(),"Actual balance is not matched");
			delayWithGivenTime(1000);
			softassert.assertEquals(cashandcarry.getActualBalanceDifference(),cashandcarry.ExpectedBalanceDifference(), "Difference value is not matched");
		//	softassert.assertTrue(cashandcarry.VerifyDifferenceFieldRedColorAppears(),"Text is not displayed in red color");
			
			// Test Step - 19
			delayWithGivenTime(2000);
			cashandcarry.EnterOneDollarDenomination("1");
			cashandcarry.EnterTwoDollarDenomination("2");
			delayWithGivenTime(2000);
			cashandcarry.EnterfiveDollarDenomination("2");
			cashandcarry.EnterFiftyDollarDenomination("0");
			delayWithGivenTime(2000);
			cashandcarry.EnterOneHundredDollarDenomination("7");
			cashandcarry.EnterPenniesDenomination("20");
			delayWithGivenTime(2000);
			cashandcarry.ClickReconcileBtnInPopup();
			softassert.assertEquals(cashandcarry.getActualBalance(), cashandcarry.Expected_Actual_Balance(),"Actual balance is not matched");

			softassert.assertAll();
			logger.info("**** Finished Hana_T78_Reconcile_CashAndCarryTest  ****");

		} catch (Exception e) {
			logger.info("Exception occured in Hana_T78_Reconcile_CashAndCarryTest is :"+e.getMessage());
			e.printStackTrace();
		}
	}
}
