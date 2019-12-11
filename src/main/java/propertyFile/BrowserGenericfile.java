package propertyFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.Scenario;


public class BrowserGenericfile {

	public static WebDriver driver;
	public static Properties prop;
	
	
	public BrowserGenericfile()  {
		try {
		prop =new Properties();
		FileInputStream ip = new FileInputStream("D:/anil/Anil QA-TAE/test_data/mygit/zoebetaBDDFramework/src/main/java/propertyFile/ElementsData.properties");
		prop.load(ip);
		}catch (IOException e) {
			e.getMessage();			
		}
		
	}
	
	
	public static void initialization() throws InterruptedException {
		String browsername = prop.getProperty("browser");
		
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","D:/anil/Anil QA-TAE/SOFTWARES/selenium_drivers/chromedriver.exe");
			Thread.sleep(3000);
			driver= new ChromeDriver();
			
		}else if(browsername.equals("FF"))	
		{
			System.setProperty("webdriver.gecko.driver","D:/anil/Anil QA-TAE/SOFTWARES/selenium_drivers/geckodriver.exe");
			Thread.sleep(3000);
			driver= new FirefoxDriver();
		}
		driver.get(prop.getProperty("url"));
		//driver.manage().window().maximize();
	}
	
	public static void tearDown(Scenario scenario) throws IOException
	{
		if (scenario.isFailed()) {
			try {
				byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				File screenshot_with_scenario_name = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screenshot_with_scenario_name, 
						new File("./target/test-report/" + scenario.getName() + ".png"));
				System.out.println(scenario.getName());
				scenario.embed(screenshot, "image/png");				
 			}catch (WebDriverException e) {
 				System.out.println(e.getMessage()); 				
 			}
		}
		driver.close();
	}

}
