package utilities

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject

import internal.GlobalVariable

public class Utilities {

	private static Utilities singleton = null;

	private Utilities(){}
	/**
	 * 
	 *Singleton Implementation 
	 * 
	 * 
	 * **/
	public static Utilities getUnicInstance(){

		if(singleton == null){
			singleton = new Utilities();
		}

		return singleton;
	}


	/**
	 * Author: Brahian Franceschetto
	 * Date:9/10/2020
	 * Description: Method that create a TestObject Based on a Xpath
	 * return: TestObject
	 * 
	 * **/
	def TestObject createObjectByXpath(String xpath){
		TestObject result = null
		if(!xpath.equals("") || xpath != null){
			TestObject temp = new TestObject(xpath)
			temp.addProperty("xpath",ConditionType.EQUALS,xpath)
			if(temp != null){
				result = temp
			}

			return result
		}else{
			return null;
		}
	}
	
}
