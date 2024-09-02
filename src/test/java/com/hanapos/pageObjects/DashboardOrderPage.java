package com.hanapos.pageObjects;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hanapos.seleniumProjectBase.TestBaseClass;

public class DashboardOrderPage extends TestBaseClass{
	private CashAndCarryPaymentPage cashandcarrypayment;
	public DashboardOrderPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath="(//div[@class='form-group has-search']//input)[1]")
	private WebElement Global_search_OrderPage;
	
	@FindBy(xpath="(//ul[@class='typeahead dropdown-menu'])[1]//li//a")
	private List<WebElement> listOfGlobal_search_OrderPage;

	@FindBy(xpath = "//span[@class='set-invoice-number']")
	private List<WebElement> listOfInvoiceNumber;

	@FindBy(xpath="//td[contains(text(),'Walkin Sales')]")
	private List<WebElement> listOfWalkinSales;
	
	@FindBy(xpath="//td[contains(text(),'Phone Order')]")
	private List<WebElement> listOfPhoneOrder;

	@FindBy(xpath="//td[contains(text(),'Pick Up')]")
	private List<WebElement> listOfPickUp;

	@FindBy(xpath="//td[contains(text(),'Cash')]")
	private List<WebElement> listOfCashMOP;
	
	@FindBy(xpath="//td[contains(text(),'Invoice/House Account')]")
	private List<WebElement> listOfInvoiceHouseAccount;
	
	@FindBy(xpath="//td[contains(text(),'Paid Outside Hana')]")
	private List<WebElement> listOfPaidOutsideHana;
	
	@FindBy(xpath="//td[contains(text(),'Gift Card')]")
	private List<WebElement> listOfGiftCard;
	
	@FindBy(xpath="//td[contains(text(),'Donation')]")
	private List<WebElement> listOfDonation;
	
	@FindBy(xpath="//table[@role='grid']//tr[1]//td[4]")
	private List<WebElement> listOfOrderStatus;

	@FindBy(xpath = "//table[@role='grid']//tr//td[@class='set-order-detail-text']")
	private List<WebElement> listOfOrderDetail;

	@FindBy(xpath = "(//table[1]/tbody[1]/tr[1]/td[5])[1]")
	private List<WebElement> firstrowOfOrderDetail;
	
	@FindBy(xpath="//span[@class='set-value-column-text-bold']")
	private List<WebElement> listOfInvoiceAmountValue;
	
	@FindBy(xpath="//table[@role='grid']//tr[1]//td[7]")
	private List<WebElement> listOfSenderCustomer;
	
	@FindBy(xpath="//table[@role='grid']//tr[1]//td[5]")
	private List<WebElement> listOfOrderDetailOnInvoicePopup;
	
	@FindBy(xpath="//span[normalize-space()='Pick Up Walkin Sales']")
	private WebElement deliveryPopup;
	
	@FindBy(xpath="//span[@class='CustType']")
	private WebElement deliveryCustType;
	
	@FindBy(xpath="//strong[@class='set-sender-reciver-desc']")
	private WebElement custAndcompyNameOnDeliveryPopup;
	
	@FindBy(xpath="(//p[@class='set-sender-reciver-desc remove-margin'])")
	private WebElement CustAddressOnDeliveryPopup;
	
	@FindBy(xpath="//span[@class='custPhoneNum']//a")
	private WebElement CustPhoneNumOnDeliveryPopup;
	
	@FindBy(xpath="//span[@class='custemail']//a")
	private WebElement CustEmailOnDeliveryPopup;
	
	@FindBy(xpath="//div[@class='modal-close-icon']")
	private WebElement DeliveryPopupCloseIcon;
	
	@FindBy(xpath="//a[@href='/Dashboard/CustomerNew']")
	private WebElement CustomerMenu;
	
	@FindBy(xpath="//span[@class='RecipientDetails test']")
	private WebElement RecipientName_InvPopup;
	
	@FindBy(xpath="//span[@class='RecipientPhone']")
	private WebElement RecipientPhone_InvPopup;
	
	@FindBy(xpath="//span[@class='set-receiveraddress-font']")
	private WebElement RecipientAddress_InvPopup;
	
	@FindBy(xpath="//small[@class='set-color-ordertype']//span")
	private WebElement OrderType_On_InvPopup;
	
	@FindBy(xpath="(//div[@class='list-group-item no-padding']//p)[3]")
	private WebElement confidentialReq_Message_DeliveryPopup;
	
	@FindBy(xpath=" (//div[@class=' PadLeft text-left no-padding'])[2]")
	private WebElement occasion_InvPopup;
	
	@FindBy(xpath="//h3[@class='CardMessageOccation']//following::div[2]")
	private WebElement cardmessage_InvPopup;
	
	@FindBy(xpath="//p[@class='item-name text-wrap']")
	private WebElement productTab_ProductDescription_OnInvPopup;
	
	@FindBy(xpath="(//div[@Class='PadLeft text-left no-padding'])[3]")
	private WebElement sourcecode_OnInvPopup;
	
	@FindBy(xpath="(//div[contains(@class, 'sender-reciver-tbl')])[2]")
	private WebElement splInstruction_OnInvPopup;
	
	@FindBy(xpath="(//div[contains(@class, 'sender-reciver-tbl')])[3]")
	private WebElement driverInstruction_OnInvPopup;
	
	@FindBy(xpath="//small[@class='set-color-ordertype']//span")
	private WebElement deliveryType_OnInvoicePopup;
	
	@FindBy(xpath="//table[@class='set-boarder-zero set-padding-order-detail']//tbody//tr[3]//td[2]")
	private List<WebElement> ListOfMOP_OnOrderPageTable;
	
	@FindBy(xpath="//table[@class='set-boarder-zero set-padding-order-detail']//tbody//tr[2]//td[2]")
	private List<WebElement> ListOfDeliveryType_OnOrderPageTable;
	
	@FindBy(xpath="//table[@class='set-boarder-zero set-padding-order-detail']//tbody//tr[1]//td[2]")
	private List<WebElement> ListOfOrderType_OnOrderPageTable;
	
	@FindBy(xpath="//table[@class='set-boarder-zero set-padding-order-detail'][2]//tbody//tr[1]//td[2]")
	private List<WebElement> Wire_ListOfOrderType_OnOrderPageTable;
	
	@FindBy(xpath="//td[6]")
	private List<WebElement> ListOfRecipient_OnOrderPageTable;
	
	@FindBy(xpath="(//td[@class='text-left DAmountlabel'])[4]//following::td[1]")
	private WebElement salesTax_OnDeliveryPopup_Invoice;
	
	@FindBy(xpath="//div[@class='fa fa-flag IsFlagColor']")
	private WebElement RedflagIcon_OnOrderpage;
	
	@FindBy(xpath="//td[contains(@class,'hana-grid-row-fullview order-status-col')]")
	private WebElement OrderStatus_OnOrderPage;
	
	@FindBy(xpath="//span[@class='label label-info']")
	private WebElement OrderStatus_InvPopup;
	
	@FindBy(xpath="(//div[@class=' PadLeft text-left no-padding'])[3]")
	private WebElement driverName_InvPopup;
	
	@FindBy(xpath="//a[text()='Dispatch']")
	private WebElement dispatchTab_InvPopup;
	
	@FindBy(xpath="//p[@class='allinform']")
	private WebElement dispatch_ConfirmationMessage_InvPopup;
	
	@FindBy(xpath="//a[text()='Status']")
	private WebElement statusTab_InvPopup;
	
	@FindBy(xpath="(//table[@class='table table-striped']//tbody)[7]//tr[1]/td[1]")
	private WebElement statusTable_row1_Date;
	
	@FindBy(xpath="(//table[@class='table table-striped']//tbody)[7]//tr[1]/td[2]")
	private WebElement statusTable_row1_statusType;
	
	@FindBy(xpath="//span[@class='set-font-msg-desc']")
	private WebElement deliveryontruck_msg_on_Activity;
	
	@FindBy(xpath="//div[@class='set-msg-border-container']//b")
	private WebElement deliveryontruck_dateandtime_on_Activity;
	
	@FindBy(xpath="//div[@class='set-msg-border-container']")
	private WebElement deliveryontruck_fullmsg_on_Activity;
	
	public String validateDashboardOrderPage() {
		return	getDriver().getCurrentUrl();
	}

	public void EnterGlobalSearch(String globalsearch) {
		Global_search_OrderPage.clear();
		delayWithGivenTime(1000);
		Global_search_OrderPage.sendKeys(globalsearch);
		delayWithGivenTime(1000);
		Global_search_OrderPage.sendKeys(Keys.ENTER);
	}
	
	public boolean ValidateInvoiceNumber() {
		boolean invoiceNumber = false;
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().equals("Walkin Sales") 
				&& listOfPickUp.get(0).getText().equals("Pick Up") 
				&& listOfCashMOP.get(0).getText().equals("Cash")) {			
			HighlightElement(listOfInvoiceNumber.get(0));
			invoiceNumber =	listOfInvoiceNumber.get(0).isDisplayed();
		
		}	return invoiceNumber;			 		
	}
	
	public String getInvoiceNumber_Walkin_pickup_Cash_OnOrderPage() {
	    // Ensure that listOfWalkinSales, listOfPickUp, and listOfCashMOP contain elements before accessing them
	    if (!listOfWalkinSales.isEmpty() && !listOfPickUp.isEmpty() && !listOfCashMOP.isEmpty()) {
	      
	    	if (listOfWalkinSales.get(0).getText().equals("Walkin Sales") 
	            && listOfPickUp.get(0).getText().equals("Pick Up") 
	            && listOfCashMOP.get(0).getText().equals("Cash")) {
	                
	            if (!listOfInvoiceNumber.isEmpty()) { // Ensure the list is not empty
	            	System.out.println("Order Page walkin sales - pickup - Cash - Invoice Number is :"+listOfInvoiceNumber.get(0).getText());
	                return listOfInvoiceNumber.get(0).getText();
	            }
	        }
	    }
	    return null; 
	}

	public String get_Walkins_Pickup_POH_MOP_DisplayedOnOrderPage() {
		String paidOutsideHana_Invoice = null;
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().equals("Walkin Sales") 
				&& listOfPickUp.get(0).getText().equals("Pick Up")
				&& listOfPaidOutsideHana.get(0).getText().equals("Paid Outside Hana")) {
				paidOutsideHana_Invoice = listOfInvoiceNumber.get(0).getText();
				System.out.println("Paid Outside Hana Invoice number: "+paidOutsideHana_Invoice);
		}return paidOutsideHana_Invoice;
	}
	
	public boolean Validate_POH_MOP_DisplayedOnOrderPage() {
		boolean paidOutsideHana = false;
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().equals("Walkin Sales") 
				&& listOfPickUp.get(0).getText().equals("Pick Up")
				&& listOfPaidOutsideHana.get(0).getText().equals("Paid Outside Hana")) {
			delayWithGivenTime(1000);
			paidOutsideHana = listOfPaidOutsideHana.get(0).isDisplayed();
		}return paidOutsideHana;
	}
	
	public String get_Walkins_Pickup_GiftCard_OnOrderPage() {
		String giftcard_Invoice=null;
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().equals("Walkin Sales") 
				&& listOfPickUp.get(0).getText().equals("Pick Up")
				&&	listOfGiftCard.get(0).getText().equals("Gift Card")) {			
				giftcard_Invoice=listOfInvoiceNumber.get(0).getText();
		}return giftcard_Invoice;
	}
	
	public boolean Validate_GiftCard_MOP_DisplayedOnOrderPage() {
		boolean giftcard_Invoice=false;
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().equals("Walkin Sales") 
				&& listOfPickUp.get(0).getText().equals("Pick Up")
				&&	listOfGiftCard.get(0).getText().equals("Gift Card")) {
				giftcard_Invoice=listOfGiftCard.get(0).isDisplayed();
		}return giftcard_Invoice;
	}
	
	public String get_Walkins_Pickup_Donation_OnOrderPage() {
		String donation_Invoice=null;
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().equals("Walkin Sales") 
				&& listOfPickUp.get(0).getText().equals("Pick Up")
				&&	listOfDonation.get(0).getText().equals("Donation")) {	
				delayWithGivenTime(1000);
				donation_Invoice=listOfInvoiceNumber.get(0).getText();						
		}return donation_Invoice;
	}
	
	public boolean Validate_Donation_MOP_DisplayedOnOrderPage() {
		boolean donation_Invoice=false;
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().equals("Walkin Sales") 
				&& listOfPickUp.get(0).getText().equals("Pick Up")
				&&	listOfDonation.get(0).getText().equals("Donation")) {
				HighlightElement(listOfDonation.get(0));
				donation_Invoice=listOfDonation.get(0).isDisplayed();						
		}return donation_Invoice;
	}
	
	public String getStatusOnOrderPage() {
		String status = null;
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().equals("Walkin Sales") 
				&& listOfPickUp.get(0).getText().equals("Pick Up")
				&&	listOfDonation.get(0).getText().equals("Donation")) {
				HighlightElement(listOfOrderStatus.get(0));
				status=	listOfOrderStatus.get(0).getText();
		}return status;
	}
	
	public String GetInvoiceAmount_Walkin_pickup_Cash_OnOrderPage() {
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().contains("Walkin Sales")
				&&listOfPickUp.get(0).getText().contains("Pick Up")
				&&listOfCashMOP.get(0).getText().contains("Cash")) {
			HighlightElement(listOfWalkinSales.get(0));
			delayWithGivenTime(1000);
			HighlightElement(listOfOrderDetail.get(0));
			delayWithGivenTime(1000);
			HighlightElement(firstrowOfOrderDetail.get(0));
			delayWithGivenTime(1000);
			HighlightElement(listOfInvoiceAmountValue.get(0));
			delayWithGivenTime(1000);
		}	return listOfInvoiceAmountValue.get(0).getText();			 		
	}
	
	public boolean Validate_PhoneOrder_Pickup_Cash_InvoiceNumber() {
		boolean invoiceNumber = false;
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().contains("Phone Order") 
				&& listOfPickUp.get(0).getText().contains("Pick Up") 
				&& listOfCashMOP.get(0).getText().contains("Cash")) {
			
			/*
			 * HighlightElement(listOfPhoneOrder.get(0)); delayWithGivenTime(1000);
			 * HighlightElement(listOfOrderDetail.get(0)); delayWithGivenTime(1000);
			 * HighlightElement(firstrowOfOrderDetail.get(0)); delayWithGivenTime(1000);
			 * HighlightElement(listOfInvoiceNumber.get(0)); delayWithGivenTime(1000);
			 */
			 invoiceNumber = listOfInvoiceNumber.get(0).isDisplayed();
		
		}	return 	invoiceNumber;		 		
	}
	
	public String get_InvoiceNumber_PhoneOrder_PickUp_Cash() {
		String invoiceNumber = null;
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().equals("Phone Order") 
				&& listOfPickUp.get(0).getText().equals("Pick Up") 
				&& listOfCashMOP.get(0).getText().equals("Cash")) {
			
			 invoiceNumber = listOfInvoiceNumber.get(0).getText();
		
		}	return 	invoiceNumber;	
	
}
	
	public String get_InvoiceNumber_PhoneOrder_PickUp_InvoiceHouse() {
		String invoiceNumber = null;
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().contains("Phone Order") 
				&& listOfPickUp.get(0).getText().contains("Pick Up") 
				&& listOfInvoiceHouseAccount.get(0).getText().contains("Invoice/House Account")) {			
			 invoiceNumber = listOfInvoiceNumber.get(0).getText();
		}	return invoiceNumber;			 		
	}
	
	public String get_InvoiceNumber_PhoneOrder_PickUp_COD_PaymentType() {
		String invoiceNumber = null;
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().contains("Phone Order") 
				&& listOfPickUp.get(0).getText().contains("Pick Up") 
				&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("COD - Cash On Delivery")) {			
			 invoiceNumber = listOfInvoiceNumber.get(0).getText();
		}	return invoiceNumber;			 		
	}
	
	public boolean Validate_PhoneOrder_COD_PaymentType_PickUp_InvoiceNumber() {
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().contains("Phone Order") 
			&& ListOfDeliveryType_OnOrderPageTable.get(0).getText().contains("Pick Up") 
			&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("COD - Cash On Delivery")) {		
			HighlightElement(listOfInvoiceNumber.get(0));
			delayWithGivenTime(1000);
		}	return listOfInvoiceNumber.get(0).isDisplayed();			 		
	}
	
	public String Validate_PhoneOrder_COD_PaymentType_PickUp_ModeOfPayment() {
		String Mode_Of_Pay = null;
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().contains("Phone Order") 
			&& ListOfDeliveryType_OnOrderPageTable.get(0).getText().contains("Pick Up") 
			&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("COD - Cash On Delivery")) {	
			HighlightElement(ListOfMOP_OnOrderPageTable.get(0));
			Mode_Of_Pay = ListOfMOP_OnOrderPageTable.get(0).getText();
		}	return 	Mode_Of_Pay;		 		
	}
	
	public String Validate_PhoneOrder_Debit_PaymentType_PickUp_ModeOfPayment() {
		String Mode_Of_Pay = null;
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().contains("Phone Order") 
			&& ListOfDeliveryType_OnOrderPageTable.get(0).getText().contains("Pick Up") 
			&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("Debit")) {	
			HighlightElement(ListOfMOP_OnOrderPageTable.get(0));
			Mode_Of_Pay = ListOfMOP_OnOrderPageTable.get(0).getText();
		}	return 	Mode_Of_Pay;		 		
	}
	
	
	public String get_InvoiceNumber_PhoneOrder_PickUp_Debit_PaymentType() {
		String invoiceNumber = null;
		if(listOfPhoneOrder.get(0).getText().contains("Phone Order") 
				&& listOfPickUp.get(0).getText().contains("Pick Up") 
				&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("Debit")) {			
			 invoiceNumber = listOfInvoiceNumber.get(0).getText();
		}	return invoiceNumber;			 		
	}
	
	public boolean Validate_PhoneOrder_Debit_PaymentType_PickUp_InvoiceNumber() {
		if(listOfPhoneOrder.get(0).getText().contains("Phone Order") 
			&& listOfPickUp.get(0).getText().contains("Pick Up") 
			&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("Debit")) {		
			HighlightElement(listOfInvoiceNumber.get(0));
			delayWithGivenTime(1000);
		}	return listOfInvoiceNumber.get(0).isDisplayed();			 		
	}
	
	public String get_InvoiceNumber_PhoneOrder_PickUp_AmericanExpress_PaymentType() {
		String invoiceNumber = null;
		if(listOfPhoneOrder.get(0).getText().contains("Phone Order") 
				&& listOfPickUp.get(0).getText().contains("Pick Up") 
				&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("American Express")) {			
			 invoiceNumber = listOfInvoiceNumber.get(0).getText();
		}	return invoiceNumber;			 		
	}
	
	public boolean Validate_PhoneOrder_AmericanExpress_PaymentType_PickUp_InvoiceNumber() {
		if(listOfPhoneOrder.get(0).getText().contains("Phone Order") 
			&& listOfPickUp.get(0).getText().contains("Pick Up") 
			&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("American Express")) {		
			HighlightElement(listOfInvoiceNumber.get(0));
			delayWithGivenTime(1000);
		}	return listOfInvoiceNumber.get(0).isDisplayed();			 		
	}
	
	public String Validate_PhoneOrder_AmericanExpress_PaymentType_PickUp_ModeOfPayment() {
		String Mode_Of_Pay = null;
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().contains("Phone Order") 
			&& ListOfDeliveryType_OnOrderPageTable.get(0).getText().contains("Pick Up") 
			&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("American Express")) {	
			HighlightElement(ListOfMOP_OnOrderPageTable.get(0));
			Mode_Of_Pay = ListOfMOP_OnOrderPageTable.get(0).getText();
		}	return 	Mode_Of_Pay;		 		
	}
	
	public String get_InvoiceNumber_PhoneOrder_PickUp_Lovingly_PaymentType() {
		String invoiceNumber = null;
		if(listOfPhoneOrder.get(0).getText().contains("Phone Order") 
				&& listOfPickUp.get(0).getText().contains("Pick Up") 
				&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("Lovingly")) {			
			 invoiceNumber = listOfInvoiceNumber.get(0).getText();
		}	return invoiceNumber;			 		
	}
	
	public boolean Validate_PhoneOrder_Lovingly_PaymentType_PickUp_InvoiceNumber() {
		if(listOfPhoneOrder.get(0).getText().contains("Phone Order") 
			&& listOfPickUp.get(0).getText().contains("Pick Up") 
			&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("Lovingly")) {		
			HighlightElement(listOfInvoiceNumber.get(0));
			delayWithGivenTime(1000);
		}	return listOfInvoiceNumber.get(0).isDisplayed();			 		
	}
	
	public String Validate_PhoneOrder_Lovingly_PaymentType_PickUp_ModeOfPayment() {
		String Mode_Of_Pay = null;
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().contains("Phone Order") 
			&& ListOfDeliveryType_OnOrderPageTable.get(0).getText().contains("Pick Up") 
			&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("Lovingly")) {	
			HighlightElement(ListOfMOP_OnOrderPageTable.get(0));
			Mode_Of_Pay = ListOfMOP_OnOrderPageTable.get(0).getText();
		}	return 	Mode_Of_Pay;		 		
	}

	public String get_InvoiceNumber_PhoneOrder_PickUp_Marigold_PaymentType() {
		String invoiceNumber = null;
		if(listOfPhoneOrder.get(0).getText().contains("Phone Order") 
				&& listOfPickUp.get(0).getText().contains("Pick Up") 
				&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("Marigold")) {			
			 invoiceNumber = listOfInvoiceNumber.get(0).getText();
		}	return invoiceNumber;			 		
	}
	
	public boolean Validate_PhoneOrder_Marigold_PaymentType_PickUp_InvoiceNumber() {
		if(listOfPhoneOrder.get(0).getText().contains("Phone Order") 
			&& listOfPickUp.get(0).getText().contains("Pick Up") 
			&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("Marigold")) {		
			HighlightElement(listOfInvoiceNumber.get(0));
			delayWithGivenTime(1000);
		}	return listOfInvoiceNumber.get(0).isDisplayed();			 		
	}
	
	public String Validate_PhoneOrder_Marigold_PaymentType_PickUp_ModeOfPayment() {
		String Mode_Of_Pay = null;
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().contains("Phone Order") 
			&& ListOfDeliveryType_OnOrderPageTable.get(0).getText().contains("Pick Up") 
			&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("Marigold")) {	
			HighlightElement(ListOfMOP_OnOrderPageTable.get(0));
			Mode_Of_Pay = ListOfMOP_OnOrderPageTable.get(0).getText();
		}	return 	Mode_Of_Pay;		 		
	}

	public String get_InvoiceNumber_PhoneOrder_PickUp_MasterCard_PaymentType() {
		String invoiceNumber = null;
		if(listOfPhoneOrder.get(0).getText().contains("Phone Order") 
				&& listOfPickUp.get(0).getText().contains("Pick Up") 
				&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("Master Card")) {			
			 invoiceNumber = listOfInvoiceNumber.get(0).getText();
		}	return invoiceNumber;			 		
	}
	
	public boolean Validate_PhoneOrder_MasterCard_PaymentType_PickUp_InvoiceNumber() {
		if(listOfPhoneOrder.get(0).getText().contains("Phone Order") 
			&& listOfPickUp.get(0).getText().contains("Pick Up") 
			&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("Master Card")) {		
			HighlightElement(listOfInvoiceNumber.get(0));
			delayWithGivenTime(1000);
		}	return listOfInvoiceNumber.get(0).isDisplayed();			 		
	}
	
	public String Validate_PhoneOrder_MasterCard_PaymentType_PickUp_ModeOfPayment() {
		String Mode_Of_Pay = null;
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().contains("Phone Order") 
			&& ListOfDeliveryType_OnOrderPageTable.get(0).getText().contains("Pick Up") 
			&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("Master Card")) {	
			HighlightElement(ListOfMOP_OnOrderPageTable.get(0));
			Mode_Of_Pay = ListOfMOP_OnOrderPageTable.get(0).getText();
		}	return 	Mode_Of_Pay;		 		
	}

	public String get_InvoiceNumber_PhoneOrder_PickUp_Paid_Outside_Hana_PaymentType() {
		String invoiceNumber = null;
		if(listOfPhoneOrder.get(0).getText().contains("Phone Order") 
				&& listOfPickUp.get(0).getText().contains("Pick Up") 
				&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("Paid Outside Hana")) {			
			 invoiceNumber = listOfInvoiceNumber.get(0).getText();
		}	return invoiceNumber;			 		
	}
	
	public boolean Validate_PhoneOrder_Paid_Outside_Hana_PaymentType_PickUp_InvoiceNumber() {
		if(listOfPhoneOrder.get(0).getText().contains("Phone Order") 
			&& listOfPickUp.get(0).getText().contains("Pick Up") 
			&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("Paid Outside Hana")) {		
			HighlightElement(listOfInvoiceNumber.get(0));
			delayWithGivenTime(1000);
		}	return listOfInvoiceNumber.get(0).isDisplayed();			 		
	}
	
	public String Validate_PhoneOrder_Paid_Outside_Hana_PaymentType_PickUp_ModeOfPayment() {
		String Mode_Of_Pay = null;
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().contains("Phone Order") 
			&& ListOfDeliveryType_OnOrderPageTable.get(0).getText().contains("Pick Up") 
			&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("Paid Outside Hana")) {	
			HighlightElement(ListOfMOP_OnOrderPageTable.get(0));
			Mode_Of_Pay = ListOfMOP_OnOrderPageTable.get(0).getText();
		}	return 	Mode_Of_Pay;		 		
	}
	
	
	public boolean Validate_PhoneOrder_InvoiceInHousePayment() {
		if(listOfPhoneOrder.get(0).getText().contains("Phone Order") 
			&& listOfPickUp.get(0).getText().contains("Pick Up") 
			&& listOfInvoiceHouseAccount.get(0).getText().contains("Invoice/House Account")) {		
			listOfInvoiceHouseAccount.get(0).isDisplayed();
		}	return listOfInvoiceNumber.get(0).isDisplayed();			 		
	}
	
	public String get_InvoiceNumber_PhoneOrder_PickUp_Cash_PaymentType() {
		String invoiceNumber = null;
		if(listOfPhoneOrder.get(0).getText().contains("Phone Order") 
				&& listOfPickUp.get(0).getText().contains("Pick Up") 
				&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("Cash")) {			
			 invoiceNumber = listOfInvoiceNumber.get(0).getText();
		}	return invoiceNumber;			 		
	}
	
	public boolean Validate_PhoneOrder_CashPaymentType_PickUp_InvoiceNumber() {
		if(listOfPhoneOrder.get(0).getText().contains("Phone Order") 
			&& listOfPickUp.get(0).getText().contains("Pick Up") 
			&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("Cash")) {		
			HighlightElement(listOfInvoiceNumber.get(0));
			delayWithGivenTime(1000);
		}	return listOfInvoiceNumber.get(0).isDisplayed();			 		
	}
	
	public String Validate_PhoneOrder_CashPaymentType_PickUp_ModeOfPayment() {
		String Mode_Of_Pay = null;
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().contains("Phone Order") 
			&& ListOfDeliveryType_OnOrderPageTable.get(0).getText().contains("Pick Up") 
			&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("Cash")) {	
			HighlightElement(ListOfMOP_OnOrderPageTable.get(0));
			Mode_Of_Pay = ListOfMOP_OnOrderPageTable.get(0).getText();
		}	return 	Mode_Of_Pay;		 		
	}
	
	public String get_InvoiceNumber_PhoneOrder_PickUp_Visa_PaymentType() {
		String invoiceNumber = null;
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().contains("Phone Order") 
				&& listOfPickUp.get(0).getText().contains("Pick Up") 
				&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("Visa")) {			
			 invoiceNumber = listOfInvoiceNumber.get(0).getText();
		}	return invoiceNumber;			 		
	}
	
	public boolean Validate_PhoneOrder_Visa_PaymentType_PickUp_InvoiceNumber() {
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().contains("Phone Order") 
			&& listOfPickUp.get(0).getText().contains("Pick Up") 
			&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("Visa")) {		
			HighlightElement(listOfInvoiceNumber.get(0));
			delayWithGivenTime(1000);
		}	return listOfInvoiceNumber.get(0).isDisplayed();			 		
	}
	
	public String Validate_PhoneOrder_Visa_PaymentType_PickUp_ModeOfPayment() {
		String Mode_Of_Pay = null;
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().contains("Phone Order") 
			&& ListOfDeliveryType_OnOrderPageTable.get(0).getText().contains("Pick Up") 
			&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("Visa")) {	
			HighlightElement(ListOfMOP_OnOrderPageTable.get(0));
			Mode_Of_Pay = ListOfMOP_OnOrderPageTable.get(0).getText();
		}	return 	Mode_Of_Pay;		 		
	}
	
	public String get_InvoiceNumber_PhoneOrder_PickUp_WriteOff_PaymentType() {
		String invoiceNumber = null;
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().contains("Phone Order") 
				&& listOfPickUp.get(0).getText().contains("Pick Up") 
				&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("Write Off")) {			
			 invoiceNumber = listOfInvoiceNumber.get(0).getText();
		}	return invoiceNumber;			 		
	}
	
	public boolean Validate_PhoneOrder_WriteOff_PaymentType_PickUp_InvoiceNumber() {
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().contains("Phone Order") 
			&& listOfPickUp.get(0).getText().contains("Pick Up") 
			&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("Write Off")) {		
			HighlightElement(listOfInvoiceNumber.get(0));
			delayWithGivenTime(1000);
		}	return listOfInvoiceNumber.get(0).isDisplayed();			 		
	}
	
	public String Validate_PhoneOrder_WriteOff_PaymentType_PickUp_ModeOfPayment() {
		String Mode_Of_Pay = null;
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().contains("Phone Order") 
			&& ListOfDeliveryType_OnOrderPageTable.get(0).getText().contains("Pick Up") 
			&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("Write Off")) {	
			HighlightElement(ListOfMOP_OnOrderPageTable.get(0));
			Mode_Of_Pay = ListOfMOP_OnOrderPageTable.get(0).getText();
		}	return 	Mode_Of_Pay;		 		
	}
	
	public String get_InvoiceNumber_PhoneOrder_PickUp_Check_PaymentType() {
		String invoiceNumber = null;
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().contains("Phone Order") 
				&& listOfPickUp.get(0).getText().contains("Pick Up") 
				&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("Check")) {			
			 invoiceNumber = listOfInvoiceNumber.get(0).getText();
		}	return invoiceNumber;			 		
	}
	
	public boolean Validate_PhoneOrder_Check_PaymentType_PickUp_InvoiceNumber() {
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().contains("Phone Order") 
			&& listOfPickUp.get(0).getText().contains("Pick Up") 
			&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("Check")) {		
			HighlightElement(listOfInvoiceNumber.get(0));
			delayWithGivenTime(1000);
		}	return listOfInvoiceNumber.get(0).isDisplayed();			 		
	}
	
	public String Validate_PhoneOrder_Check_PaymentType_PickUp_ModeOfPayment() {
		String Mode_Of_Pay = null;
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().contains("Phone Order") 
			&& ListOfDeliveryType_OnOrderPageTable.get(0).getText().contains("Pick Up") 
			&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("Check")) {	
			HighlightElement(ListOfMOP_OnOrderPageTable.get(0));
			Mode_Of_Pay = ListOfMOP_OnOrderPageTable.get(0).getText();
		}	return 	Mode_Of_Pay;		 		
	}
	
	public String get_InvoiceNumber_PhoneOrder_PickUp_Donation_PaymentType() {
		String invoiceNumber = null;
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().contains("Phone Order") 
				&& listOfPickUp.get(0).getText().contains("Pick Up") 
				&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("Donation")) {			
			 invoiceNumber = listOfInvoiceNumber.get(0).getText();
		}	return invoiceNumber;			 		
	}
	
	public boolean Validate_PhoneOrder_Donation_PaymentType_PickUp_InvoiceNumber() {
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().contains("Phone Order") 
			&& listOfPickUp.get(0).getText().contains("Pick Up") 
			&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("Donation")) {		
			HighlightElement(listOfInvoiceNumber.get(0));
			delayWithGivenTime(1000);
		}	return listOfInvoiceNumber.get(0).isDisplayed();			 		
	}
	
	public String Validate_PhoneOrder_Donation_PaymentType_PickUp_ModeOfPayment() {
		String Mode_Of_Pay = null;
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().contains("Phone Order") 
			&& ListOfDeliveryType_OnOrderPageTable.get(0).getText().contains("Pick Up") 
			&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("Donation")) {	
			HighlightElement(ListOfMOP_OnOrderPageTable.get(0));
			Mode_Of_Pay = ListOfMOP_OnOrderPageTable.get(0).getText();
		}	return 	Mode_Of_Pay;		 		
	}
	
	public String get_InvoiceNumber_PhoneOrder_PickUp_CC_PaymentType() {
		String invoiceNumber = null;
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().contains("Phone Order") 
				&& listOfPickUp.get(0).getText().contains("Pick Up") 
				&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("Credit Card")) {			
			 invoiceNumber = listOfInvoiceNumber.get(0).getText();
		}	return invoiceNumber;			 		
	}
	
	public boolean Validate_PhoneOrder_CC_PaymentType_PickUp_InvoiceNumber() {
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().contains("Phone Order") 
			&& listOfPickUp.get(0).getText().contains("Pick Up") 
			&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("Credit Card")) {		
			HighlightElement(listOfInvoiceNumber.get(0));
			delayWithGivenTime(1000);
		}	return listOfInvoiceNumber.get(0).isDisplayed();			 		
	}
	
	public String Validate_PhoneOrder_CC_PaymentType_PickUp_ModeOfPayment() {
		String Mode_Of_Pay = null;
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().contains("Phone Order") 
			&& ListOfDeliveryType_OnOrderPageTable.get(0).getText().contains("Pick Up") 
			&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("Credit Card")) {	
			HighlightElement(ListOfMOP_OnOrderPageTable.get(0));
			Mode_Of_Pay = ListOfMOP_OnOrderPageTable.get(0).getText();
		}	return 	Mode_Of_Pay;		 		
	}
	
	
	public String getInvoiceNumber_On_PhoneOrder_DeliveryInvoiceInHousePayment() {
		String invoiceNumber = null;
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().contains("Phone Order") 
				&& ListOfDeliveryType_OnOrderPageTable.get(0).getText().contains("Delivery") 
				&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("Invoice/House Account")) {							
			invoiceNumber=listOfInvoiceNumber.get(0).getText().trim();	
		}	return invoiceNumber;			 		
	}
	
	
	public void ClickInvoiceInhousePayment_on_PhoneOrder_on_SenderorCustomer_OnOrderPage() {
		if(listOfPhoneOrder.get(0).getText().contains("Phone Order") 
				&& listOfPickUp.get(0).getText().contains("Pick Up") 
				&& listOfInvoiceHouseAccount.get(0).getText().contains("Invoice/House Account")) {		
				
			jsClick(listOfSenderCustomer.get(0));
		}	 			 		
	}
	
	public void Click_Cash_Payment_PickUp_PhoneOrder_on_SenderorCustomer_OnOrderPage() {
		if(listOfPhoneOrder.get(0).getText().contains("Phone Order") 
				&& listOfPickUp.get(0).getText().contains("Pick Up") 
				&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("Cash")) {						
			jsClick(listOfSenderCustomer.get(0));
		}	 			 		
	}
	
	public String GetSenderorCustomerOnOrderPage() {
		String sender_cust=null;
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().contains("Walkin Sales")
				&&ListOfDeliveryType_OnOrderPageTable.get(0).getText().contains("Pick Up")
				&&ListOfMOP_OnOrderPageTable.get(0).getText().contains("Cash")) {
				delayWithGivenTime(1000);//ListOfOrderType_OnOrderPageTable
			//HighlightElement(listOfSenderCustomer.get(0));
			sender_cust= listOfSenderCustomer.get(0).getText();
			System.out.println("Sender or Customer : "+sender_cust);
		}	return 	sender_cust;		 		
	}
	
	public void ClickonSenderorCustomerOnOrderPage() {
		if(listOfWalkinSales.get(0).getText().contains("Walkin Sales")
			&& listOfPickUp.get(0).getText().contains("Pick Up")
			&& listOfCashMOP.get(0).getText().contains("Cash")) {
			
			HighlightElement(listOfWalkinSales.get(0));
			delayWithGivenTime(500);
			HighlightElement(listOfOrderDetail.get(0));
			delayWithGivenTime(500);
			HighlightElement(firstrowOfOrderDetail.get(0));
			
			
			for (int i= 0;i<listOfSenderCustomer.size(); ) {				
				break; 
			}
			
			click(listOfSenderCustomer.get(0));
			delayWithGivenTime(1000);
		}	 			 		
	}
	
	public void ClickPhoneOrder_on_SenderorCustomer_OnOrderPage() {
		if(listOfPhoneOrder.get(0).getText().contains("Phone Order") 
				&& listOfPickUp.get(0).getText().contains("Pick Up") 
				&& listOfCashMOP.get(0).getText().contains("Cash")) {
		
			jsClick(listOfSenderCustomer.get(0));
		}	 			 		
	}
	
	
	public boolean VerifyDeliveryPopup() {
		HighlightElement(deliveryPopup);
		return deliveryPopup.isDisplayed();
	}
	
	public String getCustomerTypeDeliveryPopup() {
		HighlightElement(deliveryCustType);
		return deliveryCustType.getText();
	}
	
	public String getCustAndcompyNameOnDeliveryPopup() {
		HighlightElement(custAndcompyNameOnDeliveryPopup);
		return custAndcompyNameOnDeliveryPopup.getText();
	}
	
	public String getCustAddressOnDeliveryPopup() {
		HighlightElement(CustAddressOnDeliveryPopup);
		return CustAddressOnDeliveryPopup.getText();
	}
	
	public String getCustPhoneNumOnDeliveryPopup() {
		HighlightElement(CustPhoneNumOnDeliveryPopup);
		return CustPhoneNumOnDeliveryPopup.getText();
	}
	
	public String getCustEmailOnDeliveryPopup() {
		HighlightElement(CustEmailOnDeliveryPopup);
		return CustEmailOnDeliveryPopup.getText();
	}
	
	public void ClickCloseIconOnDeliveryPopup() {
		click(DeliveryPopupCloseIcon);
	}
	
	public void ClickCustomerMenuOnDashboard() {
		click(CustomerMenu);
	}
	
	public String getRecipientName_OnDeliveryPopup() {
		HighlightElement(RecipientName_InvPopup);
		return RecipientName_InvPopup.getText();
	}
	
	public String getRecipientAddress_OnDeliveryPopup() {
		HighlightElement(RecipientAddress_InvPopup);
		return RecipientAddress_InvPopup.getText();
	}
	
	public String getRecipientPhoneNum_OnDeliveryPopup() {
		HighlightElement(RecipientPhone_InvPopup);
		return RecipientPhone_InvPopup.getText();
	}
	
	public String Verify_OrderType_Displayed_on_DeliveryPopup() {
		HighlightElement(OrderType_On_InvPopup);
		return 	OrderType_On_InvPopup.getText();
	}
	
	public boolean Verify_ConfidentialReqMessage_Appears() {
		HighlightElement(confidentialReq_Message_DeliveryPopup); 
		return confidentialReq_Message_DeliveryPopup.isDisplayed();
	}
	
	
	public String Verify_ConfidentialReqTextMessage_Appears() {
		HighlightElement(confidentialReq_Message_DeliveryPopup); 
		return confidentialReq_Message_DeliveryPopup.getText();
	}
	
	public String get_OccasionType_OnInvPopup() {
		HighlightElement(occasion_InvPopup);
		return occasion_InvPopup.getText();
	}
	public String get_CardMessage_OnInvPopup() {
		HighlightElement(cardmessage_InvPopup);
		return cardmessage_InvPopup.getText();
	}
	
	public String get_ProductDescription_OnInvPopup() {
		HighlightElement(productTab_ProductDescription_OnInvPopup);
		return productTab_ProductDescription_OnInvPopup.getText();
	}
	
	public String get_sourcecode_displayed_OnInvPopup() {
		HighlightElement(sourcecode_OnInvPopup);
		return sourcecode_OnInvPopup.getText();
	}
	
	public String get_SpecialInstruction_displayed_OnInvPopup() {
		HighlightElement(splInstruction_OnInvPopup);
		return splInstruction_OnInvPopup.getText();
	}
	
	public String get_DriverInstruction_displayed_OnInvPopup() {
		HighlightElement(driverInstruction_OnInvPopup);
		return driverInstruction_OnInvPopup.getText();
	}
	
	public String get_Displayed_DeliveryType_OnInvPopup() {
		HighlightElement(deliveryType_OnInvoicePopup);
		return deliveryType_OnInvoicePopup.getText();
	}
	
	public String getInvoiceNumber_Phoneorder_pickup_GiftCArd_OnOrderPage() {
	    // Ensure that listOfWalkinSales, listOfPickUp, and listOfCashMOP contain elements before accessing them
		String Giftcardinvoicenumber=null;
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().equals("Phone Order")&&
				ListOfDeliveryType_OnOrderPageTable.get(0).getText().equals("Pick Up")&&
				ListOfMOP_OnOrderPageTable.get(0).getText().equals("Gift Card"))
			{
			System.out.println("Order Page phoneorder - pickup - gift card - Invoice Number is :"+listOfInvoiceNumber.get(0).getText());
            Giftcardinvoicenumber= listOfInvoiceNumber.get(0).getText();
			}
		return Giftcardinvoicenumber;      
	
	}
	
	public boolean Validate_MOP_As_GiftCard_OnOrderPageTable() {
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().equals("Phone Order")&&
				ListOfDeliveryType_OnOrderPageTable.get(0).getText().equals("Pick Up")&&
				ListOfMOP_OnOrderPageTable.get(0).getText().equals("Gift Card"))
			{
				HighlightElement(ListOfOrderType_OnOrderPageTable.get(0));
				ListOfOrderType_OnOrderPageTable.get(0).isDisplayed();
				HighlightElement(ListOfDeliveryType_OnOrderPageTable.get(0));
				ListOfDeliveryType_OnOrderPageTable.get(0).isDisplayed();
				HighlightElement(ListOfMOP_OnOrderPageTable.get(0));
				ListOfMOP_OnOrderPageTable.get(0).isDisplayed();
				
				if(ListOfRecipient_OnOrderPageTable.get(0).getText().contains("Abish David 1160 W 5th St PICK UP Washington MO 63090")) {
					HighlightElement(ListOfRecipient_OnOrderPageTable.get(0));
					ListOfRecipient_OnOrderPageTable.get(0).isDisplayed();
					return true;
				}
				return true;
			}
		return false;
		}
	
	
	public String getInvoiceNumber_WireInDeliveryType_Appears_OnOrderPage() {			
		String invoicenumber = null;
		if(Wire_ListOfOrderType_OnOrderPageTable.get(0).getText().equals("FSN Order") 
				&& ListOfDeliveryType_OnOrderPageTable.get(0).getText().equals("Wire In") 
				&& ListOfMOP_OnOrderPageTable.get(0).getText().equals("FSN")) {				
			  invoicenumber= listOfInvoiceNumber.get(0).getText();	
			}return invoicenumber;
	}
		
	public boolean Validate_WireInOrderType_Appears_OnOrderPage() {			
		boolean wireintype = false;
		if(Wire_ListOfOrderType_OnOrderPageTable.get(0).getText().equals("FSN Order") 
				&& ListOfDeliveryType_OnOrderPageTable.get(0).getText().equals("Wire In") 
				&& ListOfMOP_OnOrderPageTable.get(0).getText().equals("FSN")) {
			wireintype= Wire_ListOfOrderType_OnOrderPageTable.get(0).isDisplayed();												
		}return wireintype;
	}
	
	public boolean Validate_WireInDeliveryType_Appears_OnOrderPage() {			
		boolean deliveryType = false;
		if(Wire_ListOfOrderType_OnOrderPageTable.get(0).getText().equals("FSN Order") 
				&& ListOfDeliveryType_OnOrderPageTable.get(0).getText().equals("Wire In") 
				&& ListOfMOP_OnOrderPageTable.get(0).getText().equals("FSN")) {				
				deliveryType = ListOfDeliveryType_OnOrderPageTable.get(0).isDisplayed();	
			}return deliveryType;
	}
	
	public boolean Validate_WireInMOP_Appears_OnOrderPage() {			
		boolean WireInMop = false;
		if(Wire_ListOfOrderType_OnOrderPageTable.get(0).getText().equals("FSN Order") 
				&& ListOfDeliveryType_OnOrderPageTable.get(0).getText().equals("Wire In") 
				&& ListOfMOP_OnOrderPageTable.get(0).getText().equals("FSN")) {			
				WireInMop = ListOfMOP_OnOrderPageTable.get(0).isDisplayed();	
			}	return 	WireInMop;
	}
		
	public String get_WireInOrderType_Text_OnOrderPage() {			
		return Wire_ListOfOrderType_OnOrderPageTable.get(0).getText();		
	}
	
	public String get_WireInDeliveryType_Text_OnOrderPage() {			
		return ListOfDeliveryType_OnOrderPageTable.get(0).getText();	
		
	}
	
	public String get_WireInMOP_Text_OnOrderPage() {			
		return ListOfMOP_OnOrderPageTable.get(0).getText();	
	}
	
	public String get_PhoneOrder_WireOut_InvoiceInHousePayment() {
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().contains("Phone Order") 
				&& ListOfDeliveryType_OnOrderPageTable.get(0).getText().contains("Wire Out") 
				&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("Invoice/House Account")) {
				delayWithGivenTime(500);	
		}	return listOfInvoiceNumber.get(0).getText();			 		
	}
	
	public boolean Validate_PhoneOrder_WireOut_InvoiceInHousePayment() {
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().contains("Phone Order") 
				&& ListOfDeliveryType_OnOrderPageTable.get(0).getText().contains("Wire Out") 
				&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("Invoice/House Account")) {
				delayWithGivenTime(500);		
		}	return listOfInvoiceNumber.get(0).isDisplayed();			 		
	}
	
	public void Click_PhoneOrder_WireOut_InvoiceInHousePayment() {
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().contains("Phone Order") 
				&& ListOfDeliveryType_OnOrderPageTable.get(0).getText().contains("Wire Out") 
				&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("Invoice/House Account")) {		
		}	jsClick(ListOfOrderType_OnOrderPageTable.get(0));			 		
	}
	
	public String get_SalesTax_On_DeliveryPopup_Invoice() {
		HighlightElement(salesTax_OnDeliveryPopup_Invoice);
		return salesTax_OnDeliveryPopup_Invoice.getText();
	}
	
	public boolean Verify_RedFlagIcon_IsAppears() {
		HighlightElement(RedflagIcon_OnOrderpage);
		return RedflagIcon_OnOrderpage.isDisplayed();
	}
	
	public String get_status_on_orderpage() {
		HighlightElement(OrderStatus_OnOrderPage);
		return	OrderStatus_OnOrderPage.getText();
	}
	
	public void Click_OrderStatus() {
		jsClick(OrderStatus_OnOrderPage);
	}
	
	public String get_OrderStatus_DeliveryPopup() {
		HighlightElement(OrderStatus_InvPopup);
		return OrderStatus_InvPopup.getText();
	}
	
	public String get_drivername_onInvoicePopup() {
		HighlightElement(driverName_InvPopup);
		return driverName_InvPopup.getText().trim();
	}
	
	public void Click_DispatchTab_onInvPopup() {
		jsClick(dispatchTab_InvPopup);
	}
	
	public String get_dispatchConfirmation_Date_and_Time() {
		String fullText = dispatch_ConfirmationMessage_InvPopup.getText();
		 String[] parts = fullText.split("Dispatched on ");
		 parts[1].trim();
		 String dateTime = null ;
		 if (parts.length > 1) {
	            dateTime = parts[1].split(" Delivered by")[0].trim().toUpperCase();
		 }  return dateTime;   
	}
	
	public boolean Validate_dispatchConfirmation_Date_and_Time_With_AtlanticTimeZone() {
		if(get_dispatchConfirmation_Date_and_Time().contains(Atlantic_TimeZone())) {
			return true;
		}else {
			System.out.println("Dispatch Confirmation Date and Time is : "+get_dispatchConfirmation_Date_and_Time() + " not matched with : "+Atlantic_TimeZone());
			return false;
		}
		
	}
	
	
	public String get_dispatchConfirmation_DriverName() {
		String fullText = dispatch_ConfirmationMessage_InvPopup.getText();
		 String[] parts = fullText.split("driver ");
		String drivername = parts[1].trim();
		return drivername;  	
	}

	public void Click_StatusTab_onInvPopup() {
		jsClick(statusTab_InvPopup);
	}
	
	public String get_status_date_and_time() {
	    String dateandtime = null;
	    if (statusTable_row1_statusType != null && statusTable_row1_statusType.getText().contains("Dispatched")) {
	        if (statusTable_row1_Date != null) {
	            HighlightElement(statusTable_row1_Date);
	            dateandtime = statusTable_row1_Date.getText().trim().toUpperCase();
	        } else {
	            System.out.println("statusTable_row1_Date is null");
	        }
	    } else {
	        System.out.println("statusTable_row1_statusType is null or does not contain 'Dispatched'");
	    }
	    return dateandtime;
	}
   
	public boolean Validate_status_date_and_time() {
		if(get_status_date_and_time().contains(Atlantic_TimeZone_NumberDateFormat())) {
			return true;
		}else {
			System.out.println("Status Tab confirmation dispatch Date and Time is : "+get_status_date_and_time() + " not matched with : "+Atlantic_TimeZone());
			return false;
		}
	}
	
	
	public String Verify_DeliveryOnTruck_at_ActivitySection() {
		HighlightElement(deliveryontruck_msg_on_Activity);
		return deliveryontruck_msg_on_Activity.getText().trim();
	}
	
	public String get_DeliveryOnTruck_DateandTime_at_ActivitySection() {
		HighlightElement(deliveryontruck_dateandtime_on_Activity);
		String dateandtime = deliveryontruck_dateandtime_on_Activity.getText().trim().toUpperCase();
		return dateandtime;
	}
	
	public boolean Validate_DeliveryOnTruck_DateandTime_at_ActivitySection() {
		if(get_DeliveryOnTruck_DateandTime_at_ActivitySection().contains(Atlantic_TimeZone())) {
			return true;
		}else {
			System.out.println("Delivery on Truck Date and Time is : "+get_DeliveryOnTruck_DateandTime_at_ActivitySection() + " not matched with : "+Atlantic_TimeZone());
			return false;
		}
	}
	
	public String get_ConfirmationDate_and_Time_RouteNumber_on_ActivitySection() {
		HighlightElement(deliveryontruck_fullmsg_on_Activity);
		String fulltext = deliveryontruck_fullmsg_on_Activity.getText().trim();
		String[] parts = fulltext.split(" Your delivery driver is ");
		String dateTime = parts[0].split("loaded into truck on ")[1].trim().toUpperCase();
		return dateTime;
	}	
	
	public boolean Validate_ConfirmationDate_and_Time_RouteNumber_on_ActivitySection() {
		if(get_ConfirmationDate_and_Time_RouteNumber_on_ActivitySection().contains(Atlantic_TimeZone())) {
			return true;
		}else {
			System.out.println("Confirmation on activity route number text Date and Time is : "+get_ConfirmationDate_and_Time_RouteNumber_on_ActivitySection() + " not matched with : "+Atlantic_TimeZone());
			return false;
		}
	}
	
	public String get_Confirmation_DriverName_RouteNumber_on_ActivitySection() {
		HighlightElement(deliveryontruck_fullmsg_on_Activity);
		String fulltext = deliveryontruck_fullmsg_on_Activity.getText().trim();
		String[] parts = fulltext.split(" Your delivery driver is ");
		 String drivername = parts[1].trim();
		return drivername;
	}	
	
	public String get_InvoiceNumber_PhoneOrder_Delivery_Type_InvoiceHouse() {
		String invoiceNumber = null;
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().contains("Phone Order") 
				&& ListOfDeliveryType_OnOrderPageTable.get(0).getText().contains("Delivery") 
				&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("Invoice/House Account")) {			
			 invoiceNumber = listOfInvoiceNumber.get(0).getText();
		}	return invoiceNumber;			 		
	}
	
	public boolean Validate_PhoneOrder_DeliveryInvoiceInHousePayment() {
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().contains("Phone Order") 
				&& ListOfDeliveryType_OnOrderPageTable.get(0).getText().contains("Delivery") 
				&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("Invoice/House Account")) {			
				listOfInvoiceHouseAccount.get(0).isDisplayed();
		}	return listOfInvoiceNumber.get(0).isDisplayed();			 		
	}
	
	public void Click_DeliveryInvoiceInhousePayment_on_PhoneOrder_on_SenderorCustomer_OnOrderPage() {
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().contains("Phone Order") 
			&& ListOfDeliveryType_OnOrderPageTable.get(0).getText().contains("Delivery") 
			&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("Invoice/House Account")) {		
			jsClick(ListOfOrderType_OnOrderPageTable.get(0));
		}	 			 		
	}
	
	public String get_InvoiceNumber_PhoneOrder_Delivery_AsCashPayment() {
		String invoiceNumber = null;
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().equals("Phone Order") 
				&& ListOfDeliveryType_OnOrderPageTable.get(0).getText().equals("Delivery") 
				&& ListOfMOP_OnOrderPageTable.get(0).getText().equals("Cash")) {
			 invoiceNumber = listOfInvoiceNumber.get(0).getText();
		}return invoiceNumber;
	}
	
	public boolean Validate_DeliveryAsCashPayment_on_PhoneOrder_on_SenderorCustomer_OnOrderPage() {
		boolean invoiceNumber = false;
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().contains("Phone Order") 
			&& ListOfDeliveryType_OnOrderPageTable.get(0).getText().contains("Delivery") 
			&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("Cash")) {		
			invoiceNumber = listOfSenderCustomer.get(0).isDisplayed();		 		
	} return invoiceNumber;
}

	public void Click_DeliveryAsCashPayment_on_PhoneOrder_on_SenderorCustomer_OnOrderPage() {
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().contains("Phone Order") 
			&& ListOfDeliveryType_OnOrderPageTable.get(0).getText().contains("Delivery") 
			&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("Cash")) {					
			jsClick(listOfInvoiceNumber.get(0));
		}	 			 		
	}
	
	public String get_InvoiceNumber_PhoneOrder_Delivery_As_Visa_Payment() {
		String invoiceNumber = null;
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().equals("Phone Order") 
				&& ListOfDeliveryType_OnOrderPageTable.get(0).getText().equals("Delivery") 
				&& ListOfMOP_OnOrderPageTable.get(0).getText().equals("Visa")) {
			 invoiceNumber = listOfInvoiceNumber.get(0).getText();
		}return invoiceNumber;
	}
	
	public boolean Validate_DeliveryAs_Visa_Payment_on_PhoneOrder_on_SenderorCustomer_OnOrderPage() {
		boolean invoiceNumber = false;
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().contains("Phone Order") 
			&& ListOfDeliveryType_OnOrderPageTable.get(0).getText().contains("Delivery") 
			&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("Visa")) {		
			invoiceNumber = listOfSenderCustomer.get(0).isDisplayed();		 		
	} return invoiceNumber;
}

	public void Click_DeliveryAs_Visa_Payment_on_PhoneOrder_on_SenderorCustomer_OnOrderPage() {
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().contains("Phone Order") 
			&& ListOfDeliveryType_OnOrderPageTable.get(0).getText().contains("Delivery") 
			&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("Visa")) {					
			jsClick(listOfInvoiceNumber.get(0));
		}	 			 		
	}
	
	
	
	
	
}
	
	

