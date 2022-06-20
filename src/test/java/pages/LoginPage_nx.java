package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage_nx extends PageObject {

	public LoginPage_nx(WebDriver driver) {
		super(driver);
	}
	 @FindBy(xpath = "//main[@id='content']/article/h1")
	    private WebElement pageHeader;
	 
	 @FindBy(xpath = "//div[@class='frc-content']/span")
	    private WebElement verificationText;
	 
	 @FindBy(name = "username")
	    private WebElement mailInput;
	 
	 @FindBy(name = "password")
	    private WebElement passwordInput;
	 
	 @FindBy(name = "loginForm-submit-button")
	    private WebElement loginButton;
	 
	 @FindBy(xpath = "//div[@class='l-flex__primary u-no-margin u-padding--ends m-Notification__message']")
	    private WebElement errorMessage;
	 
	 
	 public boolean checkPageHeader(String header) {
	        return this.pageHeader.getText().equals(header);
	    }
	 public ProfilePage login() {
		 WebDriverWait wait = new WebDriverWait(driver,30);
		 wait.until(ExpectedConditions.textToBePresentInElement(verificationText, null));
         loginButton.click();
         return new ProfilePage(driver);
	  }
	 
	 public String loginFail(String email, String password) {
		 WebDriverWait wait = new WebDriverWait(driver,30);
		 wait.until(ExpectedConditions.textToBePresentInElement(verificationText, null));
		 mailInput.sendKeys(email);
         passwordInput.sendKeys(password);
         loginButton.click();
        return errorMessage.getText();
	  }

}
