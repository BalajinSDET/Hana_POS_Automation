package com.hanapos.testCases;

import java.io.IOException;

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


public class TC_002_CashAndCarryTest extends TestBaseClass{
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private CashAndCarryPage cashandcarry;
	private CashAndCarryPaymentPage cashandcarrypayment;
	private DashboardOrderPage dashboardorder;
	public static final String dataSheetName = "TC_002_CashAndCarryTest";
	SoftAssert softassert = new SoftAssert();

	@DataProvider(name = "fetch_Excel_Data") 
	public Object[][] fetchData() throws IOException { 
		return DataLibrary.readExcelData(dataSheetName); 
	}

	@Test(priority=1,groups= {"Regression","Smoke"},dataProvider="fetch_Excel_Data",enabled=false)	
	public void ValidateCashAndCarryTest(String username, String password, String shopname, String clerk, String employee,
			String itemcode, String description, String qty, String price, String discount, String customershorttext
			,String taxtype, String occasion,String sourcecode ,String exp_res )  {

		logger.info("**** Starting TC_002_CashAndCarryTest  ****");
		logger.debug("capturing application debug logs....");
		lp = new LoginPage();

		logger.info("Entering valid username and password..");
		lp.EnterUserName(username);
		lp.EnterPassword(password);
		lp.ClickLoginButton();
		logger.info("Clicked on Login button..");

		dashboard = new HanaDashBoardPage();
		if(exp_res.equalsIgnoreCase("Valid"))
		{
			if(dashboard.VerifyHanaDashBoardPage()==true)
			{
				Assert.assertTrue(dashboard.VerifyHanaDashBoardPage(),"Page does not navigated to hana dashboard page");
				logger.info("User navigated to hana dashboard page sucess..");
				dashboard.SelectShopNameDropDown("SISTERCHICKS FLOWERS AND MORE LLC");
				dashboard.CashAndCarryMenuClick();							
				cashandcarry = new CashAndCarryPage();
				
				logger.info("User hover the mouse on New order and click on Cash and Carry..");
				Assert.assertTrue(cashandcarry.VerifyCashAndCarryPage(), "Cash And Carry page is not displayed");
				
				logger.info("User verify the Cash and Carry page is displayed..");
				
				cashandcarry.SelectShopName(shopname);
				cashandcarry.SelectClerkName(clerk);
				cashandcarry.SelectEmployeeName(employee);
				
				logger.info("User select the shop name, clerk & employee");
				cashandcarry.EnterItemCode(itemcode);
				cashandcarry.EnterItemDescription(description);
				cashandcarry.EnterItemQuantity(qty);
				cashandcarry.EnterItemPrice(price);
				cashandcarry.EnterItemDiscount(discount);
				cashandcarry.ClickAddItem();
				
				logger.info("User entered product details and click on Add Item button");
				Assert.assertTrue(cashandcarry.VerifyAddedItem());
				cashandcarry.EnterCustomerName(customershorttext);
				cashandcarry.SelectTaxType(taxtype);
				cashandcarry.SelectOccasion(occasion);
				cashandcarry.SelectSourceCode(sourcecode);
				cashandcarry.ClickPayButton();
				
				logger.info("User fillout the customer,tax type & occasion details and click on Pay button");
				cashandcarrypayment = new CashAndCarryPaymentPage();
				Assert.assertTrue(cashandcarrypayment.IsPaymentPageDisplayed(),"Cash And Carry payment page is not displayed");
				
				logger.info("User is on Cash And Carry payment page");
				cashandcarrypayment.ClickCashTab();
				
				logger.info("User select the payment type as cash tab");
				cashandcarrypayment.GetCustomerId();
				cashandcarrypayment.GetCustomerName();
				cashandcarrypayment.ClickProcessPaymentBtn();
				
				logger.info("User click the process payment button");
				Assert.assertTrue(cashandcarrypayment.SuccessToastMsg()); 
				
				logger.info("User verified the order payment done successfully");
				Assert.assertEquals(cashandcarrypayment.getOrderConfirmationToastMsg(),"Order payment done successfully");
				if(cashandcarrypayment.getConfirmationPopup()==true) {
					cashandcarrypayment.VerifyOrderConfirmationPopup();
					cashandcarrypayment.GetOrderConfirmationMsgAndInvoiceNo();		
					cashandcarrypayment.GetInvoiceNumber();
					System.out.println("Order invoice number is :"+cashandcarrypayment.GetInvoiceNumber());				
					cashandcarrypayment.GetTenderPrice();
					System.out.println("The remaining amount given to customer is :"+cashandcarrypayment.GetTenderPrice());
					cashandcarrypayment.ClickOrderConfirmationPopupCloseBtn();
				}				
				dashboard.ClickOrder();
				logger.info("User click the order menu on hana dashboard page");	
				dashboardorder = new DashboardOrderPage();				
				Assert.assertEquals(dashboardorder.validateDashboardOrderPage(),"https://hanafloralpos3.com/Dashboard/Order");				
				logger.info("User verify that the order page is navigated to dashboard order page");
				dashboardorder.ValidateInvoiceNumber();	
				logger.info("User will validate the invoice number");
				logger.info("**** Finished TC_002_CashAndCarryTest  ****");					
			}
			else
			{
				Assert.fail();
			} 
		}

		if(exp_res.equalsIgnoreCase("Invalid"))
		{
			dashboard = new HanaDashBoardPage();
			Assert.assertTrue(dashboard.VerifyHanaDashBoardPage(),"Page does not navigated to hana dashboard page");
			logger.info("User navigated to hana dashboard page sucess..");
			dashboard.SelectShopNameDropDown("SISTERCHICKS FLOWERS AND MORE LLC");
			dashboard.CashAndCarryMenuClick();						
			cashandcarry = new CashAndCarryPage();
			Assert.assertTrue(cashandcarry.VerifyCashAndCarryPage(), "Cash And Carry page is not displayed");		
			cashandcarry.ClickAddItem();
			if(cashandcarry.IsToastErrorMessageDisplayed()==true)
			{
				Assert.assertTrue(true);
			}
			else
			{  
				Assert.fail();
			}
		}
	}
	
