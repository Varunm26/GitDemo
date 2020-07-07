package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {

	//driver Object -has to have global scope inside project
	public WebDriver driver;
	/*browser has to common for all the test cases present -
	I create data.properties file and send that to this base class.
	Base class is common class for all the classes and test cases.*/
	//https://www.selenium.dev/downloads/---- download browsers
	
	// Commom Url for all the class without hardcoding
	public Properties prop;
	public WebDriver initializeDriver() throws IOException {
		
		 prop=new Properties();
		// System.getProperty("user.dir")---give current path of project
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fis);
		/*Run In Chrome Driver --
		 * mvn test -Dbrowser=chrome
		mvn test -Dbrowser=firefox*/
		// Maven Consider all the properties in SystemProperty.
		//code will check from Maven command
		//String browserName = System.getProperty("browser");
		
		//code will check from .properties files
		
		String browserName = prop.getProperty("browser"); 
		System.out.println(browserName);
		if(browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\Eclispe\\chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			if(browserName.contains("headless")) {
				options.addArguments("headless");
			}
			driver=new ChromeDriver(options);
			
		}else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "E:\\Eclispe\\Browser\\geckodriver.exe");
			 driver=new FirefoxDriver();
			
		}else if(browserName.equals("IE")){
			System.setProperty("webdriver.ie.driver", "E:\\Eclispe\\Browser\\IEDriverServer.exe");
			 driver=new InternetExplorerDriver();
		}
		//driver.manage().window().maximize();
		// Load time of each and every step and browser loading
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public String getScreenshotpath(String TestcasesName,WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File Source =ts.getScreenshotAs(OutputType.FILE);
		String DestinationFile= System.getProperty("user.dir")+"\\reports\\"+TestcasesName+".png";
		FileUtils.copyFile(Source, new File(DestinationFile));
		return DestinationFile;
	}
	
}
