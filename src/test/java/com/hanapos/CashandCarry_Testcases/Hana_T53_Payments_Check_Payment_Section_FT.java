package com.hanapos.CashandCarry_Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.hanapos.pageObjects.CashAndCarryPage;
import com.hanapos.pageObjects.CashAndCarryPaymentPage;
import com.hanapos.pageObjects.HanaDashBoardPage;
import com.hanapos.pageObjects.LoginPage;
import com.hanapos.seleniumProjectBase.TestBaseClass;
import com.hanapos.utilities.CustomSoftAssert;
import com.hanapos.utilities.DataLibrary;
import com.hanapos.utilities.ExtentReportManager;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


public class Hana_T53_Payments_Check_Payment_Section_FT extends TestBaseClass{
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private CashAndCarryPage cashandcarry;
	private CashAndCarryPaymentPage cashandcarrypayment;
	public static final String dataSheetName = "Hana_T53"; 

	// SoftAssert softassert = new SoftAssert(); - I have modified this to use CustomSoftAssert
	CustomSoftAssert softassert = new CustomSoftAssert();
	
	String invoiceNo;
	String invoicenumber;
	
	@DataProvider(name = "fetch_Excel_Data") 
	public Object[][] fetchData() throws IOException { 
		return DataLibrary.readExcelData(dataSheetName); 
	}

