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
import com.hanapos.utilities.DataLibrary;

public class Hana_T69_Add_Product_Without_Customer_FT extends TestBaseClass{
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private CashAndCarryPage cashandcarry;
	private CashAndCarryPaymentPage cashandcarrypayment;
	private DashboardOrderPage dashboardorder;
	public static final String dataSheetName = "Hana_T69";
	SoftAssert softassert = new SoftAssert();
	public static ExecutorService executorService;
	private static final int THREAD_POOL_SIZE = 2;
	String invoice;
	@DataProvider(name = "fetch_Excel_Data") 
	public Object[][] fetchData() throws IOException { 
		return DataLibrary.readExcelData(dataSheetName); 
	}

	/*
	 * HANA-T69 - 1 to 17 - Verify add product without customer Functionality
	 */
//retryAnalyzer= com.hanapos.utilities.RetryTest.class,
	@Test(enabled=true,groups= {"Smoke","Regression"},dataProvider="fetch_Excel_Data") 
	public void  Validate_Hana_T69_Add_Product_Without_Customer_Test(String shopname, String clerkname, String employeename, String itemcode,String itemdesc, String prodtile, String occasion) throws InterruptedException, IOException {
		// Test Step - 1
		logger.info("**** Starting Hana_T69_Add_Product_Without_Customer_FT_CashAndCarryTest  ****");
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
			delayWithGivenTime(2000);
			dashboard = new HanaDashBoardPage();
			softassert.assertTrue(dashboard.VerifyHanaDashBoardPage(),"Page does not navigated to hana dashboard page");
			logger.info("User navigated to hana dashboard page sucess..");

			// Test Step - 3	
			dashboard.SelectShopNameDropDown(shopname);
			logger.info("User selected the shop name as "+prop.getProperty("shopname")+ "in dashboard page");
			delayWithGivenTime(2000);
			dashboard.CashAndCarryMenuClick();							
			cashandcarry = new CashAndCarryPage();
			logger.info("User hover the mouse on New order and click on Cash and Carry..");
			softassert.assertTrue(cashandcarry.VerifyCashAndCarryPage(), "Cash And Carry page is not displayed");
			logger.info("User verify the Cash and Carry page is displayed..");

			// Test Step - 4
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
			softassert.assertEquals(cashandcarry.ItemDescriptionValueIsExist(), "Test Automation Item Deluxe","Item Description is not matched with selected item");	
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
			softassert.assertEquals(cashandcarry.getAddedItemCode(),"TAI");
			softassert.assertEquals(cashandcarry.GetAddedItemDescription(),"Test Automation Item Deluxe");
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
		//	softassert.assertEquals(cashandcarry.Verify_ToolTip_OnLeftSideTileProduct(), "Tile Product-Test Automation Tile Product Small-$220.00","Test Step - 10 - Tooltip is not matched");
			
			// Test Step - 11
			delayWithGivenTime(2000);
			cashandcarry.Select_Product_Tile(prodtile);
			logger.info("User click on the particular product tile");
			delayWithGivenTime(2000);
			softassert.assertEquals(cashandcarry.getAddedItemCodeRow2(),"Tile Product","Test Step - 11 - selected product tile is not displayed");
			logger.info("User verify add the title product to the Cash and Carry page is displayed..");		

			// Test Step - 12
			cashandcarry.SelectTaxType("Tax Exemption");
			cashandcarry.SelectOccasion(occasion);
			logger.info("User select the occasion as Birthday");
			delayWithGivenTime(1000);
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
				invoice=cashandcarrypayment.GetInvoiceNumber();
				System.out.println("Confirmation popup Order invoice number is :"+cashandcarrypayment.GetInvoiceNumber());				
				cashandcarrypayment.GetTenderPrice();
				System.out.println("The remaining amount given to customer is :"+cashandcarrypayment.GetTenderPrice());			
			}					

		//	RobotDismissAlert();
			logger.info("User click the cancel button on webclientprint window popup");
			
			// Test Step - 14
			cashandcarrypayment.ClickOrderConfirmationPopupCloseBtn();
			
			// Test Step - 15
			delayWithGivenTime(1000);
			dashboard.ClickOrder();
			delayWithGivenTime(1000);
			logger.info("User click the order menu on hana dashboard page");	//https://hanafloralpos3-qa.azurewebsites.net/Dashboard/Order
			dashboardorder = new DashboardOrderPage();	                   //https://hanafloralpos3.com/Dashboard/Order
			softassert.assertEquals(dashboardorder.validateDashboardOrderPage(),prop.getProperty("livedashboardorderURL"));				
			logger.info("User verify that the order page is navigated to dashboard order page");
						
			// Test Step - 16
			delayWithGivenTime(1000);
			dashboardorder.EnterGlobalSearch(invoice);//dashboardorder.getInvoiceNumber_Walkin_pickup_Cash_OnOrderPage()
			
			delayWithGivenTime(2000);
			softassert.assertTrue(dashboardorder.ValidateInvoiceNumber(),"Test Step - 16 - Invoice number is not displayed on hana dashboard order page");		
		
			
			// Test Step - 17
			delayWithGivenTime(2000);
			softassert.assertEquals(dashboardorder.GetSenderorCustomerOnOrderPage().contains("WALKIN | Cash And Carry Sale"),true,"Test Step - 17 - Sender or customer is not displayed on hana dashboard order page for respective invoice");
						
			softassert.assertAll();
		} catch (Exception e) {
			Assert.fail("An exception occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
