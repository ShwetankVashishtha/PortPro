package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.core.backend.CucumberBackendException;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@CucumberOptions(features = { "src/test/resources/Features/" }, glue = { "steps" }, plugin = { "pretty" })
@RunWith(Cucumber.class)
public class PortProRunner {

}