	/*
	 * HANA-T53 - 1 to 23 - Verify Payments_Check_Payment_Secion Functionality
	 */
//retryAnalyzer= com.hanapos.utilities.RetryTest.class,
	
	
	@Description("This test case is used to Validate the cash and carry Check Payment Section functionality")
	@Severity(SeverityLevel.CRITICAL)
	@Owner("Balaji N")
	@Epic("Cash and Carry Module")
	@Feature("Cash and Carry Check Payment Section functionality")
	@Test(enabled=true,groups= {"Smoke","Regression"},dataProvider="fetch_Excel_Data",description="This test case is used to validate the cash and carry Check Payment Section functionality") 
	public void  Validate_Hana_T53_Payments_Check_Payment_Section_Test(String searchandselectitemcode, String customername, String occasion, String checksplnum, String checknum, String bankname, String nameofcheck) throws InterruptedException, IOException {
       
		ExtentTest test = ExtentReportManager.createTest("Cash and Carry Check Payment functionality Test", "This test case is used to validate the cash and carry Check Payment Section functionality");

		// Test Step - 1
        test.log(Status.INFO, "Starting the Hana T53 Payments Check Payment Secion Cash And Carry Test");
		logger.info("**** Starting Hana_T53_Payments_Check_Payment_Secion_CashAndCarryTest  ****");
		try {
			lp = new LoginPage();
            test.log(Status.INFO, "Navigating to the login page");
			softassert.assertTrue(lp.LoginPageIsDisplayed(),"Test Step - 1 : Login page is not displayed");
			Allure.step("User on the hana pos login page");
			test.log(Status.PASS, "User on the hana pos login page successfully");
			
			// Test Step - 2
			test.log(Status.INFO, "User entering username");
			lp.EnterUserName(prop.getProperty("username"));
			Allure.step("User entered username as "+prop.getProperty("username"));
            test.log(Status.PASS, "User entered username as " + prop.getProperty("username") + " in the login page");

			test.log(Status.INFO, "User entering password");
			lp.EnterPassword(prop.getProperty("password"));
			test.log(Status.PASS, "User entered password as " + prop.getProperty("password") + " in the login page");
			Allure.step("User entered username as "+prop.getProperty("password"));
			
			test.log(Status.INFO, "User going to clicked on Login button");
			lp.ClickLoginButton();
			Allure.step("User clicked on Login button..");
			test.log(Status.PASS, "User clicked on Login button successfully");

			dashboard = new HanaDashBoardPage();
			test.log(Status.INFO, "User navigated to hana dashboard page");
			Assert.assertTrue(dashboard.VerifyHanaDashBoardPage(),"Test Step - 2 : Hana dashboard Page does not navigated to hana dashboard page");
			Allure.step("User navigated to hana dashboard page sucess..");
			test.log(Status.PASS, "User navigated to hana dashboard page sucessfully");
			
			// Test Step - 3
			dashboard.SelectShopNameDropDown(prop.getProperty("shopname"));
			Allure.step("User selected the shop name as "+prop.getProperty("shopname")+ "in dashboard page");
			test.log(Status.PASS, "User select the shop name from the drop down on dashboard page");

			dashboard.CashAndCarryMenuClick();							
			cashandcarry = new CashAndCarryPage();
			test.log(Status.PASS, "User hover the mouse on New order and click on Cash and Carry..");
			Allure.step("User hover the mouse on New order and click on Cash and Carry..");
			
			test.log(Status.INFO, "User navigated to the Cash and Carry page");
			softassert.assertTrue(cashandcarry.VerifyCashAndCarryPage(), "Cash And Carry page is not displayed");
			Allure.step("User verify the Cash and Carry page is displayed..");
			test.log(Status.PASS, "User verify the Cash and Carry page is displayed..");
			
			// Test Step - 4
			cashandcarry.SelectShopName(prop.getProperty("shopname")); //"Hana POS (Canada)"
			Allure.step("User select the shop name as "+prop.getProperty("shopname")+ "in cash and carry page");
			
			//Test Step - 5
			cashandcarry.SelectClerkName(prop.getProperty("clerkname")); //"Automation clerk desc"
			Allure.step("User select the clerk name as "+prop.getProperty("clerkname"));
			
			// Test Step - 6
			cashandcarry.SelectEmployeeName(prop.getProperty("employeename")); //"QA Team Automation"
			Allure.step("User select the employee name as "+prop.getProperty("employeename"));

			// Test Step - 7
			cashandcarry.SearchAndSelectTheItemCode(searchandselectitemcode);
			Allure.step("User search and select the item code as "+searchandselectitemcode);
			softassert.assertEquals(cashandcarry.ItemDescriptionValueIsExist(), "Red Rose Deluxe","Test Step - 7 : Item description is not matched with search and selected item code");	
			softassert.assertEquals(cashandcarry.ItemQtyValueIsExist(), "1","Test Step - 7 : Item quantity is not matched with search and selected item code");
			
			if(cashandcarry.ItemPriceValueIsExist()=="299") {
				softassert.assertEquals(cashandcarry.ItemPriceValueIsExist(), "299","Test Step - 7 : Item price is not matched with search and selected item code");
			}else if(cashandcarry.ItemPriceValueIsExist()=="309") {
				softassert.assertEquals(cashandcarry.ItemPriceValueIsExist(), "309","Test Step - 7 : Item price is not matched with search and selected item code");
			}
			
			softassert.assertEquals(cashandcarry.ItemDiscountAmountIsExist(),"0","Test Step - 7 : Item discount amount is not matched with search and selected item code");
			softassert.assertEquals(cashandcarry.ItemDiscountPercentageValueIsExist(), "0","Test Step - 7 : Item discount percentage is not matched with search and selected item code");

			// Test Step - 8
			cashandcarry.ClickAddItem();
			Allure.step("User click on Add item button");
			softassert.assertTrue(cashandcarry.VerifyAddedItem());
			Allure.step("User verify the added item is displayed");
			softassert.assertEquals(cashandcarry.getAddedItemCode(),"rrd","Test Step - 8 : Added item code is not matched with search and selected item code");
			softassert.assertEquals(cashandcarry.GetAddedItemDescription(),"Red Rose Deluxe","Test Step - 8 : Added item description is not matched with search and selected item code");
			softassert.assertEquals(cashandcarry.GetAddedItemQty(), "1","Test Step - 8 : Added item quantity is not matched with search and selected item code");
			
			if(cashandcarry.GetAddedItemExtPrice()=="$299.00") {
				softassert.assertEquals(cashandcarry.GetAddedItemExtPrice(), "$299.00","Test Step - 8 : Added item extended price is not matched with search and selected item code");
			}else if(cashandcarry.GetAddedItemExtPrice()=="$309.00") {
				softassert.assertEquals(cashandcarry.GetAddedItemExtPrice(), "$309.00","Test Step - 8 : Added item extended price is not matched with search and selected item code");
			}
			
			if(cashandcarry.GetAddedItemPrice()=="$299.00") {
				softassert.assertEquals(cashandcarry.GetAddedItemPrice(), "$299.00","Test Step - 8 : Added item price is not matched with search and selected item code");
			}else if(cashandcarry.GetAddedItemPrice()=="$309.00") {
				softassert.assertEquals(cashandcarry.GetAddedItemPrice(), "$309.00","Test Step - 8 : Added item price is not matched with search and selected item code");
			}
			
			softassert.assertEquals(cashandcarry.GetAddedItemDiscountAmount(), "$ 0.00","Test Step - 8 : Added item discount amount is not matched with search and selected item code");
			softassert.assertEquals(cashandcarry.GetAddedItemDiscountPercentage(),"0.00","Test Step - 8 : Added item discount percentage is not matched with search and selected item code");

			
			// Test Step - 9
			delayWithGivenTime(2000);
			cashandcarry.ClickParticularProdTitle();
			Allure.step("User click on the particular product tile");
			softassert.assertEquals(cashandcarry.getAddedItemCodeRow2(),"ballonsYY","Test Step - 9 : Selected product tile is not displayed in table grid row 2");
			Allure.step("User verify add the title product to the Cash and Carry page is displayed..");		
			
			// Test Step - 10
			cashandcarry.EnterCustomerName(customername);
			Allure.step("User search and select the created customer "+customername);
			cashandcarry.SelectTaxType("Tax Exemption");
			Allure.step("User select the tax type as "+"Tax Exemption");
			cashandcarry.SelectOccasion(occasion);
			Allure.step("User select the occasion as Birthday");
			delayWithGivenTime(1000);
			cashandcarry.ClickPayButton();
			Allure.step("User click on Pay button");
			delayWithGivenTime(2000);
			cashandcarrypayment = new CashAndCarryPaymentPage();
			softassert.assertTrue(cashandcarrypayment.IsPaymentPageDisplayed(),"Test Step - 10 : Cash And Carry payment page is not displayed");
			Allure.step("User navigated to Cash And Carry payment page successfully");
			
			// Test Step - 11	
			delayWithGivenTime(2000);
			softassert.assertEquals(cashandcarrypayment.VerifyCreditCardTabIsSelected(),"true", "Test Step - 11 : By defaultCredit card tab section is not displayed");
			Allure.step("User verified Credit card tab is selected");
			
			// Test Step - 12
			delayWithGivenTime(2000);
			cashandcarrypayment.ClickCheckTab();
			Allure.step("User click on Check tab");
			
			softassert.assertTrue(cashandcarrypayment.VerifyCheckTabDisplayed(), "Test Step - 12 : Check tab is not displayed");
			Allure.step("User verified Check tab is displayed");
			
			// Test Step - 13
			delayWithGivenTime(2000);
			softassert.assertEquals(cashandcarrypayment.getDisplayedCheckNumber(),"1844020000000010","Test Step - 13 : Check number is not displayed");
			Allure.step("User verified Check number is displayed");
			softassert.assertEquals(cashandcarrypayment.getDisplayedBankName(),"Bank Of America","Test Step - 13 : Check bank name is not displayed");
			Allure.step("User verified Check bank name is displayed");
			softassert.assertEquals(cashandcarrypayment.getDisplayedCheckName(),"Hana POS","Test Step - 13 : Check name is not displayed");
			Allure.step("User verified Check name is displayed");
			//	softassert.assertFalse(cashandcarrypayment.VerifyProcessPaymentButton(),"Process payment button is not disabled");
			//System.out.println("Process payment button is disabled status : "+cashandcarrypayment.VerifyProcessPaymentButton());
			
			
			// Test Step - 14
			cashandcarrypayment.ClickProcessPaymentBtn();
			Allure.step("User click on Process payment button");
			
			softassert.assertTrue(cashandcarrypayment.SuccessToastMsg(),"Test Step - 14 : Order payment done successfully"); 		
			Allure.step("User verified the order payment done successfully");
			
			softassert.assertEquals(cashandcarrypayment.getOrderConfirmationToastMsg(),"Order payment done successfully","Test Step - 14 : Order payment done successfully message is not displayed");
			Allure.step("User verified the order payment done successfully message is displayed");
			
			delayWithGivenTime(1000);
			if(cashandcarrypayment.getConfirmationPopup()==true) {
				cashandcarrypayment.VerifyOrderConfirmationPopup();
				logger.info("User verify the order confirmation popup is displayed");
				cashandcarrypayment.GetOrderConfirmationMsgAndInvoiceNo();	
				logger.info("User verify the order confirmation message and invoice number is displayed");
				invoiceNo =	cashandcarrypayment.GetInvoiceNumber();
				Allure.step(("Generated Order invoice number is :"+invoiceNo));
				cashandcarrypayment.GetTenderPrice();
				logger.info(("The remaining amount given to customer is :"+cashandcarrypayment.GetTenderPrice()));
			}	
					
			Allure.step("User click the cancel button on webclientprint window popup");
		
			// Test Step - 15
			delayWithGivenTime(1000);
			cashandcarrypayment.ClickOrderConfirmationPopupCloseBtn();
			Allure.step("User click on close button on order confirmation popup");
			
			delayWithGivenTime(4000);
			softassert.assertTrue(cashandcarry.VerifyCashAndCarryPage(), "Test Step - 15 : Cash And Carry page is not displayed");
			Allure.step("User verify the Cash and Carry page is displayed..");
			
			delayWithGivenTime(2000);
			cashandcarry.SearchAndSelectTheItemCode(searchandselectitemcode);
			Allure.step("User search and select the item code as "+searchandselectitemcode);
			softassert.assertEquals(cashandcarry.ItemDescriptionValueIsExist(), "Red Rose Deluxe","Test Step - 16 : Item description is not matched with search and selected item code");	
			softassert.assertEquals(cashandcarry.ItemQtyValueIsExist(), "1","Test Step - 16 : Item quantity is not matched with search and selected item code");
			
			if(cashandcarry.ItemPriceValueIsExist()=="299") {
				softassert.assertEquals(cashandcarry.ItemPriceValueIsExist(), "299","Test Step - 16 : Item price is not matched with search and selected item code");
			}else if(cashandcarry.ItemPriceValueIsExist()=="309") {
				softassert.assertEquals(cashandcarry.ItemPriceValueIsExist(), "309","Test Step - 16 : Item price is not matched with search and selected item code");
			}
			
			softassert.assertEquals(cashandcarry.ItemDiscountAmountIsExist(),"0","Test Step - 16 : Item discount amount is not matched with search and selected item code");
			softassert.assertEquals(cashandcarry.ItemDiscountPercentageValueIsExist(), "0","Test Step - 16 : Item discount percentage is not matched with search and selected item code");
			Allure.step("User verified the item details are displayed on table grid row 1");
			
			cashandcarry.ClickAddItem();
			Allure.step("User click on Add item button");
			softassert.assertTrue(cashandcarry.VerifyAddedItem());
			Allure.step("User verify the added item is displayed");
			softassert.assertEquals(cashandcarry.getAddedItemCode(),"rrd","Test Step - 16 : Added item code is not matched with search and selected item code");
			softassert.assertEquals(cashandcarry.GetAddedItemDescription(),"Red Rose Deluxe","Test Step - 16 : Added item description is not matched with search and selected item code");
			softassert.assertEquals(cashandcarry.GetAddedItemQty(), "1","Test Step - 16 : Added item quantity is not matched with search and selected item code");
			
			if(cashandcarry.GetAddedItemExtPrice()=="$299.00") {
				softassert.assertEquals(cashandcarry.GetAddedItemExtPrice(), "$299.00","Test Step - 16 : Added item price is not matched with search and selected item code");
			}else if(cashandcarry.GetAddedItemExtPrice()=="$309.00") {
				softassert.assertEquals(cashandcarry.GetAddedItemExtPrice(), "$309.00","Test Step - 16 : Added item price is not matched with search and selected item code");
			}
			
			if(cashandcarry.GetAddedItemPrice()=="$299.00") {
				softassert.assertEquals(cashandcarry.GetAddedItemPrice(), "$299.00","Test Step - 16 : Added item price is not matched with search and selected item code");
			}else if(cashandcarry.GetAddedItemPrice()=="$309.00") {
				softassert.assertEquals(cashandcarry.GetAddedItemPrice(), "$309.00","Test Step - 16 : Added item price is not matched with search and selected item code");
			}
			
			softassert.assertEquals(cashandcarry.GetAddedItemDiscountAmount(), "$ 0.00","Test Step - 16 : Added item discount amount is not matched with search and selected item code");
			softassert.assertEquals(cashandcarry.GetAddedItemDiscountPercentage(),"0.00","Test Step - 16 : Added item discount percentage is not matched with search and selected item code");
			Allure.step("User verified the added item details are displayed on table grid row 1");
			
			delayWithGivenTime(2000);
			cashandcarry.ClickParticularProdTitle();
			Allure.step("User click on the particular product tile");
			softassert.assertEquals(cashandcarry.getAddedItemCodeRow2(),"ballonsYY","Test Step - 16 : Added item code is not matched with search and selected item code");
			Allure.step("User verify add the title product to the Cash and Carry page is displayed..");		
			
			cashandcarry.EnterCustomerName(customername);
			Allure.step("User search and select the created customer "+customername);
			
			cashandcarry.SelectTaxType("Tax Exemption");
			Allure.step("User select the tax type as Tax Exemption");
			
			cashandcarry.SelectOccasion(occasion);
			Allure.step("User select the occasion as "+occasion);
			delayWithGivenTime(1000);
			
			cashandcarry.ClickPayButton();
			Allure.step("User click on Pay button");
			
			cashandcarrypayment = new CashAndCarryPaymentPage();
			softassert.assertTrue(cashandcarrypayment.IsPaymentPageDisplayed(),"Test Step - 16 : Cash And Carry payment page is not displayed");
			Allure.step("User navigated to Cash And Carry payment page successfully");			
			
			delayWithGivenTime(2000);
			softassert.assertEquals(cashandcarrypayment.VerifyCreditCardTabIsSelected(),"true", "Test Step - 16 : By defaultCredit card tab section is not displayed");
			Allure.step("User verified By default Credit card tab section is displayed");
			
			delayWithGivenTime(2000);
			cashandcarrypayment.ClickCheckTab();
			Allure.step("User click on Check tab");
			
			softassert.assertTrue(cashandcarrypayment.VerifyCheckTabDisplayed(), "Test Step - 16 : Check tab is not displayed");
			Allure.step("User verified Check tab is displayed");
			
			// Test Step - 16
			delayWithGivenTime(2000);
			test.log(Status.INFO, "Test Step - 16 : Check number is displayed");
			softassert.assertEquals(cashandcarrypayment.getDisplayedCheckNumber(),"1844020000000010", "Test Step - 16 : Check number is not displayed");
			Allure.step("User verified Check number is displayed or not as "+cashandcarrypayment.getDisplayedCheckNumber());
			
			if (cashandcarrypayment.getDisplayedCheckNumber().equals("1844020000000010")) {
                test.log(Status.PASS, "Test Step - 16 : Check number is displayed");
            } else {
                test.log(Status.FAIL, "Test Step - 16 : Check number is not displayed");
            }		
			
			test.log(Status.INFO, "Test Step - 16 : Bank name is displayed");
			softassert.assertEquals(cashandcarrypayment.getDisplayedBankName(),"Bank Of America","Test Step - 16 : Bank name is not displayed");
			Allure.step("User verified Bank name is displayed or not as "+cashandcarrypayment.getDisplayedBankName());
			
			if (cashandcarrypayment.getDisplayedBankName().equals("Bank Of America")) {
                test.log(Status.PASS, "Test Step - 16 : Bank name is displayed");
            } else {
                test.log(Status.FAIL, "Test Step - 16 : Bank name is not displayed");
            }	
			
			test.log(Status.INFO, "Test Step - 16 : Name on check is displayed");
			softassert.assertEquals(cashandcarrypayment.getDisplayedCheckName(),"Hana POS","Test Step - 16 : Name on check is not displayed");
			Allure.step("User verified Name on check is displayed or not as "+cashandcarrypayment.getDisplayedCheckName());
			
			if (cashandcarrypayment.getDisplayedCheckName().equals("Hana POS")) {
				test.log(Status.PASS, "Test Step - 16 : Name on check is displayed");
			} else {
				test.log(Status.FAIL, "Test Step - 16 : Name on check is not displayed");
			}
					
			// Test Step - 17
			cashandcarrypayment.EnterCheckNumber("");
			Allure.step("User entered blank check number");
			cashandcarrypayment.EnterBankName("");
			Allure.step("User entered blank bank name");
			cashandcarrypayment.EnterNameOnCheck("");
			Allure.step("User entered blank name on check");
			
			delayWithGivenTime(1000);
			softassert.assertEquals(cashandcarrypayment.getDisplayedCheckNumber(),"","Test Step - 17 : Check number is not displayed as blank");
			Allure.step("User verified blank check number is displayed or not as "+cashandcarrypayment.getDisplayedCheckNumber());
			softassert.assertEquals(cashandcarrypayment.getDisplayedBankName(),"","Test Step - 17 : Bank name is not displayed as blank");
			Allure.step("User verified blank bank name is displayed or not as "+cashandcarrypayment.getDisplayedBankName());
			softassert.assertEquals(cashandcarrypayment.getDisplayedCheckName(),"","Test Step - 17 : Name on check is not displayed as blank");
			Allure.step("User verified blank name on check is displayed or not as "+cashandcarrypayment.getDisplayedCheckName());
			
			// Test Step - 18
			System.out.println("Test step - 18: Process payment button is disabled status : "+cashandcarrypayment.VerifyProcessPaymentButton());
			Allure.step("User verified Process payment button is disabled status as "+cashandcarrypayment.VerifyProcessPaymentButton());
			
			// Test Step - 19
			cashandcarrypayment.EnterCheckNumber(checksplnum);
			Allure.step("User entered special check number as "+checksplnum);
			delayWithGivenTime(1000);
			softassert.assertEquals(cashandcarrypayment.getDisplayedCheckNumber(),"","Test Step - 19 : Special Check number is displayed");
			Allure.step("User verified Special Check number is displayed or not as "+cashandcarrypayment.getDisplayedCheckNumber());
			
			// Test Step - 20
			cashandcarrypayment.EnterCheckNumber(checknum);
			Allure.step("User entered check number as "+checknum);
			delayWithGivenTime(1000);
			softassert.assertEquals(cashandcarrypayment.getDisplayedCheckNumber(),"1844020000000050","Test Step - 20 : Check number is not displayed");
			Allure.step("User verified Check number is displayed or not as "+cashandcarrypayment.getDisplayedCheckNumber());
			
			// Test Step - 21
			cashandcarrypayment.EnterBankName(bankname);
			Allure.step("User entered bank name as "+bankname);
			softassert.assertEquals(cashandcarrypayment.getDisplayedBankName(),"Fedral Bank","Test Step - 21 : Bank name is not displayed");
			Allure.step("User verified Bank name is displayed or not as "+cashandcarrypayment.getDisplayedBankName());
			
			// Test Step - 22
			cashandcarrypayment.EnterNameOnCheck(nameofcheck);
			Allure.step("User entered name on check as "+nameofcheck);
			softassert.assertEquals(cashandcarrypayment.getDisplayedCheckName(),"Hana Test Automation for pos","Test Step - 22 : Name on check is not displayed");
			Allure.step("User verified Name on check is displayed or not as "+cashandcarrypayment.getDisplayedCheckName());
			
			// Test Step - 23
			cashandcarrypayment.ClickProcessPaymentBtn();
			Allure.step("User clicked on Process payment button");
			
			softassert.assertTrue(cashandcarrypayment.SuccessToastMsg(),"Test Step - 23 : Success toast message is not displayed"); 		
			logger.info("User verified the order payment done successfully");
			softassert.assertEquals(cashandcarrypayment.getOrderConfirmationToastMsg(),"Order payment done successfully","Test Step - 23 : Order confirmation toast message is not displayed");
			
			delayWithGivenTime(1000);
			if(cashandcarrypayment.getConfirmationPopup()==true) {
				cashandcarrypayment.VerifyOrderConfirmationPopup();
				logger.info("User verify the order confirmation popup is displayed");
				cashandcarrypayment.GetOrderConfirmationMsgAndInvoiceNo();	
				logger.info("User verify the order confirmation message and invoice number is displayed");
				invoicenumber = cashandcarrypayment.GetInvoiceNumber();
				Allure.step(("Generated Order invoice number is :"+invoicenumber));
				Allure.step("Order invoice number is :"+cashandcarrypayment.GetInvoiceNumber());				
				cashandcarrypayment.GetTenderPrice();
				Allure.step(("The remaining amount given to customer is :"+cashandcarrypayment.GetTenderPrice()));
				System.out.println("The remaining amount given to customer is :"+cashandcarrypayment.GetTenderPrice());			
			}	
				
		
			Allure.step("User click the cancel button on webclientprint window popup");
			cashandcarrypayment.ClickOrderConfirmationPopupCloseBtn();
			Allure.step("User click the order confirmation popup close button");
			
			Allure.step("**** Ended Hana T53 Payments Check Payment Section Functional Testcase ****");			
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
			logger.error(e.getMessage());
		}finally {
			softassert.assertAll();
			
		}
	}
}