	/*
	 * @description - Hana_POS_TC-001 - To verify Cash And Carry page Without Selecting ShopName On DashBoard
	
	*/
	
	@Test(priority=2,enabled=false,groups= {"Regression"},dataProvider="fetch_Excel_Data")
	public void ValidateCashAndCarryWithoutSelectingShopNameOnDashBoardTest(String username, String password, String shopname, String clerk, String employee,
			String itemcode, String description, String qty, String price, String discount, String customershorttext
			,String taxtype, String occasion,String sourcecode ,String exp_res) {
		logger.info("**** Starting TC_002_CashAndCarryTest  ****");
		logger.debug("capturing application debug logs....");
		lp = new LoginPage();

		logger.info("Entering valid username and password..");
		lp.EnterUserName(username);
		lp.EnterPassword(password);
		lp.ClickLoginButton();
		logger.info("Clicked on Login button..");

		dashboard = new HanaDashBoardPage();
		if(exp_res.equalsIgnoreCase("Valid"))
		{
			if(dashboard.VerifyHanaDashBoardPage()==true)
			{
				Assert.assertTrue(dashboard.VerifyHanaDashBoardPage(),"Page does not navigated to hana dashboard page");
				logger.info("User navigated to hana dashboard page sucess..");
				dashboard.CashAndCarryMenuClick();							
				cashandcarry = new CashAndCarryPage();
				
				logger.info("User hover the mouse on New order and click on Cash and Carry..");
				Assert.assertTrue(cashandcarry.VerifyCashAndCarryPage(), "Cash And Carry page is not displayed");
				
				logger.info("User verify the Cash and Carry page is displayed..");
			
				  if(cashandcarry.verifyErrorToastMsg()==true) {
				  cashandcarry.closeErrorToastMsg();
				  }
				 
				cashandcarry.SelectShopName(shopname);
				cashandcarry.SelectClerkName(clerk);
				cashandcarry.SelectEmployeeName(employee);
				
				logger.info("User select the shop name, clerk & employee");
				cashandcarry.EnterItemCode(itemcode);
				cashandcarry.EnterItemDescription(description);
				cashandcarry.EnterItemQuantity(qty);
				cashandcarry.EnterItemPrice(price);
				cashandcarry.EnterItemDiscount(discount);
				cashandcarry.ClickAddItem();
				
				logger.info("User entered product details and click on Add Item button");
				Assert.assertTrue(cashandcarry.VerifyAddedItem());
				cashandcarry.EnterCustomerName(customershorttext);
				cashandcarry.SelectTaxType(taxtype);
				cashandcarry.SelectOccasion(occasion);
				cashandcarry.SelectSourceCode(sourcecode);
				cashandcarry.ClickPayButton();
				
				logger.info("User fillout the customer,tax type & occasion details and click on Pay button");
				cashandcarrypayment = new CashAndCarryPaymentPage();
				Assert.assertTrue(cashandcarrypayment.IsPaymentPageDisplayed(),"Cash And Carry payment page is not displayed");
				
				logger.info("User is on Cash And Carry payment page");
				cashandcarrypayment.ClickCashTab();
				
				logger.info("User select the payment type as cash tab");
				cashandcarrypayment.GetCustomerId();
				cashandcarrypayment.GetCustomerName();
				cashandcarrypayment.ClickProcessPaymentBtn();
				
				logger.info("User click the process payment button");
				Assert.assertTrue(cashandcarrypayment.SuccessToastMsg()); 
				
				logger.info("User verified the order payment done successfully");
				Assert.assertEquals(cashandcarrypayment.getOrderConfirmationToastMsg(),"Order payment done successfully");
				if(cashandcarrypayment.getConfirmationPopup()==true) {
					cashandcarrypayment.VerifyOrderConfirmationPopup();
					cashandcarrypayment.GetOrderConfirmationMsgAndInvoiceNo();
					cashandcarrypayment.GetInvoiceNumber();
					System.out.println("Order invoice number is :"+cashandcarrypayment.GetInvoiceNumber());
					cashandcarrypayment.GetTenderPrice();
					System.out.println("The remaining amount given to customer is :"+cashandcarrypayment.GetTenderPrice());
					cashandcarrypayment.ClickOrderConfirmationPopupCloseBtn();
				}				
				dashboard.ClickOrder();
				logger.info("User click the order menu on hana dashboard page");
				  switchToAlert(); acceptAlert();				 	
				dashboardorder = new DashboardOrderPage();				
				Assert.assertEquals(dashboardorder.validateDashboardOrderPage(),"https://hanafloralpos3.com/Dashboard/Order");				
				logger.info("User verify that the order page is navigated to dashboard order page");
				dashboardorder.ValidateInvoiceNumber();	
			//	Assert.assertEquals(dashboardorder.ValidateInvoiceNumber(),cashandcarrypayment.GetInvoiceNumber(),"invoice number is not matching on displayed order");
				logger.info("User will validate the invoice number");
				logger.info("**** Finished TC_002_CashAndCarryTest  ****");					
			}
			else
			{
				Assert.fail();
			} 
		}

		if(exp_res.equalsIgnoreCase("Invalid"))
		{
			dashboard = new HanaDashBoardPage();
			Assert.assertTrue(dashboard.VerifyHanaDashBoardPage(),"Page does not navigated to hana dashboard page");
			logger.info("User navigated to hana dashboard page sucess..");
			dashboard.CashAndCarryMenuClick();						
			cashandcarry = new CashAndCarryPage();
			Assert.assertTrue(cashandcarry.VerifyCashAndCarryPage(), "Cash And Carry page is not displayed");		
			cashandcarry.ClickAddItem();
			if(cashandcarry.IsToastErrorMessageDisplayed()==true)
			{
				Assert.assertTrue(true);
			}
			else
			{  
				Assert.fail();
			}
		}
		
	}
	
