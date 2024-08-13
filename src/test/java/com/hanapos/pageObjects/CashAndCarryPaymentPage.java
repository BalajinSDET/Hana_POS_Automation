package com.hanapos.pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.hanapos.seleniumProjectBase.TestBaseClass;

public class CashAndCarryPaymentPage extends TestBaseClass {
	public CashAndCarryPaymentPage() {
		PageFactory.initElements(getDriver(), this);
	}
	public Select select;
	
	@FindBy(xpath="//a[@class='btn btn-warning btn-sm btn']")
	private WebElement backBtn;
	
	@FindBy(xpath="//h3[contains(text(),'Payment')]")
	private WebElement PaymentPage;
	
	@FindBy(id="tabCash")
	private WebElement CashTab;
	
	@FindBy(xpath="//p[@id='lblCustomerId']")
	private WebElement CustomerId;
	
	@FindBy(xpath="//p[@id='lblCustomerName']")
	private WebElement CustomerName;
	
	@FindBy(xpath="//button[@id='btnProcessPayment']")
	private WebElement ProcessPaymentBtn;
	
	@FindBy(xpath="(//span[@class='switchery switchery-default'])[3]")
	private WebElement SplitPaymentBtnOnCCPPage;
	
	@FindBy(xpath="(//button[@class='btn btn-primary btnAddCustomer'][normalize-space()='Add'])[2]")
	private WebElement AddCustomerBtnOnCCPPage;
	
	@FindBy(xpath="(//button[@class='btn btn-danger resetCutomerBtn'][normalize-space()='X'])[2]")
	private WebElement crossIconOnAddCustPopup;
	
	@FindBy(xpath="//h4[@id='AddNewCustomerModalTitle']")
	private WebElement AddNewCustomerPopup;
	
	@FindBy(xpath="(//div[@class='modal-header customer-modal-header']//a//i)[7]")
	private WebElement CloseIconAddNewCustPopup;
	
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
	
	@FindBy(xpath = "(//input[@id='txtSearchProductForPayment'])[1]")
	private WebElement searchandselectcustomertextbox;
	
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
	
	@FindBy(xpath="(//p[@id='lblCustomerName'])[1]")
	private WebElement CustomerNameOnCCPPage;
	
	@FindBy(xpath="(//p[@id='lblCustomerId'])[1]")
	private WebElement CustomerIdOnCCPPage;
	
	
	
	
	
	@FindBy(xpath="//div[@class='toast-title']")
	private WebElement ErrorToastMsg;
	
	@FindBy(xpath="//div[@class='toast-message']")
	private WebElement ErrorToastMsgCloseBtn;
	
	@FindBy(xpath="//table[@id='tblFinalProducts']")
	private WebElement paymentTableDescription;
	
	@FindBy(xpath="(//td[@Class='pad-left'])[2]")
	private WebElement paymentTableRow1Description;
	
	@FindBy(xpath="(//tbody//td[@align='right'])[1]")
	private WebElement paymentTableRow1DiscountAmount;
	
	@FindBy(xpath="(//tbody//td[@align='right'])[2]")
	private WebElement paymentTableRow1ExtPrice;
	
	@FindBy(xpath="//td[@id='tdSubTotalDisplay']")
	private WebElement paymentTableSubTotal;
	
	@FindBy(xpath="//td[@id='tdGST']")
	private WebElement paymentTableGST;
	
	@FindBy(xpath="//td[@id='tdPST']")
	private WebElement paymentTablePST;
	
	@FindBy(xpath="//td[@id='tdTax']")
	private WebElement paymentTableTax;
	
	@FindBy(xpath="//h4[@id='tdGrandTotal']")
	private WebElement paymentTableGrandTotal;
	
	@FindBy(xpath="//input[@id='txtGivenAmount']")
	private WebElement GivenAmountTextboxField;
	
	@FindBy(xpath="//input[@id='txtSearchProductForPayment']")
	private WebElement CustomerSelectionTextboxField;
	
	//----------------------Confirmation popup ------------------------------------
	@FindBy(xpath="//div[@id='PrintOrderNewModal']//div[@class='modal-content']")
	private WebElement PopupOrderconfirmation;
	
	@FindBy(xpath="//h3[normalize-space()='Order Confirmation']")
	private WebElement OrderConfirmationPopup;
	
	@FindBy(xpath="//label[@id='lblMsg']")
	private WebElement OrderConfirmationMsgAndInvoiceNo;
	
	@FindBy(xpath="//label[@id='lblBalance']")
	private WebElement BalanceGivenToCustomerMsg;
	
	@FindBy(xpath="(//div[@class='modal-header row']//div//a//i)[1]")
	private WebElement OrderConfirmationPopupCloseBtn;
	
