package forms;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import locators.WebLocators;
import utilities.FunLibrary;
import utilities.PropertyManager;
import wrappers.PageBase;
import wrappers.TestBase;

public class AccountReceivablePage extends PageBase implements WebLocators {

	public AccountReceivablePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	PropertyManager propertyManager = new PropertyManager();
	TestBase base = new TestBase();

	@FindBy(xpath = ACCOUNT_RECEIVABLE_LEFT_ICON)
	private WebElement accReceivable_Icon;

	@FindBy(xpath = ACCOUNT_RECEIVABLE_LEFT_MENU)
	private WebElement accReceivable_LeftMenu;

	@FindBy(xpath = APPLYPAYMENTS)
	private WebElement applyPaymentPage;

	@FindBy(xpath = APPLYPAYMENT_TAB)
	private WebElement applyPayment_tab;

	@FindBy(xpath = SELECTCUSTOMER_DD)
	private WebElement selectCustomer_DD;

	@FindBy(xpath = APPLYPAYMENT_BUTTON)
	private WebElement applyPayment_btn;

	@FindBy(xpath = DATANOTFOUND)
	private WebElement dataNotFound;

	public WebElement getDataNotFound() {
		return dataNotFound;
	}

	public WebElement getAccReceivable_Icon() {
		return accReceivable_Icon;
	}

	public WebElement getAccReceivable_LeftMenu() {
		return accReceivable_LeftMenu;
	}

	public WebElement getApplyPaymentPage() {
		return applyPaymentPage;
	}

	public WebElement getApplyPayment_tab() {
		return applyPayment_tab;
	}

	public WebElement getSelectCustomer_DD() {
		return selectCustomer_DD;
	}

	public WebElement getApplyPayment_btn() {
		return applyPayment_btn;
	}

	public void navigateToAddPaymentsPage() {
		base.waitForElementVisible(10, getAccReceivable_Icon());
		Actions action = new Actions(base.getdriver());
		action.moveToElement(getAccReceivable_Icon()).build().perform();
		base.waitForElementVisible(10, getAccReceivable_LeftMenu());
		base.waitForElementToBeClickable(10, getAccReceivable_LeftMenu());
		action.moveToElement(getAccReceivable_LeftMenu()).click().build().perform();
		base.waitForElementToBeClickable(10, getApplyPaymentPage());
		action.moveToElement(getApplyPaymentPage()).click().build().perform();
		base.waitForElementVisible(10, getApplyPayment_tab());
	}

	public void selectCustomer(String customer) {
		base.waitForElementVisible(10, getSelectCustomer_DD());
		base.waitForElementToBeClickable(10, getSelectCustomer_DD());
		getSelectCustomer_DD().click();

		List<WebElement> cust = driver.findElements(By.xpath("//div[@class='css-guqdj4-menu']/div/div"));

		for (WebElement ele : cust) {

			if (ele.getText().equalsIgnoreCase(customer)) {
				System.out.println(ele.getText());
				ele.click();
				break;
			}
		}
	}

	public void selectRandomLoad() {
		base.waitForPageLoad(10);
		List<WebElement> loads = driver.findElements(
				By.xpath("//table[@class='table table-card table-card--ls']//tr//td//input[@type='checkbox']"));

		if (loads.size() > 0) {
			int loadNo = FunLibrary.getRandomNumber(loads.size());
			if (!loads.get(loadNo).isSelected()) {
				loads.get(loadNo).click();
			}
		} else {
			Assert.fail("No Loads are available for the customer");
		}
	}

	public void addPayment() {
		base.waitForElementVisible(10, getApplyPayment_btn());
		base.waitForElementToBeClickable(10, getApplyPayment_btn());
		getApplyPayment_btn().click();
	}

	public void verifySuccessMsg(String msg) {
		base.waitForElementVisible(10, driver.findElement(By.xpath("//*[contains(text(),'" + msg + "')]")));
	}
}
