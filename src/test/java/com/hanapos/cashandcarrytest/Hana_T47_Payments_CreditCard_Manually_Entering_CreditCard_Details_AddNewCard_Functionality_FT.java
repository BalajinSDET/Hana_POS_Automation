package com.hanapos.cashandcarrytest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.hanapos.pageObjects.CashAndCarryPage;
import com.hanapos.pageObjects.CashAndCarryPaymentPage;
import com.hanapos.pageObjects.CustomerPage;
import com.hanapos.pageObjects.DashboardOrderPage;
import com.hanapos.pageObjects.HanaDashBoardPage;
import com.hanapos.pageObjects.LoginPage;
import com.hanapos.seleniumProjectBase.TestBaseClass;
import com.hanapos.utilities.DataLibrary;

public class Hana_T47_Payments_CreditCard_Manually_Entering_CreditCard_Details_AddNewCard_Functionality_FT extends TestBaseClass{
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private CashAndCarryPage cashandcarry;
	private CashAndCarryPaymentPage cashandcarrypayment;
	public static final String dataSheetName = "Hana_T47";
	SoftAssert softassert = new SoftAssert();

	@DataProvider(name = "fetch_Excel_Data") 
	public Object[][] fetchData() throws IOException { 
		return DataLibrary.readExcelData(dataSheetName); 
	}

	/*
	 * HANA-T47 - 1 to 21 - Verify Payments_CreditCard_Manually_Entering_CreditCard_Details_AddNewCard_Functionality
	 */
	//retryAnalyzer= com.hanapos.utilities.RetryTest.class,

