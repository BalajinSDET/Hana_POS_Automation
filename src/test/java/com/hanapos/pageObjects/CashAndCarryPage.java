package com.hanapos.pageObjects;

import java.awt.Robot;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.hanapos.seleniumProjectBase.TestBaseClass;


/**
 * 
 */
public class CashAndCarryPage extends TestBaseClass{
	public CashAndCarryPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public Select select;

	/*
	 * @Param - CashAndCarryPage
		@author Balaji N - Dream Corp
		@Date - 06/06/2024
	 */
	@FindBy(xpath="//h2[contains(text(),'Cash And Carry')]")
	private WebElement CashAndCarryPage;

	@FindBy(xpath="//select[@id='ddlShop']")
	private WebElement ShopNameDropDown;

	@FindBy(xpath="//select[@id='ddlClerk']")
	private WebElement ClerkDropDown;

	@FindBy(xpath="//select[@id='ddlEmployee']")
	private WebElement EmployeeDropDown;

	@FindBy(xpath="//p[normalize-space()='Item Code']")
	private WebElement ItemCodeLabel;

	@FindBy(xpath="//input[@id='txtItemCode']")
	private WebElement ItemCode;

	@FindBy(xpath="//ul[@id='ui-id-3']//li//div")
	private List<WebElement> itemcodelist;

	@FindBy(xpath="//p[normalize-space()='Description']")
	private WebElement ItemDescriptionLabel;

	@FindBy(id="txtDescription")
	private WebElement ItemDescription;

	@FindBy(xpath="//ul[@id='ui-id-4']//li")
	private List<WebElement> ItemDescList;

	@FindBy(xpath="//p[normalize-space()='Qty']")
	private WebElement ItemQuantityLabel;

	@FindBy(id="txtQty")
	private WebElement ItemQuantity;

	@FindBy(xpath="//p[normalize-space()='Price']")
	private WebElement ItemPriceLabel;

	@FindBy(xpath="//input[@id='txtPrice']")
	private WebElement ItemPrice;

	@FindBy(xpath="//p[normalize-space()='Discount']")
	private WebElement ItemDiscountLabel;

	@FindBy(xpath="//input[@id='txtDiscountAmtItem']")
	private WebElement ItemDiscount;

	@FindBy(xpath="//p[normalize-space()='Discount %']")
	private WebElement ItemDiscountPercentageLabel;

	@FindBy(xpath="//input[@id='txtDiscountPerItem']")
	private WebElement ItemDiscountPercentage;

	@FindBy(xpath="//p[normalize-space()='Action']")
	private WebElement ActionLabel;

	@FindBy(xpath="//a[@id='btnAdd']")
	private WebElement AddItemBtn;

	@FindBy(xpath="//a[@id='btnRefresh']")
	private WebElement RefreshFormBtn;

	@FindBy(xpath="//tr[@id='Row_1']")
	private WebElement AddedItemTableRow1;
	
	@FindBy(xpath="//table[@id='tblProducts']")
	private WebElement AddedItemTable;
	
	@FindBy(xpath="(//span[@class='glyphicon glyphicon-trash'])[1]")
	private WebElement AddedItemTableRow1DeleteIcon;
	
	@FindBy(xpath="//tbody[@id='tblItem']//td[1]")
	private WebElement AddedItemTableRow1ItemCode;
	
	@FindBy(xpath="//tbody[@id='tblItem']//td[2]")
	private WebElement AddedItemTableRow1Description;
	
	@FindBy(xpath="//tbody[@id='tblItem']//td[3]")
	private WebElement AddedItemTableRow1Quantity;	
	
	@FindBy(xpath="//input[@id='txtEditQty_1']")
	private WebElement EditedQtyRow1Textbox;
	
	@FindBy(xpath="//tbody[@id='tblItem']//td[4]")
	private WebElement AddedItemTableRow1Price;
	
	@FindBy(xpath="(//tbody[@id='tblItem']//td[4])[2]")
	private WebElement AddedItemTableRow2Price;
	
	@FindBy(xpath="//input[@id='txtEditItemPrice_1']")
	private WebElement EditedPriceRow1Textbox;
	
	@FindBy(xpath="//tbody[@id='tblItem']//td[5]")
	private WebElement AddedItemTableRow1ExtPrice;
	
	@FindBy(xpath="//tbody[@id='tblItem']//td[6]")
	private WebElement AddedItemTableRow1DiscountAmount;
	
	@FindBy(xpath="//tbody[@id='tblItem']//td[7]")
	private WebElement AddedItemTableRow1DiscountPercentage;
	
	@FindBy(xpath="(//tbody[@id='tblItem']//td[1])[2]")
	private WebElement AddedItemTableRow2ItemCode;
	
	@FindBy(xpath="(//tbody[@id='tblItem']//td[2])[2]")
	private WebElement AddedItemTableRow2Description;
	
	@FindBy(xpath="(//tbody[@id='tblItem']//td[3])[2]")
	private WebElement AddedItemTableRow2Quantity;
	
	@FindBy(xpath="//tbody[@id='tblItem']//td[8]")
	private WebElement AddedItemTableRow1Action;
	
	@FindBy(xpath="//tbody[@id='tblItem']//td[8]/a[1]")
	private WebElement EditAddedItemTableRow1Action;
	
	@FindBy(xpath="//span[@class='glyphicon glyphicon-floppy-saved']")
	private WebElement SavedAddedItemTableRow1Action;
	
	@FindBy(xpath="//span[@class='glyphicon glyphicon-floppy-remove']")
	private WebElement CancelAddedItemTableRow1Action;
	
	@FindBy(xpath="//tbody[@id='tblItem']//td[8]/a[2]")
	private WebElement DeleteAddedItemTableRow1;
	
	@FindBy(xpath="(//tbody[@id='tblItem']//td[8]/a[2])[2]")
	private WebElement DeleteAddedItemTableRow2;
	
	@FindBy(xpath="//tr[@id='Row_2']")
	private WebElement AddedItemTableRow2;
	
	@FindBy(xpath="//div[@class='toast-message']")
	private WebElement toasterrormsg;

	@FindBy(xpath="(//label[contains(text(),'Coupon')])[1]")
	private WebElement CouponLabel;

	@FindBy(xpath="//input[@id='txtCouponCode']")
	private WebElement CouponCodeTextbox;

	@FindBy(xpath="//label[contains(text(),'Discount(%) ')]")
	private WebElement DiscountLabel;

	@FindBy(xpath="//input[@id='txtDiscount']") 
	private WebElement DiscountPercentTextbox;

	@FindBy(xpath="//label[contains(text(),'Discount($)')]") 
	private WebElement DiscountDollarLabel;

	@FindBy(xpath="(//input[@id='txtDiscountAmount'])[1]") //(//input[@id='txtDiscountAmount'])[1]
	private WebElement DiscountDollarTextbox;

	@FindBy(xpath="//a[@id='changeUpdateDiscountMainCash']") //a[@id='changeUpdateDiscountItemCash']
	private WebElement changediscountlink;

	@FindBy(xpath="//a[@id='changeUpdateDiscountItemCash']")
	private WebElement changediscountitemlink;

	@FindBy(xpath="//div[@class='sweet-alert showSweetAlert visible']")
	private WebElement changeDiscountProductLevelPopup;

	@FindBy(xpath="//button[normalize-space()='Yes']")
	private WebElement changeDiscountProductLevelPopupYesButton;

	@FindBy(xpath="//h2[normalize-space()='Are you sure you wish to change discount amount?']")
	private WebElement changeDiscountPopupmessage;

	@FindBy(xpath="//div[@class='sa-icon sa-info']")
	private WebElement changeDiscountPopupicon;

	@FindBy(xpath="//p[contains(text(),'Updating discount at the order level will remove a')]")
	private WebElement changeDiscountPopupUnboldedText;

	@FindBy(xpath="//button[normalize-space()='No']")
	private WebElement changeDiscountPopupNoButton;

	@FindBy(xpath="//button[normalize-space()='Yes']")
	private WebElement changeDiscountPopupYesButton;

	@FindBy(xpath="(//label[contains(text(),'Select Customer')])[1]")
	private WebElement SelectCustomerLabel;
	
	@FindBy(xpath="(//button[@class='btn btn-primary btnAddCustomer'][normalize-space()='Add'])[1]")
	private WebElement AddCustomerButton;
	
	@FindBy(xpath="(//a[@class='QuickInsertItem'])[1]")
	private WebElement flowerstd_leftside_displayedTile_Prod;
	
	// Add New Customer Pop up - web elements
	
	@FindBy(xpath="//h4[@id='AddNewCustomerModalTitle']")
	private WebElement AddNewCustomerPopup;
	
	@FindBy(xpath="//select[@id='ddlCustomershop']")
	private WebElement AddNewCustShopDropdown;
	
	@FindBy(xpath="//input[@id='txtAddCompanyName']")
	private WebElement AddNewCustCompanyNameTextbox;
	
	@FindBy(xpath="(//input[@id='txtAddAddress1'])[1]")
	private WebElement AddNewCustAddress1Textbox;
	
	@FindBy(xpath="(//input[@id='txtAddAddress2'])[1]")
	private WebElement AddNewCustAddress2Textbox;
	
	@FindBy(xpath="//input[@id='txtAddZip']")
	private WebElement AddNewCustZipCodeTextbox;
	
	@FindBy(xpath="//input[@id='txtAddCity']")
	private WebElement AddNewCustCityTextbox;
	
	@FindBy(xpath="//input[@id='txtAddState']")
	private WebElement AddNewCustStateTextbox;
	
	@FindBy(xpath="//input[@id='txtAddCountry']")
	private WebElement AddNewCustCountryTextbox;
	
	@FindBy(xpath="//input[@id='txtAddEmail']")
	private WebElement AddNewCustEmailTextbox;
	
	@FindBy(xpath="//select[@id='ddlAddCustomerType']")
	private WebElement AddNewCustTypeDropdown;
	
	@FindBy(xpath="//input[@id='txtStoretxtAddStoreCreditCredit']")
	private WebElement AddNewCustCreditTextbox;
	
	@FindBy(xpath="//input[@id='txtAddFirstName']")
	private WebElement AddNewCustFirstNameTextbox;
	
	@FindBy(xpath="//input[@id='txtAddLastName']")
	private WebElement AddNewCustLastNameTextbox;
	
	@FindBy(xpath="//input[@id='txtAddPhoneNumber']")
	private WebElement AddNewCustPhoneNumberTextbox;
	
	@FindBy(xpath="//input[@id='txtAddAltPhone']")
	private WebElement AddNewCustAltPhoneNumberTextbox;
	
	@FindBy(xpath="(//div[@class='modal-header customer-modal-header']//a//i)[7]")
	private WebElement AddNewCustPopupCloseIcon;
	
	@FindBy(xpath="(//span[@class='switchery switchery-default'])[6]")
	private WebElement AddNewCustPopupcreditapprovedToogle;
	
	@FindBy(xpath="(//span[@class='switchery switchery-default'])[7]")
	private WebElement AddNewCustPopupPaperlessStatementsToogle;
	
	@FindBy(xpath="(//span[@class='switchery switchery-default'])[8]")
	private WebElement AddNewCustPopupEmailStatementToogle;
	
	@FindBy(xpath="(//span[@class='switchery switchery-default'])[9]")
	private WebElement AddNewCustPopupEnableLoyaltyToogle;
	
	@FindBy(xpath="(//span[@class='switchery switchery-default'])[10]")
	private WebElement AddNewCustPopupLateFeeSettingToogle;
	
	@FindBy(xpath="(//span[@class='switchery switchery-default'])[11]")
	private WebElement AddNewCustPopupAllowSMSToogle;
	
	@FindBy(xpath="(//span[@class='switchery switchery-default'])[12]")
	private WebElement AddNewCustPopupAllowFeedBackEmailToogle;
	
	@FindBy(xpath="//a[@id='btnAddNewCustomer']")
	private WebElement AddNewCustAddNewCustomerButton;
	
	//****** ended - Add New Customer Pop up - web elements *****

	@FindBy(xpath="(//label[contains(text(),'Tax Type')])[1]")
	private WebElement TaxTypeLabel;

	@FindBy(xpath="(//label[contains(text(),'Occasion')])[1]")
	private WebElement OccasionLabel;

	@FindBy(xpath="(//label[contains(text(),'Source Code')])[1]")
	private WebElement SourceCodeLabel;

	@FindBy(xpath="//label[contains(text(),'Discount(%)')]")
	private WebElement DiscountPercentageLabel;

	@FindBy(xpath="//input[@id='txtDiscount']")
	private WebElement Discountpertextbox;

	@FindBy(xpath="(//input[@id='txtDiscountAmount'])[1]")
	private WebElement DiscountAmtTextbox;

	@FindBy(xpath="//input[@id='txtSearchProduct']")
	private WebElement SelectCustomer;
	
	@FindBy(xpath="//ul[@id='ui-id-1']//li//div")
	private List<WebElement> CustomerList_autocomplete_dropdown_Option;
	
	@FindBy(xpath="//ul[@id='ui-id-1']//li//div[contains(text(),'')]")
	private List <WebElement> listOfCustomers;

	@FindBy(xpath="(//button[@class='btn btn-primary btnAddCustomer'][normalize-space()='Add'])[1]")
	private WebElement AddCustomerBtn;

	@FindBy(xpath="//p[@id='lblCustomerIdMain']")
	private WebElement CustomerId;

	@FindBy(xpath="//p[@id='lblCustomerNameMain']")
	private WebElement CustomerName;

	@FindBy(xpath="(//button[@class='btn btn-danger resetCutomerBtn'][normalize-space()='X'])[1]")
	private WebElement cancelcustIcon;

	@FindBy(xpath="//select[@id='ddlTaxType']")
	private WebElement TaxType;

	@FindBy(xpath="//select[@id='ddlOccasion']")
	private WebElement Occasion;

	@FindBy(xpath="//select[@id='productReferral']")
	private WebElement SourceCode;

	@FindBy(xpath="//div[normalize-space()='Sub Total']")
	private WebElement SubTotalLabel;

	@FindBy(xpath="(//div[@class='col-md-6 col-sm-5 col-xs-6 BoldText text-right'])[1]//span")
	private WebElement DefaultSubTotalValues;

	@FindBy(xpath="(//span[@id='lblSubTotal'])[1]")
	private WebElement SubTotal;

	@FindBy(xpath="//div[normalize-space()='GST']")
	private WebElement GSTLabel;

	@FindBy(xpath="(//div[@class='col-md-6 col-sm-5 col-xs-6 BoldText text-right hidetax'])[1]//span")
	private WebElement GSTDefaultValue;

	@FindBy(id="lblGSTTax")
	private WebElement GSTTax;

	@FindBy(xpath="//div[contains(text(),'PST/HST/QST')]")
	private WebElement PSTHSTQSTLabel;

	@FindBy(xpath="(//div[@class='col-md-6 col-sm-5 col-xs-6 BoldText text-right hidetax'])[2]//span")
	private WebElement PSTHSTQSTDefaultValues;

	@FindBy(id="lblPSTTax")
	private WebElement PSTTax;

	@FindBy(xpath="//div[contains(text(),'Tax')]")
	private WebElement TaxLabel;

	@FindBy(xpath="(//div[@class='col-md-6 col-sm-5 col-xs-6 BoldText text-right'])[2]//span")
	private WebElement TaxDefaultValues;

	@FindBy(xpath = "//span[@id='lblTax']")
	private WebElement Tax;

	@FindBy(xpath="(//div[@class='col-md-6 col-sm-7 col-xs-6 BoldText text-right'][normalize-space()='Discount'])[1]")
	private WebElement Discountlabel;

	@FindBy(xpath="(//div[@class='col-md-6 col-sm-5 col-xs-6 BoldText text-right'])[3]//span")
	private WebElement DiscountDefaultValues;

	@FindBy(xpath = "//span[@id='lblDiscount']")
	private WebElement Discount;

	@FindBy(xpath="//div[contains(text(),'Grand Total')]")
	private WebElement GrandTotalLabel;

	@FindBy(xpath="(//div[@class='col-md-6 col-sm-5 col-xs-6 BoldText text-right'])[4]//span")
	private WebElement GrandTotalDefaultValue;

	@FindBy(xpath = "//span[@id='GrandTotal']")
	private WebElement GrandTotal;

	@FindBy(id="lblTotal")
	private WebElement Total;

	@FindBy(xpath="//button[@id='lnkPay']")
	private WebElement PayBtn;

	@FindBy(xpath="//span[@id='lblPay']")
	private WebElement PayBtnText;

	@FindBy(xpath="//div[@class='toast-title']")
	private WebElement ErrorToastMsg;

	@FindBy(xpath="//div[@class='toast-message']")
	private WebElement ErrorToastMsgCloseBtn;

	@FindBy(xpath="//a[@class='QuickInsertItem']//div")
	private List<WebElement> CashAndCarryTile;

	@FindBy(xpath="//div[@class='MyBoxes'][normalize-space()='ballonsYY-Ballons small-$40.00']")
	private WebElement CashAndCarryBalloonTitle;
	
	@FindBy(xpath="//a[@class='QuickInsertItem']")
	private List<WebElement> ListOfProdTiles;

	@FindBy(xpath="//button[@id='btnReconcile']")
	private WebElement ReconcileBtn;

	@FindBy(xpath="(//h3[normalize-space()='Reconcile Cash Draw Balance'])[1]")
	private WebElement ReconcilePopupHeader;
	
	@FindBy(xpath="(//select[@id='ddlClerkReconcile'])[1]")
	private WebElement ClerkReconcileDropDown;
	
	@FindBy(xpath="//select[@id='ddlClerkReconcile']//option")
	private List <WebElement> listOfClerkReconcileDropDown;
	
	@FindBy(xpath="(//select[@id='ddlShopReconcile'])[1]")
	private WebElement ShopReconcileDropDown;
	
	@FindBy(id="lblLastBalanceDate")
	private WebElement lastReconcillationDate;
	
