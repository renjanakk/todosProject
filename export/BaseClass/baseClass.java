package BaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.utility;




public class baseClass {
	public static WebDriver driver;
	public static Properties prop;
	public String expectedStr="";
	public Actions point;
	public utility Util;
	public static String parentWindow;
	public static WebDriverWait wait;
	
	public baseClass(){
		try {
			prop=new Properties();
			FileInputStream ip;
			ip=new FileInputStream("D:\\SoftwareTestingCourse\\AutomationTesting\\workspace\\todosProject"
					+ "\\src\\test\\java\\Config\\config.properties");
			prop.load(ip);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	public static void initialization() {
		String browserName=prop.getProperty("browser");
		
		if(browserName.contains("FF")){
			System.setProperty("webdriver.gecko.driver", "D:\\JavaAutomation\\geckodriver-v0.33.0-win64\\geckodriver.exe");
			driver=new FirefoxDriver();
		}/*else if (browserName=="chrome") {
			System.setProperty("webdriver.chrome.driver", "D:\\JavaAutomation\\drivers\\chrome\\chrome-win64\\chrome.exe");
			driver=new ChromeDriver();

		}*/
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(utility.IMPLICIT_WAIT));
		
		driver.get(prop.getProperty("baseUrl"));
		parentWindow=driver.getWindowHandle();
		
	}
	
}
