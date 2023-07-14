import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

'Define variable'
def URL = 'https://opensource-demo.orangehrmlive.com'
def loginURL = URL + '/web/index.php/auth/login'
def forgotpasswordURL = URL + '/web/index.php/auth/requestPasswordResetCode'

'Open browse then open URLs: https://opensource-demo.orangehrmlive.com'
WebUI.openBrowser(URL)
WebUI.maximizeWindow()

'Click Forgot your password'
WebUI.click(findTestObject('Login_Page/lnk_forgotpassword'))

'Should refirect to reset password page: URL: /auth/requestPasswordResetCode'
assert WebUI.getUrl() == forgotpasswordURL

'VP: Verify button Cancel should enable'
WebUI.verifyElementClickable(findTestObject('ResetPassword_Page/btn_cancel'))

'VP: Verify button Reset Password should enable'
WebUI.verifyElementClickable(findTestObject('ResetPassword_Page/btn_ResetPassword'))

'Click Button Cancel'
WebUI.click(findTestObject('ResetPassword_Page/btn_cancel'))

'Should display login page'
assert WebUI.getUrl() == loginURL

'Post-Condtion: Close Browser'
WebUI.closeBrowser()
