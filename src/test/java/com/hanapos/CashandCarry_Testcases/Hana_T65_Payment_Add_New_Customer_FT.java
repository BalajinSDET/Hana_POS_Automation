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
import com.hanapos.pageObjects.CustomerPage;
import com.hanapos.pageObjects.DashboardOrderPage;
import com.hanapos.pageObjects.HanaDashBoardPage;
import com.hanapos.pageObjects.LoginPage;
import com.hanapos.seleniumProjectBase.TestBaseClass;
import com.hanapos.utilities.DataLibrary;

public class Hana_T65_Payment_Add_New_Customer_FT extends TestBaseClass{
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private CashAndCarryPage cashandcarry;
	private CashAndCarryPaymentPage cashandcarrypayment;
	private DashboardOrderPage dashboardorder;
	private CustomerPage customerpage;
	public static final String dataSheetName = "Hana_T65";
	SoftAssert softassert = new SoftAssert();
	String invoice;
	String custId;
	String newlycreatedcustomername;
	public static ExecutorService executorService;
	private static final int THREAD_POOL_SIZE = 2;

	@DataProvider(name = "fetch_Excel_Data") 
	public Object[][] fetchData() throws IOException { 
		return DataLibrary.readExcelData(dataSheetName); 
	}

	/*
	 * HANA-T65 - 1 to 34 - Verify Payment_Add_New_Customer_Functionality
	 */
	//retryAnalyzer= com.hanapos.utilities.RetryTest.class,

