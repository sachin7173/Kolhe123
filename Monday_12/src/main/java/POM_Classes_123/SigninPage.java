package POM_Classes_123;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SigninPage {
@FindBy(xpath="//a[contains(text(),'Sign in')]")private WebElement signinbtn;
public SigninPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
}
public void Signinbtn12() {
	signinbtn.click();
}
}