	@FindBy(xpath="//div[@class='toast-message']")
	private WebElement OrderConfirmationToastMsg;
	
	@FindBy(id="txtCustEmail")
	private WebElement OrderConfirmationPopupCustEmailTextbox;
	
	@FindBy(id="SMSPhoneNo")
	private WebElement OrderConfirmationPopupSMSTextbox;
	
	@FindBy(id="btnSendEmailReciept")
	private WebElement SendRecieptBtn;
	
	//-----------------Check Payment Page----------------------------------------------------
	
	@FindBy(xpath="//h3[contains(text(),'Check')]")
	private WebElement CheckPaymentPage;
	
	@FindBy(xpath="//a[@id='tabCheck']")
	private WebElement CheckTab;
	
	@FindBy(xpath="//input[@id='txtCheckNumber']")
	private WebElement CheckNumberTextboxField;
	
	@FindBy(xpath="(//input[@id='txtBankName'])[1]")
	private WebElement BankNameTextboxField;
	
	@FindBy(xpath="(//input[@id='txtNameOnCheck'])[1]")
	private WebElement NameOnCheckTextboxField;
	
	@FindBy(xpath="//input[@id='txtCheckAmount']")
	private WebElement CheckTabAmountTextboxField;
	
	//---------------------Split Payment Page---------------------------------------------------
	@FindBy(xpath="//h3[contains(text(),'Split Payment')]")
	private WebElement SplitPaymentPage;
	
	@FindBy(xpath="//span[@id='lblInvoiceNumber']")
	private WebElement SplitPayment_InvoiceNumberLeftTopCorner;
	
	//---------------------Product Description Table---------------------------------------------

	@FindBy(xpath="//tbody[@id='tblFinalItem']//tr[1]//td[1]")
	private WebElement paymentTableRow1ProductDescription;
	
	@FindBy(xpath="//tbody[@id='tblFinalItem']//tr[2]//td[1]")
	private WebElement paymentTableRow2ProductDescription;
	
	@FindBy(xpath="//td[@id='tdSubTotalDisplay']")
	private WebElement TableSubTotalValues;
	
	@FindBy(xpath="//td[@id='tdGST']")
	private WebElement TableGSTValues;
	
	@FindBy(xpath="//td[@id='tdPST']")
	private WebElement TablePSTValues;
	
	@FindBy(xpath="//td[@id='tdTax']")
	private WebElement TableTaxValues;
	
	@FindBy(xpath="//td[@id='tdCCFee']")
	private WebElement paymentTableConvFee;
	
	@FindBy(xpath="(//td[@Class='clsMPO'])[1]")
	private WebElement paymentTypeRow1;
	
	@FindBy(xpath="(//td[@Class='clsMPO'])[2]")
	private WebElement paymentTypeRow2;
	
	@FindBy(xpath="(//td[@Class='clsMPO'])[3]")
	private WebElement paymentTypeRow3;
	
	@FindBy(xpath="(//td[@Class='clsMPO'])[4]")
	private WebElement paymentTypeRow4;
	
	@FindBy(xpath="(//td[@class='clsPaidAmt'])[1]")
	private WebElement paymentTablePaidAmtRow1;
	
	@FindBy(xpath="(//td[@class='clsPaidAmt'])[2]")
	private WebElement paymentTablePaidAmtRow2;
	
	@FindBy(xpath="(//td[@class='clsPaidAmt'])[3]")
	private WebElement paymentTablePaidAmtRow3;
	
	@FindBy(xpath="(//td[@class='clsPaidAmt'])[4]")
	private WebElement paymentTablePaidAmtRow4;
	
	
	
	//----------------------Credit card Payment ---------------------------------------------
	

	
	@FindBy(xpath="//a[@id='tabCC']")
	private WebElement CreditCardTab;
	
	@FindBy(xpath="(//span[@class='switchery switchery-default'])[2]")
	private WebElement CreditCardPresentToogleBtn;
	
	@FindBy(xpath="(//input[@id='txtFirstName'])[1]")
	private WebElement CreditCardFirstNameTextboxField;
	
	@FindBy(xpath="(//input[@id='txtLastName'])[1]")
	private WebElement CreditCardLastNameTextboxField;
	
	@FindBy(xpath="(//select[@id='SelectCardOption'])[1]") //Add New Card
	private WebElement CreditCardSelectCardDropdown;
	
	@FindBy(xpath="(//input[@id='txtCardNumber'])[1]")
	private WebElement CreditCardNumberTextboxField;
	
	@FindBy(xpath="(//input[@id='txtExpiryDate'])[1]")
	private WebElement CreditCardExpiryDateTextboxField;
	
	@FindBy(xpath="(//input[@id='txtCVV'])[1]")
	private WebElement CreditCardCVVTextboxField;
	
