package Runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features ="D:\\anil\\Anil QA-TE_A\\test_data\\eclips\\java devlop\\zoebetaBDDFramework\\src\\main\\java\\features"
		,glue= {"stepDefination"}
		
		)

public class TestRunner {

}
