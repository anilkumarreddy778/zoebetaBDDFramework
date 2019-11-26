package propertyFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BrowserGenericfile {

	public static WebDriver driver;
	static Properties prop =new Properties();
	public static void main(String[] args) throws InterruptedException, IOException {
			

	}
	
	public BrowserGenericfile() throws IOException, InterruptedException {
		FileInputStream ip = new FileInputStream("D:/anil/Anil QA-TAE/test_data/mygit/zoebetaBDDFramework/src/main/java/propertyFile/ElementsData.properties");
		prop.load(ip);
		
		String browsername = prop.getProperty("browser");
		
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","D:/anil/Anil QA-TAE/SOFTWARES/selenium_drivers/chromedriver.exe");
			Thread.sleep(3000);
			driver= new ChromeDriver();
			driver.get(prop.getProperty("url"));
			
		}else if(browsername.equals("FF"))	
		{
			System.setProperty("webdriver.gecko.driver","D:/anil/Anil QA-TAE/SOFTWARES/selenium_drivers/geckodriver.exe");
			Thread.sleep(3000);
			driver= new FirefoxDriver();
			driver.get(prop.getProperty("url"));
			//driver.manage().window().maximize();
		}
	}
}
