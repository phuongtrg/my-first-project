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
def OrangeHRMURL = 'https://www.orangehrm.com/'

'Open browse then open URLs: https://opensource-demo.orangehrmlive.com'
WebUI.openBrowser(URL)
WebUI.maximizeWindow()

'Click  link OrangeHRM, Inc.'
WebUI.click(findTestObject('Login_Page/lnk_OrangeHRM'))

'VP: Should refirect to HRM page:'
'- URL: orangehrm.com'
'- Title contains text: OrangeHRM Software'
WebUI.switchToWindowIndex(1)
assert WebUI.getUrl() == OrangeHRMURL

windowTitle = WebUI.getWindowTitle()
WebUI.verifyEqual(windowTitle.contains('OrangeHRM HR Software'),true)

'Post-Condtion: Close Browser'
//WebUI.closeBrowser()