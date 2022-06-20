package tests;

import java.util.Map;

import org.junit.Assert;
import org.testng.annotations.Test;

import pages.LoginPage_nl;
import pages.LoginPage_nx;
import pages.ProfilePage;
import utils.BrowserTypeEnum;
import utils.Common;
import utils.Driver;

public class LoginTest extends Driver {

	public LoginTest() {
		super(BrowserTypeEnum.chrome);
	}
	LoginPage_nl login_nl;
	LoginPage_nx login_nx;
	ProfilePage profile;
	Common common = new Common();
	

	    
	@Test(priority=0)
	    public void loginSucces() {
	   	 Map<String, String> userProperty = common.readUserProperties("test1");
		    String userName = userProperty.get("userName");
		    String password = userProperty.get("password");
		    String accountNameSurname = userProperty.get("accountNameSurname");
		    
	    	login_nl = new LoginPage_nl(driver);
	    	 Assert.assertTrue(login_nl.checkPageHeader("Anmelden"));
	    	 login_nx=login_nl.login(userName, password);
	    	 Assert.assertTrue(login_nx.checkPageHeader("Anmelden"));
	    	 profile= login_nx.login();
	    	Assert.assertTrue(profile.getUserName().contains(accountNameSurname));
	    	 
	    }
	    
	@Test(priority=1)
	    public void loginFail() {
	      	 Map<String, String> userProperty = common.readUserProperties("test2");
			    String userName = userProperty.get("userName");
			    String password = userProperty.get("password");
	    	login_nl = new LoginPage_nl(driver);
	    	 Assert.assertTrue(login_nl.checkPageHeader("Anmelden"));
	    	 login_nx=login_nl.login(userName, password);
	    	Assert.assertEquals("E-Mail-Adresse und/oder Passwort sind falsch. Bitte überprüfen Sie Ihre Eingaben.",login_nx.loginFail(userName, password) );
	    
	    }

}
