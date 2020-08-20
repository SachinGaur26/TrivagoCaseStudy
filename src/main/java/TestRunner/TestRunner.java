package TestRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "C:\\Users\\Admin\\Desktop\\Sachin\\TrivagoCaseStudy6\\src\\main\\java\\Feature\\AutomationScenarios.feature",
        glue = {"StepDefiniton"},
        plugin = {"pretty","html:target/screenshots"},
        //tags = {"@SmokeTest"},
        dryRun = false
       
	
		)
public class TestRunner {

}