	@FindBy(xpath="(//input[@id='txtZipCode'])[1]")
	private WebElement CreditCardZipCodeTextboxField;
	
	@FindBy(xpath="(//input[@id='txtSplitCreditCardPayment'])[1]")
	private WebElement CreditCardPaymentTextboxField;
	
	@FindBy(xpath="//select[@id='ddlClerkSplitPayment']")
	private WebElement SplitPaymentCashRegistryDropdown;
	
	//----------------------------- POH Payment ---------------------------------------------
	
	@FindBy(xpath="//a[@id='tabPOH']")
	private WebElement POHPaymentTab;
	
	@FindBy(xpath="(//input[@id='txtPOHAmt'])[1]")
	private WebElement POHAmountTextboxField;
	
	//------------------------- Gift card payment -----------------------------
	@FindBy(xpath="//a[@id='tabGiftCard']")
	private WebElement GiftCardPaymentTab;
	
	@FindBy(xpath="(//input[@id='btnSwipeCardForGiftCard'])[1]")
	private WebElement GiftCardSwipeCardBtn;
	
	@FindBy(xpath="(//input[@id='txtCardNumberForGiftCard'])[1]")
	private WebElement GiftCardNumberTextboxField;
	
	@FindBy(xpath="//input[@id='txtFirstNameForGiftCard']")
	private WebElement GiftCardCustomerNameTextboxField;
	
	@FindBy(xpath="//span[@id='lblSplitedBalanaceAmount']")
	private WebElement splitedBalanceAmountOnTable;
	
	@FindBy(xpath="(//input[@id='txtPayWithGiftCardAmount'])[1]")
	private WebElement GiftCardPaymentAmtTextboxField;
	
	@FindBy(xpath="(//input[@id='txtGiftCardAvailableBalance'])[1]")
	private WebElement GiftCardAvailableBalanceTextboxField;
	
	@FindBy(xpath="//button[@id='btnFinish']")
	private WebElement FinishBtn;
	
	@FindBy(xpath="//div[@class='sweet-alert showSweetAlert visible']")
	private WebElement AlertPopup;
	
	@FindBy(xpath="(//div[@class='sa-icon sa-warning pulseWarning'])[1]")
	private WebElement AlertPopupWarningIcon;
	
	@FindBy(xpath="//h2[contains(text(),'This order is still not fully paid.')]")
	private WebElement AlertPopupWarningText;
	
	@FindBy(xpath="//button[normalize-space()='Stay']")
	private WebElement AlertPopupStayBtn;
	
	@FindBy(xpath="//button[normalize-space()='Leave']")
	private WebElement AlertPopupLeaveBtn;
	
	@FindBy(xpath="//span[@id='lblFullPaidNote']")
	private WebElement OrderFullyPaidNote;
	
	@FindBy(xpath="//a[@id='btnPhoneOrder']")
	private WebElement ConvertToDelivery;
	
	// ------------------------------------ Invoice Tab Payment ---------------------------------------
	@FindBy(xpath="//a[@id='tbInvoice']")
	private WebElement InvoicePaymentTab;
	
	@FindBy(xpath="//select[@id='ddlPaymentTerm']")
	private WebElement InvoicePaymentTermDropdown;
	
	@FindBy(xpath="//a[@id='btnBackToPanelIntialInfo']")
	private WebElement BackButtonOnCCPpage;
	
	@FindBy(xpath="(//a[normalize-space()='POH (F7)'])[1]")
	private WebElement POH_Tab;
	
	// ==================== Donation Payment Section ====================
	@FindBy(xpath="(//a[normalize-space()='Donation (F9)'])[1]")
	private WebElement Donation_Tab;
	
	@FindBy(xpath="(//label[contains(text(),'EIN Number')])[1]")
	private WebElement EINNumber_Label;
	
	@FindBy(xpath="(//input[@id='txtEINNumber'])[1]")
	private WebElement EINNumber_Textbox;
	
	
	public boolean IsPaymentPageDisplayed() {
		HighlightElement(PaymentPage);
		return PaymentPage.isDisplayed();
	}
	
	public boolean verifyPaymentDescriptionTableIsDisplayed() {
		HighlightElement(paymentTableDescription);
		return paymentTableDescription.isDisplayed();
	}
	
	public String getRow1PaymentDescription() {
		return paymentTableRow1Description.getText();
	}
	
	public String getRow1PaymentDiscountAmount() {
		return  paymentTableRow1DiscountAmount.getText();
		//String[] discountAmt = disAmt.split("$");
	}
	
	public String getRow1PaymentExtPrice() {
		return paymentTableRow1ExtPrice.getText();
	}
	
