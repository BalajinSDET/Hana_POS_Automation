package com.hanapos.CashandCarry_Testcases;

import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hanapos.pageObjects.CashAndCarryPage;
import com.hanapos.pageObjects.HanaDashBoardPage;
import com.hanapos.pageObjects.LoginPage;
import com.hanapos.seleniumProjectBase.TestBaseClass;
import com.hanapos.utilities.DataLibrary;

public class Hana_T03_UpdateDiscountOrderLevel_FT extends TestBaseClass{

	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private CashAndCarryPage cashandcarry;
	public static final String dataSheetName = "Hana_T03";
	SoftAssert softassert = new SoftAssert();

	@DataProvider(name = "fetch_Excel_Data") 
	public Object[][] fetchData() throws IOException { 
		return DataLibrary.readExcelData(dataSheetName); 
	}
	
	//retryAnalyzer= com.hanapos.utilities.RetryTest.class,
	@Test(enabled=true,groups= {"Regression"},dataProvider="fetch_Excel_Data") 
	public void  Validate_Hana_T03_Update_DiscountOrder_LevelTest(String searchandselectitemdescription,String itemdiscountpercentage,String couponcode, String discount) throws InterruptedException, IOException, NoSuchElementException {
		
		//Hana-T03  - Update Discount Order Level
		//Test Steps - 1 to 6
		
		logger.info("**** Starting Hana_T03_UpdateDiscountOrderLevel_CashAndCarryTest  ****");
		logger.debug("capturing application debug logs....");
		try {
			lp = new LoginPage();
			softassert.assertTrue(lp.LoginPageIsDisplayed(),"Login page is not displayed");
			logger.info("User on the hana pos login page");
			
			lp.EnterUserName(prop.getProperty("username"));
			logger.info("User entered the username as "+prop.getProperty("username"));
			lp.EnterPassword(prop.getProperty("password"));
			logger.info("User entered the password as "+prop.getProperty("password"));
			lp.ClickLoginButton();
			logger.info("Clicked on Login button..");

			dashboard = new HanaDashBoardPage();
			Assert.assertTrue(dashboard.VerifyHanaDashBoardPage(),"Page does not navigated to hana dashboard page");
			logger.info("User navigated to hana dashboard page sucess..");
			dashboard.SelectShopNameDropDown(prop.getProperty("shopname"));
			logger.info("User selected the shop name as "+prop.getProperty("shopname")+ "in dashboard page");
			dashboard.CashAndCarryMenuClick();							
			cashandcarry = new CashAndCarryPage();

			logger.info("User hover the mouse on New order and click on Cash and Carry..");
			Assert.assertTrue(cashandcarry.VerifyCashAndCarryPage(), "Cash And Carry page is not displayed");

			logger.info("User verify the Cash and Carry page is displayed..");

			cashandcarry.SelectShopName(prop.getProperty("shopname"));
			logger.info("User selected the shopname on Cash and Carry page as "+prop.getProperty("shopname"));
			cashandcarry.SelectClerkName(prop.getProperty("clerkname"));
			logger.info("User selected the clerk name on Cash and Carry page as "+prop.getProperty("clerkname"));
			cashandcarry.SelectEmployeeName(prop.getProperty("employeename"));
			logger.info("User selected the employee name on Cash and Carry page as "+prop.getProperty("employeename"));
			
			//Test Step - 7
			cashandcarry.searchAndselectWithItemDescription(searchandselectitemdescription);
			logger.info("User selected the item description on Cash and Carry page as "+searchandselectitemdescription);
			
			//Test Step - 8
			cashandcarry.EnterDiscountPercentageOnAddItem(itemdiscountpercentage);
			logger.info("User entered the discount percentage on Cash and Carry page as "+itemdiscountpercentage);
			
			//Test Step - 9
			cashandcarry.ClickAddItem();
			logger.info("User clicked on Add item button on Cash and Carry page");	
			softassert.assertTrue(cashandcarry.VerifyAddedItem());
			
			//Test Step - 10	
			softassert.assertFalse(cashandcarry.CouponcodeIsDisabled(),"coupon code is enabled"); 
			softassert.assertFalse(cashandcarry.DiscountPercentageFieldIsDisabled(), "Discount percentage textbox field is enabled");
			softassert.assertFalse(cashandcarry.DiscountAmountFieldIsDisabled(), "Discount amount textbox field is enabled");

			//Test - 11
			softassert.assertTrue(cashandcarry.DiscountChangeLinkIsDisplayed());
					
			//Test Step - 12
			cashandcarry.ClickChangeLinkOnDiscountPercentageField();
			
			//Test Step - 13
			softassert.assertTrue(cashandcarry.verifyChangePopUpMessage());
			softassert.assertTrue(cashandcarry.VerifyWarningIconIsDisplayed(),"Warning icon is not displayed");
			softassert.assertTrue(cashandcarry.VerifyUpdatingDiscountText(),"update discount text is not displayed");
			softassert.assertTrue(cashandcarry.ChangeDiscountNoButton(),"No button is not displayed");
			softassert.assertTrue(cashandcarry.ChangeDiscountYesButton(),"Yes button is not displayed");
			
			
			//Test Step - 14
			cashandcarry.ClickChangeDiscountNoButton();
			
			//Test Step - 15
			cashandcarry.ClickChangeLinkOnDiscountPercentageField();
			
			//Test Step - 16
			delayWithGivenTime(2000);
			cashandcarry.ClickChangeDiscountYesButton();
			
			softassert.assertTrue(cashandcarry.CouponcodeIsDisabled(),"coupon code is not enabled"); 
			softassert.assertTrue(cashandcarry.DiscountPercentageFieldIsDisabled(), "Discount percentage textbox field is not enabled");
			softassert.assertTrue(cashandcarry.DiscountAmountFieldIsDisabled(), "Discount amount textbox field is not enabled");
			delayWithGivenTime(2000);
			
			//Test Step - 17
			cashandcarry.searchAndselectWithItemDescription(searchandselectitemdescription);
			
			//Test Step - 18
			cashandcarry.ClickAddItem();
			
			//Test Step - 19
			delayWithGivenTime(2000);
			cashandcarry.SetCouponCode(couponcode);
			cashandcarry.ClickDiscountDollarField();
			
			//Test Step - 20
			delayWithGivenTime(2000);
			cashandcarry.EnterDiscount(discount);
			delayWithGivenTime(2000);
			cashandcarry.ClickDiscountDollarField();
			
			//Test Step - 21
			delayWithGivenTime(2000);
			softassert.assertEquals(cashandcarry.getCouponCode(), "","Test Step - 21 - coupon code is not blank");
			
			// Test Step - 22
			delayWithGivenTime(2000);
			softassert.assertTrue(cashandcarry.verifyChangeDiscountOnProductLevelIsDispalyed(),"Test Step - 22 - Change discount on product level link is not displayed");
			
			//Test Step - 23
			delayWithGivenTime(2000);
			cashandcarry.ClickChangeDiscountOnProductLevel();
			softassert.assertTrue(cashandcarry.verifyChangeDiscountOnProductLevelPopupIsDispalyed());
			
			//Test Step - 24
			cashandcarry.ClickChangeDiscountOnProductLevelYesButton();
			delayWithGivenTime(2000);
			softassert.assertEquals(cashandcarry.getDiscountAmountvalueOrderLevel(),"0.00");
			softassert.assertAll();
			logger.info("**** Ended Hana_T03_UpdateDiscountOrderLevel_CashAndCarryTest  ****");
		} catch (Exception e) {
			e.printStackTrace();
			softassert.fail(e.getMessage());
			softassert.assertAll();
			logger.error("Test case execution failed due to : "+e);
		}
	}
	
}
