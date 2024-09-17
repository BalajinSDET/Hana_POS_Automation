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
import com.hanapos.utilities.CustomSoftAssert;
import com.hanapos.utilities.DataLibrary;

public class Hana_T11_WalkinsSetting_CashRegistery_Customer_Copy_With_Customer_Copy_Notes_FT extends TestBaseClass {
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private CashAndCarryPage cashandcarry;
	private CashAndCarryPaymentPage cashandcarrypayment;
	public static ExecutorService executorService;
	private static final int THREAD_POOL_SIZE = 2;
	public static final String dataSheetName = "TC_002_CashAndCarryTest";
	// SoftAssert softassert = new SoftAssert(); - I have modified this to use CustomSoftAssert
	CustomSoftAssert softassert = new CustomSoftAssert();

	@DataProvider(name = "fetch_Excel_Data") 
	public Object[][] fetchData() throws IOException { 
		return DataLibrary.readExcelData(dataSheetName); 
	}

	/*
	 * HANA-T11 - 1 to 17 - Verify Cash and Carry Page - Walkins setting - Cash Registery - Customer Copy with Customer Copy Notes- Functionality

	 */
	//retryAnalyzer= com.hanapos.utilities.RetryTest.class,

	@Test(enabled=true,groups= {"Regression"}) 
	public void Validate_Hana_T11_WalkinsSetting_CashRegistery_Customer_Copy_with_Customer_Copy_Notes_FT() {
		// Test Step - 1
		logger.info("**** Starting Hana_T11_WalkinsSetting_CashRegistery_Customer_Copy_With_Customer_Copy_Notes_FT_CashAndCarryTest  ****");
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
			Assert.assertTrue(cashandcarry.VerifyCashAndCarryPage(), "Test Step - 3 : Cash And Carry page is not displayed");

			logger.info("User verify the Cash and Carry page is displayed..");

			// Test Step - 4		
			cashandcarry.SelectShopName(prop.getProperty("shopname"));
			
			// Pre-requisite - Go to walkins setting --> edit the cash registry (Automation_Don't Delete) --> 
			// set customer copy as enabled & customer copy notes as "Customer Copy Notes - Automation"

			cashandcarry.ClickWalkingSettingIcon();
			delayWithGivenTime(2000);
			softassert.assertTrue(cashandcarry.verifyWalkingSettingPopupIsDisplayed(),"Test Step - 4 : Walking Setting pop up is not displayed");

			cashandcarry.ClickAutomationDontDeleteEditBtnOnWalkInSetting();
			softassert.assertTrue(cashandcarry.VerifyAddNewWalkingSettingPopupIsDisplayed(),"Test Step - 4 : Add new walking setting pop up is not displayed");
			delayWithGivenTime(1000);
			softassert.assertTrue(cashandcarry.custCopyCheckBoxonAddNewpopUPIsSelected(),"Test Step - 4 : Customer copy checkbox is not selected");
			delayWithGivenTime(1000);
			softassert.assertEquals(cashandcarry.getEnteredCustCopyNoteonAddnewPopup(),"Customer Copy Notes - Automation","Test Step - 4 : Customer copy notes is not displayed");
			delayWithGivenTime(1000);
			cashandcarry.ClickWalkingPopupCloseIcon();
			delayWithGivenTime(3000);
			logger.info("User selected the shop name");
			
			// Test Step - 5
			softassert.assertTrue(cashandcarry.VerifyCashAndCarryPage(), "Test Step - 5 : Cash And Carry page is not displayed");
			logger.info("User verify the Cash and Carry page is displayed..");
			cashandcarry.SelectClerkName("Automation_Don't Delete");		
			logger.info("User selected the clerk as Automation_Don't Delete");

			// Test Step - 6
			cashandcarry.SelectEmployeeName(prop.getProperty("employeename"));
			logger.info("User selected the employee");
			
			// Test Step - 7
			cashandcarry.SearchAndSelectTheItemCode("rrd");
			
			// If it fails possible to check default values of qty is changed
				
			logger.info("User search and selected the item code");
			softassert.assertEquals(cashandcarry.ItemDescriptionValueIsExist(), "Red Rose Deluxe","Test Step - 7 : Item description is not matched with search and selected item code");	;
			softassert.assertEquals(cashandcarry.ItemQtyValueIsExist(), "1","Test Step - 7 : Item qty is not matched with search and selected item code");	;
			
			if(cashandcarry.ItemPriceValueIsExist()=="299") {
				softassert.assertEquals(cashandcarry.ItemPriceValueIsExist(), "299","Test Step - 7 : Item price is not matched with search and selected item code");
			}else if(cashandcarry.ItemPriceValueIsExist()=="309") {
				softassert.assertEquals(cashandcarry.ItemPriceValueIsExist(), "309","Test Step - 7 : Item price is not matched with search and selected item code");
			}			
			softassert.assertEquals(cashandcarry.ItemDiscountAmountIsExist(),"0","Test Step - 7 : Item discount amount is not matched with search and selected item code");
			softassert.assertEquals(cashandcarry.ItemDiscountPercentageValueIsExist(), "0","Test Step - 7 : Item discount percentage is not matched with search and selected item code");

			// Test Step - 8
			cashandcarry.ClickAddItem();

			// Test Step - 9
			cashandcarry.EnterCustomerName("abish");
			cashandcarry.SelectTaxType("Tax Exemption");
			cashandcarry.SelectOccasion("Birthday");
			
			// Test Step - 10
			cashandcarry.ClickPayButton();

			// Test Step - 11
			delayWithGivenTime(2000);
			cashandcarrypayment = new CashAndCarryPaymentPage();
			softassert.assertTrue(cashandcarrypayment.IsPaymentPageDisplayed(),"Test Step - 11 : Cash And Carry payment page is not displayed");
			logger.info("User is on Cash And Carry payment page");
			cashandcarrypayment.ClickCashTab();
			logger.info("User select the payment type as cash tab");
			cashandcarrypayment.EnterGivenAmount();
			cashandcarrypayment.GetCustomerId();
			cashandcarrypayment.GetCustomerName();
			cashandcarrypayment.ClickProcessPaymentBtn();
			logger.info("User click the process payment button");
			softassert.assertTrue(cashandcarrypayment.SuccessToastMsg(),"Test Step - 11 : Success toast message is not displayed"); 		
			logger.info("User verified the order payment done successfully");
			softassert.assertEquals(cashandcarrypayment.getOrderConfirmationToastMsg(),"Order payment done successfully","Test Step - 11 : Order confirmation toast message is not displayed");
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
			
			// Test Step - 12	
			logger.info("User verified the order payment done successfully");
			
			// Test Step - 13	
		//	delayWithGivenTime(2000);			
		//	RobotDismissAlert();
			logger.info("User click the cancel button on webclientprint window popup");
			delayWithGivenTime(2000);
			cashandcarrypayment.ClickOrderConfirmationPopupCloseBtn();
			delayWithGivenTime(1000);
			softassert.assertTrue(cashandcarry.VerifyCashAndCarryPage(), "Test Step - 13 : Cash And Carry page is not displayed");
			logger.info("User verify the Cash and Carry page is displayed..");
			
			// Test Step - 14		
			delayWithGivenTime(1000);
			cashandcarry.SelectEmployeeName(prop.getProperty("employeename"));
			logger.info("User selected the employee");		
			cashandcarry.SearchAndSelectTheItemCode("rrd");
			logger.info("User search and selected the item code");
			delayWithGivenTime(1000);
			softassert.assertEquals(cashandcarry.ItemDescriptionValueIsExist(), "Red Rose Deluxe","Test Step - 14 : Item description is not matched with search and selected item code");	;
			softassert.assertEquals(cashandcarry.ItemQtyValueIsExist(), "1","Test Step - 14 : Item qty is not matched with search and selected item code");	;
			
			if(cashandcarry.ItemPriceValueIsExist()=="299") {
				softassert.assertEquals(cashandcarry.ItemPriceValueIsExist(), "299","Test Step - 14 : Item price is not matched with search and selected item code");
			}else if(cashandcarry.ItemPriceValueIsExist()=="309") {
				softassert.assertEquals(cashandcarry.ItemPriceValueIsExist(), "309","Test Step - 14 : Item price is not matched with search and selected item code");
			}
			
			softassert.assertEquals(cashandcarry.ItemDiscountAmountIsExist(),"0","Test Step - 14 : Item discount amount is not matched with search and selected item code");
			softassert.assertEquals(cashandcarry.ItemDiscountPercentageValueIsExist(), "0","Test Step - 14 : Item discount percentage is not matched with search and selected item code");
			cashandcarry.ClickAddItem();
			cashandcarry.EnterCustomerName("abish");
			cashandcarry.SelectTaxType("Tax Exemption");
			cashandcarry.SelectOccasion("Birthday");
			cashandcarry.ClickPayButton();
			delayWithGivenTime(2000);
			cashandcarrypayment = new CashAndCarryPaymentPage();
			softassert.assertTrue(cashandcarrypayment.IsPaymentPageDisplayed(),"Test Step - 14 : Cash And Carry payment page is not displayed");
			logger.info("User is on Cash And Carry payment page");
			
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
			cashandcarrypayment.GetCustomerId();
			logger.info("Selected customer id is:"+cashandcarrypayment.GetCustomerId());
			cashandcarrypayment.GetCustomerName();
			logger.info("Selected customer name is:"+cashandcarrypayment.GetCustomerName());
			cashandcarrypayment.ClickProcessPaymentBtn();
			logger.info("User click the process payment button");
			softassert.assertTrue(cashandcarrypayment.SuccessToastMsg(),"Test Step - 14 : Success toast message is not displayed"); 
			logger.info("User verified the order payment done successfully");
			softassert.assertEquals(cashandcarrypayment.getOrderConfirmationToastMsg(),"Order payment done successfully","Test Step - 14 : Order payment done successfully text is not displayed");
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
		
		//	delayWithGivenTime(2000);

		//	RobotAcceptAlert();	
			delayWithGivenTime(2000);
			cashandcarrypayment.ClickOrderConfirmationPopupCloseBtn();
			logger.info("User repeat the test step from 6 to 12 and click the open webclientprint button");		
			logger.info("Finished Hana_T11_WalkinsSetting_CashRegistery_Customer_Copy_With_Customer_Copy_Notes_FT execution completed successfully");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
			logger.error("Hana_T11_WalkinsSetting_CashRegistery_Customer_Copy_With_Customer_Copy_Notes_FT failed due to "+e.getMessage());
		}finally {
			softassert.assertAll();
		}		
	}
}