	/*	Test Step - 3. Validate Cash and Carry UI elements
	 * @description - Hana_POS_TC-001 - To validate the Cash and Carry UI elements
	
	*/
	
	@Test(priority=3,groups= {"Regression"}, enabled = false)
	public void ValidateCashAndCarryUIElementTest() { 
		logger.info("**** Starting TC_002_CashAndCarryTest  ****");
		logger.debug("capturing application debug logs....");
		lp = new LoginPage();

		logger.info("Entering valid username and password..");
		lp.EnterUserName(prop.getProperty("username"));
		lp.EnterPassword(prop.getProperty("password"));
		lp.ClickLoginButton();
		logger.info("Clicked on Login button..");

		dashboard = new HanaDashBoardPage();
		softassert.assertTrue(dashboard.VerifyHanaDashBoardPage(),"Page does not navigated to hana dashboard page");
		logger.info("User navigated to hana dashboard page sucess..");
		dashboard.SelectShopNameDropDown("SISTERCHICKS FLOWERS AND MORE LLC");
		dashboard.CashAndCarryMenuClick();							
		cashandcarry = new CashAndCarryPage();
		logger.info("User hover the mouse on New order and click on Cash and Carry..");
		softassert.assertTrue(cashandcarry.VerifyCashAndCarryPage(), "Cash And Carry page is not displayed");		
		logger.info("User verify the Cash and Carry page is displayed..");
		
		softassert.assertTrue(cashandcarry.shopnamedropdownIsDisplayed(),"***Shop Name dropdown field is not displayed***");
		softassert.assertTrue(cashandcarry.clerkdropdownIsDisplayed(),"***clerk dropdown field is not displayed***");
		softassert.assertTrue(cashandcarry.employeedropdownIsDisplayed(),"***employee dropdown field is not displayed***");
		
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
		softassert.assertEquals(cashandcarry.ValidateSubTotalDefaultValue(), "$0.00","***Sub total default value is not displayed***");
		softassert.assertTrue(cashandcarry.ValidateGSTLabel(),"***GST label is not displayed***");
		softassert.assertEquals(cashandcarry.ValidateGSTDefaultValue(), "$0.00","***GST default value is not displayed***");
		softassert.assertTrue(cashandcarry.ValidatePSTHSTQSTLabel(),"***PST/HST/QST label is not displayed***");
		softassert.assertEquals(cashandcarry.ValidatePSTHSTQSTDefaultValues(), "$0.00","***PST/HST/QST default value is not displayed***");
		softassert.assertTrue(cashandcarry.ValidateTaxLabel(),"***Tax label is not displayed***");
		softassert.assertEquals(cashandcarry.ValidateTaxDefaultValue(), "$0.00","***Tax default value is not displayed***");
		softassert.assertTrue(cashandcarry.ValidateDiscountLabel(),"***Discount label is not displayed***");
		softassert.assertEquals(cashandcarry.ValidateDiscountDefaultValues(), "$0.00","***Discount default value is not displayed***");
		softassert.assertTrue(cashandcarry.ValidateGrandTotalLabel(),"***Grand total label is not displayed***");
		softassert.assertEquals(cashandcarry.ValidateGrandTotalDefaultValue(), "$0.00","***Grand total default value is not displayed***");
		
		softassert.assertAll();		
	}
	
