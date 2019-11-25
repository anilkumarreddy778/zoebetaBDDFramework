package stepDefination;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
public class LoginStepDefination {

	WebDriver driver;
@Given("^User is already on login page*")
public void user_already_on_loing_page() throws InterruptedException 
{
	System.setProperty("webdriver.chrome.driver","D:/anil/Anil QA-TAE/SOFTWARES/selenium_drivers/chromedriver.exe");
	Thread.sleep(3000);
	driver= new ChromeDriver();
	Thread.sleep(3000);
	driver.get("https://zoe.menu/beta/");
}

@When("^title of login page is zoemenu$")
public void title_of_login_page_is_zoemenu()  {
   String title = driver.getTitle();
   System.out.println(title);
   Assert.assertEquals("Choose Diet food for Weight Loss, Healthy Juices, Organic Honey – ZOE", title);
}

@Then("^user enter username and password$")
public void user_enter_username_and_password() throws InterruptedException {
    driver.findElement(By.xpath("//a[.=' SIGN IN / SIGN UP ']")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("//input[@name='in_email']")).sendKeys("prathap@steedserv.com");
    driver.findElement(By.xpath("//input[@name='in_password']")).sendKeys("12345678");
    driver.findElement(By.xpath("//button[.='Submit']")).click();
}

@And("^user clicks on login buttion$")
public void user_click_login_button() {
	
}

@And("^user is on home page$")
public void user_in_homepage() {
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
