package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import wrappers.TestBase;

public class DriverProfile {

	TestBase base = new TestBase();
	forms.Dispatcher dispatcher;
	forms.LoadInfoPage loadInfo;
	forms.BillingPage billingTab;
	forms.PaymentPage paymentTab;
	forms.DriversPage driverPage;
	forms.CustomerPage customerPage;

	@When("User redirects to Driver profile section")
	public void user_redirects_to_driver_profile_section() {
		driverPage = new forms.DriversPage(base.getdriver());
		driverPage.navigateToDriversProfilePage();
	}

	@When("User enters FirstName, LastName, Email, Phone, Password")
	public void user_enters_first_name_last_name_email_phone_password() {
		driverPage = new forms.DriversPage(base.getdriver());
		driverPage.enterGeneralDetails();
	}

	@When("User selecs a Username and Timezone from dropdown")
	public void user_selecs_a_username_and_timezone_from_dropdown() {
		driverPage = new forms.DriversPage(base.getdriver());
		driverPage.selectUserName_DD();
		driverPage.selectTimeZone_DD();
	}

	@When("User selects License state")
	public void user_selects_license_state() {
		driverPage = new forms.DriversPage(base.getdriver());
		driverPage.selectLicenseState_DD();
	}

	@When("User provides License number")
	public void user_provides_license_number() {
		driverPage = new forms.DriversPage(base.getdriver());
		driverPage.inputLicenseNumber();
		driverPage.provideExpirtionDate();
	}

	@Then("User gets message on driver creation {string}")
	public void user_gets_message_on_driver_creation(String string) {
		driverPage = new forms.DriversPage(base.getdriver());
		driverPage.driverCreationMsg(string);
	}
}
