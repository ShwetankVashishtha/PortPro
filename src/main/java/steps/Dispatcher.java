package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import wrappers.TestBase;

public class Dispatcher {

	TestBase base = new TestBase();
	forms.Dispatcher dispatcher;
	forms.LoadInfoPage loadInfo;
	forms.BillingPage billingTab;
	forms.PaymentPage paymentTab;
	forms.AccountReceivablePage accPage;
	static String totalBill = null;

	@Given("User is redirected to AUT login url")
	public void openAUT() {
		dispatcher = new forms.Dispatcher(base.getdriver());
		dispatcher.openAUT();
	}

	@When("User login with {string} and {string}")
	public void loginUser(String username, String password) {
		dispatcher = new forms.Dispatcher(base.getdriver());
		dispatcher.loginUser(username, password);
	}

	@When("User navigates to dispatcher page from left menu")
	public void redirectToDispatcher() {
		dispatcher = new forms.Dispatcher(base.getdriver());
		dispatcher.redirectToDispatcher();
	}

	@And("User adds new load")
	public void addNewLoad() {
		dispatcher = new forms.Dispatcher(base.getdriver());
		dispatcher.addNewLoad();
	}

	@Then("User should be able to add load successfully")
	public void validateLoadCreateSuccessMessage() {
		dispatcher = new forms.Dispatcher(base.getdriver());
		dispatcher.validateLoadCreateSuccessMessage();
		dispatcher.closeAUT();
	}

	@And("User assigns driver to load")
	public void assignDriver() {
		dispatcher = new forms.Dispatcher(base.getdriver());
		dispatcher.assignDriver("Test port");
	}

	@Then("User should be able to assign driver successfully")
	public void validateSuccessMessage() {
		dispatcher = new forms.Dispatcher(base.getdriver());
		dispatcher.validateSuccessMessage();
		dispatcher.closeAUT();
	}

	@Then("User should be able to add notes successfully")
	public void validateNoteCreateSuccessMessage() {
		dispatcher = new forms.Dispatcher(base.getdriver());
		dispatcher.validateNoteCreateSuccessMessage();
		dispatcher.closeAUT();
	}

	@And("User adds notes {string}")
	public void userAddsNotes(String arg0) {
		dispatcher = new forms.Dispatcher(base.getdriver());
		dispatcher.addNewNotes(arg0);
	}

	@Then("User should be able to view correct Summary")
	public void validateBillingSummary() {
		dispatcher = new forms.Dispatcher(base.getdriver());
		dispatcher.validateBillingSummary();
		dispatcher.closeAUT();
	}

	@And("User selects load option {string}")
	public void selectLoadOptions(String arg0) {
		dispatcher = new forms.Dispatcher(base.getdriver());
		dispatcher.selectLoadOptions(arg0);
	}

	@And("User selects driver {string}")
	public void selectDriver(String arg0) {
		dispatcher = new forms.Dispatcher(base.getdriver());
		dispatcher.selectDriverFromDD(arg0);
	}

	@And("User selects date")
	public void selectDate() {
		dispatcher = new forms.Dispatcher(base.getdriver());
		dispatcher.selectDate();
	}

	@And("User selects pull container address {string}")
	public void selectPullContainerAddress(String arg0) {
		dispatcher = new forms.Dispatcher(base.getdriver());
		dispatcher.selectPullContainerFromDD(arg0);
	}

	@And("User selects deliver load address {string}")
	public void selectDeliverLoadAddress(String arg0) {
		dispatcher = new forms.Dispatcher(base.getdriver());
		dispatcher.selectDeliverLoadFromDD(arg0);
	}

	@And("User selects return container address {string}")
	public void selectReturnContainerAddress(String arg0) {
		dispatcher = new forms.Dispatcher(base.getdriver());
		dispatcher.selectReturnContainerFromDD(arg0);
	}

	@And("User save the changes")
	public void saveChanges() {
		dispatcher = new forms.Dispatcher(base.getdriver());
		dispatcher.clickSaveChanges();
		dispatcher.clickSaveChangesYes();
		dispatcher.validateRouteAssignSuccessMessage();
	}

	@And("User click on Complete Load")
	public void userClickOnuserClickOnCompleteLoadCompleteLoad() {
		dispatcher = new forms.Dispatcher(base.getdriver());
		dispatcher.clickCompleteLoad();
		dispatcher.clickSaveChangesYes();
	}