	@FindBy(id="lblOpenBalance")
	private WebElement openBalance;
	
	@FindBy(id="lblExpectedBalance")
	private WebElement expectedBalance;
	
	@FindBy(id="lblActualBalance")
	private WebElement actualBalance;
	
	@FindBy(id="lblDifference")
	private WebElement difference;
	
	@FindBy(xpath="//div[@class='col-md-2 col-sm-6 text-right GreenText']")
	private WebElement differencefieldcolor;
	
	@FindBy(id="lbldatetime")
	private WebElement CashRegisterSalesReview_dateTime;
	
	@FindBy(id="lblCash")
	private WebElement CashRegisterSalesReview_Cash;
	
	@FindBy(id="lblCashTax")
	private WebElement CashRegisterSalesReview_AfterTax;
	
	@FindBy(xpath="(//span[@id='lblTotalSales'])[1]")
	private WebElement CashRegisterSalesReview_TotalSales;
	
	@FindBy(xpath="(//span[@id='lblStartCash'])[1]")
	private WebElement CashRegisterSalesReview_StartCash;
	
	@FindBy(xpath="(//span[@id='lblPaymentAmt'])[1]")
	private WebElement CashRegisterSalesReview_PayoutAmt;
	
	@FindBy(xpath="(//span[@id='lblCashInDrawer'])[1]")
	private WebElement CashRegisterSalesReview_CashInDrawer;
	
	@FindBy(id="txt1Dollars")
	private WebElement oneDollars_denomination;
	
	@FindBy(id="txt2Dollars")
	private WebElement twoDollars_denomination;
	
	@FindBy(id="txt5Dollars")
	private WebElement fiveDollars_denomination;
	
	@FindBy(id="txt20Dollars")
	private WebElement twentyDollars_denomination;
	
	@FindBy(id="txt50Dollars")
	private WebElement fiftyDollars_denomination;
	
	@FindBy(id="txt100Dollars")
	private WebElement oneHundredDollars_denomination;
	
	@FindBy(id="txtPennies")
	private WebElement pennies_denomination;
	
	@FindBy(id="txtNickles")
	private WebElement nickles_denomination;
	
	@FindBy(id="txtDimes")
	private WebElement dimes_denomination;
	
	@FindBy(id="txtQuarters")
	private WebElement quarters_denomination;
	
	@FindBy(xpath="(//button[normalize-space()='Reconcile'])[1]")
	private WebElement ReconcileBtn_ReconcilePopup;
	
	@FindBy(xpath="(//span[@id='lblPaymentAmt'])[1]")
	private WebElement payOutAmt_ReconcilePopup;

	@FindBy(xpath="//button[@id='btnPayOut']")
	private WebElement PayOutBtn;

	@FindBy(xpath="//button[@id='btnSalesHistory']")
	private WebElement SalesHistoryBtn;

	@FindBy(xpath="//button[@id='btnOpenCashDrawer']")
	private WebElement OpenCashDrawerBtn;
	
	@FindBy(xpath="(//div[@class='modal-content'])[6]")
	private WebElement verifyPasswordPopup;
	
	@FindBy(xpath="(//h3[normalize-space()='Verify Password'])[1]")
	private WebElement VerifyPasswordPopupHeader;
	
	@FindBy(xpath="(//input[@id='txtCCPassword'])[1]")
	private WebElement VerifyPasswordTextbox;
	
	@FindBy(xpath="(//button[normalize-space()='Verify'])[1]")
	private WebElement verifyBtn_PasswordPopup;
	
	@FindBy(xpath="(//h3[normalize-space()='Cash Draw Payout'])[1]")
	private WebElement CashDrawPopupHeader;
	
	@FindBy(xpath="(//select[@id='ddlShopPayout'])[1]")
	private WebElement ShopPayoutDropDown;
	
	@FindBy(xpath="(//select[@id='ddlClerkPayout'])[1]")
	private WebElement ClerkPayoutDropDown;
	
	@FindBy(xpath="//select[@id='ddlClerkPayout']//option")
	private List <WebElement> ClerkPayoutDropDownList; 
	
	@FindBy(xpath="(//input[@id='txtNamePayout'])[1]")
	private WebElement NamePayoutTextBox;
	
	@FindBy(xpath="(//textarea[@id='txtReasonPayout'])[1]")
	private WebElement ReasonPayoutTextBox;
	
	@FindBy(xpath="(//input[@id='txtSubTotalPayout'])[1]")
	private WebElement SubTotalPayoutTextBox;
	
	@FindBy(xpath="(//input[@id='txtTaxAmountPayout'])[1]")
	private WebElement TaxAmountPayoutTextBox;
	
	@FindBy(xpath="(//input[@id='txtAmountPayout'])[1]")
	private WebElement GrandTotalPayoutTextBox;
	
	@FindBy(xpath="//div[@class='col-md-1 text-right']//a/i")
	private WebElement CloseiconCashDrawPopup;
	
	@FindBy(xpath="(//button[@id='btnSavePayout'])[1]")
	private WebElement SavePayoutBtn;

	

	@FindBy(xpath="//span[contains(text(),'Press')]")
	private WebElement PressAltPtocontinuetopaymentpageText;

	@FindBy(xpath="(//span[@class='switchery switchery-default'])[1]")
	private WebElement SplitPaymentToogleButton;

	@FindBy(xpath="(//span[@class='fa fa-clone fa-2x'])[1]")
	private WebElement chooseDefaultValuesIcon;

	@FindBy(xpath="(//h3[normalize-space()='Choose Page Default Values'])[1]")
	private WebElement choosepagedefaultvaluespopupHeader;

	@FindBy(xpath="//select[@id='ddlSalesPerson']")
	private WebElement salespersondd;

	@FindBy(xpath="//select[@id='ddlDefaultOccasion']")
	private WebElement defaultoccasiondd;

	@FindBy(xpath="//select[@id='ddlSourceCode']")
	private WebElement sourcecodedd;

	@FindBy(xpath="//button[@id='btnUpdate']")
	private WebElement updateBtn;

	/*
	@Param - Gift Card Section
	@Author - Balaji
	@Date - 06/06/2024
	 */

	@FindBy(xpath="//a[@class='btnShowGiftPopUp']//div[@class='MyBoxes']")
	private WebElement GiftCardTile;

	@FindBy(xpath="//h3[contains(text(),'Gift Card Sale')]")
	private WebElement GiftCardSalePopup;

	@FindBy(xpath="//div[@id='divGiftCardPrice']//button")
	private List<WebElement> GiftCardPriceListButton;

	@FindBy(xpath="(//div[@id='divGiftCardPrice']//button)[11]")
	private WebElement GiftCardPriceListEditButton;

	@FindBy(xpath="//input[@id='txtGiftCardAmount']")
	private WebElement GiftCardAmountTextBox;

	@FindBy(xpath="//input[@id='txtGiftCardProcessingFee']")
	private WebElement ProcessingFeeTextBox;

	@FindBy(xpath="//input[@id='txtGiftCardCardNumber']")
	private WebElement GiftCardNumberTextBox;

	@FindBy(xpath="//input[@id='txtCustomerNameForGiftCard']")
	private WebElement CustomerNameTextBox;

	@FindBy(xpath="//input[@id='txtGiftCardTotal']")
	private WebElement GiftCardTotalPriceTextBox;

	@FindBy(xpath="(//button[contains(text(),'Submit')])[1]")
	private WebElement GiftCardSubmitButton;

	@FindBy(xpath="(//div[@class='modal-header']//a//i)[7]")
	private WebElement CloseGiftCardPopup;	
	
	@FindBy(xpath="//button[@id='btnUpdateGiftPriceValues']")
	private WebElement EditButtonOnGiftCardPopup;
	
	@FindBy(xpath="//h3[@id='GiftCardCreateModalTitle']")
	private WebElement EditGiftCardDominationPopup;
	
	@FindBy(xpath="//div[@id='divGiftCardPrice']//button[1]")
	private WebElement giftcarddenominationprice1;

	@FindBy(xpath="//div[@id='divGiftCardPrice']//button[2]")
	private WebElement giftcarddenominationprice2;
	
	@FindBy(xpath="//div[@id='divGiftCardPrice']//button[3]")
	private WebElement giftcarddenominationprice3;
	
	@FindBy(xpath="//div[@id='divGiftCardPrice']//button[4]")
	private WebElement giftcarddenominationprice4;
	
	@FindBy(xpath="//div[@id='divGiftCardPrice']//button[5]")
	private WebElement giftcarddenominationprice5;
	
	@FindBy(xpath="//div[@id='divGiftCardPrice']//button[6]")
	private WebElement giftcarddenominationprice6;
	
	@FindBy(xpath="//div[@id='divGiftCardPrice']//button[7]")
	private WebElement giftcarddenominationprice7;
	
	@FindBy(xpath="//div[@id='divGiftCardPrice']//button[8]")
	private WebElement giftcarddenominationprice8;
	
	@FindBy(xpath="//div[@id='divGiftCardPrice']//button[9]")
	private WebElement giftcarddenominationprice9;
	
	@FindBy(xpath="//div[@id='divGiftCardPrice']//button[10]")
	private WebElement giftcarddenominationprice10;
	
	
	/*
	@Param - Edit Gift Card Denominations
	@Author - Balaji
	@Date - 06/06/2024
	 */

	@FindBy(xpath="//input[@id='txtD1']") // txtD2, txtD3 similarly for other denominations textbox
	private WebElement EditGiftCardDenomination1TextBox;
	
	@FindBy(xpath="//input[@id='txtD2']")
	private WebElement EditGiftCardDenomination2TextBox;
	
	@FindBy(xpath="//input[@id='txtD3']")
	private WebElement EditGiftCardDenomination3TextBox;
	
	@FindBy(xpath="//input[@id='txtD4']")
	private WebElement EditGiftCardDenomination4TextBox;
	
	@FindBy(xpath="//input[@id='txtD5']")
	private WebElement EditGiftCardDenomination5TextBox;

	@FindBy(xpath="//input[@id='txtD6']")
	private WebElement EditGiftCardDenomination6TextBox;
	
	@FindBy(xpath="//input[@id='txtD7']")
	private WebElement EditGiftCardDenomination7TextBox;
	
	@FindBy(xpath="//input[@id='txtD8']")
	private WebElement EditGiftCardDenomination8TextBox;
	
	@FindBy(xpath="//input[@id='txtD9']")
	private WebElement EditGiftCardDenomination9TextBox;
	
	@FindBy(xpath="//input[@id='txtD10']")
	private WebElement EditGiftCardDenomination10TextBox;

	@FindBy(xpath="//button[@id='btnSaveGiftCardPrice']")
	private WebElement EditGiftCardDenominationSaveButton;

	@FindBy(xpath="(//button[contains(text(),'Cancel')])[2]")
	private WebElement EditGiftCardDenominationCancelButton;

	@FindBy(xpath="(//i[@data-dismiss='modal'])[8]")
	private WebElement CloseEditGiftCardDominationPopup;

	/*
	 * @Param - Cash And Carry Page walkins setting & Their pop up sections
	 * @Author - Balaji
	 * @Date - 06/06/2024	
	 */

	@FindBy(xpath="//a[@title='WalkIns Settings']")
	private WebElement CashAndCarryPageWalkinsSettingIcon;

	@FindBy(xpath="//h3[normalize-space()='Walkin Settings']")
	private WebElement  WalkinsSettingPopup;

	@FindBy(xpath="(//i[@class='fa fa-2x fa-times-circle modal-action-container-close-icon hana-drawer-container-close close no-padding hana-initialized'])[1]")
	private WebElement  WalkinsSettingPopupCloseIcon;

	@FindBy(xpath="//select[@id='ddlShopForWalkinsSettings']")
	private WebElement  WalkinsSettingPopupShopDropDown;

	@FindBy(xpath="//button[@id='btnAddNewWalkin']")
	private WebElement  WalkinsSettingPopupAddNewBtn;

	@FindBy(xpath="//h3[normalize-space()='Walkin Settings']")
	private WebElement  WalkinsSettingAddNewPopupScreen;

	@FindBy(xpath="//label[normalize-space()='Clerk Id']")
	private WebElement ClerkIdLabel;

	@FindBy(id="txtClerkID")
	private WebElement ClerkIDTextBox;

	@FindBy(xpath="//label[normalize-space()='Clerk Description']")
	private WebElement ClerkDescLabel;

	@FindBy(id="txtClerkDesc")
	private WebElement ClerkDescTextBox;

	@FindBy(xpath="//label[normalize-space()='Printer Name']")
	private WebElement PrinterNameLabel;

	@FindBy(id="txtPrinterName")
	private WebElement PrinterNameTextBox;

	@FindBy(xpath="//label[normalize-space()='Manufacturer']")
	private WebElement ManufacturerLabel;

	@FindBy(id="ddlManufacturer")
	private WebElement ManufacturerDropDown; //  Epson 

	@FindBy(xpath="//label[normalize-space()='Model']")
	private WebElement ModelLabel;

	@FindBy(id="ddlModel")
	private WebElement ModelDropDown; //  LX-300+

	@FindBy(xpath="//label[normalize-space()='Cash Draw Code']")
	private WebElement CashDrawCodeLabel;

	@FindBy(id="txtCashDrawCode")
	private WebElement CashDrawCodeTextBox;

	@FindBy(xpath="//label[normalize-space()='Printer Cut Code']")
	private WebElement PrinterCutCodeLabel;

	@FindBy(id="txtPrinterCutCode")
	private WebElement PrinterCutCodeTextBox;

	@FindBy(xpath="//label[normalize-space()='Clearent API Key']")
	private WebElement ClearantAPIKeyLabel;

	@FindBy(id="txtAPIKey")
	private WebElement APIKeyTextBox;

	@FindBy(xpath="//label[normalize-space()='Clover Device Id']")
	private WebElement CloverDeviceIDLabel;

	@FindBy(xpath="//input[@id='txtCloverDeviceId']")
	private WebElement CloverDeviceIDTextBox;

	@FindBy(xpath="//label[normalize-space()='Clover Cash Drawer Id']")
	private WebElement CloverCashDrawerIdLabel;

	@FindBy(xpath="//div[@class='input-group-addon']")
	private WebElement CloverCashDrawerIdSearchIcon;

	@FindBy(xpath="//label[normalize-space()='Enable Clover Printer']")
	private WebElement EnableCloverPrinterLabel;

	@FindBy(xpath="//input[@id='chkEnableCloverPrinter']")
	private WebElement EnableCloverPrinterCheckBox;

	@FindBy(xpath="//label[normalize-space()='OpenEdge Web ID']")
	private WebElement OpenEdgeWebIDLabel;

	@FindBy(xpath="//input[@id='txtWebID']")
	private WebElement OpenEdgeWebIDTextBox;

	@FindBy(xpath="//label[normalize-space()='OpenEdge Terminal ID']")
	private WebElement OpenEdgeTerminalIDLabel;

	@FindBy(xpath="//input[@id='txtTerminalID']")
	private WebElement OpenEdgeTerminalIDTextBox;

	@FindBy(xpath="//label[normalize-space()='OpenEdge AuthKey']")
	private WebElement OpenEdgeAuthKeyLabel;

	@FindBy(xpath="//input[@id='txtAuthKey']")
	private WebElement OpenEdgeAuthKeyTextBox;

	@FindBy(xpath="//label[normalize-space()='Customer Copy']")
	private WebElement OpenEdgeCustomerCopyLabel;

	@FindBy(xpath="//input[@id='chkCustomerCopy']")
	private WebElement OpenEdgeCustomerCopyCheckBox;

	@FindBy(xpath="//label[normalize-space()='Merchant Copy']")
	private WebElement OpenEdgeMerchantCopyLabel;

	@FindBy(xpath="//input[@id='chkMerchantCopy']")
	private WebElement OpenEdgeMerchantCopyCheckBox;

	@FindBy(xpath="//label[normalize-space()='Enable OpenEdge Printer']")
	private WebElement EnableOpenEdgePrinterLabel;

	@FindBy(xpath="//label[normalize-space()='Customer Copy Note']")
	private WebElement CustomerCopyNoteLabel;

	@FindBy(xpath="//textarea[@id='txtwalkingdescription']")
	private WebElement CustomerCopyNoteTextBox;

	@FindBy(xpath="//label[normalize-space()='Merchant Copy Note']")
	private WebElement MerchantCopyNoteLabel;

	@FindBy(xpath="//textarea[@id='txtwalkingMerchantdescription']")
	private WebElement MerchantCopyNoteTextBox;

	@FindBy(xpath="//button[@id='btnSaveWalkIn']")
	private WebElement SaveWalkInSettingButton;

	@FindBy(xpath="//div[@class='toast-message']") //WalkIns Settings saved successfully
	private WebElement successToastMessageOnAddNewWalkInSetting;

	@FindBy(xpath="(//td[contains(text(),'1')])[5]")
	private WebElement NewlyCreatedClerkIdWalkInSetting;

	@FindBy(xpath="(//td[contains(text(),'Automation Clerk description')]/following-sibling::td//a[@id='btnEditWalkInSetting'])[1]")
	private WebElement Automation_Clerk_description_NewlyCreatedEditWalkInSettingButton;

	@FindBy(xpath="(//a[@class='m-r-50 CashRegisterInactive'])[1]")
	private WebElement NewlyCreatedDeleteWalkInSettingButton;

	@FindBy(xpath="//button[@id='btnBackToIntialWalkin']")
	private WebElement CancelWalkInSettingButton;	

	@FindBy(xpath="//table[@class='table table-responsive table-striped']//tbody[1]//tr//td[3]")
	private List<WebElement> listOfPrinterName; 

	@FindBy(xpath="(//i[@data-dismiss='modal'])[5]")
	private WebElement WalkingSettingPopupCloseIcon;

	@FindBy(xpath="//table[@id='tblProducts']//tbody//tr")
	private List<WebElement> listoftablerows;

