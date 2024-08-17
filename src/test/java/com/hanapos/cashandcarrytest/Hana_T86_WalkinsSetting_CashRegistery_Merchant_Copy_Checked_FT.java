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

public class Hana_T86_WalkinsSetting_CashRegistery_Merchant_Copy_Checked_FT extends TestBaseClass {

	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private CashAndCarryPage cashandcarry;
	private CashAndCarryPaymentPage cashandcarrypayment;
	public static final String dataSheetName = "Hana_T86";
	SoftAssert softassert = new SoftAssert();
	public static ExecutorService executorService;
	
	@DataProvider(name = "fetch_Excel_Data") 
	public Object[][] fetchData() throws IOException { 
		return DataLibrary.readExcelData(dataSheetName); 
	}

	/*
	 * HANA-T86 - 1 to 15 - Verify Cash and Carry Page - Walkins setting - Cash Registery - Merchant Copy with Checked- Functionality

	 */
	//retryAnalyzer= com.hanapos.utilities.RetryTest.class,

	@Test(enabled=true,groups= {"Regression"},dataProvider="fetch_Excel_Data") 
	public void Validate_Hana_T86_WalkinsSetting_CashRegistery_Merchant_Copy_Checked_FT(String merchantcopynote, String clerkname, String searchandselectitemcode, String customername, String taxtype, String occasion) {
		// Test Step - 1
		logger.info("**** Starting Hana_T86_WalkinsSetting_CashRegistery_Merchant_Copy_Checked_FT  ****");
		
		try {
			lp = new LoginPage();
			softassert.assertTrue(lp.LoginPageIsDisplayed(),"Login page is not displayed");
			logger.info("User on the hana pos login page");
			
			// Test Step - 2
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
			cashandcarry.SelectShopName(prop.getProperty("shopname"));
			logger.info("User selected the shop name");
			
			// Pre-requisite - Go to walkins setting --> edit the cash registry (Automation Clerk Desc) --> 
			// set merchant copy as enabled & merchant copy notes as "Automation merchant copy notes"
					cashandcarry.ClickWalkingSettingIcon();
					delayWithGivenTime(2000);
					softassert.assertTrue(cashandcarry.verifyWalkingSettingPopupIsDisplayed(),"Walking Setting pop up is not displayed");
					delayWithGivenTime(1000);
					cashandcarry.ClickAutomationClerkDescEditBtnOnWalkInSetting();
					
					delayWithGivenTime(4000);
					softassert.assertTrue(cashandcarry.VerifyAddNewWalkingSettingPopupIsDisplayed());
					cashandcarry.EnterMerchantCopyNoteonAddnewPopup(merchantcopynote);
					cashandcarry.ClickSaveBtnonAddnewPopup();
					delayWithGivenTime(1000);
					softassert.assertTrue(cashandcarry.verifyWalkingSettingPopupIsDisplayed(),"Walking Setting pop up is not displayed");
					delayWithGivenTime(1000);
					cashandcarry.ClickAutomationClerkDescEditBtnOnWalkInSetting();
					
					delayWithGivenTime(4000);
					softassert.assertTrue(cashandcarry.merchantCopyCheckBoxonAddNewpopUPIsSelected());
					if(cashandcarry.getEnteredMerchantCopyNoteonAddnewPopup().equals("Automation merchant copy notes")) {
					softassert.assertEquals(cashandcarry.getEnteredMerchantCopyNoteonAddnewPopup(),"Automation merchant copy notes");
					}else {
						softassert.fail("Merchant copy note is not getting saved");
					}
					delayWithGivenTime(1000);
					cashandcarry.ClickWalkingPopupCloseIcon();
					delayWithGivenTime(3000);
					logger.info("User selected the shop name");
					
			
			
			// Test Step - 5
			cashandcarry.SelectClerkName(clerkname);		
			logger.info("User selected the clerk");
			// Test Step - 6
			cashandcarry.SelectEmployeeName(prop.getProperty("employeename"));
			logger.info("User selected the employee");
			
			// Test Step - 7
			cashandcarry.SearchAndSelectTheItemCode(searchandselectitemcode);
			logger.info("User search and selected the item code");
			softassert.assertEquals(cashandcarry.ItemDescriptionValueIsExist(), "Red Rose Deluxe");	;
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
			// Test Step - 9
			cashandcarry.EnterCustomerName(customername);
			cashandcarry.SelectTaxType(taxtype);
			cashandcarry.SelectOccasion(occasion);
			// Test Step - 10
			cashandcarry.ClickPayButton();
			// Test Step - 11
			delayWithGivenTime(2000);
			cashandcarrypayment = new CashAndCarryPaymentPage();
			softassert.assertTrue(cashandcarrypayment.IsPaymentPageDisplayed(),"Cash And Carry payment page is not displayed");

			logger.info("User is on Cash And Carry payment page");
			delayWithGivenTime(1000);
			cashandcarrypayment.ClickCashTab();
			logger.info("User select the payment type as cash tab");
			cashandcarrypayment.EnterGivenAmount();
			cashandcarrypayment.GetCustomerId();
			cashandcarrypayment.GetCustomerName();
			cashandcarrypayment.ClickProcessPaymentBtn();

			logger.info("User click the process payment button");
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
			
			// Test Step - 12

			logger.info("User verified the order payment done successfully");
			// Test Step - 13
			
		
		//	RobotDismissAlert();
			logger.info("User click the cancel button on webclientprint window popup");
			delayWithGivenTime(1000);
			cashandcarrypayment.ClickOrderConfirmationPopupCloseBtn();
			
			// Test Step - 14			
			delayWithGivenTime(2000);
			cashandcarry.SelectEmployeeName(prop.getProperty("employeename"));
			logger.info("User selected the employee");
			
			cashandcarry.SearchAndSelectTheItemCode(searchandselectitemcode);
			logger.info("User search and selected the item code");
			softassert.assertEquals(cashandcarry.ItemDescriptionValueIsExist(), "Red Rose Deluxe");	;
			softassert.assertEquals(cashandcarry.ItemQtyValueIsExist(), "1");
			
			if(cashandcarry.ItemPriceValueIsExist()=="299") {
				softassert.assertEquals(cashandcarry.ItemPriceValueIsExist(), "299","Item price is not matched with search and selected item code");
			}else if(cashandcarry.ItemPriceValueIsExist()=="309") {
				softassert.assertEquals(cashandcarry.ItemPriceValueIsExist(), "309","Item price is not matched with search and selected item code");
			}
			
			softassert.assertEquals(cashandcarry.ItemDiscountAmountIsExist(),"0");
			softassert.assertEquals(cashandcarry.ItemDiscountPercentageValueIsExist(), "0");
			cashandcarry.ClickAddItem();
			
			cashandcarry.EnterCustomerName(customername);
			cashandcarry.SelectTaxType(taxtype);
			cashandcarry.SelectOccasion(occasion);
			cashandcarry.ClickPayButton();		
			delayWithGivenTime(2000);
			
			cashandcarrypayment = new CashAndCarryPaymentPage();
			softassert.assertTrue(cashandcarrypayment.IsPaymentPageDisplayed(),"Cash And Carry payment page is not displayed");
			logger.info("User is on Cash And Carry payment page");
			delayWithGivenTime(1000);
			
			softassert.assertTrue(cashandcarrypayment.verifyPaymentDescriptionTableIsDisplayed());
			ConsoleLog("Item Description is :"+cashandcarrypayment.getRow1PaymentDescription());
			logger.info("Item Description is :"+cashandcarrypayment.getRow1PaymentDescription());
			ConsoleLog("Item Discount is :"+cashandcarrypayment.getRow1PaymentDiscountAmount());
			logger.info("Item Discount is :"+cashandcarrypayment.getRow1PaymentDiscountAmount());
			ConsoleLog("Item Ext Price is :"+ cashandcarrypayment.getRow1PaymentExtPrice());
			logger.info("Item Ext Price is :"+cashandcarrypayment.getRow1PaymentExtPrice());
			ConsoleLog("Sub Total is :"+	cashandcarrypayment.getPaymentSubTotal());
			logger.info("Sub Total is :"+cashandcarrypayment.getPaymentSubTotal());
			ConsoleLog("GST is :"+cashandcarrypayment.getPaymentGST());
			logger.info("GST is :"+cashandcarrypayment.getPaymentGST());
			ConsoleLog("PST is :"+cashandcarrypayment.getPaymentPST());
			logger.info("PST is :"+cashandcarrypayment.getPaymentPST());
			ConsoleLog("Tax is :"+cashandcarrypayment.getPaymentTax());
			logger.info("Tax is :"+cashandcarrypayment.getPaymentTax());
			ConsoleLog("Grand Total is :"+cashandcarrypayment.getPaymentGrandTotal());
			logger.info("Grand Total is :"+cashandcarrypayment.getPaymentGrandTotal());		
			
			delayWithGivenTime(1000);
			cashandcarrypayment.ClickCashTab();
			logger.info("User select the payment type as cash tab");
			cashandcarrypayment.EnterGivenAmount();
			logger.info("User enter the given amount");
			cashandcarrypayment.GetCustomerId();
			logger.info("Selected customer id is:"+cashandcarrypayment.GetCustomerId());
			cashandcarrypayment.GetCustomerName();
			logger.info("Selected customer name is:"+cashandcarrypayment.GetCustomerName());
			cashandcarrypayment.ClickProcessPaymentBtn();
			logger.info("User click the process payment button");
			Assert.assertTrue(cashandcarrypayment.SuccessToastMsg()); 
			logger.info("User verified the order payment done successfully");
			Assert.assertEquals(cashandcarrypayment.getOrderConfirmationToastMsg(),"Order payment done successfully");
		
			delayWithGivenTime(1000);
			if(cashandcarrypayment.getConfirmationPopup()==true) {
				cashandcarrypayment.VerifyOrderConfirmationPopup();
				cashandcarrypayment.GetOrderConfirmationMsgAndInvoiceNo();		
				cashandcarrypayment.GetInvoiceNumber();
				logger.info("Order invoice number is :"+cashandcarrypayment.GetInvoiceNumber());
				System.out.println("Order invoice number is :"+cashandcarrypayment.GetInvoiceNumber());				
				cashandcarrypayment.GetTenderPrice();
				logger.info("The remaining amount given to customer is :"+cashandcarrypayment.GetTenderPrice());
				System.out.println("The remaining amount given to customer is :"+cashandcarrypayment.GetTenderPrice());			
			}
			
		//	RobotAcceptAlert();	
			delayWithGivenTime(1000);
			cashandcarrypayment.ClickOrderConfirmationPopupCloseBtn();
			logger.info("User repeat the test step from 6 to 12 and click the open webclientprint button");
			softassert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
