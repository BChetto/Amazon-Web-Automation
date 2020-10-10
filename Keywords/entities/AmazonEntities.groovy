package entities

import com.kms.katalon.core.testobject.TestObject
import utilities.Utilities

import internal.GlobalVariable

public class AmazonEntities {

	public enum LoginObjects{

		amazonUrl('https://www.amazon.com/?currency=USD&language=en_US'),
		errorMessage('/*[contains(text(),"problem")]'),
		mainMenu('//*[@id="nav-hamburger-menu"]'),
		singIngLink('//*[contains(text(),"Sign In")]'),
		emailInput('//*[@id="ap_email"]'),
		emailContinueBtn('//*[@id="continue"]'),
		passwordInput('//*[@id="ap_password"]'),
		passwordContinueBtn('//*[@id="signInSubmit"]')




		public TestObject obj;
		public String txt;

		private LoginObjects(String xpath){
			this.obj = Utilities.getUnicInstance().createObjectByXpath(xpath);
			this.txt = xpath;
		}
	}
}
