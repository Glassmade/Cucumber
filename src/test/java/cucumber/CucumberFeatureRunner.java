package cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\Users\\dimko\\IdeaProjects\\Cucumber\\src\\test\\resources\\",
        tags = {"@BuySingleItem"},
        glue = {"stepDefinitions"}
)
public class CucumberFeatureRunner {}