	@FindBy(xpath="//label[@id='lblItemCode_1']")
	private WebElement AddedItemCodecol1;
	
	@FindBy(xpath="//label[@id='lblItemCode_2']")
	private WebElement AddedItemCodeRow2;

	@FindBy(xpath="//label[@id='lblItemDesc_1']")
	private WebElement AddedItemDescriptioncol1;
	
	@FindBy(xpath="//label[@id='lblQty_1']")
	private WebElement AddedItemQuantitycol1;
	
	@FindBy(xpath="//label[@id='lblItemPrice_1']")
	private WebElement AddedItemPricecol1;
	
	@FindBy(xpath="//span[@id='lblExtPrice_1']")
	private WebElement AddedItemExtendedPricecol1;
	
	@FindBy(xpath="//label[@id='lblDicountAmt_1']")
	private WebElement AddedItemDiscountAmountcol1;
	
	@FindBy(xpath="//label[@id='lblDicountPer_1']")
	private WebElement AddedItemDiscountPercentagecol1;
	
	@FindBy(xpath="//h4[@id='AddNewCustomerModalTitle']")
	private WebElement AddNewCustomerTitle;

	@FindBy(xpath="(//i[@class='fa fa-2x fa-times-circle modal-action-container-close-icon hana-drawer-container-close close'])[6]")
	private WebElement AddNewCustomerCloseIcon;

	@FindBy(xpath="(//a[@Class='close text-right no-padding'])[1]")
	private WebElement WalkingSettingPopupCloseIcon1;

	@FindBy(xpath="//a[@id='btnEditWalkInSetting']")
	private List<WebElement> EditWalkInSettingButton;	
	
	@FindBy(xpath="//td[contains(text(),'Hana Testing Description')]/following-sibling::td//a[@id='btnEditWalkInSetting']")
	private WebElement Hana_Testing_DescriptionEditWalkInSettingButton1;
	
	@FindBy(xpath="//td[contains(text(),'Automation_Don')]/following-sibling::td//a[@id='btnEditWalkInSetting']")
	private WebElement Automation_DontDeletetEditWalkInSettingButton;
	
	@FindBy(xpath="//td[contains(text(),'Automation')]/following-sibling::td//a[@id='btnEditWalkInSetting']")
	private WebElement AutomationEditWalkInSettingButton1;
	
	@FindBy(xpath="//td[contains(text(),'Automation Clerk Desc')]/following-sibling::td//a[@id='btnEditWalkInSetting']")
	private WebElement Automation_Clerk_DescEditWalkInSettingButton;
	//Cash Register unchecked FT
	@FindBy(xpath="//td[contains(text(),'Cash Register unchecked FT')]/following-sibling::td//a[@id='btnEditWalkInSetting']")
	private WebElement CashRegisterUncheckedFTEditWalkInSettingButton;
	
	@FindBy(xpath="//td[contains(text(),'Cash Register2')]/following-sibling::td//a[@id='btnEditWalkInSetting']")
	private WebElement CashRegister2EditWalkInSettingButton1;

	@FindBy(xpath="//a[@class='m-r-50 CashRegisterInactive']")
	private List<WebElement> deleteWalkInSettingButton;
	
	@FindBy(xpath="//td[contains(text(),'Automation')]/following-sibling::td//a[@class='m-r-50 CashRegisterInactive']")
	private WebElement AutomationdeleteWalkInSettingButton1;
	
	@FindBy(xpath="//h2[normalize-space()='Confirmation']")
	private WebElement DeleteConfirmationPopUpInWalkinSetting;
	
	@FindBy(xpath="//p[contains(text(),'Are you sure you wish to remove this cash register')]")
	private WebElement AreYouSureYouWishToWalkinSettingText;
	
	@FindBy(xpath="//input[@placeholder='Confirmation code']")
	private WebElement ConfirmationCodeTextBox;
	
	@FindBy(xpath="//button[@class='cancel']")
	private WebElement CancelButtonInDeleteConfirmationPopUp;
	
	@FindBy(xpath="//button[normalize-space()='OK']")
	private WebElement OKButtonInDeleteConfirmationPopUp;
	
	@FindBy(xpath="//p[normalize-space()='Incorrect confirmation code!']")
	private WebElement IncorrectConfirmationCodeText;
	
	@FindBy(xpath="(//div[@class='sa-input-error show'])[1]")
	private WebElement IncorrectDeleteConfirmationCodeErrorIcon;
	
	@FindBy(xpath="((//table[@class='table table-responsive table-striped'])[2]//tr[1]//td[1])[1]")
	private WebElement WalkingSettingPopUpShopSiNo;

	@FindBy(xpath="((//table[@class='table table-responsive table-striped'])[2]//tr[1]//td[2])[1]")
	private WebElement WalkingSettingPopUpShopClerkId;

	@FindBy(xpath="((//table[@class='table table-responsive table-striped'])[2]//tr[1]//td[3])[1]")
	private WebElement WalkingSettingPopUpShopPrinterName;

	@FindBy(xpath="((//table[@class='table table-responsive table-striped'])[2]//tr[1]//td[4])[1]")
	private WebElement WalkingSettingPopUpShopCashDrawCode;

	@FindBy(xpath="((//table[@class='table table-responsive table-striped'])[2]//tr[1]//td[5])[1]")
	private WebElement WalkingSettingPopUpShopPrinterCutCode;

	@FindBy(xpath="((//table[@class='table table-responsive table-striped'])[2]//tr[1]//td[6])[1]")
	private WebElement WalkingSettingPopUpShopClerkDesc;

	@FindBy(xpath="((//table[@class='table table-responsive table-striped'])[2]//tr[1]//td[7])[1]")
	private WebElement WalkingSettingPopUpShopCustCopy;

	@FindBy(xpath="((//table[@class='table table-responsive table-striped'])[2]//tr[1]//td[8])[1]")
	private WebElement WalkingSettingPopUpShopAction;

	@FindBy(xpath="(//a[@class='close text-right no-padding'])[1]")
	private WebElement AddNewWalkInSettingPopupCloseIcon;

	// Choose page default values web elements
	@FindBy(xpath="//select[@id='ddlShopShopDefaultNew']")
	private WebElement ShopChooseDefaultValuesDD;
	
	@FindBy(xpath="//select[@id='ddlPagename']")
	private WebElement PageNameChooseDefaultValuesDD;
	
	@FindBy(xpath="(//input[@id='txtBankName'])[2]")
	private WebElement BankNameTextBoxChooseDefaultValues;
	
	@FindBy(xpath="//input[@id='txtCheckNo']")
	private WebElement CheckNoTextBoxChooseDefaultValues;
	
	@FindBy(xpath="(//input[@id='txtNameOnCheck'])[2]")
	private WebElement NameOnCheckTextBoxChooseDefaultValues;
	
	@FindBy(xpath="//div[@class='form-group']//input[@id='txtQty']")
	private WebElement QuantityTextBoxChooseDefaultValues;
	
	@FindBy(xpath="(//select[@id='ddlDefaultOccasion'])[1]")
	private WebElement DefaultOccasionDD;
	
	@FindBy(xpath="(//select[@id='ddlSalesPerson'])[1]")
	private WebElement SalesPersonDefaultValuesDD;
	
	@FindBy(xpath="(//select[@id='ddlSourceCode'])[1]")
	private WebElement SourceCodeDefaultValuesDD;
	
	@FindBy(xpath="//button[@id='btnUpdate']")
	private WebElement ChooseDefaultUpdateButton;
	
	@FindBy(xpath="(//div[@class='modal-header']//a//i)[1]")
	private WebElement CloseIconOnChooseDefaultValuesPopup;
	
	@FindBy(xpath="(//input[@id='txtItemCode'])[2]")
	private WebElement ItemCodeTextBoxChooseDefaultValues;
	
	@FindBy(xpath="(//input[@id='txtQty1'])[1]")
	private WebElement PhoneOrderQTYTextBoxChooseDefaultValues;
	
	@FindBy(xpath="(//input[@id='txtRecipientPhone'])[1]")
	private WebElement PhoneOrderRecipientPhoneTextBoxChooseDefaultValues;
	
	@FindBy(xpath="(//input[@id='txtRecipientZipcode'])[1]")
	private WebElement PhoneOrderRecipientZipcodeTextBoxChooseDefaultValues;
	
	@FindBy(xpath="(//select[@id='ddlDefaultWireInMethod'])[1]")
	private WebElement PhoneOrderWireInMethodDefaultValuesDD;
	
	@FindBy(xpath="(//select[@id='ddlDefaultWireOutMethod'])[1]")
	private WebElement PhoneOrderWireOutMethodDefaultValuesDD;
	
	@FindBy(xpath="(//select[@id='ddlPaymentType'])[1]")
	private WebElement PhoneOrderPaymentTypeDefaultValuesDD;
	
	@FindBy(xpath="(//select[@id='ddlPhoneOrderCustomerType'])[1]")
	private WebElement PhoneOrderCustomerTypeDefaultValuesDD;
	
	@FindBy(xpath="(//select[@id='ddlSalesPerson'])[1]")
	private WebElement PhoneOrderSalesPersonDefaultValuesDD;
	
	@FindBy(xpath="(//select[@id='ddlSelectCountry'])[1]")
	private WebElement PhoneOrderSelectCountryDefaultValuesDD;
	
	@FindBy(xpath="(//select[@id='ddlSelectLocation'])[1]")
	private WebElement PhoneOrderSelectLocationDefaultValuesDD;
	
	@FindBy(xpath="(//select[@id='ddlSelectOccasion'])[1]")
	private WebElement PhoneOrderSelectOccasionDefaultValuesDD;
	
	@FindBy(xpath="(//select[@id='ddlSelectOrderType'])[1]")
	private WebElement PhoneOrderSelectOrderTypeDefaultValuesDD;
	
	@FindBy(xpath="(//div[@class='modal-content']//div//a//i)[1]")
	private WebElement CloseIconOnChooseDefaultValuesPagePopup;
	
	@FindBy(xpath="(//button[@id='btnUpdate'])[1]")
	private WebElement ChooseDefaultValuesUpdateButton;
	
	/*
	@Param - Cash And Carry Page Action methods implementations
	@Author - Balaji 
	 */
	public boolean VerifyCashAndCarryPage() {
		HighlightElement(CashAndCarryPage);
		return CashAndCarryPage.isDisplayed();
	}

	public boolean shopnamedropdownIsDisplayed() {
		HighlightElement(ShopNameDropDown);
		return ShopNameDropDown.isDisplayed();
	}

	public String getShopNameSelectedOption() {
		select = new Select(ShopNameDropDown);
		String shopname = select.getFirstSelectedOption().getText();
		return shopname;
	}
	
	public boolean clerkdropdownIsDisplayed() {
		HighlightElement(ClerkDropDown);
		return ClerkDropDown.isDisplayed();
	}

	public boolean employeedropdownIsDisplayed() {
		HighlightElement(EmployeeDropDown);
		return EmployeeDropDown.isDisplayed();
	}

	public CashAndCarryPage SelectShopName(String shopname) {
		fluentWait(ShopNameDropDown);
		dropDown(ShopNameDropDown, shopname, "VisibleText");
		return this;
	}

	public CashAndCarryPage SelectClerkName(String clerk) {
		fluentWait(ClerkDropDown);
		dropDown(ClerkDropDown, clerk, "VisibleText");
		return this;
	}

	public CashAndCarryPage SelectEmployeeName(String employee) {
		dropDown(EmployeeDropDown, employee, "VisibleText");
		return this;
	}

	public boolean GiftCardAndTilesIsDisplayed() {
		for (int i = 0; i<CashAndCarryTile.size(); i++) {
			HighlightElement(CashAndCarryTile.get(i));
			CashAndCarryTile.get(i).isDisplayed();
		}
		return true;
	}

	public CashAndCarryPage EnterItemCode(String itemcode) {
		clickAndType(ItemCode, itemcode);
		return this;
	}						

	public CashAndCarryPage EnterItemDescription(String description) {
		clickAndType(ItemDescription, description);
		return this;
	}

	public CashAndCarryPage EnterItemQuantity(String qty) {
		jsClearAndType(ItemQuantity, qty);
		return this;
	}

	public CashAndCarryPage EnterItemPrice(String price) {
		//clickAndType(ItemPrice, price);
		jsClearAndType(ItemPrice, price);
		return this;
	}

	public double getDiscountAmtBasedonPercentage() {
		Actions actions = new Actions(getDriver());
		delayWithGivenTime(4000);
		// Perform Shift + Tab key press
		actions.keyDown(Keys.SHIFT)
		.sendKeys(Keys.TAB)
		.keyUp(Keys.SHIFT)
		.perform();

		delayWithGivenTime(4000);
		double originalPrice = Double.parseDouble(ItemPrice.getAttribute("value"));     
		double discountPercentage = Double.parseDouble(ItemDiscountPercentage.getAttribute("value"));

		double expectedDiscountAmount = (originalPrice * discountPercentage) / 100;
		return expectedDiscountAmount;

	}


	public double getDiscountAmt() {
		Actions actions = new Actions(getDriver());
		delayWithGivenTime(4000);
		// Perform Shift + Tab key press
		actions.keyDown(Keys.SHIFT)
		.sendKeys(Keys.TAB)
		.keyUp(Keys.SHIFT)
		.perform();

		delayWithGivenTime(4000);
		double discountAmount = Double.parseDouble(ItemDiscount.getAttribute("value"));
		System.out.println("Discount Amount: " + discountAmount);
		return discountAmount;
	}

	public CashAndCarryPage EnterItemDiscount(String discount) {
		jsClearAndType(ItemDiscount, discount);
		return this;
	}


	public CashAndCarryPage ClickAddItem() {
		jsScrollClick(AddItemBtn);
		return this;
	}

	public CashAndCarryPage EnterDiscountPercentageOnAddItem(String discount_Percentage) {	
		ItemDiscountPercentage.sendKeys(discount_Percentage);
		delayWithGivenTime(2000);
		ItemDiscount.click();		
		return this;
	}
	
	public CashAndCarryPage EnterDiscountAmountOnAddItem(String discount_Amount) {
		ItemDiscount.sendKeys(discount_Amount);
		delayWithGivenTime(2000);
		ItemDiscountPercentage.click();		
		return this;
	}

	public String getDiscountPercentageOnDiscIsAddedByDiscAmtField() {
		return ItemDiscountPercentage.getAttribute("value");
	}
	
	public String getDiscountAmtOnDiscIsAddedByDiscPerAddItem() {
		return ItemDiscount.getAttribute("value");
	}
	
	public boolean VerifyAddedItem() {
		HighlightElement(AddedItemTableRow1);
		return AddedItemTableRow1.isDisplayed();
	}

	public boolean IsToastErrorMessageDisplayed() {
		HighlightElement(toasterrormsg);
		return toasterrormsg.isDisplayed();
	}

	public CashAndCarryPage EnterCustomerName(String customershorttext) {
		SelectCustomer.clear();
		clickAndType(SelectCustomer,customershorttext); //"abish"
		delayWithGivenTime(3000);
		for(WebElement cust : CustomerList_autocomplete_dropdown_Option) {
			if(cust.getText().equals(prop.getProperty("customername"))) {
				jsClick(cust);
				break;
			}
		}
		return this;
	}
	
	public CashAndCarryPage EnterCustomerName(String customershorttext, String customername) {
		SelectCustomer.clear();
		clickAndType(SelectCustomer,customershorttext); //"abish"
		delayWithGivenTime(3000);
		for(WebElement cust : CustomerList_autocomplete_dropdown_Option) {
			if(cust.getText().contains(customername)) {
				click(cust);
				break;
			}
		}
		return this;
	}

	public CashAndCarryPage EnterNewCustomerName() {
		SelectCustomer.sendKeys("");
		delayWithGivenTime(2000);
		getDriver().findElement(By.xpath("//ul[@id='ui-id-1']//li//div[contains(text(),'" + get_NewlyCreated_CustomerId() + "')]")).click();
		return this;
	}
	
	public CashAndCarryPage SelectTaxType(String taxtype) {
		dropDown(TaxType,taxtype , "VisibleText"); //"Tax Exemption"
		return this;
	}
	
	public String get_selected_tax_type() {
		select = new Select(TaxType);
		return (select.getFirstSelectedOption().getText());
	}

	public CashAndCarryPage SelectOccasion(String occasion) {
		dropDown(Occasion, occasion , "VisibleText"); //"Birthday"
		return this;
	}

	public CashAndCarryPage SelectSourceCode(String sourcecode) {
		dropDown(SourceCode,sourcecode , "VisibleText"); //"Friend"
		return this;
	}

	public double getSubTotalPrice() {
		String subtotal = SubTotal.getText();
		System.out.println("Subtotal is : " +subtotal);
		String sub_total = subtotal.replaceAll("[^a-zA-Z0-9]", "");
		double Sub_Total =	Double.parseDouble(sub_total);
		return Sub_Total;
	}

	public CashAndCarryPaymentPage ClickPayButton() {
		jsClick(PayBtn);
		return new CashAndCarryPaymentPage();
	}

	public boolean verifyErrorToastMsg() {
		HighlightElement(ErrorToastMsg);
		return ErrorToastMsg.isDisplayed();
	}

	public CashAndCarryPage closeErrorToastMsg() {
		click(ErrorToastMsgCloseBtn);	
		return this;
	}

	public boolean ItemEntryLabels() {
		HighlightElement(ItemCodeLabel);
		ItemCodeLabel.isDisplayed();
		HighlightElement(ItemDescriptionLabel);
		ItemDescriptionLabel.isDisplayed();
		HighlightElement(ItemQuantityLabel);
		ItemQuantityLabel.isDisplayed();
		HighlightElement(ItemPriceLabel);
		ItemPriceLabel.isDisplayed();
		HighlightElement(ItemDiscountLabel);
		ItemDiscountLabel.isDisplayed();
		HighlightElement(ItemDiscountPercentageLabel);
		ItemDiscountPercentageLabel.isDisplayed();
		HighlightElement(ActionLabel);
		ActionLabel.isDisplayed();
		return true;
	}

