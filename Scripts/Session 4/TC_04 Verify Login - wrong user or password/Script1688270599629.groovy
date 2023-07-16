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
def UserName = 'Admin'
def WrongUserName = UserName + "1"
def Password = 'admin123'
def WrongPassword = Password + "4"
def isEmptyField	= ''

'1. Open browse then open URLs: https://opensource-demo.orangehrmlive.com'
WebUI.openBrowser(URL)
WebUI.maximizeWindow()

'VP: Should display Login page'
assert WebUI.getUrl() == loginURL
WebUI.verifyElementVisible(findTestObject('Login_Page/lbl_login'))
WebUI.verifyElementVisible(findTestObject('Login_Page/txt_username'))
WebUI.verifyElementVisible(findTestObject('Login_Page/txt_password'))

'2. Input valid username and wrong password'
WebUI.setText(findTestObject('Login_Page/txt_username'), UserName)
WebUI.setText(findTestObject('Login_Page/txt_password'), WrongPassword)

'VP: Should input successful'
WebUI.verifyElementAttributeValue(findTestObject('Login_Page/txt_username'), 'value',UserName,1)
WebUI.verifyElementAttributeValue(findTestObject('Login_Page/txt_password'), 'value',WrongPassword,1)

'3. Click Button Login'
WebUI.click(findTestObject('Login_Page/btn_login'))

'VP: Should display modal Invalid:'
'- "Invalid credentials" text with alert icon'
'- Username/password inputted before should clear'
WebUI.verifyElementVisible(findTestObject('Login_Page/msg_Invalidcredentials'))
WebUI.verifyElementAttributeValue(findTestObject('Login_Page/txt_username'), 'value',isEmptyField,1)
WebUI.verifyElementAttributeValue(findTestObject('Login_Page/txt_password'), 'value',isEmptyField,1)

'4. Input wrong username and valid password'
WebUI.focus(findTestObject('Login_Page/txt_username'))
WebUI.setText(findTestObject('Login_Page/txt_username'), WrongUserName)
WebUI.setText(findTestObject('Login_Page/txt_password'), Password)

'5. Click Button Login'
WebUI.click(findTestObject('Login_Page/btn_login'))

'VP: Should display modal Invalid:'
'- "Invalid credentials" text with alert icon'
'- Username/password inputted before should clear'
WebUI.verifyElementVisible(findTestObject('Login_Page/msg_Invalidcredentials'))
WebUI.verifyElementAttributeValue(findTestObject('Login_Page/txt_username'), 'value',isEmptyField,1)
WebUI.verifyElementAttributeValue(findTestObject('Login_Page/txt_password'), 'value',isEmptyField,1)

'Post-Condtion: Close Browser'
WebUI.closeBrowser()