	public String getPaymentSubTotal() {
		return paymentTableSubTotal.getText();
	}
	
	public String getPaymentGST() {
		return paymentTableGST.getText();
	}
	
	public String getPaymentPST() {
		return paymentTablePST.getText();
	}
	
	public String getPaymentTax() {
		return paymentTableTax.getText();
	}
	
	public String getPaymentGrandTotal() {
		return paymentTableGrandTotal.getText();
	}
	
	public String ValidateGrandTotalWithoutConvFee() {
		double subTotal = Double.parseDouble(TableSubTotalValues.getText().replace("$", "").trim());
		double gst = Double.parseDouble(TableGSTValues.getText().replace("$", "").trim());
		double psthstqst = Double.parseDouble(TablePSTValues.getText().replace("$", "").trim());
		double tax = Double.parseDouble(TableTaxValues.getText().replace("$", "").trim());
	//	double convFee = Double.parseDouble(paymentTableConvFee.getText().replace("$", "").trim());


		double expectedGrandTotal = (subTotal + gst + psthstqst + tax );

		// Format the numbers to two decimal places
		DecimalFormat df = new DecimalFormat("#.00");
		String formattedExpectedGrandTotal = df.format(expectedGrandTotal);
		return formattedExpectedGrandTotal;
	}
	
	public String ValidateGrandTotalWithConvFee() {
		double subTotal = Double.parseDouble(TableSubTotalValues.getText().replace("$", "").trim());
		double gst = Double.parseDouble(TableGSTValues.getText().replace("$", "").trim());
		double psthstqst = Double.parseDouble(TablePSTValues.getText().replace("$", "").trim());
		double tax = Double.parseDouble(TableTaxValues.getText().replace("$", "").trim());
		double convFee = Double.parseDouble(paymentTableConvFee.getText().replace("$", "").trim());


		double expectedGrandTotal = (subTotal + gst + psthstqst + tax + convFee);

		// Format the numbers to two decimal places
		DecimalFormat df = new DecimalFormat("#.00");
		String formattedExpectedGrandTotal = df.format(expectedGrandTotal);
		return formattedExpectedGrandTotal;
	}
	
	public String getGrandTotaltoPay() {
		String grandTotal =paymentTableGrandTotal.getText();
		grandTotal = grandTotal.replace("$", "");
		return grandTotal;
	}
	
	public void EnterGivenAmount() {
		DoubleClickAndType(GivenAmountTextboxField,getGrandTotaltoPay());
	}
	
	public void EnterGivenAmountOnCashTab(String cashamount) {
		fluentWait(GivenAmountTextboxField);
		GivenAmountTextboxField.clear();
		delayWithGivenTime(1000);
		GivenAmountTextboxField.sendKeys(cashamount);
		//DoubleClickAndType(GivenAmountTextboxField,cashamount); //CashGivenAmountTextboxField
	}
	
	public boolean VerifyGivenAmountOnCashTabTextboxIsDisplayed() {
		HighlightElement(GivenAmountTextboxField);
		return GivenAmountTextboxField.isDisplayed();
	}
	
	public void PressF8Key_GiftcardTab() {
		
	}
	
	public String getEnteredGivenAmountOnCashTab() {
	return GivenAmountTextboxField.getAttribute("value");
	}
	
	public CashAndCarryPaymentPage ClickCashTab() {
		jsClick(CashTab);
		return this;
	}
	
	public String GetCustomerId() {
		return CustomerId.getText();
	}
	
	public String GetCustomerName() {
		return CustomerName.getText();
		
	}
	
	public CashAndCarryPaymentPage ClickProcessPaymentBtn() {
			fluentWait(ProcessPaymentBtn);
			jsClick(ProcessPaymentBtn);
			return this;
	}
	
	public boolean VerifyProcessPaymentButton() {
		HighlightElement(ProcessPaymentBtn);
		return (ProcessPaymentBtn.isEnabled());
	}
	
	public boolean VerifyProcessPaymentDisabled() {
		HighlightElement(ProcessPaymentBtn);
		boolean isDisabled = ProcessPaymentBtn.getAttribute("disabled")!= null;		
		return isDisabled;
	}
	
	public boolean GetOrderConfirmationMsgAndInvoiceNo() {
		getDriver().switchTo().activeElement();
		HighlightElement(OrderConfirmationMsgAndInvoiceNo);
		return OrderConfirmationMsgAndInvoiceNo.isDisplayed();
	}
	
	public String GetBalanceGivenToCustomerMsg() {
		HighlightElement(BalanceGivenToCustomerMsg);
		return BalanceGivenToCustomerMsg.getText();
	}
	
	public void ClickOrderConfirmationPopupCloseBtn() {
		jsClick(OrderConfirmationPopupCloseBtn);
	}
	
