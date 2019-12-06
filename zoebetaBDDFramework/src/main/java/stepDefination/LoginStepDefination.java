package stepDefination;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
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

//scenario 1
	@Before
	public void openBrowser()
	{
		
	}
	@After
	public void closeBrowser(Scenario scenario) throws IOException
	{
		BrowserGenericfile.tearDown(scenario);
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
	
	Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(prop.getProperty("excel_path"), prop.getProperty("sheet_name"), "'TestCase_001'");
	
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



//****************** scenario 2 *********

@Then("^title of login page should be verfiedy$")
public void title_of_login_page_should_be_verfiedy() throws Throwable {
	String hometitle = driver.getTitle();
	Assert.assertEquals(prop.get("home_page_title"), hometitle);
	System.out.println("verified home page title");
}

@Then("^user enter invalid username and password$")
public void user_enter_invalid_username_and_password() throws Throwable {
   driver.findElement(By.xpath(prop.getProperty("sign_up"))).click();
   	 WebDriverWait waits = new WebDriverWait(driver,10);
//   waits.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getProperty("sing_up_popup_xpath"))));
//   System.out.println("visibale login popup");
   Map<String, String> TestDataInMap2 = ExcelHandler.getTestDataInMap(prop.getProperty("excel_path"), prop.getProperty("sheet_name"), "'TestCase_002'");
   driver.findElement(By.xpath(prop.getProperty("username_xpath"))).sendKeys(TestDataInMap2.get("Data_1"));
   driver.findElement(By.xpath(prop.getProperty("password_xpath"))).sendKeys(TestDataInMap2.get("Data_2"));
   driver.findElement(By.xpath(prop.getProperty("login_button_xpath"))).click();
   //	waits.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getProperty("invalid_usernam&pass_xpath"))));
   WebElement ele=driver.findElement(By.xpath(prop.getProperty("invalid_usernam&pass_xpath")));
   String error_message = ele.getText();
   if(error_message.equals(prop.getProperty("error_message")))
   {
   System.out.println("error_message as veryfied");
   }else {
	   System.out.println("invalid error_message as displayed");
   }
}

@Then("^user clcik on login button$")
public void user_clcik_on_login_button() throws Throwable {
   
}

@Then("^the error message should display$")
public void the_error_message_should_display() throws Throwable 
{
    
}
	
}
