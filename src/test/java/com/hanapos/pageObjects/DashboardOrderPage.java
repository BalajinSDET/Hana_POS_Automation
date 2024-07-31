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

	
	public String validateDashboardOrderPage() {
		return	getDriver().getCurrentUrl();
	}

	public boolean ValidateInvoiceNumber() {
		if(listOfWalkinSales.get(0).getText().equals("Walkin Sales") 
				&& listOfPickUp.get(0).getText().equals("Pick Up") 
				&& listOfCashMOP.get(0).getText().equals("Cash")) {
			for (int i= 0;i<listOfInvoiceNumber.size(); i++ ) {	
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
				&& listOfPickUp.get(0).getText().contains("Pick Up") ) {
			HighlightElement(listOfInvoiceNumber.get(0));
			delayWithGivenTime(1000);
			for(int i=0;i<listOfPaidOutsideHana.size();i++) {
				listOfPaidOutsideHana.get(0).isDisplayed();
				break;
			}
		}return listOfPaidOutsideHana.get(0).isDisplayed();
	}
	
	public boolean Validate_GiftCard_MOP_DisplayedOnOrderPage() {
		if(listOfWalkinSales.get(0).getText().contains("Walkin Sales") 
				&& listOfPickUp.get(0).getText().contains("Pick Up") ) {
			HighlightElement(listOfInvoiceNumber.get(0));
			delayWithGivenTime(1000);
			for(int i=0;i<listOfGiftCard.size();i++) {
				listOfGiftCard.get(0).isDisplayed();
				break;
			}
		}return listOfGiftCard.get(0).isDisplayed();
	}
	
	public boolean Validate_Donation_MOP_DisplayedOnOrderPage() {
		
		if(listOfWalkinSales.get(0).getText().contains("Walkin Sales") 
				&& listOfPickUp.get(0).getText().contains("Pick Up") ) {
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
			for (int i= 0;i<listOfInvoiceAmountValue.size(); i++ ) {				
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
	
	
	public String GetSenderorCustomerOnOrderPage() {
		if(listOfWalkinSales.get(0).getText().contains("Walkin Sales")
				&&listOfPickUp.get(0).getText().contains("Pick Up")
				&&listOfCashMOP.get(0).getText().contains("Cash")) {
			HighlightElement(listOfWalkinSales.get(0));
			delayWithGivenTime(1000);
			HighlightElement(listOfOrderDetail.get(0));
			delayWithGivenTime(1000);
			HighlightElement(firstrowOfOrderDetail.get(0));
			delayWithGivenTime(1000);
			
			for (int i= 0;i<listOfSenderCustomer.size(); i++ ) {				
				break; 
			}
			
			HighlightElement(listOfSenderCustomer.get(0));
			delayWithGivenTime(1000);
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
			
			
			for (int i= 0;i<listOfSenderCustomer.size(); i++ ) {				
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
	
}
	