	public boolean VerifyOrderConfirmationPopupCloseBtn() {
		HighlightElement(OrderConfirmationPopupCloseBtn);
		return OrderConfirmationPopupCloseBtn.isDisplayed();
	}
	
	public boolean VerifyOrderConfirmationPopup() {
	//	delayWithGivenTime(3000);
		HighlightElement(OrderConfirmationPopup);
		return	OrderConfirmationPopup.isDisplayed();
	}
	
	public String VerifyPaymentSuccessMsg() {
		return OrderConfirmationMsgAndInvoiceNo.getText();
	}
	
	public String GetInvoiceNumber() {
		String OrderMsg = OrderConfirmationMsgAndInvoiceNo.getText();		
        String[] InvoiceNumber = OrderMsg.split(":");
        String InvoiceNo = InvoiceNumber[1].trim();
        return InvoiceNo;
	}
	
	public String GetTenderPrice() {
	String RemBal =	BalanceGivenToCustomerMsg.getText();
	 String[] RemainingBalance = RemBal.split("\\s+");
	 return RemainingBalance[2];
	}
	
	public boolean SuccessToastMsg() {
		HighlightElement(OrderConfirmationToastMsg);
		return OrderConfirmationToastMsg.isDisplayed();		
	}
	
	public boolean VerifyErrorToastMsg() {
		HighlightElement(OrderConfirmationToastMsg);
		return OrderConfirmationToastMsg.isDisplayed();		
	}
	
	public String getOrderConfirmationToastMsg() {
		HighlightElement(OrderConfirmationToastMsg);
		return OrderConfirmationToastMsg.getText();
	}
	
	public String getGeneratedInvoiceNumber() {
		String invoiceNo = OrderConfirmationToastMsg.getText();
		String[] InvoiceNo = invoiceNo.split(":");
		String generatedInvoiceNo = InvoiceNo[1].trim();
		return generatedInvoiceNo;
	}
	
	public boolean getConfirmationPopup() {
		return PopupOrderconfirmation.isDisplayed();
	}
	
	public CashAndCarryPaymentPage SearchAndSelectCustomer(String customershorttext) {
		explicitWait(CustomerSelectionTextboxField);
		HandleAutocomplete(CustomerSelectionTextboxField,customershorttext); //"abish"
		return this;	
	}
	
	public void ClickBackButtonOnTopRightCorner() {
			jsClick(backBtn);
	}
	
	public String GetConfirmationPopupCustEmail() {
		HighlightElement(OrderConfirmationPopupCustEmailTextbox);
		return OrderConfirmationPopupCustEmailTextbox.getAttribute("value");
	}
	
	public String GetConfirmationPopupCustSMS() {
		HighlightElement(OrderConfirmationPopupSMSTextbox);
		return OrderConfirmationPopupSMSTextbox.getAttribute("value");	
	}
	
	public void ClickSendReciptBtnOnOrderConfirmationPopup() {
		click(SendRecieptBtn);
	}
	
	public void ClickCheckTab() {
		click(CheckTab);
	}
	
	public boolean VerifyCheckTabDisplayed() {
		HighlightElement(CheckNumberTextboxField);
		return CheckNumberTextboxField.isDisplayed();
	}
	
	public String getDisplayedCheckNumber() {
		HighlightElement(CheckNumberTextboxField);
		return CheckNumberTextboxField.getAttribute("value");
	}
	
	public void EnterCheckNumber(String checknumber) {
		DoubleClickAndType(CheckNumberTextboxField,checknumber);
	}
	
	public String getDisplayedBankName() {
		HighlightElement(BankNameTextboxField);
		return BankNameTextboxField.getAttribute("value");
	}
	
	public void EnterBankName(String bankname) {
		DoubleClickAndType(BankNameTextboxField,bankname);
	}
	
	public String getDisplayedCheckName() {
		HighlightElement(NameOnCheckTextboxField);
		return NameOnCheckTextboxField.getAttribute("value");
	}
	
	public void EnterNameOnCheck(String nameoncheck) {
		DoubleClickAndType(NameOnCheckTextboxField,nameoncheck);
	}
	
	public String getTopLeftCornerInvNo() {
		HighlightElement(SplitPayment_InvoiceNumberLeftTopCorner);
		return SplitPayment_InvoiceNumberLeftTopCorner.getText();
	}

	public String getRow1ProductInTable() {
		HighlightElement(paymentTableRow1ProductDescription);
		return paymentTableRow1ProductDescription.getText();
	}

	public String getRow2ProductInTable() {
		HighlightElement(paymentTableRow2ProductDescription);
		return paymentTableRow2ProductDescription.getText();
	}
	
	public void ClickCreditCardTab() {
		click(CreditCardTab);
	}
	
