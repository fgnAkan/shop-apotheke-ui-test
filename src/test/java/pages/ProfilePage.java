package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends PageObject {

	public ProfilePage(WebDriver driver) {
		super(driver);
	}
	 @FindBy(xpath = "//h3[@class='a-h3 u-margin-xx-small--bottom']")
	    private WebElement userName;
	 
	 public String getUserName() {
	        return this.userName.getText();
	    }
}
