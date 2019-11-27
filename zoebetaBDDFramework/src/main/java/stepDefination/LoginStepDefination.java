package stepDefination;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import propertyFile.BrowserGenericfile;


public class LoginStepDefination 
{

	WebDriver driverr;
	static Properties	prop;

	public LoginStepDefination() throws IOException {
		prop =new Properties();
		FileInputStream ip = new FileInputStream("D:/anil/Anil QA-TAE/test_data/mygit/zoebetaBDDFramework/src/main/java/propertyFile/ElementsData.properties");
		prop.load(ip);
	}
	
//	public static void main(String arg[]) throws IOException, InterruptedException
//	{
//		prop =new Properties();
//	FileInputStream ip = new FileInputStream("D:/anil/Anil QA-TAE/test_data/mygit/zoebetaBDDFramework/src/main/java/propertyFile/ElementsData.properties");
//	prop.load(ip);
//	System.out.println("i am done" + prop);
//	}
	
	
//	@Before	
//	public void openBrowser() throws IOException, InterruptedException 
//	{
//	BrowserGenericfile browser=new BrowserGenericfile();
//	}
//	
//	@After
//	public void closeBrowser()
//	{
//		driver.quit();
//	}
	
	
	
	
	
@Given("^User is already on login pagee*")
public void user_already_on_loing_page() throws InterruptedException, IOException 
{
	BrowserGenericfile browser=new BrowserGenericfile();
	System.out.println(prop.getProperty("browser"));
	System.out.println(prop.getProperty("sign_up"));
	Thread.sleep(5000);
	
	driverr.findElement(By.xpath("//strong[.=\"SHOP \"]")).click();
	
	
	//driver.get("https://zoe.menu/beta");
	Thread.sleep(5000);
}

@When("^title of login page is zoemenu$")
public void title_of_login_page_is_zoemenu() throws InterruptedException  {
	
 
}

@Then("^user enter username and password$")
public void user_enter_username_and_password() throws InterruptedException {
	System.out.println(prop.getProperty("browser")+" / it's me manual");
	System.out.println(prop.getProperty("sign_up"));
	
    driverr.findElement(By.xpath(prop.getProperty("sign_up"))).click();
    Thread.sleep(3000);
    driverr.findElement(By.xpath("//input[@name='in_email']")).sendKeys("prathap@steedserv.com");
    driverr.findElement(By.xpath("//input[@name='in_password']")).sendKeys("12345678");
    driverr.findElement(By.xpath("//button[.='Submit']")).click();
}

@And("^user clicks on login buttion$")
public void user_click_login_button() {
	
}

@And("^user is on home page$")
public void user_in_homepage() {
	
}
		
}
