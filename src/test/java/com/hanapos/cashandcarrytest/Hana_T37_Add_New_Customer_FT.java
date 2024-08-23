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
import com.hanapos.pageObjects.CustomerPage;
import com.hanapos.pageObjects.DashboardOrderPage;
import com.hanapos.pageObjects.HanaDashBoardPage;
import com.hanapos.pageObjects.LoginPage;
import com.hanapos.seleniumProjectBase.TestBaseClass;
import com.hanapos.utilities.DataLibrary;

public class Hana_T37_Add_New_Customer_FT extends TestBaseClass{
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private CashAndCarryPage cashandcarry;
	private CashAndCarryPaymentPage cashandcarrypayment;
	private DashboardOrderPage dashboardorder;
	private CustomerPage customerpage = new CustomerPage();
	public static final String dataSheetName = "Hana_T37";
	SoftAssert softassert = new SoftAssert();
	public static ExecutorService executorService;
	private static final int THREAD_POOL_SIZE = 2;

	@DataProvider(name = "fetch_Excel_Data") 
	public Object[][] fetchData() throws IOException { 
		return DataLibrary.readExcelData(dataSheetName); 
	}

	/*
	 * HANA-T37 - 1 to 34 - Verify Add new customer Functionality
	 */
//retryAnalyzer= com.hanapos.utilities.RetryTest.class,
	@Test(enabled=true,groups= {"Smoke","Regression"},dataProvider="fetch_Excel_Data") 
	public void  Validate_Hana_T37_Add_New_Customer_Test(String searchandselectitemcode, String custfirstname, String custlastname, String custphonenumber, String custsplfname, String custspllname, String custsplphonenumber, String custsplaltphnumber,
			String custalphaphnumber, String custalphaltphnumber, String custphnumber1, String custphnumber2, String companyname, String custphonenumber1, String custaltphonenumber, String address1, String address2, String zipcode,
			String city, String state, String country,String emailid, String custtype, String custcredit, String customername, String occasion) throws InterruptedException, IOException {
		// Test Step - 1
		logger.info("**** Starting Hana_T37_Add_New_Customer_FT_CashAndCarryTest  ****");
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

			// Test Step - 8
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

			
			// Test Step - 09
			delayWithGivenTime(2000);
			cashandcarry.ClickParticularProdTitle();
			logger.info("User click on the particular product tile");
			softassert.assertEquals(cashandcarry.getAddedItemCodeRow2(),"ballonsYY");
			logger.info("User verify add the title product to the Cash and Carry page is displayed..");		

			// Test Step - 10
			cashandcarry.ClickAddCustomerButton();
			logger.info("User click the add button on customer select field");
			delayWithGivenTime(2000);
			softassert.assertTrue(cashandcarry.VerifyAddNewCustomerPopup(),"Test Step - 10 - Add new customer popup is not displayed");
			logger.info("User verify the add new customer popup is displayed");
			
			// Test Step - 11
			cashandcarry.EnterAddNewCustFirstName(custfirstname);
			logger.info("User entered the first name as ");
			cashandcarry.EnterAddNewCustLastName(custlastname);
			logger.info("User entered the last name as ");
			cashandcarry.EnterAddNewCustPhoneNumber(custphonenumber);
			logger.info("User entered the phone number as ");
			
			// Test Step - 12
			cashandcarry.ClickAddNewCustPopupCloseIcon();
			logger.info("User click the add new customer pop up close icon ");
			
			softassert.assertTrue(cashandcarry.VerifyCashAndCarryPage(), "Cash And Carry page is not displayed");
			logger.info("User verify the Cash and Carry page is displayed..");
			
			softassert.assertEquals(cashandcarry.getDisplayedCustomerName(), "","Customer name entered on add new customer popup is displayed");
			logger.info("User verify the customer name entered on add new customer popup is displayed");
			
			// Test Step - 13
			cashandcarry.ClickAddCustomerButton();
			logger.info("User click the add button on customer select field");
			delayWithGivenTime(2000);
			softassert.assertTrue(cashandcarry.VerifyAddNewCustomerPopup(),"Add new customer popup is not displayed");
			logger.info("User verify the add new customer popup is displayed");
			
			// Test Step - 14
			cashandcarry.EnterAddNewCustFirstName(custsplfname);
			logger.info("User entered the first name as ");
			cashandcarry.EnterAddNewCustLastName(custspllname);
			logger.info("User entered the last name as ");
			cashandcarry.EnterAddNewCustPhoneNumber(custsplphonenumber);
			logger.info("User entered the phone number as ");
			cashandcarry.EnterAddNewCustAltPhoneNumber(custsplaltphnumber);
			logger.info("User entered the alternate phone number as ");
			
			softassert.assertEquals(cashandcarry.getEnteredaddnewcustfirstname(), "","special character is added on first name field");
			logger.info("User verify the special character is not accepted on first name field ");
			softassert.assertEquals(cashandcarry.getEnteredaddnewcustlastname(), "","special character is added on last name field");
			logger.info("User verify the special character is not accepted on last name field ");
			softassert.assertEquals(cashandcarry.getEnteredaddnewcustphonenumber(), "","special character is added on phone number field");
			logger.info("User verify the special character is not accepted on phone number field ");
			softassert.assertEquals(cashandcarry.getEnteredaddnewcustaltphonenumber(), "","special character is added on alternative phone number field");
			logger.info("User verify the special character is not accepted on alternative phone number field ");
			
			// Test Step - 15
			cashandcarry.EnterAddNewCustPhoneNumber(custalphaphnumber);
			logger.info("User entered the phone number as ");
			cashandcarry.EnterAddNewCustAltPhoneNumber(custalphaltphnumber);
			logger.info("User entered the alternate phone number as ");
			
			softassert.assertEquals(cashandcarry.getEnteredaddnewcustphonenumber(), "","alphabetic character is added on phone number field");
			logger.info("User verify the alphabetic character is not accepted on phone number field ");
			softassert.assertEquals(cashandcarry.getEnteredaddnewcustaltphonenumber(), "","alphabetic character is added on alternative phone number field");
			logger.info("User verify the alphabetic character is not accepted on alternative phone number field ");

			// Test Step - 16
			cashandcarry.EnterAddNewCustPhoneNumber(custphnumber1);
			logger.info("User entered the phone number as ");
			cashandcarry.EnterAddNewCustAltPhoneNumber(custphnumber2);
			logger.info("User entered the alternate phone number as ");
			
			softassert.assertEquals(cashandcarry.getEnteredaddnewcustphonenumber(), "+99-123-456-7890","Test Step - 16 - enter more than 12 character is added on phone number field");
			logger.info("User verify the alphabetic character is not accepted on phone number field ");
			softassert.assertEquals(cashandcarry.getEnteredaddnewcustaltphonenumber(), "+99-123-456-7890","Test Step - 16 - enter more than 12 character is added on alternative phone number field");
			logger.info("User verify the alphabetic character is not accepted on alternative phone number field ");

			// Test Step - 17
			cashandcarry.SelectShopNameOnAddNewCustPopup(prop.getProperty("shopname"));
			logger.info("User select the shop name on add new customer popup ");
			cashandcarry.EnterCompanyNameOnAddnewCustPopup(companyname);
			logger.info("User entered the company name as ");
			cashandcarry.EnterAddNewCustFirstName(custfirstname);
			logger.info("User entered the first name as ");
			cashandcarry.EnterAddNewCustLastName(custlastname);
			logger.info("User entered the last name as ");
			cashandcarry.EnterAddNewCustPhoneNumber(custphonenumber1);
			logger.info("User entered the phone number as ");
			cashandcarry.EnterAddNewCustAltPhoneNumber(custaltphonenumber);
			logger.info("User entered the alternate phone number as ");	
			cashandcarry.EnterAddress1OnAddnewCustPopup(address1);
			logger.info("User entered the address 1 as ");
			cashandcarry.EnterAddress2OnAddnewCustPopup(address2);
			logger.info("User entered the address 2 as ");
			cashandcarry.EnterZipCodeOnAddnewCustPopup(zipcode);
			logger.info("User entered the zipcode as ");
			cashandcarry.EnterCityOnAddnewCustPopup(city);
			logger.info("User entered the city as ");
			cashandcarry.EnterStateOnAddnewCustPopup(state);
			logger.info("User selected the state as ");
			cashandcarry.EnterCountryOnAddnewCustPopup(country);
			logger.info("User entered the country as ");
			cashandcarry.EnterEmailOnAddnewCustPopup(emailid);
			logger.info("User entered the email id as ");
			cashandcarry.SelectCustTypeOnAddNewCustPopup(custtype);
			logger.info("User selected the customer type as ");
			cashandcarry.EnterCustCreditOnAddNewCustPopup(custcredit);
			logger.info("User entered the customer credit as ");
			ThreadWait(2000);
			softassert.assertEquals(cashandcarry.getSelectedShopNameOnAddNewCustPopup(), prop.getProperty("shopname"));
			logger.info("User verified that selected shopname selected data is displayed on add new customer popup");
			
			if(cashandcarry.getEnteredaddnewcustcompanyname().equals("Test Automation pvt ltd ")){ 
				softassert.assertEquals(cashandcarry.getEnteredaddnewcustcompanyname(), "Test Automation pvt ltd "," Test Step-17 -Added on company name field are not properly displayed");
				logger.info("User verified that entered company name entered data is displayed on add new customer popup");	
			}else if(cashandcarry.getEnteredaddnewcustcompanyname().equals("Test Automation pvt ltd")){ 
				softassert.assertEquals(cashandcarry.getEnteredaddnewcustcompanyname(), "Test Automation pvt ltd"," Test Step-17 -Added on company name field are not properly displayed");
				logger.info("User verified that entered company name entered data is displayed on add new customer popup");	
			}

			softassert.assertEquals(cashandcarry.getEnteredaddnewcustfirstname(), "Test","Test Step-17 -Added on first name field are not properly displayed");
			logger.info("User verify the first name field entered data is displayed");
			softassert.assertEquals(cashandcarry.getEnteredaddnewcustlastname(), "Automation","Test Step-17 -Added on first name field are not properly displayed");
			logger.info("User verify the last name field entered data is displayed");
			softassert.assertEquals(cashandcarry.getEnteredaddnewcustphonenumber(), "919-293-9495","Test Step-17 -Added on phone number field are not properly displayed");
			logger.info("User verify the phone number field entered data is displayed");
			softassert.assertEquals(cashandcarry.getEnteredaddnewcustaltphonenumber(), "919-293-9896","Test Step-17 -Added on alternative phone number field are not properly displayed");
			logger.info("User verify the alternative phone number field entered data is displayed");
			softassert.assertEquals(cashandcarry.getEnteredaddnewcustaddress1(),"Test Automation Address, India","Test Step-17 -Added address 1 field is not properly displayed");
			logger.info("User verify that address 1 field entered data is displayed");
			softassert.assertEquals(cashandcarry.getEnteredaddnewcustaddress2(), "QA Test Automation, Cbe, Tn, India","Test Step-17 -Added address 2 field is not properly displayed");
			logger.info("User verify that address 2 field entered data is displayed");
			softassert.assertEquals(cashandcarry.getEnteredaddnewcustzipcode(), "641004","Test Step-17 -Added zip code is not displayed");
			logger.info("User verify that zipcode field entered data is displayed");
			
			if(cashandcarry.getEnteredaddnewcustcity().equals("Coimbatore")) {
				softassert.assertEquals(cashandcarry.getEnteredaddnewcustcity(), "Coimbatore","Test Step-17 -Added city field is not displayed");
				logger.info("User verify that city field entered data is displayed");
			}else if (cashandcarry.getEnteredaddnewcustcity().equals("Coimabtore")) {
				softassert.assertEquals(cashandcarry.getEnteredaddnewcustcity(), "Coimbatore","Test Step-17 -Added city field is not displayed");
				logger.info("User verify that city field entered data is displayed");
			}
						
			softassert.assertEquals(cashandcarry.getEnteredaddnewcuststate(), "Tamilnadu","Test Step-17 -Added state field is not displayed");
			logger.info("User verify that state field entered data is displayed");
			softassert.assertEquals(cashandcarry.getEnteredaddnewcustcountry(), "India","Test Step-17 -Added country field is not displayed");
			logger.info("User verify that country field entered data is displayed");
			softassert.assertEquals(cashandcarry.getEnteredaddnewcustemail(), "hanaposqateam@gmail.com","Test Step-17 -Added email id field is not displayed");
			logger.info("User verify that email id field entered data is displayed");
			softassert.assertEquals(cashandcarry.getSelectedCustTypeOnAddNewCustPopup(), "Corporate","Test Step-17 -Added customer type dropdown field is not displayed");
			logger.info("User verify that customer type dropdown field selected data is displayed");
			
			if(cashandcarry.getEnteredaddnewcustcredit().equals("100")) {
			softassert.assertEquals(cashandcarry.getEnteredaddnewcustcredit(), "100","Test Step-17 -Added customer type dropdown field is not displayed");
			logger.info("User verify that customer type dropdown field selected data is displayed");
			}else if(cashandcarry.getEnteredaddnewcustcredit().equals("0")) {
			softassert.assertEquals(cashandcarry.getEnteredaddnewcustcredit(), "0","Test Step-17 -Added customer type dropdown field is not displayed");
			logger.info("User verify that customer type dropdown field selected data is displayed");		
			}
			
			// Test Step - 18
			softassert.assertTrue(cashandcarry.ValidateCreditApprovedToogleOnAddNewCustPopup(),"Test Step-18 Credit approved toogle is enabled");
			logger.info("User verify that credit approved toogle is disabled");
			softassert.assertTrue(cashandcarry.ValidatePaperlessStatementToogleOnAddNewCustPopup(),"Test Step-18 paperless statement toogle is enabled");
			logger.info("User verify that paperless statement toogle is disabled");
			softassert.assertTrue(cashandcarry.ValidateEmailStatementToogleOnAddNewCustPopup(),"Test Step-18 Email statement toogle is enabled");
			logger.info("User verify that email statement toogle is disabled");
			softassert.assertTrue(cashandcarry.ValidateEnableLoyaltyToogleOnAddNewCustPopup(),"Test Step-18 Enable loyalty toogle is enabled");
			logger.info("User verify that enable loyalty toogle is disabled");
			softassert.assertTrue(cashandcarry.ValidateLateFeeSettingToogleOnAddNewCustPopup(),"Test Step-18 Late Fee Setting toogle is enabled");
			logger.info("User verify that enable loyalty toogle is disabled");
			softassert.assertTrue(cashandcarry.ValidateAllowSMSTToogleOnAddNewCustPopup(),"Test Step-18 Allow SMS toogle is enabled");
			logger.info("User verify that allow sms toogle is disabled");
			softassert.assertTrue(cashandcarry.ValidateAllowFeedbackEmailTToogleOnAddNewCustPopup(),"Test Step-18 Allow feedback email toogle is not enabled");
			logger.info("User verify that allow feedback email toogle is enabled");
			
			
			// Test Step - 19
			cashandcarry.ClickAddNewCustPopupAddNewCustBtn();
			logger.info("User click on the add new customer button");
			softassert.assertTrue(cashandcarry.VerifySuccessMessageIsDisplayed(),"Test Step - 19 -Success toast message is not displayed after creating customer");
			logger.info("User verified success toast message is displayed ");
			softassert.assertEquals(cashandcarry.getDisplayedCustomerNameOnCCPage(),"Test Automation","Test Step - 19 - Newly created Customer name is not displayed");		
			logger.info("User verified created customer name is displayed on cash and carry page");
			System.out.println("Test Step - 19 - Newly Created Customer Id: " +cashandcarry. get_NewlyCreated_CustomerId());
		
			// Test Step - 20
			//========================== Test 20, 21
			//=========================== In Automation we cannot able to reselect the customer name			
			//========== Because we cannot able to get the newly created customer id ================= 
			/*
			 * delayWithGivenTime(1000); cashandcarry.ClickCancelCustIcon();
			 * logger.info("User clicks on the cancel customer icon");
			 * delayWithGivenTime(1000);
			 * softassert.assertEquals(cashandcarry.getDisplayedCustomerName(),
			 * "","Customer name is displayed");
			 * 
			 * // Test Step - 21 delayWithGivenTime(1000); //
			 * cashandcarry.EnterCustomerName(customername);
			 * cashandcarry.EnterNewCustomerName();
			 * logger.info("User search and select the created customer ");
			 * delayWithGivenTime(1000);
			 * //softassert.assertEquals(cashandcarry.getDisplayedCustomerName()
			 * ,"Test Automation","Customer name is not displayed"); logger.
			 * info("User verify that search and selected the created customer is displayed "
			 * );
			 *///=======================Skiped above test step
			
			// Test Step - 22
			delayWithGivenTime(1000);
			softassert.assertEquals(cashandcarry.getDisplayedCustomerNameOnCCPage(),"Test Automation","Test Step - 22 - Customer name is not displayed");		
			logger.info("User verified created customer name is displayed on cash and carry page");
			softassert.assertTrue(cashandcarry.CustomerIdIsExist(),"Test Step - 22 -Test Automation customer id is not displayed");		
			logger.info("User verified created customer name is displayed on cash and carry page");
			
			// Test Step - 23
			cashandcarry.SelectTaxType("Tax Exemption");
			cashandcarry.SelectOccasion(occasion);
			logger.info("User select the occasion as birthday");
			cashandcarry.ClickPayButton();
			logger.info("User clicks on the pay button");
			
			delayWithGivenTime(2000);
			cashandcarrypayment = new CashAndCarryPaymentPage();
			softassert.assertTrue(cashandcarrypayment.IsPaymentPageDisplayed(),"Test Step - 23 -Cash And Carry payment page is not displayed");
			logger.info("User is on Cash And Carry payment page");
			
			// Test Step - 24
			delayWithGivenTime(2000);
			cashandcarrypayment.ClickCashTab();
			logger.info("User select the payment type as cash tab");
			cashandcarrypayment.EnterGivenAmount();
			logger.info("User enter the amount in given amount field");
			cashandcarrypayment.ClickProcessPaymentBtn();
			softassert.assertTrue(cashandcarrypayment.SuccessToastMsg(),"Test Step - 24 -Order payment done successfully toast message is not displayed"); 		
			logger.info("User verified the order payment done successfully");
			softassert.assertEquals(cashandcarrypayment.getOrderConfirmationToastMsg(),"Order payment done successfully","Test Step - 24 -Order confirmation message is not displayed");
			
			delayWithGivenTime(1000);
			if(cashandcarrypayment.getConfirmationPopup()==true) {
				cashandcarrypayment.VerifyOrderConfirmationPopup();
				logger.info("User verify the order confirmation popup is displayed");
				cashandcarrypayment.GetOrderConfirmationMsgAndInvoiceNo();	
				logger.info("User verify the order confirmation message and invoice number is displayed");
				cashandcarrypayment.GetInvoiceNumber();
				logger.info(("Generated Order invoice number is :"+cashandcarrypayment.GetInvoiceNumber()));
				System.out.println("Order invoice number is :"+cashandcarrypayment.GetInvoiceNumber());				
				cashandcarrypayment.GetTenderPrice();
				logger.info(("The remaining amount given to customer is :"+cashandcarrypayment.GetTenderPrice()));
				System.out.println("The remaining amount given to customer is :"+cashandcarrypayment.GetTenderPrice());			
			}	
			
		//	RobotDismissAlert();
			logger.info("User click the cancel button on webclientprint window popup");
			cashandcarrypayment.ClickOrderConfirmationPopupCloseBtn();
			logger.info("User select the payment type as cash tab");
				
			// Test Step - 25
			delayWithGivenTime(1000);
			dashboard.ClickOrder();
			delayWithGivenTime(1000);
			logger.info("User click the order menu on hana dashboard page");	
			dashboardorder = new DashboardOrderPage();		//https://hanafloralpos3.com/Dashboard/Order
			softassert.assertEquals(dashboardorder.validateDashboardOrderPage(),prop.getProperty("livedashboardorderURL"),"Dashboard order page is not displayed");				
			logger.info("User verify that the order page is navigated to dashboard order page");
			
			delayWithGivenTime(1000);
			dashboardorder.EnterGlobalSearch(dashboardorder.getInvoiceNumber_Walkin_pickup_Cash_OnOrderPage());
			softassert.assertTrue(dashboardorder.ValidateInvoiceNumber(),"Test Step - 25 -Invoice number on order page is not displayed");		
			
			// Test Step - 26
			delayWithGivenTime(1000);
			softassert.assertEquals(dashboardorder.GetSenderorCustomerOnOrderPage().contains("Test Automation pvt ltd | Test Automation"),true,"Test Step - 26 -sender or customer name on order page is not matched");
			
			// Test Step - 27
			dashboardorder.ClickonSenderorCustomerOnOrderPage();
			softassert.assertTrue(dashboardorder.VerifyDeliveryPopup(),"Delivery popup is not displayed");
			
			// Test STep - 28
			softassert.assertEquals(dashboardorder.getCustomerTypeDeliveryPopup(),"(New Customer)","Test Step - 28 -customer type on delivery popup is not matched");
			softassert.assertEquals(dashboardorder.getCustAndcompyNameOnDeliveryPopup(),"Test Automation pvt ltd | Test Automation","Test Step - 28 -customer and company name on delivery popup is not matched");
			softassert.assertEquals(dashboardorder.getCustAddressOnDeliveryPopup(),"Test Automation Address, India QA Test Automation, Cbe, Tn, India","Test Step - 28 -customer address on delivery popup is not matched");
			softassert.assertEquals(dashboardorder.getCustPhoneNumOnDeliveryPopup(),"919-293-9495","Test Step - 28 -customer phone number on delivery popup is not matched");
			softassert.assertEquals(dashboardorder.getCustEmailOnDeliveryPopup(),"hanaposqateam@gmail.com","Test Step - 28 -customer phone number on delivery popup is not matched");
			logger.info("User verified displayed customer type, customer name, company name, Address, Phone number & email are matched");
			
			// Test Step - 29
			dashboardorder.ClickCloseIconOnDeliveryPopup();
			logger.info("User clicks on close icon on delivery popup ");
			
			// Test Step - 30
			customerpage = new CustomerPage();
			dashboardorder.ClickCustomerMenuOnDashboard();
			logger.info("User clicks on customer menu on dashboard");
			delayWithGivenTime(2000);
			softassert.assertTrue(customerpage.VerifyCustomerMenuPage(),"Test Step - 30 -customer menu page is not displayed");
			logger.info("User verify that customer menu page is displayed successfully");
			
			// Test Step - 31			
			customerpage.SearchAndSelectCustomerName(customername);
			customerpage.SearchAndSelectCustomerPhone("956-655-0756");
			customerpage.SearchAndSelectCustomerCityStateZip("Coimbatore");
			ThreadWait(1000);
			customerpage.ClickCustomerId_LastRow_OnCustTable();
			
			// Test Step - 32

			logger.info("User clicks the displayed customer in the table ");
			delayWithGivenTime(4000);
			softassert.assertTrue(customerpage.VerifyCustomerDetailsPopup(),"Test Step - 32 - Customer details pop up is not displayed");
			logger.info("User verify that customer details popup is displayed");
			
			// Test Step - 33
			delayWithGivenTime(2000);
			softassert.assertEquals(customerpage.getCustDetailsCompanyNameTextBox(), "Test Automation pvt ltd "," Test - 33 - Added on company name field are not properly displayed");
			logger.info("User verified that entered company name entered data is displayed on add new customer popup");
			softassert.assertEquals(customerpage.getCustDetailsFirstNameTextBox(), "Test","Test Step - 33 - Added on first name field are not properly displayed");
			logger.info("User verify the first name field entered data is displayed");
			softassert.assertEquals(customerpage.getCustDetailsLastNameTextBox(), "Automation","Test Step - 33 - Added on first name field are not properly displayed");
			logger.info("User verify the last name field entered data is displayed");
			softassert.assertEquals(customerpage.getCustDetailsPhoneNumberTextbox(), "919-293-9495","Test Step - 33 - Added on phone number field are not properly displayed");
			logger.info("User verify the phone number field entered data is displayed");
			softassert.assertEquals(customerpage.getCustDetailsAltPhoneNumberTextBox(), "919-293-9896","Test Step - 33 - Added on alternative phone number field are not properly displayed");
			logger.info("User verify the alternative phone number field entered data is displayed");
			softassert.assertEquals(customerpage.getCustDetailsAddress1TextBox(),"Test Automation Address, India","Test Step - 33 - Added address 1 field is not properly displayed");
			logger.info("User verify that address 1 field entered data is displayed");
			softassert.assertEquals(customerpage.getCustDetailsAddress2TextBox(), "QA Test Automation, Cbe, Tn, India","Test Step - 33 - Added address 2 field is not properly displayed");
			logger.info("User verify that address 2 field entered data is displayed");
			softassert.assertEquals(customerpage.getCustDetailsZipCodeTextBox(), "641004","Test Step - 33 - Added zip code is not displayed");
			logger.info("User verify that zipcode field entered data is displayed");
			softassert.assertEquals(customerpage.getCustDetailsCityTextBox(), "Coimbatore","Test Step - 33 - Added city field is not displayed");
			logger.info("User verify that city field entered data is displayed");
			softassert.assertEquals(customerpage.getCustDetailsStateTextBox(), "Tamilnadu","Test Step - 33 - Added state field is not displayed");
			logger.info("User verify that state field entered data is displayed");
			softassert.assertEquals(customerpage.getCustDetailsCountryTextBox(), "India","Test Step - 33 - Added country field is not displayed");
			logger.info("User verify that country field entered data is displayed");
			softassert.assertEquals(customerpage.getCustDetailsEmailTextBox(), "hanaposqateam@gmail.com","Test Step - 33 - Added email id field is not displayed");
			logger.info("User verify that email id field entered data is displayed");
			softassert.assertEquals(customerpage.getDisplayedCustDetailsCustomerType(), "Corporate","Test Step - 33 - Added customer type dropdown field is not displayed");
			logger.info("User verify that customer type dropdown field selected data is displayed");
		
			if(customerpage.getCustDetailsStoreCreditTextBox()=="100") {
				softassert.assertEquals(customerpage.getCustDetailsStoreCreditTextBox(), "100","Test Step - 33 - Added customer type dropdown field is not displayed");
				logger.info("User verify that customer type dropdown field selected data is displayed");				
			}else if(customerpage.getCustDetailsStoreCreditTextBox()=="0") {
				softassert.assertEquals(customerpage.getCustDetailsStoreCreditTextBox(), "0","Test Step - 33 - Added customer type dropdown field is not displayed");
				logger.info("User verify that customer type dropdown field selected data is displayed");		
			}
			
			softassert.assertTrue(customerpage.validateCustDetailsCreditApprovedToogle(),"Test Step - 33 - Credit approved toogle is enabled");
			logger.info("User verify that credit approved toogle is disabled");
			softassert.assertTrue(customerpage.ValidateCustDetailsPaperlessStatementToogle(),"Test Step - 33 - paperless statement toogle is enabled");
			logger.info("User verify that paperless statement toogle is disabled");
			softassert.assertTrue(customerpage.ValidateCustDetailsEmailStatementToogle(),"Test Step - 33 - Email statement toogle is enabled");
			logger.info("User verify that email statement toogle is disabled");
			softassert.assertTrue(customerpage.ValidateCustDetailsEnableLoyaltyToogle(),"Test Step - 33 - Enable loyalty toogle is enabled");
			logger.info("User verify that enable loyalty toogle is disabled");
			softassert.assertTrue(customerpage.ValidateCustDetailsLateFeeSettingToogle(),"Test Step - 33 - Late Fee Setting toogle is enabled");
			logger.info("User verify that enable loyalty toogle is disabled");
			softassert.assertTrue(customerpage.ValidateCustDetailsAllowFeedbackEmailTToogle(),"Test Step - 33 - Allow feedback email toogle is not enabled");
			logger.info("User verify that allow feedback email toogle is enabled");
			
			// Test Step - 34
			customerpage.ClickCustomerDetailsPopupCloseIcon();
			logger.info("User clicks on customer details popup close icon");
			
			//=========== We cannot able to delete customer in the pos ==============
			/*
			 * softassert.assertTrue(customerpage.VerifyCustomerMenuPage()
			 * ,"customer menu page is not displayed");
			 * logger.info("User verify the customer menu page successfully");
			 * 
			 * customerpage.ClickOnCustomerTableAllCheckBox(); delayWithGivenTime(2000);
			 * customerpage.ClickOnActionButton(); delayWithGivenTime(2000);
			 * customerpage.ClickOnCustomerDeleteButton();
			 */
			softassert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception in test case - " + e.getMessage());			
		}
	}
}