	public String  ItemCodePlaceholder() {
		HighlightElement(ItemCode);
		return 	ItemCode.getAttribute("placeholder");
	}

	public void SearchAndSelectTheItemCode(String itemcode) {
		HighlightElement(ItemCode);
		ItemCode.clear();
		DoubleClickAndType(ItemCode,itemcode);
		delayWithGivenTime(3000);
		
		for(WebElement ele:itemcodelist) {	
			if(ele.getText().contains("rrd-Red Rose Deluxe")) {
				jsClick(ele);
				break;
			}
		}

	}

	public void SearchAndSelect_ItemCode(String itemcode, String itemdescription) {
		HighlightElement(ItemCode);
		DoubleClickAndType(ItemCode,itemcode);
		delayWithGivenTime(3000);

		for(WebElement ele:itemcodelist) {
			if(ele.getText().contains(itemdescription)) {
				jsClick(ele);
				break;
			}
			
		}
	
	}
	
	public void searchAndselectWithItemDescription(String itemdescription) {
		clickAndType(ItemDescription,itemdescription);//"premium"
		delayWithGivenTime(2500);

		for(int i=0;i<ItemDescList.size();i++) {
			if(ItemDescList.get(i).getText().equals("RDWB-Premium Red Roses Double Wrapped Bouquet -40")) {
				jsClick(ItemDescList.get(i));
				break;
			}
		}
	}

	public String ItemCodeValueIsExists() {
		HighlightElement(ItemCode);
		delayWithGivenTime(500);
		return ItemCode.getAttribute("value");
	}

	public String ItemDescription() {
		HighlightElement(ItemDescription);
		return ItemDescription.getAttribute("placeholder");
	}

	public String ItemDescriptionValueIsExist() {
		HighlightElement(ItemDescription);
		return ItemDescription.getAttribute("value");
	}

	public String ItemQtyValueIsExist() {		
		HighlightElement(ItemQuantity);
		return ItemQuantity.getAttribute("value");
	}

	public String ItemQtyPlaceholder() {
		HighlightElement(ItemQuantity);
		return ItemQuantity.getAttribute("placeholder");
	}

	public String ItemPricePlaceholder() {
		HighlightElement(ItemPrice);
		return ItemPrice.getAttribute("placeholder");
	}

	public String ItemPriceValueIsExist() {
		HighlightElement(ItemPrice);
		return ItemPrice.getAttribute("value");
	}

	public String ItemDiscountPlaceholder() {
		HighlightElement(ItemDiscount);
		return ItemDiscount.getAttribute("placeholder");
	}

	public String ItemDiscountAmountIsExist() {	
		HighlightElement(ItemDiscount);
		return ItemDiscount.getAttribute("value");
	}

	public String ItemDiscountPercentagePlaceholder() {
		HighlightElement(ItemDiscountPercentage);
		return ItemDiscountPercentage.getAttribute("placeholder");
	}

	public String ItemDiscountPercentageValueIsExist() {
		HighlightElement(ItemDiscountPercentage);
		return ItemDiscountPercentage.getAttribute("value");
	}

	public void SearchAndSelectProdByItemDescription(String itemdescription) {
		HighlightElement(ItemDescription); //"premium"
		clickAndType(ItemDescription,itemdescription);
		delayWithGivenTime(3000);

		for(int i=0;i<ItemDescList.size();i++) {
			if(ItemDescList.get(i).getText().equals("RDWB-Premium Red Roses Double Wrapped Bouquet -40")) {
				ItemDescList.get(i).click();
				break;
			}
		}
	}



	public boolean CouponLabel() {
		HighlightElement(CouponLabel);
		return CouponLabel.isDisplayed();
	}

	public boolean DiscountLabel() {
		HighlightElement(DiscountLabel);
		return DiscountLabel.isDisplayed();
	}

	public boolean DiscountDollarLabel() {
		HighlightElement(DiscountDollarLabel);
		return DiscountDollarLabel.isDisplayed();
	}

	public boolean SelectCustomerLabel() {
		HighlightElement(SelectCustomerLabel);
		return SelectCustomerLabel.isDisplayed();	 
	}

	public boolean TaxtypeLabel() {
		HighlightElement(TaxTypeLabel);
		return TaxTypeLabel.isDisplayed();
	}

	public boolean occasionLabel() {
		HighlightElement(OccasionLabel);
		return OccasionLabel.isDisplayed();
	}

	public void sourceCodeLabel() {
		HighlightElement(SourceCodeLabel);
		SourceCodeLabel.isDisplayed();
	}

	public void EnterCouponCode(String couponcode) {
		DoubleClickAndType(CouponCodeTextbox, couponcode);
		delayWithGivenTime(1000);
		CouponCodeTextbox.sendKeys(Keys.TAB);
	}

	public void SetCouponCode(String couponcode) {
		CouponCodeTextbox.sendKeys(couponcode);
	}

	public void ClickDiscountDollarField() {
		DiscountDollarTextbox.click();
	}



	public String getCouponCode() {
		return CouponCodeTextbox.getAttribute("value");
	}

	public String CouponCodePlaceHolder() {
		HighlightElement(CouponCodeTextbox);
		return CouponCodeTextbox.getAttribute("placeholder");
	}

	public void SetDiscount(String discount) {
		clickAndType(DiscountPercentTextbox, discount); //DiscountPercentTextbox
	}

	public void EnterDiscount(String discount) {
		jsClearAndType(DiscountPercentTextbox, discount);
	}

	public String DiscountTextBoxPlaceHolder() {
		HighlightElement(DiscountPercentTextbox);
		return DiscountPercentTextbox.getAttribute("placeholder");
	}

	public String DiscountpercentageTextbox() {
		HighlightElement(Discountpertextbox);
		return Discountpertextbox.getAttribute("placeholder");
	}

	public void EnterDiscountPercentage(String discountpercentage) {
		jsClearAndType(Discountpertextbox, discountpercentage);
	}

	public String DiscountPercentagePlaceHolder() {
		HighlightElement(Discountpertextbox);
		return Discountpertextbox.getAttribute("placeholder");
	}

	public boolean DiscountAmountFieldIsDisabled() {
		HighlightElement(DiscountDollarTextbox);
		return DiscountDollarTextbox.isEnabled();
	}

	public String DiscountAmountPlaceHolder() {
		HighlightElement(DiscountAmtTextbox);
		return DiscountAmtTextbox.getAttribute("placeholder");
	}

	public String TaxTypePlaceholder() {
		HighlightElement(TaxType);
		return TaxType.getAttribute("placeholder");
	}

	public String SelectCustomerPlaceholder() {
		HighlightElement(SelectCustomer);		
		return SelectCustomer.getAttribute("placeholder");
	}
	
	public String getDisplayedCustomerName() {
		HighlightElement(SelectCustomer);		
		return SelectCustomer.getAttribute("value");
		
	}

	public boolean CustomerAddButton() {
		HighlightElement(AddCustomerBtn);
		return AddCustomerBtn.isDisplayed();
	}

	public boolean ReconcileBtnIsDisplayed() {
		HighlightElement(ReconcileBtn);
		return ReconcileBtn.isDisplayed();
	}

	public boolean PayOutBtnIsDisplayed() {
		HighlightElement(PayOutBtn);
		return PayOutBtn.isDisplayed();
	}
	
	public void ClickPayOutBtn() {
		jsClick(PayOutBtn);
	}

	public boolean SalesHistoryIsDisplayed() {
		HighlightElement(SalesHistoryBtn);
		return SalesHistoryBtn.isDisplayed();
	}
	
	public void ClickSalesHistoryBtn() {
		click(SalesHistoryBtn);
	}

	public boolean OpenDrawerIsDisplayed() {
		HighlightElement(OpenCashDrawerBtn);
		return OpenCashDrawerBtn.isDisplayed();
	}
	
	public boolean VerifyPasswordPopupIsDisplayed() {
		HighlightElement(verifyPasswordPopup);
		return verifyPasswordPopup.isDisplayed();
	}
	
	public boolean VerifyPasswordPopup() {
		HighlightElement(VerifyPasswordPopupHeader);
		return VerifyPasswordPopupHeader.isDisplayed();
	}
	
	public void EnterVerifyPassword(String verifyPassword) {
		DoubleClickAndType(VerifyPasswordTextbox,verifyPassword);
	}
	
	public String getEnteredVerifyPassword() {
		HighlightElement(VerifyPasswordTextbox);
		return VerifyPasswordTextbox.getAttribute("value");
	}
	
	public void ClickVerifyBtnOnPasswordPopup() {
		jsClick(verifyBtn_PasswordPopup);
	}
	
	public void ClickOpenDrawerBtn() {
		jsClick(OpenCashDrawerBtn);
	}

	public boolean AltPTextIsDisplayed() {
		HighlightElement(PressAltPtocontinuetopaymentpageText);
		return PressAltPtocontinuetopaymentpageText.isDisplayed();
	}

	public void ClickSplitPaymentToogleButton() {
		click(PressAltPtocontinuetopaymentpageText);
	}
	
	public boolean ValidateSplitPaymentToogleButton() {
		HighlightElement(SplitPaymentToogleButton);
		SplitPaymentToogleButton.isDisplayed();
		return SplitPaymentToogleButton.isEnabled();
	}

	public boolean ValidateSubTotalLabelPresence() {
		HighlightElement(SubTotalLabel);
		return	SubTotalLabel.isDisplayed();
	}


	public String ValidateSubTotalDefaultValue() {
		HighlightElement(DefaultSubTotalValues);
		return DefaultSubTotalValues.getText();
	}

	public boolean ValidateGSTLabel() {
		HighlightElement(GSTLabel);
		return GSTLabel.isDisplayed();
	}

	public String ValidateGSTDefaultValue() {
		HighlightElement(GSTDefaultValue);
		return GSTDefaultValue.getText();
	}

	public boolean ValidatePSTHSTQSTLabel() {
		HighlightElement(PSTHSTQSTLabel);
		return PSTHSTQSTLabel.isDisplayed();
	}

	public String ValidatePSTHSTQSTDefaultValues() {
		HighlightElement(PSTHSTQSTDefaultValues);
		return PSTHSTQSTDefaultValues.getText();
	}

	public boolean ValidateTaxLabel() {
		HighlightElement(TaxLabel);
		return TaxLabel.isDisplayed();
	}

	public String ValidateTaxDefaultValue() {
		HighlightElement(TaxDefaultValues);
		return TaxDefaultValues.getText();
	}

	public boolean ValidateDiscountLabel() {
		HighlightElement(Discountlabel);
		return Discountlabel.isDisplayed();
	}

	public String ValidateDiscountDefaultValues() {
		HighlightElement(DiscountDefaultValues);
		return DiscountDefaultValues.getText();
	}

	public boolean ValidateGrandTotalLabel() {
		HighlightElement(GrandTotalLabel);
		return GrandTotalLabel.isDisplayed();
	}

	public String ValidateGrandTotalDefaultValue() {
		HighlightElement(GrandTotalDefaultValue);
		return GrandTotalDefaultValue.getText();
	}

	public void ClickChooseDefaultValue() {
		jsClick(chooseDefaultValuesIcon);
		delayWithGivenTime(2000);
		getDriver().switchTo().activeElement();
	}

	public boolean ValidateChoosePageDefaultValuePopupIsDisplayed() {
		HighlightElement(choosepagedefaultvaluespopupHeader);
		return choosepagedefaultvaluespopupHeader.isDisplayed();
	}
	

	public void SelectDefaultOccasion() {
		dropDown(defaultoccasiondd,"--select--","VisibleText");		
	}

	public void SelectDefaultSalesPerson() {
		dropDown(salespersondd,"--select--","VisibleText");
	}

	public void SelectDefaultSourcecode() {
		dropDown(sourcecodedd,"--select--","VisibleText");
	}

	public void ClickUpdateButtonOnChooseDefaultPopup() {
		click(updateBtn);
	}

	public String GetEmployeeDDfirstOption() {
		HighlightElement(EmployeeDropDown);
		select = new Select(EmployeeDropDown);
		WebElement employeedefaultvalue = select.getFirstSelectedOption();
		return	employeedefaultvalue.getText();
	}

	public String GetOccasionDDfirstOption() {
		HighlightElement(Occasion);
		select= new Select(Occasion);
		WebElement occasionDefaultValue = select.getFirstSelectedOption();
		return occasionDefaultValue.getText();
	}

	public String GetSourceCodeDDfirstOption() {
		HighlightElement(SourceCode);
		select= new Select(SourceCode);
		WebElement SourceCodeDefaultValue = select.getFirstSelectedOption();
		return SourceCodeDefaultValue.getText();
	}

	public boolean WalkingSettingIconIsExist() {
		HighlightElement(CashAndCarryPageWalkinsSettingIcon);
		return	CashAndCarryPageWalkinsSettingIcon.isDisplayed();
	}

	public boolean ChooseDefaultValueIconIsExist() {
		HighlightElement(chooseDefaultValuesIcon);
		return	chooseDefaultValuesIcon.isDisplayed();
	}

	public void ClickRefreshForm() {
		click(RefreshFormBtn);
	}

	public CashAndCarryPage ClickProductTitle() {		
		int i;
		for( i=0;i<CashAndCarryTile.size();i++) {
			if(CashAndCarryTile.get(i).getAttribute("title").contains("ballonsYY-Ballons small-$40.00")) {
				jsScrollClick(CashAndCarryTile.get(i));
				break;
			}
		}return this;		
	}

	public boolean ProdTitleAddedItemIsExist() {
		int i;
		for(i=0;i<listoftablerows.size();i++) {
			if(listoftablerows.get(i).getText().contains("ballonsYY-Ballons small-$40.00")) {
				HighlightElement(listoftablerows.get(i));
				break;
			}
		}return listoftablerows.get(i).isDisplayed();
	}

	public String getAddedItemCode() {
		HighlightElement(AddedItemCodecol1);
		return AddedItemCodecol1.getText();
	}


	public String getAddedItemCodeRow2() {
		HighlightElement(AddedItemCodeRow2);
		return AddedItemCodeRow2.getText();
	}
	
	public void ClickParticularProdTitle() {
		jsScrollClick(CashAndCarryBalloonTitle);	
	}

	public CashAndCarryPage SelectProductTile(String prodtile) {		
		for(WebElement prodTile:ListOfProdTiles) {
			delayWithGivenTime(1000);
			if(prodTile.getAttribute("title").contains(prodtile)) {
				jsClick(prodTile);
				break;
			}
		}		
	
		return this;	
		
	}
	
	public String getDisplayedProductTitletooltip() {
		Actions action = new Actions(getDriver());
		explicitWait(CashAndCarryBalloonTitle);
		HighlightElement(CashAndCarryBalloonTitle);
		action.moveToElement(CashAndCarryBalloonTitle).build().perform();
		delayWithGivenTime(1500);
		return CashAndCarryBalloonTitle.getText();
	}
	
	public boolean CouponcodeIsDisabled() {
		HighlightElement(CouponCodeTextbox);
		return CouponCodeTextbox.isEnabled();
	}

	public boolean DiscountPercentageFieldIsDisabled() {
		HighlightElement(DiscountPercentTextbox);
		return DiscountPercentTextbox.isEnabled();
	}

	public void ClickAddBtnForCreateNewCust() {
		click(AddCustomerBtn);
	}

	public boolean VerifyAddNewCustomerPageIsExist() {
		delayWithGivenTime(2000);	
		getDriver().switchTo().activeElement();
		HighlightElement(AddNewCustomerTitle);
		return AddNewCustomerTitle.isDisplayed();
	}

	public void ClickCloseIconOnAddNewCustPopup() {
		delayWithGivenTime(2000);
		jsClick(AddNewCustomerCloseIcon);
	}

	public boolean CustomerIdIsExist() {
		fluentWait(CustomerId);
		HighlightElement(CustomerId);
		return CustomerId.isDisplayed();
	}
	
	public String get_NewlyCreated_CustomerId() {
		//HighlightElement(CustomerId);
		return CustomerId.getText();
	}

	public boolean CustomerNameIsExist() {
		fluentWait(CustomerName);
		HighlightElement(CustomerName);
		return CustomerName.isDisplayed();		
	}
	
	public String getDisplayedCustomerNameOnCCPage() {
		HighlightElement(CustomerName);
		return CustomerName.getText();
	}

	public boolean CustomerCancelCrossIconIsDisplayed() {		
		fluentWait(cancelcustIcon);
		HighlightElement(cancelcustIcon);
		return cancelcustIcon.isDisplayed();
	}

	public void ClickCancelCustIcon() {
		jsClick(cancelcustIcon);
	}

	public boolean SelectCustomerDDIsDisplayed() {
		explicitWait(SelectCustomer);
		return SelectCustomer.isDisplayed();
	}

	public boolean SelectCustomerLabelIsDisplayed() {
		HighlightElement(SelectCustomerLabel);
		explicitWait(SelectCustomerLabel);
		return SelectCustomerLabel.isDisplayed();		
	}

	public String ActualGrandTotal() {
		return GrandTotalDefaultValue.getText();
	}


	public String ValidateGrandTotal() {
		double subTotal = Double.parseDouble(DefaultSubTotalValues.getText().replace("$", "").trim());
		//double gst = Double.parseDouble(GSTDefaultValue.getText().replace("$", "").trim());
		//double psthstqst = Double.parseDouble(PSTHSTQSTDefaultValues.getText().replace("$", "").trim());
		double tax = Double.parseDouble(TaxDefaultValues.getText().replace("$", "").trim());
		double discount = Double.parseDouble(DiscountDefaultValues.getText().replace("$", "").trim());
		// gst + psthstqst ---- functionality removed in UI july 2024

		double expectedGrandTotal = (subTotal + tax) - discount;

		// Format the numbers to two decimal places
		DecimalFormat df = new DecimalFormat("#.00");
		String formattedExpectedGrandTotal = df.format(expectedGrandTotal);
		return formattedExpectedGrandTotal;
	}

