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

public class Hana_T15_Edit_Product_FT extends TestBaseClass{
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private CashAndCarryPage cashandcarry;
	private CashAndCarryPaymentPage cashandcarrypayment;
	private DashboardOrderPage dashboardorder;
	public static final String dataSheetName = "Hana_T15";
	public static ExecutorService executorService;
	private static final int THREAD_POOL_SIZE = 2;
	SoftAssert softassert = new SoftAssert();

	@DataProvider(name = "fetch_Excel_Data") 
	public Object[][] fetchData() throws IOException { 
		return DataLibrary.readExcelData(dataSheetName); 
	}

	/*
	 * HANA-T15 - 1 to 26 - Verify Edit Product functionality
	 */
	//retryAnalyzer= com.hanapos.utilities.RetryTest.class,

	@Test(enabled=true,groups= {"Smoke","Regression"},dataProvider="fetch_Excel_Data") 
	public void  Validate_Hana_T15_Edit_Product_Test(String searchandselectitemcode,String occasion, String qtyrow1,String customername) throws InterruptedException, IOException {
		
		// Test Step - 1
		logger.info("**** Starting Hana_T15_Edit_Product_CashAndCarryTest  ****");
		logger.debug("capturing application debug logs....");
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

			if(cashandcarry.ItemPriceValueIsExist()=="299") {
				softassert.assertEquals(cashandcarry.ItemPriceValueIsExist(), "299","Item price is not matched with search and selected item code");
			}else if(cashandcarry.ItemPriceValueIsExist()=="309") {
				softassert.assertEquals(cashandcarry.ItemPriceValueIsExist(), "309","Item price is not matched with search and selected item code");
			}
						
			softassert.assertEquals(cashandcarry.ItemDiscountAmountIsExist(),"0");
			softassert.assertEquals(cashandcarry.ItemDiscountPercentageValueIsExist(), "0");

			// Test Step - 9
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

			//Delete the added item on Cash and Carry page
			cashandcarry.ClickRow1DeleteIcon();

			// Test Step - 10
			delayWithGivenTime(2000);
			logger.info("User verify add the title product to the Cash and Carry page is displayed..");
			cashandcarry.ClickParticularProdTitle();
			softassert.assertEquals(cashandcarry.getAddedItemCode(),"ballonsYY");
			cashandcarry.SelectTaxType("Tax Exemption");
			cashandcarry.SelectOccasion(occasion);

			// Test Step - 11
			cashandcarry.ClickPayButton();

			logger.info("User fillout the customer,tax type & occasion details and click on Pay button");
			cashandcarrypayment = new CashAndCarryPaymentPage();
			delayWithGivenTime(2000);
			softassert.assertTrue(cashandcarrypayment.IsPaymentPageDisplayed(),"Cash And Carry payment page is not displayed");
			logger.info("User is on Cash And Carry payment page");

			// Test Step - 12
			delayWithGivenTime(2000);
			cashandcarrypayment.ClickBackButtonOnTopRightCorner();
			logger.info("User click on Back button on top right corner");
			delayWithGivenTime(2000);
			softassert.assertTrue(cashandcarry.VerifyCashAndCarryPage(), "Test Step:12 - Cash And Carry page is not displayed");
			logger.info("User verify the Cash and Carry page is displayed..");

			// Test Step - 13
			delayWithGivenTime(2000);
			softassert.assertEquals(cashandcarry.getAddedItemCode(),"ballonsYY","Test Step:13 - Item code is not matched");
			softassert.assertEquals(cashandcarry.GetAddedItemDescription(),"Ballons small","Test Step:13 - Item description is not matched");
			softassert.assertEquals(cashandcarry.GetAddedItemQty(), "1","Test Step:13 - Item quantity is not matched");
			softassert.assertEquals(cashandcarry.GetAddedItemExtPrice(), "$40.00","Test Step:13 - Item extended price is not matched");
			softassert.assertEquals(cashandcarry.GetAddedItemPrice(), "$40.00","Test Step:13 - Item price is not matched");
			softassert.assertEquals(cashandcarry.GetAddedItemDiscountAmount(), "$ 0.00","Test Step:13 - Item discount amount is not matched");
			softassert.assertEquals(cashandcarry.GetAddedItemDiscountPercentage(),"0.00","Test Step:13 - Item discount percentage is not matched");

			// Test Step - 14
			cashandcarry.ClickAddedRow1EditButton();
			delayWithGivenTime(1000);
			softassert.assertTrue(cashandcarry.IsSavedIconDisplayedOnAddedItemTableRow1(),"Saved Icon is not displayed");
			delayWithGivenTime(1000);
			softassert.assertTrue(cashandcarry.IsCancelIconDisplayedOnAddedItemTableRow1(),"Cancel Icon is not displayed");

			//Test Step - 15
			cashandcarry.EditQuantityOnTableRow1(qtyrow1);

			//Test Step - 16
			cashandcarry.ClickTheCancelIconOnAddedItemTableRow1();

			//Test Step - 17
			delayWithGivenTime(2000);
			cashandcarry.ClickAddedRow1EditButton();
			cashandcarry.EditQuantityOnTableRow1(qtyrow1);
			softassert.assertTrue(cashandcarry.IsSavedIconDisplayedOnAddedItemTableRow1(),"Saved Icon is not displayed");
			softassert.assertTrue(cashandcarry.IsCancelIconDisplayedOnAddedItemTableRow1(),"Cancel Icon is not displayed");
			cashandcarry.ClickTheSavedIconOnAddedItemTableRow1();

			// Test Step - 18
			cashandcarry.SelectTaxType("Tax Exemption");
			delayWithGivenTime(2000);
			
			if(cashandcarry.get_selected_tax_type().equals("Tax Exemption")){
			delayWithGivenTime(2000);
			softassert.assertEquals(cashandcarry.ValidateGrandTotalDefaultValue(),"120.00","Test Step:18 - Grand total to pay is not matched");
			// Test Step - 19
			softassert.assertEquals(cashandcarry.ValidatePayButtonDisplayedPrice(),"120.00","Test Step:19 - Grand total to pay is not matched");
			// Test Step - 20			
			cashandcarry.SelectOccasion(occasion);
			cashandcarry.ClickPayButton();

			logger.info("User fillout the customer,tax type & occasion details and click on Pay button");
			cashandcarrypayment = new CashAndCarryPaymentPage();
			softassert.assertTrue(cashandcarrypayment.IsPaymentPageDisplayed(),"Cash And Carry payment page is not displayed");
			logger.info("User is on Cash And Carry payment page");

			// Test Step - 21
			cashandcarrypayment.ClickCashTab();
			logger.info("User select the payment type as cash tab");
			delayWithGivenTime(1000);
			softassert.assertEquals(cashandcarrypayment.getGrandTotaltoPay(),"120.00", "Test Step:21 - Grand total to pay is not matched");
			} 			
			
			// Test Step - 22		
			cashandcarrypayment.EnterGivenAmount();
			logger.info("User enter the amount in given amount field");		
			cashandcarrypayment.SearchAndSelectCustomer(customername);
			logger.info("User search and select the customer ");	
			cashandcarrypayment.ClickProcessPaymentBtn();
			softassert.assertTrue(cashandcarrypayment.SuccessToastMsg()); 		
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
				 
			logger.info("User click the cancel button on webclientprint window popup");

			// Test Step - 23
			cashandcarrypayment.ClickOrderConfirmationPopupCloseBtn();
			logger.info("User select the payment type as cash tab");

			// Test Step - 24 
			delayWithGivenTime(1000);
			dashboard.ClickOrder();
			delayWithGivenTime(1000);
			logger.info("User click the order menu on hana dashboard page");
			dashboardorder = new DashboardOrderPage();

			//Test Step - 25							
			softassert.assertEquals(dashboardorder.validateDashboardOrderPage(),prop.getProperty("livedashboardorderURL"),"Test Step:25 - Dashboard order page is not displayed");
			logger.info("User verify that the order page is navigated to dashboard order page");
			delayWithGivenTime(1000); 
			dashboardorder.EnterGlobalSearch(dashboardorder.getInvoiceNumber_Walkin_pickup_Cash_OnOrderPage());

			softassert.assertTrue(dashboardorder.ValidateInvoiceNumber(),"Test Step:25 - Invoice number is not displayed on order page");

			// Test Step -26 
			delayWithGivenTime(1000);		
			softassert.assertEquals(dashboardorder.GetInvoiceAmount_Walkin_pickup_Cash_OnOrderPage(), "$120.00","Test Step:26 - Invoice amount on order page is not matched");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Test failed due to "+e.getMessage());
			logger.error("Test failed due to "+e.getMessage());
		}finally {
			softassert.assertAll();
		}
	}}

