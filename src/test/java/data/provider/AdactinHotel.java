package data.provider;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baseclass.libglobal.LibGlobal;

public class AdactinHotel extends LibGlobal{
	
	LibGlobal global =  new LibGlobal();
	AcdatinParameter para =  new AcdatinParameter();
	
	@Parameters({"url"})
	@BeforeClass
	private void launchUrl() {
		getDriver();
	}
	
	@Parameters({"username","password"})
	@Test
	private void signIn(String string,String string2) {
		global.sendkeysAlert(string);
		global.sendkeysAlert(string2);
		global.click(para.getSignIn());

	}
	
	

}