	public String ValidatePayButtonDisplayedPrice() {
		return PayBtnText.getText().replace("$", "").trim();
	}

	public void SetDiscountpercentageValue() {
		jsClearAndType(Discountpertextbox,"10");	
	}

	public String getDiscountAmountvalue() {
		String discountAmt = DiscountAmtTextbox.getAttribute("value");
		System.out.println("Discount amount is :  "+discountAmt);
		return discountAmt;
	}

	public boolean DiscountChangeLinkIsDisplayed() {
		HighlightElement(changediscountlink);
		return changediscountlink.isDisplayed();
	}

	public boolean verifyChangePopUpMessage() {
		getDriver().switchTo().activeElement();
		HighlightElement(changeDiscountPopupmessage);
		return changeDiscountPopupmessage.isDisplayed();		
	}

	public void ClickChangeLinkOnDiscountPercentageField() {
		click(changediscountlink);			
	}

	public boolean VerifyWarningIconIsDisplayed() {
		HighlightElement(changeDiscountPopupicon);
		return changeDiscountPopupicon.isDisplayed();
	}

	public boolean VerifyUpdatingDiscountText() {
		HighlightElement(changeDiscountPopupUnboldedText);
		return changeDiscountPopupUnboldedText.isDisplayed();		
	}

	public boolean ChangeDiscountNoButton() {
		HighlightElement(changeDiscountPopupNoButton);
		return changeDiscountPopupNoButton.isDisplayed();			
	}

	public boolean ChangeDiscountYesButton() {
		HighlightElement(changeDiscountPopupYesButton);
		return changeDiscountPopupYesButton.isDisplayed();
	}

	public void ClickChangeDiscountNoButton() {
		jsClick(changeDiscountPopupNoButton);
	}

	public void ClickChangeDiscountYesButton() {
		click(changeDiscountPopupYesButton);
	}

	public String getDiscountAmountvalueOrderLevel() {
		String discountAmt = DiscountDollarTextbox.getAttribute("value");
		return discountAmt;
	}

	public boolean verifyChangeDiscountOnProductLevelIsDispalyed() {
		HighlightElement(changediscountitemlink);
		return changediscountitemlink.isDisplayed();
	}

	public void ClickChangeDiscountOnProductLevel() {
		click(changediscountitemlink);
	}

	public boolean verifyChangeDiscountOnProductLevelPopupIsDispalyed() {
		HighlightElement(changeDiscountProductLevelPopup);
		return changeDiscountProductLevelPopup.isDisplayed();
	}

	public void ClickChangeDiscountOnProductLevelYesButton() {
		click(changeDiscountProductLevelPopupYesButton);
	}

	public void ClickWalkingSettingIcon() {
		jsScrollClick(CashAndCarryPageWalkinsSettingIcon);	
		//CashAndCarryPageWalkinsSettingIcon.click();
		if(verifyWalkingSettingPopupIsDisplayed()==false) {
			CashAndCarryPageWalkinsSettingIcon.click();
		}
	}

	public void ClickRow1DeleteIcon() {
		jsClick(AddedItemTableRow1DeleteIcon);
	}
	
	public String VerifyWalkingSettingsToolTip() {
		HighlightElement(CashAndCarryPageWalkinsSettingIcon);	
		MouseHover(CashAndCarryPageWalkinsSettingIcon);
		delayWithGivenTime(1500);
		String tooltipText = CashAndCarryPageWalkinsSettingIcon.getAttribute("title");		
		return tooltipText;
	}

	public boolean verifyWalkingSettingPopupIsDisplayed() {
		delayWithGivenTime(3000);
		explicitWait(WalkinsSettingPopup);
		getDriver().switchTo().activeElement();
		HighlightElement(WalkinsSettingPopup);
		return WalkinsSettingPopup.isDisplayed();
	}

	public String VerifyDefaultShopNameonWalkingSettings() {
		Select s = new Select(WalkinsSettingPopupShopDropDown);
		return s.getFirstSelectedOption().getText();
	}

	public boolean VerifyAddNewButtonIsDisplayedonWalkinsSettings() {
		HighlightElement(WalkinsSettingPopupAddNewBtn);
		return 	WalkinsSettingPopupAddNewBtn.isDisplayed();
	}

	public boolean VerifyWalkingPopupCloseIcon() {
		HighlightElement(WalkinsSettingPopupCloseIcon);
		return WalkinsSettingPopupCloseIcon.isDisplayed();
	}

	public void ClickWalkingPopupCloseIcon() {
		jsScrollClick(WalkinsSettingPopupCloseIcon);
	}
	
	public void SelectShopNameonWalkingSetting() {	
		dropDown(WalkinsSettingPopupShopDropDown,prop.getProperty("ShopName"),"VisibleText");
	}

	public String VerifyShopTableHeaderonWalkingSettingSno() {
		HighlightElement(WalkingSettingPopUpShopSiNo);
		return 	WalkingSettingPopUpShopSiNo.getText();
	}

	public String VerifyShopTableHeaderonWalkingSettingClerkId() {
		HighlightElement(WalkingSettingPopUpShopClerkId);
		return WalkingSettingPopUpShopClerkId.getText();
	}

	public String VerifyWalkingSettingShopPrinterName() {
		HighlightElement(WalkingSettingPopUpShopPrinterName);
		return WalkingSettingPopUpShopPrinterName.getText();		
	}

	public String VerifyWalkingSettingShopCashDrawcode() {
		HighlightElement(WalkingSettingPopUpShopCashDrawCode);
		return WalkingSettingPopUpShopCashDrawCode.getText();
	}

	public String VerifyWalkingSettingPrinterCutCode() {
		HighlightElement(WalkingSettingPopUpShopPrinterCutCode);
		return WalkingSettingPopUpShopPrinterCutCode.getText();
	}

	public String VerifyClerkDescWalkingSetting() {
		HighlightElement(WalkingSettingPopUpShopClerkDesc);
		return WalkingSettingPopUpShopClerkDesc.getText();
	}

	public String VerifyWalkingSettingCustcopy() {
		HighlightElement(WalkingSettingPopUpShopCustCopy);
		return WalkingSettingPopUpShopCustCopy.getText();
	}

	public String VerifyWalkingSettingActionheader() {
		HighlightElement(WalkingSettingPopUpShopAction);
		return WalkingSettingPopUpShopAction.getText();		
	}

	public void ClickWalkingSettingPopupCloseIcon() {
		click(WalkingSettingPopupCloseIcon1);
	}

	public boolean ValidateEditBtnPresenceOnWalkingSettingPopup() {
		int i=0;
		for(i=0;i<EditWalkInSettingButton.size();i++) {
			if(EditWalkInSettingButton.get(i).isDisplayed()) {
				HighlightElement(EditWalkInSettingButton.get(i));
				break;
			}
		}

		return EditWalkInSettingButton.get(i).isDisplayed();
	}

	public boolean ValidateDeleteIconPresenceOnWalkingSettingPopup() {
		int i=0;
		for(i=0;i<deleteWalkInSettingButton.size();i++) {
			if(deleteWalkInSettingButton.get(i).isDisplayed()) {
				HighlightElement(deleteWalkInSettingButton.get(i));
				break;
			}
		}return deleteWalkInSettingButton.get(i).isDisplayed();
	}

	public void ClickAddNewButtonOnWalkingSettingPopup() {
		click(WalkinsSettingPopupAddNewBtn);
	}

	public boolean VerifyAddNewWalkingSettingPopupIsDisplayed() {
		getDriver().switchTo().activeElement();
		HighlightElement(WalkinsSettingAddNewPopupScreen);
		return WalkinsSettingAddNewPopupScreen.isDisplayed();
	}

	public boolean clerkIdLabelonAddnewPopupIsExists() {
		HighlightElement(ClerkIdLabel);
		return ClerkIdLabel.isDisplayed();
	}

	public boolean clerkIdTextboxonAddnewPopupIsDisplayed() {
		HighlightElement(ClerkIDTextBox);
		return ClerkIDTextBox.isDisplayed();
	}

	public boolean clerkDescriptionLabelonAddnewPopupIsDisplayed() {
		HighlightElement(ClerkDescLabel);
		return ClerkDescLabel.isDisplayed();
	}

	public boolean clerkDescriptionTextboxonAddnewPopupIsDisplayed() {
		HighlightElement(ClerkDescTextBox);
		return ClerkDescTextBox.isDisplayed();
	}

	public boolean printerNameonAddnewPopupIsDisplayed() {
		HighlightElement(PrinterNameLabel);
		return PrinterNameLabel.isDisplayed();
	}

	public boolean printerNameTextboxonAddnewPopupIsDisplayed() {
		HighlightElement(PrinterNameTextBox);
		return PrinterNameTextBox.isDisplayed();
	}


	public boolean manufacturerLabelonAddnewPopupIsDisplayed() {
		HighlightElement(ManufacturerLabel);
		return ManufacturerLabel.isDisplayed();
	}

	public boolean manufacturerDropdownonAddnewPopupIsDisplayed() {
		HighlightElement(ManufacturerDropDown);
		return ManufacturerDropDown.isDisplayed();
	}

	public boolean modelLabelonAddnewPopupIsDisplayed() {
		HighlightElement(ModelLabel);
		return ModelLabel.isDisplayed();
	}

	public boolean modelDropdownonAddnewPopupIsDisplayed() {
		HighlightElement(ModelDropDown);
		return ModelDropDown.isDisplayed();
	}

	public boolean cashdrawcodeLabelonAddnewPopupIsDisplayed() {
		HighlightElement(CashDrawCodeLabel);
		return CashDrawCodeLabel.isDisplayed();
	}

	public boolean cashdrawcodeTextboxonAddnewPopupIsDisplayed() {
		HighlightElement(CashDrawCodeTextBox);
		return CashDrawCodeTextBox.isDisplayed();
	}

	public boolean printercutcodeLabelonAddnewPopupIsDisplayed() {
		HighlightElement(PrinterCutCodeLabel);
		return PrinterCutCodeLabel.isDisplayed();
	}

	public boolean printercutcodeTextboxonAddnewPopupIsDisplayed() {
		HighlightElement(PrinterCutCodeTextBox);
		return PrinterCutCodeTextBox.isDisplayed();
	}

	public boolean clearantApiKeyLabelonAddnewPopupIsDisplayed() {
		HighlightElement(ClearantAPIKeyLabel);
		return ClearantAPIKeyLabel.isDisplayed();
	}

	public boolean clearantApiKeyTextboxonAddnewPopupIsDisplayed() {
		HighlightElement(APIKeyTextBox);
		return APIKeyTextBox.isDisplayed();
	}

	public boolean cloverDeviceIdLabelonAddnewPopupIsDisplayed() {
		HighlightElement(CloverDeviceIDLabel);
		return CloverDeviceIDLabel.isDisplayed();
	}

	public boolean cloverDeviceIdTextboxonAddnewPopupIsDisplayed() {
		HighlightElement(CloverDeviceIDTextBox);
		return CloverDeviceIDTextBox.isDisplayed();
	}

	public boolean clovercashdrawerIdLabelonAddnewPopupIsDisplayed() {
		HighlightElement(CloverCashDrawerIdLabel);
		return CloverCashDrawerIdLabel.isDisplayed();
	}

	public boolean clovercashdrawerIdsearchicononAddnewPopupIsDisplayed() {
		HighlightElement(CloverCashDrawerIdSearchIcon);
		return CloverCashDrawerIdSearchIcon.isDisplayed();
	}

	public boolean enableCloverPrinteronAddnewPopupIsDisplayed() {
		HighlightElement(EnableCloverPrinterLabel);
		return EnableCloverPrinterLabel.isDisplayed();
	}

	public boolean enableCloverPrinterCheckboxonAddnewPopupIsDisplayed() {
		HighlightElement(EnableCloverPrinterCheckBox);
		return EnableCloverPrinterCheckBox.isDisplayed();
	}

	public boolean openEdgeWebIDonAddnewPopupIsDisplayed() {
		HighlightElement(OpenEdgeWebIDLabel);
		return OpenEdgeWebIDLabel.isDisplayed();
	}

	public boolean openEdgeWebIDTextboxonAddnewPopupIsDisplayed() {
		HighlightElement(OpenEdgeWebIDTextBox);
		return OpenEdgeWebIDTextBox.isDisplayed();
	}

	public boolean openEdgeTerminalIDLabelonAddnewPopupIsDisplayed() {
		HighlightElement(OpenEdgeTerminalIDLabel);
		return OpenEdgeTerminalIDLabel.isDisplayed();
	}

	public boolean openEdgeTerminalIDTextboxonAddnewPopupIsDisplayed() {
		HighlightElement(OpenEdgeTerminalIDTextBox);
		return OpenEdgeTerminalIDTextBox.isDisplayed();
	}

	public boolean openEdgeAuthKeyLabelonAddnewPopupIsDisplayed() {
		HighlightElement(OpenEdgeAuthKeyLabel);
		return OpenEdgeAuthKeyLabel.isDisplayed();
	}

	public boolean openEdgeAuthKeyTextboxonAddnewPopupIsDisplayed() {
		HighlightElement(OpenEdgeAuthKeyTextBox);
		return OpenEdgeAuthKeyTextBox.isDisplayed();
	}

	public boolean OpenEdgeCustomerCopyLabelonAddnewPopupIsDisplayed() {
		HighlightElement(OpenEdgeCustomerCopyLabel);
		return OpenEdgeCustomerCopyLabel.isDisplayed();
	}

	public boolean openEdgeCustomerCopyCheckboxonAddnewPopupIsDisplayed() {
		HighlightElement(OpenEdgeCustomerCopyCheckBox);
		return OpenEdgeCustomerCopyCheckBox.isDisplayed();
	}

	public boolean OpenEdgeMerchantCopyLabelonAddnewPopupIsDisplayed() {
		HighlightElement(OpenEdgeMerchantCopyLabel);
		return OpenEdgeMerchantCopyLabel.isDisplayed();
	}

	public boolean openEdgeMerchantCopyCheckboxonAddnewPopupIsDisplayed() {
		HighlightElement(OpenEdgeMerchantCopyCheckBox);
		return OpenEdgeMerchantCopyCheckBox.isDisplayed();
	}

	public boolean custCopyNoteLabelonAddnewPopupIsDisplayed() {
		HighlightElement(CustomerCopyNoteLabel);
		return CustomerCopyNoteLabel.isDisplayed();
	}

	public boolean custCopyNoteTextboxonAddnewPopupIsDisplayed() {
		HighlightElement(CustomerCopyNoteTextBox);
		return CustomerCopyNoteTextBox.isDisplayed();
	}

	public boolean merchantCopyNoteLabelonAddnewPopupIsDisplayed() {
		HighlightElement(CustomerCopyNoteLabel);
		return CustomerCopyNoteLabel.isDisplayed();
	}

	public boolean merchantCopyNoteTextboxonAddnewPopupIsDisplayed() {
		HighlightElement(CustomerCopyNoteTextBox);
		return CustomerCopyNoteTextBox.isDisplayed();
	}

	public boolean saveBtnonAddnewPopupIsDisplayed() {
		HighlightElement(SaveWalkInSettingButton);
		return SaveWalkInSettingButton.isDisplayed();
	}

	public boolean cancelBtnonAddnewPopupIsDisplayed() {
		HighlightElement(CancelWalkInSettingButton);
		return CancelWalkInSettingButton.isDisplayed();
	}

	public boolean closeIconOnAddnewPopupIsDisplayed() {
		HighlightElement(AddNewWalkInSettingPopupCloseIcon);
		return AddNewWalkInSettingPopupCloseIcon.isDisplayed();
	}

	public void ClickCloseIconOnAddnewPopup() {
		click(AddNewWalkInSettingPopupCloseIcon);
	}

	public void EnterClerkIDonAddnewPopup(String ClerkID) {
		DoubleClickAndType(ClerkIDTextBox, ClerkID);	
	}

	public String getEnteredClerkIDonAddnewPopup() {
		
		return ClerkIDTextBox.getAttribute("value");
	}

	public void EnterClerkDescriptiononAddnewPopup(String ClerkDescription) {
		clickAndType(ClerkDescTextBox, ClerkDescription);	
	}

	public String getEnteredClerkDescriptiononAddnewPopup() {
		return ClerkDescTextBox.getAttribute("value");
	}

	public void EnterPrinterNameonAddnewPopup(String printerName) {
		clickAndType(PrinterNameTextBox, printerName);
	}

	public String getEnteredPrinterNameonAddnewPopup() {
		return PrinterNameTextBox.getAttribute("value");
	}

	public void SelectManufacturerOnAddNewPopup(String manufacturer) {
		dropDown(ManufacturerDropDown, manufacturer, "VisibleText");
	}

	public String getFirstSelectedManufacturerOptionOnAddNewPopup() {
		select = new Select(ManufacturerDropDown);
		return select.getFirstSelectedOption().getText();
	}

	public void SelectModelOnAddNewPopup(String model) {
		dropDown(ModelDropDown, model, "VisibleText");
	}



	public String getFirstSelectedModelOptionOnAddNewPopup() {
		select = new Select(ModelDropDown);
		return select.getFirstSelectedOption().getText();
	}

	public String getCashdrawcodeOnAddnewPopup() {
		//delayWithGivenTime(3000);
		HighlightElement(CashDrawCodeTextBox);	
		return CashDrawCodeTextBox.getAttribute("value");		
	}

	public String getPrinterCutCodeOnAddnewPopup() {
		HighlightElement(PrinterCutCodeTextBox);
		return PrinterCutCodeTextBox.getAttribute("value");
	}

	public void ClickCustomerCopyCheckboxOnAddnewPopup() {
		click(OpenEdgeCustomerCopyCheckBox);
	}

	public void ClickMerchantCopyCheckboxOnAddnewPopup() {
		click(OpenEdgeMerchantCopyCheckBox);
	}