	@Test(enabled=true,groups= {"Regression"},dataProvider="fetch_Excel_Data") 
	public void  Validate_Hana_T47_Payments_CreditCard_Manually_Entering_CreditCard_Details_AddNewCard_Test(String searchandselectitemcode, String customername, String occasion, String ccfname,String cclname, String creditcardtype, String cccardnumber, String ccexpiredate,String cccvv, String cczipcode) throws InterruptedException, IOException {
		// Test Step - 1
		logger.info("**** Starting Hana_T47_Payments_CreditCard_Manually_Entering_CreditCard_Details_AddNewCard_Functionality_CashAndCarryTest  ****");
		try {
			lp = new LoginPage();
			softassert.assertTrue(lp.LoginPageIsDisplayed(),"Login page is not displayed");
			logger.info("User on the hana pos login page");
			
			// Test Step - 2
			lp.EnterUserName(prop.getProperty("username"));
			logger.info("User entered username as "+prop.getProperty("username"));
			lp.EnterPassword(prop.getProperty("password"));
			logger.info("User entered username as "+prop.getProperty("password"));
			lp.ClickLoginButton();
			logger.info("User clicked on Login button..");

			dashboard = new HanaDashBoardPage();
			Assert.assertTrue(dashboard.VerifyHanaDashBoardPage(),"Page does not navigated to hana dashboard page");
			logger.info("User navigated to hana dashboard page sucess..");
			
			// Test Step - 3
			dashboard.SelectShopNameDropDown(prop.getProperty("shopname"));
			logger.info("User selected the shop name as "+prop.getProperty("shopname")+ "in dashboard page");
			dashboard.CashAndCarryMenuClick();							
			cashandcarry = new CashAndCarryPage();
			logger.info("User hover the mouse on New order and click on Cash and Carry..");
			softassert.assertTrue(cashandcarry.VerifyCashAndCarryPage(), "Cash And Carry page is not displayed");
			logger.info("User verify the Cash and Carry page is displayed..");
			
			// Test Step - 4
			cashandcarry.SelectShopName(prop.getProperty("shopname")); //"Hana POS (Canada)"
			logger.info("User select the shop name as "+prop.getProperty("shopname")+ "in cash and carry page");
			
			//Test Step - 5
			cashandcarry.SelectClerkName(prop.getProperty("clerkname")); //"Automation clerk desc"
			logger.info("User select the clerk name as "+prop.getProperty("clerkname"));
			
			// Test Step - 6
			cashandcarry.SelectEmployeeName(prop.getProperty("employeename")); //"QA Team Automation"
			logger.info("User select the employee name as "+prop.getProperty("employeename"));

			// Test Step - 7
			softassert.assertTrue(cashandcarry.IsPayButtonDisabled(),"Pay button is not disabled");
			cashandcarry.SearchAndSelectTheItemCode(searchandselectitemcode);
			softassert.assertEquals(cashandcarry.ItemDescriptionValueIsExist(), "Red Rose Deluxe");	
			softassert.assertEquals(cashandcarry.ItemQtyValueIsExist(), "1");
			softassert.assertEquals(cashandcarry.ItemPriceValueIsExist(), "309");
			softassert.assertEquals(cashandcarry.ItemDiscountAmountIsExist(),"0");
			softassert.assertEquals(cashandcarry.ItemDiscountPercentageValueIsExist(), "0");

			// Test Step - 8
			cashandcarry.ClickAddItem();
			softassert.assertTrue(cashandcarry.VerifyAddedItem());
			softassert.assertEquals(cashandcarry.getAddedItemCode(),"rrd");
			softassert.assertEquals(cashandcarry.GetAddedItemDescription(),"Red Rose Deluxe");
			softassert.assertEquals(cashandcarry.GetAddedItemQty(), "1");
			softassert.assertEquals(cashandcarry.GetAddedItemExtPrice(), "$309.00");
			softassert.assertEquals(cashandcarry.GetAddedItemPrice(), "$309.00");
			softassert.assertEquals(cashandcarry.GetAddedItemDiscountAmount(), "$ 0.00");
			softassert.assertEquals(cashandcarry.GetAddedItemDiscountPercentage(),"0.00");
			
			// Test Step - 9
			delayWithGivenTime(2000);
			cashandcarry.ClickParticularProdTitle();
			logger.info("User click on the particular product tile");
			softassert.assertEquals(cashandcarry.getAddedItemCodeRow2(),"ballonsYY");
			logger.info("User verify add the title product to the Cash and Carry page is displayed..");		
			
			// Test Step - 10
			cashandcarry.EnterCustomerName(customername);
			logger.info("User search and select the created customer ");
			cashandcarry.SelectTaxType("Tax Exemption");
			cashandcarry.SelectOccasion(occasion);
			logger.info("User select the occasion as Birthday");
			delayWithGivenTime(1000);
			cashandcarry.ClickPayButton();
			logger.info("User click on Pay button");
			delayWithGivenTime(2000);
			cashandcarrypayment = new CashAndCarryPaymentPage();
			softassert.assertTrue(cashandcarrypayment.IsPaymentPageDisplayed(),"Cash And Carry payment page is not displayed");
			logger.info("User navigated to Cash And Carry payment page successfully");
			
			// Test Step - 11	
			delayWithGivenTime(2000);
			softassert.assertEquals(cashandcarrypayment.VerifyCreditCardTabIsSelected(),"true", "By defaultCredit card tab section is not displayed");
			
			// Test Step - 12				
			delayWithGivenTime(2000);
			cashandcarrypayment.ClickCreditCardTab();
			if(cashandcarrypayment.VerifyCreditCardPresentToogleBtnIsAppear()==true) {
				cashandcarrypayment.ClickCreditCardPresentToogleBtn();
				softassert.assertTrue(cashandcarrypayment.VerifyCreditCardPresentToogleBtnIsSelected(),"Test Step - 12 : Credit card is present toogle button is not turn on");
			}else {
					softassert.fail("***Credit card present toogle button is not displayed***");
				}
			
			if(cashandcarrypayment.VerifyCreditCardFirstNameIsDisabled()==true) {
			softassert.assertTrue(cashandcarrypayment.VerifyCreditCardFirstNameIsDisabled(),"Credit card first name field is not disabled");
			softassert.assertTrue(cashandcarrypayment.VerifyCreditCardLastNameIsDisabled(),"Credit card last name field is not disabled");
			softassert.assertTrue(cashandcarrypayment.VerifySelectCreditCardTypeIsDisabled(),"Credit card selected card type is not disabled");
			softassert.assertTrue(cashandcarrypayment.VerifyEnterCreditCardNumberIsDisabled(),"Credit card number field is not disabled");
			softassert.assertTrue(cashandcarrypayment.VerifyEnterCreditCardExpireDateIsDisabled(),"Credit card expire date is not disabled");
			softassert.assertTrue(cashandcarrypayment.VerifyEnterCreditCardCVVIsDisabled(),"Credit card cvv field is not disabled");
			softassert.assertTrue(cashandcarrypayment.VerifyEnterCreditCardZipCodeIsDisabled(),"Credit card zipcode field is not disabled");
			}else {
				softassert.fail("Test Step - 12 : Credit card tab all the fields are not disabled");
			}
			
			// Test Step - 13 
			cashandcarrypayment.ClickCreditCardPresentToogleBtn();
			
			// Test Step - 14
			cashandcarrypayment.EnterFirstNameOnCreditCardTab(ccfname);
			delayWithGivenTime(1000);
			softassert.assertEquals(cashandcarrypayment.getEnteredCreditCardFirstName(),"Automation","First name is not displayed");
			
			// Test Step - 15
			cashandcarrypayment.EnterLastNameOnCreditCardTab(cclname);
			delayWithGivenTime(1000);
			softassert.assertEquals(cashandcarrypayment.getEnteredCreditCardLastName(),"Test","Last name is not displayed");
			
			// Test Step - 16
			cashandcarrypayment.SelectCreditCardTypeOnCreditCardTab(creditcardtype);
			
			// Test Step - 17	
			cashandcarrypayment.EnterCreditCardNumberOnCreditCardTab(cccardnumber);
			delayWithGivenTime(1000);
			softassert.assertEquals(cashandcarrypayment.getEnterCreditCardNumber(),"378282246310005","credit card number entered data is not displayed");
			
			// Test Step - 18
			cashandcarrypayment.EnterCreditCardExpireDateOnCreditCardTab(ccexpiredate);
			delayWithGivenTime(1000);
			softassert.assertEquals(cashandcarrypayment.getEnterCreditCardExpireDate(),"0628","credit card expire date entered data is not displayed");	
			
			// Test Step - 19
			cashandcarrypayment.EnterCreditCardCVVOnCreditCardTab(cccvv);
			delayWithGivenTime(1000);
			softassert.assertEquals(cashandcarrypayment.getEnterCreditCardCVV(),"567","credit card cvv entered data is not displayed");
			
			// Test Step - 20
			cashandcarrypayment.EnterCreditCardZipCodeOnCreditCardTab(cczipcode);
			delayWithGivenTime(1000);
			softassert.assertEquals(cashandcarrypayment.getEnterCreditCardZipCode(),"32012","credit card zipcode entered data is not displayed");
			
			// Test Step - 21
			delayWithGivenTime(3000);
			softassert.assertTrue(cashandcarrypayment.VerifyProcessPaymentButton(),"Process payment button is not displayed");
			delayWithGivenTime(3000);
			cashandcarrypayment.ClickProcessPaymentBtn();
			softassert.assertTrue(cashandcarrypayment.VerifyErrorToastMsg(),"Error toast message is not displayed");
			logger.info("Order payment done success message is cannot able to test on live environment");
			delayWithGivenTime(2000);
					
			softassert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
			logger.error(e.getMessage());
		}
	}
}
