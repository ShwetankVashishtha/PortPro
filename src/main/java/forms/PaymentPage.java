package forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import locators.WebLocators;
import utilities.DateUtils;
import utilities.FunLibrary;
import utilities.PropertyManager;
import wrappers.PageBase;
import wrappers.TestBase;

public class PaymentPage extends PageBase implements WebLocators{

	PropertyManager propertyManager = new PropertyManager();
	TestBase base = new TestBase();
	
	public PaymentPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = PAYMENTTAB)
	private WebElement paymentTab;
	
	@FindBy(xpath = ADDPAYMENT_BTN)
	private WebElement addPaymentBtn;
	
	@FindBy(xpath = ENTERAMOUNT_ADDPAYMENTPOPUP)
	private WebElement enterAmount_addPaymentPopUp;
	
	@FindBy(xpath = PAYMENTDATE_TXTBOX)
	private WebElement paymentDate;
	
	@FindBy(xpath = ADDPAYMENTBTN_POPUP)
	private WebElement addPaymentBtn_PopUp;
	
	@FindBy(xpath = SUCCESSMSG_ADDPAYMENT)
	private WebElement successMsg_addPayment;
	
	public WebElement getSuccessMsg_addPayment() {
		return successMsg_addPayment;
	}

	public WebElement getPaymentTab() {
		return paymentTab;
	}

	public WebElement getAddPaymentBtn() {
		return addPaymentBtn;
	}

	public WebElement getEnterAmount_addPaymentPopUp() {
		return enterAmount_addPaymentPopUp;
	}

	public WebElement getPaymentDate() {
		return paymentDate;
	}

	public WebElement getAddPaymentBtn_PopUp() {
		return addPaymentBtn_PopUp;
	}

	public void navigateToPaymentTab() {
		
		base.waitForElementVisible(10, getPaymentTab());
		base.waitForElementToBeClickable(10, getPaymentTab());
		getPaymentTab().click();
	}
	
	public void clickAddPaymentBtn() {
		
		base.waitForElementVisible(10, getAddPaymentBtn());
		base.waitForElementToBeClickable(10, getAddPaymentBtn());
		getAddPaymentBtn().click();
	}
	
	public void enterAmount_PaymentPopup() {
		
		base.waitForElementVisible(10, getEnterAmount_addPaymentPopUp());
		getEnterAmount_addPaymentPopUp().clear();
		getEnterAmount_addPaymentPopUp().sendKeys(String.valueOf(FunLibrary.getRandomNumber(500)));
	}
	
	public void selectDate_payment() {
        base.waitForElementVisible(10, getPaymentDate());
        base.waitForElementToBeClickable(10, getPaymentDate());
        getPaymentDate().click();
        getPaymentDate().clear();
        String tomorrowDate = DateUtils.getFormattedDate(DateUtils.getTomorrowDate(), "MM-DD-YY h:mm a");
        getPaymentDate().sendKeys(tomorrowDate);
    }
	
	public void savePaymentDetails() {
		
		base.waitForElementVisible(10, getAddPaymentBtn_PopUp());
		base.waitForElementToBeClickable(10, getAddPaymentBtn_PopUp());
		getAddPaymentBtn_PopUp().click();
	}

	public boolean verifySuccessMsg_AddPayment() {
		return getAddPaymentBtn_PopUp().isDisplayed();
	}
}