	public boolean custCopyCheckBoxonAddNewpopUPIsSelected() {
		return OpenEdgeCustomerCopyCheckBox.isSelected();
	}

	public boolean merchantCopyCheckBoxonAddNewpopUPIsSelected() {
		return OpenEdgeMerchantCopyCheckBox.isSelected();
	}

	public void EnterCustCopyNoteonAddnewPopup(String custCopyNote) {
		clickAndType(CustomerCopyNoteTextBox, custCopyNote);
	}

	public void EnterMerchantCopyNoteonAddnewPopup(String merchantCopyNote) {
		clickAndType(MerchantCopyNoteTextBox, merchantCopyNote);
	}

	public String getEnteredCustCopyNoteonAddnewPopup() {
		return CustomerCopyNoteTextBox.getAttribute("value");
	}

	public String getEnteredMerchantCopyNoteonAddnewPopup() {
		return MerchantCopyNoteTextBox.getAttribute("value");
	}

	public void ClickCancelBtnonAddnewPopup() {
		jsScrollClick(CancelWalkInSettingButton);
	}

	public void ClickSaveBtnonAddnewPopup() {
		jsScrollClick(SaveWalkInSettingButton);
	}

	public boolean VerifySuccessMessageIsDisplayed() {
		HighlightElement(successToastMessageOnAddNewWalkInSetting);
		return successToastMessageOnAddNewWalkInSetting.isDisplayed();
	}

	public boolean VerifyWalkingSettingNewlyAdded() {
		HighlightElement(NewlyCreatedClerkIdWalkInSetting);
		return NewlyCreatedClerkIdWalkInSetting.isDisplayed();
	}

	public void ClickNewlyCreatedEditBtnOnWalkInSetting() {
		jsScrollClick(Automation_Clerk_description_NewlyCreatedEditWalkInSettingButton);
	}

	public void ClickAutomationClerkDescEditBtnOnWalkInSetting() {
		jsScrollClick(Automation_Clerk_DescEditWalkInSettingButton);
	}
	
	public void ClickCashRegistryUncheckedEditBtnOnWalkInSetting() {
		jsScrollClick(CashRegisterUncheckedFTEditWalkInSettingButton);
	}
	
	public String geteditBtnToolTiponAddnewPopupIsDisplayed() {
		MouseHover(Automation_Clerk_description_NewlyCreatedEditWalkInSettingButton);
		delayWithGivenTime(1000);
		return Automation_Clerk_description_NewlyCreatedEditWalkInSettingButton.getAttribute("title");
	}

	public String getDeleteBtnToolTiponAddnewPopupIsDisplayed() {
		MouseHover(NewlyCreatedDeleteWalkInSettingButton);
		delayWithGivenTime(1000);
		return NewlyCreatedDeleteWalkInSettingButton.getAttribute("title");
	}
	
	public void ClickAutomationEditBtnOnWalkInSetting() {
		fluentWait(AutomationEditWalkInSettingButton1);
		jsScrollClick(AutomationEditWalkInSettingButton1);
	}

	public void ClickAutomationDontDeleteEditBtnOnWalkInSetting() {
		fluentWait(Automation_DontDeletetEditWalkInSettingButton);
		jsScrollClick(Automation_DontDeletetEditWalkInSettingButton);
	}
	
	public void ClickCashRegistery2EditBtnOnWalkInSetting() {
		fluentWait(CashRegister2EditWalkInSettingButton1);
		jsScrollClick(CashRegister2EditWalkInSettingButton1);
	}
	
	public void ClickEditBtnOnWalkInSetting() {		
		fluentWait(Hana_Testing_DescriptionEditWalkInSettingButton1);
		jsScrollClick(Hana_Testing_DescriptionEditWalkInSettingButton1);		
	}
	
	public void ClickSaveBtnOnAddNewPopup() {
		jsScrollClick(SaveWalkInSettingButton);
	}
	
	public String VerifyUpdatedPrinterName() {
		int p;
		for ( p=0;p<listOfPrinterName.size();) {
			if(listOfPrinterName.get(p).getText().equals("Saka Printer")) {
				listOfPrinterName.get(p).getText();
				p++;
			break;
			}	break;
		}return listOfPrinterName.get(p).getText();
	}
	
	public void ClickDeleteBtnOnParticularWalkInSetting() {
		fluentWait(AutomationdeleteWalkInSettingButton1);
		jsScrollClick(AutomationdeleteWalkInSettingButton1);
	}
	
	public boolean verifyDeleteConfirmationPopupIsDisplayed() {
		getDriver().switchTo().activeElement();
		HighlightElement(DeleteConfirmationPopUpInWalkinSetting);
		return DeleteConfirmationPopUpInWalkinSetting.isDisplayed();
	}
	
	public String verifyDeleteConfirmationPopuText() {
		HighlightElement(AreYouSureYouWishToWalkinSettingText);
		return AreYouSureYouWishToWalkinSettingText.getText();
	}
	
	public boolean confirmationcodeTextBoxIsDisplayed() {
		HighlightElement(ConfirmationCodeTextBox);
		return ConfirmationCodeTextBox.isDisplayed();
	}
	
	public String VerifyconfirmationCodePlaceholder() {
		return ConfirmationCodeTextBox.getAttribute("placeholder");
	}
	
	public boolean CancelBtnInDeleteConfirmationPopupIsDisplayed() {
		HighlightElement(CancelButtonInDeleteConfirmationPopUp);
		return CancelButtonInDeleteConfirmationPopUp.isDisplayed();
	}
	
	public boolean OkBtnInDeleteConfirmationPopup() {
		HighlightElement(OKButtonInDeleteConfirmationPopUp);
		return OKButtonInDeleteConfirmationPopUp.isDisplayed();
	}
	
	public void ClickCancelBtnInDeleteConfirmationPopup() {
		jsScrollClick(CancelButtonInDeleteConfirmationPopUp);
	}
	
	public void EnterConfirmationCodeInDeleteConfirmationPopup(String confirmationCode) {
		clickAndType(ConfirmationCodeTextBox, confirmationCode);
	}
	
	public void ClickOkBtnInDeleteConfirmationPopup() {
		jsScrollClick(OKButtonInDeleteConfirmationPopUp);
	}
	
	public String validateInvalidDeleteConfirmationCode() {
		delayWithGivenTime(2000);	
		HighlightElement(IncorrectConfirmationCodeText);
		return IncorrectConfirmationCodeText.getText();
	}
	
	public boolean validateInvalidDeleteConfirmationCodeCrossIcon() {
		HighlightElement(IncorrectDeleteConfirmationCodeErrorIcon);
		return IncorrectDeleteConfirmationCodeErrorIcon.isDisplayed();
	}
	
	public String getDeleteConfirmationCode() {
	String confirmationCode =	AreYouSureYouWishToWalkinSettingText.getText();
	
	String[] ExtractedconfirmationCode=confirmationCode.split("Type")[1].trim().split(" ");
	System.out.println(ExtractedconfirmationCode[0]);
	return ExtractedconfirmationCode[0];
	}
	
	public void EnterDeleteConfirmationCode() {
		jsClearAndType(ConfirmationCodeTextBox, getDeleteConfirmationCode());
	}
	
	public String GetAddedItemCode() {
		return AddedItemTableRow1ItemCode.getText();
	}
	
	public String GetAddedRow2ItemCode() {
		return AddedItemTableRow2ItemCode.getText();
	}
	
	public String GetAddedItemDescription() {
		return AddedItemTableRow1Description.getText();
	}
	
	public String GetAddedItemDescriptionRow2() {
		return AddedItemTableRow2Description.getText();
	}
	
	
	public String GetAddedItemQty() {
		return AddedItemTableRow1Quantity.getText();
	}
	
	public String GetAddedItemQtyRow2() {
		return AddedItemTableRow2Quantity.getText();
	}
	
	public String GetAddedItemPrice() {
	return AddedItemTableRow1Price.getText();
	}
	
	public String GetAddedItemExtPrice() {
	return AddedItemTableRow1ExtPrice.getText();
	}
	
	public String GetAddedItemDiscountAmount() {
		return AddedItemTableRow1DiscountAmount.getText();
	}
	
	public String GetAddedItemDiscountPercentage() {
		return AddedItemTableRow1DiscountPercentage.getText();
	}
	
	public boolean IsPayButtonDisabled() {
		HighlightElement(PayBtn);	
		String classAttribute = PayBtn.getAttribute("class");
		boolean isDisabledClassPresent = classAttribute.contains("BoldText disabled"); 
		return isDisabledClassPresent;      
	}
	
	public boolean VerifyPayButtonIsEnabled() {
		HighlightElement(PayBtn);	
		boolean isDisabled = PayBtn.getAttribute("class").contains("disabled");
		return isDisabled;
	}
	
	public String getDisplayedItemDescription() {
		HighlightElement(AddedItemDescriptioncol1);
		return AddedItemDescriptioncol1.getText();
	}
	
	public String getDisplayedItemQty() {
		HighlightElement(AddedItemQuantitycol1);
		return AddedItemQuantitycol1.getText();
	}
	
	public String getDisplayedItemPrice() {
		HighlightElement(AddedItemPricecol1);
		return AddedItemPricecol1.getText();
	}
	
	public String getDisplayedItemExtPrice() {
		HighlightElement(AddedItemExtendedPricecol1);
		return AddedItemExtendedPricecol1.getText();
	}
	
	public String getDisplayedItemDiscountAmount() {
		HighlightElement(AddedItemDiscountAmountcol1);
		return AddedItemDiscountAmountcol1.getText();
	}
	
	public String getDisplayedItemDiscountPercentage() {
		HighlightElement(AddedItemDiscountPercentagecol1);
		return AddedItemDiscountPercentagecol1.getText();
	}
	
	public void ClickAddedRow1EditButton() {
		click(EditAddedItemTableRow1Action);
	}
	
	public boolean IsSavedIconDisplayedOnAddedItemTableRow1() {
		HighlightElement(SavedAddedItemTableRow1Action);
		return SavedAddedItemTableRow1Action.isDisplayed();
		}
	
	public boolean IsCancelIconDisplayedOnAddedItemTableRow1() {
		HighlightElement(CancelAddedItemTableRow1Action);
		return CancelAddedItemTableRow1Action.isDisplayed();
	}
	
	public void ClickTheCancelIconOnAddedItemTableRow1() {
		click(CancelAddedItemTableRow1Action);
	}
	
	public void ClickTheSavedIconOnAddedItemTableRow1() {
		click(SavedAddedItemTableRow1Action);
	}
	
	public void EditQuantityOnTableRow1(String QTY) {	
		Actions actions = new Actions(getDriver());
		explicitWait(EditedQtyRow1Textbox);
        actions.doubleClick(EditedQtyRow1Textbox).build().perform();
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		executor.executeScript("arguments[0].value='" + QTY + "'", EditedQtyRow1Textbox);
		delayWithGivenTime(1000);
		EditedPriceRow1Textbox.click();		
	}
	
	public void ClickOnEditPriceOnTableRow1() {
		click(AddedItemTableRow1Price);
	}
	
	public void ClickOnDeleteIconAtRow2() {
		click(DeleteAddedItemTableRow2);
	}
	
	public boolean IsRow2TableAddedItemDisplayed() {
		 List<WebElement> rows = AddedItemTable.findElements(By.tagName("tr"));
		 boolean isDataDeleted = true;
         for (WebElement row : rows) {
             if (row.getText().contains("Red Rose Deluxe")) { // Replace "data to delete" with the actual data
            	 isDataDeleted = false;
                 break;
             }
         }
		return isDataDeleted;		
	}
	
	public void ClickOnDeleteIconAtRow1() {
		click(DeleteAddedItemTableRow1);
	}
	
	public boolean IsRow1TableAddedItemDisplayed() {		
		 List<WebElement> rows = AddedItemTable.findElements(By.tagName("tr"));
		 boolean isDataDeleted = true;
         for (WebElement row : rows) {
             if (row.getText().contains("ballonsYY")) { // Replace "data to delete" with the actual data
            	 isDataDeleted = false;
                 break;
             }
         }
		return isDataDeleted;	
	}
	
	public void SelectShopOnChoosePageDefaultValues(String shop) {
		dropDown(ShopChooseDefaultValuesDD,shop ,"VisibleText");	
	}
	
	public String getSelectShopOnCPDV() {
		HighlightElement(ShopChooseDefaultValuesDD);
		select = new Select(ShopChooseDefaultValuesDD);
		String displayedPageName = select.getFirstSelectedOption().getText();
		return displayedPageName;
	}
	
	public void SelectPageNameOnCPDV(String pagename) {
		dropDown(PageNameChooseDefaultValuesDD,pagename ,"VisibleText");
	}
	
	public String getFirstSelectedOptionOnPageNameDD() {
		HighlightElement(PageNameChooseDefaultValuesDD);
		select = new Select(PageNameChooseDefaultValuesDD);
		String displayedPageName = select.getFirstSelectedOption().getText();
		return displayedPageName;
	}
	
	public void EnterBankNameOnBankNameOnChooseDefaultValues(String bankname) {
		jsClearAndType(BankNameTextBoxChooseDefaultValues, bankname);
	}
	
	public void EnterCheckNoOnCheckNoOnChooseDefaultValues(String checkno) {
		jsClearAndType(CheckNoTextBoxChooseDefaultValues, checkno);
	}
	
	public void EnterNameofCheckOnChooseDefaultValues(String nameofcheck) {
		jsClearAndType(NameOnCheckTextBoxChooseDefaultValues, nameofcheck);
	}
	
	public void EnterSplCharInQuantityOnChooseDefaultValues(String quantity) {
		DoubleClick(QuantityTextBoxChooseDefaultValues);
		jsClearAndType(QuantityTextBoxChooseDefaultValues, quantity);
		delayWithGivenTime(2000);		
	}
	
	public String getQtyOnChooseDefaultValues() {
		return QuantityTextBoxChooseDefaultValues.getAttribute("value");
	}
	
	public void ClearQuantityFieldOnChooseDefaultValues() {
		jsClear(QuantityTextBoxChooseDefaultValues);
	}
	public void EnterQuantityOnChooseDefaultValues(String quantity) {
		
		DoubleClick(QuantityTextBoxChooseDefaultValues);
		jsClearAndType(QuantityTextBoxChooseDefaultValues, quantity);
	}
	
	public String getEnteredDefaultQuantityOnChooseDefaultValue() {
		return QuantityTextBoxChooseDefaultValues.getAttribute("value");
	}
	
	public void SelectDefaultOccasionOnChooseDefaultValues(String defaultoccasion) {
		dropDown(DefaultOccasionDD,defaultoccasion,"VisibleText");
	}
	
	public String getDefaultoccasionselected() {
		HighlightElement(DefaultOccasionDD);
		select = new Select(DefaultOccasionDD);
		return select.getFirstSelectedOption().getText();
	}
	
	public void SelectDefaultSalesPersonOnChooseDefaultValues(String defaultsalesperson) {
		dropDown(SalesPersonDefaultValuesDD,defaultsalesperson,"VisibleText");
	}
	
	public String getSalesPersonSelected() {
		HighlightElement(SalesPersonDefaultValuesDD);
		select = new Select(SalesPersonDefaultValuesDD);
		return select.getFirstSelectedOption().getText();
	}
	
	
	public void SelectDefaultSourceCodeOnChooseDefaultValues(String defaultsourcecode) {
		dropDown(SourceCodeDefaultValuesDD,defaultsourcecode,"VisibleText");
	}
	
	public String getSelectedSourceCodeOnChooseDefaultValues() {
		HighlightElement(SourceCodeDefaultValuesDD);
		select = new Select(SourceCodeDefaultValuesDD);
		return select.getFirstSelectedOption().getText();
	}
	
	public void ClickUpdateBtnOnChooseDefaultValues() {
		click(ChooseDefaultUpdateButton);
	}
	
	public void ClickCloseIconOnChooseDefaultValuesPopup() {
		jsClick(CloseIconOnChooseDefaultValuesPopup);
	}
	
	public String getItemQtyOnProductLevel() {
		HighlightElement(ItemQuantity);
		return ItemQuantity.getAttribute("value");
	}
	
	public void ClickGiftCardTile() {
		jsClick(GiftCardTile);
	}
	
	public boolean VerifyGiftCardSale() {
		getDriver().switchTo().activeElement();
		HighlightElement(GiftCardSalePopup);
		return GiftCardSalePopup.isDisplayed();
	}
	
	public void set_DefaultDenomination() {
		jsClick(EditButtonOnGiftCardPopup);
		delayWithGivenTime(1000);
		EditGiftCardDenomination1TextBox.clear();
		EditGiftCardDenomination1TextBox.sendKeys("30");
		jsClick(EditGiftCardDenominationSaveButton);
	}
	
	public void ClickOnInstantDenomination(String instantdenomination) {		
		for(WebElement ele:GiftCardPriceListButton) {
			if(ele.getText().equals(instantdenomination)) {
				jsClick(ele);
				break;
			}
		}	
		
}

	public String getGiftAmountValue() {
		HighlightElement(GiftCardAmountTextBox);
		return GiftCardAmountTextBox.getAttribute("value");
	}
	
	public void EnterAmountOnGiftamtField(String giftamount) {
		clearAndType(GiftCardAmountTextBox,giftamount);
		delayWithGivenTime(2000);
		GiftCardAmountTextBox.sendKeys(Keys.TAB);
	}
	
	
	public String getTotalGiftValue() {
		HighlightElement(GiftCardTotalPriceTextBox);
		return GiftCardTotalPriceTextBox.getAttribute("value");
	}

	public String VerifyTotalGiftValueTextboxIsDisabled() {
		HighlightElement(GiftCardTotalPriceTextBox);
		DoubleClick(GiftCardTotalPriceTextBox);
		GiftCardTotalPriceTextBox.sendKeys("20");
		delayWithGivenTime(2000);
		return GiftCardTotalPriceTextBox.getAttribute("value");
		// IsDisabled(GiftCardTotalPriceTextBox);
	}

