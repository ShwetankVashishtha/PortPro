package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import wrappers.TestBase;

public class Dispatcher {

    TestBase base = new TestBase();
    forms.Dispatcher dispatcher;

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

    @Then("User should be logged in")
    public void verifyDashboardLogo() {
        dispatcher = new forms.Dispatcher(base.getdriver());
        dispatcher.verifyDashboardLogo();
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
    }

    @Then("User should be able to add notes successfully")
    public void validateNoteCreateSuccessMessage() {
        dispatcher = new forms.Dispatcher(base.getdriver());
        dispatcher.validateNoteCreateSuccessMessage();
    }

    @And("User adds notes {string}")
    public void userAddsNotes(String arg0) {
        dispatcher = new forms.Dispatcher(base.getdriver());
        dispatcher.addNewNotes(arg0);
    }

    @And("User navigates to Billing")
    public void redirectToBilling() {
        dispatcher = new forms.Dispatcher(base.getdriver());
        dispatcher.redirectToBilling();
    }

    @Then("User should be able to view correct Summary")
    public void userShouldBeAbleToViewCorrectSummary() {
    }
}
