package Runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"D:/anil/Anil QA-TAE/test_data/mygit/zoebetaBDDFramework/src/main/java/features/login.feature"}
		,glue= {"stepDefination"}
	,monochrome= true
		)

public class TestRunner {

}
