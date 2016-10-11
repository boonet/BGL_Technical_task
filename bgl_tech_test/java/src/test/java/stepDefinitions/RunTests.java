package stepDefinitions;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features", tags = "@ctm", format = { "pretty",
        "html:target/site/cucumber-pretty"})
public class RunTests {
}