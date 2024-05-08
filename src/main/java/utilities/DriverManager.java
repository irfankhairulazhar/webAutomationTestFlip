package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class DriverManager
{
	
	public void setUp(String browserName)  
	{
		//Create an instance of FirefoxOptions
		FirefoxOptions options = new FirefoxOptions();
		//Create an instance of ChromeOptions
		ChromeOptions chromeOptions = new ChromeOptions();
		switch (browserName.toLowerCase()) 
		{
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
//				options.addArguments("-headless");
				options.setAcceptInsecureCerts(true);
				options.addPreference("dom.webnotifications.enabled", false);
				options.addPreference("dom.webnotifications.serviceworker.enabled", false);
				options.addPreference("dom.push.enabled", false);
				ThreadManager.setDriver(new FirefoxDriver(options));
				break;
	
			case "chrome":
				WebDriverManager.chromedriver().clearDriverCache().setup();
				WebDriverManager.chromedriver().clearResolutionCache().setup();
				//Create a map to store  preferences
				Map<String, Object> prefs = new HashMap<>();
				//add key and value to map as follow to switch off browser notification
				//Pass the argument 1 to allow and 2 to block
				prefs.put("profile.default_content_setting_values.notifications", 2);
				// set ExperimentalOption - prefs
				chromeOptions.setExperimentalOption("prefs", prefs);
				chromeOptions.addArguments("--remote-allow-origins=*");
				chromeOptions.addArguments("--incognito");
				chromeOptions.addArguments("disable-infobars");
				chromeOptions.addArguments("--disable-in-process-stack-traces");
				chromeOptions.addArguments("--log-level=3");
//				chromeOptions.addArguments("--headless");
				chromeOptions.addArguments("--start-maximized");
				chromeOptions.addArguments("window-size=1366,768");
				chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
				chromeOptions.setExperimentalOption("useAutomationExtension", false);
				chromeOptions.addArguments("--no-sandbox");
				chromeOptions.addArguments("--disable-dev-shm-usage");
				chromeOptions.addArguments("--disable-gpu");
				//Now Pass ChromeOptions instance to ChromeDriver Constructor to initialize chrome driver which will switch off this browser notification on the chrome browser
				ThreadManager.setDriver(new ChromeDriver(chromeOptions));
				break;


			default:
				throw new IllegalArgumentException("Please specify valid browser name. Valid browser names are: firefox, chrome,chrome-headless, ie ,edge");

		}

		ThreadManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		ThreadManager.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(1800));
		ThreadManager.getDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(60));
		ThreadManager.getDriver().manage().window().maximize();
	 }
	
	public void tearDown()
	{
		if(ThreadManager.getDriver()!=null)
		{
			ThreadManager.getDriver().quit();
		}
	}
}