	public String VerifyCreditCardTabIsSelected() {
		HighlightElement(CreditCardTab);
		String CreditCardTabSelected = CreditCardTab.getAttribute("aria-expanded"); // aria-expanded
		 return CreditCardTabSelected;
	}
	
	public void ClickCreditCardPresentToogleBtn() {
		click(CreditCardPresentToogleBtn);
	}
	
	public boolean VerifyCreditCardPresentToogleBtnIsAppear() {
		return CreditCardPresentToogleBtn.isDisplayed();
	}
	
	public boolean VerifyCreditCardPresentToogleBtnIsSelected() {
		return CreditCardPresentToogleBtn.getAttribute("style").contains("rgb(26, 179, 148)"); // rgb(26, 179, 148)
	}
	
	public void EnterFirstNameOnCreditCardTab(String creditcardfirstname) {
		DoubleClickAndType(CreditCardFirstNameTextboxField, creditcardfirstname);
	}
	
	public String getEnteredCreditCardFirstName() {
		return CreditCardFirstNameTextboxField.getAttribute("value");
	}
	
	public boolean VerifyCreditCardFirstNameIsDisabled() {
		return IsDisabled(CreditCardFirstNameTextboxField);
	}
	
	public void EnterLastNameOnCreditCardTab(String creditcardlastname) {
		DoubleClickAndType(CreditCardLastNameTextboxField, creditcardlastname);
	}
	
	public String getEnteredCreditCardLastName() {
		return CreditCardLastNameTextboxField.getAttribute("value");
	}
	
	public boolean VerifyCreditCardLastNameIsDisabled() {
		return IsDisabled(CreditCardLastNameTextboxField);
	}
	
	public void SelectCreditCardTypeOnCreditCardTab(String creditcardtype) {
		dropDown(CreditCardSelectCardDropdown, creditcardtype, "VisibleText");
	}	
	
	public String getSelectCreditCardType() {
		return CreditCardLastNameTextboxField.getAttribute("value");
	}
	
	public boolean VerifySelectCreditCardTypeIsDisabled() {
		return IsDisabled(CreditCardSelectCardDropdown);
	}
	
	public void EnterCreditCardNumberOnCreditCardTab(String creditcardnumber) {
		DoubleClickAndType(CreditCardNumberTextboxField, creditcardnumber);
	}
	
	public String getEnterCreditCardNumber() {
		return CreditCardNumberTextboxField.getAttribute("value");
	}
	
	public boolean VerifyEnterCreditCardNumberIsDisabled() {
		return IsDisabled(CreditCardNumberTextboxField);
	}
	
	public void EnterCreditCardExpireDateOnCreditCardTab(String creditcardExpireDate) {
		DoubleClickAndType(CreditCardExpiryDateTextboxField, creditcardExpireDate);
	}
	
	public String getEnterCreditCardExpireDate() {
		return CreditCardExpiryDateTextboxField.getAttribute("value");
	}
	
	public boolean VerifyEnterCreditCardExpireDateIsDisabled() {
		return IsDisabled(CreditCardExpiryDateTextboxField);
	}
	
	public void EnterCreditCardCVVOnCreditCardTab(String creditcardCVV) {
		DoubleClickAndType(CreditCardCVVTextboxField, creditcardCVV);
	}
	
	public String getEnterCreditCardCVV() {
		return CreditCardCVVTextboxField.getAttribute("value");
	}
	
	public boolean VerifyEnterCreditCardCVVIsDisabled() {
		return IsDisabled(CreditCardCVVTextboxField);
	}
	
	public void EnterCreditCardZipCodeOnCreditCardTab(String creditcardZipCode) {
		DoubleClickAndType(CreditCardZipCodeTextboxField, creditcardZipCode);
	}
	
	public String getEnterCreditCardZipCode() {
		return CreditCardZipCodeTextboxField.getAttribute("value");
	}
	
	public boolean VerifyEnterCreditCardZipCodeIsDisabled() {
		return IsDisabled(CreditCardZipCodeTextboxField);
	}
		
	public void EnterCreditCardAmountOnCreditCardTab(String creditcardamount) {
		DoubleClickAndType(CreditCardPaymentTextboxField, creditcardamount);
	}
	
	public void SelectRegistryOnCashTab(String registry) {
		dropDown(SplitPaymentCashRegistryDropdown, registry, "VisibleText");
	}
	
	public void EnterAmountOnCheckTab(String checkamount) {
		DoubleClickAndType(CheckTabAmountTextboxField, checkamount);
	}
	
	public String getEnteredAmountOnCheckTab() {
		HighlightElement(CheckTabAmountTextboxField);
		return CheckTabAmountTextboxField.getAttribute("value");
	}
	
