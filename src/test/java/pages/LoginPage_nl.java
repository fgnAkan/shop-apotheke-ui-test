package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage_nl extends PageObject {

	public LoginPage_nl(WebDriver driver) {
		super(driver);
	}
	 @FindBy(xpath = "//div[@data-qa-id='login']/h1")
	    private WebElement pageHeader;
	 
	 @FindBy(id = "login-email")
	    private WebElement mailInput;
	 
	 @FindBy(id = "login-password")
	    private WebElement passwordInput;
	 
	 @FindBy(id = "btn-login")
	    private WebElement loginButton;
	 
	 public boolean checkPageHeader(String header) {
	        return this.pageHeader.getText().equals(header);
	    }
	 
	  public LoginPage_nx login(String email, String password) {
          mailInput.sendKeys(email);
          passwordInput.sendKeys(password);
          loginButton.click();
          return new LoginPage_nx(driver);
	  }
	 
}
