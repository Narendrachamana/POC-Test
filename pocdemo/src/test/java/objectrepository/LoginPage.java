package objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import accelerators.Actiondriver;
import accelerators.Base;

public class LoginPage extends Base {

	public LoginPage() {
		PageFactory.initElements(driver, this);
		}
	
	private static final String logInButton = "//li[@data-cy='account']";
	private static final String userName = "//input[@id='username']";
	private static final String continuebtn = "//button[@data-cy='continueBtn']";
	private static final String logInViaPassword = "//a[text()='or Login via OTP']";
	private static final String password ="//input[@id='password']";
	private static final String logIn ="//button[@data-cy='login']";
	
	@FindBy(how=How.XPATH,using=logInButton)
	private WebElement loginbtn;
	
	@FindBy(how=How.XPATH,using=userName)
	private WebElement usernametxt;
	
	@FindBy(how=How.XPATH,using=continuebtn)
	private WebElement continuebtns;
	
	@FindBy(how=How.XPATH,using=logInViaPassword)
	private WebElement loginviapasswd;
	
	@FindBy(how=How.XPATH,using=password)
	private WebElement paswrd;
	
	@FindBy(how=How.XPATH,using=logIn)
	private WebElement loginn;
	
	public void clickonloginbtn() throws Throwable {
		Thread.sleep(3000);
		Actiondriver.gf_JsClick(loginbtn);
		Thread.sleep(3000);
	}
	
	public void dologin(String username1,String pswd) throws Throwable {
		Actiondriver.enterText(usernametxt, username1);
		Thread.sleep(6000);
		//Actiondriver.clickElement(continuebtns);
		//Thread.sleep(3000);
		//Actiondriver.gf_JsClick(loginviapasswd);
		Actiondriver.enterText(paswrd, pswd);
	}
	
	public void clickonlogin() throws Throwable {
		Actiondriver.gf_JsClick(loginn);
	}
	
	
	
}
