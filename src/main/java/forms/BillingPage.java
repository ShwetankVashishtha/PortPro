package forms;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import locators.WebLocators;
import requests.getLoads;
import utilities.FunLibrary;
import utilities.PropertyManager;
import wrappers.PageBase;
import wrappers.TestBase;

public class BillingPage extends PageBase implements WebLocators {

	PropertyManager propertyManager = new PropertyManager();
	TestBase base = new TestBase();

	public BillingPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = BILLING_TAB)
	private WebElement billingTab;

	@FindBy(xpath = MAINCUSTOMER)
	private WebElement mainCustomer;

	@FindBy(xpath = SUBCUSTOMER)
	private WebElement subCustomer;

	@FindBy(xpath = ADDCHARGE)
	private WebElement addCharge;

	@FindBy(xpath = SELECTCHARGE_DD)
	private WebElement selectCharge_DD;

	@FindBy(xpath = ENTERPRICE_BILLING)
	private WebElement enterBillingPrice;

	@FindBy(xpath = UPDATEBILLINGSUCCESSMSG)
	private WebElement updateBillingSuccessMessage;

	@FindBy(xpath = ADDSUBBILL)
	private WebElement addSubBill;

	@FindBy(xpath = SELECTSUBCUSTOMER_DD)
	private WebElement selectSubCustomerDD;

	@FindBy(xpath = UPDATEBILLINGSUCCESSMSG_SUBCUSTOMER)
	private WebElement billingUpdateMsg_SubCustomer;

	@FindBy(xpath = DELETEPRICIMSG)
	private WebElement deletePricingMsg;

	@FindBy(xpath = APPOVED_CHECKBOX)
	private WebElement approvedCheckbox;

	@FindBy(xpath = APPROVED_INVOICE_CHECKBOX)
	private WebElement approvedInvoiceCheckBox;

	@FindBy(xpath = UNAPPROVED_CHECKBOX)
	private WebElement unapprovedCheckBox;

	@FindBy(xpath = REBILL_CHECKBOX)
	private WebElement rebillCheckbox;

	@FindBy(xpath = CANELBTN_SENDMAIL)
	private WebElement cancelButton;

	public WebElement getCancelButton() {
		return cancelButton;
	}

	public WebElement getApprovedCheckbox() {
		return approvedCheckbox;
	}

	public WebElement getApprovedInvoiceCheckBox() {
		return approvedInvoiceCheckBox;
	}

	public WebElement getUnapprovedCheckBox() {
		return unapprovedCheckBox;
	}

	public WebElement getRebillCheckbox() {
		return rebillCheckbox;
	}

	public WebElement getDeletePricingMsg() {
		return deletePricingMsg;
	}

	public WebElement getBillingUpdateMsg_SubCustomer() {
		return billingUpdateMsg_SubCustomer;
	}

	public WebElement getAddSubBill() {
		return addSubBill;
	}

	public WebElement getSelectSubCustomerDD() {
		return selectSubCustomerDD;
	}

	public WebElement getUpdateBillingSuccessMessage() {
		return updateBillingSuccessMessage;
	}

	public WebElement getEnterBillingPrice() {
		return enterBillingPrice;
	}

	public WebElement getBillingTab() {
		return billingTab;
	}

	public WebElement getMainCustomer() {
		return mainCustomer;
	}

	public WebElement getSubCustomer() {
		return subCustomer;
	}

	public WebElement getAddCharge() {
		return addCharge;
	}

	public WebElement getSelectCharge_DD() {
		return selectCharge_DD;
	}

	public void navigatetoBillingTab() {
		base.waitForElementVisible(10, getBillingTab());
		base.waitForElementToBeClickable(10, getBillingTab());
		getBillingTab().click();
		base.waitForElementVisible(10, getMainCustomer());
	}

	public void selectMainCustomer() {
		base.waitForElementVisible(10, getMainCustomer());
		base.waitForElementToBeClickable(10, getMainCustomer());
		getMainCustomer().click();
	}

	public void clickAddChargeButton() {
		base.waitForElementVisible(10, getAddCharge());
		base.waitForElementToBeClickable(10, getAddCharge());
		getAddCharge().click();
	}

	public void selectRandomChargetype_DD() {
		base.waitForElementVisible(20, getSelectCharge_DD());
		base.waitForElementToBeClickable(20, getSelectCharge_DD());

		getSelectCharge_DD().click();
		base.pause(3000);
		try {

			List<WebElement> chrgeType = driver.findElements(By.xpath("//div[@class='css-guqdj4-menu']/div/div"));
			chrgeType.get(0).click();
		} catch (Exception e) {

			List<WebElement> chrgeType = driver.findElements(By.xpath("//div[@class='css-1a5snlm-menu']/div/div"));
			chrgeType.get(10).click();
		}

	}

	public void enterBillingPrice() {
		base.waitForElementVisible(10, getEnterBillingPrice());
		List<WebElement> enterPrice = driver.findElements(By.xpath("//input[@name='finalAmount']"));
		if (enterPrice.size() > 0) {
			enterPrice.get(enterPrice.size() - 1).clear();
			enterPrice.get(enterPrice.size() - 1).sendKeys(String.valueOf(FunLibrary.getRandomNumber(200)));
		} else {
			Assert.fail("No text box is available to enter the billing price.");
		}
	}

	public void verifyUpdateBillingSuccessMsg(String msg) {
		base.waitForElementVisible(10, getUpdateBillingSuccessMessage());
		assertEquals(getUpdateBillingSuccessMessage().getText().trim(), msg);
	}

	public void selectSubCustomer() {
		base.waitForElementVisible(10, getSubCustomer());
		base.waitForElementToBeClickable(10, getSubCustomer());
		getSubCustomer().click();
	}

	public void clickAddSubBill() {
		base.waitForElementVisible(10, getAddSubBill());
		base.waitForElementToBeClickable(10, getAddSubBill());
		base.pause(2000);
		JavascriptExecutor js = (JavascriptExecutor) base.getdriver();
		js.executeScript("arguments[0].click()", getAddSubBill());
		base.pause(2000);
		base.waitForElementVisible(10, getSelectSubCustomerDD());
	}

	public void selectandomSubCustomer_DD() {
		base.waitForElementToBeClickable(10, getSelectSubCustomerDD());
		getSelectSubCustomerDD().click();
		base.pause(5000);
		List<WebElement> subCustomer = driver.findElements(By.xpath("//div[@class='css-guqdj4-menu']//div"));

		if (subCustomer.size() > 0) {

			int randNo = FunLibrary.getRandomNumber(subCustomer.size());
			subCustomer.get(randNo).click();
			base.pause(5000);
		}

		else {
			Assert.fail("No Sub Customer is available");
		}
	}

	public void verifySuccssMessage_subCustomer(String msg) {
		base.waitForElementVisible(10, getBillingUpdateMsg_SubCustomer());
		assertEquals(getBillingUpdateMsg_SubCustomer().getText().trim(), msg);
	}

	public void removeAddedBilling() {
		List<WebElement> deleteBillingBtn = driver
				.findElements(By.xpath("//button[@class='btn btn-xs btn-circle bg-soft-danger']"));

		if (deleteBillingBtn.size() > 0) {

			deleteBillingBtn.get(deleteBillingBtn.size() - 1).click();
		} else {
			Assert.fail("No Billing record is available for deletion.");
		}
	}

	public void verifyDeleteBillingSuccessMsg(String msg) {
		base.waitForElementVisible(10, getDeletePricingMsg());
		assertEquals(getDeletePricingMsg().getText().trim(), msg);
	}

	public void enableCheckboxes() {
		base.waitForElementToBeClickable(10, getApprovedCheckbox());
		assertTrue(getApprovedCheckbox().isEnabled());
		assertTrue(getApprovedInvoiceCheckBox().isEnabled());
	}

	public void disabledCheckboxes() {
		assertFalse(getRebillCheckbox().isEnabled());
		assertFalse(getUnapprovedCheckBox().isEnabled());
	}

	public void selectCheckBox(String checkboxName) {
		WebElement element = driver
				.findElement(By.xpath("//label[text()='" + checkboxName + "']//preceding-sibling::input"));
		base.waitForElementToBeClickable(10, element);

		if (!element.isSelected()) {
			element.click();
		}
	}

	public void closeMailPopUp() {
		base.waitForElementVisible(10, getCancelButton());
		base.waitForElementToBeClickable(10, getCancelButton());
		getCancelButton().click();
	}

	public void validateTotalAmountWithAPIresponse(String tBill) {
		String loadNumber = driver.findElement(By.tagName("h5")).getText().trim();
		loadNumber = loadNumber.replace("Load #: ", "").trim();
		String totalAmount_api = getLoads.getTotalAmount(loadNumber);
		System.out.println("API ==>" + totalAmount_api + " UI==>" + tBill);
		assertEquals(tBill, totalAmount_api);

	}

	public void addMultipleCharges(String text) {

		Dispatcher dispatcher = new Dispatcher(driver);
		for (int i = 0; i < Integer.parseInt(text); i++) {

			// selectRandomChargetype_DD();
			driver.findElement(By.xpath(
					"(//div[text()='Select...']//ancestor::div[@class='css-1pcexqc-container'])[" + (i + 1) + "]"))
					.click();
			base.pause(3000);
			try {

				List<WebElement> chrgeType = driver.findElements(By.xpath("//div[@class='css-guqdj4-menu']/div/div"));
				chrgeType.get(0+i).click();
			} catch (Exception e) {

				List<WebElement> chrgeType = driver.findElements(By.xpath("//div[@class='css-1a5snlm-menu']/div/div"));
				chrgeType.get(10).click();
			}

			enterBillingPrice();
			dispatcher.updateChanges();
			base.pause(5000);
			if (i != Integer.parseInt(text) - 1) {
				driver.findElement(By.xpath("//a[text()='Add Charge']")).click();
			}

			// clickAddChargeButton();
		}

		List<WebElement> delBtn = driver
				.findElements(By.xpath("(//button[@class='btn btn-xs btn-circle bg-soft-danger'])"));
		for (int j = delBtn.size()-1; j >= 0; j--) {

			delBtn.get(j).click();
			base.pause(3000);
		}
	}
}