package forms;


import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.support.FindBy;

import com.github.javafaker.Faker;

import locators.WebLocators;
import requests.getLoads;
import utilities.FunLibrary;
import utilities.PropertyManager;
import wrappers.PageBase;
import wrappers.TestBase;

public class CustomerPage extends PageBase implements WebLocators {

	public CustomerPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	PropertyManager propertyManager = new PropertyManager();
	TestBase base = new TestBase();
	Faker fake = new Faker();
	public static String company_Name = null;
	
	@FindBy(xpath = CUSTOMER_LEFT_MENU_ICON)
	private WebElement customerleftMenuIcon;

	@FindBy(xpath = CUSTOMER_LEFT_MENU)
	private WebElement customerLeftMenu;

	@FindBy(xpath = CUSTOMER_PROFILE)
	private WebElement customerProfie;

	@FindBy(xpath = CUSTOMERPROFILE_TAB)
	private WebElement customerProfileTab;

	@FindBy(xpath = ADDNEWCUSTOMER_BUTTON)
	private WebElement addNeCustomerButton;;

	@FindBy(xpath = ADDNEWCUSTOMER_POPUPBTN)
	private WebElement adNewCustomerButton_Popup;

	@FindBy(xpath = CUSTOMER_CHECKBOX)
	private WebElement customer_checkbox;

	@FindBy(xpath = COMPANYNAME_TEXTBOX)
	private WebElement companyName;

	@FindBy(xpath = ADDRESS_TEXTBOX)
	private WebElement address;

	@FindBy(xpath = CITY_TEXTBOX)
	private WebElement city;

	@FindBy(xpath = STATE_TEXTBOX)
	private WebElement state;

	@FindBy(xpath = ZIPCODE_TEXTBOX)
	private WebElement zipcode;

	@FindBy(xpath = COUNTRY_TEXTBOX)
	private WebElement country;

	@FindBy(xpath = EMAIL_TEXTBOX)
	private WebElement email;

	@FindBy(xpath = PASSWORD_TEXTBOX)
	private WebElement password;

	@FindBy(xpath = ADDNEWCUSTOMER_TITlE)
	private WebElement addCustomerTitle;
	
	@FindBy(xpath = RECEIVEREMAIL)
	private WebElement receiverEmail;
	
	@FindBy(xpath = CUSTOMERFILTERBUTTON)
	private WebElement customerFilterBtn;
	
	@FindBy(xpath = SUCCESFULLYUPDATED_MSG)
	private WebElement successfulUpdateMessage;
	
	@FindBy(xpath=SEARCH_CUSTOMER)
	private WebElement searchCustomer;
	
	@FindBy(xpath = DELETECSOMER_POPUPBTN)
	private WebElement deleteCustomer_popupBtn;
	
	@FindBy(xpath=CUSTOMERS_COUNT)
	private WebElement cutomersCount;
	
	@FindBy(xpath=BACKBUTTON)
	private WebElement backButton;

	public WebElement getBackButton() {
		return backButton;
	}

	public WebElement getCutomersCount() {
		return cutomersCount;
	}

	public WebElement getDeleteCustomer_popupBtn() {
		return deleteCustomer_popupBtn;
	}

	public WebElement getSearchCustomer() {
		return searchCustomer;
	}

	public void setSearchCustomer(WebElement searchCustomer) {
		this.searchCustomer = searchCustomer;
	}

	public WebElement getSuccessfulUpdateMessage() {
		return successfulUpdateMessage;
	}

	public WebElement getDeleteCustomer() {
		return deleteCustomer;
	}

	public WebElement getCustomerFilterBtn() {
		return customerFilterBtn;
	}

	public WebElement getReceiverEmail() {
		return receiverEmail;
	}

	public WebElement getCustomerleftMenuIcon() {
		return customerleftMenuIcon;
	}

	@FindBy(xpath = CUSTOMERADDEDMESSAGE)
	private WebElement addCustomerMessage;
	
	@FindBy(xpath=DELETECUSTOMER_BTN)
	private WebElement deleteCustomer;

	public WebElement getAddCustomerMessage() {
		return addCustomerMessage;
	}

	public WebElement getAddCustomerTitle() {
		return addCustomerTitle;
	}

	public WebElement getCustomerLeftMenu() {
		return customerLeftMenu;
	}

	public WebElement getCustomerProfie() {
		return customerProfie;
	}

	public WebElement getCustomerProfileTab() {
		return customerProfileTab;
	}

	public WebElement getAddNeCustomerButton() {
		return addNeCustomerButton;
	}

	public WebElement getAdNewCustomerButton_Popup() {
		return adNewCustomerButton_Popup;
	}

	public WebElement getCustomer_checkbox() {
		return customer_checkbox;
	}

