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

public class Hana_T22_ChooseDefaultvalues_Cash_and_Carry_FT extends TestBaseClass{
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private CashAndCarryPage cashandcarry;
	private CashAndCarryPaymentPage cashandcarrypayment;
	public static final String dataSheetName = "Hana_T22";
	SoftAssert softassert = new SoftAssert();
	public static ExecutorService executorService;
	private static final int THREAD_POOL_SIZE = 2;
	
	@DataProvider(name = "fetch_Excel_Data")  
	public Object[][] fetchData() throws IOException { 
		return DataLibrary.readExcelData(dataSheetName); 
	}

	/*
	 * HANA-T22 - 1 to 29 - Verify choose default values Functionality
	 */
//retryAnalyzer= com.hanapos.utilities.RetryTest.class,
	@Test(enabled=true,groups= {"Regression"},dataProvider="fetch_Excel_Data") 
	public void  Validate_Hana_T22_Choose_Default_Values_Page_Test(String bankname,String checknumber,String nameofcheck,String Splqty,String qty,String occasion,String salespersonname,String customershortname, 
			String sourcecode,String searchandselectitemcode) throws InterruptedException, IOException {
		// Test Step - 1
		logger.info("**** Starting Hana_T22_ChooseDefaultvalues_Cash_and_Carry_Functional Test  ****");
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
			logger.info("User navigated to hana dashboard page sucessfully");

			// Test Step - 3
			dashboard.SelectShopNameDropDown(prop.getProperty("shopname"));
			logger.info("User selected shop name as "+prop.getProperty("shopname") +" from dropdown in the hana dashboard");
			dashboard.CashAndCarryMenuClick();							
			cashandcarry = new CashAndCarryPage();
			logger.info("User hover the mouse on New order and click on Cash and Carry..");
			Assert.assertTrue(cashandcarry.VerifyCashAndCarryPage(), "Cash And Carry page is not displayed");
			logger.info("User verify the Cash and Carry page is displayed..");

			// Test Step - 4
			cashandcarry.ClickChooseDefaultValue();
			logger.info("User clicked on Choose Default Values button..");
			softassert.assertTrue(cashandcarry.ValidateChoosePageDefaultValuePopupIsDisplayed());
			logger.info("User verify the Choose Default Values popup is displayed..");
			
			// Test Step - 5
			cashandcarry.SelectShopOnChoosePageDefaultValues(prop.getProperty("shopname"));
			logger.info("User selected shop name as "+prop.getProperty("shopname"));
			delayWithGivenTime(2000);
			softassert.assertEquals(cashandcarry.getFirstSelectedOptionOnPageNameDD(),"Cash & Carry","Page Name is not displayed as Cash & Carry");
			logger.info("User verify the Page Name is displayed as Cash & Carry..");
			
			// Test Step - 6
			cashandcarry.EnterBankNameOnBankNameOnChooseDefaultValues(bankname);
			logger.info("User entered Bank Name as " + bankname);
			
			// Test Step - 7
			cashandcarry.EnterCheckNoOnCheckNoOnChooseDefaultValues(checknumber);
			logger.info("User entered Check Number as "+checknumber);
			
			// Test Step - 8
			cashandcarry.EnterNameofCheckOnChooseDefaultValues(nameofcheck);
			logger.info("User entered Name of Check as "+nameofcheck);
			
			// Test Step - 9		
			cashandcarry.EnterSplCharInQuantityOnChooseDefaultValues(Splqty);	
			logger.info("User entered Special Character in Quantity as "+Splqty);

			cashandcarry.ClearQuantityFieldOnChooseDefaultValues();
			cashandcarry.EnterQuantityOnChooseDefaultValues(qty); 
			logger.info("User entered Quantity as "+qty);
			
			// Test Step - 10
			cashandcarry.SelectDefaultOccasionOnChooseDefaultValues(occasion);
			logger.info("User selected Occasion as "+occasion);
			
			// Test Step - 11
			cashandcarry.SelectDefaultSalesPersonOnChooseDefaultValues(salespersonname);
			logger.info("User selected Sales Person as "+salespersonname);
			
			//Test Step - 12
			cashandcarry.SelectDefaultSourceCodeOnChooseDefaultValues(sourcecode);
			logger.info("User selected Source Code as "+sourcecode);
			
			//TestStep - 13
			
			/*
			 * if(cashandcarry.verifyErrorToastMsg()==true){
			 * softassert.assertTrue(cashandcarry.verifyErrorToastMsg()
			 * ,"***Toast error message is not displayed***"); } else{ softassert.
			 * fail("***Test Step - 13 - Toast error message is not displayed on Choose Default Values popup***"
			 * ); }
			 */
			softassert.fail("***Test Step - 13 - Toast error message for providing negative value on field is not displayed on Choose Default Values popup***" );
			cashandcarry.ClickUpdateBtnOnChooseDefaultValues();
			logger.info("User clicked on Update button on Choose Default Values popup");
			delayWithGivenTime(2000);
			softassert.assertTrue(cashandcarry.VerifySuccessMessageIsDisplayed(),"***Default values success toast message is not displayed***");
			logger.info("User verify the Default values success toast message is displayed..");
			delayWithGivenTime(2000);
			
			
			
			// TestStep - 14
			cashandcarry.ClickCloseIconOnChooseDefaultValuesPopup();
			logger.info("User clicked on Close icon on Choose Default Values popup");
			
			// Test Step - 15
			softassert.assertTrue(cashandcarry.VerifyCashAndCarryPage(), "Cash And Carry page is not displayed");
			logger.info("User verify the Cash and Carry page is displayed..");
			
			//Test Step - 16
			softassert.assertEquals(cashandcarry.getItemQtyOnProductLevel(),"1", "Quantity is not updated or autopopulated");
			logger.info("User verify the Quantity is updated successfully");
			
			// Test Step - 17
			softassert.assertEquals(cashandcarry.GetOccasionDDfirstOption(), "Birthday", "Occasion is not updated or autopopulated");
			logger.info("User verify the Occasion is updated successfully");
			
			//Test Step - 18
			softassert.assertEquals(cashandcarry.GetEmployeeDDfirstOption(),"Abish David", "Sales Person is not updated or autopopulated");
			logger.info("User verify the Sales Person is updated successfully");
			
			// Test Step - 19
			softassert.assertEquals(cashandcarry.GetSourceCodeDDfirstOption(),"Friend", "Source Code is not updated or autopopulated");
			logger.info("User verify the Source Code is updated successfully");
			
			//Test Step - 20		
			cashandcarry.SelectClerkName(prop.getProperty("clerkname"));
			logger.info("User selected Clerk Name as "+prop.getProperty("clerkname"));
			cashandcarry.SearchAndSelectTheItemCode(searchandselectitemcode);
			logger.info("User selected Item Code as "+searchandselectitemcode);
			softassert.assertEquals(cashandcarry.ItemDescriptionValueIsExist(), "Red Rose Deluxe", "Item Description is not updated or autopopulated");	
			softassert.assertEquals(cashandcarry.ItemQtyValueIsExist(), "1", "Item Quantity is not updated or autopopulated");
			
			if(cashandcarry.ItemPriceValueIsExist()=="299") {
				softassert.assertEquals(cashandcarry.ItemPriceValueIsExist(), "299","Item price is not matched with search and selected item code");
			}else if(cashandcarry.ItemPriceValueIsExist()=="309") {
				softassert.assertEquals(cashandcarry.ItemPriceValueIsExist(), "309","Item price is not matched with search and selected item code");
			}	
			
			softassert.assertEquals(cashandcarry.ItemDiscountAmountIsExist(),"0", "Item Discount Amount is not updated or autopopulated");
			softassert.assertEquals(cashandcarry.ItemDiscountPercentageValueIsExist(), "0", "Item Discount Percentage is not updated or autopopulated");
			logger.info("User verify the Item Details are updated successfully in the table grid");		
			
			// Test Step - 21
			cashandcarry.ClickAddItem();
			logger.info("User clicked on Add Item button");
			
			// Test Step - 22
			cashandcarry.ClickParticularProdTitle();
			logger.info("User clicked on Particular Product Title as ballonsYY");
			softassert.assertEquals(cashandcarry.getAddedItemCodeRow2(),"ballonsYY");
			logger.info("User verify the Added Item Code is displayed in the table grid");
			
			// Test Step - 23
			cashandcarry.SelectTaxType("Tax Exemption");
			cashandcarry.SelectOccasion("Birthday");
			logger.info("User selected Occasion as Birthday");
			cashandcarry.ClickPayButton();
			logger.info("User clicked on Pay button");
			delayWithGivenTime(2000);
			cashandcarrypayment = new CashAndCarryPaymentPage();
			softassert.assertTrue(cashandcarrypayment.IsPaymentPageDisplayed(),"Cash And Carry payment page is not displayed");
			logger.info("User verify the Cash and Carry payment page is displayed..");
			
			// Test Step - 24
			cashandcarrypayment.ClickCheckTab();
			logger.info("User clicked on Check tab as payment method");
			
			// Test Step - 25
			softassert.assertEquals(cashandcarrypayment.getDisplayedCheckNumber(), "1844020000000010", "Check number is not autopopulated");
			logger.info("User verify the Check number is autopopulated");
			
			// Test Step - 26
			softassert.assertEquals(cashandcarrypayment.getDisplayedBankName(), "Bank Of America", "Bank name is not autopopulated");
			logger.info("User verify the Bank name is autopopulated");
			
			// Test Step - 27
			softassert.assertEquals(cashandcarrypayment.getDisplayedCheckName(), "Hana POS", "Name of check is not autopopulated");
			logger.info("User verify the Name of check is autopopulated");
			
			// Test Step - 28
			cashandcarrypayment.SearchAndSelectCustomer(customershortname);
			logger.info("User selected Customer as abish");
			cashandcarrypayment.ClickProcessPaymentBtn();
			logger.info("User clicked on Process Payment button");
			softassert.assertTrue(cashandcarrypayment.SuccessToastMsg()); 		
			logger.info("User verified the order payment done successfully");
			softassert.assertEquals(cashandcarrypayment.getOrderConfirmationToastMsg(),"Order payment done successfully");
			logger.info("User verified the order payment done successfully text is displayed");
			delayWithGivenTime(1000);
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
			delayWithGivenTime(1000);
				
			getDriver().switchTo().activeElement();
			logger.info("User click the cancel button on webclientprint window popup");
			delayWithGivenTime(1000);
			
			// Test Step - 29
			cashandcarrypayment.ClickOrderConfirmationPopupCloseBtn();
			logger.info("User clicked on Close button on order confirmation popup");

			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
			logger.error("**** Abnormal Termination Hana_T22_ChooseDefaultvalues_Cash_and_Carry_Functional Test Case  ****");
		}	finally {
			softassert.assertAll();
			logger.info("**** Finished Hana_T22_ChooseDefaultvalues_Cash_and_Carry_Functional Test Case  ****");

		}

	}
}
