import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import utilities.CommomBehavior
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.testdata.TestData as TestData
import entities.AmazonEntities.LoginObjects as Login


TestData testData = findTestData('Login Test Data')

CommomBehavior.getUnicInstance().goToLogin()

CommomBehavior.getUnicInstance().completeEmailOrNumber(testData.getValue(1, 3))

WebUI.waitForElementPresent(Login.errorMessage.obj, 5)

WebUI.closeBrowser()