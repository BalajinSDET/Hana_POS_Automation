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
import com.hanapos.pageObjects.CustomerPage;
import com.hanapos.pageObjects.DashboardOrderPage;
import com.hanapos.pageObjects.HanaDashBoardPage;
import com.hanapos.pageObjects.LoginPage;
import com.hanapos.seleniumProjectBase.TestBaseClass;
import com.hanapos.utilities.DataLibrary;

public class Hana_T43_Payments_Split_Payment_FT extends TestBaseClass{
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private CashAndCarryPage cashandcarry;
	private CashAndCarryPaymentPage cashandcarrypayment;
	public static ExecutorService executorService;
	private static final int THREAD_POOL_SIZE = 2;
	public static final String dataSheetName = "Hana_T43";
	SoftAssert softassert = new SoftAssert();

	@DataProvider(name = "fetch_Excel_Data") 
	public Object[][] fetchData() throws IOException { 
		return DataLibrary.readExcelData(dataSheetName); 
	}

	/*
	 * HANA-T37 - 1 to 33 - Verify split payment Functionality
	 */
	//retryAnalyzer= com.hanapos.utilities.RetryTest.class,

	@Test(enabled=true,groups= {"Smoke","Regression"},dataProvider="fetch_Excel_Data") 
	public void  Validate_Hana_T43_Payments_Split_Payment_Test(String searchandselectitemcode, String customername, String occasion, String ccfname,String cclname, String creditcardtype, String cccardnumber, String cccvv, String cczipcode, String ccamount, String checkamount,
			String selectregistry, String cashamount,String pohamount, String giftcardnum, String giftamt, String checknumber, String bankname,String nameoncheck) throws InterruptedException, IOException {
		// Test Step - 1
		logger.info("**** Starting Hana_T43_Payments_Split_Payment_CashAndCarryTest  ****");
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
			softassert.assertTrue(cashandcarry.IsPayButtonDisabled(),"Pay button is not disabled");
			
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

			
			// Test Step - 10
			delayWithGivenTime(2000);
			cashandcarry.ClickParticularProdTitle();
			logger.info("User click on the particular product tile");
			softassert.assertEquals(cashandcarry.getAddedItemCodeRow2(),"ballonsYY");
			logger.info("User verify add the title product to the Cash and Carry page is displayed..");		
			
			// Test Step - 11
			cashandcarry.EnterCustomerName(customername);
			logger.info("User search and select the created customer ");
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
			
			// Test Step - 12	
			cashandcarrypayment.ClickSplitPaymentBtn();
			
			delayWithGivenTime(2000);
			softassert.assertTrue(cashandcarrypayment.SuccessToastMsg()); 		
			logger.info("User verified the order invoice is generated successfully");
			softassert.assertEquals(cashandcarrypayment.getOrderConfirmationToastMsg().contains("Invoice Number is:"),true,"Invoice Number is: ---> Text is not displayed");		
			delayWithGivenTime(2000);	
			
			// Test Step - 13
			softassert.assertEquals(cashandcarrypayment.getTopLeftCornerInvNo(),cashandcarrypayment.getGeneratedInvoiceNumber());
			logger.info("User verified the invoice number is displayed in the top left corner and toast message displayed invoice number are same");
			
			// Test Step - 14		
			softassert.assertEquals(cashandcarrypayment.getRow1ProductInTable().contains("Red Rose Deluxe"),true);
			softassert.assertEquals(cashandcarrypayment.getRow2ProductInTable().contains("ballonsYY - Ballons small 1 X $40.00"),true);

			// Test Step - 15
			delayWithGivenTime(2000); //.contains(cashandcarrypayment.ValidateGrandTotalWithConvFee() 5.60 is conv fee
			softassert.assertEquals(cashandcarrypayment.getPaymentGrandTotal(),"$344.60","Test Step - 15 - Grand total amount is not calculated correctly");
					
			// Test Step - 16
			delayWithGivenTime(2000);
			cashandcarrypayment.ClickCreditCardTab();
			if(cashandcarrypayment.VerifyCreditCardPresentToogleBtnIsAppear()==true) {
				cashandcarrypayment.ClickCreditCardPresentToogleBtn();
			}else {
					softassert.fail("***Credit card present toogle button is not displayed***");
				}
			cashandcarrypayment.EnterFirstNameOnCreditCardTab(ccfname);
			cashandcarrypayment.EnterLastNameOnCreditCardTab(cclname);
			cashandcarrypayment.SelectCreditCardTypeOnCreditCardTab(creditcardtype);
			cashandcarrypayment.EnterCreditCardNumberOnCreditCardTab(cccardnumber);
			cashandcarrypayment.EnterCreditCardCVVOnCreditCardTab(cccvv);
			cashandcarrypayment.EnterCreditCardZipCodeOnCreditCardTab(cczipcode);
			cashandcarrypayment.EnterCreditCardAmountOnCreditCardTab(ccamount);
			softassert.assertTrue(cashandcarrypayment.VerifyProcessPaymentButton(),"Test Step - 16: Credit card payment process button is disabled");
			//	softassert.fail("***Credit card payment process button is disabled -- Bug --***");
			cashandcarrypayment.ClickProcessPaymentBtn();
		
			delayWithGivenTime(1000);
			cashandcarrypayment.ClickCheckTab();
			cashandcarrypayment.EnterAmountOnCheckTab(checkamount);
			cashandcarrypayment.ClickProcessPaymentBtn();
			
			delayWithGivenTime(1000);
			getDriver().switchTo().activeElement();
			delayWithGivenTime(2000);
		//	executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
		//	executorService.submit(() -> handleCancelPopupOpenWebClientPrint());
		//	executorService.shutdown();
			RobotDismissAlert();
			
			softassert.assertEquals(cashandcarrypayment.VerifyPaymentTypeOnTableRow1(),"Check");
			softassert.assertEquals(cashandcarrypayment.VerifyPaidAmountOnTableRow1().contains(cashandcarrypayment.getEnteredAmountOnCheckTab()),true);		
			
			// Test Step - 17
			delayWithGivenTime(2000);
			cashandcarrypayment.ClickCashTab();
			
			// Test Step - 18
			delayWithGivenTime(2000);
			softassert.assertFalse(cashandcarrypayment.VerifyProcessPaymentButton(),"Test Step - 18: Process payment button is not disabled");
			
			// Test Step - 19
			delayWithGivenTime(2000);
			cashandcarrypayment.SelectRegistryOnCashTab(selectregistry);
			
			// Test Step - 20 
			delayWithGivenTime(1000);
			cashandcarrypayment.EnterGivenAmountOnCashTab(cashamount);
			cashandcarrypayment.ClickProcessPaymentBtn();
			delayWithGivenTime(1000);
			getDriver().switchTo().activeElement();
			delayWithGivenTime(2000);
		//	executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
		//	executorService.submit(() -> handleCancelPopupOpenWebClientPrint());
		//	executorService.shutdown();
			RobotDismissAlert();
			delayWithGivenTime(1000);
			softassert.assertEquals(cashandcarrypayment.VerifyPaymentTypeOnTableRow2(),"Cash","cash payment is not displayed");
			softassert.assertEquals(cashandcarrypayment.VerifyPaidAmountOnTableRow2().contains(cashandcarrypayment.getEnteredGivenAmountOnCashTab()),true,"amount is not matched");		
			
			// Test Step - 21 & 22 are done to replace for credit card payment
			
			// Test Step - 23
			delayWithGivenTime(2000);
			cashandcarrypayment.ClickOnPOHPaymentTab();
			
			// Test Step - 24 
			softassert.assertTrue(cashandcarrypayment.VerifyProcessPaymentButton(),"Test Step - 24: Process payment button is disabled");
			delayWithGivenTime(2000);
			cashandcarrypayment.EnterPOHAmountOnPOHPaymentTab(pohamount);
			cashandcarrypayment.ClickProcessPaymentBtn();
			delayWithGivenTime(1000);
			getDriver().switchTo().activeElement();
			delayWithGivenTime(2000);
		//	executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
		//	executorService.submit(() -> handleCancelPopupOpenWebClientPrint());
		//	executorService.shutdown();
			RobotDismissAlert();
			softassert.assertEquals(cashandcarrypayment.VerifyPaymentTypeOnTableRow3(),"Paid Outside Hana");
			softassert.assertEquals(cashandcarrypayment.VerifyPaidAmountOnTableRow3().contains(cashandcarrypayment.getEnteredPOHAmountOnPOHPaymentTab()),true);		
			
			// Test Step - 25
			delayWithGivenTime(2000);
			cashandcarrypayment.ClickOnGiftCardPaymentTab();
			
			// Test Step - 26
			delayWithGivenTime(2000);
			cashandcarrypayment.EnterGiftCardNumberOnGiftCardPaymentTab(giftcardnum);
			softassert.assertEquals(cashandcarrypayment.getDisplayedCustNameOnGiftCardPaymentTab(), "Test Automation");
			softassert.assertEquals(cashandcarrypayment.getDisplayedPaymentAmtOnGiftCardPaymentTab().contains(cashandcarrypayment.getTableDisplayedBalanceAmt()),true);
			
			// Test Step - 27
			delayWithGivenTime(2000);
			cashandcarrypayment.EnterPaymentAmtOnGiftCardPaymentTab(giftamt);
			cashandcarrypayment.ClickProcessPaymentBtn();
			delayWithGivenTime(1000);
			getDriver().switchTo().activeElement();
			delayWithGivenTime(2000);
		//	executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
		//	executorService.submit(() -> handleCancelPopupOpenWebClientPrint());
		//	executorService.shutdown();
			RobotDismissAlert();
			softassert.assertEquals(cashandcarrypayment.VerifyPaymentTypeOnTableRow4(),"Gift Card");
			softassert.assertEquals(cashandcarrypayment.VerifyPaidAmountOnTableRow4().contains(cashandcarrypayment.getDisplayedPaymentAmtOnGiftCardPaymentTab()),true);		
			
			// Test Step - 28
			cashandcarrypayment.ClickFinishBtnOnCashAndCarryPaymentPage();
			delayWithGivenTime(2000);
			softassert.assertTrue(cashandcarrypayment.VerifyAlertPopup());
			
			// Test Step - 29
			softassert.assertTrue(cashandcarrypayment.VerifyAlertIcon());
			softassert.assertEquals(cashandcarrypayment.VerifyAlertPopupWarningText(),"This order is still not fully paid. If you navigate away from this page, balance will remain on this order. Are you sure?");
			
			// Test Step - 30	
			cashandcarrypayment.ClickOnAlertPopupLeaveBtn();
			delayWithGivenTime(4000);
			softassert.assertTrue(cashandcarry.VerifyCashAndCarryPage(), "Cash And Carry page is not displayed");
			logger.info("User verify the Cash and Carry page is displayed..");
			
			// Test Step - 31
			delayWithGivenTime(2000);
			softassert.assertTrue(cashandcarry.IsPayButtonDisabled(),"Test Step - 31: Pay button is not disabled");

			cashandcarry.SearchAndSelectTheItemCode(searchandselectitemcode);
			softassert.assertEquals(cashandcarry.ItemDescriptionValueIsExist(), "Red Rose Deluxe");	
			softassert.assertEquals(cashandcarry.ItemQtyValueIsExist(), "1");
			softassert.assertEquals(cashandcarry.ItemPriceValueIsExist(), "299");
			softassert.assertEquals(cashandcarry.ItemDiscountAmountIsExist(),"0");
			softassert.assertEquals(cashandcarry.ItemDiscountPercentageValueIsExist(), "0");

			cashandcarry.ClickAddItem();
			softassert.assertTrue(cashandcarry.VerifyAddedItem());
			softassert.assertEquals(cashandcarry.getAddedItemCode(),"rrd");
			softassert.assertEquals(cashandcarry.GetAddedItemDescription(),"Red Rose Deluxe");
			softassert.assertEquals(cashandcarry.GetAddedItemQty(), "1");
			softassert.assertEquals(cashandcarry.GetAddedItemExtPrice(), "$299.00");
			softassert.assertEquals(cashandcarry.GetAddedItemPrice(), "$299.00");
			softassert.assertEquals(cashandcarry.GetAddedItemDiscountAmount(), "$ 0.00");
			softassert.assertEquals(cashandcarry.GetAddedItemDiscountPercentage(),"0.00");

			delayWithGivenTime(2000);
			cashandcarry.ClickParticularProdTitle();
			logger.info("User click on the particular product tile");
			softassert.assertEquals(cashandcarry.getAddedItemCodeRow2(),"ballonsYY");
			logger.info("User verify add the title product to the Cash and Carry page is displayed..");		

			cashandcarry.EnterCustomerName(customername);
			logger.info("User search and select the created customer ");
			cashandcarry.SelectTaxType("Tax Exemption");
			cashandcarry.SelectOccasion(occasion);
			logger.info("User select the Occasion as Birthday");
			delayWithGivenTime(1000);
			cashandcarry.ClickPayButton();
			logger.info("User click on Pay button");
			delayWithGivenTime(2000);
			cashandcarrypayment = new CashAndCarryPaymentPage();
			softassert.assertTrue(cashandcarrypayment.IsPaymentPageDisplayed(),"Cash And Carry payment page is not displayed");
			logger.info("User navigated to Cash And Carry payment page successfully");

			cashandcarrypayment.ClickSplitPaymentBtn();
			
			delayWithGivenTime(2000);
			softassert.assertTrue(cashandcarrypayment.SuccessToastMsg()); 		
			logger.info("User verified the order invoice is generated successfully");
			softassert.assertEquals(cashandcarrypayment.getOrderConfirmationToastMsg().contains("Invoice Number is:"),true,"Invoice Number is: ---> Text is not displayed");		
			delayWithGivenTime(2000);	

			softassert.assertEquals(cashandcarrypayment.getTopLeftCornerInvNo(),cashandcarrypayment.getGeneratedInvoiceNumber());
			logger.info("User verified the invoice number is displayed in the top left corner and toast message displayed invoice number are same");	
			softassert.assertEquals(cashandcarrypayment.getRow1ProductInTable().contains("Red Rose Deluxe"),true);
			softassert.assertEquals(cashandcarrypayment.getRow2ProductInTable().contains("ballonsYY - Ballons small 1 X $40.00"),true);
			delayWithGivenTime(2000);
			softassert.assertEquals(cashandcarrypayment.getPaymentGrandTotal(),"$344.60","Grand total amount is not calculated correctly");
			
			delayWithGivenTime(2000);
			cashandcarrypayment.ClickCreditCardTab();
			
			if(cashandcarrypayment.VerifyCreditCardPresentToogleBtnIsAppear()==true) {
				cashandcarrypayment.ClickCreditCardPresentToogleBtn();
			}else {
				softassert.fail("***Credit card present toogle button is not displayed***");
				}
			
			cashandcarrypayment.EnterFirstNameOnCreditCardTab(ccfname);
			cashandcarrypayment.EnterLastNameOnCreditCardTab(cclname);
			cashandcarrypayment.SelectCreditCardTypeOnCreditCardTab(creditcardtype);
			cashandcarrypayment.EnterCreditCardNumberOnCreditCardTab(cccardnumber);
			cashandcarrypayment.EnterCreditCardCVVOnCreditCardTab(cccvv);
			cashandcarrypayment.EnterCreditCardZipCodeOnCreditCardTab(cczipcode);
			cashandcarrypayment.EnterCreditCardAmountOnCreditCardTab(ccamount);
			
			softassert.assertTrue(cashandcarrypayment.VerifyProcessPaymentButton(),"Test Step - 32: Credit card payment process button is disabled");
			delayWithGivenTime(1000);
			cashandcarrypayment.ClickCheckTab();
			
			softassert.assertTrue(cashandcarrypayment.getDisplayedCheckNumber().contains(""),"Check number field is not empty");
			softassert.assertTrue(cashandcarrypayment.getDisplayedCheckName().contains(""),"Check name field is not empty");
			softassert.assertTrue(cashandcarrypayment.getDisplayedBankName().contains(""),"Bank Name field is not empty");
			
			cashandcarrypayment.EnterCheckNumber(checknumber);
			cashandcarrypayment.EnterBankName(bankname);
			cashandcarrypayment.EnterNameOnCheck(nameoncheck);
			cashandcarrypayment.EnterAmountOnCheckTab(checkamount);
			cashandcarrypayment.ClickProcessPaymentBtn();
			delayWithGivenTime(1000);
			getDriver().switchTo().activeElement();
			delayWithGivenTime(2000);
		//	executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
		//	executorService.submit(() -> handleCancelPopupOpenWebClientPrint());
		//	executorService.shutdown();
			RobotDismissAlert();	
			softassert.assertEquals(cashandcarrypayment.VerifyPaymentTypeOnTableRow1(),"Check");
			softassert.assertEquals(cashandcarrypayment.VerifyPaidAmountOnTableRow1().contains(cashandcarrypayment.getEnteredAmountOnCheckTab()),true);		
			delayWithGivenTime(2000);
			cashandcarrypayment.ClickCashTab();
			delayWithGivenTime(2000);
			softassert.assertFalse(cashandcarrypayment.VerifyProcessPaymentButton(),"Test Step - 32: Process payment button is not disabled");
			delayWithGivenTime(2000);
			cashandcarrypayment.SelectRegistryOnCashTab(selectregistry);
			delayWithGivenTime(1000);
			//	cashandcarrypayment.EnterGivenAmount();
			cashandcarrypayment.EnterGivenAmountOnCashTab(cashamount);
			cashandcarrypayment.ClickProcessPaymentBtn();
			delayWithGivenTime(1000);
			getDriver().switchTo().activeElement();
			delayWithGivenTime(2000);
		//	executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
		//	executorService.submit(() -> handleCancelPopupOpenWebClientPrint());
		//	executorService.shutdown();
			RobotDismissAlert();
			softassert.assertEquals(cashandcarrypayment.VerifyPaymentTypeOnTableRow2(),"Cash","cash payment is not displayed");
			softassert.assertEquals(cashandcarrypayment.VerifyPaidAmountOnTableRow2().contains(cashandcarrypayment.getEnteredGivenAmountOnCashTab()),true,"amount is not matched");		
			
			// Test Step - 21 & 22 are done to replace for credit card payment
			delayWithGivenTime(2000);
			cashandcarrypayment.ClickOnPOHPaymentTab();
			delayWithGivenTime(500);
			softassert.assertTrue(cashandcarrypayment.VerifyProcessPaymentButton(),"Process payment button is disabled");
			delayWithGivenTime(2000);
			cashandcarrypayment.EnterPOHAmountOnPOHPaymentTab(pohamount);
			cashandcarrypayment.ClickProcessPaymentBtn();
			delayWithGivenTime(1000);
			getDriver().switchTo().activeElement();
			delayWithGivenTime(2000);
		//	executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
		//	executorService.submit(() -> handleCancelPopupOpenWebClientPrint());
		//	executorService.shutdown();
			RobotDismissAlert();
			softassert.assertEquals(cashandcarrypayment.VerifyPaymentTypeOnTableRow3(),"Paid Outside Hana");
			softassert.assertEquals(cashandcarrypayment.VerifyPaidAmountOnTableRow3().contains(cashandcarrypayment.getEnteredPOHAmountOnPOHPaymentTab()),true);		
			delayWithGivenTime(2000);
			cashandcarrypayment.ClickOnGiftCardPaymentTab();
			delayWithGivenTime(2000);
			cashandcarrypayment.EnterGiftCardNumberOnGiftCardPaymentTab(giftcardnum);
			softassert.assertEquals(cashandcarrypayment.getDisplayedCustNameOnGiftCardPaymentTab(), "Test Automation");
			softassert.assertEquals(cashandcarrypayment.getDisplayedPaymentAmtOnGiftCardPaymentTab().contains(cashandcarrypayment.getTableDisplayedBalanceAmt()),true);
			
			// Test Step - 32
			delayWithGivenTime(2000);
			cashandcarrypayment.ClickCashTab();
			delayWithGivenTime(1000);
			
			cashandcarrypayment.EnterGivenAmountOnCashTab(cashandcarrypayment.getTableDisplayedBalanceAmt()); //
			
			logger.info("User enter the amount in given amount field");					
			
			// Test Step - 33
			cashandcarrypayment.ClickProcessPaymentBtn();
			delayWithGivenTime(1000);			
			
			if(cashandcarrypayment.SuccessToastMsg()==true) {
			softassert.assertEquals(cashandcarrypayment.getOrderConfirmationToastMsg().contains("Please tender $0.00 to Customer"),true,"Please tender $0.00 to Customer message is not displayed");
			}
			
			delayWithGivenTime(2000);
			RobotDismissAlert();
			delayWithGivenTime(1500);
		
			if(cashandcarrypayment.VerifyOrderPaidTextAppears()==true) {
			softassert.assertEquals(cashandcarrypayment.VerifyFullyPaidMessage(), "Order Fully Paid. No more payments required.","Order fully paid message is not displayed");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			softassert.fail();
			logger.error("Test case failed due to exception", e.getMessage());
		}finally {
			softassert.assertAll();
		}
	}
}
