package stepDefination;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import propertyFile.BrowserGenericfile;
import propertyFile.ExcelHandler;
import propertyFile.TestDataHandler;


public class LoginStepDefination extends BrowserGenericfile
{

	TestDataHandler testdata=new TestDataHandler();
	public	static Properties	prop;
	
	public LoginStepDefination() throws IOException, InterruptedException {
	
	prop =new Properties();
	FileInputStream ip = new FileInputStream("D:/anil/Anil QA-TAE/test_data/mygit/zoebetaBDDFramework/src/main/java/propertyFile/ElementsData.properties");
	prop.load(ip);
	}


	
@Given("^User is already on login pagee*")
public void user_already_on_loing_page() throws InterruptedException 
{
	BrowserGenericfile.initialization();
	System.out.println("Browser Name - "+prop.getProperty("browser"));
	Thread.sleep(3000);
	
		
}

@When("^title of login page is zoemenu$")
public void title_of_login_page_is_zoemenu() throws InterruptedException  {
	String title =driver.getTitle();
 Assert.assertEquals(prop.getProperty("home_page_title"), title);
System.out.println("Loing page Title - " +title);
}

@Then("^user enter username and password$")
public void user_enter_username_and_password() throws Exception {
	
	Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap("D:/anil/Anil QA-TAE/test_data/mygit/zoebetaBDDFramework/resources-testdata/MyTestdata.xlsx", "LOGIN", "'TestCase_001'");
	
	testdata.setTestDataInMap(TestDataInMap);//getter and setter
	
	driver.findElement(By.xpath(prop.getProperty("sign_up"))).click();
	Thread.sleep(4000);
    driver.findElement(By.xpath(prop.getProperty("username_xpath"))).sendKeys(TestDataInMap.get("Data_1"));
    driver.findElement(By.xpath(prop.getProperty("password_xpath"))).sendKeys(TestDataInMap.get("Data_2"));
    
}

@And("^user clicks on login buttion$")
public void user_click_login_button() {
	driver.findElement(By.xpath(prop.getProperty("login_button_xpath"))).click();
	
	Map<String,String> statictestdata = testdata.getTestDataInMap(); //getter and sertter
	System.out.println(statictestdata.get("Data_3"));
	
}

@And("^user is on home page$")
public void user_in_homepage() {
	
	String title =driver.getTitle();
	 Assert.assertEquals(prop.getProperty("home_page_title"), title);
	 System.out.println("Home page Title - " +title);
}



@Then("^title of login page should be verfiedy$")
public void title_of_login_page_should_be_verfiedy() throws Throwable {
  
}

@Then("^user enter invalid username and password$")
public void user_enter_invalid_username_and_password() throws Throwable {
   
}

@Then("^user clcik on login button$")
public void user_clcik_on_login_button() throws Throwable {
   
}

@Then("^the error message should display$")
public void the_error_message_should_display() throws Throwable 
{
    
}
	
}