	/*	Testcase Id - Hana-POS-TC-001
	 * 	Test Step - 4, 5 . Validate Choose Default Values Functionality
	
	*/
	@Test(priority=5,enabled=true,groups= {"Regression"})
	public void ValidateChooseDefaultValuesFunctionality() {
		logger.info("**** Starting TC_002_CashAndCarryTest  ****");
		logger.debug("capturing application debug logs....");
		lp = new LoginPage();

		logger.info("Entering valid username and password..");
		lp.EnterUserName(prop.getProperty("username"));
		lp.EnterPassword(prop.getProperty("password"));
		lp.ClickLoginButton();
		logger.info("Clicked on Login button..");

		dashboard = new HanaDashBoardPage();
		softassert.assertTrue(dashboard.VerifyHanaDashBoardPage(),"Page does not navigated to hana dashboard page");
		logger.info("User navigated to hana dashboard page sucess..");
		dashboard.SelectShopNameDropDown("SISTERCHICKS FLOWERS AND MORE LLC");
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
		
		softassert.assertEquals(cashandcarry.GetEmployeeDDfirstOption(),"--Select User--","default employee is not matched");
		softassert.assertEquals(cashandcarry.GetOccasionDDfirstOption(),"--Choose Occasion--","default Occasion is not matched");
		softassert.assertEquals(cashandcarry.GetSourceCodeDDfirstOption(),"--Select Source Code--","default sourcecode is not matched");
			
		softassert.assertTrue(cashandcarry.WalkingSettingIconIsExist(),"***Walking setting icon is not displayed***");
		softassert.assertTrue(cashandcarry.ChooseDefaultValueIconIsExist(),"***Choose default value icon is not displayed***");
		
		softassert.assertAll();
	}
	
}
