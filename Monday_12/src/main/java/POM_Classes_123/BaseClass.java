package POM_Classes_123;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;




public class BaseClass {
public static WebDriver driver;
public static void openBrowser() throws IOException, InterruptedException {
	System.setProperty("webdriver.chrome.driver","C:\\automation\\Monday_12\\src\\test\\resources\\Browsers\\Browsers1\\chromedriver.exe");
   ChromeOptions option=new ChromeOptions();
   option.addArguments("--disable-notifications");
   driver=new ChromeDriver(option);
   
   driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
   driver.get(UtilityClass.getPropertyFile("url"));
   Thread.sleep(2000);
}
}
