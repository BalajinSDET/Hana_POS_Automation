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
import com.hanapos.utilities.CustomSoftAssert;
import com.hanapos.utilities.DataLibrary;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class Hana_T03_UpdateDiscountOrderLevel_FT extends TestBaseClass{

	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private CashAndCarryPage cashandcarry;
	public static final String dataSheetName = "Hana_T03";
	// SoftAssert softassert = new SoftAssert(); - I have modified this to use CustomSoftAssert
	CustomSoftAssert softassert = new CustomSoftAssert();

	@DataProvider(name = "fetch_Excel_Data") 
	public Object[][] fetchData() throws IOException { 
		return DataLibrary.readExcelData(dataSheetName); 
	}
	
	//retryAnalyzer= com.hanapos.utilities.RetryTest.class,
	@Description("This test case is used to Validate the product update discount order level functionality")
	@Severity(SeverityLevel.CRITICAL)
	@Owner("Balaji N")
	@Epic("Cash and Carry Module")
	@Feature("Cash and Carry update Product with Discount functionality at order level")
	@Test(enabled=true,groups= {"Regression"},dataProvider="fetch_Excel_Data") 
	public void  Validate_Hana_T03_Update_DiscountOrder_LevelTest(String searchandselectitemdescription,String itemdiscountpercentage,String couponcode, String discount) throws InterruptedException, IOException, NoSuchElementException {
		
		//Hana-T03  - Update Discount Order Level
		//Test Steps - 1 to 6
		
		logger.info("**** Starting Hana_T03_UpdateDiscountOrderLevel_CashAndCarryTest  ****");
		logger.debug("capturing application debug logs....");
		try {
			lp = new LoginPage();
			softassert.assertTrue(lp.LoginPageIsDisplayed(),"Test Step - 1 : Login page is not displayed");
			Allure.step("User on the hana pos login page");
			
			lp.EnterUserName(prop.getProperty("username"));
			Allure.step("User entered the username as "+prop.getProperty("username"));
			lp.EnterPassword(prop.getProperty("password"));
			Allure.step("User entered the password as "+prop.getProperty("password"));
			lp.ClickLoginButton();
			Allure.step("Clicked on Login button..");

			dashboard = new HanaDashBoardPage();
			Assert.assertTrue(dashboard.VerifyHanaDashBoardPage(),"Test Step - 2 : Hana dashboard Page does not navigated to hana dashboard page");
			Allure.step("User navigated to hana dashboard page sucess..");
			dashboard.SelectShopNameDropDown(prop.getProperty("shopname"));
			Allure.step("User selected the shop name as "+prop.getProperty("shopname")+ "in dashboard page");
			dashboard.CashAndCarryMenuClick();							
			cashandcarry = new CashAndCarryPage();

			Allure.step("User hover the mouse on New order and click on Cash and Carry..");
			Assert.assertTrue(cashandcarry.VerifyCashAndCarryPage(), "Test Step - 3 : Cash And Carry page is not displayed");

			Allure.step("User verify the Cash and Carry page is displayed..");

			cashandcarry.SelectShopName(prop.getProperty("shopname"));
			Allure.step("User selected the shopname on Cash and Carry page as "+prop.getProperty("shopname"));
			cashandcarry.SelectClerkName(prop.getProperty("clerkname"));
			Allure.step("User selected the clerk name on Cash and Carry page as "+prop.getProperty("clerkname"));
			cashandcarry.SelectEmployeeName(prop.getProperty("employeename"));
			Allure.step("User selected the employee name on Cash and Carry page as "+prop.getProperty("employeename"));
			
			//Test Step - 7
			cashandcarry.searchAndselectWithItemDescription(searchandselectitemdescription);
			Allure.step("User selected the item description on Cash and Carry page as "+searchandselectitemdescription);
			
			//Test Step - 8
			cashandcarry.EnterDiscountPercentageOnAddItem(itemdiscountpercentage);
			Allure.step("User entered the discount percentage on Cash and Carry page as "+itemdiscountpercentage);
			
			//Test Step - 9
			cashandcarry.ClickAddItem();
			Allure.step("User clicked on Add item button on Cash and Carry page");	
			softassert.assertTrue(cashandcarry.VerifyAddedItem());
			
			//Test Step - 10	
			softassert.assertFalse(cashandcarry.CouponcodeIsDisabled(),"Test Step - 10 : coupon code is enabled"); 
			Allure.step("User verified the coupon code textbox field is enabled");
			softassert.assertFalse(cashandcarry.DiscountPercentageFieldIsDisabled(), "Test Step - 10 : Discount percentage textbox field is enabled");
			Allure.step("User verified the discount percentage textbox field is enabled");
			softassert.assertFalse(cashandcarry.DiscountAmountFieldIsDisabled(), "Test Step - 10 : Discount amount textbox field is enabled");
			Allure.step("User verified the discount amount textbox field is enabled");
			
			//Test - 11
			softassert.assertTrue(cashandcarry.DiscountChangeLinkIsDisplayed(),"Test Step - 11 : Discount change link is not displayed");
			Allure.step("User verified the discount change link is displayed");
					
			//Test Step - 12
			cashandcarry.ClickChangeLinkOnDiscountPercentageField();
			Allure.step("User clicked on Discount change link on Cash and Carry page");
			
			//Test Step - 13
			softassert.assertTrue(cashandcarry.verifyChangePopUpMessage(),"Test Step - 13 : Change pop up message is not displayed");
			softassert.assertTrue(cashandcarry.VerifyWarningIconIsDisplayed(),"Test Step - 13 : Warning icon is not displayed");
			softassert.assertTrue(cashandcarry.VerifyUpdatingDiscountText(),"Test Step - 13 : update discount text is not displayed");
			softassert.assertTrue(cashandcarry.ChangeDiscountNoButton(),"Test Step - 13 : No button is not displayed");
			softassert.assertTrue(cashandcarry.ChangeDiscountYesButton(),"Test Step - 13 : Yes button is not displayed");
			Allure.step("User verified the change pop up message is displayed");
			Allure.step("User verified the warning icon is displayed");
			Allure.step("User verified the update discount text is displayed");
			Allure.step("User verified the No button is displayed");
			Allure.step("User verified the Yes button is displayed");
			
			//Test Step - 14
			cashandcarry.ClickChangeDiscountNoButton();
			Allure.step("User clicked on No button on Change pop up message");
			
			//Test Step - 15
			cashandcarry.ClickChangeLinkOnDiscountPercentageField();
			Allure.step("User clicked on Discount change link on Cash and Carry page");
			
			//Test Step - 16
			delayWithGivenTime(2000);
			cashandcarry.ClickChangeDiscountYesButton();
			Allure.step("User clicked on Yes button on Change pop up message");
			
			softassert.assertTrue(cashandcarry.CouponcodeIsDisabled(),"Test Step - 16 : coupon code is not enabled"); 
			softassert.assertTrue(cashandcarry.DiscountPercentageFieldIsDisabled(), "Test Step - 16 : Discount percentage textbox field is not enabled");
			softassert.assertTrue(cashandcarry.DiscountAmountFieldIsDisabled(), "Test Step - 16 : Discount amount textbox field is not enabled");
			delayWithGivenTime(2000);
			
			//Test Step - 17
			cashandcarry.searchAndselectWithItemDescription(searchandselectitemdescription);
			Allure.step("User selected the item description on Cash and Carry page as "+searchandselectitemdescription);
			
			//Test Step - 18
			cashandcarry.ClickAddItem();
			Allure.step("User clicked on Add item button on Cash and Carry page");
			
			//Test Step - 19
			delayWithGivenTime(2000);
			cashandcarry.SetCouponCode(couponcode);
			Allure.step("User entered the coupon code on Cash and Carry page as "+couponcode);
			cashandcarry.ClickDiscountDollarField();
			Allure.step("User click on Discount dollar field on Cash and Carry page");
			
			//Test Step - 20
			delayWithGivenTime(2000);
			cashandcarry.EnterDiscount(discount);
			Allure.step("User entered the discount on Cash and Carry page as "+discount);
			delayWithGivenTime(2000);
			cashandcarry.ClickDiscountDollarField();
			Allure.step("User click on Discount dollar field on Cash and Carry page");
			
			//Test Step - 21
			delayWithGivenTime(2000);
			softassert.assertEquals(cashandcarry.getCouponCode(), "","Test Step - 21 - coupon code is not blank");
			Allure.step("User verified the coupon code is blank");
			
			// Test Step - 22
			delayWithGivenTime(2000);
			softassert.assertTrue(cashandcarry.verifyChangeDiscountOnProductLevelIsDispalyed(),"Test Step - 22 - Change discount on product level link is not displayed");
			Allure.step("User verified the Change discount on product level link is displayed");
			
			//Test Step - 23
			delayWithGivenTime(2000);
			cashandcarry.ClickChangeDiscountOnProductLevel();
			Allure.step("User clicked on Change discount on product level link on Cash and Carry page");
			softassert.assertTrue(cashandcarry.verifyChangeDiscountOnProductLevelPopupIsDispalyed(),"Test Step - 23 - Change discount on product level popup is not displayed");
			Allure.step("User verified the Change discount on product level popup is displayed");
			
			//Test Step - 24
			cashandcarry.ClickChangeDiscountOnProductLevelYesButton();
			Allure.step("User clicked on Yes button on Change discount on product level popup");
			delayWithGivenTime(2000);
			softassert.assertEquals(cashandcarry.getDiscountAmountvalueOrderLevel(),"0.00","Test Step - 24 - Discount amount is not 0.00 on order level");
			Allure.step("User verified the discount amount is 0.00 on order level");
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
