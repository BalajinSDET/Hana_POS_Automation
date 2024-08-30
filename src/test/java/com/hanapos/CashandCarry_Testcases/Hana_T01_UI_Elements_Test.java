package com.hanapos.CashandCarry_Testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hanapos.pageObjects.CashAndCarryPage;
import com.hanapos.pageObjects.HanaDashBoardPage;
import com.hanapos.pageObjects.LoginPage;
import com.hanapos.seleniumProjectBase.TestBaseClass;
import com.hanapos.utilities.DataLibrary;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


public class Hana_T01_UI_Elements_Test extends TestBaseClass {
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private CashAndCarryPage cashandcarry;
	public static final String dataSheetName = "TC_002_CashAndCarryTest";
	SoftAssert softassert = new SoftAssert();

	@DataProvider(name = "fetch_Excel_Data") 
	public Object[][] fetchData() throws IOException { 
		return DataLibrary.readExcelData(dataSheetName); 
	}	
	
	/* Validate Cash and Carry UI elements
	 * @description - Hana-T01 - To validate the Cash and Carry UI elements
	*/
	
	@Test(priority=1,groups= {"Regression"}, enabled = true)
	@Description("This test method is to validate the Cash and Carry page UI elements")
	@Severity(SeverityLevel.MINOR)
	@Owner("Balaji N")
	@Epic("Cash and Carry Module")
	@Feature("Cash and Carry UI elements")
	public void Validate_Hana_T01_CashAndCarryPage_UI_ElementsTest() { 
		
		logger.info("**** Starting  Hana-T01_CashAndCarry_UI_ElementsTest  ****");
		logger.debug("capturing application debug logs....");
		try {
			lp = new LoginPage();
			softassert.assertTrue(lp.LoginPageIsDisplayed(),"Login page is not displayed");
			Allure.step("User on the hana pos login page");
			logger.info("User on the hana pos login page");
			
			lp.EnterUserName(prop.getProperty("username"));
			Allure.step("User entered the username as "+prop.getProperty("username"));
			logger.info("User entered the username as "+prop.getProperty("username"));
			lp.EnterPassword(prop.getProperty("password"));
			Allure.step("User entered the password as "+prop.getProperty("password"));
			logger.info("User entered the password as "+prop.getProperty("password"));
			lp.ClickLoginButton();
			Allure.step("User clicked on Login button");
			logger.info("User clicked on Login button");

			dashboard = new HanaDashBoardPage();
			softassert.assertTrue(dashboard.VerifyHanaDashBoardPage(),"Hana dashboard page is not displayed");
			Allure.step("User navigated to hana dashboard page sucessfully");
			logger.info("User navigated to hana dashboard page");
			dashboard.SelectShopNameDropDown(prop.getProperty("shopname"));
			logger.info("User select the shopname on dashbaord page as "+prop.getProperty("shopname"));
			Allure.step("User select the shopname on dashbaord page as "+prop.getProperty("shopname"));
			dashboard.CashAndCarryMenuClick();	
			Allure.step("User hover the mouse on New order and click on Cash and Carry..");
			cashandcarry = new CashAndCarryPage();
			logger.info("User hover the mouse on New order and click on Cash and Carry..");
			softassert.assertTrue(cashandcarry.VerifyCashAndCarryPage(), "Cash And Carry page is not displayed");		
			Allure.step("User verify the Cash and Carry page is displayed..");
			logger.info("User verify the Cash and Carry page is displayed..");			
			softassert.assertTrue(cashandcarry.shopnamedropdownIsDisplayed(),"***Shop Name dropdown field is not displayed***");
			Allure.step("User verify the Shop Name dropdown field is displayed..");
			softassert.assertTrue(cashandcarry.clerkdropdownIsDisplayed(),"***clerk dropdown field is not displayed***");
			Allure.step("User verify the clerk dropdown field is displayed..");
			softassert.assertTrue(cashandcarry.employeedropdownIsDisplayed(),"***employee dropdown field is not displayed***");
			Allure.step("User verify the employee dropdown field is displayed..");
			softassert.assertTrue(cashandcarry.GiftCardAndTilesIsDisplayed(),"***Gift card and tiles is not displayed***");
			softassert.assertTrue(cashandcarry.ItemEntryLabels(),"***Item entry labels are not displayed***");
			softassert.assertEquals(cashandcarry.ItemCodePlaceholder(), "Item Code","***Item code placeholder is not displayed***");
			softassert.assertEquals(cashandcarry.ItemDescription(), "Description","***Item description placeholder is not displayed***");
			softassert.assertEquals(cashandcarry.ItemQtyPlaceholder(), "Qty","***Item quantity placeholder is not displayed***");
			softassert.assertEquals(cashandcarry.ItemPricePlaceholder(), "Price","***Item price placeholder is not displayed***");
			softassert.assertEquals(cashandcarry.ItemDiscountPlaceholder(), "Discount","***Item total placeholder is not displayed***");
			softassert.assertEquals(cashandcarry.ItemDiscountPercentagePlaceholder(), "Discount %","***Item discount placeholder is not displayed***");
			softassert.assertEquals(cashandcarry.CouponCodePlaceHolder(), "Enter Coupon Code","***Coupon code placeholder is not displayed***");
			softassert.assertEquals(cashandcarry.DiscountpercentageTextbox(), "Enter Discount(%)","***Discount percentage placeholder is not displayed***");
			softassert.assertEquals(cashandcarry.DiscountAmountPlaceHolder(), "Enter Discount Amount","***Discount amount placeholder is not displayed***");
			softassert.assertEquals(cashandcarry.TaxTypePlaceholder(), "Tax Type","***Tax type placeholder is not displayed***");
			softassert.assertEquals(cashandcarry.SelectCustomerPlaceholder(), "Select Customer","***Select customer placeholder is not displayed***");
			softassert.assertTrue(cashandcarry.CustomerAddButton(),"***Customer Add button is not displayed***");
			
			softassert.assertTrue(cashandcarry.ReconcileBtnIsDisplayed(),"***Reconcile button is not displayed***");
			softassert.assertTrue(cashandcarry.PayOutBtnIsDisplayed(),"***Payout button is not displayed***");
			softassert.assertTrue(cashandcarry.SalesHistoryIsDisplayed(),"***Sales history button is not displayed***");
			softassert.assertTrue(cashandcarry.OpenDrawerIsDisplayed(),"***Open drawer button is not displayed***");
			
			softassert.assertTrue(cashandcarry.AltPTextIsDisplayed(),"***Alt+P button is not displayed***");
			softassert.assertTrue(cashandcarry.ValidateSplitPaymentToogleButton(),"***Split payment toggle button is not displayed***");
					
			softassert.assertTrue(cashandcarry.ValidateSubTotalLabelPresence(),"***Sub total label is not displayed***");
			softassert.assertEquals(cashandcarry.ValidateSubTotalDefaultValue(), "0.00","***Sub total default value is not displayed***");
			softassert.assertTrue(cashandcarry.ValidateGSTLabel(),"***GST label is not displayed***");
			softassert.assertEquals(cashandcarry.ValidateGSTDefaultValue(), "0.00","***GST default value is not displayed***");
			softassert.assertTrue(cashandcarry.ValidatePSTHSTQSTLabel(),"***PST/HST/QST label is not displayed***");
			softassert.assertEquals(cashandcarry.ValidatePSTHSTQSTDefaultValues(), "0.00","***PST/HST/QST default value is not displayed***");
			softassert.assertTrue(cashandcarry.ValidateTaxLabel(),"***Tax label is not displayed***");
			softassert.assertEquals(cashandcarry.ValidateTaxDefaultValue(), "0.00","***Tax default value is not displayed***");
			softassert.assertTrue(cashandcarry.ValidateDiscountLabel(),"***Discount label is not displayed***");
			softassert.assertEquals(cashandcarry.ValidateDiscountDefaultValues(), "0.00","***Discount default value is not displayed***");
			softassert.assertTrue(cashandcarry.ValidateGrandTotalLabel(),"***Grand total label is not displayed***");
			softassert.assertEquals(cashandcarry.ValidateGrandTotalDefaultValue(), "0.00","***Grand total default value is not displayed***");			
		
			delayWithGivenTime(2000);
			dashboard.ClickOnHomeIcon();
			dashboard = new HanaDashBoardPage();
			softassert.assertTrue(dashboard.VerifyHanaDashBoardPage(),"Hana dashboard page is not displayed");
			logger.info("User navigated to hana dashboard page sucess..");
			dashboard.SelectShopNameDropDown(prop.getProperty("shopname"));
			dashboard.CashAndCarryMenuClick();							
			cashandcarry = new CashAndCarryPage();
			logger.info("User hover the mouse on New order and click on Cash and Carry..");
			softassert.assertTrue(cashandcarry.VerifyCashAndCarryPage(), "Cash And Carry page is not displayed");		
			logger.info("User verify the Cash and Carry page is displayed..");
			
			cashandcarry.ClickChooseDefaultValue();
			softassert.assertTrue(cashandcarry.ValidateChoosePageDefaultValuePopupIsDisplayed());
			cashandcarry.SelectDefaultOccasion();
			cashandcarry.SelectDefaultSalesPerson();
			cashandcarry.SelectDefaultSourcecode();
			cashandcarry.ClickUpdateButtonOnChooseDefaultPopup();
			
			//--Select User--
			if(cashandcarry.GetEmployeeDDfirstOption().equals("--Select User--")){ 
				softassert.assertEquals(cashandcarry.GetEmployeeDDfirstOption(),"--Select User--","default employee is not matched in choose default values popup");
			}else if(cashandcarry.GetEmployeeDDfirstOption().equals("Abish David")){ 
				softassert.assertEquals(cashandcarry.GetEmployeeDDfirstOption(),"Abish David","default employee is not matched in choose default values popup");
			}else {
				softassert.fail("default employee is not matched in choose default values popup");
			}
			
			
			if(cashandcarry.GetOccasionDDfirstOption().equals("--Choose Occasion--")){ 
				softassert.assertEquals(cashandcarry.GetOccasionDDfirstOption(),"--Choose Occasion--","default Occasion is not matched in choose default values popup");
			}else if(cashandcarry.GetOccasionDDfirstOption().equals("Birthday")){ 
				softassert.assertEquals(cashandcarry.GetOccasionDDfirstOption(),"Birthday","default Occasion is not matched in choose default values popup");
			}else {
				softassert.fail("default Occasion is not matched in choose default values popup");
			}
			
			
			softassert.assertEquals(cashandcarry.GetSourceCodeDDfirstOption(),"--Select Source Code--","default sourcecode is not matched in choose default values popup");			
			softassert.assertTrue(cashandcarry.WalkingSettingIconIsExist(),"***Walking setting icon is not displayed in choose default values popup***");
			softassert.assertTrue(cashandcarry.ChooseDefaultValueIconIsExist(),"***Choose default value icon is not displayed in choose default values popup***");
			logger.info("***** Finished Hana-T01_CashAndCarry_UI_ElementsTest *****");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("***** Error in Hana_T01_UI_Test_CashAndCarryTest : " + e);
			softassert.fail("***** Error in Hana_T01_UI_Test_CashAndCarryTest : " + e);
			softassert.assertAll();
		} finally {
			softassert.assertAll();
		}
		
	}

	
}
