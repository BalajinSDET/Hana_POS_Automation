package com.hanapos.pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.hanapos.seleniumProjectBase.TestBaseClass;

public class ProposalsPage extends TestBaseClass {
	
	public ProposalsPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//a[@class='nav-link li_Proposals']")
	private WebElement ProposalsMenu;
	
	@FindBy(xpath="//a[@id='btnAddProposalRV3']")
	private WebElement AddProposalBtn;
	
	@FindBy(xpath="//h4[contains(text(),'Create Proposal')]")
	private WebElement CreateProposalHeader_Popup;
	
	@FindBy(xpath="//input[@id='searchCustomer']")
	private WebElement SearchCustomer_SearchboxField;
	
	@FindBy(xpath="//ul[@id='ui-id-1']//li")
	private List<WebElement> CustomerList;
	
	@FindBy(xpath="//button[@id='btnContinueToProposal']")
	private WebElement AddProposalBtn_On_CreateProposalPopup;
	
	@FindBy(xpath="//a[@id='proposaldsort']")
	private WebElement proposal_Id_label;
	
	@FindBy(xpath="//span[@class='k-icon k-i-sort-asc-sm']")
	private WebElement proposal_Id_Sort_asc_Icon;
	
	@FindBy(xpath="//span[@class='k-icon k-i-sort-desc-sm']")
	private WebElement proposal_Id_Sort_desc_Icon;
	
	@FindBy(xpath="(//select[@id='ddlStatusType'])[1]")
	private WebElement proposal_StatusType_DropDown;
	
	@FindBy(xpath="(//span[@class='fa fa-bars fa-1x hana-color-drdAction'])[1]")
	private WebElement proposal_Action_Button;
	
	@FindBy(xpath="(//a[@class='CustomerProposalView'])[1]")
	private WebElement proposal_CustProposalView_Button;
	
	@FindBy(xpath="//p[text()='Red Rose Small']")
	private WebElement proposal_CustProposalView_itemName;
	
	
	public String get_ProposalsViewPageTitle() {
		return getDriver().getTitle();
	}
	
	
	public void ClickOnProposalsMenu()
	{
		click(ProposalsMenu);
	}
	
	public void Click_AddProposalBtn()
	{
		click(AddProposalBtn);
	}
	
	public boolean Verify_CreateProposalHeader_Popup()
	{
		HighlightElement(CreateProposalHeader_Popup);
		return CreateProposalHeader_Popup.isDisplayed();
	}
	
	public void SearchandSelect_Customer_OnProposal(String customerName) {
		clickAndType(SearchCustomer_SearchboxField, customerName);
		delayWithGivenTime(2000);
		for(WebElement ele : CustomerList) {
			if(ele.getText().contains(customerName)) {
				ele.click();
				break;
			}
			
		}
	}
	
	
	public void Click_AddProposal_On_CreateProposal_Popup() {
		click(AddProposalBtn_On_CreateProposalPopup);
	}
	
	public void Click_Proposal_Id_Label() {
		jsClick(proposal_Id_label);
	}
	
	public boolean Verify_Proposal_Id_Sort_desc_Icon() {
		HighlightElement(proposal_Id_Sort_desc_Icon);
		return proposal_Id_Sort_desc_Icon.isDisplayed();
	}
	
	public boolean Verify_Proposal_Id_Sort_asc_Icon() {
		HighlightElement(proposal_Id_Sort_asc_Icon);
		return proposal_Id_Sort_asc_Icon.isDisplayed();
	}
	
	
	public void Select_Proposal_StatusType_DropDown(String statusType) {
		dropDown(proposal_StatusType_DropDown, statusType,"VisibleText");
	}
	
	public String get_Selected_Proposal_StatusType() {
		HighlightElement(proposal_StatusType_DropDown);
		Select s = new Select(proposal_StatusType_DropDown);
		return s.getFirstSelectedOption().getText();
	}
	
	public void Click_Proposal_Action_Button() {
		jsClick(proposal_Action_Button);
	}
	
	public void Click_Proposal_CustProposalView_Button() {
		click(proposal_CustProposalView_Button);
		delayWithGivenTime(1000);
		switchToWindowbyIndex(1);		
	}
	
	public boolean Verify_ItemNameIsDisplayed_on_CustProposalView() {
		HighlightElement(proposal_CustProposalView_itemName);
		return proposal_CustProposalView_itemName.isDisplayed();
	}
	
}
