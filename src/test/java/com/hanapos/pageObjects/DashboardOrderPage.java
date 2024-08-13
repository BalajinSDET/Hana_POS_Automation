package com.hanapos.pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hanapos.seleniumProjectBase.TestBaseClass;

public class DashboardOrderPage extends TestBaseClass{
	private CashAndCarryPaymentPage cashandcarrypayment = new CashAndCarryPaymentPage();
	public DashboardOrderPage() {
		PageFactory.initElements(getDriver(), this);
	}


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
	
	@FindBy(xpath="//td[@class='hana-grid-row-fullview order-status-col']")
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

	public boolean ValidateInvoiceNumber() {
		if(listOfWalkinSales.get(0).getText().equals("Walkin Sales") 
				&& listOfPickUp.get(0).getText().equals("Pick Up") 
				&& listOfCashMOP.get(0).getText().equals("Cash")) {
			for (int i= 0;i<listOfInvoiceNumber.size(); ) {	
				HighlightElement(listOfWalkinSales.get(0));
				HighlightElement(listOfOrderDetail.get(0));
				HighlightElement(firstrowOfOrderDetail.get(0));
				delayWithGivenTime(1000);
				HighlightElement(listOfInvoiceNumber.get(0));
				listOfInvoiceNumber.get(0).isDisplayed();
				break; 
			}
		
		}	return listOfInvoiceNumber.get(0).isDisplayed();			 		
	}
	
	public boolean Validate_POH_MOP_DisplayedOnOrderPage() {
		if(listOfWalkinSales.get(0).getText().contains("Walkin Sales") 
				&& listOfPickUp.get(0).getText().contains("Pick Up")
				&& listOfPaidOutsideHana.get(0).getText().contains("Paid Outside Hana")) {
			HighlightElement(listOfInvoiceNumber.get(0));
			delayWithGivenTime(1000);
			for(int i=0;i<listOfPaidOutsideHana.size();) {
				listOfPaidOutsideHana.get(0).isDisplayed();
				break;
			}
		}return listOfPaidOutsideHana.get(0).isDisplayed();
	}
	
	public boolean Validate_GiftCard_MOP_DisplayedOnOrderPage() {
		if(listOfWalkinSales.get(0).getText().contains("Walkin Sales") 
				&& listOfPickUp.get(0).getText().contains("Pick Up")
				&&	listOfGiftCard.get(0).getText().contains("Gift Card")) {
			HighlightElement(listOfInvoiceNumber.get(0));
			delayWithGivenTime(1000);
			for(int i=0;i<listOfGiftCard.size();) {
				listOfGiftCard.get(0).isDisplayed();
				break;
			}
		}return listOfGiftCard.get(0).isDisplayed();
	}
	
	public boolean Validate_Donation_MOP_DisplayedOnOrderPage() {
		
		if(listOfWalkinSales.get(0).getText().contains("Walkin Sales") 
				&& listOfPickUp.get(0).getText().contains("Pick Up")
				&&	listOfDonation.get(0).getText().contains("Donation")) {
			HighlightElement(listOfInvoiceNumber.get(0));
			HighlightElement(listOfOrderStatus.get(0));
			delayWithGivenTime(1000);
			
			for (WebElement donation : listOfDonation) {
		        if (donation.isDisplayed()) {
		            return true;
		        }
		    }			
		}return false;
	}
	
	public boolean getStatusOnOrderPage() {
		if(listOfWalkinSales.get(0).getText().contains("Walkin Sales") 
				&& listOfPickUp.get(0).getText().contains("Pick Up") ) {
			HighlightElement(listOfInvoiceNumber.get(0));
			
			delayWithGivenTime(1000);
			
			for (WebElement status : listOfOrderStatus) {
				HighlightElement(listOfOrderStatus.get(0));
		        if (status.isDisplayed()) {
		        	System.out.println("Order status is : "+status.getText());
		        	return true;
		        }
		    }			
		}return false;
	}
	
	public String GetInvoiceAmountOnOrderPage() {
		if(listOfWalkinSales.get(0).getText().contains("Walkin Sales")
				&&listOfPickUp.get(0).getText().contains("Pick Up")
				&&listOfCashMOP.get(0).getText().contains("Cash")) {
			HighlightElement(listOfWalkinSales.get(0));
			delayWithGivenTime(1000);
			HighlightElement(listOfOrderDetail.get(0));
			delayWithGivenTime(1000);
			HighlightElement(firstrowOfOrderDetail.get(0));
			delayWithGivenTime(1000);
			for (int i= 0;i<listOfInvoiceAmountValue.size(); ) {				
				break; 
			}
			HighlightElement(listOfInvoiceAmountValue.get(0));
			delayWithGivenTime(1000);
		}	return listOfInvoiceAmountValue.get(0).getText();			 		
	}
	
