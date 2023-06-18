package Test_classes_223;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POM_Classes_123.BaseClass;
import POM_Classes_123.HomePage;
import POM_Classes_123.LoginPage;
import POM_Classes_123.LogoutPage;
import POM_Classes_123.SigninPage;
import POM_Classes_123.UtilityClass;

public class Test_Class_1  extends BaseClass{

	
	SigninPage signin;
	HomePage home;
	LoginPage login;
	LogoutPage logout;
	
	@BeforeClass
	public void openBrowser12() throws IOException, InterruptedException {
		openBrowser();
		signin =new SigninPage(driver);
		login=new LoginPage(driver);
		home=new HomePage(driver);
		logout=new LogoutPage(driver);
	}
	@BeforeMethod
	public void login12() throws IOException, InterruptedException {
		signin.Signinbtn12();
		login.username(UtilityClass.getPropertyFile("username"));
		login.password(UtilityClass.getPropertyFile("password"));
login.loginbtn();
Thread.sleep(2000);
home.accountbtn12();
	}
	@Test
	public void verifyusername() throws IOException {
		String expResult = UtilityClass.getPropertyFile("username1");
		String actResult = home.verifyusername();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(actResult, expResult,"act and exp result is different");
		soft.assertAll();
	}
	@AfterMethod
	public void logout12(ITestResult result) throws IOException, InterruptedException {
		if(result.getStatus()==ITestResult.FAILURE) {
			int TCID=2343;
			UtilityClass.CaptureScreenshot(driver, TCID);
			Thread.sleep(2000);
		}
		logout.logoutbtn();
	}
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}
