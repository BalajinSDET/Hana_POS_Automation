package com.hanapos.cashandcarrytest;

import java.io.IOException;
import java.util.concurrent.ExecutorService;

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

public class Hana_T16_Delete_Product_FT extends TestBaseClass{
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private CashAndCarryPage cashandcarry;
	private CashAndCarryPaymentPage cashandcarrypayment;
	public static final String dataSheetName = "Hana_T16";
	SoftAssert softassert = new SoftAssert();

	@DataProvider(name = "fetch_Excel_Data") 
	public Object[][] fetchData() throws IOException { 
		return DataLibrary.readExcelData(dataSheetName); 
	}

	/*
	 * HANA-T16 - 1 to 20 - Verify Delete Product Functionality
	 */
//retryAnalyzer= com.hanapos.utilities.RetryTest.class,
	@Test(enabled=true,groups= {"Smoke","Regression"},dataProvider="fetch_Excel_Data",threadPoolSize = 2) 
	public void  Validate_Hana_T16_Delete_Product_Test(String searchandselectitemcode, String occasion) throws InterruptedException, IOException {
	
		// Test Step - 1
		logger.info("**** Starting Hana_T16_Delete_Product_CashAndCarryTest  ****");
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
			delayWithGivenTime(1000);
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
			cashandcarrypayment.ClickBackButtonOnTopRightCorner();
			logger.info("User click on Back button on top right corner");
			softassert.assertTrue(cashandcarry.VerifyCashAndCarryPage(), "Cash And Carry page is not displayed");
			logger.info("User verify the Cash and Carry page is displayed..");
			softassert.assertEquals(cashandcarry.getAddedItemCode(),"ballonsYY");
			softassert.assertEquals(cashandcarry.GetAddedItemDescription(),"Ballons small");
			softassert.assertEquals(cashandcarry.GetAddedItemQty(), "1");
			softassert.assertEquals(cashandcarry.GetAddedItemExtPrice(), "$40.00");
			softassert.assertEquals(cashandcarry.GetAddedItemPrice(), "$40.00");
			softassert.assertEquals(cashandcarry.GetAddedItemDiscountAmount(), "$ 0.00");
			softassert.assertEquals(cashandcarry.GetAddedItemDiscountPercentage(),"0.00");

			// Test Step - 13
			
			// Add one more product - Red Rose Deluxe-309
			delayWithGivenTime(1000);
			cashandcarry.SearchAndSelectTheItemCode(searchandselectitemcode);
			cashandcarry.ClickAddItem();
			delayWithGivenTime(1000);
			cashandcarry.SelectTaxType("Tax Exemption");
			// Before delete the added item on Cash and Carry page
			softassert.assertEquals(cashandcarry.ValidatePayButtonDisplayedPrice(),"339.00","Pay button displayed price is not correct as expected");
			softassert.assertEquals(cashandcarry.ValidateGrandTotalDefaultValue(),"339.00","Grand total value is not correct as expected");
			delayWithGivenTime(1000);
			cashandcarry.ClickOnDeleteIconAtRow2();
			delayWithGivenTime(1000);
			
			// Test Step - 14
			// After delete the added item on pay button
			softassert.assertEquals(cashandcarry.ValidatePayButtonDisplayedPrice(),"40.00");
			
			// Test Step - 15
			// After delete the added item on grand total
			softassert.assertEquals(cashandcarry.ValidateGrandTotalDefaultValue(),"40.00");
			
			// Test Step - 16
			
			cashandcarry.SelectOccasion(occasion);
			cashandcarry.ClickPayButton();
			logger.info("User fillout the customer,tax type & occasion details and click on Pay button");
			cashandcarrypayment = new CashAndCarryPaymentPage();
			softassert.assertTrue(cashandcarrypayment.IsPaymentPageDisplayed(),"Cash And Carry payment page is not displayed");
			logger.info("User is on Cash And Carry payment page");
			
			//Test Step -17
			cashandcarrypayment.ClickBackButtonOnTopRightCorner();
			logger.info("User click on Back button on top right corner");
			softassert.assertTrue(cashandcarry.VerifyCashAndCarryPage(), "Cash And Carry page is not displayed");
			logger.info("User verify the Cash and Carry page is displayed..");
			
			//Test Step - 18 
			softassert.assertTrue(cashandcarry.IsRow2TableAddedItemDisplayed(),"Added Red Rose Deluxe Item in row 2 table data is not deleted");
			
			// Test Step - 19
			cashandcarry.ClickOnDeleteIconAtRow1();
			
			// Test Step - 20
			softassert.assertTrue(cashandcarry.IsRow1TableAddedItemDisplayed(),"Added Item row 1 table data is not deleted");
			delayWithGivenTime(1000);
			
			softassert.assertTrue(cashandcarry.IsPayButtonDisabled(),"pay button is not disabled");
			softassert.assertEquals(cashandcarry.ValidatePayButtonDisplayedPrice(),"");
			softassert.assertEquals(cashandcarry.ValidateGrandTotalDefaultValue(),"0.00");	
			softassert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
