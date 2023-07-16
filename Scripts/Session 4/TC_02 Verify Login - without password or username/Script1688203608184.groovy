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
def Password = 'admin123'

'1. Open browse then open URLs: https://opensource-demo.orangehrmlive.com'
WebUI.openBrowser(URL)
WebUI.maximizeWindow()

'VP: Should display Login page'
assert WebUI.getUrl() == loginURL
WebUI.verifyElementVisible(findTestObject('Login_Page/lbl_login'))
WebUI.verifyElementVisible(findTestObject('Login_Page/txt_username'))
WebUI.verifyElementVisible(findTestObject('Login_Page/txt_password'))

'2. Input username'
WebUI.setText(findTestObject('Login_Page/txt_username'), UserName)

'VP: Should display username correctly'
WebUI.verifyElementAttributeValue(findTestObject('Login_Page/txt_username'), 'value',UserName,1)

'3. Click Button Login'
WebUI.click(findTestObject('Login_Page/btn_login'))

'VP: Should display "Required" text at password'
WebUI.verifyElementVisible(findTestObject('Login_Page/msg_requiredPassword'))

'4. Clear username'
WebUI.sendKeys(findTestObject('Login_Page/txt_username'), Keys.chord(Keys.CONTROL, 'a'))
WebUI.sendKeys(findTestObject('Login_Page/txt_username'), Keys.chord(Keys.BACK_SPACE))

'5. Input password'
WebUI.setText(findTestObject('Login_Page/txt_password'), Password)

'VP: Should display password correctly'
WebUI.verifyElementAttributeValue(findTestObject('Login_Page/txt_password'), 'value',Password,1)

'6. Click Button Login'
WebUI.click(findTestObject('Login_Page/btn_login'))

'VP: Should display "Required" text at username'
WebUI.verifyElementVisible(findTestObject('Login_Page/msg_requiredUsername'))

'Post-Condtion: Close Browser'
WebUI.closeBrowser()