	public String VerifyPaymentTypeOnTableRow1() {
		HighlightElement(paymentTypeRow1);
		paymentTypeRow1.isDisplayed();
		return paymentTypeRow1.getText();
	}
	
	public String VerifyPaidAmountOnTableRow1() {
		HighlightElement(paymentTablePaidAmtRow1);
		paymentTablePaidAmtRow1.isDisplayed();
		return paymentTablePaidAmtRow1.getText();
	}
	
	public String VerifyPaymentTypeOnTableRow2() {
		HighlightElement(paymentTypeRow2);
		paymentTypeRow2.isDisplayed();
		return paymentTypeRow2.getText();
	}
	
	public String VerifyPaidAmountOnTableRow2() {
		HighlightElement(paymentTablePaidAmtRow2);
		paymentTablePaidAmtRow2.isDisplayed();
		return paymentTablePaidAmtRow2.getText();
	}
	
	public String VerifyPaymentTypeOnTableRow3() {
		HighlightElement(paymentTypeRow3);
		paymentTypeRow3.isDisplayed();
		return paymentTypeRow3.getText();
	}
	
	public String VerifyPaidAmountOnTableRow3() {
		HighlightElement(paymentTablePaidAmtRow3);
		paymentTablePaidAmtRow3.isDisplayed();
		return paymentTablePaidAmtRow3.getText();
	}
	
	public String VerifyPaymentTypeOnTableRow4() {
		HighlightElement(paymentTypeRow4);
		paymentTypeRow4.isDisplayed();
		return paymentTypeRow4.getText();
	}
	
	public String VerifyPaidAmountOnTableRow4() {
		HighlightElement(paymentTablePaidAmtRow4);
		paymentTablePaidAmtRow4.isDisplayed();
		return paymentTablePaidAmtRow4.getText();
	}
	
	public void ClickOnPOHPaymentTab() {
		jsClick(POHPaymentTab);
	}
	
	public void EnterPOHAmountOnPOHPaymentTab(String pohamount) {
		DoubleClickAndType(POHAmountTextboxField, pohamount);
	}
	
	public String getEnteredPOHAmountOnPOHPaymentTab() {
		return POHAmountTextboxField.getAttribute("value");
	}
	
	public void ClickOnGiftCardPaymentTab() {
		click(GiftCardPaymentTab);
	}
	
	public void EnterGiftCardNumberOnGiftCardPaymentTab(String giftcardnumber) {
		DoubleClickAndType(GiftCardNumberTextboxField, giftcardnumber);
		delayWithGivenTime(1000);
		GiftCardNumberTextboxField.sendKeys(Keys.TAB);
	}
		
	public String getEnteredGiftCardAmountOnGiftCardPaymentTab() {
		HighlightElement(GiftCardNumberTextboxField);
		return GiftCardNumberTextboxField.getAttribute("value");
	}
	
	public String getDisplayedCustNameOnGiftCardPaymentTab() {
		HighlightElement(GiftCardCustomerNameTextboxField);
		return GiftCardCustomerNameTextboxField.getAttribute("value");
	}
	
	public String getDisplayedPaymentAmtOnGiftCardPaymentTab() {
		HighlightElement(GiftCardPaymentAmtTextboxField);
		return GiftCardPaymentAmtTextboxField.getAttribute("value");
	}
	
	public String getTableDisplayedBalanceAmt() {
		return splitedBalanceAmountOnTable.getText();
	}
	
	public void EnterPaymentAmtOnGiftCardPaymentTab(String paymentamount) {
		DoubleClickAndType(GiftCardPaymentAmtTextboxField, paymentamount);
	}
	
	public void ClickFinishBtnOnCashAndCarryPaymentPage() {
		click(FinishBtn);
	}
	
	public boolean VerifyAlertPopup() {
		HighlightElement(AlertPopup);
		return AlertPopup.isDisplayed();
	}
	
	public boolean VerifyAlertIcon() {
		HighlightElement(AlertPopupWarningIcon);
		return AlertPopupWarningIcon.isDisplayed();
	}
	
	public String VerifyAlertPopupWarningText() {
		HighlightElement(AlertPopupWarningText);
		AlertPopupWarningText.isDisplayed();
		return AlertPopupWarningText.getText();
	}
	
	public void ClickOnAlertPopupLeaveBtn() {
		click(AlertPopupLeaveBtn);
	}
	
	public boolean VerifyOrderPaidTextAppears() {
		return OrderFullyPaidNote.isDisplayed();
	}
	
	public String VerifyFullyPaidMessage() {
		HighlightElement(OrderFullyPaidNote);
	//	OrderFullyPaidNote.isDisplayed();
		return OrderFullyPaidNote.getText();
	}
	