	public void EnterProcessingFeesOnGiftSalePopup(String processingfee) {
		HighlightElement(ProcessingFeeTextBox);
		DoubleClick(ProcessingFeeTextBox);
		ProcessingFeeTextBox.sendKeys(processingfee);
		ProcessingFeeTextBox.sendKeys(Keys.TAB);
	}
	
	public String getGiftCardProcessingFee() {
		return ProcessingFeeTextBox.getAttribute("value");
	}
	
	public void EnterGiftCardNumber(String giftcardnumber) {
		clickAndType(GiftCardNumberTextBox,giftcardnumber);
	}
	
	public void ClearGiftCardNumber() {
		GiftCardNumberTextBox.clear();
	}
	
	public String getGiftCardNumber() {
		HighlightElement(GiftCardNumberTextBox);
		return GiftCardNumberTextBox.getAttribute("value");
	}
	
	public void SelectExistingGiftCardCustomer(String custname) {
		explicitWait(CustomerNameTextBox);
		HandleAutocomplete(CustomerNameTextBox,custname);
	}
	
	public void ClickGiftSalesPopupCloseIcon() {
		jsClick(CloseGiftCardPopup);
	}
	
	public void ClickSubmitBtnInGiftSalesPopup() {
		click(GiftCardSubmitButton);
	}
	
	public void ClickEditIconOnGiftCardPopup() {
		jsClick(EditButtonOnGiftCardPopup);
	}
	
	public boolean VerifyEditGiftCardDominationPopup() {
		HighlightElement(EditGiftCardDominationPopup);
		return EditGiftCardDominationPopup.isDisplayed();	
	}
	
	public void EditDenomination1TextBox(String denomination1) {
		HighlightElement(EditGiftCardDenomination1TextBox);
		DoubleClickAndType(EditGiftCardDenomination1TextBox,denomination1);
	}
	
	public void ClickEditGiftCardDenominationPopupCancelButton() {
		click(EditGiftCardDenominationCancelButton);
	}
	
	public String getGiftCardPrice1Denomination() {
		HighlightElement(giftcarddenominationprice1);
		return giftcarddenominationprice1.getText();
	}
	
	public void EditDenomination2TextBox(String denomination2) {
		HighlightElement(EditGiftCardDenomination2TextBox);
		DoubleClickAndType(EditGiftCardDenomination2TextBox,denomination2);
	}
	public void EditDenomination3TextBox(String denomination3) {
		HighlightElement(EditGiftCardDenomination3TextBox);
		DoubleClickAndType(EditGiftCardDenomination3TextBox,denomination3);
	}
	public void EditDenomination4TextBox(String denomination4) {
		HighlightElement(EditGiftCardDenomination4TextBox);
		DoubleClickAndType(EditGiftCardDenomination4TextBox,denomination4);
	}
	public void EditDenomination5TextBox(String denomination5) {
		HighlightElement(EditGiftCardDenomination5TextBox);
		DoubleClickAndType(EditGiftCardDenomination5TextBox,denomination5);
	}
	public void EditDenomination6TextBox(String denomination6) {
		HighlightElement(EditGiftCardDenomination6TextBox);
		DoubleClickAndType(EditGiftCardDenomination6TextBox,denomination6);
	}
	public void EditDenomination7TextBox(String denomination7) {
		HighlightElement(EditGiftCardDenomination7TextBox);
		DoubleClickAndType(EditGiftCardDenomination7TextBox,denomination7);
	}
	public void EditDenomination8TextBox(String denomination8) {
		HighlightElement(EditGiftCardDenomination8TextBox);
		DoubleClickAndType(EditGiftCardDenomination8TextBox,denomination8);
	}
	public void EditDenomination9TextBox(String denomination9) {
		HighlightElement(EditGiftCardDenomination9TextBox);
		DoubleClickAndType(EditGiftCardDenomination9TextBox,denomination9);
	}
	public void EditDenomination10TextBox(String denomination10) {
		HighlightElement(EditGiftCardDenomination10TextBox);
		DoubleClickAndType(EditGiftCardDenomination10TextBox,denomination10);
	}
		
	public String getGiftCardPrice2Denomination() {
		HighlightElement(giftcarddenominationprice2);
		return giftcarddenominationprice2.getText();
	}
	
	public String getGiftCardPrice3Denomination() {
		HighlightElement(giftcarddenominationprice3);
		return giftcarddenominationprice3.getText();
	}
	
	public String getGiftCardPrice4Denomination() {
		HighlightElement(giftcarddenominationprice4);
		return giftcarddenominationprice4.getText();
	}
	
	public String getGiftCardPrice5Denomination() {
		HighlightElement(giftcarddenominationprice5);
		return giftcarddenominationprice5.getText();
	}
	
	public String getGiftCardPrice6Denomination() {
		HighlightElement(giftcarddenominationprice6);
		return giftcarddenominationprice6.getText();
	}
	
	public String getGiftCardPrice7Denomination() {
		HighlightElement(giftcarddenominationprice7);
		return giftcarddenominationprice7.getText();
	}
	
	public String getGiftCardPrice8Denomination() {
		HighlightElement(giftcarddenominationprice8);
		return giftcarddenominationprice8.getText();
	}
	
	public String getGiftCardPrice9Denomination() {
		HighlightElement(giftcarddenominationprice9);
		return giftcarddenominationprice9.getText();
	}
	
	public String getGiftCardPrice10Denomination() {
		HighlightElement(giftcarddenominationprice10);
		return giftcarddenominationprice10.getText();
	}
	
	public void ClickEditGiftCardDenominationPopupSaveButton() {
		click(EditGiftCardDenominationSaveButton);
	}
	
	public boolean ISErrorToastMessageDisplayed() {
		HighlightElement(ErrorToastMsg);
		return ErrorToastMsg.isDisplayed();
	}
	
	public void ClickCloseIconOnErrorToastMessage() {
		click(ErrorToastMsgCloseBtn);
	}
	
	public void ClickAddCustomerButton() {
		click(AddCustomerButton);
	}
	
	public boolean VerifyAddNewCustomerPopup() {
		HighlightElement(AddNewCustomerPopup);
		return AddNewCustomerPopup.isDisplayed();
	}
	
	public void EnterAddNewCustFirstName(String firstname) {
		DoubleClickAndType(AddNewCustFirstNameTextbox, firstname);
	}

	
	public String getEnteredaddnewcustfirstname() {
		HighlightElement(AddNewCustFirstNameTextbox);
		return AddNewCustFirstNameTextbox.getAttribute("value");
	}
	
	public void EnterAddNewCustLastName(String lastname) {
		DoubleClickAndType(AddNewCustLastNameTextbox, lastname);
	}
	
	public String getEnteredaddnewcustlastname() {
		HighlightElement(AddNewCustLastNameTextbox);
		return AddNewCustLastNameTextbox.getAttribute("value");
	}
	
	public void EnterAddNewCustPhoneNumber(String phonenumber) {
		AddNewCustPhoneNumberTextbox.clear();
		DoubleClickAndType(AddNewCustPhoneNumberTextbox, phonenumber);
	}
	
	public String getEnteredaddnewcustphonenumber() {
		HighlightElement(AddNewCustPhoneNumberTextbox);
		return AddNewCustPhoneNumberTextbox.getAttribute("value");
	}
	
	public void EnterAddNewCustAltPhoneNumber(String altphonenumber) {
		AddNewCustAltPhoneNumberTextbox.clear();
		DoubleClickAndType(AddNewCustAltPhoneNumberTextbox, altphonenumber);	
	}
	
	public String getEnteredaddnewcustaltphonenumber() {
		HighlightElement(AddNewCustAltPhoneNumberTextbox);
		return AddNewCustAltPhoneNumberTextbox.getAttribute("value");
	}
	
	public void ClickAddNewCustPopupCloseIcon() {
		click(AddNewCustPopupCloseIcon);
	}
	
	public void EnterCompanyNameOnAddnewCustPopup(String companyname) {
		DoubleClickAndType(AddNewCustCompanyNameTextbox, companyname);
	}
	
	public String getEnteredaddnewcustcompanyname() {
		HighlightElement(AddNewCustCompanyNameTextbox);
		return AddNewCustCompanyNameTextbox.getAttribute("value");
	}
	
	public void EnterAddress1OnAddnewCustPopup(String address1) {
		DoubleClickAndType(AddNewCustAddress1Textbox, address1);
	}
	
	public String getEnteredaddnewcustaddress1() {
		HighlightElement(AddNewCustAddress1Textbox);
		return AddNewCustAddress1Textbox.getAttribute("value");
	}
	
	public void EnterAddress2OnAddnewCustPopup(String address2) {
		DoubleClickAndType(AddNewCustAddress2Textbox, address2);
	} 
	
	public String getEnteredaddnewcustaddress2() {
		HighlightElement(AddNewCustAddress2Textbox);
		return AddNewCustAddress2Textbox.getAttribute("value");
	}
	
	public void EnterZipCodeOnAddnewCustPopup(String zipcode) {
		DoubleClickAndType(AddNewCustZipCodeTextbox, zipcode);
	}
	
	public String getEnteredaddnewcustzipcode() {
		HighlightElement(AddNewCustZipCodeTextbox);
		return AddNewCustZipCodeTextbox.getAttribute("value");
	}
	
	public void EnterCityOnAddnewCustPopup(String city) {
		DoubleClickAndType(AddNewCustCityTextbox, city);
	}

	public String getEnteredaddnewcustcity() {
		HighlightElement(AddNewCustCityTextbox);
		return AddNewCustCityTextbox.getAttribute("value");
	}
 
	
	public void EnterStateOnAddnewCustPopup(String state) {
		DoubleClickAndType(AddNewCustStateTextbox, state);
	}
	
	public String getEnteredaddnewcuststate() {
		HighlightElement(AddNewCustStateTextbox);
		return AddNewCustStateTextbox.getAttribute("value");
	}
	
	public void EnterCountryOnAddnewCustPopup(String country) {
		DoubleClickAndType(AddNewCustCountryTextbox, country);
	}
	
	public String getEnteredaddnewcustcountry() {
		HighlightElement(AddNewCustCountryTextbox);
		return AddNewCustCountryTextbox.getAttribute("value");
	}
	
	public void EnterEmailOnAddnewCustPopup(String email) {
		DoubleClickAndType(AddNewCustEmailTextbox, email);
	}
	
	public String getEnteredaddnewcustemail() {
		HighlightElement(AddNewCustEmailTextbox);
		return AddNewCustEmailTextbox.getAttribute("value");
	}
	
	public void SelectCustTypeOnAddNewCustPopup(String custtype) {
		dropDown(AddNewCustTypeDropdown, custtype, "VisibleText");
	}
	
	public String getSelectedCustTypeOnAddNewCustPopup() {
		select = new Select(AddNewCustTypeDropdown);
		return select.getFirstSelectedOption().getText();
	}
	
	public void EnterCustCreditOnAddNewCustPopup(String custcredit) {
		DoubleClickAndType(AddNewCustCreditTextbox, custcredit);
	}
	
	public String getEnteredaddnewcustcredit() {
		HighlightElement(AddNewCustCreditTextbox);
		return AddNewCustCreditTextbox.getAttribute("value");
	}
	
	public void SelectShopNameOnAddNewCustPopup(String shopname) {	
		dropDown(AddNewCustShopDropdown, shopname, "VisibleText");
	}
	
	public String getSelectedShopNameOnAddNewCustPopup() {
		select = new Select(AddNewCustShopDropdown);
		return select.getFirstSelectedOption().getText();
	}
	
	public boolean ValidateCreditApprovedToogleOnAddNewCustPopup() {
		HighlightElement(AddNewCustPopupcreditapprovedToogle);
		return AddNewCustPopupcreditapprovedToogle.getAttribute("style").contains("rgb(223, 223, 223)");	
	}
	
	public boolean ValidatePaperlessStatementToogleOnAddNewCustPopup() {
		HighlightElement(AddNewCustPopupPaperlessStatementsToogle);
		return AddNewCustPopupPaperlessStatementsToogle.getAttribute("style").contains("rgb(223, 223, 223)");		
	} 
	
	public boolean ValidateEmailStatementToogleOnAddNewCustPopup() {
		HighlightElement(AddNewCustPopupEmailStatementToogle);
		return AddNewCustPopupEmailStatementToogle.getAttribute("style").contains("rgb(223, 223, 223)");	
	}
	
	public boolean ValidateEnableLoyaltyToogleOnAddNewCustPopup() {
		HighlightElement(AddNewCustPopupEnableLoyaltyToogle);
		return AddNewCustPopupEnableLoyaltyToogle.getAttribute("style").contains("rgb(223, 223, 223)");		
	}
	
	public boolean ValidateLateFeeSettingToogleOnAddNewCustPopup() {
		HighlightElement(AddNewCustPopupLateFeeSettingToogle);
		return AddNewCustPopupLateFeeSettingToogle.getAttribute("style").contains("rgb(223, 223, 223)");		
	}
	
	public boolean ValidateAllowSMSTToogleOnAddNewCustPopup() {
		HighlightElement(AddNewCustPopupAllowSMSToogle); // Red background color
		return AddNewCustPopupAllowSMSToogle.getAttribute("style").contains("rgb(223, 223, 223)");		
	}
	
	public boolean ValidateAllowFeedbackEmailTToogleOnAddNewCustPopup() {
		HighlightElement(AddNewCustPopupAllowFeedBackEmailToogle); // green background color 
		return AddNewCustPopupAllowFeedBackEmailToogle.getAttribute("style").contains("rgb(197, 231, 244)");		
	}
	
	public void ClickAddNewCustPopupAddNewCustBtn() {
		click(AddNewCustAddNewCustomerButton);
	}
	
	public void ClickOnSplitPaymentToogleButton() {
		click(SplitPaymentToogleButton);
	}
	
	public void EnterItemCodeOnCPDV(String itemcodeCPDV) {
		DoubleClickAndType(ItemCodeTextBoxChooseDefaultValues, itemcodeCPDV);
	}
	
	public String getEnteredItemCodeOnCPDV() {
		HighlightElement(ItemCodeTextBoxChooseDefaultValues);
		return ItemCodeTextBoxChooseDefaultValues.getAttribute("value");
	}
	
	public void EnterQtyonPhoneOrderCPDV(String PhoneOrderqtyCPDV) {
		jsClear(PhoneOrderQTYTextBoxChooseDefaultValues);
		DoubleClickAndType(PhoneOrderQTYTextBoxChooseDefaultValues, PhoneOrderqtyCPDV);
	}
	
	public String getEnteredQtyonPhoneOrderCPDV() {
		HighlightElement(PhoneOrderQTYTextBoxChooseDefaultValues);
		return PhoneOrderQTYTextBoxChooseDefaultValues.getAttribute("value");
	}
	
	public void EnterRecipientPhone(String recipientphone) {
		DoubleClickAndType(PhoneOrderRecipientPhoneTextBoxChooseDefaultValues, recipientphone);
	}
	
	public String getEnteredRecipientPhoneonPhoneOrderCPDV() {
		HighlightElement(PhoneOrderRecipientPhoneTextBoxChooseDefaultValues);
		return PhoneOrderRecipientPhoneTextBoxChooseDefaultValues.getAttribute("value");
	}
	
	public void EnterZipcodeOnPhoneOrderCPDV(String zipcodePhoneCPDV) {
		jsClear(PhoneOrderRecipientZipcodeTextBoxChooseDefaultValues);
		DoubleClickAndType(PhoneOrderRecipientZipcodeTextBoxChooseDefaultValues, zipcodePhoneCPDV);
	}
	
	public String getEnteredZipcodeOnPhoneOrderCPDV() {
		HighlightElement(PhoneOrderRecipientZipcodeTextBoxChooseDefaultValues);
		return PhoneOrderRecipientZipcodeTextBoxChooseDefaultValues.getAttribute("value");
	}
	
	public void SelectDefaultWireInMethod(String defaultWireInMethod) {
		dropDown(PhoneOrderWireInMethodDefaultValuesDD, defaultWireInMethod, "VisibleText");
	}
	
	public String getSelectedDefaultWireInMethod() {
		HighlightElement(PhoneOrderWireInMethodDefaultValuesDD);
		select = new Select(PhoneOrderWireInMethodDefaultValuesDD);
		return (select.getFirstSelectedOption().getText());
	}
	
	
	public void SelectDefaultWireOutMethod(String defaultWireOutMethod) {
		dropDown(PhoneOrderWireOutMethodDefaultValuesDD, defaultWireOutMethod, "VisibleText");
	}
	
	public String getSelectedDefaultWireOutMethod() {
		HighlightElement(PhoneOrderWireOutMethodDefaultValuesDD);
		select = new Select(PhoneOrderWireOutMethodDefaultValuesDD);
		return (select.getFirstSelectedOption().getText());
	}
	
	public void SelectDefaultPaymentType(String paymentType) {
		dropDown(PhoneOrderPaymentTypeDefaultValuesDD, paymentType, "VisibleText");
	}
	
	public String getSelectedDefaultPaymentType() {
		HighlightElement(PhoneOrderPaymentTypeDefaultValuesDD);
		select = new Select(PhoneOrderPaymentTypeDefaultValuesDD);
		return (select.getFirstSelectedOption().getText());
	}
	
	public void SelectDefaultCustomerType(String customerType) {
		dropDown(PhoneOrderCustomerTypeDefaultValuesDD, customerType, "VisibleText");
	}
	
	public String getSelectedDefaultCustomerType() {
		HighlightElement(PhoneOrderCustomerTypeDefaultValuesDD);
		select = new Select(PhoneOrderCustomerTypeDefaultValuesDD);
		return (select.getFirstSelectedOption().getText());
	}
	
	public void SelectDefaultSalesPerson(String salesPerson) {
		dropDown(PhoneOrderSalesPersonDefaultValuesDD, salesPerson, "VisibleText");
	}
	