	public WebElement getCompanyName() {
		return companyName;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getState() {
		return state;
	}

	public WebElement getZipcode() {
		return zipcode;
	}

	public WebElement getCountry() {
		return country;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public void navigateToCustomerProfile() {
		base.waitForElementVisible(10, getCustomerleftMenuIcon());
		Actions action = new Actions(base.getdriver());
		action.moveToElement(getCustomerleftMenuIcon()).build().perform();
		base.waitForElementVisible(10, getCustomerLeftMenu());
		base.waitForElementToBeClickable(10, getCustomerLeftMenu());
		action.moveToElement(getCustomerLeftMenu()).click().build().perform();
		base.waitForElementToBeClickable(10, getCustomerProfie());
		action.moveToElement(getCustomerProfie()).click().build().perform();
		base.waitForElementVisible(10, getCustomerProfileTab());
	}

	public void clickAddNewCustomer_button(String mValue) {
		WebElement addCustomer = driver.findElement(By.xpath("//*[text()='" + mValue + "']"));
		base.waitForElementToBeClickable(10, addCustomer);
		addCustomer.click();
		base.waitForElementVisible(10, getAddCustomerTitle());
	}

	public void selectCustomerCheckbox() {
		base.waitForElementVisible(10, getCustomer_checkbox());
		base.waitForElementToBeClickable(10, getCustomer_checkbox());
		if (!getCustomer_checkbox().isSelected()) {
			getCustomer_checkbox().click();
		}
	}

	public void enterCustomerDetails() throws InterruptedException {
		company_Name = fake.company().name();
		base.waitForElementVisible(10, getCompanyName());
		base.waitForElementToBeClickable(10, getCompanyName());

		getCompanyName().sendKeys(company_Name);
		enterAddressDetails();

		getEmail().sendKeys(fake.name().firstName() + fake.name().lastName() + "@getnada.com");
		getPassword().sendKeys("123456789");

	}

	public void enterAddressDetails() throws InterruptedException {
		getAddress().sendKeys("1 World Way, Los Angeles, CA, USA");
		Thread.sleep(10000);
		List<WebElement> ele = driver.findElements(By.xpath("//div[@class='react-mapbox-ac-suggestion']"));
		if (ele.size() > 0) {
			ele.get(0).click();
		}
		
		base.attributeToBe(15, getCity(), "value", "Los Angeles");
	}

	public void createCustomer() {
		base.waitForElementVisible(10, getAdNewCustomerButton_Popup());
		base.waitForElementToBeClickable(10, getAdNewCustomerButton_Popup());
		getAdNewCustomerButton_Popup().click();
	}

	public void addedCustomer_successMsg(String msg) {
		base.waitForElementVisible(20, getAddCustomerMessage());
		assertEquals(getAddCustomerMessage().getText().trim(), msg);
	}
	
	public void addReceiverEmail() {
		Faker faker = new Faker();
		base.waitForElementVisible(10, getReceiverEmail());
		base.waitForElementToBeClickable(10, getReceiverEmail());
		getReceiverEmail().clear();
		getReceiverEmail().sendKeys(faker.name().firstName()+"@test.com");
	}
	
	public void customerFilterButton() {
		base.waitForElementVisible(10, getCustomerFilterBtn());
		base.waitForElementToBeClickable(10, getCustomerFilterBtn());
		getCustomerFilterBtn().click();
		base.waitForPageLoad(10);
	}
	
	public void editRandomCustomer() {
		List<WebElement> editCust = driver.findElements(By.xpath("//table[@class='table table-card']//tr//td[1]"));
		if(editCust.size()>0) {
			
			editCust.get(FunLibrary.getRandomNumber(editCust.size()-1)).click();
			base.waitForElementVisible(10, getCompanyName());
			base.waitForElementToBeClickable(10, getCompanyName());
			company_Name = getCompanyName().getAttribute("value").trim();
			System.out.println(company_Name);
		}
	}
	
	public void verifyUserUpdatedMessage(String msgs) {
		base.waitForElementVisible(10, getSuccessfulUpdateMessage());
		assertEquals(getSuccessfulUpdateMessage().getText().trim(), msgs);
	}
	
	public void deleteCreatedCustomer() {
		
		//getLoads.deleteCustomer(company_Name);
		base.waitForElementVisible(10, getSearchCustomer());
		getSearchCustomer().sendKeys(company_Name);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		base.waitForElementToBeClickable(15, getDeleteCustomer());
		getDeleteCustomer().click();
		base.waitForElementToBeClickable(15, getDeleteCustomer_popupBtn());
		getDeleteCustomer_popupBtn().click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String attribute = getCutomersCount().getText().trim();
		assertEquals(attribute, "0");
	}
	
	public void navigateBacktoCustomerList() {
		
		base.waitForElementVisible(10, getBackButton());
		getBackButton().click();
	}
	
}