	public void ClickConvertToDeliveryBtn() {
		click(ConvertToDelivery);
	}
	
	public void ClickSplitPaymentBtn() {
		jsClick(SplitPaymentBtnOnCCPPage);
	}
	
	public void ClickInvoiceTab() {
		jsClick(InvoicePaymentTab);
	}
	
	public boolean VerifyInvoiceTermDropdown() {
		HighlightElement(InvoicePaymentTermDropdown);
		return InvoicePaymentTermDropdown.isDisplayed();
	}
	
	public void SelectPaymentTermsOnInvDD(String invterms) {
		dropDown(InvoicePaymentTermDropdown, invterms, "VisibleText");
	}
	
	public String getSelectedPaymentTermsOnInvDD() {
		select = new Select(InvoicePaymentTermDropdown);
		return select.getFirstSelectedOption().getText();
	}
	
	public void ClickBackButton() {
		jsClick(BackButtonOnCCPpage);
	}
	
	public void ClickPOHTab() {
		jsClick(POH_Tab);
	}
	
	public boolean VerifyIsSwipeGiftCardButtonDisplayed() {
		HighlightElement(GiftCardSwipeCardBtn);
		return GiftCardSwipeCardBtn.isDisplayed();
	}
	
	public void ClickSwipeGiftCardButton() {
		jsClick(GiftCardSwipeCardBtn);
	}
	
	
	public String VerifyGiftCardCurrentBalance() {
		HighlightElement(GiftCardAvailableBalanceTextboxField);
		GiftCardAvailableBalanceTextboxField.isDisplayed();
		return GiftCardAvailableBalanceTextboxField.getAttribute("value");
	}
	
	public void ClickAddNewCustButtonOnCCP() {
		jsClick(AddCustomerBtnOnCCPPage);
	}
	
	public void ClickAddNewCustCloseIconPopup() {
		jsClick(CloseIconAddNewCustPopup);
	}
	
	public boolean VerifyAddNewCustPopupIsDisplayed() {
		HighlightElement(AddNewCustomerPopup);
		return AddNewCustomerPopup.isDisplayed();
	}
	
	public void ClickAddNewCustPopupCloseIcon() {
		jsClick(AddNewCustPopupCloseIcon);
	}
	
	public String getSearchandselectCustDisplayedData() {
		HighlightElement(searchandselectcustomertextbox);
		return searchandselectcustomertextbox.getAttribute("value");
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
		DoubleClickAndType(AddNewCustPhoneNumberTextbox, phonenumber);
	}
	
	public String getEnteredaddnewcustphonenumber() {
		HighlightElement(AddNewCustPhoneNumberTextbox);
		return AddNewCustPhoneNumberTextbox.getAttribute("value");
	}
	
	public void EnterAddNewCustAltPhoneNumber(String altphonenumber) {
		DoubleClickAndType(AddNewCustAltPhoneNumberTextbox, altphonenumber);	
	}
	
	public String getEnteredaddnewcustaltphonenumber() {
		HighlightElement(AddNewCustAltPhoneNumberTextbox);
		return AddNewCustAltPhoneNumberTextbox.getAttribute("value");
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
		jsClick(AddNewCustAddNewCustomerButton);
	}

	public String getDisplayedCustomerNameOnCCPage() {
		HighlightElement(CustomerNameOnCCPPage);
		return CustomerNameOnCCPPage.getText();
	}
	
	public boolean Verify_CustomerName_AppearsOnCCPage() {
		return CustomerNameOnCCPPage.isDisplayed();
	}
	
	public void ClickCrossIconOnAddNewCust() {
		jsClick(crossIconOnAddCustPopup);
	}
	
	public CashAndCarryPaymentPage EnterCustomerName(String customername) {
		explicitWait(searchandselectcustomertextbox);
		HandleAutocomplete(searchandselectcustomertextbox,customername); //"abish"
		return this;
	}
	
	public String getCustomerIdDisplayed() {
		HighlightElement(CustomerIdOnCCPPage);	
		return CustomerIdOnCCPPage.getText();
	}
	
	public boolean Verify_CustomerIdAppears_OnCCPage() {
		return CustomerIdOnCCPPage.isDisplayed();
	}
	
	public void ClickDonationTab() {
		click(Donation_Tab);
	}
	
	public boolean Verify_EIN_Number_IsDisplayed() {
		HighlightElement(EINNumber_Label);
		return EINNumber_Label.isDisplayed();
	}
	
	public void EnterEINNumber(String EINNumber) {
		DoubleClickAndType(EINNumber_Textbox, EINNumber);
	}
	
	public String getEnteredEinNumber() {
		HighlightElement(EINNumber_Textbox);
		return EINNumber_Textbox.getAttribute("value");
	}
	
}
