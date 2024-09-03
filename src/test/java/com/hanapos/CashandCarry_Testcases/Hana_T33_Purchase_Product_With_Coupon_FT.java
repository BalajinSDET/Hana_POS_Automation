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

public class Hana_T33_Purchase_Product_With_Coupon_FT extends TestBaseClass{
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private CashAndCarryPage cashandcarry;
	private CashAndCarryPaymentPage cashandcarrypayment;
	public static final String dataSheetName = "Hana_T33";
	SoftAssert softassert = new SoftAssert();
	public static ExecutorService executorService;

	@DataProvider(name = "fetch_Excel_Data") 
	public Object[][] fetchData() throws IOException { 
		return DataLibrary.readExcelData(dataSheetName); 
	}

	/*
	 * HANA-T33 - 1 to 14 - Verify Cash and Carry Page -Purchase Product with Coupon - Functionality
	 */

	@Test(priority=1,enabled=true,groups= {"Smoke","Regression"},dataProvider="fetch_Excel_Data") 
	public void  Validate_Hana_T33_Purchase_Product_With_Coupon_Test(String searchandselectitemcode, String couponcode,String customershorttext) throws IOException {
		// Test Step - 1
		logger.info("**** Starting HANA-T33_Cash And Carry Purchase Product with Coupon - Functionality  ****");
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
			logger.info("User navigated to hana dashboard page sucessfully");
			
			// Test Step - 3
			dashboard.SelectShopNameDropDown(prop.getProperty("shopname"));
			logger.info("User select the shop name as "+prop.getProperty("shopname") +"in the dashboard page");
			dashboard.CashAndCarryMenuClick();			
			cashandcarry = new CashAndCarryPage();
			logger.info("User hover the mouse on New order and click on Cash and Carry..");
			softassert.assertTrue(cashandcarry.VerifyCashAndCarryPage(), "Cash And Carry page is not displayed");
			logger.info("User verify the Cash and Carry page is displayed..");
			
			// Test Step - 4
			cashandcarry.SelectShopName(prop.getProperty("shopname")); //"Hana POS (Canada)"
			logger.info("User select the shop name as "+prop.getProperty("shopname"));
			
			//Test Step - 5
			cashandcarry.SelectClerkName(prop.getProperty("clerkname")); //"Automation clerk desc"
			logger.info("User select the clerk name as "+prop.getProperty("clerkname"));
			
			// Test Step - 6
			cashandcarry.SelectEmployeeName(prop.getProperty("employeename")); //"QA Team Automation"
			logger.info("User select the employee name as "+prop.getProperty("employeename"));

			// Test Step - 7
			softassert.assertTrue(cashandcarry.IsPayButtonDisabled(), "Pay button is not disabled");
			logger.info("User verify the pay button is disabled");
			
			// Test Step - 8
			cashandcarry.SearchAndSelectTheItemCode(searchandselectitemcode);
			logger.info("User search and select the item code as "+searchandselectitemcode);
			softassert.assertEquals(cashandcarry.ItemDescriptionValueIsExist(), "Red Rose Deluxe");	
			softassert.assertEquals(cashandcarry.ItemQtyValueIsExist(), "1");
			
			if(cashandcarry.ItemPriceValueIsExist()=="299") {
				softassert.assertEquals(cashandcarry.ItemPriceValueIsExist(), "299","Item price is not matched with search and selected item code");
			}else if(cashandcarry.ItemPriceValueIsExist()=="309") {
				softassert.assertEquals(cashandcarry.ItemPriceValueIsExist(), "309","Item price is not matched with search and selected item code");
			}
			
			softassert.assertEquals(cashandcarry.ItemDiscountAmountIsExist(),"0");
			softassert.assertEquals(cashandcarry.ItemDiscountPercentageValueIsExist(), "0");
			logger.info("User verify add the item to the table grid is displayed or matched");
			
			// Test Step - 9
			cashandcarry.ClickAddItem();
			logger.info("User click on Add item plus icon button");
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
			logger.info("User verify add the item to the table grid is displayed or matched");
			
			//Test Step - 10	
			delayWithGivenTime(2000);		
			cashandcarry.ClickParticularProdTitle();
			logger.info("User click on particular product tile");
			softassert.assertEquals(cashandcarry.getAddedItemCodeRow2(),"ballonsYY");
			logger.info("User verify add the tile product to the Cash and Carry page is displayed..");

			// Test Step - 11
			cashandcarry.EnterCouponCode(couponcode);
			logger.info("User enter the coupon code as "+couponcode);
			cashandcarry.SelectTaxType("Tax Exemption");
			cashandcarry.SelectOccasion("Birthday");
			logger.info("User select the Occasion as Birthday");
			delayWithGivenTime(2000);
			softassert.assertEquals(cashandcarry.getDiscountAmountvalueOrderLevel(),cashandcarry.ValidateDiscountDefaultValues(),"Test Step - 11 - Discount dollar amount is not matched with the coupon code");
			logger.info("User verify the discount dollar amount is matched with the coupon code");
			
			// Test Step - 12	
			softassert.assertEquals(cashandcarry.ValidateGrandTotal(),cashandcarry.ActualGrandTotal(), "Test Step - 12 - Grand total amount is not calculated correctly" );	
			logger.info("User validate the grand total amount is calculated correctly with coupon discount");
			cashandcarry.ClickPayButton();
			logger.info("User click on Pay button");
			delayWithGivenTime(2000);
			cashandcarrypayment = new CashAndCarryPaymentPage();
			softassert.assertTrue(cashandcarrypayment.IsPaymentPageDisplayed(),"Cash And Carry payment page is not displayed");
			logger.info("User verify the Cash And Carry payment page is displayed");
			
			// Test Step - 13
			cashandcarrypayment.ClickCashTab();
			logger.info("User select the payment type as cash tab");
			cashandcarrypayment.EnterGivenAmount();
			logger.info("User enter the amount in given amount field");		
			cashandcarrypayment.SearchAndSelectCustomer(customershorttext);
			logger.info("User search and select the customer as "+customershorttext);	
			cashandcarrypayment.ClickProcessPaymentBtn();
			softassert.assertTrue(cashandcarrypayment.SuccessToastMsg()); 		
			logger.info("User verified the order payment done successfully");
			softassert.assertEquals(cashandcarrypayment.getOrderConfirmationToastMsg(),"Order payment done successfully");
			logger.info("User verify the text of toast success message as order payment done successfully is displayed");
			
			delayWithGivenTime(2000);
			if(cashandcarrypayment.getConfirmationPopup()==true) {
				softassert.assertTrue(cashandcarrypayment.VerifyOrderConfirmationPopup(),"Order confirmation popup is not displayed");
				logger.info("User verify the order confirmation popup is displayed");
				
				softassert.assertTrue(cashandcarrypayment.GetOrderConfirmationMsgAndInvoiceNo(),"Order confirmation message and invoice number is not displayed");		
				logger.info("User verify the order confirmation message and invoice number is displayed");
			
				cashandcarrypayment.GetInvoiceNumber();		
				logger.info(("Generated Order invoice number is :"+cashandcarrypayment.GetInvoiceNumber()));
				
				cashandcarrypayment.GetTenderPrice();
				logger.info(("The remaining amount given to customer is :"+cashandcarrypayment.GetTenderPrice()));
			}	
		//	RobotDismissAlert();
			logger.info("User click the cancel button on webclientprint window popup");
			
			// Test Step - 14
			cashandcarrypayment.ClickOrderConfirmationPopupCloseBtn();
			logger.info("User click on close button on order confirmation popup");
			softassert.assertAll();
			logger.info("**** Finished Hana_T33_Purchase_Product_With_Coupon_Functional Test Case  ****");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
			logger.error(e.getMessage());
		}	

	}
}
