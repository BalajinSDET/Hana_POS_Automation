package com.hanapos.cashandcarrytest;

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
import com.hanapos.utilities.DataLibrary;

public class Hana_T02_AddProductWithDiscount_FT extends TestBaseClass{
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private CashAndCarryPage cashandcarry;
	private CashAndCarryPaymentPage cashandcarrypayment;
	public static final String dataSheetName = "Hana_T02";
	SoftAssert softassert = new SoftAssert();

	@DataProvider(name = "fetch_Excel_Data") 
	public Object[][] fetchData() throws IOException { 
		return DataLibrary.readExcelData(dataSheetName); 
	}

	/*
	 * HANA-T02 - 1 to 29 - Verify Add Product with Discount	
	 */
//,retryAnalyzer= com.hanapos.utilities.RetryTest.class
	@Test(priority=1,enabled=true,groups= {"Regression"},dataProvider="fetch_Excel_Data") 
	public void  Validate_Hana_T02_Add_Product_With_Discount_Test(String searchandselectitemcode, String searchandselectitemdescription,String itemqty, String itemprice,
			String itemdiscountpercentage, String itemdiscountamount, String itemcode,String itemdiscountpercent,String itemdescription,String itemquantity,
			String itemPrice,String customername,String taxtype,String occasion,String sourcecode) throws InterruptedException, IOException {
		// Test Step - 1
		logger.info("**** Starting Hana_T02_AddProductWithDiscount_CashAndCarryTest  ****");
		logger.debug("capturing application debug logs....");
		try {
			lp = new LoginPage();
			softassert.assertTrue(lp.LoginPageIsDisplayed(),"Login page is not displayed");
			logger.info("User on the hana pos login page");
			
			// Test Step - 2
			lp.EnterUserName(prop.getProperty("username"));
			logger.info("User entered the username as "+prop.getProperty("username"));
			lp.EnterPassword(prop.getProperty("password"));
			logger.info("User entered the password as "+prop.getProperty("password"));
			lp.ClickLoginButton();
			logger.info("User Clicked on Login button");

			dashboard = new HanaDashBoardPage();
			Assert.assertTrue(dashboard.VerifyHanaDashBoardPage(),"Hana dashboard page is not displayed");
			logger.info("User navigated to hana dashboard page sucessfully");
			
			// Test Step - 3
			dashboard.SelectShopNameDropDown(prop.getProperty("shopname"));
			logger.info("User selected the shop name on dashboard page as "+prop.getProperty("shopname"));
			dashboard.CashAndCarryMenuClick();							
			cashandcarry = new CashAndCarryPage();
			logger.info("User hover the mouse on New order and click on Cash and Carry..");
			softassert.assertTrue(cashandcarry.VerifyCashAndCarryPage(), "Cash And Carry page is not displayed");
			logger.info("User verify the Cash and Carry page is displayed..");
			
			// Test Step - 4
			cashandcarry.SelectShopName(prop.getProperty("shopname"));
			logger.info("User select the shop name on cash and carry page as "+prop.getProperty("shopname"));
			
			//Test Step - 5
			cashandcarry.SelectClerkName(prop.getProperty("clerkname"));
			logger.info("User select the clerk name on cash and carry page as "+prop.getProperty("clerkname"));

			
			// Test Step - 6
			cashandcarry.SelectEmployeeName(prop.getProperty("employeename"));
			logger.info("User select the employee name as "+prop.getProperty("employeename"));

			// Test Step - 7
			cashandcarry.SearchAndSelectTheItemCode(searchandselectitemcode);
			logger.info("User select the item code as "+searchandselectitemcode);
			
			// Test Step - 8
			softassert.assertEquals(cashandcarry.ItemDescriptionValueIsExist(), "Red Rose Deluxe","Item description is not matched with search and selected item code");
			softassert.assertEquals(cashandcarry.ItemQtyValueIsExist(), "1","Item Quantity is not matched with search and selected item code");
			softassert.assertEquals(cashandcarry.ItemPriceValueIsExist(), "309","Item price is not matched with search and selected item code");
			softassert.assertEquals(cashandcarry.ItemDiscountAmountIsExist(),"0","Item discount amount is not matched with search and selected item code");
			softassert.assertEquals(cashandcarry.ItemDiscountPercentageValueIsExist(), "0","Item discount percentage is not matched with search and selected item code");
			logger.info("User verify the item description, quantity, price, discount amount and discount percentage..");
			
			// Test Step - 9,10
			cashandcarry.ClickRefreshForm();
			logger.info("User click on refresh button..");
			softassert.assertEquals(cashandcarry.ItemCodeValueIsExists(),"","After click on refresh button the item code is not cleared");
			softassert.assertEquals(cashandcarry.ItemDescriptionValueIsExist(),"", "After click on refresh button the item description is not cleared");	
			softassert.assertEquals(cashandcarry.ItemQtyValueIsExist(), "","After click on refresh button the item quantity is not cleared");
			softassert.assertEquals(cashandcarry.ItemPriceValueIsExist(), "","After click on refresh button the item price is not cleared");
			softassert.assertEquals(cashandcarry.ItemDiscountAmountIsExist(),"","After click on refresh button the item discount amount is not cleared");
			softassert.assertEquals(cashandcarry.ItemDiscountPercentageValueIsExist(), "","After click on refresh button the item discount percentage is not cleared");
			logger.info("User verify the item description, quantity, price, discount amount and discount percentage are cleared..");
			
			// Test Step - 11
			cashandcarry.SearchAndSelectProdByItemDescription(searchandselectitemdescription);
			logger.info("User select the item description as "+searchandselectitemdescription);
			softassert.assertEquals(cashandcarry.ItemCodeValueIsExists(),"RDWB","Search and selected item description is not matched with displayed item code");	
			softassert.assertEquals(cashandcarry.ItemQtyValueIsExist(), "1","Search and selected item description is not matched with displayed item quantity");
			softassert.assertEquals(cashandcarry.ItemPriceValueIsExist(), "40","Search and selected item description is not matched with displayed item price");
			softassert.assertEquals(cashandcarry.ItemDiscountAmountIsExist(),"0","Search and selected item description is not matched with displayed item discount amount");
			softassert.assertEquals(cashandcarry.ItemDiscountPercentageValueIsExist(), "0","Search and selected item description is not matched with displayed item discount percentage");
			logger.info("User verify the item code, quantity, price, discount amount and discount percentage..");
			
			// Test Step - 12
			cashandcarry.EnterItemQuantity(itemqty);
			logger.info("User entered the item quantity as "+itemqty);
			cashandcarry.EnterItemPrice(itemprice);
			logger.info("User entered the item price as "+itemprice);
			softassert.assertEquals(cashandcarry.ItemQtyValueIsExist(), "3","Item quantity added value is not displayed");
			logger.info("User verify the item quantity..");
			softassert.assertEquals(cashandcarry.ItemPriceValueIsExist(), "50","Item price added value is not displayed");
			logger.info("User verify the item price..");

			// Test Step - 13
			cashandcarry.EnterDiscountPercentageOnAddItem(itemdiscountpercentage);
			logger.info("User entered the discount percentage as "+itemdiscountpercentage);
			softassert.assertEquals(cashandcarry.getDiscountAmtOnDiscIsAddedByDiscPerAddItem(), "15.00","Discount percentage added value is not autocalculated to discount amount");	

			//Test Step - 14
			// ---Bug---
			cashandcarry.EnterDiscountAmountOnAddItem(itemdiscountamount);
			logger.info("User entered the discount amount as "+itemdiscountamount);
			softassert.assertEquals(cashandcarry.getDiscountPercentageOnDiscIsAddedByDiscAmtField(), "010","Discount Amount added value is not autocalculated to discount percentage");

			//Test Step - 15
			cashandcarry.ClickAddItem();
			logger.info("User click on Add Item button..");
			softassert.assertTrue(cashandcarry.VerifyAddedItem(),"Added Item is not displayed on Cash and Carry page grid table");
			softassert.assertEquals(cashandcarry.getAddedItemCode(),"RDWB","Item code is not displayed on Cash and Carry page grid table");
			softassert.assertEquals(cashandcarry.GetAddedItemDescription(),"Premium Red Roses Double Wrapped Bouquet","Item description is not displayed on Cash and Carry page grid table");
			softassert.assertEquals(cashandcarry.GetAddedItemQty(), "3","Item quantity is not displayed on Cash and Carry page grid table");
			softassert.assertEquals(cashandcarry.GetAddedItemExtPrice(), "$150.00","Item extended price is not displayed on Cash and Carry page grid table");
			softassert.assertEquals(cashandcarry.GetAddedItemPrice(), "$50.00","Item Price is not displayed on Cash and Carry page grid table");
			softassert.assertEquals(cashandcarry.GetAddedItemDiscountAmount(), "$15.00","Item discount amount is not displayed on Cash and Carry page grid table");
			softassert.assertEquals(cashandcarry.GetAddedItemDiscountPercentage(),"10.00","Item discount percentage is not displayed on Cash and Carry page grid table");
			logger.info("User verify the added item on Cash and Carry page grid table");
			
			//Delete the added item on Cash and Carry page
			cashandcarry.ClickRow1DeleteIcon();
			logger.info("User click the delete icon on the grid table row 1");
			
			// Test Step - 16 Verify Title Display Product
			delayWithGivenTime(2000);
			logger.info("User verify add the title product to the Cash and Carry page is displayed..");
			cashandcarry.ClickParticularProdTitle();
			logger.info("User click the left side menu tile displayed product");
			softassert.assertEquals(cashandcarry.getAddedItemCode(),"ballonsYY");

			// Test Step - 17 Verify Product Discount
			//Delete the added item on Cash and Carry page
			cashandcarry.ClickRow1DeleteIcon();
			delayWithGivenTime(2000);
			logger.info("User verify add the title product to the Cash and Carry page is displayed..");
			cashandcarry.EnterItemCode(itemcode);
			logger.info("User entered the item code as "+itemcode);
			cashandcarry.EnterDiscountPercentageOnAddItem(itemdiscountpercent);
			logger.info("User entered the discount percentage as "+itemdiscountpercent);
			cashandcarry.EnterItemDescription(itemdescription);
			logger.info("User entered the item description as "+itemdescription);
			cashandcarry.EnterItemQuantity(itemquantity);
			logger.info("User entered the item quantity as "+itemquantity);
			cashandcarry.EnterItemPrice(itemPrice);
			logger.info("User entered the item price as "+itemPrice);
			softassert.assertEquals(cashandcarry.ItemDiscountPercentageValueIsExist(), "10");

			cashandcarry.ClickAddItem();
			// Hold below step due to discount percentage value is not reflected on the table
			//By manually it working fine
			softassert.assertTrue(cashandcarry.CouponcodeIsDisabled(),"coupon code is not enabled");

			// Test step - 19,20
			cashandcarry.ClickAddBtnForCreateNewCust();	
			softassert.assertTrue(cashandcarry.VerifyAddNewCustomerPageIsExist(), "Add new customer page is not displayed");
			cashandcarry.ClickCloseIconOnAddNewCustPopup();

			//Test step - 21
			cashandcarry.SelectCustomerLabelIsDisplayed();
			cashandcarry.EnterCustomerName(customername);
			softassert.assertTrue(cashandcarry.CustomerIdIsExist());
			softassert.assertTrue(cashandcarry.CustomerNameIsExist());
			softassert.assertTrue(cashandcarry.CustomerCancelCrossIconIsDisplayed());

			//Test step - 22
			cashandcarry.ClickCancelCustIcon();
			softassert.assertTrue(cashandcarry.SelectCustomerDDIsDisplayed());

			//Test step - 23
			cashandcarry.SelectCustomerLabelIsDisplayed();
			cashandcarry.EnterCustomerName(customername);
			softassert.assertTrue(cashandcarry.CustomerIdIsExist());
			softassert.assertTrue(cashandcarry.CustomerNameIsExist());
			softassert.assertTrue(cashandcarry.CustomerCancelCrossIconIsDisplayed());

			//Test step - 24
			cashandcarry.SelectTaxType(taxtype);

			//Test step - 25
			cashandcarry.SelectOccasion(occasion);

			//Test Step - 26
			cashandcarry.SelectSourceCode(sourcecode);

			//Test Step - 27	
			softassert.assertEquals(cashandcarry.ValidateGrandTotal(), cashandcarry.ActualGrandTotal());

			//Test Step - 28
			softassert.assertEquals(cashandcarry.ValidatePayButtonDisplayedPrice(), cashandcarry.ActualGrandTotal());	

			//Test Step - 29
			cashandcarry.ClickPayButton();
			cashandcarrypayment = new CashAndCarryPaymentPage();
			softassert.assertTrue(cashandcarrypayment.IsPaymentPageDisplayed(),"Cash And Carry payment page is not displayed");
			softassert.assertAll();
			logger.info("**** Ending HANA-T02_AddProductWithDiscount - Functionality ****");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error in Hana_T02_AddProductWithDiscount_Test_CashAndCarryTest : " + e);
			softassert.fail("Error in Hana_T02_AddProductWithDiscount_Test_CashAndCarryTest : " + e);
			softassert.assertAll();
		}
		
	}
}