	@When("User selects any available load from list of loads")
	public void user_selects_any_available_load_from_list_of_loads() {
		dispatcher = new forms.Dispatcher(base.getdriver());
		dispatcher.selectLoad();
	}

	@When("User selects the chassis pickup location {string}")
	public void user_selects_the_chassis_pickup_location(String string) {
		loadInfo = new forms.LoadInfoPage(base.getdriver());
		loadInfo.selectChassisPickUpLicationFrom_DD(string);
	}

	@When("User selects the chassis termination location {string}")
	public void user_selects_the_chassis_termination_location(String string) {
		loadInfo = new forms.LoadInfoPage(base.getdriver());
		loadInfo.selectChassisTerminationLicationFrom_DD(string);
	}

	@When("User update the changes")
	public void user_update_the_changes() {
		dispatcher = new forms.Dispatcher(base.getdriver());
		dispatcher.updateChanges();
	}

	@Then("User is presented with a message {string}")
	public void user_is_presented_with_a_message(String string) {
		loadInfo = new forms.LoadInfoPage(base.getdriver());
		loadInfo.verifyUpdateSuccessMessage(string);
		dispatcher.closeAUT();
	}

	@Given("User clicks the billing tab")
	public void user_clicks_the_billing_tab() {
		billingTab = new forms.BillingPage(base.getdriver());
		billingTab.navigatetoBillingTab();
	}

	@When("User selects main customer")
	public void user_selects_main_customer() {
		billingTab = new forms.BillingPage(base.getdriver());
		billingTab.selectMainCustomer();
	}

	@When("User clicks the add charge button")
	public void user_clicks_the_add_charge_button() {
		billingTab = new forms.BillingPage(base.getdriver());
		billingTab.clickAddChargeButton();
	}

	@When("User selects random charge type from charge dropdown")
	public void user_selects_random_charge_type_from_charge_dropdown() {
		billingTab = new forms.BillingPage(base.getdriver());
		billingTab.selectRandomChargetype_DD();
	}

	@When("User enter the amount")
	public void user_enter_the_amount() {
		billingTab = new forms.BillingPage(base.getdriver());
		billingTab.enterBillingPrice();
	}

	@Then("User gets billing success message {string}")
	public void user_gets_billing_success_message(String string) {
		billingTab = new forms.BillingPage(base.getdriver());
		billingTab.verifyUpdateBillingSuccessMsg(string);
	}

	@Then("User removes the added bill")
	public void user_removes_the_added_bill() {
		billingTab = new forms.BillingPage(base.getdriver());
		billingTab.removeAddedBilling();
		//dispatcher.closeAUT();
	}

	@When("User selects sub customer")
	public void user_selects_sub_customer() {
		billingTab = new forms.BillingPage(base.getdriver());
		billingTab.selectSubCustomer();
	}

	@When("User clicks add sub bill")
	public void user_clicks_add_sub_bill() {
		billingTab = new forms.BillingPage(base.getdriver());
		billingTab.clickAddSubBill();
	}

	@When("User selects sub customer from dropdown")
	public void user_selects_sub_customer_from_dropdown() {
		billingTab = new forms.BillingPage(base.getdriver());
		billingTab.selectandomSubCustomer_DD();
	}

	@Then("User gets billing success message for sub customer {string}")
	public void user_gets_billing_success_message_for_sub_customer(String string) {
		billingTab = new forms.BillingPage(base.getdriver());
		billingTab.verifySuccssMessage_subCustomer(string);
	}

	@Then("User is presented with successful pricing deletion message {string}")
	public void user_is_presented_with_successful_pricing_deletion_message(String string) {
		billingTab = new forms.BillingPage(base.getdriver());
		billingTab.verifyDeleteBillingSuccessMsg(string);
	}

	@When("User navigates to payment tab")
	public void user_navigates_to_payment_tab() {
		paymentTab = new forms.PaymentPage(base.getdriver());
		paymentTab.navigateToPaymentTab();
	}

	@When("User clicks add payment button")
	public void user_clicks_add_payment_button() {
		paymentTab = new forms.PaymentPage(base.getdriver());
		paymentTab.clickAddPaymentBtn();
	}