	public String getSelectedDefaultSalesPerson() {
		HighlightElement(PhoneOrderSalesPersonDefaultValuesDD);
		select = new Select(PhoneOrderSalesPersonDefaultValuesDD);
		return (select.getFirstSelectedOption().getText());
	}
	
	public void SelectDefaultCountry(String country) {
		dropDown(PhoneOrderSelectCountryDefaultValuesDD, country, "VisibleText");
	}
	
	public String getSelectedDefaultCountry() {
		HighlightElement(PhoneOrderSelectCountryDefaultValuesDD);
		select = new Select(PhoneOrderSelectCountryDefaultValuesDD);
		return (select.getFirstSelectedOption().getText());
	}
	
	public void SelectDefaultLocation(String country) {
		dropDown(PhoneOrderSelectLocationDefaultValuesDD, country, "VisibleText");
	}
	
	public String getSelectedDefaultLocation() {
		HighlightElement(PhoneOrderSelectLocationDefaultValuesDD);
		select = new Select(PhoneOrderSelectLocationDefaultValuesDD);
		return (select.getFirstSelectedOption().getText());
	}
	
	public void SelectDefaultOccasion(String country) {
		dropDown(PhoneOrderSelectOccasionDefaultValuesDD, country, "VisibleText");
	}
	
	public String getSelectedDefaultOccasion() {
		HighlightElement(PhoneOrderSelectOccasionDefaultValuesDD);
		select = new Select(PhoneOrderSelectOccasionDefaultValuesDD);
		return (select.getFirstSelectedOption().getText());
	}
	
	public void SelectDefaultOrderType(String country) {
		dropDown(PhoneOrderSelectOrderTypeDefaultValuesDD, country, "VisibleText");
	}
	
	public String getSelectedDefaultOrderType() {
		HighlightElement(PhoneOrderSelectOrderTypeDefaultValuesDD);
		select = new Select(PhoneOrderSelectOrderTypeDefaultValuesDD);
		return (select.getFirstSelectedOption().getText());
	}
	
	public void ClickCloseIconOnChooseDefaultValuesPage() {
		jsClick(CloseIconOnChooseDefaultValuesPagePopup);
	}
	
	public void ClickUpdateButtonOnChooseDefaultValuesPage() {
		jsClick(ChooseDefaultValuesUpdateButton);
	}
	
	public String VerifyToolTipOnLeftSideTileProduct() {
		Actions action = new Actions(getDriver());
		action.moveToElement(flowerstd_leftside_displayedTile_Prod).build().perform();
		delayWithGivenTime(500);	
	//	MouseHover(flowerstd_leftside_displayedTile_Prod);
		delayWithGivenTime(2000);
		String prodTile_tooltip = flowerstd_leftside_displayedTile_Prod.getAttribute("title");
		return prodTile_tooltip;
	}
	
	public void PressAltKeyH_SalesHistory() {
		Actions actions = new Actions(getDriver());
		actions.keyDown(Keys.ALT).sendKeys("h").keyUp(Keys.ALT).build().perform();
	}
	
	public boolean VerifyCashDrawPopupDisplayed() {
		HighlightElement(CashDrawPopupHeader);
		return CashDrawPopupHeader.isDisplayed();
	}
	
	public void SelectShopCashDrawPopup(String shopname) {
		dropDown(ShopPayoutDropDown, shopname, "VisibleText");
	}
	
	public void SelectCashRegisterId(String cashregisterid) {
		//ClerkPayoutDropDown.click();
	//	delayWithGivenTime(1000);
		dropDown(ClerkPayoutDropDown, cashregisterid, "value");		
	}
	
	public void Select_CashRegisterId(String cashregisterid) {
		ClerkPayoutDropDown.click();
		delayWithGivenTime(1000);
		for(int i = 0; i<ClerkPayoutDropDownList.size(); i++) {
			if(ClerkPayoutDropDownList.get(i).getText().contains(cashregisterid)) {
			(ClerkPayoutDropDownList.get(i)).click();
				break;
			}	
		}		
	}
	
	public String getSelectedCashRegisterId() {
		HighlightElement(ClerkPayoutDropDown);
		select = new Select(ClerkPayoutDropDown);
		return (select.getFirstSelectedOption().getText());
	}
	
	public void EnterNameonCashDrawPopup(String name) {
		DoubleClickAndType(NamePayoutTextBox, name);
	}
	
	public String getEnteredNameonCashDrawPopup() {
		return NamePayoutTextBox.getAttribute("value");
	}
	
	public void EnterReasononCashDrawPopup(String reason) {
		DoubleClickAndType(ReasonPayoutTextBox, reason);
	}
	
	public String getEnteredReasononCashDrawPopup() {
		return ReasonPayoutTextBox.getAttribute("value");
	}
	
	public void EnterSubTotalonCashDrawPopup(String subtotal) {
		jsClear(SubTotalPayoutTextBox);
		DoubleClickAndType(SubTotalPayoutTextBox, subtotal);
	}
	
	public String getEnteredSubTotalonCashDrawPopup() {
		return SubTotalPayoutTextBox.getAttribute("value");
	}
	
	public void EnterTaxAmountonCashDrawPopup(String taxamount) {
		jsClear(TaxAmountPayoutTextBox);
		DoubleClickAndType(TaxAmountPayoutTextBox, taxamount);
	}
	
	public String getEnteredTaxAmountonCashDrawPopup() {
		return TaxAmountPayoutTextBox.getAttribute("value");
	}
	
	public boolean VerifyGrandTotalonCashDrawPopup() {
		HighlightElement(GrandTotalPayoutTextBox);	
		boolean isDisabled = false;
		if(GrandTotalPayoutTextBox.isEnabled()==false) {
			 isDisabled =GrandTotalPayoutTextBox.isEnabled();
		}
		return isDisabled;
	}
	
	public void ClickCloseIcon() {
		jsClick(CloseiconCashDrawPopup);
	}
	
	public void ClickSaveBtnOnCashDrawPopup() {
		jsClick(SavePayoutBtn);
	}
	
	public void ClickOnReconcileBtn() {
		jsClick(ReconcileBtn);
	}
	
	public boolean VerifyReconcilePopupDisplayed() {
		HighlightElement(ReconcilePopupHeader);
		return ReconcilePopupHeader.isDisplayed();
	}
	
	public String getSelectedCashRegistryonReconcilePopup() {
		HighlightElement(ClerkReconcileDropDown);
		select = new Select(ClerkReconcileDropDown);
		return (select.getFirstSelectedOption().getText());
	}

	public void Select_CashRegistryIdonReconcilePopup(String reconcilecashregisterid) {	
		ClerkReconcileDropDown.click();
		for(int i = 0; i<listOfClerkReconcileDropDown.size(); i++) {
			if(listOfClerkReconcileDropDown.get(i).getText().contains(reconcilecashregisterid)) {
			(listOfClerkReconcileDropDown.get(i)).click();
				break;
			}	
		}
		
		//dropDown(ClerkReconcileDropDown, reconcilecashregisterid, "value");		
	}
	
	public void SelectShopReconcilePopup(String reconcileshopname) {
		dropDown(ShopReconcileDropDown, reconcileshopname, "VisibleText");
	}
	
	public String getSelectedShopNameonReconcilePopup() {
		HighlightElement(ShopReconcileDropDown);
		select = new Select(ShopReconcileDropDown);
		return (select.getFirstSelectedOption().getText());
	}	
	
	public String getPayOut_Amount_OnReconcilePopup() {
		HighlightElement(payOutAmt_ReconcilePopup);
		return payOutAmt_ReconcilePopup.getText();		
	}
	
	public String ExpectedCalculatedPayoutAmount() {
		String previousactualamount = getPayOut_Amount_OnReconcilePopup() ;
		double addedamount = 100.00;
		
		String Expected = previousactualamount;
		System.out.println("Expected value is :"+Expected);
		return Expected;
	}
	
	public String ValidateLastReconciliationdate() {
		HighlightElement(lastReconcillationDate);
		return lastReconcillationDate.getText();		
	}
	
	public boolean VerifyOpenBalanceOnReconcilePopup() {
		HighlightElement(openBalance);
		return openBalance.isDisplayed();
	}
	
	public boolean VerifyExpectedBalance() {
		HighlightElement(expectedBalance);
		return expectedBalance.isDisplayed();
	}
	
	public String getExpectedBalance() {
		HighlightElement(expectedBalance);
		return expectedBalance.getText();
	}
	
	public boolean VerifyActualBalance() {
		HighlightElement(actualBalance);
		return actualBalance.isDisplayed();
	}
	
	public String getActualBalance() {
		HighlightElement(actualBalance);
		return actualBalance.getText();
	}
	
	public String ExpectedBalanceDifference() {
		double expectedBalanceDifference =   Double.parseDouble(getActualBalance()) - Double.parseDouble(getExpectedBalance()) ;
		DecimalFormat df = new DecimalFormat("#.00");
		String formattedexpectedBalanceDifference = df.format(expectedBalanceDifference);
		
		System.out.println("Expected Balance Difference is :"+formattedexpectedBalanceDifference);
		return formattedexpectedBalanceDifference;
	}
	
	public String ExpectedActualBalance() {
		double OneDollar = Double.parseDouble(oneDollars_denomination.getAttribute("value").trim());		
		double TwoDollars =  Double.parseDouble(twoDollars_denomination.getAttribute("value").trim());
		double FiveDollars =  Double.parseDouble(fiveDollars_denomination.getAttribute("value").trim());
		double TwentyDollars =  Double.parseDouble(twentyDollars_denomination.getAttribute("value").trim());
		double FiftyDollars =  Double.parseDouble(fiftyDollars_denomination.getAttribute("value").trim());	
		double OneHundredDollars =  Double.parseDouble(oneHundredDollars_denomination.getAttribute("value").trim());		
		
		double actualDenominationBalance = (OneDollar*1 + TwoDollars*2 + FiveDollars*5 + TwentyDollars*20 + FiftyDollars*50 + OneHundredDollars*100);
		System.out.println("Actual Denomination Balance is :"+actualDenominationBalance);
		
		double pennies = Double.parseDouble(pennies_denomination.getAttribute("value").trim());	
		double nickles = Double.parseDouble(nickles_denomination.getAttribute("value").trim());
		double dimes = Double.parseDouble(dimes_denomination.getAttribute("value").trim());
		double quarters = Double.parseDouble(quarters_denomination.getAttribute("value").trim());
		
		double actualCoinBalance = (pennies * 0.01) + (nickles * 0.05) + (dimes * 0.10) + (quarters * 0.25);
		System.out.println("Actual Coin Balance is :"+actualCoinBalance);
		
		double expected_Actual_Balance = actualDenominationBalance+actualCoinBalance;
		
		DecimalFormat df = new DecimalFormat("#.00");
		String formattedexpected_Actual_Balance = df.format(expected_Actual_Balance);
				
		System.out.println("Expected Actual Balance is :"+formattedexpected_Actual_Balance);
		return formattedexpected_Actual_Balance;
	}
	
	
	public double parseOrDefault(String value) {
		
	        if (value == null || value.trim().isEmpty()) {
	            return 0;
	        } else {
	            return Double.parseDouble(value.trim());
	        }
	    
	}

	public String Expected_Actual_Balance() {
	    // Method to safely parse double from string, defaulting to 0.0 if the string is empty
	   
	    // Parse denomination values
	    double OneDollar = parseOrDefault(oneDollars_denomination.getAttribute("value"));     
	    double TwoDollars = parseOrDefault(twoDollars_denomination.getAttribute("value"));
	    double FiveDollars = parseOrDefault(fiveDollars_denomination.getAttribute("value"));
	    double TwentyDollars = parseOrDefault(twentyDollars_denomination.getAttribute("value"));
	    double FiftyDollars = parseOrDefault(fiftyDollars_denomination.getAttribute("value"));  
	    double OneHundredDollars = parseOrDefault(oneHundredDollars_denomination.getAttribute("value"));      
	    
	    double actualDenominationBalance = (OneDollar * 1 + TwoDollars * 2 + FiveDollars * 5 + TwentyDollars * 20 + FiftyDollars * 50 + OneHundredDollars * 100);
	    System.out.println("Actual Denomination Balance is :" + actualDenominationBalance);
	    
	    // Parse coin values
	    double pennies = parseOrDefault(pennies_denomination.getAttribute("value"));   
	    double nickles = parseOrDefault(nickles_denomination.getAttribute("value"));
	    double dimes = parseOrDefault(dimes_denomination.getAttribute("value"));
	    double quarters = parseOrDefault(quarters_denomination.getAttribute("value"));
	    
	    double actualCoinBalance = (pennies * 0.01) + (nickles * 0.05) + (dimes * 0.10) + (quarters * 0.25);
	    System.out.println("Actual Coin Balance is :" + actualCoinBalance);
	    
	    double expected_Actual_Balance = actualDenominationBalance + actualCoinBalance;
	    
	    DecimalFormat df = new DecimalFormat("#.00");
	    String formattedexpected_Actual_Balance = df.format(expected_Actual_Balance);
	            
	    System.out.println("Expected Actual Balance is :" + formattedexpected_Actual_Balance);
	    return formattedexpected_Actual_Balance;
	}

	
	public boolean VerifyDiffernce() {
		HighlightElement(difference);
		return difference.isDisplayed();
	}
	
	public String getActualBalanceDifference() {
		HighlightElement(difference);
		return difference.getText();
	}
	
	public boolean VerifyDifferenceFieldRedColorAppears() {
		return differencefieldcolor.getAttribute("class").contains("Red");
	}
	
	public boolean VerifyDifferenceFieldGreenColorAppears() {
		return differencefieldcolor.getAttribute("class").contains("Green");
	}
	
	public boolean VerifyCashRegisterSalesReview_dateTime() {
		HighlightElement(CashRegisterSalesReview_dateTime);
		return CashRegisterSalesReview_dateTime.isDisplayed();
	}
	
	public boolean VerifyCashRegisterSalesReview_Cash() {
		HighlightElement(CashRegisterSalesReview_Cash);
		return CashRegisterSalesReview_Cash.isDisplayed();
	}
	
	public boolean VerifyCashRegisterSalesReview_AfterTax() {
		HighlightElement(CashRegisterSalesReview_AfterTax);
		return CashRegisterSalesReview_AfterTax.isDisplayed();
	}
	
	public boolean VerifyCashRegisterSalesReview_TotalSales() {
		HighlightElement(CashRegisterSalesReview_TotalSales);
		return CashRegisterSalesReview_TotalSales.isDisplayed();
	}
	
	public boolean VerifyCashRegisterSalesReview_StartCash() {
		HighlightElement(CashRegisterSalesReview_StartCash);
		return CashRegisterSalesReview_StartCash.isDisplayed();
	}
	
	public String getCashInDrawerCalculation() {
		String cash = CashRegisterSalesReview_AfterTax.getText();
		String startcash = CashRegisterSalesReview_StartCash.getText();
		String payout = CashRegisterSalesReview_PayoutAmt.getText();	
		
		double cashvalue = Double.parseDouble(cash);
		double startcashvalue = Double.parseDouble(startcash);
		double payoutvalue = Double.parseDouble(payout);
		
		double cashInDrawer = (cashvalue + startcashvalue) - payoutvalue;
		
		DecimalFormat df = new DecimalFormat("#.00");
		String formattedExpectedcashInDrawer = df.format(cashInDrawer);
		
		
	//	String formattedCashInDrawer =	String.format("%.2f", cashInDrawer);
		System.out.println("Cash In Drawer is :" + formattedExpectedcashInDrawer);
		return formattedExpectedcashInDrawer;
	}
	
	public String getCashInDrawer() {
		HighlightElement(CashRegisterSalesReview_CashInDrawer);
		return CashRegisterSalesReview_CashInDrawer.getText();	
	}
	
	public void EnterOneDollarDenomination(String onedollardenomination) {
		DoubleClickAndType(oneDollars_denomination, onedollardenomination);
	}
	
	public void EnterTwoDollarDenomination(String twodollardenomination) {
		DoubleClickAndType(twoDollars_denomination, twodollardenomination);
	}
	
	public void EnterfiveDollarDenomination(String fivedollardenomination) {
		DoubleClickAndType(fiveDollars_denomination, fivedollardenomination);
	}
	
	public void EnterFiftyDollarDenomination(String fiftydollardenomination) {
		DoubleClickAndType(fiftyDollars_denomination, fiftydollardenomination);
	}
	
	public void EnterOneHundredDollarDenomination(String onehundreddollardenomination) {
		DoubleClickAndType(oneHundredDollars_denomination, onehundreddollardenomination);
	}
	
	public void EnterPenniesDenomination(String penniesdenomination) {
		DoubleClickAndType(pennies_denomination, penniesdenomination);
	}
	
	public void EnterTwentyDollarDenomination(String twentydollardenomination) {
		DoubleClickAndType(twentyDollars_denomination, twentydollardenomination);
	}
	
	public String getEnteredTwentyDollarDenomination() {
		HighlightElement(twentyDollars_denomination);
		return twentyDollars_denomination.getAttribute("value");
	}
	
	public void ClickReconcileBtnInPopup() {
		click(ReconcileBtn_ReconcilePopup);
	}
	
	public void ValidateDifferenceFieldDisplayedColor() {
		HighlightElement(difference);
        String color = difference.getCssValue("color");
        String backgroundColor = difference.getCssValue("background-color");

        // Print the color and background color values
        System.out.println("Color: " + color);
        System.out.println("Background Color: " + backgroundColor);

        // Expected color values for red (these values may vary depending on the implementation)
        String expectedColor = "rgba(255, 0, 0, 1)"; // This is a common value for red
        String expectedBackgroundColor = "rgba(255, 255, 255, 1)"; // Assuming white background for contrast

        // Validate that the color is red
        if (color.equals(expectedColor) || backgroundColor.equals(expectedColor)) {
            System.out.println("The difference field is highlighted in red.");
        } else {
            System.out.println("The difference field is not highlighted in red.");
        }
	}	
}
	




