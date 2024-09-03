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
import com.hanapos.utilities.DataLibrary;


public class Hana_T18_OrderConfirmationPopup_FT extends TestBaseClass{
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private CashAndCarryPage cashandcarry;
	private CashAndCarryPaymentPage cashandcarrypayment;
	private DashboardOrderPage dashboardorder;
	public static final String dataSheetName = "Hana_T18";
	public static ExecutorService executorService;
	private static final int THREAD_POOL_SIZE = 2;
	String invoicenumber;
	SoftAssert softassert = new SoftAssert();

	@DataProvider(name = "fetch_Excel_Data") 
	public Object[][] fetchData() throws IOException { 
		return DataLibrary.readExcelData(dataSheetName); 
	}

	/*
	 * HANA-T18 - 1 to 16 - Verify Order confirmation pop up Functionality
	 */
//retryAnalyzer= com.hanapos.utilities.RetryTest.class,
	@Test(enabled=true,groups= {"Smoke","Regression"},dataProvider="fetch_Excel_Data") 
	public void  Validate_Hana_T18_Order_Confirmation_Popup_Test(String searchandselectitemcode, String customername, String occasion) throws InterruptedException, IOException {
		// Test Step - 1
		logger.info("**** Starting Hana_T18_OrderConfirmationPopup_CashAndCarryTest  ****");
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
			cashandcarry.SearchAndSelectTheItemCode(searchandselectitemcode);

			softassert.assertEquals(cashandcarry.ItemDescriptionValueIsExist(), "Red Rose Deluxe","Test Step - 7 - Item description is not matched with search and selected item code");	
			softassert.assertEquals(cashandcarry.ItemQtyValueIsExist(), "1","Test Step - 7 - Item quantity is not matched with search and selected item code");
			
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
			delayWithGivenTime(1000);
			cashandcarry.ClickParticularProdTitle();
			softassert.assertEquals(cashandcarry.getAddedItemCodeRow2(),"ballonsYY");

			// Test Step - 10
			delayWithGivenTime(1000);
			cashandcarry.EnterCustomerName(customername);
			delayWithGivenTime(1000);
			cashandcarry.SelectTaxType("Tax Exemption");
			cashandcarry.SelectOccasion(occasion);
			cashandcarry.ClickPayButton();

			logger.info("User fillout the customer details and click on Pay button");
			cashandcarrypayment = new CashAndCarryPaymentPage();
			delayWithGivenTime(2000);
			softassert.assertTrue(cashandcarrypayment.IsPaymentPageDisplayed(),"Test Step - 10 - Cash And Carry payment page is not displayed");
			logger.info("User is on Cash And Carry payment page");

			// Test Step - 11
			cashandcarrypayment.ClickCashTab();
			cashandcarrypayment.EnterGivenAmount();
			logger.info("User select the payment type as cash tab");
					
			// Test Step - 12			
			cashandcarrypayment.ClickProcessPaymentBtn();
			softassert.assertTrue(cashandcarrypayment.SuccessToastMsg()); 		
			logger.info("User verified the order payment done successfully");
			softassert.assertEquals(cashandcarrypayment.getOrderConfirmationToastMsg(),"Order payment done successfully");
			
			delayWithGivenTime(2000);
			if(cashandcarrypayment.getConfirmationPopup()==true) {
				cashandcarrypayment.VerifyOrderConfirmationPopup();
				cashandcarrypayment.GetOrderConfirmationMsgAndInvoiceNo();		
				invoicenumber = cashandcarrypayment.GetInvoiceNumber();
				System.out.println("Order invoice number is :"+cashandcarrypayment.GetInvoiceNumber());				
				cashandcarrypayment.GetTenderPrice();
				System.out.println("The remaining amount given to customer is :"+cashandcarrypayment.GetTenderPrice());			
			}	
			
			logger.info("User click the cancel button on webclientprint window popup");
						
			// Test Step - 13
			softassert.assertEquals(cashandcarrypayment.GetConfirmationPopupCustEmail(),"hanaposqateam@gmail.com","******Test Step - 13 - Email id is not autopopulated from customer details******");		
			softassert.assertEquals(cashandcarrypayment.GetConfirmationPopupCustSMS(), "956-655-0756","******Test Step - 13 - SMS Phone number is not autopopulated from customer details******");
					
			//Test Step - 14
			cashandcarrypayment.ClickSendReciptBtnOnOrderConfirmationPopup();
			delayWithGivenTime(1000);
			softassert.assertEquals(cashandcarrypayment.getOrderConfirmationToastMsg(),"Receipt sent successfully.","Test Step - 14 - Receipt sent successfully toast message text is not displayed");
			// Future Enhancement..
			//System.out.println("Received Email Invoice number is :"+EmailReader.getInstance().getInvoiceNumber());
			logger.info("User click the send recipt button on order confirmation popup");
			logger.info("***** Need to verify email notification is received on registered mail id for confirmation order invoice is generated by tested manually *****");
			
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
			
			dashboardorder.EnterGlobalSearch(invoicenumber); //dashboardorder.getInvoiceNumber_Walkin_pickup_Cash_OnOrderPage()

			softassert.assertTrue(dashboardorder.ValidateInvoiceNumber(),"Test Step - 16 - Walkin sales - cash - pickup - Invoice number is not displayed");				
		
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
			logger.error(e.getMessage());
		}finally {
			softassert.assertAll();
		}
	}
}