	public boolean Validate_PhoneOrder_Invoice() {
		if(listOfPhoneOrder.get(0).getText().contains("Phone Order") 
				&& listOfPickUp.get(0).getText().contains("Pick Up") 
				&& listOfCashMOP.get(0).getText().contains("Cash")) {
			
			HighlightElement(listOfPhoneOrder.get(0));
			delayWithGivenTime(1000);
			HighlightElement(listOfOrderDetail.get(0));
			delayWithGivenTime(1000);
			HighlightElement(firstrowOfOrderDetail.get(0));
			delayWithGivenTime(1000);
			HighlightElement(listOfInvoiceNumber.get(0));
			delayWithGivenTime(1000);
		}	return listOfInvoiceNumber.get(0).isDisplayed();			 		
	}
	
	public boolean Validate_PhoneOrder_InvoiceInHousePayment() {
		if(listOfPhoneOrder.get(0).getText().contains("Phone Order") 
				&& listOfPickUp.get(0).getText().contains("Pick Up") 
				&& listOfInvoiceHouseAccount.get(0).getText().contains("Invoice/House Account")) {
			
		HighlightElement(listOfInvoiceHouseAccount.get(0));
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
			
			HighlightElement(listOfWalkinSales.get(0));
			delayWithGivenTime(500);
			HighlightElement(listOfOrderDetail.get(0));
			delayWithGivenTime(500);
			HighlightElement(firstrowOfOrderDetail.get(0));			
			click(listOfSenderCustomer.get(0));
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
			
			HighlightElement(ListOfOrderType_OnOrderPageTable.get(0));
			delayWithGivenTime(500);
			HighlightElement(ListOfDeliveryType_OnOrderPageTable.get(0));
			delayWithGivenTime(500);
			HighlightElement(ListOfMOP_OnOrderPageTable.get(0));			
			jsClick(ListOfOrderType_OnOrderPageTable.get(0));
		}	 			 		
	}
	
	public boolean Validate_DeliveryAsCashPayment_on_PhoneOrder_on_SenderorCustomer_OnOrderPage() {
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().contains("Phone Order") 
			&& ListOfDeliveryType_OnOrderPageTable.get(0).getText().contains("Delivery") 
			&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("Cash")) {
			
		if(ListOfOrderType_OnOrderPageTable.get(0).isDisplayed()&&ListOfDeliveryType_OnOrderPageTable.get(0).isDisplayed()&&ListOfMOP_OnOrderPageTable.get(0).isDisplayed()) {
				HighlightElement(ListOfOrderType_OnOrderPageTable.get(0));			
				HighlightElement(ListOfDeliveryType_OnOrderPageTable.get(0));			
				HighlightElement(ListOfMOP_OnOrderPageTable.get(0));			
				return true;
			}
		}return false;	 			 		
	}
	
	public String GetSenderorCustomerOnOrderPage() {
		if(listOfWalkinSales.get(0).getText().contains("Walkin Sales")
				&&listOfPickUp.get(0).getText().contains("Pick Up")
				&&listOfCashMOP.get(0).getText().contains("Cash")) {
		
			HighlightElement(firstrowOfOrderDetail.get(0));
			delayWithGivenTime(1000);
		
			for (int i= 0;i<listOfSenderCustomer.size(); ) {	
				HighlightElement(listOfSenderCustomer.get(0));
				delayWithGivenTime(1000);
				break; 
			}
			
			
		}	return listOfSenderCustomer.get(0).getText();			 		
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
			
			HighlightElement(listOfWalkinSales.get(0));
			delayWithGivenTime(500);
			HighlightElement(listOfOrderDetail.get(0));
			delayWithGivenTime(500);
			HighlightElement(firstrowOfOrderDetail.get(0));			
			click(listOfSenderCustomer.get(0));
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
		
	public boolean Validate_WireInOrderType_Appears_OnOrderPage() {			
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().contains("FSN Order") 
				&& ListOfDeliveryType_OnOrderPageTable.get(0).getText().contains("Wire In") 
				&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("FSN")) {
					
					System.out.println("Order Type : "+ListOfOrderType_OnOrderPageTable.get(0).getText());
					System.out.println("Delivery Type : "+ListOfDeliveryType_OnOrderPageTable.get(0).getText());
					System.out.println("MOP : "+ListOfMOP_OnOrderPageTable.get(0).getText());					
					return true;
											
			}return ListOfOrderType_OnOrderPageTable.get(0).isDisplayed();	
	}
	
	public boolean Validate_WireInDeliveryType_Appears_OnOrderPage() {			
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().contains("FSN Order") 
				&& ListOfDeliveryType_OnOrderPageTable.get(0).getText().contains("Wire In") 
				&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("FSN")) {				
					return true;
			}return ListOfDeliveryType_OnOrderPageTable.get(0).isDisplayed();	
	}
	
	public boolean Validate_WireInMOP_Appears_OnOrderPage() {			
		if(ListOfOrderType_OnOrderPageTable.get(0).getText().contains("FSN Order") 
				&& ListOfDeliveryType_OnOrderPageTable.get(0).getText().contains("Wire In") 
				&& ListOfMOP_OnOrderPageTable.get(0).getText().contains("FSN")) {			
				return true;			
			}	return ListOfMOP_OnOrderPageTable.get(0).isDisplayed();	
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
	
	

