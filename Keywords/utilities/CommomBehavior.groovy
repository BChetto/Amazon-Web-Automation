package utilities

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import entities.AmazonEntities.LoginObjects as Login

import internal.GlobalVariable

public class CommomBehavior {
	private static CommomBehavior singleton = null;

	private Utilities(){}
	/**
	 *
	 *Singleton Implementation
	 *
	 *
	 * **/
	public static CommomBehavior getUnicInstance(){

		if(singleton == null){
			singleton = new CommomBehavior();
		}

		return singleton;
	}

	public void completeEmailOrNumber(String data){

		WebUI.setText(Login.emailInput.obj, data)

		WebUI.click(Login.emailContinueBtn.obj)
	}

	public void goToLogin(){

		WebUI.openBrowser('')

		WebUI.navigateToUrl(Login.amazonUrl.txt)

		WebUI.maximizeWindow()

		WebUI.click(Login.mainMenu.obj)

		WebUI.click(Login.singIngLink.obj)
	}

	public void goToLoginAndroid(){

		if (Mobile.verifyElementExist(findTestObject('Object Repository/Mobile Objects/Login/android.widget.Button - Language English'),
		GlobalVariable.TimeOut, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('Object Repository/Mobile Objects/Login/android.widget.Button - Language English'), GlobalVariable.TimeOut)

			Mobile.tap(findTestObject('Object Repository/Mobile Objects/Login/android.widget.RadioButton - English'), GlobalVariable.TimeOut)

			Mobile.tap(findTestObject('Object Repository/Mobile Objects/Login/android.widget.Button - Done'), GlobalVariable.TimeOut)

			Mobile.tap(findTestObject('Object Repository/Mobile Objects/Login/android.widget.RelativeLayout (1)'), GlobalVariable.TimeOut)
		}else if(Mobile.verifyElementExist(findTestObject('Object Repository/Mobile Objects/Login/android.widget.ImageView'), 5,FailureHandling.OPTIONAL)){
			Mobile.tap(findTestObject('Object Repository/Mobile Objects/Login/android.widget.ImageView'), GlobalVariable.TimeOut)

			Mobile.tap(findTestObject('Object Repository/Mobile Objects/Login/android.widget.LinearLayout'), GlobalVariable.TimeOut)
		}else if(Mobile.verifyElementExist(findTestObject('Object Repository/Mobile Objects/Login/android.widget.Button - Already a customer Sign in'), GlobalVariable.TimeOut,FailureHandling.OPTIONAL)){

			Mobile.tap(findTestObject('Object Repository/Mobile Objects/Login/android.widget.Button - Already a customer Sign in'),
					GlobalVariable.TimeOut)
		}else if(Mobile.verifyElementExist(findTestObject('Object Repository/Mobile Objects/Login/passwordEditText'), GlobalVariable.TimeOut,FailureHandling.OPTIONAL)){
			Mobile.pressBack()
		}
	}
	
	public void completeEmailOrNumberAndroid(String data){
		if(Mobile.verifyElementExist(findTestObject('Mobile Objects/Login/EmailOrNumberEditText'), GlobalVariable.TimeOut)){
			Mobile.setText(findTestObject('Mobile Objects/Login/EmailOrNumberEditText'), data,GlobalVariable.TimeOut)
			
			Mobile.tap(findTestObject('Object Repository/Mobile Objects/Login/android.widget.Button - Continue'), GlobalVariable.TimeOut)
		}else{
			Mobile.tap(findTestObject('Mobile Objects/Login/Sign in Check'), GlobalVariable.TimeOut)
		}

	}
}
