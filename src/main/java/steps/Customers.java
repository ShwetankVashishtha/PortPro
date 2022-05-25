package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import wrappers.TestBase;

public class Customers {

	TestBase base = new TestBase();
	forms.Dispatcher dispatcher;
	forms.LoadInfoPage loadInfo;
	forms.BillingPage billingTab;
	forms.PaymentPage paymentTab;
	forms.CustomerPage customerPage;
	static String totalBill = null;

	@When("User redirects to Customer profile section")
	public void user_redirects_to_customer_profile_section() {
		customerPage = new forms.CustomerPage(base.getdriver());
		customerPage.navigateToCustomerProfile();
	}

	@When("User clicks {string} button")
	public void user_clicks_button(String string) {
		customerPage = new forms.CustomerPage(base.getdriver());
		customerPage.clickAddNewCustomer_button(string);
	}

	@When("User selects customer checkbox")
	public void user_selects_customer_checkbox() {
		customerPage = new forms.CustomerPage(base.getdriver());
		customerPage.selectCustomerCheckbox();
	}

	@When("User enters Company Name, Address, City, State, Zip Code, Country, Email and Password")
	public void user_enters_company_name_address_city_state_zip_code_country_email_and_password() throws InterruptedException {
		customerPage = new forms.CustomerPage(base.getdriver());
		customerPage.enterCustomerDetails();
	}

	@When("User clicks add new customer button on popup")
	public void user_clicks_add_new_customer_button_on_popup() {
		customerPage = new forms.CustomerPage(base.getdriver());
		customerPage.createCustomer();
	}

	@Then("User gets message on customer creation {string}")
	public void user_gets_message_on_customer_creation(String string) {
		customerPage = new forms.CustomerPage(base.getdriver());
		customerPage.addedCustomer_successMsg(string);
		dispatcher = new forms.Dispatcher(base.getdriver());
		dispatcher.closeAUT();
	}
	
	@When("User filters the list to get all customers")
	public void user_filters_the_list_to_get_all_customers() {
		customerPage = new forms.CustomerPage(base.getdriver());
		customerPage.customerFilterButton();
	}

	@When("User edits a random customer")
	public void user_edits_a_random_customer() {
		customerPage = new forms.CustomerPage(base.getdriver());
		customerPage.editRandomCustomer();
	}

	@When("User enters recovery email")
	public void user_enters_recovery_email() {
	    customerPage = new forms.CustomerPage(base.getdriver());
	    customerPage.addReceiverEmail();
	}
	
	@When("User gets message on customer updation {string}")
	public void user_gets_message_on_customer_updation(String string) {
		customerPage = new forms.CustomerPage(base.getdriver());
		customerPage.verifyUserUpdatedMessage(string);
		dispatcher = new forms.Dispatcher(base.getdriver());
		dispatcher.closeAUT();
	}
}