	@Test(enabled=true,groups= {"Smoke","Regression"},dataProvider="fetch_Excel_Data") 
	public void  Validate_Hana_T65_Payments_Add_New_Customer_Test(String searchandselectitemcode, String custfirstname, String custlastname,String custphonenumber, String custsplfname, String custspllname, String custsplphonenumber, String custsplaltphnumber,
			String custalphaphnumber, String custalphaltphnumber, String custphnumber1, String custphnumber2, String companyname, String custphonenumber1,String custaltphonenumber, String address1, String address2, String zipcode, String city, 
			String state, String country,String emailid, String custtype, String custcredit, String customername, String occasion ) throws InterruptedException, IOException {
		// Test Step - 1
		logger.info("**** Starting Hana_T65_Payment_Add_New_Customer_CashAndCarryTest  ****");
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
			delayWithGivenTime(2000);
			dashboard = new HanaDashBoardPage();
			Assert.assertTrue(dashboard.VerifyHanaDashBoardPage(),"Page does not navigated to hana dashboard page");
			logger.info("User navigated to hana dashboard page sucess..");
			
			// Test Step - 3
			dashboard.SelectShopNameDropDown(prop.getProperty("shopname"));
			logger.info("User selected the shop name as "+prop.getProperty("shopname")+ "in dashboard page");
			delayWithGivenTime(2000);
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
			cashandcarry.SearchAndSelectTheItemCode(searchandselectitemcode);
			softassert.assertEquals(cashandcarry.ItemDescriptionValueIsExist(), "Red Rose Deluxe","Test Step - 7 - Item description is not matched with search and selected item code");	
			softassert.assertEquals(cashandcarry.ItemQtyValueIsExist(), "1");
			
			if(cashandcarry.ItemPriceValueIsExist()=="299") {
				softassert.assertEquals(cashandcarry.ItemPriceValueIsExist(), "299","Item price is not matched with search and selected item code");
			}else if(cashandcarry.ItemPriceValueIsExist()=="309") {
				softassert.assertEquals(cashandcarry.ItemPriceValueIsExist(), "309","Item price is not matched with search and selected item code");
			}
			
			softassert.assertEquals(cashandcarry.ItemDiscountAmountIsExist(),"0");
			softassert.assertEquals(cashandcarry.ItemDiscountPercentageValueIsExist(), "0");

			// Test Step - 8
			cashandcarry.ClickAddItem();
			softassert.assertTrue(cashandcarry.VerifyAddedItem());
			softassert.assertEquals(cashandcarry.getAddedItemCode(),"rrd","Test Step - 8 - Added item code is not matched displayed in product table grid");
			softassert.assertEquals(cashandcarry.GetAddedItemDescription(),"Red Rose Deluxe","Test Step - 8 - Added item description is not matched displayed in product table grid");
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
			
			// Test Step - 9
			delayWithGivenTime(2000);
			cashandcarry.ClickParticularProdTitle();
			logger.info("User click on the particular product tile");
			softassert.assertEquals(cashandcarry.getAddedItemCodeRow2(),"ballonsYY","Test Step - 9 - Selected product item tile is not displayed in product table grid");
			logger.info("User verify add the title product to the Cash and Carry page is displayed..");		
			
			// Test Step - 10	
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
			cashandcarrypayment.ClickAddNewCustButtonOnCCP();
			delayWithGivenTime(1000);
			softassert.assertTrue(cashandcarrypayment.VerifyAddNewCustPopupIsDisplayed(),"Add new customer popup is not displayed");
			
			// Test Step - 12
			cashandcarrypayment.EnterAddNewCustFirstName(custfirstname);
			logger.info("User entered the first name as "+custfirstname);
			cashandcarrypayment.EnterAddNewCustLastName(custlastname);
			logger.info("User entered the last name as "+custlastname);
			cashandcarrypayment.EnterAddNewCustPhoneNumber(custphonenumber);
			logger.info("User entered the phone number as "+custphonenumber);
			
			softassert.assertEquals(cashandcarrypayment.getEnteredaddnewcustfirstname(), "Test","Test Step - 12 - Entered value is added on first name field");
			logger.info("User verify that entered value on first name field is present");
			softassert.assertEquals(cashandcarrypayment.getEnteredaddnewcustlastname(), "Automation","Test Step - 12 - Entered value is added on last name field");
			logger.info("User verify that entered value on last name field is present");
			softassert.assertEquals(cashandcarrypayment.getEnteredaddnewcustphonenumber(), "990-077-8866","Test Step - 12 - Entered value is added on phone number field");
			logger.info("User verify that entered value on phone number field is present");
			
			// Test Step - 13
			cashandcarrypayment.ClickAddNewCustPopupCloseIcon();
			softassert.assertEquals(cashandcarrypayment.getSearchandselectCustDisplayedData(), "");	;
			
			// Test Step - 14		
			delayWithGivenTime(2000);
			softassert.assertEquals(cashandcarrypayment.VerifyCreditCardTabIsSelected(),"true", "By defaultCredit card tab section is not displayed");
			cashandcarrypayment.ClickAddNewCustButtonOnCCP();
			delayWithGivenTime(1000);
			softassert.assertTrue(cashandcarrypayment.VerifyAddNewCustPopupIsDisplayed(),"Add new customer popup is not displayed");
			
			// Test Step - 15		
			cashandcarrypayment.EnterAddNewCustFirstName(custsplfname);
			logger.info("User entered the first name as "+ custsplfname);
			cashandcarrypayment.EnterAddNewCustLastName(custspllname);
			logger.info("User entered the last name as "+ custspllname);
			cashandcarrypayment.EnterAddNewCustPhoneNumber(custsplphonenumber);
			logger.info("User entered the phone number as "+ custsplphonenumber);
			cashandcarrypayment.EnterAddNewCustAltPhoneNumber(custsplaltphnumber);
			logger.info("User entered the alternate phone number as "+ custsplaltphnumber);
			
			softassert.assertEquals(cashandcarrypayment.getEnteredaddnewcustfirstname(), "","special character is added on first name field");
			logger.info("User verify the special character is not accepted on first name field ");
			softassert.assertEquals(cashandcarrypayment.getEnteredaddnewcustlastname(), "","special character is added on last name field");
			logger.info("User verify the special character is not accepted on last name field ");
			softassert.assertEquals(cashandcarrypayment.getEnteredaddnewcustphonenumber(), "","special character is added on phone number field");
			logger.info("User verify the special character is not accepted on phone number field ");
			softassert.assertEquals(cashandcarrypayment.getEnteredaddnewcustaltphonenumber(), "","special character is added on alternative phone number field");
			logger.info("User verify the special character is not accepted on alternative phone number field ");
			
			// Test Step - 16
			cashandcarrypayment.EnterAddNewCustPhoneNumber(custalphaphnumber);
			logger.info("User entered the phone number as "+ custalphaphnumber);
			cashandcarrypayment.EnterAddNewCustAltPhoneNumber(custalphaltphnumber);
			logger.info("User entered the alternate phone number as "+ custalphaltphnumber);
			
			softassert.assertEquals(cashandcarrypayment.getEnteredaddnewcustphonenumber(), "","alphabetic character is added on phone number field");
			logger.info("User verify the alphabetic character is not accepted on phone number field ");
			softassert.assertEquals(cashandcarrypayment.getEnteredaddnewcustaltphonenumber(), "","alphabetic character is added on alternative phone number field");
			logger.info("User verify the alphabetic character is not accepted on alternative phone number field ");

			// Test Step - 17
			cashandcarrypayment.EnterAddNewCustPhoneNumber(custphnumber1);
			logger.info("User entered the phone number as "+ custphnumber1);
			cashandcarrypayment.EnterAddNewCustAltPhoneNumber(custphnumber2);
			logger.info("User entered the alternate phone number as "+ custphnumber2);
			
			softassert.assertEquals(cashandcarrypayment.getEnteredaddnewcustphonenumber(), "+99-123-456-7890","Test Step - 17 - enter more than 12 character is added on phone number field");
			logger.info("User verify the alphabetic character is not accepted on phone number field ");
			softassert.assertEquals(cashandcarrypayment.getEnteredaddnewcustaltphonenumber(), "+99-123-456-7890","Test Step - 17 - enter more than 12 character is added on alternative phone number field");
			logger.info("User verify the alphabetic character is not accepted on alternative phone number field ");

			// Test Step - 18
			cashandcarrypayment.SelectShopNameOnAddNewCustPopup(prop.getProperty("shopname"));
			logger.info("User select the shop name on add new customer popup ");
			cashandcarrypayment.EnterCompanyNameOnAddnewCustPopup(companyname);
			logger.info("User entered the company name as "+companyname);
			cashandcarrypayment.EnterAddNewCustFirstName(custfirstname);
			logger.info("User entered the first name as "+ custfirstname);
			cashandcarrypayment.EnterAddNewCustLastName(custlastname);
			logger.info("User entered the last name as "+ custlastname);
			cashandcarrypayment.EnterAddNewCustPhoneNumber(custphonenumber1);
			logger.info("User entered the phone number as "+ custphonenumber1);
			cashandcarrypayment.EnterAddNewCustAltPhoneNumber(custaltphonenumber);
			logger.info("User entered the alternate phone number as "+ custaltphonenumber);	
			cashandcarrypayment.EnterAddress1OnAddnewCustPopup(address1);
			logger.info("User entered the address 1 as "+address1);
			cashandcarrypayment.EnterAddress2OnAddnewCustPopup(address2);
			logger.info("User entered the address 2 as "+address2);
			cashandcarrypayment.EnterZipCodeOnAddnewCustPopup(zipcode);
			logger.info("User entered the zipcode as "+zipcode);
			cashandcarrypayment.EnterCityOnAddnewCustPopup(city);
			logger.info("User entered the city as "+city);
			cashandcarrypayment.EnterStateOnAddnewCustPopup(state);
			logger.info("User selected the state as "+state);
			cashandcarrypayment.EnterCountryOnAddnewCustPopup(country);
			logger.info("User entered the country as "+country);
			cashandcarrypayment.EnterEmailOnAddnewCustPopup(emailid);
			logger.info("User entered the email id as "+emailid);
			cashandcarrypayment.SelectCustTypeOnAddNewCustPopup(custtype);
			logger.info("User selected the customer type as "+custtype);
			cashandcarrypayment.EnterCustCreditOnAddNewCustPopup(custcredit);
			logger.info("User entered the customer credit as "+custcredit);
			ThreadWait(1000);
			softassert.assertEquals(cashandcarrypayment.getSelectedShopNameOnAddNewCustPopup(), prop.getProperty("shopname"));
			logger.info("User verified that selected shopname selected data is displayed on add new customer popup");
			softassert.assertEquals(cashandcarrypayment.getEnteredaddnewcustcompanyname(), "Test Automation pvt ltd","Test Step - 18 - Added on company name field are not properly displayed");
			logger.info("User verified that entered company name entered data is displayed on add new customer popup");
			softassert.assertEquals(cashandcarrypayment.getEnteredaddnewcustfirstname(), "Test","Test Step - 18 - Added on first name field are not properly displayed");
			logger.info("User verify the first name field entered data is displayed");
			softassert.assertEquals(cashandcarrypayment.getEnteredaddnewcustlastname(), "Automation","Test Step - 18 - Added on first name field are not properly displayed");
			logger.info("User verify the last name field entered data is displayed");
			softassert.assertEquals(cashandcarrypayment.getEnteredaddnewcustphonenumber(), "919-293-9495","Test Step - 18 - Added on phone number field are not properly displayed");
			logger.info("User verify the phone number field entered data is displayed");
			softassert.assertEquals(cashandcarrypayment.getEnteredaddnewcustaltphonenumber(), "919-293-9896","Test Step - 18 - Added on alternative phone number field are not properly displayed");
			logger.info("User verify the alternative phone number field entered data is displayed");
			softassert.assertEquals(cashandcarrypayment.getEnteredaddnewcustaddress1(),"Test Automation Address, India","Test Step - 18 - Added address 1 field is not properly displayed");
			logger.info("User verify that address 1 field entered data is displayed");
			softassert.assertEquals(cashandcarrypayment.getEnteredaddnewcustaddress2(), "QA Test Automation, Cbe, Tn, India","Test Step - 18 - Added address 2 field is not properly displayed");
			logger.info("User verify that address 2 field entered data is displayed");
			softassert.assertEquals(cashandcarrypayment.getEnteredaddnewcustzipcode(), "641004","Test Step - 18 - Added zip code is not displayed");
			logger.info("User verify that zipcode field entered data is displayed");
			softassert.assertEquals(cashandcarrypayment.getEnteredaddnewcustcity(), "Coimbatore","Test Step - 18 - Added city field is not displayed");
			logger.info("User verify that city field entered data is displayed");
			softassert.assertEquals(cashandcarrypayment.getEnteredaddnewcuststate(), "Tamilnadu","Test Step - 18 - Added state field is not displayed");
			logger.info("User verify that state field entered data is displayed");
			softassert.assertEquals(cashandcarrypayment.getEnteredaddnewcustcountry(), "India","Test Step - 18 - Added country field is not displayed");
			logger.info("User verify that country field entered data is displayed");
			softassert.assertEquals(cashandcarrypayment.getEnteredaddnewcustemail(), "hanaposqateam@gmail.com","Test Step - 18 - Added email id field is not displayed");
			logger.info("User verify that email id field entered data is displayed");
			softassert.assertEquals(cashandcarrypayment.getSelectedCustTypeOnAddNewCustPopup(), "Corporate","Test Step - 18 - Added customer type dropdown field is not displayed");
			logger.info("User verify that customer type dropdown field selected data is displayed");
			softassert.assertEquals(cashandcarrypayment.getEnteredaddnewcustcredit(), "0","Test Step - 18 - Added customer type dropdown field is not displayed");
			logger.info("User verify that customer type dropdown field selected data is displayed");

			// Test Step - 19
			softassert.assertTrue(cashandcarrypayment.ValidateCreditApprovedToogleOnAddNewCustPopup(),"Credit approved toogle is enabled");
			logger.info("User verify that credit approved toogle is disabled");
			softassert.assertTrue(cashandcarrypayment.ValidatePaperlessStatementToogleOnAddNewCustPopup(),"paperless statement toogle is enabled");
			logger.info("User verify that paperless statement toogle is disabled");
			softassert.assertTrue(cashandcarrypayment.ValidateEmailStatementToogleOnAddNewCustPopup(),"Email statement toogle is enabled");
			logger.info("User verify that email statement toogle is disabled");
			softassert.assertTrue(cashandcarrypayment.ValidateEnableLoyaltyToogleOnAddNewCustPopup(),"Enable loyalty toogle is enabled");
			logger.info("User verify that enable loyalty toogle is disabled");
			softassert.assertTrue(cashandcarrypayment.ValidateLateFeeSettingToogleOnAddNewCustPopup(),"Late Fee Setting toogle is enabled");
			logger.info("User verify that enable loyalty toogle is disabled");
			softassert.assertTrue(cashandcarrypayment.ValidateAllowSMSTToogleOnAddNewCustPopup(),"Allow SMS toogle is enabled");
			logger.info("User verify that allow sms toogle is disabled");
			softassert.assertTrue(cashandcarrypayment.ValidateAllowFeedbackEmailTToogleOnAddNewCustPopup(),"Allow feedback email toogle is not enabled");
			logger.info("User verify that allow feedback email toogle is enabled");
			
			// Test Step - 20
			cashandcarrypayment.ClickAddNewCustPopupAddNewCustBtn();
			logger.info("User click on the add new customer button");
			softassert.assertTrue(cashandcarrypayment.SuccessToastMsg(),"Success toast message is not displayed after creating customer");
			logger.info("User verified success toast message is displayed ");
			softassert.assertEquals(cashandcarrypayment.getDisplayedCustomerNameOnCCPage(),"Test Automation","Customer name is not displayed");		
			logger.info("User verified created customer name is displayed on cash and carry page");
			custId=cashandcarrypayment.getCustomerIdDisplayed();
			newlycreatedcustomername=cashandcarrypayment.getDisplayedCustomerNameOnCCPage();
			
			// Test Step - 21		
			delayWithGivenTime(2000);
			softassert.assertEquals(cashandcarrypayment.getDisplayedCustomerNameOnCCPage(),"Test Automation","Test Step - 21 - Customer name is displayed");		
			cashandcarrypayment.ClickCrossIconOnAddNewCust();
			logger.info("User clicks on the cancel customer icon");
			softassert.assertEquals(cashandcarrypayment.getSearchandselectCustDisplayedData(), "","Test Step - 21 - Selected customer cleared by close icon is not working"); ;
		 
		  	//Test Step - 22
		  	cashandcarrypayment.EnterCustomerName(custId);
		 
			// Test Step - 23
			delayWithGivenTime(2000);
			softassert.assertTrue(cashandcarrypayment.Verify_CustomerName_AppearsOnCCPage(),"Test Step - 23 - Customer name is not displayed");
			logger.info("User verified the created customer name is displayed on cash and carry page");
			softassert.assertTrue(cashandcarrypayment.Verify_CustomerIdAppears_OnCCPage(),"Test Step - 23 - Customer id is not displayed");
			logger.info("User verified the created customer id is displayed on cash and carry page");
			
			// Test Step - 24
			delayWithGivenTime(1000);
			cashandcarrypayment.ClickCashTab();
			logger.info("User select the payment type as cash tab");
			cashandcarrypayment.EnterGivenAmount();
			delayWithGivenTime(1000);
			cashandcarrypayment.ClickProcessPaymentBtn();
			delayWithGivenTime(2000);
			softassert.assertTrue(cashandcarrypayment.SuccessToastMsg()); 		
			logger.info("User verified the order payment done successfully");
			softassert.assertEquals(cashandcarrypayment.getOrderConfirmationToastMsg(),"Order payment done successfully","Test Step - 24 - Order confirmation toast message text is not matched");
			delayWithGivenTime(2000);
		//	softassert.assertEquals(cashandcarrypayment.getOrderConfirmationToastMsg(),"New Customer added successfully","Test Step - 24 - New Customer added successfully toast message text is not matched");
		
			delayWithGivenTime(1000);
			if(cashandcarrypayment.getConfirmationPopup()==true) {
				cashandcarrypayment.VerifyOrderConfirmationPopup();
				logger.info("User verify the order confirmation popup is displayed");
				cashandcarrypayment.GetOrderConfirmationMsgAndInvoiceNo();	
				logger.info("User verify the order confirmation message and invoice number is displayed");
				invoice = cashandcarrypayment.GetInvoiceNumber();
				logger.info(("Generated Order invoice number is :"+cashandcarrypayment.GetInvoiceNumber()));
				System.out.println("Order invoice number is :"+cashandcarrypayment.GetInvoiceNumber());				
				cashandcarrypayment.GetTenderPrice();
				logger.info(("The remaining amount given to customer is :"+cashandcarrypayment.GetTenderPrice()));
				System.out.println("The remaining amount given to customer is :"+cashandcarrypayment.GetTenderPrice());			
			}	
	
			logger.info("User click the cancel button on webclientprint window popup");
			delayWithGivenTime(1000);
			cashandcarrypayment.ClickOrderConfirmationPopupCloseBtn();
			logger.info("User select the payment type as cash tab");
			
			// Test Step - 25
			delayWithGivenTime(1000);
			dashboard.ClickOrder();
			delayWithGivenTime(1000);
			logger.info("User click the order menu on hana dashboard page");	//https://hanafloralpos3.com/Dashboard/Order
			dashboardorder = new DashboardOrderPage();							//https://hanafloralpos3-qa.azurewebsites.net/Dashboard/Order
			softassert.assertEquals(dashboardorder.validateDashboardOrderPage(),prop.getProperty("livedashboardorderURL"),"Dashboard order page is not navigated to");				
			logger.info("User verify that the order page is navigated to dashboard order page");
			dashboardorder.EnterGlobalSearch(invoice);//
			delayWithGivenTime(2000);
			softassert.assertTrue(dashboardorder.ValidateInvoiceNumber(),"Test Step - 25 - Invoice number is not displayed");		

			// Test Step - 26			
			delayWithGivenTime(2000);
			softassert.assertEquals(dashboardorder.GetSenderorCustomerOnOrderPage().contains("Test Automation pvt ltd | Test Automation"),true,"Test Step - 26 - Sender or Customer on order page is not displayed");
			
			// Test Step - 27
			dashboardorder.ClickonSenderorCustomerOnOrderPage();
			softassert.assertTrue(dashboardorder.VerifyDeliveryPopup(),"Test Step - 27: Delivery popup is not displayed");
			
			// Test Step - 28
			softassert.assertEquals(dashboardorder.getCustomerTypeDeliveryPopup(),"(New Customer)","Test Step - 28 - customer type on delivery popup is not matched");
			softassert.assertEquals(dashboardorder.getCustAndcompyNameOnDeliveryPopup(),"Test Automation pvt ltd | Test Automation","Test Step - 28 - customer and company name on delivery popup is not matched");
			softassert.assertEquals(dashboardorder.getCustAddressOnDeliveryPopup(),"Test Automation Address, India QA Test Automation, Cbe, Tn, India","Test Step - 28 - customer address on delivery popup is not matched");
			softassert.assertEquals(dashboardorder.getCustPhoneNumOnDeliveryPopup(),"919-293-9495","Test Step - 28 - customer phone number on delivery popup is not matched");
			softassert.assertEquals(dashboardorder.getCustEmailOnDeliveryPopup(),"hanaposqateam@gmail.com","Test Step - 28 - customer phone number on delivery popup is not matched");
			logger.info("User verified displayed customer type, customer name, company name, Address, Phone number & email are matched");

			// Test Step - 29
			delayWithGivenTime(2000);
			dashboardorder.ClickCloseIconOnDeliveryPopup();
			logger.info("User clicks on close icon on delivery popup ");
			
			// Test Step - 30
			customerpage = new CustomerPage();
			dashboardorder.ClickCustomerMenuOnDashboard();
			logger.info("User clicks on customer menu on dashboard");
			delayWithGivenTime(2000);
			softassert.assertTrue(customerpage.VerifyCustomerMenuPage(),"customer menu page is not displayed");
			logger.info("User verify that customer menu page is displayed successfully");
			
			// Test Step - 31
			//customerpage.SearchAndSelectCustomerName(customername);
			delayWithGivenTime(2000);
			customerpage.Enter_CustomerId_SearchTextBox_OnCustomerTable(custId);
			//customerpage.SearchAndSelectCustomerPhone("919-293-9495");
			//customerpage.SearchAndSelectCustomerCityStateZip("Coimbatore Tamilnadu 641004");
			ThreadWait(1000);
			
			// It is a new customer so it will appears on row1 in customer table grid
			customerpage.ClickCustomerId_LastRow_OnCustTable();
			ThreadWait(1000);
			
			softassert.assertEquals(customerpage.VerifyCompanyNameOnCustTable(),"Test Automation pvt ltd","Test Step - 31 - Company Name on customer table is not matched");
			logger.info("User verify that company name on customer table");
			softassert.assertEquals(customerpage.VerifyPhoneNumberOnCustTable(),"919-293-9495","Test Step - 31 - Phone number on customer table is not matched");
			logger.info("User verify that phone number on customer table");
			softassert.assertEquals(customerpage.VerifyAddressOnCustTable(),"Test Automation Address, India","Test Step - 31 - Address on customer table is not matched");
			logger.info("User verify that address on customer table");
			softassert.assertEquals(customerpage.VerifyCityStateZipCodeOnCustTable(),"Coimbatore Tamilnadu 641004","Test Step - 31 - City, State & Zipcode on customer table is not matched");
			logger.info("User verify that city, state and zipcode on customer table");
			
			
			// Test Step - 32
			logger.info("User clicks the displayed customer in the table ");			
			delayWithGivenTime(2000);
			softassert.assertTrue(customerpage.VerifyCustomerDetailsPopup(),"Customer details pop up is not displayed");
			logger.info("User verify that customer details popup is displayed");
						
			// Test Step - 33
			delayWithGivenTime(2000);
		
			if(customerpage.getCustDetailsCompanyNameTextBox()=="Test Automation pvt ltd ") {
				softassert.assertEquals(customerpage.getCustDetailsCompanyNameTextBox(), "Test Automation pvt ltd ","Test Step - 33 - Company Name on customer details popup is not matched as expected");
				logger.info("User verified that entered company name entered data is displayed on add new customer popup");

			}else if(customerpage.getCustDetailsCompanyNameTextBox()=="Test Automation pvt ltd") {
				softassert.assertEquals(customerpage.getCustDetailsCompanyNameTextBox(), "Test Automation pvt ltd","Test Step - 33 - Company Name on customer details popup is not matched as expected");
				logger.info("User verified that entered company name entered data is displayed on add new customer popup");
			}
			
			softassert.assertEquals(customerpage.getCustDetailsFirstNameTextBox(), "Test","Added on first name field are not properly displayed");
			logger.info("User verify the first name field entered data is displayed");
			softassert.assertEquals(customerpage.getCustDetailsLastNameTextBox(), "Automation","Added on first name field are not properly displayed");
			logger.info("User verify the last name field entered data is displayed");
			softassert.assertEquals(customerpage.getCustDetailsPhoneNumberTextbox(), "919-293-9495","Added on phone number field are not properly displayed");
			logger.info("User verify the phone number field entered data is displayed");
			softassert.assertEquals(customerpage.getCustDetailsAltPhoneNumberTextBox(), "919-293-9896","Added on alternative phone number field are not properly displayed");
			logger.info("User verify the alternative phone number field entered data is displayed");
			softassert.assertEquals(customerpage.getCustDetailsAddress1TextBox(),"Test Automation Address, India","Added address 1 field is not properly displayed");
			logger.info("User verify that address 1 field entered data is displayed");
			softassert.assertEquals(customerpage.getCustDetailsAddress2TextBox(), "QA Test Automation, Cbe, Tn, India","Added address 2 field is not properly displayed");
			logger.info("User verify that address 2 field entered data is displayed");
			softassert.assertEquals(customerpage.getCustDetailsZipCodeTextBox(), "641004","Added zip code is not displayed");
			logger.info("User verify that zipcode field entered data is displayed");
		
			if(customerpage.getCustDetailsCityTextBox()=="Coimbatore") {
			softassert.assertEquals(customerpage.getCustDetailsCityTextBox(),"Coimbatore","Test Step - 33 - Added city field is not displayed");
			logger.info("User verify that city field entered data is displayed");
			}else if(customerpage.getCustDetailsCityTextBox()=="Coimabtore") {
			softassert.assertEquals(customerpage.getCustDetailsCityTextBox(),"Coimabtore","Test Step - 33 - Added city field is not displayed");			
			}
		
			softassert.assertEquals(customerpage.getCustDetailsStateTextBox(), "Tamilnadu","Added state field is not displayed");
			logger.info("User verify that state field entered data is displayed");
			softassert.assertEquals(customerpage.getCustDetailsCountryTextBox(), "India","Added country field is not displayed");
			logger.info("User verify that country field entered data is displayed");
			softassert.assertEquals(customerpage.getCustDetailsEmailTextBox(), "hanaposqateam@gmail.com","Added email id field is not displayed");
			logger.info("User verify that email id field entered data is displayed");
			softassert.assertEquals(customerpage.getDisplayedCustDetailsCustomerType(), "Corporate","Added customer type dropdown field is not displayed");
			logger.info("User verify that customer type dropdown field selected data is displayed");
			
			if(customerpage.getCustDetailsStoreCreditTextBox()=="0") {
			softassert.assertEquals(customerpage.getCustDetailsStoreCreditTextBox(), "0","Test Step - 33 - Added credit card field is not displayed");
			logger.info("User verify that customer type dropdown field selected data is displayed");
			}
			
			softassert.assertTrue(customerpage.validateCustDetailsCreditApprovedToogle(),"Credit approved toogle is enabled");
			logger.info("User verify that credit approved toogle is disabled");
			softassert.assertTrue(customerpage.ValidateCustDetailsPaperlessStatementToogle(),"paperless statement toogle is enabled");
			logger.info("User verify that paperless statement toogle is disabled");
			softassert.assertTrue(customerpage.ValidateCustDetailsEmailStatementToogle(),"Email statement toogle is enabled");
			logger.info("User verify that email statement toogle is disabled");
			softassert.assertTrue(customerpage.ValidateCustDetailsEnableLoyaltyToogle(),"Enable loyalty toogle is enabled");
			logger.info("User verify that enable loyalty toogle is disabled");
			softassert.assertTrue(customerpage.ValidateCustDetailsLateFeeSettingToogle(),"Late Fee Setting toogle is enabled");
			logger.info("User verify that enable loyalty toogle is disabled");
			softassert.assertTrue(customerpage.ValidateCustDetailsAllowFeedbackEmailTToogle(),"Allow feedback email toogle is not enabled");
			logger.info("User verify that allow feedback email toogle is enabled");
			
			// Test Step - 34
			customerpage.ClickCustomerDetailsPopupCloseIcon();
			logger.info("User clicks on customer details popup close icon");
			logger.info("User verify the customer menu page successfully");		
			softassert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
			logger.error("Test case failed due to : "+e.getMessage());
		}
	}
}
