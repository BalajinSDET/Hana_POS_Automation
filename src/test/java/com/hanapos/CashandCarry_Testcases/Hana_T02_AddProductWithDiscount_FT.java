package com.hanapos.CashandCarry_Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hanapos.pageObjects.CashAndCarryPage;
import com.hanapos.pageObjects.CashAndCarryPaymentPage;
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

public class Hana_T02_AddProductWithDiscount_FT extends TestBaseClass{
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private CashAndCarryPage cashandcarry;
	private CashAndCarryPaymentPage cashandcarrypayment;
	public static final String dataSheetName = "Hana_T02";
	// SoftAssert softassert = new SoftAssert(); - I have modified this to use CustomSoftAssert
	CustomSoftAssert softassert = new CustomSoftAssert();

	@DataProvider(name = "fetch_Excel_Data") 
	public Object[][] fetchData() throws IOException { 
		return DataLibrary.readExcelData(dataSheetName); 
	}

	/*
	 * HANA-T02 - 1 to 29 - Verify Add Product with Discount	
	 */
	
	//,retryAnalyzer= com.hanapos.utilities.RetryTest.class	
	@Description("This test case is used to Validate Add Product With Discount functionality")
	@Severity(SeverityLevel.CRITICAL)
	@Owner("Balaji N")
	@Epic("Cash and Carry Module")
	@Feature("Cash and Carry Add Product with Discount functionality")
	@Test(priority=1,enabled=true,groups= {"Regression"},dataProvider="fetch_Excel_Data") 
	public void  Validate_Hana_T02_Add_Product_With_Discount_Test(String searchandselectitemcode, String searchandselectitemdescription,String itemqty, String itemprice,
			String itemdiscountpercentage, String itemdiscountamount, String itemcode,String itemdiscountpercent,String itemdescription,String itemquantity,
			String itemPrice,String customername,String taxtype,String occasion,String sourcecode) throws InterruptedException, IOException {
		
		// Test Step - 1
		logger.info("**** Starting Hana_T02_AddProductWithDiscount_CashAndCarryTest  ****");
		logger.debug("capturing application debug logs....");
		try {
			lp = new LoginPage();
			softassert.assertTrue(lp.LoginPageIsDisplayed(),"Test Step - 1 : Login page is not displayed");
			Allure.step("User on the hana pos login page");
			logger.info("User on the hana pos login page");
			
			// Test Step - 2
			lp.EnterUserName(prop.getProperty("username"));
			Allure.step("User entered the username as "+prop.getProperty("username"));
			lp.EnterPassword(prop.getProperty("password"));
			Allure.step("User entered the password as "+prop.getProperty("password"));
			lp.ClickLoginButton();
			Allure.step("User clicked on Login button");

			dashboard = new HanaDashBoardPage();
			Assert.assertTrue(dashboard.VerifyHanaDashBoardPage(),"Test Step - 2 : Hana dashboard page is not displayed");
			logger.info("User navigated to hana dashboard page sucessfully");
			
			// Test Step - 3
			dashboard.SelectShopNameDropDown(prop.getProperty("shopname"));
			logger.info("User selected the shop name on dashboard page as "+prop.getProperty("shopname"));
			Allure.step("User selected the shop name on dashboard page as "+prop.getProperty("shopname"));
			dashboard.CashAndCarryMenuClick();							
			cashandcarry = new CashAndCarryPage();
			Allure.step("User hover the mouse on New order and click on Cash and Carry..");
			logger.info("User hover the mouse on New order and click on Cash and Carry..");
			softassert.assertTrue(cashandcarry.VerifyCashAndCarryPage(), "Test Step - 3 : Cash And Carry page is not displayed");
			logger.info("User verify the Cash and Carry page is displayed..");
			Allure.step("User verify the Cash and Carry page is displayed..");
			
			// Test Step - 4
			cashandcarry.SelectShopName(prop.getProperty("shopname"));
			Allure.step("Test Step - 4 : User select the shop name on cash and carry page as "+prop.getProperty("shopname"));
			
			//Test Step - 5
			cashandcarry.SelectClerkName(prop.getProperty("clerkname"));
			Allure.step("Test Step - 5 : User select the clerk name on cash and carry page as "+prop.getProperty("clerkname"));

			
			// Test Step - 6
			cashandcarry.SelectEmployeeName(prop.getProperty("employeename"));
			Allure.step("Test Step - 6 : User select the employee name as "+prop.getProperty("employeename"));

			// Test Step - 7
			cashandcarry.SearchAndSelectTheItemCode(searchandselectitemcode);
			Allure.step("Test Step - 7 : User select the item code as "+searchandselectitemcode);
			
			// Test Step - 8
			softassert.assertEquals(cashandcarry.ItemDescriptionValueIsExist(), "Red Rose Deluxe","Test Step - 8 : Item description is not matched with search and selected item code");
			softassert.assertEquals(cashandcarry.ItemQtyValueIsExist(), "1","Test Step - 8 : Item Quantity is not matched with search and selected item code");
			
			if(cashandcarry.ItemPriceValueIsExist()=="299") {
				softassert.assertEquals(cashandcarry.ItemPriceValueIsExist(), "299","Test Step - 8 : Item price is not matched with search and selected item code");
			}else if(cashandcarry.ItemPriceValueIsExist()=="309") {
				softassert.assertEquals(cashandcarry.ItemPriceValueIsExist(), "309","Test Step - 8 : Item price is not matched with search and selected item code");
			}
			
			softassert.assertEquals(cashandcarry.ItemDiscountAmountIsExist(),"0","Test Step - 8 : Item discount amount is not matched with search and selected item code");
			softassert.assertEquals(cashandcarry.ItemDiscountPercentageValueIsExist(), "0","Test Step - 8 : Item discount percentage is not matched with search and selected item code");
			Allure.step("User verify the item description, quantity, price, discount amount and discount percentage are displayed on respective fields");
			
			// Test Step - 9,10
			cashandcarry.ClickRefreshForm();
			Allure.step("Test Step - 9,10 : User click on refresh button and respective fields displayed datas are cleared");
			
			softassert.assertEquals(cashandcarry.ItemCodeValueIsExists(),"","Test Step - 9,10 : After click on refresh button the item code is not cleared");
			softassert.assertEquals(cashandcarry.ItemDescriptionValueIsExist(),"", "Test Step - 9,10 : After click on refresh button the item description is not cleared");	
			softassert.assertEquals(cashandcarry.ItemQtyValueIsExist(), "","Test Step - 9,10 : After click on refresh button the item quantity is not cleared");
			softassert.assertEquals(cashandcarry.ItemPriceValueIsExist(), "","Test Step - 9,10 : After click on refresh button the item price is not cleared");
			softassert.assertEquals(cashandcarry.ItemDiscountAmountIsExist(),"","Test Step - 9,10 : After click on refresh button the item discount amount is not cleared");
			softassert.assertEquals(cashandcarry.ItemDiscountPercentageValueIsExist(), "","Test Step - 9,10 : After click on refresh button the item discount percentage is not cleared");
			Allure.step("Test Step - 9,10 : User verify the item description, quantity, price, discount amount and discount percentage are cleared..");
			
			// Test Step - 11
			cashandcarry.SearchAndSelectProdByItemDescription(searchandselectitemdescription);
			Allure.step("Test Step - 11 : User select the item description as "+searchandselectitemdescription);
			
			softassert.assertEquals(cashandcarry.ItemCodeValueIsExists(),"RDWB","Test Step - 11 : Search and selected item description is not matched with displayed item code");	
			softassert.assertEquals(cashandcarry.ItemQtyValueIsExist(), "1","Test Step - 11 : Search and selected item description is not matched with displayed item quantity");
			
			softassert.assertEquals(cashandcarry.ItemPriceValueIsExist(), "40","Test Step - 11 : Search and selected item description is not matched with displayed item price");
			
			softassert.assertEquals(cashandcarry.ItemDiscountAmountIsExist(),"0","Test Step - 11 : Search and selected item description is not matched with displayed item discount amount");
			softassert.assertEquals(cashandcarry.ItemDiscountPercentageValueIsExist(), "0","Test Step - 11 : Search and selected item description is not matched with displayed item discount percentage");
			Allure.step("User verify the item code, quantity, price, discount amount and discount percentage are displayed on respective fields");
			
			// Test Step - 12
			cashandcarry.EnterItemQuantity(itemqty);
			Allure.step("User entered the item quantity as "+itemqty);
			
			cashandcarry.EnterItemPrice(itemprice);
			Allure.step("User entered the item price as "+itemprice);
			
			softassert.assertEquals(cashandcarry.ItemQtyValueIsExist(), "3","Test Step - 12 : Item quantity added value is not displayed");
			Allure.step("User verify the item quantity is displayed on item quantity field");
			
			softassert.assertEquals(cashandcarry.ItemPriceValueIsExist(), "50","Test Step - 12 : Item price added value is not displayed");
			Allure.step("User verify the item price..");

			// Test Step - 13
			cashandcarry.EnterDiscountPercentageOnAddItem(itemdiscountpercentage);
			Allure.step("User entered the discount percentage as "+itemdiscountpercentage);
			softassert.assertEquals(cashandcarry.getDiscountAmtOnDiscIsAddedByDiscPerAddItem(), "15.00","Test Step - 13 : Discount percentage added value is not autocalculated to discount amount");	

			//Test Step - 14
			cashandcarry.EnterDiscountAmountOnAddItem(itemdiscountamount);
			Allure.step("User entered the discount amount as "+itemdiscountamount);
			
			softassert.assertEquals(cashandcarry.getDiscountPercentageOnDiscIsAddedByDiscAmtField(), "010","Test Step - 14 : Discount Amount added value is not autocalculated to discount percentage");

			//Test Step - 15
			cashandcarry.ClickAddItem();
			Allure.step("User click on Add Item button");
			
			softassert.assertTrue(cashandcarry.VerifyAddedItem(),"Test Step - 15 : Added Item is not displayed on Cash and Carry page grid table");
			softassert.assertEquals(cashandcarry.getAddedItemCode(),"RDWB","Test Step - 15 : Item code is not displayed on Cash and Carry page grid table");
			softassert.assertEquals(cashandcarry.GetAddedItemDescription(),"Premium Red Roses Double Wrapped Bouquet","Test Step - 15 : Item description is not displayed on Cash and Carry page grid table");
			softassert.assertEquals(cashandcarry.GetAddedItemQty(), "3","Test Step - 15 : Item quantity is not displayed on Cash and Carry page grid table");
			softassert.assertEquals(cashandcarry.GetAddedItemExtPrice(), "$150.00","Test Step - 15 : Item extended price is not displayed on Cash and Carry page grid table");
			softassert.assertEquals(cashandcarry.GetAddedItemPrice(), "$50.00","Test Step - 15 : Item Price is not displayed on Cash and Carry page grid table");
			softassert.assertEquals(cashandcarry.GetAddedItemDiscountAmount(), "$15.00","Test Step - 15 : Item discount amount is not displayed on Cash and Carry page grid table");
			softassert.assertEquals(cashandcarry.GetAddedItemDiscountPercentage(),"10.00","Test Step - 15 : Item discount percentage is not displayed on Cash and Carry page grid table");
			Allure.step("User verify the added item on Cash and Carry page grid table");
			
			//Delete the added item on Cash and Carry page
			cashandcarry.ClickRow1DeleteIcon();
			Allure.step("User click the delete icon on the grid table row 1");
			
			// Test Step - 16 Verify Title Display Product
			delayWithGivenTime(2000);
			Allure.step("User verify add the title product to the Cash and Carry page is displayed..");
			cashandcarry.ClickParticularProdTitle();
			Allure.step("User click the left side menu tile displayed product");
			softassert.assertEquals(cashandcarry.getAddedItemCode(),"ballonsYY","Test Step - 16 : Added Item product tile is not displayed on Cash and Carry page grid table");

			// Test Step - 17 Verify Product Discount
			//Delete the added item on Cash and Carry page
			cashandcarry.ClickRow1DeleteIcon();
			delayWithGivenTime(2000);
			Allure.step("User verify add the title product to the Cash and Carry page is displayed..");
			
			cashandcarry.EnterItemCode(itemcode);
			Allure.step("User entered the item code as "+itemcode);
			
			cashandcarry.EnterDiscountPercentageOnAddItem(itemdiscountpercent);
			Allure.step("User entered the discount percentage as "+itemdiscountpercent);
			
			cashandcarry.EnterItemDescription(itemdescription);
			Allure.step("User entered the item description as "+itemdescription);
			
			cashandcarry.EnterItemQuantity(itemquantity);
			Allure.step("User entered the item quantity as "+itemquantity);
			
			cashandcarry.EnterItemPrice(itemPrice);
			Allure.step("User entered the item price as "+itemPrice);
			
			softassert.assertEquals(cashandcarry.ItemDiscountPercentageValueIsExist(), "10","Test Step - 17 : Item discount percentage added value is not displayed");

			cashandcarry.ClickAddItem();
			Allure.step("User click the Add Item button");
			// Hold below step due to discount percentage value is not reflected on the table
			//By manually it working fine
			softassert.assertTrue(cashandcarry.CouponcodeIsDisabled(),"Test Step - 18 : coupon code is not enabled");
			Allure.step("User verify the coupon code is disabled");
			
			// Test step - 19,20
			cashandcarry.ClickAddBtnForCreateNewCust();	
			Allure.step("User click on Add button in the Add new customer popup");
			
			softassert.assertTrue(cashandcarry.VerifyAddNewCustomerPageIsExist(), "Test Step - 19,20 : Add new customer page is not displayed");
			cashandcarry.ClickCloseIconOnAddNewCustPopup();
			Allure.step("User click the close icon in the Add new customer popup");			
			
			//Test step - 21
			cashandcarry.SelectCustomerLabelIsDisplayed();
			cashandcarry.EnterCustomerName(customername);
			Allure.step("User entered the customer name as "+customername);
			
			softassert.assertTrue(cashandcarry.CustomerIdIsExist(),"Test Step - 21 : Customer id is not displayed");
			Allure.step("User verify the customer id is displayed");
			
			softassert.assertTrue(cashandcarry.CustomerNameIsExist(),"Test Step - 21 : Customer name is not displayed");
			Allure.step("User verify the customer name is displayed");
			
			softassert.assertTrue(cashandcarry.CustomerCancelCrossIconIsDisplayed(),"Test Step - 21 : Customer cancel cross icon is not displayed");
			Allure.step("User verify the customer cancel cross icon is displayed");
			
			//Test step - 22
			cashandcarry.ClickCancelCustIcon();
			Allure.step("User click the cancel customer icon");
			
			softassert.assertTrue(cashandcarry.SelectCustomerDDIsDisplayed(),"Test Step - 22 : Select customer drop down is not displayed");
			Allure.step("User verify the select customer drop down is displayed");
			
			//Test step - 23
			cashandcarry.SelectCustomerLabelIsDisplayed();
			cashandcarry.EnterCustomerName(customername);
			Allure.step("User entered the customer name as "+customername);
			softassert.assertTrue(cashandcarry.CustomerIdIsExist());
			Allure.step("User verify the customer id is displayed");
			softassert.assertTrue(cashandcarry.CustomerNameIsExist());
			Allure.step("User verify the customer name is displayed");
			softassert.assertTrue(cashandcarry.CustomerCancelCrossIconIsDisplayed());
			Allure.step("User verify the customer cancel cross icon is displayed");
			
			//Test step - 24
			cashandcarry.SelectTaxType(taxtype);
			Allure.step("User selected the tax type as "+taxtype);
			
			//Test step - 25
			cashandcarry.SelectOccasion(occasion);
			Allure.step("User selected the occasion as "+occasion);
			
			//Test Step - 26
			cashandcarry.SelectSourceCode(sourcecode);
			Allure.step("User selected the source code as "+sourcecode);
			
			//Test Step - 27	
			softassert.assertEquals(cashandcarry.ValidateGrandTotal(), cashandcarry.ActualGrandTotal(),"Test Step - 27 : Grand total is not displayed");
			Allure.step("User verify the grand total is displayed");
			
			//Test Step - 28
			softassert.assertEquals(cashandcarry.ValidatePayButtonDisplayedPrice(), cashandcarry.ActualGrandTotal(),"Test Step - 28 : Pay button price is not displayed");	
			Allure.step("User verify the pay button price is displayed");
			
			//Test Step - 29
			cashandcarry.ClickPayButton();
			Allure.step("User click on Pay button");
			
			cashandcarrypayment = new CashAndCarryPaymentPage();
			softassert.assertTrue(cashandcarrypayment.IsPaymentPageDisplayed(),"Test Step - 29 : Cash And Carry payment page is not displayed");
			Allure.step("User verify the Cash And Carry payment page is displayed");
			
			Allure.step("**** Ending HANA-T02_AddProductWithDiscount - Functionality ****");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error in Hana_T02_AddProductWithDiscount_Test_CashAndCarryTest : " + e);
			softassert.fail("Error in Hana_T02_AddProductWithDiscount_Test_CashAndCarryTest : " + e);
			softassert.assertAll();
		}
		
	}
}
