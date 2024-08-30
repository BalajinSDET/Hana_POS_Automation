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
import com.hanapos.pageObjects.HanaDashBoardPage;
import com.hanapos.pageObjects.LoginPage;
import com.hanapos.seleniumProjectBase.TestBaseClass;
import com.hanapos.utilities.DataLibrary;
import com.hanapos.utilities.EmailReader;

public class Hana_T20_OrderConfirmationEmail_FT extends TestBaseClass{
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private CashAndCarryPage cashandcarry;
	private CashAndCarryPaymentPage cashandcarrypayment;
	public static final String dataSheetName = "Hana_T20";
	SoftAssert softassert = new SoftAssert();
	public static ExecutorService executorService;
	private static final int THREAD_POOL_SIZE = 2;
	

	@DataProvider(name = "fetch_Excel_Data") 
	public Object[][] fetchData() throws IOException { 
		return DataLibrary.readExcelData(dataSheetName); 
	}

	/*
	 * HANA-T20 - 1 to 16 - Verify Order confirmation Email Functionality
	 */
//retryAnalyzer= com.hanapos.utilities.RetryTest.class,
	@Test(enabled=true,groups= {"Regression"},dataProvider="fetch_Excel_Data") 
	public void  Validate_Hana_T20_OrderConfirmationEmail_Test(String searchandselectitemcode, String customershortname ) throws InterruptedException, IOException {
		// Test Step - 1
		logger.info("**** Starting Hana_T20_CashAndCarryOrderConfirmationEmail_FT  ****");
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
			softassert.assertTrue(dashboard.VerifyHanaDashBoardPage(),"Page does not navigated to hana dashboard page");
			logger.info("User navigated to hana dashboard page sucessfully..");

			// Test Step - 3
			dashboard.SelectShopNameDropDown(prop.getProperty("shopname"));
			logger.info("User selected shop name as "+prop.getProperty("shopname") +" from dropdown in the hana dashboard");
			dashboard.CashAndCarryMenuClick();	
			cashandcarry = new CashAndCarryPage();
			logger.info("User hover the mouse on New order and click on Cash and Carry..");
			softassert.assertTrue(cashandcarry.VerifyCashAndCarryPage(), "Cash And Carry page is not displayed");
			logger.info("User verify the Cash and Carry page is displayed..");

			// Test Step - 4
			cashandcarry.SelectShopName(prop.getProperty("shopname")); //"Hana POS (Canada)"
			logger.info("User selected shop name as "+prop.getProperty("shopname"));

			//Test Step - 5
			cashandcarry.SelectClerkName(prop.getProperty("clerkname")); //"Automation clerk desc"
			logger.info("User select the clerk name as "+prop.getProperty("clerkname"));

			// Test Step - 6
			cashandcarry.SelectEmployeeName(prop.getProperty("employeename")); //"QA Team Automation"
			logger.info("User select the employee name as "+prop.getProperty("employeename"));

			// Test Step - 7
			cashandcarry.SearchAndSelectTheItemCode(searchandselectitemcode);
			logger.info("User search and select the item code as "+ searchandselectitemcode);
			softassert.assertEquals(cashandcarry.ItemDescriptionValueIsExist(), "Red Rose Deluxe");	
			softassert.assertEquals(cashandcarry.ItemQtyValueIsExist(), "1");
			
			if(cashandcarry.ItemPriceValueIsExist()=="299") {
				softassert.assertEquals(cashandcarry.ItemPriceValueIsExist(), "299","Item price is not matched with search and selected item code");
			}else if(cashandcarry.ItemPriceValueIsExist()=="309") {
				softassert.assertEquals(cashandcarry.ItemPriceValueIsExist(), "309","Item price is not matched with search and selected item code");
			}
			
			
			softassert.assertEquals(cashandcarry.ItemDiscountAmountIsExist(),"0");
			softassert.assertEquals(cashandcarry.ItemDiscountPercentageValueIsExist(), "0");
			logger.info("Validate search and selected item is displayed correctly into the table grid");
			
			// Test Step - 8
			cashandcarry.ClickAddItem();
			logger.info("User click on the add item at action");
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
			logger.info("User verify the search and selected data are displayed in table grid ");
			
			// Test Step - 09
			delayWithGivenTime(1000);
			cashandcarry.ClickParticularProdTitle();
			logger.info("User click on the particular product title on left side");
			softassert.assertEquals(cashandcarry.getAddedItemCodeRow2(),"ballonsYY");
			logger.info("User verify that added tile product is displayed on table grid");
			
			// Test Step - 10
			cashandcarry.EnterCustomerName(customershortname);
			logger.info("User enter the customer name as "+ customershortname );
			cashandcarry.SelectTaxType("Tax Exemption");
			cashandcarry.SelectOccasion("Birthday");
			logger.info("User select the occasion as Birthday");
			cashandcarry.ClickPayButton();

			logger.info("User click on Pay button");
			cashandcarrypayment = new CashAndCarryPaymentPage();
			delayWithGivenTime(2000);
			softassert.assertTrue(cashandcarrypayment.IsPaymentPageDisplayed(),"Cash And Carry payment page is not displayed");
			logger.info("User is on Cash And Carry payment page");

			// Test Step - 11
			cashandcarrypayment.ClickCashTab();
			logger.info("User select the payment type as cash tab");
			cashandcarrypayment.EnterGivenAmount();
			
			// Test Step - 12	
			cashandcarrypayment.ClickProcessPaymentBtn();
			logger.info("User clicks on the process payment button");
			delayWithGivenTime(1000);
			softassert.assertTrue(cashandcarrypayment.SuccessToastMsg()); 		
			logger.info("User verified the order payment done successfully");
			softassert.assertEquals(cashandcarrypayment.getOrderConfirmationToastMsg(),"Order payment done successfully");
			logger.info("User verify the toast message text as "+cashandcarrypayment.getOrderConfirmationToastMsg());
		
			delayWithGivenTime(2000);
			if(cashandcarrypayment.getConfirmationPopup()==true) {
				softassert.assertTrue(cashandcarrypayment.VerifyOrderConfirmationPopup(),"Order confirmation popup is not displayed");
				logger.info("User verify the order confirmation popup is displayed");
				softassert.assertTrue(cashandcarrypayment.GetOrderConfirmationMsgAndInvoiceNo(),"Order confirmation message and invoice number is not displayed");	
				logger.info("User verify the order confirmation message and invoice number is displayed");
				cashandcarrypayment.GetInvoiceNumber();
				logger.info(("Generated Order invoice number is :"+cashandcarrypayment.GetInvoiceNumber()));
				System.out.println("Order invoice number is :"+cashandcarrypayment.GetInvoiceNumber());				
				cashandcarrypayment.GetTenderPrice();
				logger.info("The remaining amount given to customer is :"+cashandcarrypayment.GetTenderPrice());
				System.out.println("The remaining amount given to customer is :"+cashandcarrypayment.GetTenderPrice());			
			}	
	
		//	RobotDismissAlert();
			logger.info("User click the cancel button on webclientprint window popup");
			delayWithGivenTime(1000);
					
			// Test Step - 13
			softassert.assertEquals(cashandcarrypayment.GetConfirmationPopupCustEmail(),"hanaposqateam@gmail.com","******Test Failed: Email id is not autopopulated from customer details******");
			logger.info("User verify the customer popup email as "+cashandcarrypayment.GetConfirmationPopupCustEmail());
			
			softassert.assertEquals(cashandcarrypayment.GetConfirmationPopupCustSMS(), "956-655-0756","******Test Failed: SMS Phone number is not autopopulated from customer details******");
			logger.info("User verify the customer popup customer sms "+cashandcarrypayment.GetConfirmationPopupCustSMS());
			
			//Test Step - 14
			delayWithGivenTime(1000);
			cashandcarrypayment.ClickSendReciptBtnOnOrderConfirmationPopup();
			logger.info("User click send receipt button in order confirmation popup");
			delayWithGivenTime(1000);
			softassert.assertEquals(cashandcarrypayment.getOrderConfirmationToastMsg(),"Receipt sent successfully.");
			logger.info("User verify the toast message text as "+cashandcarrypayment.getOrderConfirmationToastMsg());
			
			// Test Step - 15
			// Future Enhancement..
			
			//	EmailReader.getInstance();
			//	System.out.println("Received Email Invoice number is :" + EmailReader.getInvoiceNumber());
			
			logger.info("User click the send recipt button on order confirmation popup");
			logger.info("***** Need to verify email notification is received on registered mail id for confirmation order invoice is generated by tested manually *****");
			
			//	softassert.assertEquals(EmailReader.getInvoiceNumber(),cashandcarrypayment.GetInvoiceNumber());
			//	logger.info("User validate the email notification and validate the invoice number as "+EmailReader.getInvoiceNumber());
			
			
			// Test Step - 16,17 & 18 are need to be done manually
			logger.info("***** Need to verify email body messages is received on registered mail id which is done by tested manually *****");	
			
			logger.info("**** Finished Hana_T20_CashAndCarryOrderConfirmationEmail_FT  ****");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
			logger.error(e.getMessage());
		}finally {
			softassert.assertAll();
		}

	}
}
