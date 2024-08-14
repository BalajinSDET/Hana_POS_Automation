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
import com.hanapos.pageObjects.HanaDashBoardPage;
import com.hanapos.pageObjects.LoginPage;
import com.hanapos.seleniumProjectBase.TestBaseClass;
import com.hanapos.utilities.DataLibrary;

public class Hana_T28_Gift_Card_FT extends TestBaseClass{
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private CashAndCarryPage cashandcarry;
	private CashAndCarryPaymentPage cashandcarrypayment;
	public static ExecutorService executorService;
	private static final int THREAD_POOL_SIZE = 2;
	public static final String dataSheetName = "Hana_T28";
	SoftAssert softassert = new SoftAssert();

	@DataProvider(name = "fetch_Excel_Data") 
	public Object[][] fetchData() throws IOException { 
		return DataLibrary.readExcelData(dataSheetName); 
	}

	/*
	 * HANA-T28 - 1 to 29 - Verify gift card Functionality
	 */
//retryAnalyzer= com.hanapos.utilities.RetryTest.class,
	@Test(enabled=true,groups= {"Smoke","Regression"},dataProvider="fetch_Excel_Data") 
	public void  Validate_Hana_T28_GiftCard_Functionality_Test(String instantdenomination1, String giftamt,String giftvalidamt,
			String processingfee,String giftcardno,String morethan25digitgiftcardno, String customershortname, String Instantdenomination1			) throws InterruptedException, IOException {
		// Test Step - 1
		logger.info("**** Starting HANA_T28_CashAndCarry_GiftCard_FunctionalityTest  ****");
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
			logger.info("User navigated to hana dashboard page sucessfully..");

			// Test Step - 3
			dashboard.SelectShopNameDropDown(prop.getProperty("shopname"));
			logger.info("User selected shop name as "+prop.getProperty("shopname") + "from dropdown in Hana dashboard page");
			dashboard.CashAndCarryMenuClick();							
			cashandcarry = new CashAndCarryPage();
			logger.info("User hover the mouse on New order and click on Cash and Carry..");
			softassert.assertTrue(cashandcarry.VerifyCashAndCarryPage(), "Cash And Carry page is not displayed");
			logger.info("User verify the Cash and Carry page is displayed..");

			// Test Step - 4
			cashandcarry.ClickGiftCardTile();
			logger.info("User click on Gift Card tile..");
			delayWithGivenTime(2000);
			softassert.assertTrue(cashandcarry.VerifyGiftCardSale(),"gift card sales pop up is not displayed");
			logger.info("User verify the gift card sales pop up is displayed..");
			
			// Test Step - 5
			//prerequiste
			cashandcarry.set_DefaultDenomination();
			delayWithGivenTime(1000);	
			cashandcarry.ClickOnInstantDenomination(instantdenomination1);
			logger.info("User select instant denomination as "+instantdenomination1);
			delayWithGivenTime(2000);
			softassert.assertEquals(cashandcarry.getGiftAmountValue(), "30.00","Test Step - 5 - Gift amount values are not matched");
			logger.info("User verify the gift amount values are matched..");
			softassert.assertEquals(cashandcarry.getTotalGiftValue(), "30.00","Test Step - 5 - Total gift values are not matched");
			logger.info("User verify the total gift values are matched..");
			
			// Test Step - 6
			cashandcarry.EnterAmountOnGiftamtField(giftamt);	
			logger.info("User enter amount on gift amount field as "+giftamt);
			softassert.assertEquals(cashandcarry.getGiftAmountValue(), "","Gift amount values are not matched");
			logger.info("User verify the gift amount values are matched..");
			
			//Test Step - 7
			cashandcarry.EnterAmountOnGiftamtField(giftvalidamt);
			logger.info("User enter amount on gift amount field as "+giftvalidamt);
			delayWithGivenTime(2000);
			softassert.assertEquals(cashandcarry.getGiftAmountValue(), "30","Test Step - 7 - gift amount values are not match");
			logger.info("User verify the gift amount values are matched as "+giftvalidamt);
			softassert.assertEquals(cashandcarry.getTotalGiftValue(), "30.00","Test Step - 7 - Total gift values are not match");
			logger.info("User verify the total gift values are matched as "+giftvalidamt);
			
			// Test Step - 8
			delayWithGivenTime(1000);
			softassert.assertEquals(cashandcarry.VerifyTotalGiftValueTextboxIsDisabled(),"30.00","Test Step - 8 - Total gift value field is enabled");
			logger.info("User verify the Total gift value field is disabled..");
			
			// Test Step - 9
			cashandcarry.EnterProcessingFeesOnGiftSalePopup(processingfee);
			logger.info("User enter gift card processing fee as "+processingfee);
			softassert.assertEquals(cashandcarry.getGiftCardProcessingFee(),"5.00");
			logger.info("User verify the gift card processing fee is matched as "+processingfee);
			delayWithGivenTime(2000);
			softassert.assertEquals(cashandcarry.getTotalGiftValue(), "35.00"," Test Step - 9 - Total gift values are not matched");
			logger.info("User verify the total gift values are matched as "+processingfee);
			
			// Test Step - 10
			cashandcarry.EnterGiftCardNumber("1234567890123456");
			logger.info("User enter gift card number as 1234567890123456");
			delayWithGivenTime(2000);
			cashandcarry.EnterGiftCardNumber(giftcardno);
			logger.info("User enter gift card number as "+giftcardno);
			softassert.assertEquals(cashandcarry.getGiftCardNumber(),"1234567890123456","Gift Card Number is not matched");
			logger.info("User verify the gift card number is matched as 1234567890123456");

			// Test Step - 11
			delayWithGivenTime(2000);
			cashandcarry.ClearGiftCardNumber();
			cashandcarry.EnterGiftCardNumber(morethan25digitgiftcardno);
			logger.info("User enter gift card number as "+morethan25digitgiftcardno);
			softassert.assertEquals(cashandcarry.getGiftCardNumber(),"1111122222333334444455555","Gift Card Number is not matched");
			logger.info("User verify the gift card number is matched as "+morethan25digitgiftcardno);
			
			// Test Step - 12
			cashandcarry.ClearGiftCardNumber();
			cashandcarry.EnterGiftCardNumber("12345678909990");
			logger.info("User enter gift card number as 12345678909990");
			softassert.assertEquals(cashandcarry.getGiftCardNumber(),"12345678909990","Gift Card Number is not matched");
			logger.info("User verify the gift card number is matched as 12345678909990");
			
			// Test Step - 13,14
			cashandcarry.SelectExistingGiftCardCustomer(customershortname);
			logger.info("User select existing gift card customer as "+customershortname);
			
			// Test Step - 15
			cashandcarry.ClickGiftSalesPopupCloseIcon();
			logger.info("User click on gift sales popup close icon..");
			
			delayWithGivenTime(3000);
			// Test Step - 16
			cashandcarry.ClickGiftCardTile();
			logger.info("User click on gift card tile..");
			delayWithGivenTime(2000);
			softassert.assertTrue(cashandcarry.VerifyGiftCardSale(),"gift card sales pop up is not displayed");
			logger.info("User verify the gift card sales pop up is displayed..");
			
			// Test Step - 17
			cashandcarry.ClickOnInstantDenomination(Instantdenomination1);
			logger.info("User select instant denomination as "+Instantdenomination1);
			delayWithGivenTime(2000);
			softassert.assertEquals(cashandcarry.getGiftAmountValue(), "30.00","Test Step - 17 - Gift amount values are not matched");
			logger.info("User verify the gift amount values are matched as "+Instantdenomination1);
			
			softassert.assertEquals(cashandcarry.getTotalGiftValue(), "30.00","Test Step - 17 - Total gift values are not matched");
			logger.info("User verify the total gift values are matched as "+Instantdenomination1);
			
			cashandcarry.EnterAmountOnGiftamtField("abc");	
			logger.info("User enter gift amount as abc");
			softassert.assertEquals(cashandcarry.getGiftAmountValue(), "","Gift amount values are not matched");
			logger.info("User verify the gift amount values are matched ");
			cashandcarry.EnterAmountOnGiftamtField(giftvalidamt);
			logger.info("User enter gift amount as "+giftvalidamt);
			softassert.assertEquals(cashandcarry.getGiftAmountValue(), "30");
			logger.info("User verify the gift amount values are matched as "+giftvalidamt);
			softassert.assertEquals(cashandcarry.getTotalGiftValue(), "30.00");
			logger.info("User verify the total gift values are matched as "+giftvalidamt);

			softassert.assertEquals(cashandcarry.VerifyTotalGiftValueTextboxIsDisabled(),"30.00","Test Step - 17 - Total gift value field is enabled");
			logger.info("User verify the Total gift value field is disabled..");
			cashandcarry.EnterProcessingFeesOnGiftSalePopup(processingfee);
			logger.info("User enter gift card processing fee as "+processingfee);
			softassert.assertEquals(cashandcarry.getGiftCardProcessingFee(),"5.00");	
			logger.info("User verify the gift card processing fee is matched as "+processingfee);
			delayWithGivenTime(2000);
			softassert.assertEquals(cashandcarry.getTotalGiftValue(), "35.00");
			logger.info("User verify the total gift values are displayed as 35.00");

			cashandcarry.EnterGiftCardNumber("1234567890123456");
			logger.info("User enter gift card number as 1234567890123456");
			delayWithGivenTime(2000);
			cashandcarry.EnterGiftCardNumber(giftcardno);
			logger.info("User enter gift card number as "+giftcardno);
			softassert.assertEquals(cashandcarry.getGiftCardNumber(),"1234567890123456","Gift Card Number is not matched");
			logger.info("User verify the gift card number is matched as "+giftcardno);
			delayWithGivenTime(2000);
			cashandcarry.ClearGiftCardNumber();
			cashandcarry.EnterGiftCardNumber(morethan25digitgiftcardno);
			logger.info("User enter gift card number as "+morethan25digitgiftcardno);
			softassert.assertEquals(cashandcarry.getGiftCardNumber(),"1111122222333334444455555","Gift Card Number is not matched");
			logger.info("User verify the gift card number is matched as "+morethan25digitgiftcardno);
			cashandcarry.ClearGiftCardNumber();
			
			cashandcarry.EnterGiftCardNumber(randomeNumber());
			logger.info("User enter gift card number as "+randomeNumber());
			cashandcarry.SelectExistingGiftCardCustomer(customershortname);
			logger.info("User select existing gift card customer as "+customershortname);
			delayWithGivenTime(3000);
			cashandcarry.ClickSubmitBtnInGiftSalesPopup();
			logger.info("User click on submit button in gift sales popup..");
			delayWithGivenTime(3000);
			cashandcarrypayment = new CashAndCarryPaymentPage();
			softassert.assertTrue(cashandcarrypayment.SuccessToastMsg()); 
			logger.info("User verify the success toast message is displayed..");
			// Test Step - 18,19,20
			delayWithGivenTime(3000);
			softassert.assertEquals(cashandcarry.getAddedItemCode(),"GIFTC");
			logger.info("User verify the added item code is matched as GIFTC");
			//softassert.assertEquals(cashandcarry.GetAddedItemDescription(),("Gift Card-12345678909990-Abish David"));
			softassert.assertEquals(cashandcarry.GetAddedItemQty(), "1");
			softassert.assertEquals(cashandcarry.GetAddedItemExtPrice(), "$30.00");
			softassert.assertEquals(cashandcarry.GetAddedItemPrice(), "$30.00");
			softassert.assertEquals(cashandcarry.GetAddedItemDiscountAmount(), "$ 0.00");
			softassert.assertEquals(cashandcarry.GetAddedItemDiscountPercentage(),"0.00");
			delayWithGivenTime(2000);
			softassert.assertEquals(cashandcarry.getAddedItemCodeRow2(),"GIFTCP");
			logger.info("User verify the added item code is matched as GIFTCP");
			//softassert.assertEquals(cashandcarry.GetAddedItemDescriptionRow2(),("Gift Card Processing Fee-12345678909990-Abish David"));
			softassert.assertEquals(cashandcarry.GetAddedItemQtyRow2(),"1");
			
			
			// Test Step - 22
			cashandcarry.SelectClerkName(prop.getProperty("clerkname")); //"Automation clerk desc"
			logger.info("User select the clerk name");
			cashandcarry.SelectEmployeeName(prop.getProperty("employeename")); //"QA Team Automation"
			logger.info("User select the employee name");
			cashandcarry.SelectTaxType("Tax Exemption");
			cashandcarry.SelectOccasion("Birthday");
			logger.info("User select the occasion as birthday");
			cashandcarry.ClickPayButton();
			logger.info("User click on Pay button");
			delayWithGivenTime(2000);
			cashandcarrypayment = new CashAndCarryPaymentPage();
			softassert.assertTrue(cashandcarrypayment.IsPaymentPageDisplayed(),"Cash And Carry payment page is not displayed");
			logger.info("User navigated to Cash And Carry payment page successfully");
			
			// Test Step - 23
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
				logger.info("User verify the order confirmation popup is displayed");
				cashandcarrypayment.GetOrderConfirmationMsgAndInvoiceNo();	
				logger.info("User verify the order confirmation message and invoice number is displayed");
				cashandcarrypayment.GetInvoiceNumber();
				logger.info(("Generated Order invoice number is :"+cashandcarrypayment.GetInvoiceNumber()));
				System.out.println("Order invoice number is :"+cashandcarrypayment.GetInvoiceNumber());				
				cashandcarrypayment.GetTenderPrice();
				logger.info(("The remaining amount given to customer is :"+cashandcarrypayment.GetTenderPrice()));
				System.out.println("The remaining amount given to customer is :"+cashandcarrypayment.GetTenderPrice());			
			}	

		//	delayWithGivenTime(2000);
		
		//	RobotDismissAlert();
			logger.info("User click the cancel button on web client print window popup");
			delayWithGivenTime(1000);

			cashandcarrypayment.ClickOrderConfirmationPopupCloseBtn();
			logger.info("User click on close button on order confirmation popup");
			delayWithGivenTime(1000);

			softassert.assertAll();
			logger.info("**** Finished Starting HANA_T28_CashAndCarry_GiftCard_FunctionalityTest ****");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
			logger.error("Test Failed **** Finished Starting HANA_T28_CashAndCarry_GiftCard_FunctionalityTest ****"+ e.getMessage());
		}	
	}
}