	@When("User enters amount")
	public void user_enters_amount() {
		paymentTab = new forms.PaymentPage(base.getdriver());
		paymentTab.enterAmount_PaymentPopup();
	}

	@When("User selects payment date")
	public void user_selects_payment_date() {

		paymentTab = new forms.PaymentPage(base.getdriver());
		paymentTab.selectDate_payment();
	}

	@When("User clicks save payment")
	public void user_clicks_save_payment() {
		paymentTab = new forms.PaymentPage(base.getdriver());
		paymentTab.savePaymentDetails();
	}

	@Then("Payment added successfully")
	public void payment_added_successfully() {
		paymentTab = new forms.PaymentPage(base.getdriver());
		paymentTab.verifySuccessMsg_AddPayment();
		dispatcher.closeAUT();
	}

	@When("User finds that Approve and Approve and Invoice checkbox are enabled")
	public void user_finds_that_approve_and_approve_and_invoice_checkbox_are_enabled() {
		billingTab = new forms.BillingPage(base.getdriver());
		billingTab.enableCheckboxes();
	}

	@When("Unapproved Rebill checkbox are disabled")
	public void unapproved_rebill_checkbox_are_disabled() {
		billingTab = new forms.BillingPage(base.getdriver());
		billingTab.disabledCheckboxes();
	}

	@When("User select checkbox {string}")
	public void user_select_checkbox(String string) {
		billingTab = new forms.BillingPage(base.getdriver());
		billingTab.selectCheckBox(string);
	}

	@When("User select checkbox {string} and close email popup")
	public void user_select_checkbox_and_close_email_popup(String string) {
		billingTab = new forms.BillingPage(base.getdriver());
		billingTab.selectCheckBox(string);
		billingTab.closeMailPopUp();
	}

	@When("User fetches the total amount from billing tab")
	public void user_fetches_the_total_ampount_from_billing_tab() {
		dispatcher = new forms.Dispatcher(base.getdriver());
		totalBill = dispatcher.getTotalAmount();
	}
	
	@Then("User gets the update total amount from getLoadDetail api and verify with billing tab")
	public void user_gets_the_update_total_amount_from_get_load_detail_api_and_verify_with_billing_tab() {
		billingTab = new forms.BillingPage(base.getdriver());
		billingTab.validateTotalAmountWithAPIresponse(totalBill);
	}
	
	@When("User clicks document upload button")
	public void user_clicks_document_upload_button() {
		dispatcher = new forms.Dispatcher(base.getdriver());
		dispatcher.clickUploadDoc();
	}

	@When("User uploads a file from machine")
	public void user_uploads_a_file_from_machine() {
		dispatcher = new forms.Dispatcher(base.getdriver());
		dispatcher.uploadFile();
	}

	@When("User selects the file type")
	public void user_selects_the_file_type() {
		dispatcher = new forms.Dispatcher(base.getdriver());
		dispatcher.selectDocumentType_DD();
	}
	
	@When("User save the document")
	public void user_save_the_document() {
		dispatcher = new forms.Dispatcher(base.getdriver());
		dispatcher.saveDocuments();
		dispatcher.closeAUT();
	}
	
	@When("User navigates to Add Payments tab")
	public void user_navigates_to_add_payments_tab() {
	    accPage = new forms.AccountReceivablePage(base.getdriver());
	    accPage.navigateToAddPaymentsPage();
	}

	@When("User selects a customer from the dropdown as {string}")
	public void user_selects_a_customer_from_the_dropdown_as(String string) {
		accPage = new forms.AccountReceivablePage(base.getdriver());
		accPage.selectCustomer(string);
	}

	@When("User selects a random load available for the customer")
	public void user_selects_a_random_load_available_for_the_customer() {
		accPage = new forms.AccountReceivablePage(base.getdriver());
		accPage.selectRandomLoad();
	}

	@When("User add the payment")
	public void user_add_the_payment() {
		accPage = new forms.AccountReceivablePage(base.getdriver());
		accPage.addPayment();
	}

	@Then("application displays a successful payment message {string}")
	public void application_displays_a_successful_payment_message(String string) {
		accPage = new forms.AccountReceivablePage(base.getdriver());
		accPage.verifySuccessMsg(string);
		dispatcher.closeAUT();
	}
}
