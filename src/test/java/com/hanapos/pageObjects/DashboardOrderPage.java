package com.hanapos.pageObjects;

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
	
	@FindBy(xpath="//td[@class='hana-grid-row-fullview order-status-col overflowVisible']")
	private List<WebElement> listOfOrderStatus;

	@FindBy(xpath = "//table[@role='grid']//tr//td[@class='set-order-detail-text']")
	private List<WebElement> listOfOrderDetail;

	@FindBy(xpath = "(//table[1]/tbody[1]/tr[1]/td[5])[1]")
	private List<WebElement> firstrowOfOrderDetail;
	
	@FindBy(xpath="//span[@class='set-value-column-text-bold']")
	private List<WebElement> listOfInvoiceAmountValue;
	
	@FindBy(xpath="//td[@class='hana-grid-row-fullview smallSize order-sender-customer-col']")
	private List<WebElement> listOfSenderCustomer;
	
	@FindBy(xpath="//td[@class='hana-grid-row-fullview smallSize order-orderdetail-col']")
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
	
	public String validateDashboardOrderPage() {
		return	getDriver().getCurrentUrl();
	}

	public void EnterGlobalSearch(String globalsearch) {
		//HighlightElement(Global_search_OrderPage);
		Global_search_OrderPage.clear();
		delayWithGivenTime(1000);
		Global_search_OrderPage.sendKeys(globalsearch);
		//clickAndType(Global_search_OrderPage,globalsearch);
		delayWithGivenTime(1000);
		Global_search_OrderPage.sendKeys(Keys.ENTER);
	}
	
	public boolean ValidateInvoiceNumber() {
		boolean invoiceNumber = false;
		if(listOfWalkinSales.get(0).getText().equals("Walkin Sales") 
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
		if(listOfWalkinSales.get(0).getText().equals("Walkin Sales") 
				&& listOfPickUp.get(0).getText().equals("Pick Up")
				&& listOfPaidOutsideHana.get(0).getText().equals("Paid Outside Hana")) {
				paidOutsideHana_Invoice = listOfInvoiceNumber.get(0).getText();
				System.out.println("Paid Outside Hana Invoice number: "+paidOutsideHana_Invoice);
		}return paidOutsideHana_Invoice;
	}
	
	public boolean Validate_POH_MOP_DisplayedOnOrderPage() {
		boolean paidOutsideHana = false;
		if(listOfWalkinSales.get(0).getText().equals("Walkin Sales") 
				&& listOfPickUp.get(0).getText().equals("Pick Up")
				&& listOfPaidOutsideHana.get(0).getText().equals("Paid Outside Hana")) {
			HighlightElement(listOfInvoiceNumber.get(0));
			delayWithGivenTime(1000);
			HighlightElement(listOfPaidOutsideHana.get(0));
			paidOutsideHana = listOfPaidOutsideHana.get(0).isDisplayed();
		}return paidOutsideHana;
	}
	
	public String get_Walkins_Pickup_GiftCard_OnOrderPage() {
		String giftcard_Invoice=null;
		if(listOfWalkinSales.get(0).getText().equals("Walkin Sales") 
				&& listOfPickUp.get(0).getText().equals("Pick Up")
				&&	listOfGiftCard.get(0).getText().equals("Gift Card")) {			
				giftcard_Invoice=listOfInvoiceNumber.get(0).getText();
		}return giftcard_Invoice;
	}
	
	public boolean Validate_GiftCard_MOP_DisplayedOnOrderPage() {
		boolean giftcard_Invoice=false;
		if(listOfWalkinSales.get(0).getText().equals("Walkin Sales") 
				&& listOfPickUp.get(0).getText().equals("Pick Up")
				&&	listOfGiftCard.get(0).getText().equals("Gift Card")) {
			HighlightElement(listOfInvoiceNumber.get(0));
			delayWithGivenTime(1000);
			giftcard_Invoice=listOfInvoiceNumber.get(0).isDisplayed();
		}return giftcard_Invoice;
	}
	
	public String get_Walkins_Pickup_Donation_OnOrderPage() {
		String donation_Invoice=null;
		if(listOfWalkinSales.get(0).getText().equals("Walkin Sales") 
				&& listOfPickUp.get(0).getText().equals("Pick Up")
				&&	listOfDonation.get(0).getText().equals("Donation")) {			
				donation_Invoice=listOfInvoiceNumber.get(0).getText();						
		}return donation_Invoice;
	}
	
	public boolean Validate_Donation_MOP_DisplayedOnOrderPage() {
		boolean donation_Invoice=false;
		if(listOfWalkinSales.get(0).getText().equals("Walkin Sales") 
				&& listOfPickUp.get(0).getText().equals("Pick Up")
				&&	listOfDonation.get(0).getText().equals("Donation")) {
			HighlightElement(listOfInvoiceNumber.get(0));
			donation_Invoice=listOfInvoiceNumber.get(0).isDisplayed();						
		}return donation_Invoice;
	}
	
	public String getStatusOnOrderPage() {
		String status = null;
		if(listOfWalkinSales.get(0).getText().equals("Walkin Sales") 
				&& listOfPickUp.get(0).getText().equals("Pick Up")
				&&	listOfDonation.get(0).getText().equals("Donation")) {
				status=	listOfOrderStatus.get(0).getText();
		}return status;
	}
	
	public String GetInvoiceAmount_Walkin_pickup_Cash_OnOrderPage() {
		if(listOfWalkinSales.get(0).getText().contains("Walkin Sales")
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
		if(listOfPhoneOrder.get(0).getText().contains("Phone Order") 
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
		if(listOfPhoneOrder.get(0).getText().equals("Phone Order") 
				&& listOfPickUp.get(0).getText().equals("Pick Up") 
				&& listOfCashMOP.get(0).getText().equals("Cash")) {
			
			 invoiceNumber = listOfInvoiceNumber.get(0).getText();
		
		}	return 	invoiceNumber;	
	
}
	
	public String get_InvoiceNumber_PhoneOrder_PickUp_InvoiceHouse() {
		String invoiceNumber = null;
		if(listOfPhoneOrder.get(0).getText().contains("Phone Order") 
				&& listOfPickUp.get(0).getText().contains("Pick Up") 
				&& listOfInvoiceHouseAccount.get(0).getText().contains("Invoice/House Account")) {			
			 invoiceNumber = listOfInvoiceNumber.get(0).getText();
		}	return invoiceNumber;			 		
	}
	
	
	public boolean Validate_PhoneOrder_InvoiceInHousePayment() {
		if(listOfPhoneOrder.get(0).getText().contains("Phone Order") 
			&& listOfPickUp.get(0).getText().contains("Pick Up") 
			&& listOfInvoiceHouseAccount.get(0).getText().contains("Invoice/House Account")) {		
			listOfInvoiceHouseAccount.get(0).isDisplayed();
		}	return listOfInvoiceNumber.get(0).isDisplayed();			 		
	}
	
	public boolean Validate_PhoneOrder_DeliveryInvoiceInHousePayment() {
		if(listOfPhoneOrder.get(0).getText().contains("Phone Order") 
				&& listOfPickUp.get(0).getText().contains("Delivery") 
				&& listOfInvoiceHouseAccount.get(0).getText().contains("Invoice/House Account")) {			
				HighlightElement(listOfInvoiceHouseAccount.get(0));
				listOfInvoiceHouseAccount.get(0).isDisplayed();
		}	return listOfInvoiceNumber.get(0).isDisplayed();			 		
	}
	
	public void ClickInvoiceInhousePayment_on_PhoneOrder_on_SenderorCustomer_OnOrderPage() {
		if(listOfPhoneOrder.get(0).getText().contains("Phone Order") 
				&& listOfPickUp.get(0).getText().contains("Pick Up") 
				&& listOfInvoiceHouseAccount.get(0).getText().contains("Invoice/House Account")) {		
				
			jsClick(listOfSenderCustomer.get(0));
		}	 			 		
	}
	
	public void Click_DeliveryInvoiceInhousePayment_on_PhoneOrder_on_SenderorCustomer_OnOrderPage() {
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().contains("Phone Order") 
			&& ListOfDeliveryType_OnOrderPageTable.get(0).getText().contains("Delivery") 
			&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("Invoice/House Account")) {
			
			HighlightElement(ListOfOrderType_OnOrderPageTable.get(0));
			delayWithGivenTime(500);
			HighlightElement(ListOfDeliveryType_OnOrderPageTable.get(0));
			delayWithGivenTime(500);
			HighlightElement(ListOfMOP_OnOrderPageTable.get(0));			
			jsClick(ListOfOrderType_OnOrderPageTable.get(0));
		}	 			 		
	}
	
	public void Click_DeliveryAsCashPayment_on_PhoneOrder_on_SenderorCustomer_OnOrderPage() {
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().contains("Phone Order") 
			&& ListOfDeliveryType_OnOrderPageTable.get(0).getText().contains("Delivery") 
			&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("Cash")) {					
			jsClick(listOfInvoiceNumber.get(0));
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
	
	public String GetSenderorCustomerOnOrderPage() {
		String sender_cust=null;
		if(listOfWalkinSales.get(0).getText().contains("Walkin Sales")
				&&listOfPickUp.get(0).getText().contains("Pick Up")
				&&listOfCashMOP.get(0).getText().contains("Cash")) {

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
	
	public boolean Validate_PhoneOrder_WireOut_InvoiceInHousePayment() {
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().contains("Phone Order") 
				&& ListOfDeliveryType_OnOrderPageTable.get(0).getText().contains("Wire Out") 
				&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("Invoice/House Account")) {
				delayWithGivenTime(500);
				HighlightElement(ListOfOrderType_OnOrderPageTable.get(0));
				delayWithGivenTime(500);
				HighlightElement(ListOfDeliveryType_OnOrderPageTable.get(0));
				delayWithGivenTime(500);
				HighlightElement(listOfInvoiceHouseAccount.get(0));			
		}	return listOfInvoiceNumber.get(0).isDisplayed();			 		
	}
	
	public void Click_PhoneOrder_WireOut_InvoiceInHousePayment() {
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().contains("Phone Order") 
				&& ListOfDeliveryType_OnOrderPageTable.get(0).getText().contains("Wire Out") 
				&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("Invoice/House Account")) {
				delayWithGivenTime(500);
				HighlightElement(ListOfOrderType_OnOrderPageTable.get(0));
				delayWithGivenTime(500);
				HighlightElement(ListOfDeliveryType_OnOrderPageTable.get(0));
				delayWithGivenTime(500);
				HighlightElement(listOfInvoiceHouseAccount.get(0));			
		}	jsClick(ListOfOrderType_OnOrderPageTable.get(0));			 		
	}
	
	
	
	
	}
	
	

