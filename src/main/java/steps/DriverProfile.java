package steps;

import forms.DriversPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import requests.getLoads;
import wrappers.TestBase;

public class DriverProfile {

	TestBase base = new TestBase();
	forms.Dispatcher dispatcher;
	forms.LoadInfoPage loadInfo;
	forms.BillingPage billingTab;
	forms.PaymentPage paymentTab;
	DriversPage driverPage;
	forms.CustomerPage customerPage;

	@When("User redirects to Driver profile section")
	public void user_redirects_to_driver_profile_section() {
		driverPage = new DriversPage(base.getdriver());
		driverPage.navigateToDriversProfilePage();
	}

	@When("User enters FirstName, LastName, Email, Phone, Password")
	public void user_enters_first_name_last_name_email_phone_password() {
		driverPage = new DriversPage(base.getdriver());
		driverPage.enterGeneralDetails();
	}

	@When("User selects a Username and Timezone from dropdown")
	public void user_selects_a_username_and_timezone_from_dropdown() {
		driverPage = new DriversPage(base.getdriver());
		driverPage.selectUserName_DD();
		driverPage.selectTimeZone_DD();
	}

	@When("User selects License state")
	public void user_selects_license_state() {
		driverPage = new DriversPage(base.getdriver());
		driverPage.selectLicenseState_DD();
	}

	@When("User provides License number")
	public void user_provides_license_number() {
		driverPage = new DriversPage(base.getdriver());
		driverPage.inputLicenseNumber();
		driverPage.provideExpirtionDate();
	}

	@Then("User gets message on driver creation {string}")
	public void user_gets_message_on_driver_creation(String string) {
		driverPage = new DriversPage(base.getdriver());
		//driverPage.driverCreationMsg(string);
		//getLoads.deleteDriver(DriversPage.email_id);
	}
}
